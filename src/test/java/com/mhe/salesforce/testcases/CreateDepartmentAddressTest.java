package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateDepartmentAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@When("^I go to Department address screen$")
	public void i_go_to_department_address_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(4000);
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
			//selenium.hoverAndClick("departmentAddressL");
			selenium.waitForElementToBeClickable("adressTypeRadioBtn");
			selenium.hoverAndClick("adressTypeRadioBtn");
			//selenium.click("next");
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			//if (selenium.isElementPresentFast("contactAddressPopup"))
			if (selenium.isElementPresentFast("newAddressPopup"))
				selenium.test.log(LogStatus.INFO, "Department address screen loaded successfully!");
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
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
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^I enter and save all the required details$")
	public void i_enter_and_save_all_the_required_details() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			//selenium.type("addressNameL", "Address Name");
			selenium.type("addressNameTxt", "Address Name");
			//selenium.type("serach_Account", "Account Name");
			//selenium.click("sample");
			//selenium.typeRandomstring("serach_Account", WebConnector.ACC_NAME_RANDOM);
			//selenium.clickDynamicUsingAccName("divTitle", WebConnector.ACC_NAME_RANDOM, "end");
			selenium.typeRandomstring("serach_Account", WebConnector.ACC_NAME_RANDOM);
			selenium.clickDynamicUsingAccName("dropDownOptionDynamic", WebConnector.ACC_NAME_RANDOM, "end");
			
			selenium.type("Name_Field", "Department Name");
			selenium.clickDynamic("dropDownOptionDynamic", "Department Name", "end");
			
			//selenium.type("Name_Field", "Department Name");
			//selenium.pressBackspace("Name_Field");
			//selenium.clickDynamic("divTitle", "Department Name", "end");
			//selenium.scrollToElement("street1");
			//selenium.type("street1", "Street1");
			//selenium.scrollToElement("city");
			//selenium.type("city", "City");
			//selenium.scrollToElement("Countryaddress");
			//selenium.click("Countryaddress");
			//selenium.waitingTime(2000);
			//selenium.jsClickXpath(selenium.getDynamicXpath("anchorTitle", "Country", "end"));
			//selenium.scrollToElement("street1Txt");
			selenium.type("street1Txt", "Street1");
			
			//selenium.scrollToElement("addressTypeDropDwn");
			selenium.waitForElementToBeClickable("addressTypeDropDwn");
			selenium.click("addressTypeDropDwn");
			selenium.waitingTime(2000);
			selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Address Type", "end"));
			
			//selenium.scrollToElement("addressStatusDropDwn");
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
			selenium.selectFromLookUpDynamicValue("Account Lookup", WebConnector.ACC_NAME_RANDOM);
			selenium.selectFromLookUp("Department Lookup", "Department Name");
			selenium.type("street1C", "Street1");
			selenium.type("cityC", "City");
			selenium.selectDropdownText("countryC", "Country");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
			
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^department address creation should be successful$")
	public void department_address_creation_should_be_successful() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
	}
}
