package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewSampleFromContactPage {

	
	WebConnector selenium = WebConnector.getInstance();
	
	
	@Then("^click on new Sample button$")
    public void click_on_new_sample_button() {
		
		try {
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("NewSampleContact");
			selenium.click("NewSampleContact");
			selenium.waitingTime(4000);
			selenium.switchToFrame("sampleContact");
			selenium.waitingTime(2000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
		}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while clicking on sample contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		
		}
	
}
	
	@Then("^verify account details on sample record$")
    public void verify_account_details_on_sample_record() {
	 
	 try {
//		 selenium.waitingTime(5000);
		 	//selenium.jsClick("sampleOnContactDetailsTab");
		 	selenium.waitingTime(4000);
		 	if(selenium.isElementPresentFast("sampleContactModified"))
		 	{
				selenium.waitForElementToBeClickable("sampleContactModified");
			 	selenium.jsClick("sampleContactModified");
		 	}
		 	else
		 	{
		 		selenium.refresh();
		 		selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("sampleContactModified");
			 	selenium.jsClick("sampleContactModified");
		 	}
		 	selenium.waitingTime(4000);
		 	selenium.captureScreenShot();
		 	selenium.waitingTime(2000);
		 	selenium.refresh();
		 	selenium.waitingTime(10000);
		 	String xpath=selenium.getDynamicXpath("spantextContains","ISBN","endContains");
		 	System.out.println(xpath);
//		 	selenium.waitForXpathElementToBeClickable(xpath);
		 	selenium.waitingTime(4000);
		 	selenium.clickXpath(xpath);
		 	selenium.test.log(LogStatus.INFO, "Clicked on sample record " );
		 	selenium.waitingTime(4000);
		 	selenium.captureScreenShot();
//		 	selenium.waitingTime(4000);
	 }
		 	 catch (Exception e) {
					selenium.reportFailure("Error while clicking on sample record " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}

		 	String accountName = selenium.getText("AccountNameonSampleDetails01").toString();
		 	String expected_AccountName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
		 	System.out.println("actual Account Name" + accountName );
		 	System.out.println("expected Account Name"  +expected_AccountName );
		 	if(accountName.equalsIgnoreCase(expected_AccountName)) {
		 		selenium.test.log(LogStatus.PASS, "Account name verified over sample order details page");
		 		
			} else {
				selenium.test.log(LogStatus.FAIL, "Account name not verified over sample order details page");
				selenium.reportFailure("Account name not verified over sample order details page");
				}
		 	selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("ProductNameOnSampleDetails");
		 	String productName= selenium.getText("ProductNameOnSampleDetails").toString();
		 	System.out.println(productName);
			
	 
	
 } 
	
	@When("^I navigate to ownership verification tab$")
	public void I_navigate_to_ownership_verification_tab()  {
		try {
			
		
		//selenium.waitingTime(7000);
		//selenium.click("accountTabClick");
			
		//selenium.clickHeader(objectRepoElement);
		
//	    selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("menuDots");
		selenium.click("menuDots");
		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("searchItemsTextField");
		selenium.type("searchItemsTextField", "Ownership Verification");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("ownershipVerificationMenuDots");
		selenium.jsClick("ownershipVerificationMenuDots");
		selenium.waitingTime(5000);
		selenium.captureScreenShot();
		
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to Ownership Verivication " + e.getMessage());
			}

	}


	@And("^verify sample details from owner verification page$")
	public void verify_sample_details_from_owner_verification_page()  {

		
		
		try{
				selenium.waitingTime(2000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.isElementPresentXpathFast("//h2[@class='mainTitle']");				
				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("selectAccount");
				selenium.type("selectAccount", "Account Name");
				selenium.waitingTime(2000);
				selenium.selectFromLookUp("Account Name", "Account Name");
				
				selenium.waitingTime(5000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.isElementPresentXpathFast("//h2[@class='mainTitle']");
				selenium.waitingTime(5000);
				
				selenium.waitForElementToBeVisible("selectProduct");
				selenium.type("selectProduct", "Product Name");
				selenium.waitingTime(2000);
				selenium.selectFromLookUp("Product Name", "Product Name");
							
				selenium.waitingTime(5000);
				selenium.switchToFrame("OpportunityFrameNew");
				selenium.waitingTime(2000);
				selenium.jsClick("viewOwnershipButton");
				selenium.waitingTime(10000);
				selenium.captureScreenShot();
		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while searching owner details in Owners Verivication field " + e.getMessage());
		}
	}
	

	@Then("^fill address on account and orders details page$")
    public void fill_address_on_account_and_orders_details_page() {
		
		try{
		//selenium.captureScreenShot();
		selenium.waitingTime(6000);
		selenium.waitForElementToBeVisible("addressValueOnOrderPad");
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
		
		if(selenium.isElementPresentFast("errorMessageOnSampleAddress")==true) {
			selenium.jsClick("closeButtonOnSampleAddress");
		}
		selenium.waitForElementToBeClickable("saveButton");
		selenium.jsClick("saveButton");
		selenium.waitingTime(6000);
		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("NxtButton");
		selenium.jsClick("NxtButton");
		selenium.waitingTime(2000);
		}
	
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
				selenium.reportFailure("Error while filling address details " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				
			}
	
	
	
	}
	
	
	@Then("^add products by ISBN number$")
    public void add_products_by_ISBN_number() {
	 
	 try {
//		 selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("IsbnInput");
		 
			
			selenium.click("IsbnInput");
			selenium.waitingTime(2000);
			selenium.type("IsbnInput","ISBN");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addIsbnButton");
			selenium.click("addIsbnButton");
			
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("selectProductCheckbox");
			selenium.scrollToElement("selectProductCheckbox");
			selenium.click("selectProductCheckbox");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NxtButton");
			selenium.click("NxtButton");
			selenium.waitingTime(5000);
			
			
	 }
	 catch (Exception e) {
		 selenium.switchBackToParentWindow();
			selenium.reportFailure("Error while adding product" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

}
}