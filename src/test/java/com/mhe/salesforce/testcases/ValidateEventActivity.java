package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateEventActivity {

	WebConnector selenium = WebConnector.getInstance();
	public String eventSUbject = null;

	@When("^I navigate to the contact associated with the event$")
	public void i_navgate_to_the_contacts() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			eventSUbject = selenium.getText("eventHeader");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("eventContact");
			selenium.click("eventContact");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@When("^I navigate to the opportunity associated with the event$")
	public void i_navgate_to_the_opportunityevent() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			eventSUbject = selenium.getText("eventHeader");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("eventopportunity");
			selenium.click("eventopportunity");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	

	@And("^I validate activity on contacts$")
	public void validateActivityEvent() {
		try {
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("showAllLinks"))
			selenium.click("showAllLinks");
		selenium.jsClick("activityHistory");
		String Xpath=selenium.getDynamicAccountXpath("anchorTitle", eventSUbject, "end");
		if(selenium.isElementPresentXpathFast(Xpath)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("^I validate activity on Opportunities$")
	public void validateActivityEventOpportunities() {
		try {
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("showAllLinks"))
			selenium.waitForElementToBeClickable("showAllLinks");
			selenium.click("showAllLinks");
			selenium.waitForElementToBeClickable("openActivityOpportunity");
		selenium.jsClick("openActivityOpportunity");
		String Xpath=selenium.getDynamicAccountXpath("anchorTitle", eventSUbject, "end");
		if(selenium.isElementPresentXpathFast(Xpath)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		
	}