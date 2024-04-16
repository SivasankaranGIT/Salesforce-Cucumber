package com.mhe.salesforce.testcases;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.util.Assert;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateSampleFromOrderPadCustomLink {
	String ActURL;
	WebConnector selenium = WebConnector.getInstance();
	String RandomContactURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwT5BAAU/view";


	@Then("^navigate to MHES Lightning Console$")
	public void navigate_to_mhes_lightning_console() {
		try {

//			  selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "New Console");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("MHESlightningConsoleMenuDotsOption");
			selenium.jsClick("MHESlightningConsoleMenuDotsOption");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to console " + e.getMessage());
		}

	}


	@Then("^navigate to MHES Lightning Page$")
	public void navigate_to_mhes_lightning_page() {
		try {

//			  selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.typeData("searchItemsTextField", "MHES Lightning Console");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("MHESlightningConsoleMenuDotsOption");
			selenium.jsClick("MHESlightningConsoleMenuDotsOption");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to console " + e.getMessage());
		}

	}

	@And("^click on order pad custom link$")
	public void click_on_order_pad_custom_link() {
		try {
			selenium.waitForElementToBeClickable("customLinkHeader");
			selenium.jsClick("customLinkHeader");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("orderPadInsideCustomLink");
			selenium.jsClick("orderPadInsideCustomLink");
			selenium.waitingTime(5000);
			selenium.switchToChildWindow();
			selenium.waitingTime(4000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking order pad link " + e.getMessage());
		}

	}


	@Then("^fill mandatory fileds on account and orders details page$")
	public void fill_mandatory_fileds_on_account_and_orders_details_page() {
		try {
//		selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("searchAccountOnNewSample");
			selenium.click("searchAccountOnNewSample");
			selenium.waitingTime(2000);
			selenium.type("searchAccountOnNewSample", "Account Name");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("accountNameOnOrderPadNew");
			selenium.click("accountNameOnOrderPadNew");
//		selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("contactDropdownOnOrderPad1");
//		selenium.waitingTime(3000);
			selenium.jsClick("contactDropdownOnOrderPad1");
			selenium.waitingTime(4000);
			selenium.selectDropdownByIndex("contactDropdownOnOrderPad1", "Index");
			//selenium.selectDropdownText("contactDropdownOnOrderPad", "Contact Name");
			selenium.waitingTime(2000);

			String expected_line = selenium.fetchSelectedOptionFromDropdown("contactDropdownOnOrderPad1");
			String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
			//  = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact Name");
			System.out.println("attention line is" + expected_line + line);
			if (line.equalsIgnoreCase(expected_line)) {
				System.out.println("attention line matched");
				selenium.test.log(LogStatus.INFO, "attention line prepopulated");

			} else {
				selenium.test.log(LogStatus.INFO, "attention line not prepopulated");

			}

			selenium.captureScreenShot();
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("addressValueOnOrderPad");
			String address = selenium.getElement("addressValueOnOrderPad").getText();
			System.out.println("address is" + address);
			selenium.waitForElementToBeClickable("searchAddressonNewSample");
			selenium.click("searchAddressonNewSample");
//		selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("createNewAddressonSample");
			selenium.click("createNewAddressonSample");
//		selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
			selenium.click("street1OnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("street1OnNewSampleAddress", "Street 1");
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
			selenium.click("cityOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("cityOnNewSampleAddress", "City");
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
			selenium.click("stateOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("stateOnNewSampleAddress", "State");
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
			selenium.click("zipOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("zipOnNewSampleAddress", "Zip");
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
			selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
			selenium.click("workflowStatusNoteOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
			selenium.waitingTime(2000);
			selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
			selenium.captureScreenShot();
//		selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("errorMessageOnSampleAddress") == true) {
				selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
				selenium.jsClick("closeButtonOnSampleAddress");
			}
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("orderLineTypeOnOrderPad");


			selenium.scrollToElement("orderLineTypeOnOrderPad");
			boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad", "Order Line Type");
			boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad", "SFDC Status");
			boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad", "Ship Method");
			boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad", "Ship Priority");
			System.out.println("value is" + value1);

			String name = selenium.getText("desiredOwnerOnOrderPad").toString();
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
			System.out.println("actual owner is" + name + expected_name);

			if (value1 == true & value2 == true & value3 == true & value4 == true & name.equalsIgnoreCase(expected_name)) {
				selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page");


			} else {
				selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page");
				selenium.reportFailure("Values verification failed on Account and order details page");
			}


			selenium.captureScreenShot();
//		selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.test.log(LogStatus.FAIL, "Error while filling mandatory details");
			selenium.reportFailure("Error while filling mandatory details " + e.getMessage());

		}

	}

	@Then("^add products by clicking search product$")
	public void add_products_by_clicking_search_product() {
		try {
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchProductsHeader");
			selenium.jsClick("searchProductsHeader");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productsearchtab");
			selenium.click("productsearchtab");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productnamesampleorderpad");
			selenium.type("productnamesampleorderpad", "Product name");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchButton");
			selenium.click("searchButton");
//			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("selectfirstproduct");
			selenium.click("selectfirstproduct");
			selenium.waitForElementToBeClickable("addToSampleAndCloseButtonOnOrderPad");
			selenium.click("addToSampleAndCloseButtonOnOrderPad");
			selenium.waitingTime(2000);

			/*
			 * selenium.jsClick("searchProductsHeader"); selenium.waitingTime(9000);
			 * selenium.waitForElementsToBeVisible("orderTypeOnOrderPad");
			 * selenium.click("orderTypeOnOrderPad"); selenium.waitingTime(2000);
			 * selenium.selectDropdownText("orderTypeOnOrderPad", "Order Type");
			 * selenium.waitingTime(2000);
			 * selenium.jsClick("searchOnProductsPageOfOrderPad");
			 * selenium.waitingTime(6000); selenium.click("firstProductSelectOnOrderPad");
			 * selenium.waitingTime(2000);
			 * selenium.click("addToSampleAndCloseButtonOnOrderPad");
			 * selenium.waitingTime(5000); selenium.captureScreenShot();
			 * selenium.waitingTime(2000);
			 *
			 * selenium.click("selectProductAfterSearch"); selenium.waitingTime(2000);
			 */
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error while adding product" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding product");
		}

	}

	@Then("^fill details on additional info page$")
	public void fill_details_on_additional_info_page() {
		try {

			selenium.click("notesAdditionalInfoOnOrderPad");
			selenium.waitingTime(2000);
			selenium.type("notesAdditionalInfoOnOrderPad", "Workflow Notes");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);

			if (selenium.getElement("emailMissingErrorOnOrderPad").isDisplayed()) {
				selenium.click("emailOnOrderPad");
				selenium.waitingTime(2000);
				selenium.type("emailOnOrderPad", "Email");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveEmailOnOrderPad");
				selenium.click("saveEmailOnOrderPad");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("errorEmailMessageOnOrderPad") == true) {
					selenium.jsClick("closeButtonOnSampleAddress");
					selenium.waitingTime(5000);
				}

				selenium.waitingTime(5000);

			}
		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error on additional info page" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^review details on review page$")
	public void review_details_on_review_page() {
		try {
			boolean accountname = selenium.isElementPresentFast("accountNameOnReviewOrderPad");
			boolean address = selenium.isElementPresentFast("addressReviewOnOrderPad");
			boolean cost = selenium.isElementPresentFast("totalRepCostOnReviewOrderPad");
			boolean product = selenium.isElementPresentFast("productsOnReviewPageForOrderPad");
			boolean line = selenium.isElementPresentFast("attnLineOnOredrPad");
			// String expected_line = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact Name");
			System.out.println("attention line is" + line);
			if (accountname == true & address == true & cost == true & product == true & line == true) {
				selenium.test.log(LogStatus.PASS, "Details reviewed successfully");


			} else {
				selenium.test.log(LogStatus.FAIL, "Details are not proper on review page");
				selenium.reportFailure("Details are not proper on review page");
			}

			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("createSampleOrderBtn");
			selenium.click("createSampleOrderBtn");
			selenium.waitingTime(10000);

			if (selenium.isElementPresentFast("duplicateSamplesPopup") == true) {
				selenium.waitForElementToBeClickable("createSamples");
				selenium.jsClick("createSamples");
				selenium.waitingTime(5000);
			}
			selenium.waitForElementToBeClickable("closeOnOrderPadWindow");
			selenium.click("closeOnOrderPadWindow");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error on review page" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^verify sample is created from Order Pad$")
	public void verify_sample_is_created_from_order_pad() {
		try {
			selenium.waitForElementsToBeVisible("lastModifiedDateRecord");
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);

			if (recordDate.contains(todaysDate)) {
				System.out.println("inside date check");
				String contact = selenium.getElement("accountNameOnSampleAfterCreation").getText();
				String expected_conatct = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
				System.out.println("account name is" + contact);
				if (contact.equalsIgnoreCase(expected_conatct)) {
					selenium.test.log(LogStatus.PASS, "Sample created");


				} else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed");
					selenium.reportFailure("Sample creation failed");

				}

				selenium.waitingTime(5000);
			} else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastModifiedDate");
				selenium.jsClick("lastModifiedDate");
//					selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("lastModifiedDateRecord");
				String recordDate1 = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				if (recordDate1.contains(todaysDate)) {
					System.out.println("date matched");
					String contact = selenium.getElement("accountNameOnSampleAfterCreation").getText();
					String expected_conatct = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
					System.out.println("account name is" + contact);
					if (contact.equalsIgnoreCase(expected_conatct)) {
						selenium.test.log(LogStatus.PASS, "Sample created");


					} else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed");
						selenium.reportFailure("Sample creation failed");

					}

					selenium.waitingTime(5000);
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
					selenium.reportFailure("Sample creation failed");
				}
			}

			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
		} catch (Exception e) {
			selenium.switchBackToParentWindow();
			selenium.reportFailure("Error verifying sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^navigate to accounts tab$")
	public void navigate_to_accounts_tab() {
		try {

			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.type("searchItemsTextField", "New Account");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("accountTabOptionsClick");
			selenium.jsClick("accountTabOptionsClick");
			selenium.waitingTime(5000);
		} catch (Exception e) {

			selenium.reportFailure("Error while navigating to accounts " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

//		 @And("^make sure opp stage is open$")
//		    public void make_sure_opp_stage_is_open()
//		 	{
//				try
//				{
//					selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068H000005Z5qJQAS/view");
////					selenium.navigateToURL(selenium.NewOppURLForSamplesTest);
//					selenium.waitingTime(10000);
//					String oppName = selenium.getText("opp_Name").toString();
//					String expected_oppName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Expected Opp Name");
//					System.out.println("opp name is" + oppName);
//					System.out.println("Expected opp name is" + expected_oppName);
//					if (oppName.equalsIgnoreCase(expected_oppName))
//					{
//						System.out.println("Opp name is matching with expected name so don't need to update the opp stage");				
//					}
//					else
//					{
//						System.out.println("Updating opp stage..");
//			            selenium.waitForElementToBeClickable("clickonstageedit");
//						selenium.click("clickonstageedit");
//						selenium.waitingTime(4000);
//						selenium.scrolldown(100);
//			            selenium.waitForElementToBeClickable("OppStageWon");
//						selenium.click("OppStageWon");
//			            selenium.waitForElementToBeClickable("OppStageStatedNeed1");
//						selenium.click("OppStageStatedNeed1");
//			            selenium.waitForElementToBeClickable("Save_Btn");
//						selenium.click("Save_Btn");
//						selenium.waitingTime(20000);
//						selenium.captureScreenShot();
//					}
//				}
//
//				catch (Exception e)
//				{						
//					selenium.reportFailure("Error while verifying/updating opp stage " + e.getMessage());
//					selenium.test.log(LogStatus.FAIL, "Error while verifying/updating opp stage");
//				}
//
//		 	}

	@And("^click on any account$")
	public void click_on_any_account() {
		try {
			selenium.waitingTime(2000);
			selenium.search("Account Name");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("accountResults", "Account Name", "end");
			selenium.waitingTime(2000);
			System.out.println("xpath is" + Xpath);
//					selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(8000);
			ActURL = selenium.getURL();
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking account " + e.getMessage());
		}

	}

	@Then("^verify account and fill mandatory fileds on account and orders details page$")
	public void verify_account_and_fill_mandatory_fileds_on_account_and_orders_details_page() {
		try {


			selenium.waitForElementToBeClickable("contactDropdownOnOrderPad");
			selenium.jsClick("contactDropdownOnOrderPad");
			selenium.waitingTime(2000);
			selenium.selectDropdownByIndex("contactDropdownOnOrderPad", "Index");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("sampleOpportunityAccountName1");
			String account = selenium.getElement("sampleOpportunityAccountName1").getText();
			System.out.println("account is" + account);

			String expected_line = selenium.fetchSelectedOptionFromDropdown("contactDropdownOnOrderPad");
			String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");

			System.out.println("attention line is" + expected_line + line);
			if (account != null & line.equalsIgnoreCase(expected_line)) {
				selenium.test.log(LogStatus.PASS, "account and attention line prepopulated");
				System.out.println("INSIDE PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "account and attention line not prepopulated");
				System.out.println("INSIDE fail");
				selenium.reportFailure("account and attention line not prepopulated");
			}

			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("addressValueOnOrderPad");
			String address = selenium.getElement("addressValueOnOrderPad").getText();
			System.out.println("address is" + address);
			selenium.waitForElementToBeClickable("searchAddressonNewSample");
			selenium.click("searchAddressonNewSample");
//				selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("createNewAddressonSample");
			selenium.click("createNewAddressonSample");
//				selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
			selenium.click("street1OnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("street1OnNewSampleAddress", "Street 1");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
			selenium.click("cityOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("cityOnNewSampleAddress", "City");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
			selenium.click("stateOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("stateOnNewSampleAddress", "State");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
			selenium.click("zipOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("zipOnNewSampleAddress", "Zip");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
			selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
			selenium.click("workflowStatusNoteOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
			selenium.waitingTime(2000);
			selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("errorMessageOnSampleAddress") == true) {
				selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
				selenium.jsClick("closeButtonOnSampleAddress");
			}
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("orderLineTypeOnOrderPad");


			selenium.scrollToElement("orderLineTypeOnOrderPad");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad", "Order Line Type");
			boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad", "SFDC Status");
			boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad", "Ship Method");
			boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad", "Ship Priority");
			System.out.println("value is" + value1);

			String name = selenium.getText("desiredOwnerOnOrderPad").toString();
			selenium.waitingTime(2000);
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
			System.out.println("actual owner is" + name + "expected owner is" + expected_name);

			if (value1 == true & value2 == true & value3 == true & value4 == true & name.equalsIgnoreCase(expected_name)) {
				selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page");

				System.out.println("INSIDE PASS 1");
			} else {
				selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page");
				System.out.println("INSIDE fail 1");
				selenium.reportFailure("Values verification failed on Account and order details page");
			}


			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^add products for SEG user by clicking search product$")
	public void add_products_for_SEG_user_by_clicking_search_product() {
		try {
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("searchProductsHeader");
			selenium.jsClick("searchProductsHeader");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("orderTypeOnOrderPadFromAccount");
			selenium.click("orderTypeOnOrderPadFromAccount");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("orderTypeOnOrderPadFromAccount", "Order Type");
			selenium.waitForElementToBeClickable("searchOnProductsPageOfOrderPad1");
			selenium.clickLoop("searchOnProductsPageOfOrderPad1");			
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstProductSelectOnOrderPad");
			selenium.click("firstProductSelectOnOrderPad");
			selenium.waitForElementToBeClickable("addToSampleAndCloseButtonOnOrderPad1");
			selenium.click("addToSampleAndCloseButtonOnOrderPad1");
			
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("InvalidProdInSampleCreation"))
			{
				System.out.println("Invalid Product popup appeared..");
				selenium.click2("okButton");
				selenium.waitingTime(3000);
			}
			
			selenium.waitForElementToBeClickable("selectProductAfterSearch");
			selenium.click("selectProductAfterSearch");
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while adding product" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^fill details on additional info page for SEG User$")
	public void fill_details_on_additional_info_page_for_seg_user() {
		try {
			selenium.waitForElementToBeClickable("notesAdditionalInfoOnOrderPad");
			selenium.click("notesAdditionalInfoOnOrderPad");
			selenium.waitingTime(2000);
			selenium.type("notesAdditionalInfoOnOrderPad", "Workflow Notes");
			
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGCreateSampleFromSampTab"))
			{
				selenium.waitForElementToBeClickable("SampleCreationLinkExistingOppFlipBtn");
				selenium.click("SampleCreationLinkExistingOppFlipBtn");
				selenium.waitingTime(2000);
				if(selenium.checkElementIsEnabled("SampleCreationSubTypeDrpDwn")==false)
				{
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "The SubType field is available and non-editable");
				}
				else
				{
					System.out.println("FAIL - The SubType field is not disabled");
					selenium.reportFailure("The SubType field is not disabled");
					selenium.test.log(LogStatus.FAIL, "The SubType field is not disabled");
				}
				
				selenium.click("SampleCreationCreateNewOppFlipBtn");
				selenium.waitingTime(2000);
				if(selenium.checkElementIsEnabled("SampleCreationSubTypeDrpDwn")==true)
				{
					System.out.println("PASS");
					selenium.click("SampleCreationSubTypeDrpDwn");
					String SubTypePickListValue1 = "New Logo";
					String SubTypePickListValue2 = "New Logo Site";
					String SubTypePickListValue3 = "Cross-Sale";
					String SubTypePickListValue4 = "Rollover";
					String SubTypePickListValue5 = "Takeaway";
					String SubTypePickListValue6 = "Expansion";
					Select dropdown = new Select(selenium.getElement("SampleCreationSubTypeDrpDwn"));
					dropdown.selectByVisibleText(SubTypePickListValue1);
					dropdown.selectByVisibleText(SubTypePickListValue2);
					dropdown.selectByVisibleText(SubTypePickListValue3);
					dropdown.selectByVisibleText(SubTypePickListValue4);
					dropdown.selectByVisibleText(SubTypePickListValue5);
					dropdown.selectByVisibleText(SubTypePickListValue6);
					selenium.test.log(LogStatus.PASS, "The expected SubType picklist values are there and the field is editable");
					
					selenium.typeData("OppAmountFieldInSamples", "50");
					selenium.click("MarketRevenueGroupFieldInSamples");
					String MRG = "ELEMENTARY: CORE - SOCIAL STUDIES";
					dropdown = new Select(selenium.getElement("MarketRevenueGroupFieldInSamples"));
					dropdown.selectByValue(MRG);
					selenium.waitingTime(2000);
				}
				else
				{
					System.out.println("FAIL - The expected SubType picklist values are missing");
					selenium.reportFailure("The expected SubType picklist values are missing");
					selenium.test.log(LogStatus.FAIL, "The expected SubType picklist values are missing");
				}
//				selenium.click("SampleCreationCreateNewOppFlipBtn");
//				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(5000);

			if (selenium.getElement("emailMissingErrorOnOrderPad").isDisplayed()) {
				selenium.waitForElementToBeClickable("emailOnOrderPad");
				selenium.click("emailOnOrderPad");
				selenium.waitingTime(2000);
				selenium.type("emailOnOrderPad", "Email");
//					selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveEmailOnOrderPad");
				selenium.click("saveEmailOnOrderPad");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("errorEmailMessageOnOrderPad") == true) {
					selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
					selenium.jsClick("closeButtonOnSampleAddress");
					selenium.waitingTime(5000);
				}

				selenium.waitingTime(5000);

			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error on additional info page" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^review details on review page for SEG User$")
	public void review_details_on_review_page_for_seg_user() {
		try {
			boolean accountname = selenium.isElementPresentFast("accountNameOnReviewOrderPad");
			boolean address = selenium.isElementPresentFast("addressReviewOnOrderPad");
			boolean cost = selenium.isElementPresentFast("totalRepCostOnReviewOrderPad");
			boolean product = selenium.isElementPresentFast("productsOnReviewPageForOrderPad");
//				String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
//					 String expected_line = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact Name");
//				System.out.println("attention line is" + line);
			boolean line = selenium.isElementPresentFast("attnLineOnOredrPad");
			if (accountname == true & address == true & cost == true & product == true & line == true) {
				selenium.test.log(LogStatus.PASS, "Details reviewed successfully");
				System.out.println("INSIDE PASS 3");

			} else {
				selenium.test.log(LogStatus.FAIL, "Details are not proper on review page");
				System.out.println("INSIDE Fail 3");
				selenium.reportFailure("Test Case Failed");
			}

			selenium.captureScreenShot();
//					selenium.waitingTime(2000);
			selenium.click("createSampleOrderBtn");
			selenium.waitingTime(5000);

			if (selenium.isElementPresentFast("duplicateSamplesPopup") == true) {
				selenium.jsClick("createSamples");
				selenium.waitingTime(5000);
			}


		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error on review page" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^verify sample is created for SEG User$")
	public void verify_sample_is_created_for_seg_user() {
		try {
			selenium.waitingTime(5000);
			boolean success = selenium.isElementPresentFast("samplecreatedSuccessMessage");
			System.out.println("success" + success);
			if (success == true) {
				selenium.test.log(LogStatus.PASS, "Sample created successfully");
				System.out.println("INSIDE PASS 4");

			} else {
				selenium.test.log(LogStatus.FAIL, "Sample creation failed");
				System.out.println("INSIDE Fail 5");
				selenium.reportFailure("Test Case Failed");

			}

			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.click("closeOnOrderPadWindow");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();
		} catch (Exception e) {

			selenium.reportFailure("Error verifying sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^verify details on additional info page for SEG User$")
	public void verify_details_on_additional_info_page_for_seg_user() {
		try {
			selenium.waitForElementToBeClickable("notesAdditionalInfoOnOrderPad");
			selenium.click("notesAdditionalInfoOnOrderPad");
			selenium.waitingTime(2000);
			selenium.type("notesAdditionalInfoOnOrderPad", "Workflow Notes");
			selenium.waitingTime(2000);
			boolean value = selenium.isElementPresentFast("opportunityNameOnReviewSection");
			boolean value1 = selenium.isElementPresentFast("opportunityDetailsOnReviewSection");
			if (value == true & value1 == true) {
				System.out.println("inside pass for details");
				selenium.test.log(LogStatus.PASS, "Opportunity details prepopulated");
			}
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(5000);

			if (selenium.getElement("emailMissingErrorOnOrderPad").isDisplayed()) {
				selenium.waitForElementToBeClickable("emailOnOrderPad");
				selenium.click("emailOnOrderPad");
				selenium.waitingTime(2000);
				selenium.type("emailOnOrderPad", "Email");
//					selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveEmailOnOrderPad");
				selenium.click("saveEmailOnOrderPad");
				selenium.waitingTime(2000);

				if (selenium.isElementPresentFast("errorEmailMessageOnOrderPad") == true) {
					selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
					selenium.jsClick("closeButtonOnSampleAddress");
					selenium.waitingTime(5000);
				}

				selenium.waitingTime(5000);

			}
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error on additional info page" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^verify contact and fill mandatory fileds on account and orders details page$")
	public void verify_contact_and_fill_mandatory_fileds_on_account_and_orders_details_page() {
		try {
//					selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("contactDropdownOnOrderPad");
			String contact = selenium.fetchSelectedOptionFromDropdown("contactDropdownOnOrderPad");

			//boolean contact = selenium.fetchValueFromDropdown("contactDropdownOnOrderPad", "Contact Name");
//				selenium.waitingTime(2000);
			System.out.println("contact is" + contact);
			//selenium.click("contactDropdownOnOrderPad");
			selenium.waitingTime(4000);
			selenium.selectDropdownIndex("contactDropdownOnOrderPad");
			//selenium.selectDropdownByIndex("contactDropdownOnOrderPad", "Contact");
			//selenium.selectDropdownText("contactDropdownOnOrderPad", "Contact");
			selenium.waitForElementToBeVisible("sampleOpportunityAccountName1");
			String account = selenium.getElement("sampleOpportunityAccountName1").getText();
			System.out.println("account is" + account);
			String expected_line = selenium.fetchSelectedOptionFromDropdown("contactDropdownOnOrderPad");
			String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");

			System.out.println("attention line is" + line);
			if (contact != null & account != null & line.equalsIgnoreCase(expected_line)) {
				selenium.test.log(LogStatus.PASS, "Contact and account details prepopulated");
				System.out.println("INSIDE PASS");
			} else {
				selenium.test.log(LogStatus.FAIL, "Contact and account details not prepopulated");
				System.out.println("INSIDE fail");
				selenium.reportFailure("Test Case Failed");
			}

			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			String address = selenium.getElement("addressValueOnOrderPad").getText();
			System.out.println("address is" + address);
			selenium.waitForElementToBeClickable("searchAddressonNewSample");
			selenium.click("searchAddressonNewSample");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("createNewAddressonSample");
			selenium.click("createNewAddressonSample");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
			selenium.click("street1OnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("street1OnNewSampleAddress", "Street 1");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
			selenium.click("cityOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("cityOnNewSampleAddress", "City");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
			selenium.click("stateOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("stateOnNewSampleAddress", "State");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
			selenium.click("zipOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("zipOnNewSampleAddress", "Zip");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
			selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
			selenium.click("workflowStatusNoteOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
			selenium.waitingTime(2000);
			selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("errorMessageOnSampleAddress") == true) {
				selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
				selenium.jsClick("closeButtonOnSampleAddress");
			}
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("orderLineTypeOnOrderPad");


			selenium.scrollToElement("orderLineTypeOnOrderPad");
			boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad", "Order Line Type");
			boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad", "SFDC Status");
			boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad", "Ship Method");
			boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad", "Ship Priority");
			System.out.println("value is" + value1);

			String name = selenium.getText("desiredOwnerOnOrderPad").toString();
			String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
			System.out.println("actual owner is" + name + expected_name);

			if (value1 == true & value2 == true & value3 == true & value4 == true & name.equalsIgnoreCase(expected_name)) {
				selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page");

				System.out.println("INSIDE PASS 1");
			} else {
				selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page");
				System.out.println("INSIDE fail 1");
				selenium.reportFailure("Test Case Failed");
			}


			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^navigate to accounts page$")
	public void navigate_to_accounts_page() {
		try {
			selenium.navigateToURL(ActURL);
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to accounts page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to accounts page");
		}
	}

	@Then("^navigate to Opp Search page through custom link$")
	public void navigate_to_Opp_Search_page_through_custom_link() {
		try {
			selenium.waitForElementToBeClickable("customLinkHeader");
			selenium.click("customLinkHeader");
			selenium.waitForElementToBeClickable("OppSearchOptionInCustomLink");
			selenium.click("OppSearchOptionInCustomLink");
			selenium.waitingTime(2000);
			selenium.switchToChildWindow();
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
		} catch (Exception e) {
			selenium.reportFailure("Error while navigating to opp search page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to opp search page");
		}
	}

	@And("^verify market revenue group filter \\\"([^\\\"]*)\\\"$")
	public void verify_market_revenue_group_filter(String MRV) {
		try {
			selenium.waitForElementToBeClickable("OppFilterOppStage");
			String OppStage = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opp Stage");
			Select dropdown = new Select(selenium.getElement("OppFilterOppStage"));
			dropdown.selectByVisibleText(OppStage);

			String IsValidated = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Is Validated");
			dropdown = new Select(selenium.getElement("OppFilterIsValidated"));
			dropdown.selectByVisibleText(IsValidated);

			String Year = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Year");
			dropdown = new Select(selenium.getElement("OppFilterYear"));
			dropdown.selectByVisibleText(Year);

//	            selenium.type("OppFilterState", "State");

//	            String MRV = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Market Revenue Group");
			dropdown = new Select(selenium.getElement("OppFilterMarketRevenueGroup"));
			dropdown.selectByVisibleText(MRV);

			selenium.click("searchButton");
			selenium.waitingTime(25000);
			selenium.waitForElementToBeClickable("searchButton");

			String Xpath = selenium.getDynamicXpathData("OppTableOutputStart", MRV, "end");
			selenium.waitingTime(2000);
			System.out.println("xpath is" + Xpath);

			if (selenium.isElementPresentXpathFast(Xpath)) {
				selenium.test.log(LogStatus.PASS, "Market Revenue Group Filter is working fine");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Market Revenue Group Filter is NOT working");
				selenium.reportFailure("Market Revenue Group Filter is NOT working");
				System.out.println("FAIL");
			}

//				selenium.close();
//				selenium.waitingTime(2000);
//				selenium.switchBackToParentWindow();
//				selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.close();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(2000);
			selenium.reportFailure("Error while verifying market revenue group filter " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying market revenue group filter");
		}
	}

	@And("^verify probability group filter$")
	public void verify_probability_group_filter() {
		try {
			selenium.waitForElementToBeClickable("OppFilterSearchCriteriaLink");
			selenium.click("OppFilterSearchCriteriaLink");
			selenium.waitForElementToBeClickable("OppFilterClearBtn");
			selenium.click("OppFilterClearBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppFilterProbabilityGroup");
			String Prospect = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value1");
			Select dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Prospect);
			String Open = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value2");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Open);
			String Won = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value3");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Won);
			String Cancelled = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value5");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Cancelled);
			String Postponed = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value6");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Postponed);
			String Lost = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value4");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Lost);
			selenium.test.log(LogStatus.INFO, "All the expected options are available in the Probability Group dropdown list");

			String Year = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Year");
			dropdown = new Select(selenium.getElement("OppFilterYear"));
			dropdown.selectByVisibleText(Year);

//	            selenium.type("OppFilterState", "State");

			selenium.click("searchButton");
			selenium.waitingTime(60000);
			selenium.waitForElementToBeClickable("searchButton");

//				String Xpath = selenium.getDynamicXpath("OppTableOutputStart", "Probability Group", "end");
//				selenium.waitingTime(2000);
//				System.out.println("xpath1 is" + Xpath);

			if (selenium.isElementPresentFast("MarketRevenueGroupFilterOutput")) {
				selenium.test.log(LogStatus.PASS, "Probability Group Filter is working fine in OPPORTUNITIES page");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Probability Group Filter is NOT working in OPPORTUNITIES page");
				selenium.reportFailure("Probability Group Filter is NOT working in OPPORTUNITIES page");
				System.out.println("FAIL");
			}

			selenium.click("OppFilterOppLineItemTab");
			selenium.waitForElementToBeClickable("OppFilterSearchCriteriaLink");
			selenium.click("OppFilterSearchCriteriaLink");
			selenium.waitForElementToBeClickable("OppFilterClearBtn");
			selenium.click("OppFilterClearBtn");
			selenium.waitingTime(4000);
			Postponed = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Probability Group Value6");
			dropdown = new Select(selenium.getElement("OppFilterProbabilityGroup"));
			dropdown.selectByVisibleText(Postponed);
			selenium.click("searchButton");
			selenium.waitingTime(20000);
			selenium.waitForElementToBeClickable("searchButton");

			if (selenium.isElementPresentFast("OppFilterTableFirstRecord")) {
				selenium.test.log(LogStatus.PASS, "Probability Group Filter is working fine in OPPORTUNITY LINE ITEM page");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Probability Group Filter is NOT working in OPPORTUNITY LINE ITEM page");
				selenium.reportFailure("Probability Group Filter is NOT working in OPPORTUNITY LINE ITEM page");
				System.out.println("FAIL");
			}

			selenium.close();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.close();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(2000);
			selenium.reportFailure("Error while verifying probability group filter " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying probability group filter");
		}
	}


	@Then("^navigate to account tab$")
	public void navigate_to_account_tab() {
		try {

			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.typeData("searchItemsTextField", "Accounts");
//		selenium.type("searchItemsTextField", "New Account");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("accountTabOptionsClick");
			selenium.jsClick("accountTabOptionsClick");
			selenium.waitingTime(5000);
		} catch (Exception e) {

			selenium.reportFailure("Error while navigating to accounts " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@And("^I edit account detail$")
	public void i_edit_account_detail(DataTable table) {
		try {

			selenium.waitingTime(4000);
			if(selenium.isElementPresentFast("firstTableRecord"))
			{
				selenium.hoverAndClick("firstTableRecord");
			}
			else
			{
				selenium.navigateToURL(RandomContactURL);
			}
			selenium.waitingTime(8000);
			selenium.scrolldown(3500);
			selenium.waitingTime(2000);
			selenium.scrollToElement("Edit_SEM");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			String text4=selenium.getText("Edit_SEM");
			if(text4.equalsIgnoreCase(""))
			{
				selenium.test.log(LogStatus.PASS, "SEM Owner Field is Is Blank");
				System.out.println("SEM Owner Field is Is Blank");
				List<String> data = table.transpose().asList(String.class);
				selenium.navigateToURL(data.get(0));
//				selenium.navigateToURL(url);
			}
			else {

				selenium.test.log(LogStatus.FAIL, "SEM Owner Field is Is Not Blank");
				System.out.println("SEM Owner Field is Is Blank");
				selenium.waitForElementToBeClickable("Edit_SalesSEM");
				selenium.jsClick("Edit_SalesSEM");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("clear_text");
				selenium.jsClick("clear_text");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.jsClick("saveButton");
				selenium.waitingTime(5000);
			}
		} catch (Exception e) {
			selenium.reportFailure(e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}


	}

	@Then("^Verify Opportunity sales team value is matching with Opp Owners profile value$")
	public void verify_Opportunity_sales_team_value_is_matching_with_Opp_Owners_profile_value() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.click("firstTableRecord");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("change_owner");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("change_owner");
			selenium.jsClick("change_owner");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("search_user");
			selenium.jsClick("search_user");
			String user = "SEM";
			selenium.typeData("search_user",user);
			selenium.waitingTime(2000);
			selenium.jsClick("SEM_User");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("select_user");
//			selenium.jsClick("select_user");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ChangeOwnerBtn");
			selenium.jsClick("ChangeOwnerBtn");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("change_owner");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to first opportunity " + e.getMessage());
		}
	}
}