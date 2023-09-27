package com.qa.AD_ID.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.AD_ID.base.BaseTest; 

public class LabelsAndTagsConfiguration extends BaseTest {

	@Test
	public void labelsAndTagsConfiguration() {
		 
		 
		 
		
		loginpage.doLoginToCPQ(prop.getProperty("username"), prop.getProperty("password"));
		 
		 
		

		salesCloudHomePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("url2"));

		
		String backgroundColorofSentToEBS=salesCloudHomePage.oscQuoteCreation().addLineItem().modelConfiguration().materialConfiguration().constructionConfiguration()
				.validate().DemandConfiguration();
		
		Assert.assertEquals(backgroundColorofSentToEBS, "rgba(227, 31, 38, 1)");
		
	}
}
