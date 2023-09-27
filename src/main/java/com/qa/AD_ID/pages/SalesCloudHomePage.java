package com.qa.AD_ID.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qa.AD_ID.constants.AppConstants;
import com.qa.AD_ID.listeners.ExtentReportListener;
import com.qa.AD_ID.utils.ElementUtil;
import com.qa.AD_ID.utils.JavaScriptUtil;

import io.qameta.allure.Step;

public class SalesCloudHomePage {
	// page changing model

	private ExtentTest test = ExtentReportListener.test.get();
	
	public String un1 = "saicharan.chinthapalli@ap.averydennison.com";
	public String pw1 = "e3G53(yGES";
	
	public String un2 = "venkatesh.orusu@ap.averydennison.com";
	public String pw2 = "pavankalyan800800";
	
	public String un3 = "rajeshwari.selvanambi@ap.averydennison.com";
	//public String pw3 = "KesteHyderabad002@";
	public String pw3 = "ADQA&Argan0@2023";
	
	public String un4 = "ravikumar.vidhani@ap.averydennison.com";
	public String pw4 = "Default*123";
	
		private WebDriver driver;
		private ElementUtil eleutil;
		private JavaScriptUtil JsUtil;
		private By WelcomeHomePage = By.xpath("//a[text()='You have a new home page!']");
		private By hamburger = By.id("pt1:_UISmmLink::icon");
		private By sales = By.xpath("//span[text()=\"Sales\"]");
		private By opportunity = By.xpath("//div[@title='Sales']//../..//a[@title='Opportunities']/span");
		private By existingOpp = By.id("_FOpt1:_FOr1:0:_FONSr2:0:_FOTr0:0:pt1:lstSrch:atlspc:t1:0:cl1");
		
		private By quote = By.xpath("//div[text()='Quotes and Orders']");
		private By createquote = By.xpath("//span[text()='Create Quote']");
		
		private By userName = By.id("input28");
		private By nextBtn = By.xpath("//input[@value='Next']");
		private By frame = By.id("_FOpt1:_FOr1:0:_FONSr2:0:_FOTr0:0:pt1:r1:0:pt1:r8:1:pt1:r3:1:if1");
		
		
		private By passwordSelect = By.xpath("//h3[text()='Password']/../../div/a");
		private By password = By.xpath("//input[@type='password']");
		private By verifyButton = By.xpath("//input[@value='Verify']");
		//private By oktaEmail = By.xpath("//label[contains(text(),'Email')]//..//..//input[@type='text']");
		private By OktaverifyButton = By.xpath("//h3[text()='Get a push notification']/../../div[@class='authenticator-button']/a");
		
		//----------------------- CPQ Transaction page
		
		private By tranPageTitle = By.xpath("//h2[text()='Transaction Header']");
		private By addLineItem = By.xpath("//cpq-table-toolbar//div//span[text()='Add Line Item']");
		
		//--------------------- Home Page
		
		private By labelsandtags = By.xpath("//h3/a[text()='Labels & Tags']");
		
		
		
public SalesCloudHomePage(WebDriver driver)
{
	this.driver = driver;
	eleutil = new ElementUtil(driver);
	JsUtil=new JavaScriptUtil(driver);
}

@Step("Navigating to Quote")
public CPQPage oscQuoteCreation()
{
	eleutil.sleep(5);
	eleutil.waitForElementAndClick(WelcomeHomePage, 20, 2);
	eleutil.doClick(hamburger);
	//eleutil.waitForElementAndClick(sales, 20, 2);
	//eleutil.sleep(10);
	eleutil.waitForElementVisible(sales, AppConstants.MEDIUM_TIME_OUT);
	JsUtil.clickElementByJS(sales);
	eleutil.sleep(5);
	eleutil.waitForElementVisible(opportunity, AppConstants.MEDIUM_TIME_OUT);
	eleutil.waitForElementAndClick(opportunity,40,2);
	//eleutil.sleep(5);
	eleutil.waitForElementAndClick(existingOpp,60,2);
	eleutil.sleep(10);
	eleutil.waitForElementPresence(quote, AppConstants.MEDIUM_TIME_OUT);
	
	JsUtil.scrollIntoView(driver.findElement(quote));
	eleutil.scrollToEle(quote);
	eleutil.waitForElementVisible(quote, AppConstants.MEDIUM_TIME_OUT);
	eleutil.waitForElementAndClick(quote,40,4);
	eleutil.waitForElementAndClick(createquote,40,2);
	
	eleutil.sleep(10);

	test.info("New Quote is created");
	return new CPQPage(driver);


	
}

}
