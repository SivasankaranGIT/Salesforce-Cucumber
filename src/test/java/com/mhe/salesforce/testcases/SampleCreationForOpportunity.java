package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleCreationForOpportunity {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^verify account and orders details page$")
    public void verify_account_and_orders_details_page() {
		try {
		selenium.waitForElementToBeClickable("contactDropdownOnOrderPad");
		selenium.jsClick("contactDropdownOnOrderPad");
		selenium.waitingTime(2000);
		selenium.selectDropdownByIndex("contactDropdownOnOrderPad", "Index");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("sampleOpportunityAccountName1");		
		String account = selenium.getElement("sampleOpportunityAccountName1").getText();
		System.out.println("account is" + account);
		String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
		 String expected_line = selenium.fetchTextFromDropdown("contactDropdownOnOrderPad");
		System.out.println("attention line is" + line);
		if (account!= null & line.equalsIgnoreCase(expected_line)) {
			selenium.test.log(LogStatus.PASS, "account and attention line prepopulated" );
			System.out.println("INSIDE PASS");
		}
		
		else
		{
			selenium.test.log(LogStatus.FAIL, "account and attention line not prepopulated" );
			selenium.reportFailure("account and attention line not prepopulated");
			System.out.println("INSIDE FAIL");
		}
		
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		String address = selenium.getElement("addressValueOnOrderPad").getText();
		System.out.println("address is" + address);
		if(address.isBlank() || address.isEmpty()) {
			System.out.println("Address is empty");
			selenium.waitForElementToBeClickable("searchAddressonNewSample");
		selenium.click("searchAddressonNewSample");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("createNewAddressonSample");
		selenium.click("createNewAddressonSample");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
		selenium.click("street1OnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("street1OnNewSampleAddress", "Street 1");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
		selenium.click("cityOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("cityOnNewSampleAddress", "City");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
		selenium.click("stateOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("stateOnNewSampleAddress", "State");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
		selenium.click("zipOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("zipOnNewSampleAddress", "Zip");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
		selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
		selenium.click("workflowStatusNoteOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
		selenium.waitingTime(2000);
		selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		
		if(selenium.isElementPresentFast("errorMessageOnSampleAddress")==true) {
			selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
			selenium.jsClick("closeButtonOnSampleAddress");
		}
		selenium.waitForElementToBeClickable("saveButton");
		selenium.jsClick("saveButton");
		selenium.waitingTime(6000);
		}
		
		selenium.scrollToElement("orderLineTypeOnOrderPad");
		//boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad","Order Line Type");
		boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad","SFDC Status");
		boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad","Ship Method");
		boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad","Ship Priority");
		//System.out.println("value is" + value1);
		
		String name = selenium.getText("desiredOwnerOnOrderPad").toString();
		 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
		System.out.println("actual owner is" + name + expected_name);
		
		if(value2==true & value3==true & value4==true & name.equalsIgnoreCase(expected_name) ) {
			selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page" );
			
			System.out.println("INSIDE PASS 1");
		}
		
		else
			
		{
			selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page" );
			System.out.println("INSIDE fail 1");
			selenium.reportFailure("Test Case Failed");
		}
		
		
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		
		
		}
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	@Then("^verify account and orders details page and click next$")
    public void verify_account_and_orders_details_page_and_click_next() {
		try {
		selenium.waitForElementToBeClickable("contactDropdownOnOrderPad");
		selenium.jsClick("contactDropdownOnOrderPad");
		selenium.waitingTime(2000);
		selenium.selectDropdownByIndex("contactDropdownOnOrderPad", "Index");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("sampleOpportunityAccountName1");
		String account = selenium.getElement("sampleOpportunityAccountName1").getText();
		System.out.println("account is" + account);
		String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
		 String expected_line = selenium.fetchTextFromDropdown("contactDropdownOnOrderPad");
		System.out.println("attention line is" + line);
		if (account!= null & line.equalsIgnoreCase(expected_line)) {
			selenium.test.log(LogStatus.PASS, "account and attention line prepopulated" );
			System.out.println("INSIDE PASS");
		}
		
		else
		{
			selenium.test.log(LogStatus.FAIL, "account and attention line not prepopulated" );
			System.out.println("INSIDE fail");
			selenium.reportFailure("Test Case Failed");
		}
		
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("addressValueOnOrderPad");
		String address = selenium.getElement("addressValueOnOrderPad").getText();
		System.out.println("address is" + address);
			if(address.isBlank() || address.isEmpty()) {
		selenium.click("searchAddressonNewSample");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("createNewAddressonSample");
		selenium.click("createNewAddressonSample");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
		selenium.click("street1OnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("street1OnNewSampleAddress", "Street 1");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
		selenium.click("cityOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("cityOnNewSampleAddress", "City");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
		selenium.click("stateOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("stateOnNewSampleAddress", "State");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
		selenium.click("zipOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("zipOnNewSampleAddress", "Zip");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
		selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
		selenium.click("workflowStatusNoteOnNewSampleAddress");
		selenium.waitingTime(2000);
		selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
		selenium.waitingTime(2000);
		selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		
		if(selenium.isElementPresentFast("errorMessageOnSampleAddress")==true) {
			selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
			selenium.jsClick("closeButtonOnSampleAddress");
		}
		selenium.waitForElementToBeClickable("saveButton");
		selenium.jsClick("saveButton");
		selenium.waitingTime(6000);
		}
		
		selenium.scrollToElement("orderLineTypeOnOrderPad");
		//boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad","Order Line Type");
		boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad","SFDC Status");
		boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad","Ship Method");
		boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad","Ship Priority");
		//System.out.println("value is" + value1);
		
		String name = selenium.getText("desiredOwnerOnOrderPad").toString();
		 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
		System.out.println("actual owner is" + name + expected_name);
		
		if(value2==true & value3==true & value4==true & name.equalsIgnoreCase(expected_name) ) {
			selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page" );
			
			System.out.println("INSIDE PASS 1");
		}
		
		else
			
		{
			selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page" );
			System.out.println("INSIDE fail 1");	
			selenium.reportFailure("Test Case Failed");
		}
		
		
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("NxtButton");
		selenium.jsClick("NxtButton");
		selenium.waitingTime(2000);
		

		
		}
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	 @Then("^select order line type as FWO US$")
	    public void select_order_line_type_as_FWO_us() {
			try {
			
			
				selenium.waitForElementToBeClickable("orderLineTypeOnOrderPad");
			selenium.jsClick("orderLineTypeOnOrderPad");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("orderLineTypeOnOrderPad", "Order Line Type");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Order line type selected as FWO - US" );
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
			
			}
			
	
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while editing order line type" + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
	 
	 @Then("^select order line type as Pilot US$")
	    public void select_order_line_type_as__pilot_us() {
			try {
			
			
				selenium.waitForElementToBeClickable("orderLineTypeOnOrderPad");
			selenium.jsClick("orderLineTypeOnOrderPad");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("orderLineTypeOnOrderPad", "Order Line Type");
			selenium.waitingTime(2000);
			Calendar calendar= Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow=calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.typeData("pilotEndDateText", todaysdate);
			//selenium.jsClick("pilotEndDate");
//			selenium.waitingTime(2000);
			//selenium.type("pilotEndDate", "Pilot End Date");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Order line type selected as Pilot - US" );
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
			
			}
			
	
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while editing order line type" + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
	 @Then("^Review details on review page$")
	    public void eview_details_on_review_page() {
			try {
			boolean accountname = selenium.isElementPresentFast("accountNameOnReviewOrderPad");
			boolean address = selenium.isElementPresentFast("addressReviewOnOrderPad");
			boolean cost = selenium.isElementPresentFast("totalRepCostOnReviewOrderPad");
			boolean product = selenium.isElementPresentFast("productsOnReviewPageForOrderPad");
			boolean line = selenium.isElementPresentFast("attnLineOnOredrPad");
			System.out.println("attention line is" + line);
			if (accountname==true & address == true & cost == true & product==true & line==true) {
				selenium.test.log(LogStatus.PASS, "Details reviewed successfully" );
				System.out.println("INSIDE PASS 3");
				
			}
			
			else
			{
				selenium.test.log(LogStatus.FAIL, "Details are not proper on review page" );
				System.out.println("INSIDE Fail 3");
				selenium.reportFailure("Test Case Failed");
			}
			
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("createSampleOrderBtn");
				selenium.click("createSampleOrderBtn");
				selenium.waitingTime(5000);
				
				if(selenium.isElementPresentFast("duplicateSamplesPopup")==true) {
					selenium.waitForElementToBeClickable("createSamples");
					selenium.jsClick("createSamples");
					selenium.waitingTime(5000);
				}
				
				
				
			}
		
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error on review page" + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}

	}
		
}
