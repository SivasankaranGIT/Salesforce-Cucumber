package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteCaseTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^I select and delete case$")
	public void i_select_and_delete_case() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			selenium.clickDynamicUsingAccName("anchorTitle", selenium.casenumber, "end");
			//selenium.click("firstcase");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			//selenium.clickLoop("Select_Case");
			//selenium.waitingTime(2000);
			//selenium.clickLoop("DeleteRecord");
			//selenium.waitingTime(2000);
			//selenium.click("DeleteButton");
			selenium.click("DeleteActionBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deletePopupBtn");
			selenium.click("deletePopupBtn");

		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CaseNum_C");
			selenium.click("CaseNum_C");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("delete");
			selenium.click("delete");
			selenium.acceptAlert();

		}
		}
		catch (Exception e) {
		e.printStackTrace();
		selenium.reportFailure("Test Case Failed");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@Then("^user clicks the delete button$")
	public void user_clicks_the_delete_button() {
		try {
		//selenium.test.log(LogStatus.INFO, "Checking for the presence of delete button");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("moreActionsBtn");
		selenium.click("moreActionsBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deleteBtn");
		selenium.click("deleteBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deletePopupBtn");
		selenium.click("deletePopupBtn");
		flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
	@Then("^I validate the account delete success message$")
	public void account_address_creation_should_be_successful() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^user should click on the Delete button$")
	public void user_should__be_able_to_click_the_delete_button() {
		try {
		selenium.test.log(LogStatus.INFO, "Checking for the presence of delete button");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("DeleteActionBtn");
		selenium.click("DeleteActionBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deletePopupBtn");
		selenium.click("deletePopupBtn");
		flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}

	@Then("^I validate the delete success message$")
	public void i_validate_the_delete_success_message() {
		try {
		boolean success = false;
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			success = selenium.isElementPresentFast("contactSuccessfulL");

		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			success = selenium.isElementPresentFast("CaseNum_C");
			if (success)
				selenium.test.log(LogStatus.INFO, "successfully executed");
		}

		selenium.printLastTestResult(success);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

}
