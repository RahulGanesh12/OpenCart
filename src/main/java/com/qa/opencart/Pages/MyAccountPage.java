package com.qa.opencart.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.base.BaseClass;

public class MyAccountPage extends BaseClass {
	public MyAccountPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search;
	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement SearchButton;
	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement Logo;

	public String myAccountPageTitle() {
		return driver.getTitle();
	}

	public SearchPage searchContent(String value) throws InterruptedException {
		Search.sendKeys(value);
		Thread.sleep(2000);
		SearchButton.click();
		return new SearchPage();
	}

	public boolean logo() {
		boolean status = Logo.isDisplayed();
		return status;
	}
}
