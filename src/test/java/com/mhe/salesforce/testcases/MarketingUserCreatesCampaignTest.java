package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingUserCreatesCampaignTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create campaign by filling mandatory fields$")
	public void create_campaign_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(4000);
				//selenium.type("campaignName", "Campaign Name");
				String campaignName = selenium.getRandomString();
				selenium.waitForElementToBeVisible("campaignName");
				selenium.getElement("campaignName").sendKeys(campaignName);
				selenium.waitingTime(2000);
				
				selenium.type("search_People", "Campaign Requestor");
				selenium.clickDynamic("contactAccountDynamic", "Name", "end");
				selenium.waitForElementToBeClickable("campaignBusinessUnit");
				selenium.click("campaignBusinessUnit");
				selenium.clickDynamic("anchorTitle", "Campaign Business Unit", "end");
				selenium.waitForElementToBeClickable("maSyncFlagChkBox");
				selenium.click("maSyncFlagChkBox");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.waitingTime(4000);
				selenium.campaign=selenium.getURL();

			}

		} catch (Exception e) {
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
				selenium.click("CancelButton");
			}

		}

	}

	@And("^I edit campaign details$")
	public void I_edit_campaign_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				/*selenium.search("Campaign Name");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Campaign Name", "endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);*/
				
				selenium.navigateToURL(selenium.campaign);
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("EditButton");
				selenium.jsClick("EditButton");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("campaignObjective");
				selenium.type("campaignObjective", "Campaign Objective");
				selenium.scrollToElement("descriptionTxtField");
//				selenium.type("descriptionTxtField", "SimpleTextBox");
				selenium.typeData("descriptionTxtField","Higher Education");
				selenium.scrollToElement("campaignStartDate");
				selenium.type("campaignStartDate", "Start Date");
				selenium.scrollToElement("campaignEndDate");
				selenium.type("campaignEndDate", "End Date");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			}

		} catch (Exception e) {
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
				selenium.click("CancelButton");
			}

		}

	}

	@Then("^I validate the Marketing user create campaign success message$")
	public void validate_the_CXG_contact_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}
	
	@When("^Navigate to Campaigns page$")
	public void navigate_to_products_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("campaignOption");
		selenium.click("campaignOption");
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "Campaigns screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

}
