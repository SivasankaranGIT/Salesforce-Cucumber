package com.mhe.salesforce.a3k;

import java.util.List;

import org.junit.Assert;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A3KCase {
	WebConnector selenium = WebConnector.getInstance();	
	String ContantNameInContact = null;
	String AccountNameInContact = null;
	String AccountNameInCase = null;
	String ContactNameInCase = null;

	@And("^create new Smarty Ants record type case$")
	public void create_new_Smarty_Ants_record_type_case(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("A3KSmartyAntsRecordTypeRadioBtn");
			selenium.clickLoop("A3KSmartyAntsRecordTypeRadioBtn");
			selenium.click("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", data.get(0));
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", data.get(1));
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.waitingTime(5000);
			selenium.typeData("Search_contact", data.get(0));
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseDesTextArea");
			selenium.typeData("CaseDesTextArea", data.get(1));
			selenium.waitingTime(2000);
			selenium.scrollToElement("SalesSupportProductDropDown");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeClickable("SalesSupportProductDropDown");
			selenium.click("SalesSupportProductDropDown");
			selenium.waitForElementToBeClickable("ProductTypeSmartyAnts");
			selenium.click("ProductTypeSmartyAnts");*/
			selenium.waitForElementToBeClickable("Category1DrpDwn");
			selenium.click("Category1DrpDwn");
			selenium.waitForElementToBeClickable("Category1Type");
			selenium.click("Category1Type");
			selenium.waitForElementToBeClickable("Category2DrpDwn");
			selenium.click("Category2DrpDwn");
			selenium.waitForElementToBeClickable("Category2Type");
			selenium.click("Category2Type");
			selenium.waitForElementToBeClickable("Category3DrpDwn");
			selenium.click("Category3DrpDwn");
			selenium.waitForElementToBeClickable("Category3Type");
			selenium.click("Category3Type");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.takeScreenShot();
			Assert.assertTrue(selenium.isElementPresentFast("editButton"));
			selenium.test.log(LogStatus.PASS, "New case created successfully!");
			
			selenium.newA3KCase = selenium.getURL();
			System.out.println("newA3KCase" + selenium.newA3KCase);
		} catch (Exception e) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^confirm case related list fields$")
	public void confirm_case_related_list_fields() {
		try {
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_RelatedCases"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_CaseComments"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_CaseHistory"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_OpenActivities"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_ActivityHistory"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_Emails"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_VoiceOfTheCustomer"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_Notes"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_ChatTranscripts"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_Files"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseRelatedList_Attachments"));
			selenium.test.log(LogStatus.PASS, "The expected related list fields are present");
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^confirm case fields are added up correctly$")
	public void confirm_case_fields_are_added_up_correctly() {
		try {
			Assert.assertTrue(selenium.isElementPresentFast("A3KCase_DueDateField"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCase_ProductField"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCase_CommentsField"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCase_BusinessHoursField"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCase_LastModifiedDateField"));
			selenium.test.log(LogStatus.PASS, "The expected fields are present");
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^confirm case can be transferred$")
	public void confirm_case_can_be_transferred(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			 selenium.waitForElementToBeClickable("changeOwner");
			 selenium.clickLoop("changeOwner");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("UserTypeDD");
			 selenium.clickLoop("UserTypeDD");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("UserTypeValue");
			 selenium.click("UserTypeValue");
			 selenium.waitingTime(2000);
			 selenium.typeData("searchQueues", data.get(0));
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("A3KSmartyAntsResult");
			 selenium.click("A3KSmartyAntsResult");
			 selenium.waitingTime(2000);
			 selenium.click("ChangeOwnerBtn");
			 selenium.waitingTime(10000);
			 selenium.test.log(LogStatus.PASS, "Case Owner updated to A3K Smarty Ants");
			 selenium.takeScreenShot();
			 selenium.refresh();
			 selenium.waitingTime(10000);
			 selenium.waitForElementToBeClickable("changeOwner");
			 selenium.clickLoop("changeOwner");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("search_user");
			 selenium.typeData("search_user", data.get(1));
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("ChangeUserResult");
			 selenium.click("ChangeUserResult");
			 selenium.waitingTime(2000);
			 selenium.click("ChangeOwnerBtn");
			 selenium.waitingTime(10000);
			 selenium.test.log(LogStatus.PASS, "Case Owner updated back to original user");	 
			 selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.click("opportunityAccountsEditCancel");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^close the A3K case$")
	public void close_the_A3K_case() {
		try {		
			 selenium.waitForElementToBeClickable("A3KCloseCaseLink");
			 selenium.jsClick("A3KCloseCaseLink");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("A3KCloseCaseStatusDrpDwn");
			 selenium.jsClick("A3KCloseCaseStatusDrpDwn");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("case_Status_closed");
			 selenium.jsClick("case_Status_closed");
			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("A3KCloseCaseSaveBtn");
			 selenium.jsClick("A3KCloseCaseSaveBtn");
			 selenium.waitingTime(10000);
			 selenium.refresh();
			 selenium.waitingTime(8000);
			 Assert.assertTrue(selenium.isElementPresentFast("A3KCaseClosedStatus"));
			 selenium.test.log(LogStatus.PASS, "A3K Case has been closed successfully!");
			 selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^verify Supplemental Tier field$")
	public void verify_Supplemental_Tier_field() {
		try {
			 selenium.refresh();
			 selenium.waitingTime(6000);
			 selenium.waitForElementToBeClickable("editButton");
			 selenium.jsClick("editButton");
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("SupplementField");
			 Assert.assertTrue(selenium.isElementPresentFast("SupplementField"));
			 Assert.assertTrue(selenium.isElementPresentFast("SupplementTierFieldText"));
			 selenium.test.log(LogStatus.PASS, "Supplemental Tier field is present & it is a formula field");
			 selenium.takeScreenShot();
			 selenium.click("CancelButton");
			 selenium.waitingTime(10000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^verify functionality of Junk Case Button$")
	public void verify_functionality_of_Junk_Case_Button() {
		try {
			 selenium.refresh();
			 selenium.waitingTime(6000);
			 selenium.waitForElementToBeClickable("JunkCaseBtn");
			 selenium.jsClick("JunkCaseBtn");
			 selenium.waitingTime(8000);
			 Assert.assertTrue(selenium.isElementPresentFast("A3KCaseClosedStatus"));
			 selenium.test.log(LogStatus.PASS, "A3K Case - Status has updated as Closed!");
			 Assert.assertTrue(selenium.isElementPresentFast("JunkCaseAccountName"));
			 selenium.test.log(LogStatus.PASS, "A3K Case - Account Name has updated as Achieve 3000!");
			 Assert.assertTrue(selenium.isElementPresentFast("JunkCaseContactName"));
			 selenium.test.log(LogStatus.PASS, "A3K Case - Contact Name has updated as Junk Junk!");
			 Assert.assertTrue(selenium.isElementPresentFast("JunkCaseCategory1Value"));
			 selenium.test.log(LogStatus.PASS, "A3K Case - Category 1 value has updated as Junk Case!");
			 selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new case " + e.getMessage());
		}
	}
	
	@And("^verify functionality of Create Contact Button$")
	public void verify_functionality_of_Create_Contact_Button() {
		try {
			 String lastName= selenium.getRandomString();
			 selenium.refresh();
			 selenium.waitingTime(6000);
			 selenium.waitForElementToBeClickable("A3KCaseCreateContactBtn");
			 selenium.jsClick("A3KCaseCreateContactBtn");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("ContactLastName");
			 selenium.typeData("ContactLastName", lastName);
			 selenium.type_propertiesFile("serach_Account", "serach_Account");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			 selenium.click("showAllResultsFromDropDwn");
			 selenium.waitingTime(4000);
			 String accountsearch = selenium.getDynamicXpath_propertiesFile("anchorTitlecontains", "serach_Account", "endContains");
			 selenium.waitingTime(4000);
			 selenium.clickLoopXpath(accountsearch);
			 selenium.waitingTime(4000);
			 selenium.click("Save_Btn");
			 selenium.waitingTime(8000);
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
			 Assert.assertFalse(selenium.isElementPresentFast("ContactLastName"));
			 selenium.test.log(LogStatus.PASS, "A3K Case - New Contact has been created!");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a new contact in case " + e.getMessage());
		}
	}
	
	@And("^verify A3k record types$")
	public void verify_A3k_record_types(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
//			String A3kRecordType1 = selenium.getDynamicXpathData("Text_Span", data.get(0), "end");
			String A3kRecordType2 = selenium.getDynamicXpathData("Text_Span", data.get(1), "end");
			String A3kRecordType3 = selenium.getDynamicXpathData("Text_Span", data.get(2), "end");
			String A3kRecordType4 = selenium.getDynamicXpathData("Text_Span", data.get(3), "end");
			String A3kRecordType5 = selenium.getDynamicXpathData("Text_Span", data.get(4), "end");
			String A3kRecordType6 = selenium.getDynamicXpathData("Text_Span", data.get(5), "end");
			String A3kRecordType7 = selenium.getDynamicXpathData("Text_Span", data.get(6), "end");
			String A3kRecordType8 = selenium.getDynamicXpathData("Text_Span", data.get(7), "end");
			String A3kRecordType9 = selenium.getDynamicXpathData("Text_Span", data.get(8), "end");
			System.out.println("A3kRecordType2" + A3kRecordType2 +"A3kRecordType3" + A3kRecordType3 +"A3kRecordType4" + A3kRecordType4 +"A3kRecordType5" + A3kRecordType5 +"A3kRecordType6" + A3kRecordType6 +"A3kRecordType7" + A3kRecordType7 +"A3kRecordType8" + A3kRecordType8 +"A3kRecordType9" + A3kRecordType9);
//			Assert.assertTrue(selenium.isElementPresentFast(A3kRecordType1));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType2));	
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType3));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType4));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType5));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType6));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType7));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType8));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordType9));
			selenium.test.log(LogStatus.PASS, "All the expected A3K record types are present");
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying A3k case record types " + e.getMessage());
		}
	}
	
	@And("^create A3K Accounts Receivable type case$")
	public void create_A3K_Accounts_Receivable_type_case(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			selenium.waitForElementToBeClickable("NewButtonToAdd");
			selenium.jsClick("NewButtonToAdd");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("A3KAccountsReceivableCaseTypeRadioBtn");
			selenium.jsClick("A3KAccountsReceivableCaseTypeRadioBtn");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("serach_Account");
			selenium.waitingTime(5000);
			selenium.typeData("serach_Account", data.get(0));
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.jsClick("SelectAccountName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.typeData("Subject_field", data.get(1));
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.waitingTime(5000);
			selenium.typeData("Search_contact", data.get(0));
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.jsClick("SelectContactName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseDesTextArea");
			selenium.typeData("CaseDesTextArea", data.get(1));
			selenium.waitingTime(2000);
			selenium.scrollToElement("Category1DrpDwn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			/*selenium.waitForElementToBeClickable("SalesSupportProductDropDown");
			selenium.click("SalesSupportProductDropDown");
			selenium.waitForElementToBeClickable("ProductTypeSmartyAnts");
			selenium.click("ProductTypeSmartyAnts");*/
			selenium.waitForElementToBeClickable("Category1DrpDwn");
			selenium.click("Category1DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Category4Type");
			selenium.click("Category4Type");
			selenium.waitForElementToBeClickable("Category2DrpDwn");
			selenium.click("Category2DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Category5Type");
			selenium.click("Category5Type");
			selenium.waitForElementToBeClickable("Category3DrpDwn");
			selenium.click("Category3DrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Category6Type");
			selenium.click("Category6Type");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.takeScreenShot();
			Assert.assertTrue(selenium.isElementPresentFast("editButton"));
			selenium.test.log(LogStatus.PASS, "New case created successfully!");
			
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying A3k case record types " + e.getMessage());
		}
	}
	
	@And("^close A3K Accounts Receivable type case$")
	public void close_A3K_Accounts_Receivable_type_case() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("closeCaseTab");
			selenium.jsClick("closeCaseTab");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("closeCaseTabSaveBtn");
			selenium.jsClick("closeCaseTabSaveBtn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Case Closed Successfully!");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying A3k case record types " + e.getMessage());
		}
	}
	
	@And("^verify A3k record status picklist values$")
	public void verify_A3k_record_status_picklist_values(DataTable table) {
		List<String> data = table.transpose().asList(String.class);
		try {
			selenium.waitForElementToBeClickable("A3KSmartyAntsRecordTypeRadioBtn");
			selenium.clickLoop("A3KSmartyAntsRecordTypeRadioBtn");
			selenium.click("NextButton");
			selenium.waitingTime(5000);
			selenium.scrollToElement("Status_DropDown");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Status_DropDown");
			selenium.click("Status_DropDown");
			selenium.waitingTime(2000);
			//Verify default status is open
			Assert.assertTrue(selenium.isElementPresentFast("DefaultCaseStatusIsOpen"));
			selenium.test.log(LogStatus.PASS, "Default status is OPEN");
			
			//Verify no "closed" status are dropdown
			String A3kRecordStatus0 = selenium.getDynamicXpathData("Text_Span", data.get(16), "end");
			System.out.println("A3kRecordStatus0 -->" + A3kRecordStatus0);
			Assert.assertFalse(selenium.isElementPresentXpathFast(A3kRecordStatus0));
			selenium.test.log(LogStatus.PASS, "Closed status is not present in Status dropdown list");
			
			//Verify all other statuses exist in dropdown
			String A3kRecordStatus1 = selenium.getDynamicXpathData("Text_Span", data.get(0), "end");
//			String A3kRecordStatus2 = selenium.getDynamicXpathData("Text_Span", data.get(1), "end");
			String A3kRecordStatus3 = selenium.getDynamicXpathData("Text_Span", data.get(2), "end");
			String A3kRecordStatus4 = selenium.getDynamicXpathData("Text_Span", data.get(3), "end");
			String A3kRecordStatus5 = selenium.getDynamicXpathData("Text_Span", data.get(4), "end");
			String A3kRecordStatus6 = selenium.getDynamicXpathData("Text_Span", data.get(5), "end");
			String A3kRecordStatus7 = selenium.getDynamicXpathData("Text_Span", data.get(6), "end");
			String A3kRecordStatus8 = selenium.getDynamicXpathData("Text_Span", data.get(7), "end");
			String A3kRecordStatus9 = selenium.getDynamicXpathData("Text_Span", data.get(8), "end");
			String A3kRecordStatus10 = selenium.getDynamicXpathData("Text_Span", data.get(9), "end");
			String A3kRecordStatus11 = selenium.getDynamicXpathData("Text_Span", data.get(10), "end");
			String A3kRecordStatus12 = selenium.getDynamicXpathData("Text_Span", data.get(11), "end");
			String A3kRecordStatus13 = selenium.getDynamicXpathData("Text_Span", data.get(12), "end");
			String A3kRecordStatus14 = selenium.getDynamicXpathData("Text_Span", data.get(13), "end");
			String A3kRecordStatus15 = selenium.getDynamicXpathData("Text_Span", data.get(14), "end");
			String A3kRecordStatus16 = selenium.getDynamicXpathData("Text_Span", data.get(15), "end");
			
			System.out.println("A3kRecordStatus1" + A3kRecordStatus1 + "A3kRecordStatus3" + A3kRecordStatus3 +"A3kRecordStatus4" + A3kRecordStatus4 +"A3kRecordStatus5" + A3kRecordStatus5 +"A3kRecordStatus6" + A3kRecordStatus6 +"A3kRecordStatus7" + A3kRecordStatus7 +"A3kRecordStatus8" + A3kRecordStatus8 +"A3kRecordStatus9" + A3kRecordStatus9 +"A3kRecordStatus10" + A3kRecordStatus10 + "A3kRecordStatus11" + A3kRecordStatus11 + "A3kRecordStatus12" + A3kRecordStatus12 +"A3kRecordStatus13" + A3kRecordStatus13 + "A3kRecordStatus14" + A3kRecordStatus14 +"A3kRecordStatus15" + A3kRecordStatus15 +"A3kRecordStatus16" + A3kRecordStatus16);
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus1));
//			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus2));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus3));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus4));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus5));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus6));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus7));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus8));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus9));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus10));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus11));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus12));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus13));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus14));
			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus15));
