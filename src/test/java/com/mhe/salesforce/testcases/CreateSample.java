package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import org.apache.poi.util.SystemOutLogger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSample {
	WebConnector selenium = WebConnector.getInstance();
	String ISBN;
	String todaysDate;
//	public String ProductURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t80000001xr5SAAQ/view";
	
	
	@When("^I navigate to sample tab$")
	public void I_navigate_to_sample_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
     	selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "New Sample");
     	selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleMenuDotsOption");
		selenium.jsClick("sampleMenuDotsOption");
		selenium.waitingTime(5000);
		System.out.println("Navigated to Samples page successfully!");
		selenium.test.log(LogStatus.INFO, "Navigated to Samples page successfully!");
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to Samples " + e.getMessage());
			}

	}
	
	@When("^I go to sample tab$")
	public void I_go_to_sample_tab()  {
		try {
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
     	selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type_propertiesFile("searchItemsTextField", "NewSample");
     	selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("sampleMenuDotsOption");
		selenium.jsClick("sampleMenuDotsOption");
		selenium.waitingTime(5000);
		System.out.println("Navigated to Samples page successfully!");
		selenium.test.log(LogStatus.INFO, "Navigated to Samples page successfully!");
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to Samples " + e.getMessage());
			}

	}
	
	
	@And("^click on New to create sample$")
    public void click_on_new_to_create_sample() {
		try {
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(15000);
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(2000);
	}
	
	
		 catch (Exception e) {
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while clicking new for sample " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	@Then("^click on search contacts$")
    public void click_on_search_contacts() {
		try {
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(30000);
//			selenium.waitForElementToBeVisible("sampleContact");
//			selenium.switchToFrame("sampleContact");
//			selenium.waitingTime(6000);
//			selenium.waitForElementToBeClickable("searchContactsOnNewSample");
//			selenium.click("searchContactsOnNewSample");
//			selenium.waitingTime(15000);
//			selenium.refresh();
//			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("sampleContact");
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchContactsOnNewSample");
			selenium.click("searchContactsOnNewSample");
			selenium.waitingTime(30000);
			selenium.waitForElementToBeClickable("searchAccountOnNewSample");
			selenium.click("searchAccountOnNewSample");
			selenium.waitingTime(5000);
			selenium.type("searchAccountOnNewSample", "Account Name");
			selenium.clickDynamic("spantextContains", "Account Name", "endContains");
			selenium.waitingTime(2000);
			//selenium.click("accountNameTosearchOnNewSample");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(5000);
	}
	
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching contacts " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	
	@And("^add contact to sample$")
    public void add_contact_to_sample() {
		try {
		boolean value =selenium.isElementPresentFast("contactResultsOnSearchOnNewSample");
		System.out.println("results"+value);
		if (value==true) {
				selenium.test.log(LogStatus.PASS, "Contact search results avilable");
		 		
			}
		 else {
				selenium.test.log(LogStatus.FAIL, "Contact search results not avilable");
				selenium.reportFailure("Contact search results not avilable");
				}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("conatctResultChcekboxOnNewSample");
			selenium.click("conatctResultChcekboxOnNewSample");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addToSamplebutton");
			selenium.jsClick("addToSamplebutton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("cancelOnSample");
			selenium.clickLoop("cancelOnSample");
			selenium.waitingTime(2000);
			boolean contact =selenium.isElementPresentFast("contactAddedToSample");
			System.out.println("contact added"+contact);
			if (contact==true) {
				selenium.test.log(LogStatus.PASS, "Contact added to sample");
		 		
			}
		 else {
				selenium.test.log(LogStatus.FAIL, "Contact not added to sample");
				selenium.reportFailure("Contact not added to sample");
				}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			
	}
	
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while adding contact to sample " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	
	@Then("^click on search products$")
    public void click_on_search_products() {
		try {
			selenium.waitForElementToBeClickable("searchProductsBtn");
			selenium.jsClick("searchProductsBtn");
//			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("productSearchCopyright");
			selenium.click("productSearchCopyright");
			selenium.waitingTime(2000);
			selenium.type("productSearchCopyright", "Copyright");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(5000);
	}
	
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while searching products " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	
	 @And("^add product to sample$")
	    public void add_product_to_sample() {
		try {

		selenium.waitForElementToBeVisible("contactResultsOnSearchOnNewSample");
		boolean value =selenium.isElementPresentFast("contactResultsOnSearchOnNewSample");
		System.out.println("results"+value);
		if (value==true) {
				selenium.test.log(LogStatus.PASS, "product search results avilable");
		 		
			}
		 else {
				selenium.test.log(LogStatus.FAIL, "product search results not avilable");
				selenium.reportFailure("product search results not avilable");
				}
			
			selenium.captureScreenShot();
			selenium.scrolldown(100);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productResultCheckboxOnNewSample");
			selenium.click("productResultCheckboxOnNewSample");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addToSamplebuttonAgain");
			selenium.jsClick("addToSamplebuttonAgain");
			selenium.waitingTime(4000);
			
			if(selenium.isElementPresentFast("swappedProductsPopUp")){
				System.out.println("inside swap poppup");
				selenium.jsClick("okButton");
				selenium.waitingTime(3000);
			}
			
			selenium.waitForElementToBeClickable("cancelOnSample");
			selenium.clickLoop("cancelOnSample");
			selenium.waitingTime(4000);
			boolean contact =selenium.isElementPresentFast("productAddedToSample");
			System.out.println("contact added"+contact);
			if (contact==true) {
				selenium.test.log(LogStatus.PASS, "Product added to sample");
				System.out.println("PASS");
		 		
			}
		 else {
				selenium.test.log(LogStatus.FAIL, "Product not added to sample");
				selenium.reportFailure("Product not added to sample");
				System.out.println("FAIL");
				}
			
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
				
	}
	
	
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while adding product to sample " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	 
	 @Then("^click on next and create sample$")
	    public void click_on_next_and_create_sample() {
		 
		 try {
			 selenium.waitForElementToBeClickable("ClickNextButton");
			 selenium.click("ClickNextButton");
				selenium.waitingTime(4000);
				
				
//				if(selenium.getElement("sampleCreate").isDisplayed())
//				{
//					System.out.println("Qualified samples checking popup");
//					selenium.waitForElementToBeClickable("sampleCreatecheckbox");
//					selenium.jsClick("sampleCreatecheckbox");
//					selenium.waitForElementToBeClickable("sampleCreationOkButton");
//					selenium.jsClick("sampleCreationOkButton");
//					
//					
//				}
				
				
				selenium.waitForElementToBeClickable("createSampleOrder");
				selenium.click("createSampleOrder");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentFast("duplicateRecord"))
				{
					selenium.waitForElementToBeClickable("duplicateYes");
					selenium.click2("duplicateYes");
					selenium.waitingTime(1000);
					selenium.waitForElementToBeClickable("duplicateOKButton");
					selenium.click2("duplicateOKButton");
					selenium.switchOutOfFrame();					
				}
//				if(selenium.getElement("sampleCreate").isDisplayed())
//				{
//					selenium.clickLoop("sampleCreatecheckbox");
//					selenium.waitingTime(2000);
//					selenium.click("sampleCreationOkButton");
//					selenium.switchOutOfFrame();
//					
//					
//				}
				
				selenium.switchOutOfFrame();
				selenium.waitingTime(5000);
			 
		 }
		 
		 catch (Exception e) {
			 selenium.switchOutOfFrame();
				selenium.reportFailure("Error while creating sample order " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @And("^verify sample is created$")
	    public void verify_sample_is_created() {
		 
		 try {
			 selenium.waitingTime(9000);
			 
			 Calendar calendar1 = Calendar.getInstance();
				Date date = calendar1.getTime();
				SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
				String todaysDate = sdf1.format(date);
				String recordDate = selenium.getTextLoop("lastModifiedDateRecord");
				System.out.println("todays date"+todaysDate);
				System.out.println("record date"+recordDate);
				
				calendar1.setTime(date);
				calendar1.add(Calendar.DATE, -1);
				Date dateBefore1Day = calendar1.getTime();
				SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
				String yesterdaysDate = sdf2.format(dateBefore1Day);
				System.out.println("yesterday/today date" + yesterdaysDate);

				if(recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate))  {
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
					String recordDate1 = selenium.getTextLoop("lastModifiedDateRecord");
					if(recordDate1.contains(todaysDate) || recordDate1.contains(yesterdaysDate))  {
						System.out.println("PASS - date matched");
						selenium.waitForElementToBeClickable("sampleRecordTable");
						selenium.jsClick("sampleRecordTable");	
						selenium.waitingTime(5000);
					}
					else {
						selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
						System.out.println("FAIL - Sample creation failed");
						selenium.reportFailure("Sample creation failed");
					}
				}

			 String prodNameXpath= selenium.getLastXpath("scomUserAccountName");
			 String name = selenium.getXpathElement(prodNameXpath).getAttribute("innerHTML");
			 	String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
			 	System.out.println("actual product" + name );
			 	System.out.println("expected product"  +expected_name );
			 	selenium.waitForElementToBeVisible("copyRightAfterSampling");
			 	String copyright = selenium.getText("copyRightAfterSampling").toString();
			 	String expected_copyright = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Copyright");
			 	System.out.println("actual address status" + copyright );
			 	System.out.println("expected add3ress status"  +expected_copyright );
			 	if((name.contains(expected_name)) & (copyright.equalsIgnoreCase(expected_copyright))) {
			 		selenium.test.log(LogStatus.PASS, "Sample details Verified successfully");
			 		System.out.println("PASS - inside second pass");
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample details not proper");
					System.out.println("FAIL - inside second fail");
					selenium.reportFailure("Sample details not proper");
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying details on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
	 
	 @When("^I navigate to Products tab$")
	    public void i_navigate_to_products_tab()  {
			try {
			
//		    selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type("searchItemsTextField", "New Product");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productsMenuDotsOption");
			selenium.jsClick("productsMenuDotsOption");
			selenium.waitingTime(5000);
			}
			 catch (Exception e) {
					
					selenium.reportFailure("Error while navigating to Products " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		} 
	 
	 @When("^I go to Products tab$")
	    public void i_go_to_products_tab()  {
			try {
			
//		    selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.type_propertiesFile("searchItemsTextField", "NewProduct");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("productsMenuDotsOption");
			selenium.jsClick("productsMenuDotsOption");
			selenium.waitingTime(5000);
			}
			 catch (Exception e) {
					
					selenium.reportFailure("Error while navigating to Products " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		} 
	 
//	 @Then("^I filter for Product Oracle Status as OP$")
//	    public void i_filter_for_product_oracle_status_as_op() {
//			try {
//  /*          selenium.search("Product Name");
//			selenium.clickDynamicXpath("anchorTitle", "Product Name", "end");*/
//			selenium.waitingTime(5000);
//			selenium.navigateToURL(ProductURL);
//			selenium.waitingTime(8000);
//			 
//			}
//			 catch (Exception e) {
//					
//					selenium.reportFailure("Error while filtering products " + e.getMessage());
//					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//				}
//
//		}
	 
	 @And("^fetch ISBN value$")
	    public void fetch_ISBN_value() {
			try {
				
				ISBN = selenium.getText("restrictedISBNvalue").toString();
			 	System.out.println("actual ISBN" + ISBN );	
			 	selenium.captureScreenShot();
//			 	selenium.waitingTime(3000);
			}
			 catch (Exception e) {
					
					selenium.reportFailure("Error while filtering products " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
	 
	 @Then("^search for restricted product$")
	    public void search_for_restricted_product() {
		 
		 try {
//			 selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("addISBN");
			 selenium.click("addISBN");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("enterISBN");
				selenium.click("enterISBN");
				selenium.waitingTime(2000);
				selenium.getElement("enterISBN").sendKeys(ISBN);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addButton");
				selenium.click("addButton");
				selenium.waitingTime(5000);
				if(selenium.isElementPresentFast("swappedProductsPopUp")){
					System.out.println("inside swap poppup");
					selenium.jsClick("okButton");
					selenium.waitingTime(3000);
				}
//				boolean error = selenium.isElementPresentFast("restrictedISBNErrorWindow");
//				
//				System.out.println(error);
				
				//String name = selenium.getText("restrictedISBNErrorMessage").toString();
				
//			 	String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
//			 	System.out.println("actual error" + name );
//			 	System.out.println("expected error"  +expected_name );
			 	selenium.click("ClickNextButton");
			 	if(selenium.isElementPresentFast("noProductsFoundForOPIsbn"))
			 	 {
			 		selenium.test.log(LogStatus.PASS, "ISBN entered is restricted from being sampled");
			 		System.out.println("inside second pass");
				} else {
					selenium.test.log(LogStatus.FAIL, "ISBN is not restricted from being sampled");
					System.out.println("inside second fail");
					selenium.reportFailure("ISBN is not restricted from being sampled");
					}
			 	selenium.captureScreenShot();
//				selenium.waitingTime(2000);
				
				//selenium.click("okButtonForISBNRestricted");
				selenium.waitingTime(3000);
				selenium.switchOutOfFrame();
		
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while adding product" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^fill mandatory fileds on account and orders details page for SEG user$")
	    public void fill_mandatory_fileds_on_account_and_orders_details_page_for_seg_user() {
			try {
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("searchAccountOnNewSample");
				selenium.click("searchAccountOnNewSample");
				selenium.waitingTime(2000);
				selenium.type("searchAccountOnNewSample", "Account Name");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("accountNameOnOrderPadNew");
				selenium.click("accountNameOnOrderPadNew");
				selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("contactDropdownOnOrderPad");
			selenium.jsClick("contactDropdownOnOrderPad");
			selenium.waitingTime(2000);
			selenium.selectDropdownByIndex("contactDropdownOnOrderPad", "Index");
			selenium.waitingTime(2000);
			String line = selenium.getElement("attnLineOnOredrPad").getAttribute("innerHTML");
			 String expected_line = selenium.fetchTextFromDropdown("contactDropdownOnOrderPad");
			System.out.println("attention line is" + line);
			if (line.equalsIgnoreCase(expected_line)) {
				selenium.test.log(LogStatus.INFO, "attention line prepopulated" );				
			}			
			else
			{
				selenium.test.log(LogStatus.INFO, "attention line not prepopulated" );				
			}
			
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.click("RefInstruction");
			selenium.waitingTime(4000);
			String address = selenium.getElement("addressValueOnOrderPad").getText();
			System.out.println("address is" + address);
			selenium.waitForElementToBeClickable("searchAddressonNewSample");
			selenium.click("searchAddressonNewSample");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("createNewAddressonSample");
			selenium.click("createNewAddressonSample");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("street1OnNewSampleAddress");
			selenium.click("street1OnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("street1OnNewSampleAddress", "Street 1");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("cityOnNewSampleAddress");
			selenium.click("cityOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("cityOnNewSampleAddress", "City");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("stateOnNewSampleAddress");
			selenium.click("stateOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("stateOnNewSampleAddress", "State");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("zipOnNewSampleAddress");
			selenium.click("zipOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("zipOnNewSampleAddress", "Zip");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addressTypeDropdownOnNewSampleAddress");
			selenium.jsClick("addressTypeDropdownOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.selectDropdownText("addressTypeDropdownOnNewSampleAddress", "Address Type");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("workflowStatusNoteOnNewSampleAddress");
			selenium.click("workflowStatusNoteOnNewSampleAddress");
			selenium.waitingTime(2000);
			selenium.type("workflowStatusNoteOnNewSampleAddress", "Workflow Notes");
			selenium.waitingTime(2000);
			selenium.moveTab("workflowStatusNoteOnNewSampleAddress");
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
			if(selenium.isElementPresentFast("errorMessageOnSampleAddress")==true) {
				selenium.waitForElementToBeClickable("closeButtonOnSampleAddress");
				selenium.jsClick("closeButtonOnSampleAddress");
			}
			selenium.waitForElementToBeClickable("saveButton");
			selenium.jsClick("saveButton");
//			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("orderLineTypeOnOrderPad");			
			
			selenium.scrollToElement("orderLineTypeOnOrderPad");
			boolean value1 = selenium.fetchValueFromDropdown("orderLineTypeOnOrderPad","Order Line Type");
			boolean value2 = selenium.fetchValueFromDropdown("sfdcStatusOnOrderPad","SFDC Status");
			boolean value3 = selenium.fetchValueFromDropdown("shipMethodOnOrderPad","Ship Method");
			boolean value4 = selenium.fetchValueFromDropdown("shipPriorityOnOrderPad","Ship Priority");
			System.out.println("value1 is" + value1);
			System.out.println("value2 is" + value2);
			System.out.println("value3 is" + value3);
			System.out.println("value4 is" + value4);
			
			String name = selenium.getText("desiredOwnerOnOrderPad").toString();
			 String expected_name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Desired Owner");
			System.out.println("actual owner is" + name + expected_name);
			
			if(value1==true & value2==true & value3==true & value4==true & name.equalsIgnoreCase(expected_name) ) {
				selenium.test.log(LogStatus.PASS, "Values verified successfully on Account and order details page" );	
				System.out.println("PASS");
			}			
			else				
			{
				selenium.test.log(LogStatus.FAIL, "Values verification failed on Account and order details page" );
				selenium.reportFailure("Values verification failed on Account and order details page");
				System.out.println("FAIL");
			}		
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(10000);
			}
		
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while filling mandatory details " + e.getMessage());
					selenium.switchOutOfFrame();
				}
		}
	 
		@Then("^add contact information$")
	    public void add_contact_information() {
			try {
	
				selenium.waitForElementToBeClickable("searchAccountOnNewSample");
				selenium.click("searchAccountOnNewSample");
				selenium.waitingTime(2000);
				selenium.type("searchAccountOnNewSample", "Account Name");
				selenium.waitingTime(4000);
				selenium.clickDynamic("spantextContains", "Account Name", "endContains");
				//selenium.selectDropdownByValue("contactsamplecreation","Contact Name");
				selenium.selectDropdownByIndex("contactsamplecreation", "Contact Name");
				selenium.waitingTime(2000);
				selenium.type("oppDesiredOwner", "Desired Owner");
				
				selenium.waitingTime(2000);
				selenium.clickDynamic("spantextContains", "Desired Owner", "endContains");
				selenium.click("NxtButton");
		}
		
		
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while searching contacts " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
		
		@Then("^create new opportunity from smample$")
	    public void create_new_opportunity() {
			try {
				selenium.waitingTime(2000);
				selenium.click("backButton");
				selenium.waitingTime(2000);
				selenium.click("productselected");
				selenium.click("NxtButton");
				selenium.waitingTime(2000);
				selenium.jsClick("oppCreationcheckbox");
				selenium.waitingTime(2000);
				selenium.type("oppAmount","Amount");
				selenium.selectDropdownByValue("oppmarketrevenuegroup", "Market Revenue Group");
				selenium.type("oppDealName", "Deal Name");
				if(selenium.getTestCaseName().equalsIgnoreCase("oppcreatedfromsamplescenario2"))
				{
					selenium.type("closedate", "Closedate");
					selenium.type("Purchasedate", "PurchaseDate");
				}
				
				if(selenium.getTestCaseName().equalsIgnoreCase("oppcreatedfromsamplescenario3"))
				{
					selenium.type("closedate", "Closedate");
					selenium.type("Purchasedate", "PurchaseDate");
				}
				
				selenium.click("NxtButton");
				selenium.waitingTime(2000);
				selenium.click("createSampleOrderBtn");
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("createSamples"))
				selenium.click("createSamples");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("goToOppButton");
				selenium.click("goToOppButton");
		}
		
		
			 catch (Exception e) {
				 selenium.switchOutOfFrame();
					selenium.reportFailure("Error while searching contacts " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		}
		
		@And("^verify cy/fy date on opportunity$")
	    public void verify_date_on_opportunity() {
		 
		 try {
			selenium.waitingTime(4000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrolldown(200);
			selenium.waitingTime(2000);
			String closedate= selenium.getText("closedateOpp2");
			String purchasedate=selenium.getText("purchaseDateopp2");
	     	String expected_closeDate = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Close Date");
	     	String expected_purchaseDate = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Purchase Date"); 
			System.out.println("closedate:" + closedate + "purchasedate:" + purchasedate + "expected_closeDate:" + expected_closeDate + "expected_purchaseDate:" + expected_purchaseDate);
	     	
			 	if((closedate.equals(expected_closeDate)) & (purchasedate.equals(expected_purchaseDate))) {
			 		selenium.test.log(LogStatus.PASS, "Sample details Verified successfully");
			 		System.out.println("PASS");
				} else {
					selenium.test.log(LogStatus.FAIL, "Sample details not proper");
					selenium.reportFailure("Sample details not proper");
					}
			 	selenium.captureScreenShot();
				selenium.waitingTime(2000);
			 	
				
		 }
		 catch (Exception e) {
				selenium.reportFailure("Error while verifying details on sample page " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 } 
		@When("^I navigate to consultant tab$")
		public void I_navigate_to_consultant_tab()  {
			try
				{
					selenium.check_Switch_UserInterface();
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.typeData("searchItemsTextField", "Consultants");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ConsultantMenuDotsOption");
					selenium.jsClick("ConsultantMenuDotsOption");
					selenium.waitingTime(5000);
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while navigating to Consultant");
					selenium.reportFailure("Error while navigating to Consultant " + e.getMessage());
				}
		}

		@Then("^I navigate to CRF page$")
		public void I_navigate_to_CRF_page()
		{
			try
				{
					selenium.switchToFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("AssignmentsTab");
					selenium.click("AssignmentsTab");
					selenium.waitForElementToBeClickable("RequestCRFLink");
					selenium.click("RequestCRFLink");
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.switchToMultipleFrame("newAccountFrame");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("AdeccoBtn");
					selenium.click("AdeccoBtn");
				}
			catch (Exception e)
				{
				 	selenium.captureScreenShot();
				 	selenium.test.log(LogStatus.FAIL, "Error while navigating to CRF page");
					selenium.reportFailure("Error while navigating to CRF page" + e.getMessage());
				}
		}

		@And("^verify CRF Preview PDF functionality$")
		public void verify_CRF_Preview_PDF_functionality()
		{
			try
				{
					selenium.waitingTime(5000);
					selenium.switchToLastWindow();
					selenium.waitingTime(2000);
					if(!selenium.getTestCaseName().equalsIgnoreCase("CRFVerifyPreviewPDFAndEmail3"))
					{
						selenium.switchOutOfFrame();
						selenium.waitingTime(2000);						
					}
					selenium.waitForElementToBeClickable("AssignementRadioBtn");
					selenium.click("AssignementRadioBtn");
					selenium.waitForElementToBeClickable("nextButtonValue");
					selenium.click("nextButtonValue");
					selenium.waitForElementToBeVisible("PreviewPDFBtn");
					selenium.scrollToElement("PreviewPDFBtn");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.click("PreviewPDFBtn");
					selenium.waitingTime(5000);
//					selenium.switchToLastWindow();
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					selenium.switchToChildWindow();
					selenium.waitingTime(5000);
//					selenium.captureScreenShot();
//					selenium.waitingTime(2000);
					selenium.test.log(LogStatus.PASS, "CRF - Preview PDF Successful!");
					selenium.close();
					selenium.waitingTime(5000);
					selenium.switchToLastWindow();
					selenium.waitingTime(5000);
				}
			catch (Exception e)
				{
				 	selenium.captureScreenShot();
				 	selenium.test.log(LogStatus.FAIL, "Error while previewing CRF PDF file");
					selenium.reportFailure("Error while previewing CRF PDF file" + e.getMessage());
				}
		}

		@And("^verify Send Request as PDF functionality$")
		public void verify_Send_Request_as_PDF_functionality()
		{
			try
				{
					selenium.waitForElementToBeVisible("EmailCRFToField");
					selenium.type("EmailCRFToField", "To Email");
					selenium.type("EmailCRFCCField", "CC Email");
					selenium.type("EmailCRFMessageField", "Message Email");
					selenium.scrollToElement("EmailCRFSendBtn");
					selenium.click("EmailCRFSendBtn");
					selenium.waitingTime(8000);
					if(selenium.isElementPresentFast("EmailSentSuccessMsg"))
					{
						selenium.test.log(LogStatus.PASS, "CRF - Emailed Successfully!");
						selenium.captureScreenShot();
						selenium.waitingTime(2000);
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "CRF - Email Failed!");
						selenium.reportFailure("CRF - Email Failed!");
					}
					selenium.close();
					selenium.waitingTime(2000);
					selenium.switchBackToParentWindow();
					selenium.waitingTime(3000);
				}
			catch (Exception e)
				{
				 	selenium.captureScreenShot();
				 	selenium.test.log(LogStatus.FAIL, "Error while verifying send request as pdf functionality");
					selenium.reportFailure("Error while verifying send request as pdf functionality" + e.getMessage());
				}
		}

		@Then("^I navigate to consultant assignments page$")
		public void I_navigate_to_consultant_assignment_page()
		{
			try
				{
					selenium.switchToFrame("newAccountFrame");
					selenium.waitForElementToBeClickable("AssignmentsTab");
					selenium.click("AssignmentsTab");
					selenium.waitForElementToBeClickable("ConsultantAssignmentsLink");
					selenium.click("ConsultantAssignmentsLink");
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.switchToMultipleFrame("newAccountFrame");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("Addeco");
					selenium.click("Addeco");
				}
			catch (Exception e)
				{
				 	selenium.captureScreenShot();
				 	selenium.test.log(LogStatus.FAIL, "Error while navigating to CRF page");
					selenium.reportFailure("Error while navigating to CRF page" + e.getMessage());
				}
		}

		@When("^I navigate to consultant requests tab$")
		public void I_navigate_to_consultant_requests_tab()  {
			try
				{
					selenium.check_Switch_UserInterface();
					selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.typeData("searchItemsTextField", "Consultant Requests");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ConsultantRequestMenuDotsOption");
					selenium.jsClick("ConsultantRequestMenuDotsOption");
					selenium.waitingTime(5000);
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while navigating to Consultant Request");
					selenium.reportFailure("Error while navigating to Consultant Request" + e.getMessage());
				}
		}

		@And("^create new consultant request$")
		public void create_new_consultant_request()  {
			try
				{
					selenium.waitForElementToBeClickable("NewButtonToAdd");
					selenium.click("NewButtonToAdd");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("nextBtn");
					selenium.click("nextBtn");
					selenium.waitingTime(8000);
					selenium.switchToMultipleFrame("newCRFIframe");
					selenium.waitingTime(4000);
					selenium.waitForElementToBeVisible("crfType");
					selenium.selectDropdownText("crfType", "Type");
//					selenium.waitingTime(2000);
//					selenium.typeData("CRFRequestor", "SEGBA SEGAdmin");
					selenium.waitingTime(2000);
					selenium.typeData("CRFManager", "Charlie Edwards"); //Charlie Edwards //Jason Hinkle

					Calendar calendar1 = Calendar.getInstance();
					Date date = calendar1.getTime();

					SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
					todaysDate = sdf1.format(date);
					System.out.println(todaysDate);
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfPresentationDate");
					selenium.typeData("crfPresentationDate", todaysDate);
					selenium.waitingTime(2000);
					selenium.typeData("crfAlternateDate1", todaysDate);
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfAlternateDate2");
					selenium.typeData("crfAlternateDate2", todaysDate);
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfPresentationStartTime");

					selenium.scrollToElement("crfPresentationStartTime");
					selenium.selectDropdownText("crfPresentationStartTime", "PresentationStartTime");
					selenium.selectDropdownText("crfPresentationEndTime", "PresentationEndTime");
					selenium.selectDropdownText("crfPresentationTimeZone", "PresentationTimeZone");
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("crfPresentationTime");
					selenium.jsClick("crfPresentationTime");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfConsultantsNeeded");

					selenium.type("crfConsultantsNeeded", "ConsultantsNeeded");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfPrimaryContactNumber");
					selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");

					selenium.scrollToElement("crfProgramCopyRightProgramlevels");
					selenium.type("crfProgramCopyRightProgramlevels", "ProgramCopyRightProgramlevels");
					selenium.waitingTime(2000);
					selenium.type("DollerAmount", "Doller Amount");
					selenium.waitForElementToBeVisible("presentationTypes");
					//selenium.moveTab("presentationTypes");
					Select dropdown = new Select(selenium.getElement("presentationTypes"));
		            
		            dropdown.selectByValue("1");
					//selenium.selectDropdownText("presentationTypes", "Presentation Type");
		            selenium.waitForElementToBeClickable("crfArrowToMove");
					selenium.clickLoop("crfArrowToMove");
//					selenium.waitingTime(2000);
//					selenium.waitForElementToBeVisible("crfDistrickMeetingType");
//					selenium.type("crfDistrickMeetingType", "DistrickMeetingType");
	                selenium.selectDropdownText("webinarinperson", "WebinarInPerson");
					selenium.scrollToElement("crfNoOfParticipant");
					selenium.type("crfNoOfParticipant", "NoOfParticipant");

					selenium.type("crfPresentationDescription", "PresentationDescription");

					selenium.type("linkedOpportunityText", "Linked Opportunity");
					selenium.type("crfSiteAddress", "SiteAddress");
					selenium.type("crfSiteCity", "SiteCity");
					selenium.selectDropdownText("crfSiteState", "SiteState");
					selenium.type("crfSitePostalCode", "SitePostalCode");

					selenium.type("crfPresentationSite", "PresentationSite");
					selenium.type("crfSitePhone", "SitePhone");
					selenium.type("crfSiteContactName", "SiteContactName");
					selenium.type("crfSiteContactEmail", "SiteContactEmail");

					selenium.type("crfAirportName", "AirportName");
					selenium.type("crfAirportCityState", "AirportCityState");
					selenium.type("crfTravelTime", "TravelTime");
					selenium.waitingTime(5000);
					selenium.scrollToElement("crfSaveClose");
					selenium.clickLoop("crfSaveClose");
					//selenium.waitingTime(5000);
					/*if(selenium.isElementPresentFast("crfSaveClose"))
					{
						selenium.clickLoop("crfSaveClose");
					}*/
//					selenium.switchOutOfFrame();
					selenium.waitingTime(5000);

				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while creating new Consultant Request");
					selenium.reportFailure("Error while creating new Consultant Request" + e.getMessage());
				}
		}

		@And("^verify manager and requestor field validation$")
		public void verify_manager_and_requestor_field_validation()  {
			try
				{
					if(selenium.isElementPresentFast("CRFSameUserValidationMsg"))
					{
						selenium.test.log(LogStatus.PASS, "Requestor and Manager cannot be same\r\n"
								+ " - Validation triggered successfully!");
						selenium.captureScreenShot();
						selenium.waitingTime(2000);
						System.out.println("PASS");
						selenium.typeData("CRFRequestor", "Charlie Edwards");
						selenium.waitingTime(2000);
						selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");
						selenium.scrollToElement("crfSaveClose");
						selenium.clickLoop("crfSaveClose");
						selenium.waitingTime(5000);
						selenium.switchOutOfFrame();
						selenium.test.log(LogStatus.PASS, "New Consultant Request Created Successfully!");
						selenium.captureScreenShot();
						selenium.waitingTime(2000);						
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "Requestor and Manager cannot be same\r\n"
								+ " - Validation did not trigger!");
						selenium.reportFailure("The expected validation did not trigger");
						System.out.println("FAIL");
					}

				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while validating the manager and requestor");
					selenium.reportFailure("Error while validating the manager and requestor" + e.getMessage());
				}
		}

		@And("^edit existing CRF and verify manager and requestor field validation$")
		public void edit_existing_CRF_and_verify()  {
			try
				{
					selenium.refresh();
					selenium.waitingTime(5000);
					selenium.switchToFrame("newAccountFrame");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("edit");
					selenium.click("edit");
					selenium.waitingTime(4000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.switchToMultipleFrame("newCRFIframe");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("CRFRequestor");
//					selenium.typeData("CRFRequestor", "SEGBA SEGAdmin");
					selenium.typeData("CRFManager", "Charlie Edwards");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("crfPrimaryContactNumber");
					selenium.type("crfPrimaryContactNumber", "PrimaryContactNumber");
					selenium.scrollToElement("crfSaveClose");
					selenium.clickLoop("crfSaveClose");
					selenium.waitingTime(2000);
					verify_manager_and_requestor_field_validation();
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while validating the manager and requestor");
					selenium.reportFailure("Error while validating the manager and requestor" + e.getMessage());
				}
		}

		@And("^switch to classic user interface$")
		public void switch_to_classic_user_interface()  {
			try
				{
					selenium.switchTo_Classic_UserInterface();					
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while switching to classic interface");
					selenium.reportFailure("Error while switching to classic interface" + e.getMessage());
				}
		}

		@Then("^I navigate to reports tab$")
		public void I_navigate_to_reports_tab()  {
			try
				{
					selenium.waitForElementToBeClickable("ReportsTab");
					selenium.click("ReportsTab");
					selenium.waitForElementToBeClickable("CustomReportOption");
					selenium.click("CustomReportOption");
										
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Error while navigating to reports tab in classic mode");
					selenium.reportFailure("Error while navigating to reports tab in classic mode" + e.getMessage());
				}
		}

		@And("^verify the request general and webinar in person fields$")
		public void verify_the_required_fields()  {
			try
				{
					selenium.waitForElementToBeClickable("CustomReportOption");
					selenium.click("CustomReportOption");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ReportQuickSearch");
					selenium.type("ReportQuickSearch", "Report Name");
					selenium.waitingTime(2000);
					selenium.pressEnter("ReportQuickSearch");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("ReportTestData");
					selenium.click("ReportTestData");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("CustomizeReportBtn");
					selenium.click("CustomizeReportBtn");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("FieldsQuickFind");
					selenium.type("FieldsQuickFind", "Field Name");
					selenium.waitingTime(2000);
					if(selenium.isElementPresentFast("RequestGeneralField") && selenium.isElementPresentFast("WebinarField"))
					{
						selenium.test.log(LogStatus.PASS, "Request: General & Webinar/In-Person fields are present!");
						System.out.println("PASS");
						selenium.captureScreenShot();
						selenium.waitingTime(2000);
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "The expected fields are not present");
						selenium.reportFailure("The expected fields are not present");						
					}
					selenium.click("CloseReport");
					selenium.waitingTime(2000);
					selenium.click("CloseReportPopup");
					selenium.waitingTime(4000);
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "The expected fields are not present");
					selenium.reportFailure("The expected fields are not present" + e.getMessage());
				}
		}

		@Then("^create new report and verify the webinar in person field$")
		public void create_new_report_and_verify()  {
			try
				{
					selenium.waitForElementToBeClickable("NewReportBtn");
					selenium.click("NewReportBtn");
					selenium.waitForElementToBeClickable("FieldsQuickFind");
					selenium.type("FieldsQuickFind", "Report Type");
					selenium.waitForElementToBeClickable("ReportType");
					selenium.click("ReportType");
					selenium.waitForElementToBeClickable("CreateReportBtn");
					selenium.click("CreateReportBtn");
					selenium.waitingTime(5000);
					if(selenium.isElementPresentFast("WebinarColumn"))
					{
						selenium.test.log(LogStatus.PASS, "Webinar/In-Person field is present!");
						System.out.println("PASS");
						selenium.captureScreenShot();
						selenium.waitingTime(2000);
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "Webinar/In-Person field is not present!");
						selenium.reportFailure("Webinar/In-Person field is not present!");						
					}										
				}
			 catch (Exception e)
				{
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.FAIL, "Webinar/In-Person field is not present!");
					selenium.reportFailure("Webinar/In-Person field is not present!" + e.getMessage());
				}
		}

		@Then("^I navigate to CRF page in classic mode$")
		public void I_navigate_to_CRF_page_in_clasic_mode()
		{
			try
				{
					selenium.waitForElementToBeClickable("AllTabsMenu");
					selenium.click("AllTabsMenu");
					selenium.waitForElementToBeClickable("ConsultantLink");
					selenium.click("ConsultantLink");
					selenium.waitForElementToBeClickable("searchTextC");
					selenium.type("searchTextC", "Consultant Name");
					selenium.pressEnter("searchTextC");
					selenium.waitingTime(6000);
					if(selenium.isElementPresentFast("NoThanksPopup"))
					{
						selenium.click("NoThanksPopup");
					}
					selenium.waitForElementToBeClickable("ConsultantSearchLink");
					selenium.click("ConsultantSearchLink");
					
					String consultantName = selenium.getDynamicXpath("anchorTextcontains", "Consultant Name", "endContains");
					System.out.println("consultantName is : " + consultantName);
					selenium.waitingTime(2000);
					selenium.clickLoopXpath(consultantName);
					
//					selenium.waitForElementToBeClickable("ConsultantRecord");
//					selenium.click("ConsultantRecord");
					selenium.waitForElementToBeClickable("AssignmentsTab");
					selenium.click("AssignmentsTab");
					selenium.waitingTime(5000);
					if(selenium.getTestCaseName().equalsIgnoreCase("CRFVerifyPreviewPDFAndEmail3"))
					{
						selenium.waitForElementToBeClickable("RequestCRFLink");
						selenium.click("RequestCRFLink");
					}
					if(selenium.getTestCaseName().equalsIgnoreCase("CRFVerifyPreviewPDFAndEmail4"))
					{
						selenium.waitForElementToBeClickable("ConsultantAssignmentsLink");
						selenium.click("ConsultantAssignmentsLink");
					}
					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("AdeccoBtn");
					selenium.click("AdeccoBtn");
				}
			catch (Exception e)
				{
				 	selenium.captureScreenShot();
				 	selenium.test.log(LogStatus.FAIL, "Error while navigating to CRF page in classic mode");
					selenium.reportFailure("Error while navigating to CRF page in classic mode" + e.getMessage());
				}
		}

		@Then("^navigate to mass search screen$")
		public void navigate_to_mass_search_screen()  {
			try
				{
					selenium.waitingTime(6000);
					selenium.captureScreenShot();
					selenium.switchToMultipleFrame("SoftPhoneRefreshFrame");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("MassSearchLink");
					selenium.click("MassSearchLink");			
				}
			 catch (Exception e)
				{
					selenium.test.log(LogStatus.FAIL, "Error while navigating to mass search screen");
					selenium.reportFailure("Error while navigating to mass search screen" + e.getMessage());
				}
		}

		@And("^create multiple samples$")
		public void create_multiple_samples()  {
			try
				{
					selenium.waitingTime(5000);
					selenium.switchOutOfFrame();
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("AccountFilterRadioBtn");
					selenium.click("AccountFilterRadioBtn");
					selenium.type("StateEntryField", "State");
					selenium.type("CountyEntryField", "County");
//					selenium.click("AccountTypeList");
//					String AccountTypeValue = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("AccountType");
//					Select dropdown = new Select(selenium.getElement("AccountTypeList"));
//					dropdown.selectByVisibleText(AccountTypeValue);
					selenium.click("AccountTypeList");
					selenium.waitForElementToBeClickable("AccountTypeOption");
					selenium.click("AccountTypeOption");
					selenium.click("SearchSampleBtn");
//					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("FirstSampleRecordChkbox");
					selenium.click("FirstSampleRecordChkbox");
					selenium.click("SecondSampleRecordChkbox");
					selenium.type("DefaultAttnLine","Default Attn Line");
					selenium.click("DefaultAttnLineBtn");
					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					selenium.click("ApplyMassFunctionBtn");
					selenium.waitForElementToBeClickable("SampleBtnInMassSample");
					selenium.click("SampleBtnInMassSample");
//					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("SampleBtnInMassSample");
					selenium.type("ISBNKeyAdd","ISBN");
					selenium.click("ISBNKeyAddBtn");
					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					selenium.waitForElementToBeClickable("Next_Btn");
					selenium.click("Next_Btn");
					selenium.waitForElementToBeClickable("CalculateAddressBtn");
					selenium.click("CalculateAddressBtn");
					selenium.waitingTime(4000);
					selenium.captureScreenShot();
					selenium.click("MassSampleCreateSampleOrderBtn");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentFast("DuplicateSamplePopup"))
					{
						selenium.test.log(LogStatus.INFO, "Sample already present and creating duplicate samples!");
						selenium.captureScreenShot();
						selenium.click("CreateDuplicateSampleBtn");
					}
					selenium.waitingTime(15000);
					selenium.test.log(LogStatus.PASS, "Multiple Samples created successfully through Mass Search!");
					System.out.println("PASS");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
			 catch (Exception e)
				{
					selenium.test.log(LogStatus.FAIL, "Error while creating multiple samples");
					selenium.reportFailure("Error while creating creating multiple samples" + e.getMessage());
				}
		}
}
