package com.qa.saucedemo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.utils.Constants;

public class TC1LoginPageError extends BaseTest{

	
	
	@BeforeClass
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	//This test should fail so that in a report we can see how the failed test looks like
	@Test
	public void invalidLoginTest() {
			loginPage.doLogin(prop.getProperty("invalidusername"), prop.getProperty("password"));
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url,Constants.HomePageURL);
					
		}
	
	//
	@Test
	public void invalidUsernameTest() {
			loginPage.doLogin(prop.getProperty("invalidusername"), prop.getProperty("password"));
			Assert.assertTrue(loginPage.invalidUsername()); 
		}
	
}
	
