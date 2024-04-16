package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class validateProductDeletionFromOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;

	@And("^I delete the product on opportunity screen$")
	public void i_delete_the_product_on_opportunity_screen() {
		try {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			/*selenium.clickLoop("NewProductOpportunity");
			selenium.clickDynamic("anchorTitle", "Product Name", "end");
			selenium.waitingTime(5000);
			selenium.clickLoop("DeleteRecord");
			selenium.waitingTime(2000);
			selenium.click("deleteBtn");*/
			
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("productsLink");
			selenium.click("productsLink");
			selenium.clickDynamic("anchorTitlecontains", "Product Name", "endContains");
//			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("DeleteActionButton");
			selenium.jsClick("DeleteActionButton");
			selenium.waitingTime(2000);
			
		}
		else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitingTime(2000);
			String xpath=selenium.getDynamicXpath("anchorText","Product Name", "productdeletedynamic");
			selenium.scrollToXpathElement(xpath);
			selenium.waitingTime(4000);
//			selenium.waitForXpathElementToBeVisible(xpath);
			selenium.clickXpath(xpath);
			//selenium.clickDynamic("anchorText","Product Name", "productdeletedynamic");
			selenium.waitingTime(2000);
			selenium.acceptAlert();	
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("^the product should be successfully deleted$")
	public void the_product_should_be_successfully_deleted() {
		try {
			if (selenium.getUI().equalsIgnoreCase("lightning")) {
				//selenium.waitingTime(1000);
				//selenium.printLastTestResult(selenium.isElementPresentFast("contactSuccessfulL"));
//				selenium.waitingTime(4000);
				selenium.waitForElementToBeVisible("productsLink");
				flagsuccess=selenium.isElementPresentFast("productsLink");
				selenium.printLastTestResult(flagsuccess);
			}

			else if (selenium.getUI().equalsIgnoreCase("classic")) {
				if (selenium.getBrowserName().equalsIgnoreCase("IE"))
					selenium.waitingTime(2000);
				String xpath=selenium.getDynamicXpath("anchorText", "Product Name", "end");
					selenium.waitingTime(4000);
//					selenium.waitForXpathElementToBeVisible(xpath);
					boolean success=selenium.isElementPresentXpathFast(xpath);
				selenium.printLastTestResult(!success);
			}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

		}

}
