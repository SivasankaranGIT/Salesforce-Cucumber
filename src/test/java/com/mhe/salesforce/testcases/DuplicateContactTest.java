package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DuplicateContactTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create contact to view duplicates$")
	public void create_contact_view_duplicates() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				String firstname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
				String lastname = selenium.lastName;
//						selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
				String contactFullName = firstname.concat(" ").concat(lastname);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.getElement("lastName").sendKeys(selenium.lastName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);

				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
//				selenium.scrollToElement("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactStatusDropdown");

				selenium.scrollToElement("contactStatusDropdown");
				selenium.waitForElementToBeClickable("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("emailCXG")) {
					selenium.type("emailCXG", "Email");
					selenium.waitingTime(2000);
				}
				selenium.waitingTime(5000);
				selenium.type_propertiesFile("search_Departments", "Department_Name");
				selenium.waitingTime(5000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DuplidateRecordValidation");
				selenium.click("DuplidateRecordValidation");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("contactCardTitle");
				String cardName = selenium.getText("contactCardTitle");
				if (cardName.equals(contactFullName)) {
					selenium.test.log(LogStatus.PASS, "Duplicate Contact exists");
					System.out.println("PASS - Duplicate Contact exists");
					selenium.waitForElementToBeClickable("closeDuplicateWindowBtn");
					selenium.click("closeDuplicateWindowBtn");
					selenium.waitingTime(4000);
				}
				if (selenium.isElementPresentFast("closeDuplicateWindowCard")) {
					selenium.waitForElementToBeClickable("closeDuplicateWindowCard");
					selenium.click("closeDuplicateWindowCard");
				}
//				selenium.captureScreenShot();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.click("search_Departments");
				selenium.waitingTime(5000);
//				selenium.type_propertiesFile("search_Departments", "Department_Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Department_Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(5000);
				boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
				if (duplicate == true) {
					selenium.test.log(LogStatus.INFO, "Navigated to Ok to Add Duplicate check box");
					System.out.println("Navigated to Ok to Add Duplicate check box");
					selenium.waitForElementToBeClickable("okToAddDuplicate");
					selenium.jsClick("okToAddDuplicate");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("okToAddDuplicateCheckbox1");

					selenium.jsClick("okToAddDuplicateCheckbox1");
					selenium.waitingTime(3000);
					selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
					System.out.println("Duplicate Contact exists");
				}

				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Save Button clicked");
				System.out.println("PASS - Save Button clicked");
				boolean viewDuplicates = selenium.isElementPresentFast("DuplidateRecordValidation");
				if (viewDuplicates == true) {
					selenium.test.log(LogStatus.PASS, "Duplicate Record Present message displayed");
					System.out.println("PASS - Duplicate Record Present message displayed");
					selenium.waitForElementToBeClickable("CancelEdit");
					selenium.click("CancelEdit");
					selenium.waitingTime(6000);
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
				selenium.waitForElementToBeClickable("CancelButton");
				selenium.click("CancelButton");
			}

			else {
				System.out.println("inside else to click cancel");
				selenium.waitForElementToBeClickable("CancelButton");
				selenium.click("CancelButton");
			}
		}
	}
	
	@And("^create contact to merge duplicates$")
	public void create_contact_merge_duplicates() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				String firstname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
				String lastname = selenium.lastName;
