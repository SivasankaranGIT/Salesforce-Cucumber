package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHESSalesRepViewCustomLinksTest {
	
WebConnector selenium = WebConnector.getInstance();
	
	@Then("^Verify Custom Links for MHES Sales Rep$")
	public void I_Verify_Custom_Links_MHES() {
		try {
		selenium.test.log(LogStatus.INFO, "Verifying Custom Links");
		selenium.waitingTime(3000);
		selenium.search("Account Name");
		selenium.waitingTime(4000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
//		selenium.waitForXpathElementToBeClickable(Xpath);
		selenium.waitingTime(4000);	
		selenium.clickLoopXpath(Xpath);
		selenium.waitingTime(6000);	
		
		boolean customLinkSection = selenium.isElementPresentFast("customLinkHeader");
		if(customLinkSection==true) {
			
			selenium.scrollToElement("customLinkHeader");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("historicalSalesLink");
			selenium.jsClick("historicalSalesLink");
			selenium.waitingTime(4000);
			selenium.verifyCustomLinks();
			selenium.switchOutOfFrame();
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Custom Link Section not available for this account");
			selenium.reportFailure("Custom Link Section not available for this account");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
