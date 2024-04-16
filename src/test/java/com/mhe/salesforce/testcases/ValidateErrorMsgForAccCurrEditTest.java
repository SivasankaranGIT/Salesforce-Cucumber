package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForAccCurrEditTest {
	
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit account currency details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
				selenium.waitForElementToBeClickable("editButton");
				selenium.click("editButton");
				selenium.test.log(LogStatus.INFO, "selecting the value for Currency!");
				selenium.scrollToElement("currencyDropDwn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("currencyDropDwn");
				selenium.click("currencyDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("newType", "Currency", "end"));
			
			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");
				selenium.scrollToElement("accCurrency");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("accCurrency", "Currency");

			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure(e.getMessage());
		}

	}

	@Then("^Validate error message for account currency edit successfully$")
    public void validate_error_message_for_account_currency_edit_successfully() {
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
		if(error.contains(expected_error)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		}
		else
		{
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	}
}
