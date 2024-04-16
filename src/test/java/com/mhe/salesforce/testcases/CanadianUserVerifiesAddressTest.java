package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CanadianUserVerifiesAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
	// String street1;

	@And("^create new address for Canada User$")
	public void create_new_address_for_Canada_User() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.click("closeBtn");
					selenium.waitingTime(2000);
				}				

				if (selenium.isElementPresentFast("clearAllLink")) {
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("clearAllLink");
					selenium.click("clearAllLink");
				} else {
					selenium.waitForElementToBeClickable("addressLink");
					selenium.click("addressLink");
//					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("new");
					selenium.clickLoop("new");
					selenium.waitingTime(2000);
					selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("nextBtn");
					selenium.click("nextBtn");

					String address = selenium.getRandomString();
					selenium.getElement("Name_Field").sendKeys(address);
					System.out.println(address);

					/*
					 * selenium.type("Search_contact", "Contact Name"); selenium.waitingTime(2000);
					 * selenium.clickDynamic("strongdynamic", "Name", "end");
					 */

//				street1 = selenium.getRandomString();
//				selenium.getElement("street1Address").sendKeys(street1);
//				System.out.println(street1);

					selenium.type("Search_contact", "Contact Name");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
					selenium.click("showAllResultsFromDropDwn");
					selenium.waitingTime(6000);
					String contactsearch = selenium.getDynamicXpath("accountSearchSample", "Contact Name", "end");
//					selenium.waitForXpathElementToBeClickable(contactsearch);
					selenium.waitingTime(4000);
					selenium.clickLoopXpath(contactsearch);

					selenium.type("street1Address", "Street1");
					selenium.type("street2Address", "Street2");
					selenium.type("street3Address", "Street3");
					selenium.type("street4Address", "Street4");

					selenium.type("cityAddress", "City");
					selenium.type("postalCodeAddress", "Postal Code");

					//selenium.click("addressTypeDropDwn2");
					selenium.scrollToElement("addressTypeDropDwn1");
					selenium.waitForElementToBeClickable("addressTypeDropDwn1");
					selenium.click("addressTypeDropDwn1");
					selenium.waitingTime(2000);
					selenium.clickDynamic("spanTitle", "Address Type", "end");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("addressStatusDropDwn1");
					selenium.click("addressStatusDropDwn1");
					selenium.waitingTime(2000);
					selenium.clickDynamic("spanTitle", "Address Status", "end");
					selenium.waitingTime(2000);
					selenium.scrollToElement("countryDrpDown1");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("countryDrpDown1");
					selenium.click("countryDrpDown1");
					selenium.waitingTime(2000);
					selenium.clickDynamic("spanTitle", "Country", "end");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("save");
					selenium.click("save");
					selenium.waitingTime(10000);
//					flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
//					selenium.printLastTestResult(flagsuccess);
//					selenium.waitingTime(4000);
				}

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

	@Then("^edit and verify Address Status$")
	public void edit_and_verify_Address_Status() {
		try {

			String addressStatus = null;
			String exp_addressStatus = null;

			String xpath = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.clickLoop("editButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("addressStatusDropDwn1");
			selenium.click("addressStatusDropDwn1");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Address Status After", "end");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);
			System.out.println(flagsuccess);
			selenium.waitingTime(2000);

			addressStatus = selenium.getText("addressStatusGetText").toString();
			exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status After");
			System.out.println("The expected result is :" + addressStatus + exp_addressStatus);
			if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Verified");

			} else {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed");

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

}
