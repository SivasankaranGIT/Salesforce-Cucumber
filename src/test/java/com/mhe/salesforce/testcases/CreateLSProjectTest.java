package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateLSProjectTest {
	
	WebConnector selenium = WebConnector.getInstance();
	String lsUrl;
	boolean flagsuccess;
	
	@And("^create LS Project$")
	public void create_LS_Project() throws InterruptedException {
		try {
//		String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity URL");
//		selenium.navigateToURL(url);
//		selenium.waitingTime(8000);
		
		selenium.waitForElementToBeClickable("moreActionsBtn");
		selenium.click("moreActionsBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("newLSProjectBtn");
		selenium.click("newLSProjectBtn");
		selenium.waitingTime(6000);
		
		selenium.switchToMultipleFrame("productframeUat");
		selenium.waitingTime(6000);
		
		String opp = selenium.getDynamicXpath("radioBtnStart", "Opp Name", "oppRadioBtn");
		System.out.println("opp xpath:" +opp);
		selenium.jsClickXpath(opp);
		selenium.waitingTime(2000);
		
		String product = selenium.getDynamicXpath("radioBtnStart", "Target Product", "primaryProductRadioBtn");
		System.out.println("product xpath:" +product);
//		selenium.waitForXpathElementToBeClickable(product);
		selenium.waitingTime(4000);
		selenium.jsClickXpath(product);
		selenium.waitingTime(2000);
		
		String productInUse = selenium.getDynamicXpath("radioBtnStart", "Product In Use", "primaryProductInUseRadioBtn");
		System.out.println("product-in-use xpath:" +productInUse);
//		selenium.waitForXpathElementToBeClickable(productInUse);
		selenium.waitingTime(4000);
		selenium.jsClickXpath(productInUse);
//		selenium.waitingTime(2000);

		selenium.waitForElementToBeClickable("Submit_Button");
		selenium.click("Submit_Button");
		selenium.waitingTime(10000);
		selenium.waitForElementToBeVisible("lsCreateDate");
		lsUrl=selenium.getURL();

		selenium.refresh();
		selenium.waitForElementToBeVisible("lsCreateDate");
		//selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/LS_Project__c/a3E55000000Sf9gEAC/view");
		
		String recordDate = selenium.getTextLoop("lsCreateDate");
		System.out.println("record date is : " + recordDate);
	 	Calendar calendar1 = Calendar.getInstance();
		Date date = calendar1.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
		String todaysdate = sdf.format(new Date());
		System.out.println("today date is : " + todaysdate);
		
		calendar1.setTime(date);
		calendar1.add(Calendar.DATE, -1);
		Date dateBefore1Day = calendar1.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
		String yesterdaysDate = sdf2.format(dateBefore1Day);
		System.out.println("yesterday/today date is : " + yesterdaysDate);
		
		if(recordDate.contains(todaysdate)|| recordDate.contains(yesterdaysDate)) {
			selenium.test.log(LogStatus.PASS, "LS Project created successfully today");
			System.out.println("PASS");
			selenium.waitingTime(2000);
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
		
	}
	
	@Then("^delete LS Project$")
	public void delete_LS_Project() throws InterruptedException {
		try {
		selenium.navigateToURL(lsUrl);
//		selenium.waitingTime(6000);
		selenium.waitForElementToBeClickable("DeleteActionBtn");
		
		selenium.click("DeleteActionBtn");
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("deleteBtn");
		selenium.click("deleteBtn");
//		selenium.waitingTime(1000);
		selenium.waitForElementToBeVisible("contactSuccessfulL");
		flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
		selenium.printLastTestResult(flagsuccess);

		selenium.test.log(LogStatus.PASS, "Record deleted successfully");
		
	}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}
	

}
