package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SamplecreationVitalSource {
	WebConnector selenium = WebConnector.getInstance();
	String title;
	String sampleUrl;
	
	@Then("^select SFDC Status as approved$")
    public void select_sfdc_status_as_approved()  {
		 
		 try {
//			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("firstProductCheckbox");
			 selenium.click("firstProductCheckbox");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("sampleSFDCStatusDropdown");
			 selenium.click("sampleSFDCStatusDropdown");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("sampleSFDCStatusDropdown", "SFDC Status");
//				selenium.waitingTime(2000);
				 selenium.waitForElementToBeClickable("applyButtonOnSample");
				selenium.click("applyButtonOnSample");
				selenium.waitingTime(5000);
				
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while selecting SFDC status " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }

	@Then("^copy sample name and verify sample status$")
    public void copy_sample_name_and_verify_sample_status() {
		 
		 try {
			 selenium.waitingTime(5000);
			 //sampleSectionInsideContacts
			 selenium.waitForElementToBeClickable("sampleLink_all");
			 selenium.jsClick("sampleLink_all");
			 	selenium.waitingTime(8000);
			 	
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
//				String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate = selenium.getText("lastModifiedDateRecordNew2");
				selenium.captureScreenShot();
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				if(recordDate.contains(todaysDate)) {
					System.out.println("inside date check");
					title = selenium.getElement("sampleRecordTable").getAttribute("title");	
					System.out.println("title is"+ title);
					sampleUrl =selenium.getURL();
//					selenium.waitingTime(2000);
					 selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");	
					selenium.waitingTime(5000);
				}
				else {
					System.out.println("clicking last modified date");
					selenium.waitForElementToBeClickable("lastModifiedDate");
					selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
					 selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
//					String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					 String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
					if(recordDate1.contains(todaysDate)) {
						System.out.println("date matched");
						title = selenium.getElement("sampleRecordTable").getAttribute("title");	
						System.out.println("title is"+ title);
						sampleUrl =selenium.getURL();
//						selenium.waitingTime(2000);
						 selenium.waitForElementToBeClickable("sampleRecordTable");
						selenium.jsClick("sampleRecordTable");	
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						selenium.reportFailure("Test Case Failed");
					}
				}

			 	String status = selenium.getText("sampleSFDCStatusForVitalSource1").toString();
			 	String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SFDC Status");
			 	System.out.println("actual status" + status );
			 	System.out.println("expected status"  +expected_status );

			 	if(status.equalsIgnoreCase(expected_status)) {
			 		selenium.test.log(LogStatus.PASS, "Sample details Verified successfully");
			 		System.out.println("inside second pass");
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample details not proper");
					System.out.println("inside second fail");
					selenium.reportFailure("Test Case Failed");
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(6000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying details on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	
	@And("^search copied sample$")
    public void search_copied_sample() {
		try {
			/*
			selenium.clickLoop("searchTextL");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("campaignFromDrpDwn");
			selenium.click("campaignFromDrpDwn");
			selenium.waitingTime(2000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "New Sample" , "end");
			selenium.scrollToXpathElement(nameXpath);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(2000);
			selenium.searchString(title);

			 */
			selenium.navigateToURL(sampleUrl);
			System.out.println(sampleUrl);
			selenium.test.log(LogStatus.INFO, "Sample URL : "+sampleUrl);
			selenium.waitingTime(16000);
//			selenium.waitingTime(6000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
		}

		catch (Exception e) {

			selenium.reportFailure("Error while searching sample " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
}
