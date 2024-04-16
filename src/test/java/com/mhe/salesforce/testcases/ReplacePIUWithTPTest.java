package com.mhe.salesforce.testcases;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ReplacePIUWithTPTest {

	WebConnector selenium = WebConnector.getInstance();
	String targetedProduct;
	String targetedProductUI;
	String ISBNNo;
	String PtoPIU_Opp;


	@And("^Note target products$")
	public void note_target_products() {

		try {		
			selenium.search("Opportunity Name");
			selenium.waitingTime(3000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Opportunity Name", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(Xpath);
			selenium.waitingTime(10000);
//            selenium.waitForElementToBeVisible("targetedProductsGetText");
//			selenium.scrollToElement("targetedProductsGetText");
//			targetedProduct = selenium.getTextLoop("targetedProductsGetText").toString();
//			System.out.println(targetedProduct);
			PtoPIU_Opp = selenium.getURL();
			System.out.println("Opp URL is :" + PtoPIU_Opp);
			
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
			
			ISBNNo = selenium.getTestDataFromPropertiesFile("ISBNNo");
			System.out.println("ISBNNo is" + ISBNNo);

			selenium.type_propertiesFile("isbnSearch1", "ISBNNo");
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
			selenium.test.log(LogStatus.PASS, "Product Added to Opportunity");					
			System.out.println("Product Added to Opportunity");
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on new sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}
	
	@And("^delete the product$")
	public void delete_the_product() {

		try {
			selenium.navigateToURL(PtoPIU_Opp);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("opportunityLineItemRelatedList");
			selenium.click("opportunityLineItemRelatedList");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("ProductInUse_Delete");
			selenium.click("ProductInUse_Delete");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
			selenium.waitingTime(6000);
			System.out.println("Successfully deleted the Product");
		}
		catch (Exception e) {
			selenium.reportFailure("Error while deleting product" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^Replace PIU with TP button and verify products in use$")
	public void replace_PIU_with_TP_button() {

		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			System.out.println(selenium.getURL());
			selenium.test.log(LogStatus.INFO, "URL : "+selenium.getURL());
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
			selenium.waitForElementToBeClickable("replacePIUWithTPBtn");
			selenium.clickLoop("replacePIUWithTPBtn");
			selenium.waitingTime(4000);
			selenium.switchToFrame("productframeUat");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("replacePIUWithTPMsg");
			String msg = selenium.getText("replacePIUWithTPMsg");
			selenium.test.log(LogStatus.PASS, "Message is displayed as:" + msg);
			selenium.waitForElementToBeClickable("backBtn");
			selenium.click("backBtn");
			selenium.waitingTime(4000);
			selenium.switchOutOfFrame();
			selenium.refresh();
			selenium.waitingTime(8000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.click("closeBtn");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("productInUseLink");
				selenium.click("productInUseLink");
			} else {
				selenium.waitForElementToBeVisible("productInUseLink");
				selenium.click("productInUseLink");
			}
			selenium.waitingTime(4000);
			
			System.out.println("ISBNNo is :" + ISBNNo);
			String Xpath = selenium.getDynamicXpath_propertiesFile("spantextContains", "ISBNNo", "endContains");
			selenium.waitingTime(4000);
			System.out.println("Xpath is" + Xpath);
//			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(4000);
//			targetedProductUI = selenium.getTextLoop("productInUseGetText");
//			selenium.test.log(LogStatus.INFO, "Targeted Product previous : "+targetedProduct);
//			selenium.test.log(LogStatus.INFO, "Targeted Product Now : "+targetedProductUI);
//			if((targetedProduct.toLowerCase()).contains(targetedProductUI.toLowerCase())) {
			if(selenium.isElementPresentXpathFast(Xpath)) {
				selenium.test.log(LogStatus.PASS, "Product found");
				System.out.println("PASS");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Product not found");
				selenium.reportFailure("Product not found");
			}
			
		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on new sample" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while clicking on new sample");
		}
	}
	
	@And("^verify ReplacePIUwithTP functionality from Opp List View$")
	public void verify_ReplacePIUwithTP_functionality() {
		try {
			selenium.navigateToURL(selenium.INTLOppURL);
			selenium.waitingTime(10000);
			selenium.navigateBack();
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("FirstOppCheckboxinRecentlyViewList");
			selenium.jsClick("FirstOppCheckboxinRecentlyViewList");
			selenium.click("ReplacePIUwithTPActionBtn");			
			selenium.waitingTime(10000);
			
			  if(selenium.isAlertPresent())
			  {
				  System.out.println("The expected alert message appeared.");
				  selenium.acceptAlertPopup();
				  selenium.waitingTime(10000);
				  if(selenium.isAlertPresent())
				  {
					  System.out.println("Alert appeared.");
					  selenium.acceptAlertPopup();
				  }
				  
					selenium.navigateToURL(selenium.INTLOppURL);
					selenium.waitingTime(10000);
					selenium.waitForElementToBeVisible("productInUseLink");
					selenium.click("productInUseLink");
					selenium.waitingTime(8000);
					Assert.assertTrue(selenium.isElementPresentFast("FirstTableRecord"));
					selenium.test.log(LogStatus.PASS,"Data got copied from Product to Product-In-Use");
			  }
			  else
			  {
				  	System.out.println("FAIL");
					selenium.reportFailure("The 1 Opportunities were processed and 1 products were replaced ! alert message did not appear");
					selenium.test.log(LogStatus.FAIL, "The 1 Opportunities were processed and 1 products were replaced ! alert message did not appear");
			  }				
			
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying ReplacePIUwithTP functionality" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying ReplacePIUwithTP functionality");
		}
	}
	
	@And("^verify ReplacePIUwithTP functionality from PIU related list$")
	public void verify_ReplacePIUwithTP_functionality_from_PIU_related_list() {
		try {
			selenium.click("replacePIUWithTPBtn");			
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.switchToFrame("newAccountFrame");
			Assert.assertTrue(selenium.isElementPresentFast("ReplacePIUwithTPSuccessMsg"));
			selenium.test.log(LogStatus.PASS,"Data got copied from Product to Product-In-Use");			
		} catch (Exception e) {
			selenium.reportFailure("Error while verifying ReplacePIUwithTP functionality" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying ReplacePIUwithTP functionality");
		}
	}

}
