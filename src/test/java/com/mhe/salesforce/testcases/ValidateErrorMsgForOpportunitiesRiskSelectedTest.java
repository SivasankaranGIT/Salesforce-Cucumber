package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForOpportunitiesRiskSelectedTest {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit Risk selected details$")
	public void i_edit_Risk_selected_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("AtriskL");
				selenium.click("AtriskL");
				
				/*String type = selenium.getText("opportunityTypeDropDwn");
				if(type.equalsIgnoreCase("New")) {
					selenium.click("AtriskL");
				}
				else {
					selenium.click("opportunityTypeDropDwn");
					selenium.waitingTime(2000);
					selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Opportunity type", "end"));
					selenium.click("save");
					selenium.waitingTime(5000);
					selenium.click("editButton");
					selenium.waitingTime(2000);
				}
				*/
			}
			
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
				selenium.waitForElementToBeClickable("AtriskC");
				selenium.click("AtriskC");
	
			}
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for Risk selected Type edit successfully$")
    public void validate_error_message_for_Risk_selected_type_edit_successfully() {
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
			error = selenium.getText("errorSales");
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
