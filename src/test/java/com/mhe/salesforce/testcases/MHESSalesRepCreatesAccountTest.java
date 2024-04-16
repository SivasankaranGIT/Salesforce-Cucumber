package com.mhe.salesforce.testcases;

import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESSalesRepCreatesAccountTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
	int count=0;

	@And("^create new Account by filling mandatory fields$")
	public void create_new_Account_by_filling_mandatory_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.waitForElementToBeClickable("new");
				selenium.click("new");
				selenium.waitingTime(4000);
				selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
				selenium.waitForElementToBeClickable("nextBtn");
				selenium.click("nextBtn");
				//selenium.typeRandomstring("accountNameField", WebConnector.ACC_NAME_RANDOM);
				String accnt= selenium.getRandomString();
				selenium.getElement("accountNameField").sendKeys(accnt);
				selenium.type("serach_Account", "Parent Account Name");
				selenium.waitingTime(2000);
				selenium.clickDynamic("strongdynamic", "Name", "end");
				selenium.scrollToElement("workflowNotesTextField");
				selenium.type("workflowNotesTextField", "Workflow Notes");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("save");

				selenium.click("save");
				selenium.waitingTime(1000);
				flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
				selenium.printLastTestResult(flagsuccess);
				selenium.waitingTime(2000);

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
				selenium.click("CancelButton");
			}

		}
	}

	@Then("^I validate the account creation success message$")
	public void validate_the_accoungt_creation_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		} else if (selenium.getUI().equalsIgnoreCase("classic")) {
			selenium.printLastTestResult(flagsuccess);
		}
	}

	@Then("^Verify the Details of the account record created$")
	public void verify_details_of_the_account_record_created() {

		selenium.waitingTime(4000);
		String accountStatus = null;
		String workflowStatus = null;
		String expected_accntStatus = null;
		String expected_workflowStatus = null;
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.refresh();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("accountStatusText");
			selenium.scrollToElement("accountStatusText");
			accountStatus = selenium.getText("accountStatusText").toString();
			selenium.scrollToElement("workflowStatusText");
			workflowStatus = selenium.getText("workflowStatusText").toString();
			expected_accntStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Status");
			expected_workflowStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Workflow Status");
			selenium.test.log(LogStatus.INFO,
					"Account Status and Workflow Status are: " + accountStatus + "and" + workflowStatus);

			url = selenium.getURL();
			if (accountStatus.equalsIgnoreCase(expected_accntStatus)
					&& workflowStatus.equalsIgnoreCase(expected_workflowStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^Verify approver name$")
	public void verify_approver_name() {
		try {
		String approverName = null;
		String expected_approver = null;
		selenium.refresh();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("showAllLinks");
		selenium.click("showAllLinks");
		selenium.waitingTime(2000);
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("approvalHistoryLink");
			selenium.click("approvalHistoryLink");

		} else {
			selenium.waitForElementToBeClickable("approvalHistoryLink");
			selenium.click("approvalHistoryLink");
		}
		selenium.waitingTime(4000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Step Name", "endContains");
//		selenium.waitForXpathElementToBeClickable(Xpath);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
		approverName = selenium.getText("actualApproverNameText").toString();
		expected_approver = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("User Name");

		if (approverName.equalsIgnoreCase(expected_approver)) {
			selenium.test.log(LogStatus.INFO, "Approver name is: " + approverName);
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");

		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@Then("^I navigate to Sales Home page$")
	public void I_navigate_to_Sales_Home_page() {
		try {
			selenium.waitingTime(20000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.typeData("searchItemsTextField", "Sales");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("salesOptionFromMenu");
		selenium.jsClick("salesOptionFromMenu");
		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I navigate to CSOM Lightning Console Home page$")
	public void I_navigate_to_CSOM_Home_page() {
		try {
			selenium.waitingTime(20000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.typeData("searchItemsTextField", "CSOM Lightning Console");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("CSOMLightningConsole");
		selenium.jsClick("CSOMLightningConsole");
		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^I navigate to MHHE Mass Opportunity Cloning page$")
	public void I_navigate_to_MHHE_Mass_Opportunity_Cloning_page() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "MHHE Mass Opportunity Cloning");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MassOppCloneOptionFromMenu");
			selenium.jsClick("MassOppCloneOptionFromMenu");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("^I navigate to MHHE Opportunity Cloning Users page$")
	public void I_navigate_to_MHHE_Opportunity_Cloning_Users_page() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "MHHE Opportunity Cloning Users");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MHHEOppCloneUsers");
			selenium.jsClick("MHHEOppCloneUsers");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("^mass delete all users from MHHE Opp Cloning Users list view$")
	public void mass_delete_all_users_from_MHHE_Opp_Cloning_Users_list_view() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("FirstRecordCheckbox");
			selenium.click("FirstRecordCheckbox");
			selenium.click("SecondRecordCheckbox");
			selenium.waitingTime(2000);
			selenium.click("MassDeleteUserBtn");
			selenium.waitingTime(4000);
			selenium.switchToFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("MassDeleteUserYESBtn");
			selenium.click("MassDeleteUserYESBtn");		
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			
			if(selenium.isElementPresentFast("MassDeleteUserSuccessMsg"))
			{
				selenium.test.log(LogStatus.PASS, "Mass user deletion successful!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
		 	else
		 	{
				selenium.test.log(LogStatus.FAIL, "Mass user deletion failed!");
				selenium.reportFailure("Mass user deletion failed!");
				System.out.println("FAIL");
			}
			selenium.click("FinishButton");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Mass user deletion failed!");
			selenium.reportFailure("Mass user deletion failed! " + e.getMessage());
		}
	}

	@Then("^I navigate to INTL Sample Check Home page$")
	public void I_navigate_to_INTL_Sample_Check_Home_page() {
		try {
			selenium.waitingTime(20000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.typeData("searchItemsTextField", "INTL Sample Check");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("INTLSampleCheckOptionFromMenu");
		selenium.jsClick("INTLSampleCheckOptionFromMenu");
		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^I login as different user$")
	public void i_login_as_sales_rep() {
		try {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("globalSearch");
			selenium.type("globalSearch", "User");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("salesrepsearch");
			selenium.click("salesrepsearch");
//			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("people_uat");
			selenium.click("people_uat");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath("salesrepUserL", "User", "end");
			selenium.getXpathElement(xpath).click();
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("userDetail");
			selenium.jsClick("userDetail");
			selenium.waitingTime(3000);
			selenium.retryingWait("setup");
			selenium.waitingTime(3000);
			selenium.switchToFrame("newAccountFrame");
			selenium.click("loginSalesrep");
			selenium.waitingTime(3000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Login as sales rep successful!");
		} catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^I approve the account created$")
	public void I_approve_the_account_created() {
		try {
		selenium.navigateToURL(url);
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("showAllLinks");
		selenium.click("showAllLinks");
		selenium.waitingTime(2000);
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("approvalHistoryLink");
			selenium.click("approvalHistoryLink");
		} else {
			selenium.waitForElementToBeClickable("approvalHistoryLink");
			selenium.click("approvalHistoryLink");
		}
		// String xpath = selenium.getDynamicXpath("anchorTitlecontains", "Step Name",
		// "endContains");
		// selenium.clickLoopXpath(xpath);
		selenium.waitForElementToBeClickable("approveBtn");
		selenium.click("approveBtn");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("commentsTextArea");
		selenium.type("commentsTextArea", "Comments");
		selenium.waitForElementToBeClickable("ApproveBtn");
		selenium.click("ApproveBtn");
		selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Verify the details of the account record created$")
	public void verify_Details_of_the_account_record_created() {

		selenium.waitingTime(4000);
		String accountStatus = null;
		String workflowStatus = null;
		String expected_accntStatus = null;
		String expected_workflowStatus = null;
		try {
		if (selenium.getUI().contains("Lightning")) {
			//selenium.refresh();
			selenium.waitingTime(2000);
			/*String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
			selenium.clickLoopXpath(Xpath);*/
			selenium.navigateToURL(url);
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("accountStatusText");
			selenium.scrollToElement("accountStatusText");
			accountStatus = selenium.getText("accountStatusText").toString();
			selenium.scrollToElement("workflowStatusText");
			workflowStatus = selenium.getText("workflowStatusText").toString();
			expected_accntStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Status New");
			expected_workflowStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0)
					.get("Workflow Status New");
			selenium.test.log(LogStatus.INFO,
					"Account Status and Workflow Status are: " + accountStatus + "and" + workflowStatus);

			if (accountStatus.equalsIgnoreCase(expected_accntStatus)
					&& workflowStatus.equalsIgnoreCase(expected_workflowStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Verify the details for approved status$")
	public void verify_details_of_approved_status() {

		selenium.waitingTime(4000);
		String accountStatus = null;
		String workflowStatus = null;
		String expected_accntStatus = null;
		String expected_workflowStatus = null;
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.refresh();
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
//			selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.scrollToElement("accountStatusText");
			accountStatus = selenium.getText("accountStatusText").toString();
			selenium.scrollToElement("workflowStatusText");
			workflowStatus = selenium.getText("workflowStatusText").toString();
			expected_accntStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Status New");
			expected_workflowStatus = selenium.getExcelValue(selenium.getTestCaseName()).get(0)
					.get("Workflow Status New");
			selenium.test.log(LogStatus.INFO,
					"Account Status and Workflow Status are: " + accountStatus + "and" + workflowStatus);

			if (accountStatus.equalsIgnoreCase(expected_accntStatus)
					&& workflowStatus.equalsIgnoreCase(expected_workflowStatus)) {
				selenium.test.log(LogStatus.PASS, "Test Case Passed!");

			} else {
				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@And("^check product vital source availability$")
	public void check_product_vital_source_availability() {
		try
		{
			selenium.waitingTime(10000);

			if(selenium.isElementPresentFast("newAccountFrame")) {
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
				selenium.type("VitalSourceISBNSearch", "ISBN1");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("newAccountFrame");
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
				selenium.type("VitalSourceISBNSearch", "ISBN1");
			}

			selenium.waitForElementToBeClickable("GetVitalSourceDataBtn");
			selenium.click("GetVitalSourceDataBtn");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("VitalSourceValidMessage"))
			{
				selenium.test.log(LogStatus.PASS, "<b>Verified the mesage - Product can be sampled</b>");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "<b>Unable to verify the mesage - Product can be sampled</b>");
				selenium.reportFailure("<b>Unable to verify the mesage - Product can be sampled</b>");
			}

			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
			selenium.type("VitalSourceISBNSearch", "ISBN2");
			selenium.waitForElementToBeClickable("GetVitalSourceDataBtn");
			selenium.click("GetVitalSourceDataBtn");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("VirtalSourceInvalidMessage"))
			{
				selenium.test.log(LogStatus.PASS, "<b>Verified the mesage - No Records available with this ISBN.\r\n</b>"
						+ "");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "<b>Unable to verify the mesage - No Records available with this ISBN.\r\n</b>"
						+ "");
				selenium.reportFailure("<b>Unable to verify the mesage - No Records available with this ISBN.\r\n</b>"
						+ "");
			}
			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying vital source availability");
			selenium.reportFailure("Error while verifying vital source availability" + e.getMessage());
		}
	}

	@And("^check Vitalsource product cannot be Sampled validation$")
	public void check_Vitalsource_product_cannot_be_Sampled_validation() {
		try
		{
			selenium.waitingTime(10000);

			if(selenium.isElementPresentFast("newAccountFrame")) {
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
				selenium.type("VitalSourceISBNSearch", "ISBN3");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("newAccountFrame");
				selenium.switchToFrame("newAccountFrame");
				selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
				selenium.type("VitalSourceISBNSearch", "ISBN3");
			}

			selenium.waitForElementToBeClickable("GetVitalSourceDataBtn");
			selenium.click("GetVitalSourceDataBtn");
			selenium.waitingTime(3000);
			String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Virtalsource Validation Message", "endContains");
			selenium.waitingTime(4000);
			System.out.println(validationMessage);
			if(selenium.isElementPresentXpathFast(validationMessage))
			{
				selenium.test.log(LogStatus.PASS, "<b>This Product is not set to \"Sampleable\" or \"Type is not Single\" or \"Digital List Price = 0\" or \"Distributable = false\" or \"The value in the product Print ISBN & SKU are same in the vitalsource object\"\r\n"
						+ " - Validation Message Appearead</b>");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
		 	else
		 	{
				selenium.test.log(LogStatus.FAIL, "<b>This Product is not set to \"Sampleable\" or \"Type is not Single\" or \"Digital List Price = 0\" or \"Distributable = false\" or \"The value in the product Print ISBN & SKU are same in the vitalsource object\"\r\n"
						+ " - Validation Message Did Not Appear</b>");
				selenium.reportFailure("<b>This Product is not set to \"Sampleable\" or \"Type is not Single\" or \"Digital List Price = 0\" or \"Distributable = false\" or \"The value in the product Print ISBN & SKU are same in the vitalsource object\"\r\n"
						+ " - Validation Message Did Not Appear</b>");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying vital source product cannot be sampled valiadtion message ");
			selenium.reportFailure("Error while verifying vital source product cannot be sampled valiadtion message " + e.getMessage());
		}
	}

	@And("^check product print availability$")
	public void check_product_print_availability() {
		try
		{
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("newAccountFrame")) {
				selenium.switchToFrame("newAccountFrame");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
			}
			String BusinessRegionName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Business Region1");
            Select dropdown = new Select(selenium.getElement("BusinessRegion"));
            dropdown.selectByVisibleText(BusinessRegionName);
			selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
			selenium.type("VitalSourceISBNSearch1", "ISBN1");
			selenium.waitForElementToBeClickable("GetCountryProductDataBtn");
			selenium.click("GetCountryProductDataBtn");
			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("CountryCodeColumn"))
			{
				selenium.test.log(LogStatus.PASS, "Verified country product data");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Unable to verify the country product data");
				selenium.reportFailure("Unable to verify the country product data");
			}
//			selenium.waitForElementToBeClickable("RefreshBtn");
//			selenium.click("RefreshBtn");
			selenium.waitingTime(8000);
//			selenium.waitForElementToBeVisible("newAccountFrame");
//			selenium.switchToFrame("newAccountFrame");
			BusinessRegionName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Business Region2");
            dropdown = new Select(selenium.getElement("BusinessRegion"));
            dropdown.selectByVisibleText(BusinessRegionName);
			selenium.waitingTime(3000);
//			String CountryName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Country");
//			Select dropdown1 = new Select(selenium.getElement("CountryList"));
//            dropdown1.selectByVisibleText(CountryName);
			selenium.waitForElementToBeClickable("VitalSourceISBNSearch");
			selenium.type("VitalSourceISBNSearch1", "ISBN1");
			selenium.waitForElementToBeClickable("GetCountryProductDataBtn");
			selenium.click("GetCountryProductDataBtn");
			selenium.waitingTime(4000);
			String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Validation Message", "endContains");
			selenium.waitingTime(4000);
			System.out.println(validationMessage);
			if(selenium.isElementPresentXpathFast(validationMessage))
			{
				selenium.test.log(LogStatus.PASS, "Verified the mesage - This product cannot be sampled or added to Opportunity for this country as it is not setup on the ERP. Please contact your product team to set this up in PDH and ERP!");
				System.out.println("PASS");
				selenium.captureScreenShot();
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Unable to verify the mesage - This product cannot be sampled or added to Opportunity for this country as it is not setup on the ERP. Please contact your product team to set this up in PDH and ERP!");
				selenium.reportFailure("Unable to verify the mesage - This product cannot be sampled or added to Opportunity for this country as it is not setup on the ERP. Please contact your product team to set this up in PDH and ERP!");
			}
			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying print availability");
			selenium.reportFailure("Error while verifying print availability" + e.getMessage());
		}
	}
	@Then("I edit the created MHHE Opportunity cloning")
	public void i_edit_the_created_mhhe_opp_cloning(){
		try{
			selenium.waitForElementToBeClickable("editButton");
			selenium.jsClick("editButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CrossBtn");
			selenium.jsClick("CrossBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_People");
			selenium.typeData("search_People", "Jaime Klar");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.jsClick("showAllResultsFromDropDwn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CloneUserNameSelect");
			selenium.jsClick("CloneUserNameSelect");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No error occurred");
				selenium.test.log(LogStatus.PASS,"No error occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error occurred");
				selenium.test.log(LogStatus.FAIL,"Error occurred");
				selenium.reportFailure("Error occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I change the contact status to inactive and verify")
	public void i_change_the_contact_status_to_inactive_and_verify(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ContactNameLink");
			selenium.jsClick("ContactNameLink");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.jsClick("EditContactBtn");
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
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("snagerror"))
			{
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ShowAllResults");
				selenium.jsClick("ShowAllResults");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("DepartmentNameSelect");
				selenium.jsClick("DepartmentNameSelect");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			if(selenium.isElementPresentsuperFast("verifyContactRecord"))
			{
				System.out.println("PASS!!! Contact Record Found");
				selenium.test.log(LogStatus.PASS,"Contact Record Found");
			}
			else
			{
				System.out.println("FAIL!!! No Contact Record Found");
				selenium.test.log(LogStatus.FAIL,"No Contact Record Found");
				selenium.reportFailure("No Contact Record Found");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I add opportunity contact from opportunity for INTL user")
	public void i_add_opp_contact_from_opp_for_intl_user(){
		try{
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppAddContactBtn");
			selenium.jsClick("OppAddContactBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpptyFirstCheckBoxForConactAdd");
			selenium.jsClick("OpptyFirstCheckBoxForConactAdd");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(10000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I change the contact status to inactive and verify no contact")
	public void i_change_the_contact_status_to_inactive_and_verify_no_contact(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ContactNameLink");
			selenium.jsClick("ContactNameLink");
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("EditContactBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EditContactBtn");
			selenium.jsClick("EditContactBtn");
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
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("snagerror"))
			{
				selenium.waitForElementToBeClickable("search_Departments");
				selenium.typeData("search_Departments", "MATHEMATICS & COMPUTER SCIENCE");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ShowAllResults");
				selenium.jsClick("ShowAllResults");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("DepartmentNameSelect");
				selenium.jsClick("DepartmentNameSelect");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			if(!selenium.isElementPresentsuperFast("verifyContactRecord"))
			{
				System.out.println("PASS!!! Contact Record Found");
				selenium.test.log(LogStatus.PASS,"Contact Record Found");
			}
			else
			{
				System.out.println("FAIL!!! No Contact Record Found");
				selenium.test.log(LogStatus.FAIL,"No Contact Record Found");
				selenium.reportFailure("No Contact Record Found");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
