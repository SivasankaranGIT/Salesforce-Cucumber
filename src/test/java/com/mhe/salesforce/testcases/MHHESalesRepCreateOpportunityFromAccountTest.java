package com.mhe.salesforce.testcases;

import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHHESalesRepCreateOpportunityFromAccountTest {
	WebConnector selenium = WebConnector.getInstance();
	String opportunityName;
	String url;
	boolean flagsuccess;
	
	@And("^I fill mandatory opportunity details$")
	public void i_fill_in_the_following_to_create_a_new_opportunity() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				
//				selenium.search("Account Name");
//				selenium.waitingTime(2000);
//				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
//				System.out.println(Xpath);
//				selenium.waitingTime(4000);
//				selenium.clickLoopXpath(Xpath);
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwVPOAA2/view");
				selenium.waitingTime(4000);
				url=selenium.getURL();
				selenium.waitForElementToBeClickable("opportunitiesLink");
				selenium.click("opportunitiesLink");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.clickLoop("NewActionButton");
				selenium.waitingTime(15000);
//				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
				selenium.waitingTime(2000);
				
				selenium.type("mheCourse", "MHE Course");
				selenium.waitingTime(4000);
				String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
				selenium.clickLoopXpath(xpath);
				
				selenium.selectDropdownText("termDropdown", "Term");
				selenium.selectDropdownText("opportunityTypeDropdown", "Opportunity Type");
				selenium.selectDropdownText("salesStageDropdown", "Sales Stage");
				
				selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
				selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
				selenium.type("oppurtunitySummerEnrollment", "Summer Enrollment");
				selenium.type("oppurtunityWinterEnrollment", "Winter Enrollment");
				
				selenium.captureScreenShot();
//                selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("ButtonSave");
                selenium.jsClick("ButtonSave");
                selenium.waitingTime(5000);
                selenium.switchOutOfFrame(); 
                
			} else {
				selenium.click("switchToLighteningMode");
			}


		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@And("^New I fill mandatory opportunity details$")
	public void New_i_fill_in_the_following_to_create_a_new_opportunity() {
		try {

			if (selenium.getUI().contains("Lightning")) {
				
				selenium.search("Account Name");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
				selenium.clickLoopXpath(Xpath);
				selenium.waitingTime(4000);
				url=selenium.getURL();
				selenium.waitForElementToBeClickable("opportunitiesLink");
				selenium.click("opportunitiesLink");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("newOpportunityBtn");
				selenium.click("newOpportunityBtn");
				selenium.waitingTime(2000);
				selenium.waitForElementsToBeVisible("newAccountFrame");
				selenium.switchToMultipleFrame("newAccountFrame");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("mheCourse");
				
				selenium.type("mheCourse", "MHE Course");
				selenium.waitingTime(2000);
				String xpath = selenium.getDynamicXpath("spanTitle", "MHE Course", "end");
				selenium.clickLoopXpath(xpath);
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("opportunityTypeDropdown");
//				selenium.selectDropdownText("termDropdown", "Term");
				selenium.selectDropdownText("opportunityTypeDropdown", "Opportunity Type");
//				selenium.selectDropdownText("salesStageDropdown", "Sales Stage");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeVisible("oppurtunityFallEnrollment");
				selenium.type("oppurtunityFallEnrollment", "Fall Enrollment");
				selenium.type("oppurtunitySpringEnrollment", "Spring Enrollment");
				selenium.type("oppurtunitySummerEnrollment", "Summer Enrollment");
				selenium.type("oppurtunityWinterEnrollment", "Winter Enrollment");
				
				selenium.captureScreenShot();
//                selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("ButtonSave");
                selenium.jsClick("ButtonSave");
                selenium.waitingTime(5000);
                selenium.switchOutOfFrame(); 
                
			} else {
				selenium.click("switchToLighteningMode");
			}


		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating an opportunity " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^I validate opportunity created under account$")
	public void account_address_creation_should_be_successful() {
		try {
		selenium.navigateToURL(url);
		
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("accountsOpportunityLink_new1");
			selenium.clickLastXpath("accountsOpportunityLink_new1");
		} else {
			selenium.waitForElementToBeClickable("accountsOpportunityLink_new1");
			selenium.clickLastXpath("accountsOpportunityLink_new1");
		}

    		selenium.waitingTime(5000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opportunityNameGetText01");

			opportunityName=selenium.getTextLoop("opportunityNameGetText01").toString();
			System.out.println("Opportunity Name is : " + opportunityName);
    	String opp = selenium.getDynamicXpath("spantextContains", "MHE Course", "endContains");
		System.out.println(opp);
    	selenium.clickLoopXpath(opp);
  		selenium.waitingTime(5000);
		  selenium.refresh();
		  selenium.waitingTime(5000);
	//	selenium.waitForElementToBeVisible("opportunityNameGetText");
		

		// String oppType = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity Type");
		String accName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Name");
		System.out.println("Account type : "+accName);

        selenium.opportunity=selenium.getURL();

		/*boolean opportunity = selenium.isElementPresentFast("opportunityName");
		selenium.waitingTime(2000);
		System.out.println("Opportunity present"+ opportunity);*/
		if(opportunityName.contains(accName)) {
        	selenium.test.log(LogStatus.PASS, "Opportunity: " + opportunityName + " created successfully");
        	System.out.println("PASS");
        }
        else {
			selenium.reportFailure("Opportunity creation failed");

		}
				
				/*if(opportunity==true) {
					System.out.println("inside true");
					selenium.test.log(LogStatus.PASS, "Opportunity created successfully");
				}
				else {
					selenium.test.log(LogStatus.FAIL, "Opportunity not created");
		
				}*/
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
	@And("^delete created object$")
	public void delete_created_object() {
		try {
		selenium.waitForElementToBeClickable("taskArrowBtn");
		selenium.clickLoop("taskArrowBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("DeleteRecord");
		selenium.click("DeleteRecord");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deleteBtn");
		selenium.click("deleteBtn");

		flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
		selenium.printLastTestResult(flagsuccess);

		selenium.test.log(LogStatus.PASS, "Task deleted successfully");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
