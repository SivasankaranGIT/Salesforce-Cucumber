package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateAndVerifyContactAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	//String url;
	String street1;

	@And("^create new address for the contact$")
	public void create_new_address_for_the_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				/*selenium.waitingTime(3000);
				selenium.click("SearchThisList");
				selenium.waitingTime(2000);
				selenium.type("SearchThisList", "Contact Name");
				selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
				selenium.waitingTime(2000);*/
				selenium.waitingTime(4000);			
				selenium.search("Contact Name");
				selenium.waitingTime(4000);
				String Xpath = selenium.getDynamicXpath("anchorTitle", "Contact Name", "end");
				System.out.println(Xpath);
				selenium.waitingTime(4000);
//				selenium.waitForXpathElementToBeClickable(Xpath);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);

				if (selenium.isElementPresentFast("showAllLinks")) {
					selenium.waitForElementToBeClickable("showAllLinks");
					selenium.clickLoop("showAllLinks");
				}
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("addressLink");
					selenium.click("addressLink");
				} else {
					selenium.waitForElementToBeClickable("addressLink");
					selenium.click("addressLink");
				}

				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
				}
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("CloseNotificationPopup"))
				{
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("new");
				selenium.clickLoop("new");

				String address = selenium.getRandomString();
				selenium.waitForElementToBeVisible("Name_Field");
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println("Randomly Generated Address is :" + address);
				selenium.waitForElementToBeClickable("addressTypeDropDwn1");
				//selenium.jsClick("addressTypeDropDwn2");
				selenium.jsClick("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");

				selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				//selenium.type("cityAddress", "City");
				String cityAddress = selenium.getRandomString();
				selenium.waitingTime(2000);
				selenium.getElement("cityAddress").sendKeys(cityAddress);
				System.out.println("Randomly Generated City Address is :" + cityAddress);
				selenium.type("postalCodeAddress", "Postal Code");
				selenium.waitForElementToBeClickable("save");
				selenium.waitingTime(3000);
				selenium.click("save");
				//selenium.click("addressGreenLink");
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("objectFilterBtn");
				
				selenium.jsClick("objectFilterBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("addressFiltervalueInput");
				selenium.getElement("addressFiltervalueInput").sendKeys(cityAddress);
				System.out.println("City Address Passed in Filer is :" + cityAddress);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
				selenium.waitingTime(5000);

				String Xpath1 = selenium.getDynamicXpathProperty("anchorTitlecontains", cityAddress, "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath1);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath1);
				selenium.waitingTime(8000);

				selenium.url = selenium.getURL();
				System.out.println(selenium.url);
				System.out.println("New Address URL is : " + selenium.url);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
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

	@Then("^Verify and accept changes$")
	public void verify_and_accept_changes() {
		try {

		String addressStatus = null;
		String exp_addressStatus = null;
		selenium.navigateToURL(selenium.url);
		System.out.println("New Address URL is : " + selenium.url);
		selenium.waitingTime(4000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		if(selenium.getTestCaseName().equalsIgnoreCase("CreateAndVerifyContactAddress"))
		{
			selenium.scrollToElement("lastTaskRecord");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastTaskRecord");
			selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("lastTaskRecordLinkNew");
			selenium.jsClick("lastTaskRecordLinkNew");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
		}
		selenium.waitForElementToBeVisible("addressStatusGetText");
		addressStatus = selenium.getTextLoop("addressStatusGetText").toString();
		exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status Before");
		System.out.println("Address & Exp. Address is : " + addressStatus + exp_addressStatus);
		if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Not Verified");
			System.out.println("PASS");
		} else {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed! Status did not change to Not Verified");
			selenium.reportFailure("Test Case Failed! Status did not change to Not Verified");
		}
		selenium.waitingTime(2000);
		selenium.refresh();
		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("verifyAddressBtn");
		selenium.jsClick("verifyAddressBtn");
		selenium.waitingTime(4000);
		selenium.refresh();
		selenium.waitingTime(5000);
		selenium.switchToFrame("productframeUat");
		selenium.waitingTime(6000);
		selenium.scrollToElement("acceptChangesBtn");
		selenium.waitForElementToBeClickable("acceptChangesBtn");
		selenium.click("acceptChangesBtn");
		selenium.waitingTime(12000);
		selenium.switchOutOfFrame();
		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("addressStatusGetText");
		addressStatus = selenium.getText("addressStatusGetText").toString();
		exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status After");
		System.out.println("Address & Exp. Address is : " + addressStatus + exp_addressStatus);
		if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Verified");
			selenium.url = selenium.getURL();

		} else {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed! Status did not change to Verified");
			selenium.reportFailure("Test Case Failed! Status did not change to Verified");

		}
		} catch (Exception e) {
			selenium.navigateTo("LoginTest", "Url");
			selenium.waitingTime(4000);
			selenium.check_Switch_UserInterface();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@And("^edit new address for the contact$")
	public void edit_new_address_for_the_contact() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				System.out.println("New Address URL is : " + selenium.url);
				selenium.navigateToURL(selenium.url);
				selenium.waitingTime(10000);
				/*selenium.scrollToElement("lastTaskRecord");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("lastTaskRecord");
				selenium.clickLoop("lastTaskRecord"); //just to navigate to last row
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("lastTaskRecord");
				selenium.jsClick("lastTaskRecord");
				selenium.waitingTime(5000);*/
				selenium.captureScreenShot();
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("street2Address");
				selenium.clearText("street2Address");
				String street2 = selenium.getRandomString();
				selenium.getElement("street2Address").sendKeys(street2);
				selenium.waitingTime(2000);
				System.out.println(street2);

				// selenium.type("street2Address", "Street2");
				selenium.clearText("street3Address");
				String street3 = selenium.getRandomString();
				selenium.getElement("street3Address").sendKeys(street3);
				System.out.println(street3);

				// selenium.type("street3Address", "Street3");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				selenium.waitingTime(8000);
				/*flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);*/

//				String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
//				selenium.clickLoopXpath(Xpath1);
//				selenium.waitingTime(4000);

				selenium.url = selenium.getURL();
				System.out.println(selenium.url);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
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

	@And("^Open and verify the same address$")
	public void open_and_verify_address() {
		try {
			String addressStatus = null;
			String exp_addressStatus = null;
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			addressStatus = selenium.getText("addressStatusGetText").toString();
			exp_addressStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Address Status After");
			if (addressStatus.equalsIgnoreCase(exp_addressStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed! Status changed to Verified");

			} else {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed");

			}
		}
		catch(Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@And("^copy the address url$")
	public void copy_address_url() {

		String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
//		selenium.waitForXpathElementToBeClickable(Xpath1);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath1);
		selenium.waitingTime(4000);

		selenium.url = selenium.getURL();

	}

	@And("^create new address for the account to accept changes$")
	public void create_new_address_for_the_account_accept_changes() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.MHES_Contact_URL);
				selenium.waitingTime(6000);
				if(selenium.isElementPresentFast("showAllLinks")){
				selenium.click("showAllLinks");
				}
				selenium.waitingTime(2000);
				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.click("addressLink_new");
				} else {
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.click("addressLink_new");
				}

				selenium.waitForElementToBeClickable("new");
				selenium.clickLoop("new");
				selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");

				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Name_Field");
				String address = selenium.getRandomString();
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println(address);				
				selenium.waitingTime(2000);
				
				selenium.waitForElementToBeClickable("addressTypeDropDwn1");				
				selenium.click("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");
				selenium.waitForElementToBeVisible("street1Address");
				
				selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				selenium.type("cityAddress", "City");
				selenium.type("postalCodeAddress", "Postal Code");

				/*selenium.click("addressTypeDropDwn2");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");*/

				selenium.scrollToElement("workflowNotesTextField");
				selenium.type("workflowNotesTextField", "Workflow Notes");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");

				selenium.click("save");
				selenium.waitingTime(1000);
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(2000);

			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
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
