package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
	
	public static WebDriver driver;
	static Properties prop;

	public TestBase(){
		PageFactory.initElements(driver, this);
		
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/rsoni/Desktop/Dashmi/amazonTest/src/main/java/com/amazon/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void initialization(){
		
		String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rsoni\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\rsoni\\Desktop\\Selenium\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();				
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
		}
}
