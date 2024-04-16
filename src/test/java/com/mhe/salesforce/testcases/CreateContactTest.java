package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CreateContactTest {
	WebConnector selenium = WebConnector.getInstance();

	@Then("^contact should get created$")
	public void contact_should_get_created() {
		boolean isSuccess = false;
		if (selenium.getUI().contains("Lightning"))
			isSuccess = selenium.isElementPresentFast("contactSuccessfulL");
		else {
			String messageLocator = selenium.getDynamicXpath("contactSuccessfulC", "First Name", "endContains");
			selenium.waitingTime(3000);
			isSuccess = selenium.isElementPresentXpathFast(messageLocator);
		}
		selenium.printLastTestResult(isSuccess);		
	}

	@And("^I fill in all the mandatory details to create a new contact$")
	public void i_fill_in_the_following_to_create_a_new_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("contactLink");
				//selenium.click("Newcontact");
				selenium.click("contactLink");
				
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("newContactBtn");
				//selenium.click("new_uat");
				selenium.click("newContactBtn");
				selenium.waitForElementToBeClickable("salutation");
				selenium.click("salutation");
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
				selenium.clickDynamic("anchorTitle", "Salutation", "end");
				selenium.waitForElementToBeClickable("contactType");
				selenium.click("contactType");
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
				selenium.clickDynamic("anchorTitle", "Contact Type", "end");
				selenium.type("firstName", "First Name");
				selenium.type("lastName", "Last Name");
				selenium.scrollToElement("Name_Field");
				selenium.type("Name_Field", "Department Name");
				selenium.clickDynamic("divTitle", "Department Name", "end");
				if (selenium.getBrowserName().equalsIgnoreCase("IE")) {
					selenium.scrollToElement("emailIE");
					selenium.type("emailIE", "Email");
				} else {
					//selenium.scrollToElement("emailUat");
					//selenium.type("emailUat", "Email");
					selenium.scrollToElement("contactEmailField");
					selenium.type("contactEmailField", "Email");
					selenium.scrollToElement("serach_Account");
					selenium.typeRandomstring("serach_Account", WebConnector.ACC_NAME_RANDOM);
					selenium.clickDynamicUsingAccName("contactAccountDynamic", WebConnector.ACC_NAME_RANDOM, "end");
				}
				
					selenium.isDuplicate();
//				    selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("savebtn");
				    selenium.clickLoop("savebtn");
				    selenium.waitingTime(4000);
				    if(selenium.isElementPresentFast("savebtn"))
				    {
				    	selenium.clickLoop("savebtn");
				    }
			} else {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("contactC");
				selenium.scrollToElement("contactC");
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("contactC");
				selenium.jsClick("contactC");
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("salutationC");
				selenium.selectDropdownText("salutationC", "Salutation");
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("contactTypeC");
				selenium.selectDropdownText("contactTypeC", "Contact Type");
				selenium.type("firstNameC", "First Name");
				selenium.type("lastNameC", "Last Name");
				selenium.type("emailC", "Email");
				selenium.isDuplicate();
				selenium.scrollToElement("departmentNameC");
				selenium.type("departmentNameC", "Department Name");
				selenium.pressEnter("departmentNameC");
				selenium.waitingTime(2000);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating the contact " + e.getMessage());
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) 
			{
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else 
			{
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}
	}
	@Then("I create a new report")
	public void i_create_a_new_report(){
		try{
			selenium.caseNumber=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewReportButton");
			selenium.click("NewReportButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("ReportIframeNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReportAllBtn");
			selenium.jsClick("ReportAllBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchReportTypeTextBox");
			selenium.typeData("SearchReportTypeTextBox","Cases");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReportCasesObj");
			selenium.jsClick("ReportCasesObj");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StartReportBtn");
			selenium.jsClick("StartReportBtn");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("ReportIframeNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOwnerCloseBtn");
			selenium.click("CaseOwnerCloseBtn");
			selenium.waitForElementToBeClickable("AccountNameCloseBtn");
			selenium.click("AccountNameCloseBtn");
			selenium.waitForElementToBeClickable("SubjectCloseBtn");
			selenium.click("SubjectCloseBtn");
			selenium.waitForElementToBeClickable("DateTimeOpenedClosedBtn");
			selenium.click("DateTimeOpenedClosedBtn");
			selenium.waitForElementToBeClickable("AgeClosedBtn");
			selenium.click("AgeClosedBtn");
			selenium.waitForElementToBeClickable("OpenClosedBtn");
			selenium.click("OpenClosedBtn");
			selenium.waitForElementToBeClickable("ClosedColumnCloseBtn");
			selenium.click("ClosedColumnCloseBtn");
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Case Number");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CaseNumberColumn");
			selenium.jsClick("CaseNumberColumn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Status");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CaseStatusColumn");
			selenium.jsClick("CaseStatusColumn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Priority");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CasePriorityColumn");
			selenium.jsClick("CasePriorityColumn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Case Owner");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CaseOwnerColumn");
			selenium.jsClick("CaseOwnerColumn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Support Account");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CaseSupportAccountColumn");
			selenium.jsClick("CaseSupportAccountColumn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.typeData("AddColumnTextBox","Country");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AddColumnTextBox");
			selenium.jsClick("AddColumnTextBox");
			selenium.waitForElementToBeClickable("CaseCountryColumn");
			selenium.jsClick("CaseCountryColumn");
			selenium.waitForElementToBeClickable("CaseFilters");
			selenium.jsClick("CaseFilters");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CasesFilterShowMe");
			selenium.jsClick("CasesFilterShowMe");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditAllCasesFilterDropDown");
			selenium.jsClick("EditAllCasesFilterDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AllCasesFilterOption");
			selenium.jsClick("AllCasesFilterOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("FilterApplyBtn");
			selenium.jsClick("FilterApplyBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpenedDateFilter");
			selenium.jsClick("OpenedDateFilter");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RangeFilterDropDown");
			selenium.jsClick("RangeFilterDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RangeFilter");
			selenium.jsClick("RangeFilter");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("FilterApplyBtn");
			selenium.jsClick("FilterApplyBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReportNameTextBox");
			selenium.clearText("ReportNameTextBox");
			selenium.waitingTime(2000);
			selenium.typeData("ReportNameTextBox",selenium.caseNumber);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton2");
			selenium.jsClick("saveButton2");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.switchToMultipleFrame("ReportIframeNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReportRun");
			selenium.jsClick("ReportRun");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
		}catch (Exception e){
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the created report")
	public void i_verify_the_created_report(){
		try{
			selenium.switchToMultipleFrame("ReportIframe");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EnableFieldEditingBtn");
			selenium.jsClick("EnableFieldEditingBtn");
			selenium.waitingTime(2000);
			String caseOwner=selenium.getText("ReportCaseOwnerGetText").toString();
			System.out.println(caseOwner);
			selenium.waitForElementToBeClickable("CaseNumberSelect");
			selenium.jsClick("CaseNumberSelect");
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(7000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(2000);
			selenium.scrollToElement("EditContactNameBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactNameBtn");
			selenium.jsClick("EditContactNameBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CrossBtnContactName");
			selenium.jsClick("CrossBtnContactName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.typeData("Search_contact","Tessal");
			selenium.waitingTime(2000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("Search_contact");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeDropdown2");
			selenium.autoSuggestiveDropdownWithoutTextTwo("contactTypeDropdown2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CrossBtnSupportAccount");
			selenium.jsClick("CrossBtnSupportAccount");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("newContactSupportAccountSearch");
			selenium.typeData("newContactSupportAccountSearch","Stanford University");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("newContactSupportAccountSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("countryDrpDown1");
			selenium.jsClick("countryDrpDown1");
			selenium.autoSuggestiveDropdownWithoutTextTwo("countryDrpDown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field","Test Report");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			String caseOwnerGetText=selenium.getText("CaseOwnerGetText").toString();
			System.out.println(caseOwnerGetText);
			Assert.assertTrue(caseOwner.equalsIgnoreCase(caseOwnerGetText));
			System.out.println("PASS");

		}catch (Exception e){
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