//						selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
				String contactFullName = firstname.concat(" ").concat(lastname);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.getElement("lastName").sendKeys(selenium.lastName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("serach_Account");
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
				System.out.println(accountsearch);
				selenium.waitingTime(4000);
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.clickLoopXpath(accountsearch);

				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactTypeDropdown");
				selenium.scrollToElement("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactStatusDropdown");

				selenium.scrollToElement("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("emailCXG")) {
					selenium.type("emailCXG", "Email");
					selenium.waitingTime(2000);
				}
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("search_Departments");
				selenium.type("search_Departments", "Department Name");
				selenium.waitingTime(6000);
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("DuplidateRecordValidation");
				selenium.click("DuplidateRecordValidation");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("contactCardTitle");
				String cardName = selenium.getText("contactCardTitle");
				if (cardName.equals(contactFullName)) {
					selenium.test.log(LogStatus.PASS, "Duplicate Contact exists");
					selenium.waitForElementToBeClickable("closeDuplicateWindowBtn");
					selenium.click("closeDuplicateWindowBtn");
					selenium.waitingTime(4000);
				}
				if (selenium.isElementPresentFast("closeDuplicateWindowCard")) {
					selenium.waitForElementToBeClickable("closeDuplicateWindowCard");
					selenium.click("closeDuplicateWindowCard");
				}
//				selenium.captureScreenShot();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.click("search_Departments");
				selenium.waitingTime(5000);
//				selenium.type_propertiesFile("search_Departments", "Department_Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.clickLoop("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Department_Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(deptsearch);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(3000);
				
				boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
				if (duplicate == true) {
					selenium.test.log(LogStatus.INFO, "Navigated to Ok to Add Duplicate check box");
					selenium.click("okToAddDuplicate");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("OkToAddDuplicateCheckBox");
					selenium.jsClick("OkToAddDuplicateCheckBox");
					selenium.waitingTime(3000);
					selenium.test.log(LogStatus.INFO, "Duplicate Contact exists");
				}
//				else
//				{
//					selenium.test.log(LogStatus.FAIL, "Create Duplicate Contact Failed!");
//					selenium.click("CancelButton");
//				}
				if (selenium.isElementPresentFast("closeDuplicateWindowCard")) {
					selenium.waitForElementToBeClickable("closeDuplicateWindowCard");
					selenium.click("closeDuplicateWindowCard");
				}
				selenium.jsClick("saveButton");
				selenium.waitingTime(8000);
				selenium.test.log(LogStatus.PASS, "Save Button clicked");

				boolean viewDuplicates = selenium.isElementPresentFast("DuplidateRecordValidation");
				if (viewDuplicates == true) {
					selenium.test.log(LogStatus.PASS, "Duplicate Record Present message displayed");
//					selenium.waitingTime(2000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("CloseErrorDialogPopup");
					selenium.click("CloseErrorDialogPopup");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("saveButton");
					selenium.jsClick("saveButton");
					selenium.waitingTime(15000);
					selenium.test.log(LogStatus.PASS, "Save Button clicked");
					selenium.jsClick("DuplidateRecordValidation");
//					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("mergeCheckBox");
					selenium.jsClick("mergeCheckBox");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("NxtButton");
					selenium.click("NxtButton");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("NxtButton");
					selenium.click("NxtButton");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("mergeButton");
					selenium.click("mergeButton");
					selenium.waitingTime(15000);
				}
//				else
//				{
//					selenium.test.log(LogStatus.FAIL, "Create Duplicate Contact Failed!");
//					selenium.click("CancelButton");
//				}

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
	
	@And("^create duplicate contact$")
    public void create_duplicate_contact() {
		try {
			 

				String firstname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("First Name");
				String lastname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
				String contactFullName = firstname.concat(" ").concat(lastname);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
				selenium.type("lastName", "Last Name");

				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);

				selenium.scrollToElement("jobFunctionTitle");
				selenium.clickDynamic("spanTitle", "Job Function", "end");
				selenium.waitForElementToBeClickable("JobFunctionChooseButton");
				selenium.click("JobFunctionChooseButton");
//				selenium.waitingTime(2000);
//				
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(9000);
				selenium.captureScreenShot();
				
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
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
	
	@Then("^verify duplicate notification$")
    public void verify_duplicate_notification() {
		try {
			selenium.waitingTime(3000);
			boolean duplicate = selenium.isElementPresentFast("okToAddDuplicate");
			if (duplicate == true) {
				selenium.waitForElementToBeClickable("okToAddDuplicate");
				selenium.click("okToAddDuplicate");
				selenium.waitingTime(3000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);

				if(selenium.getElement("contactDuplicateNotification").isDisplayed()) {
					System.out.println("inside pass");
					selenium.test.log(LogStatus.PASS, "Duplicate Notification displayed");
						
				}
				selenium.waitForElementToBeClickable("loginPopUp");
				selenium.click("loginPopUp");
				selenium.waitingTime(3000);
			}

			else {
				selenium.test.log(LogStatus.FAIL, "Duplicate Notification Not Displayed");
				selenium.reportFailure("Duplicate Notification Not Displayed");
				
			}

		}
		catch (Exception e) {
			selenium.reportFailure(e.getMessage());
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
	
}
