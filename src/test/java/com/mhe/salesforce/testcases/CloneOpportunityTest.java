package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class CloneOpportunityTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to pipeline creation screen$")
	public void i_go_to_pipeline_creation_screen() {
		try {
		
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.waitForElementToBeClickable("pipelinecreation");
			selenium.click("pipelinecreation");
			selenium.selectDropdownText("pipelinedisplay", "Display Type");
	
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while navigating to pipeline creation screen " + e.getMessage());
		}
			
	}

	@When("^I enter all the required details$")
	public void i_enter_all_the_required_details() {
		try {
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.selectDropdownText("nextopportunityyear","Next Opportunity Year");
			selenium.waitForElementToBeClickable("DateLink");
			selenium.click("DateLink");
			selenium.waitForElementToBeClickable("pipelineopenactivities");
			selenium.click("pipelineopenactivities");
			selenium.type("pipelinebatchid", "Pipeline Batch ID");
			selenium.selectResult("opportunityclone","Total Opportunity", "end");
			selenium.waitForElementToBeClickable("createpipeline");
			selenium.click("createpipeline");
			selenium.acceptAlert();
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error while entering all the required details " + e.getMessage());
		}
			
		}
		
	   @Then("^clone opportunity creation should be successful$")
		public void clone_opportunity_creation_should_be_successful() {
			if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementsToBeVisible("pipelinecreationsuccessful");	
	}
	
	   }
	   
	   @Then("^I reassigned opportunity to original owner$")
		public void I_reassigned_opportunity_to_original_owner() {
		   try {
			if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitForElementToBeClickable("Pipelinereassign");
			selenium.click("Pipelinereassign");
			selenium.waitForElementToBeClickable("allButtonClassic");
			selenium.click("allButtonClassic");
			selenium.waitForElementToBeClickable("pipelinereassign");
			selenium.click("pipelinereassign");
			selenium.type("pipelinebatchid", "Pipeline Batch ID");
			selenium.waitForElementToBeClickable("searchpipeline");
			selenium.click("searchpipeline");
			selenium.assertMessage("pipelineopportunityowner", "Default Opportunity Owner");
			selenium.assertMessage("pipelineoriginalowner", "Display Type");
			selenium.selectResult("opportunityclone","Total Opportunity", "end");
			selenium.waitForElementToBeClickable("Assignpipeline");
			selenium.click("Assignpipeline");
			selenium.printLastTestResult(selenium.isElementPresentFast("pipelinereassignsuccessful"));
			selenium.waitForElementToBeClickable("searchpipeline");
			selenium.click("searchpipeline");
			selenium.assertMessage("pipelineopportunityowner", "Display Type");
	}
		   }
		   catch (Exception e)
			{
			   	selenium.test.log(LogStatus.FAIL, "Test Case Failed");
				selenium.reportFailure("Error while reassigning opportunity to original owner " + e.getMessage());
			}
	   }
	   @Then("I click on MHE Quotes link through opportunity")
	   public void i_click_on_mhe_quotes_link_through_opportunity(){
		try{
			selenium.waitForElementToBeClickable("mheQuoteLink");
			selenium.jsClick("mheQuoteLink");
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("newQuoteButton");
			selenium.jsClick("newQuoteButton");
			selenium.waitingTime(10000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I verify the created quote can be edit or not")
	public void i_verify_the_created_quote_can_be_edit_or_not(){
		try{
			System.out.println("Waiting Waiting...");
			selenium.waitingTime(15000);
			selenium.captureScreenShot();
			selenium.defaultframe();
			selenium.switchToFrame("newAccountFrame");
			selenium.switchToFrame("frame_quote");
			if(selenium.isElementPresentFast("quoteEditOpp"))
			{
				System.out.println("PASS!!! Created quote is editable");
				selenium.test.log(LogStatus.PASS,"Created quote is editable");
			}
			else
			{
				System.out.println("FAIL!!! Created quote is not editable");
				selenium.test.log(LogStatus.FAIL,"Created quote is not editable");
				selenium.reportFailure("Created quote is not editable");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("verify the opportunity history fields are removed or not")
	public void verify_the_opp_history_fields_are_removed_or_not(){
		try{
			if (selenium.isElementPresentFast("OpportunityFieldHistoryLink")) {
				selenium.jsClick("OpportunityFieldHistoryLink");
			} else {
				selenium.jsClick("OpportunityFieldHistoryLink2");
			}
			if(selenium.isElementPresentFast("OpportunityHistoryHeading"))
			{
				System.out.println("FAIL!!! Field is present");
				selenium.test.log(LogStatus.FAIL,"Field is present");
				selenium.reportFailure("Field is present");
			}
			else
			{
				System.out.println("PASS!!! Field is not present");
				selenium.test.log(LogStatus.PASS,"Field is not present");
			}
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(6000);
			if(selenium.isElementPresentsuperFast("QuoteDateField")&&selenium.isElementPresentsuperFast("QuoteReceivedDateField"))
			{
				System.out.println("FAIL!!! Fields are not removed");
				selenium.test.log(LogStatus.FAIL,"Fields are not removed");
				selenium.reportFailure("Fields are not removed");
			}
			else
			{
				System.out.println("PASS!!! Fields are removed");
				selenium.test.log(LogStatus.PASS,"Fields are removed");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I verify the percent of grades value")
	public void i_verify_the_percent_of_grades_value(){
		try{
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("DigitalAssignmentEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DigitalAssignmentEditBtn");
			selenium.jsClick("DigitalAssignmentEditBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("DigitalAssignmentDropDown");
			selenium.jsClick("DigitalAssignmentDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DigitalAssignmentOption");
			selenium.jsClick("DigitalAssignmentOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PercentOfGradeDropDown");
			selenium.jsClick("PercentOfGradeDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PercentOfGradeOption");
			selenium.jsClick("PercentOfGradeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.jsClick("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("DigitalAssignmentEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeVisible("PercentOfGradeGetText");
			String percentValue=selenium.getText("PercentOfGradeGetText").toString();
			if(percentValue.equalsIgnoreCase("5"))
			{
				System.out.println("PASS!!! Percent Of Grade field is updated");
				selenium.test.log(LogStatus.PASS,"Percent Of Grade field is updated");
			}
			else
			{
				System.out.println("PASS!!! Percent Of Grade field is not updated");
				selenium.test.log(LogStatus.FAIL,"Percent Of Grade field is not updated");
				selenium.reportFailure("Percent Of Grade field is not updated");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I create a new opportunity for DAG New record type")
	public void i_create_a_new_opp_for_dag_new_record_type(){
		try{
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("NewBtn");
			selenium.jsClick("NewBtn");
			selenium.waitingTime(4000);
			selenium.waitForElementToBeClickable("OpptyDAGNewCheckBox");
			selenium.jsClick("OpptyDAGNewCheckBox");
			selenium.waitForElementToBeClickable("NextButton");
			selenium.jsClick("NextButton");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("opp_accName");
	//		selenium.click("opp_accName");
	//		selenium.waitingTime(1000);
			selenium.typeData("opp_accName","Lawton Public School");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DateLink");
			selenium.jsClick("DateLink");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("DefaultPurchaseDate");
			selenium.jsClick("DefaultPurchaseDate");
			selenium.waitingTime(2000);
			String Amount="200";
			Select dropdown1 = new Select(selenium.getElement("ConfidenceFactor"));
			dropdown1.selectByIndex(1);
			Select dropdown2 = new Select(selenium.getElement("MarketRevenueGroup"));
			dropdown2.selectByIndex(14);
			selenium.typeData("OppAmount", Amount);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OpptySaveBtn");
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(2000);
			selenium.jsClick("OpptySaveBtn");
			selenium.waitingTime(10000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("Add a product through opportunity")
	public void add_a_product_through_opp(){
		try{
			selenium.waitForElementToBeClickable("OppProduct");
			selenium.jsClick("OppProduct");
			selenium.waitingTime(6000);
			selenium.refresh();
			selenium.waitingTime(6000);
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.typeData("keyIsbn","9780076923472");
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
			selenium.waitingTime(13000);
			selenium.clickLoop("saveProduct");
			selenium.waitingTime(25000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);

			if(selenium.getTestCaseName().equalsIgnoreCase("VerifyOppDateAndYearWhenStageEqualsWon")||
			selenium.getTestCaseName().equalsIgnoreCase("VerifyOppCloseDateWhenStageNotEqualsWon"))
			{
				System.out.println(selenium.getTestCaseName());
			}
			else
			{
				selenium.waitForElementToBeClickable("OpportunityContactClick1");
				selenium.click("OpportunityContactClick1");
			}
			selenium.waitingTime(3000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 
	@Then("I edit the stage to won and verify")
	public void i_edit_the_stage_to_won_and_verify(){
		try{
			selenium.navigateToURL(selenium.oppURL);
			selenium.waitingTime(8000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageWon1");
			selenium.jsClick("OppStageWon1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ReasonDDList");
			selenium.jsClick("ReasonDDList");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageCloseReasonValue");
			selenium.jsClick("OppStageCloseReasonValue");
			selenium.waitingTime(2000);
			selenium.scrollToElement("PrimaryFundingTypeField");
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryFundingTypeField");
			selenium.click("PrimaryFundingTypeField");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("PrimaryFundingTypeValue");
			selenium.click("PrimaryFundingTypeValue");
			selenium.waitingTime(2000);
			selenium.scrolldown(5000);
			selenium.waitForElementToBeClickable("SubtypeDropDownOpp");
			selenium.jsClick("SubtypeDropDownOpp");
			selenium.waitingTime(2000);
//			selenium.waitForElementToBeClickable("SubtypeOption");
//			selenium.jsClick("SubtypeOption");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			if(!selenium.isElementPresentsuperFast("snagerror"))
			{
				System.out.println("PASS!!! No Error Occurred");
				selenium.test.log(LogStatus.PASS,"No Error Occurred");
			}
			else
			{
				System.out.println("FAIL!!! Error Occurred");
				selenium.test.log(LogStatus.FAIL,"Error Occurred");
				selenium.reportFailure("Error Occurred");
			}
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I check the probability of stage in opportunity")
	public void i_check_the_probability_of_stage_in_opp(){
		try{
			selenium.navigateToURL(selenium.url);
			selenium.waitingTime(8000);
			selenium.scrollToElement("OwnerCalculatedEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProbabilityPercentageGetText");
			String probabilityPercentage=selenium.getText("ProbabilityPercentageGetText").toString();
			if (probabilityPercentage.equalsIgnoreCase("20%"))
			{
				System.out.println("PASS!!! Probability Percentage is 20%");
				selenium.test.log(LogStatus.PASS,"Probability Percentage is 20%");
			}
			else
			{
				System.out.println("FAIL!!! Probability Percentage is not 20%");
				selenium.test.log(LogStatus.FAIL,"Probability Percentage is not 20%");
				selenium.reportFailure("Probability Percentage is not 20%");
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("opportunityStage3");
			selenium.jsClick("opportunityStage3");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OwnerCalculatedEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProbabilityPercentageGetText");
			probabilityPercentage=selenium.getText("ProbabilityPercentageGetText").toString();
			if (probabilityPercentage.equalsIgnoreCase("40%"))
			{
				System.out.println("PASS!!! Probability Percentage is 40%");
				selenium.test.log(LogStatus.PASS,"Probability Percentage is 40%");
			}
			else
			{
				System.out.println("FAIL!!! Probability Percentage is not 40%");
				selenium.test.log(LogStatus.FAIL,"Probability Percentage is not 40%");
				selenium.reportFailure("Probability Percentage is not 40%");
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStagePilot");
			selenium.jsClick("OppStagePilot");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OwnerCalculatedEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProbabilityPercentageGetText");
			probabilityPercentage=selenium.getText("ProbabilityPercentageGetText").toString();
			if (probabilityPercentage.equalsIgnoreCase("50%"))
			{
				System.out.println("PASS!!! Probability Percentage is 50%");
				selenium.test.log(LogStatus.PASS,"Probability Percentage is 50%");
			}
			else
			{
				System.out.println("FAIL!!! Probability Percentage is not 50%");
				selenium.test.log(LogStatus.FAIL,"Probability Percentage is not 50%");
				selenium.reportFailure("Probability Percentage is not 50%");
			}
			selenium.refresh();
			selenium.waitingTime(10000);
			selenium.scrollToElement("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("editStagesNew");
			selenium.jsClick("editStagesNew");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("OppStageDropDown");
			selenium.jsClick("OppStageDropDown");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("StageOptionQuoteNegotation");
			selenium.jsClick("StageOptionQuoteNegotation");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);
			selenium.refresh();
			selenium.waitingTime(8000);
			selenium.scrollToElement("OwnerCalculatedEditBtn");
			selenium.waitingTime(2000);
			selenium.scrolldown(-200);
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("ProbabilityPercentageGetText");
			probabilityPercentage=selenium.getText("ProbabilityPercentageGetText").toString();
			if (probabilityPercentage.equalsIgnoreCase("60%"))
			{
				System.out.println("PASS!!! Probability Percentage is 60%");
				selenium.test.log(LogStatus.PASS,"Probability Percentage is 60%");
			}
			else
			{
				System.out.println("FAIL!!! Probability Percentage is not 60%");
				selenium.test.log(LogStatus.FAIL,"Probability Percentage is not 60%");
				selenium.reportFailure("Probability Percentage is not 60%");
			}

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I add product through opportunity")
	public void i_add_product_through_opportunity(){
		try{
			selenium.waitForElementToBeClickable("modifyProducts");
			selenium.click("modifyProducts");
			selenium.waitingTime(15000);
			selenium.switchToFrame("switch_iFrame");
			selenium.waitForElementToBeClickable("keyIsbn");
			selenium.click("keyIsbn");
			selenium.waitingTime(2000);
			selenium.typeData("keyIsbn","9780076923472");
			selenium.waitForElementToBeClickable("addButton");
			selenium.click("addButton");
			selenium.waitingTime(13000);
			selenium.clickLoop("saveProduct");
			selenium.waitingTime(25000);
			selenium.switchOutOfFrame();
			selenium.waitingTime(5000);
		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
	 @Then("I verify the created contact Is Teaching field picklist value")
	public void i_verify_the_created_contact_is_teaching_field_picklist_value(){
		try{
			selenium.refresh();
			selenium.waitForElementToBeClickable("OpportunityContactClick1");
			selenium.jsClick("OpportunityContactClick1");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("OppContactFirstRecord");
			selenium.jsClick("OppContactFirstRecord");
			selenium.waitingTime(8000);
			selenium.waitForElementToBeClickable("IsTeachingEditBtn");
			selenium.jsClick("IsTeachingEditBtn");
			selenium.waitingTime(5000);
			selenium.waitForElementToBeClickable("IsTeachingDropDown");
			selenium.jsClick("IsTeachingDropDown");
			selenium.waitingTime(2000);
			if(selenium.isElementPresentFast("IsTeachingOption"))
			{
				System.out.println("PASS!!! Picklist value is present");
				selenium.test.log(LogStatus.PASS,"Picklist value is present");
//				selenium.waitForElementToBeClickable("IsTeachingOption");
				selenium.jsClick("IsTeachingOption");
			}
			else
			{
				System.out.println("FAIL!!! Picklist value is not present");
				selenium.test.log(LogStatus.FAIL,"Picklist value is not present");
				selenium.reportFailure("Picklist value is not present");
			}
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("Save_Btn");
			selenium.click("Save_Btn");
			selenium.waitingTime(10000);

		}catch (Exception e){
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	 }
}
