package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForAccDLEIDEditTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account DLE institution ID details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
//				selenium.scrolldown(100);
//				selenium.waitingTime(2000);
//				selenium.clickLoop("detailsTab");
//				selenium.waitingTime(2000);
//				selenium.clickLoop("Select_Case");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for Currency!");
				//selenium.scrollToElement("TopAccount");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("DLE_ID");
				selenium.scrollToElement("DLE_ID");
				selenium.waitingTime(2000);
				selenium.type("DLE_ID", "DLE ID");
			
			} else {
				selenium.waitingTime(3000);
//				selenium.jsClick("edit");
				selenium.waitForElementToBeVisible("DLE_ID_C");
				selenium.scrollToElement("DLE_ID_C");
				selenium.enterData("DLE_ID_C", "DLE ID");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for account DLE institution ID edit successfully$")
    public void validate_error_message_for_account_dle_institution_id_edit_successfully() {
		try {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("errorWeChatId_L");
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
		if(error.contains(expected_error)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		}
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
