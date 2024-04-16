package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class MHESSalesRepModifiesAccountPhoneNumberTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@Then("^I edit the account phone number$")
	public void I_edit_department_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
			/*
				selenium.search("Account Name");
				selenium.waitingTime(4000);
				String Xpath = selenium.getDynamicXpath("anchorTitle", "Account Name", "end");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);

			 */
//				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account URL");
//				selenium.navigateToURL(url);
//				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
				selenium.waitingTime(2000);
				selenium.scrollToElement("phoneNumberText");
				selenium.clearText("phoneNumberText");
				selenium.type("phoneNumberText", "Phone number");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				selenium.waitingTime(15000);
				//flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				String accntName = selenium.getTextLoop("accountNameGetText").toString();
				String expected_accntName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				if (accntName.equalsIgnoreCase(expected_accntName)) {
					selenium.test.log(LogStatus.PASS, "Phone number is updated");
				} else {
					selenium.test.log(LogStatus.FAIL, "Phone number is not updated");
					selenium.reportFailure("Phone number is not updated");
				}

				selenium.waitingTime(5000);

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

	@And("^I validate edit phone number success message$")
	public void validate_the_CXG_contact_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}
}
