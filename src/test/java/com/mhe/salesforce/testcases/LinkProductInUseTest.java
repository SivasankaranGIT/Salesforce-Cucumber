package com.mhe.salesforce.testcases;

import java.util.List;

import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LinkProductInUseTest {

	WebConnector selenium = WebConnector.getInstance();

	@When("^I navigate to product in use screen and add product$")
	public void I_navigate_product_screen_addProduct() {
		try {		
		selenium.search("Opportunity Name");
		selenium.waitingTime(5000);
		String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
		System.out.println(Xpath);
		selenium.waitingTime(4000);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(Xpath);
//		selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001O2CbPAAV/view");
		selenium.waitingTime(6000);
		selenium.refresh();
		selenium.waitingTime(8000);
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(150);
			selenium.waitForElementToBeClickable("productInUseLInk3");
			selenium.click("productInUseLInk3");
		} else {
			selenium.scrolldown(150);
			selenium.waitForElementToBeClickable("productInUseLInk3");
			selenium.click("productInUseLInk3");
		}
		
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("productAddOrEdit");
		selenium.click("productAddOrEdit");
		selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
		selenium.waitingTime(4000);

		selenium.switchToMultipleFrame("productframeUat");
		
		//
		selenium.click("selectAllCheckbox");
		selenium.waitForElementToBeClickable("removeBtn");
		selenium.click("removeBtn");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("clearButton");
		
		selenium.click("clearButton");
		//selenium.type("copyrightField", "Copyright");
		selenium.type("isbnField", "ISBN");
		selenium.click("searchBtn");
		selenium.waitingTime(8000);
		// selenium.clickDynamic("divText","Author Name", "productCheckBoxDynamic");
		selenium.waitForElementToBeVisible("searchProductsHeader");
		selenium.scrollToElement("Addtoopportunity");
		String checkBox = selenium.getDynamicXpath("divText", "Author Name", "productCheckBoxDynamic");
//		selenium.waitForXpathElementToBeClickable(checkBox);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(checkBox);
		selenium.waitForElementToBeClickable("Addtoopportunity");
		selenium.click("Addtoopportunity");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeVisible("Button_Save");
		selenium.scrollToElement("Button_Save");
		selenium.click("selectAllCheckbox");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("Button_Save");
		selenium.click("Button_Save");
		selenium.waitingTime(15000);
		if(selenium.isElementPresentFast("productInUseLInk3"))
		{
			selenium.click("productInUseLInk3");
		}
		else
		{
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("productInUseLink3");
			selenium.click("productInUseLink3");
		}

		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}


	@When("^I navigate to product in use screen and add products$")
	public void I_navigate_product_screen_addProducts() {
		try {
				selenium.navigateToURL(selenium.OppPIUAddDeleteURL);
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("PIU_LinkinOpp");
				selenium.jsClick("PIU_LinkinOpp");
				selenium.refresh();
				selenium.waitForElementToBeClickable("PIU_AddButton");
				selenium.jsClick("PIU_AddButton");

				selenium.waitingTime(5000);
				selenium.switchToFrame("switch_iFrame");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("PIU_Input");
//				selenium.typeData("PIU_Input",data);
				selenium.type_propertiesFile("PIU_Input","AuthorName");

				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("searchProductsBtn");
				selenium.click("searchProductsBtn");

				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("PIU_checkbox");
				selenium.click("PIU_checkbox");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("PIU_AddtoOpp");
				selenium.click("PIU_AddtoOpp");
				selenium.waitingTime(4000);
				selenium.defaultframe();

		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}



	@And("^Verify product in use list within the opportunities$")
	public void verify_productInUse_lists() {
		try {
				/*String text="ALBERTA COOLBAUGH PRIMIS CUSTOM TEXT 1 2006 9780390353092";
				System.out.println("Product added successfully");
//				selenium.refresh();
				String flag=selenium.getText("PIU_getText").toString();
				if(flag.equalsIgnoreCase(text))
				{
					selenium.waitingTime(6000);
					selenium.waitForElementToBeClickable("PIU_checkboxDelete");
					selenium.click("PIU_checkboxDelete");
					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("PIU_deleteButton");
					selenium.jsClick("PIU_deleteButton");
					selenium.waitingTime(3000);
					selenium.switchToFrame("switch_iFrame");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeClickable("PIU_deleteconfirm");
					selenium.jsClick("PIU_deleteconfirm");
					selenium.defaultframe();
					System.out.println("Product deleted successfully");*/
			System.out.println("Inside verify product in use list");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("productCourseTable_New");
			WebElement table = selenium.getElement("productCourseTable_New");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("th"));
				WebElement column = columnsList.get(0);
				System.out.print("column:" + column.getText());
				String author = selenium.getTestDataFromPropertiesFile("AuthorName");
				System.out.println("author:" + author);
				if (column.getText().contains(author)) {
					selenium.test.log(LogStatus.PASS, "Product is successfully added to the opportunity");
					System.out.println("PASS");
					break;
				} else {
					continue;
				}
			}

		} catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^Delete the field product and verify$")
	public void delete_the_field_product_and_verify() {
		try {
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PIU_checkboxDelete");
			selenium.click("PIU_checkboxDelete");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("PIU_deleteButton");
			selenium.jsClick("PIU_deleteButton");
			selenium.waitingTime(3000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("PIU_deleteconfirm");
			selenium.jsClick("PIU_deleteconfirm");
			selenium.defaultframe();
			System.out.println("Product deleted successfully");



//			selenium.test.log(LogStatus.INFO, "All product deleted successfully");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}



	@And("^Verify product in use list within the opportunity$")
	public void verify_productInUse_list() {
		try {
			System.out.println("Inside verify product in use list");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productCourseTable_New");
			WebElement table = selenium.getElement("productCourseTable_New");
			List<WebElement> rowsList = table.findElements(By.tagName("tr"));
			List<WebElement> columnsList = null;
			for (WebElement row : rowsList) {
				columnsList = row.findElements(By.tagName("th"));
				WebElement column = columnsList.get(0);
				System.out.print("column:"+ column.getText());
				String author = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Author");
				System.out.println("author:" +author);
				if (column.getText().contains(author)) {
					selenium.test.log(LogStatus.PASS, "Product is successfully added to the opportunity");
					System.out.println("PASS");
					break;
				} else
				{
					continue;
				}

			}
//			System.out.println("INFO - All the product details tied to opportunity are listed");
			selenium.test.log(LogStatus.INFO, "All the product details tied to opportunity are listed");

		} catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the stage value and reason field")
	public void i_verify_the_stage_value_and_reason_field(){
		try{
			selenium.navigateToURL(selenium.NewSEGOpp);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Opp_StageValue");
			String opptyStageGetText=selenium.getText("Opp_StageValue").toString();
			System.out.println(opptyStageGetText);
			if(opptyStageGetText.contains("Stated"))
			{
				System.out.println("PASS!!Field is present");
				selenium.test.log(LogStatus.PASS,"Field is present");
			}
			else
			{
				System.out.println("FAIL!!!Field is not present");
				selenium.test.log(LogStatus.FAIL,"Field is not present");
				selenium.reportFailure("Field is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageLost");
			selenium.jsClick("StageLost");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ReasonDropDownOption");
			if(selenium.isElementPresentFast("ReasonDropDownOption"))
			{
				System.out.println("PASS!!!Low Usage is present in reason field");
				selenium.test.log(LogStatus.PASS,"Low Usage is present in reason field");
			}
			else
			{
				System.out.println("FAIL!!!Low Usage is not present in reason field");
				selenium.test.log(LogStatus.FAIL,"Low Usage is not present in reason field");
				selenium.reportFailure("Low Usage is not present in reason field");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the stage value and reason")
	public void i_verify_the_stage_value_and_reason(){
		try{
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageClosed");
			selenium.jsClick("OppStageClosed");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("OppStageClosed");
			if(selenium.isElementPresentFast("OppStageClosed")&&selenium.isElementPresentFast("ReasonFieldOption"))
			{
				System.out.println("PASS!!!Option present in reason field");
				selenium.test.log(LogStatus.PASS,"Option present in reason field");
			}
			else
			{
				System.out.println("FAIL!!!Option is not present in reason field");
				selenium.test.log(LogStatus.FAIL,"Option is not present in reason field");
				selenium.reportFailure("Option is not present in reason field");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageLost");
			selenium.jsClick("StageLost");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ReasonDropDownOption");
			if(selenium.isElementPresentFast("ReasonDropDownOption")&&selenium.isElementPresentFast("ReasonFieldOptionRFPLoss"))
			{
				System.out.println("PASS!!! Option present in reason field");
				selenium.test.log(LogStatus.PASS,"Option present in reason field");
			}
			else
			{
				System.out.println("FAIL!!! Option is not present in reason field");
				selenium.test.log(LogStatus.FAIL,"Option is not present in reason field");
				selenium.reportFailure("Option is not present in reason field");
			}
			selenium.click("CancelButton");
			selenium.waitingTime(20000);
		}catch (Exception e){
			selenium.click("CancelButton");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("verify the log a call btn in activity history")
	public void verify_the_log_a_call_btn_in_activity_history(){
		try{
			selenium.waitForElementToBeClickable("OpptyActivityHistory");
			selenium.jsClick("OpptyActivityHistory");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeVisible("OpptyLogACallBtn");
			if(selenium.isElementPresentFast("OpptyLogACallBtn"))
			{
				System.out.println("PASS!!! Log a call button is present");
				selenium.test.log(LogStatus.PASS,"Log a call button is present");
			}
			else
			{
				System.out.println("FAIL!!! Log a call button is not present");
				selenium.test.log(LogStatus.FAIL,"Log a call button is not present");
				selenium.reportFailure("Log a call button is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptyLogACallBtn");
			selenium.jsClick("OpptyLogACallBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallActionDropDown");
			selenium.jsClick("LogACallActionDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallActionOption");
			selenium.jsClick("LogACallActionOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallCallSourceDropDown");
			selenium.jsClick("LogACallCallSourceDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CallSourceOption");
			selenium.jsClick("CallSourceOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallCommentsTextBox");
			selenium.typeData("LogACallCommentsTextBox","Automation Testing Demo");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClassificationDropDown");
			selenium.jsClick("ClassificationDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClassificationOption");
			selenium.jsClick("ClassificationOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallSaveBtn");
			selenium.jsClick("LogACallSaveBtn");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("VerifyLogACallTaskCreated");
			if(selenium.isElementPresentFast("VerifyLogACallTaskCreated"))
			{
				System.out.println("PASS!!! Task Created");
				selenium.test.log(LogStatus.PASS,"Task Created");
			}
			else
			{
				System.out.println("FAIL!!! Task Not Created");
				selenium.test.log(LogStatus.FAIL,"Task Not Created");
				selenium.reportFailure("Task Not Created");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("validate the mandatory fields")
	public void validate_the_mandatory_fields(){
		try{
			selenium.waitForElementToBeClickable("QuickDropDownBtn");
			selenium.jsClick("QuickDropDownBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TaskBtnNew");
			selenium.jsClick("TaskBtnNew");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("Task_AssignedTo");
			if(selenium.isElementPresentsuperFast("Task_AssignedTo")&&selenium.isElementPresentsuperFast("Task_Subject")&&
			selenium.isElementPresentsuperFast("LogACallActionDropDown")&&selenium.isElementPresentsuperFast("Task_CallSourceDropDown")&&
			selenium.isElementPresentsuperFast("Task_Status")&&selenium.isElementPresentsuperFast("Task_CallDate")&&
			selenium.isElementPresentsuperFast("Task_DueDate")&&selenium.isElementPresentsuperFast("Task_Priority")&&
			selenium.isElementPresentsuperFast("LogACallCommentsTextBox"))
			{
				System.out.println("PASS!!! All Mandatory Fields are present");
				selenium.test.log(LogStatus.PASS,"All Mandatory Fields are present");
			}
			else
			{
				System.out.println("FAIL!!! All Mandatory Fields are not present");
				selenium.test.log(LogStatus.FAIL,"All Mandatory Fields are not present");
				selenium.reportFailure("All Mandatory Fields are not present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("create the task without Action field")
	public void create_the_task_without_action_field(){
		try{
			selenium.waitForElementToBeClickable("Task_Subject");
			selenium.jsClick("Task_Subject");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Task_SubjectOption");
			selenium.jsClick("Task_SubjectOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallCallSourceDropDown");
			selenium.jsClick("LogACallCallSourceDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CallSourceOption");
			selenium.jsClick("CallSourceOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Task_DueDate");
			selenium.jsClick("Task_DueDate");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.jsClick("TodayDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("LogACallCommentsTextBox");
			selenium.typeData("LogACallCommentsTextBox","Automation Testing Demo");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClassificationDropDown");
			selenium.jsClick("ClassificationDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClassificationOption");
			selenium.jsClick("ClassificationOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveBtnNew1");
			selenium.jsClick("SaveBtnNew1");
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I validate the error without Action field")
	public void i_validate_the_error_without_action_field(){
		try{
			selenium.waitForElementToBeVisible("TaskErrorMsg");
			String errorMsg=selenium.getText("TaskErrorMsg").toString();
			System.out.println("Error Message from UI is : "+errorMsg);
			if(errorMsg.contains("Action"))
			{
				System.out.println("PASS!!! Action Field is Mandatory");
				selenium.test.log(LogStatus.PASS,"Action Field is Mandatory");
			}
			else
			{
				System.out.println("FAIL!!! Task Created");
				selenium.test.log(LogStatus.FAIL,"Task Created");
				selenium.reportFailure("Task Created");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create country product and validate the error")
	public void i_create_country_product_and_validate_the_error(){
		try{
			selenium.randomString=selenium.getRandomString();
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("NextButton");
//			selenium.click("NextButton");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CountryProductNameTextBox");
			selenium.typeData("CountryProductNameTextBox",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CountryCodeTextBox");
			selenium.typeData("CountryCodeTextBox",selenium.randomString);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_producttextbox");
			selenium.typeData("search_producttextbox","Computer Science");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.jsClick("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstProdNameinList");
			selenium.jsClick("FirstProdNameinList");
			selenium.waitingTime(5000);
			selenium.scrollToElement("NetPriceTextBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NetPriceTextBox");
			selenium.typeData("NetPriceTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
//			selenium.scrollToElement("NetPriceEditBtn");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NetPriceEditBtn");
			selenium.jsClick("NetPriceEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NetPriceTextBox");
			selenium.clearText("NetPriceTextBox");
			selenium.typeData("NetPriceTextBox","200");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("NetPriceEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NetPriceEditBtn");
			selenium.jsClick("NetPriceEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NetPriceTextBox");
			selenium.clearText("NetPriceTextBox");
			selenium.typeData("NetPriceTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! Again No Error Occurred");
				selenium.test.log(LogStatus.PASS,"Again No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I create new LS project")
	public void i_create_new_ls_project(){
		try{
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageAdopted");
			selenium.jsClick("OppStageAdopted");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);

			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.click("LearningSolutionsSetupCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Submit_Button");
			selenium.jsClick("Submit_Button");
			selenium.waitingTime(10000);
			selenium.scrollToElement("TargetPriceEditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceEditBtn");
			selenium.jsClick("TargetPriceEditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceInclusiveAccessTextBox");
			selenium.typeData("TargetPriceInclusiveAccessTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceDirectPurchaseTextBox");
			selenium.typeData("TargetPriceDirectPurchaseTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceAccessCardTextBox");
			selenium.typeData("TargetPriceAccessCardTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceIALLViaBookStoreTextBox");
			selenium.typeData("TargetPriceIALLViaBookStoreTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceLLDirectViaOnline");
			selenium.typeData("TargetPriceLLDirectViaOnline","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPricePrintOnlyTextBox");
			selenium.typeData("TargetPricePrintOnlyTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceEBookTextBox");
			selenium.typeData("TargetPriceEBookTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TargetPriceComboOrPrePackTextBox");
			selenium.typeData("TargetPriceComboOrPrePackTextBox","100");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("change the status of LS project and validate the error")
	public void change_the_status_of_ls_project_and_validate_the_error(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("Edit_StatusBtn");
			selenium.jsClick("Edit_StatusBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Status_DropDown");
			selenium.jsClick("Status_DropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StatusOptionSubmit");
			selenium.jsClick("StatusOptionSubmit");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! Error Occurred");
				selenium.test.log(LogStatus.PASS,"Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! No Error Occurred");
				selenium.test.log(LogStatus.FAIL,"No Error Occurred");
				selenium.reportFailure("No Error Occurred");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I try to change the stage to postponed and validate")
	public void i_try_to_change_the_stage_to_postponed_and_validate(){
		try{
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeVisible("editStagesNew");
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageOptionPostponed");
			selenium.jsClick("StageOptionPostponed");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("snagerror"))
			{
				System.out.println("PASS!!! Error Occurred");
				selenium.test.log(LogStatus.PASS,"Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! No Error Occurred");
				selenium.test.log(LogStatus.FAIL,"No Error Occurred");
				selenium.reportFailure("No Error Occurred");
			}
			
			selenium.click("CancelButton");
			selenium.waitingTime(6000);
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
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.jsClick("OppStageProspect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("Again I try to change the opportunity stage to postponed and verify")
	public void again_i_try_to_change_the_opp_stage_to_postponed_and_verify(){
		try {
			selenium.navigateToURL(selenium.url);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageOptionPostponed");
			selenium.jsClick("StageOptionPostponed");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the ESD Top field is editable or not")
	public void i_verify_the_esd_top_field_is_editable_or_not(){
		try{
			selenium.url=selenium.getURL();
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("ESDTopTargetEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ESDTopTargetEditBtn");
			if(selenium.isElementPresentFast("ESDTopTargetEditBtn"))
			{
				System.out.println("PASS!!! Field is present");
				selenium.test.log(LogStatus.PASS,"Field is present");
			}
			else
			{
				System.out.println("FAIL!!! Field is not present");
				selenium.test.log(LogStatus.FAIL,"Field is not present");
				selenium.reportFailure("Field is not present");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I confirm the ESD Top field is editable or not")
	public void i_confirm_the_esd_top_field_is_editable_or_not(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			if(!selenium.isElementPresentFast("ESDTopTargetEditBtn"))
			{
				System.out.println("PASS!!! Field is not present");
				selenium.test.log(LogStatus.PASS,"Field is not present");
			}
			else
			{
				System.out.println("FAIL!!! Field is present");
				selenium.test.log(LogStatus.FAIL,"Field is present");
				selenium.reportFailure("Field is present");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify the fields are present and editable")
	public void i_verify_the_fields_are_present_and_editable(){
		try{
			selenium.url=selenium.getURL();
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("TechAccessSSOInUseTextBox");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("TechAccessSSOInUseTextBox")&&selenium.isElementPresentsuperFast("TechDSATextBox")&&
			selenium.isElementPresentsuperFast("TechRequestedRostering")&&selenium.isElementPresentsuperFast("ImplStartDateTextBox")&&
			selenium.isElementPresentsuperFast("ImplScope")&&selenium.isElementPresentsuperFast("ImplSuccessMetrics"))
			{
				System.out.println("PASS!!! ALL Fields are present & editable");
				selenium.test.log(LogStatus.PASS,"ALL Fields are present & editable");
			}
			else
			{
				System.out.println("FAIL!!! ALL Fields are either not present or not editable");
				selenium.test.log(LogStatus.FAIL,"ALL Fields are either not present or not editable");
				selenium.reportFailure("ALL Fields are either not present or not editable");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechAccessSSOInUseTextBox");
			selenium.jsClick("TechAccessSSOInUseTextBox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ImplScopeTextBoxNew");
			selenium.typeData("ImplScopeTextBoxNew","Automation Demo Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}

		}catch (Exception e){
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I verify same fields from A3K customer support profile")
	public void i_verify_same_fields_from_a3k_customer_support_profile(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("TechAccessSSOInUseTextBox");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			if(selenium.isElementPresentsuperFast("TechAccessSSOInUseTextBox")&&selenium.isElementPresentsuperFast("TechDSATextBox")&&
					selenium.isElementPresentsuperFast("TechRequestedRostering")&&selenium.isElementPresentsuperFast("ImplStartDateTextBox")&&
					selenium.isElementPresentsuperFast("ImplScope")&&selenium.isElementPresentsuperFast("ImplSuccessMetrics"))
			{
				System.out.println("PASS!!! ALL Fields are present");
				selenium.test.log(LogStatus.PASS,"ALL Fields are present");
			}
			else
			{
				System.out.println("FAIL!!! ALL Fields are not present");
				selenium.test.log(LogStatus.FAIL,"ALL Fields are not present");
				selenium.reportFailure("ALL Fields are not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechAccessSSOInUseTextBox");
			selenium.jsClick("TechAccessSSOInUseTextBox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ImplScopeTextBoxNew");
			selenium.typeData("ImplScopeTextBoxNew","Automation Demo Test");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! Error Occurred");
				selenium.test.log(LogStatus.PASS,"Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! No Error Occurred");
				selenium.test.log(LogStatus.FAIL,"No Error Occurred");
				selenium.reportFailure("No Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("I change the stage to previous to postpone")
	public void i_change_the_stage_to_previous_to_postpone(){
		try{
			selenium.url=selenium.getURL();
			selenium.waitForElementToBeVisible("editStagesNew");
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageProspect");
			selenium.jsClick("OppStageProspect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("I add opportunity contact from opportunity")
	public void i_add_opp_contact_from_opportunity(){
		try{
			selenium.url=selenium.getURL();
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyPicklistValueInTeachingField")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldPicklistValue")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyOppContactCanBeDeletedAndAdded")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldAfterClone")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyIsTeachingFieldAfterOppClone")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyUSOppContactStatus"))
			{
				selenium.waitForElementToBeClickable("OpportunityContactClick1");
				selenium.jsClick("OpportunityContactClick1");
				selenium.waitingTime(5000);
			}
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.jsClick("taggedProductISBNSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsFirstCheckBox");
			selenium.jsClick("ObjectsFirstCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsSecondCheckBox");
			selenium.jsClick("ObjectsSecondCheckBox");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(20000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
//			if(selenium.getTestCaseName().equalsIgnoreCase("SamplesPrepopulateContAndProd"))
//			{
//				selenium.SamplesWithProdAndContact=selenium.getURL();
//			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("verify the Stage picklist values in \"([^\"]*)\"$")
	public void verify_the_Stage_picklist_values_in_Opp(String Opp_Type){
		try
		{
			selenium.scrollToElement("editStagesNew");
			selenium.scrolldown(-200);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.click("editStagesNew");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			selenium.waitingTime(2000);
			if(Opp_Type.equals("DAG New/Field"))
			{
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue1"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue2"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue3"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue4"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue5"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue6"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue7"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue8"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue9"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue10"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue11"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue12"));
				selenium.test.log(LogStatus.PASS, "All the expected Stages are present");
			}
			else if(Opp_Type.equals("DAG Renewal"))
			{
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue8"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue9"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue12"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue13"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue14"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue15"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue16"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue17"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue18"));
				Assert.assertTrue(selenium.isElementPresentFast("DAGOpp_StagePicklistValue19"));
				selenium.test.log(LogStatus.PASS, "All the expected Stages are present");
			}
			else if(Opp_Type.equals("SEG"))
			{
				System.out.println("For SEG type opp we are not validating opportunity stage picklist");
			}
			selenium.click("CancelEdit");
			selenium.waitingTime(5000);
		}
		catch (Exception e){
			selenium.click("CancelEdit");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("verify the Fiscal Year error message for \"([^\"]*)\"$")
	public void verify_the_Fiscal_Year_error_message_for_opp(String Opp_Type){
		try
		{
			if(Opp_Type.equals("DAG New/Field"))		//This test step is only for DAG New/Field type opp - GCRM-16643
			{
				selenium.scrollToElement("EditOppPurchaseDate");
				selenium.scrolldown(-200);
				selenium.waitForElementToBeClickable("EditOppPurchaseDate");
				selenium.click("EditOppPurchaseDate");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("OppPurchaseDateSelectionField");
				selenium.typeData("OppPurchaseDateSelectionField","4/10/2025");	//increasing one year from 2024 to 2025
				selenium.scrollToElement("ConfidenceFactorList");
				selenium.scrolldown(-200);
				selenium.waitForElementToBeClickable("ConfidenceFactorList");
				selenium.click("ConfidenceFactorList");
				selenium.waitForElementToBeClickable("ConfidenceFactorListValue");
				selenium.click("ConfidenceFactorListValue");
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(4000);
				String validationMsg = selenium.getText("OppSaveValidationMsgText");
				System.out.println("Actual validation msg -->" + validationMsg);
				String expectedValidationMsg = selenium.getTestDataFromPropertiesFile("OppPurchaseDateValidationMsg");
				if(validationMsg.contains(expectedValidationMsg)) {
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "The expected purchase date validation message appeared");
				}
				else
				{
					System.out.println("FAIL");
					selenium.test.log(LogStatus.FAIL, "The expected purchase date validation message did not fire");
					selenium.reportFailure("The expected purchase date validation message did not fire");
				}
				selenium.click("CancelEdit");
				selenium.waitingTime(5000);
			}
		}
		catch (Exception e){
			selenium.click("CancelEdit");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@And("confirm the newly created Opp type is \"([^\"]*)\"$")
	public void confirm_the_newly_created_Opp_type(String Opp_Type){
		try
		{
        	selenium.waitingTime(6000);
        	selenium.refresh();
        	selenium.waitingTime(10000);
			selenium.scrolldown(200);
			selenium.waitingTime(2000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("DefaultAdoptionLink2");
			selenium.jsClick("DefaultAdoptionLink2");
        	selenium.waitingTime(8000);
        	selenium.switchOutOfFrame();
			selenium.scrolldown(1000);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("systemInfoSection");
            selenium.scrollToElement("systemInfoSection");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Opp_recordtype");
			String GetRecortype = selenium.getText("Opp_recordtype").toString();
			
	        if(Opp_Type.equals("DAG New/Field"))
			{
				if (GetRecortype.equalsIgnoreCase("DAG New/Field"))
				{
					System.out.println("Opp record type is " + GetRecortype);
					selenium.test.log(LogStatus.PASS, "Oppo Record Type Verified");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Oppo Record Type Verification Failed");
					selenium.reportFailure("Oppo Record Type Verification Failed");
				}
			}
	        else if(Opp_Type.equals("DAG Renewal"))
	        {
				if (GetRecortype.equalsIgnoreCase("DAG Renewal"))
				{
					System.out.println("Opp record type is " + GetRecortype);
					selenium.test.log(LogStatus.PASS, "Oppo Record Type Verified");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Oppo Record Type Verification Failed");
					selenium.reportFailure("Oppo Record Type Verification Failed");
				}
	        }
	        else if(Opp_Type.equals("SEG"))
	        {
				if (GetRecortype.equalsIgnoreCase("SEG"))
				{
					System.out.println("Opp record type is " + GetRecortype);
					selenium.test.log(LogStatus.PASS, "Oppo Record Type Verified");
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Oppo Record Type Verification Failed");
					selenium.reportFailure("Oppo Record Type Verification Failed");
				}
	        }
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("I edit the contact role")
	public void i_edit_the_contact_role(){
		try{
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("EditOppContactRoleBtn");
			selenium.jsClick("EditOppContactRoleBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ContactRoleDropDown");
			selenium.jsClick("ContactRoleDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ContactRoleOption");
			selenium.jsClick("ContactRoleOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(15000);
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStagePilot");
			selenium.jsClick("OppStagePilot");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechAccessSSODropDown");
			selenium.jsClick("TechAccessSSODropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechAccessSSOOption");
			selenium.jsClick("TechAccessSSOOption");
			selenium.waitingTime(2000);
			String test="Automation Test Demo";
			selenium.waitForElementToBeClickable("RosteringNotesTextBox");
			selenium.typeData("RosteringNotesTextBox",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechDSATextBoxNew");
			selenium.typeData("TechDSATextBoxNew",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechRequestedRosteringDropDown");
			selenium.jsClick("TechRequestedRosteringDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechRequestedRosteringOption");
			selenium.jsClick("TechRequestedRosteringOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplStartDate");
			selenium.typeData("ImplStartDate",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplScopeTextBoxNew");
			selenium.typeData("ImplScopeTextBoxNew",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplSuccessMetricsTextBox");
			selenium.typeData("ImplSuccessMetricsTextBox",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("Save_Btn"))
			{
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(8000);
			}
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("I add Provisioning and rostering details")
	public void I_add_Provisioning_and_rostering_details(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("TechAccessSSOInUseTextBox");
			selenium.jsClick("TechAccessSSOInUseTextBox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("TechAccessSSODropDown");
			selenium.jsClick("TechAccessSSODropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechAccessSSOOption");
			selenium.jsClick("TechAccessSSOOption");
			selenium.waitingTime(2000);
			String test="Automation Test Demo";
			selenium.waitForElementToBeClickable("RosteringNotesTextBox");
			selenium.typeData("RosteringNotesTextBox",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechDSATextBoxNew");
			selenium.typeData("TechDSATextBoxNew",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechRequestedRosteringDropDown");
			selenium.jsClick("TechRequestedRosteringDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TechRequestedRosteringOption");
			selenium.jsClick("TechRequestedRosteringOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplStartDate");
			selenium.typeData("ImplStartDate",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplScopeTextBoxNew");
			selenium.typeData("ImplScopeTextBoxNew",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ImplSuccessMetricsTextBox");
			selenium.typeData("ImplSuccessMetricsTextBox",test);
			selenium.waitingTime(2000);
			selenium.typeData("OppNextStepTextBox",test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("Save_Btn"))
			{
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.jsClick("Save_Btn");
				selenium.waitingTime(8000);
			}
		}
		
		catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("PostponeClone Opportunity when no provisioning rostering fields are blank")
	public void PostponeClone_Opportunity_when_no_data_filled(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opportunityPostponClone");
			selenium.click("opportunityPostponClone");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			selenium.selectDropdownByIndex_propertiesFile("opportunityPostponCloneYear", "Index");
			selenium.waitingTime(2000);
			selenium.selectDropdownText_Data("opportunityPostponCloneReason", "Funding");
			selenium.waitForElementToBeClickable("opportunityPostponCloneSave");
			selenium.click("opportunityPostponCloneSave");
			selenium.waitUntilOpportunityClones();
			selenium.waitingTime(60000);
			selenium.test.log(LogStatus.PASS, "Cloning process completed");
			selenium.switchOutOfFrame();			
		}
		catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("Update Opportunity stage to Presentation and verify the validation error")
	public void Update_Opportunity_stage_to_Presentation_and_verify_the_validation_error(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityStage3");
			selenium.jsClick("opportunityStage3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			Assert.assertTrue(selenium.isElementPresentFast("OppValidationMsgWithoutImplDetails"));
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			} else {
				selenium.click("CancelButton");

			}
		}
		catch (Exception e){
			selenium.click("CancelButton");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	
	@Then("I add role based opportunity contacts from opportunity")
	public void i_add_role_based_opp_contacts_from_opportunity(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
			
			selenium.waitForElementToBeClickable("taggedProductISBNSearch");
			selenium.jsClick("taggedProductISBNSearch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsFirstCheckBox");
			selenium.jsClick("ObjectsFirstCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsSecondCheckBox");
			selenium.jsClick("ObjectsSecondCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsThirdCheckBox");
			selenium.jsClick("ObjectsThirdCheckBox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ObjectsForthCheckBox");
			selenium.jsClick("ObjectsForthCheckBox");
			selenium.waitingTime(2000);
            
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(6000);	
			
			selenium.waitForElementToBeClickable("EditIconOppContact1Role");
			selenium.click("EditIconOppContact1Role");
			selenium.waitingTime(6000);	
            Select dropdown = new Select(selenium.getElement("OppContactRoleDrpDwn"));
            dropdown.selectByVisibleText("Activation Contact / MCH");
			selenium.waitingTime(6000);	
            
			selenium.waitForElementToBeClickable("EditIconOppContact1Role");
			selenium.click("EditIconOppContact1Role");
			selenium.waitingTime(6000);	
            dropdown = new Select(selenium.getElement("OppContactRoleDrpDwn"));
            dropdown.selectByVisibleText("Strategic Key Decision Maker / Buyer");
			selenium.waitingTime(6000);	
            
			selenium.waitForElementToBeClickable("EditIconOppContact2Role");
			selenium.click("EditIconOppContact2Role");
			selenium.waitingTime(6000);	
            dropdown = new Select(selenium.getElement("OppContactRoleDrpDwn2"));
            dropdown.selectByVisibleText("Training Contact");
			selenium.waitingTime(6000);	
			
			selenium.waitForElementToBeClickable("EditIconOppContact2Role");
			selenium.click("EditIconOppContact2Role");
			selenium.waitingTime(6000);	
            dropdown = new Select(selenium.getElement("OppContactRoleDrpDwn2"));
            dropdown.selectByVisibleText("Tech/Rostering Contact");
			selenium.waitingTime(6000);	
            
            System.out.println("CP2");
			selenium.jsClick("ObjectsSecondCheckBox");
			selenium.jsClick("ObjectsFirstCheckBox");
			selenium.jsClick("ObjectsThirdCheckBox");
			selenium.jsClick("ObjectsForthCheckBox");
			selenium.waitingTime(2000);
			
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(20000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(15000);
//			if(selenium.getTestCaseName().equalsIgnoreCase("SamplesPrepopulateContAndProd"))
//			{
//				selenium.SamplesWithProdAndContact=selenium.getURL();
//			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("^I verify the \"([^\"]*)\"$")
	public void i_verify_the_route_to_market_field(String route_to_market_field){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("RouteToMarketEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("RouteToMarketGetText");
			String routeToMarketGetText=selenium.getText("RouteToMarketGetText").toString();
			System.out.println(routeToMarketGetText);
			if(route_to_market_field.equalsIgnoreCase(routeToMarketGetText))
			{
				selenium.test.log(LogStatus.PASS,"Route To Market Is Matched Successfully");
				System.out.println("PASS!!! Route To Market Is Matched Successfully");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("navigate to opportunity contact and verify picklist values")
	public void navigate_to_opportunity_contact_and_verify_picklist_values(){
		try{
			selenium.url=selenium.getURL();
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.task=selenium.getURL();
			Assert.assertTrue(selenium.isElementPresentFast("teachingFieldgetText"));
			selenium.test.log(LogStatus.PASS,"Pass");
			System.out.println("PASS");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("HandoffRequiredEditIcon");
			selenium.click("HandoffRequiredEditIcon");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("HandoffRequiredList");
			selenium.click("HandoffRequiredList");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("HandoffRequiredValue")&&
			(selenium.isElementPresentFast("handOffDropdownvalue")));
			selenium.test.log(LogStatus.PASS,"Pass");
			System.out.println("PASS");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CancelButton");
			selenium.jsClick("CancelButton");

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
	@Then("verify teaching fields are not editable")
	public void verify_teaching_fields_are_not_editable(){
		try{
			selenium.navigateToURL(selenium.task);
			selenium.refresh();
			selenium.waitingTime(8000);
			Assert.assertFalse(selenium.isElementPresentFast("HandoffRequiredEditIcon"));
			selenium.test.log(LogStatus.PASS,"Pass,Field is not editable");
			System.out.println("PASS,Field is not editable");
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^create a new Opportunity for INTL")
	public void create_a_new_Opportunity_for_INTL() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("Opp_Name_01"))
			{
				selenium.waitForElementToBeClickable("Opp_Name_01");
				selenium.click("Opp_Name_01");
			}
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityAccountName");
			selenium.type_propertiesFile("opportunityAccountName","account_name4");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name4", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("closeDate1");
			selenium.click("closeDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TomorrowDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("orderDate1");
			selenium.click("orderDate1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("TodayDateInCalendar");
			selenium.click("TomorrowDateInCalendar");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("mheCourse");
			selenium.type_propertiesFile("mheCourse", "mhe_course");
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath_propertiesFile("spanTitle", "mhe_course", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath);
			String xpath1 = selenium.getDynamicXpath_propertiesFile("spanTitle", "account_name", "end");
			selenium.waitingTime(2000);
			selenium.clickLoopXpath(xpath1);
			selenium.waitForElementToBeClickable("enrollment");
			selenium.type_propertiesFile("enrollment", "Enrollment");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("save_new_opp");
			selenium.click("save_new_opp");
			selenium.waitingTime(20000);
			System.out.println("New Opp Record Created Successfully");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
}
