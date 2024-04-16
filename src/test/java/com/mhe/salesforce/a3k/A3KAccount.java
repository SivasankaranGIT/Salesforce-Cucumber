package com.mhe.salesforce.a3k;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class A3KAccount {
    WebConnector selenium = WebConnector.getInstance();

    @When("^I navigate to A3K Account$")
    public void i_navigate_to_a3k_account() {
        try{
            selenium.navigateToURL_propertiesFile("A3KAccount");
        }catch (Exception e){
            System.out.println("Inside i_navigate_to_a3k_account catch");
            e.printStackTrace();
            selenium.captureScreenShot();
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }

    @When("^I create from Account a new Opportunity of Record Type \"([^\"]*)\"$")
    public void i_create_from_Account_a_new_Opportunity_of_Record_Type(String recordType) {
        try{
          /*  switch (recordType) {
                case "DAG_New_Field" -> recordType = "dagNewField";
                case "DAG_Renewal" -> recordType = "dagRenewal";
                default -> {
                    selenium.test.log(LogStatus.FAIL, recordType + ": Provided Record Type is not recognized. Add path to properties");
                    selenium.reportFailure(recordType + ": Provided Record Type is not recognized. Add path to properties");
                }
            }*/
            selenium.click("opp_Link");
            selenium.click("NewActionButton");
            selenium.click(recordType);
            selenium.click("NextButton");
        }catch (Exception e){
            System.out.println("Inside i_create_from_Account_a_new_Opportunity_of_Record_Type catch");
            e.printStackTrace();
            selenium.captureScreenShot();
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the time zone operating hours")
    public void i_verify_the_time_zone_operating_hours(){
        try {
            selenium.url=selenium.getURL();
            System.out.println(selenium.url);
            selenium.refresh();
            selenium.waitingTime(15000);
            selenium.scrollToElement("OperatingHoursEditBtn");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("OperatingHoursGetText");
            String operatingHours = selenium.getText("OperatingHoursGetText").toString();
            System.out.println("Operating Hours From UI is :"+operatingHours);
            if (operatingHours.contains("Denver"))
            {
                System.out.println("PASS!!!  Operating Hours are Matching");
                selenium.test.log(LogStatus.PASS, "Operating Hours are Matching");
            }
            else
            {
                System.out.println("FAIL!!!  Operating Hours are not Matching");
                selenium.test.log(LogStatus.FAIL, "Operating Hours are not Matching");
                selenium.reportFailure("Operating Hours are not Matching");
            }
        }catch (Exception e){
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the Exclude Monthly Exclude Weekly touch points")
    public void i_verify_the_exclude_monthly_exclude_weekly_touch_points() {
        try {
            Calendar calendar= Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 0);
            Date today=calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String todayDate = sdf.format(today);
            System.out.println(todayDate);
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.scrollToElement("ExcludeMonthlyEditBtn");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ExcludeMonthlyEditBtn");
            selenium.jsClick("ExcludeMonthlyEditBtn");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("ExcludeMonthlyTextBox");
            selenium.typeData("ExcludeMonthlyTextBox",todayDate);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ExcludeWeeklyTextBox");
            selenium.typeData("ExcludeWeeklyTextBox",todayDate);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ClickOnRandomCheckBox");
            selenium.jsClick("ClickOnRandomCheckBox");
            selenium.waitingTime(2000);
            String excludeMonthlyTime=selenium.getElement("ExcludeMonthlyTextBox1").getAttribute("data-value").toString();
            System.out.println("Exclude Monthly Time is : "+excludeMonthlyTime);
            selenium.waitingTime(2000);
            String excludeWeeklyTime=selenium.getElement("ExcludeWeeklyTextBox2").getAttribute("data-value").toString();
            System.out.println("Exclude Monthly Time is : "+excludeWeeklyTime);
            selenium.waitingTime(2000);
            if((excludeMonthlyTime.isBlank()||excludeMonthlyTime.isEmpty())&&(excludeWeeklyTime.isBlank()||excludeWeeklyTime.isEmpty()))
            {

                System.out.println("FAIL!!!  Time is not present automatically");
                selenium.test.log(LogStatus.FAIL, "Time is not present automatically");
                selenium.reportFailure("Time is not present automatically");
            }
                else
            {
                System.out.println("PASS!!!  Time is present automatically");
                selenium.test.log(LogStatus.PASS, "Time is present automatically");
            }
            selenium.waitForElementToBeClickable("ExcludeMonthlyTextBox");
            selenium.clearText("ExcludeMonthlyTextBox");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ExcludeWeeklyTextBox");
            selenium.clearText("ExcludeWeeklyTextBox");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ClickOnRandomCheckBox");
            selenium.jsClick("ClickOnRandomCheckBox");
            selenium.waitingTime(2000);
            excludeMonthlyTime=selenium.getElement("ExcludeMonthlyTextBox1").getAttribute("data-value").toString();
            System.out.println("Exclude Monthly Time is : "+excludeMonthlyTime);
            selenium.waitingTime(2000);
            excludeWeeklyTime=selenium.getElement("ExcludeWeeklyTextBox2").getAttribute("data-value").toString();
            System.out.println("Exclude Monthly Time is : "+excludeWeeklyTime);
            selenium.waitingTime(2000);
            if((excludeMonthlyTime.isBlank()||excludeMonthlyTime.isEmpty())&&(excludeWeeklyTime.isBlank()||excludeWeeklyTime.isEmpty()))
            {
                System.out.println("PASS!!!  Time is not present");
                selenium.test.log(LogStatus.PASS, "Time is not present");
            }
            else
            {
                System.out.println("FAIL!!!  Time is present");
                selenium.test.log(LogStatus.FAIL, "Time is present");
                selenium.reportFailure("Time is present");
            }
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the sharepoint account name and record id")
    public void i_verify_the_sharepoint_account_name_and_record_id(){
        try{
 //           selenium.url=selenium.getURL();
            selenium.waitForElementToBeClickable("CancelButton");
            selenium.jsClick("CancelButton");
            selenium.waitingTime(2000);
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.scrollToElement("LMSEditBtn");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("SharepointAccountNameGetText");
            String sharepointAccountName=selenium.getText("SharepointAccountNameGetText").toString();
            System.out.println("Sharepoint Account Name from UI is : "+sharepointAccountName);
            String[] parts=sharepointAccountName.split(" ");
            String part1=parts[0];
            String part2=parts[1];
            System.out.println("Part 1 is : "+part1);
            System.out.println("Part 2 is : "+part2);

            System.out.println("Account Name is :"+selenium.randomString);
            System.out.println("Record Id from URL is : "+selenium.url);
            if(sharepointAccountName.contains(selenium.randomString)&&selenium.url.contains(part2))
            {
                System.out.println("PASS!!! Account name and Record Id are present");
                selenium.test.log(LogStatus.PASS, "Account name and Record Id are present");
            }
            else
            {
                System.out.println("FAIL!!!  Account name and Record Id are not present");
                selenium.test.log(LogStatus.FAIL, "Account name and Record Id are not present");
                selenium.reportFailure("Account name and Record Id are not present");
            }
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.scrollToElement("LMSEditBtn");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("LMSEditBtn");
            selenium.jsClick("LMSEditBtn");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("Save_Btn");
            selenium.jsClick("Save_Btn");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeVisible("snagerror");
            if(selenium.isElementPresentsuperFast("snagerror"))
            {
                System.out.println("PASS!!! Cannot Save the record");
                selenium.test.log(LogStatus.PASS, "Cannot Save the record");
            }
            else
            {
                System.out.println("FAIL!!!  Record Saved");
                selenium.test.log(LogStatus.FAIL, "Record Saved");
                selenium.reportFailure("Record Saved");
            }
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I click work order button")
    public void i_click_work_order_button(){
        try{
            selenium.waitForElementToBeClickable("CancelButton");
            selenium.jsClick("CancelButton");
            selenium.waitingTime(2000);
            selenium.refresh();
            selenium.waitingTime(20000);
            selenium.waitForElementToBeClickable("Create_WorkOrder_Button");
            selenium.jsClick("Create_WorkOrder_Button");
            selenium.waitingTime(5000);
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the type dropdown picklist")
    public void i_verify_the_type_dropdown_picklist(){
        try{
            selenium.waitForElementToBeClickable("Type_DropDown");
            selenium.jsClick("Type_DropDown");
            selenium.waitingTime(2000);
            if(!selenium.isElementPresentsuperFast("TypeWorkOderOption1")&&
            selenium.isElementPresentsuperFast("TypeWorkOderOption2")&&
            selenium.isElementPresentsuperFast("TypeWorkOderOption3")&&
            selenium.isElementPresentsuperFast("TypeWorkOderOption4")&&
            selenium.isElementPresentsuperFast("TypeWorkOderOption5"))
            {
                System.out.println("FAIL!!!  Picklist value found");
                selenium.test.log(LogStatus.FAIL, "Picklist value found");
                selenium.reportFailure("Picklist value found");
            }
            else
            {
                System.out.println("PASS!!! No Picklist value found");
                selenium.test.log(LogStatus.PASS, "No Picklist value found");
            }

        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I open an existing record")
    public void i_open_an_existing_record(DataTable table){
        List<String> data = table.transpose().asList(String.class);
        try{
            selenium.waitingTime(2000);
            selenium.navigateToURL(data.get(0));
            selenium.waitingTime(7000);
            Assert.assertTrue(selenium.isElementPresentFast("OwnerNameNew"));
            System.out.println("Record Opened Successfully");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the work order tab and new button")
    public void i_verify_the_work_order_tab_and_new_btn(){
            try{
            selenium.waitForElementToBeVisible("WorkOrdersTab");
            Assert.assertTrue(selenium.isElementPresentFast("WorkOrdersTab"));
            System.out.println("PASS!!! Work Order tab is present");
            selenium.jsClick("WorkOrdersTab");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeVisible("NewBtn");
            Assert.assertTrue(selenium.isElementPresentFast("NewBtn"));
            System.out.println("PASS!!! New button is present in work order");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the work order tab and new button on opportunity")
    public void i_verify_the_work_order_tab_and_new_btn_on_opp(){
        try{
            selenium.waitForElementToBeVisible("WorkOrdersTabOpp");
            Assert.assertTrue(selenium.isElementPresentFast("WorkOrdersTabOpp"));
            System.out.println("PASS!!! Work Order tab is present");
            selenium.jsClick("WorkOrdersTabOpp");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeVisible("NewButton");
            Assert.assertTrue(selenium.isElementPresentFast("NewButton"));
            System.out.println("PASS!!! New button is present in work order");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the consultant request record")
    public void i_verify_the_consultant_request_record() {
        try {
            Assert.assertFalse(selenium.isElementPresentFast("NewButtonToAdd"));
            System.out.println("PASS!!! New button is not present");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ConsultantRequestListViewBtn");
            selenium.jsClick("ConsultantRequestListViewBtn");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("SearchList");
            selenium.typeData("SearchList","All Consultant Requests");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("SelectAllConsultantReq");
            selenium.jsClick("SelectAllConsultantReq");
            selenium.waitingTime(20000);
            selenium.waitForElementToBeClickable("SelectFirstRecord");
            selenium.jsClick("SelectFirstRecord");
            selenium.waitingTime(8000);
            selenium.switchToMultipleFrame("switch_iFrame");
            selenium.waitingTime(3000);
            Assert.assertFalse(selenium.isElementPresentsuperFast("EditBtnTop"));
            System.out.println("PASS!!! Edit button is not present");
            selenium.waitingTime(2000);
            Assert.assertFalse(selenium.isElementPresentsuperFast("DeleteBtnVerify"));
            System.out.println("PASS!!! Delete button is not present");
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the consultant record")
    public void i_verify_the_consultant_record(){
        try{
            Assert.assertFalse(selenium.isElementPresentFast("Click_New"));
            System.out.println("PASS!!! New button is not present");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ConsultantListViewBtn");
            selenium.jsClick("ConsultantListViewBtn");
            selenium.waitForElementToBeClickable("SearchList");
            selenium.typeData("SearchList","All");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ConsultantAllBtn");
            selenium.jsClick("ConsultantAllBtn");
            selenium.waitingTime(20000);
            selenium.waitForElementToBeClickable("SelectFirstRecord");
            selenium.jsClick("SelectFirstRecord");
            selenium.waitingTime(8000);
            selenium.switchToMultipleFrame("switch_iFrame");
            selenium.waitingTime(3000);
            Assert.assertFalse(selenium.isElementPresentsuperFast("EditBtnTop"));
            System.out.println("PASS!!! Edit button is not present");
            selenium.waitingTime(2000);
            Assert.assertFalse(selenium.isElementPresentsuperFast("DeleteBtnVerify"));
            System.out.println("PASS!!! Delete button is not present");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("AssignmentBtn");
            selenium.jsClick("AssignmentBtn");
            selenium.waitingTime(2000);
            Assert.assertFalse(selenium.isElementPresentsuperFast("NewRequestBtn"));
            System.out.println("PASS!!! Request button is not present");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("Verify the New crf button")
    public void verify_the_new_crf_btn(){
        try{
            Assert.assertFalse(selenium.isElementPresentsuperFast("NewCrfBtn"));
            System.out.println("PASS!!! Button is not present");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("Verify the New crf button in opp")
    public void verify_the_new_crf_btn_in_opp(){
        try {
            Assert.assertFalse(selenium.isElementPresentsuperFast("NewCrfBtn"));
            System.out.println("PASS!!! Button is not present");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("Verifying user is able to create daily new orders report")
    public void verifying_user_is_able_to_create_daily_new_orders_report(){
        try{
            //Below url is to run the report after clicking on edit button it has filters.
            selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/Report/00O8b000009RDBIEA4/view?queryScope=userFolders");
            selenium.waitingTime(20000);
            selenium.switchToMultipleFrame("ReportIframe");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ReportEditBtn");
            selenium.jsClick("ReportEditBtn");
            selenium.switchOutOfFrame();
            selenium.waitingTime(20000);
            selenium.switchToMultipleFrame("ReportIframeNew");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ReportRunBtn");
            selenium.jsClick("ReportRunBtn");
            selenium.switchOutOfFrame();
            selenium.waitingTime(20000);
            selenium.switchToMultipleFrame("ReportIframe");
            selenium.waitingTime(2000);
            Assert.assertTrue(selenium.isElementPresentFast("ReportEditBtn"));
            System.out.println("PASS!!! Report run successfully");
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("I verify the fields on service territory screen")
    public void i_verify_the_fields_on_service_territory_screen(){
        try{
            selenium.waitForElementToBeClickable("ServiceTerritoryListViewDrpDwn");
            selenium.jsClick("ServiceTerritoryListViewDrpDwn");
            selenium.waitingTime(1000);
            selenium.waitForElementToBeClickable("ServiceTerritorySelectListView");
            selenium.jsClick("ServiceTerritorySelectListView");
            selenium.waitingTime(10000);
            selenium.waitForElementToBeClickable("ServiceTerritoryFirstRecord");
            selenium.jsClick("ServiceTerritoryFirstRecord");
            selenium.waitingTime(8000);
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.waitForElementToBeClickable("PrimarySchedulerEditBtn");
            selenium.jsClick("PrimarySchedulerEditBtn");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("PrimarySchedulerCrossBtn");
            selenium.jsClick("PrimarySchedulerCrossBtn");
            selenium.waitingTime(1000);
            selenium.waitForElementToBeClickable("search_People");
            selenium.clearText("search_People");
            selenium.waitingTime(1000);
            selenium.typeData("search_People","Amy Stumpf");
            selenium.autoSuggestiveDropdownWithoutText("search_People");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ServiceTerritoryPLDCrossBtn");
            selenium.jsClick("ServiceTerritoryPLDCrossBtn");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("PLDDropDown");
            selenium.clearText("PLDDropDown");
            selenium.waitingTime(1000);
            selenium.typeData("PLDDropDown","Amy Stumpf");
            selenium.autoSuggestiveDropdownWithoutText("PLDDropDown");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("AutoDispatchCheckBox");
            selenium.jsClick("AutoDispatchCheckBox");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("AvailableAsSecondaryCheckBox");
            selenium.jsClick("AvailableAsSecondaryCheckBox");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ActiveCheckBox");
            selenium.jsClick("ActiveCheckBox");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("Save_Btn");
            selenium.jsClick("Save_Btn");
            selenium.waitingTime(6000);
            Assert.assertFalse(selenium.isElementPresentFast("snagerror"));
            System.out.println("PASS");

        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
}
