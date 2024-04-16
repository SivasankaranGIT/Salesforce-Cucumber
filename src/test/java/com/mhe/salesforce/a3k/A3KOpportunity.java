package com.mhe.salesforce.a3k;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.regex.Pattern;

public class A3KOpportunity {
    WebConnector selenium = WebConnector.getInstance();
    @When("^I fill in all the required DAG Opportunity fields$")
    public void i_fill_in_all_the_required_DAG_Opportunity_fields() {
        try{
            selenium.click("dagOppCloseDateLink");
            selenium.click("dagOppPurchaseDateLink");
            selenium.click("dagOppDealName");
            selenium.type_propertiesFile("dagOppDealName","dagOppDealName");
            selenium.click("OppAmount");
            selenium.type_propertiesFile("OppAmount","dagOppAmount");
            selenium.selectDropdownText_propertiesFile("ConfidenceFactor","ConfidenceFactor");
            selenium.selectDropdownText_propertiesFile("MarketRevenueGroup","MarketRevenueGroup");
            if(selenium.isElementPresentsuperFast("OppOwner")){
                selenium.click("OppOwner");
                selenium.type_propertiesFile("OppOwner","dagOppOwner");
            }
            selenium.click("Button_Save");
            selenium.waitForElementToBeVisible("Opp_Owner");
            selenium.newOppULR=selenium.getURL();
        }catch (Exception e){
            System.out.println("Inside i_create_from_Account_a_new_Opportunity_of_Record_Type catch");
            e.printStackTrace();
            selenium.captureScreenShot();
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }
    @Then("^I verify the Opportunity Stage is \"([^\"]*)\"$")
    public void i_verify_the_Opportunity_Stage_is(String oppInitialStage) {
        try{
            selenium.assertMessage_propertiesFile("opportunityStageGetText",oppInitialStage);
        }catch (Exception e){
            System.out.println("Inside i_verify_the_Opportunity_Stage_is catch");
            e.printStackTrace();
            selenium.captureScreenShot();
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }

    @Then("^I verify the Opportunity Name is in the expected DAG format$")
    public void i_verify_the_Opportunity_Name_is_in_the_expected_DAG_format() {
        try{
            selenium.newopportunity_name = selenium.getText("opportunityNameGetText");
            String regex = "[0-9]{4}-*";
            Assert.assertTrue(Pattern.matches(regex,selenium.newopportunity_name));
        }catch (Exception e){
            System.out.println("Inside i_verify_the_Opportunity_Name_is_in_the_expected_DAG_format catch");
            e.printStackTrace();
            selenium.captureScreenShot();
            selenium.test.log(LogStatus.FAIL, "Test Case Failed");
            selenium.reportFailure("Test Case Failed" + e.getMessage());
        }
    }

}
