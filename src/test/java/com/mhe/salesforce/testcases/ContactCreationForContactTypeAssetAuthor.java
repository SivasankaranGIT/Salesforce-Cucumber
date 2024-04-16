package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactCreationForContactTypeAssetAuthor {
WebConnector selenium = WebConnector.getInstance();

boolean flagsuccess;
String userFullName = null;

@When("^I click Admin user Contacts to create new contact$")
public void I_click_admin_user_Contacts_to_create_new_contact() throws InterruptedException {
	try {
	
	//selenium.waitingTime(7000);
	//selenium.click("accountTabClick");
		
	//selenium.clickHeader(objectRepoElement);
	
    selenium.waitingTime(5000);
    selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "New Contact");
//	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("contactsOptionMenuDots");
	selenium.jsClick("contactsOptionMenuDots");
	selenium.waitingTime(5000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error while clicking on Admin user Contacts " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	}
	
}

@When("^I click Contacts to create new contact$")
public void I_click_Contacts_to_create_new_contact() throws InterruptedException {
	try {
	
	//selenium.waitingTime(7000);
	//selenium.click("accountTabClick");
		
	//selenium.clickHeader(objectRepoElement);
	
    selenium.waitingTime(5000);
    selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "New Contact");
//	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("contactsOptionMenuDots");
	selenium.jsClick("contactsOptionMenuDots");
	selenium.waitingTime(5000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error while clicking on contacts " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	}
	
}

@When("^I click to create new Accounts$")
public void I_click_to_create_new_Accounts() throws InterruptedException {
	try {
	
	//selenium.waitingTime(7000);
	//selenium.click("accountTabClick");
		
	//selenium.clickHeader(objectRepoElement);
	
    selenium.waitingTime(5000);
    selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "New Accounts");
//	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("contactsOptionMenuDots");
	selenium.jsClick("contactsOptionMenuDots");
	selenium.waitingTime(5000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	}
	
}

@When("^I click Admin user Contacts to create new department$")
public void I_click_admin_user_Contacts_to_create_new_department() throws InterruptedException {
	try {
	
	//selenium.waitingTime(7000);
	//selenium.click("accountTabClick");
		
	//selenium.clickHeader(objectRepoElement);
	
    selenium.waitingTime(5000);
    selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "New Contact");
	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("departmantsOptionMenuDots");
	selenium.jsClick("departmantsOptionMenuDots");
	selenium.waitingTime(5000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error occurred " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	}
	
}
@When("^User to search and do Opportunity related validation$")
public void User_to_search_and_do_Opportunity_related_validation() throws InterruptedException {
	try {
	
	//selenium.waitingTime(7000);
	//selenium.click("accountTabClick");
		
	//selenium.clickHeader(objectRepoElement);
	
    selenium.waitingTime(5000);
    selenium.waitForElementToBeClickable("menuDots");
	selenium.click("menuDots");
	selenium.waitingTime(3000);
	selenium.waitForElementToBeVisible("searchItemsTextField");
	selenium.type("searchItemsTextField", "New Contact");
//	selenium.waitingTime(2000);
	selenium.waitForElementToBeClickable("OpportunityClick");
	selenium.jsClick("OpportunityClick");
	selenium.waitingTime(5000);
	}
	catch (Exception e)
	{
		selenium.reportFailure("Error occurred " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	}
	
}

@And("^I enter and save all the department details$")
public void I_enter_and_save_all_the_department_details() throws InterruptedException {
	try {
	if (selenium.getUI().equalsIgnoreCase("lightning")) {

		selenium.waitingTime(2000);
		String department_Code = selenium.getRandomString();
		System.out.println("departmentCode is :" + department_Code);
		selenium.waitForElementToBeClickable("NewBtn");
		selenium.jsClick("NewBtn");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("Name_Field");
		selenium.type("Name_Field", "Department Name");
		selenium.waitForElementToBeVisible("departmentCode");
		selenium.typeData("departmentCode",department_Code);
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("Save_Btn");
		selenium.jsClick("Save_Btn");
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("Save_Btn"))
		{
			selenium.jsClick("Save_Btn");
		}
		selenium.waitingTime(4000);
		if(selenium.isElementPresentFast("Deletepopup2"))
		{
			selenium.waitForElementToBeClickable("Deletepopup2");
			selenium.click("Deletepopup2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deletedepartmentconfirm");
			selenium.click("deletedepartmentconfirm");
			selenium.test.log(LogStatus.PASS, "Department creation success!");
		}
		else
		{
			selenium.test.log(LogStatus.FAIL, "Department creation failed");
			selenium.reportFailure("Department creation failed");
		}
	}
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
	}
}



@And("^I enter and save all the Contact details$")
public void I_enter_and_save_all_the_Address_details() throws InterruptedException {
	try{
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
		selenium.waitForElementToBeClickable("NewButtonToAdd");
		selenium.jsClick("NewButtonToAdd");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("firstName");
		
		String firstName= selenium.getRandomString();
        selenium.getElement("firstName").sendKeys(firstName);
//        selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("lastName");
        
        String lastName= selenium.getRandomString();
        selenium.getElement("lastName").sendKeys(lastName);
		selenium.waitingTime(2000);
		
//		selenium.type("firstName", "First Name");
//		selenium.type("lastName", "Last Name");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("contactSalutation");
		selenium.click("contactSalutation");
		selenium.clickDynamic("spanTitle", "Salutation", "end");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("contactTypeBtnNew");
		selenium.jsClick("contactTypeBtnNew");
		selenium.clickDynamic("spanTitle", "Contact Type1", "end");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("searchAccounts");
		selenium.jsClick("searchAccounts");
		selenium.waitingTime(4000);
		selenium.type("searchAccounts", "Account Name");
//		selenium.waitingTime(3000);
//		selenium.waitForElementToBeClickable("accountAutosuggestiveOption");
//		selenium.jsClick("accountAutosuggestiveOption");
		selenium.autoSuggestiveDropdownWithoutTextTwo("searchAccounts");
//		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("search_Departments");
//		selenium.jsClick("search_Departments");
//		selenium.waitingTime(2000);
//		selenium.autoSuggestiveDropdown("search_Departments","Department Name");
		selenium.waitForElementToBeClickable("search_Departments");
		selenium.typeData("search_Departments","Math");
		selenium.waitingTime(4000);
		selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("saveButton");
		selenium.click("saveButton");
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("ErrorListAll");
		 boolean  error=selenium.isElementPresentFast("ErrorListAll");
	        System.out.println(error);
	        if(error==true) {
	        selenium.click("CloseErrorDialogPopup") ;       
		validate_error_message_for_Active_Asset_Author();
	        }
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("contactTypeBtnNew");
		selenium.scrollToElement("contactTypeBtnNew");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactTypeBtnNew");
		selenium.click("contactTypeBtnNew");
		selenium.waitingTime(2000);
		selenium.clickDynamic("spanTitle", "Contact Type2", "end");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("saveButton");
		selenium.click("saveButton");
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		
//		if(selenium.isElementPresentFast("CancelButton"))
//		{
//			System.out.println("Add Address popup did not close. So, clicking on Cancel button.");
//			selenium.jsClick("CancelButton");
//			selenium.test.log(LogStatus.FAIL, "Create New address Failed!");
//			selenium.reportFailure("Create New address Failed!");
//		}
		
		}
	}
		
	 catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.waitingTime(3000);
            System.out.println("Error catch");
        
			 boolean  error=selenium.isElementPresentFast("ErrorListAll"); 
	            System.out.println(error);
			
			 
	         if(error==true ) {
                   System.out.println("Error came");
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);            
                   selenium.click("CancelButton");
                   selenium.reportFailure("Error while navigation to new case" + e.getMessage());
            }
	            else {
	            	System.out.println("inside Else");
	            	 selenium.click("CancelButton");
	            	 selenium.reportFailure("Error while navigation to new case" + e.getMessage());
	            }
	 		}

	}


@And("^I enter and save all the Contact details DepartmentValidation$")
public void I_enter_and_save_all_the_Address_details_DepartmentValidation() throws InterruptedException {
	try {
		if (selenium.getUI().contains("Lightning")) {
			
			
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("firstName");
			selenium.type("firstName", "First Name");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("lastName");
			selenium.type("lastName", "Last Name");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactSalutation");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation", "end");
			
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("contactTypeDropdown");
			selenium.scrollToElement("contactTypeDropdown");
			selenium.waitForElementToBeClickable("contactTypeDropdown");
			selenium.click("contactTypeDropdown");
			selenium.waitingTime(2000);		
			selenium.clickDynamic("spanTitle", "Contact Type", "end");
			
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("contactStatusDropdown");
			selenium.scrollToElement("contactStatusDropdown");	
			selenium.waitForElementToBeClickable("contactStatusDropdown");
			selenium.click("contactStatusDropdown");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Contact Status", "end");
			
			
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchAccounts");
			selenium.scrollToElement("searchAccounts");
			selenium.waitForElementToBeClickable("searchAccounts");
			selenium.jsClick("searchAccounts");
			selenium.type("searchAccounts", "Account Name");
			selenium.autoSuggestiveDropdownWithoutText1("searchAccounts");
			selenium.waitingTime(2000);
			selenium.scrollToElement("search_Departments");
			selenium.waitForElementToBeClickable("search_Departments");
			selenium.jsClick("search_Departments");
			selenium.type("search_Departments", "Department Name2");
			selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
			selenium.waitingTime(3000);
			if(selenium.isElementPresentFast("DepartmentNameSelectionFromWindow")) {
				selenium.waitForElementToBeClickable("DepartmentNameSelectionFromWindow");
				selenium.jsClick("DepartmentNameSelectionFromWindow");
				selenium.waitingTime(3000);
				
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("save");
			selenium.click("save");
			selenium.waitingTime(3000);
			boolean  error1=selenium.isElementPresentFast("ErrorListAll");
	        System.out.println(error1);
	        if(error1==true) {
	               System.out.println("Error came");
	   
	               selenium.clickLoop("closePopUp");
	               selenium.waitingTime(2000);      
	        selenium.click("CancelButton");    
	        } 
			

	/*		selenium.click("newOpportunityBtn");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation", "end");
			selenium.type("firstName", "First Name");
			selenium.waitingTime(2000);
			selenium.type("lastName", "Last Name");
			selenium.waitingTime(2000);
			selenium.jsClick("searchAccounts");
			selenium.autoSuggestiveDropdown("searchAccounts", "Name");
			selenium.waitingTime(2000);
			selenium.waitingTime(2000);
			selenium.click("contactTypeDropdown");
			selenium.clickDynamic("spanTitle", "Contact Type", "end");
			selenium.waitingTime(2000);
			
			//selenium.type("emailCXG", "Email");
			//selenium.waitingTime(2000);
			selenium.jsClick("search_Departments");
			selenium.autoSuggestiveDropdownOne("search_Departments","Department Name");
			selenium.waitingTime(3000);

			selenium.click("save");
			
			selenium.waitForElementToBeVisible("contactSuccessfulL");
			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			
			*/
		}

	} catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
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


@And("^I enter and save all the Contact details Validation$")
public void I_enter_and_save_all_the_Address_details_Validation() {
	
	try {
	if (selenium.getUI().equalsIgnoreCase("lightning")) {
		String FirstName = Integer.toString(selenium.getRandomNumber());
		System.out.println("First name random text is : " + FirstName);
		String LastName = Integer.toString(selenium.getRandomNumber());
		System.out.println("Last name random text is : " + LastName);
		String JobFunction = "Assistant Director";
		selenium.waitForElementToBeClickable("NewButtonToAdd");
		selenium.jsClick("NewButtonToAdd");		
		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("firstName");
		selenium.typeData("firstName", FirstName);
		selenium.typeData("lastName", LastName);
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("searchAccounts2");
		selenium.jsClick("searchAccounts2");
		selenium.autoSuggestiveDropdownWithoutText1("searchAccounts2");
		selenium.waitingTime(2000);
		/*selenium.waitForElementToBeClickable("search_Departments");
		selenium.jsClick("search_Departments");
		selenium.waitingTime(2000);
		selenium.type_propertiesFile("search_Departments", "Name_Field");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
		selenium.clickLoop("showAllResultsFromDropDwn");
		selenium.waitingTime(6000);
		String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Name_Field", "end");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(deptsearch);
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("contactTypeDropdown2");
		selenium.jsClick("contactTypeDropdown2");
		selenium.waitingTime(2000);
        selenium.autoSuggestiveDropdownWithoutText2("contactTypeDropdown2");*/

		selenium.scrollToElement("jobFunctionTitle");
		selenium.clickDynamicData("spanTitle",JobFunction , "end");
		selenium.waitForElementToBeClickable("JobFunctionChooseButton");
		selenium.click("JobFunctionChooseButton");

        selenium.waitForElementToBeClickable("save");
		selenium.click("save");
		selenium.waitingTime(15000);
		selenium.MHES_Contact_URL = selenium.getURL();
		System.out.println("selenium.MHES_Contact_URL" + selenium.MHES_Contact_URL);
		}
	
	}catch (Exception e){	
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
		}
	  }	


@And("^I enter and save all the Contact details Inactive$")
public void I_enter_and_save_all_the_Address_details_Inactive() throws InterruptedException {
	
	try {
	if (selenium.getUI().equalsIgnoreCase("lightning")) {

		selenium.waitForElementToBeClickable("NewButtonToAdd");
		selenium.jsClick("NewButtonToAdd");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("firstName");
		selenium.type("firstName", "First Name");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("lastName");
		selenium.type("lastName", "Last Name");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactSalutation");
		selenium.click("contactSalutation");
		selenium.waitingTime(2000);
		selenium.clickDynamic("spanTitle", "Salutation", "end");
		
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("contactTypeDropdown");
		selenium.scrollToElement("contactTypeDropdown");
		selenium.waitForElementToBeClickable("contactTypeDropdown");
		selenium.click("contactTypeDropdown");
		selenium.waitingTime(2000);		
		selenium.clickDynamic("spanTitle", "Contact Type1", "end");
		
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("contactStatusDropdown");
		selenium.scrollToElement("contactStatusDropdown");	
		selenium.waitForElementToBeClickable("contactStatusDropdown");
		selenium.click("contactStatusDropdown");
		selenium.waitingTime(2000);
		selenium.clickDynamic("spanTitle", "Contact Status", "end");
		
		
		
		selenium.waitingTime(2000);
//		selenium.waitForElementToBeVisible("searchAccounts");
		selenium.scrollToElement("searchAccounts");
		selenium.waitForElementToBeClickable("searchAccounts");
		selenium.jsClick("searchAccounts");
		selenium.type("searchAccounts", "Account name Contact");
		selenium.waitingTime(2000);
		selenium.autoSuggestiveDropdownWithoutText1("searchAccounts");
		selenium.waitingTime(5000);
		if(selenium.isElementPresentFast("valueSelectionfromNewContactAccount")) {
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("valueSelectionfromNewContactAccount");
			selenium.waitForElementToBeClickable("valueSelectionfromNewContactAccount");
			selenium.clickLoop("valueSelectionfromNewContactAccount");
		}
		
		
		
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("search_Departments");
		selenium.jsClick("search_Departments");
		selenium.type("search_Departments", "Department Name");
		selenium.autoSuggestiveDropdownWithoutTextTwo("search_Departments");
		selenium.waitingTime(5000);
		if(selenium.isElementPresentFast("opportunitydeptClickforValueSelect")) {
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("opportunitydeptClickforValueSelect");
			selenium.clickLoop("opportunitydeptClickforValueSelect");
		}
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("save");
		selenium.click("save");
		selenium.waitingTime(5000);
		
		boolean  error1=selenium.isElementPresentFast("ErrorListAll");
        System.out.println(error1);
        if(error1==true) {
               System.out.println("Error came");
   
               selenium.clickLoop("closePopUp");
//               selenium.waitingTime(2000);    
       		selenium.waitForElementToBeVisible("contactTypeDropdown");
        selenium.scrollToElement("contactTypeDropdown");    
        } 
//		selenium.waitingTime(2000);		
   		selenium.waitForElementToBeVisible("NewContactinactiveError");
			
		String error = selenium.getText("NewContactinactiveError");
		System.out.println(error);
		String expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		System.out.println(expected_error);	
		selenium.waitingTime(2000);
		if(error.equalsIgnoreCase(expected_error)) {
			System.out.println("Error matching");
			selenium.waitingTime(2000);
			selenium.clickLoop("CancelButton");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		}else {
			System.out.println("Error not same");
			selenium.waitingTime(2000);
			selenium.clickLoop("CancelButton");
		}
		
		
		
	/*	selenium.selectDropdown("salutation", "Salutation");
		selenium.waitingTime(3000);
		selenium.type("firstName", "First Name");
		selenium.type("lastName", "Last Name"); */
		
	/*	selenium.waitingTime(3000);
		selenium.selectDropdown("contactType", "Contact Type1");
		selenium.waitingTime(3000);
//		selenium.selectDropdown("contactType", "Contact Type"); */
		
		
		
//		selenium.selectDropdown("accountsContactsStatus", "Contact Status");
//		selenium.waitingTime(3000);
//		selenium.selectDropdown("accountContactInactivereason", "Inactive reason");
/*		selenium.waitingTime(2000);
		
		selenium.jsClick("searchAccounts");
		selenium.autoSuggestiveDropdownWithoutText("searchAccounts");
		selenium.waitingTime(2000);
		selenium.jsClick("Name_Field");
		selenium.autoSuggestiveDropdown("Name_Field","Department Name");*/
	/*	selenium.click("save");
		validate_error_message_for_Active_Asset_Author();
		selenium.waitingTime(3000);
		selenium.selectDropdown("contactType", "Contact Type2");
		selenium.waitingTime(3000);*/
		
		
		
		
	}
} catch(Exception e) {
	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	selenium.reportFailure("Error occurred " + e.getMessage());
	System.out.println("Inside Error Catch");
	selenium.click("CancelButton");
	
          }
}
	



public void validate_error_message_for_Active_Asset_Author() {
	try{selenium.waitingTime(2000);
	String error = null;
	String expected_error=null;
	if (selenium.getUI().contains("Lightning")) {
		error = selenium.getText("errormsgContactType");
	expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
	System.out.println("error is"+error +expected_error );
	selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
	if(error.contains(expected_error)) {
		selenium.test.log(LogStatus.PASS, "Active asset author scenario Passed!");
		selenium.waitingTime(4000);
		
	}
	
	else {
		selenium.test.log(LogStatus.FAIL, "Active asset author scenario Failed");
		selenium.reportFailure("Active asset author scenario Failed");
		
	}
	}
	}
	 catch (Exception e) {
			
	            	 selenium.click("CancelButton");
	            	 selenium.reportFailure("Error while navigation to new case" + e.getMessage());
	            	 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	            }
	 		}
	
	

	@Then("^Validate error message$")
	public void validate_error_message() {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		selenium.waitForElementToBeVisible("errormsgContactType");
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("errormsgContactType");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
		if(error.contains(expected_error)) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			selenium.waitingTime(4000);
			
		}
		else {
			selenium.click("CancelEdit");
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
		}
		}
		
}
	@Then("^Validate error message inactive$")
	public void validate_error_message_inactive() {
		try {
		selenium.waitingTime(2000);
		String error = null;
		String expected_error=null;
		if (selenium.getUI().contains("Lightning")) {
			error = selenium.getText("ErrorMsg");
		expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
		selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
		if(error.contains(expected_error)) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
			selenium.waitingTime(4000);
			
		}
		else {
			selenium.click("CancelEdit");
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		
}

	@Then("^add new contact \"([^\"]*)\"$")
	public void add_new_contact(String accountName)
	{
		try
		{
			String UserLastName = Integer.toString(selenium.getRandomNumber());
			System.out.println("User Last name random text is : " + UserLastName);
			String EmailID = UserLastName+"@MHEducation.com";
			System.out.println("EmailID random text is : " + EmailID);

			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(8000);
//			selenium.waitForElementToBeClickable("contactTypeBtnNew");
//			selenium.scrollToElement("contactTypeBtnNew");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.clickDynamic_propertiesFile("spanTitle", "Contact_Type", "end");
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeVisible("search_Departments");
			selenium.scrollToElement("search_Departments");
			selenium.waitingTime(2000);
			selenium.jsClick("search_Departments");
			selenium.type_propertiesFile("search_Departments", "Department_Name1");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.clickLoop("showAllResultsFromDropDwn");
			//selenium.pressEnter("search_Departments");
			selenium.waitingTime(6000);
			String deptsearch = selenium.getDynamicXpath_propertiesFile("searchDepartment", "Department_Name1", "end");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(deptsearch);
			selenium.waitingTime(6000);

			selenium.waitForElementToBeVisible("firstName");
			selenium.type_propertiesFile("firstName", "FirstName");				
			selenium.waitForElementToBeVisible("lastName");
			selenium.typeData("lastName", UserLastName);

			selenium.waitingTime(2000);
			userFullName = selenium.getPropertiesFileData("FirstName")+ " " +UserLastName;
			System.out.println("userFullName is :" + userFullName);
			selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("emailCXG");
			selenium.typeData("emailCXG", EmailID);
			selenium.waitingTime(2000);
			System.out.println(accountName);
			selenium.waitForElementToBeVisible("serach_Account");
			selenium.scrollToElement("serach_Account");
			selenium.waitingTime(2000);
			selenium.jsClick("serach_Account");
			//selenium.waitForElementToBeClickable("serach_Account");
			selenium.typeData("serach_Account", accountName);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			//selenium.jsClick("showAllResultsFromDropDwn");
			selenium.clickLoop("showAllResultsFromDropDwn");
			//selenium.pressEnter("serach_Account");
			selenium.waitingTime(6000);
			String accountsearch = selenium.getDynamicXpathData("anchorTextcontains", accountName, "endContains");
			System.out.println("Account selected: "+accountsearch);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(accountsearch);		
			selenium.waitingTime(6000);

			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");

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
			
			selenium.INTLNewContact=selenium.getURL();
			System.out.println("Newly created INTL contact URL is :" + selenium.INTLNewContact);
			selenium.waitingTime(6000);
			
//			WebConnector.CONTACT_NAME_RANDOM = selenium.getText("INTLContactFullName");
//			System.out.println("The newly created contact full name is :" + WebConnector.CONTACT_NAME_RANDOM);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding new contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding new contact");
		}
		
	}

	@Then("^add contact address with country as \"([^\"]*)\" and city as \"([^\"]*)\"$")
	public void add_contact_address(String country, String city)
	{
		try
		{
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038H00000HeT3EQAV/view");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
//			if (selenium.isElementPresentFast("showAllLinks"))
//			{
//				selenium.click("showAllLinks");
//				selenium.waitForElementToBeClickable("addressLink_new");
//				selenium.click("addressLink_new");
//			}
//			else
//			{
				selenium.waitForElementToBeClickable("addressLink_new");
				selenium.click("addressLink_new");
//			}
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");

			selenium.waitingTime(8000);
			String addressName = selenium.getRandomString();
			selenium.getElement("Name_Field").sendKeys(addressName);
			System.out.println("addressName is :" + addressName);

			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("addressTypeDropDwn1");			
			selenium.click("addressTypeDropDwn1");
			selenium.waitingTime(2000);
//			selenium.click("addressTypeDropDwn1");
//			selenium.waitingTime(4000);
			System.out.println("Clicked on addressTypeDropDwn1");
			selenium.clickDynamic_propertiesFile("spanTitle", "AddressType", "end");
			//String Address=selenium.getDynamicXpath_propertiesFile("spanTitle", "AddressType", "end");
			//selenium.jsClickXpath(selenium.getDynamicXpath_propertiesFile("spanTitle", "AddressType", "end"));
			System.out.println("Selected the addressTypeDropDwn1 value as Office");
			selenium.waitingTime(4000);
			selenium.scrollToElement("addressStatusDropDwn1");
			selenium.waitForElementToBeClickable("addressStatusDropDwn1");
			selenium.click("addressStatusDropDwn1");
			selenium.waitingTime(4000);
			//selenium.jsClick("addressStatusDropDwn1");
			//selenium.waitingTime(4000);
			System.out.println("Clicked on addressStatusDropDwn1");
			selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Address Status", "end"));
			selenium.waitingTime(4000);
			System.out.println("Clicking on country dropdown in contactCreation class");
			selenium.waitForElementToBeClickable("countryDrpDown1");
			selenium.scrollToElement("countryDrpDown1");
			selenium.waitingTime(2000);
			selenium.scrolldown(-150);
			selenium.waitingTime(2000);
			selenium.jsClick("countryDrpDown1");
			System.out.println("Country Name:" +country);
			selenium.waitingTime(4000);
			selenium.clickDynamicData("spanTitle", country, "end");
			selenium.waitingTime(2000);
			System.out.println("India is selected as country");

			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("street1Address");			
			selenium.type_propertiesFile("street1Address", "Street1");
			selenium.type_propertiesFile("street2Address", "Street2");
			selenium.type_propertiesFile("street3Address", "Street3");
			selenium.type_propertiesFile("street4Address", "Street4");
			selenium.typeData("cityAddress", city);
			selenium.type_propertiesFile("postalCodeAddress", "PostalCode");
			selenium.type_propertiesFile("stateName", "State");

			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			System.out.println("Contact Address added successfully!");
			selenium.test.log(LogStatus.INFO, "Contact Address added successfully!");
			selenium.refresh();
			selenium.waitingTime(6000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding new contact address " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding new contact address");
		}
		
	}

	@Then("^update product type to print$")
	public void update_product_type_to_print()
	{
		try
		{
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("ProductsRecentListActionBtn");
			selenium.click("ProductsRecentListActionBtn");
			selenium.waitForElementToBeClickable("editL");
			selenium.click("editL");
			selenium.waitingTime(6000);
			
			if(selenium.isElementPresentFast("ProductDigTypeChkBoxEnabled"))
			{
				System.out.println("Digital Product Intl is checked for this product.. so unchecking it..");
				selenium.jsClick("ProductDigTypeChkBoxEnabled");
				selenium.waitingTime(1000);
				selenium.click("RecordSaveButton");
				selenium.waitingTime(6000);
			}
			else
			{
				System.out.println("Digital Product Intl checkbox is already unchecked.. so clicking on cancel button");
				selenium.click("opportunityAccountsEditCancel");
				selenium.waitingTime(5000);
			}
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while updating the product type " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while updating the product type");
		}
		
	}

	@And("^create new sample$")
	public void create_new_sample()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.selectFromLookUp2("Contact Name Lookup", "Contact Name");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SampleISBN");
			selenium.type("SampleISBN", "ISBN");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.click("SelectFirstProductChkBox");
			selenium.click("Addtosampleandcontinue");
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("createsampleorder");
			selenium.click("createsampleorder");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Duplicate"))
			{
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
				selenium.waitingTime(8000);
			}
			
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

			if(selenium.isElementPresentFast("NewBtn"))
			{
				selenium.test.log(LogStatus.PASS, "INTL User with Employee Number is able to create Sample successfully!");
				System.out.println("PASS");
//				selenium.captureScreenShot();
			}
		 	else
		 	{
				selenium.test.log(LogStatus.FAIL, "INTL User with Employee Number is UNable to create Sample!");
				selenium.reportFailure("INTL User with Employee Number is UNable to create Sample!");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while creating new sample " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating new sample");
		}
		
	}

	@And("^create new sample record$")
	public void create_new_sample_record()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(20000);
			//selenium.refresh();
			//selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.selectFromLookUpDynamicValue("Contact Name Lookup", userFullName);
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SampleISBN");
			selenium.type_propertiesFile("SampleISBN", "ISBN");
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.click("SelectFirstProductChkBox");
			selenium.waitingTime(3000);
			selenium.click("Addtosampleandcontinue");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.pressEscapeKey();
			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("createsampleorder");
			selenium.click("createsampleorder");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Duplicate"))
			{
				selenium.waitForElementToBeClickable("yestoall");
				selenium.click("yestoall");
				selenium.waitingTime(8000);
			}
			
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);

			if(selenium.isElementPresentFast("NewBtn"))
			{
				selenium.test.log(LogStatus.PASS, "INTL User with Employee Number is able to create Sample successfully!");
				System.out.println("PASS");
//				selenium.captureScreenShot();
			}
		 	else
		 	{
				selenium.test.log(LogStatus.FAIL, "INTL User with Employee Number is UNable to create Sample!");
				selenium.reportFailure("INTL User with Employee Number is UNable to create Sample!");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while creating new sample " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating new sample");
		}
		
	}

	
	@And("^create new sample and verify rep code validation$")
	public void create_new_sample_and_verify_rep_code_validation()
	{
		try
		{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.selectFromLookUp2_propertiesFile("Contact Name Lookup", "FirstName");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SampleISBN");
			selenium.type_propertiesFile("SampleISBN", "ISBN");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchProduct");
			selenium.click("SearchProduct");
			selenium.waitingTime(5000);
			selenium.click("SelectFirstProductChkBox");
			selenium.waitForElementToBeClickable("Addtosampleandcontinue");
			selenium.click("Addtosampleandcontinue");
			selenium.waitingTime(5000);
//			selenium.pressEscapeKey();
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");		
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("CreateSampleOrderButton");
			System.out.println("CreateSampleOrderButton present and clickable..");
			selenium.jsClick("CreateSampleOrderButton");
			String validationMessage = selenium.getDynamicXpath_propertiesFile("divTextcontains1", "RepcodeValidationMessage", "endContains");
			selenium.waitingTime(4000);
			System.out.println(validationMessage);
			if(selenium.isElementPresentXpathFast(validationMessage))
			{
				selenium.test.log(LogStatus.PASS, "<b> For INTL Sales rep user belongs to India (IN) with no emp number, the rep code validation message appeared with correct Sales OP Manager email ID. </b>");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
		 	else
		 	{
				selenium.test.log(LogStatus.FAIL, "<b> Error while verifying Rep Code validation message </b>");
				selenium.reportFailure("<b> Error while verifying Rep Code validation message </b>");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying Rep Code validation message " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying Rep Code validation messag");
		}
		
	}
}


