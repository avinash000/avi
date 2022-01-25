

package com.crm.qa.testcases;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.TestPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class PageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestPage contactsPage;
	
	String sheetName = "contacts";	
	   
	public PageTest(){
			super();
			
	}
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new TestPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyHomePage() throws InterruptedException{
		Thread.sleep(7000);
		Assert.assertTrue(homePage.verifyHomePage(), "Inventory is not displaying in home page");

	}
	
	@Test(priority=2)
	public void clickOnInventory() throws InterruptedException{
		homePage.clickOnInventory();
		Thread.sleep(5000);
		Assert.assertTrue(homePage.verifyInventoryPage(), "Inventory page is not displaying");

	}
	
	@Test(priority=3)
	public void clickOnProduct() throws InterruptedException{
		Thread.sleep(5000);
		homePage.clickOnProduct();
		Thread.sleep(7000);
		Assert.assertTrue(homePage.verifyProducrPage(), "Product page is not displaying");

	}
	
	@Test(priority=4)
	public void clicktoCreateProduct() throws InterruptedException{
		homePage.createProduct();
		Thread.sleep(7000);
		Assert.assertTrue(homePage.verifyCreateProducrPage(), "Create Product page is not displaying");

	}
	
	/*@Test(priority=5)
	public void createProduct() throws InterruptedException{
		homePage.createProduct1();
		Thread.sleep(8000);
		Assert.assertTrue(homePage.verifyUpdateQuantity(), "Update is not showing up");

	}*/
	
	@Test(priority=5)
	public void productcreate() throws InterruptedException{
		homePage.productcreate(prop.getProperty("prodName"));
		Thread.sleep(8000);
		Assert.assertTrue(homePage.verifyUpdateQuantity(), "Update is not showing up");
	}
	
	@Test(priority=6)
	public void updateQuantity() throws InterruptedException{
		homePage.updateQuantity();
		Thread.sleep(7000);
		homePage.createQuantity();

	}
	
	@Test(priority=7)
	public void enterQuantityDetails() throws InterruptedException{
		Thread.sleep(7000);
		homePage.slecteLoc();	
	}
	
	@Test(priority=8)
	public void goToApplication() throws InterruptedException{
		homePage.selectApplicationIcon();	
		Thread.sleep(6000);
		Assert.assertTrue(homePage.verifyHomePage(), "Inventory is not displaying in home page");
	}
	
	@Test(priority=9)
	public void selectManufacture() throws InterruptedException{
		homePage.selectManufacture();	
		Thread.sleep(5000);
		Assert.assertTrue(homePage.verfiyManufacture(), "Manufactur page is not loaded");
		homePage.createManufacture();
		
	}
	
	@Test(priority=10)
	public void creatManufacture() throws InterruptedException{
		homePage.valueManufctr();	
		
	}
	

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
