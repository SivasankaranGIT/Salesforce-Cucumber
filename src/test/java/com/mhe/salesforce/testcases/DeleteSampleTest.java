package com.mhe.salesforce.testcases;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.When;

public class DeleteSampleTest {
	
	WebConnector selenium = WebConnector.getInstance();
	
	@When("^I go to sample detail screen$")
	public void i_go_to_sample_detail_screen(){
		try{
		if(selenium.getUI().equalsIgnoreCase("classic")){
			selenium.waitingTime(2000);
			selenium.clickDynamic("anchorText", "Samplename", "end");
		}
		
		else if (selenium.getUI().equalsIgnoreCase("lightning")) {
			selenium.waitingTime(9000);
			String xpath= selenium.getDynamicXpath("anchorTitle", "Samplename", "end");
//			selenium.waitForXpathElementToBeClickable(xpath);
			selenium.waitingTime(4000);
			selenium.clickLoopXpath(xpath);
			selenium.waitingTime(2000);
		}
				
	}
		catch (Exception e) {
			e.printStackTrace();
			selenium.reportFailure("Error while navigating to Sample screen");
			selenium.test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}	
	   
}
