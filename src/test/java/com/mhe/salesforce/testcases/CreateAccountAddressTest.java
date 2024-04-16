package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountAddressTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@When("^I go to account address screen$")
	public void i_go_to_account_address_screen() {
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
			//selenium.hoverAndClick("accountAddressL");
			//selenium.click("next");
			selenium.waitForElementToBeClickable("accountAddressRadioBtn");
			selenium.hoverAndClick("accountAddressRadioBtn");
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			//if (selenium.isElementPresentFast("contactAddressPopup"))
				selenium.test.log(LogStatus.INFO, "Department address screen loaded successfully!");
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			if(selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
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

	@And("^I enter and save all the account details$")
	public void i_enter_and_save_all_the_account_details() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.type("addressNameL", "Address Name");
//			selenium.typeRandomstring("serach_Account", WebConnector.ACC_NAME_RANDOM);
//			selenium.clickDynamicUsingAccName("divTitle", WebConnector.ACC_NAME_RANDOM, "end");
//			
//			selenium.scrollToElement("street1");
//			selenium.type("street1", "Street1");
//			selenium.scrollToElement("city");
//			selenium.type("city", "City");
//			selenium.scrollToElement("Countryaddress");
//			selenium.click("Countryaddress");
//			selenium.waitingTime(2000);
//			selenium.jsClickXpath(selenium.getDynamicXpath("anchorTitle", "Country", "end"));
//			selenium.click("save");
			
			selenium.type("addressNameTxt", "Address Name");
			selenium.typeRandomstring("serach_Account", WebConnector.ACC_NAME_RANDOM);
			selenium.clickDynamicUsingAccName("dropDownOptionDynamic", WebConnector.ACC_NAME_RANDOM, "end");
			selenium.type("street1Txt", "Street1");
			selenium.scrollToElement("addressStatusDropDwn");
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
			selenium.type("street1C", "Street1");
			selenium.type("cityC", "City");
			selenium.selectDropdownText("countryC", "Country");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("^I enter and save all the Sales Rep Address details$")
	public void I_enter_and_save_all_the_Sales_Rep_Address_details() throws InterruptedException {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {

			selenium.jsClick("NewButton");
			selenium.waitingTime(3000);
			selenium.type("addressNameTxt", "Address Name");
		
			
			selenium.type("street1Txt", "Street1");
			
		
			selenium.waitingTime(2000);
		
		//	selenium.selectDropdownText("addressStatusDropDwn2", "Address Status");
			selenium.selectDropdown("addressStatusDropDwn2", "Address Statu");
			selenium.waitingTime(2000);
		//	selenium.selectDropdownText("addressTypeDropDwn2", "Address Type");
			selenium.selectDropdown("addressTypeDropDwn2", "Address Type");
		
			selenium.scrollToElement("cityTxt");
			selenium.type("cityTxt", "City");
			selenium.waitingTime(2000);
			selenium.scrollToElement("postalCodeAddress");
			selenium.type("postalCodeAddress", "Postal Code");
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
			selenium.type("street1C", "Street1");
			selenium.type("cityC", "City");
			selenium.selectDropdownText("countryC", "Country");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("^I enter and save all the Address details$")
    public void I_enter_and_save_all_the_Address_details() throws InterruptedException {
		try {
           if (selenium.getUI().equalsIgnoreCase("lightning")) {
				if(selenium.isElementPresentFast("CloseNotificationPopup"))
				{
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
				}
        	      selenium.clickLoop("NewButton");//jsClick
                  selenium.waitingTime(3000);
                  selenium.click("addressNameTxt");
                  selenium.type("addressNameTxt", "Address Name");
                  selenium.click("Search_contact");
                  
                  selenium.type("Search_contact", "Account Name");
  				selenium.waitingTime(2000);
  				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
  				selenium.clickLoop("showAllResultsFromDropDwn");
  				selenium.waitingTime(6000);
  				String deptsearch = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endContains");
  				System.out.println(deptsearch);
  				selenium.waitingTime(4000);
  				selenium.clickLoopXpath(deptsearch);
  				selenium.waitingTime(4000);
           
                  
                  selenium.type("street1Txt", "Street1");
           
                  //selenium.waitingTime(2000);
                  //selenium.click("addressStatusDropDwn2");
           
           
                  selenium.waitingTime(2000);
                  selenium.autoSuggestiveDropdownWithoutText("addressTypeDropDwn1");
           
                  selenium.scrollToElement("cityTxt");
                  selenium.type("cityTxt", "City");
                  selenium.waitingTime(2000);
                  selenium.scrollToElement("postalCodeAddress");
                  selenium.type("postalCodeAddress", "Postal Code");
//               selenium.scrollToElement("countryDropDwn");
//               selenium.click("countryDropDwn");
//               selenium.waitingTime(2000);
//               selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Country", "end"));
//               
      			  selenium.waitForElementToBeClickable("save");
                  selenium.click("save");
                  selenium.waitingTime(9000);
                  //flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
                  
           }else if(selenium.getUI().equalsIgnoreCase("classic")){
                  selenium.type("NameField", "Address Name");
                  selenium.selectFromLookUpDynamicValue("Account Lookup", WebConnector.ACC_NAME_RANDOM);
                  selenium.type("street1C", "Street1");
                  selenium.type("cityC", "City");
                  selenium.selectDropdownText("countryC", "Country");
      			  selenium.waitForElementToBeClickable("save");
                  selenium.click("save");
                  
           }
    }catch(Exception e) {
    	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
    	selenium.reportFailure("Test Case Failed");
    	selenium.waitingTime(3000);
        System.out.println("Error catch");
        boolean      error=selenium.isElementPresentFast("ErrorListAll");     
        System.out.println(error);
        if(error==true) {
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

	


	@Then("^account address creation should be successful$")
	public void account_address_creation_should_be_successful() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
	}
}
