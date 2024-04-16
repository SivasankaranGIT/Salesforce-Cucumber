package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForContactInActiveEditTest {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit contact status details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the Contact tab");
//				selenium.waitingTime(2000);
//				selenium.jsClick("editL");
//				selenium.waitingTime(2000);
//				selenium.click("ContactActiveOption");
//				selenium.clickDynamic("anchorTitle", "Contact Status", "end");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for Contact Status!");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactStatusDropDwn");
				selenium.click("contactStatusDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Contact Status", "end"));
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
				selenium.selectDropdownText("contactStatusC", "Contact Status");
				
	
			}
				selenium.click("save");
				/*
			
			} else {
				selenium.waitingTime(3000);
				selenium.jsClick("edit");
				selenium.scrollToElement("accCurrency");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("accCurrency", "Currency");

		*/ 
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for contact status edit successfully$")
    public void validate_error_message_for_contact_status_edit_successfully() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("errorText_L");
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
			error = selenium.getText("errorText");
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
