package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Samples_VerifyOracleStatus {
	WebConnector selenium = WebConnector.getInstance();
	String title;
//	public String OppNavigation="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001AbrYAAAZ/view";
//	public String OpptoSampleCreation="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001AbrYAAAZ/view";
	String sampViewUrl;
	@Then("^select order line type as Desk US$")
    public void select_order_line_type_as_desk_us()  {
		 
		 try {
//			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("firstProductCheckbox");
			 selenium.click("firstProductCheckbox");
//			 selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("sampleOrderLineTypeDropDown");
			    selenium.click("sampleOrderLineTypeDropDown");
				selenium.waitingTime(2000);
				selenium.selectDropdownText("sampleOrderLineTypeDropDown", "Order Line Type");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("applyButtonOnSample");
				selenium.click("applyButtonOnSample");
				selenium.waitingTime(5000);
				
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while selecting order line type " + e.getMessage());
			}
	 }
	
	 @And("^click on create sample order for copy$")
	    public void click_on_create_sample_order_for_copy() {
		 
		 try {
				 selenium.waitForElementToBeClickable("createSampleOrder");
				 selenium.click("createSampleOrder");
				 selenium.waitingTime(90000);
				 
				 selenium.takeScreenShot();
				 selenium.waitingTime(2000);
				
				  if(selenium.waitForElementToBeVisible("duplicateSamplePopup")==true) {
					  	 selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
						 selenium.click("dupOverrideOptionCheckBox");
						 selenium.waitingTime(4000);
						 selenium.takeScreenShot();
						 selenium.waitingTime(2000);
					  	 selenium.waitForElementToBeClickable("duplicateOKButtonNew");
						 selenium.click("duplicateOKButtonNew");
						 selenium.waitingTime(4000);
						 selenium.takeScreenShot();
						 selenium.waitingTime(2000);
					}
				  
				/*if(selenium.getElement("duplicateRecord").isDisplayed())
				{
					selenium.click("duplicateYes");
					selenium.waitingTime(2000);
					selenium.click("duplicateOKButton");
					selenium.switchOutOfFrame();
					selenium.waitingTime(5000);
					
				}*/
				selenium.switchOutOfFrame();				
				selenium.waitingTime(5000);			 
		 }		 
		 catch (Exception e) {
			 	selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating sample order " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
//	 @Then("^click on Oppurtunity record$")
//		public void click_on_Oppurtunity_record() {
//		 
//		 try {
////			selenium.waitingTime(5000);
///*selenium.search("Opportunity");
//selenium.waitingTime(3000);
//String Xpath = selenium.getDynamicXpath("opportunityResultsOnGlobalSearch", "Opportunity", "endContains");
//selenium.waitingTime(4000);
//System.out.println("xpath is"+Xpath);
//selenium.clickLoopXpath(Xpath);*/
//			selenium.waitingTime(5000);
//			selenium.navigateToURL(OppNavigation);
//            selenium.waitingTime(8000);
//			
//		}
//	 
//	 catch (Exception e) {
//			selenium.reportFailure("Error while clicking on opportunity record " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
//	 }
	 
	 @And("^click on new sample$")
	    public void click_on_new_sample() {
			
			try {
				if(selenium.getTestCaseName().equalsIgnoreCase("SEGUserSampleForOrderLinePilotUS") || selenium.getTestCaseName().equalsIgnoreCase("SEGSamplePrePopAccountProd") || selenium.getTestCaseName().equalsIgnoreCase("SEGUserSampleForOrderLineTypeFWOUS"))
				{
					selenium.navigateToURL(selenium.SampleTestingURL);
				}
				else
				{
					selenium.navigateToURL(selenium.NewOppURLForSamplesTest);	
				}

				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("newSampleFromOpportunity");
				selenium.click("newSampleFromOpportunity");
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("sampleContact"))
				{
					System.out.println("INSIDE IF");
					selenium.switchToFrame("sampleContact");
				}
				else
				{
					System.out.println("INSIDE ELSE");
					selenium.refresh();
					selenium.waitingTime(15000);
					selenium.takeScreenShot();
					selenium.switchToFrame("sampleContact");
				}
				selenium.waitingTime(2000);
			}
			catch (Exception e) {
				System.out.println("Inside click on new sample method catch");
				selenium.reportFailure("Error while clicking on new sample " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.switchOutOfFrame();
			}
		}
	 
	 
	 
	 @Then("^verify desired owner on new sample page$")
	    public void verify_desired_owner_on_new_sample_page() {
		 
		 try {
			 selenium.waitingTime(4000);
			 boolean heading1 = selenium.isElementPresentFast("sampleOpportunityHeading1");
			 selenium.waitingTime(2000);
			 System.out.println(heading1);
			 boolean heading2 =selenium.isElementPresentFast("sampleOpportunityHeading2");
			 selenium.waitingTime(2000);
			 System.out.println(heading2);
			 boolean account =selenium.isElementPresentFast("sampleOpportunityAccountName1");
//			 selenium.waitingTime(2000);
			 System.out.println(account);
			 selenium.waitForElementToBeVisible("sampleDesiredOwner1");
			 selenium.scrollToElement("sampleDesiredOwner1");
			 selenium.waitingTime(3000);
			 
			 if(heading1 == true & heading2 == true & account == true ) {
			 		selenium.test.log(LogStatus.PASS, "Details verified on order pad new sample page");
			 		System.out.println("PASS");
				}
			 else {
					selenium.test.log(LogStatus.FAIL, "Details not proper on order pad new sample page");
					System.out.println("FAIL");
					selenium.reportFailure("Test Case Failed");
					}
			 
			 	String owner = selenium.getText("sampleDesiredOwner1").toString();
			 	selenium.waitingTime(2000);
			 	String expected_owner = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("User");
			 	selenium.waitingTime(2000);
			 	System.out.println("Owner" + owner + "Expected Owner" + expected_owner );
			 	if(owner.equalsIgnoreCase(expected_owner)) {
			 		selenium.test.log(LogStatus.PASS, "Desired owner matching with Sales Rep");
			 		System.out.println("PASS - Desired owner matching with Sales Rep");
				} else {
					selenium.test.log(LogStatus.FAIL, "Desired owner not matching with Sales Rep");
					System.out.println("FAIL - Desired owner not matching with Sales Rep");
					selenium.reportFailure("Test Case Failed");
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 	
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while verifying desired owner" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
	 @Then("^verify sample for Copy$")
	    public void verify_sample_for_copy() {
		 
		 try {
			 	selenium.waitForElementToBeClickable("sampleOnContactJordan1");
			 	selenium.jsClick("sampleOnContactJordan1");
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
						selenium.jsClick("sampleRecordTable");	
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						System.out.println("FAIL - Sample creation failed");
						selenium.reportFailure("Test Case Failed");
					}
				}
			 	
			 	
			 	String status = selenium.getText("SFDCstatusAfterSampling").toString();
			 	String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SFDC Status");
			 	System.out.println("actual product" + status );
			 	System.out.println("expected product"  +expected_status );
			 	selenium.scrollToElement("addressInterfaceStatusField");
			 	String addressStatus = selenium.getText("addressInterfaceStatus").toString();
			 	String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Interface Status");
			 	System.out.println("actual address status" + addressStatus );
			 	System.out.println("expected address status"  +expected_address );
			 	if((status.equalsIgnoreCase(expected_status)) & (addressStatus.equalsIgnoreCase(expected_address))) {
			 		selenium.test.log(LogStatus.PASS, "Sample details Verified successfully");
			 		System.out.println("inside second pass");
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample details not proper");
					System.out.println("inside second fail");
					selenium.reportFailure("Test Case Failed");
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying details on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	
	
	 @And("^verify duplicate sample message$")
	    public void verify_duplicate_sample_message() {
		 
		 try {
				 selenium.waitForElementToBeClickable("createSampleOrder");
				 selenium.click("createSampleOrder");
				 selenium.waitingTime(90000);
				 
				 selenium.takeScreenShot();
				 selenium.waitingTime(2000);
				
				  if(selenium.waitForElementToBeVisible("duplicateSamplePopup")==true)
				  {
					  System.out.println("duplicate message");
					  selenium.test.log(LogStatus.PASS, "Duplicate Sample creation alert message displayed");
					  selenium.waitForElementToBeClickable("duplicateOKButton");
					  selenium.click("duplicateOKButton");
				  }
				  else
				  {
					  selenium.test.log(LogStatus.FAIL, "Duplicate sample creation alert not displayed");
					  selenium.reportFailure("Test Case Failed");
				  }
				  
					selenium.waitingTime(30000);				 
					selenium.switchOutOfFrame();				
					selenium.waitingTime(5000);			 
		 }
		 
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while verifying duplicate message" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	
	
	
	 @Then("^copy sample name$")
	    public void copy_sample_name() {
		 
		 try {
			 selenium.waitingTime(2000);
			 selenium.refresh();
			 selenium.waitingTime(8000);
			 selenium.captureScreenShot();
			 selenium.waitForElementToBeClickable("sampleOnContactJordan1");
			 	selenium.jsClick("sampleOnContactJordan1");
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
				
				calendar1.setTime(date);
				calendar1.add(Calendar.DATE, -1);
				Date dateBefore1Day = calendar1.getTime();
				SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
				String yesterdaysDate = sdf2.format(dateBefore1Day);
				System.out.println("yesterday/today date" + yesterdaysDate);

				if(recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
					System.out.println("inside date check");
					 title = selenium.getElement("sampleRecordTable").getAttribute("title");	
					System.out.println("title is"+ title);
					sampViewUrl = selenium.getURL();
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					System.out.println("sampViewUrl url is : "+ sampViewUrl);
					selenium.waitingTime(5000);
					String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
					selenium.navigateToURL(url);
					selenium.waitingTime(10000);
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
						sampViewUrl = selenium.getURL();
						selenium.captureScreenShot();
						selenium.waitingTime(2000);
						System.out.println("sampViewUrl url is (in else) : "+ sampViewUrl);
						selenium.waitingTime(5000);
						String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
						selenium.navigateToURL(url);
						selenium.waitingTime(10000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						selenium.reportFailure("Test Case Failed");
					}
				}
			 	
			 	
			 	
			 	selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			 	
		 }
		 
		 catch (Exception e) {
			
				selenium.reportFailure("Error while copying sample name" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }

	 @And("^select copied sample from search$")
	    public void select__copied_sample_from_search() {
		try {
			/*
			selenium.waitForElementToBeClickable("campaignFromDrpDwn");
			selenium.click("campaignFromDrpDwn");
			selenium.waitingTime(2000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "New Sample" , "end");
			selenium.scrollToXpathElement(nameXpath);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(2000);
			selenium.searchString(title);
			selenium.waitingTime(6000);

			 */
			System.out.println(sampViewUrl);
			selenium.navigateToURL(sampViewUrl);
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
		}

		catch (Exception e) {

			selenium.reportFailure("Error while searching sample " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	 @Then("^delete sample$")
	    public void delete_sample() {
		try {
			
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
//			String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			String recordDate = selenium.getText("lastModifiedDateRecordNew2");
			selenium.captureScreenShot();
			System.out.println("todays date"+todaysDate);
			System.out.println("record date"+recordDate);
			
			if(recordDate.contains(todaysDate)) {
				System.out.println("inside date check");
				selenium.scrollToElement("MoreActionBtn2");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("MoreActionBtn2");
				selenium.click("MoreActionBtn2");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("DeleteRecord");
				selenium.click("DeleteRecord");
//				 selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("deleteBtn");
				 selenium.click("deleteBtn");
				 selenium.waitingTime(9000);
				
				
				
			}
			else {
				System.out.println("clicking last modified date");
				selenium.jsClick("lastModifiedDate");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
//				String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
				if(recordDate1.contains(todaysDate)) {
					selenium.waitForElementToBeClickable("MoreActionBtn2");
					System.out.println("date matched");
					selenium.click("MoreActionBtn2");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("DeleteRecord");
					selenium.click("DeleteRecord");
//					 selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("deleteBtn");
					 selenium.click("deleteBtn");
					 selenium.waitingTime(9000);
					
				}
				else {
					selenium.test.log(LogStatus.INFO, "Sample not found to delete");
				}
			}
		 	
		 	
		 	
		 	selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deleting sample " + e.getMessage());
		}

	}
	 
}