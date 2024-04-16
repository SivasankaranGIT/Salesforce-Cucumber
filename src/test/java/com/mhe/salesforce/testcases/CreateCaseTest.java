package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCaseTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@When("^I navigated to cases home page$")
	public void i_navigated_to_cases_home_page() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(2000);
			selenium.type("searchallitems", "cases");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("casesTab");
			selenium.click("casesTab");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.click("NewButtonToAdd");
			String recordType = selenium.getDynamicXpath("spantextContains", "Record Type", "endContains");
//			selenium.waitForXpathElementToBeClickable(recordType);
			selenium.waitingTime(4000);
			selenium.clickXpath(recordType);
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			selenium.test.log(LogStatus.INFO, "Navigated successfully to New Case Page!");

		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.scrollToElement("casesClassic");
			selenium.waitForElementToBeClickable("casesClassic");
			selenium.click("casesClassic");
			selenium.waitForElementToBeClickable("newButton_C");
			selenium.click("newButton_C");
			selenium.selectDropdownText("departmentAddressC", "Record Type");

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^I fill up all the mandatory details for case$")
	public void i_fill_up_all_the_mandatory_details_for_case() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.test.log(LogStatus.INFO, "selecting the value for case origin!");
			selenium.waitForElementToBeClickable("caseOrigin");
			selenium.click("caseOrigin");
			String CaseOrigin = selenium.getDynamicXpath("anchorTitle", "Case Origin", "end");
			selenium.clickXpath(CaseOrigin);
			
			selenium.type("Search_contact", "Contact Name");
			selenium.clickDynamic("contactAccountDynamic", "Name", "end");
			selenium.waitForElementToBeClickable("contactType");
			selenium.click("contactType");
			//selenium.waitingTime(2000);
			selenium.clickDynamic("anchorTitle", "Contact Type", "end");
			
			selenium.scrollToElement("subjectTxtField");
			selenium.type("subjectTxtField", "Subject");
			selenium.type("descriptionTxtField", "SimpleTextBox");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			selenium.waitingTime(2000);
			
			flagsuccess=selenium.isElementPresentFast("cassenumber");
			selenium.casenumber=selenium.getText("cassenumber");

		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("continue");
			selenium.click("continue");
			selenium.selectDropdownText("caseOrigin_C", "Case Origin");

		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^I validate the success message$")
	public void i_validate_the_success_message() {
		try {
		boolean success = false;
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			///success = selenium.isElementPresentFast("contactSuccessfulL");
			//selenium.casenumber=selenium.getText("cassenumber");
			selenium.printLastTestResult(flagsuccess);
		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			success = selenium.isElementPresentFast("caseno");
			if (success)
				selenium.test.log(LogStatus.INFO, "Case No:" + selenium.getText("caseno"));
			selenium.test.log(LogStatus.INFO, "successfully Case Created");
			selenium.printLastTestResult(success);
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

		//selenium.printLastTestResult(success);
	}
}
