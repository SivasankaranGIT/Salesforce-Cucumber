package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESBusinessAdminSetDivisionalOptOutTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	boolean email, phone, fax;

	@Then("^Check Opt Out checkboxes$")
	public void check_Opt_Out_checkboxes() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				/*
				 * selenium.search("Account Name"); selenium.waitingTime(3000); String Xpath =
				 * selenium.getDynamicXpath("anchorTitlecontains", "Account Name",
				 * "endContains"); selenium.clickLoopXpath(Xpath); selenium.waitingTime(4000);
				 */
//				  String URL=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Data Url");
//				  selenium.navigateToURL(URL);
//				  selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("segEmailCheckBox");
				selenium.scrollToElement("segEmailCheckBox");

				if (!selenium.getElement("segEmailCheckBox").isSelected()) {
					selenium.waitForElementToBeClickable("segEmailCheckBox");
					selenium.jsClick("segEmailCheckBox");
				}
				if (!selenium.getElement("segPhoneCheckBox").isSelected()) {
					selenium.waitForElementToBeClickable("segPhoneCheckBox");
					selenium.jsClick("segPhoneCheckBox");
				}
				if (!selenium.getElement("segFaxCheckBox").isSelected()) {
					selenium.waitForElementToBeClickable("segFaxCheckBox");
					selenium.jsClick("segFaxCheckBox");
				}
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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}

	@And("^Verify that OptOut gets auto-applied on the contacts$")
	public void verify_that_OptOut_gets_autoapplied_on_the_contacts() {
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("contactsLink");
			selenium.click("contactsLink");
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
			System.out.println(Xpath);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("segEmailCheckBox");
			selenium.scrollToElement("segEmailCheckBox");

			if (selenium.getElement("segEmailCheckBox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "SEG Email OptOut is auto-applied on the contact");
				email = true;
			}
			if (selenium.getElement("segPhoneCheckBox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "SEG Phone OptOut is auto-applied on the contact");
				phone = true;
			}
			if (selenium.getElement("segFaxCheckBox").isSelected()) {
				selenium.test.log(LogStatus.PASS, "SEG Fax OptOut is auto-applied on the contact");
				fax = true;
			}
			if (email && phone && fax) {
				selenium.test.log(LogStatus.PASS, "All OptOut are auto-applied on the contacts");
			} else {
				selenium.test.log(LogStatus.FAIL, "All OptOut are not auto-applied on the contacts");
				selenium.reportFailure("All OptOut are not auto-applied on the contacts");
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
