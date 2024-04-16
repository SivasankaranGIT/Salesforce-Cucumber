package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ContactRecievingVOCSurvey {

	
	WebConnector selenium = WebConnector.getInstance();
//	String contactForRestrictedProduct="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0031A000027yYPgQAM/view";
	
//	@And("^click on contact$")
//	public void click_on_contact() {
//		try {
////			 selenium.click("SearchThisList");
////			 selenium.waitingTime(2000);
////			 selenium.type("SearchThisList", "Contact Name");
////			 selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
////			 selenium.waitingTime(4000);
////			 selenium.click("vocSurveyContactName");
//			selenium.waitingTime(4000);
///*			selenium.search("Contact Name");
//			selenium.waitingTime(4000);
//			
//			String Xpath = selenium.getDynamicXpath("contactResultsOnGlobalSearch", "Contact Name", "endContains");
//			selenium.waitingTime(3000);
//			System.out.println("xpath is"+Xpath);
//			selenium.clickLoopXpath(Xpath);*/
//			
//			
//			selenium.navigateToURL(contactForRestrictedProduct);
//			
//			selenium.waitingTime(8000);
//		selenium.test.log(LogStatus.INFO, "Clicked on contact" );
//		selenium.captureScreenShot();
////		selenium.waitingTime(2000);
//	}
//	
//	
//		 catch (Exception e) {
//				
//				selenium.reportFailure("Error while clicking contact " + e.getMessage());
//				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			}
//
//	}
	
//	@And("^click on contact for OP product$")
//	public void click_on_contact_for_OP_product() {
//		try {
////			 selenium.click("SearchThisList");
////			 selenium.waitingTime(2000);
////			 selenium.type("SearchThisList", "Contact Name");
////			 selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
////			 selenium.waitingTime(4000);
////			 selenium.click("vocSurveyContactName");
//			selenium.waitingTime(2000);
////			selenium.search("Contact Name");
////			selenium.waitingTime(4000);
////			
////			String Xpath = selenium.getDynamicXpath("contactResultsOnGlobalSearch", "Contact Name", "endContains");
////			selenium.waitingTime(3000);
////			System.out.println("xpath is"+Xpath);
////			selenium.clickLoopXpath(Xpath);
//			selenium.navigateToURL(contactForRestrictedProduct);
//			selenium.waitingTime(8000);
//		selenium.test.log(LogStatus.INFO, "Clicked on contact" );
//		selenium.captureScreenShot();
////		selenium.waitingTime(2000);
//	}
//	
//	
//		 catch (Exception e) {
//			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				selenium.reportFailure("Error while clicking contact " + e.getMessage());
//			}
//
//	}
	
	@Then("^click case section to create new case$")
    public void click_case_section_to_create_new_case() {
		try {	
			
			//selenium.isElementPresentFast("lastVOCSurveyDate");
			//selenium.waitingTime(2000);
//			if(selenium.getElement("caseSectioninsideContacts").isDisplayed()){
//				System.out.println("inside first");
//				selenium.jsClick("caseSectioninsideContacts");
//			}
//			else if(selenium.getElement("caseSectionInsideContacts1").isDisplayed()){
//				System.out.println("inside second");
//				selenium.jsClick("caseSectionInsideContacts1");
//			}
//			selenium.waitingTime(9000);
			selenium.waitForElementToBeClickable("caseinsidecontact");
			System.out.println("clicking case");
			selenium.jsClick("caseinsidecontact");
			System.out.println("clicked case");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("newCaseForContact");
			selenium.jsClick("newCaseForContact"); 
			selenium.waitingTime(8000);
			//selenium.switchToFrame("newCaseFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("continue");
			selenium.jsClick("continue");
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
}
		catch (Exception e) {
				selenium.switchOutOfFrame();
				System.out.println("inside catch");
				selenium.reportFailure("Error while navigating to case page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	
//	@And("^fill all mandatory details to create new case$")
//    public void fill_all_mandatory_details_to_create_new_case() {
//	 
//	 try {
//		 
////		 selenium.waitingTime(5000);
//		 selenium.waitForElementToBeClickable("newCaseSearchContacts");
//		 selenium.jsClick("newCaseSearchContacts");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeVisible("newCaseSearchContacts");
//		 selenium.autoSuggestiveDropdownWithoutText("newCaseSearchContacts");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("contactType");
//		 selenium.click("contactType");
//		selenium.clickDynamic("anchorTitle", "Contact Type", "end");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("newCaseSupportAccount_new");
//		 selenium.jsClick("newCaseSupportAccount_new");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeVisible("newCaseSupportAccount_new");
////		 selenium.autoSuggestiveDropdownWithoutText("newCaseSupportAccount");
////		 selenium.waitingTime(2000);
//		 selenium.type("newCaseSupportAccount_new", "Support Account");
//			selenium.clickDynamic("divTitle", "Support Account", "end");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("caseOriginDropdown");
//		 selenium.jsClick("caseOriginDropdown");
//		 selenium.waitingTime(2000);
//		 selenium.dropdownListClick("caseOriginOption");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("caseCXGProductDropdown");
//		 selenium.jsClick("caseCXGProductDropdown");
//		 selenium.waitingTime(2000);
//		 selenium.dropdownListClick("caseCXGProductOption");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("caseCXGIncidentDropdown");
//		 selenium.jsClick("caseCXGIncidentDropdown");
//		 selenium.waitingTime(2000);
//		 selenium.dropdownListClick("caseCXGIncidentOption");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("caseCXGSubIncidentDropdown");
//		 selenium.jsClick("caseCXGSubIncidentDropdown");
//		 selenium.waitingTime(2000);
//		 selenium.dropdownListClick("caseCXGSubIncidentOption");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("caseSubject");
//		 selenium.click("caseSubject");
//		 selenium.waitingTime(2000);
//		 selenium.type("caseSubject", "Subject");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("caseCXGInternalDescription");
//		 selenium.click("caseCXGInternalDescription");
//		 selenium.waitingTime(2000);
//		 selenium.type("caseCXGInternalDescription", "Internal Description");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeVisible("caseCXGInternalDescription");
//		 selenium.moveTab("caseCXGInternalDescription");
////		 selenium.waitingTime(2000);
//		 selenium.waitForElementToBeClickable("saveForVOC");
//		 selenium.jsClick("saveForVOC");
//		 System.out.println("clicked save");
//		 selenium.waitForElementToBeVisible("contactSuccessfulL");
//		 if(selenium.isElementPresentFast("contactSuccessfulL")) {
//		 selenium.test.log(LogStatus.PASS, "Case created successfully" );
//		 
//	 }
//		 
//		 else {
//			 selenium.test.log(LogStatus.FAIL, "Case not created" );
//			 selenium.reportFailure("Case not created");
//		 }
//	 }
//	 catch (Exception e) {
//		 selenium.jsClick("contactCloseButton");
//			selenium.reportFailure("Error while creating new case " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
// }
	
	@Then("^click on close case button to close case$")
    public void click_on_close_case_button_to_close_case() {
	 
	 try {
		 selenium.captureScreenShot();
//		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("Close_case");
		 selenium.jsClick("Close_case");
		 selenium.waitingTime(5000);
		 
	 }
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking on close case " + e.getMessage());
		}
 }
	
	@And("^fill mandatory fields to close Case$")
    public void fill_mandatory_fields_to_close_cxg_case() {
	 
	 try {
		 
		 selenium.jsClick("closingStatus");
		 selenium.waitingTime(2000);
		 selenium.selectDropdownText("closingStatus", "Close Status");
//		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("caseResolution");
		 selenium.click("caseResolution");
		 selenium.waitingTime(2000);
		 selenium.type("caseResolution", "Case Resolution");
//		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
		 selenium.jsClick("caseCXGCloseMarketDropdown");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Market", "end");
		 selenium.waitingTime(2000);
		 selenium.captureScreenShot();
//		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("saveButton");
		 selenium.jsClick("saveButton");
		 selenium.waitingTime(2000);
		 selenium.test.log(LogStatus.PASS, "Case closed successfully");
		 
	 }
		 
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while closing case " + e.getMessage());
		}
 }
	
//	 @Then("^verify the status of closed case$")
//	    public void verify_the_status_of_closed_case() {
//		 
//			try {
//
//				selenium.waitingTime(8000);
//				selenium.captureScreenShot();
////				selenium.waitingTime(2000);
//				selenium.waitForElementToBeVisible("caseClosedStatus");
//				String status = selenium.getTextLoop("caseClosedStatus");
//				String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
//				System.out.println("status" + status + expected_status);
//				boolean surveyFunctionalArea = selenium.isElementPresentFast("surveyFunctionalArea");
//
//				System.out.println("survey functional area" + surveyFunctionalArea);
//				selenium.waitingTime(2000);
//				selenium.refresh();
//				selenium.waitingTime(2000);
//				Boolean survry = selenium.isElementPresentFast("surveyErrorCode");
//				System.out.println(survry);
//				selenium.scrollToElement("reasonCodeVOCcheck");
//				selenium.waitingTime(3000);
//				selenium.captureScreenShot();
////				selenium.waitingTime(2000);
//				String surveyErrorCode = selenium.getTextLoop("surveyErrorCode");
//
//				String errorcode = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Code");
//				System.out.println("surveyErrorCode" + surveyErrorCode + errorcode);
//				selenium.test.log(LogStatus.INFO, "Status : "+status +" Expected status : "+expected_status);
//				selenium.test.log(LogStatus.INFO, "Survey Functional area : "+surveyFunctionalArea);
//				selenium.test.log(LogStatus.INFO, "Survey Error Code:"+surveyErrorCode +" Error Code : "+errorcode);
//				if (status.equalsIgnoreCase(expected_status) && (surveyFunctionalArea == true)) {
//					selenium.test.log(LogStatus.PASS, "Verified successfully");
//
//				} else {
//					selenium.test.log(LogStatus.FAIL, "Verification failed");
//					selenium.reportFailure("Verification failed");
//				}
//			}
//		 catch (Exception e) {
//			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				selenium.reportFailure("Error while verifying case details " + e.getMessage());
//			}
//	 }
// 
	
	
}
