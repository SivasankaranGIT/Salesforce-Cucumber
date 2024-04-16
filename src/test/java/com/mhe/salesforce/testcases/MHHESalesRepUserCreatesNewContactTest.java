package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHHESalesRepUserCreatesNewContactTest {


	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create sales rep user contact by filling mandatory fields$")
	public void create_new_CXG_contact_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(5000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitingTime(2000);
				selenium.type("firstName", "First Name");				
				selenium.lastName= selenium.getRandomString();
				System.out.println("Last Name is :" + selenium.lastName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.typeData("lastName", selenium.lastName);
				selenium.waitForElementToBeVisible("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(accountsearch);
			
				selenium.waitingTime(2000);
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
				selenium.click("search_Departments");
				selenium.type("search_Departments", "Department Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath("searchDepartment", "Department Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");

				selenium.waitingTime(5000);
				boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
				if (duplicate == true) {
					selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
					System.out.println("Duplicate Contact exists");
					selenium.waitForElementToBeClickable("okToAddDuplicate");
					selenium.jsClick("okToAddDuplicate");
					selenium.waitForElementToBeClickable("okToAddDuplicateCheckbox1");
					selenium.jsClick("okToAddDuplicateCheckbox1");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("saveButton");
					selenium.jsClick("saveButton");
					selenium.waitingTime(15000);

					boolean viewDuplicates = selenium.isElementPresentFast("DuplidateRecordValidation");
					if (viewDuplicates == true) {
						System.out.println("Duplicate Record Present message displayed");
						selenium.jsClick("saveButton");
						selenium.waitingTime(6000);
					}
				}			

				selenium.contacts=selenium.getURL();
				System.out.println("Newly created contact URL is :" + selenium.contacts);
			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
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


	@And("^I edit sales rep user department details$")
	public void I_edit_department_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {

				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("deptNameLabel");
				selenium.scrollToElement("deptNameLabel");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ContactDeptClearSelectionIcon");
				selenium.click("ContactDeptClearSelectionIcon");
				selenium.waitingTime(5000);
				/*selenium.type_propertiesFile("search_Departments", "Department_Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Department_Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(4000);*/
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

	@Then("^Validate error message for sales rep department field edit$")
	public void validate_error_message_for_department_field_edit() {
		try {

			selenium.waitingTime(2000);
			String error = null;
			String expected_error = null;
			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptRemoveErrorGetText");
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

	@And("^create sales support user contact by filling mandatory fields$")
	public void create_sales_support_user_contact_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(5000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitingTime(2000);
				selenium.type("firstName", "First Name");				
				String userLastName= selenium.getRandomString();
				System.out.println("Last Name is :" + userLastName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.typeData("lastName", userLastName);
				selenium.waitForElementToBeVisible("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(accountsearch);
			
				selenium.waitingTime(2000);
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
				selenium.click("search_Departments");
				selenium.waitingTime(5000);
				selenium.type_propertiesFile("search_Departments", "Department_Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Department_Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");

				selenium.waitingTime(5000);
				boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
				if (duplicate == true) {
					selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
					System.out.println("Duplicate Contact exists");
					selenium.waitForElementToBeClickable("okToAddDuplicate");
					selenium.jsClick("okToAddDuplicate");
					selenium.waitForElementToBeClickable("okToAddDuplicateCheckbox1");
					selenium.jsClick("okToAddDuplicateCheckbox1");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("saveButton");
					selenium.jsClick("saveButton");
					selenium.waitingTime(15000);

					boolean viewDuplicates = selenium.isElementPresentFast("DuplidateRecordValidation");
					if (viewDuplicates == true) {
						System.out.println("Duplicate Record Present message displayed");
						selenium.jsClick("saveButton");
						selenium.waitingTime(6000);
					}
				}
				
				selenium.newContacts=selenium.getURL();
				System.out.println("Newly created contact URL is :" + selenium.newContacts);
			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
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

}
