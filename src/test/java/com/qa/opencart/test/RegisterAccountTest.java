package com.qa.opencart.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.AccountHasBeenCreatedPage;
import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.Register;
import com.qa.opencart.base.BaseClass;
import com.qa.opencart.utils.RandomStringUtilsClass;
import com.qa.opencart.utils.RegistrationTestData;

public class RegisterAccountTest extends BaseClass {
	public RegisterAccountTest() throws IOException {
		super();
	}

	static WebDriver driver;

	HomePage hp;
	Register reg;
	AccountHasBeenCreatedPage AccountCreatedPage;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		log.info("Launched Browser");
		hp = new HomePage();
		reg = new Register();
		hp.clickMyAccount();
		log.info("Clicked My Account Button");
		hp.clickRegister();
		log.info("Clicked Register Button");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		String pageTitle = reg.getPageTitle();
		Assert.assertEquals(pageTitle, "Register Account", "Registration page title doesn't match");
	}

	@Test(priority = 3)
	public void accountRegister() throws InterruptedException, IOException {
		AccountCreatedPage = reg.registerAccount(RandomStringUtilsClass.randomAlphabeticString(),
				RandomStringUtilsClass.randomAlphaNumericString(), RandomStringUtilsClass.randomEmailGenerator(),
				RandomStringUtilsClass.randomPasswordGenerator());
		log.info("Entered Details");
	}

	@DataProvider
	public Object[][] testData() throws IOException {
		return RegistrationTestData.data(p.getProperty("SheetName"));
	}

	@Test(priority = 2, dataProvider = "testData")
	public void accountRegisterWithData(String FirstName, String LastName, String Email, String Password)
			throws InterruptedException, IOException {
		AccountCreatedPage = reg.registerAccount(FirstName, LastName, Email, Password);
		log.info("Entered Details");
	}

	@AfterMethod
	public void tearDown() {
		driverQuit();
		log.info("Exit Browser");
	}
}
