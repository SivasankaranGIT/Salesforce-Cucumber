package com.mhe.salesforce.testcases;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCasesFromDifferentLocations {
	WebConnector selenium = WebConnector.getInstance();
	
	 @When("^I navigate to contact page$")
	    public void i_navigate_to_contact_page() {
		try {
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
	
		}
		 catch (Exception e) {
			 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to contact page" + e.getMessage());
			}

	}
	 
	 @And("^navigate to Cases section$")
	    public void navigate_to_cases_section() {
		try {
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("casesOnContact1");
			selenium.clickLoop("casesOnContact1");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("casePresentInsidesection");
		
			if(selenium.getElement("casePresentInsidesection").isDisplayed()) {
				System.out.println("Case record present");
				selenium.test.log(LogStatus.PASS, "Case record present");
				selenium.refresh();
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
//			 	selenium.scrollToElement("casePresentInsidesection");
			 	selenium.waitForElementToBeClickable("casePresentInsidesection");
				selenium.jsClick("casePresentInsidesection");
				selenium.waitingTime(9000);

			} else {
				System.out.println("Case record not present");
				selenium.test.log(LogStatus.FAIL, "Case record not present");
			}
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to case" + e.getMessage());
			}

	}
	 
	 @Then("^verify case details$")
	    public void verify_contact_case_details() {
		try {
			
			selenium.waitForElementToBeVisible("caseHeaderOnpage");
		
			if(selenium.getElement("caseHeaderOnpage").isDisplayed()) {
				System.out.println("Case viewed");
				selenium.test.log(LogStatus.PASS, "Case viewed successfully");

			} else {
				System.out.println("fail");
				selenium.test.log(LogStatus.FAIL, "Case view failed");

			
			}
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			
	
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while viewing case" + e.getMessage());
			}

	}
	 
	 @When("^I navigate to Opportunity page$")
	    public void i_navigate_to_opportunity_page() {
		try {
			
			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity URL");
			selenium.navigateToURL(url);
			selenium.waitingTime(6000);
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
	
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to contact page" + e.getMessage());
			}

	}
	 
	 @And("^navigate to Cases section from opportunity$")
	    public void navigate_to_cases_section_from_opportunity() {
		try {
			//selenium.waitForElementToBeClickable("showAllLinks");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("opportunityHeaderSection");
			selenium.scrollToElement("opportunityHeaderSection");
			selenium.waitingTime(4000);
			System.out.println("clicking");
			if (selenium.isElementPresentFast("showAllLinks")) {
			selenium.click("showAllLinks");
			}
			selenium.waitingTime(2000);
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.click("closeBtn");
			}
				System.out.println("clicked");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("casesSectionInsideContact");
			selenium.jsClick("casesSectionInsideContact");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("casePresentInsidesection");
		
			if(selenium.isElementPresentFast("casePresentInsidesection")) {
				System.out.println("Case record present");
				selenium.test.log(LogStatus.PASS, "Case record present");
				selenium.refresh();
				selenium.waitingTime(4000);
				selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("casePresentInsidesection");
				selenium.jsClick("casePresentInsidesection");
				selenium.waitingTime(9000);

			} else {
				System.out.println("Case record not present. So creating new case..");
				selenium.test.log(LogStatus.INFO, "Case record not present. So creating new case..");
//				selenium.reportFailure("Test Case Failed");
				String oppCasePageURL = selenium.getURL();
				selenium.waitingTime(2000);
//				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/o/Case/list?filterName=Recent");
				selenium.waitForElementToBeClickable("NewActionButton");
				selenium.click("NewActionButton");
				selenium.waitingTime(2000);
				if(selenium.isElementPresentFast("next"))
				{
				selenium.waitForElementToBeClickable("next");
				selenium.click("next");
				selenium.waitingTime(2000);
				}
				selenium.waitForElementToBeClickable("createParentCase1");
				selenium.click("createParentCase1");
				selenium.waitingTime(2000);
				selenium.autoSuggestiveDropdownWithoutText("createParentCase1");
				selenium.waitForElementToBeClickable("Case_OriginDropDown");
				selenium.jsClick("Case_OriginDropDown");
				selenium.waitingTime(2000);
				selenium.clickDynamic("spanTitle", "Case Origin", "end");
				System.out.println("Added Case origin");
				selenium.waitingTime(2000);
//				selenium.scrollToElement("ProductType");
				selenium.waitForElementToBeClickable("Eventopportunities");
				selenium.click("Eventopportunities");
				selenium.waitForElementToBeClickable("FirstEVentOpportunity");
				selenium.click("FirstEVentOpportunity");
				selenium.waitForElementToBeClickable("caseDTSProductTypeDropdown");
				selenium.click("caseDTSProductTypeDropdown");
				selenium.waitingTime(2000);
//				selenium.jsClickXpath(selenium.getDynamicXpathForDropdownSelection("anchorTitle", "Producttype Value", "end"));
				selenium.click("productTypeValue");
				selenium.waitForElementToBeClickable("ProductDropDownField");
				selenium.click("ProductDropDownField");
				selenium.waitingTime(2000);
//				selenium.jsClickXpath(selenium.getDynamicXpathForDropdownSelection("anchorTitle", "Product Value", "end"));
				selenium.click("productValue");
				selenium.waitForElementToBeClickable("RecordSaveButton");
				selenium.jsClick("RecordSaveButton");
				System.out.println("Clicked save button");
				selenium.waitingTime(10000);
				if(selenium.isElementPresentFast("RecordSaveButton"))
				{
				 selenium.clickLoop("RecordSaveButton");
				 selenium.waitingTime(10000);
				}
				selenium.navigateToURL(oppCasePageURL);
				selenium.waitingTime(6000);
				if(selenium.isElementPresentFast("casePresentInsidesection")) {
					System.out.println("Case record present");
					selenium.test.log(LogStatus.PASS, "Case record present");
					selenium.captureScreenShot();
					selenium.waitingTime(4000);
					selenium.waitForElementToBeClickable("casePresentInsidesection");
					selenium.click("casePresentInsidesection");
					selenium.waitingTime(9000);
				}
			}
			
	
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while navigating to case" + e.getMessage());
			}

	}
	 
}
