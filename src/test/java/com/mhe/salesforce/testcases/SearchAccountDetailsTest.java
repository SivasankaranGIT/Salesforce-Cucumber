package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class SearchAccountDetailsTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^Account record details page should get displayed$")
	public void account_record_details(){
		boolean isSuccess=false;
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
				isSuccess=selenium.isElementPresentFast("detailsTab");

			} else {
				selenium.waitingTime(3000);
				isSuccess=selenium.isElementPresentFast("edit");

			}
			selenium.waitingTime(2000);
			selenium.printLastTestResult(isSuccess);
			selenium.captureScreenShot();
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	
	}
	
	@Then("^MHE salesrep Number should get displayed$")
    public void verifyMhesalesrepnumber() {
		selenium.waitingTime(2000);
		String salesrepnumber = null;
		String expected_Salesrepnumber=null;
		if (selenium.getUI().contains("Lightning")) {
			salesrepnumber = selenium.getText("Salesrepnumberaccount");
			expected_Salesrepnumber = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sales rep number");
		selenium.test.log(LogStatus.INFO, "Sales rep number: " + salesrepnumber);
		if(salesrepnumber.contains(expected_Salesrepnumber)) {
			
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			
		}
		else {
			
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
		}
			else if (selenium.getUI().equalsIgnoreCase("classic")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
			/*error = selenium.getText("errorText");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
		if(error.contains(expected_error)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");*/
		}
		else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
			}
	}	

