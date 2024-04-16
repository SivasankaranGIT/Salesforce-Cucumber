package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForConnect2TargetUnCheckTest {
WebConnector selenium = WebConnector.getInstance();
	
     @And("^I edit connect2 target details$")
      public void i_edit_connect2_target_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.test.log(LogStatus.INFO, "Uncheck the Connect2 Target !");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("ConnectTarget_L");
				selenium.scrollToElement("ConnectTarget_L");
				selenium.waitingTime(2000);
				selenium.click("ConnectTarget_L");
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("ConnectTarget_C");
				selenium.scrollToElement("ConnectTarget_C");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ConnectTarget_C");
				selenium.click("ConnectTarget_C");
				
	
			}
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
     @Then("^Validate error message for connect2 target edit successfully$")
     public void validate_error_message_for_connect2_target_edit_successfully() {

		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			selenium.scrollToElement("errorConnectTarget_L");
			selenium.waitingTime(2000);
			error = selenium.getText("errorConnectTarget_L");
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
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("errorText");
				selenium.scrollToElement("errorText");
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
