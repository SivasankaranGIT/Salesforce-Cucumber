package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForAccPriceClassEditTest {

	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account Price class details$")
	public void i_edit_account_Price_class_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
				// selenium.scrollToElement("detailsTab");
				// selenium.scrolldown(400);
				/// selenium.waitingTime(2000);
				// selenium.clickLoop("Select_Case");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.waitingTime(2000);
				// selenium.hoverAndClick("editAccount");
				selenium.scrolldown(600);
				// selenium.scrollToElement("PriceClassL");
				selenium.waitingTime(2000);
				selenium.clearText("PriceClassL");
				selenium.type("PriceClassL", "Price Class");

			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("PriceClassC");
				selenium.clearText("PriceClassC");
				selenium.enterData("PriceClassC", "Price Class");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^Validate error message for account Price class edit successfully$")
	public void validate_error_message_for_Price_class_edit_successfully() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error = null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("ErrorMsg_Acc_Name");
			expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
			selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
			if (error.contains(expected_error)) {
				selenium.click("CancelEdit");
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.click("CancelEdit");
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			error = selenium.getText("errorText");
			expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
			selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
			if (error.contains(expected_error)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		}
	}

	@Then("^Validate error message for account price class with CA or USA$")

	public void errorMessageValidation() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error = null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("MessageText");
			expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
			selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
			if (error.contains(expected_error)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			error = selenium.getText("errorText");
			expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
			selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
			if (error.contains(expected_error)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		}
	}
	
	@And("^I select ecommerce Flag$")
	public void selectEcommercechecbox()
	{   
		selenium.selectCheckbox("eCommerceActivatedFlag(Y/N)", "ValidateErrorMsgForAccPriceclasssCAorUSA");
	}
	
}
