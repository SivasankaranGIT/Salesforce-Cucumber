package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditeventTest {

	WebConnector selenium = WebConnector.getInstance();


//	@When("^I go to the events$")
//	public void i_go_to_the_events() {
//		if (selenium.getUI().equalsIgnoreCase("lightning")) {
//			selenium.navigateToURL(selenium.Eventtitle);
//			selenium.waitingTime(2000);
//		}
//	}

	@And("^I Edit event$")
	public void editEvent() {
		selenium.waitForElementToBeClickable("EditButton");
		selenium.click("EditButton");
		selenium.clearText("Calendarsubject");
		selenium.type("Calendarsubject","Subject");
	}
	
	@And("^I validate the edit details on events$")
	public void eventEditMEssage() {
		String Expected=null;
		String Actual=null;
//		selenium.waitingTime(2000);
		selenium.waitForElementToBeVisible("eventMeeting");
		Actual=selenium.getText("eventMeeting");
		Expected=selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("eventMeeting");
		selenium.test.log(LogStatus.INFO, "EVent subject: " + Actual);
		if (Actual.contains(Expected)) {
			selenium.test.log(LogStatus.PASS, "Test Case Passed!");
		} else {
			selenium.reportFailure("Test Case Failed");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");

		}
	}		
		
	}
