package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteContactTest {
	
	WebConnector selenium = WebConnector.getInstance();
	boolean success;
	
	@When("^I go to contact detail screen$")
	public void i_go_to_contact_detail_screen(){
		try{
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.type("searchTextC", "Contact");
			selenium.pressEnter("searchTextC");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Contact");
			selenium.click("Contact");
		}
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchTextL");
			selenium.type("searchTextL", "Contact");
			selenium.waitingTime(2000);
			selenium.pressEnter("searchTextL");
			/*selenium.click("salesrepsearch");
			selenium.waitingTime(6000);
			selenium.scrollToElement("Accountsearch");
			selenium.waitingTime(6000);*/
			
			String Contactsearch=selenium.getDynamicXpath("Contactsearchsample", "Contact", "end");
//			selenium.waitForXpathElementToBeClickable(Contactsearch);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Contactsearch);
			
			
		}
				
	}
		catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while navigating to Contact screen");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^I delete a contact$")
	public void i_delete_a_contact() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deletePopupBtn");
			selenium.click("deletePopupBtn");
			success = selenium.isElementPresentFast("permissionMsg");

		}

		else if (selenium.getUI().equalsIgnoreCase("classic")) {
			if (selenium.getBrowserName().equalsIgnoreCase("IE"))
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CaseNum_C");
			selenium.click("CaseNum_C");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("delete");
			selenium.click("delete");
			selenium.acceptAlert();

		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I validate the delete contact message$")
	public void validate_delete_contact_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(success);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(success);
		}
	}

}
