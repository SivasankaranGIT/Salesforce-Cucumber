package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;

public class MarketoSalesInsightContactTest {

	WebConnector selenium = WebConnector.getInstance();

	@And("^view Marketo Sales Insight list$")
	public void view_marketo_sales_insight_list() {
		try {

//			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
			if(selenium.isElementPresentFast("marketoSalesInsightTab"))
			{
				selenium.waitForElementToBeClickable("marketoSalesInsightTab");
				selenium.clickLoop("marketoSalesInsightTab");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(15000);
				selenium.waitForElementToBeClickable("marketoSalesInsightTab");
				selenium.clickLoop("marketoSalesInsightTab");
			}
			selenium.waitingTime(3000);
			selenium.switchToMultipleFrame("productframeUat");
			String msi = selenium.getTextLoop("msiTabDetails1");
			
			String msiName = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MSI Name");
			if(msi.contains(msiName)) {
				selenium.test.log(LogStatus.PASS, "Marketo Sales Insight details are visible");
				System.out.println("PASS");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Marketo Sales Insight details are not visible");
				selenium.reportFailure("Marketo Sales Insight details are not visible");
			}
			
			

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying Marketo Sales Insight" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying Marketo Sales Insight");
		}
	}
	
	@And("^view MHES Marketo Sales Insight list$")
	public void view_mhes_marketo_sales_insight_list() {
		try {

//			String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//			selenium.navigateToURL(url);
			selenium.waitingTime(10000);
			selenium.captureScreenShot();
//	        selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("marketo_section");
            selenium.scrollToElement("marketo_section");
            selenium.waitingTime(2000);
            selenium.captureScreenShot();
            
            String attribute_mark = selenium.getElement("marketo_attribute").getAttribute("aria-hidden");
            System.out.println("attribute "+attribute_mark);
            if (attribute_mark.equals("true")) {
                selenium.jsClick("marketo_section");
            }else{
                System.out.println("Marketo section is expanded");
            }
            selenium.switchToMultipleFrame("newAccountFrame");
			
			if(selenium.getElement("msiTabDetails1").isDisplayed()) {
				 System.out.println("inside pass");
				selenium.test.log(LogStatus.PASS, "Marketo Sales Insight details are visible");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "Marketo Sales Insight details are not visible");
				selenium.reportFailure("Marketo Sales Insight details are not visible");
			}
			 
			selenium.switchOutOfFrame();
			

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while verifying Marketo Sales Insight" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying Marketo Sales Insight");
		}
	}

}
