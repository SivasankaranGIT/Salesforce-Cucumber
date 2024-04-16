package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateErrorMsgForUSDBillingUnCheckTest {
WebConnector selenium = WebConnector.getInstance();
	
@When("^I navigate Opportunity validation screen$")
public void i_navigate_Opportunity_validation_screen() {
	if (selenium.getUI().equalsIgnoreCase("lightning")) {
//		selenium.type("searchTextL", "opportunity name");
//		selenium.waitingTime(2000);
//		selenium.pressEnter("searchTextL");
//		selenium.waitingTime(2000);
//		selenium.clickDynamic("anchorTitlecontains", "opportunity name", "endContains");
		
		selenium.searchForOpp();
		String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "opportunity name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
	}
}

    @And("^I edit USD Bill field details$")
       public void i_edit_usd_bill_field_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.test.log(LogStatus.INFO, "Uncheck the USD Bill !");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("billingUSD");
				selenium.click("billingUSD");
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("USDChechbox_C");
				selenium.click("USDChechbox_C");
				
	
			}
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
    @Then("^Validate error message for USD Bill field edit successfully$")
    public void validate_error_message_for_usd_bill_field_edit_successfully() {

		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("ErrorMsg_Dr_L");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
		if(error.contains(expected_error)) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			
		}
		else {
			selenium.click("CancelEdit");
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
		}
			else if (selenium.getUI().equalsIgnoreCase("classic")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
			error = selenium.getText("ErrorMsg_Acc_C");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
		if(error.contains(expected_error))
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		else {
			selenium.reportFailure("Test Case Failed");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
		
		
	}


}
