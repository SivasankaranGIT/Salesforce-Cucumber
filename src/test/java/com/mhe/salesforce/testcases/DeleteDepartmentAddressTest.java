package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class DeleteDepartmentAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^I Delete the department address$")
	public void i_Delete_the_department_address() {
		selenium.test.log(LogStatus.INFO, "Deleting the department address");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamicL", "Street1",
					"endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
//			selenium.waitingTime(2000);
			//selenium.click("moreActionsBtn");
			//selenium.click("Deletepopup1");
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamic", "Street1",
					"endContains");
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
		selenium.reportFailure("Error while deleting department address");
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Department address should be successfully deleted$")
	public void Department_address_should_be_successfully_deleted() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamic", "Street1",
					"endContains");
			boolean success=selenium.isElementPresentXpathFast(xpath);
			selenium.printLastTestResult(!success);
		}
	}

}
