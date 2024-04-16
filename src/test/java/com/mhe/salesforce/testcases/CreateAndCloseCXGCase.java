package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateAndCloseCXGCase {
	
	WebConnector selenium = WebConnector.getInstance();

		@And("^fill all mandatory details to create CXG case$")
	    public void fill_all_mandatory_details_to_create_cxg_case() {
		 
		 try {
			 selenium.waitingTime(3000);
			 
			 if(selenium.getElement("Subject_field").isDisplayed()) {
				 System.out.println("inside first");
			 selenium.type("Subject_field", "Subject");
			 selenium.waitingTime(2000);
			 }
			 
			 else if(selenium.getElement("caseCXGSubject2").isDisplayed()) {
				 System.out.println("inside second");
				 selenium.type("caseCXGSubject2", "Subject");
				 selenium.waitingTime(2000);
				 }
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Save_Btn");
			 selenium.jsClick("Save_Btn");
			 selenium.waitingTime(10000);

			 selenium.refresh();
			 selenium.waitingTime(10000);
			 selenium.checkFlowInterruptedPopup();
			 selenium.scrollToElement("Case_CXG_ProductField");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Case_CXG_ProductField");
			 selenium.click("Case_CXG_ProductField");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("ProductType_ALEKS");
			 selenium.click("ProductType_ALEKS");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Case_CXG_IncidentField");
			 selenium.click("Case_CXG_IncidentField");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("IncidentOption");
			 selenium.click("IncidentOption");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(30);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Case_CXG_SubIncidentField");
			 selenium.click("Case_CXG_SubIncidentField");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Case_CXG_SubIncidentOption");
			 selenium.click("Case_CXG_SubIncidentOption");
			 selenium.waitingTime(2000);
			 selenium.scrollToElement("Case_CXG_BUField");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Case_CXG_BUField");
			 selenium.click("Case_CXG_BUField");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("BU_Option");
			 selenium.click("BU_Option");
			 selenium.waitingTime(2000);
			 selenium.scrollToElement("Save_Button");
			 selenium.waitingTime(2000);
			 selenium.scrolldown(-200);
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Save_Button");
			 selenium.click("Save_Button");
			 selenium.waitingTime(10000);
			 selenium.CXGCaseURL = selenium.getURL();
			 System.out.println("Newly created CXG Case URL is " + selenium.CXGCaseURL);
		 }
		 catch (Exception e) {
			 System.out.println("inside catch block");
				System.out.println("inside catch");
				selenium.reportFailure("Error while creating new case " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");				
				}		
	 }
 
 @And("^verify CXGUpdates and FindINTLContacts button$")
 public void verify_button()
 {	 
	 try
	 {
		 //VERIFY FIND INTL CONTACT BUTTON IS THERE OR NOT
		 selenium.refresh();
		 selenium.waitingTime(10000);
	        if (selenium.isElementPresentFast("loginPopUpNew"))
	        {
		       	System.out.println("I am inside loginPopUpNew method");
		       	selenium.clickLoop("loginPopUpNew");
		       	selenium.waitingTime(2000);	
	        }
	        else if (selenium.isElementPresentFast("loginPopUp"))
			 {
	       	 	 System.out.println("I am inside loginPopup method");
	       	 	 selenium.click("loginPopUp");
	       	 	 selenium.waitingTime(2000);
			 }
	        if(selenium.isElementPresentFast("moreActionsBtn"))
	        {
				 selenium.scrollToElement("moreActionsBtn");
				 selenium.waitingTime(2000);
				 selenium.scrolldown(-200);
				 selenium.waitingTime(2000);
				 selenium.click("moreActionsBtn");
				 if(!selenium.isElementPresentFast("FindINTLContactBtn"))
				 {
					System.out.println("inside pass" );
					selenium.test.log(LogStatus.PASS, "Find INTL Contact button is not present");
				 }
				 else
				 {
					System.out.println("inside fail" );
					selenium.test.log(LogStatus.FAIL, "Find INTL Contact button is present");
					selenium.reportFailure("Find INTL Contact button is present");
				 }
	        }

		 //VERIFY CXG UPDATE BUTTON REDIRECTION NEW PAGE (this page is asking for OKTA credentials again)
		/* selenium.waitForElementToBeClickable("CXGUpdatesBtn");
		 selenium.click("CXGUpdatesBtn");
		 selenium.waitingTime(2000);
		 selenium.switchToChildWindow();
		 String ActualCXGUpdatePageURL = selenium.getURL();
		 String ExpectedCXGUpdatePageURL = "https://mcgrawhill.atlassian.net/jira/dashboards/10091";
		 if(ActualCXGUpdatePageURL.equalsIgnoreCase(ExpectedCXGUpdatePageURL))
		 {
			System.out.println("inside pass" );
			selenium.test.log(LogStatus.PASS, "ActualCXGUpdatePageURL : "+ActualCXGUpdatePageURL +" ExpectedCXGUpdatePageURL : "+ExpectedCXGUpdatePageURL);
		 }
		 else
		 {
			System.out.println("ActualCXGUpdatePageURL : "+ActualCXGUpdatePageURL +" ExpectedCXGUpdatePageURL : "+ExpectedCXGUpdatePageURL);
			selenium.test.log(LogStatus.FAIL, "ActualCXGUpdatePageURL : "+ActualCXGUpdatePageURL +" ExpectedCXGUpdatePageURL : "+ExpectedCXGUpdatePageURL);
			selenium.reportFailure("Test Case Failed");
		 }
		 
		selenium.close();
		selenium.waitingTime(2000);
		selenium.switchBackToParentWindow();*/
		selenium.waitingTime(5000); 
	 }
	 catch (Exception e)
	 {
		selenium.reportFailure("Error while verifying CXGUpdates and FindINTLContacts button " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Error while verifying CXGUpdates and FindINTLContacts button");			
	 }
 }
 
 @And("^edit the case origin$")
 public void edit_the_case_origin() {
	 
	 try {
		 selenium.refresh();
		 selenium.waitingTime(10000);
		 selenium.waitForElementToBeClickable("editButton");
		 selenium.clickLoop("editButton");
		 selenium.waitingTime(4000);
		 selenium.waitForElementToBeClickable("Case_OriginDropDown");
		 selenium.jsClick("Case_OriginDropDown");
		 selenium.waitingTime(2000);
		 selenium.clickDynamicData("spanTitle", "Email", "end");
		 selenium.waitingTime(2000);
		 selenium.type("Subject_field", "Subject");
		 selenium.click("Save_Btn");
		 selenium.waitingTime(8000);
		 System.out.println("Updated Case origin from Phone to Email");
		 selenium.test.log(LogStatus.INFO, "Updated Case origin from Phone to Email");	
	 }
	 catch (Exception e) {
			selenium.reportFailure("Error while editing case origin " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing case origin");			
			}
 }
	 
	 @Then("^click on close case button for CXG$")
	    public void click_on_close_case_button_for_CXG() {
		 
		 try {
			 selenium.refresh();
//			 selenium.waitingTime(8000);
//			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("Close_case");
			 selenium.jsClick("Close_case");
			 selenium.waitingTime(8000);
			 
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking on close case " + e.getMessage());
			}
	 }
	 
	 @And("^fill mandatory fields to close CXG Case$")
	    public void fill_mandatory_fields_to_close_cxg_case() {
		 
		 try {

			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("closingStatus");
			 selenium.jsClick("closingStatus");
			 selenium.waitingTime(2000);
			 selenium.selectDropdownText("closingStatus", "Close Status");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseResolution");
			 selenium.jsClick("caseResolution");
			 selenium.waitingTime(2000);
			 selenium.type("caseResolution", "Case Resolution");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
			 selenium.jsClick("caseCXGCloseMarketDropdown");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Market", "end");
//			 selenium.waitingTime(4000);
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
	 
	 @Then("^verify the status of closed CXG record$")
	    public void verify_the_status_of_closed_cxg_record() {
		 
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
	 
	 

}
