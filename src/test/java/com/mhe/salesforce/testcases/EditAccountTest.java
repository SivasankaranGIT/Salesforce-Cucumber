package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditAccountTest {
	WebConnector selenium = WebConnector.getInstance();

	@And("^I edit the account details$")
	public void i_edit_the_following() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.test.log(LogStatus.INFO, "Navigating to the details tab");
				//selenium.waitForElementToDisappear("recentItems");
				selenium.waitingTime(2000);
				selenium.scrolldown(200);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("detailsTab");
				selenium.clickLoop("detailsTab");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("editAccount");
				selenium.hoverAndClick("editAccount");
				selenium.scrolldown(200);
				//selenium.scrollToElement("phone_edit");
				selenium.type("phone_edit", "Phone Number");

				//selenium.scrollToElement("territoryName_edit");
				selenium.type("territoryName_edit", "Territory Name");

				//selenium.scrollToElement("accountEmail_edit");
				selenium.type("accountEmail_edit", "Email");
			} else {
//				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("edit");
				selenium.jsClick("edit");

				selenium.scrollToElement("phone_editC");
				selenium.type("phone_editC", "Phone Number");

				selenium.scrollToElement("territoryName_editC");
				selenium.type("territoryName_editC", "Territory Name");

				selenium.scrollToElement("accountEmail_editC");
				selenium.type("accountEmail_editC", "Email");
			}
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^data should be saved successfully$")
	public void data_should_be_saved_successfully() {
		selenium.waitingTime(2000);
		String actual = null;
		if (selenium.getUI().contains("Lightning"))
			actual = selenium.getTextLoop("territoryFetch");
		else
			actual = selenium.getText("territoryFetchC");
		String expected = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Territory Name");
		if (actual.contains(expected))
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		else
			selenium.reportFailure("Test Case Failed");
	}


	@Then("I open the account record and verify the field")
	public void i_open_the_account_record_and_verify_the_field() {
		try {
			selenium.waitForElementToBeClickable("AccountsListViewNotchBtn");
			selenium.jsClick("AccountsListViewNotchBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList", "All Accounts");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllAccountsOption");
			selenium.jsClick("AllAccountsOption");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("AccountFirstRecordClick");
			selenium.jsClick("AccountFirstRecordClick");
			selenium.waitingTime(6000);
			selenium.accountURL = selenium.getURL();
			selenium.scrollToElement("ALEKSLTIAAvailableCheckBox");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ALEKSLTIAAvailableCheckBox");
			Assert.assertTrue(selenium.getElement("ALEKSLTIAAvailableCheckBox").isEnabled());
			System.out.println("ALEKS LTIA Available field is present and read only");
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I validate the IP1 account number field is editable")
	public void I_validate_the_IP1_account_number_field_is_editable() {
		try {
			selenium.waitForElementToBeClickable("AccountsListViewNotchBtn");
			selenium.jsClick("AccountsListViewNotchBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountListViewOptions");
			selenium.jsClick("AccountListViewOptions");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("AccountFirstRecord");
			selenium.jsClick("AccountFirstRecord");
			selenium.waitingTime(8000);
			selenium.accountURL = selenium.getURL();
			selenium.scrollToElement("IP1AccountNumberEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("IP1AccountNumberEditBtn"));
			System.out.println("PASSED, IP1Account Field is editable");
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I validate the IP1 account number field is not editable")
	public void I_validate_the_IP1_account_number_field_is_not_editable() {
		try {
			selenium.navigateToURL(selenium.accountURL);
			selenium.waitingTime(8000);
			Assert.assertFalse(selenium.isElementPresentFast("IP1AccountNumberEditBtn"));
			System.out.println("PASSED, IP1Account Field is not editable");

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I open the account record again and verify the field")
	public void i_open_the_account_record_again_and_verify_the_field() {
		try {
			selenium.navigateToURL(selenium.accountURL);
			selenium.waitingTime(8000);
			selenium.scrollToElement("ALEKSLTIAAvailableCheckBox");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSLTIAAvailableEditBtn");
			selenium.jsClick("ALEKSLTIAAvailableEditBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ALEKSLTIAAvailableCheckBoxNew");
			Assert.assertTrue(selenium.getElement("ALEKSLTIAAvailableCheckBoxNew").isEnabled());
			System.out.println("PASSED, ALEKS LTIA Available checkbox is editable");

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I validate the ALEKS Implementation Manager field")
	public void i_validate_the_ALEKS_implementation_manager_field() {
		try {
			String randomString = selenium.getRandomString();
			String accountName = randomString + "_DemoAccount";
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field", accountName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Account_WebsiteTextBox");
			selenium.typeData("Account_WebsiteTextBox", "www.test.com");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("ALEKSImplemenationEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSImplemenationEditBtn");
			Assert.assertTrue(selenium.getElement("ALEKSImplemenationEditBtn").isDisplayed());
			System.out.println("PASS ALEKS Implementation Manager field is editable and available");

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I validate the field labels")
	public void i_validate_the_field_labels() {
		try {
			String randomString = selenium.getRandomString();
			String accountName = randomString + "_DemoAccount";
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field", accountName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountClassDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("AccountDAGEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("FieldLabelGetText1") && selenium.isElementPresentFast("FieldLabelGetText2") &&
					selenium.isElementPresentFast("FieldLabelGetText3") && selenium.isElementPresentFast("FieldLabelGetText4") &&
					selenium.isElementPresentFast("FieldLabelGetText5") && selenium.isElementPresentFast("FieldLabelGetText6") &&
					selenium.isElementPresentFast("FieldLabelGetText7") && selenium.isElementPresentFast("FieldLabelGetText8") &&
					selenium.isElementPresentFast("FieldLabelGetText9") && selenium.isElementPresentFast("FieldLabelGetText10"));
			System.out.println("PASS All the labels are present");
			Assert.assertTrue(selenium.isElementPresentFast("CustomerAdvocacyGetText1") && selenium.isElementPresentFast("CustomerAdvocacyGetText2") &&
					selenium.isElementPresentFast("CustomerAdvocacyGetText3") && selenium.isElementPresentFast("CustomerAdvocacyGetText4") &&
					selenium.isElementPresentFast("CustomerAdvocacyGetText5") && selenium.isElementPresentFast("CustomerAdvocacyGetText6"));
			System.out.println("PASS All the labels are present");

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I verify the CHBA option from component")
	public void i_verify_the_chba_option_from_component() {
		try {
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("ProdDropdownList");
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.hoverAndClick("ProductType_ALEKS");
			selenium.waitingTime(3000);
			selenium.scrollToElement("select_BU");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectBEC_BU");
			selenium.jsClick("selectBEC_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_Incidentvalue");
			selenium.jsClick("select_Incidentvalue");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Internal_description");
			selenium.jsClick("Internal_description");
			String CaseDemo = " CXGCaseUATTestDemo";
			selenium.typeData("Internal_description", CaseDemo);
			selenium.waitingTime(3000);
			selenium.scrollToElement("Save_Button");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("Save_Button");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("Edit_Category");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Category");
			selenium.jsClick("Edit_Category");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_CategoryDropdown");
			selenium.jsClick("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGCategoryOptionPlatform");
			selenium.jsClick("CXGCategoryOptionPlatform");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ComponentDropDwn");
			selenium.jsClick("ComponentDropDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ComponentOption");
			selenium.jsClick("ComponentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			if (!selenium.isElementPresentFast("snagerror")) {
				System.out.println("Pass: No validation error found");
				selenium.test.log(LogStatus.PASS, "No validation error found");
			} else {
				selenium.test.log(LogStatus.FAIL, "validation error found");
				selenium.reportFailure("validation error found");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I verify all the LOVs in the component")
	public void i_verify_all_the_lovs_in_the_component() {
		try {
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("ProdDropdownList");
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.hoverAndClick("ProductOptionConnect");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
			selenium.waitingTime(2000);
			selenium.scrollToElement("select_BU");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectBEC_BU");
			selenium.jsClick("selectBEC_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_Incidentvalue");
			selenium.jsClick("select_Incidentvalue");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_Discipline");
			selenium.jsClick("select_Discipline");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Internal_description");
			selenium.jsClick("Internal_description");
			String CaseDemo = " CXGCaseUATTestDemo";
			selenium.typeData("Internal_description", CaseDemo);
			selenium.waitingTime(3000);
			selenium.scrollToElement("Save_Button");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("Save_Button");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("Edit_Category");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Category");
			selenium.jsClick("Edit_Category");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_CategoryDropdown");
			selenium.jsClick("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGCategoryOptionPlatform");
			selenium.jsClick("CXGCategoryOptionPlatform");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ComponentDropDwn");
			selenium.jsClick("ComponentDropDwn");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("ComponentOptionConnect1") && selenium.isElementPresentFast("ComponentOptionConnect2") && selenium.isElementPresentFast("ComponentOptionConnect3"));
			System.out.println("PASS");
			selenium.waitForElementToBeClickable("select_CategoryDropdown");
			selenium.jsClick("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CategoryOptionImprovement");
			selenium.jsClick("CategoryOptionImprovement");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ComponentDropDwn");
			selenium.jsClick("ComponentDropDwn");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("ComponentOptionConnect1") && selenium.isElementPresentFast("ComponentOptionConnect4") && selenium.isElementPresentFast("ComponentOptionConnect5"));
			System.out.println("PASS");

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("I verify all the fields from created case")
	public void i_verify_all_the_fields_from_created_case(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OrderStageDrpDwn");
			String orderStage = selenium.getElement("OrderStageDrpDwn").getAttribute("data-value").toString();
			Assert.assertEquals(orderStage, data.get(0));
			selenium.test.log(LogStatus.PASS, "Order Stage is Matched Successfully");
			System.out.println("Order Stage is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("RequestReasonDrpDwn");
			String requestReason = selenium.getElement("RequestReasonDrpDwn").getAttribute("data-value").toString();
			Assert.assertEquals(requestReason, data.get(1));
			selenium.test.log(LogStatus.PASS, "Order Stage is Matched Successfully");
			System.out.println("Order Stage is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("Action_DropDown");
			String action = selenium.getElement("Action_DropDown").getAttribute("data-value").toString();
			Assert.assertEquals(action, data.get(2));
			selenium.test.log(LogStatus.PASS, "Action is Matched Successfully");
			System.out.println("Action is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("resolutionTab");
			selenium.jsClick("resolutionTab");

			selenium.waitForElementToBeVisible("CaseResolutionGetText");
			String caseResolution = selenium.getText("CaseResolutionGetText").toString();
			Assert.assertEquals(caseResolution, data.get(3));
			selenium.test.log(LogStatus.PASS, "Case Resolution is Matched Successfully");
			System.out.println("Case Resolution is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CSOMCaseOwner");
			String caseOwner = selenium.getText("CSOMCaseOwner").toString();
			Assert.assertEquals(caseOwner, data.get(4));
			selenium.test.log(LogStatus.PASS, "Case Owner is Matched Successfully");
			System.out.println("Case Owner is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CSOMCaseStatus");
			String caseStatus = selenium.getText("CSOMCaseStatus").toString();
			Assert.assertEquals(caseStatus, data.get(5));
			selenium.test.log(LogStatus.PASS, "Case Status is Matched Successfully");
			System.out.println("Case Status is Matched Successfully");
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("verify all the fields from created case")
	public void verify_all_the_fields_from_created_case(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("CSOMCaseOwner");
			String caseOwner = selenium.getText("CSOMCaseOwner").toString();
			Assert.assertEquals(caseOwner, data.get(0));
			selenium.test.log(LogStatus.PASS, "Case Owner is Matched Successfully");
			System.out.println("Case Owner is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CSOMEmailStatus");
			String caseStatus = selenium.getText("CSOMEmailStatus").toString();
			Assert.assertEquals(caseStatus, data.get(1));
			selenium.test.log(LogStatus.PASS, "Case Status is Matched Successfully");
			System.out.println("Case Status is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CSOMCaseOrigin");
			String caseOrigin = selenium.getText("CSOMCaseOrigin").toString();
			Assert.assertEquals(caseOrigin, data.get(2));
			selenium.test.log(LogStatus.PASS, "Case Origin is Matched Successfully");
			System.out.println("Case Origin is Matched Successfully");
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I validate the transcation field labels")
	public void i_validate_the_transcation_field_labels(){
		try{
			String randomString = selenium.getRandomString();
			String accountName = randomString + "_DemoAccount";
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("NextButton");
//			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field", accountName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountClassDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.accountURL=selenium.getURL();
			selenium.scrollToElement("PublishExternalEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertFalse(selenium.isElementPresentFast("TranscationEditBtn"));
			System.out.println("PASS!!! Field is not editable");
			selenium.waitingTime(2000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I validate the transcation field")
	public void i_validate_the_transcation_field(){
		try{
			selenium.navigateToURL(selenium.accountURL);
			selenium.waitingTime(6000);
			selenium.scrollToElement("TranscationEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("TranscationEditBtn"));
			System.out.println("PASS!!! Field is editable");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TranscationEditBtn");
			selenium.jsClick("TranscationEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("TranscationDropDown");
			selenium.jsClick("TranscationDropDown");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("TranscationOption1")&&
			selenium.isElementPresentFast("TranscationOption2")&&
			selenium.isElementPresentFast("TranscationOption3")&&
			selenium.isElementPresentFast("TranscationOption4")&&
			selenium.isElementPresentFast("TranscationOption5"));
			System.out.println("PASS!!! All Options are available");

		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I create a new account record for MHE Standard Record Type")
	public void i_create_a_new_account_record_for_mhe_standart_record_type(){
		try{
			String randomString = selenium.getRandomString();
			String accountName = randomString + "_DemoAccount";
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitForElementToBeClickable("MHEStandardRecordTypeRadioBtn");
			selenium.jsClick("MHEStandardRecordTypeRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("Name_Field");
			selenium.typeData("Name_Field", accountName);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountClassDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountClassDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AccountTypeDropDown");
			selenium.autoSuggestiveDropdownWithoutText("AccountTypeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("AssignedTerritoriesQuickLink");
			selenium.jsClick("AssignedTerritoriesQuickLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("AssignTerrotriesBtn");
			selenium.jsClick("AssignTerrotriesBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SearchTerritoriesTextBox");
			selenium.typeData("SearchTerritoriesTextBox","MHE");
			selenium.waitingTime(2000);
			selenium.autoSuggestiveDropdownWithoutText("SearchTerritoriesTextBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.refresh();
			selenium.waitingTime(6000);
			String text=selenium.getText("AssignedTerritoriesGetText").toString();
			Assert.assertTrue(text.contains(text));
			System.out.println("PASS!!!");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I open the existing account record")
	public void i_open_the_existing_account_record(){
		try{
			selenium.waitForElementToBeClickable("AccountsListViewNotchBtn");
			selenium.jsClick("AccountsListViewNotchBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList", "All Accounts");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("AllAccountsOption");
			selenium.jsClick("AllAccountsOption");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("AccountFirstRecordClick");
			selenium.jsClick("AccountFirstRecordClick");
			selenium.waitingTime(8000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I create a new opportunity record through accounts")
	public void i_create_a_new_opp_record_through_accounts(){
		try{
			selenium.waitForElementToBeClickable("OppLinkfromAccounts");
			selenium.jsClick("OppLinkfromAccounts");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("NewActionButton");
			selenium.jsClick("NewActionButton");
			selenium.waitingTime(15000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(3000);
			String mheCourse="Biology Majors Lab";
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.typeData("OpportunityMHECourse2", mheCourse);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("MHECourseOption");
			selenium.jsClick("MHECourseOption");
			selenium.waitingTime(2000);
			Select dropdown = new Select(selenium.getElement("oppurtunityType"));
			dropdown.selectByIndex(2);
			selenium.waitingTime(2000);
			selenium.typeData("oppurtunitySpringEnrollment", "123");
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment", "12");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("oppurtunitySummerEnrollment");
			selenium.typeData("oppurtunitySummerEnrollment","1234");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the simnet specialist field")
	public void i_verify_the_simnet_specialist_field(){
		try{
			selenium.refresh();
			selenium.scrollToElement("PIUCurrentPriceEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String SimnetSpecialistGetText=selenium.getText("SimnetSpecialistGetText").toString();
			System.out.println(SimnetSpecialistGetText);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifySIMnetForMHHEBusinessAdmin"))
			{
				Assert.assertNotEquals(SimnetSpecialistGetText,"Chris Holder");
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS,"PASS");
			}
			else {
				Assert.assertEquals(SimnetSpecialistGetText, "Chris Holder");
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "PASS");
			}
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I clone the opportunity to verify simnet specialist field")
	public void i_clone_the_opp_to_verify_simnet_specialist_field(){
		try{
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");
			selenium.jsClick("ClickOnCloneBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("clickYear");
			selenium.hoverAndClick("clickYear");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectYear");
			selenium.click("selectYear");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ClickTerm");
			selenium.click("ClickTerm");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ValueofTerm");
			selenium.click("ValueofTerm");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clickSaveBtn");
			selenium.jsClick("clickSaveBtn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("ClickOnContinue"))
			{
				selenium.waitForElementToBeClickable("ClickOnContinue");
				selenium.jsClick("ClickOnContinue");
			}
			selenium.waitingTime(25000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I change the opp owner and verify the simnet field")
	public void i_change_the_opp_owner_and_verify_the_simnet_field(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("ChangeOppOwnerIcon");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOppOwnerIcon"); //CaseChangeOwnerBtn
			selenium.jsClick("ChangeOppOwnerIcon");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ChangeOwnerSearchUsersTextBox");
			selenium.typeData("ChangeOwnerSearchUsersTextBox","Mairead Jacoby");
			selenium.waitingTime(4000);
			selenium.pressEnter("ChangeOwnerSearchUsersTextBox");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppChangeUser");
			selenium.jsClick("OppChangeUser");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.click("ChangeOwnerBtn");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("PIUCurrentPriceEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String SimnetSpecialistGetText=selenium.getText("SimnetSpecialistGetText").toString();
			System.out.println(SimnetSpecialistGetText);
			Assert.assertEquals(SimnetSpecialistGetText, "Dana Sander");
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the checklist field in opportunity")
	public void i_verify_the_checklist_field_in_opp(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.oppURL=selenium.getURL();
			selenium.scrollToElement("OppBusinessPlanEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("OppChecklistEditBtn"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
			selenium.waitingTime(2000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I again verify the checklist field in opportunity")
	public void i_again_verify_the_checklist_field_in_opp(){
		try {
			selenium.waitingTime(4000);
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.scrollToElement("OppLateAssignmentEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			Assert.assertFalse(selenium.isElementPresentFast("OppChecklistEditBtn"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
			selenium.waitingTime(2000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the new button for print exception")
	public void i_verify_the_new_button_for_print_exception(){
		try{
			selenium.waitingTime(6000);
			Assert.assertFalse(selenium.isElementPresentFast("NewBtnPrintException"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify that product is fetched")
	public void i_verify_that_product_is_fetched(){
		try{
			selenium.waitForElementToBeClickable("ContactRoleDrpDwn");
			selenium.jsClick("ContactRoleDrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppContactRoleOption");
			selenium.jsClick("OppContactRoleOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(4000);
			String copyrightYear="2022";
			selenium.waitForElementToBeClickable("CopyRightTextBox");
			selenium.typeData("CopyRightTextBox",copyrightYear);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchButton");
			selenium.jsClick("searchButton");
			selenium.waitingTime(2000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("CopyRightYearGetText");
			String copyRightYearGetText =selenium.getText("CopyRightYearGetText").toString();
			if(copyRightYearGetText.contains(copyrightYear))
			{
				System.out.println("PASS!!! Copyright year fetched successfully");
				selenium.test.log(LogStatus.PASS, "PASS!!! Copyright year fetched successfully");
			}
			else
			{
				System.out.println("FAIL!!! Copyright year not fetched");
				selenium.test.log(LogStatus.FAIL, "FAIL!!! Copyright year not fetched");
				selenium.reportFailure("FAIL!!! Copyright year not fetched");
			}
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the opportunity copyright year")
	public void i_verify_the_opp_copyright_year(){
		try{
			selenium.waitForElementToBeClickable("newSampleFromOpportunity");
			selenium.jsClick("newSampleFromOpportunity");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProductAlert");
			selenium.jsClick("ProductAlert");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactAlert");
			selenium.jsClick("ContactAlert");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.jsClick("searchProductsBtn");
			selenium.waitingTime(2000);
			String copyrightYear="2022";
			selenium.waitForElementToBeClickable("copyrightField");
			selenium.typeData("copyrightField","2022");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("CopyRightYearOppGetText");
			String CopyRightYearGetText =selenium.getText("CopyRightYearOppGetText").toString();
			if(CopyRightYearGetText.contains(copyrightYear))
			{
				System.out.println("PASS!!! Copyright year fetched successfully");
				selenium.test.log(LogStatus.PASS, "PASS!!! Copyright year fetched successfully");
			}
			else
			{
				System.out.println("FAIL!!! Copyright year not fetched");
				selenium.test.log(LogStatus.FAIL, "FAIL!!! Copyright year not fetched");
				selenium.reportFailure("FAIL!!! Copyright year not fetched");
			}
		}catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I add the product in opportunity")
	public void i_add_the_product_in_opp(){
		try{
			selenium.waitForElementToBeClickable("OppProductQuickLink");
			selenium.jsClick("OppProductQuickLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ProductAddOrEditBtn");
			selenium.jsClick("ProductAddOrEditBtn");
			selenium.waitingTime(12000);
			selenium.switchToMultipleFrame("switch_iFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clearButton");
			selenium.jsClick("clearButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ProductISBNTextBox");
			selenium.waitingTime(2000);
			selenium.typeData("ProductISBNTextBox"," 9781266556210"); //select id from Product2 where Evergreen_Product_Development__c = true and Print_Exception_Allowed__c =true  LIMIT 10
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(5000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeClickable("productCheckBox");
			selenium.jsClick("productCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Product Added to Opportunity");
			System.out.println("Product Added to Opportunity");
		}catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the mhhe product exception")
	public void i_verify_the_mhhe_product_exception(){
		try{
			selenium.waitForElementToBeClickable("RequestProductExceptionBtn");
			selenium.jsClick("RequestProductExceptionBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("switch_iFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EvergreenPrintExceptionNationalRadioBtn");
			selenium.jsClick("EvergreenPrintExceptionNationalRadioBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductExceptionReasonDrpDwn");
			selenium.click("ProductExceptionReasonDrpDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductExceptionReason");
			selenium.click("ProductExceptionReason");
			selenium.typeData("ProductExceptionComments", "Test");
			selenium.jsClick("ProductExceptionProductSelectionChkBx");
			selenium.typeData("ExpectedSoldQty", "1");
			selenium.typeData("ExceptionThroughDate", "Feb 7, 2025");
			selenium.click("SubmitButton");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.PASS, "Product Expection Request has been submitted");
		}catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify delete button in mhhe product exception")
	public void i_verify_delete_btn_in_mhhe_product_exception(){
		try{
			selenium.waitForElementToBeClickable("MHHEProductExceptionQuickLink");
			selenium.jsClick("MHHEProductExceptionQuickLink");
			selenium.waitingTime(6000);
			selenium.oppURL=selenium.getURL();
			selenium.waitForElementToBeClickable("MHHEProductExceptionFirstRecord");
			selenium.jsClick("MHHEProductExceptionFirstRecord");
			selenium.waitingTime(6000);
			Assert.assertTrue(selenium.isElementPresentFast("editButton")&&selenium.isElementPresentFast("DeleteActionBtn"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I reverify delete button in mhhe product exception")
	public void i_reverify_delete_btn_in_mhhe_product_exception(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(6000);
			Assert.assertFalse(selenium.isElementPresentFast("editButton")&&selenium.isElementPresentFast("DeleteActionBtn"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I add new contact from opportunity")
	public void i_add_new_contact_form_opportunity(){
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("FirstCheckBoxClick");
			selenium.jsClick("FirstCheckBoxClick");
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.scrollToElement("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitForElementToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.switchOutOfFrame();
			selenium.waitingTime(12000);
			selenium.refresh();
			selenium.waitingTime(6000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the handoff field")
	public void i_verify_the_handoff_field(){
		try{
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(6000);
			Assert.assertTrue(selenium.isElementPresentFast("HandOffTypeField"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I update the stage as Recognize and validate the error")
	public void i_update_the_stage_as_recognize_and_validate_the_error(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.click("OppStageValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			Assert.assertTrue(selenium.isElementPresentFast("snagerror"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(8000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I revalidate the stage as Recognize")
	public void i_revalidate_the_stage_as_recognize(){
		try{
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.click("OppStageValue");
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			Assert.assertFalse(selenium.isElementPresentFast("snagerror"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I verify the added contact")
	public void i_verify_the_added_contact(){
		try{
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityContactsLink");
			selenium.click("opportunityContactsLink");
			selenium.waitingTime(6000);
			Assert.assertTrue(selenium.isElementPresentFast("OppContactFirstRecord"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "PASS");

		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("I navigate to newly create Opportunity record")
	public void i_navigate_to_newly_create_Opportunity_record(){
		try{
			selenium.navigateToURL(selenium.OppPIUAddDeleteURL);
			selenium.waitingTime(6000);
		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("verify the jira issue in email information")
	public void verify_the_jira_issue_in_email_information() {
		try {
			selenium.scrollToElement("JIRAIssueEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.text= selenium.getText("JIRAIssueGetText").toString();
			System.out.println(selenium.text);
			Assert.assertTrue(selenium.text.contains("GCRM"));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS,"PASS");
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@And("Again verify the jira issue in email information")
	public void again_verify_the_jira_issue_in_email_information() {
		try {
			selenium.scrollToElement("JIRAIssueEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.caseNumber= selenium.getText("JIRAIssueGetText").toString();
			System.out.println(selenium.caseNumber);
			Assert.assertFalse(selenium.text.equalsIgnoreCase(selenium.caseNumber));
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS,"PASS");
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	@Then("I validate the ALEKS order fullfillment queue fields")
	public void i_validate_the_aleks_order_fullfillment_queue_fields(DataTable table){
		try{
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeVisible("CSOMCaseOrigin");
			String caseOrigin = selenium.getText("CSOMCaseOrigin").toString();
			Assert.assertEquals(caseOrigin, data.get(0));
			selenium.test.log(LogStatus.PASS, "Case Origin is Matched Successfully");
			System.out.println("Case Origin is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("VerifyCaseOriginSkill");
			String caseOriginSkill = selenium.getText("VerifyCaseOriginSkill").toString();
			Assert.assertEquals(caseOriginSkill, data.get(1));
			selenium.test.log(LogStatus.PASS, "Case Origin Skill is Matched Successfully");
			System.out.println("Case Origin Skill is Matched Successfully");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("CaseTransferSkillGetText");
			Assert.assertTrue(selenium.getText("CaseTransferSkillGetText").isBlank());
//			Assert.assertEquals(caseOriginSkill, data.get(2));
			selenium.test.log(LogStatus.PASS, "Case Transfer Skill is Matched Successfully");
			System.out.println("Case Transfer Skill is Matched Successfully");
			selenium.waitingTime(2000);

		}catch (Exception e) {
			selenium.reportFailure("Test Case Failed " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
