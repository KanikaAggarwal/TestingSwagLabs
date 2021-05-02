package com.qa.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.saucedemo.base.BasePage;
import com.qa.saucedemo.utils.Constants;
import com.qa.saucedemo.utils.ElementUtil;


public class LoginPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. By Locators: OR
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By checkoutButton = By.id("checkout");
	private By dropDown = By.className("product_sort_container");
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By fleecePrice = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]//parent::div/div");
	private By backpackPrice = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]//parent::div/div");
	private By fleeceCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By backpackCartButton = By.id("add-to-cart-sauce-labs-backpack");
	private By finishButton = By.id("finish");
	// 2. Constructor of the page class:

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. page actions: features(Behavior) of the page in the form methods:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public void doLogin(String un, String pwd) {

		System.out.println("Login with :" + un + " and " + pwd);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();		
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	
	public void getPriceCheckAndAddToCart() {
		String fleece_jacket_price = driver.findElement(fleecePrice).getText();
		System.out.println("the price of the “Sauce Labs Fleece Jacket” is : "+ fleece_jacket_price);
		
		if (fleece_jacket_price.contains(Constants.Sauce_Labs_Fleece_Jacket_Price)) {
			doClick(fleeceCartButton);
		}
		else {
			System.out.println("incorrect price");   		
		}
		
		String labs_backpack_price =driver.findElement(backpackPrice).getText();
				
		System.out.println("Sauce Labs Backpack price is : "+labs_backpack_price);
		
		if (labs_backpack_price.contains(Constants.Sauce_Labs_Backpack_Price)) {
			doClick(backpackCartButton);
		}
		else {
			System.out.println("incorrect price");		
		
		}
		
		
	}
	
	public void doCheckout(String fn, String ln, String pc) {
		
		System.out.println("Login with :" + fn + " and " + ln + " with postal code as :" + pc);
		
		doSendKeys(firstName,fn);
		//driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastName).sendKeys(ln);
		driver.findElement(postalCode).sendKeys(pc);
		doClick(continueButton);
		//driver.findElement(continueButton).click();		
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	
	public String paymentInfo() {
		return  driver.findElement(By.className("summary_value_label")).getText();
		
	}
	
	public String shippingInfo() {
		return driver.findElement(By.xpath("(//*[@class=\"summary_value_label\"])[2]")).getText();
	}
	
	public String totalAmount() {
		return driver.findElement(By.className("summary_total_label")).getText();
	}
	
	public void finish() {
		doClick(finishButton);		
	}
	
	public boolean isHeaderVisible() {
		
		if (driver.findElement(By.className("title")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean invalidUsername() {
		if (driver.findElement(By.xpath("(//*[text()=\"Epic sadface: Sorry, this user has been locked out.\"]")).isDisplayed()) {
			return true;
		}
		return false;
		
	}
	
	// UTILITIES 
	
	public By getLocator(String value) {
		return By.id(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
}}
