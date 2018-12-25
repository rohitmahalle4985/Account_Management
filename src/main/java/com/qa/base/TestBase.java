package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.TestUtils;
public class TestBase {
	
	public static WebDriver driver;
	public static Properties properti;
	public static WebElement element;
	
	public static Workbook book;
	public static  Sheet sheet;

 
	public TestBase()
		{
			
			properti=new Properties();
			FileInputStream fis;
			try 
			{
			fis = new FileInputStream(("C:/Users/Nishant/eclipe-Oxygen-workspace/AccountManagement/src/main/java/com/qa/config/lconfig.properties"));
			properti.load(fis);
			} 
			catch (FileNotFoundException e) 
			{
			e.printStackTrace();
			}
			catch (IOException e)
			{
			e.printStackTrace();
			}
			}
		
		
		public static void initialization()
		{
			String browsername=properti.getProperty("browser");
			
			if (browsername.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			else if(browsername.equalsIgnoreCase("Chrome"))
			{	
				System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
				driver=new ChromeDriver();
				
				
			}
			
		
			 
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.time_PageLayout,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtils.time_PageLayout, TimeUnit.SECONDS);
			
			driver.get(properti.getProperty("url"));
		}
		


		
		

	
}
