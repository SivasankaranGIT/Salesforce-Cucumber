package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class Cases_VerifyOrder {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^close the CSOM case$") public void
	  close_the_CSOM_case() throws Exception {
		  try {
		  selenium.waitForElementsToBeVisible("internalDescription1text");
			 selenium.waitingTime(2000);
			 selenium.jsClick("internalDescription1text");
			 System.out.println("inside ID1");
			 selenium.waitingTime(2000);
			 
			 selenium.jsClick("OrderStagebtn");
			 System.out.println("inside first order stage");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Order Stage History", "end");
			 selenium.waitingTime(2000);

			 selenium.jsClick("ReasonCodebtn");
			 System.out.println("inside first request reason");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Request Reason History", "end");
			 selenium.waitingTime(2000);

			 selenium.jsClick("Actionbtn");
			 System.out.println("inside first action");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Action History", "end");
			 selenium.waitingTime(2000);
			 
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(4000);
		  }
		  catch (Exception e)
			{
				selenium.reportFailure("Error while closing the CSOM case " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	  
	  }
	 
		 
		 @And("^verify the status of closed case in internal description tab$")
		 public void verify_the_status_of_closed_case_in_internal_desciption() throws Exception {
			 try {
			 selenium.waitForElementsToBeVisible("resolutionTab");
			 selenium.waitingTime(3000);
			 selenium.jsClick("resolutionTab");
			 System.out.println("Inside Resolution Tab");
			 selenium.waitingTime(3000);
			 selenium.scrollToElement("resolutionTab");
			 selenium.waitingTime(3000);
			 boolean internalDescriptionResTab=selenium.isElementPresentXpathFast("InternalDescriptioninResTab");
			 if(internalDescriptionResTab==false) {
					
				 System.out.println(" Status is correct under Internal description");
				}
				else {
					System.out.println("Status is not correct under Internal description");
				}
				selenium.captureScreenShot();
			 }
			 catch (Exception e)
				{
					selenium.reportFailure("Error while verifying status " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
			}
		 

		 @Then("^verify the internal description order stage$")
		 public void verify_the_internal_description_order_stage() throws Exception {
			 try {
			    selenium.refresh();
			    selenium.waitingTime(7000);
			    if(selenium.isElementPresentFast("showAll"))
			    {
					selenium.waitForElementToBeClickable("showAll");
					selenium.click("showAll");			    	
			    }
				selenium.waitForElementToBeClickable("internalDescriptionHistorybtn");
				selenium.jsClick("internalDescriptionHistorybtn");
				selenium.waitingTime(7000);
				String orderStage = selenium.getText("orderStageVal").toString();
				String requestReason = selenium.getText("requestReasonVal").toString();
				String action = selenium.getText("actionVal").toString();
				String expected_orderStage = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Order Stage");
				String expected_requestReason = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Request Reason");
				String expected_action = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Action");
				System.out.println("status" + orderStage + expected_orderStage + requestReason + expected_requestReason + action + expected_action);
				if (orderStage.equalsIgnoreCase(expected_orderStage) && requestReason.equalsIgnoreCase(expected_requestReason) && action.equalsIgnoreCase(expected_action)) {
					System.out.println("inside pass");
					selenium.test.log(LogStatus.PASS, "Internal Description verification completed");

				} else {
					System.out.println("inside fail");
					selenium.test.log(LogStatus.FAIL, "Internal Description verification failed");
					selenium.reportFailure("Internal Description verification failed");
		 }
				selenium.closeSubTabs();
				selenium.waitingTime(2000);
		}
			 catch (Exception e)
				{
					selenium.reportFailure("Error while verifying Internal Description order stage " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
				
	
		 }
		 
		 @And("^create the new case by entering the required fields$")
		    public void create_the_new_case_by_entering_the_required_fields()  {
				try {
				selenium.waitForElementToBeClickable("newCaseReq1");
				selenium.click("newCaseReq1");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("newCaseReq2");
				selenium.click("newCaseReq2");
				selenium.waitingTime(3000);
				selenium.autoSuggestiveDropdownOne("newCaseReq2", "List View");
				selenium.waitingTime(9000);
				}
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while entering required fields" + e.getMessage());
					}

			}
		 
		 @Then("^change the owner of the case$")
		    public void change_the_owner_of_the_case()  {
				try {
				
				selenium.waitForElementToBeVisible("newOwner");
				if(selenium.getElement("newOwner").isDisplayed()) {
					selenium.test.log(LogStatus.PASS, "Owner of the case is changed");

				} else {
					System.out.println("Owner of the case not changed");
					selenium.test.log(LogStatus.FAIL, "Owner of the case not changed");
					selenium.reportFailure("Owner of the case not changed");
				}
				
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.click("newOwnerbtn");
				selenium.waitingTime(5000);
				
				}
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while changing the owner" + e.getMessage());
					
					}

			}
		 
		 @And("^check the field details$")
		    public void check_the_field_details() {
				try {
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("caseEditPriority");
				selenium.jsClick("caseEditPriority");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("caseEditPriorityDropdown1");
				selenium.jsClick("caseEditPriorityDropdown1");
				selenium.waitingTime(3000);
				selenium.clickDynamic("spanTitle", "Priority", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("caseDTSCloseProductDropdown");
				selenium.jsClick("caseDTSCloseProductDropdown");
				selenium.waitingTime(3000);
				selenium.clickDynamic("spanTitle", "Product", "end");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(9000);
			
				}
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while checking the field details" + e.getMessage());
					
					}

			}
		 
		 @Then ("^verify the change owner to appropriate queue$")
		 public void verify_the_change_owner_to_appropriate_queue() {
			 try {
					
					selenium.waitForElementToBeVisible("caseEditPriority");
					selenium.scrollToElement("parentCaseField");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("priorityStatusAfterEdit");
					
					String priority = selenium.getText("priorityStatusAfterEdit").toString();
					String expected_priority = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Priority");
					System.out.println("status" +priority + expected_priority );
					if (priority.equalsIgnoreCase(expected_priority)) {
						System.out.println("inside pass");
						selenium.test.log(LogStatus.PASS, "Verification of changed owner is successfully");

					} else {
						System.out.println("inside fail");
						selenium.test.log(LogStatus.FAIL, "Verification of changed owner is failed");
						

					}
					
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					}
					 catch (Exception e) {
						 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
							selenium.reportFailure("Error while verifying owner details" + e.getMessage());
						
						}
		 
		 }
		 
		 @And("^open case and verify the LMS field value from picklist$")
		    public void open_the_case() {
			 
			 try {
				 selenium.search("Case Number");
				 String Xpath = selenium.getDynamicXpath("anchorTitle", "Case Number", "end");
					selenium.waitingTime(4000);
				    selenium.clickLoopXpath(Xpath);
					selenium.test.log(LogStatus.INFO, "Clicked on case" );
					selenium.waitingTime(5000);
					selenium.captureScreenShot();
				 
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while opening case" + e.getMessage());
				}
		 }
		 
		 @Then("^verify Email address is present$")
		    public void verify_email_address_is_present() {
			 
			 try {
				 selenium.waitForElementToBeClickable("caseEmailSection1");
				 selenium.jsClick("caseEmailSection1");
				 selenium.waitForElementToBeVisible("caseEmailNotification");
				 boolean email = selenium.isElementPresentFast("caseEmailNotification");
				 System.out.println("email present" + email);
				 if(email == true) {
					 selenium.test.log(LogStatus.PASS, "Email address is present" );
					 System.out.println("PASS");
				 }
				 else {
					 selenium.test.log(LogStatus.FAIL, "Email address is not present" );
					 selenium.reportFailure("Email address is not present");
				 }
	
				 selenium.captureScreenShot();
			 }
			 
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying email address " + e.getMessage());
				}
		 }
		 
		 @And("^fill all mandatory details to create new case and verify field values$")
		    public void fill_all_mandatory_details_to_create_new_case_and_verify_field_values() {
			 
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
				 selenium.scrolldown(30);
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("internalDescription");
				 selenium.jsClick("internalDescription");
				 selenium.type("internalDescription", "Internal Description");
				 System.out.println("Added Internal description");

				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("Save_Btn");
				 selenium.jsClick("Save_Btn");
				 System.out.println("Clicked save button");
				 selenium.waitingTime(6000);
				 if(selenium.isElementPresentFast("RecordSaveButton"))
				 {
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
				 selenium.waitingTime(2000);
				 selenium.test.log(LogStatus.PASS, "ALEKS Case created successfully" );
				 
				 }
			 catch (Exception e) {
					System.out.println("Error while creating new case");
					selenium.reportFailure("Error while creating new case " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
					}
		 }
		 
		 @Then ("^I will verify the mass case close screen$")
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
				 selenium.test.log(LogStatus.PASS, "Picklist values verified successfully" );
			        if (selenium.isElementPresentFast("loginPopUp"))
			        {
			        	System.out.println("I am inside loginPopup method");
			        	selenium.clickLoop("loginPopUp");
			        	selenium.waitingTime(5000);	
			        }
				 selenium.waitForElementToBeClickable("CancelButton");
				 selenium.click("CancelButton");
				 selenium.waitingTime(10000);
				 selenium.closeSubTabs();
				 selenium.waitingTime(2000);
		    }
		    
		    catch (Exception e) {
				System.out.println("Error while checking the mass case close screen");
				selenium.reportFailure("Error while checking the mass case close screen " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	}
		 
		 @And ("^verify the read access to case based on record type$")
		    public void verify_the_read_access_to_case_based_on_record_type() throws Exception {
		    	try {
		    	selenium.waitingTime(4000);
		    	selenium.jsClick("omniBtn");
		    	selenium.waitingTime(2000);
		    	selenium.jsClick("downArrowBtn");
		    	selenium.waitingTime(2000);
		    	selenium.isElementPresentFast("omniStatus");		    	
		    	}
		    	catch (Exception e)
		    	{
		    		selenium.reportFailure("Error occurred " + e.getMessage());
		    		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		    	}
		    }
		 
		 @Then ("^verify the read access to case based queue type$")
		    public void verify_the_read_access_to_case_based_on_queue_type() throws Exception {
		    try {	selenium.waitingTime(4000);
		    	selenium.jsClick("omniBtn");
		    	selenium.waitingTime(2000);
		    	selenium.jsClick("downArrowBtn");
		    	selenium.waitingTime(2000);
		    	selenium.isElementPresentFast("omniStatus1");
		    	selenium.test.log(LogStatus.PASS, "Access has been verified");
		    }
		    catch (Exception e) {
		    	
		    	selenium.reportFailure("Error while verifying read access " + e.getMessage());
		    	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		    	
		    }
		    	
		    }
		 
		 
		 @And("^fill all mandatory details and verify the fields of the case$")
		    public void fill_all_mandatory_details_and_verify_the_fields_of_the_cases() {
			 
			 try {
				 selenium.waitingTime(3000);
//				 if(selenium.getElement("Case_OriginDropDown").isDisplayed()){
//					 System.out.println("inside first");
//					 selenium.waitForElementToBeClickable("Case_OriginDropDown");
//				 selenium.jsClick("Case_OriginDropDown");
////				 selenium.waitingTime(2000);
//				 selenium.waitForElementToBeClickable("caseOriginOptionNew");
//				 selenium.dropdownListClick("caseOriginOptionNew");
//				 selenium.waitingTime(2000);
//				 }
//				 else  if(selenium.getElement("caseOriginDropdown2").isDisplayed()){
//					 System.out.println("inside second");
//					 selenium.waitForElementToBeClickable("caseOriginDropdown2");
//					 selenium.jsClick("caseOriginDropdown2");
////					 selenium.waitingTime(2000);
//					 selenium.waitForElementToBeClickable("caseOriginOptionNew");
//					 selenium.dropdownListClick("caseOriginOptionNew");
//					 selenium.waitingTime(2000);
//					 }
				 
				 if(selenium.getElement("productDropDwn1").isDisplayed()){
					 System.out.println("inside first");
					 selenium.waitForElementToBeClickable("productDropDwn1");
				 selenium.jsClick("productDropDwn1");
//				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("ProductType_ALEKS");
				 selenium.dropdownListClick("ProductType_ALEKS");
				 selenium.waitingTime(2000);
				 }
				 else  if(selenium.getElement("caseCXGProductDropdown2").isDisplayed()){
					 System.out.println("inside second");
					 selenium.waitForElementToBeClickable("caseCXGProductDropdown2");
					 selenium.jsClick("caseCXGProductDropdown2");
//					 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("ProductType_ALEKS");
					 selenium.dropdownListClick("ProductType_ALEKS");
					 selenium.waitingTime(2000);
					 }
				 
				 if(selenium.getElement("incident_option").isDisplayed()){
					 System.out.println("inside first");
					 selenium.waitForElementToBeClickable("incident_option");
				 selenium.jsClick("incident_option");
//				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("IncidentOption");
				 selenium.dropdownListClick("IncidentOption");
				 selenium.waitingTime(2000);
				 }
				 else  if(selenium.getElement("caseCXGIncidentDropdown2").isDisplayed()){
					 System.out.println("inside second");
					 selenium.waitForElementToBeClickable("caseCXGIncidentDropdown2");
					 selenium.jsClick("caseCXGIncidentDropdown2");
//					 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("IncidentOption");
					 selenium.dropdownListClick("IncidentOption");
					 selenium.waitingTime(2000);
					 }
				 
				 if(selenium.getElement("caseSubIncidentDrpDwnNew").isDisplayed()){
					 System.out.println("inside first");
					 selenium.waitForElementToBeClickable("caseSubIncidentDrpDwnNew");
				 selenium.jsClick("caseSubIncidentDrpDwnNew");
//				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("caseCXGSubIncidentOptionNew");
				selenium.dropdownListClick("caseCXGSubIncidentOptionNew");
				 selenium.waitingTime(2000);
				 }
				 else if(selenium.getElement("caseCXGSubIncidentDropdown2").isDisplayed()){
					 System.out.println("inside second");
					 selenium.waitForElementToBeClickable("caseCXGSubIncidentDropdown2");
					 selenium.jsClick("caseCXGSubIncidentDropdown2");
//					 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("caseCXGSubIncidentOptionNew");
					selenium.dropdownListClick("caseCXGSubIncidentOptionNew");
					 selenium.waitingTime(2000);
					 }
				 
				 if(selenium.getElement("caseBUDrpDwnNew").isDisplayed()){
					 System.out.println("inside first");
					 selenium.waitForElementToBeClickable("caseBUDrpDwnNew");
				 selenium.jsClick("caseBUDrpDwnNew");
//				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("BU_Option");
				 selenium.dropdownListClick("BU_Option");
				 selenium.waitingTime(2000);
				 }
				 else if(selenium.getElement("caseCXGBUDropdown2").isDisplayed()){
					 System.out.println("inside second");
					 selenium.waitForElementToBeClickable("caseCXGBUDropdown2");
					 selenium.jsClick("caseCXGBUDropdown2");
//					 selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("BU_Option");
					 selenium.dropdownListClick("BU_Option");
					 selenium.waitingTime(2000);
					 }
				 
				 if(selenium.getElement("Subject_field").isDisplayed()) {
					 System.out.println("inside first");
//					 selenium.waitForElementToBeClickable("Subject_field");
//				 selenium.click("Subject_field");
//				 selenium.waitingTime(2000);
				 selenium.type("Subject_field", "Subject");
				 selenium.waitingTime(2000);
				 }
				 
				 else if(selenium.getElement("caseCXGSubject2").isDisplayed()) {
					 System.out.println("inside second");
//					 selenium.waitForElementToBeClickable("caseCXGSubject2");
//					 selenium.click("caseCXGSubject2");
//					 selenium.waitingTime(2000);
					 selenium.type("caseCXGSubject2", "Subject");
					 selenium.waitingTime(2000);
					 }
				 
				 if(selenium.getElement("caseCXGInternalDescriptionNew").isDisplayed()) {
					 System.out.println("inside first");
//					 selenium.waitForElementToBeClickable("caseCXGInternalDescriptionNew");
//				 selenium.click("caseCXGInternalDescriptionNew");
//				 selenium.waitingTime(2000);
				 selenium.type("caseCXGInternalDescriptionNew", "Internal Description");
				 selenium.waitingTime(2000);
				 }
				 else if(selenium.getElement("caseCXGInternalDescription2").isDisplayed()) {
					 System.out.println("inside second");
//					 selenium.waitForElementToBeClickable("caseCXGInternalDescription2");
//					 selenium.click("caseCXGInternalDescription2");
//					 selenium.waitingTime(2000);
					 selenium.type("caseCXGInternalDescription2", "Internal Description");
					 selenium.waitingTime(2000);
					 }
				 
				 
				 selenium.moveTab("caseCXGInternalDescriptionNew");
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("saveButton");
				 selenium.jsClick("saveButton");
				 selenium.waitForElementToBeVisible("contactSuccessfulL");
				 if(selenium.isElementPresentFast("contactSuccessfulL")) {
				 selenium.test.log(LogStatus.PASS, "CXG Case created successfully" );
				 
			 }
				 
				 else {
					 selenium.test.log(LogStatus.FAIL, "CXG Case not created" );
					 selenium.reportFailure("CXG Case not created");
				 }
			 }
			 catch (Exception e) {
				 System.out.println("inside catch block");
					System.out.println("inside catch");
					selenium.reportFailure("Error while creating new case " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
					}
			
		 }
		 
		 @Then("^click on close case button after filling all the required details$")
		    public void click_on_close_case_button_after_filling_all_the_required_details() {
			 
			 try {
				 selenium.refresh();
				 selenium.waitingTime(8000);
				 selenium.waitForElementToBeClickable("Close_case");
				 selenium.jsClick("Close_case");
				 selenium.waitingTime(8000);
				 
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while clicking on close case " + e.getMessage());
				}
		 }
		 
		 
		 @And("^will verify the fields of the closed case$")
		    public void will_verify_the_fields_of_the_closed_case() {
			 
			 try {

				 selenium.captureScreenShot();
				 selenium.waitForElementToBeClickable("closingStatus");
				 selenium.jsClick("closingStatus");
				 selenium.waitingTime(2000);
				 selenium.selectDropdownText("closingStatus", "Close Status");
				 selenium.waitForElementToBeClickable("caseResolution");
				 selenium.jsClick("caseResolution");
				 selenium.waitingTime(2000);
				 selenium.type("caseResolution", "Case Resolution");
				 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
				 selenium.jsClick("caseCXGCloseMarketDropdown");
				 selenium.waitingTime(2000);
				 selenium.clickDynamic("spanTitle", "Market", "end");
				 selenium.waitForElementToBeVisible("saveButton");
				 selenium.jsClick("saveButton");
				 selenium.waitingTime(2000);
				 selenium.test.log(LogStatus.PASS, "Case closed successfully");
				 
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
		 
		 
		 @Then("^verify the status of closed case$")
		    public void verify_the_status_of_closed_case() {
			 
			 try {
				
				 selenium.waitingTime(5000);
				 	
				 	String status = selenium.getText("caseCXGClosedStatus").toString();
					String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
					System.out.println("status" +status + expected_status );
					selenium.captureScreenShot();
					if (status.equalsIgnoreCase(expected_status)) {
						System.out.println("inside pass" );
						selenium.test.log(LogStatus.PASS, "Status is closed : "+status +" Expected : "+expected_status);

					} else {
						System.out.println("inside fail" );
						selenium.test.log(LogStatus.FAIL, "Status is closed : "+status +" Expected : "+expected_status);
						selenium.reportFailure("Test Case Failed");
						

					}
					
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying case status " + e.getMessage());
			 }
		 }
		 
		 @And("^verify all action field value$")
		    public void verify_all_action_field_value() {
			 
			 try {
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("caseOriginDropdown");
				 selenium.jsClick("caseOriginDropdown");
				 System.out.println("inside case origin");
				 selenium.waitingTime(2000);
				 selenium.clickDynamic("anchorTitle", "Case Origin", "end");
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
				 selenium.jsClick("caseOriginSkillDropdownNew");
				 System.out.println("inside case origin skill");
				 selenium.waitingTime(2000);
				 selenium.clickDynamic("anchorTitle", "Case Origin Skill", "end");
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("sveprductL");
				 selenium.jsClick("sveprductL");
				 
				 selenium.waitingTime(6000);
				 
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
				 selenium.waitingTime(2000);
				 selenium.clickDynamic("spanTitle", "Action", "end");
				 selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("saveID1");
				 selenium.jsClick("saveID1");
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
				 selenium.waitForElementToBeClickable("saveID2");
				 selenium.jsClick("saveID2");
				 selenium.waitingTime(4000);
				 
				 selenium.waitForElementToBeVisible("contactSuccessfulL");
				 if(selenium.isElementPresentFast("contactSuccessfulL")) {
				 selenium.test.log(LogStatus.PASS, "Values checked successfully" );
				 
			 }
				 
				 else {
					 selenium.test.log(LogStatus.FAIL, "Value check is failed" );
				 	 selenium.reportFailure("Value check is failed");
				 }
				 }
			 catch (Exception e) {
				 System.out.println("inside catch");					
					System.out.println("inside catch1");
					selenium.reportFailure("Error while checking values " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
					}
		 }
		 
		 @And ("^verify user can delete the access$")
		    public void verify_user_can_delete_the_access() throws Exception {
		    	try {
		    	selenium.waitingTime(4000);
		    	selenium.jsClick("omniBtn");
		    	selenium.waitingTime(2000);
		    	selenium.jsClick("downArrowBtn");
		    	selenium.waitingTime(2000);
		    	selenium.isElementPresentFast("omniStatus");		    	
		    	}
		    	catch (Exception e)
		    	{
		    		selenium.reportFailure("Error occurred " + e.getMessage());
		    		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		    	}
		    }
		 
		 @Then ("^verify the dependencies of the category$")
		    public void verify_the_dependencies_of_the_category() throws Exception {
		    try {	selenium.waitingTime(4000);
		    	selenium.jsClick("omniBtn");
		    	selenium.waitingTime(2000);
		    	selenium.jsClick("downArrowBtn");
		    	selenium.waitingTime(2000);
		    	selenium.isElementPresentFast("omniStatus1");
		    	selenium.test.log(LogStatus.PASS, "Access has been verified");
		    }
		    catch (Exception e) {
		    	
		    	selenium.reportFailure("Error while verifying read access " + e.getMessage());
		    	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		    	
		    }
}
	@And("^I Verify the \"([^\"]*)\" record$")
	public void I_Verify_the_Opp_record(String Opp) {
		try {
			selenium.navigateToURL(Opp);
//			selenium.waitForElementToBeVisible("Digital_Risk");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyDigitalRequirementFieldForNonINTLOpp")) {
				if (selenium.isElementPresentFast("Digital_Risk")) {
					System.out.println("Digital Risk is displayed");
					selenium.test.log(LogStatus.FAIL, "Digital Risk is displayed");
					selenium.reportFailure("Digital Risk is displayed");
				} else {

					selenium.test.log(LogStatus.PASS, "Digital Risk is not displayed");
				}
			}
			selenium.waitingTime(5000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyDigitalRequirementFieldForINTLOpp")) {
				if (selenium.isElementPresentFast("Digital_Risk")) {
					selenium.test.log(LogStatus.PASS, "Digital Risk is displayed");
				} else {
					System.out.println("Digital Risk is displayed");
					selenium.test.log(LogStatus.FAIL, "Digital Risk is not displayed");
					selenium.reportFailure("Digital Risk is not displayed");

				}
			}

		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing the owner" + e.getMessage());

		}

	}

}