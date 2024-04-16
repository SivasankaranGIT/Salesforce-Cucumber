package com.mhe.salesforce.testcases;

import java.util.List;

//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAndCloseDTSCase {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I search for DTS User contacts$")
    public void i_search_for_dts_user_contacts()  {
		try {
			
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Contact");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactsOptionMenuDots");
		selenium.jsClick("contactsOptionMenuDots");
		selenium.waitingTime(3000);
		
	
	}
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to contacts " + e.getMessage());
		}

}

	 @Then("^select record type as DTS Support$")
	    public void select_record_type_as_dts_support() {
		 
		 try {
			 selenium.waitForElementToBeClickable("RecordType");
			 selenium.click("RecordType");
			 selenium.waitingTime(2000);
			 selenium.selectDropdownText("RecordType", "Record Type");
//			 selenium.waitingTime(2000);
//			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("continueButton");
			 selenium.jsClick("continueButton");
			 selenium.waitingTime(5000);
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while selecting record type " + e.getMessage());
				selenium.click("CancelEdit");
				}
	 }

 @And("^fill all mandatory details to create DTS case$")
	    public void fill_all_mandatory_details_to_create_dts_case() {
		 
		 try {
			
			 selenium.waitingTime(3000);
			 if(selenium.getElement("caseOriginSkillDropdownNew").isDisplayed()) {
				 System.out.println("inside first");
				 selenium.waitForElementToBeClickableLongerDuration("caseOriginSkillDropdownNew");
			 selenium.jsClick("caseOriginSkillDropdownNew");
			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeClickable("select_caseOriginSkill");
			 selenium.dropdownListClick("select_caseOriginSkill");
			 selenium.waitingTime(2000);
			 }
			 else  if(selenium.getElement("caseDTSOriginSkillDropdown2").isDisplayed()) {
				 System.out.println("inside second");
				 selenium.jsClick("caseDTSOriginSkillDropdown2");
//				 selenium.waitingTime(3000);
				 selenium.waitForElementToBeClickable("select_caseOriginSkill");
				 selenium.dropdownListClick("select_caseOriginSkill");
				 selenium.waitingTime(2000);
				 }
			 
			 
			 if(selenium.getElement("ProductTypeDDList").isDisplayed()) {
				 System.out.println("inside first");
				 selenium.waitForElementToBeClickable("InquiryType1New");
			 selenium.jsClick("InquiryType1New");
			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeClickable("caseDTSProductOption1New");
			 selenium.dropdownListClick("caseDTSProductOption1New");
			 selenium.waitingTime(2000);
			 }
			 else  if(selenium.getElement("caseDTSProductTypeDropdown2").isDisplayed()) {
				 System.out.println("inside second");
				 selenium.jsClick("caseDTSProductTypeDropdown2");
//				 selenium.waitingTime(3000);
				 selenium.waitForElementToBeClickable("caseDTSProductOption1New");
				 selenium.dropdownListClick("caseDTSProductOption1New");
				 selenium.waitingTime(2000);
				 }
			 System.out.println("Click on Product dropdown field");
			 
			 selenium.waitForElementToBeClickable("ProdDropdownList");
			 selenium.jsClick("ProdDropdownList");
			 selenium.waitForElementToBeClickable("ProdValueFromList");
			 selenium.dropdownListClick("ProdValueFromList");
			 selenium.waitingTime(2000);
			 
			 selenium.waitForElementToBeClickable("incident_option");
			 selenium.jsClick("incident_option");
			 selenium.waitForElementToBeClickable("caseSEGIncidentOptionNew");
			 selenium.dropdownListClick("caseSEGIncidentOptionNew");
			 selenium.waitingTime(2000);
			 
			 selenium.waitForElementToBeClickable("caseCXGInternalDescriptionNew");
			 selenium.jsClick("caseCXGInternalDescriptionNew");
			 selenium.typeData("caseCXGInternalDescriptionNew", "Automation Test");
			 System.out.println("Added Internal description");
			 selenium.typeData("caseDTSDescriptionNew", "Automation Test");
//			 selenium.moveTab("caseDTSDescriptionNew");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Save_Btn");
			 selenium.jsClick("Save_Btn");
//			 selenium.waitForElementToBeVisible("contactSuccessfulL");
//			 if(selenium.isElementPresentFast("contactSuccessfulL")) {
//			 selenium.test.log(LogStatus.PASS, "DTS Case created successfully" );
//			 System.out.println("PASS");
//		 }
			 
//			 else {
//				 selenium.test.log(LogStatus.FAIL, "DTS Case not created" );
//				 selenium.reportFailure("DTS Case not created");
//			 }
			 selenium.waitingTime(8000);
			 selenium.captureScreenShot();
			 selenium.waitingTime(2000);
			 
			 selenium.DTSCaseURL= selenium.getURL();
			 System.out.println("selenium.DTSCaseURL is" + selenium.DTSCaseURL);
		 }
		 catch (Exception e) {
			 System.out.println("inside catch");
//				selenium.jsClick("contactCloseButton");
				System.out.println("inside catch1");
				selenium.reportFailure("Error while creating new case " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				
				}
	 }
	 
	 @Then("^click on close case button for DTS$")
	    public void click_on_close_case_button_for_DTS() {
		 
		 try {
			 selenium.captureScreenShot();
			 selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("loginPopUp"))
				{
					selenium.click("loginPopUp");
				}
			 if(selenium.getElement("Close_case").isDisplayed()) {
			 selenium.jsClick("Close_case");
			 selenium.waitingTime(5000);
			 }
			 
			 else  if(selenium.getElement("CXGCloseCase2").isDisplayed()) {
				 selenium.jsClick("CXGCloseCase2");
				 selenium.waitingTime(5000);
				 }
				if (selenium.isElementPresentFast("loginPopUp"))
				{
					selenium.click("loginPopUp");
				}
			 
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking on close case " + e.getMessage());
			}
	 }
	 
	 @And("^fill mandatory fields to close DTS Case$")
	    public void fill_mandatory_fields_to_close_dts_case() {
		 
		 try {
			 
			 if (selenium.getTestCaseName().equalsIgnoreCase("VerifycreateAndCloseDTSCase"))
			 {
			 selenium.waitForElementToBeClickable("closingStatus");
			 selenium.jsClick("closingStatus");
			 selenium.waitingTime(2000);
			 selenium.selectDropdownText("closingStatus", "Close Status");
			 selenium.waitingTime(2000);
			 selenium.scrollToElement("caseDTSCloseProductTypeDropdown");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseDTSCloseProductTypeDropdown");
			 selenium.click("caseDTSCloseProductTypeDropdown");
			 selenium.waitingTime(2000);
			 selenium.click("caseDTSProductOption1New");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseDTSCloseProductDropdown");
			 selenium.click("caseDTSCloseProductDropdown");
			 selenium.waitingTime(2000);
			 selenium.click("ProdValueFromList");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(100);
			 selenium.waitingTime(2000);
			 selenium.scrollToElement("caseDTSCloseIncidentDropdown");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseDTSCloseIncidentDropdown");
			 selenium.click("caseDTSCloseIncidentDropdown");
			 selenium.waitForElementToBeClickable("caseDTSCloseIncidentOption1");
			 selenium.click("caseDTSCloseIncidentOption1");
			 selenium.waitForElementToBeClickable("caseDTSCloseSubIncidentDropdown");
			 selenium.click("caseDTSCloseSubIncidentDropdown");
			 selenium.waitForElementToBeClickable("caseDTSCloseSubIncidentOption1");
			 selenium.click("caseDTSCloseSubIncidentOption1");			
			 selenium.waitForElementToBeClickable("reportedIssue1");
			 selenium.click("reportedIssue1");			 
			 selenium.waitForElementToBeClickable("reportedIssueOption");
			 selenium.click("reportedIssueOption");
			 selenium.scrolldown(50);
			 selenium.waitForElementToBeClickable("resolutionType1");
			 selenium.click("resolutionType1");
			 selenium.waitForElementToBeClickable("resultionTypeOption");
			 selenium.click("resultionTypeOption");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseResolution");
			 selenium.click("caseResolution");
			 selenium.waitingTime(2000);
			 selenium.type("caseResolution", "Case Resolution");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("saveButton");
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(5000);
			 selenium.test.log(LogStatus.PASS, "Case closed successfully");		
			 }
			 else
			 {
			 
			 selenium.waitForElementToBeClickable("SEGCaseStatusDropDownField");
			 selenium.jsClick("SEGCaseStatusDropDownField");
			 selenium.waitForElementToBeClickable("SEGCaseStatusDropDownOption");
			 selenium.jsClick("SEGCaseStatusDropDownOption");
			 selenium.waitForElementToBeClickable("SEGCaseReportedIssueDropDownField");
			 selenium.jsClick("SEGCaseReportedIssueDropDownField");
			 selenium.waitForElementToBeClickable("SEGCaseReportedIssueDropDownOption");
			 selenium.jsClick("SEGCaseReportedIssueDropDownOption");
			 selenium.waitForElementToBeClickable("SEGCaseResolutionTypeDropDownField");
			 selenium.jsClick("SEGCaseResolutionTypeDropDownField");
			 selenium.waitForElementToBeClickable("SEGCaseResolutionTypeDropDownOption");
			 selenium.jsClick("SEGCaseResolutionTypeDropDownOption");
			 selenium.waitForElementToBeClickable("caseResolution");
			 selenium.click("caseResolution");
			 selenium.waitingTime(2000);
			 selenium.type("caseResolution", "Case Resolution");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("closeCase");
			 selenium.jsClick("closeCase");
			 selenium.waitingTime(25000);
//			 selenium.jsClick("closeCase");
//			 selenium.waitingTime(8000);
			 selenium.test.log(LogStatus.INFO, "Case close button clicked");
			 }
		 }
			 
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while closing case " + e.getMessage());
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
	 
	 @Then("^change case owner and verify record type$")
	    public void change_case_owner_and_verify_record_type() {
		 
		 try {
			 String CaseType = null;
			 selenium.navigateToURL(selenium.DTSCaseURL);
			 selenium.waitingTime(6000);
			 
			 selenium.waitForElementToBeClickable("changeOwner");
			 
			 if(selenium.isElementPresentFast("closeViewDuplicateTosterPopup"))
			 {
				 selenium.click("closeViewDuplicateTosterPopup");
				 selenium.waitingTime(2000);
			 }
			 selenium.clickLoop("changeOwner");
			 selenium.waitingTime(6000);
			 selenium.waitForElementToBeClickable("UserTypeDD");
			 selenium.jsClick("UserTypeDD");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("UserTypeValue");
			 selenium.click("UserTypeValue");
			 selenium.waitingTime(2000);
			 
			 selenium.waitForElementToBeClickable("searchQueues");
			 selenium.typeData("searchQueues", "CXG_Spanish_Support"); //CXG_Spanish_Support
//			 selenium.pressEnter("searchQueues");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("QueueUserSelection");
			 selenium.jsClick("QueueUserSelection");
			 selenium.waitingTime(4000);
//			 selenium.waitForElementToBeClickable("CXGSpanishSupportResult1");
//			 selenium.jsClick("CXGSpanishSupportResult1");
//			 selenium.waitingTime(6000);
			 selenium.click("ChangeOwnerBtn");
			 selenium.waitingTime(20000);
			 selenium.test.log(LogStatus.INFO, "Case Owner updated to CXG_Spanish_Support");
			 
	//		 selenium.scrolldown(1000);
			 selenium.refresh();
			 selenium.waitingTime(10000);
			 selenium.scrollToElement("AdditionalCaseInfoTab");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("AdditionalCaseInfoTab");
			 if(selenium.isElementPresentFast("CaseRecodeTypeGetText"))
			 {
				 CaseType = selenium.getText("CaseRecodeTypeGetText");
			 }
			 else
			 {
				 selenium.click("AdditionalCaseInfoTab");
				 selenium.waitingTime(2000);
				 CaseType = selenium.getText("CaseRecodeTypeGetText");
			 }
			 System.out.println("Case Type is : " + CaseType);
			 if(CaseType.equalsIgnoreCase("MHHE Product Support"))
			 {
				 selenium.test.log(LogStatus.PASS, "Record Type is matching");
				 System.out.println("PASS");
			 }
			 else
			 {
				selenium.test.log(LogStatus.FAIL, "Test case failed");
				selenium.reportFailure("Test case failed");
				System.out.println("FAIL");
			 }
		 }
		 
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying case record type " + e.getMessage());
			}
	 }
	 
	 @Then("^verify the status of closed DTS record$")
	    public void verify_the_status_of_closed_cxg_record() {
		 
		 try {
			 selenium.refresh();
			 selenium.waitingTime(10000);
				if (selenium.isElementPresentFast("loginPopUp"))
				{
					selenium.click2("loginPopUp");
				}
			 	selenium.waitingTime(4000);
			 	selenium.waitForElementToBeVisible("DtsStatusnew");
			 	String status = selenium.getText("DtsStatusnew");
			 	String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
				System.out.println("status" +status);
				System.out.println("expected status" + expected_status);
				if (status.equalsIgnoreCase(expected_status)) {
					 System.out.println("inside pass");
					selenium.test.log(LogStatus.PASS, "Status is closed");

				} else {
					 System.out.println("inside fail");
					selenium.test.log(LogStatus.FAIL, "Status is not closed");
					selenium.reportFailure("Status is not closed");

				}
				selenium.closeSubTabs();
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying case status " + e.getMessage());
			}
	 }
	 
	 

}
