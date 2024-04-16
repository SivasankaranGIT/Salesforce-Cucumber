package com.mhe.salesforce.testcases;

import org.junit.Assert;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConvertLeadToContactTest {
	WebConnector selenium = WebConnector.getInstance();

	@When("^Navigate to Leads Page$")
	public void vavigate_to_leads_page() throws InterruptedException {
		try {
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "Screen");
		selenium.waitForElementToBeClickable("leadOptionsMenuDots");
		selenium.jsClick("leadOptionsMenuDots");
		selenium.waitingTime(3000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@When("^create a new Lead$")
	public void create_lead() throws InterruptedException {

		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitForElementToBeClickable("contactSalutation");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation", "end");
			selenium.type("firstName", "First Name");
			selenium.waitingTime(2000);

			String CurrentDate = selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
			String lastName_excel = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
			String lastName = lastName_excel + CurrentDate;
			selenium.typeData("lastName", lastName);
			
			String firstName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
			selenium.convertedContactName= firstName.concat(" ").concat(lastName);
			selenium.test.log(LogStatus.INFO, "Full name is: " +selenium.convertedContactName);
			System.out.println("Full name is: " +selenium.convertedContactName);

			selenium.typeData("LeadCompnay", "McHill");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.leadUrl_new = selenium.getURL();
			System.out.println("Newly created Lead URL : " + selenium.leadUrl_new);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^convert Lead to Contact$")
	public void convert_lead_to_contact() throws InterruptedException {
		try {
		selenium.waitForElementToBeClickable("convertButton");
		selenium.click("convertButton");
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("chooseExistingIcon");

		selenium.click("chooseExistingIcon");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("existingAccountHolder");
		
		selenium.type("existingAccountHolder", "Account Name");
		selenium.waitForElementToBeClickable("showResultsInAccount");
		selenium.click("showResultsInAccount");
		selenium.waitingTime(6000);
		
		String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
				"end");
//		selenium.waitForXpathElementToBeClickable(accountsearch);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(accountsearch);
		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("convert_buttonNew");
		
		selenium.click("convert_buttonNew");
		selenium.waitingTime(10000);

//		if (selenium.isElementPresentFast("convertSuccessText1")) {
//			selenium.test.log(LogStatus.PASS, "Lead has been converted successfully");
//			System.out.println("PASS");
//			selenium.waitForElementToBeClickable("goToLeadsBtn");
//			selenium.click("goToLeadsBtn");
//			selenium.waitingTime(6000);
//		} else {
//			selenium.test.log(LogStatus.FAIL, "Error in Lead conversion");
//			System.out.println("FAIL");
//			selenium.reportFailure("Error in Lead conversion");
//		}
		
        Assert.assertTrue(selenium.isElementPresentFast("LeadConvertedMsg"));
        selenium.test.log(LogStatus.PASS, "Lead has been converted successfully");
        System.out.println("PASS");
        selenium.click("goToLeadsBtn");
        selenium.waitingTime(8000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^create new Lead$")
	public void create_new_lead() throws InterruptedException {

		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitForElementToBeClickable("contactSalutation");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation", "end");
			selenium.type("firstName", "First Name");
			selenium.waitingTime(2000);

			String CurrentDate = selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
			String lastName_excel = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
			String lastName = lastName_excel + CurrentDate;
			selenium.typeData("lastName", lastName);
			
			String firstName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
			selenium.convertedContactName= firstName.concat(" ").concat(lastName);
			selenium.test.log(LogStatus.INFO, "Full name is: " +selenium.convertedContactName);
			System.out.println("Full name is: " +selenium.convertedContactName);

			selenium.typeData("LeadCompnay", "McHill");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.LeadURl = selenium.getURL();
			System.out.println("Newly created Lead URL is : " + selenium.LeadURl);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
	
	@Then("^click on New case by selecting available contact$")
    public void click_on_new_case_by_selecting_one_contact() {
	 
		try {
			
			selenium.waitingTime(5000);
			selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
			selenium.waitingTime(10000);
			if(selenium.getTestCaseName().equalsIgnoreCase("CreateCSOMCaseAndVerifyOwner"))
			{
			selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
			selenium.waitingTime(10000);
			}
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("newCase");
			selenium.click("newCase");
			selenium.waitingTime(5000);

		}
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigation to new case" + e.getMessage());
		}
 }
	
	

}
