package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SampleContactFromSEGSite {
	WebConnector selenium = WebConnector.getInstance();
	String campaignURL;
//	public String SEGSiteForURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Campaign/7010y000001c5inAAA/view";

	@Then("^click on SEG Site URL$")
	public void click_on_SEG_Site_URL() {
		try {
			
			campaignURL = selenium.getURL();
			if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleTitleinSEGSite"))
			{
				selenium.navigateToURL(selenium.newCampaignURL);
			}
			selenium.waitingTime(18000);
        	selenium.waitForElementToBeClickable("SEGSitesURL");
			selenium.click("SEGSitesURL");
			selenium.waitingTime(5000);
        	selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.switchToChildWindow();
			selenium.waitingTime(5000);
        	selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.maximizeBrowserWindow();

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking SEG Url" + e.getMessage());
		 	selenium.close();
		 	selenium.switchBackToParentWindow();
		 	selenium.waitingTime(5000);
		}

	}

	@Then("^I enter the details$")
	public void I_enter_the_details() {
		try {

		//selenium.click("sampleSchool");
		//	selenium.type("sampleSchool", "School");
//			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleProvince2");
			selenium.click("sampleProvince2");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("sampleProvince2", "State/Province code");
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.scrolldown(100);
        	selenium.waitForElementToBeClickable("sampleSchoolCode3");
			selenium.click("sampleSchoolCode3");
			selenium.type("sampleSchoolCode3", "Zipcode");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleLocateMySchool");
			selenium.click("sampleLocateMySchool");
//			selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("sampleSchoolRadioButton");
			selenium.click("sampleSchoolRadioButton");
//			selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("sampleFirstName2");
			selenium.click("sampleFirstName2");
			selenium.type("sampleFirstName2", "First Name");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleLastName2");
			selenium.click("sampleLastName2");
			selenium.type("sampleLastName2", "Last Name");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleJobTitle3");
			selenium.click("sampleJobTitle3");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("sampleJobTitle3", "Job Title");
//			selenium.type("sampleJobTitle", "Job Title");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleEmail2");
			selenium.click("sampleEmail2");
			selenium.type("sampleEmail2", "Email");
//			selenium.waitingTime(2000);
//			selenium.click("sampleRepContactMeCheckBox");
//			selenium.waitingTime(2000);
//			selenium.click("sampleResponse");
//			selenium.waitingTime(2000);
//			selenium.selectDropdownText("sampleResponse", "Sample Response");
			selenium.waitingTime(2000);
			selenium.scrolldown(50);
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("Submit_Button");
			selenium.click("Submit_Button");
			selenium.waitingTime(20000);

		}

		catch (Exception e) {
			System.out.println("Inside 'I enter the details' catch block");
//			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error whilefilling mandatory details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^I enter the details for user doesnot exist$")
	public void I_enter_the_details_for_user_doesnot_exist() {
		try {
        	selenium.waitForElementToBeClickable("sampleProvince2");
			selenium.click("sampleProvince2");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("sampleProvince2", "State/Province code");
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.scrolldown(100);
        	selenium.waitForElementToBeClickable("sampleSchoolCode3");
			selenium.click("sampleSchoolCode3");
			selenium.type("sampleSchoolCode3", "Zipcode");
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleLocateMySchool");
			selenium.click("sampleLocateMySchool");
			selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("sampleSchoolRadioButton");
			selenium.click("sampleSchoolRadioButton");
			selenium.waitingTime(4000);
			selenium.scrollToElement("sampleFirstName2");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleFirstName2");
			selenium.click("sampleFirstName2");
			selenium.type("sampleFirstName2", "First Name");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleLastName2");
			selenium.click("sampleLastName2");
			selenium.type("sampleLastName2", "Last Name");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleJobTitle3");
			selenium.click("sampleJobTitle3");
			selenium.selectDropdownText("sampleJobTitle3", "Job Title");
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("sampleEmail2");
			selenium.click("sampleEmail2");
			selenium.type("sampleEmail2", "Email");
//			selenium.waitingTime(2000);
//			selenium.click("sampleRepContactMeCheckBox");
//			selenium.waitingTime(2000);
//			selenium.click("sampleResponse");
//			selenium.waitingTime(2000);
//			selenium.selectDropdownText("sampleResponse", "Sample Response");
			selenium.waitingTime(2000);
			selenium.scrolldown(50);
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("Submit_Button");
			selenium.click("Submit_Button");
			selenium.waitingTime(20000);

		}

		catch (Exception e) {
			System.out.println("Inside 'I enter the details for user doesnot exist' catch block");
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error whilefilling mandatory details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^verify contact record on campaign members section for existing user$")
	public void verify_contact_record_on_campaign_members_section_for_existing_user() {
		try {
			selenium.switchBackToParentWindow();
			 selenium.waitingTime(4000);
			 selenium.navigateToURL(campaignURL);
			 selenium.waitingTime(8000);
			 selenium.waitForElementToBeClickable("campaignMembersSection");
			selenium.jsClick("campaignMembersSection");
			selenium.waitingTime(15000);
			//String Firstname = selenium.getElement("campaignFirstName").getText();
			selenium.refresh();
//			selenium.waitingTime(8000);
        	selenium.waitForElementToBeVisible("campaignFirstName_new");
			String Firstname = selenium.getElement("campaignFirstName_new").getText();
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
			System.out.println("record name is" + Firstname);

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			
			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);			
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			
			String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);
			
			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				System.out.println("inside date check");
				if (Firstname.equalsIgnoreCase(expected_name)) {
					selenium.test.log(LogStatus.INFO, "contact created successfully");
					System.out.println("contact created successfully1");
				} else {
					System.out.println("inside else check");
		        	selenium.waitForElementToBeClickable("lastModifiedDate");
					selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
		        	selenium.waitForElementToBeClickable("lastModifiedDate");
					selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
		        	selenium.waitForElementToBeVisible("lastModifiedDateRecord");
					String recordDateafter = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					System.out.println("record date" + recordDateafter);
					if ((recordDateafter.contains(todaysDate) || recordDateafter.contains(yesterdaysDate)) & (Firstname.equalsIgnoreCase(expected_name))) {
						System.out.println("after chcek");
						selenium.test.log(LogStatus.INFO, "contact created successfully");
					}
				}
			}

			else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastModifiedDate");
				selenium.jsClick("lastModifiedDate");
//				selenium.waitingTime(3000);
//				selenium.jsClick("lastModifiedDate");
//				selenium.waitingTime(3000);
	        	selenium.waitForElementToBeVisible("lastModifiedDateRecord");
				String recordDate1 = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				System.out.println("record date" + recordDate1);
				if ((recordDate1.contains(todaysDate)|| recordDate1.contains(yesterdaysDate)) & (Firstname.equalsIgnoreCase(expected_name))) {
					System.out.println("after chcek");
					selenium.test.log(LogStatus.INFO, "contact created successfully");
				}

				else {
					selenium.test.log(LogStatus.INFO, "contact creation failed ");
					System.out.println("contact creation failed");
				}
			}

			selenium.captureScreenShot();
			selenium.waitingTime(5000);

		} catch (Exception e) {

			selenium.reportFailure("Error while verifying contact record " + e.getMessage());
			System.out.println("Error while verifying contact record");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^verify contact record on campaign members section$")
	public void verify_contact_record_on_campaign_members_sectionr() {
		try {
			selenium.switchBackToParentWindow();
//			selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("campaignMembersSection");
			selenium.jsClick("campaignMembersSection");
			selenium.waitingTime(5000);
			selenium.refresh();
//			selenium.waitingTime(8000);
        	selenium.waitForElementToBeVisible("campaignFirstName_new");
			String Firstname = selenium.getElement("campaignFirstName_new").getText();
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
			System.out.println("record name is" + Firstname);

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);

			String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate)|| recordDate.contains(yesterdaysDate)) {
				System.out.println("inside date check");
				if (Firstname.equalsIgnoreCase(expected_name)) {
					selenium.test.log(LogStatus.INFO, "contact created successfully");
				} else {
					System.out.println("inside else check");
					selenium.waitForElementToBeClickable("lastModifiedDate");
					selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
//					selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
		        	selenium.waitForElementToBeVisible("lastModifiedDateRecord");
					String recordDateafter = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					System.out.println("record date" + recordDateafter);
					if ((recordDateafter.contains(todaysDate)|| recordDateafter.contains(yesterdaysDate)) & (Firstname.equalsIgnoreCase(expected_name))) {
						System.out.println("after chcek");
						selenium.test.log(LogStatus.INFO, "contact created successfully");
					}
				}
			}

			else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastModifiedDate");
				selenium.jsClick("lastModifiedDate");
//				selenium.waitingTime(3000);
//				selenium.jsClick("lastModifiedDate");
//				selenium.waitingTime(3000);
	        	selenium.waitForElementToBeVisible("lastModifiedDateRecord");
				String recordDate1 = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				System.out.println("record date" + recordDate1);
				if ((recordDate1.contains(todaysDate)|| recordDate1.contains(yesterdaysDate)) & (Firstname.equalsIgnoreCase(expected_name))) {
					System.out.println("after chcek");
					selenium.test.log(LogStatus.INFO, "contact created successfully");
				}

				else {
					selenium.test.log(LogStatus.INFO, "contact creation failed ");
				}
			}

			selenium.captureScreenShot();
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying contact record " + e.getMessage());
		}
	}

	@And("^verify navigation on clicking first name and contact$")
	public void verify_navigation_on_clicking_first_name_and_contact() {
		try {
//			selenium.waitingTime(10000);
        	selenium.waitForElementToBeClickable("campaignFirstName_new");
			selenium.click("campaignFirstName_new");
//			selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("namePageTitle");
			String pagetitle = selenium.getElement("namePageTitle").getText();
			if (pagetitle.equalsIgnoreCase("Campaign Member")) {
				selenium.test.log(LogStatus.PASS, "navigated to campaign memeber page");
				System.out.println("PASS - navigated to campaign memeber page");
			}
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);

			selenium.navigateBack();
			selenium.waitingTime(3000);
        	selenium.waitForElementToBeClickable("campaignMemeberContactRecord");
			selenium.click("campaignMemeberContactRecord");
			selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("contactPageTitle");
			String pagetitle1 = selenium.getElement("contactPageTitle").getText();
			if (pagetitle1.equalsIgnoreCase("Contact")) {
				selenium.test.log(LogStatus.PASS, "navigated to contact page");
				System.out.println("PASS");
			}

			selenium.captureScreenShot();
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying navigation" + e.getMessage());
		}
	}

	@Then("^verify sample on contact record$")
	public void verify_sample_on_contact_record() {
		try {
			
			selenium.waitingTime(5000);

			if(selenium.isElementPresentFast("contactSampleSection2"))
			{
				selenium.waitForElementToBeClickable("contactSampleSection2");
				selenium.click("contactSampleSection2");				
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("contactSampleSection2");
				selenium.click("contactSampleSection2");				
			}

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
			selenium.waitingTime(60000);
			selenium.waitForElementToBeVisible("lastModifiedDateRecord");
			String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate) ) {
				System.out.println("inside date check");
				String record = selenium.getDynamicXpath("opportunityNameContains", "First Name", "sampleVerification");
				System.out.println("record" + record);

				if (!record.isEmpty()) {
					selenium.test.log(LogStatus.PASS, "Sample created successfully");
					System.out.println("inside sample record");
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample not present");
					System.out.println("outside sample record");
					selenium.reportFailure("Sample not present");

				}
				selenium.waitingTime(5000);
			} else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastCreatedDateRecord");
				selenium.jsClick("lastCreatedDateRecord");
				selenium.waitingTime(3000);
