package com.mhe.salesforce.a3k;

import com.mhe.salesforce.util.WebConnector;

//import org.apache.poi.util.SystemOutLogger;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block;
import org.junit.Assert;


import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class FSLWorkOrder {
	WebConnector selenium = WebConnector.getInstance();
	String NewWONumber = null;
	String WorkOrderURL = null;
	String ServiceAppointmentURL_ToAssignResource = "https://mh--uat.sandbox.lightning.force.com/lightning/r/ServiceAppointment/08pDY0000004mD6YAI/view";
	

	@When("^User click on create work order button$")
	public void user_click_on_create_work_order_button(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			selenium.waitingTime(2000);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Create_WorkOrder_Button");
			selenium.jsClick("Create_WorkOrder_Button");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Clicking on Create Work order button " + e.getMessage());
		}
	}

	@Then("^Select \"([^\"]*)\" work order record type and click next$")
	public void select_pre_sale_work_order_record_type_and_click_next(String salesOption) {
		try {
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_PreSales") || selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_Others"))
			{
				selenium.navigateToURL(selenium.oppURL);
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("Create_WorkOrder_Button");
				selenium.jsClick("Create_WorkOrder_Button");
				selenium.waitingTime(5000);
			}
			selenium.waitingTime(2000);
			if (salesOption.equals("PreSales")) {
				selenium.waitForElementToBeClickable("WorkOrderPreSales");
				selenium.jsClick("WorkOrderPreSales");
			}
			if (salesOption.equals("PostSales")) {
				selenium.waitForElementToBeClickable("WorkOrderPostSales");
				selenium.jsClick("WorkOrderPostSales");
			}
			if (salesOption.equals("Others")) {
				selenium.waitForElementToBeClickable("WorkOrderOtherSales");
				selenium.clickLoop("WorkOrderOtherSales");
			}
			System.out.println("-->"+salesOption);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Selecting Sales option " + e.getMessage());
		}
	}

	@Then("^create Work Order by filling mandatory fields Scheduler$")
	public void create_work_order_by_filling_mandatory_fields_scheduler() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Targetted_District");
			selenium.autoSuggestiveDropdownWithoutText("Targetted_District");
			selenium.waitForElementToBeClickable("Contact");
			selenium.autoSuggestiveDropdownWithoutText("Contact");
			selenium.waitForElementToBeClickable("ServiceTerritory");
			selenium.autoSuggestiveDropdownWithoutText("ServiceTerritory");
			selenium.waitForElementToBeClickable("Type_DropDown");
			selenium.autoSuggestiveDropdownWithoutText("Type_DropDown");
			selenium.waitForElementToBeClickable("Online_Offline");
			selenium.autoSuggestiveDropdownWithoutText("Online_Offline");
			selenium.waitForElementToBeClickable("Subject");
			selenium.getElement("Subject").sendKeys("Testing FSL");
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeClickable("ConsultantNeededTextBox");
			selenium.typeData("ConsultantNeededTextBox","1");
			selenium.waitForElementToBeClickable("NumberOfParticipantsTextBox");
			selenium.typeData("NumberOfParticipantsTextBox","1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PresentationTypeDropDwn");
			selenium.jsClick("PresentationTypeDropDwn");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_Other"))
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption2");
				selenium.jsClick("PresentationTypeOption2");
				selenium.waitingTime(2000);
			}
			else if (selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_Others"))
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption2");
				selenium.jsClick("PresentationTypeOption2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FSL_ExhibitConferenceDetailsTextBox");
				selenium.typeData("FSL_ExhibitConferenceDetailsTextBox", "AutomationTest");
			}
			else
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption1");
				selenium.jsClick("PresentationTypeOption1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FSL_DistrictMeetingType");
				selenium.typeData("FSL_DistrictMeetingType", "AutomationTest");
			}

			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("SelectSecondOppForWO"))
			{
				System.out.println("Selecting the second opp in the list..");
				selenium.scrollToElement("SelectSecondOppForWO");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.click("SelectSecondOppForWO");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("SelectSecondOppForWO"))
			{
				selenium.jsClick("SelectSecondOppForWO");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAddress");
			selenium.autoSuggestiveDropdownWithoutText("SelectAddress");
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("BuildingName FSL");
			selenium.waitForElementToBeClickable("RoomName");
			selenium.getElement("RoomName").sendKeys("RoomName FSL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("PreferredServiceResources");
//			selenium.jsClick("PreferredServiceResources");
			selenium.typeData("PreferredServiceResources", "Jennifer Cook"); //This User(SR) should be Active
			selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			selenium.waitingTime(5000);
			selenium.jsClick("PreferenceType");
			System.out.print("Preference Type --> Clicked");
			Select dropdown_value = new Select(selenium.getElement("PreferenceType"));
			dropdown_value.selectByIndex(1);
			selenium.waitForElementToBeClickable("WorkTypeCheckBox");
			selenium.jsClick("WorkTypeCheckBox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("Preferred_AlternateDateTypes");
			selenium.jsClick("Preferred_AlternateDateTypes");
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("1");
			System.out.print("Trainer Value 1");
			// pref date
			selenium.waitForElementToBeClickable("Preferred_StartDate");
			selenium.getElement("Preferred_StartDate").sendKeys(selenium.getFutureDate(1));
			selenium.waitForElementToBeClickable("Preferred_EndDate");
			selenium.getElement("Preferred_EndDate").sendKeys(selenium.getFutureDate(2));
			selenium.waitForElementToBeVisible("DateTime_Confirmed_Dropdown");
			Select dateTimeConfirmedDropdown = new Select(selenium.getElement("DateTime_Confirmed_Dropdown"));
			dateTimeConfirmedDropdown.selectByIndex(1);
			// alt date 1
			selenium.waitForElementToBeClickable("Alternate1_StartDate");
			selenium.getElement("Alternate1_StartDate").sendKeys(selenium.getFutureDate(7));
			selenium.waitForElementToBeClickable("Alternate1_EndDate");
			selenium.getElement("Alternate1_EndDate").sendKeys(selenium.getFutureDate(8));
			selenium.waitForElementToBeVisible("DateTime_Alt1_Dropdown");
			Select dateTimeAlternateDropdown1 = new Select(selenium.getElement("DateTime_Alt1_Dropdown"));
			dateTimeAlternateDropdown1.selectByIndex(1);
			// alt date 2
			selenium.waitForElementToBeClickable("Alternate2_StartDate");
			selenium.getElement("Alternate2_StartDate").sendKeys(selenium.getFutureDate(11));
			selenium.waitForElementToBeClickable("Alternate2_EndDate");
			selenium.getElement("Alternate2_EndDate").sendKeys(selenium.getFutureDate(12));
			selenium.waitForElementToBeVisible("DateTime_Alt2_Dropdown");
			Select dateTimeAlternateDropdown2 = new Select(selenium.getElement("DateTime_Alt2_Dropdown"));
			dateTimeAlternateDropdown2.selectByIndex(1);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("WorkPlanTypeCheckBox");
			selenium.jsClick("WorkPlanTypeCheckBox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(15000);

			if (!selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_Others")) {
			selenium.waitForElementToBeClickable("AlternateDateCheckbox");
			selenium.jsClick("AlternateDateCheckbox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("PreferredResourceDrpDwn"))
			{
				Select dropdown = new Select(selenium.getElement("PreferredResourceDrpDwn"));
				dropdown.selectByIndex(1);
				selenium.waitingTime(2000);
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(10000);
			}
			selenium.waitForElementsToBeVisible("AddMoreAppointementNoRadio");
			selenium.jsClick("AddMoreAppointementNoRadio");
			}
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
	}
	
	@Then("^create other Work Order by filling mandatory fields Scheduler$")
	public void create_other_work_order_by_filling_mandatory_fields_scheduler() {
		try {
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Targetted_District");
			selenium.autoSuggestiveDropdownWithoutText("Targetted_District");
			selenium.waitForElementToBeClickable("Contact");
			selenium.autoSuggestiveDropdownWithoutText("Contact");
			selenium.waitForElementToBeClickable("ServiceTerritory");
			selenium.autoSuggestiveDropdownWithoutText("ServiceTerritory");
			selenium.waitForElementToBeClickable("Type_DropDown");
			selenium.autoSuggestiveDropdownWithoutText("Type_DropDown");
			selenium.waitForElementToBeClickable("Online_Offline");
			selenium.autoSuggestiveDropdownWithoutText("Online_Offline");
			selenium.waitForElementToBeClickable("Subject");
			selenium.getElement("Subject").sendKeys("Testing FSL");
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeClickable("ConsultantNeededTextBox");
			selenium.typeData("ConsultantNeededTextBox","1");
			selenium.waitForElementToBeClickable("NumberOfParticipantsTextBox");
			selenium.typeData("NumberOfParticipantsTextBox","1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PresentationTypeDropDwn");
			selenium.jsClick("PresentationTypeDropDwn");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_Other"))
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption2");
				selenium.jsClick("PresentationTypeOption2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FSL_ExhibitConferenceDetailsTextBox");
				selenium.typeData("FSL_ExhibitConferenceDetailsTextBox", "AutomationTest");
			}
			else
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption1");
				selenium.jsClick("PresentationTypeOption1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FSL_DistrictMeetingType");
				selenium.typeData("FSL_DistrictMeetingType", "AutomationTest");
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			/*if(selenium.isElementPresentFast("SelectSecondOppForWO"))
			{
				System.out.println("Selecting the second opp in the list..");
				selenium.scrollToElement("SelectSecondOppForWO");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.click("SelectSecondOppForWO");
				selenium.waitingTime(2000);
			}*/
//			selenium.waitForElementToBeClickable("Next_Btn");
//			selenium.jsClick("Next_Btn");
//			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("Next_Btn");
//			selenium.jsClick("Next_Btn");
//			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SelectAddress");
			selenium.autoSuggestiveDropdownWithoutText("SelectAddress");
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("BuildingName FSL");
			selenium.waitForElementToBeClickable("RoomName");
			selenium.getElement("RoomName").sendKeys("RoomName FSL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("PreferredServiceResources");
//			selenium.jsClick("PreferredServiceResources");
			selenium.typeData("PreferredServiceResources", "Jennifer Cook"); //This User(SR) should be Active
			selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			selenium.waitingTime(5000);
			selenium.waitingTime(5000);
			selenium.jsClick("PreferenceType");
			System.out.print("Preference Type --> Clicked");
			Select dropdown_value = new Select(selenium.getElement("PreferenceType"));
			dropdown_value.selectByIndex(1);
			selenium.waitForElementToBeClickable("WorkTypeCheckBox");
			selenium.jsClick("WorkTypeCheckBox");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitForElementToBeClickable("WorkPlanTypeCheckBox");
			selenium.jsClick("WorkPlanTypeCheckBox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementsToBeVisible("NoRadio");
			selenium.jsClick("NoRadio");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
	}

	@Then("^create Work Order by filling mandatory fields SalesRep$")
	public void create_work_order_by_filling_mandatory_fields_salesrep() {
		try {
			selenium.waitingTime(6000);
			if(selenium.isElementPresentFast("Targetted_District"))
			{
				selenium.waitForElementToBeClickable("Targetted_District");
				selenium.autoSuggestiveDropdownWithoutText("Targetted_District");
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSales")||selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSalesWithTypeMcGraw"))
			{
				selenium.waitForElementToBeClickable("Service_Territory");
				selenium.typeData("Service_Territory", "Inside Sales");
			}
			else
			{
				selenium.waitForElementToBeClickable("Service_Territory");
				selenium.typeData("Service_Territory", "A3K");
			}
			selenium.waitingTime(6000);
			selenium.autoSuggestiveDropdownWithoutText("Service_Territory");
			selenium.waitForElementToBeClickable("Account_Contacts");
			selenium.autoSuggestiveDropdownWithoutText("Account_Contacts");
			if(selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSalesWithTypeMcGraw"))
			{
				selenium.waitForElementToBeClickable("Type_DropDown");
				Select dropdown=new Select(selenium.getElement("Type_DropDown"));
				dropdown.selectByIndex(32);
			}
			else
			{
				selenium.waitForElementToBeClickable("Type_DropDown");
				selenium.autoSuggestiveDropdownWithoutText("Type_DropDown");
			}
			selenium.waitForElementToBeClickable("Online_Offline");
			selenium.autoSuggestiveDropdownWithoutText("Online_Offline");
			selenium.waitForElementToBeClickable("Subject");
			selenium.getElement("Subject").sendKeys("Testing FSL");
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("ConsultantNeededTextBox"))
			{
				selenium.waitForElementToBeClickable("ConsultantNeededTextBox");
				selenium.typeData("ConsultantNeededTextBox","1");
				selenium.waitForElementToBeClickable("NumberOfParticipantsTextBox");
				selenium.typeData("NumberOfParticipantsTextBox","1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("PresentationTypeDropDwn");
				selenium.jsClick("PresentationTypeDropDwn");
				selenium.waitingTime(2000);
				if (selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSales")) {
					selenium.waitForElementToBeClickable("PresentationTypeOption");
					selenium.jsClick("PresentationTypeOption");
				}
				else
				{
					selenium.waitForElementToBeClickable("PresentationTypeOption1");
					selenium.jsClick("PresentationTypeOption1");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("FSL_DistrictMeetingType");
					selenium.typeData("FSL_DistrictMeetingType", "AutomationTest");
				}
	
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
			}
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PreSales") || selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSales")) {
				if(selenium.isElementPresentFast("SelectSecondOppForWO"))
				{
					System.out.println("Selecting the second opp in the list..");
	//				selenium.scrollToElement("SelectSecondOppForWO");
	//				selenium.waitingTime(2000);
	//				selenium.scrolldown(-200);
					selenium.waitingTime(2000);
					selenium.jsClick("SelectSecondOppForWO");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentFast("SelectSecondOppForWO"))
				{
					selenium.jsClick("SelectSecondOppForWO");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Next_Btn");
					selenium.jsClick("Next_Btn");
					selenium.waitingTime(5000);
				}
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
			}
			/*if(selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSalesWithTypeMcGraw"))
			{
				selenium.waitForElementToBeClickable("ConsultantNeededTextBox");
				selenium.typeData("ConsultantNeededTextBox","2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NumberOfParticipantsTextBox");
				selenium.typeData("NumberOfParticipantsTextBox","2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("PresentationTypeDropDwn");
				selenium.jsClick("PresentationTypeDropDwn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("PresentationTypeOption");
				selenium.jsClick("PresentationTypeOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");

				selenium.waitForElementToBeClickable("CheckBoxMcGrawType");
				selenium.jsClick("CheckBoxMcGrawType");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");

			}*/
			selenium.waitForElementToBeClickable("SelectAddress");
			selenium.autoSuggestiveDropdownWithoutText("SelectAddress");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("BuildingName FSL");
			selenium.waitForElementToBeClickable("RoomName");
			selenium.getElement("RoomName").sendKeys("RoomName FSL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("PreferredServiceResources");
//			selenium.autoSuggestiveDropdownWithoutText1("PreferredServiceResources");
			selenium.typeData("PreferredServiceResources", "Jennifer Cook"); //This User(SR) should be Active
			selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			selenium.waitingTime(5000);
			selenium.jsClick("PreferenceType");
			System.out.print("Preference Type --> Clicked");
			Select dropdown_value = new Select(selenium.getElement("PreferenceType"));
			dropdown_value.selectByIndex(1);
			selenium.waitForElementToBeClickable("WorkTypeCheckBox");
			selenium.jsClick("WorkTypeCheckBox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			if(selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSalesWithTypeMcGraw")) {
				Assert.assertFalse(selenium.isElementPresentFast("FSLOperatingHoursPreviousBtn"));
				System.out.println("PASS!!! No Previous button is present");
			}
			selenium.waitForElementToBeClickable("Preferred_AlternateDateTypes");
			selenium.jsClick("Preferred_AlternateDateTypes");
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("1");
			System.out.print("Trainer Value 1");
			// pref date
			selenium.waitForElementToBeClickable("Preferred_StartDate");
			selenium.getElement("Preferred_StartDate").sendKeys(selenium.getFutureDate(1));
			selenium.waitForElementToBeClickable("Preferred_EndDate");
			selenium.getElement("Preferred_EndDate").sendKeys(selenium.getFutureDate(2));
			selenium.waitForElementToBeVisible("DateTime_Confirmed_Dropdown");
			Select dateTimeConfirmedDropdown = new Select(selenium.getElement("DateTime_Confirmed_Dropdown"));
			dateTimeConfirmedDropdown.selectByIndex(1);
			// alt date 1
			selenium.waitForElementToBeClickable("Alternate1_StartDate");
			selenium.getElement("Alternate1_StartDate").sendKeys(selenium.getFutureDate(7));
			selenium.waitForElementToBeClickable("Alternate1_EndDate");
			selenium.getElement("Alternate1_EndDate").sendKeys(selenium.getFutureDate(8));
			selenium.waitForElementToBeVisible("DateTime_Alt1_Dropdown");
			Select dateTimeAlternateDropdown1 = new Select(selenium.getElement("DateTime_Alt1_Dropdown"));
			dateTimeAlternateDropdown1.selectByIndex(1);
			// alt date 2
			selenium.waitForElementToBeClickable("Alternate2_StartDate");
			selenium.getElement("Alternate2_StartDate").sendKeys(selenium.getFutureDate(11));
			selenium.waitForElementToBeClickable("Alternate2_EndDate");
			selenium.getElement("Alternate2_EndDate").sendKeys(selenium.getFutureDate(12));
			selenium.waitForElementToBeVisible("DateTime_Alt2_Dropdown");
			Select dateTimeAlternateDropdown2 = new Select(selenium.getElement("DateTime_Alt2_Dropdown"));
			dateTimeAlternateDropdown2.selectByIndex(1);
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Next_Btn"))
			{
				selenium.waitForElementToBeClickable("Next_Btn"); //select modules popup
				selenium.jsClick("Next_Btn");
			}
			selenium.waitingTime(15000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
	}

	@Then("On the next page Validate a Success Message Work Order #xxxxxxx has been successfully created. It has not been submitted yet")
	public void on_the_next_page_validate_a_success_message_work_order_xxxxxxx_has_been_successfully_created_it_has_not_been_submitted_yet() {
		try{
				selenium.takeScreenShot();
				String expected = selenium.getTestDataFromPropertiesFile("WorkOrderCreatedMessage");
				String actual = selenium.getElement("WorkOrderSuccessfulMessage").getText();
				System.out.println("Expected --> "+expected);
				System.out.println("Actual --> "+actual);
				assertTrue(actual.contains(expected));
				String expected1 = selenium.getTestDataFromPropertiesFile("WorkOrderCreatedMessage2");
				String actual1 = selenium.getElement("WorkOrderSuccessfulMessage2").getText();
				System.out.println("Expected1 --> "+expected1);
				System.out.println("Actual1 --> "+actual1);
				Assert.assertEquals(actual1,expected1);
				
				String[] FirstSplit = actual.split(" ");
				String WONumber = FirstSplit[2];
				System.out.println("WorkOrderNumber with # is " + WONumber);
				
				String[] SecondSplit = WONumber.split("#");
				NewWONumber = SecondSplit[1];
				System.out.println("WorkOrderNumber without # is " + NewWONumber);
}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating work order creation message " + e.getMessage());
		}
	}

	@Then("Validate when click on Open New Work Order button it navigate you to the newly created work order record")
//	public void validate_when_click_on_open_new_work_order_button_it_navigate_you_to_the_newly_created_work_order_record(DataTable table) {
		public void validate_when_click_on_open_new_work_order_button_it_navigate_you_to_the_newly_created_work_order_record() {

			try {
			selenium.waitForElementToBeClickable("OpenNewWorkOrderButton1");
			selenium.jsClick("OpenNewWorkOrderButton1");
			selenium.waitingTime(5000);
			WorkOrderURL = selenium.getURL();
			System.out.println("WorkOrderURL is " + WorkOrderURL);
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSales") || selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_Other")||selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSalesWithTypeMcGraw"))
			{
				/*selenium.navigateToURL(data.get(0));
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("AccountShowAllRelatedList");
				selenium.hoverAndClick("AccountShowAllRelatedList");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("WORelatedListInAct");
				selenium.clickLoop("WORelatedListInAct");*/
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/related/WorkOrders/view");
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(10000);
					String Xpath = selenium.getDynamicXpath_data("NewWOLinkStart",NewWONumber,"end");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentXpathFast(Xpath))
					{
						selenium.clickXpath(Xpath);
					}
					else
					{
						selenium.click("WONameColumn");
						selenium.waitingTime(5000);
						selenium.clickXpath(Xpath);
					}
				selenium.waitingTime(5000);
				WorkOrderURL = selenium.getURL();
				System.out.println("WorkOrderURL is " + WorkOrderURL);
			}
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLSalesRepCreateWO_PostSales"))
			{
				selenium.PostSalesWorkOrderURL = selenium.getURL();
				System.out.println("PostSalesWorkOrderURL is " + selenium.PostSalesWorkOrderURL);
			}
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
	}
	
	@Then("create service appointment for workorderlineitem of new workorder")
	public void create_service_appointment_for_workorderlineitem_of_new_workorder() {
		try {

			if(selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerProcessWO_PostSales") || selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerAddWorkOrderLineItem"))
			{
				System.out.println("Inside IF");
				selenium.navigateToURL(selenium.PostSalesWorkOrderURL);
			}
			else
			{
				System.out.println("Inside ELSE");
				selenium.navigateToURL(WorkOrderURL);	
			}
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("WorkOrderLineItemsRelatedList");
			selenium.clickLoop("WorkOrderLineItemsRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CreateAppointmentBtn");
			selenium.takeScreenShot();
			selenium.jsClick("CreateAppointmentBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EarliestStartTimeField");
			selenium.typeData("EarliestStartTimeField",selenium.getFutureDate(14));
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DueDateField");
			selenium.typeData("DueDateField",selenium.getFutureDate(14));
			selenium.waitingTime(2000);
			selenium.click("NuberOfTrainersRequiredField");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("CreateAppointmentAlternativeDateCBox"))
			{
				selenium.jsClick("CreateAppointmentAlternativeDateCBox");
				selenium.waitingTime(2000);
			}
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while creating Service appointment for WorkOrderLineItem of new Workorder");
			selenium.reportFailure("Error while creating Service appointment for WorkOrderLineItem of new Workorder " + e.getMessage());
		}
	}
	
	@And("add all different presentation types to the workorder")
	public void add_all_different_presentation_types_to_the_workorder() {
		try {
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			
			/*Add Presentation Type Details*/
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.typeData("ExhibitorConferenceDetailsField", "Test");
			selenium.typeData("DistrictMeetingTypeField", "Test");
			selenium.typeData("PresentationTypeSupportDiemField", "Test");
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_Others")) {
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType1");
			selenium.jsClick("OtherWOPresentationType1");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType2");
			selenium.jsClick("OtherWOPresentationType2");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType3");
			selenium.jsClick("OtherWOPresentationType3");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType4");
			selenium.jsClick("OtherWOPresentationType4");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType5");
			selenium.jsClick("OtherWOPresentationType5");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType6");
			selenium.jsClick("OtherWOPresentationType6");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.clickLoop("EditButton");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("OtherWOPresentationType7");
			selenium.jsClick("OtherWOPresentationType7");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(6000);
			}
			else if (selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_PreSales")) {
				selenium.jsClick("PresentationTypeDrpDwn");
				selenium.waitForElementToBeClickable("OtherWOPresentationType8");
				selenium.jsClick("OtherWOPresentationType8");
				selenium.clickLoop("SaveBtnNew1");
				selenium.waitingTime(6000);
				
				selenium.navigateToURL(WorkOrderURL);
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.clickLoop("EditButton");
				selenium.waitingTime(6000);
				selenium.scrollToElement("PresentationTypeDrpDwn");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.jsClick("PresentationTypeDrpDwn");
				selenium.waitForElementToBeClickable("OtherWOPresentationType9");
				selenium.jsClick("OtherWOPresentationType9");
				selenium.clickLoop("SaveBtnNew1");
				selenium.waitingTime(6000);
				
				selenium.navigateToURL(WorkOrderURL);
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.clickLoop("EditButton");
				selenium.waitingTime(6000);
				selenium.scrollToElement("PresentationTypeDrpDwn");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.jsClick("PresentationTypeDrpDwn");
				selenium.waitForElementToBeClickable("OtherWOPresentationType10");
				selenium.jsClick("OtherWOPresentationType10");
				selenium.clickLoop("SaveBtnNew1");
				selenium.waitingTime(6000);
			}
			
			selenium.test.log(LogStatus.PASS, "Successfully verified all presentation type for a workorder (other)");
//			selenium.closeSubTabs();	
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while adding presentation type to the Workorder");
			selenium.reportFailure("Error while adding presentation type to the Workorder " + e.getMessage());
		}
	}
	
	@And("Submit WO and validate PD Usage and Presentation type missing message")
	public void Submit_WO_and_validate_PD_Usage_and_Presentation_type_missing_message() {
		try {
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/WorkOrder/0WO8H000001JC3oWAG/view?ws=%2Flightning%2Fr%2FAccount%2F0018000000cMIcyAAG%2Fview");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SubmitWOBtn");
			selenium.jsClick("SubmitWOBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("WOSubmitValidationPopup");
			if(selenium.isElementPresentFast("WOSubmitValidationPopup") && selenium.isElementPresentFast("WOSubmitValidationMsg1"))// && selenium.isElementPresentFast("WOSubmitValidationMsg2"))
			{
				selenium.test.log(LogStatus.PASS, "The expected validation message appeared");
				System.out.println("PASS");	
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The expected validation message did not appear");
				selenium.reportFailure("The expected validation message did not appear");
				System.out.println("FAIL");
			}
			selenium.click("WOSubmitValidationMsgFinishBtn");
			selenium.waitingTime(4000);			
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while validating the error messages");
			selenium.reportFailure("Error while validating the error messages " + e.getMessage());
		}
	}
	
	@And("add PD Usage Summary and Presentation type details")
	public void add_PD_Usage_Summary_and_Presentation_type_details() {
		try {
			/*Add Presentation Type Details*/
			selenium.waitForElementToBeClickable("editL");
			selenium.jsClick("editL");
			selenium.waitingTime(6000);
			selenium.scrollToElement("PresentationTypeDrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("PresentationTypeDrpDwn");
			selenium.waitForElementToBeClickable("PresentationTypeValue");
			selenium.jsClick("PresentationTypeValue");
			selenium.typeData("ExhibitorConferenceDetailsField", "Test");
			selenium.typeData("DistrictMeetingTypeField", "Test");
			selenium.typeData("PresentationTypeSupportDiemField", "Test");
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(15000);
			
			/*Add PD Usage Summary Details*/
			selenium.waitForElementToBeClickable("AddPDUsageSummaryBtn");
			selenium.click("AddPDUsageSummaryBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(2000);
//			selenium.scrolldown(200);
			selenium.scrollToElement("SelectFirstPDMainAccountCheckbox");
			selenium.waitForElementToBeClickable("SelectFirstPDMainAccountCheckbox");
			selenium.click("SelectFirstPDMainAccountCheckbox");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(6000);
			
			/*Verify PD Usage Summaries*/
			selenium.waitForElementToBeClickable("PDUsageSummariesPanel");
			selenium.scrollToElement("PDUsageSummariesPanel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("DaysAllocated") && selenium.isElementPresentFast("DaysScheduled") && selenium.isElementPresentFast("DaysConsumed")) {
				selenium.test.log(LogStatus.PASS, "Verify PD Usage Summary");
				System.out.println("PASS");		
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Unable to verify PD Usage Summary");
				selenium.reportFailure("Unable to verify PD Usage Summary");
				System.out.println("FAIL");
			}	
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while adding data");
			selenium.reportFailure("Error while adding data " + e.getMessage());
		}
	}
	
	@And("Submit WO and validate the WO status and owner")
	public void Submit_WO_and_validate_the_WO_status_and_owner() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SubmitWOBtn");
			selenium.jsClick("SubmitWOBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubmitButton");
			selenium.jsClick("SubmitButton");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Status_GetText");
			String WOStatus = selenium.getText("Status_GetText");
			System.out.println("WOStatus is "+ WOStatus );
			if(WOStatus.equalsIgnoreCase("Submitted")) {
				selenium.test.log(LogStatus.PASS, "WO status has been changed to Submitted");
				System.out.println("PASS");		
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "WO status did not change to Submitted");
				selenium.reportFailure("WO status did not change to Submitted");
				System.out.println("FAIL");
			}
//			selenium.closeSubTabs();
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while validating the Workorder data");
			selenium.reportFailure("Error while validating the Workorder data" + e.getMessage());
		}
	}
	
	@Then("On the next page validate Service Appointment is Created")
	public void on_the_next_page_validate_service_appointment_is_created() {
		try {
			selenium.takeScreenShot();
			String expected = null;
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale"))
			{
				expected = selenium.getTestDataFromPropertiesFile("AppointmentWillCreatedMessage2");
			}
			else
			{
				expected = selenium.getTestDataFromPropertiesFile("AppointmentWillCreatedMessage");
			}

			String actual = selenium.getElement("AppointementWillCreateText").getText();
			assertTrue(actual.contains(expected));
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the Service appointment is created or not " + e.getMessage());
		}
	}
	
	@Then("On the next page validate PD Days is Created")
	public void on_the_next_page_validate_PD_Days_is_created() {
		try {
			String expected = selenium.getTestDataFromPropertiesFile("AppointmentCreatedPDDaysMessage");
			String actual = selenium.getElement("AppointmentCreatedPDDaysText").getText();
			assertTrue(actual.contains(expected));
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale"))
			{
				selenium.click("PDAddLaterRadioBtn");
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KScheduler_AutoScheduleServiceResourceToSA")||selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView")) {
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);			
			selenium.waitForElementToBeClickable("SelectAccountForPDDays2");
			selenium.jsClick("SelectAccountForPDDays2");		
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the PD Days is created or not " + e.getMessage());
		}
	}
	
	@Then("On the next page validate non-billable appointments")
	public void on_the_next_page_validate_nonbillable_appointments() {
		try {
			selenium.waitForElementToBeClickable("YesRadio");
			selenium.jsClick("YesRadio");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			String expected = selenium.getTestDataFromPropertiesFile("NonBillableAppointmentYESPanel");
			String actual = selenium.getElement("AppointmentExcludeFromPDsText").getText();
			System.out.println("expected-->" + expected);
			System.out.println("actual-->" + actual);
			assertTrue(actual.contains(expected));
			selenium.waitForElementToBeClickable("NoRadio");
			selenium.jsClick("NoRadio");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
//			System.out.println("OUtput" + selenium.IsCheckBoxSelected("AccountWithPDDaysAvailable"));
			if(selenium.isElementPresentFast("MoreThanOnePDaccountCBox"))
			{
				System.out.println("More than one account is there and we are selecting one out of it");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("AccountWithPDDaysAvailable");		//when more than one account is there, selecting 2nd PD account check box
				selenium.jsClick("AccountWithPDDaysAvailable");
			}
			else if(selenium.IsCheckBoxSelected("AccountWithPDDaysAvailable")==false)
			{
				System.out.println("Only one account is there and it is not selected, so we are selecting it");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("AccountWithPDDaysAvailable");	//when only one account is there, selecting that using select all check box
				selenium.jsClick("AccountWithPDDaysAvailable");
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the PD Days is created or not " + e.getMessage());
		}
	}
	
	@Then("On the next page validate Service Appointment is not Created")
	public void on_the_next_page_validate_service_appointment_is_not_created() {
		try {
			selenium.takeScreenShot();
			String expected = selenium.getTestDataFromPropertiesFile("AppointmentWillNotBeCreatedMessage");
			String actual = selenium.getElement("GetCurrentValidationMsg").getText();
			assertTrue(actual.contains(expected));
			selenium.waitForElementToBeClickable("NoRadio");
			selenium.jsClick("NoRadio");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);		
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the Service appointment is created or not " + e.getMessage());
		}
	}
	
	@Then("Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment")
	public void validate_when_click_on_open_new_service_appointment_button_it_navigate_you_to_the_newly_created_service_appointment() {
		try {
			
			String expected1 = null;
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale"))
			{
				expected1 = selenium.getTestDataFromPropertiesFile("AppointmentCreatedText2");
			}
			else
			{
				expected1 = selenium.getTestDataFromPropertiesFile("AppointmentCreatedText");
			}
			String actual1 = selenium.getElement("AppointmentCreatedText").getText();
			assertTrue(actual1.contains(expected1));
			selenium.waitingTime(8000);
			selenium.takeScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpenServiceAppointmentButton");
			selenium.jsClick("OpenServiceAppointmentButton");
			selenium.waitingTime(8000);
			selenium.takeScreenShot();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Service Appointment has been created for Work order line item");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Opening  a new service appointment all the required details " + e.getMessage());
		}
	}
	
	@And("open the new service appointment")
	public void open_the_new_service_appointment() {
		try {
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(5000);
			selenium.ServiceAppointmentURL = selenium.getURL();
			System.out.println("ServiceAppointmentURL is --> " + selenium.ServiceAppointmentURL);
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_Other") || selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_PostSale")) {
				selenium.SAURL = selenium.getURL();
				System.out.println("SAURL is --> " + selenium.SAURL);
				selenium.SA_Num = selenium.getText("SA_Number");
				System.out.println("Service Appointment Nuber is -->" + selenium.SA_Num);
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while Opening the new service appointment");
			selenium.reportFailure("Error while Opening the new service appointment " + e.getMessage());
		}
	}
	
	@And("validate service resource got assigned")
	public void validate_service_resource_got_assigned() {
		try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("Status_GetText");			
			String SAStatus = selenium.getText("Status_GetText");
			System.out.println("SAStatus is" + SAStatus);
			
			if(selenium.isElementPresentFast("SAServiceResourceAdded") && SAStatus.equalsIgnoreCase("Dispatched"))
			{
				selenium.test.log(LogStatus.PASS, "The Service Resource has been assigned to SA & status has been changed to Dispatched");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.waitingTime(15000);	//waiting for 15 more seconds
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("Status_GetText");
				SAStatus = selenium.getText("Status_GetText");
				System.out.println("SAStatus is" + SAStatus);
				if(selenium.isElementPresentFast("SAServiceResourceAdded") && SAStatus.equalsIgnoreCase("Dispatched"))
				{
					selenium.test.log(LogStatus.PASS, "The Service Resource has been assigned to SA & status has been changed to Dispatched");
					System.out.println("PASS");		
					selenium.takeScreenShot();
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Either Service Resource did not get added to SA or status did not changed to Dispatched");
					selenium.reportFailure("Either Service Resource did not get added to SA or status did not changed to Scheduled");
					System.out.println("FAIL");
				}
			}
			
			/*Unassign the service appointment for next automation test cycle*/
			selenium.click("ShowAssignedResourceInSAArrowBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitForElementToBeVisible("DeleteConfirmationButton");
			selenium.jsClick("DeleteConfirmationButton");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while Opening the new service appointment");
			selenium.reportFailure("Error while Opening the new service appointment " + e.getMessage());
		}
	}
	
	@And("validate service resource got auto assigned")
	public void validate_service_resource_got_auto_assigned() {
		try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("Status_GetText");			
			String SAStatus = selenium.getText("Status_GetText");
			System.out.println("SAStatus is" + SAStatus);
			
			if(selenium.isElementPresentFast("SAServiceResourceAdded") && SAStatus.equalsIgnoreCase("Dispatched"))
			{
				selenium.test.log(LogStatus.PASS, "The preferred/required Service Resource has been auto assigned to SA & status has been changed to Dispatched");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.waitingTime(15000);	//waiting for 15 more seconds
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("Status_GetText");
				SAStatus = selenium.getText("Status_GetText");
				System.out.println("SAStatus is" + SAStatus);
				if(selenium.isElementPresentFast("SAServiceResourceAdded") && SAStatus.equalsIgnoreCase("Dispatched"))
				{
					selenium.test.log(LogStatus.PASS, "The preferred/required Service Resource has been auto assigned to SA & status has been changed to Dispatched");
					System.out.println("PASS");		
					selenium.takeScreenShot();
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Either Service Resource did not get added to SA or status did not changed to Dispatched");
					selenium.reportFailure("Either Service Resource did not get added to SA or status did not changed to Scheduled");
					System.out.println("FAIL");
				}
			}
			if(selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView"))
			{
				selenium.waitForElementToBeClickable("AssignedResourceNameLink");
				selenium.jsClick("AssignedResourceNameLink");
				selenium.waitingTime(8000);
				selenium.scrolldown(5000);
				selenium.waitingTime(20000);
				selenium.switchToFrame("FSL_Iframe");
				selenium.waitingTime(2000);
				selenium.switchToFrame("FSL_Iframe");
				selenium.waitingTime(2000);
				selenium.scrollToElement("SAAssignedResourceColor");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SAAssignedResourceColor");
				selenium.mouseHover("SAAssignedResourceColor");
				Assert.assertTrue(selenium.isElementPresentFast("HoverWorkOrderType")&&selenium.isElementPresentFast("HoverOnline_Onsite")&&
						selenium.isElementPresentFast("HoverSubject")&&selenium.isElementPresentFast("HoverScheduledStart")&&
						selenium.isElementPresentFast("HoverScheduledEnd")&&selenium.isElementPresentFast("HoverAccountID"));
				System.out.println("PASS");
			}
			else {
				/*Unassign the service appointment for next automation test cycle*/
				selenium.click("ShowAssignedResourceInSAArrowBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("DeleteRecord");
				selenium.jsClick("DeleteRecord");
				selenium.waitForElementToBeVisible("DeleteConfirmationButton");
				selenium.jsClick("DeleteConfirmationButton");
				selenium.waitingTime(10000);
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while Opening the new service appointment");
			selenium.reportFailure("Error while Opening the new service appointment " + e.getMessage());
		}
	}
	
	@And("unassign service resource for next test cycle")
	public void unassign_service_resource_for_next_test_cycle() {
		try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("ShowAssignedResourceInSAArrowBtn");
			
			/*Unassign the service appointment for next automation test cycle*/
			selenium.click("ShowAssignedResourceInSAArrowBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitForElementToBeVisible("DeleteConfirmationButton");
			selenium.jsClick("DeleteConfirmationButton");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while Opening the new service appointment");
			selenium.reportFailure("Error while Opening the new service appointment " + e.getMessage());
		}
	}
	
	@And("open the new work order")
	public void open_the_new_work_order() {
		try {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/o/WorkOrder/list?filterName=Recent");
			selenium.waitingTime(8000);
			String Xpath = selenium.getDynamicXpath_data("NewWOLinkStart",NewWONumber,"end");
			if(selenium.isElementPresentXpathFast(Xpath))
			{
				selenium.clickXpath(Xpath);
			}
			else
			{
				selenium.click("WONameColumn");
				selenium.waitingTime(5000);
				selenium.clickXpath(Xpath);
			}
		selenium.waitingTime(5000);
		WorkOrderURL = selenium.getURL();
		System.out.println("WorkOrderURL is " + WorkOrderURL);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while Opening the new work order");
			selenium.reportFailure("Error while Opening the new work order " + e.getMessage());
		}
	}
	
	@Then("Validate the Records are created")
	public void validate_the_records_are_created() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("ParentRecordLink");
			selenium.jsClick("ParentRecordLink");
			selenium.waitingTime(5000);
			selenium.isElementPresentFast("ParentRecordLink");
			selenium.isElementPresentFast("WorkActivitiesLink");
			selenium.isElementPresentFast("ResourcePreferenceLink");
			selenium.isElementPresentFast("ServiceAppointmentLink");
			selenium.isElementPresentFast("WorkPlansLink");
			selenium.waitForElementToBeClickable("WorkOrderLink");
			selenium.jsClick("WorkOrderLink");
			selenium.isElementPresentFast("WorkOrderLineItemsLinkWO");
			selenium.isElementPresentFast("AppointmentDatesLinkWO");
			selenium.isElementPresentFast("WorkActivitiesLinkWO");
			selenium.isElementPresentFast("WorkPlanLinkWO");
			selenium.isElementPresentFast("WorkStepsLinkWO");
			selenium.isElementPresentFast("ResourcePreferenceLinkWO");
			selenium.isElementPresentFast("ServiceAppointmentsLinkWO");
			selenium.isElementPresentFast("WorkOrderHistoryLinkWO");
			selenium.isElementPresentFast("OpportunitiesLinkWO");
			selenium.waitingTime(5000);
			if(selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_PostSale"))
			{
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.scrolldown(-5000);
				if (selenium.isElementPresentFast("ConsultantNeededFSL") &&
						selenium.isElementPresentFast("NumberOfParticipantsFSL") &&
					selenium.isElementPresentFast("AirportNameFSL") &&
//						selenium.isElementPresentFast("AirportCity_StateSL") &&
					selenium.isElementPresentFast("TravelTimeFSL") &&
						selenium.isElementPresentFast("PresentationTypeFSL"))
				{
					System.out.println("Fields are present");
					selenium.test.log(LogStatus.PASS, "Fields are present");
				} else
				{
					System.out.println("Fields are not present");
					selenium.test.log(LogStatus.FAIL, "Fields are not present");
					selenium.reportFailure("Fields are not present");
				}
			}
			WorkOrderURL = selenium.getURL();
			System.out.println("WorkOrderURL is " + WorkOrderURL);
			
			NewWONumber = selenium.getText("GetWONumber");
			System.out.println("NewWONumber is " + NewWONumber);
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the records are created" + e.getMessage());
		}
	}
	
	@When("User click on Clone work order button")
	public void user_click_on_clone_work_order_button() {
	   try {
		    selenium.navigateToURL(WorkOrderURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CloneWorkOrder");
			selenium.takeScreenShot();
			selenium.jsClick("CloneWorkOrder");
			selenium.waitingTime(5000);
	   }
	   catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Clicking on Clone Work Order Button" + e.getMessage());
		}
	   
	}
	
	@Then("Validate Clone Work Order Message")
	public void validate_clone_work_order_message() {
	try{
		selenium.takeScreenShot();
		String expected1 = selenium.getTestDataFromPropertiesFile("CloneWorkOrderMessage1");
		System.out.println("Expected 1 -->"+expected1);
		String actual1 = selenium.getElement("CloneWorkOrderMessage1").getText();
		System.out.println("actual 1 -->"+actual1);
		assertTrue(actual1.contains(expected1));
		String expected2= selenium.getTestDataFromPropertiesFile("CloneWorkOrderMessage2");
		System.out.println("Expected 2 -->"+expected2);
		String actual2 = selenium.getElement("CloneWorkOrderMessage2").getText();
		System.out.println("actual 2 -->"+expected2);
		assertTrue(actual2.contains(expected2));
		
} catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error while Validating the records are created" + e.getMessage());
	}
	}
	@Then("Navigate to Cloned Work Order")
	public void navigate_to_cloned_work_order() {
		try{
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("ClickHereToViewNewWorkOrder");
			selenium.jsClick("ClickHereToViewNewWorkOrder");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while Validating the records are created" + e.getMessage());
		}
	}
	
	@And("^create Work Order by filling mandatory fields A3KScheduler$")
	public void create_work_order_by_filling_mandatory_fields_A3KScheduler() {
		try {
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Targetted_District");
			selenium.autoSuggestiveDropdownWithoutText("Targetted_District");
			selenium.waitForElementToBeClickable("Contact");
			selenium.autoSuggestiveDropdownWithoutText("Contact");
			selenium.waitForElementToBeClickable("ServiceTerritory");
			selenium.typeData("ServiceTerritory", "A3K");
			selenium.waitingTime(3000);
			selenium.autoSuggestiveDropdownWithoutText("ServiceTerritory");
			selenium.waitForElementToBeClickable("Type_DropDown");
			selenium.autoSuggestiveDropdownWithoutText("Type_DropDown");
			selenium.waitForElementToBeClickable("Online_OfflineNew");
			selenium.autoSuggestiveDropdownWithoutText("Online_OfflineNew");
			selenium.waitForElementToBeClickable("Subject");
			selenium.getElement("Subject").sendKeys("Testing FSL");
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);			
			
			selenium.waitForElementToBeClickable("ConsultantNeededTextBox");
			selenium.typeData("ConsultantNeededTextBox","1");
			selenium.waitForElementToBeClickable("NumberOfParticipantsTextBox");
			selenium.typeData("NumberOfParticipantsTextBox","1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PresentationTypeDropDwn");
			selenium.jsClick("PresentationTypeDropDwn");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_PostSale") || selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale") || selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView") || selenium.getTestCaseName().equalsIgnoreCase("FSLA3KScheduler_AutoScheduleServiceResourceToSA"))
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption");
				selenium.jsClick("PresentationTypeOption");
				selenium.waitingTime(2000);
			}
			else
			{
				selenium.waitForElementToBeClickable("PresentationTypeOption1");
				selenium.jsClick("PresentationTypeOption1");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("FSL_DistrictMeetingType");
				selenium.typeData("FSL_DistrictMeetingType", "AutomationTest");
			}
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("SelectSecondOppForWO"))
			{
				System.out.println("Selecting the second opp in the list..");
				selenium.scrollToElement("SelectSecondOppForWO");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.click("SelectSecondOppForWO");
				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(5000);
			}
			
			selenium.waitForElementToBeClickable("SelectAddress");
			selenium.autoSuggestiveDropdownWithoutText("SelectAddress");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TextEntryField");
			selenium.getElement("TextEntryField").sendKeys("BuildingName FSL");
			selenium.waitForElementToBeClickable("RoomName");
			selenium.getElement("RoomName").sendKeys("RoomName FSL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeClickable("PreferredServiceResources");
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KScheduler_AutoScheduleServiceResourceToSA")||selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView")) {
				selenium.typeData("PreferredServiceResources", "Mai Sidawi"); //Assigning Service Resource who is available for auto assignment to SA
				selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			}
			else
			{
				selenium.waitingTime(3000);
				selenium.typeData("PreferredServiceResources", "Jennifer Cook"); //This User(SR) should be Active
				selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			}
			selenium.waitingTime(5000);
			selenium.jsClick("PreferenceType");
			System.out.print("Preference Type --> Clicked");
			Select dropdown_value = new Select(selenium.getElement("PreferenceType"));
			dropdown_value.selectByIndex(2);
			selenium.waitForElementToBeClickable("WorkTypeCheckBox");
			selenium.jsClick("WorkTypeCheckBox");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("WorkPlanTypeCheckBox"))
			{
				selenium.waitForElementToBeClickable("WorkPlanTypeCheckBox");
				selenium.jsClick("WorkPlanTypeCheckBox");
				selenium.waitForElementToBeClickable("Next_Btn");
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(15000);
			}

			/*selenium.waitForElementToBeClickable("FSL_WODateTypes");
			selenium.click("FSL_WODateTypes");
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KScheduler_AutoScheduleServiceResourceToSA") || selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerCreateWO_PostSale")||selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView")) {
				selenium.typeData("NuberOfTrainersRequiredField", "1");
			}
			else {
				selenium.typeData("NuberOfTrainersRequiredField", "3");
			}

			selenium.waitForElementToBeClickable("EarliestStartTimeField");
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KScheduler_AutoScheduleServiceResourceToSA")||selenium.getTestCaseName().equalsIgnoreCase("SA_IsHoveredInResourceView")) {
				selenium.getElement("EarliestStartTimeField").sendKeys(selenium.getFutureDate(-14));
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DueDateField");
				selenium.getElement("DueDateField").sendKeys(selenium.getFutureDate(14));
			}
			else {
				selenium.getElement("EarliestStartTimeField").sendKeys(selenium.getFutureDate(14));
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DueDateField");
				selenium.getElement("DueDateField").sendKeys(selenium.getFutureDate(14));
			}
			selenium.waitingTime(2000);
			selenium.click("NuberOfTrainersRequiredField");
			selenium.waitingTime(2000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(15000);*/
			
			selenium.waitForElementToBeClickable("Preferred_AlternateDateTypes");
			selenium.jsClick("Preferred_AlternateDateTypes");
			selenium.waitForElementToBeClickable("TextEntryField");
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale"))
			{
				selenium.getElement("TextEntryField").sendKeys("3");
				System.out.print("Trainer Value 3.");
			}
			else
			{
				selenium.getElement("TextEntryField").sendKeys("1");
				System.out.print("Trainer Value 1");
			}

			// pref date
			selenium.waitForElementToBeClickable("Preferred_StartDate");
			selenium.getElement("Preferred_StartDate").sendKeys(selenium.getFutureDate(1));
			selenium.waitForElementToBeClickable("Preferred_EndDate");
			selenium.getElement("Preferred_EndDate").sendKeys(selenium.getFutureDate(2));
			selenium.waitForElementToBeVisible("DateTime_Confirmed_Dropdown");
			Select dateTimeConfirmedDropdown = new Select(selenium.getElement("DateTime_Confirmed_Dropdown"));
			dateTimeConfirmedDropdown.selectByIndex(1);
			// alt date 1
			selenium.waitForElementToBeClickable("Alternate1_StartDate");
			selenium.getElement("Alternate1_StartDate").sendKeys(selenium.getFutureDate(7));
			selenium.waitForElementToBeClickable("Alternate1_EndDate");
			selenium.getElement("Alternate1_EndDate").sendKeys(selenium.getFutureDate(8));
			selenium.waitForElementToBeVisible("DateTime_Alt1_Dropdown");
			Select dateTimeAlternateDropdown1 = new Select(selenium.getElement("DateTime_Alt1_Dropdown"));
			dateTimeAlternateDropdown1.selectByIndex(1);
			// alt date 2
			selenium.waitForElementToBeClickable("Alternate2_StartDate");
			selenium.getElement("Alternate2_StartDate").sendKeys(selenium.getFutureDate(11));
			selenium.waitForElementToBeClickable("Alternate2_EndDate");
			selenium.getElement("Alternate2_EndDate").sendKeys(selenium.getFutureDate(12));
			selenium.waitForElementToBeVisible("DateTime_Alt2_Dropdown");
			Select dateTimeAlternateDropdown2 = new Select(selenium.getElement("DateTime_Alt2_Dropdown"));
			dateTimeAlternateDropdown2.selectByIndex(1);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("WorkPlanTypeCheckBox");
			selenium.jsClick("WorkPlanTypeCheckBox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(15000);
			
			if (selenium.getTestCaseName().equalsIgnoreCase("FSLA3KSchedulerManageWO_PostSale"))	//workaround for UAT bug. After bug fix, we should remove this if block
			{
				selenium.clearText("TextEntryField");
				selenium.waitingTime(1000);
				selenium.getElement("TextEntryField").sendKeys("3");
				System.out.print("Trainer Value 3");
			}

			if (!selenium.getTestCaseName().equalsIgnoreCase("FSLMHSchedulerCreateWO_Others")) {
			selenium.waitForElementToBeClickable("AlternateDateCheckbox");
			selenium.jsClick("AlternateDateCheckbox");
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("PreferredResourceDrpDwn"))
			{
				Select dropdown = new Select(selenium.getElement("PreferredResourceDrpDwn"));
				dropdown.selectByIndex(1);
				selenium.waitingTime(2000);
				selenium.jsClick("Next_Btn");
				selenium.waitingTime(10000);
			}
			selenium.waitForElementsToBeVisible("AddMoreAppointementNoRadio");
			selenium.jsClick("AddMoreAppointementNoRadio");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
	}
	
	@And("open PD Usage related list in Service Appointment")
	public void open_PD_Usage_related_list_in_Service_Appointment() {
		try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(5000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("PDUsageServiceLink");
			selenium.jsClick("PDUsageServiceLink");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while opening PD Usage related list in SA");
			selenium.reportFailure("Error while opening PD Usage related list in SA " + e.getMessage());
		}
	}
	
	@And("click on PD Service and validate PD Usage Summary")
	public void click_on_PD_Service_and_validate_PD_Usage_Summary() {
		try {
			selenium.waitingTime(8000);
			selenium.scrolldown(1000);
			selenium.waitingTime(2000);
			selenium.scrollToElement("PDUsageSummaryLink");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PDUsageSummaryLink");
			selenium.clickLoop("PDUsageSummaryLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("PDUsageSummaryViewAll");
			selenium.jsClick("PDUsageSummaryViewAll");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);

			String rowXpath = selenium.getDynamicXpath_data("PDDaysAllowed_Start", NewWONumber, "end");
			if(!selenium.isElementPresentXpathFast(rowXpath))
			{
				System.out.println("Unable to find WO name under PD Usage Summary. So, flipping record list order..");
				selenium.waitForElementToBeClickable("WOColumnInPDUsageSummaries");
				selenium.jsClick("WOColumnInPDUsageSummaries");
				selenium.waitingTime(5000);
			}
			
			String xpath = selenium.getDynamicXpathData("PDDaysAllowed_Start", NewWONumber, "PDDaysAllowed_End");
			System.out.println("xpath is"+ xpath);
//			selenium.scrolldown(100);
//			selenium.waitingTime(1000);
			selenium.scrollToXpathElement(xpath);
			selenium.waitingTime(2000);
			String actualPDDays = selenium.getDynamicText(xpath);
			System.out.println("actualPDDays" + actualPDDays);
			if(actualPDDays.equalsIgnoreCase("1.000"))
			{
				selenium.test.log(LogStatus.PASS, "The Allowed PD Days is equal 1.000!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("The Allowed PD Days is NOT equal 1.000!");
				selenium.test.log(LogStatus.FAIL, "The Allowed PD Days is NOT equal 1.000!");
				System.out.println("FAIL");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying PD Usage Summary data");
			selenium.reportFailure("Error while verifying PD Usage Summary data " + e.getMessage());
		}
	}
	
	@And("Validate Manage Hold functionality when SA has no PD Days")
	public void Validate_Manage_Hold_functionality_no_PD() {
		try {
			/*Adding Service Resource to SA & changing status to OnHold*/
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SAManageHoldBtn");
			selenium.takeScreenShot();
			selenium.jsClick("SAManageHoldBtn");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("PreferredServiceResources")==true)	//if SR auto assigned then this field will be auto filled
			{
				System.out.println("SR not auto assigned..");
				selenium.waitForElementToBeClickable("PreferredServiceResources");
				selenium.autoSuggestiveDropdownWithoutText("PreferredServiceResources");
			}
			selenium.takeScreenShot();
			selenium.waitingTime(2000);
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("WOSubmitValidationMsgFinishBtn");
			selenium.jsClick("WOSubmitValidationMsgFinishBtn");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Status_GetText");			
			String SAStatus = selenium.getText("Status_GetText");
			System.out.println("SAStatus is" + SAStatus);
			
			if( SAStatus.equalsIgnoreCase("On Hold")) //selenium.isElementPresentFast("SAServiceResourceAdded") &&
			{
				selenium.test.log(LogStatus.PASS, "Status has been changed to ON HOLD");
				System.out.println("PASS");			
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Status did not changed to ON HOLD");
				selenium.reportFailure("Status did not changed to ON HOLD");
				System.out.println("FAIL");
			}
			
			/*Trying to remove OnHold status when no PD Days are added to SA*/
			selenium.waitForElementToBeClickable("SAManageHoldBtn");
			selenium.jsClick("SAManageHoldBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("RemoveHoldOption1");
			selenium.jsClick("RemoveHoldOption1");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
			
			selenium.takeScreenShot();
			String expected = selenium.getTestDataFromPropertiesFile("Message_PDUsageRequired");
			String actual = selenium.getElement("GetCurrentValidationMsg").getText();
			assertTrue(actual.contains(expected));
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitForElementToBeClickable("WOSubmitValidationMsgFinishBtn");
			selenium.jsClick("WOSubmitValidationMsgFinishBtn");
			selenium.waitingTime(5000);
			
			/*Add PD Days to SA*/
			selenium.waitForElementToBeClickable("AddSplitPDDaysBtn");
			selenium.jsClick("AddSplitPDDaysBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectAccountForPDDays");
			selenium.jsClick("SelectAccountForPDDays");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(5000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while validating Manage Hold functionality");
			selenium.reportFailure("Error while validating Manage Hold functionality " + e.getMessage());
		}
	}
	
	@And("Validate Manage Hold functionality when SA has PD Days")
	public void Validate_Manage_Hold_functionality_has_PD() {
		try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SAManageHoldBtn");
			selenium.jsClick("SAManageHoldBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("RemoveHoldOption1");
			selenium.jsClick("RemoveHoldOption1");
			selenium.waitingTime(3000);
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(3000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("WOSubmitValidationMsgFinishBtn");
			selenium.jsClick("WOSubmitValidationMsgFinishBtn");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("Status_GetText");			
			String SAStatus = selenium.getText("Status_GetText");
			System.out.println("SAStatus is" + SAStatus);
			
			if(SAStatus.equalsIgnoreCase("Dispatched")) //selenium.isElementPresentFast("SAServiceResourceAdded") && 
			{
				selenium.test.log(LogStatus.PASS, "Status has been changed to Dispatched");
				System.out.println("PASS");				
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Status did not changed to Dispatched");
				selenium.reportFailure("Status did not changed to Dispatched");
				System.out.println("FAIL");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while validating Manage Hold functionality");
			selenium.reportFailure("Error while validating Manage Hold functionality " + e.getMessage());
		}
	}
	
	@And("add Work order line item for work order")
	public void add_Work_order_line_item_for_work_order() {
		try {
			selenium.navigateToURL(selenium.PostSalesWorkOrderURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("AddWOLIActionBtn");
			selenium.jsClick("AddWOLIActionBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("WorkTypeRadioBtninWOLI");
			selenium.jsClick("WorkTypeRadioBtninWOLI");
			selenium.waitingTime(2000);
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.jsClick("Next_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Successfully added Work order line item for work order");
			selenium.takeScreenShot();
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while adding Work order line item for work order");
			selenium.reportFailure("Error while adding Work order line item for work order " + e.getMessage());
		}
	}
	
	@Then("login into experience cloud application")
	public void login_into_experience_cloud_application() {
		try {
			selenium.navigateToURL_propertiesFile("ExperienceCloudURL");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("XP_UserName");
			selenium.type_propertiesFile("XP_UserName", "XP_UserName");
			selenium.type_propertiesFile("XP_Password", "XP_Password");
			selenium.takeScreenShot();
			selenium.click("XP_LoginBtn");
			selenium.waitingTime(5000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while logging into experience cloud application");
			selenium.reportFailure("Error while logging into experience cloud application " + e.getMessage());
		}
	}
	
	@And("verify all the experience cloud components")
	public void verify_all_the_experience_cloud_components() {
		try {
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("HomeLink");
			if(selenium.isElementPresentFast("HomeLink") && selenium.isElementPresentFast("MyAppointmentsLink") && selenium.isElementPresentFast("ProfileLink") && selenium.isElementPresentFast("SearchIcon") && selenium.isElementPresentFast("NotificationBellIcon") && selenium.isElementPresentFast("ProfileIcon") && selenium.isElementPresentFast("CalendarLink") && selenium.isElementPresentFast("CreateEventPanel"))
			{
				selenium.test.log(LogStatus.PASS, "All expected componets are exist");
				System.out.println("PASS");			
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "One or more components are missing");
				selenium.reportFailure("One or more components are missing");
				System.out.println("FAIL");
			}
			
			String expected = selenium.getTestDataFromPropertiesFile("ContentTitleText");
			String actual = selenium.getElement("ContentTitle").getText();
			System.out.println("Expected Title --> "+expected);
			System.out.println("Actual Title --> "+actual);
			assertTrue(actual.contains(expected));
			String expected1 = selenium.getTestDataFromPropertiesFile("ContentSubTitleText");
			String actual1 = selenium.getElement("ContentSubtitle").getText();
			System.out.println("Expected SubTitle --> "+expected1);
			System.out.println("Actual SubTitle --> "+actual1);
			Assert.assertEquals(actual1,expected1);
			
			selenium.jsClick("MyAppointmentsLink");	//make sure by default it opens up recently view list (pinned) or else check data under All Service Appointment List view
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("PerDiemListviewDownArrow");
//			selenium.click("PerDiemListviewDownArrow");
//			selenium.waitForElementToBeClickable("AllServiceAppointmentListviewOption");
//			selenium.click("AllServiceAppointmentListviewOption");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("XP_ServiceAppointmentList");
			
			if(selenium.isElementPresentFast("XP_ServiceAppointmentList"))
			{
				selenium.test.log(LogStatus.PASS, "List of service appointments exist under My Appointment page");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Data missing");
				selenium.reportFailure("Data missing");
				System.out.println("FAIL");
			}
			
			selenium.jsClick("ProfileLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("XP_ServiceAppointmentUserName");
			selenium.jsClick("XP_ServiceAppointmentUserName");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("MyProfile_InformationSection");
			if(selenium.isElementPresentFast("MyProfile_InformationSection") && selenium.isElementPresentFast("MyProfile_ContactInfoSection") && selenium.isElementPresentFast("MyProfile_AbsencesRelatedList") && selenium.isElementPresentFast("MyProfile_ServiceResourceSkillsRelatedList") && selenium.isElementPresentFast("MyProfile_ServiceTerritoriesRelatedList") && selenium.isElementPresentFast("MyProfile_ServiceAppointmentRelatedList"))
			{
				selenium.test.log(LogStatus.PASS, "All expected componets are exist under My Profile page");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "One or more components are missing under My Profile page");
				selenium.reportFailure("One or more components are missing under My Profile page");
				System.out.println("FAIL");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying experience cloud application components");
			selenium.reportFailure("Error while verifying experience cloud application components " + e.getMessage());
		}
	}
	
	
	@And("create an absence event and verify calendar")
	public void create_an_absence_event_and_verify_calendar(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("HomeLink");
			
			selenium.typeData("Subject", data.get(0));
			selenium.click("EventTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EventReason");
			selenium.click("EventReason");
			selenium.getElement("EventStartDate").sendKeys(selenium.getFutureDate(0));
			selenium.getElement("EventEndDate").sendKeys(selenium.getFutureDate(1));
			selenium.typeData("SimpleTextAreaField", data.get(1));
			selenium.takeScreenShot();
			selenium.click("NxtButton");
			selenium.waitingTime(20000);
			if(selenium.isElementPresentFast("EventCreatedMsg"))
			{
				selenium.test.log(LogStatus.PASS, "Absence event got created successfully");
				System.out.println("PASS");
				selenium.takeScreenShot();
				selenium.click("FinishButton");
				selenium.waitingTime(4000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Event creation failed.");
				selenium.reportFailure("Event creation failed.");
				System.out.println("FAIL");
			}
			
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("EventLinkInsideCalendar");
			
			if(selenium.isElementPresentFast("EventLinkInsideCalendar"))
			{
				selenium.test.log(LogStatus.PASS, "Newly created event is getting display in Calendar");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Newly created event is not getting display in Calendar");
				selenium.reportFailure("Newly created event is not getting display in Calendar");
				System.out.println("FAIL");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while creating absence event using Create Event component");
			selenium.reportFailure("Error while creating absence event using Create Event component " + e.getMessage());
		}
	}
	
	@And("update the service appointment status")
	public void update_the_service_appointment_status() {
		try {
			
			selenium.jsClick("MyAppointmentsLink"); //make sure by default it opens up recently view list (pinned) or else check data under All Service Appointment List view
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("PerDiemListviewDownArrow");
//			selenium.click("PerDiemListviewDownArrow");
//			selenium.waitForElementToBeClickable("AllServiceAppointmentListviewOption");
//			selenium.click("AllServiceAppointmentListviewOption");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SA_StatusColumn");
			selenium.jsClick("SA_StatusColumn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SA_FirstSARecordLink");
			selenium.jsClick("SA_FirstSARecordLink");
//			selenium.navigateToURL("https://mh--uat.sandbox.my.site.com/training/s/detail/08p8b000000o6mFAAQ");
			//We need SA with In-Progress status to test this TC. Also, once we change the status to Complete/Cannot Complete then we cannot change it's status. So, we are skipping these 2 conditions.
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Edit_StatusBtn");
			selenium.jsClick("Edit_StatusBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SA_StatusDrpDwn");
			selenium.jsClick("SA_StatusDrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SA_StatusInProgress");
			selenium.jsClick("SA_StatusInProgress");
			selenium.takeScreenShot();
			selenium.jsClick("RecordSaveButton");
			selenium.waitingTime(8000);			
			selenium.refresh();
			selenium.waitingTime(6000);
			if(selenium.isElementPresentFast("RecordSaveButton"))
			{
				selenium.reportFailure("SA status update failed!");
				selenium.test.log(LogStatus.FAIL, "SA status update failed!");
				System.out.println("FAIL");
			}
			else
			{
				selenium.test.log(LogStatus.PASS, "SA status updated successfully!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while updating service appointment status");
			selenium.reportFailure("Error while updating service appointment status " + e.getMessage());
		}
	}
	
	
	@And("locate the SR and create absence")
	public void locate_the_SR_and_create_absence(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("SearchSABox");
			selenium.typeData("SearchSABox", data.get(0));
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("SetAbsenceBtn");
			selenium.click("SetAbsenceBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SR_AbsenceReasonbox");
			selenium.typeData("SR_AbsenceReasonbox", data.get(1));
			selenium.waitingTime(5000);
			selenium.pressEscapeKey();
			selenium.waitingTime(5000);
			selenium.dragAnddrop("SR_DragAbsence", "AbsenceTimeBox");
			selenium.waitingTime(10000);
			
			if(selenium.isElementPresentFast("AbsenceEventInsideTimeline"))
			{
				selenium.test.log(LogStatus.PASS, "Absence has been created for Service Resource successfully!");
				System.out.println("PASS");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.waitForElementToBeVisible("newAccountFrame");
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("SearchSABox");
				selenium.typeData("SearchSABox", data.get(0));
				selenium.waitingTime(6000);
				if(selenium.isElementPresentFast("AbsenceEventInsideTimeline"))
				{
					selenium.test.log(LogStatus.PASS, "Absence has been created for Service Resource successfully!");
					System.out.println("PASS");
				}
				else
				{
				selenium.reportFailure("Absence event did not get created");
				selenium.test.log(LogStatus.FAIL, "Absence event did not get created");
				System.out.println("FAIL");
				}
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while creating absence event for a service resource in dispatch console");
			selenium.reportFailure("Error while creating absence event for a service resource in dispatch console " + e.getMessage());
		}
	}
	
	@And("locate the SA and verify the fields")
	public void locate_the_SA_and_verify_the_fields() {
		try {
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("Gantt_SAQuickList");
			selenium.click("Gantt_SAQuickList");
			selenium.waitingTime(2000);
			
			if(selenium.isElementPresentFast("Gantt_SA_Field1") && selenium.isElementPresentFast("Gantt_SA_Field2") && selenium.isElementPresentFast("Gantt_SA_Field3") && selenium.isElementPresentFast("Gantt_SA_Field4") && selenium.isElementPresentFast("Gantt_SA_Field5"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected SA fields are present in Gantt screen!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt screen");
				System.out.println("FAIL");
			}
			
			selenium.click("SRContainer");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SR_RelatedMenu");
			selenium.click("SR_RelatedMenu");			
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SR_CalendarMenu");
			selenium.click("SR_CalendarMenu");			
			selenium.waitingTime(2000);			
			selenium.click("SR_CloseMenuPopup");
			selenium.waitingTime(2000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying service appointment fields in dispatch console");
			selenium.reportFailure("Error while verifying service appointment fields in dispatch console " + e.getMessage());
			selenium.click("SR_CloseMenuPopup");
			selenium.waitingTime(2000);
		}
	}
	
	@And("verify the Gantt filter and fields")
	public void verify_the_Gantt_filter_and_fields() {
		try {
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.click("Gantt_FilterIcon");
			
			if(selenium.isElementPresentFast("Filter_ByHour") && selenium.isElementPresentFast("Gantt_FilterOption1") && selenium.isElementPresentFast("Gantt_FilterOption2") && selenium.isElementPresentFast("Gantt_FilterOption3") && selenium.isElementPresentFast("Gantt_FilterOption4") && selenium.isElementPresentFast("Gantt_FilterOption5"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are present in Gantt screen - Filter option!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen - Filter option");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt screen - Filter option");
				System.out.println("FAIL");
			}
			
			selenium.waitingTime(2000);
			selenium.click("Gantt_FilterOption2");
			
			if(selenium.isElementPresentFast("Filter_ByResource"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are present in Gantt screen - Resources!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen - Resources");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt scree - Resourcesn");
				System.out.println("FAIL");
			}
			
			selenium.waitingTime(2000);
			selenium.click("Gantt_FilterOption3");
			
			if(selenium.isElementPresentFast("Filter_BySkills"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are present in Gantt screen - Skills!");
				System.out.println("PASS");
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen - Skills");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt scree - Skills");
				System.out.println("FAIL");
			}
			
			selenium.waitingTime(2000);
			selenium.click("Gantt_FilterOption5");
			
			if(selenium.isElementPresentFast("Filter_ByPallettes"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are present in Gantt screen - Pallettes!");
				System.out.println("PASS");	
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen - Pallettes");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt scree - Pallettes");
				System.out.println("FAIL");
			}
			
			selenium.waitingTime(2000);
			selenium.click("OpenPalletteEditorBtn");
			selenium.waitingTime(5000);
//			selenium.switchOutOfFrame();
//			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("iframePallette");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewPalletteBtn");
			selenium.click("NewPalletteBtn");
			
			if(selenium.isElementPresentFast("CreatePalletteField1") && selenium.isElementPresentFast("CreatePalletteField2") && selenium.isElementPresentFast("CreatePalletteField3") && selenium.isElementPresentFast("CreatePalletteField4") && selenium.isElementPresentFast("CreatePalletteField5") && selenium.isElementPresentFast("CreatePalletteField6") && selenium.isElementPresentFast("CreatePalletteField7") && selenium.isElementPresentFast("CreatePalletteField8"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are present in Gantt screen - New Pallette Screen!");
				System.out.println("PASS");	
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more fields are missing in Gantt screen - New Pallette Screen");
				selenium.test.log(LogStatus.FAIL, "One of more fields are missing in Gantt scree - New Pallette Screen");
				System.out.println("FAIL");
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying Gantt fields in dispatch console");
			selenium.reportFailure("Error while verifying Gantt fields in dispatch console " + e.getMessage());
			selenium.waitingTime(2000);
		}
	}
	
	@And("verify territories in Gantt")
	public void verify_territories_in_Gantt() {
		try {
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");			
			selenium.waitForElementToBeClickable("TerritoryFilter");

			String terrirotyname = selenium.getText("GanttTerrirotyRow");
			System.out.println("terrirotyname is -->  " + terrirotyname);
			
			selenium.click("TerritoryFilter");
			selenium.waitingTime(6000);
			
			if(selenium.isElementPresentFast("SearchTerritoryFilter") && terrirotyname.contains("Territories"))
			{
				selenium.test.log(LogStatus.PASS, "The territory filter and info is present in Gantt!");
				System.out.println("PASS");		
				selenium.takeScreenShot();
			}
			else
			{
				selenium.reportFailure("One of more expected fields are missing in Gantt screen - Territory");
				selenium.test.log(LogStatus.FAIL, "One of more expected fields are missing in Gantt screen - Territory");
				System.out.println("FAIL");
			}
			
			selenium.click("SelectAllTerritories");
			selenium.waitingTime(2000);
			selenium.click("TerritoriesPopupSaveBtn");
			selenium.waitingTime(10000);
			
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying territories in dispatch console");
			selenium.reportFailure("Error while verifying territories in dispatch console " + e.getMessage());
			selenium.waitingTime(2000);
		}
	}
	
	@And("locate the SA and assign the candidates")
	public void locate_the_SA_and_assign_the_candidates(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(25000);
			selenium.waitForElementToBeVisible("newAccountFrame");
			selenium.switchToFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("SearchSA");
//			selenium.typeData("SearchSA", selenium.SA_Num);
			selenium.typeData("SearchSA", data.get(0));
			selenium.waitingTime(4000);
//			if(selenium.isElementPresentFast("SA_SearchAllRecords"))
//			{
//				selenium.click("SA_SearchAllRecords");
//				selenium.waitingTime(4000);
//			}
			selenium.waitForElementToBeClickable("Gantt_SAQuickList");
			selenium.click("Gantt_SAQuickList");
			selenium.waitForElementToBeClickable("CandidatesBtnInSA");
			selenium.takeScreenShot();
			selenium.click("CandidatesBtnInSA");
			selenium.waitingTime(15000);
			//For the logged-in user some time we get Candidates to assign and some times we don't. so, I am commenting below validation
			/*selenium.waitForElementToBeClickable("FirstCandidateInList");
			selenium.click("FirstCandidateInList");
			selenium.waitingTime(4000);
			
			if(selenium.isElementPresentFast("ScheduleBtnInsideCandidateRow"))
			{
				selenium.test.log(LogStatus.PASS, "User is able to find/assign candidate to SA in Gantt!");
				System.out.println("PASS");				
			}
			else
			{
				selenium.reportFailure("Unable to find/assign candidates to SA");
				selenium.test.log(LogStatus.FAIL, "Unable to find/assign candidates to SA");
				System.out.println("FAIL");
			}*/
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while assigning candidates to SA in dispatch console");
			selenium.reportFailure("Error while assigning candidates to SA in dispatch console " + e.getMessage());
			selenium.waitingTime(2000);
		}
	}
	
	@And("assign service resources through Candidate action button")
	public void assign_service_resources_through_Candidate_action_button() {
		try {

			if(selenium.ServiceAppointmentURL != null)
			{
				System.out.println("Dynamic SA URL is not null");
				selenium.navigateToURL(selenium.ServiceAppointmentURL);
			}
			else
			{
				System.out.println("Dynamic SA URL is null, so picking up hard-coded SA URL in else Block");
				System.out.println("ServiceAppointmentURL is null");
				selenium.navigateToURL(ServiceAppointmentURL_ToAssignResource);
			}
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("SA_CandidateActionBtn");
			selenium.takeScreenShot();
			selenium.jsClick("SA_CandidateActionBtn");
			selenium.waitingTime(15000);
			selenium.waitForElementToBeVisible("iframeCandidatePopup");
			selenium.switchToFrame("iframeCandidatePopup");
			selenium.waitForElementToBeClickable("SA_CandidateResources");
			selenium.click("SA_CandidateResources");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SA_CandidateRadioBtn");
			selenium.click("SA_CandidateRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SA_ScheduleToCandidateBtn");
			selenium.click("SA_ScheduleToCandidateBtn");
			selenium.waitingTime(25000);			
			selenium.waitForElementToBeClickable("SA_ViewSABtn");
			selenium.click("SA_ViewSABtn");
			selenium.waitingTime(5000);			
			selenium.switchOutOfFrame();
			selenium.click("CancelButton_Span");
			selenium.waitingTime(5000);
			
		}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.click("CancelButton_Span");
			selenium.waitingTime(2000);
			
			selenium.test.log(LogStatus.FAIL, "Error while assigning candidates to SA");
			selenium.reportFailure("Error while assigning candidates to SA " + e.getMessage());
			selenium.waitingTime(2000);
		}
	}
			
}