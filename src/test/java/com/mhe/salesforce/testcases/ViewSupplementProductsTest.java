package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewSupplementProductsTest {

	WebConnector selenium = WebConnector.getInstance();
//	String supplemenetproduct="https://mh--uat.sandbox.lightning.force.com/lightning/r/Product2/01t0y000005JDpJAAW/view";
	@Then("^Verify supplement page have read only access$")
	public void Verify_supplement_page_have_read_only_access() {
		try {
//		selenium.navigateToURL(supplemenetproduct);
		/*
		 * selenium.search("Product Name"); String Xpath =
		 * selenium.getDynamicXpath("anchorTitlecontains", "Product Name",
		 * "endContains"); selenium.clickLoopXpath(Xpath);
		 */
//		selenium.waitingTime(4000);
		selenium.refresh();
		selenium.waitingTime(8000);
		selenium.waitForElementToBeVisible("productNameGetText");
		String productName = selenium.getTextLoop("productNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Product Name page:  " + productName + "is displayed");
		selenium.waitForElementToBeClickable("supplementsLink");
		selenium.click("supplementsLink");
		selenium.waitingTime(2000);

		String supplement = selenium.getDynamicXpath("spantextContains", "Supplement Name", "endContains");
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(supplement);
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeVisible("supplementNameGetText");
		String supplementName = selenium.getTextLoop("supplementNameGetText").toString();
		selenium.test.log(LogStatus.INFO, "Supplement Name page:  " + supplementName + "is displayed");

		boolean editBtn = selenium.isElementPresentFast("editBtn");
		boolean printOption = selenium.isElementPresentFast("printViewBtn");
		if (editBtn == false && printOption == true) {
			selenium.test.log(LogStatus.INFO,
					"Fields are non-editable for the SFDC-Users and only print option is present for them");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@Then("I search product by expanding business unit$")
	public void I_search_product_by_expanding_business_unit() {
		try {
		selenium.test.log(LogStatus.INFO, "Selecting and expanding Business Unit");
		selenium.waitingTime(4000);
//		selenium.waitForElementToBeVisible("productframeUat");
		selenium.switchToMultipleFrame("productframeUat");
//		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("businessUnitDropDwn");
		selenium.click("businessUnitDropDwn");
		// selenium.clickDynamic("currencyValue", "Business Unit", "end");
		selenium.selectDropdownText("businessUnitDropDwn", "Business Unit");
		selenium.waitForElementToBeClickable("expandAllOption");
		selenium.click("expandAllOption");
		selenium.waitingTime(2000);
		selenium.clickDynamic("Text_Span", "Area", "end");
//		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("searchProductsBtn");
		selenium.click("searchProductsBtn");
		selenium.waitingTime(10000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}

	}

	@Then("Check supplement records$")
	public void Check_supplement_records() {
		try {
			selenium.scrolldown(100);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("goButton");
			// selenium.scrollToElement("productsTable");
//			selenium.scrollToElement("goButton");
			selenium.waitingTime(2000);
			selenium.scrolldown(200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("goButton");
			selenium.click("goButton");
			selenium.waitingTime(3000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 2nd window");
			selenium.captureScreenShot();
			selenium.waitForElementToBeClickable("supplementsTab");
			selenium.click("supplementsTab");
			selenium.captureScreenShot();
			selenium.waitingTime(2000);
			String supplement = selenium.getDynamicXpath("anchorTextcontains", "ISBN", "endContains");
			//String supplement = selenium.getDynamicXpath("supplementTableDynamic", "ISBN", "endContains");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(supplement);
			selenium.waitingTime(4000);
			selenium.switchToLastWindow();
			selenium.waitingTime(3000);
			selenium.test.log(LogStatus.PASS, "Switched to 3rd window");
			selenium.captureScreenShot();
			selenium.refresh();
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("supplementsRecordTab")) {
				selenium.scrollToElement("supplementsRecordTab");
				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("supplementsRecordTab");
				selenium.click("supplementsRecordTab");
				selenium.waitingTime(7000);
				selenium.captureScreenShot();
				/*selenium.waitForElementToBeVisible("supplementRecordGetText");
				selenium.waitingTime(5000);
				String supplementRecord = selenium.getText("supplementRecordGetText").toString();
				selenium.waitingTime(2000);*/
				selenium.waitForElementToBeVisible("supplementText");
				selenium.waitingTime(5000);
				selenium.captureScreenShot();
				String supplementRecord = selenium.getText("supplementText").toString();
				selenium.waitingTime(2000);
				System.out.println(supplementRecord);
				if (supplementRecord.equalsIgnoreCase("Data Not Available") || selenium.isElementPresentFast("supplementTblRecord")) {
					selenium.captureScreenShot();
					selenium.test.log(LogStatus.PASS,
							"Fields are non-editable and there are no further supplement records underneath it.");
					System.out.println("Fields are non-editable and there are no further supplement records underneath it.");
				} else
				{
					selenium.test.log(LogStatus.FAIL, "Value could not be fetched");
					System.out.println("Value could not be fetched");
					selenium.reportFailure("Value could not be fetched");
				}
				selenium.close();
//				selenium.switchToLastWindow();
//				selenium.close();
				selenium.switchBackToParentWindow();
				selenium.switchOutOfFrame();
			}
		} catch (Exception e) {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.switchToLastWindow();
			selenium.close();
			selenium.switchBackToParentWindow();
			selenium.switchOutOfFrame();
		}
	}
}
