package com.mhe.salesforce.testcases;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CaseNSSView {

	WebConnector selenium = WebConnector.getInstance();
	
	@And("^choose NSS list view$")
    public void choose_nss_list_view()  {
		try {
		selenium.waitForElementToBeClickable("newCaseReq1");
		selenium.click("newCaseReq1");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("newCaseReq2");
		selenium.click("newCaseReq2");
		selenium.waitingTime(3000);
//		selenium.type("newCaseReq2", "List View");
//		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("listViewFilterResult2");
//		selenium.click("listViewFilterResult2");
		selenium.autoSuggestiveDropdownOne("newCaseReq2", "List View");
		selenium.waitingTime(9000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while choosing NSS list view" + e.getMessage());
			}

	}
	
	@Then("^select case from results$")
    public void select_case_from_results()  {
		try {
		
		selenium.waitForElementToBeVisible("nssViewcaseList");
		if(selenium.getElement("nssViewcaseList").isDisplayed()) {
			System.out.println("list results present");
			selenium.test.log(LogStatus.PASS, "NSS View cases present");

		} else {
			System.out.println("list results not present");
			selenium.test.log(LogStatus.FAIL, "NSS View cases not present");
			selenium.reportFailure("NSS View cases not present");
		}
		
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.refresh();
		selenium.waitingTime(6000);
		selenium.click("nssViewcase");
		selenium.waitingTime(5000);
		
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while choosing list view result for opportunity" + e.getMessage());
			
			}

	}
	
	@And("^edit existing case details$")
    public void edit_existing_case_details() {
		try {
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("caseEditPriority");
		selenium.jsClick("caseEditPriority");
		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("caseEditPriorityDropdown1");
		selenium.jsClick("caseEditPriorityDropdown1");
		selenium.waitingTime(3000);
		selenium.clickDynamic("spanTitle", "Priority", "end");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("caseDTSCloseProductDropdown");
		selenium.jsClick("caseDTSCloseProductDropdown");
		selenium.waitingTime(3000);
		selenium.clickDynamic("spanTitle", "Product", "end");
		selenium.waitingTime(2000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("saveButton");
		selenium.jsClick("saveButton");
		selenium.waitingTime(9000);
	
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while editing case" + e.getMessage());
			
			}

	}
	
	@Then("^verify edited case details$")
    public void verify_edited_case_details()  {
		try {
		
		selenium.waitForElementToBeVisible("caseEditPriority");
		selenium.scrollToElement("parentCaseField");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("priorityStatusAfterEdit");
		
		String priority = selenium.getText("priorityStatusAfterEdit").toString();
		String expected_priority = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Priority");
		System.out.println("status" +priority + expected_priority );
		if (priority.equalsIgnoreCase(expected_priority)) {
			System.out.println("inside pass");
			selenium.test.log(LogStatus.PASS, "Existing Case edited successfully");

		} else {
			System.out.println("inside fail");
			selenium.test.log(LogStatus.FAIL, "Existing Case editing failed");
			selenium.reportFailure("Existing Case editing failed");

		}
		
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while verifying case details" + e.getMessage());
			
			}

	}
	
	@And("^fill all mandatory details to create new case with reason code$")
    public void fill_all_mandatory_details_to_create_new_case_with_reason_code() {
	 
	 try {
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("Search_contact");
		 selenium.jsClick("Search_contact");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeVisible("Search_contact");
		 selenium.type("Search_contact", "Contact Name");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("ShowAllResults");
		 selenium.jsClick("ShowAllResults");
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("firstContactNameLink");
		 selenium.jsClick("firstContactNameLink");
		 selenium.waitingTime(2000);
		 System.out.println("Added Contact Name");

		 selenium.waitForElementToBeClickable("contactTypeBtnNew");
		 selenium.jsClick("contactTypeBtnNew");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Contact Type", "end");
		 selenium.waitingTime(2000);
		 System.out.println("Added Contact type");

		 selenium.waitForElementToBeClickable("newCaseSupportAccount_new2");
		 selenium.jsClick("newCaseSupportAccount_new2");
		 selenium.waitingTime(2000);
		 selenium.type("newCaseSupportAccount_new2", "Support Account");
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("ShowAllResults");
		 selenium.clickLoop("ShowAllResults");
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("firstContactNameLink");
		 selenium.jsClick("firstContactNameLink");
		 selenium.waitingTime(2000);
		 System.out.println("Added Support account name");
		 
		 selenium.waitForElementToBeClickable("BusinessHoursField");
		 selenium.jsClick("BusinessHoursField");
		 selenium.waitingTime(2000);
		 selenium.type("BusinessHoursField", "Business Hours");
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("ShowAllResults");
		 selenium.clickLoop("ShowAllResults");
		 selenium.waitingTime(3000);
		 selenium.waitForElementToBeClickable("firstContactNameLink");
		 selenium.jsClick("firstContactNameLink");
		 selenium.waitingTime(2000);
		 System.out.println("Added Business Hours");

		 selenium.waitForElementToBeClickable("Case_OriginDropDown");
		 selenium.jsClick("Case_OriginDropDown");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Case Origin", "end");
		 System.out.println("Added Case origin");

		 selenium.waitingTime(2000);
		 selenium.waitingTime(2000);
		 selenium.scrollToElement("ALEKSProductInfo");
		 selenium.waitForElementToBeClickable("productDropDwn1");
		 selenium.jsClick("productDropDwn1");
		 selenium.waitingTime(5000);
		 selenium.clickDynamic("spanTitle", "Product", "end");
		 selenium.waitingTime(2000);

		 System.out.println("Added Product name");
		 selenium.waitForElementToBeClickable("ReasonDDList");
		 selenium.jsClick("ReasonDDList");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Reason", "end");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("Subject_field");
		 selenium.jsClick("Subject_field");
		 selenium.waitingTime(2000);
		 selenium.type("Subject_field", "Case Subject");
		 selenium.waitingTime(2000);
		 selenium.scrolldown(20);
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("internalDescription");
		 selenium.jsClick("internalDescription");
		 selenium.type("internalDescription", "Internal Description");
		 System.out.println("Added Internal description");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("Save_Btn");
		 selenium.jsClick("Save_Btn");
		 System.out.println("Clicked save button");
		 selenium.waitingTime(10000);

		 selenium.refresh();
		 selenium.waitingTime(8000);
		 selenium.waitForElementToBeClickable("editReason1");
		 selenium.jsClick("editReason1");
		 System.out.println("Clicked edit button");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Reason", "end");
		 System.out.println("Choosen different reason");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason", "end");
		 System.out.println("Choosen different sub-reason");
		 selenium.waitingTime(2000);
		 selenium.test.log(LogStatus.PASS, "ALEKS Case created successfully" );
		 
		 }
	 catch (Exception e) {
			System.out.println("Error while creating new case");
			selenium.reportFailure("Error while creating new case " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			
			}
 }
	
	@Then("^create a new contact for CXG user with reason code$")
    public void create_a_new_contact_for_cxg_user_with_reason_code() {
	 try {
		 selenium.waitForElementToBeClickable("NewButtonToAdd");
		 selenium.jsClick("NewButtonToAdd");
		 selenium.waitingTime(5000);
		 String firstName= selenium.getRandomString();
            selenium.getElement("firstName").sendKeys(firstName);
            selenium.waitingTime(2000);
            
            String lastName= selenium.getRandomString();
            selenium.getElement("lastName").sendKeys(lastName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactSalutation");
			selenium.click("contactSalutation");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Salutation", "end");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("contactTypeDropdown");
			selenium.click("contactTypeDropdown");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Contact Type", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("contactStatusDropdown");
			selenium.jsClick("contactStatusDropdown");
			selenium.waitingTime(2000);
			selenium.clickDynamic("spanTitle", "Contact Status", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchAccounts");
			selenium.jsClick("searchAccounts");
			selenium.waitingTime(4000);
			selenium.type("searchAccounts", "Support Account");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("accountAutosuggestiveOption");
			selenium.jsClick("accountAutosuggestiveOption");
			selenium.waitingTime(2000);
			String email= selenium.getRandomString();
			 String address = "@mhedu.com";
			 String emailAddress = email+address;
	            selenium.getElement("emailCXG").sendKeys(emailAddress);
	            selenium.waitingTime(2000);
	        selenium.waitForElementToBeClickable("search_Departments");
			selenium.jsClick("search_Departments");
			selenium.autoSuggestiveDropdown("search_Departments","Department Name");
			selenium.waitingTime(3000);
	        selenium.waitForElementToBeClickable("saveButton");
			selenium.click("saveButton");
			selenium.waitForElementToBeVisible("contactSuccessfulL");
			boolean contact= selenium.isElementPresentFast("contactSuccessfulL");
			System.out.println("success message" + contact);
			 if(contact == true) {
				 selenium.test.log(LogStatus.INFO, "Contact created successfully" );
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
	            	 selenium.click("CancelButton");
	            }
	 		}
	 
 }
 
// @Then("^Verify Account name and Support account for CXG with reason code$")
//    public void verify_account_name_and_support_account_for_CXG_with_reason_code() {
//	 try {
//		 selenium.waitingTime(5000);
//		 selenium.waitForElementToBeVisible("supportAccntNameGetText");
//		 String supportaccountname = selenium.getTextLoop("supportAccntNameGetText");
//		 String expected_supportname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Actual Account name");
//			System.out.println("support account name is" + supportaccountname);
//			selenium.waitForElementToBeVisible("accountNameCases");
//		 String accountname = selenium.getElement("accountNameCases").getAttribute("innerHTML");
//		 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
//			System.out.println("account name is" + accountname);
//			if ((accountname.equalsIgnoreCase(expected_name)) & (supportaccountname.equalsIgnoreCase(expected_supportname))) {
//				selenium.test.log(LogStatus.PASS, "Account and support account verified successfully");
//				
//			}
//			
//			else
//			{
//				selenium.test.log(LogStatus.FAIL, "Account and support account name not proper " );
//				selenium.reportFailure("Account and support account name not proper");
//			}
//			
//			selenium.captureScreenShot();
//	 }
//	 catch (Exception e) {
//		 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//			selenium.reportFailure("Error while verifying account name and support account " + e.getMessage());
//		}
// }

 @Then ("^I will edit the required fields to verify priority$")
 public void i_will_edit_the_required_fields_to_verify_priority() {	
 	
 	try {
 	 selenium.waitForElementToBeClickable("reasonBtn");
 	 selenium.jsClick("reasonBtn");
 	 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason2", "end");
		 System.out.println("Choosen different reason2");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason2", "end");
		 System.out.println("Choosen different sub-reason2");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason3", "end");
		 System.out.println("Choosen different reason3");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason3", "end");
		 System.out.println("Choosen different sub-reason3");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason4", "end");
		 System.out.println("Choosen different reason4");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason4", "end");
		 System.out.println("Choosen different sub-reason4");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason5", "end");
		 System.out.println("Choosen different reason5");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason5", "end");
		 System.out.println("Choosen different sub-reason5");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason6", "end");
		 System.out.println("Choosen different reason6");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason6", "end");
		 System.out.println("Choosen different sub-reason6");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason7", "end");
		 System.out.println("Choosen different reason7");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason7", "end");
		 System.out.println("Choosen different sub-reason7");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason8", "end");
		 System.out.println("Choosen different reason8");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason8", "end");
		 System.out.println("Choosen different sub-reason8");
		 selenium.waitForElementToBeClickable("reasonBtn");
		 selenium.jsClick("reasonBtn");
		 selenium.waitingTime(2000);
 	 selenium.clickDynamic("spanTitle", "Edit Reason9", "end");
		 System.out.println("Choosen different reason9");
		 selenium.waitingTime(2000);
		 selenium.waitForElementToBeClickable("subReasonBtn");
		 selenium.jsClick("subReasonBtn");
		 selenium.waitingTime(2000);
		 selenium.clickDynamic("spanTitle", "Edit Sub Reason9", "end");
		 System.out.println("Choosen different sub-reason9");
		 selenium.waitingTime(2000);
		 selenium.test.log(LogStatus.PASS, "Picklist values verified successfully" );
		 selenium.waitForElementToBeClickable("CancelButton");
		 selenium.click("CancelButton");
		 selenium.waitingTime(10000);
		 
		 if(selenium.isElementPresentFast("loginPopUpNew"))
		 {
			 selenium.clickLoop("loginPopUpNew");
			 selenium.waitingTime(3000);
		 }
 }
 
 catch (Exception e) {
		System.out.println("Error while checking the picklist");
		selenium.reportFailure("Error while checking the picklist " + e.getMessage());
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
}
 @Then("verify case number records$")
	public void verify_vase_number_records() {
		try {
			selenium.scrollToElement("goButton");
			selenium.waitForElementToBeClickable("goButton");
			selenium.click("goButton");
			selenium.waitingTime(3000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 2nd window");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("supplementsTab");
			selenium.click("supplementsTab");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			String supplement = selenium.getDynamicXpath("anchorTextcontains", "ISBN", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(supplement);
			selenium.waitingTime(4000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 3rd window");
			selenium.captureScreenShot();
			selenium.refresh();
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("supplementsRecordTab")) {
				selenium.scrollToElement("supplementsRecordTab");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("supplementsRecordTab");
				selenium.click("supplementsRecordTab");
				selenium.waitingTime(7000);
				selenium.waitForElementToBeVisible("supplementText");
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				String supplementRecord = selenium.getText("supplementText").toString();
				selenium.waitingTime(2000);
				System.out.println(supplementRecord);
				if (supplementRecord.equalsIgnoreCase("Data Not Available") || selenium.isElementPresentFast("supplementTblRecord")) {
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.PASS,
							"Fields are non-editable and there are no further supplement records underneath it.");
					System.out.println("Fields are non-editable and there are no further supplement records underneath it.");
				} else
				{
					selenium.test.log(LogStatus.FAIL, "Value could not be fetched");
					System.out.println("Value could not be fetched");
					selenium.reportFailure("Value could not be fetched");
				}
				selenium.close();
				selenium.switchBackToParentWindow();
				selenium.switchOutOfFrame();
			}
		} catch (Exception e) {
			selenium.switchToLastWindow();
			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@And("I create a new case for MHES Sales Opertation record type")
		public void i_create_a_new_case_for_mhes_sales_operation_record_type() {
			try {
				selenium.waitForElementToBeClickable("click_newcaseBtn");
				selenium.jsClick("click_newcaseBtn");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("MHSESalesOprRadioBtn");
				selenium.hoverAndClick("MHSESalesOprRadioBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NextButton");
				selenium.hoverAndClick("NextButton");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("CaseAccountNameTextBox");
				selenium.typeData("CaseAccountNameTextBox","STANFORD UNIV");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutText("CaseAccountNameTextBox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CaseContactNameTextBox");
				selenium.typeData("CaseContactNameTextBox","Livonia Public Schs");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutText("CaseContactNameTextBox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Case_OriginDropDown");
				selenium.jsClick("Case_OriginDropDown");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutText("Case_OriginDropDown");
				selenium.waitingTime(2000);
				if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCallTypeOptionInCases"))
				{
					selenium.waitForElementToBeClickable("CallTypeDropDown");
					selenium.jsClick("CallTypeDropDown");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("CallTypeOption");
					selenium.jsClick("CallTypeOption");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ReasonCodeDropDown");
					selenium.jsClick("ReasonCodeDropDown");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ReasonCodeOption");
					selenium.jsClick("ReasonCodeOption");
				}
				if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCallTypeOption"))
				{
					selenium.waitForElementToBeClickable("CallTypeDropDown");
					selenium.jsClick("CallTypeDropDown");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("CallTypeOption1");
					selenium.jsClick("CallTypeOption1");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ReasonCodeDropDown");
					selenium.jsClick("ReasonCodeDropDown");
					selenium.waitingTime(2000);
					Assert.assertFalse(selenium.isElementPresentFast("ReasonCodeOption"));
					selenium.test.log(LogStatus.PASS,"PASS");
					System.out.println("PASS");
				}
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(4000);
				if(selenium.getTestCaseName().equalsIgnoreCase("VerifyCallTypeOptionInCases"))
				{
					Assert.assertFalse(selenium.isElementPresentFast("snagerror"));
					selenium.test.log(LogStatus.PASS,"PASS");
					System.out.println("PASS");
				}
				selenium.waitingTime(6000);
			} catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed");
			}
		}
		@Then("I create a new case for A3K customer support")
		public void i_create_a_new_case_for_a3k_customer_support(){
		try{
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CaseAccountNameTextBox");
			selenium.typeData("CaseAccountNameTextBox","Ocean Palms Elementary School");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("CaseAccountNameTextBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field","Test Data");
			selenium.waitForElementToBeClickable("CaseContactNameTextBox");
			selenium.typeData("CaseContactNameTextBox","Test");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutTextTwo("CaseContactNameTextBox");
			selenium.waitForElementToBeClickable("CaseDesTextArea");
			selenium.typeData("CaseDesTextArea","Automation Demo Test");
			selenium.waitForElementToBeClickable("Category1DrpDwn");
			selenium.autoSuggestiveDropdownWithoutTextTwo("Category1DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Category2DrpDwn");
			selenium.autoSuggestiveDropdownWithoutTextTwo("Category2DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Category3DrpDwn");
			selenium.autoSuggestiveDropdownWithoutTextTwo("Category3DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("verify the district from account name dropdown")
	public void verify_the_district_from_account_name_dropdown(){
		try{
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("editAccount");
			selenium.jsClick("editAccount");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("AccountNameCrossBtn");
			selenium.jsClick("AccountNameCrossBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseAccountNameTextBox");
			selenium.typeData("CaseAccountNameTextBox","Ocean Palms Elementary Sch");
			selenium.waitingTime(5000);
			Assert.assertTrue(selenium.isElementPresentFast("AccountNameDistGetText"));
			selenium.test.log(LogStatus.PASS,"PASS");
			System.out.println("PASS");
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I go to cases in classic mode and verify")
	public void i_go_to_cases_in_classic_mode_and_verify(){
		try{
			selenium.waitForElementToBeClickable("SearchTextBoxClassicMode");
			selenium.typeData("SearchTextBoxClassicMode","Cases");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchBtnClassicMode");
			selenium.jsClick("SearchBtnClassicMode");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CasesQuickLinkClassicMode");
			selenium.jsClick("CasesQuickLinkClassicMode");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("FirstCaseRecordInClassic");
			selenium.jsClick("FirstCaseRecordInClassic");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("DetailsTabInClassic");
			selenium.jsClick("DetailsTabInClassic");
			selenium.waitingTime(2000);
			Assert.assertFalse(selenium.isElementPresentFast("edit"));
			selenium.test.log(LogStatus.PASS,"PASS");
			System.out.println("PASS");
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
			selenium.reportFailure("Test Case Failed");
		}
	}
	@And("update and verify the incident and subincident field")
	public void update_and_verify_the_incident_and_subincident_field(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption_Reporting");
			selenium.jsClick("IncidentOption_Reporting");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption_GradeDispute");
			selenium.jsClick("SubIncidentOption_GradeDispute");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeVisible("Internal_Description1");
//			String Idtext=selenium.getText("Internal_Description1").toString();
//			System.out.println("The text from Internal description is : "+Idtext);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(6000);
//			Assert.assertFalse(selenium.getElement("Save_Button").isEnabled());
			Assert.assertFalse(selenium.getElement("Save_Button").isEnabled());
			selenium.test.log(LogStatus.PASS,"PASS");
			System.out.println("PASS");
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I update and verify for incident subincident")
	public void i_update_and_verify_for_incident_subincident(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption_Registration");
			selenium.jsClick("IncidentOption_Registration");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption_Incorrect");
			selenium.jsClick("SubIncidentOption_Incorrect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("Internal_Description1");
			String Idtext=selenium.getText("Internal_Description1").toString();
			System.out.println("The text from Internal description is : "+Idtext);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(6000);
			Assert.assertFalse(selenium.getElement("Save_Button").isEnabled());
			selenium.test.log(LogStatus.PASS,"PASS");
			System.out.println("PASS");

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	@Then("I update incident and subincident and subincident")
	public void i_update_incident_and_subincident_fields(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentOption_AdditionalResources");
			selenium.jsClick("IncidentOption_AdditionalResources");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentOption_StudentResources");
			selenium.jsClick("SubIncidentOption_StudentResources");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("Internal_Description1");
			String Idtext=selenium.getText("Internal_Description1").toString();
			System.out.println("The text from Internal description is : "+Idtext);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(6000);
			Assert.assertFalse(selenium.getElement("Save_Button").isEnabled());
			selenium.test.log(LogStatus.PASS,"PASS");
			System.out.println("PASS");

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
}
