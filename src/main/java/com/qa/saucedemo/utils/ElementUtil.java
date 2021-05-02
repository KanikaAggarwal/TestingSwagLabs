package com.qa.saucedemo.utils;


	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.NoSuchElementException;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class ElementUtil {
		private WebDriver driver;

		public ElementUtil(WebDriver driver) {
			this.driver = driver;
		}

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

		public void doActionsSendKeys(By locator, String value) {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).perform();
		}

		public void doActionsClick(By locator) {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).perform();
		}

		public void doSendKeysWithMoveToElement(By locator, String value) {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).sendKeys(value).build().perform();
		}

		public void doClickWithMoveToElement(By locator) {
			Actions action = new Actions(driver);
			action.moveToElement(getElement(locator)).click().build().perform();
		}

		public String doGetText(By locator) {
			return getElement(locator).getText();
		}

		public boolean doIsDisplayed(By locator) {
			return getElement(locator).isDisplayed();
		}

		

		// ***************************Drop Down Utils
		// ***********************************

		public void doSelectDropDownByVisibleText(By locator, String text) {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(text);

		}
	}

		
		

		
