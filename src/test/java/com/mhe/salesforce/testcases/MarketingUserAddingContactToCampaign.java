package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class MarketingUserAddingContactToCampaign {


	WebConnector selenium = WebConnector.getInstance();
	String inactiveContactURL = null;
	String StudentTypeContact = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/003C000001nspkeIAA/view";
	String DAG_Account = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000cMIbsAAG/view";
	
	@When("^I navigate to contacts tab$")
	public void I_navigate_to_contacts_tab() {
		try {
			if (selenium.isElementPresentFast("loginPopUp")) {
				System.out.println("I am inside loginPopup method");
				selenium.clickLoop("loginPopUp");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "New Contact");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactsOptionMenuDots");
			selenium.jsClick("contactsOptionMenuDots");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to contact " + e.getMessage());
		}

	}

	@When("^I navigate to contacts page$")
	public void I_navigate_to_contacts_page() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "Contacts");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactsOptionMenuDots");
			selenium.jsClick("contactsOptionMenuDots");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("ContactTab"))
			{
				selenium.jsClick("ContactTab");
				selenium.waitingTime(5000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to contact " + e.getMessage());
		}

	}

	@And("^click on contact name$")
	public void click_on_contact_name() {
		try {
			/*
			 * selenium.searchGlobal("Contact Name"); selenium.waitingTime(2000); String
			 * Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name",
			 * "endContains"); selenium.waitingTime(2000); System.out.println("xpath is" +
			 * Xpath); selenium.waitingTime(2000); selenium.clickLoopXpath(Xpath);
			 */

			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.INFO, "Clicked on contact ");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking contact " + e.getMessage());
		}

	}


	@When("^I navigate to Campaign history section to click on Add to campaign button$")
	public void I_navigate_to_Campaignhistory_section_to_click_on_Add_to_campaign_button() throws InterruptedException {

		try {
			selenium.navigateToURL(selenium.contacts);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("campaignHistoryWithinContact");
			selenium.jsClick("campaignHistoryWithinContact");
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("addtocampaignnew");
			selenium.clickLoop("addtocampaignnew");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking add to campaign " + e.getMessage());
		}

	}

	@Then("^I select campaign$")
	public void I_select_campaign() {

		try {
			selenium.autoSuggestiveDropdown("searchCampaign", "Campaign");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			System.out.println("clicking next");
			selenium.waitForElementToBeClickable("campaignNext2");
			selenium.jsClick("campaignNext2");
			selenium.waitingTime(5000);


		} catch (Exception e) {

//						selenium.click("cancelButtonOnAddingCampaignToLead");
			selenium.reportFailure("Error while selecting campaign " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}


	}


	@And("^verify fields on campaign page$")
	public void verify_fields_on_campaign_page() {
		try {

			selenium.waitingTime(2000);
			selenium.isElementPresentFast("campaignField");
			selenium.isElementPresentFast("statusField");
			selenium.isElementPresentFast("MHECourseField");
			selenium.isElementPresentFast("commentsField");
			selenium.test.log(LogStatus.INFO, "Fields are present");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveOnCampaignPopUp");
			selenium.jsClick("saveOnCampaignPopUp");
			selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("alreadyCampaignMemeberError")) {
				System.out.println("clciking cancel for already campaign member");
				selenium.waitForElementToBeClickable("CancelButton_Span");
				selenium.clickLoop("CancelButton_Span");
				System.out.println("clicked cancel");
				selenium.test.log(LogStatus.INFO, "Already campaign member");
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("addtocampaignnew");
				selenium.jsClick("addtocampaignnew");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("addNewCampaignOption");
				selenium.click("addNewCampaignOption");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeVisible("campaignNameToCreateNewCampaign");
				String campaignname = selenium.getRandomString();
				selenium.getElement("campaignNameToCreateNewCampaign").sendKeys(campaignname);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("campaignBusinessUnit");
				selenium.clickLoop("campaignBusinessUnit");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("campaignBusinessUnitOption");
				selenium.click("campaignBusinessUnitOption");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("SaveBtnNew1");
				selenium.clickLoop("SaveBtnNew1");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("campaignNext2");
				selenium.jsClick("campaignNext2");
				selenium.waitingTime(5000);
				verify_fields_on_campaign_page();
				selenium.test.log(LogStatus.INFO, "Contact added to Campaign successfully");

			}
//		if(selenium.isElementPresentFast("ErrorMsg")) {
//			System.out.println("clciking cancel");
//			selenium.jsClick("cancelButtonOnAddingCampaignToLead");
//			System.out.println("clicked cancel");
//			selenium.waitingTime(3000);
//			
//		}
//		else
//			
//			selenium.test.log(LogStatus.INFO, "Contact added to Campaign successfully" );
		} catch (Exception e) {
//			 selenium.jsClick("cancelButtonOnAddingCampaignToLead");
			selenium.reportFailure("Error while verifying campaign details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^click on Campaign name$")
	public void click_on_campaign_name() {
		try {
			selenium.waitingTime(5000);
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);

			String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				System.out.println("inside date check");
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("RecentlyAddedRecord");
				selenium.jsClick("RecentlyAddedRecord");
				selenium.waitingTime(5000);
			} else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("memberStatusUpdatedDate");
				selenium.jsClick("memberStatusUpdatedDate");
				selenium.waitingTime(3000);
				String recordDate1 = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				if (recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
					System.out.println("date matched");
					selenium.waitForElementToBeClickable("RecentlyAddedRecord");
					selenium.jsClick("RecentlyAddedRecord");
					selenium.waitingTime(5000);
				} else {
					selenium.test.log(LogStatus.INFO, "Campaign record not present");
				}
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking on campaign " + e.getMessage());
		}

	}

	@And("^verify contact details in campaign history section$")
	public void verify_contact_details_in_campaign_history_section() {
		try {

			selenium.waitForElementToBeClickable("campaignMembersSection");
			selenium.jsClick("campaignMembersSection");
			selenium.waitingTime(5000);

			if (selenium.getElement("campaignMembersrecordCheck").isDisplayed()) {
				System.out.println("Inside pass");
				selenium.test.log(LogStatus.PASS, "Campaign member record present");
			}


			selenium.waitingTime(3000);
			selenium.captureScreenShot();

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying contact name on campaign " + e.getMessage());
		}

	}


	@Then("^delete campaign member$")
	public void delete_campaign_member() {
		try {
			selenium.waitForElementToBeClickable("campaignMemeberSelectionToRemove");
			selenium.clickLoop("campaignMemeberSelectionToRemove");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("case_dropdown");
			selenium.clickLoop("case_dropdown");
			selenium.waitingTime(2000);
			selenium.click("DeleteRecord");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteConfirmationButton");
			selenium.jsClick("DeleteConfirmationButton");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.click("cancelButtonForCampaignMemberRemoval");
			selenium.reportFailure("Error while deleting member from campaign " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^global search for any data$")
	public void global_search_for_any_data() {
		try {
			selenium.search("Search Data");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Search Data", "endContains");
			selenium.waitingTime(4000);
			System.out.println(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while searching data " + e.getMessage());
		}
	}

	@And("^activate the contact$")
	public void activate_the_contact() {
		try {
			selenium.navigateToURL(inactiveContactURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.click("EditContactBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.jsClick("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactActiveOption");
			selenium.click("ContactActiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while activating contact " + e.getMessage());
		}
	}

	@And("^dactivate the contact$")
	public void dactivate_the_contact() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			inactiveContactURL = selenium.getURL();
			System.out.println("The contact going to be inactive is :" + inactiveContactURL);
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-300);
			selenium.waitingTime(2000);
			selenium.click("EditContactBtn");
//		selenium.waitForElementToBeClickable("contactStatusDropDwn");
//		selenium.jsClick("contactStatusDropDwn");
//		selenium.waitForElementToBeClickable("ContactInactiveOption");
//		selenium.jsClick("ContactInactiveOption");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.click("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactInactiveOption");
			selenium.click("ContactInactiveOption");
			selenium.waitingTime(2000);
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("accountContactInactivereason");
			selenium.click("accountContactInactivereason");
			selenium.clickDynamic("spanTitle", "Inactive reason", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(10000);
//		selenium.waitForElementToBeVisible("contactSuccessfulL");
//		boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
//		System.out.println("success message" + contact);
//		
//		 if(contact == true) {
//			 selenium.test.log(LogStatus.PASS, "Contact edited successfully" );
//		 }	
//		 
//		 else {
//			 selenium.test.log(LogStatus.FAIL, "Test case failed" );
//		 	 selenium.reportFailure("Test Case Failed");
//			 selenium.captureScreenShot();
//			 System.out.println("FAIL");
//		 }


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^I create a new contact from contact page and new opportunity from contact created$")
	public void i_create_a_new_contact_from_contact_page_and_new_opportunity_from_contact_created() {
		try {
			selenium.randomString=selenium.getRandomString();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ContactLastName");
			selenium.typeData("ContactLastName",selenium.randomString);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.jsClick("serach_Account");
			selenium.waitingTime(2000);
			selenium.typeData("serach_Account","OLYMPIC COLLEGE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("account_Name");
			selenium.jsClick("account_Name");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(12000);
			selenium.url= selenium.getURL();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opp_contact");
			selenium.jsClick("opp_contact");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewOportunityButton");
			selenium.jsClick("NewOportunityButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("iframe1");
			selenium.switchToFrame("iframe1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.hoverAndClick("OpportunityMHECourse2");
			String Course = "Advanced Engineering Mathematics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.pressEnter("OpportunityMHECourse2");
			selenium.waitForElementToBeVisible("select_course");
			selenium.waitForElementToBeClickable("select_course");
			selenium.hoverAndClick("select_course");
			selenium.waitingTime(3000);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("fall_enrollment");
			selenium.jsClick("fall_enrollment");
			selenium.waitingTime(3000);
			String Value = "20";
			selenium.typeData("fall_enrollment", Value);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("opp_contacts");
			selenium.jsClick("opp_contacts");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(5000);
			selenium.oppContactURL1=selenium.getURL();
			} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^i navigated on created contact page as an Admin$")
	public void i_navigated_on_created_contact_page_as_an_Admin() {
		try {
			selenium.waitingTime(4000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^i delete the newly created contact record as an admin and verify the opp contact$")
	public void i_delete_the_newly_created_contact_record_as_an_admin_and_verify_the_opp_contact() {
		try {
			selenium.waitForElementToBeClickable("VerifySideBtn");
			selenium.jsClick("VerifySideBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.jsClick("DeleteRecord");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(8000);
			selenium.navigateToURL(selenium.oppContactURL1);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("DeletePageMsg");
			if(selenium.isElementPresentsuperFast("DeletePageMsg"))
			{
				System.out.println("PASS!!! Opportunity Contact is not present");
				selenium.test.log(LogStatus.PASS,"Opportunity Contact is not present");
			}
			else
			{
				System.out.println("FAIL!!!Opportunity Contact is present");
				selenium.test.log(LogStatus.FAIL,"Opportunity Contact is present");
				selenium.reportFailure("Opportunity Contact is present");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^I verify the changes for contact in Contact History$")
	public void i_verify_the_changes_for_contact_in_Contact_History() {
		try {
			selenium.waitingTime(6000);
			selenium.scrollToElement("consent_editBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("consent_editBtn");
			selenium.jsClick("consent_editBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("email_consentCheckbox");
			selenium.jsClick("email_consentCheckbox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("phone_consentCheckbox");
			selenium.jsClick("phone_consentCheckbox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("contact_historyLink");
			selenium.clickLoop("contact_historyLink");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(12000);
			if(selenium.isElementPresentsuperFast("email_consent_optLink")&& selenium.isElementPresentsuperFast("phone_consent_optLink"))
			{
				System.out.println("PASS!!! Email & Phone Consent is updated");
				selenium.test.log(LogStatus.PASS,"Email & Phone Consent is updated");
			}
			else
			{
				System.out.println("FAIL!!!Email & Phone Consent is not updated");
				selenium.test.log(LogStatus.FAIL,"Email & Phone Consent is not updated");
				selenium.reportFailure("Email & Phone Consent is not updated");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^validate contact is created with no error$")
	public void validate_contact_is_created_with_no_error() {
		try {
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase("Active"))
			{
				System.out.println("Pass : Contact is created with no error");
				selenium.test.log(LogStatus.PASS,"Contact is created with no error");
			}
			else
			{
				System.out.println("FAIL :  Contact is not created");
				selenium.test.log(LogStatus.FAIL," Contact is not created");
				selenium.reportFailure(" Contact is not created");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@When("^create a new task for INTL Opportunity and Verify Opp Clone Task$")
	public void create_a_new_task_for_INTL_Opportunity_and_Verify_Opp_Clone_Task() {
		try {
			selenium.closeAllNotificationPopups_nonEnglish();
			selenium.waitForElementToBeClickable("opp_Btn");
			selenium.jsClick("opp_Btn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("new_OppBTN");
			selenium.jsClick("new_OppBTN");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("oppnext_BTN");
			selenium.jsClick("oppnext_BTN");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("account_Search");
			selenium.jsClick("account_Search");
			selenium.waitingTime(2000);
			String accname="ATIYA STANFORD";
			selenium.typeData("account_Search",accname);
			selenium.waitingTime(4000);
			String xpath=selenium.getDynamicXpathData("spanTitle",accname,"end");
			selenium.waitingTime(2000);
			System.out.println("Account xpath-->" + xpath);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("account_name3");
//			selenium.hoverAndClick("account_name3");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("course_BTN");
			selenium.jsClick("course_BTN");
			selenium.waitingTime(2000);
			String mhecourse="ASTROPHYSICS";
			selenium.typeData("course_BTN",mhecourse);
			String xpath1=selenium.getDynamicXpathData("spanTitle",mhecourse,"end");
			selenium.waitingTime(2000);
			System.out.println("MHE Course xpath-->" + xpath1);
			selenium.clickLoopXpath(xpath1);
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("course_productSearch");
//			selenium.hoverAndClick("course_productSearch");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("calendarDate");
			selenium.jsClick("calendarDate");
			selenium.waitingTime(3000);
			selenium.typeData("calendarDate", "11 feb 2025");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("date_picker");
			selenium.jsClick("date_picker");
			selenium.waitingTime(3000);
			selenium.typeData("date_picker", "11 feb 2025");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("description_field1");
			selenium.jsClick("description_field1");
			String val1="10";
			selenium.typeData("description_field1",val1);
			selenium.waitingTime(2000);
			selenium.typeData("description_field1",val1);	//for the first time filling the data is getting cleared for some reason, so refilling it.
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("save_Opp");
			selenium.jsClick("save_Opp");
			selenium.waitingTime(30000);
			selenium.url= selenium.getURL();
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("activity_Btn");
			selenium.jsClick("activity_Btn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("task_Btn");
			selenium.jsClick("task_Btn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("save_Task");
			selenium.jsClick("save_Task");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("click_quickBtn");
			selenium.jsClick("click_quickBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clone_Btn");
			selenium.jsClick("clone_Btn");
			selenium.waitingTime(6000);
			selenium.switchToFrame("iFrame");
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("activity_Btn");
			selenium.jsClick("activity_Btn");
			selenium.waitingTime(3000);
			if(!(selenium.isElementPresentsuperFast("task_Name")))
			{
				System.out.println("Opp Task Did not Clone");
				selenium.test.log(LogStatus.PASS," Opp Task Did not Clone");
			}
			else
			{
				System.out.println("FAIL : Opp Task Got Cloned");
				selenium.test.log(LogStatus.FAIL," Opp Task Got Cloned");
				selenium.reportFailure(" Opp Task Got Cloned");
			}
			selenium.waitingTime(4000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("click_quickBtn");
			selenium.jsClick("click_quickBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clone_Btn");
			selenium.jsClick("clone_Btn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("iFrame");
			selenium.switchToFrame("iFrame");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clonar_abrirBtn");
			selenium.jsClick("clonar_abrirBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("activity_Btn");
			selenium.jsClick("activity_Btn");
			selenium.waitingTime(8000);
			if((selenium.isElementPresentFast("task_Name")))
			{
				System.out.println("Opp Task Got Cloned");
				selenium.test.log(LogStatus.PASS," Opp Task Got Cloned");
			}
			else
			{
				System.out.println("FAIL : Opp Task Did Not Clone");
				selenium.test.log(LogStatus.FAIL," Opp Task Did Not Clone");
				selenium.reportFailure(" Opp Task Did Not Clone");
			}
			
			//Logout non-English user 
//			selenium.waitForElementToBeClickable("userIcon");
//			selenium.clickNew("userIcon");
			selenium.waitingTime(4000);
			selenium.jsClick("LogoutNonEnglishUser");
			selenium.waitingTime(6000);

		} catch (Exception e) {
			selenium.takeScreenShot();
			//Logout non-english user 
			selenium.jsClick("LogoutNonEnglishUser");
			selenium.waitingTime(6000);
			
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@And("^navigate to account record$")
	public void navigate_to_account_record() {
		try {
//			selenium.waitForElementToBeClickable("select_accRecord");
//			selenium.jsClick("select_accRecord");
			selenium.navigateToURL(DAG_Account);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opp_Link");
			selenium.jsClick("opp_Link");
//			selenium.waiting(3000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deactivating contact " + e.getMessage());
		}
	}

	@Then("create an new Opp of DAG New record type")
	public void create_an_new_Opp_of_DAG_New_record_type(){
		try{
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewActionButton");
			selenium.jsClick("NewActionButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OpptyDAGNewCheckBox");
			selenium.jsClick("OpptyDAGNewCheckBox");
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			String date="11/11/2023";
			selenium.waitForElementToBeClickable("defaultPurchase_date");
			selenium.jsClick("defaultPurchase_date");
			selenium.waitingTime(2000);
			selenium.typeData("defaultPurchase_date",date);
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(16);
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(5000);
			String errormsg=selenium.getText("error_Message").toString();
			System.out.println(errormsg);
			if(errormsg.equalsIgnoreCase(errormsg))
			{
				System.out.println("Purchase Date Is invalid");
				selenium.test.log(LogStatus.PASS,"Purchase Date Is invalid");
			}
			else
			{
				System.out.println("Purchase Date Is valid");
				selenium.test.log(LogStatus.FAIL,"Purchase Date Is valid");
				selenium.reportFailure("Purchase Date Is valid");
			}

			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(15000);
			selenium.oppURL=selenium.getURL();
			System.out.println(selenium.oppURL);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("verify DAG Opp Field Values")
	public void verify_DAG_Opp_Field_Values(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opp_Year_getText");
			String ActualYear=selenium.getText("opp_Year_getText").toString();
			String expected ="2025";
			Assert.assertTrue(ActualYear.equalsIgnoreCase(expected));
			System.out.println("Pass : Opp Year is Financial Year of Purchase Date " +expected);
			selenium.waitingTime(2000);
			String actualStage=selenium.getText("Opp_StageValue").toString();
			String expectedStage="Stated Need/Discovery";
			Assert.assertTrue(actualStage.equalsIgnoreCase(expectedStage));
			System.out.println("Pass : Opp Stage is " +expectedStage);
			selenium.waitingTime(3000);
			String oppName=selenium.getText("opp_Name").toString();
			System.out.println("Opp Name is " + oppName);
			String[] name=oppName.split("-");
			String part1=name[0];
			String part2=name[1];
			String part3=name[2];
			String part4=name[3];
//			String part5=name[4];
//			String part6=name[5];
//			String part7=name[6];
			System.out.println("Opp year from UI is " +part1);
			System.out.println("Opp Shipping State from UI is " +part2);
			System.out.println("Opp Account from UI is " +part3);
			System.out.println("Opp Market revenue from UI is " +part4);
//			System.out.println("Opp Status from UI is " +part5);
//			System.out.println("Opp Owner from UI is " +part6);
//			System.out.println("Opp year from UI is" +part1);
			String optyYear="2025";
			String shippingState="NH";
			String accountName="Moultonborough Academy";
			String revenueGroup="HIGH SCHOOL: CORE";
//			String oppStatus="Open";
//			String oppOwner="jhold";
			selenium.waitingTime(2000);
			if(optyYear.equalsIgnoreCase(part1)&& shippingState.equalsIgnoreCase(part2)&& accountName.equalsIgnoreCase(part3)&&
			revenueGroup.equalsIgnoreCase(part4))
			{
				System.out.println("All the name in Opportunity name are matched");
			}
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.clearText("Name_Field");
			selenium.waitingTime(2000);
			String opptyNmeafteredit="Test Opp Name";
			selenium.typeData("Name_Field",opptyNmeafteredit);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
			selenium.jsClick("SubtypeDropDownOpp");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubtypeOption");
			selenium.jsClick("SubtypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertFalse(oppName.equalsIgnoreCase(opptyNmeafteredit));
			System.out.println("Opp Name Is not editable");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("verify if the contact status validation fired or not")
	public void verify_if_the_contact_status_validation_fired_or_not()
	{
		try
		{
//			selenium.waitForElementToBeClickable("firstTableRecord");
//			selenium.jsClick("firstTableRecord");
			selenium.navigateToURL(StudentTypeContact);	//make sure this contact is in Pending state
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.checkFlowInterruptedPopup();
			
			String contactStatus = selenium.getText("ContactCurrentStatus");
			System.out.println("contactStatus -->" + contactStatus);
			if(!contactStatus.equals("Pending"))
			{
				selenium.waitForElementToBeClickable("EditContactBtn");
				selenium.jsClick("EditContactBtn");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ContactStatusField");
				selenium.jsClick("ContactStatusField");
				selenium.waitForElementToBeClickable("ContactPendingOption");
				selenium.click("ContactPendingOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.click("saveButton");
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.checkFlowInterruptedPopup();
			}
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.jsClick("EditContactBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.jsClick("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactActiveOption");
			selenium.click("ContactActiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(5000);
			String Xpath = selenium.getDynamicXpath_propertiesFile("AllTagTextEqualsStart", "ContactStatusChangeValidationMsg", "EndDoubleQuotes");
			System.out.println("Xpath -->" + Xpath);
			if(!selenium.isElementPresentXpath(Xpath))
			{
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS,"Error Message Not Triggered for the current user profile");
			}
			else
			{
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CancelButton");
				selenium.jsClick("CancelButton");
				selenium.waitingTime(2000);
				System.out.println("FAIL");
				selenium.test.log(LogStatus.FAIL,"Error Message Triggered for the current user profile");
				selenium.reportFailure("Error Message Triggered for the current user profile");
			}
		}
		catch (Exception e)
		{
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.jsClick("CancelButton");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

}

