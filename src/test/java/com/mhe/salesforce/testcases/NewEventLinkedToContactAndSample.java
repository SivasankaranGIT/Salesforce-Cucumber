package com.mhe.salesforce.testcases;

import java.time.Duration;
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

public class NewEventLinkedToContactAndSample {

WebConnector selenium = WebConnector.getInstance();
	
	Map<String, String> currentRuntimeGlobalVariables = new HashMap<String, String>();
	
	@Then("^NewEventLinkedToContactAndSample - Navigate to digital training Calendar$")
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
	
	@Then("^NewEventLinkedToContactAndSample - I select new calendar event and validate page title$")
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
	
	@Then("^NewEventLinkedToContactAndSample - I validate MHE event is selected as record type by default and page title$")
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
	
	@Then("^NewEventLinkedToContactAndSample - I validate correct name is displayed in assigned to field$")
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
	
	@Then("^NewEventLinkedToContactAndSample - I enter subject of meeting$")
	public void i_enter_subject_of_meeting() throws Exception {
		String subjectStr = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Subject") + selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
		selenium.typeData("subjectInput", subjectStr);
		this.currentRuntimeGlobalVariables.put("subjectOfCalendarEvent", subjectStr);
		selenium.waiting(2);
	}
	
	
	
	@Then("^NewEventLinkedToContactAndSample - I select sample from related to field$")
	public void i_select_samples_from_related_to_field() throws Exception {
		try {
		selenium.waitForElementToBeClickable("relatedTo");
		selenium.click("relatedTo");
//		selenium.waiting(3);
		selenium.waitForElementToBeClickable("samples");
		selenium.click("samples");
//		selenium.waiting(1.5);
		selenium.waitForElementToBeVisible("searchSamples");
		selenium.type("searchSamples", "SampleName");
		selenium.waitingTime(2000);
		//String sampleName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SampleName");
		selenium.pressEnter("searchSamples");
		selenium.clickDynamic("anchorTitle","SampleName", "end");
		/*
		 * String sampleNameElementXpath =
		 * selenium.getPropertiesObj().getProperty("sampleName").
		 * replace("<placeholder>", sampleName);
		 */
		selenium.waiting(2);
		/* selenium.clickXpath(sampleNameElementXpath); */
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToContactAndSample - I verify contacts and enter contact name$")
	public void i_verify_contacts_and_enter_contact_name() throws Exception {
		try {
		selenium.waiting(1);
		selenium.checkObjectExists("contacts", "Contacts");
		selenium.type("Search_contact", "ContactName");
		selenium.waiting(2.5);
		String contactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ContactName");
		String contactNameFieldXpath = selenium.getPropertiesObj().getProperty("contactsName").
				replace("<placeholder>", contactName);
		selenium.clickXpath(contactNameFieldXpath);
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToContactAndSample - I select all day calendar event$")
	public void i_select_all_day_calendar_event() throws Exception {
		selenium.waitForElementToBeClickable("allDayCalendarEventInput");
		selenium.click("allDayCalendarEventInput");
		selenium.waiting(2.5);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I enter start date in calendar event$")
	public void i_enter_current_start_date() throws Exception {
		String startDate = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
		String startDateArr[] = startDate.split("-");
		startDate = startDateArr[1] + " " + Integer.parseInt(startDateArr[0]) + ", " + startDateArr[2];
		selenium.typeData("startDateCalendarEventInput", startDate);
		selenium.waiting(3);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I select action$")
	public void i_select_action_from_dropdown() throws Exception {
		try {
		selenium.waitForElementToBeClickable("actionDropDown");
		selenium.click("actionDropDown");
		selenium.waiting(1.5);
		String actionValue = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ActionValue");
		String actionValueElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", actionValue);
		selenium.waiting(4);
		selenium.clickXpath(actionValueElementXpath);
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^NewEventLinkedToContactAndSample - I enter description in description field$")
	public void i_enter_description_in_description_field() throws Exception {
		selenium.type("SimpleTextBox", "Text");
		selenium.waiting(2);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I click save button to save calendar meeting$")
	public void i_click_save_button() throws Exception {
		selenium.waitForElementToBeClickable("save");
		selenium.click("save");
		selenium.waiting(6);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I verify calendar event is available in calendar section$")
	public void i_verify_event_in_calendar_section() throws Exception {
		//fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");	 
		String calendarEventElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", calendarEventSubject);
		selenium.checkObjectWithXpathExists(calendarEventElementXpath, "Calendar event with subject: " + calendarEventSubject);
		selenium.waiting(3);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I select calendar event$")
	public void i_click_on_calendar_event() throws Exception {
		//fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
		String calendarEventElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", calendarEventSubject);
		selenium.clickXpath(calendarEventElementXpath);
		selenium.waiting(4);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I click on name field in event$")
	public void i_click_leadname_in_event() throws Exception {
		selenium.waiting(2);
		String contactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ContactName");
		String contactNameInCalendarElementXpath = selenium.getPropertiesObj().getProperty("nameInEventDetailPage").
				replace("<placeholder>", contactName);
		selenium.clickXpath(contactNameInCalendarElementXpath);
		selenium.waiting(4);
	}
	
	@Then("^NewEventLinkedToContactAndSample - I verify event in contacts open activites$")
	public void i_click_name_and_verify_event_in_contacts() throws Exception {
		try {
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
		String contactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ContactName");
//		selenium.waiting(5);
		selenium.waitForElementToBeClickable("openActivitiesInContacts");
		selenium.click("openActivitiesInContacts");
//		selenium.waiting(7);
		selenium.waitForElementToBeClickable("viewAllInOpenActivitiesInContacts");
		selenium.clickLoop("viewAllInOpenActivitiesInContacts");
	//	selenium.click("viewAllInOpenActivitiesInContacts");
	//	selenium.clickLoop("openActivitiesInContactsPage");
		String calendareventElementXpath = selenium.getPropertiesObj().getProperty("eventInOpenActivities").
				replace("<placeholder>", calendarEventSubject);
		selenium.waiting(6);
		
		//The below part is written for checking if calendar event exists in contacts page or not
		List<WebElement> eventList = selenium.getDriver().findElements(By.xpath("//a[@title='" + calendarEventSubject + "']"));
		boolean isDisplayed = false;
		System.out.println("Size of eventList: " + eventList.size());
		for(WebElement element: eventList) {
			try {
				(new WebDriverWait(selenium.getDriver(), Duration.ofSeconds(4))).until(ExpectedConditions.elementToBeClickable(element));
				if(element.isDisplayed()) {
					isDisplayed = true;
					break;
				}
			} catch(Exception e) {
				continue;
			}
			
		}
		if(isDisplayed) {
			selenium.test.log(LogStatus.PASS, "Calendar meeting open activity with subject: " + calendarEventSubject + " in contacts");
			System.out.println("Calendar meeting open activity with subject: " + calendarEventSubject + " in contacts");
		} else {
			selenium.test.log(LogStatus.FAIL, "Calendar meeting open activity with subject: " + calendarEventSubject + " in contacts "
					+ "is expected to be displayed but not displayed");
			System.out.println("Calendar meeting open activity with subject: " + calendarEventSubject + " in contacts "
					+ "is expected to be displayed but not displayed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
}
