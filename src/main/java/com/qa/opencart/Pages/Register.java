package com.qa.opencart.Pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.base.BaseClass;

public class Register extends BaseClass {
	JavascriptExecutor js;

	public Register() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement newsLetter;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicy;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continueButton;
	@FindBy(xpath = "//h1[normalize-space()='Register Account']")
	WebElement heading;

	public AccountHasBeenCreatedPage registerAccount(String FirstName, String LastName, String Email, String Password)
			throws InterruptedException, IOException {
		firstName.sendKeys(FirstName);
		Thread.sleep(1000);
		lastName.sendKeys(LastName);
		Thread.sleep(1000);
		email.sendKeys(Email);
		Thread.sleep(1000);
		password.sendKeys(Password);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		newsLetter.click();
		Thread.sleep(1000);
		privacyPolicy.click();
		Thread.sleep(1000);
		continueButton.click();
		return new AccountHasBeenCreatedPage();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
