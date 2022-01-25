package com.crm.qa.pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@id='result_app_1']")
	WebElement inventoryClick;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement productName;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[contains(text(),'Inventory')]")
	WebElement homePageValidation;
	
	@FindBy(xpath="//li[contains(text(),'Inventory Overview')]")
	WebElement inventoryPageValidation;
	
	@FindBy(xpath="(//a[@class='dropdown-toggle o-no-caret o_menu_header_lvl_1'])[2]")
	WebElement product;
	
	@FindBy(xpath="//a[@data-action-id='204']")
	WebElement product1;
	
	@FindBy(xpath="//li[contains(text(),'Products')]")
	WebElement validateProductPage;
	
	@FindBy(xpath="//button[@class='btn btn-primary o-kanban-button-new']")
	WebElement createProduct;

	@FindBy(xpath="//li[contains(text(),'New')]")
	WebElement verifycreateProduct;
	
	@FindBy(xpath="//button[@class='btn btn-primary o_form_button_save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[@name='action_update_quantity_on_hand']")
	WebElement verifyProductPage;
	
	@FindBy(xpath="//button[@name='action_update_quantity_on_hand']")
	WebElement updateBtn;
	
	@FindBy(xpath="//button[@class='btn btn-primary o_list_button_add']")
	WebElement creatQtyBtn;
	
	@FindBy(xpath="(//input[@class='o_input ui-autocomplete-input'])[1]")
	WebElement selectLoc;
	
	@FindBy(xpath="(//input[@class='o_input ui-autocomplete-input'])[2]")
	WebElement selectPkg;
	
	@FindBy(xpath="//input[@name='inventory_quantity']")
	WebElement quantityEnter;
	
	@FindBy(xpath="//button[@class='btn btn-primary o_list_button_save']")
	WebElement saveQtyBtn;
	
	@FindBy(xpath="//a[@class='fa o_menu_toggle fa-th']")
	WebElement selectApplicationIcon;
	
	@FindBy(xpath="//a[@id='result_app_2']")
	WebElement selectManufactr;
	
	@FindBy(xpath="//a[@class='o_menu_brand']")
	WebElement menuBrand;
	
	@FindBy(xpath="//button[@class='btn btn-primary o_list_button_add']")
	WebElement createmanufacture;
	
	@FindBy(xpath="//a[contains(text(),'Virtual Locations/HN')]")
	WebElement selectLocatioValue;
	
	@FindBy(xpath="(//div[@class='o_input_dropdown'])[1]")
	WebElement selectProdValue;
	
	@FindBy(xpath="//button[@name='action_confirm']")
	WebElement confirmOrder;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyHomePage(){
		return homePageValidation.isDisplayed();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnInventory(){
		inventoryClick.click();
	}

	
	public void clickOnNewContactLink(){
		//Actions action = new Actions(driver);
		//action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

	public boolean verifyInventoryPage() {
		return inventoryPageValidation.isDisplayed();
	}

	public void clickOnProduct() throws InterruptedException {
		product.click();
		Thread.sleep(5000);
		product1.click();
		Thread.sleep(5000);
	}

	public boolean verifyProducrPage() {
		return validateProductPage.isDisplayed();
	}

	public void createProduct() {
		createProduct.click();
	}

	public boolean verifyCreateProducrPage() {
		return verifycreateProduct.isDisplayed();
	}	
	
	public boolean verifyProdPage() {
		return verifyProductPage.isDisplayed();
	}
	
	public void createProduct1() throws InterruptedException{
		//productName.sendKeys(name);
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(uuid);
		Thread.sleep(3000);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", saveBtn);
		    	
		return;
	}
	
	public void productcreate(String prodName){
		productName.sendKeys(prodName);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", saveBtn);
		    	
		return;
	}

	public boolean verifyUpdateQuantity() {
		return updateBtn.isDisplayed();
	}
	
	public void updateQuantity() {
		updateBtn.click();
	}

	public void createQuantity() {
		creatQtyBtn.click();
	}
	
	public void slecteLoc() throws InterruptedException {
		selectLoc.click();
		Thread.sleep(3000);
		//selectLoc.sendKeys("WH/Stock");
		selectLocatioValue.click();
		//Actions act = new Actions(driver);
	    //act.sendKeys(Keys.DOWN).perform();
	    //act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
//		selectPkg.click();
		selectPkg.sendKeys("2000");
		selectPkg.click();
		Thread.sleep(3000);
		//quantityEnter.click();
		quantityEnter.clear();
		quantityEnter.sendKeys("500");
		saveQtyBtn.click();
	}

	public void selectApplicationIcon() {
		selectApplicationIcon.click();
		
	}

	public void selectManufacture() {
		selectManufactr.click();
	}
	
	public boolean verfiyManufacture() {
		return menuBrand.isDisplayed();
	}
	public void createManufacture() {
		createmanufacture.click();
	}
	
	public void valueManufctr() throws InterruptedException {
		selectProdValue.sendKeys((prop.getProperty("prodName")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", saveBtn);
    	Thread.sleep(5000);
    	confirmOrder.click();
	}
	
}
