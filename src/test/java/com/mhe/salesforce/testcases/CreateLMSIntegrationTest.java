package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateLMSIntegrationTest {
	
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
//	String accountUrl="https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000cMi4wAAC/view";
	
	@And("^I fill mandatory LMS Integration details$")
	public void I_fill_mandatory_LMS_Integration_details() {
		try {
			/*selenium.searchGlobal("Account Name");
			selenium.waitingTime(2000);
			String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
			selenium.clickLoopXpath(Xpath);*/
//			selenium.navigateToURL(accountUrl);
//			selenium.waitingTime(7000);
			if (selenium.isElementPresentFast("showAllLinks")) {
				selenium.waitForElementToBeClickable("showAllLinks");
				selenium.clickLoop("showAllLinks");
			}
//			selenium.click("showAllLinks");
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("lmsIntegrationLink");
				selenium.click("lmsIntegrationLink");
			} else {
				selenium.waitForElementToBeClickable("lmsIntegrationLink");
				selenium.click("lmsIntegrationLink");
			}
			//selenium.clickXpath("(//a[@title='New']//div)[2]");
			selenium.waitForElementToBeClickable("NewButton");
			selenium.click("NewButton");
			selenium.waitingTime(2000);
	        selenium.waitForElementToBeVisible("Name_Field");
			
			String lmsName= selenium.getRandomString();
			selenium.getElement("Name_Field").sendKeys(lmsName);
			selenium.waitForElementToBeClickable("productDropDwn1");
			selenium.jsClick("productDropDwn1");
			selenium.clickDynamic("spanTitle", "Product", "end");
			selenium.waitingTime(2000);
//	        selenium.waitForElementToBeClickable("subProductDropDwn");
//			
//			selenium.jsClick("subProductDropDwn1");
//			selenium.clickDynamic("spanTitle", "Sub Product", "end");
//			selenium.waitingTime(2000);
//	        selenium.waitForElementToBeVisible("deepIntegrationCheckBox");
//			
//			selenium.scrollToElement("deepIntegrationCheckBox");
//			selenium.jsClick("deepIntegrationCheckBox");
//			selenium.type("priorityField", "Priority");
			
			selenium.scrollToElement("lmsDropDwn1");
			selenium.jsClick("lmsDropDwn1");
			selenium.clickDynamic("spanTitle", "LMS", "end");
			selenium.waitingTime(2000);
	        selenium.waitForElementToBeVisible("Search_contact");
			
			selenium.scrollToElement("Search_contact");
			
			selenium.type("Search_contact", "LMS Admin");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			selenium.click("showAllResultsFromDropDwn");
			selenium.waitingTime(6000);
			String supportaccountsearch = selenium.getDynamicXpath("contactSearchPopup", "LMS Admin",
					"end");
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeClickable(supportaccountsearch);
			selenium.clickLoopXpath(supportaccountsearch);
			
			selenium.waitingTime(2000);
	        selenium.waitForElementToBeVisible("notesTextArea");
			selenium.scrollToElement("notesTextArea");
			selenium.type("notesTextArea", "Notes");
			selenium.waitingTime(2000);
	        selenium.waitForElementToBeClickable("save");
			
			selenium.click("save");
			selenium.waitingTime(10000);
			/*selenium.waitForElementToBeVisible("contactSuccessfulL");
			flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
	
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				selenium.printLastTestResult(flagsuccess);
			}else if(selenium.getUI().equalsIgnoreCase("classic")){
				selenium.printLastTestResult(flagsuccess);
			}*/
			
		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean  error=selenium.isElementPresentFast("ErrorListAll");    
            System.out.println(error);
            if(error==true) {
                   System.out.println("Error came");
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);            
                   selenium.click("CancelButton");
            }

            else {
                   selenium.click("CancelButton");
            }
			//selenium.reportFailure("Error while creating an LMS Integration " + e.getMessage());
		}
	}
	
	@Then("^I validate LMS created under account$")
	public void I_validate_LMS_created_under_account() {
		try {
		selenium.waitingTime(4000);
		String lms = selenium.getDynamicXpath("spantextContains", "Product Name", "endContains");
		selenium.waitingTime(4000);
//		selenium.waitForXpathElementToBeClickable(lms);
		System.out.println(lms);
		selenium.clickLoopXpath(lms);
//		selenium.waitingTime(4000);
	    selenium.waitForElementToBeVisible("lmsIntegrationNameGetText");
        String lmsName=selenium.getText("lmsIntegrationNameGetText").toString();
        System.out.println("lmsName:"+ lmsName);
        String product = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Product Name");
        System.out.println("product:"+ product);
        if(lmsName.contains(product)) {
        	selenium.test.log(LogStatus.PASS, "LMS: " + lmsName + " created successfully");
        	System.out.println("PASS");
        }
        else {
			selenium.reportFailure("LMS creation failed");
			selenium.test.log(LogStatus.FAIL, "LMS creation failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}

	}

}
