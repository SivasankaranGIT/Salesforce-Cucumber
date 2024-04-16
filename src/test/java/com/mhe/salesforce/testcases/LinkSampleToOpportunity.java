package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LinkSampleToOpportunity {
	WebConnector selenium = WebConnector.getInstance();
	
	 @And("^I select sample from recently view sample list$")
	    public void I_select_sample_from_search() {
		try {
			selenium.navigateToURL(selenium.SampleTestingURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SamplesLink");
			selenium.click("SamplesLink");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("FirstSampleInOpp");
			selenium.jsClick("FirstSampleInOpp");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking Sample " + e.getMessage());
		}

	}
	
	 @And("^select sample from search$")
	    public void select_sample_from_search() {
		try {
			selenium.navigateToURL(selenium.NewOppURLForSamplesTest);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SamplesLink");
			selenium.jsClick("SamplesLink");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("lastTaskRecord");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastTaskRecord");
			selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("lastTaskRecordLinkNew");
			selenium.jsClick("lastTaskRecordLinkNew");
			selenium.waitingTime(5000);
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking Sample " + e.getMessage());
		}
	}
	 
	 @Then("^link opportunity to sample$")
	 public void link_opportunity_to_sample(){
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editOpportunityToLink");
			selenium.jsClick("editOpportunityToLink");
			selenium.waitingTime(5000);
			boolean oppField = selenium.isElementPresentFast("searchOpportunities");
			boolean opp = selenium.isElementPresentFast("clearSelectionForOpportunity");
			System.out.println("opportunity field blank" + oppField + opp);
			
			if(oppField==false & opp==true) {
				System.out.println("clear selection");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("clearSelectionForOpportunity");
				selenium.jsClick("clearSelectionForOpportunity");
				selenium.waitingTime(4000);				
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("searchOpportunities");
			selenium.jsClick("searchOpportunities");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdoWithOneDown("searchOpportunities", "Opportunity Name");
			selenium.waitingTime(6000);
			if(selenium.isElementPresentFast("FirstOppInSearchOppPopup")){
				selenium.jsClick("FirstOppInSearchOppPopup");
				selenium.waitingTime(4000);
			}
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(9000);			
		}
		catch (Exception e) {
			selenium.reportFailure("Error while linking opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			if(selenium.isElementPresentFast("CancelButton"))
			{
			selenium.click("CancelButton");
			}
		}

	}
	 
	 @Then("^verify opportunity linked to sample$")
	    public void verify_opportunity_linked_to_sample()  {
			try {
			
			selenium.waitForElementToBeVisible("editOpportunityToLink");
			String name = selenium.getText("linkedOpportunityName").toString();
			//String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Name");
			System.out.println("opp name linked" +name );
			if (!name.isEmpty()) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "sample Linked to Opportunity successfully");

			} else {
				System.out.println("inside sfail");
				selenium.test.log(LogStatus.FAIL, "Sample link to opportunity failed");
				selenium.reportFailure("Test Case Failed");

			}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying details" + e.getMessage());
				
				}

		}
}

