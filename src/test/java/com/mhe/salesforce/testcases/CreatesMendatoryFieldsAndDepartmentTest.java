package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreatesMendatoryFieldsAndDepartmentTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^Creates Mendatory Fields Department$")
	public void creates_Mendatory_Fields_Department() {
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
				selenium.type("lastName", "Last Name");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchAccounts");
				selenium.jsClick("searchAccounts");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdown("searchAccounts", "Name");
				selenium.waitingTime(2000);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				
				//selenium.type("emailCXG", "Email");
				//selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.jsClick("search_Departments");
				selenium.autoSuggestiveDropdownOne("search_Departments","Department Name");
				selenium.waitingTime(3000);
				if(selenium.isElementPresentFast("DepartmentNameSelectionFromWindow")) {
					selenium.waitForElementToBeClickable("DepartmentNameSelectionFromWindow");
					selenium.jsClick("DepartmentNameSelectionFromWindow");
					selenium.waitingTime(3000);
					
				}
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				
				selenium.waitingTime(3000);
				boolean  error1=selenium.isElementPresentFast("ErrorListAll");
		        System.out.println(error1);
		        if(error1==true) {
		               System.out.println("Error came");
//		               selenium.waitForElementToBeClickable("closePopUp");
		               selenium.clickLoop("closePopUp");
		               selenium.waitingTime(2000);      
		        selenium.click("CancelButton");    
		        } 
		        
//				if(selenium.isElementPresentFast("CancelButton"))
//				{
//					System.out.println("Add Contact popup did not close. So, clicking on Cancel button.");
//					selenium.jsClick("CancelButton");
//					selenium.test.log(LogStatus.FAIL, "Create New Contact Failed!");
//					selenium.reportFailure("Create New Contact Failed!");
//				}
				
//				selenium.waitForElementToBeVisible("contactSuccessfulL");
//				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");

				/*
				 * selenium.click("newOpportunityBtn"); selenium.click("contactSalutation");
				 * selenium.clickDynamic("anchorTitle", "Salutation", "end");
				 * selenium.type("firstName", "First Name"); selenium.type("lastName",
				 * "Last Name"); selenium.click("contactType");
				 * selenium.clickDynamic("anchorTitle", "Contact Type", "end");
				 * selenium.scrollToElement("serach_Account"); selenium.type("serach_Account",
				 * "Account Name"); selenium.clickDynamic("contactAccountDynamic", "Name",
				 * "end"); selenium.waitingTime(2000); selenium.type("emailText", "Email");
				 * selenium.type("Name_Field", "Department Name");
				 * 
				 * selenium.waitingTime(3000);
				 * 
				 * //selenium.selectFromLookUp("Department Name Lookup", "Department Name"); //
				 * selenium.waitingTime(2000); // selenium.switchToFrame("productframeUat"); //
				 * selenium.isDuplicateOpportunity();
				 * 
				 * selenium.type("Name_Field", "Department Name"); //
				 * selenium.click("deptSearch"); // selenium.click("deptSearchbtn");
				 * selenium.waitingTime(2000); selenium.clickDynamic("contactAccountDynamic",
				 * "Department Name", "end");
				 * 
				 * selenium.waitingTime(2000);
				 * 
				 * selenium.click("save"); flagsuccess =
				 * selenium.isElementPresentFast("contactSuccessfulL");
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean      error=selenium.isElementPresentFast("ErrorListAll");     
            System.out.println(error);
            if(error==true) {
                   System.out.println("Error came");
                   
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);             
                   selenium.click("CancelButton");
            }
            
            else {
                   selenium.click("CancelButton");
            }
            }


		}
	

	@Then("^Validate success message$")
	public void validate_the_CXG_contact_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}
	
	@And("^Contacts Present$")
	public void creates_Mendatory_Fields_Departments() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				
				boolean tPresent=selenium.isElementPresentFast("contactTable");
				selenium.waitForElementToBeClickable("contactTable");
				selenium.clickXpath("contactTable");
				selenium.waitForElementToBeClickable("contactTable");
				selenium.click("contactTable");

			}

		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	
}
}
