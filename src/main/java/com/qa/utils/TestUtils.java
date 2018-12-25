package com.qa.utils;

import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;


public class TestUtils extends TestBase
{
	WebDriver driver;
	 public static int time_PageLayout=20;
		public static int time_implicit=10; 
		
		
		public void switchToAlert()
		{
			driver.switchTo().alert().accept();
		}
}
