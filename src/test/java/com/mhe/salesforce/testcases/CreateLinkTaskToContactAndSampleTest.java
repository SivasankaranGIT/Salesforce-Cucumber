package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;


public class CreateLinkTaskToContactAndSampleTest {

	
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String todaysDate;
//	String contactURL="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0038000000pWCLSAA4/view";
//	String contactURLNew="https://mh--uat.sandbox.lightning.force.com/lightning/r/Contact/0030y00002ZlCWGAA3/view";
	  
	@And("^create and link contact and sample to a task$")
	public void create_link_contact_and_sample_to_a_task() {
		try {
			if(selenium.isElementPresentFast("closeBtn"))
			{
				selenium.click("closeBtn");
			}
			selenium.waitForElementToBeClickable("dispalyAsBtn");
			selenium.click("dispalyAsBtn");
//			selenium.waitingTime(2000);
//			selenium.waitingTime(2000);
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
				System.out.println("PASS");
				selenium.test.log(LogStatus.PASS, "Assigned to field is autopopulated with the user name: " + user);
			} else {
				System.out.println("FAIL");
				selenium.test.log(LogStatus.FAIL, "Assigned to field is not autopopulated");
				selenium.reportFailure("Assigned to field is not autopopulated");
			}

//			selenium.waitingTime(2000);
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
//			selenium.waitForXpathElementToBeClickable(nameXpath);
			selenium.clickLoopXpath(nameXpath);
			System.out.println(nameXpath);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("searchSample");
			selenium.type("searchSample", "Sample Name");
			selenium.clickDynamic("divTitle", "Sample Name", "end");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("Search_contact");
			selenium.type("Search_contact", "Contact Name");
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
			selenium.clickLoop("RecordSaveButton");
			/*flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);*/
			selenium.waitingTime(5000);
			

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
	
	@And("^verify task created linked with contact$")
	public void verify_task_created_linked_with_contactk()
	{
	try {	
//		selenium.waitingTime(3000);
		/*selenium.search("Contact Name");
		selenium.waitingTime(2000);
		
		//String xpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
		String contactXpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
		System.out.println(contactXpath);
		selenium.clickLoopXpath(contactXpath);*/
		
//		selenium.navigateToURL(contactURLNew);
//		System.out.println("contactURL:" + contactURLNew);
//		selenium.waitingTime(6000);
        selenium.waitForElementToBeVisible("viewAllOpenActLinkNew");
		selenium.scrollToElement("viewAllOpenActLinkNew");
		selenium.jsClick("viewAllOpenActLinkNew");
		selenium.waitingTime(4000);
		
		selenium.captureScreenShot();
		selenium.waitingTime(2000);		
//		selenium.ScrollTillPageEnd();
//		selenium.waitingTime(2000);
//		selenium.ScrollTillPageEnd();
//		selenium.waitingTime(2000);
//		selenium.ScrollTillPageEnd();
//		selenium.waitingTime(2000);
//		selenium.captureScreenShot();
//		selenium.waitingTime(2000);
//		selenium.clickLastXpath("lastOpenActivities");
//		selenium.scrollToElement("ContactActivityTableLastRecord");
//		selenium.waitingTime(5000);
//		selenium.scrollToElement("ContactActivityTableLastRecord");
//		selenium.waitingTime(5000);
//		selenium.scrollToElement("ContactActivityTableLastRecord");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("RecentlyAddedRecord");
		selenium.clickLoop("RecentlyAddedRecord");
//        selenium.waitForElementToBeClickable("ContactActivityTableLastRecord");
//		selenium.click("ContactActivityTableLastRecord");
//		String task = selenium.getDynamicXpath("anchorTitlecontains", "Subject", "endContains");
//		System.out.println("task:" +task);
//		selenium.clickLoopXpath(task);
		selenium.waitingTime(4000);
		
		
		
//		String dueDate = selenium.getText("dueDateGetTextNew");
//		System.out.println("Due date :"+dueDate);
//		System.out.println("Todays date :"+todaysDate);
		

//		if (dueDate.contains(todaysDate)) {
//			selenium.test.log(LogStatus.PASS, "Task created successfully, Linked to contact and is reflecting under Open Activities");
//		} else
//			selenium.test.log(LogStatus.FAIL, "Task creation failed ");
		
		
		
		selenium.captureScreenShot();
		selenium.waitingTime(2000);
		String anchorRelatedToOnTask=selenium.getDynamicXpath("anchorrelatedToOnTask", "Sample Name", "endContains");
		selenium.waitingTime(2000);
		System.out.println("anchorRelatedToOnTask:"+ anchorRelatedToOnTask);

		if(selenium.isElementPresentXpathFast(anchorRelatedToOnTask)){
			System.out.println("PASS");
			selenium.test.log(LogStatus.PASS, "Task created successfully and Linked to sample and Contact");
		}else
		{
			System.out.println("FAIL");
			selenium.test.log(LogStatus.FAIL, "Task not linked to sample and Contact");
			selenium.reportFailure("Task not linked to sample and Contact");
		}
	}
	catch (Exception e)
	{
		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		selenium.reportFailure("Test Case Failed");
	}
		
		
		
		
		
	}
	}
	
	
	

