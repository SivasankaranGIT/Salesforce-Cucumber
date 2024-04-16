package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DigitalOfferFromOpportunity {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^click MHHE Digital Offers$")
    public void click_mhhe_digital_offers() {
		
		try {
			
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("mhheDigitalOffersSection");
			selenium.jsClick("mhheDigitalOffersSection");
//			selenium.waitingTime(5000);
			//selenium.waitForElementToBeClickable("NewButton");
//			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.clickLoop("NewButton");
			selenium.waitingTime(8000);
			
			
		}
		catch (Exception e) {
			selenium.reportFailure("Error while  navigating to digital offers section " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("^create new digital offer$")
    public void create_new_digital_offer() {
		
		try {
			
			selenium.waitForElementToBeClickable("mhheDigitalOfferName");
			selenium.click("mhheDigitalOfferName");
			selenium.waitingTime(2000);
			selenium.type("mhheDigitalOfferName","Offer Name");
//			selenium.waitingTime(3000);
			/*
			 * selenium.jsClick("mhheDigitalStatusDropdown");
			 * selenium.clickDynamic("spanTitle", "Status", "end");
			 * selenium.waitingTime(2000); selenium.captureScreenShot();
			 * selenium.waitingTime(2000);
			 */
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			 selenium.test.log(LogStatus.PASS, "Digital Offer Created Successfully" );
		 
			
		}
		catch (Exception e) {
			selenium.reportFailure("Error while creating offer" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else {
				System.out.println("inside else to click cancel");
				selenium.reportFailure("Error while creating offer " + e.getMessage());
				selenium.click("CancelButton");
			}
		}
	}
	
	@And("^delete offer$")
    public void delete_offer(){
		 
		 try {

			 selenium.waitingTime(50000);
			
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				//SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				//String todaysDate = sdf1.format(date);
			    String todaysDate = selenium.getCurrentUSDate("M/d/yyyy");
				String recordDate =  selenium.getText("lastModifiedDateRecord1");
				
				calendar1.setTime(date);
				calendar1.add(Calendar.DATE, -1);
				Date dateBefore1Day = calendar1.getTime();
				SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
				String yesterdaysDate = sdf2.format(dateBefore1Day);
				
				System.out.println("todays date "+todaysDate);
				System.out.println("record date "+recordDate);
				System.out.println("yesterday/today date " + yesterdaysDate);
				
				if(recordDate.contains(todaysDate)|| recordDate.contains(yesterdaysDate)) {
					System.out.println("inside date check");
					selenium.refresh();
					selenium.waitingTime(6000);
					selenium.waitForElementToBeClickable("MoreActionBtn2");
					selenium.click("MoreActionBtn2");
					selenium.waitingTime(4000);
//					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("DeleteRecord");
					selenium.jsClick("DeleteRecord");
					 selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("deleteBtn");
					 selenium.click("deleteBtn");
					 selenium.waitingTime(9000);
					 selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					
				}
				else {
					System.out.println("clicking last modified date");
					selenium.waitForElementToBeClickable("lastCreatedDateRecord");
					selenium.jsClick("lastCreatedDateRecord");
					selenium.waitingTime(6000);
					selenium.refresh();
					selenium.waitingTime(6000);
					String recordDate1 =  selenium.getText("lastModifiedDateRecord1");
					selenium.test.log(LogStatus.INFO, "Record Date "+recordDate1 +"System Date :"+todaysDate);
					System.out.println("Record Date "+recordDate1 +"System Date :"+todaysDate);
					if(recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
						System.out.println("date matched");
						selenium.waitForElementToBeClickable("MoreActionBtn2");
						selenium.click("MoreActionBtn2");
						selenium.waitingTime(4000);
						selenium.waitForElementToBeClickable("DeleteRecord");
						selenium.jsClick("DeleteRecord");
						 selenium.waitingTime(5000);
						selenium.waitForElementToBeClickable("deleteBtn");
						 selenium.click("deleteBtn");
						 selenium.waitingTime(9000);
						 selenium.captureScreenShot();
//						selenium.waitingTime(2000);
					}
					else {
						selenium.captureScreenShot();
						selenium.test.log(LogStatus.FAIL, "Digital Offer delete failed");
						selenium.reportFailure("Digital Offer delete failed");
					}
				}
			 	
			 
			 		selenium.test.log(LogStatus.PASS, "Digital offer deleted");
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while deleting offer " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
}
