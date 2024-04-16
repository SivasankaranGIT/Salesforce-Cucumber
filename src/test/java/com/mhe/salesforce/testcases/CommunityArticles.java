package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class CommunityArticles {
	
WebConnector selenium = WebConnector.getInstance();
	
	
	@Then("^verify ALEKS articles on support page$")
	public void verify_aleks_articles_on_support_page() {
		 try {
			 
			 selenium.switchToFrame("newAccountFrame");
			 selenium.waitingTime(4000);
			 selenium.waitForElementToBeVisible("ALEKSSupportURLNew");
			 String ALEKSurl = selenium.getText("ALEKSSupportURLNew");
			 System.out.println("ALEKSurl is " + ALEKSurl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(ALEKSurl);
			 selenium.waitForElementToBeVisible("articleSection");
			 selenium.captureScreenShot();
//			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeVisible("article");
			 selenium.getElement("article").sendKeys(Keys.CONTROL,Keys.ENTER);
			 selenium.waitingTime(3000);
			 selenium.switchToChildWindow();
			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeVisible("ALEKSArticlePageTitle");
			 boolean value = selenium.isElementPresentFast("articleQuickLinkSection");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "ALEKS article loaded" );
				 System.out.println("inside pass");
			 }
			 else {
				 selenium.refresh();
				 selenium.waitingTime(8000);
				 boolean value1 = selenium.isElementPresentFast("articleQuickLinkSection");
				 System.out.println(value1);
				 if (value1 == true) {
					 selenium.test.log(LogStatus.PASS, "ALEKS article loaded" );
					 System.out.println("inside pass");
				 }
				 else {
				 selenium.test.log(LogStatus.FAIL, "ALEKS article not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("ALEKS article not loaded");
				 }
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(4000);
			 selenium.close();
			 selenium.waitingTime(2000);
			 selenium.switchBackToParentWindow();
			 selenium.waitingTime(3000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
// 			 selenium.switchBackToParentWindow();
			 selenium.reportFailure("Error while loading ALEKS artcile URL  " + e.getMessage());
			 selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
	 }
	 
	 @Then("^verify CSOM articles on support page$")
	    public void verify_csom_articles_on_support_page() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("CSOMUrlNew");
			 String CSOMUrl = selenium.getText("CSOMUrlNew");
			 System.out.println("CSOMUrl is " + CSOMUrl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(CSOMUrl);
			 selenium.waitForElementToBeVisible("articleSection");
			 selenium.captureScreenShot();
//			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeVisible("article");
			 selenium.getElement("article").sendKeys(Keys.CONTROL,Keys.ENTER);
			 selenium.waitingTime(3000);
			 selenium.switchToChildWindow();
			 selenium.waitForElementToBeVisible("CSOMPageTitle");
			 boolean value = selenium.isElementPresentFast("articleQuickLinkSection");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "CSOM article loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "CSOM article not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("CSOM article not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(4000);
			 selenium.close();
			 selenium.waitingTime(2000);
			 selenium.switchBackToParentWindow();
			 selenium.waitingTime(3000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 }
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
				selenium.reportFailure("Error while loading CSOM Article URL  " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }
	 
	 @Then("^verify CXG articles on support page$")
	    public void verify_cxg_articles_on_support_page() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("CXGUrl");
			 String CXGUrl = selenium.getText("CXGUrl");
			 System.out.println("CXGUrl is " + CXGUrl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(CXGUrl);
			 selenium.waitForElementToBeVisible("articleSection");
			 selenium.captureScreenShot();
//			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeVisible("article");
			 selenium.getElement("article").sendKeys(Keys.CONTROL,Keys.ENTER);
			 selenium.waitingTime(3000);
			 selenium.switchToChildWindow();
			 selenium.waitForElementToBeVisible("CXGPageTitle");
			 boolean value = selenium.isElementPresentFast("articleQuickLinkSection");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "CXG article loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "CXG article not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("CXG article not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(4000);
			 selenium.close();
			 selenium.waitingTime(2000);
			 selenium.switchBackToParentWindow();
			 selenium.waitingTime(3000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
		 
		 }
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
				selenium.reportFailure("Error while loading CXG article URL  " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }

	 @Then("^verify DTS articles on support page$")
	    public void verify_dts_articles_on_support_page() {
		 try {
			 selenium.switchToFrame("newAccountFrame");
//			 selenium.waitingTime(2000);
			 selenium.waitForElementToBeVisible("DTSUrl");
			 String DTSUrl = selenium.getText("DTSUrl");
			 System.out.println("DTSUrl is " + DTSUrl);
			 selenium.waitingTime(2000);
			 selenium.navigateToURL(DTSUrl);
			 selenium.waitForElementToBeVisible("articleSection");
			 selenium.captureScreenShot();
//			 selenium.waitingTime(3000);
			 selenium.waitForElementToBeVisible("article");
			 selenium.getElement("article").sendKeys(Keys.CONTROL,Keys.ENTER);
			 selenium.waitingTime(3000);
			 selenium.switchToChildWindow();
			 selenium.waitForElementToBeVisible("DTSPageTitle");
			 boolean value = selenium.isElementPresentFast("articleQuickLinkSection");
			 System.out.println(value);
			 if (value == true) {
				 selenium.test.log(LogStatus.PASS, "DTS article loaded" );
				 System.out.println("inside pass");
			 }
			 else { 
				 selenium.test.log(LogStatus.FAIL, "DTS article not loaded" );
				 System.out.println("inside fail");
				 selenium.reportFailure("DTS article not loaded");
			 }
			 selenium.captureScreenShot();
//			 selenium.waitingTime(4000);
			 selenium.close();
			 selenium.waitingTime(2000);
			 selenium.switchBackToParentWindow();
			 selenium.waitingTime(3000);
			 selenium.navigateBack();
			 selenium.waitingTime(2000);
			 selenium.switchOutOfFrame();
			 selenium.waitingTime(2000);
		 
		 }
		 catch (Exception e) {
			 selenium.switchBackToParentWindow();
				selenium.reportFailure("Error while loading DTS article URL  " + e.getMessage());
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				}
	 }
	 

}
