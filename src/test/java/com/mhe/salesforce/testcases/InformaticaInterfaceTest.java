package com.mhe.salesforce.testcases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InformaticaInterfaceTest {
	WebConnector selenium = WebConnector.getInstance();
	int intervalMillis = 180000;  // 3 minute
    int maxDurationMillis = 1800000;  // 30 minutes
    long startTime = System.currentTimeMillis();
    long currentTime;
	String JobName = null;
	String Status = null;
	String JobNameXpath = null;
	String JobStartDate = null;
	String JobEndDate = null;
	String tooltip = "NA";	
	String JobName1 = selenium.getTestDataFromPropertiesFile("II_Job1");
	String JobName2 = selenium.getTestDataFromPropertiesFile("II_Job2");
	String JobName3 = selenium.getTestDataFromPropertiesFile("II_Job3");
	String JobName4 = selenium.getTestDataFromPropertiesFile("II_Job4");
	String JobName5 = selenium.getTestDataFromPropertiesFile("II_Job5");
	
	@Then("^I navigate to My Services Home page$")
	public void I_navigate_to_My_Services_Home_page()
	{
		try
		{
			selenium.waitingTime(3000);
			String MyServicePageURL = selenium.getTestDataFromPropertiesFile("II_MyServicesPage");
			selenium.navigateToURL(MyServicePageURL);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while navigating to My Services Home page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to My Services Home page");
		}
	}
	
	@Then("^I navigate to Data Integration module$")
	public void I_navigate_to_Data_Integration_module()
	{
		try
		{
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("I_DataIntegrationTile");
			selenium.click("I_DataIntegrationTile");
			selenium.waitingTime(5000);
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while navigating to Data Integration module " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to Data Integration module");
		}
	}
	
	@Then("^I navigate to Explore page$")
	public void I_navigate_to_Explore_page()
	{
		try
		{
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("I_ExploreMenu");
			selenium.click("I_ExploreMenu");
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while navigating to Explore page " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while navigating to Explore page");
		}
	}
	
	@When("^I search for a particular \"([^\"]*)\" and start it$")
	public void I_search_for_a_particular_Job_and_start_it(String Job)
	{
		try
		{
			JobName = selenium.getTestDataFromPropertiesFile(Job);
			System.out.println("Current Job Name is :" + JobName);
			selenium.waitingTime(3000);
			selenium.waitForElementToBeClickable("I_FindJobBoxInExplorePage");
			selenium.refresh();
			selenium.waitingTime(3000);
			selenium.typeData("I_FindJobBoxInExplorePage", JobName);
			selenium.waitingTime(3000);
			selenium.clickDynamicData("anchorText", JobName, "end");
			selenium.waitForElementToBeClickable("I_RunJobBtn");
			selenium.click("I_RunJobBtn");	//Starting the Job
			selenium.waitingTime(3000);
			if(selenium.isElementPresentFast("I_RunErrorPopup"))
			{
				System.out.println("Job did not start");
				selenium.captureScreenShot();
				selenium.click("R_CloseErrorPopup");
				selenium.waitingTime(2000);
			}
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while either searching or starting a job " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while either searching or starting a job");
		}
	}
	
	@Then("^I navigate to My Jobs page and verify the \"([^\"]*)\" status$")
	public void I_navigate_to_My_Jobs_page_and_verify_the_Job_status(String Job)
	{
		try
		{			
			JobName = selenium.getTestDataFromPropertiesFile(Job);
			System.out.println("Current Job Name is :" + JobName);
			
			//VERIFY THE JOB WHICH WE JUST STARTED IS APPEARING ON MYJOB PAGE OR NOT (It should appear. If not, then we can say that the Job has not started due to some reason)
			selenium.waitForElementToBeClickable("I_MyJobsMenu");
			selenium.click("I_MyJobsMenu");
			selenium.waitingTime(3000);
			selenium.refresh();
			selenium.waitingTime(15000);
			
			/*selenium.waitForElementToBeClickable("I_Filter");
			selenium.clickLoop("I_Filter");
			selenium.waitForElementToBeClickable("I_FilterAddField");
			selenium.click("I_FilterAddField");
			selenium.waitingTime(2000);
			selenium.scrollToElement("I_AddFieldFilter1");
			selenium.waitForElementToBeClickable("I_AddFieldFilter1");
			selenium.clickLoop("I_AddFieldFilter1");
			selenium.waitingTime(2000);
			selenium.waitForElementToBeClickable("I_AddFieldFilter2");
			selenium.clickLoop("I_AddFieldFilter2");
			selenium.waitingTime(5000);*/
			
			selenium.waitForElementToBeClickable("I_FindJobBoxInMyJobsPage");
			selenium.typeData("I_FindJobBoxInMyJobsPage", JobName);
			selenium.waitingTime(4000);
			JobNameXpath = selenium.getDynamicXpath_data("spantextContains", JobName, "endContains");
			System.out.println("JobNameXpath is :" + JobNameXpath);
			
		 	Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy");
			String todaysDate = sdf1.format(date);
			System.out.println("todays date"+todaysDate);
			
			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			System.out.println("yesterday date" + yesterdaysDate);			
			
			String JobStartDateXpath = selenium.getDynamicXpath_data("spantextContains", JobName, "I_JobStartDateEnding");
			System.out.println("JobStartDateXpath" + JobStartDateXpath);
			JobStartDate = selenium.getDynamicText(JobStartDateXpath);
			System.out.println("JobStartDate" + JobStartDate);
			
			if(JobStartDate.contains(todaysDate) || JobStartDate.contains(yesterdaysDate))
			{				
				selenium.test.log(LogStatus.PASS, "<b>Job " + JobName + " has started...</b>");
				System.out.println("PASS");
			}
			else
			{
				selenium.test.log(LogStatus.FAIL, "<b>Job " + JobName + " has NOT started...</b>");
				selenium.reportFailure("<b>Job " + JobName + " has NOT started...</b>");
				System.out.println("FAIL");
			}			
			
			
			//VERIFY THE JOB STATUS EVERY 3 MIN FOR MAXIUMUM OF 30 MIN
	        do {
	            currentTime = System.currentTimeMillis();

	        	selenium.click("I_RefreshBtnInMyJobsPage");
	        	selenium.waitingTime(5000);	        	
	        	String JobEndDateXpath = selenium.getDynamicXpath_data("spantextContains", JobName, "I_JobEndDateEnding");
				System.out.println("JobEndDateXpath" + JobEndDateXpath);
				JobEndDate = selenium.getDynamicText(JobEndDateXpath);
				System.out.println("JobEndDate" + JobEndDate);				

	        	if(JobEndDate != null && !JobEndDate.trim().isEmpty())
	        	{
	        		System.out.println("Job has End Date");
	        		selenium.waitingTime(5000);
	                String jobStatus = selenium.getText("I_FetchJobStatus");
	                System.out.println("jobStatus is " + jobStatus);
	                
	                if(jobStatus.equalsIgnoreCase("Success"))
	                {
						selenium.test.log(LogStatus.INFO, "<b>Job " + JobName + " has completed successfully.</b>");
						System.out.println("JOB - Success");
						selenium.captureScreenShot();
						Status = "Success";
	                }
	                else if(jobStatus.equalsIgnoreCase("Warning"))
	                {
		        		selenium.hoverAndClick("I_JobStatusImg");
		        		selenium.waitForElementToBeClickable("I_CopyJobStatusTooltip");
		        		selenium.waitingTime(2000);
		        		tooltip = selenium.getText("I_GetJobStatusTooltipText");
		        		System.out.println("tooltip says : " + tooltip);
		                
						selenium.test.log(LogStatus.INFO, "<b>The Job " + JobName + " - has failed due to the following reason</b>" + tooltip);
//						selenium.reportFailure("<b>The Job " + JobName + " - has failed due to the following reason</b>" + tooltip);
						System.out.println("JOB - Warning");
						Status = "Warning";
	                }
	                else if(jobStatus.equalsIgnoreCase("Failed"))
	                {
		        		selenium.hoverAndClick("I_JobStatusImg");
		        		selenium.waitForElementToBeClickable("I_CopyJobStatusTooltip");
		        		selenium.waitingTime(2000);
		        		tooltip = selenium.getText("I_GetJobStatusTooltipText");
		        		System.out.println("tooltip says : " + tooltip);
		                
						selenium.test.log(LogStatus.INFO, "<b>The Job " + JobName + " - has failed due to the following reason</b>" + tooltip);
//						selenium.reportFailure("<b>The Job " + JobName + " - has failed due to the following reason</b>" + tooltip);
						System.out.println("JOB - Failed");
						Status = "Failed";
	                }
	                break;  // Exit the loop when the main if condition is met
	        	}

	            try {
	                Thread.sleep(intervalMillis);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        } while (currentTime - startTime < maxDurationMillis);
	        
	        if(JobEndDate == null || JobEndDate.isEmpty())
        	{
				selenium.test.log(LogStatus.INFO, "<b>Job " + JobName + " has NOT completed the execution even after 30min.</b>");
//				selenium.reportFailure("<b>Job " + JobName + " has NOT completed the execution even after 30min.</b>");
				System.out.println("JOB- Still Running..");
				Status = "Running";
            }
	        
	        if(JobName.equalsIgnoreCase(JobName1))
	        {	        	
	        	selenium.JobStartDate1 = JobStartDate;
	        	selenium.JobEndDate1 = JobEndDate;
	        	selenium.Status1 = Status;
	        	selenium.tooltip1 = tooltip;
	        }
	        else if(JobName.equalsIgnoreCase(JobName2))
	        {	        	
	        	selenium.JobStartDate2 = JobStartDate;
	        	selenium.JobEndDate2 = JobEndDate;
	        	selenium.Status2 = Status;
	        	selenium.tooltip2 = tooltip;
	        }
	        else if(JobName.equalsIgnoreCase(JobName3))
	        {	        	
	        	selenium.JobStartDate3 = JobStartDate;
	        	selenium.JobEndDate3 = JobEndDate;
	        	selenium.Status3 = Status;
	        	selenium.tooltip3 = tooltip;
	        }
	        else if(JobName.equalsIgnoreCase(JobName4))
	        {	        	
	        	selenium.JobStartDate4 = JobStartDate;
	        	selenium.JobEndDate4 = JobEndDate;
	        	selenium.Status4 = Status;
	        	selenium.tooltip4 = tooltip;
	        }
	        else if(JobName.equalsIgnoreCase(JobName5))
	        {	        	
	        	selenium.JobStartDate5 = JobStartDate;
	        	selenium.JobEndDate5 = JobEndDate;
	        	selenium.Status5 = Status;
	        	selenium.tooltip5 = tooltip;
	        }
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while verifying the job status " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while verifying the job status");
		}
	}
	
	@And("^create table and insert the job status$")
	public void create_table_and_insert_the_job_status()
	{
		try
		{
	        CreateTable();
		}
		catch (Exception e)
		{
			selenium.reportFailure("Error while adding job status to the table in extent report " + e.getMessage());
			selenium.test.log(LogStatus.FAIL, "Error while adding job status to the table in extent report");
		}
	}
	
	//Create table data inside Extent report
	private void CreateTable()
	{
		String[][] data = {
				//COLUMN
			    {"<th colspan='1' style='" + getCellStyleForTableHeading("lightblue","center","bold","14px","24%") + "'>" + "Job Name" + "</th>", 
			     "<th colspan='1' style='" + getCellStyleForTableHeading("lightblue","center","bold","14px","18%") + "'>" + "Start Time" + "</th>",
				 "<th colspan='1' style='" + getCellStyleForTableHeading("lightblue","center","bold","14px","18%") + "'>" + "End Time" + "</th>",
			     "<th colspan='1' style='" + getCellStyleForTableHeading("lightblue","center","bold","14px","15%") + "'>" + "Status" + "</th>",
			     "<th colspan='1' style='" + getCellStyleForTableHeading("lightblue","center","bold","14px","25%") + "'>" + "Error Message" + "</th>"},

			    //ROW
			    {"<td colspan='1' style='" + getCellStyleForTableConent("lightgreen","left") + "'>" + JobName1 + "</td>", 
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobStartDate1 + "</td>",
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobEndDate1 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.Status1 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.tooltip1 + "</td>"},
			    
			    {"<td colspan='1' style='" + getCellStyleForTableConent("lightgreen","left") + "'>" + JobName2 + "</td>", 
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobStartDate2 + "</td>",
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobEndDate2 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.Status2 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.tooltip2 + "</td>"},
			    
			    {"<td colspan='1' style='" + getCellStyleForTableConent("lightgreen","left") + "'>" + JobName3 + "</td>", 
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobStartDate3 + "</td>",
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobEndDate3 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.Status3 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.tooltip3 + "</td>"},
			    
			    {"<td colspan='1' style='" + getCellStyleForTableConent("lightgreen","left") + "'>" + JobName4 + "</td>", 
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobStartDate4 + "</td>",
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobEndDate4 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.Status4 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.tooltip4 + "</td>"},
			    
			    {"<td colspan='1' style='" + getCellStyleForTableConent("lightgreen","left") + "'>" + JobName5 + "</td>", 
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobStartDate5 + "</td>",
				 "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.JobEndDate5 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.Status5 + "</td>",
			     "<td colspan='1' style='" + getCellStyleForTableConent("lightyellow","center") + "'>" + selenium.tooltip5 + "</td>"},
			};	
		// Create the table using HTML tags
		StringBuilder table = new StringBuilder("<table>");
		for (String[] row : data) {
		    table.append("<tr>");
		    for (String cell : row) {
		    	table.append("<td>").append(cell).append("</td>");
		    }
		    table.append("</tr>");
		}
		table.append("</table>");
		// Log the table to the test
		selenium.test.log(LogStatus.INFO, table.toString());
 
	}
	
	// Method to generate the style for dynamic cells
    private static String getCellStyleForTableHeading(String backgroundColor, String align, String look, String size, String width) {
        return "background-color: " + backgroundColor + ";" + "text-align: " + align + ";" + "font-weight: " + look + ";" + "font-size: " + size + ";" + "width: " + width + ";";
    }
    private static String getCellStyleForTableConent(String backgroundColor, String align) {
        return "background-color: " + backgroundColor + ";" + "text-align: " + align + ";";
    }
	
}