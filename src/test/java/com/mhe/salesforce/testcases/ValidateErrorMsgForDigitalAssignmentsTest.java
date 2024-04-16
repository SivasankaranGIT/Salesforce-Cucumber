package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForDigitalAssignmentsTest {
WebConnector selenium = WebConnector.getInstance();
	
     @And("^I edit Digital Assignments details$")
       public void i_edit_digital_assignments_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for Digital Assignment Type!");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("digitalAssignment_L");
				selenium.scrollToElement("digitalAssignment_L");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("digitalAssignment_L");
				selenium.clickLoop("digitalAssignment_L");
				String selectAssignment = selenium.getDynamicXpath("anchorText", "Digital Assignments", "end");
				selenium.clickXpath(selectAssignment);
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
				selenium.selectDropdownText("digitalAssignment_C", "Digital Assignments");
	
			}
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
     @Then("^Validate error message for Digital Assignments edit successfully$")
     public void validate_error_message_for_digital_assignments_edit_successfully() {

		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("errorText_L");
			selenium.scrollToElement("errorText_L");
			selenium.waitingTime(2000);
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
