package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class deleteAccountAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	 @And("^I Delete the Account address$")
	    public void i_delete_the_account_address() {
		selenium.test.log(LogStatus.INFO, "Deleting the Account address");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamicL", "Street1",
					"endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
//			selenium.click("DeleteActionBtn");
//			selenium.waitingTime(2000);
//			selenium.click("deleteBtn");
			selenium.click("DeleteActionBtn");
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressAccDynamic_C", "Street1",
					"end");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("delete");
			selenium.click("delete");
			selenium.acceptAlert();
		}
	}
		catch (Exception e) {
		e.printStackTrace();
		selenium.reportFailure("Error while deleting Account address");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	 @Then("^Account address should be successfully deleted$")
	    public void account_address_should_be_successfully_deleted() {
		 try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressAccDynamic_C", "Street1",
					"end");
			boolean success=selenium.isElementPresentXpathFast(xpath);
			selenium.printLastTestResult(!success);
		}
		 }
			catch (Exception e) {
				e.printStackTrace();
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
		 
	 }

}
