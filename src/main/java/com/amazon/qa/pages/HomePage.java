package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@data-index=1]/div/span/div/div/div/div/div/div/span/a")
	public WebElement firstItem;
	
	//@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[2]")
	//public WebElement firstItem;
	
	//@FindBy(xpath="//span[contains(text(),'Xbox One: New Age of Gaming')]")
	//public WebElement labelFirstItem;
	
	@FindBy(xpath="//button[contains(text(),'Add to eBook cart')]")
	public WebElement btnAddToECart;
	
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]/preceding-sibling::input")
	public WebElement btnAddToCart;
	
	@FindBy(xpath="//h1[contains(text(),'Added to Cart')]")
	public WebElement labelVerificationText;
	
	@FindBy(xpath="//h1[contains(text(),'Added to Cart')]/../../../../../../following-sibling::div[@id='huc-v2-order-row-buttons']/div/div/div/span/span/a")
	public WebElement btnProceedToBuy;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtusername;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement btnContinue;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement btnLogin;
	
	@FindBy(xpath="//b[contains(text(),'Dashmi Naik')]/../../../../following-sibling::div/span/a")
	public WebElement btnDeliverToAddress;
	
	@FindBy(xpath="//input[@name='continue-bottom']")
	public WebElement btnContinueToPayment;
	
	@FindBy(xpath="//div[@class='a-last']")
	public WebElement labelErrorMessage;
	
	
	
}
