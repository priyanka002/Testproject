package com.automationpractice.CreateAccountPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.automationpractice.core.BasePage;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	By btnsignin = By.id("SubmitLogin");
	By txtemail = By.xpath("//*[@id='email_create']");
	By btncreateaccount = By.id("SubmitCreate");
	By rdb1 = By.xpath("//*[@name='id_gender' and @id='id_gender1']");
	By txtfirstname = By.id("customer_firstname");
	By txtlastname = By.id("customer_lastname");
	By txtpass = By.id("passwd");
	By drpdays = By.id("uniform-days");
	By drpmonths = By.id("uniform-months");
	By drpyears = By.id("uniform-years");
	By txtpfirstname = By.id("firstname");
	By txtplastname = By.id("lastname");
	By txtcompany = By.id("company");
	By txtpaddr1 = By.id("address1");
	By txtpaddr2 = By.id("address2");
	By txtcity = By.id("city");
	By drpstate = By.id("uniform-id_state");
	By txtpostal = By.id("postcode");
	By drpcountry = By.id("id_country");
	By txtinfo = By.id("other");
	By txtphone = By.id("phone");
	By txtmobile = By.id("phone_mobile");
	By txtalais = By.id("alias");
	By btnsubmit = By.id("submitAccount");

	By txtpemail = By.id("email");
	By txtppass = By.id("passwd");
	By btnewsignin = By.xpath("//*[@title='Log in to your customer account']");

	public void fillprofiledetails(String email, String fn, String ln, String password, String pfn, String pln,
			String company, String addr1, String addr2, String city, String postal, String info, String phone,
			String mobile, String alais) {

		try {
			click(btnewsignin);
			js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
			type(txtemail, email);
			click(btncreateaccount);
			Thread.sleep(5000);
			click(rdb1);
			type(txtfirstname, fn);
			type(txtlastname, ln);
			type(txtpass, password);
			js.executeScript("window.scrollBy(0,200)");

			WebElement selectMyElement = driver.findElement(By.id("uniform-days"));
			selectMyElement.click();
			action();

			WebElement selectMyElement1 = driver.findElement(By.id("uniform-months"));
			selectMyElement1.click();
			action();

			WebElement selectMyElement2 = driver.findElement(By.id("uniform-years"));
			selectMyElement2.click();
			action();

			type(txtpfirstname, pfn);
			type(txtplastname, pln);
			type(txtcompany, company);
			js.executeScript("window.scrollBy(0,200)");
			type(txtpaddr1, addr1);
			type(txtpaddr2, addr2);
			type(txtcity, city);
			js.executeScript("window.scrollBy(0,200)");

			WebElement mystate = driver.findElement(By.id("uniform-id_state"));
			mystate.click();
			action();

			type(txtpostal, postal);

			WebElement mycountry = driver.findElement(By.id("id_country"));
			mycountry.click();
			action();

			type(txtinfo, info);
			type(txtphone, phone);
			js.executeScript("window.scrollBy(0,200)");
			type(txtmobile, mobile);
			type(txtalais, alais);
			click(btnsubmit);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void action() {

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
	}

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
}
