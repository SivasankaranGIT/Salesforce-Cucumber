package com.mhe.salesforce.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cases_VerifySupportAccountForStudent {
	WebConnector selenium = WebConnector.getInstance();
	@When("^I search for contacts$")
    public void i_search_for_contacts()  {
		try {
				 
	    selenium.waitingTime(5000);
	    selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Contact");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("contactsOptionMenuDots");
		selenium.jsClick("contactsOptionMenuDots");
		selenium.waitingTime(3000);
		
	
	}
	 catch (Exception e) {
		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to contacts " + e.getMessage());
		}

}
	
	
	 @Then("^create a new contact for ALEKS user$")
	    public void create_a_new_contact_for_aleks_user() {
		
		 try {
			 selenium.waitForElementToBeClickable("NewButtonToAdd");
			 selenium.jsClick("NewButtonToAdd");
//			 selenium.waitingTime(8000);
			 selenium.waitForElementToBeVisible("firstName");
			 String firstName= selenium.getRandomString();
	            selenium.getElement("firstName").sendKeys(firstName);
//	            selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("lastName");
	            
	            String lastName= selenium.getRandomString();
	            selenium.getElement("lastName").sendKeys(lastName);
//	            selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactSalutation");
				
				selenium.click("contactSalutation");
				selenium.clickDynamic("spanTitle", "Salutation", "end");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("contactTypeDropdown");
				selenium.click("contactTypeDropdown");
				selenium.clickDynamic("spanTitle", "Contact Type", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("contactStatusDropdown");
				selenium.scrollToElement("contactStatusDropdown");
			   selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("contactStatusDropdown");
				selenium.click("contactStatusDropdown");
				selenium.clickDynamic("spanTitle", "Contact Status", "end");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchAccounts");
				selenium.jsClick("searchAccounts");
				selenium.waitingTime(2000);
				
				selenium.type("searchAccounts", "Account Name");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("accountDropdownList");
				selenium.click("accountDropdownList");
				
				//selenium.autoSuggestiveDropdownWithoutText("searchAccounts");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("newContactSupportAccountSearch");
				selenium.jsClick("newContactSupportAccountSearch");
				selenium.waitingTime(2000);
				selenium.type("newContactSupportAccountSearch", "Support Account");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("supportAccountDropdownList1");
				selenium.click("supportAccountDropdownList1");
			//	selenium.autoSuggestiveDrpDownSelectOption("newContactSupportAccountSearch", "Support Account");
				selenium.waitingTime(2000);
				
				 String email= selenium.getRandomString();
				 String address = "@mhedu.com";
				 String emailAddress = email+address;
		            selenium.getElement("emailCXG").sendKeys(emailAddress);
//		            selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("saveButton");
				
				selenium.click("saveButton");
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("contactSuccessfulL");
				boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
				System.out.println("success message" + contact);
				
				 if(contact == true) {
					 selenium.test.log(LogStatus.INFO, "Contact created successfully" );
				 }	
				 
					if(selenium.isElementPresentFast("CancelButton"))
					{
						System.out.println("Add Contact popup did not close. So, clicking on Cancel button.");
						selenium.jsClick("CancelButton");
						selenium.test.log(LogStatus.FAIL, "Create New Contact Failed!");
						selenium.reportFailure("Create New Contact Failed!");
					}
				
		 }
				
		 catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error occurred " + e.getMessage());
			 	selenium.waitingTime(3000);
	            System.out.println("Error catch");
	            
	            boolean duplicate = selenium.isElementPresentFast("DuplidateRecordValidation");
				 System.out.println(duplicate);
				 boolean  error=selenium.isElementPresentFast("ErrorListAll"); 
		            System.out.println(error);
				 if(duplicate==true) {
					 System.out.println("inside duplicate");
					 selenium.click("DuplidateRecordValidation");
					 selenium.waitingTime(3000);
					 selenium.click("openDuplicateContact");
					 selenium.waitingTime(3000);
					 selenium.test.log(LogStatus.INFO, "Duplicate Contact exists" );
				} 
				 
		            else if(error==true ) {
	                   System.out.println("Error came");
	                   selenium.jsClick("closePopUp");
	                   selenium.waitingTime(2000);            
	                   selenium.click("CancelButton");
	            }
		            else {
		            	System.out.println("inside Else");
					 selenium.reportFailure(e.getMessage());
		            	 selenium.click("CancelButton");
		            }
		 		}

		 
	 }
		 
	 
	 
	 @Then("^click on New case$")
	    public void click_on_new_case() {

		 try {
			 System.out.println("inside new case");
//			 selenium.waitingTime(9000);
			 selenium.waitForElementToBeClickable("newCase");
			 selenium.jsClick("newCase");
			 selenium.waitingTime(5000);
			 
		 }
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigation to new case" + e.getMessage());
			}
	 }
	 
	 @And("^fill all mandatory details to create case$")
	    public void fill_all_mandatory_details_to_create_case() {
		 
		 try {
			 selenium.waitingTime(3000);				
				
			 if(selenium.getElement("Case_OriginDropDown").isDisplayed()){
				 System.out.println("inside first");
				 selenium.waitForElementToBeClickable("Case_OriginDropDown");
				 selenium.scrollToElement("Case_OriginDropDown");
//			 selenium.jsClick("Case_OriginDropDown");
//			 selenium.waitingTime(3000);
//			 selenium.waitForElementToBeClickable("caseOriginOptionNew");
//			 selenium.dropdownListClick("caseOriginOptionNew");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("InquiryType1New");
			 selenium.jsClick("InquiryType1New");
			 selenium.waitForElementToBeClickable("caseCXGProductOption2New");
			 selenium.dropdownListClick("caseCXGProductOption2New");
			 selenium.waitingTime(2000);
			 }
			 else  if(selenium.getElement("caseOriginDropdown2").isDisplayed()){
				 System.out.println("inside second");
				 selenium.waitForElementToBeClickable("caseOriginDropdown2");
				 selenium.jsClick("caseOriginDropdown2");
				 selenium.waitForElementToBeClickable("caseOriginOption");
				 selenium.dropdownListClick("caseOriginOption");
				 selenium.waitingTime(2000);
				 }
			 
			 if(selenium.getElement("productDropDwn1").isDisplayed()){
				 System.out.println("inside first");
				 selenium.waitForElementToBeClickable("productDropDwn1");
			 selenium.jsClick("productDropDwn1");
			 selenium.waitForElementToBeClickable("ProductType_ALEKS");
			 selenium.dropdownListClick("ProductType_ALEKS");
			 selenium.waitingTime(2000);
			 }
			 else  if(selenium.getElement("caseCXGProductDropdown2").isDisplayed()){
				 System.out.println("inside second");
				 selenium.waitForElementToBeClickable("caseCXGProductDropdown2");
				 selenium.jsClick("caseCXGProductDropdown2");
				 selenium.waitForElementToBeClickable("caseCXGProductOption");
				 selenium.dropdownListClick("caseCXGProductOption");
				 selenium.waitingTime(2000);
				 }
			 
			 if(selenium.getElement("ReasonDDList").isDisplayed()){
			 selenium.waitForElementToBeClickable("ReasonDDList");	 
			 selenium.jsClick("ReasonDDList");
			 selenium.waitForElementToBeClickable("ALEKSCasereasonOptionNew");
			 selenium.dropdownListClick("ALEKSCasereasonOptionNew");
			 selenium.waitingTime(2000);
			 }
			 else  if(selenium.getElement("ALEKSCaseReason2").isDisplayed()){
				 selenium.waitForElementToBeClickable("ALEKSCaseReason2");
				 selenium.jsClick("ALEKSCaseReason2");
				 selenium.waitForElementToBeClickable("ALEKSCasereasonOption");
				 selenium.dropdownListClick("ALEKSCasereasonOption");
				 selenium.waitingTime(2000);
				 }
			 
			 
			 if(selenium.getElement("Subject_field").isDisplayed()) {
//				 selenium.waitForElementToBeClickable("Subject_field");
//				 selenium.click("Subject_field");
//				 selenium.waitingTime(2000);
				 selenium.type("Subject_field", "Subject");
				 selenium.waitingTime(2000);
				 }
				 
				 else if(selenium.getElement("caseCXGSubject2").isDisplayed()) {
					 selenium.waitForElementToBeClickable("caseCXGSubject2");
					 selenium.click("caseCXGSubject2");
					 selenium.waitingTime(2000);
					 selenium.type("caseCXGSubject2", "Subject");
					 selenium.waitingTime(2000);
					 }
				 
			 
			 if(selenium.getElement("caseCXGInternalDescriptionNew").isDisplayed()) {
//				 selenium.waitForElementToBeClickable("caseCXGInternalDescriptionNew");
//				 selenium.click("caseCXGInternalDescriptionNew");
//				 selenium.waitingTime(2000);
				 selenium.type("caseCXGInternalDescriptionNew", "Internal Description");
				 selenium.waitingTime(2000);
				 }
				 else if(selenium.getElement("caseCXGInternalDescription2").isDisplayed()) {
					 selenium.waitForElementToBeClickable("caseCXGInternalDescription2");
					 selenium.click("caseCXGInternalDescription2");
					 selenium.waitingTime(2000);
					 selenium.type("caseCXGInternalDescription2", "Internal Description");
					 selenium.waitingTime(2000);
					 }
			 
			 selenium.moveTab("caseCXGInternalDescriptionNew");
			 selenium.waitForElementToBeClickable("saveButton");
			 selenium.clickLoop("saveButton");
			 selenium.waitingTime(20000);
			 selenium.captureScreenShot();
//			 selenium.waitForElementToBeVisible("contactSuccessfulL");
//			 if(selenium.isElementPresentFast("contactSuccessfulL")) {
//			 selenium.test.log(LogStatus.PASS, "Case created successfully" );
//			 
//		 }
//			 
//			 else {
//				 selenium.test.log(LogStatus.FAIL, "Case not created" );
//			 	 selenium.reportFailure("Case not created");
//			 }
			 
			 
		 }
		 catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error occurred " + e.getMessage());
			 	selenium.waitingTime(3000);
	            System.out.println("Error catch");
	            
	            boolean duplicate = selenium.isElementPresentFast("DuplidateRecordValidation");
				 System.out.println(duplicate);
				 boolean  error=selenium.isElementPresentFast("ErrorListAll"); 
		            System.out.println(error);
				 if(duplicate==true) {
					 System.out.println("inside duplicate");
					 selenium.click("DuplidateRecordValidation");
					 selenium.waitingTime(3000);
					 selenium.click("openDuplicateContact");
					 selenium.waitingTime(3000);
					 selenium.test.log(LogStatus.INFO, "Duplicate Contact exists" );
				} 
				 
		            else if(error==true ) {
	                   System.out.println("Error came");
	                   selenium.jsClick("closePopUp");
	                   selenium.waitingTime(2000);            
	                   selenium.click("CancelButton");
	            }
		            else {
		            	System.out.println("inside Else");
		            	 selenium.click("CancelButton");
		            }
		 		}
		 
	 }

	 
	 
	 
