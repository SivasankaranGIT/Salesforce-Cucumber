package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyAllUSAutoResponseRules {

	
	WebConnector selenium = WebConnector.getInstance();
	
	
	@Then("^I Quick search for the Case Auto Response Rules$")
    public void i_quick_search_for_the_case_autoresponse_rules() {
		try {
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("quickFind");
		selenium.click("quickFind");
		selenium.waitingTime(2000);
		selenium.type("quickFind", "Search");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("caseAutoResponseRulesSearch");
		selenium.click("caseAutoResponseRulesSearch");
		
		
		
	}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while quick search  " + e.getMessage());
		}
		
}
	
	 @When("^I Click on email to case auto response rules link$")
	    public void i_click_on_email_to_case_auto_response_rules_link() {
		 try {
			 
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseAutoResponseRulesLink");
			 selenium.click("caseAutoResponseRulesLink");
			 
			 
			 
		 }
		 catch (Exception e) {
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while clicking on rules link  " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^I verify auto response rules are available for US UAT$")
	    public void i_verify_auto_response_rules_are_available_for_us_uat() {
		 try  {
			 
			 selenium.waitingTime(2000);
			 selenium.refresh();
			 selenium.waitingTime(5000);
			 selenium.isElementPresentFast("ruleDetail");
			 selenium.isElementPresentFast("ruleEntries");
			 selenium.isElementPresentFast("ruleTable");
			 selenium.captureScreenShot();
			 selenium.switchOutOfFrame();
			 
			 
		 }
		 
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while verifying rules   " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	    
	    
}
