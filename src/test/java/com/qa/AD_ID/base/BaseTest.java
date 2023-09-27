package com.qa.AD_ID.base;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.AD_ID.factory.DriverFactory;
import com.qa.AD_ID.listeners.ExtentReportListener;
import com.qa.AD_ID.pages.LoginPage;
import com.qa.AD_ID.pages.SalesCloudHomePage;
import com.qa.AD_ID.utils.ScreenRecorderUtil;

public class BaseTest {

	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginpage;
	protected SalesCloudHomePage salesCloudHomePage;
	
	protected ExtentReportListener extendLogger;

	protected DriverFactory df;
	protected SoftAssert softAssert;

	@BeforeSuite
	public void startRecord() {
		try {
			ScreenRecorderUtil.startRecord("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void stopRecord() {
		try {
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {

		df = new DriverFactory();
		prop = df.initProp();

		if (browserName != null) {

			prop.setProperty("browser", browserName);

		}
		driver = df.initDriver(prop);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginpage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {

//		driver.quit();
	}

}
