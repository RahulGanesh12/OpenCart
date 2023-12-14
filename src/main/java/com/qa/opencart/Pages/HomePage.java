package com.qa.opencart.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.base.BaseClass;

public class HomePage extends BaseClass {
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement RegisterDropDownButton;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement LoginDropDownButton;

	public void clickMyAccount() {
		MyAccount.click();
	}

	public void clickRegister() {
		RegisterDropDownButton.click();
	}

	public void clickLogin() {
		LoginDropDownButton.click();
	}
}
