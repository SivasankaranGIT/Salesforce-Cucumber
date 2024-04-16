package com.mhe.salesforce.testcases;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MHESContactSpecificAddress {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
//	String contacturl="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pXdAJAA0/view";
	
	@When("^I create new address record for MHES User$")
	public void I_create_new_address_record_for_MHES_User(){
	    
		try {
			if (selenium.getUI().contains("Lightning")) {

				/*selenium.waitingTime(3000);
				selenium.click("SearchThisList");
				selenium.waitingTime(2000);
				selenium.type("SearchThisList", "Contact Name");
				selenium.getElement("SearchThisList").sendKeys(Keys.ENTER);
				selenium.waitingTime(2000);*/
				
				/*selenium.search("Contact Name");
				selenium.waitingTime(3000);
				selenium.click("contactSearchResult");
				selenium.waitingTime(3000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
				selenium.clickLoopXpath(Xpath);*/
//				selenium.navigateToURL(contacturl);
//				selenium.waitingTime(6000);
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

				String address = selenium.getRandomString();
				selenium.waitForElementToBeVisible("Name_Field");
				selenium.getElement("Name_Field").sendKeys(address);
				System.out.println(address);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addressTypeDropDwn1");
				//selenium.jsClick("addressTypeDropDwn2");
				selenium.waitingTime(2000);
				selenium.jsClick("addressTypeDropDwn1");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Address Type", "end");
				selenium.waitForElementToBeVisible("street1Address");
				selenium.type("street1Address", "Street1");
				selenium.type("street2Address", "Street2");
				selenium.type("street3Address", "Street3");
				selenium.type("street4Address", "Street4");

				selenium.type("cityAddress", "City");
				selenium.type("postalCodeAddress", "Postal Code");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(2000);

				String Xpath1 = selenium.getDynamicXpath("anchorTitlecontains", "Street1", "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath1);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath1);
				selenium.waitingTime(4000);

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
	

	@Then("^I Validate Contact Success message$")
	public void I_Validate_Contact_Success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}
	}