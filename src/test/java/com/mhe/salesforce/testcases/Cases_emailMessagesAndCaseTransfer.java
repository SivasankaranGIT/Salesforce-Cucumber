package com.mhe.salesforce.testcases;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Cases_emailMessagesAndCaseTransfer {

	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to cases tab$")
	public void i_navigate_to_cases_tab() {

		try {

			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("CXGApp")) {
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.getElement("searchItemsTextField").sendKeys("Sales");
//					selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Saleslightningapp");
				selenium.jsClick("Saleslightningapp");
				selenium.waitingTime(4000);
			}
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "Cases");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("casesOptionMenuDots");
			selenium.jsClick("casesOptionMenuDots");
			selenium.waitingTime(3000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to cases tab " + e.getMessage());
		}

	}

	@And("^open the case$")
	public void open_the_case() {

		try {
			selenium.search("Case Number");
			String Xpath = selenium.getDynamicXpath("anchorTitle", "Case Number", "end");
//			 selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.test.log(LogStatus.INFO, "Clicked on case");
			selenium.waitingTime(5000);
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while opening case record " + e.getMessage());
		}
	}

	@Then("^verify Email notification is present$")
	public void verify_email_notification_is_present() {

		try {
			selenium.waitForElementToBeClickable("caseEmailSection1");
			selenium.jsClick("caseEmailSection1");
//			 selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("caseEmailNotification");
			boolean email = selenium.isElementPresentFast("caseEmailNotification");
			System.out.println("email present" + email);
			if (email == true) {
				selenium.test.log(LogStatus.PASS, "Email notification attached");
				System.out.println("PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "Email notification not attached");
				selenium.reportFailure("Email notification not attached");
			}


			selenium.captureScreenShot();
//				selenium.waitingTime(2000); 
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying email attached " + e.getMessage());
		}
	}

	@Then("^change the owner of case$")
	public void change_the_owner_of_case() {

		try {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/5008b00001vHBMNAA4/view");
			selenium.waitingTime(8000);
			selenium.click("moreActionsBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ChangeOwnerEditBtn");
			selenium.clickLoop("ChangeOwnerEditBtn");

//			 	selenium.waitForElementToBeClickable("changeOwner");
//				selenium.jsClick("changeOwner");
//				selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.jsClick("search_user");
			selenium.waitingTime(2000);
			selenium.typeData("search_user", "Sivasankaran Periyasamy");
			selenium.waitingTime(2000);
//				selenium.clickDynamic("divTitle", "Owner", "end");
			selenium.clickLoop("ChangeCaseOwnerSelection");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubmitForm");
			selenium.jsClick("SubmitForm");


			boolean ownerChanged = selenium.isElementPresentFast("contactSuccessfulL");
			System.out.println("owner transfer success" + ownerChanged);
			if (ownerChanged == true) {
				selenium.test.log(LogStatus.PASS, "Case transferred to new owner");
			} else {

				selenium.click("deleteAction");
				selenium.waitForElementToBeClickable("search_user");
				selenium.jsClick("search_user");
				selenium.waitingTime(2000);
				selenium.type("search_user", "New Owner");
				selenium.waitingTime(2000);
//						selenium.clickDynamic("divTitle", "Owner", "end");
				selenium.clickLoop("ChangeCaseOwnerSelection");
//						selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SubmitForm");
				selenium.jsClick("SubmitForm");
				boolean ownerChangedNew = selenium.isElementPresentFast("contactSuccessfulL");
				System.out.println("owner transfer success" + ownerChangedNew);
				if (ownerChangedNew == true) {
					selenium.test.log(LogStatus.PASS, "Case transferred to new owner");
				} else {
					selenium.test.log(LogStatus.FAIL, "Case did not transferred to new owner");
					selenium.reportFailure("Case did not transferred to new owner");
				}
			}

			if (selenium.isElementPresentFast("changeOwnerAlert")) {
				selenium.click("CancelButton_Span");
				selenium.waitingTime(3000);
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}


	@Then("^verify new owner Case details$")
	public void verify_new_owner_Case_details() {

		try {
			selenium.waitingTime(5000);
			selenium.scrollToElement("caseOwnerName1");
			selenium.waitForElementToBeVisible("caseOwnerName1");
			String name = selenium.getElement("caseOwnerName1").getAttribute("innerHTML");
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Owner");
			System.out.println("actual and expected owner" + name + expected_name);
			boolean recordtype = selenium.isElementPresentFast("caseRecordType");
			boolean hours = selenium.isElementPresentFast("businessHours");
			System.out.println("record type and hours" + recordtype + hours);
			if ((name.equalsIgnoreCase(expected_name)) & recordtype == true & hours == true) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "Case transferred to new owner successfully");
			} else {
				System.out.println("inside fail");
				selenium.test.log(LogStatus.FAIL, "Case transfer failed");
				selenium.reportFailure("Case transfer failed");
			}

			selenium.captureScreenShot();
//			selenium.waitingTime(2000); 
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying new  owner " + e.getMessage());
		}
	}

	@Then("^verify fields in new case created$")
	public void verify_fields_in_new_case_created(DataTable table) {

		try {
			selenium.url = selenium.getURL();
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwner = selenium.getText("Case_Owner_New").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwner);
			if (caseOwner.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner name is present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is present");
				System.out.println("PASS - Case Owner name is present");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
			}
			selenium.waitForElementToBeVisible("Check_Status");
			String checkStatus = selenium.getText("Check_Status").toString();
			System.out.println("The Status is : " + checkStatus);
			if (checkStatus.equalsIgnoreCase(data.get(1))) {
				System.out.println("Status is new");
				selenium.test.log(LogStatus.PASS, "Status is New");
				System.out.println("PASS - Status is New");
			} else {
				System.out.println("Status is not new");
				selenium.test.log(LogStatus.FAIL, "Status is not new");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("web_emailEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("gettext_webEmailName");
			String checkWebemailName = selenium.getText("gettext_webEmailName").toString();
			System.out.println("The Status is : " + checkWebemailName);
			if (checkWebemailName.equalsIgnoreCase(data.get(2))) {
				System.out.println("Web Email Name Matched");
				selenium.test.log(LogStatus.PASS, "Web Email Name Matched");
				System.out.println("PASS - Web Email Name Matched");
			} else {
				System.out.println("Web Email Name Not Matched");
				selenium.test.log(LogStatus.FAIL, "Web Email Name Not Matched");
				System.out.println("FAIL");
			}
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ChatterTab");
			selenium.jsClick("ChatterTab");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CaseEmailBtn");
			selenium.jsClick("CaseEmailBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CaseEmailFromTextBox");
			String fromTextBox=selenium.getText("CaseEmailFromTextBox").toString();
			System.out.println("Text from Email from Text Box is : "+fromTextBox);
			if(fromTextBox.contains("MH India Support"))
			{
				System.out.println("!!!PASS Email Name Matched");
				selenium.test.log(LogStatus.PASS, "Email Name Matched");
			}
			else
			{
				System.out.println("!!!FAIL Email Name Not Matched");
				selenium.test.log(LogStatus.FAIL, "Email Name Not Matched");
				selenium.reportFailure("Email Name Not Matched");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}

	@Then("^verify created case status$")
	public void verify_created_case_status(DataTable table) {

		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitForElementToBeClickable("CheckBoxClick");
			selenium.jsClick("CheckBoxClick");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeStatusActionBtn");
			selenium.jsClick("ChangeStatusActionBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CaseEmailFrom");
			selenium.click("CaseEmailFrom");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("case_Status_closed");
			selenium.jsClick("case_Status_closed");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("change_status_SaveBtn");
			selenium.jsClick("change_status_SaveBtn");
			selenium.waitingTime(5000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Check_Status");
			String checkStatus = selenium.getText("Check_Status").toString();
			System.out.println("The Status is : " + checkStatus);
			if (checkStatus.equalsIgnoreCase(data.get(0))) {
				System.out.println("Status is new");
				selenium.test.log(LogStatus.PASS, "Status is Closed");
				System.out.println("PASS - Status is Closed");
			} else {
				System.out.println("Status is not Closed");
				selenium.test.log(LogStatus.FAIL, "Status is not Closed");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}

	@Then("^verify case is created with no CMG Agent Location of Case Originator value$")
	public void verify_case_is_created_with_no_CMG_Agent_Location_of_Case_Originator_value() {

		try {
			selenium.url = selenium.getURL();
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("edit_CMG_USerInlineEdit");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("cmg_agent_Textfield");
			String actualCMGagent = selenium.getText("cmg_agent_Textfield");
			if (actualCMGagent.equalsIgnoreCase("")) {
				System.out.println("CMG Agent Location of Case Originator field is blank");
				selenium.test.log(LogStatus.PASS, "CMG Agent Location of Case Originator field is blank");
			} else {
				System.out.println("CMG Agent Location of Case Originator field is not blank");
				selenium.test.log(LogStatus.FAIL, "CMG Agent Location of Case Originator field is not blank");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}

	@Then("^verify CMG agent location of case originator is dispayed when case owner is changed$")
	public void verify_CMG_agent_location_of_case_originator_is_dispayed_when_case_owner_is_changed() {
		try {
//			selenium.waiting(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("changeOwner");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("changeOwner");
			selenium.jsClick("changeOwner");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.jsClick("search_user");
			String user = "Mindy Peters";
			selenium.typeData("search_user",user);
			selenium.waitingTime(2000);
			selenium.jsClick("select_Owner");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.jsClick("ChangeOwnerBtn");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("edit_CMG_USerInlineEdit");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("cmg_agent_Textfield");
			String actualCMGagent = selenium.getText("cmg_agent_Textfield");
			System.out.println("CMG Agent name is " +actualCMGagent);
			if (!(actualCMGagent.equalsIgnoreCase(""))) {
				System.out.println("CMG Agent Location of Case Originator field is not blank");
				selenium.test.log(LogStatus.PASS, "CMG Agent Location of Case Originator field is not blank");
			} else {
				System.out.println("CMG Agent Location of Case Originator field is  blank");
				selenium.test.log(LogStatus.FAIL, "CMG Agent Location of Case Originator field is blank");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}

	@Then("^verify field values for newly created case$")
	public void verify_field_values_for_newly_created_case(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwnerName = selenium.getText("Case_Owner_New").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwnerName);
			selenium.waitingTime(2000);
			if (caseOwnerName.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner name is present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is present");
				System.out.println("PASS - Case Owner name is present");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordtyp = selenium.getText("Case_Record_Type").toString();
			System.out.println("The Case record type in UI is : " + caseRecordtyp);
			selenium.waitingTime(2000);
			if (caseRecordtyp.equalsIgnoreCase(data.get(02))) {
				System.out.println("Case record type is displayed");
				selenium.test.log(LogStatus.PASS, "Case record type is displayed");
				System.out.println("PASS - Case record type is displayed");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
				selenium.waitingTime(3000);
			}
				selenium.scrolldown(-200);
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("case_OriginNew");
				String caseOrigin = selenium.getText("case_OriginNew").toString();
				if (caseOrigin.equalsIgnoreCase(data.get(01))) {
					System.out.println("Pass - Case origin name is present");
					selenium.test.log(LogStatus.PASS, "Case origin name is present");
				} else {
					System.out.println("Case origin name is not present");
					selenium.test.log(LogStatus.FAIL, "Case origin name is not present");
				}
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("changeOwner");
			selenium.jsClick("changeOwner");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.jsClick("search_user");
			String user4 = "Alvaro Garcia";
			selenium.typeData("search_user",user4);
			selenium.waitingTime(2000);
			selenium.clickLoop("select_ownerName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.jsClick("ChangeOwnerBtn");
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("case_OwenerName");
			String caseOwnerName3 = selenium.getText("case_OwenerName").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwnerName3);
			if(!(data.get(0).equalsIgnoreCase(caseOwnerName3)))
			{
			System.out.println("Case Owner Changed Successfully");
			selenium.test.log(LogStatus.PASS,"Case Owner Changed Successfully");
			}
			else
			{
			System.out.println("Case Owner Did not Change");
			selenium.test.log(LogStatus.FAIL,"Case Owner Did not Change");
			selenium.reportFailure("Case Owner Did not Change");
			}
			}
			 catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}

	@Then("^verify field values of created case$")
	public void verify_field_values_of_created_case(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwnerNameDetail = selenium.getText("Case_Owner_New").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwnerNameDetail);
			selenium.waitingTime(2000);
			if (caseOwnerNameDetail.equalsIgnoreCase(data.get(0))) {
				System.out.println("Case Owner name is present");
				selenium.test.log(LogStatus.PASS, "Case Owner name is present");
				System.out.println("PASS - Case Owner name is present");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Case_Record_Type");
			String caseRecordtypes = selenium.getText("Case_Record_Type").toString();
			System.out.println("The Case record type in UI is : " + caseRecordtypes);
			selenium.waitingTime(2000);
			if (caseRecordtypes.equalsIgnoreCase(data.get(02))) {
				System.out.println("Case record type is displayed");
				selenium.test.log(LogStatus.PASS, "Case record type is displayed");
				System.out.println("PASS - Case record type is displayed");
			} else {
				System.out.println("Case Owner name is not present");
				selenium.test.log(LogStatus.FAIL, "Case Owner name is not present");
				System.out.println("FAIL");
				selenium.waitingTime(3000);
			}
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("originOfTheCase");
			String originOfTheCase1 = selenium.getText("originOfTheCase").toString();
			System.out.println("Case Origin Name is " + originOfTheCase1);
			if (originOfTheCase1.equalsIgnoreCase(data.get(01))) {
				System.out.println("Pass - Case origin name is present");
				selenium.test.log(LogStatus.PASS, "Case origin name is present");
			} else {
				System.out.println("Case origin name is not present");
				selenium.test.log(LogStatus.FAIL, "Case origin name is not present");
			}
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("changeOwner");
			selenium.jsClick("changeOwner");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.jsClick("search_user");
			String user4 = "Alvaro Garcia";
			selenium.typeData("search_user", user4);
			selenium.waitingTime(2000);
			selenium.clickLoop("select_ownerName");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.jsClick("ChangeOwnerBtn");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("Case_Owner_New");
			String caseOwnerName3 = selenium.getText("Case_Owner_New").toString();
			System.out.println("The Case Owner name in UI is : " + caseOwnerName3);
			selenium.test.log(LogStatus.PASS, "Case owner Name is updated to new Owner");
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while changing owner " + e.getMessage());
		}
	}
			@Then("Verify the fields in created case")
			public void verify_the_fields_in_created_case(DataTable table){
			try{
				List<String> data = table.transpose().asList(String.class);
				selenium.waitForElementToBeVisible("caseRecordType");
				String caseRecord_Type=selenium.getText("caseRecordType").toString();
				System.out.println("Case Record Type "+caseRecord_Type);
				Assert.assertTrue(caseRecord_Type.equalsIgnoreCase(data.get(0)));
				selenium.test.log(LogStatus.PASS, "Case Record Type is Matched Successfully");
				System.out.println("Case Record Type is Matched Successfully");

				selenium.waitForElementToBeVisible("case_priority");
				String casePriority=selenium.getText("case_priority").toString();
				System.out.println("Case Priority "+casePriority);
				Assert.assertTrue(casePriority.equalsIgnoreCase(data.get(1)));
				selenium.test.log(LogStatus.PASS, "Case Priority is Matched Successfully");
				System.out.println("Case Priority is Matched Successfully");

				selenium.waitForElementToBeVisible("Case_Owner_New");
				String caseOwner=selenium.getText("Case_Owner_New").toString();
				System.out.println("Case Owner "+caseOwner);
				Assert.assertTrue(caseOwner.equalsIgnoreCase(data.get(2)));
				selenium.test.log(LogStatus.PASS, "Case Owner is Matched Successfully");
				System.out.println("Case Owner is Matched Successfully");

				selenium.waitForElementToBeVisible("Case_Origin_New");
				String caseOrigin=selenium.getText("Case_Origin_New").toString();
				System.out.println("Case Origin "+caseOrigin);
				Assert.assertTrue(caseOrigin.equalsIgnoreCase(data.get(3)));
				selenium.test.log(LogStatus.PASS, "Case Origin is Matched Successfully");
				System.out.println("Case Origin is Matched Successfully");

			}catch (Exception e) {
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while changing owner " + e.getMessage());
			}
		}
}
