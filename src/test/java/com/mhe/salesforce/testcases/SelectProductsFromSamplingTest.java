package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.cucumber.datatable.DataTable;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectProductsFromSamplingTest {
	
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;
	String expected_status;
	String oppContact;
	String addressURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Address__c/a0Z800000018RA0EAM/view";
	String newSampleURL;
	String LeadDate = null;
	String sourceOppNameinSourceOpp = null;
	String sourceOppNameinNewOpp = null;
	String newOppName = null;
	String resampleURL = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Sample__c/a0v0y00000X5PsLAAV/view";
	String ContactURLToCreateINTLSample = "https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002ZjjqfAAB/view";
	String OppGridURL = null;
			
	@And("^Select a contact and click on Sample Contact Button$")
	public void click_sample_button() {
		try {
			if (selenium.getUI().contains("Lightning")) {
//				selenium.waitingTime(3000);
/*				selenium.waitForElementToBeClickable("campaignFromDrpDwn");
				selenium.click("campaignFromDrpDwn");
				selenium.waitingTime(2000);
				String nameXpath = selenium.getDynamicXpath("spanTitle", "Contacts Dropdown" , "end");
				selenium.scrollToXpathElement(nameXpath);
				selenium.clickXpath(nameXpath);
				selenium.waitingTime(2000);
				
				selenium.search("Contact Name");
				selenium.waitingTime(7000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
				selenium.clickLoopXpath(Xpath);*/
				
//				selenium.waitingTime(7000);
//				selenium.navigateToURL(ContactUrl);
//				selenium.waitingTime(7000);
				
				
				selenium.waitingTime(4000);
				url=selenium.getURL();
				selenium.waitForElementToBeClickable("sampleContactButton");
				selenium.click("sampleContactButton");
				selenium.waitingTime(2000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.jsClick("searchProductsBtn");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("mheCourse");

				selenium.clearText("mheCourse");
				selenium.type("mheCourse", "MHE Course");
				selenium.waitingTime(2000);
				String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.click("searchBtn");
				selenium.waitingTime(10000);
				
				String checkBox = selenium.getDynamicXpath("divText", "Author Name", "productCheckBoxDynamic");
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(checkBox);
				selenium.waitForElementToBeClickable("addToSampleAndCloseBtn");
				selenium.clickLoop("addToSampleAndCloseBtn");
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
//				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("createSampleOrderBtn");
				selenium.jsClick("createSampleOrderBtn");
				selenium.waitingTime(5000);
				if(selenium.getElement("duplicateSamplePopup").isDisplayed()==true) {
					selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
					selenium.click("dupOverrideOptionCheckBox");
					selenium.waitForElementToBeClickable("duplicateOKButton");
					selenium.click("duplicateOKButton");
				}
				selenium.waitingTime(4000);
				selenium.switchOutOfFrame();
				//selenium.waitForElementsToBeVisible("sampleLink");
				selenium.navigateToURL(url);
				for(int i=0; i<=50;i++) {
					if(selenium.waitForElementToBeVisible("sampleLinknew")==false) {
						i++;
					}
					else {
						//selenium.refresh();
						//selenium.waitingTime(8000);
						selenium.waitForElementToBeClickable("sampleLinknew");
						selenium.click("sampleLinknew");
						break;
					}
						
				}
				selenium.waitingTime(7000);
				String sample = selenium.getDynamicXpath("anchorTitlecontains", "Sample Contact Name", "endContains");
				selenium.waitingTime(4000);
				selenium.clickXpath(sample);
				String date = selenium.getText("sampleStatusDateGetText").toString();
				
				SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
				String todaysdate = sdf.format(new Date());
				System.out.println(todaysdate);
				if(date.equalsIgnoreCase(todaysdate)) {
					selenium.test.log(LogStatus.PASS, "Sample contact created successfully today");
				}
					

			}

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			e.printStackTrace();
			selenium.reportFailure("Test Case Failed" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^add new sample contact and validate the SFDC status \\\"([^\\\"]*)\\\"$")
	public void add_new_sample_contact_and_validate_the_SFDC_status(String Expected_Address)
	{
		try
			{
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002F5uZdAAJ/view");
				selenium.waitingTime(4000);
				if(selenium.isElementPresentFast("CallAlertPopup"))
				{
					System.out.println("Call Alert Poped-up.. so closing it..");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.click("CloseNotificationPopup");
					selenium.waitingTime(2000);
						if(selenium.isElementPresentFast("CloseNotificationPopup")){ //two alert pop-up present
						selenium.click("CloseNotificationPopup");
						selenium.waitingTime(2000);}
				}
				selenium.waitForElementToBeClickable("sampleContactButton");
				selenium.click("sampleContactButton");
				selenium.waitingTime(5000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("searchProductsBtn");
				selenium.jsClick("searchProductsBtn");
				selenium.waitForElementToBeClickable("clearButton");
				selenium.click("clearButton");
				selenium.type("copyrightField", "Copyright");
				selenium.waitingTime(2000);
				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleRecordStatusMHeBook"))
				{
					selenium.waitForElementToBeClickable("mheBookOnlyChbx");
					selenium.click("mheBookOnlyChbx");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleRecordStatusVitalSource"))
				{
					selenium.waitForElementToBeClickable("vitalSourceOnlyChbx");
					selenium.click("vitalSourceOnlyChbx");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleRecordStatusCoreProduct"))
				{
					selenium.waitForElementToBeClickable("coreProductOnlyChbx");
					selenium.click("coreProductOnlyChbx");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.click("searchBtn");
				selenium.waitingTime(5000);
				String AuthorName = "Schultz";
//				String checkBox = selenium.getDynamicXpath("divText", "Author Name", "productCheckBoxDynamic");
				String checkBox = selenium.getDynamicXpathData("divText", AuthorName, "productCheckBoxDynamic");
				System.out.println(checkBox);
				selenium.clickLoopXpath(checkBox);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("addToSampleAndCloseBtn");
				selenium.clickLoop("addToSampleAndCloseBtn");
				selenium.waitForElementToBeClickable("ClickNextButton");
				selenium.click("ClickNextButton");
				selenium.waitingTime(5000);

				selenium.waitForElementToBeVisible("sampleAddress");
				selenium.scrollToElement("sampleAddress");
				String sampleAddress = selenium.getText("sampleAddress").toString();
				System.out.println("The current sample address is : " + sampleAddress);
//				String Expected_Address = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Expected Address");
				System.out.println("The execpted sample address is : " + Expected_Address);

				if (sampleAddress.contains(Expected_Address))
					{
						selenium.test.log(LogStatus.PASS,"The sample address is a Contact Preferred Address");
						System.out.println("PASS");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
				else
					{
						selenium.test.log(LogStatus.FAIL, "The sample address is not a Contact Preferred Address");
						System.out.println("FAIL");
						selenium.reportFailure("The sample address is not a Contact Preferred Address");
					}
				selenium.waitForElementToBeClickable("createSampleOrderBtn");				
				selenium.click("createSampleOrderBtn");
				selenium.waitingTime(10000);	
//				selenium.refresh();
//				selenium.waitingTime(5000);				
				if(selenium.isElementPresentFast("duplicateSamplePopup"))
				{
					selenium.test.log(LogStatus.INFO, "Duplicate Sample Popup Appeared.");
					selenium.captureScreenShot();
					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
					selenium.click("dupOverrideOptionCheckBox");
					selenium.waitForElementToBeClickable("duplicateOKButton");
					selenium.click("duplicateOKButton");
					selenium.waitingTime(5000);
				}
				selenium.waitingTime(5000);	
				selenium.waitForElementToBeClickable("sampleLinknew");
				selenium.click("sampleLinknew");
				selenium.waitingTime(5000);	
				selenium.waitForElementToBeClickable("sampleRecordTable");
				selenium.jsClick("sampleRecordTable");
				selenium.waitingTime(5000);	
				selenium.waitForElementToBeVisible("SFDCstatusAfterSampling01");
				selenium.scrolldown(100);
			 	String status = selenium.getText("SFDCstatusAfterSampling01").toString();
			 	System.out.println("actual status" + status);
			 	expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SFDC Status");
			 	System.out.println("expected status"  + expected_status);

			 	if(status.equalsIgnoreCase(expected_status))
				 	{
				 		selenium.test.log(LogStatus.PASS, "SFDC status verified successfully");
				 		System.out.println("PASS");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
			 	else
				 	{
						selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
						selenium.reportFailure("SFDC status is not proper");
						System.out.println("FAIL");
					}
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying the address type or SFDC status.");
				selenium.reportFailure("Error while verifying the address type or SFDC status" + e.getMessage());
			}
	}

	@Then("^update the account price class$")
	public void update_the_account_price_class()
	{
		try
			{
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("PriceClassIcon");
//				selenium.scrollToElement("PriceClassIcon");
				selenium.click("PriceClassIcon");
				selenium.type("PriceClassTextBox","Price Class");
				selenium.click("Save_Btn");
				selenium.waitingTime(4000);				
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while updating the account price class");
				selenium.reportFailure("Error while updating the account price class" + e.getMessage());
			}
	}

	@Then("^navigate to the desired contact$")
	public void navigate_to_the_desired_contact()
	{
		try
			{
//				selenium.refresh();
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("contactLink");
//				selenium.scrollToElement("contactLink");
				selenium.click("contactLink");
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.refresh();
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("firstSampleRecordNew");
				selenium.jsClick("firstSampleRecordNew");
				selenium.waitingTime(6000);			
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while navigating to the desired contact");
				selenium.reportFailure("Error while navigating to the desired contact" + e.getMessage());
			}
	}

	@Then("^create INTL sample for the contact$")
	public void create_INTL_sample_for_the_contact()
	{
		try
			{
				selenium.waitForElementToBeClickable("INTLAddSampleBtn");
				selenium.click("INTLAddSampleBtn");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
//				selenium.type("author", "Author Name");
//				selenium.waitingTime(1000);
//				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleStatusForAllowedUser"))
//				{
					selenium.type("SampleISBN", "ISBN");
					selenium.waitingTime(1000);
//				}
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				selenium.waitingTime(3000);
				selenium.click("Addtosampleandcontinue");
				selenium.waitForElementToBeClickable("samplereview");
				selenium.selectDropdownText("SFDCStatusDropDwn","SFDC Status");
				selenium.selectDropdownText("ShipPriorityDropDwn","Ship Priority");
				selenium.waitingTime(3000);
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
				}
				selenium.waitingTime(10000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while creating INTL sample for the contact");
				selenium.reportFailure("Error while creating INTL sample for the contact" + e.getMessage());
			}
	}

	@Then("^create INTL sample and validate address$")
	public void create_INTL_sample_and_validate_address()
	{
		try
			{
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002ZjrEmAAJ/view"); //due to duplicate contact "Greg White" I am hard coding the url
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("INTLAddSampleBtn"))
				{
					selenium.click("INTLAddSampleBtn");
				}
				else
				{
					selenium.waitForElementToBeClickable("moreActionsBtn");
					selenium.click("moreActionsBtn");
					selenium.waitForElementToBeClickable("INTL_Add_Sample1");
					selenium.click("INTL_Add_Sample1");
				}
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
//				selenium.type("author", "Author Name");
				selenium.type("SampleISBN", "ISBN");
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				selenium.waitForElementToBeClickable("AddressTabInINTLSample");
				selenium.click("AddressTabInINTLSample");
				selenium.waitingTime(4000);
				selenium.scrolldown(200);
				String address = selenium.getText("AddressTextInINTLSample1");
				System.out.println("address is " + address);
				if(!address.isEmpty())
				{
					selenium.test.log(LogStatus.PASS, "Address Appeared");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Address Did Not Appear");
					selenium.reportFailure("Address Did Not Appear");
					System.out.println("FAIL");
				}
				selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating address while creating INTL sample ");
				selenium.reportFailure("Error while validating address while creating INTL sample" + e.getMessage());
			}
	}

	@And("^verify invalid country validation$")
	public void verify_invalid_country_validation()
	{
		try
			{
				selenium.waitForElementToBeClickable("Addtosampleandcontinue");
				selenium.click("Addtosampleandcontinue");
				selenium.waitForElementToBeClickable("samplereview");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);

				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
				}
				selenium.waitingTime(10000);

				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Invalid Country Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.PASS, "Please select a Valid Address having country - Validation Message Appearead");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Please select a Valid Address having country - Validation Message Did Not Appear");
					selenium.reportFailure("Please select a Valid Address having country - Validation Message Did Not Appear");
					System.out.println("FAIL");
				}
				selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying invalid country validation message while creating INTL sample ");
				selenium.reportFailure("Error while verifying invalid country validation message while creating INTL sample" + e.getMessage());
			}
	}

	@Then("^create INTL sample and verify virtalsource product validation$")
	public void create_INTL_sample_and_verify_virtalsource_product_validation()
	{
		try
			{
				selenium.contactURLForSampling = selenium.getURL();
				System.out.println("The selenium.contactURLForSampling URL is :" + selenium.contactURLForSampling);
				selenium.waitForElementToBeClickable("INTLAddSampleBtn");
				selenium.click("INTLAddSampleBtn");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				selenium.type("author", "Author Name");
				selenium.type("SampleISBN", "ISBN");
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				selenium.waitingTime(2000);
				selenium.click("Addtosampleandcontinue");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("samplereview");
				selenium.selectDropdownText("SFDCStatusDropDwn","SFDC Status");
				selenium.selectDropdownText("ShipPriorityDropDwn","Ship Priority");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Vitalsource Platform Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.PASS, "Vitalsource Platform Validation Message Appearead");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Vitalsource Platform Validation Message Did Not Appear");
					selenium.reportFailure("Vitalsource Platform Validation Message Did Not Appear");
					System.out.println("FAIL");
				}
				selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating virtalsource product validation message");
				selenium.reportFailure("Error while validating virtalsource product validation message" + e.getMessage());
			}
	}

	@Then("^create INTL sample and verify digital product validation$")
	public void create_INTL_sample_and_verify_digital_product_validation()
	{
		try
			{
				selenium.navigateToURL(selenium.contactURLForSampling);
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("INTLAddSampleBtn");
				selenium.click("INTLAddSampleBtn");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				selenium.type("author", "Author Name");
				selenium.type("SampleISBN", "ISBN2");
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				selenium.waitingTime(2000);
				selenium.click("Addtosampleandcontinue");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("samplereview");
				selenium.selectDropdownText("SFDCStatusDropDwn","SFDC Status");
				selenium.selectDropdownText("ShipPriorityDropDwn","Ship Priority");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Digital Product Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.PASS, "Vitalsource Platform Validation Message Appearead");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Vitalsource Platform Validation Message Did Not Appear");
					selenium.reportFailure("Vitalsource Platform Validation Message Did Not Appear");
					System.out.println("FAIL");
				}
				selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating virtalsource product validation message");
				selenium.reportFailure("Error while validating virtalsource product validation message" + e.getMessage());
			}
	}

	@And("^send email to product team$")
	public void send_email_to_product_team()
	{
		try
			{
				selenium.click("SendEmailToProdctTeamBtn");
				selenium.waitingTime(3000);
				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Email Sent Success Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.PASS, "Email has been sent succesfully");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Email to product team functionality did not work");
					selenium.reportFailure("Email to product team functionality did not work");
					System.out.println("FAIL");
				}
				selenium.waitingTime(2000);
				
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating virtalsource product validation message");
				selenium.reportFailure("Error while validating virtalsource product validation message" + e.getMessage());
			}
	}

	@And("^validate the contact status$")
	public void validate_the_contact_status()
	{
		try
			{
				selenium.waitingTime(15000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.jsClick("firstTableRecord");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(6000);
				selenium.waitForElementToBeVisible("EditsfdcstatusL");
				selenium.scrolldown(100);
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("EditsfdcstatusL");
				selenium.click("EditsfdcstatusL");
		 		selenium.waitingTime(5000);
				selenium.scrolldown(100);
		 		selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SampleSFDCStatusDropDwn");
				selenium.click("SampleSFDCStatusDropDwn");
//				selenium.waitingTime(2000);
//				selenium.click("SampleSFDCStatusDropDwn");
				selenium.waitingTime(2000);
				selenium.scrollToElement("ISBNReqStatusApproved");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ISBNReqStatusApproved");
				selenium.click("ISBNReqStatusApproved");
				selenium.waitingTime(2000);
				selenium.click("Save_Btn");
				selenium.waitingTime(5000);
				
				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleStatusForRestrictedUser"))
				{
					boolean error = selenium.isElementPresentFast("ErrorListAll");
					System.out.println(error);
					if (error == true) 
					{
				 		selenium.test.log(LogStatus.PASS, "User is NOT able to change the Sample SFDC status to Approved.");
				 		System.out.println("PASS");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
						selenium.jsClick("closePopUp");
						selenium.waitingTime(2000);
						selenium.click("CancelButton");
					}	
				}

				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleStatusForAllowedUser"))
				{
					selenium.waitForElementToBeVisible("SampleSFDCStatusText");
				 	String actualSFDCStatus = selenium.getText("SampleSFDCStatusText").toString();
				 	System.out.println("Actual SFDC Status" + actualSFDCStatus);
				 	expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New SFDC Status");
				 	System.out.println("Expected SFDC Status"  + expected_status);
	
				 	if(actualSFDCStatus.equalsIgnoreCase(expected_status))
					 	{
					 		selenium.test.log(LogStatus.PASS, "User is able to change the status to Approved. SFDC status verified successfully.");
					 		System.out.println("PASS");
					 		selenium.captureScreenShot();
					 		selenium.waitingTime(2000);
						}
				 	else
					 	{
							selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
							selenium.reportFailure("SFDC status is not proper");
							System.out.println("FAIL");
					 		selenium.captureScreenShot();
					 		selenium.waitingTime(2000);
						}
				}
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating the SFDC status");
				selenium.reportFailure("Error while validating the SFDC status" + e.getMessage());
			}
	}

	@Then("^validate the SFDC status when ship usage ID is not null$")
	public void validate_the_SFDC_status_when_ship_usage_ID_is_not_null()
	{
		try
			{
			
			if(selenium.isElementPresentFast("INTLAddSampleBtn"))
			{
				selenium.waitForElementToBeClickable("INTLAddSampleBtn");
				selenium.click("INTLAddSampleBtn");
			}
			else
			{
				selenium.waitForElementToBeClickable("moreActionsBtn");
				selenium.click("moreActionsBtn");
				selenium.waitForElementToBeClickable("INTLAddSampleOption");
				selenium.click("INTLAddSampleOption");
			}
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				selenium.type("author", "Author Name");
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectSecondProductChkBox");
				
//				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleRecordStatusApproved"))
//				{
					selenium.scrollToElement("ShipUsageIDAddress");
					selenium.click("ShipUsageIDAddress");
					selenium.waitForElementToBeClickable("ShipUsageIDAddress");
					String ShipUsageID = selenium.getText("ShipdUsageIDText").toString();
					System.out.println("Ship Usage ID is :" + ShipUsageID);
					if(ShipUsageID != "" || ShipUsageID != null)
					{
						selenium.test.log(LogStatus.PASS, "Address - 'Ship Usage ID' is not NULL");
						System.out.println("PASS");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "Address - 'Ship Usage ID' is NULL");
						selenium.reportFailure("Address - 'Ship Usage ID' is NULL");
						System.out.println("FAIL");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
//				}				
				selenium.scrollToElement("Addtosampleandcontinue");
				selenium.click("Addtosampleandcontinue");
				selenium.waitForElementToBeClickable("samplereview");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
				}
				selenium.waitingTime(10000);

			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating the SFDC status");
				selenium.reportFailure("Error while validating the SFDC status" + e.getMessage());
			}
	}

	@And("^validate the sample contact status$")
	public void validate_the_sample_contact_status()
	{
		try
			{
					selenium.waitForElementToBeClickable("firstTableRecord");
					selenium.click("firstTableRecord");
					selenium.waitingTime(4000);
					selenium.refresh();
					selenium.waitingTime(6000);
					selenium.waitForElementToBeVisible("SampleSFDCStatusText");
					newSampleURL = selenium.getURL();
					System.out.println("Newly created INTL Sample URL is : " + newSampleURL);
				 	String actualSFDCStatus = selenium.getText("SampleSFDCStatusText").toString();
				 	System.out.println("Actual SFDC Status" + actualSFDCStatus);
				 	expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New SFDC Status");
				 	System.out.println("Expected SFDC Status"  + expected_status);

				 	if(actualSFDCStatus.equalsIgnoreCase(expected_status))
					 	{
					 		selenium.test.log(LogStatus.PASS, "SFDC status is verified successfully!");
					 		System.out.println("PASS");
					 		selenium.scrolldown(50);
					 		selenium.captureScreenShot();
					 		selenium.waitingTime(2000);
						}
				 	else
					 	{
							selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
							selenium.reportFailure("SFDC status is not proper");
							System.out.println("FAIL");
							selenium.scrolldown(50);
					 		selenium.captureScreenShot();
					 		selenium.waitingTime(2000);
						}
			}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while validating the SFDC status");
			selenium.reportFailure("Error while validating the SFDC status" + e.getMessage());
		}
}

	@Then("^validate the SFDC status when ship usage ID is null for \"([^\"]*)\"$")
	public void validate_the_SFDC_status_when_ship_usage_ID_is_null(String ISBN)
	{
		try
			{
				selenium.navigateToURL(ContactURLToCreateINTLSample);
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("INTLAddSampleBtn"))
				{
					selenium.waitForElementToBeClickable("INTLAddSampleBtn");
					selenium.click("INTLAddSampleBtn");
				}
				else
				{
					selenium.waitForElementToBeClickable("moreActionsBtn");
					selenium.click("moreActionsBtn");
					selenium.waitForElementToBeClickable("INTLAddSampleOption");
					selenium.click("INTLAddSampleOption");
				}
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
				//selenium.type("author", "Author Name");
				selenium.typeData("Isbn13", ISBN);
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				
//				if(selenium.getTestCaseName().equalsIgnoreCase("validateSampleRecordStatusNADataError"))
//				{
					selenium.scrollToElement("ShipUsageIDAddress");
					selenium.click("ShipUsageIDAddress");
					selenium.waitForElementToBeClickable("ShipUsageIDAddress");
					selenium.waitForElementToBeClickable("EmptyShipUsageIDAddressRadioBtn");
					selenium.click("EmptyShipUsageIDAddressRadioBtn");
					String ShipUsageID = selenium.getText("ShipdUsageIDText").toString();
					System.out.println("Ship Usage ID is :" + ShipUsageID);
					if(ShipUsageID.length() == 0 || ShipUsageID == null)
					{
						selenium.test.log(LogStatus.PASS, "Address - 'Ship Usage ID' is NULL or Empty");
						System.out.println("PASS");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
					else
					{
						selenium.test.log(LogStatus.FAIL, "Address - 'Ship Usage ID' is not NULL");
						selenium.reportFailure("Address - 'Ship Usage ID' is not NULL");
						System.out.println("FAIL");
				 		selenium.captureScreenShot();
				 		selenium.waitingTime(2000);
					}
//				}				
				selenium.scrollToElement("Addtosampleandcontinue");
				selenium.click("Addtosampleandcontinue");
				selenium.waitForElementToBeClickable("samplereview");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
				}
				selenium.waitingTime(10000);

			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while validating the SFDC status");
				selenium.reportFailure("Error while validating the SFDC status" + e.getMessage());
			}
	}

	@And("^verify recreate sample functionality$")
	public void verify_recreate_sample_functionality()
	{
		try
			{
				selenium.waitingTime(4000);
				selenium.navigateToURL(resampleURL);
				selenium.waitingTime(6000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.waitForElementToBeClickable("ReSampleBtn");
				selenium.click("ReSampleBtn");
				selenium.waitingTime(6000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(2000);
				selenium.pressEscapeKey();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("CalendarTodayDate");
				selenium.click("CalendarTodayDate");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("AddressRadioBtn");
				selenium.click("AddressRadioBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Button_Save");
				selenium.click("Button_Save");
				selenium.waitingTime(8000);
				
				if(selenium.isElementPresentFast("DuplicateSampleMsgPopup"))
				{
					System.out.println("PASS");
					selenium.test.log(LogStatus.PASS, "Sample recreation successful!");
			 		selenium.click("NoBtnInDuplicateSample");
				}
				else
				{
					System.out.println("FAIL");
					selenium.test.log(LogStatus.FAIL, "Sample recreation failed!");
					selenium.reportFailure("Sample recreation failed!");
				}
				selenium.waitingTime(5000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying sample recreate functionality");
				selenium.reportFailure("Error while verifying sample recreate functionality" + e.getMessage());
			}
	}

	@Then("^navigate to opportunity contact$")
	public void navigate_to_opportunity_contact()
	{
		try
			{
		        if(selenium.getTestCaseName().equalsIgnoreCase("CloneOppAndVerifyData"))
		        {
		        	selenium.navigateToURL(selenium.MHHENewOppURLForSingleClone);
		        	selenium.waitingTime(8000);
		        }

				selenium.waitForElementToBeClickable("opportunityNameGetText");
				sourceOppNameinSourceOpp = selenium.getText("opportunityNameGetText");
				System.out.println("Source Opp Name in source opp :" + sourceOppNameinSourceOpp);

				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);

		        if(selenium.getTestCaseName().equalsIgnoreCase("validatePreferredSampleFormat"))
		        {
				oppContact =selenium.getURL();
				System.out.println("Opportunity Contact URL is : " + oppContact);
				selenium.test.log(LogStatus.INFO, "Opp. contact URL is : "+ oppContact);
				selenium.waitingTime(4000);
		        }
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while navigating to opportunity contact page");
				selenium.reportFailure("Error while navigating to opportunity contact page" + e.getMessage());
			}
	}

	@And("^I mass clone opportunity$")
	public void I_mass_clone_opportunity()
	{
		try
			{
	            selenium.waitForElementToBeVisible("RegionDropDownList");
	            String RegionName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Region");
	            Select dropdown = new Select(selenium.getElement("RegionDropDownList"));
	            dropdown.selectByVisibleText(RegionName);
	            
	            String SourceYear = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Source Year");
	            dropdown = new Select(selenium.getElement("SourceYearDropDownList"));
	            dropdown.selectByVisibleText(SourceYear);
	            
	            String SourceTerm = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Source Term");
	            dropdown = new Select(selenium.getElement("SourceTermDropDownList"));
	            dropdown.selectByVisibleText(SourceTerm);
	            
	            String NewYear = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New Year");
	            dropdown = new Select(selenium.getElement("NewYearDropDownList"));
	            dropdown.selectByVisibleText(NewYear);
	            
	            String NewTerm = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New Term");
	            dropdown = new Select(selenium.getElement("NewTermDropDownList"));
	            dropdown.selectByVisibleText(NewTerm);
	            
	            selenium.click("CreateMassOppBtn");
	            selenium.waitingTime(5000);
            	selenium.captureScreenShot();
            	selenium.waitingTime(2000);
            	selenium.waitForElementToBeClickable("CloningProgressLink");
            	selenium.jsClick("CloningProgressLink");
            	selenium.waitingTime(3000);
            	selenium.switchToLastWindow();
            	selenium.waitingTime(4000);
            	selenium.waitForElementToBeClickable("SubmitCloningBtn");
            	selenium.click("SubmitCloningBtn");
            	selenium.waitingTime(5000);
            	selenium.captureScreenShot();
            	selenium.waitingTime(2000);
				selenium.test.log(LogStatus.PASS, "Opp Mass Cloning Successful!");
		 		selenium.close();
		 		selenium.waitingTime(2000);
		 		selenium.switchBackToParentWindow();
		 		selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while mass cloning opp");
				selenium.reportFailure("Error while mass cloning opp" + e.getMessage());
			}
}

	@And("^verify the Handoff Required and Lead field in both opportunity contact$")
	public void verify_the_HandoffRequired_Lead_field()
	{
		try
			{
				selenium.newOppULR = selenium.getURL();
				System.out.println("newOppULR :" + selenium.newOppULR);
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("opportunityContactsLink");
				selenium.click("opportunityContactsLink");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("firstSampleRecordNew");
				selenium.jsClick("firstTableRecord");
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("ControlsCourse"))
				{
					System.out.println("Handoff Required fields are matching in both opp");
					selenium.test.log(LogStatus.PASS, "Handoff Required fields are matching in both opp!");
					System.out.println("PASS");
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Handoff Required fields are not matching!");
					selenium.reportFailure("Handoff Required fields are not matching!");
					System.out.println("FAIL");
			 		selenium.captureScreenShot();
				}

		 		selenium.waitingTime(2000);		 			
		 		String ClonedOppLeadDate = selenium.getText("OppContactLeadSubmittedOnDate").toString();
				System.out.println("Lead Submitted Date On Cloned Opp:" + ClonedOppLeadDate);
				System.out.println("Lead Submitted Date On Original Opp :" + LeadDate);
				
				if(LeadDate.contentEquals(ClonedOppLeadDate))
				{
					selenium.test.log(LogStatus.PASS, "Lead fields are matching in both opp!");
					System.out.println("PASS");
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Lead fields are not matching!");
					selenium.reportFailure("Lead fields are not matching!");
					System.out.println("FAIL");
				}
		 		
				selenium.waitingTime(2000);
		 		if(selenium.getTestCaseName().equalsIgnoreCase("OppListViewMassCloneAndVerifyData"))
		 		{
			 		selenium.close();
			 		selenium.waitingTime(3000);
			 		selenium.switchBackToParentWindow();
			 		selenium.waitingTime(3000);
		 		}

			}
		catch (Exception e)
			{
				if(selenium.getTestCaseName().equalsIgnoreCase("OppListViewMassCloneAndVerifyData"))
				{
			 		selenium.waitingTime(2000);
			 		selenium.close();
			 		selenium.waitingTime(2000);
			 		selenium.switchBackToParentWindow();
			 		selenium.waitingTime(2000);
				}
				selenium.test.log(LogStatus.FAIL, "Error while verifying handoff required field");
				selenium.reportFailure("Error while verifying handoff required field" + e.getMessage());
			}
	}

	@And("^verify source opp link in new opp and new opp link in source opp$")
	public void verify_opp_links()
	{
		try
		{
			selenium.navigateToURL(selenium.newOppULR);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("opportunityNameGetText");
			String newOppName = selenium.getText("opportunityNameGetText");
			System.out.println("New Opp Name in New Opp :" + newOppName);

			selenium.waitForElementToBeVisible("sourceoppText");
			sourceOppNameinNewOpp = selenium.getText("sourceoppText");
			System.out.println("Source Opp Name in New opp :" + sourceOppNameinNewOpp);
			System.out.println("Source Opp Name in Source opp :" + sourceOppNameinSourceOpp);

			if(sourceOppNameinNewOpp.equalsIgnoreCase(sourceOppNameinSourceOpp))
			{
				selenium.test.log(LogStatus.PASS, "Source opp name is present in New opp!");
				System.out.println("PASS");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Source opp name is NOT present in New opp!");
				selenium.reportFailure("Source opp name is NOT present in New opp!");
				System.out.println("FAIL");
			}
			selenium.navigateToURL(selenium.MHHENewOppURLForSingleClone);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("RelatedOppList");
			selenium.click("RelatedOppList");
			selenium.waitingTime(5000);
			
			String nameXpath = selenium.getDynamicXpathData("OppRelatedListOppNameStartingNew", newOppName , "endContains");
			selenium.scrollToXpathElement(nameXpath);
			selenium.clickXpath(nameXpath);
			selenium.waitingTime(2000);
			
			if(selenium.isElementPresentXpathFast(nameXpath))
			{
				selenium.test.log(LogStatus.PASS, "New opp name is present in Source opp!");
				System.out.println("PASS");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "New opp name is NOT present in Source opp!");
				selenium.reportFailure("New opp name is NOT present in Source opp!");
				System.out.println("FAIL");
			}
			
			selenium.navigateToURL(selenium.newOppULR);
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying source opp link in new opp and new opp link in source opp");
			selenium.reportFailure("Error while verifying source opp link in new opp and new opp link in source opp" + e.getMessage());
		}
	}

	@Then("^edit Handoff Required field$")
	public void edit_Handoff_Required_field()
	{
		try
		{
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("ControlsCourse"))
			{
				System.out.println("ControlsCourse is already been selected.");
			}
			else
			{
				selenium.waitForElementToBeClickable("HandoffRequiredEditIcon");
				selenium.click("HandoffRequiredEditIcon");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("HandoffRequiredList");
				selenium.click("HandoffRequiredList");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("HandoffRequiredValue");
				selenium.click("HandoffRequiredValue");
				selenium.waitingTime(2000);
				selenium.click("Save_Btn");
				selenium.waitingTime(15000);
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
//			if(selenium.getTestCaseName().equalsIgnoreCase("CloneOppAndVerifyData"))
//			{
//			selenium.navigateToURL(cloneOppULR);
//			selenium.waitingTime(5000);
//			}
			
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while editing handoff required field in opp contact");
			selenium.reportFailure("Error while editing handoff required field in opp contact");
		}
	}

	@Then("^edit Lead and Lead Submitted On field$")
	public void edit_Lead_field()
	{
		try
		{
			selenium.waitForElementToBeClickable("OppContactLeadEditIcon");
			
			LeadDate = selenium.getText("OppContactLeadSubmittedOnDate").toString();
			System.out.println("Lead Submitted On Date:" + LeadDate);

//			if(LeadDate != null || LeadDate != "")
			if(!LeadDate.isEmpty())
			{
				System.out.println("Lead submitted data is already been selected.");
			}
			else
			{
				selenium.waitForElementToBeClickable("OppContactLeadEditIcon");
				selenium.click("OppContactLeadEditIcon");
				selenium.waitingTime(6000);
				selenium.waitForElementToBeClickable("OppContactLeadCheckbox");
				selenium.clickLoop("OppContactLeadCheckbox");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("OppContactLeadSubmittedOn");
				selenium.click("OppContactLeadSubmittedOn");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NeedByDateToday2");
				selenium.click("NeedByDateToday2");
				selenium.waitingTime(2000);
				selenium.click("Save_Btn");
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("OppContactLeadEditIcon");
				LeadDate = selenium.getText("OppContactLeadSubmittedOnDate").toString();
				System.out.println("Lead Submitted On Date:" + LeadDate);
			}
			selenium.captureScreenShot();
			selenium.waitingTime(2000);		
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while editing lead field in opp contact");
			selenium.reportFailure("Error while editing lead field in opp contact");
		}
	}
	
	@And("^add new opp contact if not exist \"([^\"]*)\"$")
	public void add_new_opp_contact_if_not_exist(String name) {
		try
		{
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(15000);
			selenium.waitForElementToBeClickable("taggedProductAddorEdit");
			if(!selenium.isElementPresentFast("firstOppContactRecord"))
			{
				selenium.captureScreenShot();
				System.out.println("No Contact exist for this opportunity. So adding one..");
				selenium.test.log(LogStatus.INFO, "Creating New Opp. Contact");
				selenium.jsClick("taggedProductAddorEdit");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeVisible("productframeUat");
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("OppContactFirstName");
				selenium.typeData("OppContactFirstName", name);
				selenium.waitForElementToBeClickable("searchBtn");
				selenium.jsClick("searchBtn");
				selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
			    selenium.jsClick("opportunitiesSearchResultForAdding");
				selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
				selenium.scrollToElement("opportunitiesAddToOpportunity");
				selenium.jsClick("opportunitiesAddToOpportunity");
				selenium.waitForElementToBeVisible("Button_Save");
				selenium.scrollToElement("Button_Save");
				selenium.jsClick("Button_Save");
				selenium.switchOutOfFrame();
				selenium.waitingTime(12000);
				selenium.navigateToURL(oppContact);
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(6000);
			}
			else
			{
				System.out.println("Opp contact is alread exist.. so not adding new one.");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding contact for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding contact for opportunity");
		}
	}

	@And("^add new opp \"([^\"]*)\" for MHHE Opp$")
	public void add_new_opp_contact_for_MHHE_Opp(String name) {
		try
		{
//			selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068H000006khWnQAI/view");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");				
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.test.log(LogStatus.INFO, "Creating New Opp. Contact");
			selenium.waitForElementToBeClickable("productAddOrEdit");
			selenium.jsClick("productAddOrEdit");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("productframeUat");
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("OppContactFirstName");
			selenium.typeData("OppContactFirstName", name);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");
			selenium.jsClick("searchBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunitiesSearchResultForAdding");
		    selenium.jsClick("opportunitiesSearchResultForAdding");
		    selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("opportunitiesAddToOpportunity");
			selenium.scrollToElement("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.jsClick("opportunitiesAddToOpportunity");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Button_Save");
			selenium.scrollToElement("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.switchOutOfFrame();
			selenium.waitingTime(12000);
			selenium.test.log(LogStatus.INFO, "Created New Opp. Contact");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding contact for opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding contact for opportunity");
		}
	}
	
	@And("^verify the editorial section in opp contact$")
	public void verify_the_editorial_section_in_opp_contact() {
		try
		{
			selenium.navigateToURL(selenium.MHHEOppToTestEditorialSection);
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OpportunityContactClick1");				
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("firstTableRecord");				
			selenium.jsClick("firstTableRecord");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("EditorialSection");
			selenium.scrollToElement("EditorialSection");
			selenium.waitingTime(3000);
			
			if(selenium.isElementPresentFast("ReviewInterestField") && selenium.isElementPresentFast("AuthorshipInterestField") && selenium.isElementPresentFast("OtherInterestsField") && selenium.isElementPresentFast("ReviewInterestSubtopicField") && selenium.isElementPresentFast("AuthorshipInterestSubtopicField") && selenium.isElementPresentFast("AdditionalNotesField"))
			{
				selenium.test.log(LogStatus.PASS, "All the expected fields are there in Editorial section!");
				System.out.println("PASS");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "One or more expected fields are missing in Editorial section");
				selenium.reportFailure("One or more expected fields are missing in Editorial section");
				System.out.println("FAIL");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifing editorial section in opp contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing editorial section in opp contact");
		}
	}
	
	@And("^verify the match opportunity year validation when purchase date is less than 2017$")
	public void verify_the_match_opportunity_year_validation(DataTable table) {
		try
		{
			List<String> data = table.transpose().asList(String.class);
			
			selenium.navigateToURL(data.get(0));
			selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("purchaseDateopp2");
			String oppPurchaseDate = selenium.getText("purchaseDateopp2");	//purchase date should be less than 2017 for this test
			System.out.println("Opp Purchase Date is :" + oppPurchaseDate);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("editButton"))
			{
				selenium.test.log(LogStatus.PASS, "The match opportunity year validation did not trigger for opp which has purchase date less than 1/1/2017");
				System.out.println("PASS");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The match opportunity year validation triggered for opp which has purchase date less than 1/1//2017 ");
				selenium.reportFailure("The match opportunity year validation triggered for opp which has purchase date less than 1/1//2017");
				System.out.println("FAIL");
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifing match opp year validation message " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing match opp year validation message");
		}
	}

	@And("^verify the MHHE Links$")
	public void verify_the_MHHE_Links() {
		try
		{
			selenium.waitForElementToBeClickable("MHHELinks");
			selenium.click("MHHELinks");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("InternalCodeRequestFormLink");
			
			if((!selenium.isElementPresentFast("MHELeadFormLink")) && selenium.isElementPresentFast("InternalCodeRequestFormLink"))
			{
				selenium.test.log(LogStatus.PASS, "MHE Lead Form link is not present & Internal Code Request Form link is present");
				System.out.println("PASS");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Verification failed");
				selenium.reportFailure("Verification failed");
				System.out.println("FAIL");
			}
			
			selenium.jsClick("InternalCodeRequestFormLink");
			selenium.waitingTime(3000);
			selenium.switchToChildWindow();
			String actualURL = selenium.getURL();
			String expectedURL = selenium.getTestDataFromPropertiesFile("InternalCodeRequestForm_URL");
			if(actualURL.equalsIgnoreCase(expectedURL))
			{
				selenium.test.log(LogStatus.PASS, "Navigated to correct URL");
				System.out.println("PASS");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Incorrect URL");
				selenium.reportFailure("Incorrect URL");
				System.out.println("FAIL");
			}
			selenium.close();
			selenium.waitingTime(2000);
			selenium.switchBackToParentWindow();
			selenium.waitingTime(2000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifing MHHE links " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifing MHHE links");
		}
	}

	@And("^edit the editorial section field values$")
	public void edit_the_editorial_section_field_values(DataTable table) {
		try
		{
			List<String> data = table.transpose().asList(String.class);
			
			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyEditorialSectionInOppContactByMHHEBusinessAdmin"))
			{
				selenium.waitForElementToBeClickable("EditReviewInterest");
				selenium.click("EditReviewInterest");
				selenium.clickDynamicData("spanTitle", data.get(0), "end");
				selenium.click("AddReviewInterestSubtopic");
				selenium.clickDynamicData("spanTitle", data.get(4), "end");
				selenium.click("AddReviewInterest");
				selenium.clickDynamicData("spanTitle", data.get(1), "end");
				selenium.click("AddAuthorshipInterest");
				selenium.clickDynamicData("spanTitle", data.get(3), "end");
				selenium.click("AddAuthorshipInterestSubtopic");
				selenium.clickDynamicData("spanTitle", data.get(2), "end");
				selenium.click("AddOtherInterests");
				selenium.typeData("AddAdditionalNotes",data.get(5));
				selenium.click("Save_Btn");
				selenium.waitingTime(8000);
				selenium.test.log(LogStatus.INFO, "MHHE Business Admin User is able to edit editorial section values in opp contact");
			}
			else if(selenium.getTestCaseName().equalsIgnoreCase("VerifyEditorialSectionInOppContactByMHHEContractAdmin"))
			{
				if(selenium.isElementPresentFast("EditReviewInterest"))
				{
					selenium.test.log(LogStatus.FAIL, "MHHE Contract Admin is able to edit the fields of Editorial section");
					selenium.reportFailure("MHHE Contract Admin is able to edit the fields of Editorial section");
					System.out.println("FAIL");
				}
				else
				{
					selenium.test.log(LogStatus.PASS, "MHHE Contract Admin is NOT able to edit the fields of Editorial section");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			}			
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while editing editorial section values in opp contact " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while editing editorial section values in opp contact");
		}
	}

	@And("^edit the Preferred Sample Format field in contact$")
	public void edit_the_Preferred_Sample_Format_field_in_contact()
	{
		try
			{
				selenium.waitingTime(6000);
				String Xpath = selenium.getDynamicXpath("anchorTitle", "Contact Name", "end");
				System.out.println(Xpath);
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(10000);
//				selenium.scrolldown(300);
				selenium.scrollToElement("PreferredSampleFormatEditBtn");
				selenium.waitingTime(2000);
				selenium.scrolldown(-200);
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("PreferredSampleFormatEditBtn");
				selenium.clickLoop("PreferredSampleFormatEditBtn");
				selenium.waitForElementToBeClickable("PreferredSampleFormatList");
				selenium.click("PreferredSampleFormatList");
				selenium.waitForElementToBeClickable("PreferredSampleFormatListOption");
				selenium.waitingTime(2000);
				selenium.click("PreferredSampleFormatListOption");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while editing Preferred Sample Format field");
				selenium.reportFailure("Error while editing Preferred Sample Format field" + e.getMessage());
			}
	}

	@Then("^I mass clone opportunity in opp list view$")
	public void I_mass_clone_opportunity_in_opp_list_view()
	{
		try
		{
			selenium.waitForElementToBeClickable("FirstRecordCheckbox");
			selenium.click("FirstRecordCheckbox");
			selenium.waitingTime(2000);

			if(selenium.isElementPresentFast("CallAlertPopup"))
			{
				System.out.println("Call Alert Poped-up.. so closing it..");
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.click("CloseNotificationPopup");
				selenium.waitingTime(2000);
			}

			selenium.waitForElementToBeClickable("opportunityMenuToCreateSample");
			selenium.click("opportunityMenuToCreateSample");
			selenium.waitForElementToBeClickable("MassCloneOption");
			selenium.click("MassCloneOption");

			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("NewYearDropDownList");
            String NewYear = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New Year");
            Select dropdown = new Select(selenium.getElement("NewYearDropDownList"));
            dropdown.selectByVisibleText(NewYear);
            
            String NewTerm = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("New Term");
            dropdown = new Select(selenium.getElement("NewTermDropDownList"));
            dropdown.selectByVisibleText(NewTerm);
            
            selenium.click("CreateMassOppBtn");
            selenium.waitingTime(5000);
        	selenium.captureScreenShot();
        	selenium.waitingTime(20000);
        	selenium.waitForElementToBeClickable("CloningProgressLink");
        	selenium.jsClick("CloningProgressLink");
        	selenium.waitingTime(3000);
        	selenium.switchToLastWindow();
        	selenium.waitingTime(6000);
        	selenium.captureScreenShot();
        	selenium.waitingTime(4000);
			selenium.test.log(LogStatus.PASS, "Opp Mass Cloning Successful!");
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Cloned Opp", "endContains");
			System.out.println("Cloned Opp xpath is : " + Xpath);
			selenium.scrolldown(1000);
			selenium.waitingTime(4000);
			if(selenium.isElementPresentXpathFast(Xpath))
			{
			selenium.clickLoopXpath(Xpath);
			}
			else
			{
	        	selenium.waitingTime(30000);
	        	selenium.refresh();
	        	selenium.waitingTime(15000);
				selenium.scrolldown(1000);
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(Xpath);
			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while mass cloning opp in opp list view page");
			selenium.reportFailure("Error while mass cloning opp in opp list view page" + e.getMessage());
		}
	}

	@And("^verify the Preferred Sample Format field in opportunity contact$")
	public void verify_the_Preferred_Sample_Format_field_in_opportunity_contact()
	{
		try
			{
				selenium.navigateToURL(oppContact);
				System.out.println("Opportunity Contact URL is : " + oppContact);
				selenium.test.log(LogStatus.INFO, "Opp. contact URL is : "+ oppContact);
				String Xpath = selenium.getDynamicXpath("spantextContains", "Opp Contact Name", "endContains");		//span[contains(text(),'NICK MCFADDEN Biology Majors JAIME KLAR')]
				System.out.println(Xpath);
				selenium.waitingTime(2000);
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
				if(selenium.isElementPresentFast("PreferredSampleFormatUpdatedValue"))
				{
					selenium.test.log(LogStatus.PASS, "Preferred Sample Format verified successful!");
					System.out.println("PASS");
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
				else
				{
					selenium.test.log(LogStatus.FAIL, "Preferred Sample Format value did not match!");
					selenium.reportFailure("Preferred Sample Format value did not match!");
					System.out.println("FAIL");
			 		selenium.captureScreenShot();
				}
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying Preferred Sample Format value");
				selenium.reportFailure("Error while verifying Preferred Sample Format value" + e.getMessage());
			}
	}

	@Then("^remove the ship usage id in address$")
	public void remove_the_ship_usage_id_in_address()
	{
		try
			{
//				addressURL= selenium.getURL();
				selenium.navigateToURL(addressURL);
//				System.out.println("Address URL is : " + addressURL);
				selenium.waitingTime(5000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.scrollToElement("ShipUsageIDEdit");
				selenium.waitForElementToBeClickable("ShipUsageIDEdit");
				
				if(selenium.isElementPresentFast("ShipUsageIDEdit"))
				{
					selenium.click("ShipUsageIDEdit");
					System.out.println("Ship usage ID is not blank so making it blank");
					selenium.clearText("ShipUsageIDTextField");
					selenium.captureScreenShot();
					selenium.waitingTime(2000);
					selenium.click("Save_Btn");
					selenium.waitingTime(5000);
				}
				else
				{
					System.out.println("Ship usage ID is already blank so just saving the address");
					selenium.click("Save_Btn");
					selenium.waitingTime(5000);
				}
				
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while updating ship usage id in address");
				selenium.reportFailure("Error while updating ship usage id in address" + e.getMessage());
			}
	}

	@Then("^add the ship usage id back in address$")
	public void add_the_ship_usage_id_back_in_address()
	{
		try
			{
				selenium.navigateToURL(addressURL);
				System.out.println("Address URL is : " + addressURL);
				selenium.waitingTime(6000);
//				selenium.refresh();
//				selenium.waitingTime(8000);
				selenium.waitForElementToBeVisible("ShipUsageIDEdit");
				selenium.scrollToElement("ShipUsageIDEdit");
				selenium.waitForElementToBeClickable("ShipUsageIDEdit");
				selenium.click("ShipUsageIDEdit");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("ShipUsageIDTextField");
				selenium.type("ShipUsageIDTextField", "Ship Usage ID");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("Save_Btn");
				selenium.click("Save_Btn");
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("Save_Btn"))
				{
					selenium.click("Save_Btn");
					selenium.waitingTime(10000);
				}
//				selenium.scrollToElement("ShipUsageIDEdit");
//				selenium.captureScreenShot();
//				selenium.waitingTime(2000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while updating ship usage id in address");
				selenium.reportFailure("Error while updating ship usage id in address" + e.getMessage());
			}
	}

	@And("^validate the SFDC status after adding ship usage ID to address$")
	public void validate_the_SFDC_status_after_adding_ship_usage_ID_to_address()
	{
		try
			{
			selenium.waitingTime(2000);
			selenium.navigateToURL(newSampleURL);
			System.out.println("Navigated to newly created sample URL : " + newSampleURL);
		 	String actualSFDCStatus = selenium.getText("SampleSFDCStatusText").toString();
		 	System.out.println("Actual SFDC Status" + actualSFDCStatus);
		 	expected_status = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Updated SFDC Status");
		 	System.out.println("Expected SFDC Status"  + expected_status);

		 	if(actualSFDCStatus.equalsIgnoreCase(expected_status))
			 	{
			 		selenium.test.log(LogStatus.PASS, "SFDC status is verified successfully!");
			 		System.out.println("PASS");
			 		selenium.scrolldown(50);
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}
		 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "SFDC status is not proper");
					selenium.reportFailure("SFDC status is not proper");
					System.out.println("FAIL");
					selenium.scrolldown(50);
			 		selenium.captureScreenShot();
			 		selenium.waitingTime(2000);
				}

			}
		catch (Exception e)
			{
			selenium.test.log(LogStatus.FAIL, "Error while verifying the ship usage id");
			selenium.reportFailure("Error while verifying the ship usage id" + e.getMessage());
			}
	}

	@Then("^create INTL sample for contact$")
	public void create_INTL_sample_for_contact()
	{
		try
			{
				String ISBN = "9781265621018";
				selenium.waitForElementToBeClickable("INTLAddSampleBtn");
				selenium.click("INTLAddSampleBtn");
				selenium.waitingTime(4000);
				selenium.refresh();
				selenium.waitingTime(8000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(4000);
//				selenium.type("author", "Author Name");
				selenium.typeData("Isbn13", ISBN);
				selenium.waitForElementToBeClickable("SearchProduct");
				selenium.click("SearchProduct");
				selenium.waitingTime(5000);
				selenium.click("SelectFirstProductChkBox");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("Addtosampleandcontinue");
				selenium.click("Addtosampleandcontinue");
				selenium.waitingTime(5000);

			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while creating INTL Sample");
				selenium.reportFailure("Error while creating INTL Sample" + e.getMessage());
			}
	}

	@And("^verify the address with no country validation$")
	public void verify_the_address_with_no_country_validation()
	{
		try
			{
				selenium.waitForElementToBeClickable("samplereview");
				selenium.waitForElementToBeClickable("ChangeAddressLink");
				selenium.click("ChangeAddressLink");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("SelectAddressLink_withNoCountry");
				selenium.click("SelectAddressLink_withNoCountry");
				selenium.waitingTime(3000);
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.PASS, "Country Validation Message Appearead");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Country Validation Message Did Not Appear");
					selenium.reportFailure("Country Validation Message Did Not Appear");
					System.out.println("FAIL");
				}
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("ChangeAddressLink");
				selenium.click("ChangeAddressLink");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("SelectAddressLink_withCountry");
				selenium.click("SelectAddressLink_withCountry");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("CreateSampleOrderButton");
				selenium.click("CreateSampleOrderButton");
				selenium.waitingTime(3000);

				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
					selenium.waitingTime(8000);
				}

				validationMessage = selenium.getDynamicXpath("divTextcontains1", "Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.FAIL, "Country Validation Message Appearead Even Though The Selected Address Has Country");
					selenium.reportFailure("Country Validation Message Appearead Even Though The Selected Address Has Country");
					System.out.println("FAIL");
				}
			 	else
			 	{
					selenium.test.log(LogStatus.PASS, "Validation Message Did Not Appear As The Selected Address Has Country");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}

				selenium.waitingTime(5000);		
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying the no country validation");
				selenium.reportFailure("Error while verifying the no country validation" + e.getMessage());
			}
	}

	@And("^verify the SFDC Status list for trial values$")
	public void verify_the_SFDC_Status_list_for_trial_values()
	{
		try
			{
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("SampleSFDCStatusList");
				selenium.click("SampleSFDCStatusList");
				if(selenium.isElementPresentFast("SampleSFDCStatusListValues"))
				{
					selenium.test.log(LogStatus.FAIL, "SFDC Status dropdown contains Trial related options.");
					selenium.reportFailure("SFDC Status dropdown contains Trial related options.");
					System.out.println("FAIL");
				}
				else
				{
					selenium.test.log(LogStatus.PASS, "SFDC Status dropdown does not contain Trial related options.");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
				selenium.waitingTime(5000);
			}

		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying the SFDC status Trial values");
				selenium.reportFailure("Error while verifying the SFDC status Trial values" + e.getMessage());
			}
	}

	@And("^verify the SFDC Status list for trial values while resampling$")
	public void verify_the_SFDC_Status_list_for_trial_values_while_resampling()
	{
		try
			{
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("firstTableRecord");
				selenium.click("firstTableRecord");
				selenium.waitingTime(4000);
				selenium.waitForElementToBeClickable("ReSampleBtn");
				selenium.click("ReSampleBtn");
				selenium.waitingTime(5000);
				selenium.switchToFrame("newAccountFrame");
				selenium.waitingTime(2000);
				selenium.pressEscapeKey();
				selenium.waitingTime(1000);
				selenium.waitForElementToBeClickable("SampleSFDCStatusList1");
				selenium.click("SampleSFDCStatusList1");
				if(selenium.isElementPresentFast("SampleSFDCStatusListValues1"))
				{
					selenium.test.log(LogStatus.FAIL, "SFDC Status dropdown contains Trial related options.");
					selenium.reportFailure("SFDC Status dropdown contains Trial related options.");
					System.out.println("FAIL");
				}
				else
				{
					selenium.test.log(LogStatus.PASS, "SFDC Status dropdown does not contain Trial related options.");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}
				selenium.waitingTime(5000);
			}

		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying the SFDC status Trial values");
				selenium.reportFailure("Error while verifying the SFDC status Trial values" + e.getMessage());
			}
	}

	@And("^verify the order quantity validation$")
	public void verify_the_order_quantity_validation()
	{
		try
			{
				selenium.waitForElementToBeClickable("SampleOrderQty");
				selenium.type("SampleOrderQty", "InvalidQuantity1");
				selenium.click("createsampleorder");
				selenium.waitingTime(2000);
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);
				String validationMessage = selenium.getDynamicXpath("divTextcontains1", "Validation Message", "endContains");
				selenium.waitingTime(4000);
				System.out.println(validationMessage);
				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.type("SampleOrderQty", "InvalidQuantity2");
					selenium.waitingTime(3000);
					selenium.click("createsampleorder");
					selenium.waitingTime(5000);
					selenium.waitForElementToBeClickable("createsampleorder");
					selenium.click("createsampleorder");
					selenium.waitingTime(3000);
					if(selenium.isElementPresentXpathFast(validationMessage))
					{
						selenium.test.log(LogStatus.PASS, "Order Quantity Validation Message Appearead For Both 0 & 100 Quantity");
						System.out.println("PASS");
						selenium.captureScreenShot();
					}
				}
			 	else
			 	{
					selenium.test.log(LogStatus.FAIL, "Order Quantity Validation Message Did Not Appear");
					selenium.reportFailure("Order Quantity Validation Message Did Not Appear");
					System.out.println("FAIL");
				}

				selenium.type("SampleOrderQty", "ValidQuantity");
				selenium.waitingTime(3000);
				selenium.click("createsampleorder");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("createsampleorder");
				selenium.click("createsampleorder");
				selenium.waitingTime(3000);

				if(selenium.isElementPresentFast("Duplicate"))
				{
					selenium.waitForElementToBeClickable("yestoall");
					selenium.click("yestoall");
					selenium.waitingTime(8000);
				}

				if(selenium.isElementPresentXpathFast(validationMessage))
				{
					selenium.test.log(LogStatus.FAIL, "Order Quantity Validation Message Appearead For Quantity B/w 1-99");
					selenium.reportFailure("Order Quantity Validation Message Appearead For Quantity B/w 1-99");
					System.out.println("FAIL");
				}
			 	else
			 	{
					selenium.test.log(LogStatus.PASS, "Order Quantity Validation Message Did Not Appear For Quantity B/w 1-99");
					System.out.println("PASS");
					selenium.captureScreenShot();
				}

				selenium.waitingTime(5000);
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while verifying the order quantity validation");
				selenium.reportFailure("Error while verifying the order quantity validation" + e.getMessage());
			}
	}
	
	@Then("^Create New MHHE Opportunity Cloning \\\"([^\\\"]*)\\\"$")
	public void Create_New_MHHE_Opportunity_Cloning_User(String User)
	{
		try
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.waitForElementToBeClickable("NewBtn");
				selenium.click("NewBtn");
				selenium.waitForElementToBeClickable("search_People");
				selenium.typeData("search_People", User);
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutText("search_People");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("saveButton");
				selenium.click("saveButton");
			}
		catch (Exception e)
			{
				selenium.test.log(LogStatus.FAIL, "Error while creating new MHHE Opp cloning user ");
				selenium.reportFailure("Error while creating new MHHE Opp cloning user " + e.getMessage());
			}
	}
	
	@Then("^I mass clone opportunity from opp list view$")
	public void I_mass_clone_opportunity_from_opp_list_view()
	{
		try
		{
			selenium.waitForElementToBeClickable("FirstRecordCheckbox");
			selenium.click("FirstRecordCheckbox");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("SecondRecordCheckbox");
			selenium.click("SecondRecordCheckbox");
			selenium.waitingTime(2000);

			selenium.waitForElementToBeClickable("opportunityMenuToCreateSample");
			selenium.click("opportunityMenuToCreateSample");
			selenium.waitForElementToBeClickable("MassCloneOption");
			selenium.click("MassCloneOption");

			selenium.waitingTime(5000);
			selenium.waitForElementsToBeVisible("newAccountFrame");
			selenium.switchToMultipleFrame("newAccountFrame");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RegionDropDownList");
			
            String NewRegion = selenium.getTestDataFromPropertiesFile("NewRegion");
            Select dropdown = new Select(selenium.getElement("RegionDropDownList"));
            dropdown.selectByVisibleText(NewRegion);

            String NewYear = selenium.getTestDataFromPropertiesFile("NewYear");
            dropdown = new Select(selenium.getElement("NewYearDropDownList"));
            dropdown.selectByVisibleText(NewYear);
            
            String NewTerm = selenium.getTestDataFromPropertiesFile("NewTerm");
            dropdown = new Select(selenium.getElement("NewTermDropDownList"));
            dropdown.selectByVisibleText(NewTerm);
            
            selenium.click("CreateMassOppBtn");
            selenium.waitingTime(10000);
        	selenium.waitForElementToBeClickable("CloningProgressLink");
        	selenium.jsClick("CloningProgressLink");
        	selenium.switchToLastWindow();
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while mass cloning opp from opp list view page");
			selenium.reportFailure("Error while mass cloning opp from opp list view page" + e.getMessage());
		}
	}
	
	@When("^I create new MHHE Opportunity Clone Grid record$")
	public void I_create_new_MHHE_Opportunity_Clone_Grid_record()
	{
		try
		{
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppGrid_Region");
			selenium.click("OppGrid_Region");
			selenium.waitForElementToBeClickable("OppGrid_RegionValue1");
			selenium.click("OppGrid_RegionValue1");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppType");
			selenium.click("OppGrid_SourceOppType");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppTypeValue1");
			selenium.click("OppGrid_SourceOppTypeValue1");
			selenium.waitForElementToBeClickable("OppGrid_NewOppType");
			selenium.click("OppGrid_NewOppType");
			selenium.waitForElementToBeClickable("OppGrid_NewOppTypeValue1");
			selenium.clickLoop("OppGrid_NewOppTypeValue1");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppStage");
			selenium.click("OppGrid_SourceOppStage");
			selenium.waitForElementToBeClickable("OppStageAtRisk");
			selenium.click("OppStageAtRisk");
			selenium.waitForElementToBeClickable("OppGrid_NewOppStage");
			selenium.click("OppGrid_NewOppStage");
			selenium.waitForElementToBeClickable("OppGrid_NewOppStageValue1");
			selenium.clickLoop("OppGrid_NewOppStageValue1");
			
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Successfully created a new MHHE Opportunity Clone Grid record");
			
			OppGridURL = selenium.getURL();
			System.out.println("The newly created MHHE Opp Grid Record is-->" + OppGridURL);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while creating Opp clone grid record");
			selenium.reportFailure("Error while creating Opp clone grid record" + e.getMessage());
		}
	}
	
	@Then("^I edit the existing MHHE Opportunity Clone Grid record$")
	public void I_edit_the_MHHE_Opportunity_Clone_Grid_record()
	{
		try
		{
//			selenium.navigateToURL(OppGridURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("editButton");
			selenium.click("editButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppGrid_Region");
			selenium.click("OppGrid_Region");
			selenium.waitForElementToBeClickable("OppGrid_RegionValue2");
			selenium.click("OppGrid_RegionValue2");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Successfully edited the existing MHHE Opportunity Clone Grid record");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while editing Opp clone grid record");
			selenium.reportFailure("Error while editing Opp clone grid record" + e.getMessage());
		}
	}
	
	@And("^I delete the MHHE Opportunity Clone Grid record$")
	public void I_delete_the_MHHE_Opportunity_Clone_Grid_record()
	{
		try
		{
			selenium.navigateToURL(OppGridURL);
			selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("DeleteActionBtn");
			selenium.click("DeleteActionBtn");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");
			selenium.waitingTime(10000);
			selenium.test.log(LogStatus.PASS, "Successfully deleted the MHHE Opportunity Clone Grid record");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while deleting Opp clone grid record");
			selenium.reportFailure("Error while deleting Opp clone grid record" + e.getMessage());
		}
	}
	
	@Then("^I verify duplicate MHHE Opportunity Clone Grid record$")
	public void I_verify_duplicate_MHHE_Opportunity_Clone_Grid_record()
	{
		try
		{
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.click("NewBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppGrid_Region");
			selenium.click("OppGrid_Region");
			selenium.waitForElementToBeClickable("OppGrid_RegionValue1");
			selenium.click("OppGrid_RegionValue1");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppType");
			selenium.click("OppGrid_SourceOppType");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppTypeValue1");
			selenium.click("OppGrid_SourceOppTypeValue1");
			selenium.waitForElementToBeClickable("OppGrid_NewOppType");
			selenium.click("OppGrid_NewOppType");
			selenium.waitForElementToBeClickable("OppGrid_NewOppTypeValue1");
			selenium.clickLoop("OppGrid_NewOppTypeValue1");
			selenium.waitForElementToBeClickable("OppGrid_SourceOppStage");
			selenium.click("OppGrid_SourceOppStage");
			selenium.waitForElementToBeClickable("OppStageAtRisk");
			selenium.click("OppStageAtRisk");
//			selenium.waitForElementToBeClickable("OppGrid_NewOppStage");
//			selenium.click("OppGrid_NewOppStage");
//			selenium.waitForElementToBeClickable("OppGrid_NewOppStageValue1");
//			selenium.clickLoop("OppGrid_NewOppStageValue1");
//			selenium.click("Save_Btn");
			selenium.waitingTime(2000);			
			Assert.assertTrue(selenium.isElementPresentFast("DuplidateRecordValidation"));
			selenium.jsClick("DuplidateRecordValidation");
			selenium.waitingTime(2000);			
			Assert.assertTrue(selenium.isElementPresentFast("OpenDuplicateGridRecord"));
			selenium.jsClick("OpenDuplicateGridRecord");
			selenium.waitingTime(4000);	
			selenium.waitForElementToBeClickable("editButton");
			Assert.assertTrue(selenium.isElementPresentFast("editButton"));
			selenium.test.log(LogStatus.PASS, "Successfully verified duplicate MHHE Opportunity Clone Grid record");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while deleting Opp clone grid record");
			selenium.reportFailure("Error while deleting Opp clone grid record" + e.getMessage());
		}
	}
	
	@Then("^I verify duplicate MHHE Opportunity Clone Grid record through Clone button$")
	public void I_verify_duplicate_MHHE_Opportunity_Clone_Grid_record_through_Clone_button()
	{
		try
		{
			selenium.waitForElementToBeClickable("CloneBtnNew");
			selenium.click("CloneBtnNew");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(2000);
			Assert.assertTrue(selenium.isElementPresentFast("DuplidateRecordValidation"));
			selenium.waitingTime(2000);			
			selenium.test.log(LogStatus.PASS, "Successfully verified duplicate MHHE Opportunity Clone Grid record");			
			selenium.click("CancelButton");
			selenium.waitingTime(5000);		
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while deleting Opp clone grid record");
			selenium.reportFailure("Error while deleting Opp clone grid record" + e.getMessage());
		}
	}
	
	@And("^verify cloning already inprogress validation$")
	public void verify_cloning_already_inprogress_validation()
	{
		try
		{
			selenium.waitForElementToBeClickable("SubmitCloningBtn");
			selenium.click("SubmitCloningBtn");
			selenium.waitingTime(8000);
			selenium.switchToFrame("newAccountFrame");

			if(selenium.isElementPresentFast("MassCloneAlreadyInProgressMsg"))
			{
				selenium.test.log(LogStatus.PASS,"Cloning already in-progress message appeared");
				System.out.println("PASS-1");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else if(selenium.isElementPresentFast("MassCloneAlreadyCompletedMsg2"))
			{
				selenium.test.log(LogStatus.PASS,"This cloning process is already completed - message appeared");
				System.out.println("PASS-2");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "Cloning already in-progress message DID NOT appeare");
				System.out.println("FAIL-1");
				selenium.reportFailure("Cloning already in-progress message DID NOT appeare");
			}

			selenium.click("opportunitiesCloneSave");
			selenium.waitingTime(2000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(30000);
			selenium.waitForElementToBeClickable("SubmitCloningBtn");
			selenium.click("SubmitCloningBtn");
			selenium.waitingTime(2000);
			selenium.switchToFrame("newAccountFrame");

			if(selenium.isElementPresentFast("MassCloneAlreadyCompletedMsg1") || selenium.isElementPresentFast("MassCloneAlreadyCompletedMsg2"))
			{
				selenium.test.log(LogStatus.PASS,"This cloning process is already completed - message appeared");
				System.out.println("PASS-3");
		 		selenium.captureScreenShot();
		 		selenium.waitingTime(2000);
		 		selenium.close();
		 		selenium.switchBackToParentWindow();
		 		selenium.waitingTime(2000);
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "The expected message DID NOT appeare");
				System.out.println("FAIL-2");
				selenium.reportFailure("The expected message DID NOT appeare");
			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Error while verifying cloning already inprogress validation");
			selenium.reportFailure("Error while verifying cloning already inprogress validation" + e.getMessage());
		}
	}

	@And("^I navigate to the Contact page and add INTL sample to contact$")
	public void i_navigate_to_the_Contact_page_and_add_INTL_sample_to_contact(DataTable table)
	{
		try
		{
			List<String> data = table.transpose().asList(String.class);
			selenium.navigateToURL(data.get(0));
		selenium.waitingTime(8000);
//		selenium.waitForElementToBeClickable("firstTableRecord");
//		selenium.jsClick("firstTableRecord");
//		selenium.waitingTime(5000);
		if(selenium.isElementPresentFast("addINTLsample"))
		{
			selenium.jsClick("addINTLsample");
		}
		else
		{
			selenium.click("moreActionsBtn");
			selenium.waitForElementToBeClickable("INTLAddSampleActionBtn");
			selenium.jsClick("INTLAddSampleActionBtn");
		}
		selenium.waitingTime(10000);
		selenium.switchToFrame("frametoswitch");
		selenium.waitingTime(6000);
		String subject= "maths";
		selenium.typeData("searchProduct",subject);
		selenium.waitForElementToBeClickable("searchProductsBtn");
		selenium.jsClick("searchProductsBtn");
		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("addprodtick");
		selenium.jsClick("addprodtick");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("Addtosampleandcontinue");
		selenium.click("Addtosampleandcontinue");
		selenium.waitingTime(5000);


	}
		catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
	}

}

	@Then("^verify validation error of State and postal code for new address of sample$")
	public void verify_validation_error_of_State_and_postal_code_for_new_address_of_sample()
	{
		try
		{
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("frametoswitch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("changeAddress");
			selenium.click("changeAddress");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("frametoswitch");
			selenium.waitForElementToBeClickable("createAddress");
			selenium.jsClick("createAddress");
			selenium.waitForElementToBeClickable("addresname");
			selenium.click("addresname");
//			selenium.waitingTime(2000);
			String address = "HCET";
			selenium.typeData("addresname",address);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addresType");
			selenium.click("addresType");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("typeaddress");
			selenium.click("typeaddress");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("streetano");
			selenium.jsClick("streetano");
			String street = "no 3";
			selenium.typeData("streetano",street);
			String City = "Delhi";
			selenium.waitForElementToBeClickable("city1");
			selenium.jsClick("city1");
			selenium.typeData("city1",City);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("country1");
			selenium.click("country1");
			selenium.waitingTime(1000);
			selenium.waitForElementToBeClickable("countryy");
			selenium.click("countryy");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(5000);
			String expected="Error:";
			String actual=selenium.getText("errormsg1").toString();
			System.out.println(actual);
			if(actual.equalsIgnoreCase(expected));
			{
			System.out.println("Validation Error Message Appeared");
			selenium.test.log(LogStatus.PASS, "Test Case Passed");
			selenium.captureScreenShot();
			}
			selenium.waitingTime(3000);
			String State = "Delhi";
			selenium.waitForElementToBeClickable("State1");
			selenium.jsClick("State1");
			selenium.typeData("State1",State);
			selenium.waitingTime(2000);
			String postal="110011";
			selenium.waitForElementToBeClickable("postalcode");
			selenium.jsClick("postalcode");
			selenium.typeData("postalcode",postal);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Button_Save");
			selenium.jsClick("Button_Save");
			selenium.waitingTime(5000);


		}
			catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}

	@Then("^I verify sample created with new address$")
	public void i_verify_sample_created_with_new_address()
	{
		try
		{
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("frametoswitch");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("changeAddress");
			selenium.click("changeAddress");
			selenium.waitingTime(5000);
			selenium.switchToMultipleFrame("frametoswitch");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("selectaddr");
			selenium.click("selectaddr");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("CreateSampleOrderButton");
			selenium.click("CreateSampleOrderButton");
			selenium.waitingTime(5000);
			selenium.switchOutOfFrame();

		}
		catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to opportunity " + e.getMessage());
		}

	}

}
