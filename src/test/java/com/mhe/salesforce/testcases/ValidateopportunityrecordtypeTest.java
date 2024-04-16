package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ValidateopportunityrecordtypeTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^I fill in all the mandatory details to create a new opportunity record type$")
	public void i_fill_in_the_following_to_create_a_new_opportunity() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(4000);
//				selenium.click("NewOpportunity");
//				selenium.waitingTime(2000);
//				selenium.click("NewBtn");
//				selenium.waitForElementsToBeVisible("productframeUat");
//				selenium.switchToMultipleFrame("productframeUat");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunitiesLink");
				selenium.click("opportunitiesLink");
//				selenium.waitingTime(2000);
				//selenium.click("NewBtn");
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("opportunityName");
				selenium.click("opportunityName");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");
				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(2000);
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.waitForElementToBeClickable("opportunitiesC");
				selenium.click("opportunitiesC");
			}

			selenium.type("closeDate", "Close Date");
			selenium.type("orderDate", "Order Date");
			selenium.type("mheCourse", "MHE Course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.type("enrollment", "Enrollment");
			selenium.selectDropdownText("routetomarket", "Recordtype");

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}



	
	@And("^I fill in all the mandatory details to create a new subscription opportunity record type$")
	public void i_fill_in_the_following_to_create_a_new_subscription_opportunity() {
		try {

			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(4000);
				//selenium.scrollToElement("opportunities");
				selenium.waitForElementToBeClickable("NewOpportunity");
				selenium.click("NewOpportunity");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.click("NewBtn");
				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Subscriptionopportunity");
				selenium.click("Subscriptionopportunity");
			} else {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunitiesC");
				selenium.scrollToElement("opportunitiesC");
				selenium.click("opportunitiesC");
			}

			selenium.type("closeDate", "Close Date");
			selenium.type("orderDate", "Order Date");
			//selenium.type("mheCourse", "MHE Course");
//			selenium.waitingTime(2000);
			//String xpath = selenium.getDynamicXpath("anyTitle", "MHE Course", "endContains");
			//selenium.clickLoopXpath(xpath);
			//selenium.type("enrollment", "Enrollment");
			selenium.waitForElementToBeVisible("routetomarket");
			selenium.selectDropdownText("routetomarket", "Recordtype");

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^validate opportunity record type$")
    public void validate_opportunity_record_type() {
		if(selenium.isElementPresentFast("mheCourseRequired")) {
			selenium.clearText("mheCourse");
			selenium.type("mheCourse", "MHE Course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
		}
		selenium.waitingTime(2000);
		String recordtype = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			recordtype = selenium.getText("opportunityrecordtype");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ValidateRecordtype");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + recordtype);
		if(recordtype.contains(expected_error)) {
		
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
				recordtype = selenium.getText("errorText");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message Classic: " + recordtype);
		if(recordtype.contains(expected_error))
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		else {
			selenium.reportFailure("Test Case Failed");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	}
}
