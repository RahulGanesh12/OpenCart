package com.qa.opencart.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.MyAccountPage;
import com.qa.opencart.base.BaseClass;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	MyAccountPage map;
	Logger log = LogManager.getLogger(LoginPageTest.class);

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		log.info("Launched Browser");
		hp = new HomePage();
		lp = new LoginPage();
		hp.clickMyAccount();
		log.info("Clicked My Account Button");
		hp.clickLogin();
		log.info("Clicked Login");
	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(lp.verfiyLoginPageTitle(), "Account Login");
	}

	@Test(priority = 2)
	public void verifyLogin() throws InterruptedException, IOException {
		String Email = p.getProperty("Email");
		String Password = p.getProperty("Password");
		map = lp.Login(Email, Password);
		log.info("Entered Email and Password");
	}

	@AfterMethod
	public void tearDown() {
		driverQuit();
		log.info("Exit Browser");
	}

}
