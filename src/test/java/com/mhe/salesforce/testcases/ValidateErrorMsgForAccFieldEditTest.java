package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForAccFieldEditTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
				selenium.waitingTime(3000);
				selenium.scrolldown(200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("detailsTab");
				selenium.clickLoop("detailsTab");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("editAccount");
				selenium.hoverAndClick("editAccount");
//				selenium.waitingTime(1000);
				//selenium.scrollToElement("phone");
				selenium.waitForElementToBeVisible("parentAccName");
				selenium.scrollToElement("parentAccName");
				//selenium.scrollToElement("territoryName_edit");
				selenium.enterData("territoryName_edit", "Territory Name");

			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("territoryName_editC");
				selenium.enterData("territoryName_editC", "Territory Name");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for account field edit successfully$")
    public void validate_error_message_for_account_field_edit_successfully() {
		try {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("ErrorMsg_Acc_L");
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
			{
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			}
		else 
			{
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	}
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
			}
		

}
