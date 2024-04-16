package com.mhe.salesforce.testcases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import com.mhe.salesforce.util.CommonUtil;
import com.mhe.salesforce.util.ExtentManager;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;

public class LogoutTest {
	WebConnector selenium = WebConnector.getInstance();
	
	@Then("^I logout$")
	public void I_logout() throws IOException {

		System.out.println("Inside Logout method");
//		selenium = WebConnector.getInstance();
		Date d = new Date();
		//String new_fileName = d.toString().replace(":", "_").replace(" ", "_") + "_Group.html";
		String new_fileName = "Report_T"+selenium.total_tc_count+"_F"+selenium.failed_tc_count+"_"+CommonUtil.tagNamesCombo+"_Group.html";
//		selenium.quit();
//		selenium.close();
//		System.out.println("*********** Browser closed successfully *********** ");
		if (selenium.test != null) {
			selenium.extent.endTest(selenium.test);
			selenium.extent.flush();
			
			File src = new File(WebConnector.REPORTS_PATH + ExtentManager.fileName);
	        File dest = new File(WebConnector.REPORTS_PATH  + new_fileName);	             
	        // using copy(InputStream,Path Target); method
	        Files.copy(src.toPath(), dest.toPath());
			selenium = WebConnector.getInstance();
			
			System.out.println("**************** The EXTENT REPORT is generated successfully!!! *****************");
			selenium.test.log(LogStatus.PASS, "The EXTENT REPORT is generated successfully!!!");
		}

	}
	
	@Then("^I logout from lnformatica application$")
	public void I_logout_from_lnformatica_application() throws IOException {
		System.out.println("Inside Logout lnformatica method");
		Date d = new Date();
		String new_fileName = "Report_T"+selenium.total_tc_count+"_F"+selenium.failed_tc_count+"_"+CommonUtil.tagNamesCombo+"_Group.html";
		if (selenium.test != null) {
			selenium.extent.endTest(selenium.test);
			selenium.extent.flush();			
			File src = new File(WebConnector.REPORTS_PATH + ExtentManager.fileName);
	        File dest = new File(WebConnector.REPORTS_PATH  + new_fileName);	             
	        Files.copy(src.toPath(), dest.toPath());
			selenium = WebConnector.getInstance();			
			System.out.println("**************** The EXTENT REPORT is generated successfully!!! *****************");
			selenium.test.log(LogStatus.PASS, "The EXTENT REPORT is generated successfully!!!");
		}
	}

}