//				selenium.jsClick("lastCreatedDateRecord");
//				selenium.waitingTime(3000);
				String recordDate1 = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				if (recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
					System.out.println("date matched");
					String record = selenium.getDynamicXpath("opportunityNameContains", "First Name",
							"sampleVerification");
					System.out.println("record" + record);

					if (!record.isEmpty()) {
						selenium.test.log(LogStatus.PASS, "Sample created successfully");
						System.out.println("inside sample record");
					} else {
						selenium.test.log(LogStatus.FAIL, "Sample not present");
						System.out.println("outside sample record");
						selenium.reportFailure("Sample not present");

					}
					selenium.waitingTime(5000);
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
					selenium.reportFailure("Sample creation failed ");
				}
			}

			selenium.captureScreenShot();
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying sample" + e.getMessage());
		}
	}

	@And("^verify the job function field value$")
	public void verify_the_job_function_field_value() {
		try {
			selenium.waitingTime(5000);
			String contactJobFunction = selenium.getText("ContactJobFunctionValue").toString();
			String expected_contactJobFunction = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Job Function");
			System.out.println("Actual : " + contactJobFunction + "Expected : " + expected_contactJobFunction);
			if (contactJobFunction.equalsIgnoreCase(expected_contactJobFunction))
				{
					selenium.test.log(LogStatus.PASS, "Successfully verified job function value!");
					System.out.println("PASS");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
			else
				{
					selenium.reportFailure("Job Function value verification unsuccessful!");
					selenium.test.log(LogStatus.FAIL, "Job Function value verification unsuccessful!");
				}


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying job function field in contact");
			selenium.reportFailure("Error while verifying job function field in contact" + e.getMessage());
		}
	}

	@And("^verify object history link$")
	public void verify_object_history_link() {
		try {
			selenium.waitingTime(2000);
			//Checking Opportunity Object
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001IPp9gAAD/view");
			selenium.waitingTime(5000);
			selenium.checkObjectHistory();
			//Checking Account Object
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0011A00001TrqBhQAJ/view");
			selenium.waitingTime(5000);
			selenium.checkObjectHistory();
			//Checking Contact Object
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002ajFYWAA2/view");
			selenium.waitingTime(5000);
			selenium.checkObjectHistory();
			//Checking Sample Object
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v0y00000X5PsLAAV/view");
			selenium.waitingTime(5000);
			selenium.checkObjectHistory();

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying object histroy link");
			selenium.reportFailure("Error while verifying object histroy link" + e.getMessage());
		}
	}

	@And("^verify sample title$")
	public void verify_sample_title()
	{
		try
		{
			selenium.waitForElementsToBeVisible("SampleTitle");
			selenium.scrollToElement("SampleTitle");
			String actual_title = selenium.getText("SampleTitle").toString();
			System.out.println("Actual Title is : " + actual_title);
		 	String expected_title = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Sample Title");
		 	System.out.println("Expected Title is : "  + expected_title);

		 	if(expected_title.equalsIgnoreCase(actual_title))
			 	{
			 		selenium.test.log(LogStatus.PASS, "Sample title verified successfully.");
			 		System.out.println("PASS");
			 		selenium.scrollToElement("SampleTitleHeader");
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
		 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Sample title is not proper");
					selenium.reportFailure("Sample title is not proper");
					System.out.println("FAIL");
			 		selenium.scrollToElement("SampleTitleHeader");
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
		 	selenium.close();
		 	selenium.switchBackToParentWindow();
		 	selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying the sample title");
			selenium.reportFailure("Error while verifying the sample title" + e.getMessage());
		 	selenium.close();
		 	selenium.switchBackToParentWindow();
		 	selenium.waitingTime(5000);
		}

	}
}
