package com.mhe.salesforce.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import java.time.Duration;

public class EventLinkedToContactAndOpportunity {

	WebConnector selenium = WebConnector.getInstance();
	String subjectStr;
	Map<String, String> currentRuntimeGlobalVariables = new HashMap<String, String>();
	

	@Then("^EventLinkedToContactAndOpportunity - Navigate to digital training Calendar$")
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
	
	@Then("^I select new calendar event and validate page title$")
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
	
	@Then("^I validate MHE event is selected as record type by default and page title$")
	public void i_validate_MHE_event_isSelected() throws Exception {
		try {
		selenium.waitForElementToBeClickable("next");
		selenium.checkElementIsSelected("mheEventInput");
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
	
	@Then("^I validate correct name is displayed in assigned to field$")
	public void i_validate_correct_name_is_displayed() throws Exception {
		try {
		selenium.waitForElementToBeVisible("assignedToNameField");
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
	
	@Then("^I enter subject of meeting$")
	public void i_enter_subject_of_meeting() throws Exception {
		try {
		subjectStr = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Subject") + selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
		selenium.typeData("subjectInput", subjectStr);
		this.currentRuntimeGlobalVariables.put("subjectOfCalendarEvent", subjectStr);
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I select opportunities from related to field$")
	public void i_select_opportunities_from_related_to() throws Exception {
		try {
				selenium.waitForElementToBeClickable("relatedTo");
			    selenium.click("relatedTo");
				selenium.waitForElementToBeVisible("NodeManager");
				selenium.scrollToElement("NodeManager");
				selenium.click("opportunities_calender");
				selenium.waitForElementToBeVisible("searchOpportunity");

				if(selenium.getTestCaseName().equalsIgnoreCase("AddEventToNewlyCreatedOpp"))
				{
					System.out.println("opportunity_expected is:" + selenium.opportunity_expected);
					selenium.typeData("searchOpportunity", selenium.opportunity_expected);
				    selenium.waiting(2);
				    selenium.pressEnter("searchOpportunity");
				    selenium.waitingTime(2000);
				    String oppxpath = selenium.getDynamicXpathData("anyTitle", selenium.opportunity_expected , "endContains");
				    selenium.waitingTime(2000);
				    System.out.println("oppxpath is :" + oppxpath);
				    selenium.clickLoopXpath(oppxpath);
				}
				else
				{
					selenium.type("searchOpportunity", "OpportunityName");
				    selenium.waiting(2);
				    selenium.pressEnter("searchOpportunity");
				    selenium.waitingTime(2000);
			    	System.out.println("opportunity_expected is null");
				    selenium.clickDynamicXpath("anyTitle", "OpportunityName", "endContains");
				}
			    selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	
	@Then("^I verify contacts and enter contact name$")
	public void i_verify_contacts_and_enter_contact_name() throws Exception {
		try {
//		selenium.waiting(1);
		selenium.waitForElementToBeVisible("contacts");
		selenium.checkObjectExists("contacts", "Contacts");
		selenium.type("Search_contact", "ContactName");
		selenium.waiting(2.5);
		String contactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ContactName");
		String contactNameFieldXpath = selenium.getPropertiesObj().getProperty("contactsName").
				replace("<placeholder>", contactName);
		System.out.println("contactNameFieldXpath is :" + contactNameFieldXpath);
		selenium.clickXpath(contactNameFieldXpath);
		selenium.waiting(2);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I select all day calendar event$")
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
	
	@Then("^EventLinkedToContactAndOpportunity - I enter start date in calendar event$")
	public void i_enter_current_start_date() throws Exception {
		try {
		String startDate = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
		String startDateArr[] = startDate.split("-");
		startDate = startDateArr[1] + " " + Integer.parseInt(startDateArr[0]) + ", " + startDateArr[2];
		selenium.typeData("startDateCalendarEventInput", startDate);
		selenium.waiting(3);
		}
//		catch (Exception e)
//		{
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			selenium.reportFailure("Error occurred " + e.getMessage());
//		}
		catch (org.openqa.selenium.StaleElementReferenceException ex)
		{
			String startDate = selenium.getCurrentDateTimeString("dd-MMM-yyyy");
			String startDateArr[] = startDate.split("-");
			startDate = startDateArr[1] + " " + Integer.parseInt(startDateArr[0]) + ", " + startDateArr[2];
			selenium.typeData("startDateCalendarEventInput", startDate);
			selenium.waiting(3);
		}
	}
	
	@Then("^I select action$")
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
	
	@Then("^I enter description in description field$")
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
	
	@Then("^I click save button to save calendar meeting$")
	public void i_click_save_button() throws Exception {
		try {
		selenium.click("save");
		selenium.waiting(6);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("I verify calendar event is available in calendar section")
	public void i_verify_event_in_calendar_section() throws Exception {
		try {
		//fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");	 
		String calendareventElementXpath = selenium.getPropertiesObj().getProperty("actionValue").
				replace("<placeholder>", calendarEventSubject);
		selenium.checkObjectWithXpathExists(calendareventElementXpath, "Calendar event with subject: " + calendarEventSubject);
		selenium.waiting(3);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I select calendar event$")
	public void i_click_on_calendar_event() throws Exception {
		try {
	   //fetching the calendar event subject which was stored in currentRuntimeGlobalVariables hashmap for ease of access
	   String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
	   String calendareventElementXpath = selenium.getPropertiesObj().getProperty("calendarEvent_cal").
	         replace("<placeholder>", calendarEventSubject);
	   selenium.jsClickXpath(calendareventElementXpath);
	   selenium.waiting(4);
		selenium.eventURL=selenium.getURL();
		System.out.println("Current URL:" + selenium.getURL());
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	
	@Then("^I click on related opportunity$")
	public void i_click_related_opportunity() throws Exception {
		try {
//	   selenium.waiting(4);
		selenium.waitForElementToBeVisible("OpportunityName");
	   String text = selenium.getValueByColumnName("OpportunityName");
//	   String relatedOpportunityInCalendarEvent = selenium.getPropertiesObj().getProperty("relatedOpportunityInCalendarEvent_cal").replace("$var", text);
	   selenium.waitForElementToBeClickable("relatedTo_cal");
	   selenium.click("relatedTo_cal");
	   //selenium.clickXpath(relatedOpportunityInCalendarEvent);
	   selenium.waiting(4);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}


	@Then("^I click on open activities and verify calendar event$")
	public void i_click_openActivities_and_verify_event() throws Exception {
		try {

		selenium.waitingTime(8000);
		selenium.scrolldown(500);
		selenium.waitForElementToBeClickable("openActivitiesTab");
		selenium.jsClick("openActivitiesTab");
		selenium.waitingTime(4000);
		selenium.scrolldown(500);
		selenium.waitForElementToBeVisible("viewAllInOpenActivitiesInOpportunities");
		selenium.scrollToElement("viewAllInOpenActivitiesInOpportunities");
		selenium.click("viewAllInOpenActivitiesInOpportunities");
		selenium.waitingTime(5000);
		selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
		selenium.waitingTime(5000);
		String calendarEventSubject = subjectStr;
		System.out.println("calendarEventSubject :" + calendarEventSubject);
		String calendareventElementXpath = selenium.getPropertiesObj().getProperty("eventInOpenActivities").
				replace("<placeholder>", calendarEventSubject);
		System.out.println("calendareventElementXpath :" + calendareventElementXpath);
		selenium.checkObjectWithXpathExists(calendareventElementXpath, "Calendar meeting open activity with subject: " + calendarEventSubject + " in opportunities");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I click on name field and verify event in contacts open activites$")
	public void i_click_name_and_verify_event_in_contacts() throws Exception {
		String calendarEventSubject = currentRuntimeGlobalVariables.get("subjectOfCalendarEvent");
		String contactName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ContactName");
		String contactInOpenActivitesXpath = selenium.getPropertiesObj().getProperty("contactNameInEventOpenActivities").
				replace("<placeholder1>", calendarEventSubject).replace("<placeholder2>", contactName);
		selenium.waiting(3);
		selenium.clickXpath(contactInOpenActivitesXpath);
		selenium.waitForElementToBeClickable("openActivitiesInContacts");
		selenium.click("openActivitiesInContacts");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("viewAllInOpenActivitiesInContacts");
		selenium.clickLoop("viewAllInOpenActivitiesInContacts");
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
	@Then("I create a new account for MHES lightning console")
	public void i_create_a_new_account_for_mhes_lightning_console(){
		try{
			selenium.randomString=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field",selenium.randomString+"_AccountName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassDropDown");
			selenium.jsClick("AccountClassDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassOption");
			selenium.jsClick("AccountClassOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeDropDown");
			selenium.jsClick("AccountTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeOptionNew");
			selenium.jsClick("AccountTypeOptionNew");
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOperatingHours"))
			{
				selenium.waitForElementToBeClickable("TimeZoneDropDown");
				selenium.jsClick("TimeZoneDropDown");
				selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("TimeZoneOption");
				selenium.jsClick("TimeZoneOption");
			}
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the year")
	public void i_verify_the_year(){
		try{
			selenium.waitForElementToBeClickable("OppLinkfromAccounts");
			selenium.jsClick("OppLinkfromAccounts");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("MergeOpptyBtn");
			selenium.jsClick("MergeOpptyBtn");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			Select dropdown = new Select(selenium.getElement("SelectYearInAccount"));
			dropdown.selectByIndex(1);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the First Time Instructor field")
	public void i_verify_the_first_time_instructor_field(){
		try{
			selenium.waitForElementToBeClickable("OpptyContactsNewLink");
			selenium.jsClick("OpptyContactsNewLink");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("FirstTimeInstructorField");
			if(selenium.isElementPresentFast("FirstTimeInstructorField"))
			{
				System.out.println("PASS!!! Field is present");
				selenium.test.log(LogStatus.PASS,"Field is present");
			}
			else
			{
				System.out.println("FAIL!!! Field is not present");
				selenium.test.log(LogStatus.FAIL,"Field is not present");
				selenium.reportFailure("Field is not present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I clone the opportunity and verify the Is Teaching field")
	public void i_clone_the_opp_and_verify_the_is_teaching_field(){
		try{
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");
			selenium.jsClick("ClickOnCloneBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("clickYear");
			selenium.hoverAndClick("clickYear");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectYear");
			selenium.click("selectYear");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ClickTerm");
			selenium.click("ClickTerm");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ValueofTerm");
			selenium.click("ValueofTerm");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clickSaveBtn");
			selenium.jsClick("clickSaveBtn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("ClickOnContinue"))
			{
				selenium.waitForElementToBeClickable("ClickOnContinue");
				selenium.jsClick("ClickOnContinue");
			}
			selenium.waitingTime(25000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
	//		selenium.click("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("IsTeachingGetText");
			String isTeaching=selenium.getText("IsTeachingGetText").toString();
			System.out.println(isTeaching);
			if(isTeaching.equalsIgnoreCase(selenium.task))
			{
				System.out.println("PASS!!! Value are same after cloning");
				selenium.test.log(LogStatus.PASS,"Value are same after cloning");
			}
				else
			{
				System.out.println("FAIL!!! Value are not same after cloning");
				selenium.test.log(LogStatus.FAIL,"Value are not same after cloning");
				selenium.reportFailure("Value are not same after cloning");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I get the Is Teaching field value")
	public void i_get_the_is_teaching_field_value(){
		try{
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("IsTeachingGetText");
			selenium.task=selenium.getText("IsTeachingGetText").toString();
			System.out.println(selenium.task);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the Lead field in opportunity and add it")
	public void i_verify_the_lead_field_in_opp_and_add_it(){
		try{
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.jsClick("taggedProductISBNSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsFirstCheckBox");
			selenium.jsClick("ObjectsFirstCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsSecondCheckBox");
			selenium.jsClick("ObjectsSecondCheckBox");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("LeadCheckBox");
			Assert.assertTrue(selenium.isElementPresentFast("LeadCheckBox"));
			selenium.waitingTime(2000);
			selenium.jsClick("LeadCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(20000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppContactLeadEditIcon");
			selenium.jsClick("OppContactLeadEditIcon");
			selenium.waitingTime(5000);
			if(selenium.checkElementIsSelected("OppContactLeadCheckbox"))
			{
				System.out.println("PASS!!! Lead CheckBox is selected");
				selenium.test.log(LogStatus.PASS,"Lead CheckBox is selected");
			}
			else
			{
				System.out.println("FAIL!!! Lead CheckBox is not selected");
				selenium.test.log(LogStatus.FAIL,"Lead CheckBox is not selected");
				selenium.reportFailure("Lead CheckBox is not selected");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("verify the picklist value for Lead Nomination")
	public void verify_the_picklist_for_lead_nomination(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("LikelyAdoptionTermEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LikelyAdoptionTermEditBtn");
			selenium.jsClick("LikelyAdoptionTermEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("LikelyAdoptionTermDropDown");
			selenium.jsClick("LikelyAdoptionTermDropDown");
			selenium.waitingTime(2000);
			//THE BELOW VALUES WILL KEEP CHANGING ON EVERY FY. SO WE NEED TO UPDATE XPATH AS WELL ACCORDINGLY
			if(selenium.isElementPresentsuperFast("LikelyAdoptionTermOption1")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption2")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption3")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption4")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption5")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption6")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption7")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption8")&&
			selenium.isElementPresentsuperFast("LikelyAdoptionTermOption9"))
			{
				System.out.println("PASS!!! Picklist Values are present");
				selenium.test.log(LogStatus.PASS,"Picklist Values are present");
			}
				else
			{
				System.out.println("FAIL!!! Picklist Values are not present");
				selenium.test.log(LogStatus.FAIL,"Picklist Values are not present");
				selenium.reportFailure("Picklist Values are not present");
			}
			selenium.waitForElementToBeClickable("HasCutomerBeenDropDown");
			selenium.jsClick("HasCutomerBeenDropDown");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("HasCustomerOption1")&&selenium.isElementPresentsuperFast("HasCustomerOption2"))
			{
				System.out.println("PASS!!! Picklist Values are present");
				selenium.test.log(LogStatus.PASS,"Picklist Values are present");
			}
			else
			{
				System.out.println("FAIL!!! Picklist Values are not present");
				selenium.test.log(LogStatus.FAIL,"Picklist Values are not present");
				selenium.reportFailure("Picklist Values are not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ResourceToBeDropDown");
			selenium.jsClick("ResourceToBeDropDown");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("ResourceToBeOption1")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption2")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption3")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption4")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption5")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption6")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption7")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption8")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption9")&&
			selenium.isElementPresentsuperFast("ResourceToBeOption10"))
			{
				System.out.println("PASS!!! Picklist Values are present");
				selenium.test.log(LogStatus.PASS,"Picklist Values are present");
			}
			else
			{
				System.out.println("FAIL!!! Picklist Values are not present");
				selenium.test.log(LogStatus.FAIL,"Picklist Values are not present");
				selenium.reportFailure("Picklist Values are not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EventTypeDropDown");
			selenium.jsClick("EventTypeDropDown");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("EventTypeOption1")&&
					selenium.isElementPresentsuperFast("EventTypeOption2"))
			{
				System.out.println("PASS!!! Picklist Values are present");
				selenium.test.log(LogStatus.PASS,"Picklist Values are present");
			}
			else
			{
				System.out.println("FAIL!!! Picklist Values are not present");
				selenium.test.log(LogStatus.FAIL,"Picklist Values are not present");
				selenium.reportFailure("Picklist Values are not present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I change the opportunity stage to won")
		public void i_change_the_opportunity_stage_to_won(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("Edit_Stage");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageWon1");
			selenium.jsClick("OppStageWon1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageCloseReasonValue");
			selenium.jsClick("OppStageCloseReasonValue");
			selenium.waitingTime(2000);
			selenium.scrollToElement("PrimaryFundingTypeField");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryFundingTypeField");
			selenium.click("PrimaryFundingTypeField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryFundingTypeValue");
			selenium.click("PrimaryFundingTypeValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(15000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the opportunity purchase date")
	public void i_verify_the_opp_purchase_date(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("Edit_Stage");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("OppStageDropDown");
//			selenium.jsClick("OppStageDropDown");
//			selenium.waitingTime(2000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.clearText("OppPurchaseDateSelectionField");
			selenium.waitingTime(2000);
			selenium.typeData("OppPurchaseDateSelectionField", todaysdate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("Edit_Stage");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
			selenium.clearText("OppPurchaseDateSelectionField");
			selenium.waitingTime(2000);
			selenium.typeData("OppPurchaseDateSelectionField", "11/30/2025");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! Error Occurred");
				selenium.test.log(LogStatus.PASS,"Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! No Error Occurred");
				selenium.test.log(LogStatus.FAIL,"No Error Occurred");
				selenium.reportFailure("No Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new opportunity for SEG profile")
	public void i_create_a_new_opp_for_seg_profile(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String AccountName="Grady Isd";
			selenium.waitForElementToBeClickable("opp_accName");
			selenium.click("opp_accName");
			selenium.waitingTime(1000);
			selenium.typeData("opp_accName",AccountName);
			selenium.waitingTime(2000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date yesterday=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String yesterdayDate = sdf.format(yesterday);
			System.out.println(yesterdayDate);
//			selenium.waitForElementToBeClickable("DateLink");
//			selenium.jsClick("DateLink");
			selenium.waitForElementToBeClickable("CloseDateTextBox");
			selenium.typeData("CloseDateTextBox",yesterdayDate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.waitForElementToBeClickable("OppAmount");
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppOwner");
			selenium.typeData("OppOwner","Computer Science");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(10000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new opportunity for SEG profile user")
	public void i_create_a_new_opp_for_seg_profile_user(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String AccountName="Yukon Public Schools";
			selenium.waitForElementToBeClickable("opp_accName");
			selenium.click("opp_accName");
			selenium.waitingTime(1000);
			selenium.typeData("opp_accName",AccountName);
			selenium.waitingTime(2000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			Date yesterday=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String yesterdayDate = sdf.format(yesterday);
			System.out.println(yesterdayDate);
//			selenium.waitForElementToBeClickable("DateLink");
//			selenium.jsClick("DateLink");
			selenium.waitForElementToBeClickable("CloseDateTextBox");
			selenium.typeData("CloseDateTextBox",yesterdayDate);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.waitForElementToBeClickable("OppAmount");
			selenium.typeData("OppAmount", Amount);
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("OppOwner");
//			selenium.typeData("OppOwner","Computer Science");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(10000);
			selenium.oppURL =selenium.getURL();
			System.out.println("selenium.oppURL is --> " + selenium.oppURL);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I validate the close date with today date")
	public void i_validate_the_close_date_with_today_date(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 0);
			Date today=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todayDate = sdf.format(today);
			System.out.println(todayDate);
			selenium.waitForElementToBeVisible("OpptyCloseDateGetText");
			String opptyCloseDate=selenium.getText("OpptyCloseDateGetText").toString();
			if(!opptyCloseDate.equalsIgnoreCase(todayDate))
			{
				System.out.println("PASS!!! Close Date not matched with Today Date");
				selenium.test.log(LogStatus.PASS,"Close Date not matched with Today Date");
			}
			else
			{
				System.out.println("FAIL!!! Close Date matched with Today Date");
				selenium.test.log(LogStatus.FAIL,"Close Date matched with Today Date");
				selenium.reportFailure("Close Date matched with Today Date");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("verify the print this page link")
	public void verify_the_print_this_page_link(){
		try{
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006O800000C6B9yIAF/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("moreActionsBtn");
			selenium.jsClick("moreActionsBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyPrintableViewBtn");
			selenium.jsClick("OpptyPrintableViewBtn");
			selenium.waitingTime(8000);
			selenium.switchToChildWindow();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("OpptyPrintThisPageLink");
			if(selenium.isElementPresentFast("OpptyPrintThisPageLink"))
			{
				System.out.println("PASS!!! Download Successful");
				selenium.test.log(LogStatus.PASS,"Download Successful");
				selenium.close();
				selenium.waitingTime(2000);
				selenium.switchBackToParentWindow();
				selenium.waitingTime(2000);
			}
			else
			{
				System.out.println("FAIL!!! Download Failed");
				selenium.test.log(LogStatus.FAIL,"Download Failed");
				selenium.reportFailure("Download Failed");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I validate the push out field picklist values")
	public void i_validate_the_push_out_field_picklist_values(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OpptyPushOutEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyPushOutEditBtn");
			selenium.jsClick("OpptyPushOutEditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyPushOutDropDown");
			selenium.jsClick("OpptyPushOutDropDown");

			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("PushOutDropDownOption1")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption2")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption3")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption4")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption5")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption6")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption7")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption8")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption9")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption10")&&
			selenium.isElementPresentsuperFast("PushOutDropDownOption11"))
			{
				System.out.println("PASS!!! Picklist values are present");
				selenium.test.log(LogStatus.PASS,"Picklist values are present");
			}
			else
			{
				System.out.println("FAIL!!! Picklist values are not present");
				selenium.test.log(LogStatus.FAIL,"Picklist values are not present");
				selenium.reportFailure("Picklist values are not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PushOutDropDownOption1");
			selenium.jsClick("PushOutDropDownOption1");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new opportunity for MHEI")
	public void i_create_a_new_opp_for_mhei(){
		try{
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyINTLOppContactStatus"))
			{
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.jsClick("nextBtn");
			}
			selenium.waitingTime(8000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			/*selenium.waitForElementsToBeVisible("opportunityAccountName");
			selenium.type_propertiesFile("opportunityAccountName","account_name3");
			selenium.waitingTime(4000);
			selenium.pressEnter("opportunityAccountName");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("selectOppAccountName");
			selenium.jsClick("selectOppAccountName");
			selenium.waitingTime(2000);*/
			
			selenium.waitForElementToBeClickable("opportunityAccountName");
			selenium.type_propertiesFile("opportunityAccountName","account_name3");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name3", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("enrollment");
			selenium.type_propertiesFile("enrollment", "Enrollment");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("mheCourse");
			selenium.type_propertiesFile("mheCourse", "mhe_course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath_propertiesFile("spanTitle", "mhe_course", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("closeDate1");
			selenium.click("closeDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderDate1");
			selenium.click("orderDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("save_new_opp");
			selenium.click("save_new_opp");
			selenium.waitingTime(20000);
			System.out.println("New Opportunity created");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I open the opportunity contact and edit the email and verify")
	public void i_open_the_opp_contact_and_edit_the_email_and_verify(){
		try {
			String randomText=selenium.getRandomString();
			selenium.opportunityURL=selenium.getURL();
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppAddContactBtn");
			selenium.jsClick("OppAddContactBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("contactC");
			selenium.jsClick("contactC");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			Select dropdown1 = new Select(selenium.getElement("OpptyContactTypeDropDown"));
			dropdown1.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactEmailTextBox");
			selenium.typeData("OpptyContactEmailTextBox",randomText+"@demo.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactLastName");
			selenium.typeData("OpptyContactLastName",randomText);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactDepartmentName");
			selenium.typeData("OpptyContactDepartmentName","SCIENCE");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeClickable("ContactNameLink");
			selenium.jsClick("ContactNameLink");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("ContactEmailEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactEmailEditBtn");
			selenium.jsClick("ContactEmailEditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.clearText("EmailTextBox");
			selenium.typeData("EmailTextBox","testEmail@crm.mheducation.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("snagerror"))
			{
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ShowAllResults");
				selenium.jsClick("ShowAllResults");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("DepartmentNameSelect");
				selenium.jsClick("DepartmentNameSelect");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(8000);
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I delete the added opportunity contact and verify")
	public void i_delete_the_added_opp_contact_and_verify(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.jsClick("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(2000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I open the opportunity and change the stage to lost")
	public void i_open_the_opp_and_change_the_stage_to_lost(){
		try{
			selenium.navigateToURL(selenium.opportunityURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageLost");
			selenium.jsClick("StageLost");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create an account of unique type")
	public void i_create_an_account_of_unique_type(){
		try{
			String oracleAcctNum=Integer.toString(selenium.getRandomNumber());
			selenium.randomString=selenium.getRandomString();
			String accountUrl="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwTarAAE/view";
			selenium.navigateToURL(accountUrl);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");
			selenium.jsClick("ClickOnCloneBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.clearText("Name_Field");
			selenium.waitingTime(2000);
			selenium.typeData("Name_Field",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.scrollToElement("OracleAccountNumberTextBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OracleAccountNumberTextBox");
			selenium.clearText("OracleAccountNumberTextBox");
//			selenium.typeData("OracleAccountNumberTextBox",oracleAcctNum);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OracleAccountIdTextBox");
			selenium.clearText("OracleAccountIdTextBox");
//			selenium.typeData("OracleAccountIdTextBox",oracleAcctNum);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new opportunity having random account name")
	public void i_create_a_new_opp_having_random_account_name(){
		try{
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(20000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToMultipleFrame("switch_iFrame");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CreateOppAccountTextBox");
			selenium.typeData("CreateOppAccountTextBox",selenium.randomString);
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpathData("spanTitle", selenium.randomString, "end");
			selenium.waitingTime(6000);
			selenium.clickLoopXpath(xpath);
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.hoverAndClick("OpportunityMHECourse2");
			String Course = "Advanced Engineering Mathematics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.pressEnter("OpportunityMHECourse2");
			selenium.waitForElementToBeClickable("select_course");
			selenium.hoverAndClick("select_course");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("enrollment_spring");
			selenium.jsClick("enrollment_spring");
			selenium.waitingTime(3000);
			String Value = "20";
			selenium.typeData("enrollment_spring", Value);
			selenium.waitForElementToBeClickable("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment","123");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(9000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
			selenium.waitingTime(10000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I click on mhe course link and verify")
	public void i_click_on_mhe_course_link_and_verify(){
		try {
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 0);
			Date today=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(today);
			System.out.println("Todays date is : "+todaysdate);
			selenium.waitForElementToBeClickable("AccountMHECourseEmailClick");
			selenium.jsClick("AccountMHECourseEmailClick");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("LastModifiedDateGetText");
			String dateTimeString=selenium.getText("LastModifiedDateGetText").toString();
			System.out.println("Date and Time From UI is : "+dateTimeString);
			// Define the format of the input date and time
			DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy, HH:mm");
			// Parse the input string to a Date object
			Date dateTime = inputFormat.parse(dateTimeString);
			// Define the format for extracting the date
			DateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
			// Format the Date object to get the date
			String dateOnly = outputFormat.format(dateTime);
			// Print the extracted date
			System.out.println("Date after trim is : " + dateOnly);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyAccountAndMHECourseCombination"))
			{
				selenium.refresh();
				selenium.waitingTime(8000);
				if (dateOnly.equalsIgnoreCase(todaysdate)) {
					System.out.println("PASS!!! Account name and MHE course are created first time");
					selenium.test.log(LogStatus.PASS, "Account name and MHE course are created first time");
				} else {
					System.out.println("FAIL!!! Account name and MHE course are not created first time");
					selenium.test.log(LogStatus.PASS, "Account name and MHE course are not created first time");
					selenium.reportFailure("Account name and MHE course are not created first time");
				}
			}
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppAccountAndMHECourseCombination"))
			{
				selenium.refresh();
				selenium.waitingTime(8000);
				if (!dateOnly.equalsIgnoreCase(todaysdate)) {
					System.out.println("PASS!!! Account name and MHE course are not created first time");
					selenium.test.log(LogStatus.PASS, "Account name and MHE course are not created first time");
				} else {
					System.out.println("FAIL!!! Account name and MHE course created first time");
					selenium.test.log(LogStatus.PASS, "Account name and MHE course created first time");
					selenium.reportFailure("Account name and MHE course created first time");
				}
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new opportunity for FSL")
	public void i_create_a_new_opp_for_fsl(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String AccountName="Lawton Public Schools";
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifySEGUserAbleToAddProductInOppwithAndWithoutproductCourse"))
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName","Lawton Public School");
				selenium.waitingTime(2000);
			}
			else
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName",AccountName);
				selenium.waitingTime(2000);
			}

			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.waitForElementToBeClickable("OppAmount");
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);//
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(6000);
			if(selenium.isElementPresentFast("OpptySaveBtn"))
			{
				selenium.waitForElementToBeClickable("OpptySaveBtn");
				selenium.jsClick("OpptySaveBtn");
			}
			selenium.waitingTime(10000);
			selenium.oppURL =selenium.getURL();
			System.out.println("selenium.oppURL is--> " + selenium.oppURL);
			selenium.waitForElementToBeClickable("Create_WorkOrder_Button");
			selenium.jsClick("Create_WorkOrder_Button");
			selenium.waitingTime(5000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new account for FSL")
	public void i_create_a_new_account_for_fsl() {
		try {
			selenium.randomString = selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field", selenium.randomString + "_AccountName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassDropDown");
			selenium.jsClick("AccountClassDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassOption");
			selenium.jsClick("AccountClassOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeDropDown");
			selenium.jsClick("AccountTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeOptionNew");
			selenium.jsClick("AccountTypeOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("WorkflowStatusTextBox");
			selenium.typeData("WorkflowStatusTextBox", "DemoTest");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("Create_WorkOrder_Button");
			selenium.jsClick("Create_WorkOrder_Button");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
		@Then("I create a new opportunity for SEG Sales")
		public void i_create_a_new_opp_for_seg_sales(){
			try{
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.jsClick("NewBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("NextButton");
				selenium.jsClick("NextButton");
				selenium.waitingTime(5000);
				String AccountName="Lawton Public School";
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName",AccountName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DateLink");
				selenium.jsClick("DateLink");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DefaultPurchaseDate");
				selenium.jsClick("DefaultPurchaseDate");
				selenium.waitingTime(2000);
				String Amount="200";
				Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
				dropdown1.selectByIndex(1);
				Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
				dropdown2.selectByIndex(14);
				selenium.waitForElementToBeClickable("OppAmount");
				selenium.typeData("OppAmount", Amount);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpptySaveBtn");
				selenium.jsClick("OpptySaveBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OpptySaveBtn");
				selenium.jsClick("OpptySaveBtn");
				selenium.waitingTime(10000);

			}catch (Exception e){
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error occurred " + e.getMessage());
			}
		}
			@Then("I delete the added opp contactt")
			public void i_delete_the_added_opp_contactt(){
			try{
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstOppContactRecord");
			selenium.jsClick("firstOppContactRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.jsClick("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(2000);
			System.out.println("Opp Contact deleted successfully");
			}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create a new contact for MHHE")
	public void i_create_a_new_contact_for_mhhe(){
		try{
			selenium.lastName=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastName");
			selenium.typeData("lastName",selenium.lastName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.autoSuggestiveDropdownWithoutTextTwo("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchAccounts");
			selenium.typeData("searchAccounts","Stanford University");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("searchAccounts");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments","Science");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("create again a new contact with similar name")
	public void create_again_a_new_contact_with_similar_name(){
		try{
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastName");
			selenium.typeData("lastName",selenium.lastName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.autoSuggestiveDropdownWithoutTextTwo("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchAccounts");
			selenium.typeData("searchAccounts","Stanford University");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("searchAccounts");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments","Math");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
			selenium.waitingTime(2000);
			selenium.scrollToElement("OkToAddDuplicateCheckBoxNew");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OkToAddDuplicateCheckBoxNew");
			selenium.jsClick("OkToAddDuplicateCheckBoxNew");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("merge both the contacts")
	public void merge_both_the_contacts(){
		try{
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("DupeCheckBtn");
			selenium.jsClick("DupeCheckBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MergeFromCheckBox");
			selenium.jsClick("MergeFromCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MergeToRadioBtn");
			selenium.jsClick("MergeToRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MergeBtn");
			selenium.jsClick("MergeBtn");
			selenium.waitingTime(5000);
			String mergeSuccessfulGetText=selenium.getText("MergeSuccessfulGetText").toString();
			Assert.assertEquals("The Contacts were merged successfully.",mergeSuccessfulGetText);
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS,"PASS");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}

	

