package com.mhe.salesforce.testcases;

import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ExistingEventModification {

	WebConnector selenium = WebConnector.getInstance();
	
	@When("^Navigate to digital training Calendar$")
    public void navigate_to_digital_training_screen() {
		try {
		selenium.waitForElementToBeClickable("allButtonLightning");
        selenium.click("allButtonLightning");
        selenium.waitingTime(4000);
        selenium.waitForElementToBeClickable("AllButtonL");
        selenium.click("AllButtonL");
        selenium.waitingTime(4000);
        selenium.type("searchallitems", "Screen Name");
        selenium.waitingTime(2000);
        selenium.waitForElementToBeClickable("Calendar");
        selenium.click("Calendar");
    //    selenium.clickLoop("digitalTrainingTabSearch");
        selenium.waitingTime(2000);
        selenium.test.log(LogStatus.INFO, "Digital training screen loaded successfully!");
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
    }
	
	@Then("^I go to the new events$")
	public void i_go_to_the_events() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			String eventID = selenium.getValueByColumnName("eventId");
			String event= selenium.Eventtitle+eventID+"/view";
			selenium.navigateToURL(event);
			selenium.waitingTime(2000);
		}
	}

	@And("^I Edit the event$")
	public void editEvent() {
		try {
			selenium.navigateToURL(selenium.eventURL);
			selenium.waitingTime(5000);
			System.out.println("Current URL:" + selenium.getURL());
		selenium.waitForElementToBeClickable("EditButton");
		selenium.click("EditButton");
		selenium.clearText("Calendarsubject");
		selenium.waitingTime(3000);
		selenium.type("Calendarsubject","Subject");
		selenium.waitForElementToBeClickable("ShowtimeButton_cal");
		selenium.click("ShowtimeButton_cal");
		selenium.waitingTime(2000);
		if(selenium.isElementPresentFast("selectfree_cal_selected"))
		{
			selenium.click("selectfree_cal_selected");
		}
		else
		{
			selenium.click("selectfree_cal");
		}
		selenium.waitForElementToBeClickable("SimpleTextBox");
		selenium.click("SimpleTextBox");
		selenium.clearText("SimpleTextBox");
		selenium.type("SimpleTextBox","Text");
		selenium.waitingTime(2000);
		selenium.waitForElementToBeClickable("show_time_as");
		selenium.clickLoop("show_time_as");
		selenium.click("free_span_select");
		selenium.waitForElementToBeClickable("SaveBtnNew1");
		selenium.click("SaveBtnNew1");
		selenium.waitingTime(4000);
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	
	}
	
	@Then("^I validate the edit details on new events$")
	public void eventEditMEssage() {
		String Expected=null;
		String Actual=null;
//		selenium.waitingTime(3000);
		selenium.waitForElementToBeVisible("free_span");
		
		Actual=selenium.getText("free_span");
		
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
