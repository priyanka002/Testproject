package com.automationpractice.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {

	//protected String browserName = Constants.CHROME_DRIVER_PATH;
	public static ExtentTest logger;
	public static ExtentReports extent;
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver(); 
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        
	}
	
	@AfterClass
	public void getreport(){

		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Report/AutomationpracticeTest.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.flush();
	}
	
	@AfterMethod
	public void teardown(){
		
		driver.close();
	}
}