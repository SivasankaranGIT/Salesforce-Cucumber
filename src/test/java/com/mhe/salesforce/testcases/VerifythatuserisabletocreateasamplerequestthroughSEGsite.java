package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class VerifythatuserisabletocreateasamplerequestthroughSEGsite {

	WebConnector selenium = WebConnector.getInstance();
	@And("^I create new SEG campaign$")
	public void I_create_new_SEG_campaign() {
		
		 try {

			 selenium.waitingTime(5000);
			 if(selenium.isElementPresentFast("CloseNotificationPopup"))
			 {
				 System.out.println("Notification Alert Popup Appeared. So, closing it..");
				 selenium.click("CloseNotificationPopup");
			 }
			 selenium.waitingTime(2000);
	 		 selenium.waitForElementToBeClickable("NewBtn");
			 selenium.click("NewBtn");
//	 		 selenium.waitForElementToBeClickable("segCampaignRadioButton1");
//			 selenium.click("segCampaignRadioButton1");
//			 selenium.waitingTime(2000);
//			 
//			 if(selenium.isElementPresentFast("newCampaignHeader")==true) {
//				 selenium.waitForElementToBeClickable("segCampaignRadioButton1");
//					selenium.jsClick("segCampaignRadioButton1");
//					selenium.waitingTime(5000);
//				}
//			 	selenium.waitForElementToBeClickable("nextButtonCampaign");
//				selenium.click("nextButtonCampaign");
				selenium.waitingTime(5000);
				
				if(selenium.isElementPresentFast("newCampaignSEGHeader")==true) {
					selenium.waitForElementToBeClickable("campaignName");
					selenium.click("campaignName");
					selenium.type("campaignName", "Campaign Name");
//					selenium.waitingTime(2000);
					String date = selenium.getCurrentDateTimeString("MM/dd/yyyy");
			 		selenium.waitForElementToBeVisible("campaignStartDatenew");
					selenium.scrollToElement("campaignStartDatenew");
					selenium.typeData("campaignStartDatenew", date);
//					selenium.waitingTime(2000);
			 		selenium.waitForElementToBeVisible("campaignEndDate");
					selenium.scrollToElement("campaignEndDate");
					//selenium.type("campaignEndDate", "End Date");
					selenium.typeData("campaignEndDate", date);
					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					
					selenium.scrollToElement("channelFunctionTitle");
					selenium.clickDynamic("spanTitle", "Channel", "end");
					selenium.waitForElementToBeClickable("channelmoveSelectionArrow");
					selenium.click("channelmoveSelectionArrow");
					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					
					selenium.scrollToElement("leadFunctionTitle");
					selenium.clickDynamic("spanTitle", "Lead", "end");

					selenium.waitForElementToBeClickable("leadmoveSelectionArrow1");
					selenium.click("leadmoveSelectionArrow1");

					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					
					
					selenium.scrollToElement("campaignBudgetinput");
					selenium.waitForElementToBeClickable("campaignBudgetinput");
					selenium.click("campaignBudgetinput");
					selenium.type("campaignBudgetinput", "Campgain");
					selenium.waitingTime(2000);
					selenium.captureScreenShot();
					
					selenium.waitForElementToBeClickable("savecampaignnew");
					selenium.clickLoop("savecampaignnew");
					selenium.waitingTime(8000);
					selenium.captureScreenShot();
					selenium.newCampaignURL = selenium.getURL();
					System.out.println("The newly created campaign url is :" + selenium.newCampaignURL);	
				}			 
		 }
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
				selenium.reportFailure("Error on sample creation " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
}
	
	@Then("^click on campaign product list and enter product$")
	public void click_on_campaign_product_list_and_enter_product() {
		
		 try {
			 System.out.println("Adding product to campaign");
			 selenium.waitingTime(4000);
	 		 selenium.waitForElementToBeClickable("campgainProduct");
			 selenium.jsClick("campgainProduct");			 
			 selenium.waitingTime(5000);
	 		 selenium.waitForElementToBeClickable("NewButton");
			 selenium.clickLoop("NewButton");
			 selenium.waitingTime(5000);	
//			 if(selenium.isElementPresentFast("newCampaignProduct")==true) {
			 System.out.println("Inside add product");
			 selenium.waitForElementToBeClickable("search_producttextbox");
			 selenium.type("search_producttextbox", "Product Name");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("showAllResultsFromDropDwn");
			 selenium.clickLoop("showAllResultsFromDropDwn");
			 selenium.waitingTime(6000);
			 String prodsearch = selenium.getDynamicXpath("anchorTextcontains", "Product Name", "endContains");
			 System.out.println(prodsearch);
			 selenium.waitingTime(2000);
			 selenium.clickLoopXpath(prodsearch);
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeClickable("Save_Btn");
			 selenium.jsClick("Save_Btn");
			 selenium.waitingTime(8000);
			 selenium.waitForElementToBeClickable("campgainNavigateBack1");
			 selenium.jsClick("campgainNavigateBack1");
			 selenium.waitingTime(4000);
			 selenium.captureScreenShot();
//			 }			 
			 }
		 catch (Exception e) {
			 
				selenium.reportFailure("Error on adding product to sample  " + e.getMessage());
				selenium.waitingTime(3000);
				System.out.println("Error catch");
				boolean error = selenium.isElementPresentFast("ErrorListAll");
				System.out.println(error);
				if (error == true) 
				{
					System.out.println("Error came");
					selenium.jsClick("closePopUp");
					selenium.waitingTime(2000);
					selenium.click("CancelButton");
				}

				else 
				{
					System.out.println("inside else to click cancel");
					selenium.click("CancelButton");
				}
				
	

	}
}
	
	@Then("^Go to segSiteUrl and submit$")
	public void Go_to_segSiteUrl_and_submit() {
		
		 try {
//			 selenium.waitingTime(2000);
		 	 selenium.waitForElementToBeVisible("leadurl");
			 String url= selenium.getElement("leadurl").getAttribute("href");
			 System.out.println(url);
			 String url1=url.replace("Leads", "Contact");
			 System.out.println(url1);
			 String cid = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Cid");
			 String Contacturl=url1+"&cid="+cid;
			 System.out.println(Contacturl);
			 
			 
			  selenium.waitingTime(3000);
			 	selenium.jsClickNewTab();
			 	selenium.waitingTime(2000);
			 	selenium.switchToChildWindow();
			 	
			 	selenium.waitingTime(4000);
			 	selenium.navigateToURL(url1);
			 	selenium.captureScreenShot();
//			 	selenium.waitingTime(2000);
			 	 selenium.waitForElementToBeVisible("besttimetocall1");
			 	selenium.type("besttimetocall1", "besttimetocall");
//			 	selenium.waitingTime(2000);
			 	 selenium.waitForElementToBeVisible("commentsArea1");
			 	selenium.type("commentsArea1", "commentsArea");
//			 	selenium.waitingTime(2000);
//			 	 selenium.waitForElementToBeClickable("haveArepContactme");
//			 	selenium.click("haveArepContactme");
			 	
//			 	selenium.waitingTime(2000);
			 	//selenium.scrollToElement("selectOrderconfirm");
//			 	selenium.waitingTime(2000);
			 //	selenium.selectDropdownText("selectOrderconfirm", "selectOrderconfirm");
			 	
//			 	selenium.waitingTime(2000);
			 	 selenium.waitForElementToBeVisible("submitButtonSample");
			 	selenium.scrollToElement("submitButtonSample");
			 	selenium.click("submitButtonSample");
			 	selenium.waitingTime(10000);
			 	selenium.switchBackToParentWindow();
			 	
			 	
			 
			 
		 }
	
	catch (Exception e) {
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Error on creating sample  " + e.getMessage());
		
	}

}
	
}