//	 @Then("^Verify account name and Support account for Student$")
//	    public void verify_account_name_and_support_account_for_student() {
//		 try {
//			 selenium.waitForElementToBeVisible("ALEKSSupportAccount_new");
//			 
//			 String supportaccountname = selenium.getElement("ALEKSSupportAccount_new").getAttribute("innerHTML");
//		 String expected_supportname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Actual Support Account");
//				System.out.println("support account name is" + supportaccountname);
//			 String accountname = selenium.getElement("ALEKSAccountname").getAttribute("innerHTML");
//			 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Actual Account Name");
//			 System.out.println("account name is" + accountname);
//			 selenium.test.log(LogStatus.INFO, "Account Name : "+accountname +" ..Expected Name :  "+expected_name);
//			 selenium.test.log(LogStatus.INFO, "Support Account Name : "+supportaccountname +" ..Expected Support account Name :  "+expected_supportname);
//			 if ((accountname.equalsIgnoreCase(expected_name)) & (supportaccountname.equalsIgnoreCase(expected_supportname))) {
//					 System.out.println("inside pass");
//					selenium.test.log(LogStatus.PASS, "Account and support account verified successfully");
//					
//				}
//				
//				else
//				{
//					 System.out.println("inside fail");
//					selenium.test.log(LogStatus.FAIL, "Account and support account name not proper " );
//					selenium.reportFailure("Account and support account name not proper");
//				}
//				
//				selenium.captureScreenShot();
//		 }
//		 catch (Exception e) {
//			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				selenium.reportFailure("Error while verifying support account " + e.getMessage());
//			}
//	 }
	 
}
