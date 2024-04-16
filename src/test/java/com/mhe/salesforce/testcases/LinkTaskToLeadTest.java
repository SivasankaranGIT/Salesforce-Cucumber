package com.mhe.salesforce.testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;

public class LinkTaskToLeadTest {

	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String todaysDate;
	String url;

	@And("^create and link lead to a task$")
	public void create_link_lead_to_task() {
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
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(8000);
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
				selenium.reportFailure("Test Case Failed");
			}

			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("subjectDropDwn");
			selenium.click("subjectDropDwn");
			selenium.clickDynamic("spanTitle", "Subject", "end");
			selenium.waitingTime(2000);

			if (selenium.getTestCaseName().contains("LinkTaskToLead"))
			{
				selenium.waitForElementToBeClickable("nameTaskSelectArrow");
				selenium.click("nameTaskSelectArrow");
				String nameXpath = selenium.getDynamicXpath("spanTitle", "Name", "end");
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(nameXpath);
				selenium.waitingTime(2000);
				selenium.type("searchLeads", "Lead Name");
				selenium.clickDynamic("divTitle", "Lead Name", "end");
				selenium.waitingTime(2000);
			}

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
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.click("RecordSaveButton");
			selenium.waitingTime(4000);
//			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
//			selenium.printLastTestResult(flagsuccess);
			selenium.waitingTime(2000);
			selenium.refresh();
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("FirstTableRecord");
			selenium.click("FirstTableRecord");
			selenium.waitingTime(4000);
			selenium.taskURL = selenium.getURL();
			System.out.println("Newly created task URL is : " + selenium.taskURL);
			// selenium.waitForElementToBeClickable("homepageTab");
			// selenium.click("homepageTab");
			// selenium.waitingTime(2000);

		} catch (Exception e) {
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

	@And("^verify task created linked with Lead$")
	public void verify_lead_to_task() throws ParseException {
		try {
		selenium.waitingTime(5000);
		selenium.scrollToElement("viewTaskLink");
		selenium.click("viewTaskLink");
		selenium.waitingTime(4000);
		selenium.test.log(LogStatus.INFO, "Task screen loaded successfully!");

		String task = selenium.getDynamicXpath("anchorTitlecontains", "Subject", "endContains");
//		selenium.waitForXpathElementToBeClickable(task);
		selenium.waitingTime(4000);
		selenium.clickLoopXpath(task);
		selenium.waitingTime(4000);
		
		url=selenium.getURL();
		selenium.waitingTime(4000);
		//selenium.scrollToElement("dueDateGetText");

//		Calendar calendar2 = Calendar.getInstance();
//		Date date1 = calendar2.getTime();
//		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd,yyyy");
//		String todayDate = sdf2.format(date1);

		String dueDate = selenium.getText("dueDateGetText").toString();
//		String dueDateNew = sdf2.format(dueDate);

		System.out.println("Due Date is: "+ dueDate);
		System.out.println("Today date is: "+ todaysDate);

//	    Date date01 = sdf2.parse(dueDateNew);
//	    Date date02 = sdf2.parse(todayDate);
//	    System.out.println("date01" + date01 + "date02" + date02);
	    Boolean isSameDate = todaysDate.equals(dueDate);

	    if(isSameDate){
			selenium.test.log(LogStatus.PASS, "Task created successfully ");
	        System.out.println(dueDate+" is equals to "+todaysDate);
	    }
		else
		{
			selenium.test.log(LogStatus.FAIL, "Task creation failed ");
			System.out.println(dueDate+" is not equals to "+todaysDate);
		}
	    selenium.waitForElementToBeClickable("nameLink");
		selenium.click("nameLink");
		selenium.waitingTime(4000);
		/*selenium.click("activityTab");

		selenium.waitingTime(3000);

		if (selenium.isElementPresentFast("upcomingTaskText") && selenium.isElementPresentFast("todayText")) {
			selenium.test.log(LogStatus.PASS, "You have an upcoming task");
		} else {
			selenium.test.log(LogStatus.FAIL, "No tasks present");
		}*/
		selenium.mouseHover("salesAcceptedTabHeader");
		selenium.refresh();
		selenium.waitingTime(5000);
		if (selenium.isElementPresentFast("closeBtn")) {
			selenium.waitForElementToBeClickable("closeBtn");
			selenium.click("closeBtn");
			selenium.waitForElementToBeClickable("openActivitiesLink");
			selenium.click("openActivitiesLink");
		} else {
			selenium.waitForElementToBeClickable("activityTab");
			selenium.jsClick("activityTab");
			//selenium.click("openActivitiesLink");
		}

		selenium.waitingTime(4000);
		//String task = selenium.getDynamicXpathProperty("anchorTitle", taskName, "end");
		selenium.navigateToURL(url);
		selenium.waitingTime(3000);

		selenium.test.log(LogStatus.PASS,
				"The task is available in Open Activities section.");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
		
	}
	
	@And("^delete the task created with link$")
	public void delete_task_link() {
		try {
		selenium.navigateToURL(url);
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("actionDropdownBtn");

		selenium.clickLoop("actionDropdownBtn");
		selenium.waitingTime(2000);

		selenium.waitForElementToBeClickable("DeleteRecord");
		selenium.click("DeleteRecord");
//		selenium.waitingTime(5000);
		selenium.waitForElementToBeClickable("deleteBtn");
		selenium.click("deleteBtn");

		flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
		selenium.printLastTestResult(flagsuccess);

		selenium.test.log(LogStatus.PASS, "Task deleted successfully");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}