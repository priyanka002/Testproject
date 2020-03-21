package com.automationpractice.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

	public WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		//this.wait = new WebDriverWait(this.driver, Constants.EXPLICIT_TIMEOUT);
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	protected void click(By locator) {
		
	//	wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
		
	}
    protected void clear(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).clear();
	}
    public void stoprefresh(){
		((JavascriptExecutor)driver).executeScript("window.stop();");
	}
	protected void type(By locator,String textToType) {
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		getElement(locator).sendKeys(textToType);
	}
	
	protected void TypeAndEnter(By locator,String textToType, Keys enter) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		getElement(locator).sendKeys(textToType);
		getElement(locator).sendKeys(enter);
	}
	
	protected void selectByVisibleText(By locator, String visibleText) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(visibleText);
	}

	protected WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected WebDriver driver(){
		return driver;
	}
	
   	 

}
