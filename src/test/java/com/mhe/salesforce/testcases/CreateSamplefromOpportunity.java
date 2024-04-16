package com.mhe.salesforce.testcases;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.cucumber.datatable.DataTable;
import lombok.extern.java.Log;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSamplefromOpportunity {
	WebConnector selenium = WebConnector.getInstance();
	String ISBN;
	String OppURL_Offer = null;
	String RandomOppURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001GvfypAAB/view";
	String CaseURL_JIRAAPILogs = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Case/500PE000007F7bVYAS/view";	//created it manually
	
//	public String OpportunitySample="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001D4o3PAAR/view"; 
//	public String OppForModifyShipMethod="https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FSQiCAAX/view";
//	public String OppForContAndProd= "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FU5j1AAD/view";
//	public String OppForSampleQuantity= "https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FTfU1AAL/view";

	@And("^verify the PnM and Version field removal$")
	public void verify_the_PnM_and_Version_field_removal() {
		try {
			if (selenium.getTestCaseName().equalsIgnoreCase("EditAndVerifyJIRAConnectionSyncedOrNot"))
			{
				selenium.navigateToURL(selenium.NewCXGCase);
			}
			else if (selenium.getTestCaseName().equalsIgnoreCase("CreateALEKSCaseAndVerifyPicklist"))
			{
				selenium.navigateToURL(selenium.NewALEKSCase);
			}

			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			
			Assert.assertFalse(selenium.isElementPresentFast("pnm_Unit"));
			selenium.test.log(LogStatus.PASS, "P&M field has been removed from Case page");	//GCRM-24675
			
			Assert.assertFalse(selenium.isElementPresentFast("VersionDropDown"));
			selenium.test.log(LogStatus.PASS, "Version field has been removed from Internal Description tab of Case Details page");	//GCRM-24675
			
			
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}

	}

	@When("^I navigate to opportunity tab$")
	public void i_navigate_to_opportunity_tab() {
		try {
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type_propertiesFile("searchItemsTextField", "New_Opportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpportunityClick");
			selenium.jsClick("OpportunityClick");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}

	@When("^I navigate to opportunity tab in classic$")
	public void i_navigate_to_opportunity_tab_classic() {
		try {

			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppTabClassic");
			selenium.click("OppTabClassic");
			selenium.waitingTime(5000);
		} catch (Exception e) {
//			selenium.click("UserMenuClassic");
//			selenium.waitForElementToBeClickable("UserLogoutClassic");
//			selenium.click("UserLogoutClassic");
			selenium.logoutFromAnyUserClassic();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}

	@When("^I navigate to the first opp in the page$")
	public void I_navigate_to_the_first_opp() {
		try {
			
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyEventNominationCriteriaField"))
			{
				if(selenium.isElementPresentFast("firstTableRecord"))
				{
					selenium.click("firstTableRecord");
				}
				else
				{
					selenium.navigateToURL(RandomOppURL);
				}
			}
			else
			{
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.click("firstTableRecord");
			}
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to first opportunity " + e.getMessage());
		}
	}

	@And("^verify the fields OracleStatus OPDate and PermissionEndDate in Product page$")
	public void verify_the_fields_In_Products_Page() {
		try {
			selenium.waitingTime(4000);
			selenium.navigateToURL(selenium.MHENewOppURL);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.click("productsSectionForOpportunity");
			selenium.waitingTime(6000);
			if (selenium.isElementPresentFast("OracleStatusColumn") && selenium.isElementPresentFast("OPDateColumn") && selenium.isElementPresentFast("PermissionEndDateColumn")) {
				selenium.test.log(LogStatus.PASS, "Opp Product fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Opp Product fields");
				selenium.reportFailure("Unable to verify the Opp Product fields");
				System.out.println("FAIL");
			}
			selenium.navigateBack();
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opp product fields added fields");
			selenium.reportFailure("Error while verifying the opp product fields added fields" + e.getMessage());
		}
	}

	@And("^verify the fields Evergreen and Release Date in Product page$")
	public void verify_the_fields_In_Products_Page2() {
		try {
			selenium.waitingTime(4000);
			selenium.navigateToURL(selenium.MHENewOppURL);
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("productsSectionForOpportunity");
			selenium.click("productsSectionForOpportunity");
			selenium.waitingTime(6000);
			if (selenium.isElementPresentFast("EvergreenColumn") && selenium.isElementPresentFast("ReleaseDateColumn")) {
				selenium.test.log(LogStatus.PASS, "Opp Product fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Opp Product fields");
				selenium.reportFailure("Unable to verify the Opp Product fields");
				System.out.println("FAIL");
			}
			selenium.navigateBack();
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opp product fields added fields");
			selenium.reportFailure("Error while verifying the opp product fields added fields" + e.getMessage());
		}
	}

	@And("^verify the fields OracleStatus OPDate PermissionEndDate and NetPrice in ProductInUse page$")
	public void verify_the_fields_in_ProductInUse_Page() {
		try {
			selenium.waitForElementToBeVisible("PIUOracleStatusColumn");
			if (selenium.isElementPresentFast("PIUOracleStatusColumn") && selenium.isElementPresentFast("PIUOPDateColumn") && selenium.isElementPresentFast("PIUPermissionEndDateColumn") && selenium.isElementPresentFast("PIUNetPriceColumn")) {
				selenium.test.log(LogStatus.PASS, "Opp ProductInUse fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Opp ProductInUse fields");
				selenium.reportFailure("Unable to verify the Opp ProductInUse fields");
				System.out.println("FAIL");
			}
//			selenium.navigateBack();
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opp productinuse fields added fields");
			selenium.reportFailure("Error while verifying the opp productinuse fields added fields" + e.getMessage());
		}
	}

	@And("^verify the fields Evergreen and Release Date in ProductInUse page$")
	public void verify_the_fields_in_ProductInUse_Page2() {
		try {
			selenium.waitingTime(5000);
			if (!selenium.isElementPresentFast("PIUEvergreenColumn")) {
				System.out.println("PIUEvergreenColumn not found");
				selenium.waitingTime(3000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productAddOrEdit");
				selenium.jsClick("productAddOrEdit");
				selenium.waitingTime(6000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("isbnSearch1");
				selenium.scrollToElement("isbnSearch1");
				selenium.type_propertiesFile("isbnSearch1", "ISBNNo");
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.click("searchBtn");
				selenium.waitingTime(12000);
				selenium.waitForElementToBeClickable("productCheckBox");
				selenium.click("productCheckBox");
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.PASS, "Product Added to PIU of Opportunity");
				System.out.println("Product Added to PIU of Opportunity");
				I_go_to_add_product_in_use_page_of_opportunity();
				selenium.navigateToURL(selenium.MHENewOppURL);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("productInUseLink");
				selenium.click("productInUseLink");
			}
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("PIUEvergreenColumn");
			if (selenium.isElementPresentFast("PIUEvergreenColumn") && selenium.isElementPresentFast("PIUReleaseDateColumn")) {
				selenium.test.log(LogStatus.PASS, "Opp ProductInUse fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Opp ProductInUse fields");
				selenium.reportFailure("Unable to verify the Opp ProductInUse fields");
				System.out.println("FAIL");
			}
//			selenium.navigateBack();
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying the opp productinuse fields added fields");
			selenium.reportFailure("Error while verifying the opp productinuse fields added fields" + e.getMessage());
		}
	}

	@And("^I go to add product in use page of opportunity$")
	public void I_go_to_add_product_in_use_page_of_opportunity() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("productInUseLink");
				selenium.click("productInUseLink");
			} else {
				selenium.waitForElementToBeClickable("productInUseLink");
				selenium.click("productInUseLink");
			}
			selenium.waitingTime(4000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to product in use page" + e.getMessage());
		}
	}

	@And("^verify product not in system functionality$")
	public void verify_product_not_in_system_functionality() {
		try {
			selenium.refresh();
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.click("productAddOrEdit");
			selenium.test.log(LogStatus.INFO, "Products screen loaded successfully!");
			selenium.waitingTime(4000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitForElementToBeClickable("ProductNotInSystemBtn");
			selenium.click("ProductNotInSystemBtn");
			selenium.waitForElementToBeVisible("ProductNotInSystemToAddress");

			String toAddress = selenium.getText("ProductNotInSystemToAddress").toString();
//		 	String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("To");
//		 	System.out.println("Expected expected_address"  + expected_address);		 	
			String toAddressFieldXpathOpp = selenium.getPropertiesObj().getProperty("ProductNotInSystemToAddress").
					replace("<placeholder>", toAddress);
			boolean toAddressField = selenium.isElementPresentXpathFast(toAddressFieldXpathOpp);

			String emailSubject = selenium.getText("ProductNotInSystemSubject").toString();
//		 	String expected_emailSubject = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Subject");
//		 	System.out.println("Expected expected_emailSubject"  + expected_emailSubject);		 	
			String emailSubjectFieldXpathOpp = selenium.getPropertiesObj().getProperty("ProductNotInSystemSubject").
					replace("<placeholder>", emailSubject);
			boolean emailSubjectField = selenium.isElementPresentXpathFast(emailSubjectFieldXpathOpp);

			String emailBody = selenium.getText("ProductNotInSystemEmailBody").toString();
//		 	String expected_emailBody = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Compose Text1");
//		 	System.out.println("Expected expected_emailBody"  + expected_emailSubject);		 	
			String emailBodyFieldXpathOpp = selenium.getPropertiesObj().getProperty("ProductNotInSystemEmailBody").
					replace("<placeholder>", emailBody);
			boolean emailBodyField = selenium.isElementPresentXpathFast(emailBodyFieldXpathOpp);

			if (toAddressField == true && emailSubjectField == true && emailBodyField == true) {
				selenium.test.log(LogStatus.PASS, "Product-Not-In-System Email fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Product-Not-In-System Email fields");
				selenium.reportFailure("Unable to verify the Product-Not-In-System Email fields");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying product not in system functionality" + e.getMessage());
		}
	}

	@And("^check new quote option is removed or not$")
	public void check_new_quote_option_is_removed_or_not() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("moreOption");
			OppURL_Offer = selenium.getURL();
			selenium.click("moreOption");
			selenium.waitingTime(2000);

			if (selenium.isElementPresentFast("OppNewQuoteLink")) {
				selenium.test.log(LogStatus.FAIL, "New Quote option is appearing in opportunity but it should not appear");
				selenium.reportFailure("New Quote option is appearing in opportunity but it should not appear");
				System.out.println("FAIL");
			} else {
				selenium.test.log(LogStatus.PASS, "New Quote option is not appearing in opportunity as expected.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			}
			selenium.refresh();
			selenium.waitingTime(6000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying new quote button in opp");
			selenium.reportFailure("Error while verifying new quote button in opp" + e.getMessage());
		}
	}

	@And("^create new offer and validate date field$")
	public void create_new_offer_and_validate_date_field() {
		try {

			/*add new ECOMMERCE TYPE product if it is not exist*/
			String ISBN = "9781264045969";
			String OppProdXpath = selenium.getDynamicXpathData("anchorTextcontains", ISBN, "endContains");
			System.out.println("OppProdXpath is" + OppProdXpath);
			
			selenium.navigateToURL(OppURL_Offer);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.jsClick("opportunityLineItemRelatedList");
			selenium.waitingTime(6000);
			if (selenium.isElementPresentXpathFast(OppProdXpath)) {
				System.out.println("ECOMMERCE Product Already Exist In Opp.");
			} else {
				System.out.println("Adding new opp product.");
				selenium.waitForElementToBeClickable("taggedProductAddorEdit");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(4000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(6000);
				selenium.scrollToElement("taggedProductISBN1");
				selenium.typeData("taggedProductISBN1", ISBN);
				selenium.waitForElementToBeClickable("taggedProductISBNSearch");
				selenium.click("taggedProductISBNSearch");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("addAllProductinProductSearch");
				selenium.click("addAllProductinProductSearch");
				selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
				selenium.click("opportunitiesAddToOpportunity");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(10000);
			}

			selenium.navigateToURL(OppURL_Offer);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("moreOption");
			selenium.click("moreOption");
			selenium.waitForElementToBeClickable("OppNewOfferBtn");
			selenium.click("OppNewOfferBtn");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("ProductOfferList");

			Select dropdown = new Select(selenium.getElement("ProductOfferList"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(2000);
			dropdown = new Select(selenium.getElement("ProductCategoryList"));
			dropdown.selectByVisibleText("Connect");

			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.click("Next_Btn");
			selenium.waitForElementToBeClickable("OfferTypeList");

			String OfferType = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Offer Type");
			dropdown = new Select(selenium.getElement("OfferTypeList"));
			dropdown.selectByVisibleText(OfferType);

			selenium.waitForElementToBeClickable("Next_Btn");
			selenium.click("Next_Btn");
			selenium.waitForElementToBeClickable("DealLevelRadioBtn");
			selenium.click("DealLevelRadioBtn");
			selenium.click("Next_Btn");
			selenium.waitForElementToBeClickable("NeedByDate");
			/*selenium.click("NeedByDate");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("TermStartDate");
			selenium.click("TermStartDate");
			selenium.waitingTime(2000);

			selenium.click("NationalConnectOLAISBN");
			if (selenium.isElementPresentFast("DateFormatMessage")) {
				selenium.test.log(LogStatus.PASS, "Data Format validation appeared");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Data Format validation did not appear");
				selenium.reportFailure("Data Format validation did not appear");
				System.out.println("FAIL");
			}*/

			selenium.click("NeedByDate");
			selenium.waitingTime(2000);
			selenium.click("NeedByDateToday");
			selenium.click("TermStartDate");
			selenium.waitingTime(2000);
			selenium.click("TermStartDateToday");
			selenium.waitingTime(2000);
			selenium.autoSuggestiveDropdownWithoutText("NationalConnectOLAISBN");
			selenium.waitingTime(2000);
			selenium.click("FirstProductLink");
			selenium.autoSuggestiveDropdownWithoutText("CustomeCommerceISBN");
			selenium.waitingTime(2000);
			selenium.click("FirstProductLink");

			String UrgentReason = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Urgent Reason");
			dropdown = new Select(selenium.getElement("UrgentReason"));
			dropdown.selectByVisibleText(UrgentReason);

			String DurationDays = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Duration Days");
			dropdown = new Select(selenium.getElement("DurationDays"));
			dropdown.selectByVisibleText(DurationDays);

//			selenium.autoSuggestiveDropdownWithoutText1("CPM");
			selenium.waitingTime(2000);
			selenium.click("Next_Btn");
			selenium.waitForElementToBeClickable("CreateOfferBtn");
			selenium.click("CreateOfferBtn");
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.test.log(LogStatus.PASS, "Offer Created Successfully!");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while creating new offer");
			selenium.reportFailure("Error while creating new offer" + e.getMessage());
		}
	}

	@And("^delete existing MHHE digital offer$")
	public void delete_existing_offer() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("MHHEDigitalOfferLink");
			selenium.click("MHHEDigitalOfferLink");
			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("FirstProductLink")) {
				System.out.println("inside date check");
				selenium.refresh();
				selenium.waitingTime(6000);
//				selenium.waitForElementToBeVisible("MoreActionBtn2");
//				selenium.scrollToElement("MoreActionBtn2");
				selenium.waitForElementToBeClickable("MoreActionBtn2");
				selenium.click("MoreActionBtn2");
				selenium.waitForElementToBeClickable("DeleteRecord");
				selenium.click("DeleteRecord");
				selenium.waitForElementToBeClickable("deleteBtn");
				selenium.captureScreenShot();
				selenium.click("deleteBtn");
				selenium.waitingTime(8000);
				selenium.test.log(LogStatus.INFO, "Successfully deleted the MHHE Digital Offer");
			} else {
				System.out.println("There is no existing MHHE digital offer");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while deleting offer");
			selenium.reportFailure("Error while deleting offer" + e.getMessage());
		}
	}

	@And("^delete the newly created MHHE digital offer$")
	public void delete_offer() {
		try {
			selenium.navigateToURL(OppURL_Offer);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("MHHEDigitalOfferLink");
			selenium.click("MHHEDigitalOfferLink");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(6000);
//			selenium.waitForElementToBeVisible("MoreActionBtn2");
			selenium.scrollToElement("MoreActionBtn2");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("MoreActionBtn2");
			selenium.click("MoreActionBtn2");
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.captureScreenShot();
			selenium.click("deleteBtn");
			selenium.waitingTime(8000);
			selenium.test.log(LogStatus.INFO, "Successfully deleted the MHHE Digital Offer");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while deleting offer");
			selenium.reportFailure("Error while deleting offer" + e.getMessage());
		}
	}
//	@And("^click on opportunity$")
//    public void click_on_opportunity() {
//		try {
//		
//		//	selenium.search("Opportunity");
//		//	selenium.waitingTime(4000);
//		/*	 String Xpath = selenium.getDynamicXpath("opportunityResultsOnGlobalSearch", "Opportunity", "endContains");
//				selenium.waitingTime(3000);
//				System.out.println("xpath is"+Xpath);
//				selenium.clickLoopXpath(Xpath);*/
//			selenium.waitingTime(5000);			
//			
//			selenium.navigateToURL(OpportunitySample);
//			selenium.waitingTime(8000);
//			
//			
//			
//	}


	//		 catch (Exception e) {
//			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				selenium.reportFailure("Error while clicking on opportunity " + e.getMessage());
//			}
//
//	}
	@Then("^click on sample contact button from opportunity$")
	public void click_on_sample_contact_button_from_opportunity() {

		try {
			if (selenium.getTestCaseName().equalsIgnoreCase("SEGUserModifyShipMethod")) {
				selenium.navigateToURL(selenium.NewOppURLForSamplesTest);
			}
			
//			if (selenium.getTestCaseName().equalsIgnoreCase("SamplesPrepopulateContAndProd")) {
//				selenium.navigateToURL(selenium.SamplesWithProdAndContact);
//			}

			selenium.waitingTime(10000);
			if (selenium.isElementPresentFast("anynewSample")) {
				selenium.waitForElementToBeClickable("anynewSample");
				selenium.clickLoop("anynewSample");
			} else {
				selenium.clickLoop("newmoreactions");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("anynewSample");
				selenium.clickLoop("anynewSample");
			}
			selenium.waitingTime(9000);
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("swappedProductsPopUp")) {
				System.out.println("inside swap poppup");
				selenium.test.log(LogStatus.INFO, "Swap Product Popup Appeared!");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("okButton");
				selenium.jsClick("okButton");
				selenium.waitingTime(3000);
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on new sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@Then("^click on next and verify samples section$")
	public void click_on_next_and_verify_samples_section() {
		try {
			selenium.waitForElementToBeClickable("ClickNextButton");
			selenium.click("ClickNextButton");
			selenium.waitingTime(2000);


			boolean value = selenium.isElementPresentFast("contactAndProductCombinationOnSamples");
			System.out.println("results" + value);
			selenium.scrollToElement("contactAndProductCombinationOnSamples");

			if (value == true) {
				selenium.test.log(LogStatus.PASS, "contact and product combinations available");
			} else {
				selenium.test.log(LogStatus.FAIL, "contact and product combinations not available");
				selenium.reportFailure("contact and product combinations not available");
			}

			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying samples section" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}

	@Then("^verify products and contacts dispalyed$")
	public void verify_products_and_contacts_dispalyed() {
		try {

			boolean value = selenium.getElement("productsAndContactOnSampleCreation").isDisplayed();
			System.out.println("results" + value);

			if (value == true) {
				selenium.test.log(LogStatus.PASS, "contact and product combinations available");
				System.out.println("PASS - contact and product combinations available");
			} else {
				selenium.test.log(LogStatus.FAIL, "contact and product combinations not available");
				System.out.println("FAIL - contact and product combinations not available");
				selenium.reportFailure("contact and product combinations not available");
			}

			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ClickNextButton");
			selenium.jsClick("ClickNextButton");
			selenium.waitingTime(5000);
		} catch (Exception e) {

			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying contacts section" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}

	}

	@Then("^edit Quantity to create sample$")
	public void edit_quantity_to_create_sample() {
		try {
			selenium.waitForElementToBeClickable("editQuantityIconOnSampleCreation");
			selenium.click("editQuantityIconOnSampleCreation");
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editQuantityOnSampleCreation");
			selenium.click("editQuantityOnSampleCreation");
			selenium.waitingTime(2000);
			selenium.getElement("editQuantityOnSampleCreation").sendKeys(Keys.BACK_SPACE);
			selenium.waitingTime(2000);
			selenium.type("editQuantityOnSampleCreation", "Quantity");
			selenium.waitingTime(2000);
			selenium.moveTab("editQuantityOnSampleCreation");
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("createSampleOrderBtn");
			selenium.jsClick("createSampleOrderBtn");
			selenium.waitingTime(5000);

			if (selenium.isElementPresentFast("duplicateRecord")) {
				selenium.waitForElementToBeClickable("duplicateYes");
				selenium.click("duplicateYes");
//					selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("duplicateOKButton");
				selenium.click("duplicateOKButton");
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);

			}
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^navigate to samples section from opportunity$")
	public void navigate_to_samples_section_from_opportunity() {
		try {

			selenium.waitingTime(10000);

			if (selenium.isElementPresentFast("closeBtn")) {
				System.out.println("inside close button");
				selenium.click("closeBtn");
				selenium.waitingTime(2000);
			}

			if (selenium.isElementPresentFast("showAllLinksContact_samp")) {
				selenium.waitForElementToBeClickable("showAllLinksContact_samp");
				selenium.clickLoop("showAllLinksContact_samp");
			} else {
				selenium.scrolldown(500);
				selenium.waitForElementToBeClickable("showAllLinksContact_samp");
				selenium.clickLoop("showAllLinksContact_samp");
			}

			selenium.waitingTime(4000);
			if (selenium.isElementPresentFast("closeBtn")) {
				System.out.println("inside close button");
				selenium.click("closeBtn");
				selenium.waitingTime(2000);
			}
			selenium.waitForElementToBeClickable("samplesSectionOnOpportunityToVerifySample");
			selenium.jsClick("samplesSectionOnOpportunityToVerifySample");
			selenium.waitingTime(5000);

			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
//				String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			String recordDate = selenium.getText("lastModifiedDateRecordNew1");
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);

			if (recordDate.contains(todaysDate)) {
				System.out.println("inside date check");
				selenium.waitForElementToBeClickable("sampleRecordTable");
				selenium.jsClick("sampleRecordTable");
				selenium.waitingTime(5000);
			} else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastModifiedDate");
				selenium.jsClick("lastModifiedDate");
				selenium.waitingTime(3000);
				String recordDate1 = selenium.getElement("lastModifiedDateRecordNew1").getAttribute("innerHTML");
				if (recordDate1.contains(todaysDate)) {
					System.out.println("date matched");
					selenium.jsClick("sampleRecordTable");
					selenium.waitingTime(5000);
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
					selenium.reportFailure("Sample creation failed");
				}
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to sample" + e.getMessage());

		}

	}

	@And("^verify sample is created for quantity provided$")
	public void verify_sample_is_created_for_quantity_provided() {
		try {

			String quantity = selenium.getText("orderQuantityAfterSampleCreation").toString();
			String expected_quantity = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Quantity");
			System.out.println("actual quantity" + quantity);
			System.out.println("expected quantity" + expected_quantity);

			if (quantity.equals(expected_quantity)) {
				selenium.test.log(LogStatus.PASS, "Sample details Verified successfully");

			} else {
				selenium.test.log(LogStatus.FAIL, "Sample details not proper");
				selenium.reportFailure("Sample details not proper");
			}
			selenium.captureScreenShot();
//				selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while verifying sample" + e.getMessage());

		}

	}

	@And("^click on any opportunity$")
	public void click_on_any_opportunity() {
		try {

			selenium.waitingTime(2000);
			//selenium.click("accountRecord");
			selenium.search("Opportunity Name");
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpath("opportunityResultsOnGlobalSearch", "Opportunity Name", "endContains");
			selenium.waitingTime(4000);
//				selenium.waitForXpathElementToBeClickable(Xpath);
			selenium.clickLoopXpath(Xpath);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while clicking opportunity " + e.getMessage());
		}

	}

//	 @Then("^select contact and verify account and orders details page$")
//	    public void select_contact_and_verify_account_and_orders_details_page() {
//			try {
//			
//			
//			selenium.waitForElementToBeClickable("contactDropdownOnOrderPad");
//			selenium.jsClick("contactDropdownOnOrderPad");
//			selenium.waitingTime(2000);
//			selenium.selectDropdownText("contactDropdownOnOrderPad", "Contact Name");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeVisible("sampleOpportunityAccountName1");			
//			String account = selenium.getElement("sampleOpportunityAccountName1").getText();
//			System.out.println("account is" + account);
//			String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
//			 String expected_line = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact Name");
//			System.out.println("attention line is" + line);
//			if (account!= null & line.equalsIgnoreCase(expected_line)) {
//				selenium.test.log(LogStatus.PASS, "account and attention line prepopulated" );
//				System.out.println("INSIDE PASS");
//			}
//			
//			else
//			{
//				selenium.test.log(LogStatus.FAIL, "account and attention line not prepopulated" );
//				System.out.println("INSIDE fail");
//				selenium.reportFailure("account and attention line not prepopulated");
//			}
//			
//			selenium.captureScreenShot();
////			selenium.waitingTime(2000);
//			String address = selenium.getElement("addressValueOnOrderPad").getText();
//			System.out.println("address is" + address);
//			selenium.waitForElementToBeClickable("searchAddressonNewSample");
//			selenium.click("searchAddressonNewSample");
////			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("createNewAddressonSample");
//			selenium.click("createNewAddressonSample");
////			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
//			selenium.click("street1OnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.type("street1OnNewSampleAddress", "Street 1");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
//			selenium.click("cityOnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.type("cityOnNewSampleAddress", "City");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
//			selenium.click("stateOnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.type("stateOnNewSampleAddress", "State");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
//			selenium.click("zipOnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.type("zipOnNewSampleAddress", "Zip");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
//			selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
////			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
//			selenium.click("workflowStatusNoteOnNewSampleAddress");
//			selenium.waitingTime(2000);
//			selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
//			selenium.waitingTime(2000);
//			selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
//			selenium.captureScreenShot();
////			selenium.waitingTime(2000);
//			
//			if(selenium.isElementPresentFast("errorMessageOnSampleAddress")==true) {
//				selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
//				selenium.jsClick("closeButtonOnSampleAddress");
//			}
//			
//			selenium.waitForElementToBeClickable("saveButton");
//			selenium.jsClick("saveButton");
////			selenium.waitingTime(6000);
//			
//			
//			selenium.waitForElementToBeVisible("orderLineTypeOnOrderPad");
//			selenium.scrollToElement("orderLineTypeOnOrderPad");
//			boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad","Order Line Type");
//			boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad","SFDC Status");
//			boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad","Ship Method");
//			boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad","Ship Priority");
//			System.out.println("value is" + value1);
//			
//			String name = selenium.getText("desiredOwnerOnOrderPad").toString();
//			 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
//			System.out.println("actual owner is" + name + expected_name);
//			
//			if(value1==true & value2==true & value3==true & value4==true & name.equalsIgnoreCase(expected_name) ) {
//				selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page" );
//				
//				System.out.println("INSIDE PASS 1");
//			}
//			
//			else
//				
//			{
//				selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page" );
//				System.out.println("INSIDE fail 1");
//				selenium.reportFailure("Values verification failed on Account and order details page");
//			}
//			
//			
//			selenium.captureScreenShot();
////			selenium.waitingTime(2000);
//			}
//		
//			 catch (Exception e) {
//				 selenium.switchOutOfFrame();
//					selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
//					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//					
//				}
//
//		}

	@Then("^edit shipping method on account and orders details page$")
	public void edit_shipping_method_on_account_and_orders_details_page() {
		try {


			selenium.waitForElementToBeClickable("shipMethodOnOrderPad");
			selenium.jsClick("shipMethodOnOrderPad");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("shipMethodOnOrderPad", "Ship Method Edit");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.jsClick("NxtButton");
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while editing ship method" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}

	@Then("^create Enterprise PPL type opportunity and verify types and stage fields$")
	public void create_Enterprise_PPL_type_opportunity() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("EnterprisePPLOppRadioBtn");
			selenium.click("EnterprisePPLOppRadioBtn");
			selenium.waitForElementToBeClickable("NextButton");
			selenium.click("NextButton");
			selenium.waitingTime(10000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(6000);

			/*Verify Opp types picklist values*/
			selenium.waitForElementToBeClickable("OppTypeDropDwnField");
			Select dropdown = new Select(selenium.getElement("OppTypeDropDwnField"));
			dropdown.selectByVisibleText("Takeaway");
			dropdown.selectByVisibleText("Service");
			dropdown.selectByVisibleText("Rollover");
			dropdown.selectByVisibleText("Competition Not in play");

			/*Verify Opp stages picklist values*/
			selenium.waitForElementToBeClickable("OppStageDropDwnField");
			dropdown = new Select(selenium.getElement("OppStageDropDwnField"));
			dropdown.selectByVisibleText("Prospect");
			dropdown.selectByVisibleText("Qualified");
			dropdown.selectByVisibleText("Lost");
			dropdown.selectByVisibleText("Short Stack");
			dropdown.selectByVisibleText("Adopted");
			dropdown.selectByVisibleText("At Risk");
			dropdown.selectByVisibleText("Delayed Decision");
			dropdown.selectByVisibleText("Not Applicable");

			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.type_propertiesFile("opportunityAccount", "EnterpisePPLOpp_MHHEOppAccountName");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "EnterpisePPLOpp_MHHEOppAccountName", "end");
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.EnterprisePPLOppURL = selenium.getURL();
			System.out.println("The newly created Enterpise PPL opportunity url is.. " + selenium.EnterprisePPLOppURL);
		} catch (Exception e) {
			selenium.reportFailure("Error while creating Enterprise PPL type opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while creating Enterprise PPL type opportunity");
		}
	}
	
	@And("^verify stage picklist when closing opportunity$")
	public void verify_stage_picklist_when_closing_opportunity() {
		try {
			selenium.navigateToURL(selenium.EnterprisePPLOppURL);
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			
			/*Verify Opp stages picklist values*/
			selenium.waitForElementToBeClickable("ChangedCloseStatusBtn");
			selenium.jsClick("ChangedCloseStatusBtn");
			selenium.waitingTime(4000);
			
			selenium.waitForElementToBeClickable("CloseOppStageSelectPicklist");
			Select dropdown = new Select(selenium.getElement("CloseOppStageSelectPicklist"));
			dropdown = new Select(selenium.getElement("CloseOppStageSelectPicklist"));
			dropdown.selectByVisibleText("Lost");
			dropdown.selectByVisibleText("Adopted");
			dropdown.selectByVisibleText("Delayed Decision");
			dropdown.selectByVisibleText("Not Applicable");
			
			selenium.test.log(LogStatus.PASS, "Successfully verified Stage picklist when closing opportunity");
			selenium.click("opportunityAccountsEditCancel");
			selenium.waitingTime(5000);
		} catch (Exception e) {
			selenium.reportFailure("Error while verifing stage picklist when closing opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing stage picklist when closing opportunity");
		}
	}

	@And("^verify Annual Revenue and Annual Enrollment fields$")
	public void verify_Annual_Revenue_and_Annual_Enrollment_fields() {
		try {
			selenium.navigateToURL(selenium.EnterprisePPLOppURL);
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(8000);
			
			/*Verify newly added Enterprise PPL Opp fields*/
			selenium.waitForElementToBeVisible("AnnualEnrollmentPilotFieldInENTOpp");
			Assert.assertTrue(selenium.isElementPresentFast("AnnualEnrollmentPilotFieldInENTOpp"));
			Assert.assertTrue(selenium.isElementPresentFast("AnnualEnrollmentFullImplementationFieldInENTOpp"));
			Assert.assertTrue(selenium.isElementPresentFast("Edit_AnnualEnrollmentPilotFieldInENTOpp"));
			Assert.assertTrue(selenium.isElementPresentFast("Eidt_AnnualEnrollmentFullImplementationFieldInENTOpp"));
			selenium.test.log(LogStatus.PASS, "All the fields has been verified");
		}
		catch (Exception e) {
			selenium.reportFailure("Error while verifing the fields " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing the fields");
		}
	}

	@And("^edit Enterprise PPL type opportunity and verify types and stage fields$")
	public void verify_types_and_stages_fields() {
		try {
			selenium.navigateToURL(selenium.EnterprisePPLOppURL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");

			/*Verify Opp types picklist values*/
			selenium.waitForElementToBeClickable("OppTypeDDList");
			selenium.click("OppTypeDDList");
			String xpath1 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Type1", "end");
			String xpath2 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Type2", "end");
			String xpath3 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Type3", "end");
			String xpath4 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Type4", "end");
			System.out.println("xpath1 :" + xpath1 + "xpath2 :" + xpath2 + "xpath3 :" + xpath3 + "xpath4 :" + xpath4);
			if (selenium.isElementPresentXpathFast(xpath1) && selenium.isElementPresentXpathFast(xpath2) && selenium.isElementPresentXpathFast(xpath3) && selenium.isElementPresentXpathFast(xpath4)) {
				selenium.test.log(LogStatus.PASS, "In Opp Type dropdown list the expected values are present.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "In Opp Type dropdown list the expected values are missing.");
				selenium.reportFailure("In Opp Type dropdown list the expected values are missing.");
				System.out.println("FAIL");
			}

			selenium.pressEscapeKey();
			selenium.waitingTime(2000);

			/*Verify Opp stages picklist values*/
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.click("OppStageField");
			String xpath_1 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage1", "end");
			String xpath_2 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage2", "end");
			String xpath_3 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage3", "end");
			String xpath_4 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage4", "end");
			String xpath_5 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage5", "end");
			String xpath_6 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage6", "end");
			String xpath_7 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage7", "end");
			String xpath_8 = selenium.getDynamicXpath_propertiesFile("spanTitle", "EnterprisePPLOpp_Stage8", "end");
			System.out.println("xpath_1 :" + xpath_1 + "xpath_2 :" + xpath_2 + "xpath_3 :" + xpath_3 + "xpath_4 :" + xpath_4 + "xpath_5 :" + xpath_5 + "xpath_6 :" + xpath_6 + "xpath_7 :" + xpath_7 + "xpath_8 :" + xpath_8);
			if (selenium.isElementPresentXpathFast(xpath_1) && selenium.isElementPresentXpathFast(xpath_2) && selenium.isElementPresentXpathFast(xpath_3) && selenium.isElementPresentXpathFast(xpath_4) && selenium.isElementPresentXpathFast(xpath_5) && selenium.isElementPresentXpathFast(xpath_6) && selenium.isElementPresentXpathFast(xpath_7) && selenium.isElementPresentXpathFast(xpath_8)) {
				selenium.test.log(LogStatus.PASS, "In Opp Stage dropdown list the expected values are present.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "In Opp Stage dropdown list the expected values are missing.");
				selenium.reportFailure("In Opp Stage dropdown list the expected values are missing.");
				System.out.println("FAIL");
			}

			selenium.waitForElementToBeClickable("CancelButton");
			selenium.click("CancelButton");
			selenium.waitingTime(6000);

		} catch (Exception e) {
			selenium.reportFailure("Error while verifing types and stages fields " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing types and stages fields");
		}
	}

	@And("^verify the fields Evergreen and Release Date in Product and ProductInUse page in SF classic mode$")
	public void verify_the_fields_in_Product_PIU_Page_SF_Classic() {
		try {
			selenium.waitForElementToBeClickable("RecentOppLinkClassic");
			selenium.click("RecentOppLinkClassic");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppProductsLinkClassic");
			selenium.click("OppProductsLinkClassic");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("ProductEvergreenFieldClassic");
			if (selenium.isElementPresentFast("ProductEvergreenFieldClassic") && selenium.isElementPresentFast("ProductReleaseDateFieldClassic") && selenium.isElementPresentFast("PIUEvergreenFieldClassic") && selenium.isElementPresentFast("PIUReleaseDateFieldClassic")) {
				selenium.test.log(LogStatus.PASS, "Opp fields are verified successfully.");
				System.out.println("PASS");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
			} else {
				selenium.test.log(LogStatus.FAIL, "Unable to verify the Opp fields");
				selenium.reportFailure("Unable to verify the Opp fields");
				System.out.println("FAIL");
			}
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("UserMenuClassic");
			selenium.jsClick("UserMenuClassic");
			selenium.waitForElementToBeClickable("UserLogoutClassic");
			selenium.jsClick("UserLogoutClassic");
		} catch (Exception e) {
//			selenium.click("UserMenuClassic");
//			selenium.waitForElementToBeClickable("UserLogoutClassic");
//			selenium.click("UserLogoutClassic");
			selenium.logoutFromAnyUserClassic();
			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}

	@And("^Verify At Risk History is Tracked$")
//	public void verify_At_Risk_History_is_Tracked(DataTable table)
	public void verify_At_Risk_History_is_Tracked(){
		try {
//			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL(data.get(0));

//			selenium.scrolldown(-650);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("opp_type_EditBtn");
			selenium.jsClick("opp_type_EditBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppTypeDDList");
			selenium.jsClick("OppTypeDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("oppselect_type");
			selenium.jsClick("oppselect_type");
			selenium.waitingTime(2000);
//			selenium.scrollToElement("Risk_Button");
//			selenium.waitingTime(2000);
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
////			selenium.waitForElementToBeClickable("Risk_Button");
////			selenium.hoverAndClick("Risk_Button");
//
//			selenium.waitingTime(6000);
//			selenium.scrolldown(-700);
//			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("Risk_Button");
//			selenium.jsClick("Risk_Button");
			selenium.scrollToElement("Checkbox_Risk");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Checkbox_Risk");
			selenium.click("Checkbox_Risk");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
//			selenium.scrolldown(-2000);
//			if (selenium.isElementPresentFast("Field_History1"))
			selenium.refresh();
			selenium.waitForElementToBeClickable("Field_History1");
			selenium.click("Field_History1");
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			selenium.waitForElementToBeVisible("Opportunity_FieldHistoryDate");
			String recordDate = selenium.getTextLoop("Opportunity_FieldHistoryDate").toString();
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				selenium.test.log(LogStatus.PASS, "Opportunity Field History Page Has Been Verified Successfully");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Opp Field History Page Verification Failed");
				selenium.reportFailure("Opp Field History Page Verification Failed");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@Then("^verify the goal field is read only$")
	public void verify_the_goal_field_is_read_only(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("GoalName");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);


			boolean editBtn = selenium.isElementPresentFast("GoalEditButton");

			if (editBtn == false) {
				System.out.println("Field in non editable");
				selenium.test.log(LogStatus.INFO, "Fields are non-editable");
			}


		} catch (Exception e) {

			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@Then("^verify the goal last modified is read only$")
	public void verify_the_goal_last_modified_is_read_only() {
		try {

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("GoalLstName");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			boolean editBtn = selenium.isElementPresentFast("GoalLstModfEdit");

			if (editBtn == false) {
				System.out.println("Field in non editable");
				selenium.test.log(LogStatus.INFO, "Fields are non-editable");
			}
		} catch (Exception e) {

			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@And("^verify the goal field is editable$")
//	public void verify_the_goal_field_is_editable(DataTable table) {
		public void verify_the_goal_field_is_editable() {

			try {
//			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL(data.get(0));
			String Test = "Test";
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("GoalName");
			selenium.waitingTime(2000);
			selenium.scrolldown(-350);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Goal");
			selenium.click("Edit_Goal");
			selenium.waitingTime(2000);
			selenium.typeData("Enter_Text", Test);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
//			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			boolean editBtn = selenium.isElementPresentFast("GoalEditButton");
			if (editBtn == true) {
				System.out.println("Goal Field Button is editable");
				selenium.test.log(LogStatus.INFO, "Goal Field Button is editable");
			}


		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@Then("^verify the goal modified by is read only$")
	public void verify_the_goal_modified_by_is_read_only() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("GoalModfBy");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);

			boolean editBtn = selenium.isElementPresentFast("GoalModfByEdit");

			if (editBtn == false) {
				System.out.println("Field in non editable");
				selenium.test.log(LogStatus.INFO, "Fields are non-editable");
			}
		} catch (Exception e) {

			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}

	@Then("^verify the goal field last modified is editable$")
	public void verify_the_goal_field_last_modified_is_editable() {
		try {
//			List<String> data = table.transpose().asList(String.class);
//			selenium.navigateToURL(data.get(0));
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrolldown(-250);
			selenium.scrollToElement("Goal_LastModified");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Edit_GoalModified");
			selenium.jsClick("Edit_GoalModified");
			selenium.waitingTime(2000);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String todaysdate = sdf.format(tomorrow);
			System.out.println(todaysdate);
			selenium.scrollToElement("Input_Date");
			selenium.typeData("Input_Date", todaysdate);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
//			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			boolean editBtn = selenium.isElementPresentFast("Edit_GoalModified");
			if (editBtn == true) {
				System.out.println("Goal Last Modified Field is editable");
				selenium.test.log(LogStatus.INFO, "Goal Last Modified Field is editable");
			}

		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@Then("^verify the goal last modified by is editable$")
	public void verify_the_goal_last_modified_by_is_editable() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("Goal_LastModifiedBy");
			selenium.waitingTime(3000);
			selenium.scrolldown(-250);
			selenium.waitForElementToBeClickable("Goal_LastModifiedBy");
			selenium.jsClick("Goal_LastModifiedBy");
			String Test = "UAT Test";
			selenium.typeData("EnterTxtBy", Test);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(2000);
			boolean editBtn = selenium.isElementPresentFast("Goal_LastModifiedBy");
			if (editBtn == true) {
				System.out.println("Goal Last Modified By Field is editable");
				selenium.test.log(LogStatus.INFO, "Goal Last Modified By Field is editable");
			}

		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.test.log(LogStatus.FAIL, "Error while verifying the fields");
			selenium.reportFailure("Error while verifying the fields" + e.getMessage());
		}
	}


	@When("^I edit Opportunity stage$")
	public void i_edit_Opportunity_stage(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(5000);
			selenium.scrolldown(750);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Recognize";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);
			selenium.waitingTime(2000);
			selenium.scrolldown(-100);
			selenium.waitForElementToBeVisible("Opp_Contact");
			if (selenium.getElement("Opp_Contact").isDisplayed()) {
				System.out.println("Opp Contact Value is null");
				selenium.test.log(LogStatus.PASS, "Opp_Contactact Is Null");
			} else {
				System.out.println("Opp Contact Value is not null");
				selenium.test.log(LogStatus.FAIL, "Opp_Contactact Is not Null");
				selenium.reportFailure("OppCont Not Null");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
		}
	}


	@And("^I edit Opportunity stage with at least one contact$")
	public void i_edit_Opportunity_stage_with_at_least_one_contact(DataTable table) {
//	public void i_edit_Opportunity_stage_with_at_least_one_contact(){
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrolldown(100);
			Assert.assertFalse(selenium.isElementPresentFast("targetedProductsGetText1"));		//opp should not have any products (opp line items)
			
			selenium.scrollToElement("clickonstageedit");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Recognize";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("checkViewAll");
			if (selenium.isElementPresentFast("checkViewAll")) {
				System.out.println("Opp Contact Value is Not Null");
				selenium.test.log(LogStatus.PASS, "Opp_Contactact Is Visible and Present");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
		}
	}


	@And("^I edit Opportunity stage for null decision dynamic$")
	public void i_edit_Opportunity_stage_for_null_decision_dynamic(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(80000);
			selenium.scrollToElement("Decision_dynamic");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String text2 = selenium.getText("Decision_dynamic");
			if (text2.equalsIgnoreCase("")) {
				System.out.println("Decision dynamic field is blank with no Value in it");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Evaluate";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(7000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while evaluating stage " + e.getMessage());
		}
	}

	@And("^Verify Opportunity Stage with no product solution mentioned$")
	public void verify_Opportunity_Stage_with_no_product_solution_mentioned(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(80000);
			selenium.scrollToElement("Product_Solution");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String text2 = selenium.getText("Product_Solution");
			if (text2.equalsIgnoreCase("")) {
				selenium.test.log(LogStatus.PASS, "Product Solution Field Val Is null");
				System.out.println("Product Solution Field Val Is null");
			} else {
				selenium.test.log(LogStatus.FAIL, "Product Solution Field Val Is Not null");
				System.out.println("Product Solution Field Val Is Not null");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Ordered";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(7000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while evaluating stage " + e.getMessage());
		}
	}


	@And("^Verify Opportunity stage having no value in revenue realization$")
	public void verify_Opportunity_stage_having_no_value_in_revenue_realization(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(80000);
			selenium.scrollToElement("Revenue_realization");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			String text2 = selenium.getText("Revenue_realization");
			if (text2.equalsIgnoreCase("")) {
				selenium.test.log(LogStatus.PASS, "Revenue Realization Field Val Is null");
				System.out.println("Revenue Realization Field Val Is null");
			} else {
				selenium.test.log(LogStatus.FAIL, "Revenue Realization Field Val Is Not null");
				System.out.println("FAIL");
			}
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Delivered";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(7000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while evaluating stage " + e.getMessage());
		}
	}


	@And("^Verify  error is not triggered for Opp Stage Change When Opp Contact is Active$")
	public void verify_error_is_not_triggered_for_Opp_Stage_Change_When_Opp_Contact_is_Active() {
		try {
			selenium.navigateToURL(selenium.OppPIUAddDeleteURL);
			selenium.waitingTime(10000);
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.jsClick("OppStageValue");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}


	@When("^I navigate to opportunity tab and verify validation error even if one contact is inactive$")
	public void i_navigate_to_opportunity_tab_and_verify_validation_error_even_if_one_contact_is_inactive() {
		try {

			/*selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type_propertiesFile("searchItemsTextField", "New_Opportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpportunityClick");
			selenium.jsClick("OpportunityClick");
			selenium.waitingTime(5000);*/

			selenium.navigateToURL(selenium.OppPIUAddDeleteURL);
			selenium.waitingTime(10000);
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("actualStage1");
			String actualStage2 = selenium.getText("actualStage1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Stage");
			selenium.jsClick("Edit_Stage");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageValue");
			selenium.jsClick("OppStageValue");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);
			String text5 = selenium.getText("snagerror");
			if (text5.equalsIgnoreCase("We hit a snag.")) {
				System.out.println("Error :" + text5);
				selenium.test.log(LogStatus.PASS, "Opp Stage Validation Error Received");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}

	@And("^verify opp stage changed having inactive opp contact with no validation error$")
	public void verify_opp_stage_changed_having_inactive_opp_contact_with_no_validation_error(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("openOppContact");
			selenium.waitForElementToBeClickable("openOppContact");
			selenium.hoverAndClick("openOppContact");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("MHHEOppContactN");
			selenium.jsClick("MHHEOppContactN");
			selenium.waitingTime(8000);
			if (selenium.isElementPresentFast("ContactInactiveStatusCheck")) {
				System.out.println("PASS : Contact is in InActive state");
				selenium.test.log(LogStatus.INFO, "Contact is in InActive state");
			}
			selenium.waitingTime(4000);
			selenium.navigateBack();
			selenium.waitingTime(10000);
			selenium.navigateBack();
			selenium.waitingTime(4000);
			selenium.scrolldown(-210);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clickonstageedit");
			selenium.jsClick("clickonstageedit");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			List<WebElement> attribute = selenium.getElements("oppStageList");
			String input = "Resolve";
			for (int i = 0; i < attribute.size(); i++) {
				String text = attribute.get(i).getText();
				selenium.waitingTime(5000);
				System.out.println("test :" + text);
				if (text.equalsIgnoreCase(input)) {
					attribute.get(i).click();
					break;
				}
			}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(6000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}

	@And("^verify Opportunity contact lead date is changed to today date when lead is checked$")
	public void verify_Opportunity_contact_lead_date_is_changed_to_today_date_when_lead_is_checked(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("opp_contacts");
			selenium.jsClick("opp_contacts");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(4000);
			String text12 = selenium.getText("LeadDateCheck");
			if (text12.equalsIgnoreCase("")) {
				System.out.println("Lead Date Is Blank");
				selenium.test.log(LogStatus.INFO, "Lead Date is  blank");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("clickLead");
				selenium.jsClick("clickLead");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("CheckBoxLead1");
				if (selenium.isElementPresentFast("CheckBoxLead1")) {
					selenium.waitForElementToBeClickable("CheckBoxLead1");
					selenium.jsClick("CheckBoxLead1");
				}
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(3000);
				String date = selenium.getText("OppContactLeadSubmittedOnDate");
				System.out.println(date);
				selenium.test.log(LogStatus.PASS, "Submission Date displayed");
				selenium.refresh();
			} else {
				System.out.println("Lead Date is Not Blank");
				selenium.test.log(LogStatus.INFO, "Lead Date Is Not Blank");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while editing Lead Checkbox " + e.getMessage());
		}
	}

	@Then("^verify contact lead date is blank when lead date is not checked$")
	public void verify_contact_lead_date_is_blank_when_lead_date_is_not_checked() {
		try {

			if (selenium.isElementPresentFast("LeadDateCheck")) {
				System.out.println("Lead Date Is Not Blank");
				selenium.test.log(LogStatus.PASS, "Lead Date is not blank");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("clickLead");
				selenium.jsClick("clickLead");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("CheckBoxLead");
				selenium.jsClick("CheckBoxLead");
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(3000);
				String date = selenium.getText("OppContactLeadSubmittedOnDate");
				if (date.isEmpty()) {
					System.out.println("Submission Date Is not displayed");
					selenium.test.log(LogStatus.PASS, "Submission Date Is not displayed");
				}
			} else {
				System.out.println("Lead Date is Blank");
				selenium.test.log(LogStatus.INFO, "Lead Date Is Blank");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}

	@Then("^verify Lead Nomination Submission date is today date$")
	public void verify_Lead_Nomination_Submission_date_is_today_date() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("NominationDate");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("NominationDate");
			String NominationDate1 = selenium.getText("NominationDate");
			System.out.println("NominationDate is " + NominationDate1);
			if (NominationDate1.isEmpty()) {
				System.out.println("Nomination Date Is Blank");
				selenium.test.log(LogStatus.PASS, "Nomination Date is blank");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("CLickOppLeadEdit");
				selenium.jsClick("CLickOppLeadEdit");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ClickLeadChekbox");
				selenium.jsClick("ClickLeadChekbox");
				selenium.waitingTime(5000);
				String word = "UATTest5";
				selenium.waitForElementToBeClickable("AdoptionStatus");
				selenium.typeData("AdoptionStatus", word);
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(3000);
			} else {
				System.out.println("Lead Date is not Blank " + NominationDate1);
				selenium.test.log(LogStatus.INFO, "Lead Date Is not Blank");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}


	@Then("^verify lead nomination is blank when nominate lead is not checked$")
	public void verify_lead_nomination_is_blank_when_nominate_lead_is_not_checked() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("NominationDate");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CLickOppLeadEdit");
			selenium.jsClick("CLickOppLeadEdit");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ClickLeadChekbox");
			selenium.jsClick("ClickLeadChekbox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(3000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}

	@And("^verify Lead Nomination date$")
	public void verify_Lead_Nomination_date(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("NominationDate");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("NominationDate");
			String NominationDate1 = selenium.getText("NominationDate");
			System.out.println("NominationDate is " + NominationDate1);
			if (NominationDate1.isEmpty()) {
				System.out.println("Nomination Date Is Blank");
				selenium.test.log(LogStatus.PASS, "Nomination Date is blank");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("CLickOppLeadEdit");
				selenium.jsClick("CLickOppLeadEdit");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ClickLeadChekbox");
				selenium.jsClick("ClickLeadChekbox");
				selenium.waitingTime(5000);
				String word = "UATTest5";
				selenium.waitForElementToBeClickable("AdoptionStatus");
				selenium.typeData("AdoptionStatus", word);
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(3000);
			} else {
				System.out.println("Lead Date is not Blank " + NominationDate1);
				selenium.test.log(LogStatus.INFO, "Lead Date Is not Blank");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}

	@Then("^verify lead submission date is blank in cloned Opportunity and Opportunity contact$")
	public void verify_lead_submission_date_is_blank_in_cloned_Opportunity_and_Opportunity_contact(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ClickonClone");
			selenium.jsClick("ClickonClone");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("IFrame_Click");
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

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}


	@Then("^I create a new opportunity of MHHE record type$")
	public void i_create_a_new_opportunity_of_MHHE_record_type() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyESDTopTargetField")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyOppAccountAndMHECourseCombination"))
			{
				System.out.println(" Test Case Name is : "+selenium.getTestCaseName());
			}
			else
			{
				selenium.waitForElementToBeClickable("clicknext");
				selenium.click("clicknext");
			}
			selenium.waitingTime(20000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(4000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyESDTopTargetField"))
			{
				selenium.waitForElementToBeClickable("Serach_OppName");
				selenium.hoverAndClick("Serach_OppName");
				String Account = "DREXEL UNIVERSITY";
				selenium.typeData("Serach_OppName", Account);
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OpptyAccountOption");
				selenium.click("OpptyAccountOption");
				selenium.waitingTime(3000);
			}
			else
			{
				selenium.waitForElementToBeClickable("Serach_OppName");
				selenium.hoverAndClick("Serach_OppName");
				String Account = "UNIV OF WISC WHITEWATER";
				selenium.typeData("Serach_OppName", Account);
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("searchOpp");
				selenium.click("searchOpp");
				selenium.waitingTime(3000);
			}

			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.hoverAndClick("OpportunityMHECourse2");
			String Course = "Advanced Engineering Mathematics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.pressEnter("OpportunityMHECourse2");
			selenium.waitForElementToBeVisible("select_course");
			selenium.waitForElementToBeClickable("select_course");
			selenium.hoverAndClick("select_course");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("enrollment_spring");
			selenium.jsClick("enrollment_spring");
			selenium.waitingTime(3000);
			String Value = "20";
			selenium.typeData("enrollment_spring", Value);
			selenium.waitForElementToBeClickable("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment","123");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(9000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^I verify escalate approval button function for Opp record$")
	public void i_verify_escalate_approval_button_function_for_Opp_record() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("showMoreOptionbtn");
			selenium.jsClick("showMoreOptionbtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickEscalateBtn");
			selenium.hoverAndClick("clickEscalateBtn");
			selenium.waitingTime(4000);

			String ISBNXpath = selenium.getDynamicXpath_propertiesFile("AllTagContainsText", "EscalateApprovalMsg", "endContains");
			System.out.println("ISBNXpath is -->" + ISBNXpath);				
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "The expected Escalation Approval message appeared");
			selenium.waitForElementToBeClickable("cancelAprovalbtn");
			selenium.click("cancelAprovalbtn");
			selenium.waitingTime(2000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}
	}

	@Then("^I create a new opportunity record$")
	public void i_create_a_new_opportunity_record() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(6000);
			selenium.switchToMultipleFrame("opportunitiesFrameOneNew1");
			selenium.waitingTime(4000);
			/*selenium.waitForElementToBeClickable("Serach_OppName");
			selenium.hoverAndClick("Serach_OppName");
			String Account = "SAGINAW VALLEY STATE UNIV";
			selenium.typeData("Serach_OppName", Account);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("LookOppAccountNew");
			selenium.click("LookOppAccountNew");*/
			selenium.waitForElementToBeClickable("opportunityAccountName");
			selenium.type_propertiesFile("opportunityAccountName","account_name5");
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_propertiesFile("spanTitle", "account_name5", "end");
			selenium.waitingTime(2000);
			
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.hoverAndClick("OpportunityMHECourse2");
			String Course = "English Special Topics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectCourse1");
			selenium.hoverAndClick("selectCourse1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("enrollment_spring");
			selenium.jsClick("enrollment_spring");
			selenium.waitingTime(3000);
			String Value = "20";
			selenium.typeData("enrollment_spring", Value);
			selenium.waitForElementToBeClickable("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment","123");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(9000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(2000);
			selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^I verify EAM name is populated in Opp record$")
	public void i_verify_EAM_name_is_populated_in_Opp_record() {
		try {
			selenium.waitingTime(10000);
			selenium.scrollToElement("EAMValue");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("EAMPerson");
			String EAMPerson = selenium.getText("EAMPerson");
			System.out.println("EAM Person Name is " + EAMPerson);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("inclusiveAdoptedbtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedbtn");
			selenium.jsClick("inclusiveAdoptedbtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedcheckbox");
			selenium.hoverAndClick("inclusiveAdoptedcheckbox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitForElementToBeClickable("ClickOnCloneBtn");
			selenium.jsClick("ClickOnCloneBtn");
			selenium.waitingTime(9000);
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
			selenium.waitingTime(20000);
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying EAM person name " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@When("^verify EAM receives email when inclusive access adopted is true$")
	public void verify_EAM_receives_email_when_inclusive_access_adopted_is_true() {
		try {

			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("EAMValue");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("EAMPerson");
			String EAMPerson = selenium.getText("EAMPerson");
			System.out.println("EAM Person Name is " + EAMPerson);
			selenium.test.log(LogStatus.PASS, "EAM person name verified successfully");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("inclusiveAdoptedbtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedbtn");
			selenium.jsClick("inclusiveAdoptedbtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedcheckbox");
			selenium.hoverAndClick("inclusiveAdoptedcheckbox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("EAMValue");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("EAMPerson");
			String EAMPerson1 = selenium.getText("EAMPerson");
			System.out.println("EAM Person Name is " + EAMPerson);
			selenium.waitingTime(10000);
			selenium.scrollToElement("inclusiveAdoptedbtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedbtn");
			selenium.jsClick("inclusiveAdoptedbtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("inclusiveAdoptedcheckbox");
			selenium.hoverAndClick("inclusiveAdoptedcheckbox");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(4000);

		} catch (Exception e) {
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^verify enrollment details section is editable on Opportunity page$")
	public void verify_enrollment_details_section_is_editable_on_Opportunity_page() {
		try {
			selenium.waitForElementToBeVisible("Opp_recordtype");
			String GetRecortype = selenium.getText("Opp_recordtype").toString();
			if (GetRecortype.equalsIgnoreCase("Blueprint Adoption")) {
				System.out.println("Opp record type is " + GetRecortype);
				selenium.test.log(LogStatus.PASS, "Oppo Record Type Verified");
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.scrollToElement("Enrollment_Details");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Edit_Springenrollment");
				selenium.jsClick("Edit_Springenrollment");
				String springvalue = "5";
				selenium.typeData("type_springenrollment", springvalue);
				selenium.waitingTime(2000);
				String summervalue = "10";
				selenium.typeData("Edit_Summnerenrollment", summervalue);
				selenium.waitingTime(2000);
				String fallvalue = "15";
				selenium.typeData("Edit_Fallenrollment", fallvalue);
				selenium.waitingTime(2000);
				String winterval = "20";
				selenium.typeData("edit_winterenrollment", winterval);
				String otherenroll = "5";
				selenium.typeData("edit_otherenrollment", otherenroll);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("edit_fromterritory");
				selenium.jsClick("edit_fromterritory");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.hoverAndClick("Save_Btn");
				selenium.waitingTime(3000);
			}
		} catch (Exception e) {
			selenium.reportFailure("Error while editing enrollment details " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@And("^verify reason field has Extending review option for postponed Opp$")
	public void verify_reason_field_has_Extending_review_option_for_postponed_Opp(DataTable table) {
//	public void verify_reason_field_has_Extending_review_option_for_postponed_Opp(){
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("Opp_Reasonfield");
			selenium.waitForElementToBeClickable("Edit_resononopp");
			selenium.jsClick("Edit_resononopp");
			selenium.waitingTime(10000);
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.click("ReasonDDList");
			selenium.waitForElementToBeClickable("Covid19reasonOption"); //ALEKSCasereasonOptionNew
			selenium.jsClick("Covid19reasonOption");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			String Oppreason = selenium.getText("Covid19reasonOption"); //ALEKSCasereasonOptionNew
			System.out.println("Oppreason is " + Oppreason);
			if (Oppreason.equalsIgnoreCase("Extending Review")) {
				System.out.println("Pass : Reason contains EXTENDING REVIEW option in picklist");
				selenium.test.log(LogStatus.PASS, "reason contains extending review option");
				selenium.waitingTime(3000);

			} else {
				System.out.println("Oppreason is " + Oppreason);
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}
	}


	@And("^verify route to market field is editable in opp record$")
	public void verify_route_to_market_field_is_editable_in_opp_record(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("Route_toMarket");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Edit_Routetomarket");
			selenium.jsClick("Edit_Routetomarket");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(5000);
//			String Oppreason = selenium.getText("ALEKSCasereasonOptionNew");
//			System.out.println("Oppreason is " + Oppreason);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while saving an opportunity " + e.getMessage());
		}

	}


	@Then("^create a new case for MHHE Product Support$")
	public void create_a_new_case_for_MHHE_Product_Support() {
		try {
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
			selenium.scrollToElement("Search_contact");
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.jsClick("Search_contact");
			selenium.waitingTime(1000);
			String contactName="SEG Product McGraw Hill Account";
			selenium.typeData("Search_contact",contactName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("show_allcontactresult");
			selenium.hoverAndClick("show_allcontactresult");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("pick_firstContact");
//			selenium.hoverAndClick("pick_firstContact");
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.click("SelectContactName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_firstcontact");
			selenium.jsClick("select_firstcontact");
			selenium.waitingTime(3000);
			selenium.scrollToElement("Support_account");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Support_account");
			selenium.jsClick("Support_account");
			selenium.waitingTime(2000);
			String UnivName = "account";
			selenium.typeData("Support_account", UnivName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("show_allsupportaccountresult");
			selenium.hoverAndClick("show_allsupportaccountresult");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("select_accountfromdropdown1");
//			selenium.hoverAndClick("select_accountfromdropdown1");
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.click("SelectAccountName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.jsClick("Subject_field");
			String subject1 = "UATdemotest";
			selenium.typeData("Subject_field", subject1);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CSOM");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ShowAllResults2");
			selenium.jsClick("ShowAllResults2");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CSOMBusinessHrs");
			selenium.jsClick("CSOMBusinessHrs");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.captureScreenShot();
			selenium.waitingTime(15000);
			selenium.NewCXGCase = selenium.getURL();
			System.out.println("The newly created case URL is " + selenium.NewCXGCase);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}

	}


	@Then("^validate error message for MHE product$")
	public void validate_error_message_for_MHE_product() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitForElementToBeClickable("Product_APR");
			selenium.hoverAndClick("Product_APR");
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
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
			selenium.waitForElementToBeClickable("getfirstIncident");
			selenium.jsClick("getfirstIncident");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectFirst_subincident");
			selenium.hoverAndClick("SelectFirst_subincident");
			selenium.waitingTime(4000);
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
//			selenium.waitForElementToBeClickable("Save_Button");
//			selenium.hoverAndClick("Save_Button");
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
			selenium.waitForElementToBeClickable("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
//			selenium.waitForElementToBeClickable("select_category");
//			selenium.jsClick("select_category");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.waitingTime(3000);
			String errorMessage = "We hit a snag.";
			selenium.waitForElementToBeVisible("snagerror");
			String message = selenium.getText("snagerror");
			if (message.equalsIgnoreCase("errorMessage")) ;
			{
				System.out.println("PASS : Error Message Displayed");
				selenium.test.log(LogStatus.PASS, "Test Case Passed");
				selenium.captureScreenShot();
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Cancel_caseedit");
				selenium.jsClick("Cancel_caseedit");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}


	@Then("^I enter mandatory details and close the case$")
	public void i_enter_mandtory_details_and_close_the_case() {
		try {

			selenium.waitingTime(5000);
			selenium.scrollToElement("Edit_MHEProduct");
			selenium.scrolldown(-200);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Edit_MHEProduct");
			selenium.jsClick("Edit_MHEProduct");
			String testsubjest = "Maths";
			selenium.waitForElementToBeClickable("searchEditProduct");
			selenium.typeData("searchEditProduct", testsubjest);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("showAllProduct");
			selenium.jsClick("showAllProduct");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_subject");
			selenium.hoverAndClick("select_subject");
			selenium.waitingTime(5000);
			selenium.scrollToElement("selectt_category");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("selectt_category");
			selenium.jsClick("selectt_category");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ComponentDropDwn");
			selenium.jsClick("ComponentDropDwn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ComponentDropDwnOption");
			selenium.jsClick("ComponentDropDwnOption");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.hoverAndClick("SaveRecordButton");
			selenium.captureScreenShot();
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
//			selenium.waitForElementToBeClickable("Close_case");
//			selenium.jsClick("Close_case");
//			selenium.waitingTime(20000);
//			selenium.waitForElementToBeClickable("closingStatus");
//			selenium.click("closingStatus");
//			selenium.waitingTime(10000);
//			selenium.waitForElementToBeClickable("closeCaseStatusoption");
//			selenium.hoverAndClick("closeCaseStatusoption");
//			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("caseResolutiontype");
//			selenium.click("caseResolutiontype");
//			String caseResoultiontest ="uattest demo";
//			selenium.typeData("caseResolutiontype",caseResoultiontest);
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("close_unconfirmedCase");
			selenium.jsClick("close_unconfirmedCase");
			selenium.waitForElementToBeVisible("closeCaseSavebtn");
			selenium.jsClick("closeCaseSavebtn");
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.PASS, "Case closed successfully");
			selenium.captureScreenShot();

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}

	@Then("^I fill required case details and create JIRA issue$")
	public void i_fill_required_case_details_and_create_JIRA_issue() {
		try {
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Product_APR");
			selenium.click("Product_APR");
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("getfirstIncident");
			selenium.jsClick("getfirstIncident");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectFirst_subincident");
			selenium.hoverAndClick("SelectFirst_subincident");
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("Internal_description");
//			selenium.jsClick("Internal_description");
//			String CaseDemo = " CXGCaseUATTestDemo";
//			selenium.typeData("Internal_description", CaseDemo);
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
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.click("Save_Button");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(10000);
			selenium.scrollToElement("Edit_MHEProduct");
			selenium.scrolldown(-200);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Edit_MHEProduct");
			selenium.jsClick("Edit_MHEProduct");
			String testsubjest = "Maths";
			selenium.waitForElementToBeClickable("searchEditProduct");
			selenium.typeData("searchEditProduct", testsubjest);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("showAllProduct");
			selenium.jsClick("showAllProduct");
			selenium.waitForElementToBeClickable("select_subject");
			selenium.hoverAndClick("select_subject");
			selenium.waitingTime(10000);
			selenium.scrollToElement("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_CategoryDropdown");
			selenium.jsClick("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			String Jiradescription = "TestUATDemo";
			selenium.waitForElementToBeClickable("jira_description");
			selenium.typeData("jira_description", Jiradescription);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("imprint_P&MDropdown");
			selenium.jsClick("imprint_P&MDropdown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("imprint_picklictOption");
			selenium.jsClick("imprint_picklictOption");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("pnm_Unit");		//this field has been removed as part of GCRM-24677
//			selenium.jsClick("pnm_Unit");
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("pnm_dropdownOption");
//			selenium.hoverAndClick("pnm_dropdownOption");
//			selenium.waitingTime(3000);
			
			Assert.assertFalse(selenium.isElementPresentFast("pnm_Unit"));
			selenium.test.log(LogStatus.PASS, "P&M field has been removed from Case page");	//GCRM-24675
			selenium.waitForElementToBeClickable("ComponentDropDwn");
			selenium.jsClick("ComponentDropDwn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("component_dropdownOption");
			selenium.jsClick("component_dropdownOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("click_JIRA");
			selenium.hoverAndClick("click_JIRA");
			selenium.waitingTime(7000);
			selenium.scrollToElement("jira_issues");
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AssociateOrCreateJiraIssueBtn");
			selenium.jsClick("AssociateOrCreateJiraIssueBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("create_jirabtn");
			selenium.jsClick("create_jirabtn");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("jira_projectBtn");
			selenium.jsClick("jira_projectBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("project_dropdownOption");
			selenium.hoverAndClick("project_dropdownOption");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("required_Field");
			selenium.jsClick("required_Field");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("description_field");
			selenium.jsClick("description_field");
			String textarea = "Demotests";
			selenium.typeData("description_field", textarea);
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("pnm_Unit");
			selenium.jsClick("pnm_Unit");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("pnm_dropdownOption");
			selenium.hoverAndClick("pnm_dropdownOption");
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_Discipline");
			selenium.jsClick("select_Discipline");
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("click_createBtn");
			selenium.jsClick("click_createBtn");
			selenium.waitingTime(10000);
			selenium.scrollToElement("jira_issueBtn");
			selenium.scrolldown(-250);
			selenium.waitingTime(7000);
			selenium.waitForElementToBeClickable("jira_showMenu");
			selenium.jsClick("jira_showMenu");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("jira_issueunlinkBtn");
			selenium.captureScreenShot();
			if (selenium.getElement("jira_issueunlinkBtn").isDisplayed()) {
				System.out.println("CXG Case Is Linked to JIRA Issue");
				selenium.test.log(LogStatus.PASS, "CXG Case Is Linked to JIRA Issue");

			} else {
				System.out.println("CXG Case Is Not Linked to JIRA Issue");
				selenium.test.log(LogStatus.FAIL, "CXG Case Is Not Linked to JIRA Issue");
				selenium.reportFailure("XG Case Is Not Linked to JIRA Issue");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}
	
	@Then("^I fill required case details and create new JIRA issue with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_fill_required_case_details_and_create_new_JIRA_issue(String Incident, String SubIncident) {
		try {
			selenium.navigateToURL(selenium.NewCXGCase);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Product_APR");
			selenium.click("Product_APR");
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(3000);
			selenium.clickDynamicXpath_data("Text_Span", Incident, "end");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(3000);
			selenium.clickDynamicXpath_data("alltextContainsDataValue", SubIncident, "endContains");
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
			selenium.typeData("Internal_Description1", "Testing");
			selenium.waitingTime(2000);
			selenium.scrollToElement("Save_Button");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.click("Save_Button");
			selenium.waitingTime(15000);
			selenium.refresh();
			selenium.checkFlowInterruptedPopup();
			selenium.waitingTime(10000);
			
			if(Incident.equals("Instructor Course/Section Management"))	//running below code block just for one test data as it won't make any diff if we run for all diff test data sets.
			{
				selenium.scrollToElement("Edit_MHEProduct");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Edit_MHEProduct");
				selenium.jsClick("Edit_MHEProduct");
				String testsubjest = "Maths";
				selenium.waitForElementToBeClickable("searchEditProduct");
				selenium.typeData("searchEditProduct", testsubjest);
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("showAllProduct");
				selenium.jsClick("showAllProduct");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("select_subject");
				selenium.hoverAndClick("select_subject");
				selenium.waitingTime(10000);
				selenium.scrollToElement("select_CategoryDropdown");
				selenium.waitingTime(2000);
				selenium.scrolldown(-220);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("select_CategoryDropdown");
				selenium.jsClick("select_CategoryDropdown");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("select_categoryDropdownoption");
				selenium.jsClick("select_categoryDropdownoption");
				selenium.waitingTime(2000);
				String Jiradescription = "TestUATDemo";
				selenium.waitForElementToBeClickable("jira_description");
				selenium.typeData("jira_description", Jiradescription);
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("imprint_P&MDropdown");
				selenium.jsClick("imprint_P&MDropdown");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("imprint_picklictOption");
				selenium.jsClick("imprint_picklictOption");
				selenium.waitingTime(4000);			
				selenium.waitForElementToBeClickable("ComponentDropDwn");
				selenium.jsClick("ComponentDropDwn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("component_dropdownOption");
				selenium.jsClick("component_dropdownOption");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SaveRecordButton");
				selenium.jsClick("SaveRecordButton");
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.checkFlowInterruptedPopup();
			}
			selenium.waitForElementToBeClickable("click_JIRA");
			selenium.hoverAndClick("click_JIRA");
			selenium.waitingTime(7000);
			selenium.scrollToElement("jira_issues");
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("AssociateOrCreateJiraIssueBtn");
			selenium.jsClick("AssociateOrCreateJiraIssueBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("create_jirabtn");
			selenium.jsClick("create_jirabtn");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeClickable("jira_projectBtn");
			selenium.jsClick("jira_projectBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("project_dropdownOption");
			selenium.hoverAndClick("project_dropdownOption");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("required_Field");
			selenium.jsClick("required_Field");
			selenium.waitingTime(3000);
			
			selenium.waitForElementToBeClickable("JIRASummaryTextbox");
			selenium.typeData("JIRASummaryTextbox", "testing");
			selenium.typeData("JIRADescriptionTextbox", "testing");
			selenium.typeData("JIRAComponentsList", "ABA");
			selenium.waitingTime(4000);
			selenium.click("JIRAComponentsValue");
			selenium.waitingTime(2000);
			selenium.click("JIRAImprintList");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("JIRAImprintValue");
			selenium.click("JIRAImprintValue");
			selenium.waitForElementToBeClickable("JIRACategoryList");
			selenium.click("JIRACategoryList");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("JIRACategoryValue");
			selenium.click("JIRACategoryValue");
			selenium.waitForElementToBeClickable("JIRABusinessUnitList");
			selenium.click("JIRABusinessUnitList");
			selenium.waitingTime(4000);
//			selenium.click("JIRAComponentsValue");
			selenium.waitForElementToBeClickable("JIRABusinessUnitValue");
			selenium.click("JIRABusinessUnitValue");
			/*selenium.waitForElementToBeClickable("description_field");
			selenium.jsClick("description_field");
			String textarea = "Demotests";
			selenium.typeData("description_field", textarea);
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("pnm_Unit");
			selenium.jsClick("pnm_Unit");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("pnm_dropdownOption");
			selenium.hoverAndClick("pnm_dropdownOption");*/
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown");
			selenium.jsClick("ProductDisciplineDropdown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_Discipline");
			selenium.jsClick("select_Discipline");
			selenium.waitingTime(3000);			
			selenium.waitForElementToBeClickable("click_createBtn");
			selenium.jsClick("click_createBtn");
			selenium.waitingTime(10000);
			
			selenium.scrollToElement("jira_issueBtn");
			selenium.scrolldown(-250);
			selenium.waitingTime(7000);
			selenium.waitForElementToBeClickable("jira_showMenu");
			selenium.jsClick("jira_showMenu");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("jira_issueunlinkBtn");
			selenium.captureScreenShot();
			if (selenium.getElement("jira_issueunlinkBtn").isDisplayed()) {
				System.out.println("CXG Case Is Linked to JIRA Issue");
				selenium.test.log(LogStatus.PASS, "CXG Case Is Linked to JIRA Issue");

			} else {
				System.out.println("CXG Case Is Not Linked to JIRA Issue");
				selenium.test.log(LogStatus.FAIL, "CXG Case Is Not Linked to JIRA Issue");
				selenium.reportFailure("XG Case Is Not Linked to JIRA Issue");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}
	
	@And("close the CXG case")
	public void close_the_CXG_case(){
		try{
			 if(selenium.isElementPresentFast("Close_case"))
			 {
				 selenium.waitForElementToBeClickable("Close_case");
			 	 selenium.jsClick("Close_case");
			 }
			 else
			 {
				 selenium.waitForElementToBeClickable("moreActionsBtn");
				 selenium.jsClick("moreActionsBtn");
				 selenium.waitingTime(1000);
				 selenium.waitForElementToBeClickable("Close_case");
				 selenium.jsClick("Close_case");
			 }
			 selenium.waitingTime(8000);
			 selenium.waitForElementToBeClickable("closingStatus");
			 selenium.jsClick("closingStatus");
			 selenium.waitingTime(2000);
			 selenium.selectDropdownText_Data("closingStatus", "Closed");
			 selenium.waitForElementToBeClickable("caseResolution");
			 selenium.jsClick("caseResolution");
			 selenium.waitingTime(2000);
			 selenium.typeData("caseResolution", "Automation Testing");
			 selenium.waitForElementToBeClickable("caseCXGCloseMarketDropdown");
			 selenium.jsClick("caseCXGCloseMarketDropdown");
			 selenium.waitingTime(2000);
			 selenium.clickDynamicData("spanTitle", "Consumer", "end");
			 selenium.waitForElementToBeVisible("saveButton");
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(15000);
			 selenium.test.log(LogStatus.PASS, "Case closed successfully");
			 
		 	String status = selenium.getText("caseCXGClosedStatus").toString();
			String expected_status = "Closed";
			System.out.println("status" +status + expected_status );
			selenium.captureScreenShot();
			if (status.equalsIgnoreCase(expected_status)) {
				System.out.println("inside pass" );
				selenium.test.log(LogStatus.PASS, "Status is closed : "+status +" Expected : "+expected_status);

			} else {
				System.out.println("inside fail" );
				selenium.test.log(LogStatus.FAIL, "Status is closed : "+status +" Expected : "+expected_status);
				selenium.reportFailure("Test Case Failed");
				

			}
			
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("Edit the created Jira issue")
	public void edit_the_created_jira_issue(){
		try{
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("Product_DropDownNew");
			selenium.jsClick("Product_DropDownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.jsClick("ProductOptionConnect");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("click_onSubProduct");
			selenium.jsClick("click_onSubProduct");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductOptionNoSubProduct");
			selenium.jsClick("ProductOptionNoSubProduct");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("VersionDropDown");	//this field has been removed as part of GCRM-24677
//			selenium.jsClick("VersionDropDown");
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("VersionOption");
//			selenium.jsClick("VersionOption");
//			selenium.waitingTime(2000);
			
			Assert.assertFalse(selenium.isElementPresentFast("VersionDropDown"));
			selenium.test.log(LogStatus.PASS, "Version field has been removed from Internal Description tab of Case Details page");	//GCRM-24675
			
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("BU_Option");
			selenium.jsClick("BU_Option");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SubIncidentContentDispute");
			selenium.jsClick("SubIncidentContentDispute");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductDisciplineDropdown1");
			selenium.jsClick("ProductDisciplineDropdown1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DisciplineOption1");
			selenium.jsClick("DisciplineOption1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.jsClick("Save_Button");
			selenium.waitingTime(8000);

			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.scrollToElement("CXGEditCategory");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGEditCategory");
			selenium.jsClick("CXGEditCategory");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("CXGCategoryDropDown");
			selenium.jsClick("CXGCategoryDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("select_categoryDropdownoption");
			selenium.jsClick("select_categoryDropdownoption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CXGComponentDropDown");
			selenium.jsClick("CXGComponentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ComponentQuestionBank");
			selenium.jsClick("ComponentQuestionBank");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
//			selenium.waitingTime(8000);
//			selenium.refresh();
			selenium.waitingTime(15000);

		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

	@Then("^create a new case for CXG$")
	public void create_a_new_case_for_CXG() {
		try {
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
			selenium.scrollToElement("Search_contact");
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Search_contact");
//			selenium.jsClick("Search_contact");
//			selenium.waitingTime(2000);
			selenium.typeData("Search_contact", "Guy Geraci");
			selenium.waitingTime(4000);
			selenium.autoSuggestiveDropdownWithoutText("Search_contact");
//			selenium.waitForElementToBeClickable("Select_contact");
//			selenium.hoverAndClick("Select_contact");
			selenium.waitingTime(2000);
			/*String contactName="SEG Product McGraw Hill Account";
			selenium.typeData("Search_contact",contactName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("show_allcontactresult");
			selenium.hoverAndClick("show_allcontactresult");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("pick_firstContact");
			selenium.hoverAndClick("pick_firstContact");
			selenium.waitingTime(3000);*/
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_firstcontact");
			selenium.jsClick("select_firstcontact");
			selenium.waitingTime(3000);
			selenium.scrollToElement("Support_account");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Support_account");
			selenium.jsClick("Support_account");
			selenium.waitingTime(2000);
			String UnivName = "account";
			selenium.typeData("Support_account", UnivName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("show_allsupportaccountresult");
			selenium.hoverAndClick("show_allsupportaccountresult");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("select_accountfromdropdown1");
//			selenium.hoverAndClick("select_accountfromdropdown1");
			selenium.waitForElementToBeClickable("SelectAccountName");
			selenium.click("SelectAccountName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.jsClick("Subject_field");
			String subject1 = "UATdemotest";
			selenium.typeData("Subject_field", subject1);
			selenium.waitingTime(4000);
			selenium.scrollToElement("select_BuHours");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.click("Business_Hours_DropDown");
			String CXGtime = "CXG";
			selenium.typeData("Business_Hours_DropDown", CXGtime);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("cxg_hours");
			selenium.hoverAndClick("cxg_hours");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.captureScreenShot();
			selenium.waitingTime(7000);

		} catch (Exception e) {
			selenium.click("CancelButton");
			selenium.waitingTime(5000);
			if(selenium.isElementPresentFast("CancelButton"))
			{
				selenium.click("CancelButton");
				selenium.waitingTime(5000);
			}
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}

	}

	@When("^I verify Case details$")
	public void i_verify_Case_details() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("loginPopUpNew"))
			{
				selenium.clickLoop("loginPopUpNew");
				selenium.waitingTime(3000);
			}
			selenium.checkFlowInterruptedPopup();
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitForElementToBeClickable("Product_APR");
			selenium.hoverAndClick("Product_APR");
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
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
			selenium.waitForElementToBeClickable("getfirstIncident");
			selenium.jsClick("getfirstIncident");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectFirst_subincident");
			selenium.hoverAndClick("SelectFirst_subincident");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Internal_description");
			selenium.jsClick("Internal_description");
			String CaseDemo = " CXGCaseUATTestDemo";
			selenium.typeData("Internal_description", CaseDemo);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Save_Button");
			selenium.hoverAndClick("Save_Button");
			selenium.waitingTime(10000);
			selenium.scrollToElement("jira_TicketFields");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Edit_Category");
			selenium.jsClick("Edit_Category");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("ProductFieldVerify");
			String jiraProductName = selenium.getText("ProductFieldVerify").toString();
			System.out.println(jiraProductName);
			selenium.waitingTime(4000);
			boolean editBtn = selenium.isElementPresentFast("editBtn");
			boolean printOption = selenium.isElementPresentFast("ProductFieldVerify");
			if (editBtn == false && printOption == true) {
				System.out.println("PASS : Product Field Is Not Editable");
				selenium.test.log(LogStatus.PASS, "Product Field Is Not Editable");
				selenium.test.log(LogStatus.INFO, "Product Field Is Not Editable");
			}
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}

	@When("^I verify Category Picklist Value$")
	public void i_verify_Category_Picklist_Value(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("select_CategoryDropdown");
			selenium.jsClick("select_CategoryDropdown");
			selenium.waitingTime(2000);
			selenium.waitingTime(2000);
			String xpath = selenium.getDynamicXpath_data("spanTitle", data.get(0), "end");
			System.out.println(xpath);
			String xpath1 = selenium.getDynamicXpath_data("spanTitle", data.get(1), "end");
			System.out.println(xpath1);
			String xpath2 = selenium.getDynamicXpath_data("spanTitle", data.get(2), "end");
			System.out.println(xpath2);
			if (selenium.isElementPresentXpathFast(xpath)) {
				System.out.println("Verified picklist value successfully!");
				if (selenium.isElementPresentXpathFast(xpath1)) {
					System.out.println("Verified picklist1 value successfully!");

					if (selenium.isElementPresentXpathFast(xpath2)) {
						System.out.println("Verified picklist2 value successfully!");
						selenium.captureScreenShot();
					}
				}
			} else {
				selenium.test.log(LogStatus.FAIL, "Picklist value is missing!");
				selenium.reportFailure("Picklist value is missing!");
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating error for MHE product " + e.getMessage());
		}

	}


	@When("^verify edit option for CXG user$")
	public void verify_edit_option_for_CXG_user() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("editButton");
			if (!(selenium.isElementPresentFast("editButton"))) {
				selenium.test.log(LogStatus.PASS, "Edit Option is Not Present For User");
				System.out.println("PASS : Edit Option is Not Present ");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "Validation failed ");
				selenium.reportFailure("Validation failed ");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}

	@When("^verify edit option for CXG Admin user$")
	public void verify_edit_option_for_CXG_Admin_user() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("editButton");
			if ((selenium.isElementPresentFast("editButton"))) {
				selenium.test.log(LogStatus.PASS, "Edit Option is Present For User");
				System.out.println("PASS : Edit Option is Present ");
			} else {
				selenium.test.log(LogStatus.FAIL, "Edit Option is not Present ");
				selenium.reportFailure("Edit Option is not Present ");
				System.out.println("FAIL");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}

	@When("^I create a new case for SEG Product Support$")
	public void i_create_a_new_case_for_SEG_Product_Support() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("click_newcaseBtn");
			selenium.jsClick("click_newcaseBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("seg_caserecordtype");
			selenium.hoverAndClick("seg_caserecordtype");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.hoverAndClick("NextButton");
			selenium.waitingTime(4000);
			selenium.scrollToElement("case_originField");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("caseOriginSkillDropdownNew");
			selenium.jsClick("caseOriginSkillDropdownNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_caseOriginSkill");
			selenium.jsClick("select_caseOriginSkill");
			selenium.waitingTime(3000);
			selenium.scrollToElement("internal_descriptionField");
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("description_textarea");
			selenium.jsClick("description_textarea");
			String testdemo = "UAT demo test";
			selenium.typeData("description_textarea", testdemo);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.hoverAndClick("Save_Btn");
			selenium.waitingTime(10000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}

	@When("^verify K12 leadership section on JIRA tab$")
	public void verify_K12_leadership_section_on_JIRA_tab() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("jiraTabBtn");
			selenium.jsClick("jiraTabBtn");
			selenium.waitingTime(6000);
			selenium.scrollToElement("k12_section1");
			selenium.scrolldown(-230);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("subRoot_causefield");
			if (selenium.isElementPresentFast("subRoot_causefield") && selenium.isElementPresentFast("jiraRootCausefield")) {
				System.out.println("Root Cause & Sub-Root Cause Field is Present");
				selenium.captureScreenShot();
				selenium.test.log(LogStatus.PASS, "Expected K12 Fields are Present");
			} else {
				selenium.test.log(LogStatus.FAIL, "The expected Fields are NOT present ");
				selenium.reportFailure("The expected Fields are NOT present");
				System.out.println("FAIL");
			}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("editEscalatedBtn");
			selenium.jsClick("editEscalatedBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("escalatedDatecheckbox");
			selenium.jsClick("escalatedDatecheckbox");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeVisible("escalated_caseTime");
//			String time1 = selenium.getText("escalated_caseTime").toString();
//			System.out.println(" Date & Time at the time of checking the checkbox " + time1);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.hoverAndClick("SaveRecordButton");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("case_priorityField");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("case_priority");
			String priority = selenium.getText("case_priority").toString();
			String expected_priority = "High";
			System.out.println("status" + priority + expected_priority);
			if (priority.equalsIgnoreCase(expected_priority)) {
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "Case Priority changed successfully");

			} else {
				System.out.println("inside fail");
				selenium.test.log(LogStatus.FAIL, "Existing Case editing failed");
				selenium.reportFailure("Existing Case editing failed");

			}
			selenium.waitingTime(5000);


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}


	@When("^I create a case for the contact$")
	public void i_create_a_case_for_the_contact() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstOppOrderRecord");
			selenium.jsClick("FirstOppOrderRecord");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("newCase");
			selenium.jsClick("newCase");
			selenium.waitingTime(5000);
			selenium.scrollToElement("field_product");
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.jsClick("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProductType_ALEKS");
			selenium.jsClick("ProductType_ALEKS");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("reason_dropdown");
			selenium.jsClick("reason_dropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ALEKSCasereasonOptionNew");
			selenium.jsClick("ALEKSCasereasonOptionNew");
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("incident_option");
			boolean incident = selenium.isElementPresentXpathFast("incident_option");
			if (incident == false) {
				System.out.println("Incident Dropdown is not present");
				selenium.test.log(LogStatus.PASS, "Incident Dropdown is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("clickOnsubject");
			selenium.jsClick("clickOnsubject");
			String subject1 = "Test Case UAT";
			selenium.typeData("clickOnsubject", subject1);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("description_textarea");
			selenium.jsClick("description_textarea");
			String description = "UAT TestDemo";
			selenium.typeData("description_textarea", description);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("saveButton");
			selenium.hoverAndClick("saveButton");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}


	@When("^verify case fields are auto populated$")
	public void verify_case_fields_are_auto_populated() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.scrollToElement("product_information");
			selenium.scrolldown(-220);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("incident_fieldvalue");
			selenium.waitForElementToBeVisible("subincidentvalue");
			String incident = selenium.getText("incident_fieldvalue").toString();
			System.out.println(" Value present in incident field is " + incident);
			String subincident = selenium.getText("subincidentvalue").toString();
			System.out.println(" Value present in sub-incident field is " + subincident);
			String incidentvalue1 = "Other";
			String subincidentvalue1 = "See Case Comments";
			if (incident.equalsIgnoreCase(incidentvalue1) && (subincident.equalsIgnoreCase(subincidentvalue1))) {
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "incident & sub-incident values are auto populated after case creation");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while validating feature for CXG Case " + e.getMessage());
		}

	}

	@When("^I create a case for digital sales support$")
	public void i_create_a_case_for_digital_sales_support() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("select_recordtypeBtn");
			selenium.jsClick("select_recordtypeBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.scrollToElement("caseorigin_field");
			selenium.scrolldown(-220);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Case_OriginDropDown");
			selenium.click("Case_OriginDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("case_originOption");
			selenium.jsClick("case_originOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.jsClick("Business_Hours_DropDown");
			String timezone="MHHE";
			selenium.typeData("Business_Hours_DropDown",timezone);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("business_hoursTiming");
			selenium.hoverAndClick("business_hoursTiming");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("search_producttextbox");
			selenium.jsClick("search_producttextbox");
			selenium.waitingTime(2000);
			String subject="Biology";
			selenium.typeData("search_producttextbox",subject);
//			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("selectBioSubject");
//			selenium.hoverAndClick("selectBioSubject");
//			selenium.waitingTime(4000);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectProductName");
			selenium.jsClick("SelectProductName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.waitingTime(5000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}
	
	@And("close the digital sales support case")
	public void close_the_digital_sales_support_case()
	{
		try
		{
			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyJIRAIssueCreation"))
			{
				selenium.navigateToURL(selenium.NewCXGCase);
				selenium.waitingTime(10000);
				selenium.refresh();
				selenium.waitingTime(20000);
				selenium.checkFlowInterruptedPopup();
			}
			if(selenium.isElementPresentFast("Close_case"))
			{
				 selenium.waitForElementToBeClickable("Close_case");
				 selenium.jsClick("Close_case");
			}
			else
			{
				 selenium.waitForElementToBeClickable("moreActionsBtn");
				 selenium.jsClick("moreActionsBtn");
				 selenium.waitingTime(1000);
				 selenium.waitForElementToBeClickable("Close_case");
				 selenium.jsClick("Close_case");
			}
			 selenium.waitingTime(8000);
			 selenium.switchToFrame("newAccountFrame");
			 selenium.waitForElementToBeClickable("closingStatus");
			 selenium.jsClick("closingStatus");
			 selenium.waitingTime(2000);
			 selenium.selectDropdownText_Data("closingStatus", "Closed");
			 selenium.waitForElementToBeClickable("closeCaseReasonField");
			 selenium.click("closeCaseReasonField");
			 selenium.waitingTime(3000);
			 if (selenium.getTestCaseName().equalsIgnoreCase("VerifyJIRAIssueCreation"))
			 {
				 selenium.waitForElementToBeClickable("closeCaseReasonValue3");
				 selenium.click("closeCaseReasonValue3");
			 }
			 else
			 {
				 selenium.waitForElementToBeClickable("closeCaseReasonValue2");
			 	 selenium.click("closeCaseReasonValue2");
			 }
			 selenium.waitingTime(1000);
			 selenium.waitForElementToBeClickable("caseResolutionNew");
			 selenium.jsClick("caseResolutionNew");
			 selenium.waitingTime(2000);
			 selenium.typeData("caseResolutionNew", "Automation Testing");
			 selenium.waitForElementToBeVisible("saveButton");
			 selenium.jsClick("saveButton");
			 selenium.waitingTime(15000);
			 selenium.switchOutOfFrame();
			 selenium.test.log(LogStatus.PASS, "Case closed successfully");			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

	@When("^I verify MHE product field is editable$")
	public void i_verify_MHE_product_field_is_editable() {
		try {
			selenium.waitingTime(5000);
			selenium.scrollToElement("mhe_productfield");
			selenium.waitingTime(2000);
			selenium.scrolldown(-350);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("edit_MHEproductBtn");
			selenium.waitingTime(3000);
			if (selenium.isElementPresentFast("edit_MHEproductBtn"))
			{
				System.out.println("PASS : MHE Product Field is editable");
				selenium.test.log(LogStatus.PASS, "Field is editable");
			}

			else
			{
				System.out.println("MHE Product Field is not editable");
				selenium.test.log(LogStatus.FAIL,"Field is not editable");
			}
			selenium.waitingTime(4000);
			String MHEProduct=selenium.getText("mheProductvalue").toString();
			System.out.println(" Value present in MHEProduct is " + MHEProduct);

			if(!(MHEProduct.isEmpty()))
			{
				selenium.test.log(LogStatus.PASS,"MHE Product Field is not blank");
				System.out.println("Pass : MHE Product Field is not blank");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL,"MHE product field is blank");
				System.out.println("MHE product field is blank");
			}
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("edit_MHEproductBtn");
			selenium.jsClick("edit_MHEproductBtn");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("clear_MHEProductfield");
			selenium.jsClick("clear_MHEProductfield");
			selenium.waitingTime(3000);
			String subject2="Maths";
			selenium.typeData("search_producttextbox",subject2);
//			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("showAllsearchedResult");
//			selenium.jsClick("showAllsearchedResult");
//			selenium.waitingTime(4000);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ShowAllResults");
			selenium.clickLoop("ShowAllResults");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SelectProductName");
			selenium.jsClick("SelectProductName");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.hoverAndClick("SaveRecordButton");
			selenium.captureScreenShot();
			System.out.println("MHE Product Updated Successfully");
			selenium.waitingTime(10000);


		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}

	@When("^I verify the component value for case$")
	public void i_verify_the_component_value_for_case() {
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
			selenium.waitForElementToBeClickable("Product_APR");
			selenium.hoverAndClick("Product_APR");
			selenium.waitForElementToBeClickable("click_subproduct");
			selenium.click("click_subproduct");
			selenium.waitForElementToBeClickable("select_subProduct");
			selenium.jsClick("select_subProduct");
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
			selenium.waitForElementToBeClickable("select_componenetfrompicklist");
			selenium.jsClick("select_componenetfrompicklist");
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("select_componenetfrompicklist")) {
				System.out.println("Pass: Case Has New Componenet Value");
				selenium.test.log(LogStatus.PASS, "Case Has New Componenet Value");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Case do not have new Component Value");
				selenium.reportFailure("Case do not have new Component Value");
				System.out.println("FAIL");}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}


	@When("^Verify picklist value for Product field$")
	public void verify_picklist_value_for_Product_field() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitingTime(4000);
			if(!(selenium.isElementPresentFast("select_connect2Product") && selenium.isElementPresentFast("select_productvalue")))
			{
				System.out.println("Product Connect2 & ellevate is not present in product field");
				selenium.test.log(LogStatus.PASS, "Product Connect2 is not present in product field");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Product Connect2 & ellevate is present in product field");
				System.out.println("FAIL");}
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("CancelEdit");
			selenium.jsClick("CancelEdit");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}
	
	@And("^verify JIRA API Logs related list in case and fields non-editable$")
	public void verify_JIRA_API_Logs_related_list_in_case_noneditable() {
		try {
			//not sure how to get value under the JIRA API Logs related list in the newly created case, so using existing case record
			selenium.navigateToURL(CaseURL_JIRAAPILogs);
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("JIRAAPILogsRelatedList"))
			{
				selenium.waitForElementToBeVisible("JIRAAPILogsRelatedList");
				selenium.jsClick("JIRAAPILogsRelatedList");
			}
			else
			{
				selenium.click("showAllLinks");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("JIRAAPILogsRelatedList");
				selenium.jsClick("JIRAAPILogsRelatedList");
			}

			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(8000);
			Assert.assertTrue(selenium.isElementPresentFast("JIRAAPILogField"));		//just randomly verifying one field
			Assert.assertFalse(selenium.isElementPresentFast("EditJIRAIssueKey"));		//Edit option should not present
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

	@And("^verify JIRA API Logs related list in case and fields editable$")
	public void verify_JIRA_API_Logs_related_list_in_case_editable() {
		try {
			//not sure how to get value under the JIRA API Logs related list in the newly created case, so using existing case record
			selenium.navigateToURL(CaseURL_JIRAAPILogs);
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("JIRAAPILogsRelatedList"))
			{
				selenium.waitForElementToBeVisible("JIRAAPILogsRelatedList");
				selenium.jsClick("JIRAAPILogsRelatedList");
			}
			else
			{
				selenium.click("showAllLinks");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("JIRAAPILogsRelatedList");
				selenium.jsClick("JIRAAPILogsRelatedList");
			}

			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeVisible("FirstTableRecord");
			selenium.jsClick("FirstTableRecord");
			selenium.waitingTime(8000);
			Assert.assertTrue(selenium.isElementPresentFast("JIRAAPILogField"));			//just randomly verifying one field
			Assert.assertTrue(selenium.isElementPresentFast("EditJIRAIssueKey"));			//Edit option should present
			Assert.assertTrue(selenium.isElementPresentFast("OneReachAPIRequestLabel"));	//Connect API Request renamed as OneReachAPI Request
			Assert.assertTrue(selenium.isElementPresentFast("OneReachAPIErrorLabel"));		//Connect API Error renamed as OneReach API Error
			Assert.assertTrue(selenium.isElementPresentFast("CaseNumberLabel"));			//verify the Case number field is added to the layout
			
			selenium.jsClick("EditSFDCJIRAAPIStatusIcon");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("SFDCJIRAAPIStatusEditField");
			selenium.click("SFDCJIRAAPIStatusEditField");
			selenium.waitForElementToBeClickable("SFDCJIRAAPIStatus_Error");
			selenium.click("SFDCJIRAAPIStatus_Error");
			selenium.typeData("SFDCJIRAAPIErrorsTextField", "Automation Test");
			selenium.jsClick("ReprocessJIRAAPIChkbx");
			selenium.waitingTime(2000);
			selenium.scrollToElement("Save_Btn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.click("Save_Btn");
			selenium.waitingTime(8000);
			
			selenium.waitForElementToBeClickable("contact_historyLink");
			selenium.jsClick("contact_historyLink");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
						
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy, h:mm a");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			selenium.waitForElementToBeVisible("JIRAHistoryDate");
			String recordDate = selenium.getTextLoop("JIRAHistoryDate").toString();
			System.out.println("todays date" + todaysDate);
			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);

			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
				selenium.test.log(LogStatus.PASS, "JIRA API Logs history Has Been Verified Successfully");
				System.out.println("PASS");
				selenium.captureScreenShot();
			} else {
				selenium.test.log(LogStatus.FAIL, "OJIRA API Logs history Page Verification Failed");
				selenium.reportFailure("JIRA API Logs history Page Verification Failed");
				System.out.println("FAIL");
			}
		} catch (Exception e) {	
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@When("^verify sub product picklist value for created case$")
	public void verify_sub_product_picklist_value_for_created_case() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.scrollToElement("ProdDropdownList");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ProdDropdownList");
			selenium.click("ProdDropdownList");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("ProductOptionConnect");
			selenium.jsClick("ProductOptionConnect");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("click_onSubProduct");
			selenium.jsClick("click_onSubProduct");
			if(selenium.isElementPresentFast("select_connect2Product") && selenium.isElementPresentFast("select_productvalue"))
			{
				System.out.println(" PASS : Connect2 and Ellevate sub product are present for Connect Produc ");
				selenium.test.log(LogStatus.PASS,"Connect2 and Ellevate sub product are present for Connect Product");
			}

			else {
				selenium.test.log(LogStatus.FAIL, "Product Connect2 & ellevate is not present in sub-product field");
				System.out.println("FAIL");}
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("select_connect2Product");
			selenium.jsClick("select_connect2Product");
			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("select_Version1");
//			selenium.jsClick("select_Version1");
//			selenium.waitingTime(3000);
//			selenium.waitForElementToBeClickable("select_Version");
//			selenium.jsClick("select_Version");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("select_BU");
			selenium.jsClick("select_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("selectBEC_BU");
			selenium.jsClick("selectBEC_BU");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("IncidentDropDown");
			selenium.jsClick("IncidentDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("getfirstIncident");
			selenium.jsClick("getfirstIncident");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Sub_IncidnetDropDown");
			selenium.jsClick("Sub_IncidnetDropDown");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("SelectFirst_subincident");
			selenium.hoverAndClick("SelectFirst_subincident");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("select_Disciplinedropdown");
			selenium.jsClick("select_Disciplinedropdown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_Discipline");
			selenium.jsClick("select_Discipline");
			selenium.waitingTime(5000);
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
			selenium.checkFlowInterruptedPopup();		

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}

	@Then("verify the support account error message")
	public void verify_the_support_account_error_message(){
		try{
			selenium.waitingTime(10000);
			selenium.checkFlowInterruptedPopup();
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(5000);
			selenium.scrollToElement("Search_contact");
			selenium.scrolldown(-250);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Search_contact");
			selenium.jsClick("Search_contact");
			selenium.waitingTime(1000);
			String contactName="SEG Product McGraw Hill Account";
			selenium.typeData("Search_contact",contactName);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("show_allcontactresult");
			selenium.hoverAndClick("show_allcontactresult");
			selenium.waitingTime(5000);
//			selenium.waitForElementToBeClickable("pick_firstContact");
//			selenium.hoverAndClick("pick_firstContact");
			selenium.waitForElementToBeClickable("SelectContactName");
			selenium.click("SelectContactName");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("contactTypeBtnNew");
			selenium.jsClick("contactTypeBtnNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("select_firstcontact");
			selenium.jsClick("select_firstcontact");
			selenium.waitingTime(3000);
//			selenium.scrollToElement("Support_account");
//			selenium.scrolldown(-200);
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("Support_account");
//			selenium.jsClick("Support_account");
//			selenium.waitingTime(2000);
//			String UnivName = "account";
//			selenium.typeData("Support_account", UnivName);
//			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("select_accountfromdropdown1");
//			selenium.hoverAndClick("select_accountfromdropdown1");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("Subject_field");
			selenium.jsClick("Subject_field");
			String subject1 = "UATdemotest";
			selenium.typeData("Subject_field", subject1);
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Business_Hours_DropDown");
			selenium.typeData("Business_Hours_DropDown", "CSOM");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("ShowAllResults1");
			selenium.jsClick("ShowAllResults1");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("CSOMBusinessHrs");
			selenium.jsClick("CSOMBusinessHrs");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SaveRecordButton");
			selenium.jsClick("SaveRecordButton");
			selenium.captureScreenShot();
			selenium.waitingTime(7000);

			selenium.waitForElementToBeVisible("snagerror");
			String snagError=selenium.getText("snagerror").toString();
			if(snagError.equalsIgnoreCase("We hit a snag."))
			{
				System.out.println("Error Message Found");
				selenium.test.log(LogStatus.PASS,"Error Message Found");
			}
			else
			{
				System.out.println("Error Message Not Found");
				selenium.test.log(LogStatus.FAIL,"Error Message Not Found");
				selenium.reportFailure("Error Message Not Found");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}}

	@When("^I create a new opportunity Of SEG Record Type$")
	public void i_create_a_new_opportunity_Of_SEG_Record_Type() {
		try {
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			String AccountName="Lawton Public School";
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyPostponedStageInOpportunity"))
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName","Yukon Public Schools");
			}
			else
			{
				selenium.waitForElementToBeClickable("opp_accName");
				selenium.click("opp_accName");
				selenium.waitingTime(1000);
				selenium.typeData("opp_accName",AccountName);
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("OpptySaveBtn"))
			{
				selenium.jsClick("OpptySaveBtn");
				selenium.waitingTime(10000);
			}
			String OppOwner = selenium.getText("opp_owner1");
			System.out.println("Opp Owner is :" + OppOwner);
			selenium.waitingTime(2000);
			selenium.NewSEGOpp = selenium.getURL();
			System.out.println("The new NewSEGOpp URL is -->" + selenium.NewSEGOpp);
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());
		}
	}

	@When("^verify Opportunity owner is changed when product is modified$")
	public void verify_Opportunity_owner_is_changed_when_product_is_modified() {
		try {
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opp_ProductBtn");
			selenium.jsClick("opp_ProductBtn");
			selenium.waitingTime(7000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opp_modifiyProduct");
			selenium.jsClick("opp_modifiyProduct");
			selenium.waitingTime(8000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("add_ISBN");
			selenium.jsClick("add_ISBN");
			selenium.waitingTime(3000);
			String ISBNNumber="9780076760060";
			selenium.typeData("add_ISBN",ISBNNumber);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addButton");
			selenium.jsClick("addButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("save_ISBNProduct");
			selenium.jsClick("save_ISBNProduct");
			selenium.waitingTime(4000);
			String OppOwner1 = selenium.getText("opportunityOwnerGetText");
			System.out.println("Opp Owner is :" + OppOwner1);
			selenium.waitingTime(2000);
			if(!selenium.isElementPresentFast("opp_owner1"))
			{
				System.out.println("Opp Owner Name is updated when product is updated");
				selenium.test.log(LogStatus.PASS,"Opp Owner Name is updated when product is updated");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while creating a Case " + e.getMessage());

		}
	}
	@Then("open MHSE SO PIC list view")
	public void open_mhse_so_pic_list_view(){
		try{
			selenium.waitForElementToBeClickable("SelectListView");
			selenium.jsClick("SelectListView");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("SearchList");
			selenium.typeData("SearchList","MHSE SO PIC");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SelectListViewOption");
			selenium.jsClick("SelectListViewOption");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("FirstRecordCase");
			selenium.jsClick("FirstRecordCase");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("GetCaseNumber");
			String caseNumber=selenium.getText("GetCaseNumber").toString();
			System.out.println(caseNumber);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("globalSearch");
			selenium.click("globalSearch");
			selenium.waitingTime(2000);
			selenium.typeData("globalsearchadvance",caseNumber);
			selenium.waitingTime(6000);
//			selenium.pressEnter("GlobalSearchTextBox");
			selenium.waitForElementToBeVisible("GlobalSearchResult");
			String searchResult=selenium.getText("GlobalSearchResult").toString();
			System.out.println(searchResult);
			if(searchResult.equalsIgnoreCase(caseNumber))
			{
				System.out.println("Case number is found successfully");
				selenium.test.log(LogStatus.PASS,"Case number is found successfully");
			}
			else
			{
				System.out.println("Case number not found successfully");
				selenium.test.log(LogStatus.FAIL,"Case number not found successfully");
				selenium.reportFailure("Case number not found successfully");
			}
		}catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^navigate to already existing record$")
	public void navigate_to_already_existing_record(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.INFO, "Navigated to existed record");

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify discount wizard name field and name format$")
	public void verify_discount_wizard_name_field_and_name_format() {
		try {
//			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
//			selenium.jsClick("OppProductDiscountRelatedListLink");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("OppProductDiscountNameColumn");
			Assert.assertTrue(selenium.isElementPresentFast("OppProductDiscountNameColumn"));
			selenium.test.log(LogStatus.PASS,"Opportunity Product Discount Name field is present.");
			String OppDiscountName = selenium.getText("FirstOppDiscountName");
			System.out.println("OppDiscountName is --> " + OppDiscountName);
			
			String pattern = "^[A-Z]{3}-\\d{8}$";			//OPD-00000001
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(OppDiscountName);
			
			if (matcher.matches()) {
			    System.out.println("Opportunity Product Discount Name format is valid.");
				selenium.test.log(LogStatus.PASS,"Opportunity Product Discount Name format is valid.");
			} else {
			    System.out.println("Opportunity Product Discount Name format is invalid.");
				selenium.test.log(LogStatus.FAIL,"Opportunity Product Discount Name format is invalid.");
				selenium.reportFailure("Opportunity Product Discount Name format is invalid.");
			}

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^validate the Discount Wizard Screen non availability for the Opportunity Stage \"([^\"]*)\"$")
	public void validate_the_Discount_Wizard_Screen_non_availability_for_the_Opportunity_Stage_Qualified(String OppStageName) {
		try {
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			
			if(OppStageName.equals("Qualified"))
			{
				selenium.waitForElementToBeClickable("opportunityStage2");
				selenium.jsClick("opportunityStage2");
			}
			else if(OppStageName.equals("Prospect"))
			{
				selenium.waitForElementToBeClickable("OppStageProspect");
				selenium.jsClick("OppStageProspect");
			}

			selenium.waitingTime(1000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			Assert.assertTrue(selenium.isElementPresentFast("RequestNewISBNValidationMsg"));
			selenium.test.log(LogStatus.PASS, "Opportunity can be submitted for approval only if the Stage is set to At Risk, Adopted or Short Stack - Validation message appeared");
			System.out.println("PASS");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^validate the Discount Wizard Screen availability for the Opportunity Stage \"([^\"]*)\"$")
	public void validate_the_Discount_Wizard_Screen_availability_for_the_Opportunity_Stage_Qualified(String OppStageName) {
		try {
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			
			if(OppStageName.equals("Short_Stack"))
			{
				selenium.waitForElementToBeClickable("OppStageShortStack");
				selenium.jsClick("OppStageShortStack");
			}
			else if(OppStageName.equals("Adopted"))
			{
				selenium.waitForElementToBeClickable("OppStageAdopted");
				selenium.jsClick("OppStageAdopted");
			}
			else if(OppStageName.equals("At_Risk"))
			{
				//selenium.waitForElementToBeClickable("OppStageAtRisk");	//I am using hard-coded opp with status as At Risk. Because we cannot change existing opp status to At Risk.
				//selenium.jsClick("OppStageAtRisk");
			}

			selenium.waitingTime(1000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			Assert.assertTrue(selenium.isElementPresentFast("PriceDurationChangeOption"));
			Assert.assertTrue(selenium.isElementPresentFast("LearningSolutionsSetupOption"));
			selenium.test.log(LogStatus.PASS, "Discount wizard screen1 have both the following options - Price/Duration Change & Learning Solutions Setup");
			System.out.println("PASS");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify Request New ISBN button is not available$")
	public void verify_Request_New_ISBN_button_is_not_available() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			Assert.assertFalse(selenium.isElementPresentFast("RequestNewISBN"));
			selenium.test.log(LogStatus.PASS, "Successfully verified that Request New ISBN the button is not available for non-MHHE opportunities");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}	
	
	@And("^verify Learning Solutions Setup option navigates to LS Project creation page$")
	public void verify_Learning_Solutions_Setup_option_navigates_to_LS_Project_creation_page() {
		try {
			selenium.click("LearningSolutionsSetupCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("LSProjectPageTitle"));
			selenium.test.log(LogStatus.PASS, "LS Project creation page loaded");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify PriceDuration Change option navigates to PriceDuration Product page$")
	public void verify_PriceDuration_Change_option_navigates_to_PriceDuration_Product_page() {
		try {
			selenium.navigateBack();
			selenium.waitingTime(8000);
			selenium.navigateBack();
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("PriceDurationProductPageTitle"));
			selenium.test.log(LogStatus.PASS, "Price/Duration Product page loaded");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^add \"([^\"]*)\" product to opportunity$")
	public void add_diff_type_product_to_opportunity(String ProductType) {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpportunityFrameNew");
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
            selenium.waitForElementToBeVisible("isbnSearch1");					
			selenium.scrollToElement("isbnSearch1");

			selenium.typeData("isbnSearch1", ProductType);
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");					
			selenium.waitingTime(10000);				
			System.out.println(ProductType + " Product Added to Opportunity");
			selenium.test.log(LogStatus.INFO, ProductType + " type Product added to opportunity");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

	@And("^verify the newly added products are showing under correct section of PriceDuration Products page$")
	public void verify_the_newly_added_products_are_showing_under_correct_section_of_PriceDuration_Products_page(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			
			//Validate the fields in screen - GCRM-19738
			Assert.assertTrue(selenium.isElementPresentFast("OppHeadingInISBNReqPage"));
			Assert.assertTrue(selenium.isElementPresentFast("TransManagerHeadingInISBNReqPage"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceDurationChangeOption"));
			Assert.assertTrue(selenium.isElementPresentFast("LearningSolutionsSetupOption"));
			
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			
			String ISBNXpath = null;
			
			ISBNXpath = selenium.getDynamicXpath_data("ConnectProductSectionStart", data.get(0), "endContains");
			System.out.println("CONNECT ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("MHGOProductSectionStart", data.get(1), "endContains");				//No ISBN found in UAT for this product type
			System.out.println("MHGO ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("AleksProductSectionStart", data.get(2), "endContains");
			System.out.println("ALEKS ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("SimnetProductSectionStart", data.get(3), "endContains");
			System.out.println("SIMNET ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("EBookProductSectionStart", data.get(4), "endContains");
			System.out.println("EBOOK ISBNXpath is -->" + ISBNXpath);
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("LooseLeafProductSectionStart", data.get(5), "endContains");
			System.out.println("LOOSELEAF ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			
			ISBNXpath = selenium.getDynamicXpath_data("HardboundProductSectionStart", data.get(6), "endContains");		////No ISBN found in UAT for this product type
			System.out.println("HARDBOUND ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
		
			ISBNXpath = selenium.getDynamicXpath_data("BundleProductSectionStart", data.get(7), "endContains");			////No ISBN found in UAT for this product type
			System.out.println("BUNDLE ISBNXpath is -->" + ISBNXpath);		
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));

			selenium.test.log(LogStatus.PASS, "The newly added products are showing under correct section of PriceDuration Products page");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^delete all the opportunity products$")
	public void delete_all_the_opportunity_products() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpportunityFrameNew");
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(4000);
			selenium.click("RemoveProductSelectAllCkhBx");
			selenium.waitingTime(2000);
			selenium.click("removeBtn");
			selenium.waitingTime(2000);
			selenium.click("Button_Save");
			selenium.waitingTime(20000);
			selenium.refresh();
			selenium.waitingTime(10000);
			System.out.println("Deleted all ISBNs which are under test");
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}

	@Then("^create new opportunity of MHHE record type$")
	public void create_new_opportunity_of_MHHE_record_type() {
		try {
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.click("newOpportunityBtn");
			selenium.waitingTime(2000);
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldAfterClone")||
				selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldPicklistValue")||
				selenium.getTestCaseName().equalsIgnoreCase("VerifyNeedByDateFieldToCourseRebuild")||
				selenium.getTestCaseName().equalsIgnoreCase("VerifyCopyRightYear")||selenium.getTestCaseName().equalsIgnoreCase("VerifyLabelChanges"))
			{
				System.out.println(selenium.getTestCaseName());
			}
			else
			{
				selenium.waitForElementToBeClickable("clicknext");
				selenium.click("clicknext");
			}
			selenium.waitingTime(20000);
			selenium.refresh();
			selenium.waitingTime(20000);
			selenium.waitForElementToBeVisible("switch_iFrame");
			selenium.switchToFrame("switch_iFrame");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("Serach_OppName");
			selenium.hoverAndClick("Serach_OppName");
			String Account = "UNIV OF WISC WHITEWATER";
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldAfterClone"))
			{
				selenium.typeData("Serach_OppName","SAN ANTONIO COLLEGE");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OpptyAccountName");
				selenium.jsClick("OpptyAccountName");
			} else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyNeedByDateFieldToCourseRebuild"))
			{
				selenium.typeData("Serach_OppName","AMERICAN PUBLIC UNIVERSITY");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("MHHEselectAccountName");
				selenium.jsClick("MHHEselectAccountName");
			}
			else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyCopyRightYear"))
			{
				selenium.typeData("Serach_OppName","KANSAS STATE UNIVERSITY");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("MHHEselectAccountNameNew");
				selenium.jsClick("MHHEselectAccountNameNew");
			}
			else if (selenium.getTestCaseName().equalsIgnoreCase("VerifyTeachingFieldPicklistValue"))
			{
				selenium.typeData("Serach_OppName","BUTLER COUNTY COMM COLLEGE");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("OppSelectAccName");
				selenium.jsClick("OppSelectAccName");
			}
			else
			{
				selenium.typeData("Serach_OppName", Account);
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("searchOpp");
				selenium.click("searchOpp");
			}
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OpportunityMHECourse2");
			selenium.hoverAndClick("OpportunityMHECourse2");
			String Course = "Advanced Engineering Mathematics";
			selenium.typeData("OpportunityMHECourse2", Course);
			selenium.pressEnter("OpportunityMHECourse2");
			selenium.waitForElementToBeClickable("select_course");
			selenium.hoverAndClick("select_course");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment","123");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("enrollment_spring");
			selenium.jsClick("enrollment_spring");
			selenium.waitingTime(3000);
			String Value = "20";
			selenium.typeData("enrollment_spring", Value);
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.click("ButtonSave");
			selenium.waitingTime(15000);
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@Then("^create new MHHE opportunity$")
	public void create_new_MHHE_opportunity(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("newOpportunityBtn");
			selenium.jsClick("newOpportunityBtn");
			selenium.waitingTime(5000);
			if (!(selenium.getTestCaseName().equalsIgnoreCase("VerifyProductsAreDisplayedUnderRespectiveSection") || selenium.getTestCaseName().equalsIgnoreCase("VerifyAddingofMultipleProductsOfSameType"))) {
				selenium.waitForElementToBeClickable("NextButton");
				selenium.click("NextButton");
				selenium.waitingTime(5000);
			}
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("opportunityAccount");
			selenium.typeData("opportunityAccount", data.get(0));
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_data("spanTitle", data.get(0), "end");
			selenium.waitingTime(2000);
//			selenium.clickLoop("");
			selenium.typeData("OpportunityMHECourse2", data.get(1));
			selenium.waitingTime(4000);
			selenium.clickDynamicXpath_data("spanTitle", data.get(1), "end");
			selenium.waitingTime(2000);
			selenium.selectDropdownText_Data("oppurtunityType", data.get(4));
			selenium.waitingTime(4000);
//			selenium.selectDropdownText_Data("salesStageDropdown", data.get(5));
			selenium.waitForElementToBeVisible("oppurtunitySpringEnrollment");
			selenium.typeData("oppurtunitySpringEnrollment", data.get(2));
			selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
			selenium.typeData("oppurtunityFallEnrollment", data.get(3));
			selenium.waitingTime(2000);
			selenium.moveTab("oppurtunitySummerEnrollment");
			selenium.waitForElementToBeClickable("ButtonSave");
			selenium.jsClick("ButtonSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(25000);

			if (selenium.getTestCaseName().equalsIgnoreCase("VerifyAddingofMultipleProductsOfSameType") || selenium.getTestCaseName().equalsIgnoreCase("VerifyProductsAreDisplayedUnderRespectiveSection") || selenium.getTestCaseName().equalsIgnoreCase("VerifyDuplicateISBNRequest") || selenium.getTestCaseName().equalsIgnoreCase("VerifyISBNRequestAutoApproval") || selenium.getTestCaseName().equalsIgnoreCase("VerifyCodeTypeFieldBehaviourForDiffProductTypes")) {
				selenium.NewMHHETypeOppURL = selenium.getURL();
				System.out.println("The MHHE Admin created opp url is :" + selenium.NewMHHETypeOppURL);
			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("^create an ISBN request$")
	public void create_an_ISBN_request() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("PriceDurationProductPageTitle"));
			selenium.click("ProductChkBxInPriceDurationProductsList");
			selenium.waitForElementToBeVisible("OfferLevelSetupSelectList");
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("NationDiscountOption");
			selenium.click("NationDiscountOption");
			selenium.waitingTime(1000);
			selenium.typeData("RequestedPriceField", "5");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwn");
			selenium.click("CodeTypeDropDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwnValue");
			selenium.click("CodeTypeDropDwnValue");
			selenium.waitingTime(1000);
			selenium.click("ISNReqSubmitForApprovalBtn");
			selenium.waitingTime(30000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify the new ISBN request details in Opp Product Discount related list$")
	public void verify_the_new_ISBN_request_details_in_Opp_Product_Discount_related_list() {
		try {
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
			selenium.jsClick("OppProductDiscountRelatedListLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("FirstOppDiscountName");
			Assert.assertTrue(selenium.isElementPresentFast("FirstOppDiscountName"));
			selenium.test.log(LogStatus.PASS, "Newly created ISBN request details are present");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify the duplicate ISBN request details in Opp Product Discount related list$")
	public void verify_the_duplicate_ISBN_request_details_in_Opp_Product_Discount_related_list() {
		try {
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
			selenium.jsClick("OppProductDiscountRelatedListLink");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("SecondOppDiscountName");
			Assert.assertTrue(selenium.isElementPresentFast("SecondOppDiscountName"));
			selenium.test.log(LogStatus.PASS, "Duplicate ISBN request details are present");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^update the opportunity stage to \"([^\"]*)\"$")
	public void update_the_opportunity_stage_to_shortstack(String OppStageName) {
		try {
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppStageField");
			selenium.jsClick("OppStageField");
			
			if(OppStageName.equals("Short_Stack"))
			{
				selenium.waitForElementToBeClickable("OppStageShortStack");
				selenium.jsClick("OppStageShortStack");
			}

			selenium.waitingTime(1000);
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^approver approves the ISBN Request$")
	public void approver_approves_the_ISBN_Request() {
		try {
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("ApprovalHistoryRelatedList");
			selenium.click("ApprovalHistoryRelatedList");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("ApproveBtnForISBNRequest");
			selenium.click("ApproveBtnForISBNRequest");
			selenium.waitForElementToBeVisible("ApproveComments");
			selenium.typeData("ApproveComments", "Approving");
			selenium.waitForElementToBeClickable("ApproveBtn");
			selenium.click("ApproveBtn");
			selenium.waitingTime(15000);
			selenium.test.log(LogStatus.INFO, "ISBN Request Approved");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("^create duplicate ISBN request and validate the warning message$")
	public void create_duplicate_ISBN_request_and_validate_the_warning_message() {
		try {
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			String ISBNXpath = selenium.getDynamicXpath_propertiesFile("AllTagContainsText", "DuplicateISBNReqMessage", "endContains");
			System.out.println("ISBNXpath is -->" + ISBNXpath);				
			Assert.assertTrue(selenium.isElementPresentXpathFast(ISBNXpath));
			selenium.test.log(LogStatus.PASS, "The duplicate ISBN Request Warning Message Appeared");
			selenium.click("OKButtonInMsgPopup");
			Assert.assertTrue(selenium.isElementPresentFast("RedcolorText"));
			selenium.test.log(LogStatus.PASS, "The duplicate ISBN details has been highlighted in RED color");			
			
			selenium.click("ProductChkBxInPriceDurationProductsList");
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
//			dropdown.selectByVisibleText("Unknown");
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
//			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeVisible("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
//			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("NationDiscountOption");
			selenium.click("NationDiscountOption");
			selenium.waitingTime(1000);
			selenium.typeData("RequestedPriceField", "5");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwn");
			selenium.click("CodeTypeDropDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwnValue");
			selenium.click("CodeTypeDropDwnValue");
			selenium.waitingTime(1000);
			selenium.click("ISNReqSubmitForApprovalBtn");
			selenium.waitingTime(30000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@Then("^create ISBN request and verify code type field behaviour$")
	public void create_ISBN_request_and_verify_code_type_field_behaviour(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("PriceDurationProductPageTitle"));

			//Validating all product type heading under Price/Duration Products section - GCRM-19737
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_Connect"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_MHGO"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_ALEKS"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_SIMNET"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_EBOOK"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_LOOSELEAF"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_HARDBOUND"));
			Assert.assertTrue(selenium.isElementPresentFast("ProductType_BUNDLE"));

			selenium.click("ProductChkBxInPriceDurationProductsList");
			selenium.click("ProductChkBxInPriceDurationProductsList1");
			selenium.click("ProductChkBxInPriceDurationProductsList2");
			selenium.click("ProductChkBxInPriceDurationProductsList3");
			selenium.click("ProductChkBxInPriceDurationProductsList4");
			selenium.click("ProductChkBxInPriceDurationProductsList5");
			selenium.click("ProductChkBxInPriceDurationProductsList6");
			selenium.click("ProductChkBxInPriceDurationProductsList7");

			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("OfferLevelSetupSelectList");
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
			dropdown.selectByIndex(1);
			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList1"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
//			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList2"));
//			dropdown.selectByIndex(1);
//			selenium.waitingTime(1000);
			
			//VALIDATE OFFER LEVEL SETUP PICKLIST VALUES FOR DIGITAL PRODUCT (CHOOSE ALEKS PRODUCT TYPE FOR THIS)
			dropdown = new Select(selenium.getElement("OfferLevelSetupALEKSDigitalProductList"));
			dropdown.selectByVisibleText("Master Template Code");
			dropdown.selectByVisibleText("Course Code");
			dropdown.selectByVisibleText("Unknown");
			dropdown.selectByVisibleText("Schoolwide (Non-IA Only)");
			dropdown.selectByVisibleText("Not Applicable");
			selenium.waitingTime(1000);
			
			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList3"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
			
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitingTime(1000);
			
			//VERIFYING PRICE HOLD UNTIL FIELD IN SCREEN 3
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilSection"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilSectionDefaultDate"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilSection1YrDate"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilSection2YrDate"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilSection3YrDate"));
			Assert.assertTrue(selenium.isElementPresentFast("HoldPriceCommentsField"));
			selenium.test.log(LogStatus.PASS, "ALL THE PRICE HOLD UNTIL RELATED FIELDS ARE EXIST");
			
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
			
			selenium.waitForElementToBeVisible("NationalDiscountField");
			Assert.assertTrue(selenium.isElementPresentFast("CodeTypeDropDwn"));	//Code Type name has been updated to Delivery Mode.
			selenium.test.log(LogStatus.PASS, "Code Type aka Delivery Mode field is present");
			int NumberOfEditableCodeTypeFields = selenium.getElementCount("CodeType_NonEditable");	//As per requirement, out of 3 product types, only for 2 this code type field should be editable and for one it is should be non-editable.
			Assert.assertEquals(NumberOfEditableCodeTypeFields, 4);	//This field is only editable to Aleks, Simnet, Connect, and MH GO product types.
			selenium.test.log(LogStatus.PASS, "The Code Type aka Delivery Mode field  is only editable for the product of product type ALEKS, CONNECT, MH GO and SIMNET");
			selenium.waitingTime(1000);
			
			int NumberOfNonEditableDurationDaysFields = selenium.getElementCount("DurationDays_NonEditable");	//GCRM-18296 - On the screen 4 verify duration Days Field is not editable to Hardbound and Loose-leaf product type as Source product have no duration.
			Assert.assertEquals(NumberOfNonEditableDurationDaysFields, 3);
			selenium.test.log(LogStatus.PASS, "The Duration Days field  is not editable for the product of product type LOOSELEAF, HARDBOUND, BUNDLE");
			selenium.waitingTime(1000);
			
			//Verify all the same products are in screen4 which were selected on Screen2 - GCRM-19748
			int ProductRequestedForDiscount_TableRowCount = selenium.getElementCount("ProductRequestedForDiscount");
			Assert.assertEquals(ProductRequestedForDiscount_TableRowCount, 8);	//8 products = 8 rows in table
			selenium.test.log(LogStatus.PASS, "The Product Request Discount table in Screen4 is showing 3 products");
			String product1 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(0), "endContains");
			String product2 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(1), "endContains");
			String product3 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(2), "endContains");
			String product4 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(3), "endContains");
			String product5 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(4), "endContains");
			String product6 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(5), "endContains");
			String product7 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(6), "endContains");
			String product8 = selenium.getDynamicXpath_data("anchorTitlecontains", data.get(7), "endContains");
			Assert.assertTrue(selenium.isElementPresentXpathFast(product1));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product2));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product3));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product4));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product5));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product6));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product7));
			Assert.assertTrue(selenium.isElementPresentXpathFast(product8));
			selenium.test.log(LogStatus.PASS, "The Product Request Discount table in Screen4 is showing the same 8 products whcih are added on Screen2");
			selenium.waitingTime(1000);
			
			//VERIFYING DISCOUNT TYPE AKA NATIONAL DISCOUNT PICKLIST VALUES
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			Assert.assertTrue(selenium.isElementPresentFast("NationDiscountOption"));
			Assert.assertTrue(selenium.isElementPresentFast("NationDiscountOption1"));
			Assert.assertTrue(selenium.isElementPresentFast("NationDiscountOption2"));
			Assert.assertTrue(selenium.isElementPresentFast("NationDiscountOption4"));
			selenium.test.log(LogStatus.PASS, "VERIFIED DISCOUNT TYPE AKA NATIONAL DISCOUNT PICKLIST VALUES");
			selenium.pressEscapeKey();
			selenium.waitingTime(5000);
			
			//VERIFY BILLING ISBN ONLY CHECKBOX IS SELECTABLE AND UNSELECTABLE
			Assert.assertTrue(selenium.checkElementIsEnabled("BillingISBNOnlyCheckBox"));
			selenium.jsClick("BillingISBNOnlyCheckBox");	//ToSelect BILLING ISBN ONLY Check-box
			selenium.waitingTime(1000);
			selenium.jsClick("BillingISBNOnlyCheckBox");	//ToUnSelect BILLING ISBN ONLY Check-box
			selenium.test.log(LogStatus.PASS, "VERIFIED BILLING ISBN ONLY CHECKBOX IS SELECTABLE AND UNSELECTABLE");
			selenium.waitingTime(4000);
			
			selenium.click("CancelEdit"); //Cancel will redirect to opportunity record - GCRM-19738
			selenium.waitingTime(15000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^add all type products to opportunity$")
	public void add_all_type_products_to_opportunity(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpportunityFrameNew");
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
            selenium.waitForElementToBeVisible("isbnSearch1");					
			selenium.scrollToElement("isbnSearch1");

			selenium.typeData("isbnSearch1", data.get(0));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);

			selenium.typeData("isbnSearch1", data.get(1));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(2));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(3));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(4));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(5));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(6));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(7));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
            selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");					
			selenium.waitingTime(25000);				
			System.out.println("Products Added to Opportunity");
			selenium.test.log(LogStatus.INFO, "Products added to opportunity");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify error message when user selects products from both grids$")
	public void verify_error_message_when_user_selects_products_from_both_grids() {
		try {
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			
			//Moving from Screen1 to Screen2
			selenium.switchToMultipleFrame("newAccountFrame");			
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);			
			
			//Moving from Screen2 to Screen3
			selenium.click("ProductChkBxInPriceDurationProductsList");	//First product check box
			selenium.waitForElementToBeVisible("OfferLevelSetupSelectList");
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
			
			selenium.click("CustomSetupProductChkBx");	//Selecting custom setup product check box
			selenium.waitingTime(3000);
			
			selenium.click("NxtButton");
			selenium.waitingTime(3000);
			
			//Verifying the expected error message
			String expected = selenium.getTestDataFromPropertiesFile("ISBNReqValidationForDiffGridProducts");
			String actual = selenium.getElement("ISBNReqCustomSetupProdValidationMsg").getText();
			assertTrue(actual.contains(expected));
			selenium.test.log(LogStatus.PASS, "The expected validation message triggered");
			selenium.click("OKButtonInMsgPopup");
			selenium.waitingTime(2000);
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^add same type products to opportunity$")
	public void add_same_type_products_to_opportunity(DataTable table) {
		try {
			List<String> data = table.transpose().asList(String.class);

			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.click("OppProduct");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			selenium.jsClick("taggedProductAddorEdit");
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("OpportunityFrameNew");
			selenium.switchToFrame("OpportunityFrameNew");
			selenium.waitingTime(8000);
            selenium.waitForElementToBeVisible("isbnSearch1");					
			selenium.scrollToElement("isbnSearch1");

			selenium.typeData("isbnSearch1", data.get(0));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(1));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(2));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(3));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(4));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(5));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(6));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(7));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(8));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(9));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(10));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(11));
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
			selenium.typeData("isbnSearch1", data.get(12));		//Custom Setup Product
			selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("searchBtn");
			selenium.click("searchBtn");
			selenium.waitingTime(12000);
			selenium.waitForElementToBeClickable("addProductCB");
			selenium.click("addProductCB");
			selenium.waitForElementToBeClickable("opportunitiesAddToOpportunity");
			selenium.click("opportunitiesAddToOpportunity");							
			selenium.waitingTime(4000);
			
            selenium.waitForElementToBeClickable("Button_Save");
			selenium.click("Button_Save");					
			selenium.waitingTime(25000);				
			Assert.assertFalse(selenium.isElementPresentsuperFast("Button_Save"));
			System.out.println("Multiple Products of same type added to Opportunity");
			selenium.test.log(LogStatus.INFO, "Multiple Products of same type added to Opportunity");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^Verify no new ISBN request can be raised when a OPD is in process of approval$")
	public void Verify_no_new_ISBN_request_can_be_raised_when_a_OPD_is_in_process_of_approval() {
		try {
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			selenium.switchToMultipleFrame("newAccountFrame");
			Assert.assertTrue(selenium.isElementPresentFast("ISBNReqPendingValidationMsg"));
			selenium.test.log(LogStatus.PASS, "ISBN Request cannot be started as there is a pending Approval in process - Validation message appeared");
			System.out.println("PASS");
			selenium.switchOutOfFrame();;
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify Offer Level Setup field against all product types in Screen2$")
	public void verify_Offer_Level_Setup_field_against_all_product_types_in_Screen2() {
		try {
			//Only for the CONNECT, MH GO, ALEKS, SIMNET product types the offer level field should be visible
			Assert.assertTrue(selenium.isElementPresentFast("OfferLevelSetupSelectList"));
			Assert.assertTrue(selenium.isElementPresentFast("OfferLevelSetupSelectList1"));
			Assert.assertTrue(selenium.isElementPresentFast("OfferLevelSetupSelectList2"));
			Assert.assertTrue(selenium.isElementPresentFast("OfferLevelSetupSelectList3"));
			
			//For EBOOK, LOOSELEAF, HARDBOUNT, BUNDE product types the offer level field should not be visible
			Assert.assertFalse(selenium.isElementPresentFast("OfferLevelSetupSelectList4"));
			Assert.assertFalse(selenium.isElementPresentFast("OfferLevelSetupSelectList5"));
			Assert.assertFalse(selenium.isElementPresentFast("OfferLevelSetupSelectList6"));
			Assert.assertFalse(selenium.isElementPresentFast("OfferLevelSetupSelectList7"));
			
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
			dropdown.selectByVisibleText("Schoolwide");
			dropdown.selectByVisibleText("Not Applicable");
			dropdown.selectByVisibleText("Instructor");
			dropdown.selectByVisibleText("Unknown");
			selenium.waitingTime(1000);
			
			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList1"));
			dropdown.selectByVisibleText("Schoolwide");
			dropdown.selectByVisibleText("Not Applicable");
			dropdown.selectByVisibleText("Instructor");
			dropdown.selectByVisibleText("Unknown");
			selenium.waitingTime(1000);
			
			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList2"));
			dropdown.selectByVisibleText("Schoolwide (Non-IA Only)");
			dropdown.selectByVisibleText("Not Applicable");
			dropdown.selectByVisibleText("Master Template Code");
			dropdown.selectByVisibleText("Course Code");
			dropdown.selectByVisibleText("Unknown");
			selenium.waitingTime(1000);
			
			dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList3"));
			dropdown.selectByVisibleText("Schoolwide");
			dropdown.selectByVisibleText("Course Name");
			dropdown.selectByVisibleText("Not Applicable");
			selenium.waitingTime(1000);			
			
			selenium.test.log(LogStatus.PASS, "Offer Level Setup field values has been verified against all product types");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify Details in Screen3 of Discount Wizard$")
	public void verify_Details_in_Screen3_of_Discount_Wizard() {
		try {
			//Moving from Screen2 to Screen3
			selenium.click("ProductChkBxInPriceDurationProductsList");	//First product check box
			selenium.waitForElementToBeVisible("OfferLevelSetupSelectList");
			Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
			dropdown.selectByIndex(1);
			selenium.waitingTime(1000);
			
			selenium.click("ProductChkBxInPriceDurationProductsList3");	//EBOOK type product check box
			selenium.waitingTime(1000);
			
			selenium.click("NxtButton");
			selenium.waitingTime(8000);
			
			//Moved to Screen3 and validating all the fields
			Assert.assertTrue(selenium.isElementPresentFast("PIUCurrentPriceField"));
			Assert.assertTrue(selenium.isElementPresentFast("CompetitiveOfferOrPriceField"));
			Assert.assertTrue(selenium.isElementPresentFast("DiscountSubmissionCommentsField"));
			Assert.assertTrue(selenium.isElementPresentFast("CourseStartDateField"));
			Assert.assertTrue(selenium.isElementPresentFast("NeedbyDateField"));
			Assert.assertTrue(selenium.isElementPresentFast("DigitalEndDateField"));
			Assert.assertTrue(selenium.isElementPresentFast("CampusesNeedingOfferField"));
			Assert.assertTrue(selenium.isElementPresentFast("HoldPriceCommentsField"));
			Assert.assertTrue(selenium.isElementPresentFast("PriceHoldUntilField"));

			//Validating the mandatory field validations in Screen3
			selenium.click("NxtButton");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("ISBNReqMandatoryFieldValidationMsg1"));
			selenium.test.log(LogStatus.PASS, "Course Start Date, Need by Date, Discount Submission are mandatory - Validation message triggered");
			System.out.println("Filling all mandatory field details except Competitive Offer/Price field and clicking on Next button..");	//make sure opp stage is at risk or  opp type is Takeaway. 
			
			selenium.click("OKButtonInMsgPopup");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("ISBNReqMandatoryFieldValidationMsg2"));
			selenium.test.log(LogStatus.PASS, "Competitive Offers/Price is required, if Opportunity Stage is At Risk or Opportunity Type is Takeaway - Validation message triggered");
			
			selenium.click("OKButtonInMsgPopup");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("CompetitiveOfferTextField");
			selenium.typeData("CompetitiveOfferTextField", "CompetitiveOffer Text");
			selenium.click("NxtButton");
			selenium.waitingTime(8000);
			
			Assert.assertTrue(selenium.isElementPresentFast("NationalDiscountField"));
			selenium.test.log(LogStatus.PASS, "After filling all mandatory fields in Screen3 user is able to move to Screen4");			
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify ISBN doesnt get auto approved even if the requested price is greater than suggested price but there is a duration change$")
	public void verify_ISBN_doesnt_get_auto_approved_even_if_the_requested_price_is_greater_than_suggested_price_but_there_is_a_duration_change() {
		try {
			//Moved to Screen4 - indirectly we are verifiying all the screen4 fields
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("NationDiscountOption2");	//Discount should not be deal desk 
			selenium.click("NationDiscountOption2");
			selenium.waitingTime(1000);
			selenium.typeData("RequestedPriceField", "99");	//The requested price of the products should be greater than suggested price, so I am using 99 here
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwn");
			selenium.click("CodeTypeDropDwn");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("CodeTypeDropDwnValue");
			selenium.click("CodeTypeDropDwnValue");
			selenium.waitingTime(1000);
			
			String Initial_NetPrice = selenium.getText("ISBNReqGetNetPrice");
			String Initial_SuggestedPriceA = selenium.getText("SuggestedPriceA");
			String Initial_SuggestedPriceB = selenium.getText("SuggestedPriceB");
			String Initial_SuggestedPriceC = selenium.getText("SuggestedPriceC");
			System.out.println("Initial_NetPrice " + Initial_NetPrice + "Initial_SuggestedPriceA " + Initial_SuggestedPriceA + "Initial_SuggestedPriceB " + Initial_SuggestedPriceB + "Initial_SuggestedPriceC " + Initial_SuggestedPriceC);

			//Now update Duration Days and then again check the Price values. There should not be any change in that.
			selenium.click("ISBNReqDurationDaysDrpDwn");
			selenium.waitingTime(1000);
			selenium.click("ISBNReqDurationDaysValue");
			selenium.waitingTime(2000);
			
			String Current_NetPrice = selenium.getText("ISBNReqGetNetPrice");
			String Current_SuggestedPriceA = selenium.getText("SuggestedPriceA");
			String Current_SuggestedPriceB = selenium.getText("SuggestedPriceB");
			String Current_SuggestedPriceC = selenium.getText("SuggestedPriceC");
			System.out.println("Current_NetPrice " + Current_NetPrice + "Current_SuggestedPriceA " + Current_SuggestedPriceA + "Current_SuggestedPriceB " + Current_SuggestedPriceB + "Current_SuggestedPriceC " + Current_SuggestedPriceC);
			
			Assert.assertEquals(Initial_NetPrice, Current_NetPrice);
			Assert.assertEquals(Initial_SuggestedPriceA, Current_SuggestedPriceA);
			Assert.assertEquals(Initial_SuggestedPriceB, Current_SuggestedPriceB);
			Assert.assertEquals(Initial_SuggestedPriceC, Current_SuggestedPriceC);
			selenium.test.log(LogStatus.PASS, "User is able to change the duration on screen4 and it doesnt impact any pricing");	//GCRM-19752
			
			selenium.click("NationalDiscountField2");
			selenium.waitingTime(1000);
			selenium.click("NationDiscountOption3");
			selenium.waitingTime(1000);
			selenium.typeData("RequestedPriceField2", "5");
			selenium.waitingTime(1000);
			
			selenium.click("ISNReqSubmitForApprovalBtn");	//Submitting ISBN Request
			selenium.waitingTime(30000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
			selenium.jsClick("OppProductDiscountRelatedListLink");
			selenium.waitingTime(6000);
			Assert.assertTrue(selenium.isElementPresentFast("ISBNReqStatusInApproval"));
			selenium.test.log(LogStatus.PASS, "ISBN did not get auto approved");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify ISBN get auto approved if the requested price is greater than suggested price and opty type is NULL and discount type is not Deal desk$")
	public void verify_ISBN_get_auto_approved_if_the_requested_price_is_greater_than_suggested_price_and_opty_type_is_NULL_and_discount_type_is_not_Deal_desk() {
		try {
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			
			//Moving from Screen1 to Screen2
			selenium.switchToMultipleFrame("newAccountFrame");			
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);		
			
			//Moving from Screen2 to Screen3
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);	
			selenium.click("ProductChkBxInPriceDurationProductsList");	//First product check box
			
			if(selenium.isElementPresentFast("OfferLevelSetupSelectList"))
			{
				Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
				dropdown.selectByIndex(1);
			}

			selenium.waitingTime(1000);			
			selenium.click("NxtButton");
			selenium.waitingTime(3000);
			
			//Moving from Screen3 to Screen4
			selenium.waitForElementToBeClickable("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("CompetitiveOfferTextField");
			selenium.typeData("CompetitiveOfferTextField", "CompetitiveOffer Text");
			selenium.click("NxtButton");
			selenium.waitingTime(8000);			
			
			//Moved to Screen4
			
			//Verify Suggested price A,B and C changes as per discount type entered by user on Screen4
			
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("NationDiscountOption1");	//IA
			selenium.click("NationDiscountOption1");
			selenium.waitingTime(1000);
			
			String SuggestedPriceA = selenium.getText("SuggestedPriceA");
			String SuggestedPriceB = selenium.getText("SuggestedPriceB");
			String SuggestedPriceC = selenium.getText("SuggestedPriceC");
			System.out.println("Wehn discount type is IA the Suggested Price A is --> " + SuggestedPriceA + "Suggested Price B is" + SuggestedPriceB + "Suggested Price C is" + SuggestedPriceC);
			
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeVisible("NationDiscountOption2");	//Discount should not be deal desk (National Discount)
			selenium.click("NationDiscountOption2");
			selenium.waitingTime(1000);
			
			String SuggestedPrice_A = selenium.getText("SuggestedPriceA");
			String SuggestedPrice_B = selenium.getText("SuggestedPriceB");
			String SuggestedPrice_C = selenium.getText("SuggestedPriceC");
			System.out.println("Wehn discount type is National discount the Suggested Price A is --> " + SuggestedPrice_A + "Suggested Price B is" + SuggestedPrice_B + "Suggested Price C is" + SuggestedPrice_C);
			
			Assert.assertNotEquals(SuggestedPriceA, SuggestedPrice_A);
			Assert.assertNotEquals(SuggestedPriceB, SuggestedPrice_B);
			Assert.assertNotEquals(SuggestedPriceC, SuggestedPrice_C);
			selenium.test.log(LogStatus.PASS, "Suggested price A,B and C changes as per discount type entered by user on Screen4");
						
			selenium.typeData("RequestedPriceField", "99");	//The requested price of the products should be greater than suggested price, so I am using 99 here
			selenium.waitingTime(1000);	
			selenium.click("ISNReqSubmitForApprovalBtn");	//Submitting ISBN Request
			selenium.waitingTime(30000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
			selenium.jsClick("OppProductDiscountRelatedListLink");
			selenium.waitingTime(6000);
			Assert.assertTrue(selenium.isElementPresentFast("ISBNReqStatusApproved"));
			selenium.test.log(LogStatus.PASS, "ISBN Request status is Aproved");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify for EBOOK product OPD there will be no record on the staging object$")
	public void verify_for_EBOOK_product_OPD_there_will_be_no_record_on_the_staging_object() {
		try {
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("PriceDiscountStagingRelatedList");
			selenium.jsClick("PriceDiscountStagingRelatedList");
			selenium.waitingTime(5000);
			Assert.assertFalse(selenium.isElementPresentFast("firstTableRecord"));
			selenium.test.log(LogStatus.PASS, "For EBOOK type product (under OPD related list) there is no record found in the Price Discount Staging related list");
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
	
	@And("^verify ISBN request creation with single EBOOK with \"([^\"]*)\" discount type$")
	public void verify_ISBN_request_creation_with_single_EBOOK_with_Different_discount_type(String ProductType) {
		try {		
			selenium.navigateToURL(selenium.NewMHHETypeOppURL);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RequestNewISBN");
			selenium.jsClick("RequestNewISBN");
			selenium.waitingTime(8000);
			
			//Moving from Screen1 to Screen2
			selenium.switchToMultipleFrame("newAccountFrame");			
			selenium.waitForElementToBeClickable("PriceDurationCheckBox");
			selenium.click("PriceDurationCheckBox");
			selenium.waitingTime(1000);
			selenium.click("NxtButton");
			selenium.waitingTime(5000);		
			
			//Moving from Screen2 to Screen3
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(2000);	
			
			if(selenium.isElementPresentFast("OKButtonInMsgPopup"))
			{
				selenium.click("OKButtonInMsgPopup");	//Duplicate ISBN Request popup
				selenium.waitingTime(2000);	
			}
			
			selenium.waitForElementToBeClickable("ProductChkBxInPriceDurationProductsList");
			selenium.click("ProductChkBxInPriceDurationProductsList");	//First product check box

			if(selenium.isElementPresentFast("OfferLevelSetupSelectList"))
			{
				Select dropdown = new Select(selenium.getElement("OfferLevelSetupSelectList"));
				dropdown.selectByIndex(1);
			}

			selenium.waitingTime(1000);			
			selenium.click("NxtButton");
			selenium.waitingTime(3000);
			
			//Moving from Screen3 to Screen4
			selenium.waitForElementToBeClickable("DiscountSubmissionCountsTextArea");
			selenium.typeData("DiscountSubmissionCountsTextArea", "Automation Test");
			selenium.waitForElementToBeClickable("CourseStartDatefield");
			selenium.getElement("CourseStartDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("NeedByDatefield");
			selenium.getElement("NeedByDatefield").sendKeys(selenium.getFutureDate(0));
			selenium.waitForElementToBeClickable("CompetitiveOfferTextField");
			selenium.typeData("CompetitiveOfferTextField", "CompetitiveOffer Text");
			selenium.click("NxtButton");
			selenium.waitingTime(8000);
			
			//Moved to Screen4
			selenium.waitForElementToBeVisible("NationalDiscountField");
			selenium.click("NationalDiscountField");
			selenium.waitingTime(1000);
			if (ProductType.equalsIgnoreCase("Deal_Desk"))
			{
				selenium.waitForElementToBeVisible("NationDiscountOption");	//Discount Type should be Deal Desk 
				selenium.click("NationDiscountOption");
				//Delivery Mode will be auto set as 'Private Offer', so we don't need to select it.
			}
			else if (ProductType.equalsIgnoreCase("Deal_Desk-IA"))
			{
				selenium.waitForElementToBeVisible("NationDiscountOption4");	//Discount Type should be  Deal Desk-IA
				selenium.click("NationDiscountOption4");
//				selenium.waitForElementToBeVisible("CodeTypeDropDwn");
//				selenium.click("CodeTypeDropDwn");
//				selenium.waitingTime(1000);
//				selenium.waitForElementToBeVisible("CodeTypeDropDwnValue2");
//				selenium.click("CodeTypeDropDwnValue2");
//				selenium.waitingTime(1000);
			}
			else if (ProductType.equalsIgnoreCase("IA"))
			{
				selenium.waitForElementToBeVisible("NationDiscountOption1");	//Discount Type should be IA
				selenium.click("NationDiscountOption1");
//				selenium.waitForElementToBeVisible("CodeTypeDropDwn");
//				selenium.click("CodeTypeDropDwn");
//				selenium.waitingTime(1000);
//				selenium.waitForElementToBeVisible("CodeTypeDropDwnValue3");
//				selenium.click("CodeTypeDropDwnValue3");
//				selenium.waitingTime(1000);
			}
			else if (ProductType.equalsIgnoreCase("National_Discount"))
			{
				selenium.waitForElementToBeVisible("NationDiscountOption2");	//Discount Type should be National Discount
				selenium.click("NationDiscountOption2");
				//Delivery Mode will be auto set as 'Private Offer', so we don't need to select it.
			}
			selenium.waitingTime(1000);
			selenium.typeData("RequestedPriceField", "99");	//The requested price of the products should be greater than suggested price, so I am using 99 here
			selenium.waitingTime(1000);	
			selenium.click("ISNReqSubmitForApprovalBtn");	//Submitting ISBN Request
			selenium.waitingTime(30000);
			
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("OppProductDiscountRelatedListLink");
			selenium.jsClick("OppProductDiscountRelatedListLink");
			selenium.waitingTime(6000);
//			if (selenium.getTestCaseName().equalsIgnoreCase("ISBNRequestWithSingleEBookwithDiffDiscountTypes"))
//			{
				Assert.assertTrue(selenium.isElementPresentFast("ISBNReqStatusApproved"));
				selenium.test.log(LogStatus.PASS, "ISBN Request status is Aproved");
//			}
//			else
//			{
//				Assert.assertTrue(selenium.isElementPresentFast("ISBNReqStatusInApproval"));
//				selenium.test.log(LogStatus.PASS, "ISBN Request status is InApproval");
//			}
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed " + e.getMessage());
		}
	}
}
