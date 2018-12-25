package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashBoard;
import com.qa.pages.LoginPage;
import com.qa.utils.excelDataRead;


public class LoginTest extends TestBase
{
	
	LoginPage loginpage;
	DashBoard logindata;
	excelDataRead read;

	public LoginTest() throws IOException  
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		read=new excelDataRead();
		
	}
	
	
	
	@Test
	public void m1()
	{
		System.out.println(1);
	}

	
	
	@Test(priority=1,groups="smoke")
	public void LoginPageTest()
	{
		String loginPagetitle=loginpage.LoginPageTitle();
		System.out.println(loginPagetitle);
		Assert.assertEquals(loginPagetitle, "FrontAccounting 2.4.2 - Login");
		
		
	}
	

	/*@Test(priority=2,groups="smoke")
	public void dialogueHeading()
	{
		String boxheading=loginpage.loginPageDialogueHeadingM();
		System.out.println(boxheading);
		Assert.assertEquals(boxheading,"Sign in to start your session");
	}*/
	

	/*@Test(priority=3,groups="smoke")
	public void loginRegister() throws IOException
	{
		loginpageReg=loginpage.loginPagerRegisterLinkM();		
	}
	*/

	@DataProvider(name="loginData")
	public Object[][] loginDataProvider() throws Exception
	{
		
		Object[][] data = read.getTestData("logindata");
		return data;
		
	}
	
	@Test(priority=2,dataProvider="loginData")
	public void LoginPageDataTest(String username,String password ) throws IOException
	{
					
		loginpage.loginPageData(username, password);
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
