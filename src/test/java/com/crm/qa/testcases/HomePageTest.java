package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.TestPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TestPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new TestPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePage() throws InterruptedException{
		Thread.sleep(10000);
		Assert.assertTrue(homePage.verifyHomePage(), "Inventory is not displaying in home page");

	}
	
	@Test(priority=2)
	public void clickOnInventory() throws InterruptedException{
		homePage.clickOnInventory();
		Thread.sleep(7000);
		Assert.assertTrue(homePage.verifyInventoryPage(), "Inventory page is not displaying");

	}
	
	@Test(priority=3)
	public void clickOnProduct() throws InterruptedException{
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
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
