package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;

//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApproveAndDenySample {
	WebConnector selenium = WebConnector.getInstance();
//	String nssViewcase="https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v8D0000009Vr8QAE/view";
//	String nssViewcaseNew="https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v8b00000a4iIlAAI/view";
//	String sampleURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v7h000002Q4cmAAC/view";

//	 @And("^choose customer pending list view$")
//	    public void choose_customer_pending_list_view() {
//		try {
//		selenium.waitForElementToBeClickable("listViewOpportunity");
//		selenium.click("listViewOpportunity");
////		selenium.waitingTime(3000);
//		selenium.waitForElementToBeClickable("listViewFilter");
//		selenium.click("listViewFilter");
//		selenium.waitingTime(3000);
//		selenium.type("listViewFilter", "List View");
////		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("listViewFilterResult");
//		selenium.click("listViewFilterResult");
//		selenium.waitingTime(90000);
//		}
//		 catch (Exception e) {
//			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				selenium.reportFailure("Error while choosing list view" + e.getMessage());
//			}
//
//	}
	 
	 @Then("^select sample from results$")
	    public void select_sample_from_results()  {
			try {
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(15000);
			if(selenium.getElement("nssViewcaseList").isDisplayed()) {
				System.out.println("list results present");
				selenium.test.log(LogStatus.PASS, "Shop samples present");

			} else {
				System.out.println("list results not present");
				selenium.test.log(LogStatus.FAIL, "Shop samples not present");
				selenium.reportFailure("Shop samples not present");
			}
			
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
//			selenium.navigateToURL(nssViewcaseNew);
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v8b00000a4iIlAAI/view");
			selenium.waitingTime(5000);
			
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while choosing list view result for samples" + e.getMessage());
				
				}

		}
	 
	 @And("^approve sample$")
	    public void approve_sample() {
			try {

//			selenium.navigateToURL(sampleURL);
			selenium.captureScreenShot();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("editButton");
//			selenium.waitingTime(2000);
			selenium.clickLoop("editButton");
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("SampleSFDCStatusDropDwn");
			selenium.jsClick("SampleSFDCStatusDropDwn");
			selenium.waitingTime(3000);
			selenium.clickDynamic("spanTitle", "Status", "end");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(9000);
		
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while editing status" + e.getMessage());
				
				}

		}
	 @Then("^deny sample$")
	    public void deny_sample() {
			try {
			
			selenium.waitForElementToBeClickable("editButton");
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.clickLoop("editButton");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("SampleSFDCStatusDropDwn");
			selenium.jsClick("SampleSFDCStatusDropDwn");
			selenium.waitingTime(3000);
			selenium.clickDynamic("spanTitle", "Status1", "end");
//			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("shipMethod");
//				selenium.scrollToElement("shipMethod");
//				selenium.waitingTime(1000);
//				selenium.waitForElementToBeVisible("shipMethodDropdown1");
//				selenium.click("shipMethodDropdown1");
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("shipMethodValue");
//				selenium.click("shipMethodValue");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(9000);
		
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while editing status" + e.getMessage());
				
				}

		}
	 
	 @Then("^verify edited sample details$")
	    public void verify_edited_sample_details()  {
			try {
			
			selenium.waitForElementToBeClickable("sfdcStatusAfterEdit");
			//selenium.scrollToElement("parentCaseField");
			selenium.waitingTime(2000);
			
			String status = selenium.getText("sfdcStatusAfterEdit").toString();
			String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Status1");
			System.out.println("status" +status + expected_status );
			if (status.equalsIgnoreCase(expected_status)) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "sample status edited successfully");

			} else {
				System.out.println("inside fail");
				selenium.test.log(LogStatus.FAIL, "sample status editing failed");
				selenium.reportFailure("sample status editing failed");

			}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying sample status details" + e.getMessage());
				
				}

		}
	
}
