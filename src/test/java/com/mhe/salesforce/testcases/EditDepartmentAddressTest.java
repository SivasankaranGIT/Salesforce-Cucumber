package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditDepartmentAddressTest {
	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to recent addresses$")
	public void i_navigate_to_recent_addresses() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(6000);
			selenium.type("searchallitems", "Address");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addresses");
			selenium.clickLoop("addresses");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Department address screen loaded successfully!");
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.waitForElementToBeClickable("AddressesC");
			selenium.click("AddressesC");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^I edit the country$")
	public void i_edit_the_country() {
		selenium.test.log(LogStatus.INFO, "Selecting the department address");
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamicL", "Street1",
					"endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.jsClickXpath(xpath);
			selenium.waitingTime(2000);
			selenium.scrolldown(300);
			selenium.waitForElementToBeClickable("countryEdit");
			selenium.hoverAndClick("countryEdit");
			/*selenium.waitingTime(2000);
			selenium.scrollToElement("country");
			selenium.scrolldown(200);*/
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Addressdetail");
			selenium.clickLoop("Addressdetail");
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.INFO, "Scrolled to country");
			selenium.waitForElementToBeClickable("country");
			selenium.click("country");
			selenium.waitingTime(2000);
			selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Country", "end"));
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			String xpath = selenium.getDynamicXpathData("anchorText", WebConnector.ACC_NAME_RANDOM, "addressDynamic", "Street1",
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

	@Then("^the changed value should be displayed$")
	public void the_changed_value_should_be_displayed() {
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
