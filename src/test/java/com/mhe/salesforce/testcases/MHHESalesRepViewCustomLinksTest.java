package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHESalesRepViewCustomLinksTest {
	
WebConnector selenium = WebConnector.getInstance();
//	public String AccountForCustomLink="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwVEHAA2/view";
	
	@Then("^Verify Custom Links$")
	public void I_Verify_Custom_Links() {
		try {
		selenium.test.log(LogStatus.INFO, "Open account and Verifying Custom Links");
/*		selenium.searchGlobal("Account Name");
		selenium.waitingTime(4000);
		String Xpath = selenium.getDynamicXpath("anchorTitle", "Account Name", "end");
		selenium.clickLoopXpath(Xpath);*/
//		selenium.waitingTime(2000);
		
//		selenium.navigateToURL(AccountForCustomLink);
//		selenium.waitingTime(8000);
		selenium.waitForElementToBeVisible("customLinkHeader");
		boolean customLinkSection = selenium.isElementPresentFast("customLinkHeader");
		if(customLinkSection==true) {
			
			selenium.scrollToElement("customLinkHeader");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("activeOffersLink");
			selenium.jsClick("activeOffersLink");
			selenium.waitingTime(4000);
			selenium.verifyCustomLinks();
			selenium.switchOutOfFrame();
		}
		else
			selenium.test.log(LogStatus.FAIL, "Custom Link Section not available for this account");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}

}
