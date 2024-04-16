package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifyContact {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^I switch from CXG Lightining Console App to Sales App$")
	public void And_I_switch_from_CXG_Lightining_Console_App_to_Sales_App() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitingTime(5000);
				if (selenium.isElementPresentFast("CXGApp"))
				{
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.getElement("searchItemsTextField").sendKeys("Sales");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Saleslightningapp");
					selenium.jsClick("Saleslightningapp");
					selenium.waitingTime(4000);
				}
			}
		}
		catch (Exception e) {
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^I enter mandatory fields and save$")
	public void And_I_enter_mandatory_fields_and_save() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.type("firstName", "First Name");
				selenium.waitingTime(2000);
				//selenium.type("lastName", "Last Name");	
				
				String lastName= selenium.getRandomString();
				selenium.getElement("lastName").sendKeys(lastName);
				selenium.waitingTime(2000);
				
				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
			    selenium.waitingTime(5000);
			    selenium.scrollToElement("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(5000);		
//				selenium.type("search_Departments", "Department Name");
				selenium.autoSuggestiveDropdownOne("search_Departments", "Department Name");
//				selenium.waitingTime(2000);
//				selenium.waitForElementToBeClickable("resultDropDwn");
//				selenium.click("resultDropDwn");
				selenium.waitingTime(6000);
				//selenium.scrollToElement("search_Departments");
			   String Department = selenium.getDynamicXpath("searchDepartment", "Department Name", "end");
				selenium.waitingTime(4000);
			   selenium.clickLoopXpath(Department);
			   selenium.waitingTime(2000);	
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

	@Then("^Validate Contact details$")
	public void Validate_Contact_details() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}



	@And("^I edit details$")
	public void I_edit_details() {
		try {

			if (selenium.getUI().contains("Lightning")) {

//				selenium.search("Contact Name");
//				selenium.waitingTime(2000);
//				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
//				selenium.waitingTime(4000);
//				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.clickLoop("editButton");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptNameLabel");
				selenium.scrollToElement("deptNameLabel");
				//String Xpath2 = selenium.getDynamicXpath("deptNameDynamic", "Department Name", "endDeleteIcon");
				//selenium.getXpathElement(Xpath2).click();
				if(selenium.isElementPresentFast("deptDeleteIcon"))
				{
				selenium.waitForElementToBeClickable("deptDeleteIcon");
				selenium.click("deptDeleteIcon");
				}
				selenium.waitingTime(2000);

			}

		} catch (Exception e) {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("ErrorListAll");
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("CancelButton");
				selenium.click("CancelButton");
			}

			else {
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}


	@Then("^Verify error message$")
	public void Verify_error_message() {
		try {

			selenium.waitingTime(2000);
			String error = null;
			String expected_error = null;
			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptRemoveErrorGetText");
				selenium.scrollToElement("deptRemoveErrorGetText");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("deptRemoveErrorGetText");
				error = selenium.getTextLoop("deptRemoveErrorGetText");
				expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
				selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
				if (error.contains(expected_error)) {
					selenium.click("CancelEdit");
					selenium.test.log(LogStatus.PASS, "Test Case Passed!");
					System.out.println("PASS");
				} else {
					selenium.click("CancelEdit");
					selenium.reportFailure("Test Case Failed");
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					System.out.println("FAIL");
				}
			}

		} catch (Exception e) {
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("ErrorListAll");
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("CancelButton");
				selenium.click("CancelButton");
			}

			else {
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}

	}

}



