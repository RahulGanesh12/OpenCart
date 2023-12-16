package com.qa.opencart.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.base.BaseClass;

public class SearchPage extends BaseClass {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public SearchPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='button-list']")
	WebElement ListButton;
	@FindBy(xpath = "//button[@id='button-grid']")
	WebElement GridButton;
	@FindBy(xpath = "//div[@id=\"product-list\"]/descendant::div[@class=\"price\"]//span[@class=\"price-new\"]")
	WebElement Logo;
	@FindBy(xpath = "//div[@id=\"product-list\"]/descendant::div[@class=\"description\"]//h4//a")
	List<WebElement> ProductName;
	@FindBy(xpath = "//div[@class=\"col mb-3\"]/descendant::div[@class=\"button-group\"]//button[contains(@formaction,'compare')]")
	List<WebElement> CompareProductButton;

	public boolean verifyLogo() {
		return Logo.isDisplayed();
	}

	public void verifyGridAndListFunction() {
		if (GridButton.isSelected()) {
			ListButton.click();
		} else {
			GridButton.click();
		}
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public void addProductToCompare(String productName) throws InterruptedException {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		for (int i = 0; i < ProductName.size(); i++) {
			if (ProductName.get(i).getText().equalsIgnoreCase(productName)) {
				CompareProductButton.get(i).click();
				break;
			} else {
				log.warn("No Match in product name or product price");
			}
		}
	}

}
