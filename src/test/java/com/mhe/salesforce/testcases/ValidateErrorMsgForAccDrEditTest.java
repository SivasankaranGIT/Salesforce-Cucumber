package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForAccDrEditTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account Dr details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
				selenium.scrolldown(200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("detailsTab");
				selenium.clickLoop("detailsTab");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("Select_Case");
				selenium.clickLoop("Select_Case");
				selenium.waitForElementToBeClickable("editL");
				selenium.click("editL");
				selenium.test.log(LogStatus.INFO, "selecting the value for Currency!");
				//selenium.scrollToElement("TopAccount");
				selenium.scrolldown(200);
				selenium.waitingTime(2000);
				selenium.scrollToElement("salesRep");
				selenium.type("Dr_L", "Number of Dr");
				selenium.waitingTime(2000);
				//selenium.scrollToElement("Nurse_L");
				//selenium.type("Nurse_L", "Number of Dr");

			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("Dr_c");
				selenium.type("Dr_c", "Number of Dr");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("Nurse_C");
				selenium.scrollToElement("Nurse_C");
				selenium.type("Nurse_C", "Number of Dr");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for account Dr edit successfully$")
    public void validate_error_message_for_account_dr_edit_successfully() {
		try {
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
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
			}

}
