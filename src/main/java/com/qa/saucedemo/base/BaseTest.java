package com.qa.saucedemo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.saucedemo.pages.LoginPage;



public class BaseTest {
	public BasePage basePage;
	public LoginPage loginPage;
	
	
	public Properties prop;
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	 }
	
}

