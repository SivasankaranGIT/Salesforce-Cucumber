package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Street4DepartmentNameTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String deptName;
	String lastName;
	String ActURL = null;

	@When("^I create contact for account with new department$")
	public void create_contact_for_account_with_new_department() {
		try {
			if (selenium.getUI().contains("Lightning")) {

				ActURL = selenium.getURL();
				
				selenium.waitingTime(4000);

				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("accountContacts1");
					selenium.click("accountContacts1");
				} else {
					selenium.waitForElementToBeClickable("accountContacts1");
					selenium.click("accountContacts1");
				}
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.click("NewActionButton");
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeVisible("firstName");
				selenium.type("firstName", "First Name");
//				selenium.waitingTime(2000);

				lastName = selenium.getRandomString();
				selenium.waitForElementToBeVisible("lastName");
				selenium.getElement("lastName").sendKeys(lastName);
//				selenium.waitingTime(2000);

//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactTypeDropdown");
				selenium.scrollToElement("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("search_Departments");
				selenium.scrollToElement("search_Departments");
				selenium.jsClick("search_Departments");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("newDeptCreateOption");
				selenium.jsClick("newDeptCreateOption");
				selenium.waitingTime(3000);
				String deptCode = selenium.getRandomString();
				deptName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Department Name");
				selenium.type("Name_Field", "Department Name");
				selenium.waitForElementToBeVisible("departmentCode");
				selenium.typeData("departmentCode",deptCode);
				selenium.waitForElementToBeClickable("newDeptSaveBtn");
				selenium.click("newDeptSaveBtn");
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(20000);
				selenium.test.log(LogStatus.PASS, "Contact successfully saved");

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

	@And("^verify street4 under account addresses$")
	public void verify_street4_under_account_addresses() {
		try {
			if (selenium.getUI().contains("Lightning")) {
//				selenium.navigateToURL(selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account URL"));
				selenium.navigateToURL(ActURL);
				selenium.waitingTime(8000);
				selenium.refresh();
				selenium.waitingTime(8000);

				if (selenium.isElementPresentFast("closeBtn")) {
					selenium.waitForElementToBeClickable("closeBtn");
					selenium.click("closeBtn");
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.jsClick("addressLink_new");
				} else {
					selenium.waitForElementToBeClickable("addressLink_new");
					selenium.jsClick("addressLink_new");
				}
				selenium.waitingTime(12000);
				selenium.waitForElementToBeClickable("objectFilterBtn");
				selenium.jsClick("objectFilterBtn");
				selenium.waitingTime(5000);
				selenium.scrollToElement("deptNameFilter");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("deptNameFilter");
				selenium.getElement("deptNameFilter").sendKeys(deptName);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Button");
				selenium.jsClick("Save_Button");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("closeFilterBtn");
				selenium.jsClick("closeFilterBtn");
				selenium.waitingTime(4000);

//				String Xpath1 = selenium.getDynamicXpathProperty("anchorTitlecontains", deptName, "endContains");
//				selenium.clickLoopXpath(Xpath1);
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("FirstTableRecord");
				selenium.jsClick("FirstTableRecord");
				selenium.waitingTime(8000);

				String street4 = selenium.getText("street4GetText1").toString();
				if (street4.equalsIgnoreCase(deptName)) {
					selenium.test.log(LogStatus.PASS,
							"Test Case Passed! Street 4 auto populated with the new department name");

				} else {
					selenium.test.log(LogStatus.FAIL, "Street 4 was not auto populated with new department name");
					selenium.reportFailure("Test Case Failed");
				}

			}

		} catch (Exception e) {

			selenium.captureScreenShot();
			selenium.test.log(LogStatus.FAIL, "Could not fetch value for Street 4");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("^delete newly created department$")
	public void delete_newly_created_department() {
		try {
			selenium.clickDynamic("Text_Span", "Department Name", "end");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.jsClick("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.jsClick("deleteBtn");
			selenium.waitingTime(15000);
//			selenium.waitForElementToBeVisible("contactSuccessfulL");
//			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
//			selenium.printLastTestResult(flagsuccess);

			selenium.test.log(LogStatus.PASS, "Record deleted successfully");

		} catch (Exception e) {
			System.out.println("FAIL");
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.FAIL, "Could not delete record");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("^delete newly created contact$")
	public void delete_newly_created_contact() {
		try {
			
//			selenium.navigateToURL(selenium.getValueByColumnName("Contact URL"));
//			selenium.waitingTime(6000);
			
			selenium.navigateToURL(ActURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("accountContacts1");
			selenium.jsClick("accountContacts1");
			selenium.waitingTime(5000);

			if(selenium.isElementPresentFast("objectFilterBtn"))
			{
				selenium.waitForElementToBeClickable("objectFilterBtn");
				selenium.jsClick("objectFilterBtn");				
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("objectFilterBtn");
				selenium.jsClick("objectFilterBtn");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastNameFilter");
			selenium.getElement("lastNameFilter").sendKeys(lastName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("closeFilterBtn");
			selenium.jsClick("closeFilterBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("showAction01");
			selenium.click("showAction01");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(15000);
			/*selenium.waitForElementToBeVisible("contactSuccessfulL");
			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);*/
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Record deleted successfully");

		} catch (Exception e) {
			
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.FAIL, "Could not delete record");
			System.out.println("FAIL");
			selenium.reportFailure("Test Case Failed");
		}
	}
}
