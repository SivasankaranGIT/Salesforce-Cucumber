package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpportunityLIstView {
	
	WebConnector selenium = WebConnector.getInstance();
	String url;
	
	 @And("^choose list view for opportunity$")
	    public void choose_list_view_for_opportunity()  {
		try {
			selenium.waitForElementToBeClickable("opportunityRecentlyViewed1");
		selenium.click("opportunityRecentlyViewed1");
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeClickable("SearchList");
		selenium.click("SearchList");
		selenium.waitingTime(3000);
//		selenium.type("listViewFilter", "List View");
////		selenium.waitingTime(2000);
//		selenium.waitForElementToBeClickable("listViewFilterResult1");
//		selenium.clickLoop("listViewFilterResult1");
		selenium.autoSuggestiveDropdownOne("SearchList", "List View");
		selenium.waitingTime(9000);
		}
		 catch (Exception e) {
			 	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while choosing list view for opportunity" + e.getMessage());
			}

	}
	 @Then("^select opportunities and click on new sample$")
	    public void select_opportunities_and_click_on_new_sample() {
		try {
		selenium.waitingTime(60000);
		//selenium.waitUntilLoaderLoadsOne();	
		url= selenium.getURL();
		selenium.waitForElementToBeClickable("opportunityListResult4");
		selenium.jsClick("opportunityListResult4");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("opportunityListResult5");
		selenium.jsClick("opportunityListResult5");
		selenium.waitingTime(2000);		
		if(selenium.isElementPresentFast("OppSamplesActionBtn"))
		{
			selenium.click("OppSamplesActionBtn");
		}
		else
		{
			selenium.click("arrowBtnOpportunity");
			selenium.waitForElementToBeClickable("samplesOnOpportunityInsideMenu2");
			selenium.click("samplesOnOpportunityInsideMenu2");
		}
		selenium.waitingTime(5000);
		selenium.switchToFrame("sampleContact");
		selenium.waitingTime(5000);
		}
		 catch (Exception e) {
			 	selenium.switchOutOfFrame();
				selenium.reportFailure("Error while choosing list view result for opportunity" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

	}
	 
	 @Then("^verify samples section for product and contacts combination$")
		public void verify_samples_section_for_product_and_contacts_combination() {
			try {
						selenium.waitingTime(10000);
						System.out.println("inside message");
						selenium.navigateToURL(url);
						selenium.waitingTime(8000);
						selenium.switchOutOfFrame();
						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("opportunityListResult4");
						selenium.jsClick("opportunityListResult4");
						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("opportunityListResult5");
						selenium.jsClick("opportunityListResult5");
						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("arrowBtnOpportunity");
						selenium.click("arrowBtnOpportunity");
//						selenium.waitingTime(3000);
						selenium.waitForElementToBeClickable("samplesOnOpportunityInsideMenu2");
						selenium.click("samplesOnOpportunityInsideMenu2");
						selenium.waitingTime(5000);
						selenium.switchToFrame("sampleContact");
						selenium.waitingTime(5000);
						if(selenium.isElementPresentFast("swappedProductsPopUp")){
							System.out.println("inside swap poppup");
							selenium.test.log(LogStatus.INFO, "Swap Product Popup Appeared!");
							selenium.jsClick("okButton");
							selenium.waitingTime(3000);
						}

//				if (selenium.getElement("samplecreationPopupForOpportunityListView").isDisplayed()) {
//					System.out.println("inside message1");
//					selenium.waitingTime(2000);
//					selenium.waitForElementToBeClickable("okButtonForOpportunityListView");
//					selenium.click("okButtonForOpportunityListView");
//					selenium.waitingTime(5000);
//				}

				if (selenium.isElementPresentFast("createSampleOrderBtn")) {
					System.out.println("inside pass");
					System.out.println("scrolling to element");
					//selenium.scrollToElement("contactProductCombinationForListView");
					selenium.waitingTime(2000);
					selenium.test.log(LogStatus.PASS, "contact and product combinations available");
					System.out.println("PASS");

				} else {
					System.out.println("inside fail");
					selenium.test.log(LogStatus.FAIL, "contact and product combinations not available");
					System.out.println("FAIL");
					selenium.reportFailure("Test Case Failed");
				}
				//selenium.captureScreenShot();
				selenium.waitingTime(2000);
				selenium.switchOutOfFrame();

			} catch (Exception e) {
				selenium.switchOutOfFrame();
				selenium.reportFailure("Error while verifying samples section" + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}

		}
	 
}
