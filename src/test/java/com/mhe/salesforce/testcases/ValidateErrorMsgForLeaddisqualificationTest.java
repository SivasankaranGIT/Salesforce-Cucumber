package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateErrorMsgForLeaddisqualificationTest {

	WebConnector selenium = WebConnector.getInstance();

	@When("^I Navigate to Lead and update country$")
	public void i_Navigate_to_lead() {
		try {
			if (selenium.getUI().contains("Lightning")) {
//				selenium.navigateToURL(selenium.LeadURl);
//				selenium.test.log(LogStatus.INFO, "Navigate to Lead");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("editBtn");
				selenium.click("editBtn");
				selenium.scrollToElement("country");
				selenium.clearText("Leadcountry");
				selenium.type("Leadcountry", "Lead Country");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				
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

	
	@When("^I create new lead$")
	public void i_create_new_lead() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("Leadstab");
				selenium.jsClick("Leadstab");
				selenium.test.log(LogStatus.INFO, "Click on new button");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				
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
	
	@Then("^I enter all required details on leads detail page$")
	public void I_enter_all_required_details_on_lead_detailpage() {
		selenium.waitingTime(2000);
		selenium.click("Leadsalutation");
		if (selenium.getBrowserName().equalsIgnoreCase("IE"))
			selenium.waitingTime(2000);
		selenium.jsClickXpath(selenium.getDynamicXpath("Leadstatustype", "Salutation", "end"));
		//selenium.clickDynamic("anchorTitle", "Salutation", "end");
		selenium.type("lastName", "Last Name");
		selenium.type("LeadCompnay", "LeadCompnay");
		selenium.scrollToElement("country");
		selenium.type("Leadcountry", "Country");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("LeadSTatusdropdown");
		selenium.scrollToElement("LeadSTatusdropdown");
		selenium.click("LeadSTatusdropdown");
		selenium.waitingTime(2000);
		selenium.jsClickXpath(selenium.getDynamicXpath("Leadstatustype", "Lead Status", "end"));
		selenium.click("save");
		selenium.waitingTime(4000);
//		selenium.urlTitle();
//		System.out.println(selenium.LeadURl);
	}
	
	@Then("^I validate region on lead$")
	public void I_validate_region() {
		selenium.waitingTime(2000);
		String Region = null;
		String expected_Region = null;
		if (selenium.getUI().contains("Lightning")) {
			Region = selenium.getText("Region");
			expected_Region = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Lead Region");
			selenium.test.log(LogStatus.INFO, "Region: " + Region);
			if (Region.contains(expected_Region)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");

			}
		}
		}
		

	@Then("^I validate error message for lead disqualification reason$")
	public void I_validate_error_message_for_lead_disqualification_reason() {
		selenium.waitingTime(2000);
		selenium.click("Leadsalutation");
		if (selenium.getBrowserName().equalsIgnoreCase("IE"))
			selenium.waitingTime(2000);
		selenium.jsClickXpath(selenium.getDynamicXpath("Leadstatustype", "Salutation", "end"));
		//selenium.clickDynamic("anchorTitle", "Salutation", "end");
		selenium.type("lastName", "Last Name");
		selenium.type("LeadCompnay", "LeadCompnay");
		selenium.scrollToElement("country");
		selenium.type("Leadcountry", "Country");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("LeadSTatusdropdown");
		selenium.scrollToElement("LeadSTatusdropdown");
		selenium.waitForElementToBeClickable("LeadSTatusdropdown");
		selenium.click("LeadSTatusdropdown");
		selenium.waitingTime(2000);
		selenium.jsClickXpath(selenium.getDynamicXpath("Leadstatustype", "Lead Status", "end"));
		selenium.waitForElementToBeClickable("save");
		selenium.click("save");
		String error = null;
		String expected_error = null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("Leaddisqualificationreason");
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

	
	
	
}
