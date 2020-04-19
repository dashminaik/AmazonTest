package com.amazon.qa.testcases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.util.TestUtil;

public class HomePageTests extends TestBase{

	public HomePageTests(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void addToCart(){
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		HomePage homepage = new HomePage();
		homepage.txtSearchbox.sendKeys("xbox");
		homepage.txtSearchbox.sendKeys(Keys.ENTER);
		
		//click on the first result
		List<WebElement> items = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']/span"));
			items.get(0).click();				
			
		//switch to new window
		String ParentwindowHandle = driver.getWindowHandle();
		
		Set<String> childHandles = driver.getWindowHandles();
		
		for (String childHandle : childHandles) {
			if(!(childHandle.equalsIgnoreCase(ParentwindowHandle))){
				driver.switchTo().window(childHandle);
				Assert.assertTrue(homepage.btnAddToCart.isDisplayed(),"Could not switch to new tab");
				String text = homepage.btnAddToCart.getText();	
				System.out.println(text);
			}
		}
		//driver.switchTo().defaultContent();
		//click on ad to cart button
		//wait.until(ExpectedConditions.elementToBeClickable(homepage.btnAddToCart));
		homepage.btnAddToCart.click();
		
		//verify that item is added to cart
		Assert.assertTrue(homepage.labelVerificationText.isDisplayed(), "Product not added to cart");
		
		//click on proceed button
		homepage.btnProceedToBuy.click();
		
		//enter username and pwd
		homepage.txtusername.sendKeys("9145497584");
		homepage.btnContinue.click();
		homepage.txtPassword.sendKeys("Dashmi@13");
		homepage.btnLogin.click();
		
		homepage.btnDeliverToAddress.click();
		homepage.btnContinueToPayment.click();
		
		//get the error message
		String errorMessage=homepage.labelErrorMessage.getText();
		System.out.println(errorMessage);
	}
}
