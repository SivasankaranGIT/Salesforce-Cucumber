package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSampleThroughOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean contactCheckbox, productCheckbox;

	@Then("^I create new sample from Opportunity for MHHE user$")
	public void create_sample() {
		try {

			selenium.search("Opportunity Name");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(6000);

			if (selenium.isElementPresentFast("newSampleFromOpportunity")) {
				selenium.waitForElementToBeClickable("newSampleFromOpportunity");
				selenium.clickLoop("newSampleFromOpportunity");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitingTime(4000);
//				selenium.waitForElementToBeVisible("newSampleFromOpportunityLink");
				selenium.clickLoop("newSampleFromOpportunityLink");
			}
//			selenium.waitingTime(2000);

//			selenium.waitForElementsToBeVisible("newSampleFromOpportunity");
//			selenium.clickLoop("newSampleFromOpportunity");
			selenium.waitingTime(6000);
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			selenium.switchToMultipleFrame("productframeUat");
			if (selenium.getElement("contactSampleCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "All the contacts linked to the opportunity are auto-selected");
			}
			
			selenium.scrollToElement("productSampleCheckbox");
			if (selenium.getElement("productSampleCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "All the products linked to the opportunity are auto-selected");
			}

			selenium.scrollToElement("ClickNextButton");
			selenium.jsClick("ClickNextButton");
			selenium.waitingTime(3000);
			
			String checkBox = selenium.getDynamicXpath("divText", "Sample Name", "productCheckBoxDynamic");
//			selenium.waitForXpathElementToBeClickable(checkBox);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(checkBox);
			
			selenium.jsClick("createSampleOrderBtn");
			
			selenium.retryingWaitForVisibility("duplicateSamplePopup");
			System.out.println("Sample Creation In progress popup disappeared");
			selenium.test.log(LogStatus.INFO, "Sample Creation In progress popup disappeared");
			selenium.waitingTime(15000);
			
			if(selenium.waitForElementToBeVisible("duplicateSamplePopup")==true) {
				selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
				selenium.click("dupOverrideOptionCheckBox");
				selenium.waitForElementToBeClickable("dupOKBtn");
				selenium.click("dupOKBtn");
			}
			selenium.retryingWait("showAllLinks");
			System.out.println("Show All Links visible now");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			
			selenium.waitForElementToBeClickable("showAllLinks");
			selenium.click("showAllLinks");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("sampleLink");
				selenium.click("sampleLink");

			} else {
				selenium.waitForElementToBeClickable("sampleLink");
				selenium.click("sampleLink");
			}
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(4000);
//			String sample = selenium.getDynamicXpath("spantextContains", "Sample Name", "endContains");
//			selenium.waitingTime(8000);
//			selenium.clickLoopXpath(sample);
			selenium.waitForElementToBeClickable("FirstOppOrderRecord");
			selenium.jsClick("FirstOppOrderRecord");
			selenium.waitingTime(5000);
			
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			System.out.println("Today Date is: " + todaysDate);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			System.out.println("Today or Yesterday Date is: " + yesterdaysDate);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("sampleStatusDateGetText");
			String recordDate = selenium.getTextLoop("sampleStatusDateGetText").toString();
			System.out.println("recordDate is: " + recordDate);

			if (recordDate.contains(todaysDate)|| recordDate.contains(yesterdaysDate)) {
				selenium.test.log(LogStatus.PASS, "Sample contact created successfully today");
				System.out.println("PASS");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Sample contact creation failed");
				selenium.reportFailure("Sample contact creation failed");
			}
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while navigating to opportunity");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}
	
	@Then("^I create new sample from Opportunity for Marketing user$")
	public void create_sample_mkt() {
		try {

			selenium.waitingTime(6000);

			if (selenium.isElementPresentFast("newSampleFromOpportunity")) {
				selenium.clickLoop("newSampleFromOpportunity");
			} else {
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("newSampleFromOpportunityLink");
				selenium.clickLoop("newSampleFromOpportunityLink");
			}
			selenium.waitingTime(4000);
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			selenium.switchToMultipleFrame("productframeUat");

			if(selenium.isElementPresentFast("okProdSwap")){
				selenium.click("okProdSwap");
			}
			if (selenium.getElement("contactSampleCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "All the contacts linked to the opportunity are auto-selected");
			}
			
			selenium.scrollToElement("productSampleCheckbox");
			if (selenium.getElement("productSampleCheckbox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "All the products linked to the opportunity are auto-selected");
			}

			selenium.scrollToElement("ClickNextButton");
			selenium.waitForElementToBeClickable("ClickNextButton");
			selenium.jsClick("ClickNextButton");
			selenium.waitingTime(3000);
			
			String checkBox = selenium.getDynamicXpath("divText", "Sample Name Mkt", "productCheckBoxDynamic");
//			selenium.waitForXpathElementToBeClickable(checkBox);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(checkBox);
			selenium.waitForElementToBeClickable("createSampleOrderBtn");
			selenium.jsClick("createSampleOrderBtn");			
			selenium.retryingWaitForVisibility("duplicateSamplePopup");
			System.out.println("Sample Creation In progress popup disappeared");
			selenium.test.log(LogStatus.INFO, "Sample Creation In progress popup disappeared");
			selenium.waitingTime(15000);
			
			if(selenium.waitForElementToBeVisible("duplicateSamplePopup")==true) {
				selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
				selenium.click("dupOverrideOptionCheckBox");
				selenium.waitForElementToBeClickable("duplicateOKButton");
				selenium.click("duplicateOKButton");
			}
			selenium.retryingWait("showAllLinks");
			System.out.println("Show All Links visible now");
			selenium.waitingTime(10000);
			selenium.switchOutOfFrame();
			
			selenium.waitForElementToBeClickable("showAllLinks");
			selenium.click("showAllLinks");
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("sampleFromOpportunityLink");
				selenium.click("sampleFromOpportunityLink");

			} else {
				selenium.waitForElementToBeClickable("sampleFromOpportunityLink");
				selenium.click("sampleFromOpportunityLink");
			}
			selenium.waitingTime(3000);
			
			Calendar calendar1 = Calendar.getInstance();
            Date date = calendar1.getTime();
            SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
            String todaysDate = sdf1.format(date);
            String recordDate = selenium.getTextLoop("lastModifiedDateRecord");
            System.out.println("todays date"+todaysDate);
            System.out.println("record date"+recordDate);
           
            if(recordDate.contains(todaysDate)) {
                System.out.println("inside date check");
                selenium.jsClick("sampleRecordTable");   
                selenium.waitingTime(5000);
            }
            else {
                System.out.println("clicking last modified date");
                selenium.jsClick("lastModifiedDate");
//                selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("lastModifiedDateRecord");
                recordDate = selenium.getTextLoop("lastModifiedDateRecord");
                selenium.waitingTime(3000);
                if(recordDate.contains(todaysDate)) {
                    System.out.println("date matched");
                    selenium.waitForElementToBeClickable("sampleRecordTable");
                    selenium.jsClick("sampleRecordTable");   
                    selenium.waitingTime(5000);
                    selenium.test.log(LogStatus.PASS, "Sample creation successful ");
                }
                else {
                    selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
                    selenium.reportFailure("Sample creation failed");
                }
            }
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while navigating to opportunity");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}


}
