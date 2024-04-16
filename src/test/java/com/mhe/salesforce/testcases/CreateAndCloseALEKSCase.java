package com.mhe.salesforce.testcases;

import java.util.List;

//import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAndCloseALEKSCase {
	
	WebConnector selenium = WebConnector.getInstance();
	String lastName;
	String contactUrl;
	
	@And("^create new ALEKS contact$")
	public void create_new_ALEKS_contact() {
		try {
			selenium.checkFlowInterruptedPopup();
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitForElementToBeVisible("firstName");
				selenium.type("firstName", "First Name");
				selenium.waitingTime(2000);

				lastName = selenium.getRandomString();
				System.out.println("contact name"+lastName);
				selenium.waitForElementToBeVisible("lastName");
				selenium.getElement("lastName").sendKeys(lastName);
				selenium.waitingTime(2000);
				
				selenium.waitForElementToBeClickable("contactTypeDropdown2");				
				selenium.click("contactTypeDropdown2");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
				
				selenium.waitForElementToBeClickable("ContactStatusField");
				selenium.click("ContactStatusField");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
				selenium.waitingTime(6000);
				
				if(selenium.isElementPresentFast("AccountSearchPopup"))
				{
					System.out.println("Closing Account search window..");
					selenium.clickLoop("CloseWindow");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("serach_Account");

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

				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("emailCXG");
				selenium.type("emailCXG", "Email");
				selenium.waitingTime(2000);
				selenium.moveTab("emailCXG");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(20000);
				//flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			contactUrl=selenium.getURL();

		}catch (Exception e) {
			System.out.println("inside catch");
			selenium.clickLoop("opportunityAccountsEditCancel");
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigation to new case" + e.getMessage());	 
 }
	}

	
	@Then("^click on New Case for ALEKS$")
    public void click_on_new_case_for_aleks() {
		 
		 try {
			 selenium.waitingTime(5000);
			 selenium.refresh();
			 selenium.waitingTime(15000);
			 try
			 {				 
				 selenium.checkFlowInterruptedPopup();
			 }
			 catch(Exception e)
			 {
				 System.out.println("Ignore.." + e);
			 }
			 selenium.waitingTime(2000);
			 selenium.checkFlowInterruptedPopup();
			 selenium.waitForElementToBeClickable("newCase");
			 selenium.click("newCase");
			 selenium.waitingTime(10000);		 
		 }
		 catch (Exception e) {
			 
				if(selenium.isElementPresentsuperFast("opportunityAccountsEditCancel"))
				{
					System.out.println("Clicking on opportunityAccountsEditCancel button");
					selenium.clickLoop("opportunityAccountsEditCancel");
				}
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigation to new case" + e.getMessage());
			}
	 }

	
	@And("^fill all mandatory details to create ALEKS case$")
    public void fill_all_mandatory_details_to_create_aleks_case() {
	 
	 try {
		 selenium.waitingTime(4000);
		 if (selenium.isElementPresentFast("loginPopUp"))
		 {
			 System.out.println("I am inside loginPopup method");
			 selenium.clickLoop("loginPopUp");
			 selenium.waitingTime(2000);
		 }
		 selenium.waitingTime(8000);		
		 selenium.waitForElementToBeClickable("Case_OriginDropDown");
		 selenium.jsClick("Case_OriginDropDown");
		 selenium.waitingTime(8000);
		 selenium.clickDynamic("spanTitle", "Case Origin", "end");
		 selenium.waitingTime(8000);
		 selenium.waitForElementToBeClickable("productDropDwn1");
		 selenium.jsClick("productDropDwn1");
		 selenium.waitingTime(8000);
		 selenium.clickDynamic("spanTitle", "Product", "end");
		 selenium.waitingTime(5000);
		 selenium.waitForElementToBeClickable("ReasonDDList");
		 selenium.jsClick("ReasonDDList");
		 selenium.waitingTime(3000);
		 selenium.clickDynamic("spanTitle", "Reason", "end");
		 selenium.waitingTime(4000);		
		 selenium.type("Subject_field", "Subject");
		 selenium.waitingTime(2000);		 
		 selenium.type("caseCXGInternalDescriptionNew", "Internal Description");
		 selenium.waitingTime(2000);
		 selenium.moveTab("caseCXGInternalDescriptionNew");
		 selenium.waitingTime(3000);		 
		 selenium.captureScreenShot();
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("saveButton");
		 selenium.clickLoop("saveButton");
		 selenium.waitingTime(8000);
	 }
	 catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure(e.getMessage());
	 }	 
 }	
 
	 @Then("^click on close case button for ALEKS$")
	    public void click_on_close_case_button_for_aleks() {
		 
		 try {
			
//			 selenium.waitingTime(6000);
			 selenium.waitForElementToBeClickable("closeCaseTab");
			 selenium.jsClick("closeCaseTab");
			 selenium.waitingTime(5000);
		
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while clicking on close case " + e.getMessage());
			}
	 }
	 
	 @And("^fill mandatory fields to close ALEKS Case$")
	    public void fill_mandatory_fields_to_close_aleks_case() {
		 
		 try {
			 selenium.waitForElementToBeClickable("closingStatus");
			 selenium.jsClick("closingStatus");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("closingStatus");
			 selenium.selectDropdownText("closingStatus", "Close Status");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseResolution");
			 selenium.jsClick("caseResolution");
			 selenium.waitingTime(2000);
			 selenium.type("caseResolution", "Case Resolution");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
			 selenium.jsClick("caseCXGCloseMarketDropdown");
			 selenium.waitingTime(2000);
			 selenium.clickDynamic("spanTitle", "Market", "end");
			 selenium.waitingTime(4000);
			 selenium.captureScreenShot();
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("saveButton");
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(5000);
			 selenium.test.log(LogStatus.PASS, "Case closed successfully");
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while closing case " + e.getMessage());
			}
	 }
	 
	 
	 @Then("^verify the status of closed ALEKS record$")
	    public void verify_the_status_of_closed_aleks_record() {
		 
		 try {
			 if (selenium.isElementPresentFast("loginPopUp"))
			 {
				 selenium.click("loginPopUp");
			 }
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeVisible("caseCXGClosedStatus");
			 	String status = selenium.getTextLoop("caseCXGClosedStatus").toString();
				String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Case Status");
				System.out.println("status" +status + expected_status );
				if (status.equalsIgnoreCase(expected_status)) {
					System.out.println("inside pass" );
					selenium.test.log(LogStatus.PASS, "Status is closed");

				} else {
					System.out.println("inside fail" );
					selenium.test.log(LogStatus.FAIL, "Status is not closed");
					selenium.reportFailure("Status is not closed");

				}
				selenium.captureScreenShot();
				 selenium.waitingTime(2000);
				
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying case status " + e.getMessage());
		 }
	 }
	 
	
	 @Then("^delete record$")
	    public void delete_record()  {
		 try {
			 if (selenium.isElementPresentFast("loginPopUp"))
			 {
				 selenium.click("loginPopUp");
			 }
		 selenium.waitingTime(5000);
		 selenium.waitForElementToBeClickable("DeleteActionBtn");
		 selenium.click("DeleteActionBtn");
//		 selenium.waitingTime(4000);
		 selenium.waitForElementToBeClickable("deleteBtn");
		 selenium.click("deleteBtn");
		 selenium.waitingTime(9000);
		 selenium.captureScreenShot();
		 selenium.waitingTime(2000);
		 selenium.closeSubTabs();
		 selenium.waitingTime(2000);	 	
	 }
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying case status " + e.getMessage());
	 }
	 }
	 
	 
	 
	 @And("^select contact from search$")
	    public void select_contact_from_search() {
		try {
			selenium.waitForElementToBeClickable("searchTextL");
			selenium.click("searchTextL");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("campaignFromDrpDwn");
			selenium.click("campaignFromDrpDwn");
			selenium.waitingTime(2000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "New Contact" , "end");
			selenium.waitingTime(2000);
			selenium.scrollToXpathElement(nameXpath);
			selenium.clickXpath(nameXpath);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_new");
			//selenium.searchString(lastName);
			selenium.clickLastXpath("search_new");
			String searchXpath = selenium.getLastXpath("search_new");
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeVisible(searchXpath);
			selenium.getXpathElement(searchXpath).sendKeys(lastName);
			selenium.waitingTime(2000);
			selenium.getXpathElement(searchXpath).sendKeys(Keys.ENTER);
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while searching contact " + e.getMessage());
		}

	}
	 
	 @Then("^delete contact$")
	    public void delete_contact() {
		try {
			
			String Xpath = selenium.getDynamicXpathProperty("contactSearchWithAdmin", lastName, "deleteMenuEnd");
			selenium.waitingTime(3000);
			System.out.println("xpath is"+Xpath);
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(4000);
			 selenium.captureScreenShot();
			//selenium.navigateToURL(contactUrl);
//			 selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
//			 selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("deleteBtn");
			 selenium.click("deleteBtn");
			 selenium.waitingTime(9000);
			 selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		}

		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while deleting contact " + e.getMessage());
		}

	}
	 

}