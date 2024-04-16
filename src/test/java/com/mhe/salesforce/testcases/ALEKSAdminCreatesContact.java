package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ALEKSAdminCreatesContact {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create new ALEKS contact by filling mandatory fields$")
	public void create_new_ALEKS_contact_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(4000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
//				selenium.waitingTime(2000);

				selenium.waitForElementToBeVisible("lastName");
				String lastName = selenium.getRandomString();
				selenium.getElement("lastName").sendKeys(lastName);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				selenium.scrollToElement("contactStatusDropdown");
				selenium.waitForElementToBeClickable("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");

				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("serach_Account");

//				selenium.type("serach_Account", "Support Account Name");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownOne("serach_Account", "Support Account Name");
//				selenium.waitForElementToBeClickable("resultDropDwn");
//				selenium.click("resultDropDwn");
				selenium.waitingTime(6000);
				String supportaccountsearch = selenium.getDynamicXpath("accountSearchSample", "Support Account Name",
						"end");
//				selenium.waitForXpathElementToBeClickable(supportaccountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(supportaccountsearch);

//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("emailCXG");
				selenium.type("emailCXG", "Email");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");

				selenium.clickLoop("Save_Btn");
				selenium.waitingTime(4000);
				//flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
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

	@Then("^I validate the ALEKS contact success message$")
	public void validate_the_Aleks_contact_success_message() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while validation ALEKS contact success message " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Verify the Details of the Contact record created$")
	public void verify_details_of_the_contact_record_created() {
		try {

		selenium.waitingTime(8000);
		String accountName = null;
		String supportAccountName = null;
		String expected_accntName = null;
		String expected_supportAccntName = null;

		if (selenium.getUI().contains("Lightning")) {
			selenium.refresh();
			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("loginPopUp"))
			{
				System.out.println("closing the popup...");
				selenium.click("loginPopUp");
			}
			selenium.waitForElementToBeVisible("accntNameGetText");
			accountName = selenium.getTextLoop("accntNameGetText").toString();
			supportAccountName = selenium.getTextLoop("supportAccntNameGetText").toString();
			;
			expected_accntName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name verify");
			expected_supportAccntName = selenium.getExcelValue(selenium.getTestCaseName()).get(0)
					.get("Support Account Name verify");
			selenium.test.log(LogStatus.INFO,
					"Account Name and Support Account Name are: " + accountName + "and" + supportAccountName);
			System.out.println("1. accountName:" + accountName + " 2. expected_accntName:" + expected_accntName  + " 3. supportAccountName:" + supportAccountName + " 4. expected_supportAccntName:" + expected_supportAccntName);
			if (accountName.equalsIgnoreCase(expected_accntName)
					&& supportAccountName.equalsIgnoreCase(expected_supportAccntName)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
	}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying Details of the Contact record created " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


}
