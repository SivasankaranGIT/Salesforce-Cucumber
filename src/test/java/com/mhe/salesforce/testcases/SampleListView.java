package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SampleListView {
	WebConnector selenium = WebConnector.getInstance();
	
	@And("^choose shop list view$")
    public void choose_shop_list_view()  {
		try {
			selenium.waitForElementToBeClickable("newCaseReq1");
			selenium.click("newCaseReq1");
			selenium.waitForElementToBeClickable("SearchList");
			selenium.click("SearchList");
			selenium.waitingTime(3000);
//			selenium.autoSuggestiveDropdownOne("listViewBtn", "List View");
			selenium.autoSuggestiveDropdownOne("SearchList", "List View");
			selenium.waitingTime(2000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while choosing Shop list view" + e.getMessage());
			}

	}
	
	 @Then("^verify sample source$")
	    public void verify_sample_source()  {
			try {
			
			selenium.waitForElementToBeVisible("sampleShopSource");
			selenium.scrollToElement("product_information");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("sampleShopSource");
			
			String source = selenium.getText("sampleShopSource").toString();
//			String expected_source = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Source");
//			String expected_source2 = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Source2");
			System.out.println("status" +source );
//			if ((source.equalsIgnoreCase(expected_source)) || (source.equalsIgnoreCase(expected_source2))){
			if(selenium.isElementPresentFast("sampleShopSource")) {
				System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "sample source verified successfully");

			} else {
				System.out.println("inside fail");
				selenium.test.log(LogStatus.FAIL, "sample source not proper");
				selenium.reportFailure("Test Case Failed");

			}
			
			selenium.captureScreenShot();
//			selenium.waitingTime(2000);
			}
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while verifying sample source details" + e.getMessage());
				
				}

		}
	
	 @And("^choose shipped list view$")
	    public void choose_shipped_list_view()  {
			try {
				selenium.refresh();
				selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("newCaseReq1");
			selenium.click("newCaseReq1");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("listViewBtn");
			selenium.click("listViewBtn");
     		selenium.waitingTime(3000);
//			selenium.waitForElementToBeVisible("listViewFilter");
//			selenium.type("listViewFilter", "List View");
    		selenium.autoSuggestiveDropdownOne("listViewBtn", "List View");
			selenium.waitingTime(4000);
//			selenium.waitForElementToBeClickable("listViewFilterResult1");
//			selenium.clickLoop("listViewFilterResult1");
			selenium.waitingTime(2000);
			}
			
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while choosing shipped list view" + e.getMessage());
				}

		}
	
	 @Then("^click tracking URL$")
	    public void click_tracking_url()  {
			try {
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("Leadaddressinformation");
			selenium.scrollToElement("Leadaddressinformation");
			selenium.waitingTime(3000);
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("sampleTrackingURL");
			selenium.jsClick("sampleTrackingURL");
			selenium.waitingTime(5000);
			
			}
			
			 catch (Exception e) {
				 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					selenium.reportFailure("Error while clicking tracking URL" + e.getMessage());
				}

		}
	 
	 @And("^verify tracking details$")
	    public void verify_tracking_details()  {
			try {
				 selenium.switchToChildWindow();
				 selenium.waitForElementToBeVisible("sampleFedExLogo_new");
				 boolean value = selenium.isElementPresentFast("sampleFedExLogo_new");
				 System.out.println(value);
				 if (value == true) {
					 selenium.test.log(LogStatus.PASS, "Sample tracking successful" );
					 System.out.println("inside pass");
				 }
				 else { 
					 selenium.test.log(LogStatus.FAIL, "Sample tracking failed" );
					 System.out.println("inside fail");
					 selenium.reportFailure("Test Case Failed");
				 }
				 selenium.captureScreenShot();
				 selenium.waitingTime(4000);
				 selenium.close();
				 selenium.waitingTime(2000);
				 selenium.switchBackToParentWindow();
				 selenium.waitingTime(3000);
			
				 
			 }
			 catch (Exception e) {
				 selenium.switchBackToParentWindow();
					selenium.reportFailure("Error while tracking sample " + e.getMessage());
					selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					
				}
		}
		
}
