package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class MHHEBusinessAdminSearchProductViaAreaTest {

	WebConnector selenium = WebConnector.getInstance();

	@Then("^I search product via Area$")
	public void I_search_product_via_Area() {
		try {
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Selecting and expanding Business Unit");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("businessUnitDropDwn");
			selenium.click("businessUnitDropDwn");
			// selenium.clickDynamic("currencyValue", "Business Unit", "end");
			selenium.selectDropdownText("businessUnitDropDwn", "Business Unit");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("expandAllOption");
			selenium.click("expandAllOption");
			selenium.waitingTime(3000);
			selenium.scrolldown(500);
			selenium.clickDynamic("spantextContains", "Area", "endContains");
			selenium.waitingTime(2000);
		} catch (Exception e) {
//			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

}
