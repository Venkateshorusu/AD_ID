package com.qa.AD_ID.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.AD_ID.base.BaseTest;
import com.qa.AD_ID.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - 1414 : Design of the login page for the open cart application")
@Story("US - 14 : Implementation of login page feature for the open cart application")
public class LoginPageTest extends BaseTest {
	@Description("Check user is able to login to the application with correct user name and correct password")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void loginTest() {

		loginpage.doLoginToCPQ(prop.getProperty("username"), prop.getProperty("password"));

		salesCloudHomePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("url2"));
	}

}
