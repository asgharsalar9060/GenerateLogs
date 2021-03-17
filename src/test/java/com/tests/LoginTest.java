package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
	
	//What is log? capturing info/activities at the time of program execution.
	//Type of logs:
	//1. info
	//2. warn
	//3. error
	//4. fatal
	
	//How to generate logs? use Apache log4j API
	//How it works? it reads log 4j configuration from log4j.properties file
	//Where to create log4j.properties? inside the resource folder
	
	
	

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\OneDrive\\\\Documents\\\\Selenium\\\\drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/index.html");
		log.info("entering application url");
	}
	
	@Test
	public void FreeCrmTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is-->"+title);
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");	
	}
	
	@Test
	public void FreeCrmLogoImg() {
		boolean b = driver.findElement(By.xpath("//a[@class='navbar-brand']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
