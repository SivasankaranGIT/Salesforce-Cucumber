package com.mhe.salesforce.testcases;

//import org.w3c.dom.html.HTMLIsIndexElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateEditLinkContactToCaseAndAccountTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String caseNumber;

	@And("^create new contact for Customer service agent$")
	public void create_new_contact_for_Customer_service_agent() {
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

				String lastName = selenium.getRandomString();
				selenium.getElement("lastName").sendKeys(lastName);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactStatusDropdown");
				selenium.scrollToElement("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");

				selenium.type("serach_Account", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
				selenium.click("showAllResultsFromDropDwn");
				selenium.waitingTime(6000);
				String accountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name", "end");
//				selenium.waitForXpathElementToBeClickable(accountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(accountsearch);
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("search_Departments");
				
				
				selenium.jsClick("search_Departments");
				selenium.waitingTime(6000);
				selenium.autoSuggestiveDrpDownSelectOption("search_Departments", "Department Name");
				selenium.waitingTime(6000);

				selenium.waitingTime(2000);
				String mail="@mhe.com";
				String id=lastName.concat(mail);
				System.out.println("MailId: " +id);
				//selenium.type("emailCXG", "Email");
				selenium.getElement("emailCXG").sendKeys(id);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");

				selenium.click("save");
				
				/*flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);*/

				selenium.waitingTime(5000);

				// concatenation first and last name

			}

		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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

	@Then("^I edit contact that is newly created$")
	public void edit_fields() {
		try {

			/*
			 * String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "Contact Name",
			 * "endContains"); selenium.clickLoopXpath(Xpath); selenium.waitingTime(4000);
			 */
			selenium.waitingTime(5000);
			if(!selenium.isElementPresentFast("editButton"))
			{
				selenium.refresh();
				selenium.waitingTime(12000);
				selenium.checkFlowInterruptedPopup();
			}

			selenium.waitForElementToBeClickable("editButton");
			selenium.clickLoop("editButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactSalutation");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation New", "end");
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			/*flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);*/
			selenium.waitingTime(8000);

		} catch (Exception e) {
		selenium.reportFailure(e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
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

	@Then("^I create a new case for the contact$")
	public void create_new_case() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("newCase");
			selenium.jsClick("newCase");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("Case_OriginDropDown");
//			selenium.scrollToElement("Case_OriginDropDown");
//			selenium.click("Case_OriginDropDown");
//			String caseOrigin = selenium.getDynamicXpath("spanTitle", "Case Origin", "end");
//			selenium.clickXpath(caseOrigin);

//			selenium.jsClick("InquiryType2");
//			selenium.waitForElementToBeVisible("caseCXGProductOption2");
//			selenium.dropdownListClick("caseCXGProductOption2");
//			selenium.waitingTime(2000);

			/*selenium.scrollToElement("productDropDwn1");
			selenium.click("productDropDwn1");
			String product = selenium.getDynamicXpath("spanTitle", "Product", "end");
//			selenium.waitForXpathElementToBeClickable(product);
			selenium.waitingTime(4000);
			selenium.clickXpath(product);*/

			/*selenium.scrollToElement("incident_option");
			selenium.click("incident_option");
			String incident = selenium.getDynamicXpath("spanTitle", "Incident", "end");
//			selenium.waitForXpathElementToBeClickable(incident);
			selenium.waitingTime(4000);
			selenium.clickXpath(incident);
*/
			// selenium.scrollToElement("caseSubIncidentDrpDwn");
			/*selenium.click("caseSubIncidentDrpDwnNew");
			String subIncident = selenium.getDynamicXpath("spanTitle", "Sub Incident", "end");
//			selenium.waitForXpathElementToBeClickable(subIncident);
			selenium.waitingTime(4000);
			selenium.clickXpath(subIncident);*/
			
			//String headerText=selenium.getTextLoop("contactInfoHeaderCase");
			
			
			/*selenium.scrollToElement("contactInfoHeaderCase");
			String xpathIcon= selenium.getDynamicXpath("Text_Span", "Account Name", "supportAccntDeleteIconEnd");
			System.out.println("xpathIcon is : " + xpathIcon);
			if(selenium.isElementPresentXpathFast(xpathIcon)==false) {*/
			if(!selenium.isElementPresentFast("CaseAccountNamePrefilled")) {
				selenium.type("serach_Account", "Account Name");
				selenium.click("ShowAllResults");
				selenium.waitingTime(6000);
				String supportaccountsearch = selenium.getDynamicXpath("accountSearchSample", "Account Name",
						"end");
//				selenium.waitForXpathElementToBeClickable(supportaccountsearch);
				System.out.println("supportaccountsearch is :" + supportaccountsearch);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(supportaccountsearch);
				
			}
			selenium.captureScreenShot();

			/*selenium.scrollToElement("caseBUDrpDwnNew");
			selenium.click("caseBUDrpDwnNew");
			String bu = selenium.getDynamicXpath("spanTitle", "BU", "end");
//			selenium.waitForXpathElementToBeClickable(bu);
			selenium.waitingTime(4000);
			selenium.clickXpath(bu);*/

			selenium.type("Subject_field", "Subject");
//			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeVisible("caseCXGInternalDescriptionNew");*/

			/*selenium.scrollToElement("caseCXGInternalDescriptionNew");
			// selenium.click("caseCXGInternalDescription");
			// selenium.waitingTime(2000);
			selenium.type("caseCXGInternalDescriptionNew", "Internal Description");*/
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("save");

			selenium.click("save");

			selenium.waitingTime(2000);
			
			flagsuccess = selenium.isElementPresentFast("cassenumber");
			caseNumber = selenium.getTextLoop("cassenumber");
//			selenium.waitingTime(5000);
			
			/*String contactsearch = selenium.getDynamicXpath("contactNameFromCaseDynamic", "First Name", "endContains");
			selenium.clickLoopXpath(contactsearch);
			selenium.waitingTime(6000);*/
			selenium.waitForElementToBeClickable("contactNameLinkCase");
			selenium.jsClick("contactNameLinkCase");
			selenium.waitingTime(6000);
			
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.jsClick("closeBtn");
				selenium.waitForElementToBeVisible("casesLink");
				selenium.clickLoop("casesLink");
			} else {
				selenium.waitForElementToBeVisible("casesLink");
				selenium.clickLoop("casesLink");
			}
			
			//selenium.click("casesLink");
			selenium.waitingTime(3000);
			
			String caseRecord = selenium.getDynamicXpathProperty("anchorTitlecontains", caseNumber, "endContains");
//			selenium.waitForXpathElementToBeClickable(caseRecord);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(caseRecord);
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Case creation successful for the contact");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
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
