package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MHESAdminModifiesAccountFieldsTest {
	WebConnector selenium = WebConnector.getInstance();
	boolean flagsuccess;
	
	@And("^modify enrollment grade levels and account type account fields$")
	public void modify_enrollment_grade_levels_and_account_type_account_fields() {
		try {
			if (selenium.getUI().contains("Lightning")) {
				selenium.search("Account Name");
				selenium.waitingTime(2000);
				String Xpath = selenium.getDynamicXpath("anchorTitlecontains", "Account Name", "endContains");
//				selenium.waitForXpathElementToBeClickable(Xpath);
				selenium.waitingTime(4000);
				selenium.clickLoopXpath(Xpath);
//				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("editButton");
				selenium.jsClick("editButton");
				selenium.waitingTime(5000);
				selenium.waitForElementToBeClickable("AccountTypeDropDown");
				
				selenium.click("AccountTypeDropDown");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Account Type", "end"));
				selenium.scrollToElement("enrollmentNumber");
				selenium.clearText("enrollmentNumber");
				selenium.type("enrollmentNumber", "Enrollment Number");
				selenium.waitForElementToBeClickable("lowGradeDropDwn1");
				selenium.click("lowGradeDropDwn1");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Low Grade", "end"));
				selenium.waitForElementToBeClickable("highGradeDropDwn1");
				selenium.click("highGradeDropDwn1");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "High Grade", "end"));
				selenium.waitForElementToBeClickable("accntTierClassDropDwn1");
				selenium.click("accntTierClassDropDwn1");
				selenium.waitingTime(2000);
				selenium.jsClickXpath(selenium.getDynamicXpath("spanTitle", "Account Tier", "end"));
				selenium.waitForElementToBeClickable("save");
				selenium.click("save");
				//flagsuccess=selenium.isElementPresentFast("contactSuccessfulL");
				selenium.waitingTime(15000);
				selenium.test.log(LogStatus.PASS, "Save Button clicked");
			}

		} catch (Exception e) {
			selenium.waitingTime(3000);
            System.out.println("Error catch");
            boolean  error=selenium.isElementPresentFast("ErrorListAll");    
            System.out.println(error);
            if(error==true) {
                   System.out.println("Error came");
                   selenium.jsClick("closePopUp");
                   selenium.waitingTime(2000);            
                   selenium.click("CancelButton");
            }

            else {
                   selenium.click("CancelButton");
            }

		}
	}
	
	@Then("^I validate modified account success message$")
	public void I_validate_modified_account_success_message() {
		if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.printLastTestResult(flagsuccess);
		}else if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.printLastTestResult(flagsuccess);
		}
	}
	
	@And("^Verify the account fields are modified$")
	public void verify_details_of_the_contact_record_created() {
		
		selenium.waitingTime(4000);
		String accountType = null;
		String expected_accountType = null;
		String lowGrade = null;
		String expected_lowGrade = null;
		String highGrade = null;
		String expected_highGrade = null;
		String enrollment = null;
		String expected_enrollment = null;
		String accountTier = null;
		String expected_accountTier = null;
		try {
		if (selenium.getUI().contains("Lightning")) {
			selenium.refresh();
			selenium.waitingTime(5000);

			selenium.scrollToElement("accntTypeGetText");
			accountType = selenium.getText("accntTypeGetText").toString();
			expected_accountType = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Type");

			selenium.scrollToElement("enrollmentGetText");
			enrollment = selenium.getText("enrollmentGetText").toString().replaceAll(",", "");
			expected_enrollment = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Enrollment Number");

			selenium.scrollToElement("lowGradeGetText");
			lowGrade = selenium.getText("lowGradeGetText").toString();
			expected_lowGrade = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Low Grade");

			selenium.scrollToElement("highGradeGetText");
			highGrade = selenium.getText("highGradeGetText").toString();
			expected_highGrade = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("High Grade");

			selenium.scrollToElement("accntTierClassGetText");
			accountTier = selenium.getText("accntTierClassGetText").toString();
			expected_accountTier = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Account Tier");

			if (accountType.equalsIgnoreCase(expected_accountType) ) {
				selenium.test.log(LogStatus.PASS, "Account Type is modified to" + expected_accountType + "successfully");

			}
			
			if (enrollment.equalsIgnoreCase(expected_enrollment) ) {

				selenium.test.log(LogStatus.PASS, "Enrollment is modified to" + expected_enrollment + "successfully");

			} 
			if (lowGrade.equalsIgnoreCase(expected_lowGrade) ) {

				selenium.test.log(LogStatus.PASS, "Low Grade is modified to" + expected_lowGrade + "successfully");

			}
			
			if (highGrade.equalsIgnoreCase(expected_highGrade) ) {

				selenium.test.log(LogStatus.PASS, "High Grade is modified to" + expected_highGrade + "successfully");

			}
			
			if (accountTier.equalsIgnoreCase(expected_accountTier) ) {

				selenium.test.log(LogStatus.PASS, "Account Tier is modified to" + expected_accountTier + "successfully");

			}
			
			else {

				selenium.reportFailure("Test Case Failed");
				selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			}
		}
		}
		catch (Exception e)
		{
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
			selenium.reportFailure("Error occurred " + e.getMessage());
		}
	}
}
