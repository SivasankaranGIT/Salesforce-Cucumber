package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class VerifyDisciplineFlyerProductCatalogTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("Verify Discipline Flyer in Product Catalog$")
	public void Check_supplement_records() {
		try {
		selenium.switchToMultipleFrame("productframeUat");
		selenium.click("disciplineFlyer");
		selenium.waitingTime(4000);
		
		selenium.switchOutOfFrame();
		selenium.switchToFrame("productframeUat");
		//selenium.waitUntilLoaderLoads();
		selenium.waitForElementToBeVisible("generateFlyerBtn");
		selenium.selectDropdownText("disciplineDropDown", "Discipline");
		//selenium.waitUntilLoaderLoads();
		selenium.waitingTime(10000);
		selenium.waitForElementToBeClickable("generateFlyerBtn");
		selenium.jsClick("generateFlyerBtn");
		selenium.waitingTime(5000);
		selenium.switchToLastWindow();
		selenium.waitForElementToBeClickable("exportToPDFBtn");
		selenium.click("exportToPDFBtn");
		selenium.waitingTime(4000);
		selenium.close();
		selenium.switchBackToParentWindow();
		selenium.switchOutOfFrame();
		selenium.captureScreenShot();
		/*for(int i=0; i<=100;i++) {
			if(selenium.getElement("exportToPDFBtn").isDisplayed()==false) {
				System.out.println("Waiting for Export Button to be visible visible");
				i++;
			}
			else {
				System.out.println("Export Button is visible");
				selenium.click("exportToPDFBtn");
				selenium.waitingTime(4000);
				//selenium.close();
				selenium.switchBackToParentWindow();
				selenium.switchOutOfFrame();
				break;
			}
				
		}*/
	}
		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
		
	}

}
