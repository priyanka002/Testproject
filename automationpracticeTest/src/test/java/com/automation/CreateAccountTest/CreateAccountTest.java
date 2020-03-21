package com.automation.CreateAccountTest;

import org.testng.annotations.Test;

import com.automationpractice.CreateAccountPage.CreateAccountPage;
import com.automationpractice.core.BaseTest;
import com.aventstack.extentreports.Status;

public class CreateAccountTest extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void test1() {
		CreateAccountPage p = new CreateAccountPage(driver);
		p.fillprofiledetails("autotest01@test.com", "test", "raj", "admin@123", "Avinash", "Harkulkar", "BSM", "Mumbai",
				"kalyan", "kalyan east", "00000", "hi other info", "0207876565", "9098787656", "avi");
		extent.createTest("TC_01");
		logger.log(Status.INFO, "Account creation");
	}

}
