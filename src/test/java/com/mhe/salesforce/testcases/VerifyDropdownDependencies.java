package com.mhe.salesforce.testcases;

import org.junit.Assert;

import com.mhe.salesforce.util.DataUtil;
import com.mhe.salesforce.util.WebConnector;
import com.mhe.salesforce.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class VerifyDropdownDependencies {
	
	WebConnector selenium = WebConnector.getInstance();
	 
	@When("^I navigate to case number$")
    public void i_navigate_to_case_number() 
    
 {		 
	 try 
		 {			 
			 	    selenium.waitingTime(5000);
				    selenium.waitForElementToBeClickable("menuDots");
					selenium.click("menuDots");
					selenium.waitingTime(3000);
					selenium.waitForElementToBeVisible("searchItemsTextField");
					selenium.type("searchItemsTextField", "Cases");
					selenium.waitingTime(2000);
					selenium.waitForElementToBeClickable("casesOptionMenuDots");
					selenium.jsClick("casesOptionMenuDots");
			 	    selenium.waitingTime(4000);
		            selenium.jsClick("firstCaseRow");
			 	    selenium.waitingTime(6000);

}
	 catch (Exception e) 
	 	{				
			selenium.reportFailure("Error while navigating to case number" + e.getMessage());
		}
 }
	
	@When("^Validate ID dynamic dropdown fields$")
	public void validate_ID_dynamic_dropdown_fields() throws Exception {	    
 {		 
	 try 
		 {
		        selenium.waitingTime(12000);
		        selenium.dynamicIDvalues();
				selenium.test.log(LogStatus.INFO, "Dropdown fields are having correct data!");				
		 }
	 
	 catch (Exception e) 
		 {	
		    
				Assert.assertTrue(true);
			    selenium.reportFailure("Error while validating dropdown list values" + e.getMessage());
		 }
 }

	
	}	
}
