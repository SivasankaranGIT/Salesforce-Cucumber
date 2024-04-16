package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingUserAddingLeadToCampaign {
	public String campaignname;
	
//  public String lead="https://mh--uat.sandbox.lightning.force.com/lightning/r/Lead/00Q5500000Ck9u3EAB/view";
//    public String lead="https://mh--uat.sandbox.lightning.force.com/lightning/r/Lead/00Q0y00001sW1ICEA0/view";
	WebConnector selenium = WebConnector.getInstance();
	@When("^I navigate to Leads tab$")
	public void I_navigate_to_Leads_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Lead");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("leadOptionsMenuDots");
		selenium.jsClick("leadOptionsMenuDots");
		selenium.waitingTime(5000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to Leads tab " + e.getMessage());
			}

	}
		
	
	
//	@And("^click on Lead name$")
//	public void click_on_Lead_name() {
//		try {
//			/*selenium.click("campaignFromDrpDwn");
//			selenium.waitingTime(2000);
//			selenium.scrollToElement("leadfromDropdown");
//			selenium.click("leadfromDropdown");
//			selenium.waitingTime(2000);*/
//			//selenium.searchGlobal("Lead Name");
//			/*selenium.waitingTime(6000);
//			// String Xpath = selenium.getDynamicXpath("Leadsresults", "Lead Name", "end");
//			String Xpath = selenium.getDynamicXpath("anchorTitle", "Lead Name", "end");
//			selenium.clickLoopXpath(Xpath);
//			selenium.test.log(LogStatus.INFO, "Clicked on Lead");
//			selenium.waitingTime(5000);
//			selenium.captureScreenShot();*/
//			selenium.navigateToURL(lead);
//			selenium.waitingTime(2000);
//		}
//
//		catch (Exception e) {
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			selenium.reportFailure("Error while clicking Lead " + e.getMessage());
//		}
//
//	}
	
	
	@When("^I navigate to Campaignhistory section to click on Add to campaign button$")
	public void I_navigate_to_Campaignhistory_section_to_click_on_Add_to_campaign_button() throws InterruptedException {
		
		try{
			selenium.waitingTime(5000);
			selenium.navigateToURL(selenium.LeadURl);
			System.out.println("Navigated to Lead URL is : " + selenium.LeadURl);
			selenium.waitForElementToBeClickable("campaignHistoryOnLeadPage");
			selenium.jsClick("campaignHistoryOnLeadPage");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addtocampaignnew");
			selenium.clickLoop("addtocampaignnew");
			selenium.waitingTime(5000);
		
	}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking add to campaign " + e.getMessage());
			}

	}
	
	@Then("^I select Campaign$")
	public void I_select_Campaign() {
		try {
		selenium.waitForElementToBeClickable("searchCampaign");
		selenium.autoSuggestiveDropdown("searchCampaign", "Campaign");
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		System.out.println("clicking next");
		selenium.waitForElementToBeClickable("campaignNextnew1");
			selenium.clickLoop("campaignNextnew1");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
		}
			
		catch (Exception e) {
			
//				selenium.click("cancelButtonOnAddingCampaignToLead");
				selenium.reportFailure("Error while selecting campaign " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	@And("^verify fields on Campaign page$")
	public void verify_fields_on_Campaign_page() {
		try {
		
		selenium.waitingTime(2000);
		selenium.isElementPresentFast("campaignField");
		selenium.isElementPresentFast("statusField");
		selenium.test.log(LogStatus.INFO, "Fields are present");
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("saveOnCampaignPopUp");
		selenium.jsClick("saveOnCampaignPopUp");
		selenium.waitingTime(20000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("alreadyCampaignMemeberError")) {
			System.out.println("clicking cancel for already campaign member");
			selenium.clickLoop("CancelButton_Span");
			System.out.println("clicked cancel");
			selenium.test.log(LogStatus.INFO, "Already campaign member" );
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("addtocampaignnew");
			selenium.clickLoop("addtocampaignnew");
//			selenium.waitingTime(5000);
//			selenium.captureScreenShot();
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("addNewCampaignOption");
			selenium.scrollToElement("addNewCampaignOption");
//			selenium.waitingTime(5000);
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addNewCampaignOption");
			selenium.jsClick("addNewCampaignOption");
//			selenium.waitingTime(8000);
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextPageButton");
			selenium.jsClick("NextPageButton");
//			selenium.waitingTime(5000);
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		 campaignname= selenium.getRandomString();
//		 selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("campaignNameToCreateNewCampaign2");
	        selenium.getElement("campaignNameToCreateNewCampaign2").sendKeys(campaignname);
//	        selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("campaignBusinessUnit");
	        selenium.clickLoop("campaignBusinessUnit");
//	        selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("campaignBusinessUnitOption");
	        selenium.click("campaignBusinessUnitOption");
//	        selenium.waitingTime(2000);
//	        selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
	        selenium.clickLoop("SaveBtnNew1");
	        selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("campaignNextnew1");
	        selenium.clickLoop("campaignNextnew1");
	        selenium.waitingTime(5000);
	        verify_fields_on_Campaign_page();
	        
		}
	if(selenium.isElementPresentFast("ErrorMsg")) {
		selenium.clickLoop("CancelButton_Span");
		selenium.test.log(LogStatus.FAIL, "Error adding lead to campaign" );
		selenium.reportFailure("Test Case Failed");
		selenium.waitingTime(3000);
	}
	else
		selenium.test.log(LogStatus.PASS, "Lead added to Campaign successfully" );
		
	}
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying campaign details " + e.getMessage());
			}

	}
	
	@Then("^click on Campaign Name$")
	public void click_on_campaign_Name() {
		try {
			selenium.waitingTime(5000);
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date"+todaysDate);
			System.out.println("record date"+recordDate);
			
			if(recordDate.contains(todaysDate)) {
				System.out.println("inside date check");
				String Xpath = selenium.getDynamicAccountXpath("anchorTitle", campaignname, "end");
				System.out.println("Xpath" +Xpath);
				if(selenium.isElementPresentXpathFast(Xpath)) {
					System.out.println("inside date check if");
//					selenium.waitForXpathElementToBeClickable(Xpath);
					selenium.waitingTime(5000);
					selenium.clickLoopXpath(Xpath);
					selenium.waitingTime(5000);
				}
				else {	
					System.out.println("inside date check else");
					selenium.waitForElementToBeClickable("RecentlyAddedRecord");
				selenium.jsClick("RecentlyAddedRecord");	
				selenium.waitingTime(5000);
				}
			}
			else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("memberStatusUpdatedDate");
				selenium.clickLoop("memberStatusUpdatedDate");
				selenium.waitingTime(3000);
				String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				if(recordDate1.contains(todaysDate)) {
					System.out.println("date matched");
					String Xpath = selenium.getDynamicAccountXpath("anchorTitle", campaignname, "end");
					System.out.println("Xpath" +Xpath);
					selenium.waitingTime(4000);
					if(selenium.isElementPresentXpathFast(Xpath)) {
//						selenium.waitForXpathElementToBeClickable(Xpath);
						selenium.waitingTime(5000);
						selenium.clickLoopXpath(Xpath);
						selenium.waitingTime(5000);
					}
					else {	
						System.out.println("inside date matched else");
						selenium.waitForElementToBeClickable("RecentlyAddedRecord");
					selenium.jsClick("RecentlyAddedRecord");	
					selenium.waitingTime(5000);
					}
				}
				else {
					selenium.test.log(LogStatus.INFO, "Campaign record not present");
				}
			}
		
	}
	
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking on campaign " + e.getMessage());
			}

	}
	
	@And("^verify contact details in Campaign History section$")
	public void verify_contact_details_in_Campaign_History_section() {
		try {
			selenium.waitForElementToBeClickable("campaignMembersSection");
//			selenium.waitingTime(5000);	
//			selenium.waitForElementToBeVisible("campaignMembersSection");
			selenium.jsClick("campaignMembersSection");
			selenium.waitingTime(5000);	
			
			if(selenium.getElement("campaignMembersrecordCheck").isDisplayed()) {
				System.out.println("Inside pass");
				selenium.test.log(LogStatus.PASS, "Lead  record present");
			}
							
			
			selenium.waitingTime(3000);
			selenium.captureScreenShot();
			
		
//		selenium.jsClick("campaignMembersSection");
//		selenium.waitingTime(3000);	
//		selenium.assertMessage("verifyLeadonCampaignMembersSection", "Lead Name");
//		selenium.waitingTime(3000);
//		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
	}
	
	
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying Lead name on campaign " + e.getMessage());
			}

	}
	
	@Then("^click on created Campaign Name$")
	public void click_on_created_campaign_Name() {
		String CampaignName = selenium.getValueByColumnName("Campaign");
		try {
			selenium.waitForElementToBeClickable("objectFilterBtn");
			selenium.jsClick("objectFilterBtn");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			if (campaignname != null && !campaignname.isEmpty())
			{
				selenium.getElement("campaignNameFilter").sendKeys(campaignname);
				System.out.println("Filtered Campaign Name is: "+ campaignname);
			}
			else
			{
				selenium.getElement("campaignNameFilter").sendKeys(CampaignName);
				System.out.println("Filtered Campaign Name is: "+ CampaignName);
			}
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("closeFilterBtn");
			selenium.jsClick("closeFilterBtn");
			selenium.waitingTime(2000);

			if (campaignname != null && !campaignname.isEmpty())
			{
				String Xpath1 = selenium.getDynamicXpathProperty("anchorTitlecontains", campaignname, "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath1);
				System.out.println("Xpath1" + Xpath1);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath1);
			}
			else
			{
				String Xpath2 = selenium.getDynamicXpathProperty("anchorTitlecontains", CampaignName, "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath2);
				System.out.println("Xpath2" + Xpath2);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath2);
			}
			selenium.waitingTime(8000);
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking on campaign " + e.getMessage());
		}

	}
	
	

	}

