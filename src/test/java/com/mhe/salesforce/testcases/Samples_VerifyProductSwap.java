package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Calendar;
import java.util.Date;

public class Samples_VerifyProductSwap {
	WebConnector selenium = WebConnector.getInstance();
	int x = 1;
//	public String ISBNNavigation="https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000002lSbyAAE/view";
	
//	@When("^I global search isbn$")
//    public void i_global_search_isbn() {
//		
//		try {
//			
///*		selenium.click("globalSearch");
//			selenium.waitingTime(2000);
//			selenium.type("globalSearch", "ISBN");
//			selenium.getElement("globalSearch").sendKeys(Keys.ENTER);*/
//			selenium.waitingTime(2000);
//			selenium.navigateToURL(ISBNNavigation);
//			selenium.waitingTime(8000);
//			
//		}
//		catch (Exception e) {
//			selenium.reportFailure("Error while global searching ISBN " + e.getMessage());
//			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//		}
//		
//	}
	@And("^Verify swap product field$")
    public void verify_swap_product_field() {
		
		try {
			
//			selenium.clickDynamic("globalSearchTextContains", "ISBN", "endContains");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("additionalProductInformation");
			selenium.scrollToElement("additionalProductInformation");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("swapProductISBN");
			boolean swapProduct = selenium.isElementPresentFast("swapProductISBN");
			if (swapProduct == true) {
				
				selenium.test.log(LogStatus.INFO, "Swap product present" );
			}
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			
		}
		catch (Exception e) {
			selenium.reportFailure("Error while verifying swap product field " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
    
	
	
	@Then("^click on sample contact button from menu$")
    public void click_on_sample_contact_button_from_menu() {
		
		try {
			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pXEFMAA4/view");
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
//			if (selenium.isElementPresentFast("sampleContactButton"))
//				{
//				System.out.println("sampleContactButton Element Present");
//				selenium.waitForElementToBeClickable("sampleContactButton");
//				selenium.click("sampleContactButton");
//				}
//			else
//				{
//				System.out.println("sampleContactButton Element Not Present");
				selenium.waitForElementToBeClickable("menuButton");
				selenium.jsClick("menuButton");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("sampleContactInsideMenu");
				selenium.jsClick("sampleContactInsideMenu");
//				}
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("sampleContact");
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(2000);
		}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on sample contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	
	 @Then("^search for product$")
	    public void search_for_product() {
		 
		 try {
				 selenium.waitingTime(5000);
				 selenium.refresh();
				 selenium.waitingTime(15000);
				 selenium.waitForElementToBeVisible("sampleContact");
				selenium.switchToFrame("sampleContact");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addISBN");
				selenium.click("addISBN");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("enterISBN");
				selenium.click("enterISBN");
				selenium.waitingTime(2000);
				selenium.type("enterISBN", "ISBN");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(3000);
				
		 }
			
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching product " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
				 @And("^verify swap products message$")
				    public void verify_swap_products_message() {
					 
					 try {
						boolean message =  selenium.isElementPresentFast("swappedProductsPopUp");
						 boolean productDetails = selenium.isElementPresentFast("swapProductDetailsOnPopUp");
						 if (message == true & productDetails == true ) {
							 
							 selenium.test.log(LogStatus.PASS, "Swap product message displayed" );
					 }
						 else{
							 selenium.test.log(LogStatus.FAIL, "Swap product message not displayed" );
							 selenium.reportFailure("Test Case Failed");
						 }
						 
						 selenium.captureScreenShot();
//						 selenium.waitingTime(2000);
					 }
					 catch (Exception e) {
						 selenium.switchOutOfFrame();
							selenium.reportFailure("Error while verifying swap product message" + e.getMessage());
							selenium.test.log(LogStatus.FAIL, "Test Case Failed");
						}
					 
				 }
				 
				 @Then("^click on create sample order$")
				    public void click_on_create_sample_order() {
					 try {
				 
						 selenium.waitForElementToBeClickable("okButton");
				selenium.click("okButton");
				selenium.waitingTime(3000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.isElementPresentFast("productPresent");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("createSampleOrder");
			 	selenium.clickLoop("createSampleOrder");
				selenium.waitingTime(8000);
				
				if(selenium.getElement("duplicateRecord").isDisplayed())
				{
					selenium.waitForElementToBeClickable("duplicateYes");
					selenium.click("duplicateYes");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("duplicateOKButton");
					selenium.click("duplicateOKButton");
					selenium.switchOutOfFrame();
					
				}
				
				selenium.switchOutOfFrame();
		 
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating sample " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
		
	
	 
	 @Then("^verify swap product on new sample$")
	    public void verify_swap_product_on_new_sample() {
		 
		 try {
//			 selenium.waitingTime(5000);
			//selenium.waitForElementToBeVisible("sampleOnContact");
			//selenium.waitingTime(2000);
			// boolean element = selenium.isElementPresentFast("sampleOnContact");
			// System.out.println("element present"+ element);
			 selenium.waitForElementToBeClickable("sampleLink_all");
			 	selenium.click("sampleLink_all");
			 	selenium.waitingTime(4000);
			 	
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
//				String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate = selenium.getText("lastModifiedDateRecordNew2");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				calendar1.setTime(date);
				calendar1.add(Calendar.DATE, -1);
				Date dateBefore1Day = calendar1.getTime();
				SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
				String yesterdaysDate = sdf2.format(dateBefore1Day);
				System.out.println("yesterday/today date" + yesterdaysDate);
				
				if(recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
					System.out.println("inside date check");
					selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");	
					selenium.waitingTime(5000);
				}
				else {
					System.out.println("clicking last modified date");
					selenium.waitForElementToBeClickable("lastCreatedDateRecord");
					selenium.jsClick("lastCreatedDateRecord");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
//					String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
					if(recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
						System.out.println("date matched");
						selenium.jsClick("sampleRecordTable");	
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						selenium.reportFailure("Test Case Failed");
					}
				}
			 	
			 	String product = selenium.getElement("swappedProductAfterSampleCreation").getAttribute("innerHTML");
			 	String expected_product = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Swapped Product");
			 	System.out.println("product" + product +expected_product );
			 	if(product.contains(expected_product)) {
			 		selenium.test.log(LogStatus.PASS, "Swapped product present on Sample page");
			 		
				} else {
					selenium.test.log(LogStatus.FAIL, "Swapped product not present on Sample page");
					selenium.reportFailure("Test Case Failed");
					}
			 	selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying swap product on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
	 @And("^Verify swap product field not present$")
	    public void verify_swap_product_field_not_present() {
			
			try {
				
//				selenium.clickDynamic("globalSearchTextContains", "ISBN", "endContains");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("additionalProductInformation");
				selenium.scrollToElement("additionalProductInformation");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("swapProductFieldEmpty");
				boolean swapProduct = selenium.isElementPresentFast("swapProductFieldEmpty");
				System.out.println("swap field" + swapProduct);
				String value = selenium.getElement("swapProductFieldEmpty").getText();
				System.out.println("value is" + value);
				if (value=="") {
					
					selenium.test.log(LogStatus.INFO, "Swap product not present" );
				}
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				
				
			}
			catch (Exception e) {
				selenium.reportFailure("Error while verifying swap product field " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
	 @Then("^click on create sample order for product$")
	    public void click_on_create_sample_order_for_product() {
			try {
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("createSampleOrderBtn");
				selenium.click("createSampleOrderBtn");
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
//				if(selenium.isElementPresentFast("createSampleOrderBtn"))
//				{
//					selenium.click("createSampleOrderBtn");
//				}
				selenium.waitingTime(12000);

				if (selenium.isElementPresentFast("duplicateRecord")) {
					if (selenium.getElement("duplicateRecord").isDisplayed()) {
						selenium.test.log(LogStatus.INFO, "Duplicate Record Found" );
						selenium.waitForElementToBeClickable("duplicateYes");
						selenium.click("duplicateYes");
						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("duplicateOKButton");
						selenium.click("duplicateOKButton");
						selenium.waitingTime(12000);
//						selenium.switchOutOfFrame();

					}
				}

				selenium.switchOutOfFrame();
				selenium.waitingTime(9000);

			}
catch (Exception e) {
	selenium.switchOutOfFrame();
	selenium.reportFailure("Error while creating sample " + e.getMessage());
	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
}
}
	 @Then("^verify new sample record$")
	    public void verify__new_sample_record() {
		 
		 try {
			 selenium.waitingTime(2000);

			 if(selenium.isElementPresentFast("sampleOnContact"))
			 {
				 selenium.jsClick("sampleOnContact");
			 }
			 else
			 {
				 selenium.click("sampleLinkFromOpportunities");
			 }
			 	
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
//				String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate = selenium.getText("lastModifiedDateRecordNew2");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				calendar1.setTime(date);
				calendar1.add(Calendar.DATE, -1);
				Date dateBefore1Day = calendar1.getTime();
				SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
				String yesterdaysDate = sdf2.format(dateBefore1Day);
				System.out.println("yesterday/today date" + yesterdaysDate);
				
				if(recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
					System.out.println("inside date check");
					selenium.refresh();
					selenium.waitingTime(6000);
					selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");	
					selenium.waitingTime(5000);
				}
				else {
					System.out.println("clicking last modified date");
					selenium.waitForElementToBeClickable("lastCreatedDateRecord");
					selenium.jsClick("lastCreatedDateRecord");
//					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
//					String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
					String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
					if(recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate)) {
						System.out.println("date matched");
						selenium.waitForElementToBeClickable("sampleRecordTable");
						selenium.jsClick("sampleRecordTable");	
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						selenium.reportFailure("Test Case Failed");
					}
				}
			 	
			 	String product = selenium.getElement("productNameAfterSampling").getAttribute("innerHTML");
			 	String expected_product = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("ISBN");
			 	System.out.println("actual product" + product );
			 	System.out.println("expected product"  +expected_product );
			 	if(product.contains(expected_product)) {
			 		selenium.test.log(LogStatus.PASS, "Sample created successfully");
			 		
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample not created");
					selenium.reportFailure("Test Case Failed");
					
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying swap product on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
	 @Then("^verify SFDC Status on sample record$")
	    public void verify_sfdc_status_on_sample_record() {
		 
		 try {
			 selenium.waitingTime(5000);
			 String contactURL = selenium.getURL();
			 System.out.println("contactURL is :" + contactURL);
			 selenium.waitForElementToBeClickable("sampleOnContactJordan1");
			 	selenium.jsClick("sampleOnContactJordan1");
			 	selenium.waitingTime(4000);
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
				System.out.println("The value of x is : " + x);
				if(x==2)
				{
					System.out.println("clicking last modified date to sort it in decending order..");
					selenium.waitForElementToBeClickable("lastCreatedDateRecord");
					selenium.jsClick("lastCreatedDateRecord");
					selenium.waitingTime(8000);
				}
//				String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate = selenium.getText("lastModifiedDateRecordNew2");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("sampleRecordTable");
				selenium.jsClick("sampleRecordTable");

				selenium.waitForElementToBeVisible("SFDCstatusAfterSampling");
			 	String status = selenium.getText("SFDCstatusAfterSampling").toString();
			 	String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SFDC Status");
			 	System.out.println("actual product" + status );
			 	System.out.println("expected product"  +expected_status );
			 	if(status.equalsIgnoreCase(expected_status))
			 	{
			 		selenium.test.log(LogStatus.PASS, "SFDC status verified successfully and pending approval");
			 		System.out.println("PASS");			 		
				}
			 	else
				{
					selenium.navigateToURL(contactURL);
					selenium.waitingTime(8000);
					x = 2;
					verify_sfdc_status_on_sample_record();
					if(!status.equalsIgnoreCase(expected_status))
						{					
							selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
							selenium.reportFailure("Test Case Failed");
						}					
				}
			 	selenium.captureScreenShot();
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying SFDC Status on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
	 @Then("^verify SFDC Status on sample record created$")
	    public void verify_sfdc_status_on_sample_record_created() {
		 
		 try {
//			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("sampleOnContactJordan1");
			 	selenium.jsClick("sampleOnContactJordan1");
			 	selenium.waitingTime(4000);
			 	selenium.refresh();
			 	selenium.waitingTime(5000);
			 	Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
//				String recordDate = selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
				String recordDate = selenium.getText("lastModifiedDateRecordNew2");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				if(recordDate.contains(todaysDate)) {
					System.out.println("inside date check");
					selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");	
					selenium.waitingTime(5000);
				}
				else {
			         System.out.println("clicking latest record");
			         //selenium.jsClick("lastModifiedDate");
//			         selenium.waitingTime(3000);
			         //String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			         //if(recordDate1.contains(todaysDate)) {
			         // System.out.println("date matched");
						selenium.waitForElementToBeClickable("sampleRecordTable");
			            selenium.jsClick("sampleRecordTable"); 
//			            selenium.waitingTime(5000);
			         //}
			         //else {
			         // selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
			         //}
			      }
				selenium.waitForElementToBeVisible("SFDCstatusAfterSampling");
			 	String status = selenium.getText("SFDCstatusAfterSampling").toString();
			 	String expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SFDC Status");
			 	System.out.println("actual product" + status );
			 	System.out.println("expected product"  +expected_status );
			 	if(status.equalsIgnoreCase(expected_status)) {
			 		selenium.test.log(LogStatus.PASS, "SFDC status verified successfully and pending approval");
			 		System.out.println("PASS");
			 		
				} else {
					selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
					System.out.println("FAIL");
					selenium.reportFailure("Test Case Failed");
					}
			 	selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying SFDC Status on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 

}