package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CXGUserCreatesNewContactTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create new CXG contact by filling mandatory fields$")
	public void create_new_CXG_contact_by_filling_mandatory_fields() {
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
				selenium.waitForElementToBeVisible("contactTypeDropdown");
				selenium.scrollToElement("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactStatusDropdown");
				
				selenium.scrollToElement("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
				selenium.waitingTime(2000);
				
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("serach_Account");
				
				/*selenium.jsClick("searchAccounts");
				selenium.autoSuggestiveDrpDownSelectOption("searchAccounts", "Name");*/
				
				//selenium.type("searchAccounts", "Account Name");
				//selenium.clickDynamic("contactAccountDynamic", "Name", "end");
				
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);

				if (selenium.isElementPresentFast("emailCXG")) {
					selenium.type("emailCXG", "Email");
					selenium.waitingTime(2000);
				}
				/*selenium.jsClick("search_Departments");
				selenium.autoSuggestiveDrpDownSelectOption("search_Departments", "Department Name");
				selenium.waitingTime(3000);*/
				
//				selenium.type("search_Departments", "Department Name");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownOne("search_Departments", "Department Name");
//				selenium.waitForElementToBeClickable("resultDropDwn");
//				selenium.click("resultDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath("searchDepartment", "Department Name",
						"end");
//				selenium.waitForXpathElementToBeClickable(deptsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Save Button clicked");
				
				/*if(selenium.waitForElementToBeVisible("CancelEdit")) {
					selenium.test.log(LogStatus.PASS, "Save Button clicked in second try");
					selenium.clickLoop("saveButton");
					selenium.waitingTime(4000);
				}
				flagsuccess =selenium.waitForElementToBeVisible("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);*/
//				selenium.waitForElementToBeVisible("contactNameGetText");
//				String contactName = selenium.getTextLoop("contactNameGetText").toString();
				selenium.waitForElementToBeVisible("contactNameGetText");
				String contactName = selenium.getTextLoop("contactNameGetText").toString();
				if (contactName.contains(lastName)) {
					selenium.test.log(LogStatus.PASS, "Course name is updated as: " + contactName);
					System.out.println("PASS");
				} else {
					selenium.test.log(LogStatus.FAIL, "Course name is not updated");
					selenium.reportFailure("Course name is not updated");
					System.out.println("FAIL");
				}

				selenium.waitingTime(6000);
				selenium.contacts=selenium.getURL();
				System.out.println("Newly created CXG Contact is :" + selenium.contacts);
			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^I validate the CXG contact success message$")
	public void validate_the_CXG_contact_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}

	@And("^I edit department details$")
	public void I_edit_department_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				selenium.navigateToURL(selenium.contacts);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
		        if (selenium.isElementPresentFast("loginPopUp"))
		        {
		        	System.out.println("I am inside loginPopup method");
		        	selenium.clickLoop("loginPopUp");
		        	selenium.waitingTime(2000);	
		        }
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
				selenium.waitForElementToBeVisible("contactTypeDropdown");				
				selenium.scrollToElement("contactTypeDropdown1");
				//selenium.click("contactTypeDropdown1");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitForElementToBeVisible("deptNameLabel");				
				selenium.scrollToElement("deptNameLabel");
				if(selenium.isElementPresentFast("Deletepopup1"))
				{
					selenium.click("Deletepopup1");
				}
				selenium.waitingTime(2000);
				selenium.test.log(LogStatus.PASS, "Tried removing Department Name");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.clickLoop("saveButton");
				selenium.waitingTime(6000);
				selenium.captureScreenShot();

			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	        if (selenium.isElementPresentFast("loginPopUp"))
	        {
				selenium.click("loginPopUp");
				selenium.waitingTime(2000);
	        }
		}
	}

	@Then("^Validate error message for department field edit$")
	public void validate_error_message_for_department_field_edit() {
		try {

			selenium.waitingTime(2000);
			String error = null;
			String expected_error = null;
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(2000);
				selenium.scrollToElement("deptRemoveErrorGetText");
				selenium.waitingTime(2000);
				error = selenium.getText("deptRemoveErrorGetText");
				expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
				selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
				if (error.contains(expected_error)) {
					selenium.click("CancelEdit");
					selenium.test.log(LogStatus.PASS, "Test Case Passed!");

				} else {
					selenium.click("CancelEdit");
					selenium.reportFailure("Test Case Failed");
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");

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
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}
	@When("^Navigate to CXG Contacts page$")
	public void navigate_to_contacts_screen() {
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("waffleIcon");
		selenium.click("waffleIcon");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactsOption");
		selenium.click("contactsOption");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Contacts page loaded successfully!");
	}

}
