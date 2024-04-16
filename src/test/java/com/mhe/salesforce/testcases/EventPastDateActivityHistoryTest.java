package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.When;

public class EventPastDateActivityHistoryTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	String url;

	@When("^Navigate to Events screen$")
	public void navigate_to_events_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
		selenium.click("allButtonLightning");
		selenium.waitingTime(4000);
		selenium.waitForElementToBeClickable("AllButtonL");
		selenium.click("AllButtonL");
		selenium.waitingTime(4000);
		selenium.type("searchallitems", "Screen Name");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("eventsTabSearch");
		selenium.clickLoop("eventsTabSearch");
		selenium.waitingTime(2000);
		selenium.test.log(LogStatus.INFO, "Events screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}

	@When("^I change event to past date$")
	public void change_date() {
		try {
//			selenium.waitForElementToBeVisible("viewCalendarLink");
//			selenium.scrollToElement("viewCalendarLink");
//			selenium.click("viewCalendarLink");
			selenium.navigateToURL(selenium.eventURL);
			selenium.waitingTime(5000);
			System.out.println("Current URL:" + selenium.getURL());
//			selenium.test.log(LogStatus.INFO, "Calendar Event screen loaded successfully!");
			// selenium.click("myCalendarEventLink");
			/*String event = selenium.getDynamicXpath("anchorText", "Event Name", "end");
			selenium.clickLoopXpath(event);
			selenium.waitingTime(4000);*/
			
//			selenium.navigateToURL(selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Event URL"));
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("EditButton");
			selenium.click("EditButton");
			selenium.waitingTime(4000);

			Calendar calendar1 = Calendar.getInstance();
			calendar1.add(Calendar.DAY_OF_YEAR, -1);
			Date tomorrow1 = calendar1.getTime();

			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String pastDate = sdf1.format(tomorrow1);
			System.out.println(pastDate);

			selenium.scrollToElement("eventStartDate");
			selenium.typeData("eventStartDate", pastDate);
			selenium.typeData("eventEndDate", pastDate);
//			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("RecordSaveButton");
			selenium.click("RecordSaveButton");
			selenium.waitingTime(15000);
			/*selenium.waitForElementToBeVisible("contactSuccessfulL");
			flagsuccess = selenium.isElementPresentFast("contactSuccessfulL");
			selenium.printLastTestResult(flagsuccess);*/
//			selenium.waitingTime(4000);
			selenium.waitForElementToBeVisible("productNameGetTextNew");
			String taskName = selenium.getTextLoop("productNameGetTextNew").toString();
			selenium.waitForElementToBeClickable("relatedToLink");
			selenium.clickLoop("relatedToLink");
			selenium.waitingTime(4000);
			/*selenium.click("activityTab");
			
			selenium.waitingTime(3000);
			
			///String task= selenium.getDynamicXpath("taskNameDynamic", "Event Name", "end");
			//selenium.scrollToXpathElement(task);
			if(selenium.isElementPresentFast("pastEventText")) {
				selenium.test.log(LogStatus.PASS, "You had a calendar event");
			}
			else {
				selenium.test.log(LogStatus.FAIL, "No events present");
			}*/
			
			if (selenium.isElementPresentFast("closeBtn")) {
				selenium.waitForElementToBeClickable("closeBtn");
				selenium.click("closeBtn");
				selenium.waitForElementToBeClickable("activityTab");
				selenium.click("activityTab");
			} else {
				selenium.waitForElementToBeClickable("activityTab");
				selenium.jsClick("activityTab");
			}
			
			selenium.waitingTime(4000);
			String task = selenium.getDynamicXpathProperty("anchorTitle", taskName, "eventpasdateend");
			selenium.scrolldown(300);
			System.out.println(task);
			selenium.jsClickXpath(task);
			selenium.waitingTime(3000);

			selenium.test.log(LogStatus.PASS,
					"The event is available in Activity history section.");
			System.out.println("PASS - The event is available in Activity history section.");

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

}