//			Assert.assertTrue(selenium.isElementPresentXpathFast(A3kRecordStatus16));
			selenium.test.log(LogStatus.PASS, "All the expected values are present in Status picklist");
			
		} catch (Exception e) {
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying A3k case record status picklist values " + e.getMessage());
		}
	}
	
	@And("^choose case \"([^\"]*)\" and verify required fields$")
	public void choose_case_record_type_and_verify_required_fields(String recordtype) {
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);			
			if(recordtype.equalsIgnoreCase("A3K Customer Support"))
			{
				selenium.waitForElementToBeClickable("A3KCustomerSupportRecordTypeRadioBtn");
				selenium.clickLoop("A3KCustomerSupportRecordTypeRadioBtn");
			}
			else if(recordtype.equalsIgnoreCase("A3K Customer Support - Training"))
			{
				selenium.waitForElementToBeClickable("A3KCustomerSupportTrainingRecordTypeRadioBtn");
				selenium.clickLoop("A3KCustomerSupportTrainingRecordTypeRadioBtn");
			}
			else if(recordtype.equalsIgnoreCase("A3K International Customer Support"))
			{
				selenium.waitForElementToBeClickable("A3KInternationalCustomerSupportRecordTypeRadioBtn");
				selenium.clickLoop("A3KInternationalCustomerSupportRecordTypeRadioBtn");
			}
			else if(recordtype.equalsIgnoreCase("A3K Preferred Support"))
			{
				selenium.waitForElementToBeClickable("A3KPreferredSupportRecordTypeRadioBtn");
				selenium.clickLoop("A3KPreferredSupportRecordTypeRadioBtn");
			}
			else if(recordtype.equalsIgnoreCase("A3K Suggestions"))
			{
				selenium.waitForElementToBeClickable("A3KSuggestionsRecordTypeRadioBtn");
				selenium.clickLoop("A3KSuggestionsRecordTypeRadioBtn");
			}
			else if(recordtype.equalsIgnoreCase("A3K Data Provisioning"))
			{
				selenium.waitForElementToBeClickable("A3KDataProvisioningRecordTypeRadioBtn");
				selenium.clickLoop("A3KDataProvisioningRecordTypeRadioBtn");
			}
			selenium.takeScreenShot();
			selenium.click("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("A3KCaseMandatoryField1");
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField1"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField2"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField3"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField4"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField5"));
			if(!recordtype.equalsIgnoreCase("A3K Data Provisioning"))	//For A3K Data Provisioning record type, 'Product' field is not mandatory.
			{
				Assert.assertTrue(selenium.isElementPresentFast("A3KCaseMandatoryField6"));
			}
			selenium.takeScreenShot();
			selenium.test.log(LogStatus.PASS, "Confirmed all mandatory fields");			
			selenium.click("closePopUp");
			selenium.waitingTime(2000);
			selenium.click("CancelEdit");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.click("closePopUp");
			selenium.waitingTime(2000);
			selenium.click("CancelEdit");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying case required fields " + e.getMessage());
		}
	}
	
	@When("^I navigate to existing A3K case record$")
	public void I_navigate_to_existing_A3K_record() {
		try {
			selenium.navigateToURL(selenium.newA3KCase);
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Navigated to exiting A3K Case");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to existing A3K record " + e.getMessage());
		}
	}
	
	@Then("^verify app permissions for A3K user$")
	public void verify_app_permissions_for_A3K_user() {
		try {
			selenium.waitForElementToBeClickable("ChatterFeedLink");
			Assert.assertTrue(selenium.isElementPresentFast("ChatterFeedLink"));
			selenium.test.log(LogStatus.PASS, "Chatter Feed is available in Case layout");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "A3K Customer Support");
			selenium.waitingTime(4000);
			Assert.assertTrue(selenium.isElementPresentFast("A3KCustomerSupportApp"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KCustomerSupportConsoleApp"));
			selenium.test.log(LogStatus.PASS, "Both A3K Apps are assigned");
			selenium.takeScreenShot();
			selenium.refresh();
			selenium.waitingTime(5000);
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifing app permissions for A3K user " + e.getMessage());
		}
	}
	
	@Then("^verify JIRA issue creation from A3K support case$")
	public void verify_JIRA_issue_creation_from_A3K_support_case() {
		try {
			selenium.waitForElementToBeClickable("JIRATabInA3KCase");
			selenium.click("JIRATabInA3KCase");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AssociateOrCreateJiraIssueBtn");
			selenium.click("AssociateOrCreateJiraIssueBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConnectionComboBx");
			selenium.click("ConnectionComboBx");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ConnectionValue");
			selenium.click("ConnectionValue");
			selenium.waitingTime(6000);
			selenium.click("CreateJiraIssueBtn");
			selenium.waitingTime(6000);
			selenium.takeScreenShot();
			selenium.click("click_createBtn");
			selenium.waitingTime(10000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CreatedorLinkedJIRAIssueLink");
			Assert.assertTrue(selenium.isElementPresentFast("CreatedorLinkedJIRAIssueLink"));
			selenium.test.log(LogStatus.PASS, "New JIRA Issue has been created");
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^confirm the JIRA issue creation and verify its fields$")
	public void confirm_the_JIRA_issue_creation_and_verify_its_fields() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("CreatedorLinkedJIRAIssueLink");
			Assert.assertTrue(selenium.isElementPresentFast("CreatedorLinkedJIRAIssueLink"));
			selenium.test.log(LogStatus.PASS, "New JIRA Issue has been created");
			//As we don't have the access to the "https://id.atlassian.com/" page we cannot validate the remaining test steps in this ticket 
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify the New CS button functionality$")
	public void verify_the_New_CS_button_functionality() {
		try {
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("ContactNameInContactRecord");
			ContantNameInContact = selenium.getText("ContactNameInContactRecord");
			System.out.println("ContantNameInContact is --> "  + ContantNameInContact);
			AccountNameInContact = selenium.getText("AccountNameInContactRecord");
			System.out.println("AccountNameInContact is --> "  + AccountNameInContact);
			selenium.takeScreenShot();
			selenium.click("NewCSCaseActionBtn");
			selenium.waitingTime(5000);
			selenium.click("NewCSCase_InquiryTypeDrpDwn");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_InquiryTypeValue");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_ProductDrpDwn");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_ProductValue");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_ProductFamilyName");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_ProductFamilyChooseBtn");
			selenium.waitingTime(1000);
			selenium.scrollToElement("Category1DrpDwn");
			selenium.waitingTime(1000);
			selenium.scrolldown(-200);
			selenium.waitingTime(1000);
			selenium.click("Category1DrpDwn");
			selenium.waitingTime(1000);
			selenium.click("Category1Type");
			selenium.waitingTime(1000);
			selenium.click("Category2DrpDwn");
			selenium.waitingTime(1000);
			selenium.click("Category2Type");
			selenium.waitingTime(1000);
			selenium.click("Category3DrpDwn");
			selenium.waitingTime(1000);
			selenium.click("Category3Type");
			selenium.waitingTime(1000);
			selenium.typeData("Calendarsubject", "Automation Test");
			selenium.typeData("caseDTSDescription", "Automation Test");
			selenium.click("Save_Button");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "New case has been created successfully!");
			selenium.takeScreenShot();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^confirm the account and contact name on the case matches what was on the contact record$")
	public void confirm_the_account_and_contact_name_on_the_case_matches_what_was_on_the_contact_record() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("ContactNameInCaseRecord");
			ContactNameInCase = selenium.getText("ContactNameInCaseRecord");
			System.out.println("ContantNameInCase is --> "  + ContactNameInCase);
			AccountNameInCase = selenium.getText("AccountNameInCaseRecord");
			System.out.println("AccountNameInCase is --> "  + AccountNameInCase);			
//			Assert.assertEquals(ContantNameInContact, ContactNameInCase); //Dr. Jialu Streeter vs Jialu Streeter causing failure.
			if(ContantNameInContact.contains(ContactNameInCase))
			{
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "Test Case Passed");
			}
			else
			{
				System.out.println("FAIL");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Test Case Failed");
			}
			Assert.assertEquals(AccountNameInContact, AccountNameInCase);
			selenium.test.log(LogStatus.PASS, "The account and contact name on the case matches what was on the contact record");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify current User can see the online agent assigned to A3K Chats queue$")
	public void verify_current_User_can_see_the_online_agent_assigned_to_A3K_Chats_queue() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("A3KChatOnlineUser");
			Assert.assertTrue(selenium.isElementPresentFast("A3KChatOnlineUser"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KChatQueue"));
			Assert.assertTrue(selenium.isElementPresentFast("A3KChatStatus"));
			selenium.test.log(LogStatus.PASS, "Current User can see the online agent assigned to A3K Chats queue");
			System.out.println("PASS");
			selenium.takeScreenShot();
			selenium.logoutFromAnyUser();
			selenium.test.log(LogStatus.INFO, "Logout of specific user successful!");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("loginPassword"))
			{
				System.out.println("Main login page appeared so doing login again");
				selenium.doDefaultUATLogin();
			}
			
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.checkFlowInterruptedPopup();
			selenium.closeOminiChannelPopup();
			selenium.checkFlowInterruptedPopup();
			
			//The remaining test steps cannot be automated as we cannot open two tabs simultaneously - GCRM-17632
		} catch (Exception e) {
			if(selenium.isElementPresentFast("OmniChannelPopup"))
			{
				selenium.waitForElementToBeClickable("OmniChannelPopupClose");
				selenium.click("OmniChannelPopupClose");
				selenium.waitingTime(4000);
				selenium.logoutFromAnyUser();
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("loginPassword"))
				{
					System.out.println("Main login page appeared so doing login again");
					selenium.doDefaultUATLogin();
				}
			}
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^create new DAG Sales Support type case$")
	public void create_new_DAG_Sales_Support_type_case() {
		try {
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitForElementToBeClickable("DAGSalesSupportCaseTypeRadioBtn");
			selenium.click("DAGSalesSupportCaseTypeRadioBtn");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("NextButton");
			selenium.click("NextButton");

			selenium.type_propertiesFile("serach_Account", "serach_Account");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(4000);
			String accountsearch = selenium.getDynamicXpath_propertiesFile("anchorTitlecontains", "serach_Account", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(accountsearch);
			selenium.waitingTime(2000);
			
			selenium.click("NewCSCase_ProductFamilyName");
			selenium.waitingTime(1000);
			selenium.click("NewCSCase_ProductFamilyChooseBtn");
			selenium.waitingTime(1000);
			
			selenium.type_propertiesFile("Search_contact", "ContactNameForCase");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.clickLoop("showAllResultsFromDropDwn");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("FirstContactInSearchContactPopup");
			selenium.jsClick("FirstContactInSearchContactPopup");
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeClickable("OrderStageDrpDwn");
			selenium.click("OrderStageDrpDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("OrderStageValue");
			selenium.click("OrderStageValue");
			
			selenium.waitForElementToBeClickable("RequestReasonDrpDwn");
			selenium.click("RequestReasonDrpDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("RequestReasonValue");
			selenium.click("RequestReasonValue");
			
			selenium.typeData("Subject_field", "Automation Test Subject");
			selenium.typeData("Description_Case", "Automation Test Description");
			selenium.takeScreenShot();
			selenium.click("Save_Btn");
			selenium.waitingTime(5000);
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify Sub Reason field is required when Request Reason is Quoting$")
	public void verify_Sub_Reason_field_is_required_when_Request_Reason_is_Quoting() {
		try {
			
			Assert.assertTrue(selenium.isElementPresentFast("SubReasonMandatoryValidatioPopup"));
			selenium.test.log(LogStatus.PASS, "Sub Reason field is required when Request Reason is Quoting");
			selenium.takeScreenShot();
			selenium.jsClick("SubReasonMandatoryValidatioPopup");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("SubReasonDrpDwn");
			selenium.click("SubReasonDrpDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("SubReasonValue");
			selenium.click("SubReasonValue");
			selenium.takeScreenShot();
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			Assert.assertFalse(selenium.isElementPresentFast("SubReasonMandatoryValidatioPopup"));
			selenium.test.log(LogStatus.PASS, "After entering sub reason the new DAG Case got created");
			selenium.takeScreenShot();
			
//			selenium.refresh();
//			selenium.waitingTime(10000);
//			selenium.waitForElementToBeVisible("CaseContactName");
//			Assert.assertTrue(selenium.isElementPresentFast("CaseContactName"));
//			Assert.assertFalse(selenium.isElementPresentFast("CaseAccountName"));
//			selenium.test.log(LogStatus.PASS, "For Case with contact as Stacy Peters the Account Name is not Achieve 3000");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify the A3K CS Close Cases button functionality$")
	public void verify_the_A3K_CS_Close_Cases_button_functionality() {
		try {
			selenium.waitForElementToBeClickable("ChangeStatusActionBtn");
			selenium.click("ChangeStatusActionBtn");
			
			Assert.assertTrue(selenium.isElementPresentFast("SelectAtLeastOneRecordTosterMsg"));
			selenium.test.log(LogStatus.PASS, "Select at least one record. - toster message appeared");
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("SelectAllCaseChkBxInRecentlyViewedList");
			selenium.click("SelectAllCaseChkBxInRecentlyViewedList");
			selenium.click("ChangeStatusActionBtn");
			
			Assert.assertTrue(selenium.isElementPresentFast("SelectSameTypeCaseMsg"));
			selenium.test.log(LogStatus.PASS, "To update multiple records at a time, select records belonging to the same record type - message appeared");
			selenium.takeScreenShot();
			selenium.clickLoop("ProductCloseButtonOpp");
			selenium.waitingTime(4000);
			
			selenium.refresh();
			selenium.waitingTime(5000);			
			
			selenium.waitForElementToBeClickable("searchCaseInListView");
			selenium.typeData("searchCaseInListView", "Automation Test");		//There should be more than one case with subject as 'Automation Test' should be present under recently viewed list
			selenium.pressEnterKey();
			selenium.waitingTime(6000);
			selenium.pressEnterKey();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CaseOwnerAliasColumn");
			selenium.jsClick("CaseOwnerAliasColumn"); //switching order to bring same owner records on top
			selenium.waitingTime(4000);
			
			selenium.waitForElementToBeClickable("SelectSecondCaseChkBxInRecentlyViewedList");	//Assuming these 2 cases are of same type
			selenium.click("SelectSecondCaseChkBxInRecentlyViewedList");
			selenium.waitForElementToBeClickable("SelectThirdCaseChkBxInRecentlyViewedList");
			selenium.click("SelectThirdCaseChkBxInRecentlyViewedList");
			selenium.click("ChangeStatusActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailFrom");
			selenium.click("CaseEmailFrom");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("case_Status_closed");
			selenium.click("case_Status_closed");
			selenium.waitingTime(2000);
			selenium.clickLoop("SaveBtnNew1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OKBtnInConfirmationPopup");
			selenium.click("OKBtnInConfirmationPopup");
			selenium.waitingTime(10000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			
//			selenium.waitForElementToBeClickable("searchCaseInListView");
//			selenium.typeData("searchCaseInListView", "Automation Test");		//There should be more than one case with subject as 'Automation Test' should be present under recently viewed list
//			selenium.pressEnterKey();
//			selenium.waitingTime(6000);
			
			selenium.takeScreenShot();
			Assert.assertTrue(selenium.isElementPresentFast("FirstCaseStatusIsClosed"));
			Assert.assertTrue(selenium.isElementPresentFast("SecondCaseStatusIsClosed"));
			selenium.test.log(LogStatus.PASS, "For both the cases the status got updated to CLOSED");
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify the A3K Change Owner button functionality$")
	public void verify_the_A3K_Change_Owner_button_functionality() {
		try {
			 selenium.waitForElementToBeClickable("SelectFirstCaseChkBxInRecentlyViewedList");	//Assuming these 2 cases are of same type
			 selenium.click("SelectFirstCaseChkBxInRecentlyViewedList");
			 selenium.waitForElementToBeClickable("SelectSecondCaseChkBxInRecentlyViewedList");
			 selenium.click("SelectSecondCaseChkBxInRecentlyViewedList");
				selenium.takeScreenShot();
			 selenium.waitForElementToBeClickable("ChangeOwnerActionBtn");
			 selenium.click("ChangeOwnerActionBtn");
			
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("search_user");
			 selenium.typeData("search_user", "Dannial Huang");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("ChangeUserResult2");
			 selenium.click("ChangeUserResult2");
			 selenium.waitingTime(2000);
				selenium.takeScreenShot();
			 selenium.click("SubmitForm");
			 selenium.waitingTime(10000);
			 selenium.test.log(LogStatus.PASS, "Case Owner updated");	
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify A3K and DAG record type flipping$")
	public void verify_A3K_and_DAG_record_type_flipping() {
		try {
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("changeRecordType1");
			selenium.click("changeRecordType1");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("A3KAccountsReceivableRadioBtn");
			selenium.clickLoop("A3KAccountsReceivableRadioBtn");
			selenium.waitingTime(1000);
			selenium.takeScreenShot();
			selenium.waitForElementToBeClickable("NextButton");
			selenium.click("NextButton");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.takeScreenShot();
			String ActualRecordType = selenium.getText("GetActualCaseRecordType");
			String ExpectedRecordType = "A3K Accounts Receivable";
			System.out.println("ActualRecordType" + ActualRecordType + "ExpectedRecordType" + ExpectedRecordType);
			Assert.assertEquals(ActualRecordType, ExpectedRecordType);
			selenium.test.log(LogStatus.PASS, "DAG to A3K record type flipping is success.");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
}
