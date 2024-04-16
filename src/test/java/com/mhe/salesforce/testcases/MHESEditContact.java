package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESEditContact {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit MHE user contact details$")
	public void I_edit_MHE_user_contact_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.search("Contact Name");
				selenium.waitingTime(10000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
				System.out.println(Xpath);
				selenium.waitingTime(10000);
//				selenium.waitForXpathElementToBeClickable(Xpath);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptNameLabel");
				selenium.scrollToElement("deptNameLabel");
				// String Xpath2 = selenium.getDynamicXpath("deptNameDynamic", "Department
				// Name", "endDeleteIcon");
				// selenium.getXpathElement(Xpath2).click();
				if(selenium.isElementPresentFast("deptDeleteIcon"))
				{
					selenium.click("deptDeleteIcon");
				}
				selenium.waitingTime(2000);
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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}

	@Then("^verify error field message$")
	public void verify_error_field_message() {
		try {

			selenium.waitingTime(2000);
			String error = null;
			String expected_error = null;
			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptRemoveErrorGetText");
				selenium.scrollToElement("deptRemoveErrorGetText");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptRemoveErrorGetText");
				error = selenium.getTextLoop("deptRemoveErrorGetText");
				expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
				selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
				if (error.contains(expected_error)) {
					selenium.click("CancelEdit");
					selenium.test.log(LogStatus.PASS, "Test Case Passed!");

				} else {
					selenium.click("CancelEdit");
					selenium.reportFailure("Test Case Failed");
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");

				}
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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}

}
