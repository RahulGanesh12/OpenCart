package com.qa.opencart.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.MyAccountPage;
import com.qa.opencart.Pages.SearchPage;
import com.qa.opencart.base.BaseClass;
import com.qa.opencart.utils.ProductDetail;

public class SearchPageTest extends BaseClass {
	HomePage homepage;
	LoginPage login;
	MyAccountPage myAccountPage;
	SearchPage searchPage;

	public SearchPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		log.info("Launched Browser");
		homepage = new HomePage();
		homepage.clickMyAccount();
		log.info("Clicked My Account");
		homepage.clickLogin();
		log.info("Clicked Login");
		login = new LoginPage();
		login.Login(p.getProperty("Email"), p.getProperty("Password"));
		Thread.sleep(2000);
		log.info("Logged in using email and password");
		myAccountPage = new MyAccountPage();
		myAccountPage.searchContent(p.getProperty("SearchContent"));
		searchPage = new SearchPage();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] ProductTestData() throws FileNotFoundException, IOException {
		return ProductDetail.getProductDetails(p.getProperty("SheetName2"));
	}

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		Assert.assertEquals(searchPage.verifyPageTitle(), "Search - Macbook");
	}

	@Test(priority = 2)
	public void verifyLogoTest() {
		Assert.assertTrue(searchPage.verifyLogo());
	}

	@Test(priority = 3)
	public void ListGridButtonTest() {
		searchPage.verifyGridAndListFunction();
	}

	@Test(priority = 4, dataProvider = "ProductTestData")
	public void addProductToCompareTest(String ProductName) throws InterruptedException {
		searchPage.addProductToCompare(ProductName);
	}

	@AfterMethod
	public void tearDown() {
		driverQuit();
		log.info("Exit Browser");
	}
}
