package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESVerifyContact {
	
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^I update mandatory fields$")
	public void I_update_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				//selenium.type("lastName", "Last Name");
				
				String lastName= selenium.getRandomString();
				selenium.getElement("lastName").sendKeys(lastName);
//				selenium.waitingTime(2000);
				
				/*selenium.jsClick("searchAccounts");
				selenium.autoSuggestiveDrpDownSelectOption("searchAccounts", "Name");*/
				
				//selenium.type("searchAccounts", "Account Name");
				//selenium.clickDynamic("contactAccountDynamic", "Name", "end");
				selenium.waitForElementToBeVisible("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
			
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactTypeDropdown");
				selenium.scrollToElement("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("emailCXG")) {
					selenium.type("emailCXG", "Email");
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.jsClick("search_Departments");
				selenium.autoSuggestiveDrpDownSelectOption("search_Departments", "Department Name");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("save");

				selenium.click("save");

				selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");

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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}
	}

	@Then("^Validate the updated record$")
	public void Validate_the_updated_record() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}

	

}
