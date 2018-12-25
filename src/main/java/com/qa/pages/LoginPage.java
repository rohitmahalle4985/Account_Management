package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	

		//initializing the page objects or webelements
		public LoginPage() throws IOException 
		{
			
			PageFactory.initElements(driver,this);
		}
		
		//Page Factory / Object repository
		@FindBy(xpath=".//input[contains(@type,'text')]")
		protected WebElement uname;
		
		@FindBy(xpath=".//input[contains(@type,'password')]")
		protected WebElement pass;
		
		@FindBy(xpath=".//input[contains(@type,'submit')]")
		protected WebElement login;
		
		
		
	/*	@FindBy(xpath="//*[contains(@href,'pages/examples/dashboard.html')])")
		protected WebElement loginPageHead;
		
		@FindBy(xpath="//p[contains(@class,'login-box-msg')]")
		protected WebElement loginPageDialogueHead;

		@FindBy(xpath="//*[contains(@class,'text-center')]")
		protected WebElement loginPageRegisterlink;
*/
		
		//Actions
		public String LoginPageTitle()
		{
			return driver.getTitle();
			 
		}
		
		/*public String loginPageDialogueHeadingM()
		{
			
			return loginPageDialogueHead.getText();
		}*/
		
		
		public DashBoard loginPageData(String Tuname,String Tpass ) throws IOException
		{
			uname.sendKeys(Tuname);
			pass.sendKeys(Tpass);
			login.click();
			
			return new DashBoard();
			
		}

}
