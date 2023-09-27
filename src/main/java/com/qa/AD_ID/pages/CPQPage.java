package com.qa.AD_ID.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.qa.AD_ID.listeners.ExtentReportListener;
import com.qa.AD_ID.utils.ElementUtil;
import com.qa.AD_ID.utils.JavaScriptUtil;

public class CPQPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	private JavaScriptUtil JsUtil;

	private ExtentTest test = ExtentReportListener.test.get();

	public CPQPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		JsUtil = new JavaScriptUtil(driver);

	}

	private By addLineItem = By
			.xpath("//span[text()='Import Line Items']/ancestor::oj-toolbar//span[text()='Add Line Item']/../..");
	private By BarcodeSolutionTab = By.xpath("//a[text()='Barcode Solutions']");
	private By LabelAndTags = By.xpath("//a[text()='Labels & Tags']");
	private By frame = By.xpath("//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTr0:0:pt1:r1:0:pt1:r8:1:pt1:r3:1:if1']");

//	private By Transaction_header=By.xpath("//h2[text()='Transaction Header']");
	String url = "https://erjp-dev3.fa.us2.oraclecloud.com/crmUI/faces/FuseOverview?fnd=%3B%3B%3B%3Bfalse%3B256%3B%3B%3B&fndGlobalItemNodeId=MOO_OPPTYMGMTOPPORTUNITIES_CRM_CARD&_afrLoop=27983543233309742&_afrWindowMode=0&_afrWindowId=3ywlao1xx&_adf.ctrl-state=a7gze0bll_1&_afrFS=16&_afrMT=screen&_afrMFW=1220&_afrMFH=537&_afrMFDW=1220&_afrMFDH=686&_afrMFC=8&_afrMFCI=0&_afrMFM=0&_afrMFR=151&_afrMFG=0&_afrMFS=0&_afrMFO=0";

	public CPQPage addLineItem() {

//		driver.switchTo().frame("_FOpt1:_FOr1:0:_FONSr2:0:_FOTr0:0:pt1:r1:0:pt1:r8:1:pt1:r3:1:if1");
		eleutil.sleep(30);

		WebElement frameElement = driver.findElement(frame);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].contentWindow.focus();", frameElement);

		driver.switchTo().frame(driver.findElement(frame));
		eleutil.sleep(15);

		JsUtil.scrollIntoView(driver.findElement(addLineItem));
		eleutil.sleep(2);
		eleutil.waitForElementAndClick(addLineItem, 10, 2);
		eleutil.waitForElementPresence(BarcodeSolutionTab, 20, 2);
		eleutil.sleep(5);
		JsUtil.clickElementByJS(BarcodeSolutionTab);

		eleutil.waitForElementAndClick(LabelAndTags, 20, 2);
		test.info("Added line Item");
		return this;
	}

	private By configureToggle = By.xpath("//div[@aria-labelledby='configure-label|label']");
	private By MaterialSection = By.xpath("//h3[text()='Material']");
	private By MachineModel = By.xpath("//*[@id=\"machineModelConfigure_BCS_SP_bmClone_1-combobox|input\"]");
	private By MachineModelOption = By.xpath("//div[text()='ADTP1']");

	public CPQPage modelConfiguration() {
		test.info("Configuring the model");
		eleutil.waitForElementAndClick(configureToggle, 20, 2);
		eleutil.waitForElementsVisible(MaterialSection, 20);
		eleutil.waitForElementAndClick(MachineModel, 20, 2);
		eleutil.waitForElementAndClick(MachineModelOption, 20, 2);

		return this;
	}

	private By PaperType = By.xpath("//input[@id=\"paperType_SSPL_Config_BCS_SP-combobox|input\"]");
	private By PaperTypeOption = By.xpath("//div[text()='Paper']");

	private By PrintingMethod = By.xpath("//input[@id=\"printingMethodMenuConfig_BCS_SP_bmClone_2-combobox|input\"]");
	private By PrintingMethodOption = By.xpath("//div[text()='Direct Thermal']");

	private By TopCoating = By.xpath("//input[@id=\"coating_SSPL_BOM_CLONE_2_BCS_SP-combobox|input\"]");
	private By TopCoatingOption = By.xpath("//div[text()='Top Coated']");

	private By AdhesiveType = By.xpath("//input[@id=\"adhesiveType_SSPL_Config_BCS_SP-combobox|input\"]");
	private By AdhesiveTypeOption = By.xpath("//div[text()='Permanent-All Temp']");

	public CPQPage materialConfiguration() {

		test.info("Configuring the material");
		eleutil.waitForElementAndClick(PaperType, 20, 2);
		eleutil.waitForElementAndClick(PaperTypeOption, 20, 2);

		eleutil.waitForElementAndClick(PrintingMethod, 20, 2);
		eleutil.waitForElementAndClick(PrintingMethodOption, 20, 2);

		eleutil.waitForElementAndClick(TopCoating, 20, 2);
		eleutil.waitForElementAndClick(TopCoatingOption, 20, 2);

		eleutil.waitForElementAndClick(AdhesiveType, 20, 2);
		eleutil.waitForElementAndClick(AdhesiveTypeOption, 20, 2);

		return this;

	}

	private By SupplyType = By.xpath("//input[@id=\"supplyType_BCS_SP-combobox|input\"]");
	private By SupplyTypeOption = By.xpath("//div[text()='Die Cut']");

	private By SupplyShape = By.xpath("//input[@id=\"supplyShape_BCS_SP-combobox|input\"]");
	private By SupplyshapeOption = By.xpath("//div[text()='Standard']");

	private By SenseMethod = By.xpath("//*[@id=\"senseMethodSSPL_BCS_SP-combobox|input\"]");
	private By SenseMethodOption = By.xpath("//div[text()='Sensemark']");

	private By Perfbetweeneachlabel = By.xpath("//*[@id=\"perfBetweenEachLabelConfig_BCS_SP_bmClone_1|input\"]");
	private By PerfbetweeneachlabelOption = By.xpath("//span[text()='No']/../..");

	private By Numberwide = By.xpath("//input[@id=\"numberWideconfig_BCS_SP_Label|input\"]");

	private By width = By.xpath("//input[@id=\"widthConfig_BCS_SP_bmClone_1|input\"]");

	private By length = By.xpath("//*[@id=\"lengthConfig_BCS_SP_bmClone_1|input\"]");

	private By validate = By.xpath("//span[text()='Validate']");

	public CPQPage constructionConfiguration() {
		test.info("Configuring the construction");
		eleutil.waitForElementAndClick(SupplyType, 20, 2);
		eleutil.waitForElementAndClick(SupplyTypeOption, 20, 2);

		eleutil.waitForElementAndClick(SupplyShape, 20, 2);
		eleutil.waitForElementAndClick(SupplyshapeOption, 20, 2);

		eleutil.waitForElementAndClick(SenseMethod, 20, 2);
		eleutil.waitForElementAndClick(SenseMethodOption, 20, 2);

		eleutil.waitForElementAndClick(Perfbetweeneachlabel, 20, 2);
		eleutil.waitForElementAndClick(PerfbetweeneachlabelOption, 20, 2);

		eleutil.waitForElementAndEnterValue(Numberwide, 10, 2, "1");

		eleutil.waitForElementAndEnterValue(width, 10, 2, "4");

		eleutil.waitForElementAndEnterValue(length, 10, 2, "6");

		eleutil.waitForElementAndClick(validate, 20, 2);

		return this;

	}

	public CPQPage validate() {
		eleutil.waitForElementAndClick(validate, 20, 2);

		return this;
	}

	private By Quantity = By.xpath("//input[@id='originalQuotedQtyArraySet_BCS_SP_labels|input']");
	private By Quantityfield = By.xpath("//div[text()='Quantity to quote (M)']/ancestor::div[5]/div[2]/div/div[4]");
	private By selectCheckBox = By
			.xpath("//div[text()='Quantity to quote (M)']/ancestor::div[5]/div[2]/div/div[3]/input");
	private By Quantitylabel = By.xpath("//div[text()='Quantity to quote (M)']");

	private By addToTransaction = By.xpath("//span[text()=' Add to Transaction']/..");
	private By modelconfigurationheading = By.xpath("//h3[text()='Model Configuration']");

	private By savebttn = By.xpath("//span[text()='Return to CRM']/ancestor::div[2]/oj-button[2]");
	private By savebttn2 = By.xpath("//span[text()='Save']");
	private By submitforapproval = By.xpath(" //span[text()='Submit for approval']");
	private By setupTaskTab = By.xpath(" //span[text()='Setup Tasks']/..");
	private By ReqSignature = By.xpath(" //span[text()='Request Signature']");
	private By submitPricingAgreement = By.xpath(" //span[text()='Submit Pricing Agreement']");
	private By summary = By.xpath("//h3[text()='Summary']");
	private By secondLineItem = By.xpath("//span[text()='1.1']/../../div[5]/a");

	private By tooling1 = By.xpath("//input[@id='tooling1_l|input']");
	private By Status = By.xpath("//div[text()='Status']");
	private By Status1 = By.xpath(
			"//div[text()='Status']/ancestor::div[@class='cpq-table-element oj-table-element oj-table-horizontal-grid']/div[2]/div/div[7]");
	private By Status2 = By.xpath(
			"//div[text()='Status']/ancestor::div[@class='cpq-table-element oj-table-element oj-table-horizontal-grid']/div[2]/div[2]/div[7]");
	private By complete = By.xpath("//span[text()='Complete']");
	private By Submit_Pricing_Agreement = By.xpath("//span[text()='Submit Pricing Agreement']");

	public String DemandConfiguration() {
		test.info("Configuring the Demand");
		eleutil.sleep(5);
		JsUtil.scrollIntoView(driver.findElement(Quantitylabel));
		eleutil.waitForElementAndClick(Quantityfield, 20, 2);
		eleutil.sleep(3);
		eleutil.doSendKeys(Quantity, "100");
		eleutil.sleep(3);
		eleutil.doClick(selectCheckBox);
		eleutil.sleep(3);
		JsUtil.scrollPageUp();
		eleutil.sleep(3);
		JsUtil.scrollIntoView(driver.findElement(modelconfigurationheading));
		eleutil.sleep(3);
		eleutil.waitForElementAndClick(addToTransaction, 20, 2);
		eleutil.sleep(3);
		eleutil.waitForElementAndClick(addToTransaction, 20, 2);
		eleutil.sleep(3);
		test.info("Added to transaction");
		eleutil.waitForElementAndClick(savebttn, 20, 2);
		eleutil.sleep(3);
		eleutil.waitForElementAndClick(submitforapproval, 20, 2);
		eleutil.sleep(3);
		eleutil.waitForElementAndClick(submitforapproval, 20, 2);

		eleutil.sleep(5);

		JsUtil.scrollIntoView(driver.findElement(ReqSignature));
		eleutil.sleep(3);
		eleutil.waitForElementAndClick(ReqSignature, 20, 2);
		System.out.println("ReqSignature");
		test.info("Requested for signature");
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(submitPricingAgreement, 20, 2);
		eleutil.sleep(15);

		JsUtil.scrollIntoView(driver.findElement(summary));
		eleutil.sleep(5);
		JsUtil.clickElementByJS(secondLineItem);
		eleutil.sleep(5);
		JsUtil.scrollIntoView(driver.findElement(tooling1));
		eleutil.sleep(5);
		driver.findElement(tooling1).clear();
		eleutil.sleep(5);
		JsUtil.scrollIntoView(driver.findElement(savebttn2));
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(savebttn2, 20, 2);
		eleutil.sleep(5);
		JsUtil.clickElementByJS(setupTaskTab);
		eleutil.sleep(5);
		eleutil.scrollToEle(Status);
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(Status1, 20, 2);
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(complete, 20, 2);
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(Status2, 20, 2);
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(complete, 20, 2);
		eleutil.sleep(5);
		eleutil.waitForElementAndClick(Submit_Pricing_Agreement, 20, 2);

		System.out.println("submitPricingAgreement");
		eleutil.sleep(15);
		test.info("Submitted for Pricing Agreement");
		WebElement element = driver.findElement(By.xpath("//li[text()='Sent to EBS']"));

		// Get the background color
		String backgroundColor = element.getCssValue("background-color");

		// Print the background color
		System.out.println("Background color: " + backgroundColor);

		return backgroundColor;

	}

}
