package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;

public class VerifyLeadSourceTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^verify Lead Source$")
	public void verify_Lead_Source() throws InterruptedException {
		try {
//		String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Lead URL");
//		selenium.navigateToURL(url);
			selenium.navigateToURL(selenium.LeadURl);
			System.out.println("Navigated to Lead URL is : " + selenium.LeadURl);
		selenium.waitingTime(6000);
		selenium.test.log(LogStatus.INFO, "Navigated to the desired Lead" );
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("leadSourceLabel");
		selenium.scrollToElement("leadSourceLabel");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("leadSourceGetText");
		String leadSource = selenium.getTextLoop("leadSourceGetText").toString();
		String expected_leadSource = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Lead Source");
		System.out.println("Actual : " + leadSource);
		System.out.println("Expected : " + expected_leadSource);
		if (leadSource.equalsIgnoreCase(expected_leadSource)) {
			selenium.test.log(LogStatus.PASS, "Lead source verified as: " +leadSource);
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "Lead source not updated as expected");
			selenium.reportFailure("Test Case Failed");
			System.out.println("FAIL");
		}

		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
		
		
	}
}
