package com.automation.CreateAccountTest;

import org.testng.annotations.Test;

import com.automationpractice.CreateAccountPage.OrderPage;
import com.automationpractice.core.BaseTest;
import com.aventstack.extentreports.Status;

public class OrderTest extends BaseTest {

	@Test
	public void TC_02(){
		OrderPage p=new OrderPage(driver);
		p.signin("aviy1@test.com", "admin@123");  //autotest01@test.com
		p.addproduct();
		extent.createTest("TC_02");
		logger.log(Status.INFO, "Sign in");
		logger.log(Status.INFO, "Add product");
	}
}
