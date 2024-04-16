package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddContactTest {
	WebConnector selenium = WebConnector.getInstance();
	@When("^I add contact on opprtunity screen$")
	public void i_add_contact_on_Opportunity_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			//selenium.waitForElementsToBeVisible("NewContactOpportunityL");
			selenium.waitingTime(8000);
			selenium.jsClickXpath("//*[contains(@title,'Opportunity Contacts')][contains(@class,'rlql-label')]");
			//selenium.clickLoop("NewContactOpportunityL");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opportunityContact");
			//selenium.isCheck("Viewall");
			//selenium.click("addContactL");
			selenium.click("opportunityContact");
			selenium.waitingTime(6000);
//			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeVisible("contactC");
			selenium.click("contactC");
//			selenium.waitingTime(4000);
			selenium.waitForElementsToBeVisible("contactTypeOpportunity");
			selenium.selectDropdownText("contactTypeOpportunity", "Contact Type");
			selenium.type("LastNameopportunity", "Last Name");
			selenium.click("Emailopportunity");
			selenium.type("Emailopportunity", "Email");
			selenium.selectFromLookUp("Department Name Lookup", "Department Name");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeVisible("productframeUat");
		    selenium.switchToFrame("productframeUat");
			selenium.isDuplicateOpportunity();
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			selenium.jsClickXpath("//*[contains(@title,'Opportunity Contacts')][contains(@class,'rlql-label')]");
	
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.click("addContact");
			selenium.click("contactC");
//			selenium.waitingTime(2000);
			selenium.waitForElementsToBeVisible("contactTypeOpportunity");
			selenium.selectDropdownText("contactTypeOpportunity", "Contact Type");
			selenium.type("LastNameopportunity", "Last Name");
			selenium.click("Emailopportunity");
			selenium.type("Emailopportunity", "Email");
			selenium.selectFromLookUp("Department Name Lookup", "Department Name");
			selenium.isDuplicate();
			selenium.click("Save_Btn");
		}
			selenium.test.log(LogStatus.INFO, "Contact added successfully!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding contact" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	
	}


	@Then("^the contact should be successfully added$")
	public void the_product_should_be_successfully_added() {
		try {
				String Actual="";
				String expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
				selenium.waitingTime(6000);
				if (selenium.getUI().equalsIgnoreCase("lightning")) {
					String Xpath =selenium.getDynamicXpath("anchorTitle", "Namelocator", "end");
					Actual=selenium.getLastTextLoop(Xpath);
					
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.reportFailure("Test Case Failed");
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
				}
				else if(selenium.getUI().equalsIgnoreCase("Classic")) {
					
					if(selenium.isElementPresentFast("ShowMoreContacts"))
					{
						selenium.click("ShowMoreContacts");
						selenium.waitingTime(2000);
					}
					Actual=selenium.getText("AddContactVerificationL");
					System.out.println(Actual);
					if(Actual.contains(expected))
					{
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						selenium.reportFailure("Test Case Failed");
					}
				}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding contact" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
	
	@When("^I add contact$")
	public void i_add_contact() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(8000);
			selenium.jsClickXpath("//span[contains(text(),'Opportunity Contacts')]");
			//selenium.clickLoop("NewContactOpportunityL");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("addContactL");
			//selenium.isCheck("Viewall");
			selenium.click("addContactL");
			selenium.waitingTime(6000);
//			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToFrame("productframeUat");
			selenium.type("lastnamecontact", "Last Name");
			selenium.clickDynamic("Text_Span", "Last Name", "selectcontactdynamicL");
			selenium.click("Addtoopportunity");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
		
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while while adding contact" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
}
}
