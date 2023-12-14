package com.qa.opencart.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement LoginEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement LoginPassword;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginButton;

	public String verfiyLoginPageTitle() {
		return driver.getTitle();
	}

	public MyAccountPage Login(String Email, String Password) throws InterruptedException, IOException {
		LoginEmail.sendKeys(Email);
		Thread.sleep(2000);
		LoginPassword.sendKeys(Password);
		Thread.sleep(2000);
		LoginButton.click();
		return new MyAccountPage();
	}

}
