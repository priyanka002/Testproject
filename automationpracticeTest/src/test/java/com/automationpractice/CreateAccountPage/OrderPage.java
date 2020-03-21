package com.automationpractice.CreateAccountPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationpractice.core.BasePage;

public class OrderPage extends BasePage {

	public OrderPage(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	By tabwomen = By.xpath("//*[@title='Women']");
	By btnewsignin = By.xpath("//*[@title='Log in to your customer account']");
	By tabcategory = By.xpath("//*[@title='T-shirts']");
	By btnoffer = By.xpath("//*[@class='content_price']");

	By btnchkout = By.xpath("//*[@title='Proceed to checkout']");
	By chkbox = By.xpath("//*[@type='checkbox']");
	By btnproceed = By.xpath("//*[@name='processCarrier']");

	By btntshirt = By.linkText("T-shirts");
	By btn2 = By.xpath("//*[@alt='Faded Short Sleeve T-shirts']");
	By btnaddtocart = By.id("add_to_cart");
	By btnchkout2 = By.xpath("//a[@title='Proceed to checkout']"); // ("//*[@title='Proceed
																	// to
																	// checkout']/descendant::span[text()='Proceed
																	// to
																	// checkout']");
	By btnprocess = By.xpath("//*[@name='processAddress']");
	By txttotalprice = By.id("total_price_container");

	By txtpemail = By.id("email");
	By txtppass = By.id("passwd");
	By txtpass = By.id("passwd");
	By btnsignin = By.id("SubmitLogin");

	public void signin(String email, String pass) {

		try {
			click(btnewsignin);
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
			type(txtpemail, email);
			type(txtpass, pass);
			js.executeScript("window.scrollBy(0,100)");
			click(btnsignin);
			stoprefresh();
			String actualtitle = "Sign out";
			String expectedtitle = "Sign out";
			Assert.assertEquals(actualtitle, expectedtitle);
			System.out.println("Assert passed");

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void addproduct() {

		try {
			click(tabwomen);
			driver.findElement(By.linkText("Tops")).click();
			// Thread.sleep(2000);
			click(btntshirt);
			stoprefresh();
			driver.findElement(By.id("layered_id_attribute_group_1")).click();
			js.executeScript("window.scrollBy(0,400)");
			click(btn2);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,200)");
			click(btnaddtocart);
			Thread.sleep(2000);
			click(btnchkout2);
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);

			WebElement e = driver.findElement(By.id("total_price"));
			Thread.sleep(2000);
			String str = e.getText();
			System.out.println("Total cart price is: " + str);
			js.executeScript("window.scrollBy(0,500)");
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@title='Proceed to checkout']/descendant::span[text()='Proceed to checkout']")));
			e1.click();
			System.out.println("clicked");
			js.executeScript("window.scrollBy(0,400)");
			stoprefresh();
			click(btnprocess);
			js.executeScript("window.scrollBy(0,300)");
			click(chkbox);
			click(btnproceed);
			js.executeScript("window.scrollBy(0,200)");
			WebElement e3 = driver.findElement(By.id("total_price_container"));
			String str1 = e3.getText();
			System.out.println("Final cart price is :: " + str1);
			Thread.sleep(5000);
			System.out.println("order complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
