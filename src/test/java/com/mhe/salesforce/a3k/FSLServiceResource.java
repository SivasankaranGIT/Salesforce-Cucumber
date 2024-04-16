package com.mhe.salesforce.a3k;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;

public class FSLServiceResource {

    WebConnector selenium = WebConnector.getInstance();

    @Then("Click on the Service Resource you want to update SKILLS")
    public void click_on_the_service_resource_you_want_to_update_skills() {
        try {
        	selenium.refresh();
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeClickable("SearchThisList");
            selenium.typeData("SearchThisList","Amanda Landen");
            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.waitingTime(3000);
            if(selenium.isElementPresentFast("Service_Resources_All_Checkbox"))
            {
            	selenium.waitForElementToBeClickable("Service_Resources_All_Checkbox");
                selenium.jsClick("Service_Resources_All_Checkbox");
                selenium.waitingTime(2000);
            	selenium.waitForElementToBeClickable("Select_FirstServiceResource");
                selenium.jsClick("Select_FirstServiceResource");
            }
            else
            {
            	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/ServiceResource/0Hn8b000000PopQCAS/view");	//Amanda Landen SR URL
            }
            selenium.waitingTime(5000);
            selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Service Resource");
            selenium.reportFailure("Error while Selecting Service Resource" + e.getMessage());
        }
    }

    @Then("Go to the Resource Views section and click on SKILLS")
    public void go_to_the_resource_views_section_and_click_on_skills() {
        try {
            selenium.switchToFrame("newAccountFrame");
            selenium.scrollToElement("Skills_Tab");
            selenium.jsClick("Skills_Tab");
            selenium.switchToFrame("ResourceViewSkillsFrame");
            selenium.typeData("ServiceResourceSearchInput","ALEKS Support");
            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.click("ResourceViewCheckbox");
//            selenium.click("ResourceViewCheckbox");
            selenium.waitingTime(3000);
            selenium.takeScreenShot();
            selenium.click("ServiceResourceSavebutton");
            selenium.waitingTime(5000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while clicking the skills tab");
            selenium.reportFailure("Error while clicking the skills tab" + e.getMessage());
        }
    }

    @Then("Locate the Absences related list on the right hand side")
    public void locate_the_absences_related_list_on_the_right_hand_side() {
        try {
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.scrolldown(1000);
            selenium.waitingTime(2000);
            selenium.scrollToElement("ServiceAbsenceViewAllbutton");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
        	selenium.waitForElementToBeClickable("ServiceAbsenceViewAllbutton");
        	selenium.takeScreenShot();
            selenium.jsClick("ServiceAbsenceViewAllbutton");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Service Resource");
            selenium.reportFailure("Error while Selecting Service Resource" + e.getMessage());
        }
    }

    @Then("Click the down arrow and select NEW")
    public void click_the_down_arrow_and_select_new() {
        try {
            selenium.waitForElementToBeClickable("AbsenceNewbutton");
            selenium.takeScreenShot();
            selenium.jsClick("AbsenceNewbutton");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
            selenium.reportFailure("Error while selecting New Button" + e.getMessage());
        }
    }
    @Then("Select Non Availability and Click Next")
    public void select_non_availability_and_click_next() {
        try {
        	selenium.waitForElementToBeClickable("NewResourceAbsenceRadio");
            selenium.click("NewResourceAbsenceRadio");
        	selenium.waitForElementToBeClickable("NextButton");
            selenium.click("NextButton");
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }

    @Then("Enter Type Start Date End Date and Click Save")
    public void enter_type_start_date_end_date_and_click_save() {
        try {
        	selenium.waitForElementToBeClickable("ResourceAbsenceStart");
            selenium.typeData("ResourceAbsenceStart",selenium.getCurrentDate(0));
            selenium.waitingTime(1000);
        	selenium.waitForElementToBeClickable("ResourceabsenseEnd");
            selenium.typeData("ResourceabsenseEnd",selenium.getCurrentDate(0));
        	selenium.waitForElementToBeClickable("ResourceAbsenceEndTime");
            selenium.click("ResourceAbsenceEndTime");
            selenium.waitingTime(3000);
        	selenium.waitForElementToBeClickable("ResourceAbsenceEndTime");
            selenium.typeData("ResourceAbsenceEndTime", "12:30 PM");
            selenium.waitingTime(2000);
            selenium.pressEscapeKey();
            selenium.waitingTime(2000);
            selenium.takeScreenShot();
        	selenium.waitForElementToBeClickable("SaveRecordButton");
            selenium.click("SaveRecordButton");
            selenium.waitingTime(15000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Confirm the service resource absence is created")
    public void confirm_the_service_resource_absence_is_created() {
        try {
        	String FieldServieObjectPage="https://mh--uat.sandbox.lightning.force.com/lightning/n/FSL__FieldService";
        	selenium.navigateToURL(FieldServieObjectPage);
        	selenium.waitingTime(25000);
			selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitForElementToBeClickable("FieldServiceSearchEmployee");
            selenium.typeData("FieldServiceSearchEmployee","Melissa MacIntosh");
//            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.pressEscapeKey();
            selenium.waitingTime(5000);
            selenium.isElementPresentFast("FieldServiceVacation");
            selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }

    @Then("Click on the three dotes next to the service resource name on the gantt")
    public void click_on_the_three_dotes_next_to_the_service_resource_name_on_the_gantt() {
            try {
                selenium.waitForElementToBeClickable("FieldServiceName2");
                selenium.click("FieldServiceName2");
            } catch (Exception e) {
                selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
                selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
            }
        }

    @Then("Click on Details and Click the Calendar tab and go to the date the absence was created for Confirm it is visible on the Salesforce calendar")
    public void click_on_details_and_click_the_calendar_tab_and_go_to_the_date_the_absence_was_created_for_confirm_it_is_visible_on_the_salesforce_calendar() {
        try {
        		selenium.waitingTime(10000);
        		selenium.waitForElementToBeClickable("FieldServiceCalendar");
        		selenium.takeScreenShot();
                selenium.click("FieldServiceCalendar");
                selenium.scrolldown(2500);
                selenium.isElementPresentFast("FieldserviceAbsencevisibleCalendar2");
                selenium.test.log(LogStatus.PASS, "Resource Absence Event is visible in Calendar");
            } catch (Exception e) {
                selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
                selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
            }
        }

}


