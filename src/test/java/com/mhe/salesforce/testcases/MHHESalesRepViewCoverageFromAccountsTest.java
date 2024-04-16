package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHESalesRepViewCoverageFromAccountsTest {
	
WebConnector selenium = WebConnector.getInstance();
	
	@Then("^verify coverage details$")
	public void verify_coverage_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {

//				selenium.search("Account Name");
//				selenium.waitingTime(2000);
//				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
//				selenium.clickLoopXpath(Xpath);
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwVPOAA2/view");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("accountCoverage");
				selenium.scrollToElement("accountCoverage");
				boolean name=selenium.isElementPresentFast("coverageName");
				System.out.println("Name" + name);
				boolean email=selenium.isElementPresentFast("coverageEmail");
				System.out.println("email" + email);
				boolean phone=selenium.isElementPresentFast("coveragePhoneNumber");
				System.out.println("phone" + phone);
				if((name && phone && email) == true) {
					
					selenium.test.log(LogStatus.INFO, "User is able to view the coverage details");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

}
