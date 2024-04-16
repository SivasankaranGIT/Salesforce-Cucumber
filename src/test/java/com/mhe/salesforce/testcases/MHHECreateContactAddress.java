package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHHECreateContactAddress {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
//	String contacturl="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pXdAJAA0/view";

	@And("^I enter the record fields$")
	public void I_enter_the_record_sfields() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pXdAJAA0/view");
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("showAllLinks");
				selenium.click("showAllLinks");
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
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("CloseNotificationPopup"))
				{
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("new");
				selenium.clickLoop("new");
				selenium.waitingTime(4000);
				String address = selenium.getRandomString();
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println(address);
				selenium.waitForElementToBeClickable("addressTypeDropDwn1");
				//selenium.jsClick("addressTypeDropDwn2");
				selenium.jsClick("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");
                selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				selenium.type("cityAddress", "City");
				selenium.type("postalCodeAddress", "Postal Code");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				/*selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);*/
				selenium.waitingTime(20000);

				/*String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
				selenium.waitingTime(2000);
				System.out.println("Xpath1 is " + Xpath1);
				selenium.clickLoopXpath(Xpath1);
				selenium.waitingTime(6000);*/
				
				if(selenium.isElementPresentFast("save"))
				{
	                selenium.test.log(LogStatus.FAIL, "TC Failed");
	                System.out.println("FAIL");
	                selenium.reportFailure("TC Failed");
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
				selenium.click("CancelButton");
			}

		}
	}

		@Then("^Contact should be updated$")
		public void contact_address_creation_should_be_successful() {
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				System.out.println("lightning");
				selenium.printLastTestResult(flagsuccess);
			}else if(selenium.getUI().equalsIgnoreCase("classic")){
				selenium.printLastTestResult(flagsuccess);
				System.out.println("classic");
			}
		}
	
	}
	
	

