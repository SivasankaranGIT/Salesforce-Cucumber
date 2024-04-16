package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Samples_VerifyUserCanPickDifferentAddress {
	WebConnector selenium = WebConnector.getInstance();
	
//	public String contactRecordURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/003C000001ks3bSIAQ/view";
	
//	@And("^click on any contact$")
//	public void click_on_any_contact() {
//		
//		try {
////			selenium.search("Contact Name");
////			selenium.waitingTime(6000);
////			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
////			selenium.clickLoopXpath(Xpath);
//			selenium.waitingTime(3000);
//			selenium.navigateToURL(contactRecordURL);
//			selenium.waitingTime(8000);
//		selenium.test.log(LogStatus.INFO, "Clicked on contact" );
//			selenium.waitingTime(5000);
//			selenium.captureScreenShot();
//		}
//		
//	catch (Exception e) {
//		selenium.reportFailure("Error while clicking on contact " + e.getMessage());
//		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//	}
//		
//	}
	@Then("^click on sample contact button$")
    public void click_on_sample_contact_button() {
		
		try {
//			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0031A000027yYPgQAM/view");
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("sampleContactButton");
			selenium.click("sampleContactButton");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("sampleContact");
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(2000);
//			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on sample contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		
		}
	}
	
	
	 @Then("^search for product and click on next$")
	    public void search_for_product_and_click_on_next() {
		 
		 try {
			 selenium.waitingTime(5000);
			 selenium.waitForElementToBeClickable("addISBN");
			 selenium.click("addISBN");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("enterISBN");
				selenium.click("enterISBN");
				selenium.waitingTime(2000);
				selenium.type("enterISBN", "ISBN");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(3000);
//				if(selenium.isElementPresentFast("okButton"))
//				{
//					selenium.waitForElementToBeClickable("okButton");
//					selenium.click("okButton");
//					selenium.waitingTime(3000);
//				}
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.isElementPresentFast("productPresent");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.waitingTime(6000);
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching product " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 
	 @And("^click on the address displayed$")
	    public void click_on_the_address_displayed() {
		 
		 try {
			 
//			 selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("sampleAddress");
			 	selenium.click("sampleAddress");
				selenium.waitingTime(8000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while clicking on address " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^create new address$")
	    public void create_new_address() {
		 
		 try {
			 	selenium.click("sampleNewAddress");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("addressStreet1");
				selenium.click("addressStreet1");
				selenium.waitingTime(2000);
				selenium.type("addressStreet1", "Street1");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("addressZip");
				selenium.click("addressZip");
				selenium.waitingTime(2000);
				selenium.type("addressZip", "Zip");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("saveNewAddress");
				selenium.click("saveNewAddress");
				selenium.waitingTime(6000);
				
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while clicking on address " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }
	 
	 @And("^click on apply to the selected$")
	    public void click_on_apply_to_the_selected() {		 
			try {
				selenium.waitingTime(2000);
				String address = selenium.getDynamicXpath("anchorTextcontains", "Zip", "endContains");
				selenium.waitingTime(2000);
				boolean value = selenium.isElementPresentFast(address);
				System.out.println("value" + value);
				selenium.clickDynamic("divTextcontains1", "Zip", "selectAddressRadioButtonEnd");
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("applyToSelectedLine");
				selenium.click("applyToSelectedLine");
				selenium.waitingTime(4000);

			}
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error whileselecting address " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }


	@Then("^verify address and click on create sample order$")
	public void verify_address_and_click_on_create_sample_order() {

		try {
//			selenium.waitingTime(8000);
		 	selenium.waitForElementToBeVisible("sampleAddress");
			String address = selenium.getElement("sampleAddress").getAttribute("innerHTML");
			String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Zip");
			System.out.println("Actual Address :"+address);
			System.out.println("Expected Address :"+expected_address);

			if(address.contains(expected_address)) {
				selenium.test.log(LogStatus.PASS, "New address present on review sample page");
				System.out.println("PASS");

			} else {
				selenium.test.log(LogStatus.FAIL, "New address not present on review sample page");
				System.out.println("FAIL");

			}
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
		 	selenium.waitForElementToBeClickable("createSampleOrder");
			selenium.clickLoop("createSampleOrder");
			selenium.waitingTime(2000);

			if(selenium.isElementPresentFast("duplicateRecord"))
			{
				selenium.click("duplicateYes_samp");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("duplicateOKButton");
				selenium.click("duplicateOKButton");
				selenium.switchOutOfFrame();

			}

			selenium.switchOutOfFrame();
		}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying address on review sample page  " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}


	@Then("^verify address on new sample$")
    public void verify_address_on_new_sample() {
	 
	 try {
		 selenium.waitingTime(10000);
		 	//selenium.jsClick("sampleSection");
		 selenium.waitForElementToBeClickable("sampleLink");
		 	selenium.click("sampleLink");
		 	selenium.waitingTime(5000);
		 	
		 	Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
//			String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
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
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastModifiedDate");
				selenium.jsClick("lastModifiedDate");
				selenium.waitingTime(3000);
//				String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
				if(recordDate1.contains(todaysDate)) {
					System.out.println("date matched");
					selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");	
					selenium.waitingTime(5000);
				}
				else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
				}
			}
		 	
		 	
		 	String address = selenium.getText("sampleAddresstoVerify").toString();
		 	String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Zip");
		 	
		 	if(address.contains(expected_address)) {
		 		selenium.test.log(LogStatus.PASS, "New address present on Sample page");
		 	
			} else {
				selenium.test.log(LogStatus.FAIL, "New address not present on Sample page");
				
				}
		 	selenium.captureScreenShot();
			selenium.waitingTime(2000);
		 	
			
	 }
	 catch (Exception e) {
			selenium.reportFailure("Error while verifying address on sample page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
 } 
	 
	 @Then("^search for product click on next$")
	    public void search_for_product_click_on_next() {
		 
		 try {
//			 selenium.waitingTime(5000);
			 	selenium.waitForElementToBeClickable("addISBN");
			 	selenium.click("addISBN");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("enterISBN");
				selenium.click("enterISBN");
				selenium.waitingTime(2000);
				selenium.type("enterISBN", "ISBN");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(3000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.isElementPresentFast("productPresent");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.waitingTime(2000);
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching product " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^search for product click on next for any ISBN$")
	    public void search_for_product_click_on_next_for_any_isbn() {
		 
		 try {
			 	selenium.waitingTime(5000);
			 	selenium.refresh();
			 	selenium.waitingTime(15000);
				selenium.waitForElementToBeVisible("sampleContact");
				selenium.switchToFrame("sampleContact");
			 	selenium.waitForElementToBeClickableLongerDuration("addISBN");
			 	selenium.click("addISBN");
//				selenium.waitingTime(2000);
//			 	selenium.waitForElementToBeClickable("enterISBN");
//				selenium.click("enterISBN");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("enterISBN");
				selenium.type("enterISBN", "ISBN");
//				selenium.waitingTime(6000);
			 	selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(8000);
				
				 boolean button = selenium.getElement("okButton").isDisplayed();
				System.out.println("button present"+ button);
				
				if(button==true) {
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					System.out.println("inside true");
					selenium.click("okButton");
				}
				selenium.waitingTime(2000);
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				selenium.isElementPresentFast("productPresent");
//				selenium.waitingTime(2000);
			 	selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.waitingTime(8000);
				
		 }
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching product " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^verify contact prepopulated on sample page$")
	    public void verify_contact_prepopulated_on_sample_page() {
		try {
			
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("contactsDispalyedOnSamplePage")) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "contact prepopulated");
		 		
			}
		 else {
			 System.out.println("inside fail");
			 selenium.test.log(LogStatus.FAIL, "contact not prepopulated");
				 
		 }
			selenium.captureScreenShot();
				 selenium.waitingTime(2000);
				 selenium.switchOutOfFrame();
			
		}
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while verifying contacts section" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

	}
	 
	 @And("^click on existing contact$")
		public void click_on_existing_contact() {
			try {
				
				String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
				selenium.navigateToURL(url);
				selenium.waitingTime(10000);
				selenium.test.log(LogStatus.INFO, "Navigated to the desired contact" );
				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
		}
		
		
			 catch (Exception e) {
					
					selenium.reportFailure("Error while clicking contact " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
	 
	 @Then("^verify address on page and click on create sample order$")
	   public void verify_address__on_page_and_click_on_create_sample_order() {

	 try {
//	    selenium.waitingTime(8000);
//		 selenium.waitingTime(4000);
		 	selenium.waitForElementToBeVisible("sampleAddress");
	      String address = selenium.getElement("sampleAddress").getAttribute("innerHTML");
	      //String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Zip");
	      String expected_address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Zip1");
		 System.out.println("Actual address: "+address);
		 System.out.println("Expected address: "+expected_address);
		 expected_address= expected_address.toString().trim();
		 address= address.toString().trim();
	      if(address.contains(expected_address)) {
	         selenium.test.log(LogStatus.PASS, "New address present on review sample page");
	         System.out.println("PASS");
	        
	      } else {
	         selenium.test.log(LogStatus.FAIL, "New address not present on review sample page");
	         selenium.reportFailure("New address not present on review sample page");
	         System.out.println("FAIL");
	         }
	      selenium.captureScreenShot();
//	      selenium.waitingTime(2000);
		  selenium.waitForElementToBeClickable("createSampleOrder");
	      selenium.clickLoop("createSampleOrder");
	      selenium.waitingTime(30000);
	      
	      if(selenium.isElementPresentFast("duplicateRecord"))
	      {
	         selenium.click("duplicateYes_samp");
//	         selenium.waitingTime(2000);
			 selenium.waitForElementToBeClickable("duplicateOKButton");
	         selenium.click("duplicateOKButton");
//	         selenium.switchOutOfFrame();
	        
	      }
	      selenium.waitingTime(30000);
	      selenium.switchOutOfFrame();
	      selenium.waitingTime(5000);
	}
	catch (Exception e) {
	    selenium.switchOutOfFrame();
	      selenium.reportFailure("Error while verifying address on review sample page  " + e.getMessage());
	      selenium.test.log(LogStatus.FAIL, "Test Case Failed");
	      }
	}


}