package com.mhe.salesforce.testcases;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LeadManagementTest {

    WebConnector selenium = WebConnector.getInstance();


    @Then("^Validate access to MSI on an Account$")
    public void validate_access_to_MSI_on_an_Account() {

        try {
			selenium.navigateToURL(selenium.MHES_Contact_URL);
			selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("marketo_section");
            selenium.scrollToElement("marketo_section");
            selenium.scrolldown(-100);
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("marketo_attribute");
            String attribute_mark = selenium.getElement("marketo_attribute").getAttribute("aria-hidden");
            System.out.println("attribute "+attribute_mark);
            if (attribute_mark.equals("true")) {
            	selenium.waitForElementToBeClickable("marketo_section");
                selenium.jsClick("marketo_section");
            }else{
                System.out.println("Marketo scetion is expanded");
            }
            selenium.waitingTime(3000);
            selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(3000);
            if (selenium.isElementPresentFast("msiTabDetails1")) {
                selenium.test.log(LogStatus.PASS, "User has access to MSI on an Account");
            } else {
                selenium.test.log(LogStatus.FAIL, "User does not have access to MSI on an Account");
                selenium.reportFailure("Test Case Failed");
            }
            selenium.captureScreenShot();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
        selenium.switchOutOfFrame();
        selenium.waitingTime(2000);
    }

    @Then("^Validate user has access to MSI on a Contact and can view the Lead Score$")
    public void view_the_Lead_Score() {

        try {
//            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Contact URL");
//            selenium.navigateToURL(url);
            selenium.waitingTime(5000);
			selenium.waitForElementToBeVisible("marketo_section");
            selenium.scrollToElement("marketo_section");
            selenium.scrolldown(-100);
            selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("marketo_attribute");
            String attribute_mark = selenium.getElement("marketo_attribute").getAttribute("aria-hidden");
            System.out.println("attribute "+attribute_mark);
            if (attribute_mark.equals("true")) {
            	selenium.waitForElementToBeClickable("marketo_section");
                selenium.jsClick("marketo_section");
            }else{
                System.out.println("Marketo scetion is expanded");
            }
            selenium.waitingTime(3000);
            selenium.switchToMultipleFrame("newAccountFrame");
            selenium.waitingTime(3000);
            if (selenium.isElementPresentFast("msiTabDetails1")) {
            	System.out.println("PASS");
                selenium.test.log(LogStatus.PASS, "User has access to MSI on a Contact and can view the Lead Score");
            } else {
                selenium.test.log(LogStatus.FAIL, "User does not have access to MSI on a Contact and can view the Lead Score");
                System.out.println("FAIL");
                selenium.reportFailure("User does not have access to MSI on a Contact and can view the Lead Score");
            }
            selenium.captureScreenShot();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
        selenium.switchOutOfFrame();
        selenium.waitingTime(2000);
    }


    @And("^Validate Created By field in System information Section$")
    public void validate_createdByField() {
        try {
            selenium.waitingTime(8000);
			selenium.waitForElementToBeVisible("systemInfoSection");
            selenium.scrollToElement("systemInfoSection");
            selenium.waitingTime(2000);
            selenium.scrolldown(-200);
            selenium.waitingTime(2000);
            if (selenium.isElementPresentFast("createdByField")) {
                selenium.test.log(LogStatus.PASS, "Created By field is present in System information Section");
                System.out.println("PASS");
            } else {
                selenium.test.log(LogStatus.FAIL, "Created By field is not present in System information Section");
                System.out.println("FAIL");
                selenium.reportFailure("Created By field is not present in System information Section");
            }
            selenium.captureScreenShot();
        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^click on Lead based on Search$")
    public void click_on_contact_based_on_account_names() {

        try {
        	String LeadName = "Anusha Chari";
            selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("searchTextL_new");
            selenium.click("searchTextL_new");
            selenium.waitingTime(8000);
            selenium.typeData("searchTextL_new", LeadName);
            selenium.waitingTime(8000);
            //String xpath = selenium.getDynamicXpath("anchorTextcontains", "Account Name", "endSearchContactWithAccount");
            String contactXpath = selenium.getDynamicXpath_data("spanTitle", LeadName, "end");
            System.out.println(contactXpath);
            selenium.waitingTime(8000);
//            selenium.waitForXpathElementToBeClickable(contactXpath);
            selenium.clickLoopXpath(contactXpath);
            selenium.waitingTime(2000);
            selenium.captureScreenShot();

        }
        catch (Exception e) {
            selenium.reportFailure("Error while Searching for contact " + e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


    @And("^Create a New Lead$")
    public void create_New_Lead() {

        try {
        	selenium.waitForElementToBeClickable("newAccountOpportunityBtn1");
            selenium.click("newAccountOpportunityBtn1");
            selenium.waitingTime(4000);
            String CurrentDate = selenium.getCurrentDateTimeString("ddMMyyyyHHmmss");
            String lastName_excel = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
            String lastName =lastName_excel+CurrentDate;
            selenium.typeData("lastName",lastName);
            selenium.type("firstName","First Name");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("Leadsalutation");
            selenium.click("Leadsalutation");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("salutation_mr");
            selenium.click("salutation_mr");
            selenium.waitingTime(2000);
            selenium.typeData("LeadCompnay","MHHE");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("Save_Btn");
            selenium.click("Save_Btn");
            selenium.waitingTime(2000);
        }catch(Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate that Lead is created successfully$")
    public void lead_created_SuccessFully() {

        selenium.waitingTime(8000);
        try {
            String lastname = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Last Name");
            String nameXpath = selenium.getPropertiesObj().getProperty("Lead_heading").
                    replace("$val", lastname);
//            selenium.waitForXpathElementToBeVisible(nameXpath);
			selenium.waitingTime(4000);
            if(selenium.isElementPresentXpathFast(nameXpath)) {
                selenium.test.log(LogStatus.PASS, "New Test Lead created Successfully");
            }else{
                selenium.test.log(LogStatus.FAIL, "New Test Lead is not created");
                selenium.reportFailure("New Test Lead is not created");
            }
            selenium.captureScreenShot();
        }catch(Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Convert the Lead to Contact$")
    public void convert_Lead() {

//        selenium.waitingTime(8000);
//        selenium.refresh();
//        selenium.waitingTime(8000);
        try {selenium.waitForElementToBeClickable("convertButton");
            selenium.click("convertButton");
            selenium.waitingTime(5000);
            selenium.getElement("ActName").sendKeys(Keys.F5);
            selenium.waitForElementToBeClickable("convert_buttonNew");
            selenium.click("convert_buttonNew");
            selenium.waitingTime(10000);
//            selenium.waitForElementToBeVisible("leadConversionPopup");
//            if(selenium.isElementPresentFast("convertSuccessText1")){
//                selenium.captureScreenShot();
//                selenium.test.log(LogStatus.PASS, "Lead Converted Successfully");
//                System.out.println("PASS");
//                selenium.click("goToLead");
//                selenium.waitingTime(3000);
//            }
//            else{
//                selenium.test.log(LogStatus.FAIL, "Lead is not Converted");
//                System.out.println("FAIL");
//                selenium.reportFailure("Lead is not Converted");
//            }
            
            Assert.assertTrue(selenium.isElementPresentFast("LeadConvertedMsg"));
            selenium.test.log(LogStatus.PASS, "Lead Converted Successfully");
            System.out.println("PASS");
            selenium.click("goToLead");
            selenium.waitingTime(8000);
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @And("^Modify Lead Status$")
    public void modify_lead_status() {

        selenium.waitingTime(8000);
        try {
            selenium.waitForElementToBeClickableLongerDuration("editButton");
            selenium.click("editButton");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("leadStatusDD1");
            selenium.click("leadStatusDD1");
            selenium.waitingTime(2000);
//            selenium.click("leadStatusDD1");
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("leadStatusDisqualified");
            String attribute= selenium.getElement("leadStatusDisqualified").getAttribute("aria-checked");
            String status;
            if(attribute.equalsIgnoreCase("true")){
                selenium.click("leadStatusProspect");
                status="Prospect";
            }else{
                selenium.click("leadStatusDisqualified");
                status="Disqualified";
            }
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
            selenium.click("Save_Btn");
            selenium.waitingTime(5000);
            String statusXpath = selenium.getPropertiesObj().getProperty("statusText").
                    replace("$val", status);
//            selenium.waitForXpathElementToBeVisible(statusXpath);
            selenium.waitingTime(4000);
            String status_actual=selenium.getXpathElement(statusXpath).getText();
            System.out.println("Status : "+status_actual);
            if(status_actual.equalsIgnoreCase(status)){
                selenium.test.log(LogStatus.PASS, "Status change Successful");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Status change Failed");
                System.out.println("FAIL");
                selenium.reportFailure("Status change Failed");
            }
            selenium.captureScreenShot();

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }



    @Then("^Validate user has access to Marketo Sales Insight section$")
    public void view_the_MarketoSalesInsight() {

        try {
//            selenium.waitingTime(10000);
			selenium.waitForElementToBeVisible("marketo_section");
            selenium.scrollToElement("marketo_section");
            selenium.scrolldown(-100);
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("marketo_attribute");
            String attribute_mark = selenium.getElement("marketo_attribute").getAttribute("aria-hidden");
            System.out.println("attribute "+attribute_mark);
            if (attribute_mark.equals("true")) {
            	selenium.waitForElementToBeClickable("marketo_section");
                selenium.jsClick("marketo_section");
            }else{
                System.out.println("Marketo scetion is expanded");
            }
            selenium.switchToMultipleFrame("newAccountFrame");
            if (selenium.isElementPresentFast("score_marketo") && selenium.isElementPresentFast("marketo_InterestingMoment")&& selenium.isElementPresentFast("marketo_WebActivity")&& selenium.isElementPresentFast("marketo_email")) {
                selenium.test.log(LogStatus.PASS, "I  see a Marketo Sales Insight tab containing Interesting Moments, Web Activity, Score, and Email.");
            } else {
                selenium.test.log(LogStatus.FAIL, "I does not see a Marketo Sales Insight tab containing Interesting Moments, Web Activity, Score, and Email.");
                selenium.reportFailure("I does not see a Marketo Sales Insight tab containing Interesting Moments, Web Activity, Score, and Email.");
            }
            selenium.captureScreenShot();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
        selenium.switchOutOfFrame();
        selenium.waitingTime(2000);
    }

    @And("^Modify Lead Rating$")
    public void modify_lead_rating() {

        selenium.waitingTime(8000);
        try {
//            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Lead URL");
//            selenium.navigateToURL(url);
//            selenium.waitingTime(10000);
			selenium.navigateToURL(selenium.LeadURl);
			System.out.println("Navigated to Lead URL is : " + selenium.LeadURl);
            selenium.waitForElementToBeClickable("editButton");
            selenium.click("editButton");
//            selenium.waitingTime(6000);
			selenium.waitForElementToBeVisible("rating_label");
            selenium.scrollToElement("rating_label");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("newratingDD");
            selenium.click("newratingDD");
            selenium.waitingTime(4000);
//			selenium.waitForElementToBeVisible("ratingValue_hot");
//          String attribute= selenium.getElement("ratingValue_hot").getAttribute("aria-checked");
            String status;

            if(selenium.isElementPresentFast("selectfree_cal_selected")){
                selenium.waitingTime(2000);
            	selenium.waitForElementToBeClickable("ratingValue_cold");
                selenium.click("ratingValue_cold");
                status="Cold";
            }else{
                selenium.waitingTime(2000);
            	selenium.waitForElementToBeClickable("ratingValue_hot");
                selenium.click("ratingValue_hot");
                status="Hot";
            }
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("newratingreason");
            selenium.click("newratingreason");
            selenium.waitingTime(2000);
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ratingReason_competitor");
            selenium.click("ratingReason_competitor");
//            selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
            selenium.click("Save_Btn");
            selenium.waitingTime(5000);
            String statusXpath = selenium.getPropertiesObj().getProperty("statusText").
                    replace("$val", status);
//            selenium.waitForXpathElementToBeVisible(statusXpath);
            selenium.waitingTime(4000);
            String status_actual=selenium.getXpathElement(statusXpath).getText();
            System.out.println("Rating : "+status_actual);
            if(status_actual.equalsIgnoreCase(status)){
                selenium.test.log(LogStatus.PASS, "Rating change Successful");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Rating change Failed");
                System.out.println("FAIL");
                selenium.reportFailure("Test Case Failed");
            }
            selenium.captureScreenShot();

        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }
    @And("^Navigate to existing Opportunity URL$")
    public void click_on_existing_opportunity() {
        try {

            selenium.waitingTime(3000);
            String url = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Opportunity URL");
            selenium.navigateToURL(url);
            selenium.waitingTime(20000);
            selenium.test.log(LogStatus.INFO, "Navigated to the desired Opportunity" );
            selenium.captureScreenShot();
//            selenium.waitingTime(2000);
        }
        catch (Exception e) {
            selenium.reportFailure("Error while clicking Opportunity " + e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^Validate existing Task in Activity History tab$")
    public void validate_existing_Task_in_Activity_History_tab() {
        try {
        	selenium.navigateToURL(selenium.SEGSalesRepUserNewOppURL);
        	selenium.waitingTime(10000);
			selenium.waitForElementToBeClickable("activityTab");
            selenium.jsClick("activityTab");
            selenium.waitingTime(5000);

            if(selenium.isElementPresentFast("activityHistorySubject1") && selenium.isElementPresentFast("activityHistoryUser")){
                selenium.test.log(LogStatus.PASS, "Data found in activity history section");
                System.out.println("PASS");
            }else {
                selenium.test.log(LogStatus.FAIL, "Data not found in activity history section");
                System.out.println("FAIL");
                selenium.reportFailure("Test Case Failed");
            }
            selenium.captureScreenShot();

        }catch (Exception e){
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }


}
