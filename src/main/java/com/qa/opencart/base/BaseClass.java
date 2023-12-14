package com.qa.opencart.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;

	public BaseClass() throws IOException {
		p = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\OneDrive\\Desktop\\JavaConcepts\\JavaCoding\\OpenCart\\src\\main\\java\\com\\qa\\opencart\\config\\Information.properties");
		p.load(file);
	}

	public void initialization() {
		String url = p.getProperty("BaseURL");
		String browsername = p.getProperty("Browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", "./Drivers/edgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}

	public void driverQuit() {
		driver.quit();
	}
}
