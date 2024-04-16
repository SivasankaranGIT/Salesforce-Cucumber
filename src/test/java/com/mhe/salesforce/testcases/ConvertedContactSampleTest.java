package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ConvertedContactSampleTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String sampleUrl ="";

	@Then("^add products to sample$")
	public void add_products_to_sample() {
		try {
			if(selenium.newContacts != null)
			{
				selenium.navigateToURL(selenium.newContacts);
			}
			else
			{
				System.out.println("selenium.newContacts is NULL");
				selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002WMbbcAAD/view");
			}

			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("sampleContactButton");
			selenium.click("sampleContactButton");
			selenium.waitingTime(4000);
			selenium.switchToMultipleFrame("productframeUat");
			selenium.waitingTime(8000);
			if(selenium.isElementPresentFast("searchProductsBtn"))
			{
				System.out.println("Clicking on searchProductsBtn");
				selenium.waitForElementToBeClickable("searchProductsBtn");
				selenium.click("searchProductsBtn");
			}
			else
			{
				selenium.refresh();
				selenium.waitingTime(10000);
				selenium.switchToMultipleFrame("productframeUat");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("searchProductsBtn");
				selenium.click("searchProductsBtn");
			}

			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("clearButton");

			selenium.click("clearButton");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("isbnField");
			String ISBN = "9781260953862";
			selenium.typeData("isbnField", ISBN);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("searchBtn");

			selenium.click("searchBtn");
			selenium.waitingTime(15000);

//			String checkBox = selenium.getDynamicXpath("divText", "ISBN", "searchProductCheckBoxDynamic");
//			selenium.waitForXpathElementToBeClickable(checkBox);
			String checkBox = selenium.getDynamicXpath_data("divText", ISBN, "searchProductCheckBoxDynamic");
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(checkBox);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("addToSampleAndCloseBtn");

			selenium.clickLoop("addToSampleAndCloseBtn");
			selenium.waitingTime(4000);

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
	}

	@Then("^create Sample Contact for converted contact$")
	public void create_sample() {

		try {
			selenium.waitForElementToBeClickableLongerDuration("ClickNextButton");
			selenium.click("ClickNextButton");
//			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("createSampleOrderBtn");
			selenium.jsClick("createSampleOrderBtn");
			selenium.waitingTime(8000);

			if (selenium.waitForElementToBeVisible("duplicateSamplePopup") == true) {
				selenium.waitForElementToBeClickable("dupOverrideOptionCheckBox");
				selenium.click("dupOverrideOptionCheckBox");
				selenium.waitForElementToBeClickable("duplicateOKButton");
				selenium.click("duplicateOKButton");
			}

			selenium.waitingTime(4000);
		//	selenium.switchOutOfFrame();

			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("sampleLinknew");
				selenium.clickLoop("sampleLinknew");
			} else {
				selenium.waitForElementToBeClickable("sampleLinknew");
				selenium.clickLoop("sampleLinknew");
			}
			selenium.waitingTime(7000);
			sampleUrl = selenium.getURL();
			System.out.println(sampleUrl);
			selenium.test.log(LogStatus.INFO, "Sample URL : "+sampleUrl);
			selenium.refresh();
			selenium.waitingTime(6000);

			/*String str[] = selenium.convertedContactName.split(" ");

			String sample = selenium.getDynamicXpathProperty("anchorTitlecontains", str[1].concat(str[0]),
					"endContains");
			selenium.clickLoopXpath(sample);

			selenium.waitingTime(10000);
			sampleUrl = selenium.getURL();
			System.out.println(sampleUrl);
			selenium.test.log(LogStatus.INFO, "Sample URL : "+sampleUrl);

			String date = selenium.getTextLoop("sampleStatusDateGetText_new");

			SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
			String todaysdate = sdf.format(new Date());
			System.out.println(todaysdate);
			System.out.println("App date : "+date);
			if (date.equalsIgnoreCase(todaysdate)) {
				selenium.test.log(LogStatus.PASS, "Sample contact created successfully today");
			}*/
			
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			selenium.waitForElementToBeVisible("lastModifiedDateRecordNew2");
//			String recordDate =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
			String recordDate = selenium.getText("lastModifiedDateRecordNew2");
			System.out.println("todays date"+todaysDate);
			System.out.println("record date"+recordDate);
			
			if(recordDate.contains(todaysDate)) {
				System.out.println("inside date check");
				selenium.waitForElementToBeClickable("sampleRecordTable");
				selenium.jsClick("sampleRecordTable");
				selenium.waitingTime(4000);
				selenium.test.log(LogStatus.PASS, "Sample contact created successfully today");
			}
			else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("lastCreatedDateRecord");
				selenium.jsClick("lastCreatedDateRecord");
				selenium.waitingTime(3000);
//				String recordDate1 =  selenium.getElement("lastModifiedDateRecord").getAttribute("innerHTML");
				String recordDate1 = selenium.getText("lastModifiedDateRecordNew2");
				if(recordDate1.contains(todaysDate)) {
					System.out.println("date matched");
					selenium.waitForElementToBeClickable("sampleRecordTable");
					selenium.jsClick("sampleRecordTable");
					selenium.waitingTime(4000);
					selenium.test.log(LogStatus.PASS, "Sample contact created successfully today");
				}
				else {
					selenium.test.log(LogStatus.FAIL, "Sample creation failed ");
					selenium.reportFailure("Sample creation failed");
				}
			}

		}

		catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while creating sample order " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}

	@Then("^delete record as Sys admin$")
	public void delete() {

		try {
		/*
			selenium.searchString(selenium.convertedContactName);
			selenium.waitingTime(6000);
			
			String Xpath = selenium.getDynamicXpathProperty("deleteMenuStartNew", selenium.convertedContactName, "deleteMenuEnd");
            selenium.waitingTime(3000);
            System.out.println("xpath is"+Xpath);
            selenium.clickLoopXpath(Xpath);
            selenium.waitingTime(4000);


		 */
			selenium.navigateToURL(sampleUrl);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("MoreActionBtn2");
			selenium.click("MoreActionBtn2");
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DeleteRecord");
			selenium.click("DeleteRecord");
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("deleteBtn");
			selenium.click("deleteBtn");

			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);

			selenium.test.log(LogStatus.PASS, "Record deleted successfully");

		} catch (Exception e) {
			selenium.switchOutOfFrame();
			selenium.reportFailure("Error while deleting record" + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}

	}
}
