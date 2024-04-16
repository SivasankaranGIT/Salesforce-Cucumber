package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserMaintenanceTest {

    WebConnector selenium = WebConnector.getInstance();





    @Then("^I Validate the user role$")
    public void i_Validate_the_user_role() {

        try {
//            selenium.waitForElementToBeClickable("Cancel_Acc_C");
        	selenium.waitingTime(8000);
            selenium.defaultframe();
            selenium.waitingTime(5000);
            selenium.switchToFrame("newAccountFrame");
            selenium.waitingTime(5000);
            Select dropdown = new Select(selenium.getElement("selectProfile"));
            List<WebElement> dd = dropdown.getOptions();
            System.out.println("Total number of Profile List : "+dd.size());
            ArrayList<String> profile_list = new ArrayList<>();
            for (int j = 0; j < dd.size(); j++) {
                profile_list.add(dd.get(j).getText());

            }
            System.out.println(profile_list);
            selenium.test.log(LogStatus.INFO, "Profile is present in the List : "+profile_list);
            String actual_Profiles = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Profiles");
            System.out.println("Actual Profiles :" + actual_Profiles);
            String[] profile = actual_Profiles.split(",");
            for (int i=0;i<profile.length;i++){
                if(profile_list.contains(profile[i])){
                    System.out.println("Profile is present in the List");
                    selenium.test.log(LogStatus.PASS, "Profile is present in the List : "+profile[i]);
                }else {
                    System.out.println("Profile does not present in the List");
                    selenium.test.log(LogStatus.FAIL, "Profile is present in the List : "+profile[i]);
                    selenium.reportFailure("Test Case Failed");
                }
            }
            selenium.captureScreenShot();
        } catch (Exception e) {
        selenium.reportFailure(e.getMessage());
        selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

    @Then("^I Click on Cancel User$")
    public void i_Click_on_Cancel_User() {

        try {
        	selenium.waitForElementToBeClickable("Cancel_Acc_C");
            selenium.click("Cancel_Acc_C");
            selenium.waitingTime(8000);
            selenium.refresh();
            selenium.waitingTime(5000);
           // selenium.waitForElementToBeVisible("edit");
            selenium.refresh();
            selenium.waitingTime(8000);
            selenium.captureScreenShot();
        } catch (Exception e) {
            selenium.reportFailure(e.getMessage());
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
        }
    }

//    public void check_Switch_UserInterface() {
//    	try {
//        selenium.test.log(LogStatus.INFO, "Checking the user interface");
//        boolean isLightning = selenium.isElementPresentFast("searchTextL");
//        if (!isLightning) {
//            selenium.test.log(LogStatus.INFO, "Classic Detected! Switching to Lightning");
//            selenium.click("lightning");
//            selenium.test.log(LogStatus.INFO, "Clicked on the Lightning link");
//            isLightning = selenium.isElementPresentFast("searchTextL");
//            if (isLightning)
//                selenium.test.log(LogStatus.PASS, "Successfully switched to the lightning view");
//            else
//                selenium.reportFailure("Error faced while switching to the lightning view");
//            	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//        }
//
//        selenium.setImplicitWait(5);
//        if (selenium.isElementPresentFast("loginPopUp"))
//            selenium.click("loginPopUp");
//        selenium.setDefaultImplicitWait();
//    	}
//    	catch (Exception e)
//    	{
//    		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
//    		selenium.reportFailure("Error occurred " + e.getMessage());
//    	}
//    }
    }
