package com.mhe.salesforce.testcases;

import java.util.List;
import java.util.Map;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ValidateErrorMsgForForecastCategorychangeTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	
	
	@Then("^Validate error message for Forecast Change edit successfully$")
    public void validate_error_message_for_forecast_change_edit_successfully(DataTable forecastData) {
		
		String error = null;
		String expected_error=null;
		 try {
			 List<Map<String, String>> forecastDataList = forecastData.asMaps(String.class, String.class);
			 if (selenium.getUI().contains("Lightning")) {
					selenium.test.log(LogStatus.INFO, "Editing opportunity");
//					selenium.waitingTime(3000);
					//selenium.jsClick("editL");
					selenium.waitForElementToBeClickable("editButton");
					selenium.click("editButton");
					selenium.waitingTime(2000);
				
				for (int count = 0; count <= 9; count++) {
					
					if(count==0) {
					for (count = 0 ; count <= 1; count++){
					selenium.selectDropdown(forecastDataList.get(count).get("locator"),
							forecastDataList.get(count).get("Excel Column Name"));
					selenium.waitingTime(2000);
					 if (count==1)
			                break;
					}}
					if(count==2) {
					for (count = 2 ; count <= 3; count++){ 
						selenium.selectDropdown(forecastDataList.get(2).get("locator"),
								forecastDataList.get(2).get("Excel Column Name")); 
						selenium.waitingTime(2000);
						selenium.selectDropdown(forecastDataList.get(3).get("locator"),
								forecastDataList.get(3).get("Excel Column Name")); 
						selenium.waitingTime(2000);
						if (count==3)
			                break;
					}}
					if(count==4) {
					for (count = 4; count <= 5;count++){ 
						selenium.selectDropdown(forecastDataList.get(count).get("locator"),
								forecastDataList.get(count).get("Excel Column Name"));
						if (count==5)
			                break;
				   }}
					if(count==6) {
					for (count = 6; count <= 7;count++){ 
						selenium.selectDropdown(forecastDataList.get(count).get("locator"),
								forecastDataList.get(count).get("Excel Column Name"));
						if (count==7)
			                break;
				  }}
					if(count==8) {
					for (count = 8; count <= 9; count++) { 
						selenium.selectDropdown(forecastDataList.get(count).get("locator"),
								forecastDataList.get(count).get("Excel Column Name"));
						if (count==9)
			                break;
				}}
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("save");
					selenium.click("save");
					selenium.waitingTime(2000);
					error = selenium.getText("errorCurrencycode");
					expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
					selenium.test.log(LogStatus.INFO, "Error Message lightning: " + error);
					if(error.contains(expected_error)) {
						selenium.click("CancelEdit");
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("editL");
						selenium.jsClick("editL");
						selenium.waitingTime(2000);
						selenium.test.log(LogStatus.PASS, "Test Case Passed!");
						
					}
					else {
						selenium.click("CancelEdit");
						selenium.reportFailure("Test Case Failed");	
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
				}
					
				}
 
			 else if(selenium.getUI().equalsIgnoreCase("classic")){
//					selenium.waitingTime(2000);
					selenium.waitForElementToBeVisible("edit");
					selenium.click("edit");
					selenium.waitingTime(2000);
					
					for (int count = 10; count <= 19; count++) {
						
						if(count==10) {
						for (count = 10 ; count <= 11; count++){
						selenium.selectDropdownText(forecastDataList.get(count).get("locator"),
								forecastDataList.get(count).get("Excel Column Name"));
						 if (count==11)
				                break;
						}}
						if(count==12) {
						for (count = 12 ; count <= 13; count++){ 
							selenium.selectDropdownText(forecastDataList.get(count).get("locator"),
									forecastDataList.get(count).get("Excel Column Name"));
							if (count==13)
				                break;
						}}
						if(count==14) {
						for (count = 14; count <= 15;count++){ 
							selenium.selectDropdownText(forecastDataList.get(count).get("locator"),
									forecastDataList.get(count).get("Excel Column Name"));
							if (count==15)
				                break;
					   }}
						if(count==16) {
						for (count = 16; count <= 17;count++){ 
							selenium.selectDropdownText(forecastDataList.get(count).get("locator"),
									forecastDataList.get(count).get("Excel Column Name"));
							if (count==17)
				                break;
					  }}
						if(count==18) {
						for (count = 18; count <= 19; count++) { 
							selenium.selectDropdownText(forecastDataList.get(count).get("locator"),
									forecastDataList.get(count).get("Excel Column Name"));
							if (count==19)
				                break;
					}}
//						selenium.waitingTime(2000);
						selenium.waitForElementToBeClickable("save");
						selenium.click("save");
						selenium.waitingTime(2000);
						error = selenium.getText("errorText");
						expected_error = selenium.getExcelValue(selenium.getTestCaseName()).get(0).get("Error Message");
						selenium.test.log(LogStatus.INFO, "Error Message Classic: " + error);
						if(error.contains(expected_error))
							selenium.test.log(LogStatus.PASS, "Test Case Passed!");
						else
							selenium.reportFailure("Test Case Failed");
						selenium.test.log(LogStatus.FAIL, "Test Case Failed");
					}
						
					}
			 
			 }catch (Exception e) {
				e.printStackTrace();
				selenium.reportFailure("Error while filling up the validating details");
				selenium.waitingTime(3000);
				System.out.println("Error catch");
				boolean error1 = selenium.isElementPresentFast("ErrorListAll");
				System.out.println(error1);
				if (error1 == true) 
				{
					System.out.println("Error came");
					selenium.jsClick("closePopUp");
					selenium.waitingTime(2000);
					selenium.click("CancelButton");
				}

				else 
				{
					System.out.println("inside else to click cancel");
					selenium.click("CancelButton");
				}
			}

		 
	 }

}
