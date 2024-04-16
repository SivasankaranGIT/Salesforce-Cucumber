package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateEvent {

	WebConnector selenium = WebConnector.getInstance();
	private String testCaseName = "CreateAccountTest";

	@When("^I go to Calender screen$")
	public void i_go_to_account_address_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.type("searchItemsTextField", "calendar");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Calendartab");
			selenium.click("Calendartab");
			selenium.waitingTime(2000);
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I click on the new calendar tab and enter required information$")
	public void I_click_on_the_accounts_tab() {
		try {
		selenium.waitForElementToBeClickable("newcalendarbutton");
		selenium.click("newcalendarbutton");
		selenium.waitingTime(2000);
		selenium.type("Calendarsubject", "Subject");
		selenium.waitForElementToBeClickable("eventselectOpportunity");
		selenium.click("eventselectOpportunity");
		selenium.clickDynamic("anchorTitle","event related","eventRelatedto");
		selenium.waitForElementToBeClickable("Eventopportunities");
		selenium.click("Eventopportunities");
//		selenium.waitForElementToBeClickable("FirstEVentOpportunity");
//		selenium.click("FirstEVentOpportunity"); //index
		selenium.type("Search_contact", "Contact Name");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Searchcontactsevents");
		selenium.click("Searchcontactsevents");
		String xpath=selenium.getDynamicXpath("anchortitleEvent", "Contact Name", "dynamiceventcontact");
//		selenium.waitForXpathElementToBeClickable(xpath);
		selenium.waitingTime(4000);
		selenium.clickXpath(xpath);
		
		//selenium.clickDynamic("anchortitleEvent", "Contact Name", "dynamiceventcontact");
		selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	
	@Then("^event should get created$")
	public void accountNumber() {
		try {
		//selenium.waitingTime(4000);
		if(selenium.isElementPresentFast("contactSuccessfulL"))
		{
			selenium.waitForElementToBeClickable("eventtitle");
			selenium.click("eventtitle");
			selenium.waitingTime(2000);
//			selenium.EventTitle();
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
