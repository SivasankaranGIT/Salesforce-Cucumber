package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;

public class CreateLinkTaskToContactAndOpportunityTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String todaysDate;
	String yesterdaysDate;
	//String url;
	
	@And("^I switch to ALEKS home page$")
    public void switchToALEKSHomePage() {
		try {
	        if (selenium.isElementPresentFast("loginPopUp"))
	        {
	        	System.out.println("I am inside loginPopup method");
	        	selenium.clickLoop("loginPopUp");
	        	selenium.waitingTime(2000);	
	        }
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("menuDots");
			selenium.click("menuDots");
			selenium.waitingTime(3000);
			selenium.waitForElementToBeVisible("searchItemsTextField");
			selenium.getElement("searchItemsTextField").sendKeys("ALEKS");
			selenium.waitForElementToBeClickable("SaleslightningappALEKS");
			selenium.jsClick("SaleslightningappALEKS");
			selenium.waitingTime(10000);
			}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
    }
			
	@And("^I switch to MHHE home page$")
    public void switchToMHHEHomePage() {
		try {
			selenium.waitingTime(5000);
			if (selenium.isElementPresentFast("CXGApp"))
			{
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeVisible("searchItemsTextField");
				selenium.getElement("searchItemsTextField").sendKeys("MHHE");
//				selenium.waitingTime(2000);
				selenium.waitForElementToBeClickable("SaleslightningappMHHE");
				selenium.jsClick("SaleslightningappMHHE");
				selenium.waitingTime(4000);
			}
		selenium.waitForElementToBeClickable("allButtonLightning");
        selenium.click("allButtonLightning");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonL");
        selenium.click("AllButtonL");
        selenium.waitingTime(4000);
        selenium.type("searchallitems", "Screen Name");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("mhheHomePage");
        selenium.clickLoop("mhheHomePage");
        selenium.waitingTime(4000);
        selenium.test.log(LogStatus.INFO, "MHHE Home Page loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error occurred " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
    }
	
	@And("^create and link contact and opportunity to a task$")
	public void create_link_contact_opportunity_to_task() {
		try {
			if(selenium.isElementPresentFast("closeBtn"))
			{
				selenium.click("closeBtn");
			}
			selenium.waitForElementToBeClickable("dispalyAsBtn");
			selenium.click("dispalyAsBtn");
			selenium.waitingTime(2000);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("tableView");
			selenium.click("tableView");
			selenium.waitForElementToBeClickable("newTaskBtn");
			selenium.click("newTaskBtn");
			selenium.waitingTime(2000);

			selenium.clickDynamic("spantextContains", "Record Type", "endRadioBtn");
			selenium.waitForElementToBeClickable("nextBtn");
			selenium.click("nextBtn");

			String user = selenium.getText("assignedToTaskGetText");
			if (!user.isEmpty()) {
				selenium.test.log(LogStatus.PASS, "Assigned to field is autopopulated with the user name: " + user);
			} else {
				selenium.test.log(LogStatus.FAIL, "Assigned to field is not autopopulated");
				selenium.reportFailure("Assigned to field is not autopopulated");
			}

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subjectDropDwn");
			selenium.click("subjectDropDwn");
			selenium.clickDynamic("spanTitle", "Subject", "end");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("relatedToTaskArrow");
			selenium.click("relatedToTaskArrow");
			selenium.waitingTime(8000);
			String nameXpath = selenium.getDynamicXpath("spanTitle", "Related To", "end");
			selenium.waitingTime(6000);
			selenium.scrolldown(100);
			selenium.captureScreenShot();
			selenium.waitingTime(6000);
			selenium.clickLoopXpath(nameXpath);
			System.out.println(nameXpath);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchOpportunities");
			selenium.type("searchOpportunities", "Opportunity Name");
			selenium.waitingTime(4000);
			selenium.clickDynamic("divTitle", "Opportunity Name", "end");
			selenium.waitingTime(2000);			
			selenium.type("Search_contact", "Contact Name");
			selenium.waitingTime(2000);
			selenium.type("Search_contact", "Contact Name");
			selenium.waitingTime(4000);
			selenium.clickDynamic("divTitle", "Contact Name", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("taskTypeDropDwn");
			selenium.click("taskTypeDropDwn");
			selenium.waitingTime(2000);
			selenium.clickDynamic("anchorTitle", "Task Type", "end");
			selenium.waitingTime(2000);
			
			Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();

			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			todaysDate = sdf1.format(date);
			System.out.println(todaysDate);

			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			System.out.println(yesterdaysDate);

			/*selenium.scrollToElement("taskDueDate");
			selenium.typeData("taskDueDate", todaysDate);*/
			
			selenium.scrollToElement("taskDueDate1");
			selenium.typeData("taskDueDate1", todaysDate);

			selenium.scrollToElement("taskStartDate");
			selenium.typeData("taskStartDate", todaysDate);
			selenium.typeData("taskEndDate", todaysDate);
			selenium.waitingTime(2000);

			selenium.scrollToElement("taskStatus");
			selenium.click("taskStatus");
			selenium.waitingTime(2000);
			selenium.clickDynamic("anchorTitle", "Task Status", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.jsClick("RecordSaveButton");
			
		/*	flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);*/
			selenium.waitingTime(20000);

		} catch (Exception e) {
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
			selenium.waitingTime(3000);
			System.out.println("Error catch");
			boolean error = selenium.isElementPresentFast("ErrorListAll");
			System.out.println(error);
			if (error == true) {
				System.out.println("Error came");
				selenium.jsClick("closePopUp");
				selenium.waitingTime(2000);
				selenium.click("CancelButton");
			}

			else {
				System.out.println("inside else to click cancel");
				selenium.click("CancelButton");
			}
		}

	}
	
	@And("^verify task created linked with opportunity$")
	public void verify_opp_to_task() {
		try {
		selenium.refresh();
		selenium.waitingTime(10000);
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		String task = selenium.getDynamicXpath("anchorTitlecontains", "Subject", "endContains");
		System.out.println("Task:"+ task);
//		selenium.waitForXpathElementToBeClickable(task);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(task);
		selenium.waitingTime(4000);
		
		selenium.task=selenium.getURL();
		selenium.waitingTime(4000);
        selenium.waitForElementToBeVisible("dueDateGetTextNew");
		String dueDate = selenium.getTextLoop("dueDateGetTextNew");
		selenium.waitingTime(2000);
		System.out.println("DueDate :" + dueDate);

		if (dueDate.contains(todaysDate) || dueDate.contains(yesterdaysDate)) {
			selenium.test.log(LogStatus.PASS, "Task created successfully ");
			System.out.println("PASS - Task created successfully");
		} else
		{
			selenium.test.log(LogStatus.FAIL, "Task creation failed ");
			System.out.println("FAIL -Task creation failed ");
			selenium.reportFailure("Task creation failed");
		}
		/*selenium.clickLoop("relatedToLink");
		selenium.waitingTime(4000);
		selenium.jsClick("openActivitiesTab");
		selenium.waitingTime(2000);
		selenium.scrollToElement("relatedListLink");
		selenium.jsClick("viewAllLink");*/

		if (selenium.isElementPresentFast("closeBtn")) {
//			selenium.waitingTime(4000);
	        selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");

		}
//			selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("relatedToLink");
			selenium.clickLoop("relatedToLink");
//			selenium.waitingTime(4000);
	        selenium.waitForElementToBeVisible("openActLink1");
			selenium.scrollToElement("openActLink1");
			selenium.jsClick("openActLink1");

		selenium.waitingTime(4000);
		
		/*String contact = selenium.getDynamicXpath("anchorTitlecontains", "Contact Name", "endContains");
		selenium.clickLoopXpath(contact);
		selenium.waitingTime(4000);*/
		
//		selenium.navigateToURL(selenium.task);
		selenium.waitingTime(2000);
//		selenium.test.log(LogStatus.PASS, "Task created successfully and is reflecting under Open Activities");
//		System.out.println("PASS - Task created successfully and is reflecting under Open Activities");
		//selenium.jsClick("viewAllOpenActLink");
		//selenium.waitingTime(4000);
		
		//selenium.clickLoopXpath(task);
		selenium.navigateToURL(selenium.task);
		selenium.waitingTime(4000);
        selenium.waitForElementToBeVisible("dueDateGetTextNew");
		String dueDate1 = selenium.getTextLoop("dueDateGetTextNew");
		selenium.waitingTime(2000);
		System.out.println("DueDate1 : " + dueDate1);
		if (dueDate1.contains(todaysDate) || dueDate1.contains(yesterdaysDate)) {
			selenium.test.log(LogStatus.PASS, "Task created successfully and is reflecting under Open Activities");
			System.out.println("PASS - Task created successfully and is reflecting under Open Activities");
		} else
		{
			selenium.test.log(LogStatus.FAIL, "Task creation failed ");
			System.out.println("FAIL - Task creation failed");
			selenium.reportFailure("Task creation failed");
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Test Case Failed");
		}
		
		

	}
	

}
