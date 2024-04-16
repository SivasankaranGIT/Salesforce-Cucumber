package com.mhe.salesforce.testcases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class NewEventLinkedToLead {

	WebConnector selenium = WebConnector.getInstance();
	
	Map<String, String> currentRuntimeGlobalVariables = new HashMap<String, String>();
	
	@Then("^NewEventLinkedToLead - Navigate to digital training Calendar$")
    public void navigate_to_digital_training_screen() throws Exception {
		try {
//		selenium.waiting(3);
		selenium.waitForElementToBeClickable("allButtonLightning");
        selenium.click("allButtonLightning");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonL");
        selenium.click("AllButtonL");
        selenium.waitingTime(4000);
        selenium.type("searchallitems", "Screen Name");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("Calendar");
        selenium.click("Calendar");
    //    selenium.clickLoop("digitalTrainingTabSearch");
        selenium.waitingTime(10000);
        selenium.test.log(LogStatus.INFO, "Digital training screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
        
    }
	
	@Then("^NewEventLinkedToLead - I select new calendar event and validate page title$")
	public void i_click_on_new_calendar_event() throws Exception {
		try {
			if(selenium.isElementPresentFast("newCalendarEvent"))
			{
				selenium.waitForElementToBeClickable("newCalendarEvent");
				selenium.click("newCalendarEvent");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("newCalendarEvent");
				selenium.click("newCalendarEvent");
			}
		selenium.waiting(6);
		String expectedTitle = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("NewCalendarEventPageTitle");
		String actualTitle = selenium.getDriver().getTitle();
		selenium.verifyTextEquals(expectedTitle, actualTitle);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I validate MHE event is selected as record type by default and page title$")
	public void i_validate_MHE_event_isSelected() throws Exception {
		try {
		selenium.checkElementIsSelected("mheEventInput");
		selenium.waitForElementToBeClickable("next");
		selenium.click("next");
		selenium.waitForElementToBeVisible("assignedToLabel");
		selenium.waiting(5);
		String expectedTitle = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("NewCalendarEventPageTitle2");
		String actualTitle = selenium.getDriver().getTitle();
		selenium.verifyTextEquals(expectedTitle, actualTitle);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I validate correct name is displayed in assigned to field$")
	public void i_validate_correct_name_is_displayed() throws Exception {
		try {
		selenium.waitForElementToBeClickable("assignedToLabel");
		String sysAdminName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SysAdminName");
		String assignedToNameFieldXpath = selenium.getPropertiesObj().getProperty("assignedToNameField1").
				replace("<placeholder>", sysAdminName);
		System.out.println("sysAdminName: " + sysAdminName + " assignedToNameField: " + assignedToNameFieldXpath);
		selenium.checkObjectWithXpathExists(assignedToNameFieldXpath, "Assigned to name field with correct name => " + sysAdminName);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I enter subject of meeting$")
	public void i_enter_subject_of_meeting() throws Exception {
		String subjectStr = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Subject") + selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
		selenium.typeData("subjectInput", subjectStr);
		this.currentRuntimeGlobalVariables.put("subjectOfCalendarEvent", subjectStr);
		selenium.waiting(2);
	}
	
	@Then("^NewEventLinkedToLead - I select opportunities from related to field$")
	public void i_select_opportunities_from_related_to() throws Exception {
		try {
		selenium.waitForElementToBeClickable("relatedTo");
		selenium.click("relatedTo");
//		selenium.waiting(3);
		selenium.waitForElementToBeClickable("opportunities");
		selenium.click("opportunities");
		selenium.type("searchOpportunity", "OpportunityName");
		selenium.waitForElementToBeClickable("opportunityName");
		selenium.click("opportunityName");
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I select Leads and enter lead name$")
	public void i_select_leads_and_enter_lead_name() throws Exception {
		try {
//		selenium.waiting(1);
		selenium.waitForElementToBeClickable("calendarEventNameSelection");
		selenium.click("calendarEventNameSelection");
//		selenium.waiting(1.5);
		selenium.waitForElementToBeClickable("leadsOptionInNameSelection");
		selenium.click("leadsOptionInNameSelection");
//		selenium.waiting(2);
		selenium.waitForElementToBeVisible("searchLeads");
		selenium.type("searchLeads", "LeadName");
		selenium.waiting(2.5);
		String leadName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("LeadName");
		String leadNameFieldXpath = selenium.getPropertiesObj().getProperty("contactsName_cal").
				replace("<placeholder>", leadName);
		selenium.clickXpath(leadNameFieldXpath);
		selenium.waiting(2.5);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I select all day calendar event$")
	public void i_select_all_day_calendar_event() throws Exception {
		try {
		selenium.waitForElementToBeClickable("allDayCalendarEventInput");
		selenium.click("allDayCalendarEventInput");
		selenium.waiting(2.5);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I enter start date in calendar event$")
	public void i_enter_current_start_date() throws Exception {
		try {
		String startDate = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
		String startDateArr[] = startDate.split("-");
		startDate = startDateArr[1] + " " + Integer.parseInt(startDateArr[0]) + ", " + startDateArr[2];
		selenium.typeData("startDateCalendarEventInput", startDate);
		selenium.waiting(3);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I select action$")
	public void i_select_action_from_dropdown() throws Exception {
		try {
		selenium.waitForElementToBeClickable("actionDropDown");
		selenium.click("actionDropDown");
		selenium.waiting(1.5);
		String actionValue = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ActionValue");
		String actionValueElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", actionValue);
		selenium.waiting(2);
		selenium.clickXpath(actionValueElementXpath);
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I enter description in description field$")
	public void i_enter_description_in_description_field() throws Exception {
		try {
		selenium.type("SimpleTextBox", "Text");
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I click save button to save calendar meeting$")
	public void i_click_save_button() throws Exception {
		try {
		selenium.waitForElementToBeClickable("save");
		selenium.click("save");
		selenium.waiting(6);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I verify calendar event is available in calendar section$")
	public void i_verify_event_in_calendar_section() throws Exception {
		try {
		//fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");	 
		String calendarEventElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", calendarEventSubject);
		selenium.checkObjectWithXpathExists(calendarEventElementXpath, "Calendar event with subject: " + calendarEventSubject);
		selenium.waiting(3);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I select calendar event$")
	public void i_click_on_calendar_event() throws Exception {
		try {
		//fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
		String calendarEventElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", calendarEventSubject);
		selenium.waitingTime(2000);
		selenium.clickXpath(calendarEventElementXpath);
		selenium.waiting(4);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I click on name field in event$")
	public void i_click_leadname_in_event() throws Exception {
		try {
		selenium.waiting(2);
		String leadName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("LeadName");
		String leadNameInCalendarElementXpath = selenium.getPropertiesObj().getProperty("nameInEventDetailPage").
				replace("<placeholder>", leadName);
		//selenium.clickXpath(leadNameInCalendarElementXpath);
		selenium.waitForElementToBeClickable("leadNameInCalender");
		selenium.click("leadNameInCalender");
		selenium.waiting(4);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToLead - I click activities tab and verify calendar event$")
	public void i_click_activities_tab_and_verify_calendar_event() throws Exception {
		try {
		selenium.waitForElementToBeClickable("activityTab");
	   selenium.click("activityTab");
	   selenium.waiting(4);
	   String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
	   String calendarEventElementXpath = selenium.getPropertiesObj().getProperty("newcalendarEventInActivity_cal").
	         replace("$val", calendarEventSubject);
	   selenium.checkObjectWithXpathExists(calendarEventElementXpath, "Calendar event with subject " + calendarEventSubject + " in Lead's Activity section");
	   selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	
}
