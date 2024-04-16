package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadTest {

        WebConnector selenium = WebConnector.getInstance();


        @When("^I navigate to File Object$")
        public void i_navigate_to_file_object()  {
                try {

//                        selenium.waitingTime(5000);
    					selenium.waitForElementToBeClickable("menuDots");
                        selenium.click("menuDots");
                        selenium.waitingTime(3000);
    					selenium.waitForElementToBeVisible("searchItemsTextField");
                        selenium.type("searchItemsTextField", "New Files");
//                        selenium.waitingTime(2000);
    					selenium.waitForElementToBeClickable("filesObject");
                        selenium.jsClick("filesObject");
                        selenium.waitingTime(5000);
                }
                catch (Exception e) {
                		selenium.test.log(LogStatus.FAIL, "Test Case Failed");
                        selenium.reportFailure("Error while navigating to Files " + e.getMessage());
                }

        }

        @Then("^I Upload a file$")
        public void i_upload_files() {
                try {
						selenium.waitForElementToBeClickable("uploadFiles");
                        selenium.click("uploadFiles");
                        selenium.waitingTime(4000);
                        String workingDir = System.getProperty("user.dir");
                        System.out.println("project dir "+workingDir);
                        String path = workingDir+"\\data\\test.txt";
                        System.out.println(path);
                        StringSelection ss = new StringSelection(path);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        selenium.waitingTime(5000);
                        selenium.waitForElementToBeClickable("doneButton");
                        selenium.click("doneButton");
                        selenium.waitingTime(4000);

                } catch (Exception e) {
                        selenium.reportFailure(e.getMessage());
                        selenium.test.log(LogStatus.FAIL, "Test Case Failed");
                }

        }

        @And("^verify the US Taxonomy$")
        public void verify_the_US_Taxonomy() {
                try {
                        selenium.captureScreenShot();
                        selenium.waitForElementToBeClickable("libraries");
                        selenium.click("libraries");
                        selenium.waitingTime(2000);
                        if(selenium.isElementPresentFast("usTaximony")){
                                selenium.test.log(LogStatus.PASS, "US Taximony is present");
                        }else{
                                selenium.test.log(LogStatus.FAIL, "US Taximony is not present");
                                selenium.reportFailure("US Taximony is not present");
                        }
                        selenium.captureScreenShot();

                } catch (Exception e) {
                selenium.reportFailure(e.getMessage());
                }
        }
        @Then("^I View File detatls and Document Link$")
        public void i_View_File_detatls_and_Document_Link() {
                try {
                		selenium.waitForElementToBeClickable("ownesByMe");
                        selenium.click("ownesByMe");
//                        selenium.waitingTime(3000);
    					selenium.waitForElementToBeClickable("showAction");
                        selenium.click("showAction");
//                        selenium.waitingTime(2000);
    					selenium.waitForElementToBeClickable("viewFileDetails");
                        selenium.click("viewFileDetails");
//                        selenium.waitingTime(5000);
    					selenium.waitForElementToBeClickable("detailTab_files");
                        selenium.click("detailTab_files");
//                        selenium.waitingTime(3000);
//                        selenium.captureScreenShot();
                        if(selenium.isElementPresentFast("clickHereDocumentLink")){
                                selenium.test.log(LogStatus.PASS, "clickHereDocumentLink is present");
                        }else{
                                selenium.test.log(LogStatus.FAIL, "clickHereDocumentLink is not present");
                                selenium.reportFailure("clickHereDocumentLink is not present");
                        }
                        selenium.captureScreenShot();
                }catch (Exception e){
                        selenium.reportFailure(e.getMessage());
                        selenium.test.log(LogStatus.FAIL, "Test Case Failed");
                }
                }

        @And("^I Delete uploaded file$")
        public void i_Delete_uploaded_file() {
                try {
						selenium.waitForElementToBeClickable("moreAction");
                        selenium.jsClick("moreAction");
//                        selenium.waitingTime(2000);
    					selenium.waitForElementToBeClickable("DeleteRecord");
                        selenium.jsClick("DeleteRecord");
//                        selenium.waitingTime(5000);
    					selenium.waitForElementToBeClickable("deleteBtn");
//                        selenium.captureScreenShot();
                        selenium.click("deleteBtn");
                        selenium.waitingTime(5000);

                }catch (Exception e){
                        selenium.reportFailure(e.getMessage());
                        selenium.test.log(LogStatus.FAIL, "Test Case Failed");
                }
                }

}
