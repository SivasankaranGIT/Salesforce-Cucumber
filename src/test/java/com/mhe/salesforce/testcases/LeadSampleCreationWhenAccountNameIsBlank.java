package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadSampleCreationWhenAccountNameIsBlank {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^click on the Campaign name$")
	public void click_on_the_campaign_name() {
		try {
		selenium.search("Campaign Name");
		selenium.waitingTime(4000);
		String Xpath = selenium.getDynamicXpath("anchorTitle", "Campaign Name", "end");
		selenium.waitingTime(3000);
//		selenium.waitForXpathElementToBeClickable(Xpath);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
		selenium.test.log(LogStatus.INFO, "Clicked on Campaign" );
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
	}
	
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking Campaign " + e.getMessage());
			}

	}
	
	@Then("^click on Lead URL$")
	public void click_on_Lead_URL() {
		try {
		selenium.waitForElementToBeClickable("leadURL");
		selenium.click("leadURL");
		selenium.switchToChildWindow();
		selenium.waitingTime(5000);
		
	}
	
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking lead SEG Url" + e.getMessage());
			}

	}
	
	@Then("^I enter manadatory details$")
	public void I_enter_manadatory_details() {
		try {
		selenium.waitForElementToBeClickable("clickHereLink");
		selenium.click("clickHereLink");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleAddressField");
		selenium.click("sampleAddressField");
		selenium.type("sampleAddressField", "Address");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleCity");
		selenium.click("sampleCity");
		selenium.type("sampleCity", "City");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleZipcode");
		selenium.click("sampleZipcode");
		selenium.type("sampleZipcode", "Zipcode");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleProvinceCode");
		selenium.click("sampleProvinceCode");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("sampleProvinceCode", "State/Province code");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleFirstName");
		selenium.click("sampleFirstName");
		selenium.type("sampleFirstName", "First Name");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleLastName");
		selenium.click("sampleLastName");
		selenium.type("sampleLastName", "Last Name");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleJobTitle");
		selenium.click("sampleJobTitle");
		selenium.type("sampleJobTitle", "Job Title");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleEmail");
		selenium.click("sampleEmail");
		selenium.type("sampleEmail", "Email");
		selenium.click("sampleResponse");
		selenium.waitingTime(2000);
		selenium.selectDropdownText("sampleResponse", "Sample Response");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Submit_Button");
		selenium.click("Submit_Button");
		selenium.waitingTime(5000);
		
		
		
		
	}
	
	
		 catch (Exception e) {
			 	selenium.switchBackToParentWindow();
				selenium.reportFailure("Error whilefilling mandatory details " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	
	
	@And("^I close the SEG site$")
	public void I_close_the_SEG_site() {
		try {
			System.out.println("I am in 'I close the SEG site' method");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
//		selenium.isElementPresentFast("MessageText");
//		selenium.waitingTime(2000);
//		boolean successMessage = selenium.isTextPresent("MessageText", "Success message");
//		if (successMessage == true)
//		{
//			System.out.println("Sample created successfully");
//			selenium.test.log(LogStatus.INFO, "Sample created successfully" );
//		}
////		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("sampleCloseSEG");
//		selenium.click("sampleCloseSEG");
			selenium.close();
		selenium.waitingTime(4000);
	}
	
	
		 catch (Exception e) {
			 	System.out.println("Inside 'I close the SEG site' catch block");
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking Campaign " + e.getMessage());
			}

	}	
	
	@Then("^verify lead record on campaign members section$")
    public void verify_lead_record_on_campaign_members_section() {
		try {
			selenium.switchBackToParentWindow();
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("campaignMembersSection");
			selenium.jsClick("campaignMembersSection");
			selenium.waitingTime(5000);
			
			 Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
				String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				if(recordDate.contains(todaysDate)) {
					System.out.println("inside date check");
					selenium.assertMessage("campaignMemberType", "Campaign Member Type");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("campaignFirstName");
					selenium.assertMessage("campaignFirstName", "First Name");
					selenium.waitingTime(5000);
				}
				else {
					System.out.println("clicking last modified date");
					selenium.waitForElementToBeClickable("lastModifiedDate");
					selenium.jsClick("lastModifiedDate");
					selenium.waitingTime(3000);
					String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					if(recordDate1.contains(todaysDate)) {
						System.out.println("date matched");
						selenium.assertMessage("campaignMemberType", "Campaign Member Type");
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeVisible("campaignFirstName");
						selenium.assertMessage("campaignFirstName", "First Name");
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Lead creation failed ");
						selenium.reportFailure("Test Case Failed");
					}
				}
			
			
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			 selenium.test.log(LogStatus.PASS, "Lead Created for Sample successfully" );
			
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying lead record " + e.getMessage());
			}
	}
	
	@And("^Select Campaign$")
	public void select_campaign() {
		try {
			selenium.waitForElementToBeClickable("campaignFromDrpDwn");
			selenium.click("campaignFromDrpDwn");
			selenium.waitingTime(2000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "New Campaign", "end");
			selenium.waitingTime(2000);
			selenium.scrollToXpathElement(nameXpath);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(2000);
			selenium.searchGlobal("Campaign Name");
			selenium.waitingTime(6000);
			String Xpath = selenium.getDynamicXpath("anchorTitle", "Campaign Name", "end");
			selenium.waitingTime(3000);
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.test.log(LogStatus.INFO, "Clicked on Campaign");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking Campaign " + e.getMessage());
		}

	}

}
