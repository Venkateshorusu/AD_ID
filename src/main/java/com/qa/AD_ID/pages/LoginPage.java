package com.qa.AD_ID.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qa.AD_ID.constants.AppConstants;
import com.qa.AD_ID.listeners.ExtentReportListener;
import com.qa.AD_ID.utils.ElementUtil;

import io.qameta.allure.Step; 

public class LoginPage   {

	// page changing model

	private WebDriver driver;
	private ElementUtil eleutil;
	 
	// cpq creds
	private By cpqlogin = By.xpath("//a[text()='Login']");
	private By login = By.xpath("//a[text()='Login']");
	private By cpquserName = By.id("username");
	private By cpqpassword = By.id("psword");
	private By cpqloginBtn = By.id("log_in");

	// salecloud creds
	private By UserIDLabel = By.xpath("//label[text()='User ID']");
	private By userName = By.id("userid");
	private By password = By.id("password");
	private By loginBtn = By.id("btnActive");
	private By forgotPwdLink = By.linkText("Forgot password?");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	public void doLoginToCPQ(String username, String pwd) {
		eleutil.waitForElementAndClick(login, 20, 2);

		eleutil.waitForElementVisible(cpquserName, AppConstants.LONG_TIME_OUT).sendKeys(username);
		eleutil.waitForElementVisible(cpqpassword, AppConstants.SHORT_TIME_OUT).sendKeys(pwd);
		eleutil.doClick(cpqloginBtn);
		ExtentTest test = ExtentReportListener.test.get();
		test.info("login CPQ (dev) is successful");

	}

	@Step("Login to application username : {0} and password : {1}")
	public SalesCloudHomePage doLogin(String username, String pwd, String url) {

		((JavascriptExecutor) driver).executeScript("window.open();");

		// Switch to the new tab (assuming it's the last tab opened)
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

		driver.get(url);

		System.out.println("Application Credentials: " + username + ":" + pwd);
		eleutil.waitForElementAndClick(UserIDLabel, 20, 2);

		eleutil.waitForElementVisible(userName, AppConstants.LONG_TIME_OUT).sendKeys(username);
		eleutil.waitForElementVisible(password, AppConstants.SHORT_TIME_OUT).sendKeys(pwd);
		eleutil.doClick(loginBtn);
		ExtentTest test = ExtentReportListener.test.get();
		test.info("login Sales (dev3) is successful");
		return new SalesCloudHomePage(driver);

	}

	@Step("....Getting login page title...")
	public String getLoginPageTitle() {

		String title = eleutil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page Title is :" + title);
		return title;
	}

}
