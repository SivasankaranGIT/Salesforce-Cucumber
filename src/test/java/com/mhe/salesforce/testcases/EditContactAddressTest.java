package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class EditContactAddressTest {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit the contact$")
	public void i_edit_the_contact() {
		selenium.test.log(LogStatus.INFO, "Selecting the Contact address");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("anchorText", "Contact Name", "addressDynamicL", "Street1",
					"endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
			selenium.waitingTime(4000);
			selenium.scrolldown(300);
			//selenium.scrollToElement("countryEdit");
			selenium.hoverAndClick("countryEdit");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Addressdetail");
			selenium.clickLoop("Addressdetail");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("country");
			selenium.click("country");
			selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Country", "end"));
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath = selenium.getDynamicXpath("anchorText", "Contact Name", "addressDynamic", "Street1",
					"endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
			selenium.test.log(LogStatus.INFO, "Clicking on Edit");
			selenium.waitForElementToBeClickable("edit");
			selenium.click("edit");
			selenium.scrollToElement("countryC");
			selenium.selectDropdownText("countryC", "Country");
		}
		selenium.click("save");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^the changed contact should be displayed$")
	public void the_changed_contact_should_be_displayed() {
		selenium.waitingTime(3000);
		boolean isSuccess = false;
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			if (selenium.isTextPresent("countryVerificationL", "Country"))
				isSuccess = true;
		} else {
			String xpath = selenium.getDynamicXpath("divText", "Country", "end");
			isSuccess = selenium.isElementPresentXpathFast(xpath);
		}
		selenium.printLastTestResult(isSuccess);
	}

}
