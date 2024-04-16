package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForUSDBillingTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^I edit USD Bill details$")
    public void i_edit_usd_bill_details() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editL");
				selenium.clickLoop("editL");
				selenium.test.log(LogStatus.INFO, "selecting the value for Marketing Source Type!");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("billingUSD");
				selenium.scrollToElement("billingUSD");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("billingUSD");
				selenium.clickLoop("billingUSD");
				//String selectSource = selenium.getDynamicXpath("anchorText", "Marketing Sourced Type", "end");
				//selenium.clickXpath(selectSource);
				
			}
			else if(selenium.getUI().equalsIgnoreCase("classic")){
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
				selenium.selectDropdownText("marketingSourced_C", "Marketing Sourced Type");
	
			}
		}
				catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@Then("^Validate error message for USD Bill edit successfully$")
    public void validate_error_message_for_usd_bill_edit_successfully() {

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
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("ErrorMsg_Acc_C");
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
