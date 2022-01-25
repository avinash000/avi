package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@alt,'Logo')]")
	WebElement logo;
	
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
	
	@FindBy(xpath = "//a[@id='result_app_1']")
	WebElement inventoryClick;

	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateImage(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		login.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
	public boolean verifyHomePage(){
		return homePageValidation.isDisplayed();
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
	
	public void clickOnInventory(){
		inventoryClick.click();
	}

}
