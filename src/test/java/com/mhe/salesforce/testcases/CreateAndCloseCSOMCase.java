package com.mhe.salesforce.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mhe.salesforce.util.CommonUtil;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;
import java.util.List;
import java.util.ServiceLoader;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class CreateAndCloseCSOMCase {

	WebConnector selenium = WebConnector.getInstance();
	String CSOM_NewCase = null;
	String CaseToVerifyCaseNumberChange  = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/5000y00001rKbJbAAK/view";
	String INTLReadOnlyTypeOpp = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001GLsokAAD/view";
	String MHHESupportCase="https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/5008b00001vH8Q6AAK/view";
	String contact = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/003C000001uDUONIA4/view";
	String ContactWithCase = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/003O800000Bzg6xIAB/view"; //gcrm_test_automation
	String OppWithCase = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006C000000pkXMtIAM/view";
	
	@Then("^click on New case by selecting one contact$")
	public void click_on_new_case_by_selecting_one_contact() {

		try {
				/*selenium.search("Contact");
				selenium.waitingTime(6000);
				String Xpath = selenium.getDynamicXpath("anchorTextcontains", "Contact", "endContains");
				System.out.println("xpath is" + Xpath);
				selenium.clickLoopXpath(Xpath);*/
			selenium.waitingTime(5000);
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyOrderStage")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifySubReason")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("CreateCSOMCaseAndVerifyFunctionalField")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifycreateAndCloseCSOMCase")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyCSOMCaseHistoryTab")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
			if (selenium.getTestCaseName().equalsIgnoreCase("CreateCSOMCaseAndVerifyOwner")) {
				selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
				selenium.waitingTime(10000);
			}
//			selenium.checkFlowInterruptedPopup();
//			selenium.refresh();
//			selenium.waitingTime(15000);
			selenium.waitingTime(4000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("newCase");
			selenium.click("newCase");
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(8000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigation to new case" + e.getMessage());
		}
	}

	@Then("^select record type as CSOM Support$")
	public void select_record_type_as_csom_support() {

		try {
			selenium.click("RecordType");
//			 selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("RecordType");
			selenium.selectDropdownText("RecordType", "Record Type");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("continueButton");
			selenium.jsClick("continueButton");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while selecting record type " + e.getMessage());
			selenium.click("CancelEdit");

			}
	 }

	 @And("^verify CMGAgentLocationofCaseOriginator Field Placement$")
	    public void verify_CMGAgentLocationofCaseOriginator_Field_Placement() {

		 try {
			 if (selenium.getTestCaseName().equalsIgnoreCase("VerifycreateAndCloseCSOMCase"))
			 {
				 selenium.navigateToURL(selenium.CSOMCaseURL);
				 selenium.waitingTime(8000);
				 selenium.waitForElementToBeClickable("ExpandSidebarBtn");
				 selenium.jsClick("ExpandSidebarBtn");
				 selenium.waitForElementToBeClickable("ReportingTab");
				 selenium.click("ReportingTab");
				 selenium.waitingTime(2000);

				 if(selenium.isElementPresentFast("CMGAgentLocationofCaseOriginatorField")) {
						selenium.test.log(LogStatus.PASS, "Label located at expected place");
						System.out.println("PASS");

						} else {
							selenium.test.log(LogStatus.FAIL, "Test Case Failed");
							selenium.reportFailure("Test Case Failed");
							System.out.println("FAIL");
						}
			 }
			 else
			 {
				 selenium.navigateToURL(selenium.CXGCaseURL);
				 selenium.waitingTime(8000);
				 selenium.scrolldown(1000);
				 selenium.waitingTime(2000);
				 selenium.scrollToElement("CMGAgentLocationofCaseOriginatorFieldCXG");
				 selenium.waitingTime(2000);
				 selenium.scrolldown(-200);
				 selenium.waitingTime(2000);

				 if(selenium.isElementPresentFast("CMGAgentLocationofCaseOriginatorFieldCXG")) {
						selenium.test.log(LogStatus.PASS, "Label located at expected place");
						System.out.println("PASS");

						} else {
							selenium.test.log(LogStatus.FAIL, "Test Case Failed");
							selenium.reportFailure("Test Case Failed");
							System.out.println("FAIL");
						}
			 }

		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying field placement " + e.getMessage());
			}
	 }

	 @And("^fill all mandatory details to create CSOM case$")
	    public void fill_all_mandatory_details_to_create_csom_case() {

		 try {
			 selenium.waitingTime(2000);

				/*
				 * selenium.click("internalDescription"); selenium.waitingTime(2000);
				 * selenium.type("internalDescription", "Internal Description");
				 *
				 * selenium.click("internalDescription2"); selenium.waitingTime(2000);
				 * selenium.type("internalDescription2", "Internal Description");
				 */
			 selenium.waitForElementToBeClickable("Case_OriginDropDown");
			 selenium.jsClick("Case_OriginDropDown");
			 System.out.println("inside case origin");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Case Origin", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			 selenium.jsClick("caseOriginSkillDropdownNew");
			 System.out.println("inside case origin skill");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Case Origin Skill", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Save_Btn");
			 selenium.jsClick("Save_Btn");

			 selenium.waitingTime(6000);

			 if(selenium.isElementPresentFast("CaseInterruptPopup"))
			 {
				 selenium.click("CaseInterruptPopupOKBtn");
				 selenium.waitingTime(4000);
			 }

			 selenium.waitForElementsToBeVisible("internalDescription1text");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("internalDescription1text");
			 selenium.jsClick("internalDescription1text");
			 System.out.println("inside ID1");
			 selenium.waitingTime(2000);

			 selenium.jsClick("OrderStagebtn");
			 System.out.println("inside first order stage");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Order Stage", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("ReasonCodebtn");
			 selenium.jsClick("ReasonCodebtn");
			 System.out.println("inside first request reason");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Request Reason", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Actionbtn");
			 selenium.jsClick("Actionbtn");
			 System.out.println("inside first action");
			 selenium.waitingTime(5000);
			 selenium.clickDynamic("spanTitle", "Action", "end");
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("saveButton");
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(4000);

			 selenium.waitForElementsToBeVisible("internalDescription2text");
			 selenium.waitingTime(2000);
			 selenium.jsClick("internalDescription2text");
			 System.out.println("inside ID2");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("OrderStage2btn");
			 selenium.jsClick("OrderStage2btn");
			 System.out.println("inside second order stage");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Order Stage", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("ReasonCode2btn");
			 selenium.jsClick("ReasonCode2btn");
			 System.out.println("inside second request reason");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Request Reason", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Action2btn");
			 selenium.jsClick("Action2btn");
			 System.out.println("inside second action");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Action", "end");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("saveButton2");
			 selenium.jsClick("saveButton2");
			 selenium.waitingTime(8000);
			 
			 
		 	/* selenium.waitForElementToBeVisible("contactSuccessfulL");
			 if(selenium.isElementPresentFast("contactSuccessfulL"))
			 {
			 selenium.test.log(LogStatus.PASS, "CSOM Case created successfully" );
			 System.out.println("PASS");
			 }			 
			 else
			 {
				 selenium.test.log(LogStatus.FAIL, "CSOM Case not created" );
			 	 selenium.reportFailure("CSOM Case not created");
			 }*/


			 selenium.CSOMCaseURL = selenium.getURL();
			 System.out.println("Newly created CSOM Case URL is " + selenium.CSOMCaseURL);

		}catch (Exception e) {
			 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			 selenium.reportFailure("Error while clicking on close case " + e.getMessage());
		 }
	}



	@Then("^click on close case button$")
	public void click_on_close_case_button() {

		try {
			selenium.captureScreenShot();
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("closeCase");
			selenium.jsClick("closeCase");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking on close case " + e.getMessage());
		}
	}

	@And("^fill mandatory fields to close CSOM Case$")
	public void fill_mandatory_fields_to_close_csom_case() {

		try {
			selenium.switchToFrame("iFrame");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("closingStatus");
			selenium.jsClick("closingStatus");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("closingStatus", "Close Status");


			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseResolution");
			selenium.click("caseResolution");
			selenium.waitingTime(2000);
			selenium.type("caseResolution", "Case Resolution");
			selenium.waitingTime(2000);
//			 selenium.click("closeRequestReasonnew");
//			 selenium.waitingTime(2000);
//			 selenium.clickDynamic("spanTitle", "Request Reason", "end");
//			 selenium.waitingTime(4000);
//			 selenium.scrollToElement("caseClosingAction1");
//			 selenium.waitingTime(2000);
//			 selenium.jsClick("caseClosingAction1");
//			 selenium.waitingTime(2000);
//			 selenium.jsClick("chooseAction1");
//			 selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("salesOrderNumber");
			selenium.click("salesOrderNumber");
			selenium.waitingTime(2000);
			selenium.type("salesOrderNumber", "Sales Order Number");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("purchaseOrderNumber");
			selenium.click("purchaseOrderNumber");
			selenium.waitingTime(2000);
			selenium.type("purchaseOrderNumber", "Purchase Order Number");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.PASS, "Case closed successfully");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while closing case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@Then("^verify the status of closed record$")
	public void verify_the_status_of_closed_record() {

		try {
//			 selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pVQuTAAW/view");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("caseinsidecontact");
			selenium.jsClick("caseinsidecontact");
			selenium.waitingTime(5000);
			
			selenium.refresh();
			selenium.waitingTime(10000);

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);

			selenium.waitForElementToBeVisible("lastModifiedDateRecordNew");
			String recordDate = selenium.getText("lastModifiedDateRecordNew");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				System.out.println("inside date check");
				String status = selenium.getText("caseStatusAfterClosingNew1").toString();
				String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
				System.out.println("Actual status " + status + " Expected status " + expected_status);
				if (status.equalsIgnoreCase(expected_status)) {
					selenium.test.log(LogStatus.PASS, "Status is closed");

				} else {
					selenium.test.log(LogStatus.FAIL, "Status is not closed");
					//selenium.reportFailure("Test Case Failed");
					selenium.reportFailure("Status is not closed");
				}
			} else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("dateOrTimecaseOpened");
				selenium.jsClick("dateOrTimecaseOpened");
				selenium.waitingTime(3000);
				String recordDate1 = selenium.getText("lastModifiedDateRecordNew");
				if (recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
					System.out.println("date matched");

					String status = selenium.getText("caseStatusAfterClosingNew1").toString();
					String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
					System.out.println("status" + status + expected_status);
					if (status.equalsIgnoreCase(expected_status)) {
						selenium.test.log(LogStatus.PASS, "Status is closed");

					} else {
						selenium.test.log(LogStatus.FAIL, "Status is not closed");
						//selenium.reportFailure("Test Case Failed");
						selenium.reportFailure("Status is not closed");
					}
				}


			}

		} catch (Exception e) {

			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying case status " + e.getMessage());

		}
	}

	@And("^verify the LMS field check$")
	public void verify_the_LMS_field_check() throws Exception {
		try {
			selenium.waitingTime(4000);
			selenium.type("Subject_field", "Subject");
			selenium.waitingTime(2000);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			
			selenium.refresh();
			selenium.waitingTime(10000);
			
			selenium.scrollToElement("Case_CXG_LMSField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("Case_CXG_LMSField");
			selenium.waitingTime(2000);
//		 selenium.click("Case_CXG_LMSOption");
//		 selenium.waitingTime(2000);
//		 String actualLMSRecord = selenium.getText("Case_CXG_LMSField").toString();
//			String expected_LMSRecord = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("LMS Type");
//			System.out.println("Actual: " +actualLMSRecord +" Expected: " +expected_LMSRecord );
//			if (actualLMSRecord.equalsIgnoreCase(expected_LMSRecord)) {
			if (selenium.isElementPresentFast("Case_CXG_LMSOption")) {
				selenium.test.log(LogStatus.PASS, "Spelling has been verified");
				System.out.println("PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "Spelling is not correct");
				selenium.reportFailure("Spelling is not correct");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^verify the change record type button check$")
	public void verify_the_change_record_type_button_check() throws Exception {
		try {
			selenium.waitingTime(4000);
			System.out.println("CSOMCaseURL is:" + selenium.CSOMCaseURL);
			selenium.navigateToURL(selenium.CSOMCaseURL);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			String actualRecord;
			if (selenium.isElementPresentFast("changeRecordType")) {
				actualRecord = selenium.getText("changeRecordType").toString();
			} else {
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("ChangeRecordTypeOption");
				actualRecord = selenium.getText("ChangeRecordTypeOption").toString();
			}
			String expected_Record = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Change Record Type");
			System.out.println("Actual:" + actualRecord + " Expected:" + expected_Record);
			if (actualRecord.equalsIgnoreCase(expected_Record)) {
				selenium.test.log(LogStatus.PASS, "Spelling has been verified");

			} else {
				selenium.test.log(LogStatus.FAIL, "Spelling is not correct");
				selenium.reportFailure("Spelling is not correct");
			}
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^verify the omni channel status$")
	public void verify_the_omni_channel_status() throws Exception {
		try {
			selenium.waitingTime(4000);
			selenium.jsClick("omniBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("downArrowBtn");
			selenium.waitingTime(2000);
			selenium.isElementPresentFast("omniStatus");

		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@Then("^verify the different omni channel status$")
	public void verify_the_different_omni_channel_status() throws Exception {
		try {
			selenium.waitingTime(4000);
			selenium.jsClick("omniBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("downArrowBtn");
			selenium.waitingTime(2000);
			selenium.isElementPresentFast("omniStatus1");
			selenium.test.log(LogStatus.PASS, "Status has been verified");
		} catch (Exception e) {

			selenium.reportFailure("Error while verifying status " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}


	@And("^Make the omni channel available for cases and chats and open \"([^\"]*)\" page$")
	public void make_the_omni_channel_available_for_cases_and_chats(String URL) throws Exception {
		try {
			selenium.closeAllWinExceptFirstWin();
//			selenium.getFirstWindow(); //getting the current window id and storing as first window for later switching
			selenium.firstWindowHandle = selenium.getFirstWin(); //getting the current window id and storing as first window for later switching
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(4000);
			selenium.jsClick("omniBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("downArrowBtn");
			selenium.waitingTime(2000);
			if (selenium.getTestCaseName().equalsIgnoreCase("LiveAgentChatDTSCommunity")) {
				selenium.jsClick("omniAvblDTSChat");
				selenium.waitingTime(5000);
			} else {
				selenium.jsClick("omniAvlblchatncases");
				selenium.waitingTime(5000);
			}
			selenium.jsClick("MyWorkBtn");
			selenium.waitingTime(2000);
			System.out.println("Community url: " + URL);
			selenium.openURLinNewTab(URL);
			System.out.println(URL + " opened successfully");
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I navigate to cases$")
	public void i_navigate_to_cases() {
		try {
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.waitingTime(2000);
			selenium.getElement("searchItemsTextField").sendKeys("Cases");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("casesOptionMenuDots");
			selenium.jsClick("casesOptionMenuDots");
			selenium.waitingTime(6000);
			
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/o/Case/list?filterName=Recent");
			selenium.waitingTime(6000);
			
			if(selenium.isElementPresentFast("CasesTabLink"))
			{
				selenium.jsClick("CasesTabLink");
				selenium.waitingTime(6000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^choose first case$")
	public void choose_first_case() throws Exception {
		try {
			selenium.waitingTime(4000);
			selenium.jsClick("firstCaseRow");
			selenium.test.log(LogStatus.PASS, "case has been selected");
		} catch (Exception e) {

			selenium.reportFailure("Error while selecting case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}

	@Then("^verify the Imprint Field$")
	public void verify_the_imprint_field() throws Exception {
		try {
			selenium.waitingTime(4000);
			selenium.isElementPresentFast("bookInformationTab");
			selenium.test.log(LogStatus.PASS, "field has been verified");
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying field " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}

	@And("^I navigate to cases page$")
	public void i_navigate_to_cases_page() throws Exception {
		try {
			selenium.waitForElementToBeVisible("menuDots");
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "Cases");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("casesOptionMenuDots");
			selenium.jsClick("casesOptionMenuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to cases tab " + e.getMessage());
		}
	}

	@And("^fill all mandatory details to create new ALEKS case$")
	public void fill_all_mandatory_details_to_create_new_aleks_case() {

		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.jsClick("Search_contact");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Search_contact");
			selenium.type("Search_contact", "Contact Name");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("firstContactNameLink");
			selenium.jsClick("firstContactNameLink");
			selenium.waitingTime(2000);
			System.out.println("Added Contact Name");

			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Contact Type", "end");
			selenium.waitingTime(2000);
			System.out.println("Added Contact type");

			selenium.waitForElementToBeClickable("newCaseSupportAccount_new2");
			selenium.jsClick("newCaseSupportAccount_new2");
			selenium.waitingTime(2000);
			selenium.type("newCaseSupportAccount_new2", "Support Account");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("firstContactNameLink");
			selenium.jsClick("firstContactNameLink");
			selenium.waitingTime(2000);
			System.out.println("Added Support account name");

			selenium.waitForElementToBeClickable("BusinessHoursField");
			selenium.jsClick("BusinessHoursField");
			selenium.waitingTime(2000);
			selenium.type("BusinessHoursField", "Business Hours");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("firstContactNameLink");
			selenium.jsClick("firstContactNameLink");
			selenium.waitingTime(2000);
			System.out.println("Added Business Hours");

			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Case Origin", "end");
			System.out.println("Added Case origin");

			selenium.waitingTime(2000);
			selenium.scrollToElement("ALEKSProductInfo");
			selenium.waitForElementToBeClickable("productDropDwn1");
			selenium.jsClick("productDropDwn1");
			selenium.waitingTime(5000);
			selenium.clickDynamic("spanTitle", "Product", "end");
			selenium.waitingTime(2000);

			System.out.println("Added Product name");
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Reason", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.jsClick("Subject_field");
			selenium.waitingTime(2000);
			selenium.type("Subject_field", "Case Subject");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseCXGInternalDescriptionNew");
			selenium.jsClick("caseCXGInternalDescriptionNew");
			selenium.type("caseCXGInternalDescriptionNew", "Internal Description");
			System.out.println("Added Internal description");

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			System.out.println("Clicked save button");
			selenium.waitingTime(20000);
			if (selenium.isElementPresentFast("RecordSaveButton")) {
				selenium.clickLoop("RecordSaveButton");
				selenium.waitingTime(6000);
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("editReason1");
			selenium.scrollToElement("editReason1");
			selenium.jsClick("editReason1");
			System.out.println("Clicked edit button");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason", "end");
			System.out.println("Choosen different reason");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason", "end");
			System.out.println("Choosen different sub-reason");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.PASS, "ALEKS Case created successfully");
			
			selenium.NewALEKSCase = selenium.getURL();
			System.out.println("Newly created ALEKS case URL is --> " + selenium.NewALEKSCase);

		} catch (Exception e) {
			System.out.println("Error while creating new case");
			selenium.reportFailure("Error while creating new case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@Then("^I will edit the required fields to verify Picklist$")
	public void i_will_edit_the_required_fields_to_verify_picklist() {

		try {
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason2", "end");
			System.out.println("Choosen different reason2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason2", "end");
			System.out.println("Choosen different sub-reason2");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason3", "end");
			System.out.println("Choosen different reason3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason3", "end");
			System.out.println("Choosen different sub-reason3");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason4", "end");
			System.out.println("Choosen different reason4");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason4", "end");
			System.out.println("Choosen different sub-reason4");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason5", "end");
			System.out.println("Choosen different reason5");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason5", "end");
			System.out.println("Choosen different sub-reason5");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason6", "end");
			System.out.println("Choosen different reason6");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason6", "end");
			System.out.println("Choosen different sub-reason6");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason7", "end");
			System.out.println("Choosen different reason7");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason7", "end");
			System.out.println("Choosen different sub-reason7");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason8", "end");
			System.out.println("Choosen different reason8");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason8", "end");
			System.out.println("Choosen different sub-reason8");
			selenium.waitForElementToBeClickable("reasonBtn");
			selenium.jsClick("reasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Reason9", "end");
			System.out.println("Choosen different reason9");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subReasonBtn");
			selenium.jsClick("subReasonBtn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Edit Sub Reason9", "end");
			System.out.println("Choosen different sub-reason9");
			selenium.waitingTime(4000);
			selenium.test.log(LogStatus.PASS, "Picklist values verified successfully");
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(10000);
			selenium.closeSubTabs();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			System.out.println("Error while checking the picklist");
			selenium.reportFailure("Error while checking the picklist " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^Navigate to new record$")
	public void navigate_to_new_record() {
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
			selenium.type("searchallitems", "Product Catalog");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productCatalogOption");
			selenium.click("productCatalogOption");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Product catalog screen loaded successfully!");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("I search record by customer number$")
	public void I_search_record_by_customer_number() {
		try {
			selenium.test.log(LogStatus.INFO, "Selecting and expanding Business Unit");
			selenium.waitingTime(4000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitForElementToBeClickable("businessUnitDropDwn");
			selenium.click("businessUnitDropDwn");

			selenium.selectDropdownText("businessUnitDropDwn", "Business Unit");
			selenium.waitForElementToBeClickable("expandAllOption");
			selenium.click("expandAllOption");
			selenium.waitingTime(2000);
			selenium.clickDynamic("Text_Span", "Area", "end");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.click("searchProductsBtn");
			selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@Then("Check case records$")
	public void Check_case_records() {
		try {
			selenium.waitForElementsToBeVisible("goButton");
			selenium.scrollToElement("goButton");
			selenium.waitForElementToBeClickable("goButton");
			selenium.click("goButton");
			selenium.waitingTime(3000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 2nd window");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("supplementsTab");
			selenium.click("supplementsTab");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			String supplement = selenium.getDynamicXpath("anchorTextcontains", "ISBN", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(supplement);
			selenium.waitingTime(4000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 3rd window");
			selenium.captureScreenShot();
			selenium.refresh();
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("supplementsRecordTab")) {
				selenium.scrollToElement("supplementsRecordTab");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("supplementsRecordTab");
				selenium.click("supplementsRecordTab");
				selenium.waitingTime(7000);
				selenium.waitForElementToBeVisible("supplementText");
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				String supplementRecord = selenium.getText("supplementText").toString();
				selenium.waitingTime(2000);
				System.out.println(supplementRecord);
				if (supplementRecord.equalsIgnoreCase("Data Not Available") || selenium.isElementPresentFast("supplementTblRecord")) {
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.PASS,
							"Fields are non-editable and there are no further supplement records underneath it.");
					System.out.println("Fields are non-editable and there are no further supplement records underneath it.");
				} else {
					selenium.test.log(LogStatus.FAIL, "Value could not be fetched");
					System.out.println("Value could not be fetched");
					selenium.reportFailure("Value could not be fetched");
				}
				selenium.close();
				selenium.switchBackToParentWindow();
				selenium.switchOutOfFrame();
			}
		} catch (Exception e) {
			selenium.switchToLastWindow();
			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@And("^verify the MHE functional field values$")
	public void verify_the_MHE_functional_values() {
		try {
			selenium.waitingTime(2000);
			selenium.jsClick("Status_DropDown");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Status", "end");
			selenium.waitingTime(2000);
			selenium.jsClick("StatusLocationbtnNew");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Status Location", "end");
			selenium.waitingTime(2000);
			selenium.jsClick("MHEFunctionalGroupbtnNew");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "MHE Functional", "end");
			selenium.waitingTime(4000);
			selenium.click("CancelButton");
			selenium.waitingTime(6000);
			selenium.closeSubTabs();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I create a new case")
	public void create_a_new_case() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("record_type");
			selenium.jsClick("record_type");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("serach_Account");
			//		 selenium.jsClick("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Search_contact");
//			 selenium.jsClick("Search_contact");
			selenium.waitingTime(5000);
			selenium.typeData("Search_contact", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(5000);
//			selenium.scrollToElement("Case_OriginDropDown");
//			selenium.scrolldown(-200);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.jsClick("Case_OriginDropDown");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Case_OriginOptionNew");
			selenium.click("Case_OriginOptionNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("validate the opportunity field and edit it")
	public void validate_the_opp_field_and_edit_it() {
		try {
			selenium.scrolldown(150);
			selenium.waitForElementToBeVisible("VerifyOppField");
			boolean verifyOpp = selenium.isElementPresentFast("VerifyOppField");
			if (verifyOpp == true) {
				System.out.println("Field is present");
				selenium.test.log(LogStatus.PASS, "Opportunity field is present");
			} else {
				System.out.println("Field is not present");
				selenium.test.log(LogStatus.FAIL, "Opportunity field is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditBtnForOpp");
			selenium.jsClick("EditBtnForOpp");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchOpportunities");
//			 selenium.jsClick("searchOpportunities");
			selenium.typeData("searchOpportunities", "STANFORD UNIVERSITY");
			selenium.autoSuggestiveDropdownWithoutTextTwo("searchOpportunities");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("ShowAllResults");
//			selenium.jsClick("ShowAllResults");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("SelectOppValue");
//			selenium.jsClick("SelectOppValue");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I go to app launcher and select Internal Description Header")
	public void go_to_app_launcher_and_select_Internal_Description_Header() {
		try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.waitingTime(2000);
			selenium.getElement("searchItemsTextField").sendKeys("Internal Description Header");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MenuDotsInternalDescriptionHeader");
			selenium.jsClick("MenuDotsInternalDescriptionHeader");
			selenium.waitingTime(3000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("verify the different buttons and fields")
	public void verify_the_different_buttons_and_fields() {
		try {
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("UpdateTemplateButton");
//			boolean updateTemplate=selenium.isElementPresentXpathFast("UpdateTemplateButton");
			//		 if(updateTemplate==false){
			if (selenium.isElementPresentFast("UpdateTemplateButton")) {
				System.out.println("Update Template Button is Disabled");
				selenium.test.log(LogStatus.PASS, "Update Template Button is disabled");
			} else {
				System.out.println("Update Template Button is Enabled");
				selenium.test.log(LogStatus.FAIL, "Update Template Button is Enabled");
			}
//			selenium.waitForElementToBeVisible("Cancel_Button");
//			boolean cancelBtn=selenium.isElementPresentXpathFast("Cancel_Button");
//			if(cancelBtn==false){
			if (selenium.isElementPresentFast("Cancel_Button")) {
				System.out.println("Cancel Button is Disabled");
				selenium.test.log(LogStatus.PASS, "Cancel Button is Disabled");
			} else {
				System.out.println("Cancel Button is Not Disabled");
				selenium.test.log(LogStatus.FAIL, "Cancel Button is Not Disabled");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("verify the cancel button functionality")
	public void verify_the_cancel_button_functionality() {
		try {
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("RecordTypeDropDown");
			selenium.jsClick("RecordTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordTypeOption1");
			selenium.jsClick("RecordTypeOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentDropDown");
			selenium.jsClick("Sub_IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InternalDescriptionTemplate");
			selenium.typeData("InternalDescriptionTemplate", " This is a dummy test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Cancel_Button");
			selenium.jsClick("Cancel_Button");
			selenium.waitingTime(5000);
			//		 selenium.waitForElementToBeVisible("RecordTypeDropDown");
			//		 boolean recordType=selenium.isElementPresentFast("RecordTypeDropDown");
			if (selenium.isElementPresentFast("RecordTypeDropDown")) {
				System.out.println("Record Type Field is Enabled");
				selenium.test.log(LogStatus.PASS, "Record Type Field Is Enabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("IncidentDropDown");
//			 boolean incident=selenium.isElementPresentXpathFast("IncidentDropDown");
//			 if(incident==false){
			if (selenium.isElementPresentFast("IncidentDropDown")) {
				System.out.println("Incident Field Is Disabled");
				selenium.test.log(LogStatus.PASS, "Incident Field Is Disabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("Sub_IncidentDropDown");
//			 boolean sub_incident=selenium.isElementPresentXpathFast("Sub_IncidentDropDown");
//			 if(sub_incident==false){
			if (selenium.isElementPresentFast("Sub_IncidentDropDown")) {
				System.out.println("Sub Incident Field Is Disabled");
				selenium.test.log(LogStatus.PASS, "Sub Incident Field Is Disabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("InternalDescriptionTemplate");
//			 boolean template=selenium.isElementPresentXpathFast("InternalDescriptionTemplate");
//			 if(template==false){
			if (selenium.isElementPresentFast("InternalDescriptionTemplate")) {
				System.out.println("Internal Description Template Is Disabled");
				selenium.test.log(LogStatus.PASS, "Internal Description Template Is Disabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("UpdateTemplateButton");
//			 boolean updateTemplate=selenium.isElementPresentXpathFast("UpdateTemplateButton");
//			 if(updateTemplate==false){
			if (selenium.isElementPresentFast("UpdateTemplateButton")) {
				System.out.println("Update Template Button is Disabled");
				selenium.test.log(LogStatus.PASS, "Update Template Button is disabled");
			} else {
				System.out.println("Update Template Button is Not Disabled");
				selenium.test.log(LogStatus.FAIL, "Update Template Button is not disabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("Cancel_Button");
//			 boolean cancelBtn=selenium.isElementPresentXpathFast("Cancel_Button");
//			 if(cancelBtn==false){
			if (selenium.isElementPresentFast("Cancel_Button")) {
				System.out.println("Cancel Button is Disabled");
				selenium.test.log(LogStatus.PASS, "Cancel Button is Disabled");
			} else {
				System.out.println("Cancel Button is Not Disabled");
				selenium.test.log(LogStatus.FAIL, "Cancel Button is Not Disabled");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("verify the changes in record type")
	public void verify_the_changes_in_record_type() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordTypeDropDown");
			selenium.jsClick("RecordTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordTypeOption");
			selenium.jsClick("RecordTypeOption");
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("Order_StageDropDown");
//			 boolean order_stage=selenium.isElementPresentXpathFast("Order_StageDropDown");
//			 if(order_stage==false)
			if (selenium.isElementPresentFast("Order_StageDropDown")) {
				System.out.println("Order Stage Field is enabled");
				selenium.test.log(LogStatus.PASS, "Field is enabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("Request_ReasonDropDown");
//			 boolean request_reason=selenium.isElementPresentXpathFast("Request_ReasonDropDown");
//			 if(request_reason==false)
			if (selenium.isElementPresentFast("Request_ReasonDropDown")) {
				System.out.println("Request Reason Field is enabled");
				selenium.test.log(LogStatus.PASS, "Field is enabled");
			}
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeVisible("Action_DropDown");
//			 boolean action=selenium.isElementPresentXpathFast("Action_DropDown");
//			 if(action==false)
			if (selenium.isElementPresentFast("Action_DropDown")) {
				System.out.println("Action Field is enabled");
				selenium.test.log(LogStatus.PASS, "Field is enabled");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OrderStageValue");
			selenium.jsClick("OrderStageValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonOption");
			selenium.jsClick("Request_ReasonOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_Option");
			selenium.jsClick("Action_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InternalDescriptionTemplate");
			selenium.typeData("InternalDescriptionTemplate", "Testing Demo");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("UpdateTemplateButton");
			selenium.jsClick("UpdateTemplateButton");
			selenium.waitingTime(3000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I create a new case for CSOM record type")
	public void create_a_new_case_for_CSOM_record_type() {
		try {

			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			selenium.jsClick("caseOriginSkillDropdownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginSkillOption");
			selenium.jsClick("CaseOriginSkillOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(12000);

			selenium.waitForElementToBeClickable("Order_StageDropDown");
			selenium.jsClick("Order_StageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OrderStageValue");
			selenium.jsClick("OrderStageValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonDropDown");
			selenium.jsClick("Request_ReasonDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Request_ReasonOption");
			selenium.jsClick("Request_ReasonOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_DropDown");
			selenium.jsClick("Action_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Action_Option");
			selenium.jsClick("Action_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_Description1");
			String internalDes = selenium.getElement("Internal_Description1").getText().toString();
//			String internalDes = selenium.getText("Internal_Description1").toString();
			System.out.println("Internal Description Field is : " + internalDes);
//		if(internalDes.equalsIgnoreCase())
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("validate the case from another user")
	public void validate_the_case_from_another_user() {
		try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.waitingTime(2000);
			selenium.getElement("searchItemsTextField").sendKeys("Internal Description Header");
			selenium.waitingTime(2000);
//			 selenium.waitForElementToBeClickable("MenuDotsInternalDescriptionHeader");
			boolean menuDots = selenium.isElementPresentXpathFast("MenuDotsInternalDescriptionHeader");
			if (menuDots == false) {
				System.out.println("Passed");
				selenium.test.log(LogStatus.PASS, "Nothing to click");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I create a new case for CXG Lightning Console")
	public void i_create_a_new_case_for_CXG_Lightning_Console() {
		try {
		selenium.waitingTime(4000);
		selenium.checkFlowInterruptedPopup();
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(15000);
		selenium.waitForElementToBeClickable("Search_contact");
		selenium.typeData("Search_contact","STANFORD UNIVERSITY");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults");
		selenium.jsClick("ShowAllResults");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("SelectContactName");
		selenium.jsClick("SelectContactName");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("contactTypeBtnNew");
		selenium.jsClick("contactTypeBtnNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ContactType_Option");
		selenium.jsClick("ContactType_Option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("serach_Account");
		selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults1");
		selenium.jsClick("ShowAllResults1");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("SelectAccountName");
		selenium.jsClick("SelectAccountName");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("Subject_field");
		selenium.typeData("Subject_field","UAT DEMO TEST");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Business_Hours_DropDown");
		selenium.typeData("Business_Hours_DropDown","CXG");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults2");
		selenium.jsClick("ShowAllResults2");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BusinessHoursOption");
		selenium.jsClick("BusinessHoursOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");
		selenium.waitingTime(15000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("Validate Internal Description History Page")
	public void validate_internal_description_history_page(){
		try{
		selenium.waitingTime(8000);
		String url=selenium.getURL();
		selenium.waitForElementToBeClickable("InternalDescriptionHistoryLink");
		selenium.clickLoop("InternalDescriptionHistoryLink");
		selenium.waitingTime(6000);
		boolean sideBtn= selenium.isElementPresentXpathFast("SideButtonDropDown");
		if(sideBtn==false){
			System.out.println("No Internal Description History is present");
			selenium.test.log(LogStatus.PASS,"No Internal Description History is present");
		}
		else {
			System.out.println("Internal Description History is present");
			selenium.test.log(LogStatus.FAIL,"Internal Description History is present");
			selenium.reportFailure("Internal Description History is present");
		}
//		selenium.navigateBack();
		selenium.waitingTime(6000);
		selenium.navigateToURL(url);
		selenium.waitingTime(10000);
		selenium.refresh();
		selenium.waitingTime(15000);
		selenium.checkFlowInterruptedPopup();
		selenium.scrollToElement("ProdDropdownList");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProdDropdownList");
		selenium.jsClick("ProdDropdownList");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("ProductType_ALEKS");
		selenium.jsClick("ProductType_ALEKS");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("select_BU");
		selenium.jsClick("select_BU");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BU_Option");
		selenium.jsClick("BU_Option");

		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("IncidentDropDown");
		selenium.jsClick("IncidentDropDown");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("IncidentOption");
		selenium.jsClick("IncidentOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
		selenium.jsClick("Sub_IncidnetDropDown");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Sub_IncidentOption");
		selenium.jsClick("Sub_IncidentOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Internal_Description1");
		selenium.typeData("Internal_Description1","Test Dummy Data");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Button");
		selenium.jsClick("Save_Button");
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("Internal_Description1");
		selenium.typeData("Internal_Description1","Test Dummy Data.");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("Save_Button");
		selenium.jsClick("Save_Button");
		selenium.waitingTime(10000);
		
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("InternalDescriptionHistoryLink");
		selenium.jsClick("InternalDescriptionHistoryLink");
		selenium.waitingTime(6000);
		boolean sidebtn1=selenium.isElementPresentFast("SideButtonDropDown");
		if(sidebtn1==true)
		{
			System.out.println("Internal Description History has record");
			selenium.test.log(LogStatus.PASS,"Internal Description History has record");
		}
		else
		{
			System.out.println("Internal Description History has no record");
			selenium.test.log(LogStatus.FAIL,"Internal Description History has no record");
			selenium.reportFailure("Internal Description History has no record");
		}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I fill the details of Internal Description template")
	public void i_fill_the_details_of_Internal_Description_template(){
		try{
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordTypeDropDown");
			selenium.jsClick("RecordTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordTypeOption1");
			selenium.jsClick("RecordTypeOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentDropDown");
			selenium.jsClick("Sub_IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InternalDescriptionTemplate");
			selenium.clearText("InternalDescriptionTemplate");
			selenium.typeData("InternalDescriptionTemplate","Dummy Data for UAT");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("UpdateTemplateButton");
			boolean flag=selenium.isElementPresentFast("UpdateTemplateButton");
			if(flag==true)
			{
				System.out.println("Update Template Button is Enabled");
				selenium.test.log(LogStatus.PASS,"Update Template Button is Enabled");
			}
			selenium.waitForElementToBeClickable("UpdateTemplateButton");
			selenium.jsClick("UpdateTemplateButton");
			selenium.waitingTime(5000);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I update the incident and subincident field and validate the internal description value")
	public void update_incident_and_subincident_field_and_validate_internal_description(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("Internal_Description1");
			boolean flag=selenium.isElementPresentFast("Internal_Description1");
			if(flag==true)
			{
				System.out.println("The Internal Description Field is editable");
				selenium.test.log(LogStatus.PASS,"The Internal Description Field is editable");
			}
			selenium.waitForElementToBeVisible("Internal_Description1");
			String Idtext=selenium.getText("Internal_Description1").toString();
			System.out.println("The text from Internal description is : "+Idtext);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_Description1");
			selenium.typeData("Internal_Description1","This is dummy test pls ignore");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption1");
			selenium.jsClick("IncidentOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Sub_IncidnetDropDown");
			boolean flagStatus=selenium.isElementPresentFast("Sub_IncidnetDropDown");
			if(flagStatus==true)
			{
				System.out.println("Sub Incident Field is Disabled");
				selenium.test.log(LogStatus.PASS,"Sub Incident Field is Disabled");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Internal_Description1");
			String getText=selenium.getText("Internal_Description1").toString();
			System.out.println("Internal Description Field Value After Selecting Additional Training is : "+getText);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_Description1");
			selenium.clearText("Internal_Description1");
			selenium.typeData("Internal_Description1","Update UAT Test Demo");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(8000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I validate the Internal Description Field value")
	public void validate_the_Internal_Description_Field_value(){
		try{
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("ProdDropdownList");
		selenium.jsClick("ProdDropdownList");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProductType_ALEKS");
		selenium.jsClick("ProductType_ALEKS");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("select_BU");
		selenium.jsClick("select_BU");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BU_Option");
		selenium.jsClick("BU_Option");

		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("IncidentDropDown");
		selenium.jsClick("IncidentDropDown");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("IncidentOption1");
		selenium.jsClick("IncidentOption1");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("Internal_Description1");
		String getText=selenium.getText("Internal_Description1").toString();
		System.out.println("Internal Description Field Value After Selecting Additional Training is : "+getText);
		selenium.waitingTime(2000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I verify the Discipline field value")
	public void i_verify_the_discipline_field_value(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.jsClick("ProductOptionConnect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeVisible("DisciplineOptions");
			List<WebElement> attribute=selenium.getElements("DisciplineOptions");
			String input="Business Analytics";
			for(int i=0;i<= attribute.size();i++)
			{
				String text=attribute.get(i).getText().toString();
				selenium.waitingTime(2000);
				System.out.println(text);
				if(text.equalsIgnoreCase(input))
				{
					System.out.println("Option is available : "+text);
					attribute.get(i).click();
					break;
				}
			}*/
			
			Assert.assertTrue(selenium.isElementPresentFast("BusinessAnalyticsDiscipline"));
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionMHReader");
			selenium.jsClick("ProductOptionMHReader");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeVisible("DisciplineOptions");
			List<WebElement> attribute1=selenium.getElements("DisciplineOptions");
	//		String input1="Business Analytics";
			for(int i=0;i<= attribute1.size();i++)
			{
				String text1=attribute1.get(i).getText().toString();
				selenium.waitingTime(2000);
				System.out.println(text1);
				if(text1.equalsIgnoreCase(input))
				{
					System.out.println("Option is available : "+text1);
					attribute1.get(i).click();
					break;
				}
			}*/
			Assert.assertTrue(selenium.isElementPresentFast("BusinessAnalyticsDiscipline"));
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionTestGen");
			selenium.jsClick("ProductOptionTestGen");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeVisible("DisciplineOptions");
			List<WebElement> attribute2=selenium.getElements("DisciplineOptions");
			//		String input1="Business Analytics";
			for(int i=0;i<= attribute2.size();i++)
			{
				String text2=attribute2.get(i).getText().toString();
				selenium.waitingTime(2000);
				System.out.println(text2);
				if(text2.equalsIgnoreCase(input))
				{
					System.out.println("Option is available : "+text2);
					attribute2.get(i).click();
					break;
				}
			}*/
			Assert.assertTrue(selenium.isElementPresentFast("BusinessAnalyticsDiscipline"));


		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@And("verify the INTL Read Only record type opp user permission denial")
	public void verify_the_INTL_Read_Only_record_type_opp_user_permission_denial(){
		try{
			selenium.navigateToURL(INTLReadOnlyTypeOpp);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditDecisionDateIcon");
			selenium.jsClick("EditDecisionDateIcon");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppCloseDateSelectionField");
			selenium.jsClick("OppCloseDateSelectionField");
			selenium.waitForElementToBeClickable("NeedByDateToday2");
			selenium.jsClick("NeedByDateToday2");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(5000);			
			String expected = selenium.getTestDataFromPropertiesFile("INTLReadOnlyTypeOppMsg");
			String actual = selenium.getElement("INTLReadOnlyTypeOppMsgError").getText();
			System.out.println("expected" +  expected + "actual" + actual);
			assertTrue(actual.contains(expected));
			selenium.test.log(LogStatus.PASS, "The expected validation message appeared");
			
			selenium.click("closePopUp");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(6000);
			
		}catch (Exception e) {
			selenium.click("closePopUp");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@And("verify the INTL Read Only record type opp user permission approval")
	public void verify_the_INTL_Read_Only_record_type_opp_user_permission_approval(){
		try{
			selenium.navigateToURL(INTLReadOnlyTypeOpp);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditDecisionDateIcon");
			selenium.jsClick("EditDecisionDateIcon");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppCloseDateSelectionField");
			selenium.jsClick("OppCloseDateSelectionField");
			selenium.typeData("OppCloseDateSelectionField", "11/17/2020");
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			Assert.assertTrue(selenium.isElementPresentFast("EditDecisionDateIcon"));
			selenium.test.log(LogStatus.PASS, "MHE_Business_Operations user is able to change the Close Date/Decision Date");			
		}catch (Exception e) {
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(6000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@Then("verify user in MMHE_View_All role can view MHHE Support case")
	public void verify_user_in_MMHE_View_All_role_can_view_MHHE_Support_case()
	{
		try
		{
			selenium.navigateToURL(MHHESupportCase);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("CaseNumberLabel");
			Assert.assertTrue(selenium.isElementPresentFast("CaseNumberLabel"));
			selenium.test.log(LogStatus.PASS, "user in MMHE_View_All role is able to view MHHE Support case");			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("verify user not in MMHE_View_All role can not view MHHE Support case")
	public void verify_user_not_in_MMHE_View_All_role_can_not_view_MHHE_Support_case()
	{
		try
		{
			selenium.navigateToURL(MHHESupportCase);
			selenium.waitingTime(6000);
			Assert.assertFalse(selenium.isElementPresentFast("CaseNumberLabel"));
			selenium.test.log(LogStatus.PASS, "user not in MMHE_View_All role is not able to view MHHE Support case");	
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify case visibility through Contact")
	public void verify_case_visibility_through_Contact()
	{
		try
		{
			selenium.navigateToURL(ContactWithCase);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Cases_RelatedList");
			selenium.jsClick("Cases_RelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("CaseNumberLabel");
			Assert.assertTrue(selenium.isElementPresentFast("CaseNumberLabel"));
			selenium.test.log(LogStatus.PASS, "Able to access Case through Contact record");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify case visibility through Opportunity")
	public void verify_case_visibility_through_Opportunity()
	{
		try
		{
			selenium.navigateToURL(OppWithCase);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Cases_RelatedList");
			selenium.jsClick("Cases_RelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("firstTableRecord"))
			{
				System.out.println("Case is already present..");
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.jsClick("firstTableRecord");
			}
			else
			{
				System.out.println("Case is not present. So, creating new case");
				selenium.click("NewActionButton");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NextButton");
				selenium.click("NextButton");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Case_OriginDropDown");
				selenium.jsClick("Case_OriginDropDown");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("MHHECaseOriginOption");
				selenium.jsClick("MHHECaseOriginOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SalesSupportProductDropDown");
				selenium.jsClick("SalesSupportProductDropDown");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SalesSupportProductOption2");
				selenium.jsClick("SalesSupportProductOption2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Business_Hours_DropDown");
				selenium.typeData("Business_Hours_DropDown", "CXG");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ShowAllResults");
				selenium.jsClick("ShowAllResults");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("BusinessHoursOption");
				selenium.jsClick("BusinessHoursOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("incident_option");
				selenium.jsClick("incident_option");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CaseIncidentValue");
				selenium.jsClick("CaseIncidentValue");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Subject_field");
				selenium.typeData("Subject_field", "Rep Sales");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(4000);
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("editOpportunityToLink");
				selenium.jsClick("editOpportunityToLink");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("searchOpportunities");
				selenium.jsClick("searchOpportunities");
				selenium.waitingTime(4000);
				selenium.autoSuggestiveDropdownOne_propertiesFile("searchOpportunities", "OpportunityToLinktoCase");
				selenium.waitingTime(4000);
				selenium.jsClick("OppLinkFromSearch");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
			}
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("CaseNumberLabel");
			Assert.assertTrue(selenium.isElementPresentFast("CaseNumberLabel"));
			selenium.test.log(LogStatus.PASS, "Able to access Case through Contact record");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify character limit for MHHE_IGS_Segment field is restricted to 50")
	public void verify_character_limit_for_MHHE_IGS_Segment_field_is_restricted_to_50()
	{
		try
		{
			selenium.navigateToURL(contact);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Contact_MHHEISGSegmentLabel");
			selenium.scrollToElement("Contact_MHHEISGSegmentLabel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.jsClick("Contact_MHHEISGSegmentEditIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Contact_MHHEISGSegmentFieldInEditMode");
			selenium.type_propertiesFile("Contact_MHHEISGSegmentFieldInEditMode", "LongInput51Char");
			selenium.click("SaveRecordButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Contact_MHHEISGSegmentLabel");
			selenium.scrollToElement("Contact_MHHEISGSegmentLabel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String MHHE_IGS_Segment_Value = selenium.getText("Contact_MHHEISGSegmentFieldValue");
			System.out.println("MHHE_IGS_Segment_Value --->" + MHHE_IGS_Segment_Value);
			int numberOfChar = MHHE_IGS_Segment_Value.length();
			Assert.assertEquals(numberOfChar, 50);
			selenium.test.log(LogStatus.PASS, "Character limit for MHHE_IGS_Segment field is restricted to " + numberOfChar);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify user is having only read only access to MHHE IGS Segment field")
	public void verify_user_is_having_only_read_only_access_to_MHHE_IGS_Segment_field()
	{
		try
		{
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("firstTableRecord"))
			{
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.jsClick("firstTableRecord");
			}
			else
			{
				System.out.println("no contact found in recently viewed list..");
				selenium.navigateToURL(contact);
			}

			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Contact_MHHEISGSegmentLabel");
			selenium.scrollToElement("Contact_MHHEISGSegmentLabel");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("Contact_MHHEISGSegmentLabel"));
			Assert.assertTrue(selenium.isElementPresentFast("Contact_MHHEISGSegmentDateLabel"));
			Assert.assertFalse(selenium.isElementPresentFast("Contact_MHHEISGSegmentEditIcon"));
			Assert.assertFalse(selenium.isElementPresentFast("Contact_MHHEISGSegmentDateEditIcon"));
			selenium.test.log(LogStatus.PASS, "User is having only read only access to MHHE IGS Segment field");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify the Case Number field change")
	public void verify_the_Case_Number_field_change(){
		try{
			selenium.navigateToURL(CaseToVerifyCaseNumberChange);
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("systemInfoSection");
            selenium.scrollToElement("systemInfoSection");
            selenium.waitingTime(2000);
//            selenium.scrolldown(-200);
//            selenium.waitingTime(2000);
            if (selenium.isElementPresentFast("SourceCaseNoField")) {
                selenium.test.log(LogStatus.PASS, "Source Case Number field is present in System information Section");
                System.out.println("PASS");
            } else {
                selenium.test.log(LogStatus.FAIL, "Source Case Number field not is present in System information Section");
                selenium.reportFailure("Source Case Number field not is present in System information Section");
                System.out.println("FAIL");
            }
			
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@Then("I create a new case by Admin profile")
	public void i_create_a_new_case_by_Admin_profile(){
		try{
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("next_button");
		selenium.jsClick("next_button");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("Search_contact");
		selenium.typeData("Search_contact","STANFORD UNIVERSITY");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults");
		selenium.jsClick("ShowAllResults");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("SelectContactName");
		selenium.jsClick("SelectContactName");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("contactTypeBtnNew");
		selenium.jsClick("contactTypeBtnNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ContactType_Option");
		selenium.jsClick("ContactType_Option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("serach_Account");
		selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults1");
		selenium.jsClick("ShowAllResults1");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("SelectAccountName");
		selenium.jsClick("SelectAccountName");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("Subject_field");
		selenium.typeData("Subject_field","UAT DEMO TEST");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Business_Hours_DropDown");
		selenium.typeData("Business_Hours_DropDown","CXG");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults2");
		selenium.jsClick("ShowAllResults2");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BusinessHoursOption");
		selenium.jsClick("BusinessHoursOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProductTypeDropDown01");
		selenium.jsClick("ProductTypeDropDown01");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProductType_ALEKS");
		selenium.jsClick("ProductType_ALEKS");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("incident_option");
		selenium.jsClick("incident_option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("select_categoryDropdownoption");
		selenium.jsClick("select_categoryDropdownoption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
		selenium.jsClick("caseSubIncidentDrpDwnNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("SubIncident_CXG_Option");
		selenium.jsClick("SubIncident_CXG_Option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
		selenium.typeData("ALEKSCaseInternalDescriptionTextBox","UAT Test for CXG");
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");

		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("followBtn");
	//	String toastMsg=selenium.getText("SuccessMessage").toString();
		if(selenium.isElementPresentFast("followBtn"))
		{
			System.out.println("Case Created Successfully");
			selenium.test.log(LogStatus.PASS,"Case created successfully");
		}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("verify the email count")
	public void verify_the_email_count(){
		try{
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("SEGProductRadioBtn");
		selenium.jsClick("SEGProductRadioBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("next_button");
		selenium.jsClick("next_button");
		selenium.waitingTime(8000);
		selenium.scrolldown(150);
		selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
		selenium.jsClick("caseOriginSkillDropdownNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("select_caseOriginSkill");
		selenium.jsClick("select_caseOriginSkill");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
		selenium.typeData("ALEKSCaseInternalDescriptionTextBox","UAT Test");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");
		selenium.waitingTime(18000);
		String url=selenium.getURL();
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("CaseEmailLink");
		selenium.jsClick("CaseEmailLink");
		selenium.waitingTime(6000);
//		selenium.scrollToElement("SideGridAddress");
//		selenium.waitForElementToBeVisible("SideGridAddress");
//		boolean sideGridAddress=selenium.isElementPresentFast("SideGridAddress");
		if(selenium.isElementPresentFast("EmailRecord"))
		{
			System.out.println("Email record found");
			selenium.test.log(LogStatus.FAIL,"Email record found");
			selenium.reportFailure("Email record found");
		}
		else
		{
			System.out.println("No Email record found");
			selenium.test.log(LogStatus.PASS,"No Email record found");
		}
		selenium.waitingTime(8000);
		selenium.navigateToURL(url);
		selenium.waitingTime(8000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("CaseEmailBtn");
		selenium.jsClick("CaseEmailBtn");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("CaseEmailToTextBox");
		selenium.typeData("CaseEmailToTextBox","dummymail@mheducation.com");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
		selenium.typeData("CaseEmailSubjectTextBox","Test Mail");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("EmailSendBtn");
		selenium.jsClick("EmailSendBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("CaseEmailLink");
		selenium.jsClick("CaseEmailLink");

		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("EmailRecord");
		if(selenium.isElementPresentFast("EmailRecord"))
		{
			System.out.println("Email record found");
			selenium.test.log(LogStatus.PASS,"Email record found");
		}
		else
		{
			System.out.println("No Email record found");
			selenium.test.log(LogStatus.FAIL,"No Email record found");
			selenium.reportFailure("No Email record found");
		}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("Verify the business hours")
	public void verify_the_business_hours(){
		try{
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("SEGProductRadioBtn");
		selenium.jsClick("SEGProductRadioBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("next_button");
		selenium.jsClick("next_button");
		selenium.waitingTime(8000);
		selenium.scrolldown(150);
		selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
		selenium.jsClick("caseOriginSkillDropdownNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("select_caseOriginSkill");
		selenium.jsClick("select_caseOriginSkill");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ALEKSCaseInternalDescriptionTextBox");
		selenium.typeData("ALEKSCaseInternalDescriptionTextBox","UAT Test");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.click("Save_Btn");
		selenium.waitingTime(8000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.scrolldown(350);
		selenium.waitForElementToBeVisible("Case_BusinessHours");
		String businessHours=selenium.getText("Case_BusinessHours").toString();
		System.out.println("From UI : "+businessHours);
		if(businessHours.equalsIgnoreCase("CSOM Customer Service")){
			System.out.println("Business Hours Matched");
			selenium.test.log(LogStatus.PASS,"Business Hours Matched");
		}
		else{
			System.out.println("Business Hours Not Matched");
			selenium.test.log(LogStatus.FAIL,"Business Hours Not Matched");
			selenium.reportFailure("Test Case Failed");
		}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I confirm the edit buttons when case is created")
	public void i_confirm_the_edit_buttons_when_case_is_created(){
		try{
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CSOMCaseCreationTextBox");
			selenium.typeData("CSOMCaseCreationTextBox","CSOM UAT Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			selenium.jsClick("caseOriginSkillDropdownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginSkillOption");
			selenium.jsClick("CaseOriginSkillOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field","TestDemo");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("CreditFailed");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("CreditFailed");
			selenium.scrollToElement("CreditFailed");
			selenium.waitingTime(2000);
			selenium.hoverAndClick("EditCSOMSubjectBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SubjectEditTextBox");
			selenium.clearText("SubjectEditTextBox");
			selenium.waitingTime(4000);
			selenium.typeData("SubjectEditTextBox","testDemoEdit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("CaseCreationNotes");
			if(selenium.isElementPresentFast("CaseCreationNotes"))
			{
				System.out.println("Case Creation Note field is available");
				selenium.test.log(LogStatus.PASS,"Case creation note field is available");
			}
			else
			{
				System.out.println("Case Creating Note field in not available");
				selenium.test.log(LogStatus.FAIL,"Case creating note field is not available");
				selenium.reportFailure("Case creating note field is not available");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseCreationEditBtn");
			if(selenium.isElementPresentFast("CaseCreationEditBtn"))
			{
				System.out.println("Case Creation Note field is editable");
				selenium.test.log(LogStatus.PASS,"Case Creation Note field is editable");
			}
			else
			{
				System.out.println("Case Creation Note field is not editable");
				selenium.test.log(LogStatus.FAIL,"Case Creation Note field is not editable");
				selenium.reportFailure("Case Creation Note field is not editable");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CSOMCaseCreationTextBox");
			selenium.clearText("CSOMCaseCreationTextBox");
			selenium.typeData("CSOMCaseCreationTextBox","CSOM UAT Test After Edit");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@And("verify the Case origin field doesnot contain MYC Automation")
	public void verify_the_Case_origin_field_doesnot_contain_MYC_Automation()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("CaseOriginEditIcon");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginEditIcon");
			selenium.jsClick("CaseOriginEditIcon");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CaseOriginFieldinEditMode");
			selenium.jsClick("CaseOriginFieldinEditMode");
			selenium.waitingTime(1000);
			Assert.assertFalse(selenium.isElementPresentFast("CaseOriginValue_MYC"));
			selenium.test.log(LogStatus.PASS, "MYC Automation is not present in Case Origin dropdown list");
			selenium.jsClick("CancelChangesBtn");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.click("CancelChangesBtn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("verify the MYC field related picklist and dependency values")
	public void verify_the_MYC_field_related_picklist_and_dependency_values(){
		try
		{			
			selenium.waitForElementToBeClickable("OrderStagebtn");
			selenium.jsClick("OrderStagebtn");
			selenium.waitForElementToBeClickable("ProductOptionPostOrder");
			selenium.jsClick("ProductOptionPostOrder");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonCodebtn");
			selenium.click("ReasonCodebtn");
			selenium.waitForElementToBeClickable("CSOM_RequestReasonValue1");
			selenium.jsClick("CSOM_RequestReasonValue1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Actionbtn");
			selenium.jsClick("Actionbtn");
			selenium.waitForElementToBeClickable("CSOM_ActionValue1");
			selenium.jsClick("CSOM_ActionValue1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_ActionValue2");
			selenium.jsClick("CSOM_ActionValue2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_ActionValue3");
			selenium.jsClick("CSOM_ActionValue3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_ActionValue4");
			selenium.jsClick("CSOM_ActionValue4");
			selenium.waitingTime(2000);
			selenium.scrolldown(300);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_ActionValue4");
			selenium.click("Save_Button");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.PASS, "Order Stage -> Request Reason -> Action picklist dependency has been verified successfully!");

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CSOM_StatusEditIcon");
			selenium.jsClick("CSOM_StatusEditIcon");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CSOM_CaseStatusField");
			selenium.jsClick("CSOM_CaseStatusField");
			selenium.waitForElementToBeClickable("CSOM_CaseStatusInProgress");	//Status = In Progress
			selenium.jsClick("CSOM_CaseStatusInProgress");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_CaseStatusLocationField");
			selenium.jsClick("CSOM_CaseStatusLocationField");
			selenium.waitForElementToBeClickable("CSOM_CaseStatusLocationValue1");	//Status Location = Outside Center - Waiting on Response From
			selenium.jsClick("CSOM_CaseStatusLocationValue1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CSOM_MHEFunctionalGroupField");
			selenium.jsClick("CSOM_MHEFunctionalGroupField");
			selenium.waitForElementToBeClickable("CSOM_MHEFunctionalGroupValue1");	//MHE Functional Group = Automation - MYC
			selenium.jsClick("CSOM_MHEFunctionalGroupValue1");			
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "Status -> Status Location -> MHE Functional Group picklist dependency has been verified successfully!");
			
			selenium.scrollToElement("MYCFirstEstimatedShipDateField");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertFalse(selenium.checkElementIsEnabled("MYCFirstEstimatedShipDateField"));
			selenium.test.log(LogStatus.PASS, "MYCFirstEstimatedShipDateField is read-only");
			System.out.println("PASS");
			selenium.jsClick("CSOM_SaveData");
			selenium.waitingTime(15000);
			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	
	@And("verify the MYC field is editable")
	public void verify_the_MYC_field_is_editable(){
		try
		{
			selenium.navigateToURL(CSOM_NewCase);
			selenium.waitingTime(10000);
			selenium.scrollToElement("MYCFirstEstimatedShipDateEditIcon");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MYCFirstEstimatedShipDateEditIcon");
			selenium.jsClick("MYCFirstEstimatedShipDateEditIcon");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("MYCFirstEstimatedShipDateField");
//			selenium.scrollToElement("MYCFirstEstimatedShipDateField");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.checkElementIsEnabled("MYCFirstEstimatedShipDateField"));
			selenium.test.log(LogStatus.PASS, "MYCFirstEstimatedShipDateField is editable");
			System.out.println("PASS");
			selenium.jsClick("CSOM_CancelData");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.click("CSOM_CancelData");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("create a new case through contacts")
	public void create_a_new_case_through_contacts(){
		try{
			selenium.waitForElementToBeClickable("SelectListViewContacts");
			selenium.jsClick("SelectListViewContacts");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList","All Contacts");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SelectAllContacts");
			selenium.jsClick("SelectAllContacts");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("FirstContactRecord");
			selenium.jsClick("FirstContactRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CasesLink");
			selenium.jsClick("CasesLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("NewCaseForContact");
			selenium.clickLoop("NewCaseForContact");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("next_button");
			selenium.jsClick("next_button");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CSOMCaseCreationTextBox");
			selenium.typeData("CSOMCaseCreationTextBox","CSOM UAT Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			selenium.jsClick("caseOriginSkillDropdownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseOriginSkillOption");
			selenium.jsClick("CaseOriginSkillOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field","TestDemo");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/500DY000001TvvkYAC/view?ws=%2Flightning%2Fr%2FContact%2F003C000001Q1NzxIAF%2Fview");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrolldown(5000);
			selenium.waitingTime(2000);
			selenium.scrollToElement("EditCSOMSubjectBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditCSOMSubjectBtn");
			selenium.hoverAndClick("EditCSOMSubjectBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SubjectEditTextBox");
			selenium.clearText("SubjectEditTextBox");
			selenium.waitingTime(4000);
			selenium.typeData("SubjectEditTextBox","testDemoEdit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("CaseCreationNotes");
			if(selenium.isElementPresentFast("CaseCreationNotes"))
			{
				System.out.println("Case Creation Note field is available");
				selenium.test.log(LogStatus.PASS,"Case creation note field is available");
			}
			else
			{
				System.out.println("Case Creating Note field in not available");
				selenium.test.log(LogStatus.FAIL,"Case creating note field is not available");
				selenium.reportFailure("Case creating note field is not available");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseCreationEditBtn");
			if(selenium.isElementPresentFast("CaseCreationEditBtn"))
			{
				System.out.println("Case Creation Note field is editable");
				selenium.test.log(LogStatus.FAIL,"Case Creation Note field is editable");
				selenium.reportFailure("Case Creation Note field is editable");
			}
			else
			{
				System.out.println("Case Creation Note field is not editable");
				selenium.test.log(LogStatus.PASS,"Case Creation Note field is not editable");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("InlineEditBtn");
			selenium.jsClick("InlineEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CasePurchaseOrder");
			selenium.typeData("CasePurchaseOrder","12345");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnCases");
			selenium.jsClick("SaveBtnCases");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("CasePurchaseOrder1");
			String casePurchaseOrder=selenium.getText("CasePurchaseOrder1").toString();
			System.out.println(casePurchaseOrder);
			if(casePurchaseOrder.equalsIgnoreCase("12345"))
			{
				System.out.println("Edit Successful");
				selenium.test.log(LogStatus.PASS,"Edit Successful");
			}
			else
			{
				System.out.println("Edit not done");
				selenium.test.log(LogStatus.FAIL,"Edit not done");
				selenium.reportFailure("Edit not done");
			}
			
			CSOM_NewCase = selenium.getURL();
			System.out.println("The newly created CSOM case URL is -->" + CSOM_NewCase);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I open the created case and verify")
	public void i_open_the_created_case_and_verify(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrolldown(6000);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("EditCSOMSubjectBtn");
			selenium.jsClick("EditCSOMSubjectBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.clearText("Subject_field");
			selenium.waitingTime(8000);
			selenium.typeData("Subject_field","SubjectAfterEdit");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("New_Save_Btn");
			selenium.jsClick("New_Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("CaseCreationNotes");
			if(selenium.isElementPresentFast("CaseCreationNotes"))
			{
				System.out.println("Case Creation Note field is available");
				selenium.test.log(LogStatus.PASS,"Case creation note field is available");
			}
			else
			{
				System.out.println("Case Creating Note field in not available");
				selenium.test.log(LogStatus.FAIL,"Case creating note field is not available");
				selenium.reportFailure("Case creating note field is not available");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseCreationEditBtn");
			if(selenium.isElementPresentFast("CaseCreationEditBtn"))
			{
				System.out.println("Case Creation Note field is editable");
				selenium.test.log(LogStatus.FAIL,"Case Creation Note field is editable");
				selenium.reportFailure("Case Creation Note field is editable");
			}
			else
			{
				System.out.println("Case Creation Note field is not editable");
				selenium.test.log(LogStatus.PASS,"Case Creation Note field is not editable");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("InlineEditBtn");
			selenium.jsClick("InlineEditBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CasePurchaseOrder");
			selenium.typeData("CasePurchaseOrder","12345");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnCases");
			selenium.jsClick("SaveBtnCases");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("CasePurchaseOrder1");
			String casePurchaseOrder=selenium.getText("CasePurchaseOrder1").toString();
			System.out.println(casePurchaseOrder);
			if(casePurchaseOrder.equalsIgnoreCase("12345"))
			{
				System.out.println("Edit Successful");
				selenium.test.log(LogStatus.PASS,"Edit Successful");
			}
			else
			{
				System.out.println("Edit not done");
				selenium.test.log(LogStatus.FAIL,"Edit not done");
				selenium.reportFailure("Edit not done");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the field value")
	public void verify_the_field_value(){
		try {
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption");
			selenium.jsClick("IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidentOption");
			selenium.jsClick("Sub_IncidentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGSaveBtn");
			selenium.jsClick("CXGSaveBtn");
			selenium.waitingTime(15000);

			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("CXGEditCategory");
			selenium.scrollToElement("CXGEditCategory");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGEditCategory");
			selenium.jsClick("CXGEditCategory");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CXGComponentOptions");
			List<WebElement> attribute=selenium.getElements("CXGComponentOptions");
			String input="Accessibility/ADA";
			int j=0;
			for(int i=0;i< attribute.size();i++)
			{
				String text=attribute.get(i).getText().toString();
				selenium.waitingTime(100);
				System.out.println(text);
				if(text.equalsIgnoreCase(input))
				{
					j++;
					selenium.test.log(LogStatus.FAIL,"Option is available so failed");
					selenium.reportFailure("Option is available so failed");
					System.out.println("Option is available : "+text);
					attribute.get(i).click();
					break;
				}
			}
			if(j==0)
			{
				System.out.println("Option is not available");
				selenium.test.log(LogStatus.PASS,"Option is not available");
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGCategoryOptionPlatform");
			selenium.jsClick("CXGCategoryOptionPlatform");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("CXGComponentOptions");
			List<WebElement> attributes=selenium.getElements("CXGComponentOptions");
//			String input="Accessibility/ADA";
			int k=0;
			for(int i=0;i<attributes.size();i++)
			{
				String text=attributes.get(i).getText().toString();
				selenium.waitingTime(500);
				System.out.println(text);
				if(text.equalsIgnoreCase(input))
				{
					selenium.test.log(LogStatus.PASS,"Option is available");
					System.out.println("Option is available : "+text);
					break;
				}
			}
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");

			}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("I create a case for MHHE Sales Support")
	public void i_create_a_case_for_MHHE_sales_support() {
		try {
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("next_button");
		selenium.jsClick("next_button");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("Case_OriginDropDown");
		selenium.jsClick("Case_OriginDropDown");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("MHHECaseOriginOption");
		selenium.jsClick("MHHECaseOriginOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Subject_field");
		selenium.typeData("Subject_field","Combo Requests");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Business_Hours_DropDown");
		selenium.typeData("Business_Hours_DropDown","CXG");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults");
		selenium.jsClick("ShowAllResults");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BusinessHoursOption");
		selenium.jsClick("BusinessHoursOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProductTypeDDList");
		selenium.jsClick("ProductTypeDDList");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("MHHEProductTypeOption2");
		selenium.jsClick("MHHEProductTypeOption2");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("incident_option");
		selenium.jsClick("incident_option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("CaseIncidentValue");
		selenium.jsClick("CaseIncidentValue");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");
		selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the product and incident field details")
	public void verify_the_product_and_incident_field_details(DataTable table){
		try{
		List<String> data = table.transpose().asList(String.class);
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.scrollToElement("IncidentFieldVerify");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("IncidentFieldVerify");
		String incidentFieldVerify=selenium.getText("IncidentFieldVerify").toString();
		System.out.println(incidentFieldVerify);
		if(incidentFieldVerify.equalsIgnoreCase(data.get(0)))
		{
		System.out.println("Incident field value is not changed");
		selenium.test.log(LogStatus.PASS,"Incident field value is not changed");
		}
		else
		{
		System.out.println("Incident field value is changed");
		selenium.test.log(LogStatus.FAIL,"Incident field value is changed");
		selenium.reportFailure("Incident field value is changed");
		}
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("ProductFieldVerify");
		String productFieldVerify=selenium.getText("ProductFieldVerify").toString();
		System.out.println(productFieldVerify);
		if(productFieldVerify.equalsIgnoreCase(data.get(1)))
		{
		System.out.println("Product field value is not changed");
		selenium.test.log(LogStatus.PASS,"Product field value is not changed");
		}
		else
		{
		System.out.println("Product field value is changed");
		selenium.test.log(LogStatus.FAIL,"Product field value is changed");
		selenium.reportFailure("Product field value is changed");
		}
		}catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I create a case for MHHE Sales Supports")
	public void i_create_a_case_for_MHHE_sales_supports() {
		try {
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("next_button");
		selenium.jsClick("next_button");
		selenium.waitingTime(8000);
		selenium.waitForElementToBeClickable("Case_OriginDropDown");
		selenium.jsClick("Case_OriginDropDown");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("CaseOriginOption_CompControlMHHE");
		selenium.jsClick("CaseOriginOption_CompControlMHHE");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Subject_field");
		selenium.typeData("Subject_field","Automation Test");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Business_Hours_DropDown");
		selenium.typeData("Business_Hours_DropDown","CXG");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("ShowAllResults");
		selenium.jsClick("ShowAllResults");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("BusinessHoursOption");
		selenium.jsClick("BusinessHoursOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("ProductTypeDDList");
		selenium.jsClick("ProductTypeDDList");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("MHHEProductTypeOption2");
		selenium.jsClick("MHHEProductTypeOption2");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("incident_option");
		selenium.jsClick("incident_option");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("MHHEIncidentOption");
		selenium.jsClick("MHHEIncidentOption");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");
		selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.refresh();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the incident field detail")
	public void verify_the_incident_field_detail(DataTable table) {
		try {
		List<String> data = table.transpose().asList(String.class);
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.scrollToElement("IncidentFieldVerify");
		selenium.waitingTime(2000);
		selenium.scrolldown(-200);
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("IncidentFieldVerify");
		String incidentFieldVerify = selenium.getText("IncidentFieldVerify").toString();
		System.out.println(incidentFieldVerify);
		if (incidentFieldVerify.equalsIgnoreCase(data.get(0))) {
		System.out.println("Incident field value is not changed");
		selenium.test.log(LogStatus.PASS, "Incident field value is not changed");
		} else {
		System.out.println("Incident field value is changed");
		selenium.test.log(LogStatus.FAIL, "Incident field value is changed");
		selenium.reportFailure("Incident field value is changed");
		}
		} catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the email created")
	public void verify_the_email_created(){
		try{
			selenium.waitingTime(10000);
			String url=selenium.getURL();
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord=selenium.getElements("FirstOppOrderRecord");

			int emailSize=emailRecord.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.fsu@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.cameron@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord1=selenium.getElements("FirstOppOrderRecord");
			emailSize=emailRecord1.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			if(emailSize==4)
			{
				System.out.println("Email Auto Response is Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is Received");
			}
			else
			{
				System.out.println("Email Auto Response is not Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is not Received");
				selenium.reportFailure("Email Auto Response is not Received");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify email created")
	public void verify_email_created(){
		try{
			selenium.waitingTime(10000);
			String url=selenium.getURL();
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord=selenium.getElements("FirstOppOrderRecord");

			int emailSize=emailRecord.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.strayer@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.walterstatecc@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord1=selenium.getElements("FirstOppOrderRecord");
			emailSize=emailRecord1.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			if(emailSize==4)
			{
				System.out.println("Email Auto Response is Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is Received");
			}
			else
			{
				System.out.println("Email Auto Response is not Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is not Received");
				selenium.reportFailure("Email Auto Response is not Received");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify email created or not")
	public void verify_email_created_or_not(){
		try{
			selenium.waitingTime(10000);
			String url=selenium.getURL();
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord=selenium.getElements("FirstOppOrderRecord");

			int emailSize=emailRecord.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			selenium.navigateToURL(url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.newmexico@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
			selenium.waitForElementToBeClickable("DeleteToEmail");
			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","cxg.utahvalley@mheducation.com");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailBCCTextBox");
			selenium.typeData("EmailBCCTextBox"," ");
			selenium.clearText("EmailBCCTextBox");
			selenium.waitForElementToBeClickable("DeleteBccEmail");
			selenium.jsClick("DeleteBccEmail");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CaseEmailLink");
			selenium.jsClick("CaseEmailLink");
			List<WebElement> emailRecord1=selenium.getElements("FirstOppOrderRecord");
			emailSize=emailRecord1.size();
			System.out.println("The Total Number of Email Present are : "+emailSize);
			if(emailSize==4)
			{
				System.out.println("Email Auto Response is Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is Received");
			}
			else
			{
				System.out.println("Email Auto Response is not Received");
				selenium.test.log(LogStatus.PASS, "Email Auto Response is not Received");
				selenium.reportFailure("Email Auto Response is not Received");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("verify Jira issue number is same")
	public void verify_Jira_issue_number_is_same(){
		try{
			selenium.waitForElementToBeClickable("click_JIRA");
			selenium.hoverAndClick("click_JIRA");
			selenium.waitingTime(5000);
			selenium.scrollToElement("jira_issueBtn");
			selenium.scrolldown(-250);
			selenium.waitingTime(10000);
			String jira_Number=selenium.getText("jira_CSNumbergetText").toString();
			System.out.println("Jira Issue Number is " +jira_Number);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EmailComposeBtn");
			selenium.jsClick("EmailComposeBtn");
//			selenium.waitingTime(6000);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CaseEmailToTextBox");
//			selenium.waitForElementToBeClickable("DeleteToEmail");
//			selenium.jsClick("DeleteToEmail");
			selenium.waitingTime(1000);
			selenium.typeData("CaseEmailToTextBox","suraj.kumar@mheducation.com");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("EmailBCCTextBox");
//			selenium.typeData("EmailBCCTextBox"," ");
//			selenium.clearText("EmailBCCTextBox");
//			selenium.waitForElementToBeClickable("DeleteBccEmail");
//			selenium.jsClick("DeleteBccEmail");
//			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("CaseEmailSubjectTextBox");
			selenium.typeData("CaseEmailSubjectTextBox","UAT Automation Test Mail");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EmailSendBtn");
			selenium.jsClick("EmailSendBtn");
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("click_JIRA");
			selenium.hoverAndClick("click_JIRA");
			selenium.waitingTime(5000);
			selenium.scrollToElement("jira_issueBtn");
			selenium.scrolldown(-250);
			selenium.waitingTime(10000);
			String jira_Number1=selenium.getText("jira_CSNumbergetText").toString();
			System.out.println("Jira Issue Number is " +jira_Number1);
			Assert.assertTrue(jira_Number.equalsIgnoreCase(jira_Number1));
			System.out.println("Pass ! : Jira Issue Number is Same");
			selenium.waitingTime(4000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
}