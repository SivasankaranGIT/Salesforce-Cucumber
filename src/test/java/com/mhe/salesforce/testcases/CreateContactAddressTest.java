package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateContactAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@When("^I go to Contact address screen$")
	public void i_go_to_department_address_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("allButtonLightning");
			selenium.click("allButtonLightning");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllButtonL");
			selenium.click("AllButtonL");
			selenium.waitingTime(4000);
			selenium.type("searchallitems", "Address");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addresses");
			selenium.clickLoop("addresses");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("new");
			selenium.clickLoop("new");
			//selenium.hoverAndClick("contactAddressL");
			//selenium.click("next");
			selenium.waitForElementToBeClickable("addressContactTypeRadioBtn");
			selenium.hoverAndClick("addressContactTypeRadioBtn");
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			//if (selenium.isElementPresentFast("contactAddressPopup"))
				selenium.test.log(LogStatus.INFO, "Department address screen loaded successfully!");
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			if(selenium.getBrowserName().equalsIgnoreCase("IE"))
				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.waitForElementToBeClickable("AddressesC");
			selenium.click("AddressesC");
			selenium.waitForElementToBeClickable("new");
			selenium.clickLoop("new");
			selenium.selectDropdownText("departmentAddressC", "Record Type");
			selenium.waitForElementToBeClickable("continue");
			selenium.click("continue");			
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^I enter and save all the contact details$")
	public void i_enter_and_save_all_the_contact_details() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.type("addressNameL", "Address Name");
//			selenium.type("Search_contact", "Contact Name");
//			selenium.clickDynamic("divTitle", "Contact Name", "end");
//			selenium.scrollToElement("street1");
//			selenium.type("street1", "Street1");
//			selenium.scrollToElement("city");
//			selenium.type("city", "City");
//			selenium.click("addressTypeL");
//			selenium.click("home");
//			selenium.scrollToElement("Countryaddress");
//			selenium.click("Countryaddress");
//			selenium.waitingTime(2000);
//			selenium.jsClickXpath(selenium.getDynamicXpath("anchorTitle", "Country", "end"));			
//			selenium.click("save");
			
				selenium.type("addressNameTxt", "Address Name");
				selenium.type("Search_contact", "Contact Name");
				selenium.clickDynamic("dropDownOptionDynamic", "Name", "end");
				selenium.type("street1Txt", "Street1");
				selenium.scrollToElement("addressTypeDropDwn");
				selenium.click("addressTypeDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Address Type", "end"));
				selenium.waitForElementToBeClickable("addressStatusDropDwn");
				selenium.click("addressStatusDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Address Status", "end"));
				selenium.scrollToElement("cityTxt");
				selenium.type("cityTxt", "City");
				selenium.scrollToElement("countryDropDwn");
				selenium.click("countryDropDwn");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Country", "end"));
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
				
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.type("NameField", "Address Name");
			selenium.selectFromLookUp("Contact Lookup", "Contact Name");
			selenium.type("street1C", "Street1");
			selenium.type("cityC", "City");
			selenium.selectDropdownText("countryC", "Country");
			selenium.selectDropdownText("addressType", "Address Type");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}}
		catch (Exception e) 
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) 
			{
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else 
			{
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}
	}

	@Then("^contact address creation should be successful$")
	public void contact_address_creation_should_be_successful() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
	}
}
