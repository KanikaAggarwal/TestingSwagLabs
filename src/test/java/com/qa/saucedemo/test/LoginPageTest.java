package com.qa.saucedemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.saucedemo.base.BaseTest;
import com.qa.saucedemo.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
		@BeforeTest
		public void verifyLoginPageTitleTest() {
			String title = loginPage.getLoginPageTitle();
			System.out.println("login page title is : " + title);
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
		
		
		@BeforeClass
		public void loginTest() {
			loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url,Constants.HomePageURL);
					
		}
		
		
		@Test(priority = 3)
		public void testCase2_Part1() {
					
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByVisibleText("Price (high to low)");
		
		
		}
		@Test(priority = 4)
		public void addToCartTest() {
			//ndexOutOfBoundsException
		loginPage.getPriceCheckAndAddToCart();
		loginPage.doClick(By.className("shopping_cart_link"));	
		
		
		//Assert.assertEquals(fleece_jacket_price, Constants.Sauce_Labs_Fleece_Jacket_Price);

		}
		
		@Test(priority = 5)	
		public void testCase2_Part3() {
		
		Boolean isPresent1 = driver.findElements(By.xpath(".//*[text()[contains(.,\"Sauce Labs Fleece Jacket\")]]")).size() > 0;
		Assert.assertTrue(isPresent1);
		
		Boolean isPresent2 = driver.findElements(By.xpath(".//*[text()[contains(.,\"Sauce Labs Backpack\")]]")).size() > 0;
		Assert.assertTrue(isPresent2);
		
		loginPage.doClick(By.id("checkout"));

		}

		@Test(priority = 6)	
		public void doCheckoutTest() {
			
			loginPage.doCheckout(prop.getProperty("firstname"), prop.getProperty("lastname"),prop.getProperty("postalcode"));
			String checkouturl = driver.getCurrentUrl();
			Assert.assertEquals(checkouturl,Constants.Checkout_Page_URL);
			
		}
		
		@Test(priority = 7)	
		public void paymentInfoTest() {
			
			String payinfo = loginPage.paymentInfo();
			System.out.println("Payment Information is : " + payinfo );
			Assert.assertEquals(payinfo, Constants.Payment_Information, "It doesnot matches");
		}
	
		
		@Test(priority = 8)	
		public void shippingInfoTest(){
			String shipinfo = loginPage.shippingInfo();
			System.out.println("Shipping Information is : " + shipinfo );
			Assert.assertEquals(shipinfo, Constants.Shipping_Information, "It doesnot matches");

		}
		
		@Test(priority = 9)	
		public void totalAmountTest(){
			String total = loginPage.totalAmount();
			System.out.println("Total Amount is : " + total );
			//Assert.assertEquals(total, contains(Constants.Total, "It doesnot matches");
			Assert.assertTrue(total.contains(Constants.Total));
		}
		
		@Test(priority = 10)	
		public void finishTest(){
			loginPage.finish();
			String finishUrl = driver.getCurrentUrl();
			System.out.println("The Url is :" + finishUrl);
			Assert.assertEquals(finishUrl, Constants.Finish_Url, "It doesnot matches");
		Assert.assertTrue(loginPage.isHeaderVisible()); 
		
		


		}
		
	
}