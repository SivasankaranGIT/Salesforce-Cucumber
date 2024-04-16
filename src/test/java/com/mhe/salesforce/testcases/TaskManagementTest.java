package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TaskManagementTest {

    WebConnector selenium = WebConnector.getInstance();
   String profile;

    @And("^Navigate to \\\"([^\\\"]*)\\\" Task profile$")
    public void navigate_to_SEG_Sales_Rep_Task_profile(String url){
        try {

            selenium.waitingTime(3000);
//            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("SEG_Sales_Rep URL");
            selenium.navigateToURL(url);
            selenium.waitingTime(10000);
            selenium.test.log(LogStatus.INFO, "Navigated to the SEG_Sales_Rep profile page" );
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            profile ="SEG_Sales_Rep";
        }
        catch (Exception e) {
            selenium.reportFailure("Error while navigating page " + e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Navigate to MHHE_Sales_Representative Task profile$")
    public void navigate_to_MHHE_Sales_Representative_Task_profile(){
        try {

            selenium.waitingTime(3000);
            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("MHHE_Sales_Representative URL");
            selenium.navigateToURL(url);
            selenium.waitingTime(10000);
            selenium.test.log(LogStatus.INFO, "Navigated to the SEG_Sales_Rep profile page" );
            selenium.captureScreenShot();
            selenium.waitingTime(2000);
            profile ="MHHE_Sales_Representative";
        }
        catch (Exception e) {
            selenium.reportFailure("Error while navigating page " + e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Validate Record type for SEG Task$")
    public void validate_Record_type_forSEG_Task(){
        try{
            selenium.switchToFrame("newAccountFrame");
            System.out.println("Profile : "+profile);

            String task = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("RecordTypeSEG");
//            String task =  selenium.getTestDataFromPropertiesFile("RecordTypeSEG");
            System.out.println("task : "+task);
            if (task.equalsIgnoreCase("SEG Task")) {
                selenium.test.log(LogStatus.PASS, "Assigned Record Type is checked for : "+profile);
            }else{
                selenium.test.log(LogStatus.FAIL, "Assigned Record Type is not checked for : "+profile);
                selenium.reportFailure("Test Case Failed");
            }

        }catch(Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Validate Record type for MHE Task$")
    public void validate_Record_type_forMHE_Task(){
        try{
            selenium.switchToFrame("newAccountFrame");
            System.out.println("Profile : "+profile);

            String  task = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("RecordTypeMHE");
            System.out.println("task :"+ task);

//            String taskXpath = selenium.getPropertiesObj().getProperty("task_checkbox").
//                    replace("$val", task);
//            System.out.println("taskXpath : "+taskXpath);
//            selenium.waitingTime(5000);
//            String attribute= selenium.getXpathElement(taskXpath).getAttribute("checked");
//            System.out.println("attribute : "+attribute);
//            if(attribute.equalsIgnoreCase("true")){
            if (task.equalsIgnoreCase("MHE Task")) {
                selenium.test.log(LogStatus.PASS, "Assigned Record Type is checked for : "+profile);
            }else{
                selenium.test.log(LogStatus.FAIL, "Assigned Record Type is not checked for : "+profile);
                selenium.reportFailure("Test Case Failed");
            }

        }catch(Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


    @Then("^Create Task from Open Activity section$")
    public void create_Task_from_Open_Activity_section() {
        try {
			selenium.navigateToURL(selenium.opportunityURL);
			System.out.println("Navigated to opportunity URL : " + selenium.opportunityURL);
			selenium.waitingTime(5000);
        	selenium.refresh();
			selenium.waitingTime(5000);
            if(selenium.isElementPresentFast("openActivity")){
                selenium.scrollToElement("openActivity");
//                selenium.waitingTime(2000);
        		selenium.waitForElementToBeClickable("openActivity");
                selenium.jsClick("openActivity");
            }
//            selenium.waitingTime(5000);
    		selenium.waitForElementToBeVisible("openActivityOpportunity");
            selenium.scrollToElement("openActivityOpportunity");
            selenium.scrolldown(-100);
            selenium.captureScreenShot();
            selenium.jsClick("openActivityOpportunity");
            selenium.waitingTime(2000);
            selenium.test.log(LogStatus.INFO, "Clicked on Open Activities");

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^create task from Opportunity$")
    public void create_task_from_Opportunity() {
        try {

            selenium.waitingTime(6000);
    		selenium.waitForElementToBeClickable("newTaskBtn");
            selenium.jsClick("newTaskBtn");
            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("subjectDropDwn");
            selenium.waitingTime(2000);
            selenium.click("subjectDropDwn");
            selenium.waitingTime(4000);
            selenium.clickDynamic("spanTitle", "Subject", "end");
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("taskCallSourceDropDwn");
            selenium.click("taskCallSourceDropDwn");
            selenium.waitingTime(2000);
            selenium.clickDynamic("anchorTitle", "Call Source", "end");
            selenium.waitingTime(2000);

            Calendar calendar1 = Calendar.getInstance();
            Date date = calendar1.getTime();
            SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
            String todaysDate = sdf1.format(date);
            System.out.println(todaysDate);
            
            Date today = new Date();               
            SimpleDateFormat formattedDate = new SimpleDateFormat("M/d/yyyy");            
            Calendar c = Calendar.getInstance();        
            c.add(Calendar.DATE, 1);  // number of days to add      
            String tomorrow = (String)(formattedDate.format(c.getTime()));
            System.out.println("Tomorrows date is " + tomorrow);

            selenium.scrollToElement("taskDuedatenew");
            selenium.typeData("taskDuedatenew", todaysDate);
            selenium.scrollToElement("taskStartDate");
            selenium.typeData("taskStartDate", todaysDate);
            selenium.typeData("taskEndDate", tomorrow);
            
            
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeVisible("taskStatus");
            selenium.scrollToElement("taskStatus");
            selenium.click("taskStatus");
            selenium.waitingTime(2000);
            selenium.clickDynamic("anchorTitle", "Task Status", "end");
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeVisible("taskCommentsTextarea");
            selenium.scrollToElement("taskCommentsTextarea");
            selenium.type("taskCommentsTextarea", "Comments");
            selenium.waitingTime(2000);
            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("RecordSaveButton");
            selenium.click("RecordSaveButton");

            selenium.waitingTime(6000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }

    }

    @Then("^Edit task status$")
    public void edit_task_status() {
        try {
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("taskEditDD1");
            selenium.clickLoop("taskEditDD1");
//            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("editTask");
            selenium.jsClick("editTask");
//            selenium.waitingTime(6000);
    		selenium.waitForElementToBeVisible("taskStatus");
            selenium.scrollToElement("taskStatus");
            selenium.waitForElementToBeClickable("taskStatus");
            selenium.click("taskStatus");
            selenium.waitingTime(2000);
            selenium.clickDynamic("anchorTitle", "Task Status New", "end");
            selenium.waitingTime(2000);
            selenium.captureScreenShot();
            selenium.waitForElementToBeClickable("RecordSaveButton");
            selenium.click("RecordSaveButton");

            selenium.waitingTime(6000);

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate completed Task in Activity History tab$")
    public void validate_existing_Task_in_Activity_History_tab() {
        try {
			selenium.navigateToURL(selenium.opportunityURL);
			System.out.println("Navigated to opportunity URL : " + selenium.opportunityURL);
			selenium.waitingTime(5000);
            if(selenium.isElementPresentFast("activityHistoryTab")){
                selenium.scrollToElement("activityHistoryTab");
//                selenium.waitingTime(2000);
        		selenium.waitForElementToBeClickable("activityHistoryTab");
                selenium.jsClick("activityHistoryTab");
                selenium.waitingTime(2000);
            }
            selenium.waitForElementToBeClickable("activityHistory");
            selenium.jsClick("activityHistory");
            selenium.waitingTime(5000);
            selenium.captureScreenShot();
            String subject = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Subject");
            String subjectXpath = selenium.getPropertiesObj().getProperty("text_placeholder").
                    replace("$val", subject);
            // String name = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Name");
            //  String nameXpath = selenium.getPropertiesObj().getProperty("text_placeholder").
            //     replace("$val", name);
            if(selenium.isElementPresentXpathFast(subjectXpath)){
                selenium.test.log(LogStatus.PASS, "Task Present In Activity History Tab");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Task is not Present In Activity History Tab");
                selenium.reportFailure("Test Case Failed");
            }
            selenium.captureScreenShot();

        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Delete completed Task$")
    public void delete_completed_Task() {
        try {
            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("taskEditDD1");
            selenium.clickLoop("taskEditDD1");
            selenium.waitingTime(2000);
    		selenium.waitForElementToBeClickable("deleteTask");
            selenium.jsClick("deleteTask");
            selenium.waitingTime(4000);
    		selenium.waitForElementToBeClickable("deleteButton");
            selenium.click("deleteButton");
            selenium.waitingTime(6000);
            selenium.captureScreenShot();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

}
