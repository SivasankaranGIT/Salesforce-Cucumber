package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CSOMUserCreatesNewContactTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^create new contact by filling mandatory fields$")
	public void create_new_contact_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
//				selenium.waitingTime(6000);
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
				
				//selenium.jsClick("searchAccounts");
				//selenium.autoSuggestiveDrpDownSelectOption("searchAccounts", "Name");
				//selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("serach_Account");
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

				selenium.scrollToElement("jobFunctionTitle");
				selenium.clickDynamic("spanTitle", "Job Function", "end");

				selenium.waitForElementToBeClickable("JobFunctionChooseButton");
				selenium.click("JobFunctionChooseButton");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("save");
				

				selenium.click("save");
				selenium.waitingTime(15000);
				/*selenium.waitForElementToBeVisible("contactSuccessfulL");
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(4000);*/
				
				String contactName = selenium.getTextLoop("contactNameGetText").toString();
				if (contactName.contains(lastName)) {
					selenium.test.log(LogStatus.PASS, "Course name is updated as: " + contactName);
				} else {
					selenium.test.log(LogStatus.FAIL, "Course name is not updated");
					selenium.reportFailure("Course name is not updated");
				}

				selenium.waitingTime(5000);
				
				selenium.contacts=selenium.getURL();
				
			}

		} catch (Exception e) {
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean  error=selenium.isElementPresentFast("ErrorListAll");
            System.out.println(error);
            if(error==true) {
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
	
	@And("^edit any contact and save$")
	public void edit_contact_and_save() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				
				/*String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);
				selenium.jsClick("editButton");
				selenium.waitingTime(2000);
				selenium.scrollToElement("contactType");
				selenium.click("salutation");
				selenium.clickDynamic("anchorTitle", "Salutation", "end");
				selenium.click("save");
				flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");*/
				
				/*selenium.search("Contact Name");
				selenium.waitingTime(2000);
				String Xpath=selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
				selenium.clickLoopXpath(Xpath);*/
				
				selenium.navigateToURL(selenium.contacts);
				selenium.waitingTime(4000);
				selenium.refresh();
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("editButton");
				//selenium.clickLoop("NewOpportunityEditBtn1");
				selenium.clickLoop("editButton");
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("contactSalutation");
				selenium.click("contactSalutation");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Salutation", "end");
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				
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
	
	@Then("^I validate the new contact add success message$")
	public void account_address_creation_should_be_successful() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
	}
	@Then("I create a contact with contact type student")
	public void i_create_a_contact_with_contact_type_student() {
		try {
			selenium.randomString=selenium.getRandomString();
			//	String email=selenium.randomString+"@test.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeVisible("firstName");
//			selenium.typeData("firstName", "Demo");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactTypeStudent");
			selenium.jsClick("ContactTypeStudent");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausDropDown");
			selenium.jsClick("OpptyContactStausDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausOption");
			selenium.jsClick("OpptyContactStausOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the Exclude from MKTO SFDC Sync")
	public void i_verify_the_exclude_from_mkto_sfdc_sync(){
		try{

			selenium.scrollToElement("ExcludeMKTOEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitForElementToBeClickable("ExcludeMKTOEditBtn");
			selenium.jsClick("ExcludeMKTOEditBtn");
			selenium.waitingTime(6000);

			System.out.println(selenium.checkElementIsSelected("MKTOStatusCheckBox"));
			if(selenium.getElement("MKTOStatusCheckBox").isSelected())
			{
				System.out.println("PASS!!!CheckBox is True");
				selenium.test.log(LogStatus.PASS,"CheckBox is True");
			}
			else
			{
				System.out.println("FAIL!!!CheckBox is False");
				selenium.test.log(LogStatus.FAIL,"CheckBox is False");
				selenium.reportFailure("CheckBox is True");
			}
//			Assert.assertTrue(selenium.checkElementIsSelectedorNot("MKTOStatusCheckBox"));

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I create a contact for Fax Field")
	public void i_create_a_contact_for_fax_field() {
		try {
			selenium.randomString=selenium.getRandomString();
			//	String email=selenium.randomString+"@test.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactFaxTextField");
			selenium.typeData("ContactFaxTextField","DUMMY DEMO NAME FOR FAX FIELD");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I create a new contact external related record")
	public void i_create_a_new_contact_external_related_record(){
		try{
			selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
			selenium.typeData("SearchTextBoxClassicMode",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchBtnClassicMode");
			selenium.jsClick("SearchBtnClassicMode");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ClickOnContactFirstRecord");
			selenium.jsClick("ClickOnContactFirstRecord");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ContactExternalRecord");
			selenium.jsClick("ContactExternalRecord");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NewContactExternalBtn");
			selenium.jsClick("NewContactExternalBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NameField");
			selenium.typeData("NameField",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactExternalWebUSASeedTextBox");
			selenium.typeData("ContactExternalWebUSASeedTextBox",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnBottom");
			selenium.jsClick("SaveBtnBottom");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("EditBtnTop");
			if(selenium.isElementPresentFast("EditBtnTop"))
			{
				System.out.println("PASS!!! Contact External Related Record Created Without Error");
				selenium.test.log(LogStatus.PASS,"PASS!!! Contact External Related Record Created Without Error");
			}
			else
			{
				System.out.println("FAIL!!!Contact External Related Record Not Created");
				selenium.test.log(LogStatus.FAIL,"Contact External Related Record Not Created");
				selenium.reportFailure("Contact External Related Record Not Created");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("delete");
			selenium.jsClick("delete");
			selenium.waitingTime(2000);
			selenium.acceptAlert();
			selenium.waitingTime(5000);

		}catch (Exception e) {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.logoutFromAnyUserClassic();
			selenium.test.log(LogStatus.PASS, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}

			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/page/home");
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the From Date and To Date field")
	public void i_verify_the_from_date_and_to_date_field(){
		try{
			selenium.waitingTime(6000);
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeClickable("editHoursBtn");
			selenium.clickLoop("editHoursBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("WeekDayBtn");
//			selenium.jsClick("WeekDayBtn");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("fromTime");
//			selenium.click("fromTime");
			selenium.waitForElementToBeClickable("FromTimeTextBox");
			selenium.typeData("FromTimeTextBox","7:00 AM");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("toTime");
//			selenium.click("toTime");
			selenium.waitForElementToBeClickable("ToTimeTextBox");
			selenium.typeData("ToTimeTextBox","10:00 AM");
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
//			selenium.waitForElementToBeClickable("ToTimeInput");
//			selenium.jsClick("ToTimeInput");
			selenium.waitingTime(2000);
			selenium.scrollToElement("weekday_Monday1");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("addTeachingHrsBtn");
//			selenium.click("addTeachingHrsBtn");
			selenium.waitForElementToBeClickable("weekday_Monday1");
			selenium.click("weekday_Monday1");
			selenium.waitingTime(2000);
			selenium.jsClick("weekday_Monday1");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("AddTeachingHoursBtnNew");
			selenium.jsClick("AddTeachingHoursBtnNew");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Office hours added successfully");
//			selenium.refresh();
//			selenium.waitingTime(8000);
			selenium.scrolldown(-5000);
			selenium.waitForElementToBeVisible("DisplayOfficeHoursGetTextNew");
			String updatedTime=selenium.getText("DisplayOfficeHoursGetTextNew").toString();
			System.out.println(updatedTime);
			if(updatedTime.contains("day"))
			{
				System.out.println("PASS!!! From Time Field and To Time Field is updated");
				selenium.test.log(LogStatus.PASS,"From Time Field and To Time Field is updated");
				selenium.switchOutOfFrame();
			}
			else
			{
				System.out.println("FAIL!!!From Time Field and To Time Field is not updated");
				selenium.test.log(LogStatus.FAIL,"From Time Field and To Time Field is not updated");
				selenium.reportFailure("From Time Field and To Time Field is updated");
			}

		}catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("create a new contact for INTL user")
	public void create_a_new_contact_for_intl_user(){
		try{
			selenium.randomString=selenium.getRandomString();
			String email=selenium.randomString+"@test.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.type_propertiesFile("serach_Account","account_name4");
			selenium.waitingTime(5000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("serach_Account");
//			selenium.waitForElementToBeClickable("ShowAllResults1");
//			selenium.jsClick("ShowAllResults1");
//			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("SelectAccountForIntl");
//			selenium.jsClick("SelectAccountForIntl");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the status price class and department")
	public void i_verify_the_status_price_class_and_dept(){
		try{
			String name=selenium.getRandomString();
			String email=name+"@testdemo.com";
//			selenium.waitForElementToBeVisible("OpptyContactStatus");
//			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase("Active"))
			{
				System.out.println("PASS!!! Contact Status is Active");
				selenium.test.log(LogStatus.PASS,"Contact Status is Active");
			}
			else
			{
				System.out.println("FAIL!!! Contact Status is not Active");
				selenium.test.log(LogStatus.FAIL,"Contact Status is not Active");
				selenium.reportFailure("Contact Status is not Active");
			}
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeVisible("DepartmentNameGetStatus");
//			String departmentName =selenium.getText("DepartmentNameGetStatus").toString();
			selenium.waitForElementToBeVisible("DepartmentNameGetStatusNew");
			String departmentName =selenium.getText("DepartmentNameGetStatusNew").toString();
			System.out.println(departmentName);
			if(departmentName.equalsIgnoreCase("MATHEMATICS & COMPUTER SCIENCE"))
			{
				System.out.println("PASS!!! Department Name is not blank");
				selenium.test.log(LogStatus.PASS,"Department Name is not blank");
			}
			else
			{
				System.out.println("FAIL!!! Department Name is blank");
				selenium.test.log(LogStatus.FAIL,"Department Name is blank");
				selenium.reportFailure("Department Name is blank");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DepartmentEditBtn");
			selenium.jsClick("DepartmentEditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DepartmentNameCrossBtn");
			selenium.jsClick("DepartmentNameCrossBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "Social Science");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentSelect");
			selenium.jsClick("DepartmentSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
//			selenium.waitForElementToBeVisible("DepartmentNameGetStatus");
//			String departmentNameAfterEdit =selenium.getText("DepartmentNameGetStatus").toString();
			selenium.waitForElementToBeVisible("DepartmentNameGetStatusNew");
			String departmentNameAfterEdit =selenium.getText("DepartmentNameGetStatusNew").toString();
			System.out.println(departmentNameAfterEdit);
			if(!departmentName.equalsIgnoreCase(departmentNameAfterEdit))
			{
				System.out.println("PASS!!! Department Name is updated");
				selenium.test.log(LogStatus.PASS,"Department Name is updated");
			}
			else
			{
				System.out.println("FAIL!!! Department Name is not updated");
				selenium.test.log(LogStatus.FAIL,"Department Name is not updated");
				selenium.reportFailure("Department Name is not updated");
			}
			selenium.url=selenium.getURL();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickOnAccountLink");
			selenium.jsClick("ClickOnAccountLink");
			selenium.waitingTime(10000);
			selenium.scrollToElement("PriceClassFieldGetTextNew");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("PriceClassFieldGetText");
//			String priceClassField=selenium.getText("PriceClassFieldGetText").toString();
			selenium.waitForElementToBeClickable("PriceClassFieldGetTextNew");
			String priceClassField=selenium.getText("PriceClassFieldGetTextNew").toString();
			System.out.println(priceClassField);
			if(!priceClassField.equalsIgnoreCase("CA"))
			{
				System.out.println("PASS!!! Price class is not CA");
				selenium.test.log(LogStatus.PASS,"Price class is not CA");
			}
			else
			{
				System.out.println("FAIL!!! Price class is CA");
				selenium.test.log(LogStatus.FAIL,"Price class is CA");
				selenium.reportFailure("Price class is CA");
			}
			selenium.waitingTime(2000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CloneBtnNew");
			selenium.jsClick("CloneBtnNew");
			selenium.waitingTime(10000);
			selenium.scrollToElement("lastName");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.clearText("lastName");
			selenium.waitingTime(1000);
			selenium.typeData("lastName",name);
			selenium.waitingTime(2000);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.clearText("EmailTextBox");
			selenium.waitingTime(1000);
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(25000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("ContactGetTextNew");
			String contactName=selenium.getText("ContactGetTextNew").toString();
			System.out.println("Contact Name From UI is : "+contactName);
			System.out.println("Random String is : "+selenium.randomString);
			if(!contactName.equalsIgnoreCase(selenium.randomString))
			{
				System.out.println("PASS!!! Cloned Successfully");
				selenium.test.log(LogStatus.PASS,"Cloned Successfully");
			}
			else
			{
				System.out.println("FAIL!!! Not Cloned");
				selenium.test.log(LogStatus.FAIL,"Not Cloned");
				selenium.reportFailure("Not Cloned");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("I verify the last updated field")
	public void i_verify_the_last_updated_field(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(10000);
			selenium.scrollToElement("HoursLastUpdateElement");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("HoursLastUpdatedDateGetText");
			String lastUpdatedDate=selenium.getText("HoursLastUpdatedDateGetText").toString();
			System.out.println("Last Updated Date is : "+lastUpdatedDate);
			if(lastUpdatedDate.contains("202"))
			{
				System.out.println("PASS!!! Last Updated Date Is Present");
				selenium.test.log(LogStatus.PASS,"Last Updated Date Is Present");
			}
			else
			{
				System.out.println("FAIL!!! Last Updated Date Is Not Present");
				selenium.test.log(LogStatus.FAIL,"Last Updated Date Is Not Present");
				selenium.reportFailure("Last Updated Date Is Not Present");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editHoursBtn");
			selenium.clickLoop("editHoursBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("HoursLastUpdatedDateGetText1");
			String lastUpdatedDateMaintenance=selenium.getText("HoursLastUpdatedDateGetText1").toString();
			System.out.println("Last Updated Date is : "+lastUpdatedDateMaintenance);
			if(lastUpdatedDateMaintenance.contains("202"))
			{
				System.out.println("PASS!!! Last Updated Date Is Present");
				selenium.test.log(LogStatus.PASS,"Last Updated Date Is Present");
			}
			else
			{
				System.out.println("FAIL!!! Last Updated Date Is Not Present");
				selenium.test.log(LogStatus.FAIL,"Last Updated Date Is Not Present");
				selenium.reportFailure("Last Updated Date Is Not Present");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("create a contact with sdr lead source field")
	public void create_a_contact_with_sdr_lead_source_field(){
		try{
			selenium.randomString=selenium.getRandomString();
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.scrollToElement("JobFunctionChooseButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("JobFunctionOptionNew");
			selenium.jsClick("JobFunctionOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("JobFunctionChooseButton");
			selenium.click("JobFunctionChooseButton");
			selenium.waitingTime(2000);
			selenium.scrollToElement("SDRLeadSourceField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SDRLeadSourceField");
			selenium.click("SDRLeadSourceField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SDRLeadSourceValue");
			selenium.jsClick("SDRLeadSourceValue");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify that validation is triggered or not")
	public void verify_that_validation_is_triggered_or_not(){
		try{
			selenium.waitForElementToBeVisible("snagerror");
			String snagError=selenium.getText("snagerror").toString();
			selenium.waitingTime(2000);
			if(snagError.equalsIgnoreCase("We hit a snag."))
			{
				System.out.println("PASS!!!Error Message Found");
				selenium.test.log(LogStatus.PASS,"Error Message Found");
			}
			else
			{
				System.out.println("FAIL!!!Error Message Not Found");
				selenium.test.log(LogStatus.FAIL,"Error Message Not Found");
				selenium.reportFailure("Error Message Not Found");
			}

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("create a contact for ALEKS user")
	public void create_a_contact_for_ALEKS_user(){
		try{
			selenium.randomString=selenium.getRandomString();
			String email=selenium.randomString+"@test.com";
			
			selenium.refresh();
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausDropDown");
			selenium.jsClick("OpptyContactStausDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactInactiveOption");
			selenium.jsClick("ContactInactiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InactiveReasonField");
			selenium.jsClick("InactiveReasonField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InactiveReasonOptionNew");
			selenium.jsClick("InactiveReasonOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ALEKSAccountSupportDropDown");
			selenium.waitingTime(5000);
			selenium.typeData("ALEKSAccountSupportDropDown", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AlternateEmailTextBox");
			selenium.typeData("AlternateEmailTextBox","test@test.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify the contact status")
	public void verify_the_contact_status(){
		try{
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase("Pending"))
			{
				System.out.println("PASS!!! Contact Status is Pending");
				selenium.test.log(LogStatus.PASS,"Contact Status is Pending");
			}
			else
			{
				System.out.println("FAIL!!! Contact Status is not Pending");
				selenium.test.log(LogStatus.FAIL,"Contact Status is not Pending");
				selenium.reportFailure("Contact Status is not Pending");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("InactiveReasonGetText");
			String inactiveReason=selenium.getText("InactiveReasonGetText").toString();
			System.out.println(inactiveReason);
			if(inactiveReason.equalsIgnoreCase("") || inactiveReason.isBlank())
			{
				System.out.println("PASS!!! Inactive Reason is Blank");
				selenium.test.log(LogStatus.PASS,"Inactive Reason is Blank");
			}
			else
			{
				System.out.println("FAIL!!! Inactive Reason is not Blank");
				selenium.test.log(LogStatus.FAIL,"Inactive Reason is not Blank");
				selenium.reportFailure("Inactive Reason is not Blank");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.scrollToElement("EditContactBtn");
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(2000);
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.click("EditContactBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.jsClick("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactActiveOption");
			selenium.click("ContactActiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("snagerror");
			String snagError=selenium.getText("snagerror").toString();
			if(snagError.equalsIgnoreCase("We hit a snag."))
			{
				System.out.println("PASS!!!Error Message Found");
				selenium.test.log(LogStatus.PASS,"Error Message Found");
			}
			else
			{
				System.out.println("FAIL!!!Error Message Not Found");
				selenium.test.log(LogStatus.FAIL,"Error Message Not Found");
				selenium.reportFailure("Error Message Not Found");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.jsClick("CancelButton");
			selenium.waitingTime(2000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("create a contact for CXG Lightning Console")
	public void create_a_contact_for_cxg_lightning_console(){
		try {
			selenium.randomString=selenium.getRandomString();
			String email=selenium.randomString+"@test.com";
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.click("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactType_Option");
			selenium.jsClick("ContactType_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyContactStausDropDown");
			selenium.jsClick("OpptyContactStausDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactInactiveOption");
			selenium.jsClick("ContactInactiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InactiveReasonField");
			selenium.jsClick("InactiveReasonField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("InactiveReasonOptionNew");
			selenium.jsClick("InactiveReasonOptionNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", "STANFORD UNIVERSITY");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DepartmentNameSelect");
			selenium.jsClick("DepartmentNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("EmailTextBox");
			selenium.typeData("EmailTextBox",email);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AlternateEmailTextBox");
			selenium.typeData("AlternateEmailTextBox","test@test.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
	@Then("verify the contact status for ALEKS")
	public void verify_the_contact_status_for_aleks(){
		try{
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatus=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatus);
			if(contactStatus.equalsIgnoreCase("Pending")||contactStatus.equalsIgnoreCase("Inactive"))
			{
				System.out.println("PASS!!! Contact Status is Pending/Inactive");
				selenium.test.log(LogStatus.PASS,"Contact Status is Pending/Inactive");
			}
			else
			{
				System.out.println("FAIL!!! Contact Status is not Pending/Inactive");
				selenium.test.log(LogStatus.FAIL,"Contact Status is not Pending/Inactive");
				selenium.reportFailure("Contact Status is not Pending/Inactive");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.click("EditContactBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ContactStatusField");
			selenium.jsClick("ContactStatusField");
			selenium.waitForElementToBeClickable("ContactActiveOption");
			selenium.click("ContactActiveOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("OpptyContactStatus");
			String contactStatusAfterEdit=selenium.getText("OpptyContactStatus").toString();
			System.out.println(contactStatusAfterEdit);
			if(contactStatusAfterEdit.equalsIgnoreCase("Active"))
			{
				System.out.println("PASS!!! Contact Status Is Changes Successfully");
				selenium.test.log(LogStatus.PASS,"Contact Status Is Changes Successfully");
			}
			else
			{
				System.out.println("FAIL!!! Contact Status is not changed");
				selenium.test.log(LogStatus.FAIL,"Contact Status is not changed");
				selenium.reportFailure("Contact Status is not changed");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed" + e.getMessage());
		}
	}
}
