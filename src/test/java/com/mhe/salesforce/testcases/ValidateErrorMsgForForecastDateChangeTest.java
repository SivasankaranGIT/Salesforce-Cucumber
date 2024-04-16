package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForForecastDateChangeTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^I edit Forecast Order date details$")
    public void i_edit_forecast_order_date_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Editing opportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editL");
				selenium.jsClick("editL");
				selenium.test.log(LogStatus.INFO, "updating the value for Order Date less then Close Date!");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("closeDate");
				String OrderDate = selenium.forecastOrderDate("closeDate");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("orderDate");
				selenium.typeData("orderDate", OrderDate);
				selenium.waitingTime(2000);
				
			} else if (selenium.getUI().equalsIgnoreCase("classic")) {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("edit");
				selenium.click("edit");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("closeDate_C");
				String OrderDate = selenium.forecastOrderDate("closeDate_C");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("orderDate_C");
				selenium.typeData("orderDate_C", OrderDate);
				selenium.waitingTime(2000);
			}
			
			

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while updating Date " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
		
		

	
	@Then("^Validate error message for Forecast Order date edit successfully$")
    public void validate_error_message_for_forecast_order_date_edit_successfully() {
		
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			selenium.scrollToElement("orderDate");
			selenium.waitingTime(2000);
			error = selenium.getText("errorForecastDate_L");
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
