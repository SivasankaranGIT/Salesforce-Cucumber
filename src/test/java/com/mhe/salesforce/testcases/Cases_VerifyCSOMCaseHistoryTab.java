package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class Cases_VerifyCSOMCaseHistoryTab {
	
	WebConnector selenium = WebConnector.getInstance();
	
	
	  @Then("^create the history CSOM case$") public void
	  create_the_history_CSOM_case() throws Exception {
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
				selenium.reportFailure("Error while creating the history CSOM case " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	  
	  }
	 
		 
		 @And("^verify in resolution tab internal desciption should not be there$")
		 public void verify_in_resolution_tab_internal_desciption_should_not_be_there() throws Exception {
			 try {
			 selenium.waitForElementsToBeVisible("resolutionTab");
			 selenium.waitingTime(2000);
			 selenium.jsClick("resolutionTab");
			 System.out.println("Inside Resolution Tab");
			 selenium.waitingTime(2000);
			 selenium.scrollToElement("resolutionTab");
			 selenium.waitingTime(2000);
			 boolean internalDescriptionResTab=selenium.isElementPresentXpathFast("InternalDescriptioninResTab");
			 if(internalDescriptionResTab==false) {
					
				 System.out.println("Internal description is not present under Resolution Tab");
				}
				else {
					System.out.println("Internal description is present under Resolution Tab");
				}
				selenium.captureScreenShot();
			 }
			 catch (Exception e)
				{
					selenium.reportFailure("Error while verifying resolution tab internal desciption " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
			}
		 

		 @Then("^verify the internal description history page$")
		 public void verify_the_internal_description_history_page() throws Exception {
			 try {
			    selenium.refresh();
			    selenium.waitingTime(8000);
			    //selenium.switchOutOfFrame();
			    System.out.println("Clicking on Show All Links");
			    if(selenium.isElementPresentFast("showAllVal"))
			    {
					selenium.waitForElementToBeClickable("showAllVal");
					selenium.click("showAllVal");			    	
			    }
				selenium.waitForElementToBeClickable("internalDescriptionHistorybtn");
				selenium.jsClick("internalDescriptionHistorybtn");
				selenium.waitingTime(6000);
				String orderStage = selenium.getText("orderStageVal").toString();
				String requestReason = selenium.getText("requestReasonVal").toString();
				String action = selenium.getText("actionVal").toString();
				String expected_orderStage = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Order Stage");
				String expected_requestReason = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Request Reason");
				String expected_action = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Action");
				System.out.println("status" + orderStage + expected_orderStage + requestReason + expected_requestReason + action + expected_action);
				if (orderStage.equalsIgnoreCase(expected_orderStage) && requestReason.equalsIgnoreCase(expected_requestReason) && action.equalsIgnoreCase(expected_action)) {
					System.out.println("inside pass");
					selenium.test.log(LogStatus.PASS, "Internal Description History Tab verification completed");

				} else {
					System.out.println("inside fail");
					selenium.test.log(LogStatus.FAIL, "Internal Description History Tab verification failed");
					selenium.reportFailure("Internal Description History Tab verification failed");
		 }
				selenium.closeSubTabs();
				selenium.waitingTime(2000);
		}
			 catch (Exception e)
				{
					selenium.reportFailure("Error while verifying Internal Description History Tab " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
				
	
		 }
		 
		 @And("^fill mandatory fields to change the owner of CSOM Case$")
		    public void fill_mandatory_fields_to_change_the_owner_of_csom_case() {
			 
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
				 selenium.switchOutOfFrame();
				 selenium.waitingTime(2000);
				 selenium.test.log(LogStatus.PASS, "Case closed successfully");
			 }
				 
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while changing the owner of case " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
					}
		 }
		 
		 
		 @Then("^verify the status of changed record$")
		    public void verify_the_status_of_changed_record() {
			 
			 try {
				 selenium.waitingTime(15000);
				 selenium.refresh();
				 selenium.waitForElementToBeClickable("caseinsidecontact");
				 selenium.jsClick("caseinsidecontact");
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

					String recordDate = selenium.getElement("lastModifiedDateRecordNew").getAttribute("innerHTML");
					System.out.println("todays date"+todaysDate);
					System.out.println("record date"+recordDate);
					System.out.println("yesterday/today date" + yesterdaysDate);
					
					if(recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
						System.out.println("inside date check");
						String status = selenium.getText("caseStatusAfterClosing").toString();
						String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
						System.out.println("status" +status + expected_status );
						if (status.equalsIgnoreCase(expected_status)) {
							selenium.test.log(LogStatus.PASS, "Status is changed");

						} else {
							selenium.test.log(LogStatus.FAIL, "Status is not changed");
							selenium.reportFailure("Status is not changed");

						}
					}
					else {
						System.out.println("clicking last modified date");
						selenium.waitForElementToBeClickable("dateOrTimecaseOpened");
						selenium.jsClick("dateOrTimecaseOpened");
						selenium.waitingTime(3000);
						String recordDate1 = selenium.getElement("lastModifiedDateRecordNew").getAttribute("innerHTML");
						 if(recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
								System.out.println("date matched");
							
						 	String status = selenium.getText("caseStatusAfterClosing").toString();
							String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
							System.out.println("status" +status + expected_status );
							if (status.equalsIgnoreCase(expected_status)) {
								selenium.test.log(LogStatus.PASS, "Status is changed");

							} else {
								selenium.test.log(LogStatus.FAIL, "Status is not changed");
								selenium.reportFailure("Status is not changed");
							}
					}
					
					
					 
					}
					
			 }
			 catch (Exception e) {
					
				 
					selenium.reportFailure("Error while verifying case status " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
					}
		 }
		 
		 @And("^fill mandatory fields to change owner of CXG Case$")
		    public void fill_mandatory_fields_to_owner_of_cxg_case() {
			 
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
					
					selenium.reportFailure("Error while closing case " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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
		 
		 @Then("^verify the status of changed CXG record$")
		    public void verify_the_status_of_changed_cxg_record() {
			 
			 try {
				
				 selenium.waitingTime(5000);
				 	
				 	String status = selenium.getText("caseCXGClosedStatus").toString();
					String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
					System.out.println("status" +status + expected_status );
					selenium.captureScreenShot();
					if (status.equalsIgnoreCase(expected_status)) {
						System.out.println("inside pass" );
						selenium.test.log(LogStatus.PASS, "Status is changed : "+status +" Expected : "+expected_status);

					} else {
						System.out.println("inside fail" );
						selenium.test.log(LogStatus.FAIL, "Status is changed : "+status +" Expected : "+expected_status);
						selenium.reportFailure("Test Case Failed");
					}
					
			 }
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying case status " + e.getMessage());
			 }
		 }
		 
		 
		 @Then ("^verify the owner with edited case details$")
		 public void verify_the_owner_with_edited_case_details() {
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
						selenium.test.log(LogStatus.PASS, "Existing Case edited successfully");

					} else {
						System.out.println("inside fail");
						selenium.test.log(LogStatus.FAIL, "Existing Case editing failed");
						

					}
					
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					}
					 catch (Exception e) {
						 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
							selenium.reportFailure("Error while verifying case details" + e.getMessage());
						
						}
		 
		 }
		 
		    @Then ("^click on edit case button for ALEKS$")
		    public void click_on_edit_case_button_for_ALEKS() {
		    	try {
					 selenium.waitForElementToBeClickable("closeCaseTab");
					 selenium.jsClick("closeCaseTab");
					 selenium.waitingTime(5000);
				
				 }
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while clicking on edit case " + e.getMessage());
					}
		    	
		    }
			@And ("^fill mandatory fields to edit ALEKS Case$")
			public void fill_mandatory_fields_to_edit_ALEKS_case() {
				try {
					selenium.waitingTime(4000);
					if (selenium.isElementPresentFast("loginPopUp"))
					{
						System.out.println("I am inside loginPopup method");
						selenium.clickLoop("loginPopUp");
						selenium.waitingTime(2000);
					}
					 selenium.waitForElementToBeClickable("closingStatus");
					 selenium.jsClick("closingStatus");
					 selenium.waitForElementToBeVisible("closingStatus");
					 selenium.selectDropdownText("closingStatus", "Close Status");
					 selenium.waitForElementToBeClickable("caseResolution");
					 selenium.jsClick("caseResolution");
					 selenium.waitingTime(2000);
					 selenium.type("caseResolution", "Case Resolution");
					 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
					 selenium.jsClick("caseCXGCloseMarketDropdown");
					 selenium.waitingTime(2000);
					 selenium.clickDynamic("spanTitle", "Market", "end");
					 selenium.waitingTime(4000);
					 selenium.captureScreenShot();
					 selenium.waitForElementToBeClickable("saveButton");
					 selenium.jsClick("saveButton");
					 selenium.waitingTime(5000);
					 selenium.test.log(LogStatus.PASS, "Case edited successfully");
				 }
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while closing case " + e.getMessage());
					}
				
			}
			@Then ("^verify the status of edited ALEKS record$")
			public void verify_the_status_of_edited_ALEKS_record() {
				try {
					
						selenium.waitingTime(15000);
						selenium.waitForElementToBeVisible("caseCXGClosedStatus");
					 	String status = selenium.getTextLoop("caseCXGClosedStatus").toString();
						String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
						System.out.println("status" +status + expected_status );
						if (status.equalsIgnoreCase(expected_status)) {
							System.out.println("inside pass" );
							selenium.test.log(LogStatus.PASS, "Owner is updated");

						} else {
							System.out.println("inside fail" );
							selenium.test.log(LogStatus.FAIL, "Owner is not updated");
							

						}
						selenium.captureScreenShot();
						selenium.waitingTime(10000);
				 }
				 catch (Exception e) {
					 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Error while verifying case status " + e.getMessage());
				 }
				
			}
		 
}