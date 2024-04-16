package com.mhe.salesforce.a3k;

import com.mhe.salesforce.util.WebConnector;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;

public class FSLServiceAppointment {

    WebConnector selenium = WebConnector.getInstance();
    String AppointmentNumber;
    String WorkOrderStatus;
    String ServiceAppointmentURL_VerifyStatus="https://mh--uat.sandbox.lightning.force.com/lightning/r/ServiceAppointment/08p8b000001OCyuAAG/view";

    @And("Locate the Service Appointment record to be cancelled")
    public void locate_the_service_appointment_record_to_be_cancelled() {
        try {
           /* selenium.waitForElementToBeVisible("ServiceAppointmentsStatus");
            selenium.jsClick("ServiceAppointmentsStatus"); //SA status should be NONE
            selenium.waitingTime(3000);
            selenium.waitForElementToBeClickable("FirstSARecord");
            selenium.jsClick("FirstSARecord");*/
        	selenium.navigateToURL(selenium.SAURL); //SA status should be NONE
            selenium.waitingTime(6000);
			selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
            selenium.reportFailure("Error while selecting New Button" + e.getMessage());
        }
    }

    @Then("Update the Status field to Cancelled AND Enter a Cancellation OR Cannot Complete Reason and Click Save")
    public void update_the_status_field_to_cancelled_and_enter_a_cancellation_or_cannot_complete_reason_and_click_save() {
        try {
//        	selenium.waitForElementToBeVisible("AppointmentNumberGetText");
//            AppointmentNumber =  selenium.getText("AppointmentNumberGetText");
        	selenium.refresh();
        	selenium.waitingTime(12000);
            selenium.waitForElementToBeClickable("EditButton");
            selenium.click("EditButton");
            selenium.waitingTime(3000);
            selenium.waitForElementToBeClickable("ServiceAppointmentStatusDropDown1");
            selenium.jsClick("ServiceAppointmentStatusDropDown1");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("StatusCancelled");
            selenium.jsClick("StatusCancelled");
            selenium.waitingTime(3000);
            selenium.waitForElementToBeClickable("ServiceApppointmentCancellationReason1");
            selenium.jsClick("ServiceApppointmentCancellationReason1");
            selenium.waitForElementToBeClickable("ServiceAppointmentCancellationReason");
            selenium.jsClick("ServiceAppointmentCancellationReason");
            selenium.waitingTime(3000);
			selenium.takeScreenShot();
            selenium.waitForElementToBeClickable("ServiceAppointmantcancellationStatusSave");
            selenium.clickLoop("ServiceAppointmantcancellationStatusSave");
            selenium.waitingTime(25000);

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
            selenium.reportFailure("Error while selecting New Button" + e.getMessage());
        }
    }

    @Then("Confirm the Status of the service appointment updated to Canceled")
    public void confirm_the_status_of_the_service_appointment_updated_to_canceled() {
        try {
        	selenium.waitingTime(5000);
        	selenium.refresh();
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("WOStatus");
        	WorkOrderStatus = selenium.getText("WOStatus");
            System.out.println("Service Appointment Status is --> " + WorkOrderStatus);
            if (WorkOrderStatus.equalsIgnoreCase("Canceled")) {
                selenium.test.log(LogStatus.PASS, "Service Appointment Is Updated With Cancelled Status");
                System.out.println("PASS");
    			selenium.takeScreenShot();
            }
            else
            {
                /*Deleting the SA record as it could be error one..*/
            	if(selenium.isElementPresentFast("opportunityAccountsEditCancel"))
            	{
            		selenium.click("opportunityAccountsEditCancel");
                	selenium.waitingTime(6000);
                	selenium.refresh();
                	selenium.waitingTime(5000);            		
            	}
				selenium.waitForElementToBeClickable("menuDots");
				selenium.click("menuDots");
				selenium.waitingTime(3000);
				selenium.waitForElementToBeClickable("searchItemsTextField");
				selenium.typeData("searchItemsTextField", "Service Appointments");
				selenium.waitForElementToBeClickable("CommunityName");
				selenium.jsClick("CommunityName");
				System.out.println("Navigated successfully to Community Page");
				selenium.waitingTime(5000);
	            selenium.waitForElementToBeVisible("ServiceAppointmentsStatus");
	            selenium.jsClick("ServiceAppointmentsStatus");
	            selenium.waitingTime(3000);
	            selenium.click("ServiceAppointmentDashoardDropDown");
	            selenium.waitingTime(3000);
	            selenium.click("ServiceAppointmentDeleteOption");
	            selenium.waitingTime(3000);
	            selenium.click("DeleteConfirmationButton");
	            selenium.waitingTime(10000);
	            
                selenium.test.log(LogStatus.FAIL, "SA Is NOT Updated With Cancelled Status");
                selenium.reportFailure("SA Is NOT Updated With Cancelled Status");
                System.out.println("FAIL");
            }
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "SA Is NOT Updated With Cancelled Status");
            selenium.reportFailure("SA Is NOT Updated With Cancelled Status" + e.getMessage());
        }
    }
    
    @And("Locate a Service Appointment that is completed")
    public void locate_a_service_appointment_that_is_completed() {
        try {
        	selenium.refresh();
        	selenium.waitingTime(6000);
        	selenium.waitForElementToBeClickable("ServiceAppointmentSearch");
            selenium.typeData("ServiceAppointmentSearch","Completed");
            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.waitingTime(3000);
			selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    @Then("On the Service Appointment record click on the Create Service Report button")
    public void on_the_service_appointment_record_click_on_the_create_service_report_button() {
        try {
            selenium.waitForElementToBeClickable("ServiceAppointmentsFirstSearch");
            selenium.jsClick("ServiceAppointmentsFirstSearch");
            selenium.waitingTime(3000);
			selenium.takeScreenShot();
            selenium.waitForElementToBeClickable("ServiceAppointmentCreateServiceReport");
            selenium.click("ServiceAppointmentCreateServiceReport");
            selenium.waitingTime(3000);

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("A Service Report Preview window opens confirm all looks good If any changes are needed click cancel")
    public void a_service_report_preview_window_opens_confirm_all_looks_good_if_any_changes_are_needed_click_cancel() {
        try {
        	selenium.waitForElementToBeClickable("ServiceAppointmentCancelButton");
            selenium.click("ServiceAppointmentCancelButton");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ServiceAppointmentCreateServiceReport");
            selenium.click("ServiceAppointmentCreateServiceReport");
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("ServiceAppointmentCreatePDFBtn");
            selenium.waitingTime(3000);
            selenium.click("ServiceAppointmentCreatePDFBtn");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("ServiceReportViewCreateServiceReport");
            selenium.waitingTime(3000);
            selenium.click("ServiceReportViewCreateServiceReport");
            selenium.waitingTime(5000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("You should see a message that a PDF was saved successfully")
    public void you_should_see_a_message_that_a_pdf_was_saved_successfully() {
        try {
        	selenium.refresh();
            selenium.waitingTime(6000);
            selenium.waitForElementToBeClickable("ServiceReportViewCreateServiceReport");
            selenium.click("ServiceReportViewCreateServiceReport");
            selenium.waitingTime(3000);

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    @Then("the Service Appointment record, locate the Service Reports related list and click on View All")
    public void the_service_appointment_record_locate_the_service_reports_related_list_and_click_on_view_all() {
        try {
            selenium.scrolldown(600);
            selenium.jsClick("ServiceAppointmentReportViewAll");
            selenium.waitingTime(3000);

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("Click on the Service Report Name link to preview")
    public void click_on_the_service_report_name_link_to_preview() {
        try {
        	selenium.takeScreenShot();
            selenium.click("ServiceReportNameLink");
            selenium.waitingTime(3000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("Select the My Service Appointments list view")
    public void select_the_my_service_appointments_list_view() {
        try {
            selenium.refresh();
            selenium.waitingTime(5000);
        	selenium.waitForElementToBeClickable("ServiceAppointmentsDropDown");
            selenium.click("ServiceAppointmentsDropDown");
            selenium.waitingTime(4000);
            selenium.waitForElementToBeClickable("ServiceApppointmentMyServiceAppointment");
            selenium.jsClick("ServiceApppointmentMyServiceAppointment");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeClickable("FirstAppointment");
            selenium.jsClick("FirstAppointment");
            selenium.waitingTime(5000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    @Then("on the next page Click on a Service Appointment and confirm you see Action button")
    public void on_the_next_page_click_on_a_service_appointment_and_confirm_you_see_action_button() {
        try {
        	selenium.waitForElementToBeVisible("ServiceAppointmentChangeStatus");
            selenium.isElementPresentFast("ServiceAppointmentChangeStatus");
            selenium.isElementPresentFast("EditActionButton");
            selenium.isElementPresentFast("ServiceAppointmentDetailsPage");
            selenium.isElementPresentFast("ServiceAppointmentFeed");
            selenium.click("ServiceAppointmentFeed");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeVisible("ServiceAppointmentEmail");
            selenium.isElementPresentFast("ServiceAppointmentEmail");
            selenium.isElementPresentFast("ServiceAppointmentChatter");
            selenium.click("ServiceAppointmentChatter");
            selenium.waitingTime(5000);
            selenium.waitForElementToBeVisible("ServiceAppointmentPost");
            selenium.isElementPresentFast("ServiceAppointmentPost");
            selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("Work Plan Work Steps Related lists Attendees Customer Survey Responses-Service Appointment History Files")
    public void work_plan_work_steps_related_lists_attendees_customer_survey_responses_service_appointment_history_files() {
        try {
            selenium.isElementPresentFast("ServiceAppointmentWorkOrder");
            selenium.isElementPresentFast("ServiceAppointmentAttendees");
            selenium.scrolldown(100);
            selenium.isElementPresentFast("ServiceAppointmentCustomerSurveyResponses");
            selenium.isElementPresentFast("ServiceAppoitmentHistory");
            selenium.scrolldown(200);
            selenium.takeScreenShot();
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    @Then("Explore the record and validate you can see all the needed information to delivery training work requested")
    public void explore_the_record_and_validate_you_can_see_all_the_needed_information_to_delivery_training_work_requested() {
        try {
                selenium.isElementPresentFast("ServiceAppointmentFiles");
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }

    @Then("Click on your Name link")
    public void click_on_your_name_link() {
        try {
        	selenium.refresh();
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeClickable("SearchThisList");
            selenium.typeData("SearchThisList","Amanda Landen");
            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.waitingTime(3000);
            if(selenium.isElementPresentFast("Service_Resources_All_Checkbox"))
            {
            selenium.waitForElementToBeClickable("Service_Resources_All_Checkbox");
            selenium.jsClick("Service_Resources_All_Checkbox");
            selenium.waitForElementToBeClickable("Select_FirstServiceResource");
            selenium.jsClick("Select_FirstServiceResource");
            }
            else
            {
            	selenium.navigateToURL("https://mh--uat.sandbox.lightning.force.com/lightning/r/ServiceResource/0Hn8b000000PopQCAS/view");	//Amanda Landen SR URL
            }
            selenium.waitingTime(5000);
            selenium.takeScreenShot();

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Service Resource");
            selenium.reportFailure("Error while Selecting Service Resource" + e.getMessage());
        }
    }
    @Then("Click on the drop down arrow and click on NEW")
    public void click_on_the_drop_down_arrow_and_click_on_new() {
        try {
            selenium.waitForElementToBeClickable("AbsenceNewbutton");
            selenium.jsClick("AbsenceNewbutton");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
            selenium.reportFailure("Error while selecting New Button" + e.getMessage());
        }
    }
    @Then("Enter the required Start Time End Time Type and  Click Save")
    public void enter_the_required_start_time_end_time_type_and_click_save() {
        try {
            selenium.waitForElementToBeClickable("NewResourceAbsenceRadio");
            selenium.click("NewResourceAbsenceRadio");
            selenium.waitForElementToBeClickable("NextButton");
            selenium.click("NextButton");
            selenium.waitForElementToBeClickable("ResourceAbsenceStart");
            selenium.typeData("ResourceAbsenceStart",selenium.getCurrentDate(0));
            selenium.waitingTime(1000);
            selenium.waitForElementToBeClickable("ResourceabsenseEnd");
            selenium.typeData("ResourceabsenseEnd",selenium.getCurrentDate(0));
            selenium.waitForElementToBeClickable("ResourceAbsenceEndTime");
            selenium.click("ResourceAbsenceEndTime");
            selenium.waitingTime(3000);
            selenium.waitForElementToBeClickable("ResourceAbsenceEndTime");
            selenium.typeData("ResourceAbsenceEndTime", "12:30 PM");
            selenium.waitingTime(2000);
            selenium.pressEscapeKey();
            selenium.waitingTime(2000);
            selenium.waitForElementToBeClickable("SaveRecordButton");
            selenium.takeScreenShot();
            selenium.click("SaveRecordButton");
            selenium.waitingTime(8000);
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Upon saving you are taken to the Resource Absence record Confirm the Times look correct")
    public void upon_saving_you_are_taken_to_the_resource_absence_record_confirm_the_times_look_correct() {
        try {
//            selenium.waitForElementToBeClickable("FieldServiceSearchEmployee");
//            selenium.typeData("FieldServiceSearchEmployee","Allison Zimpfer");
//            selenium.pressEnterKeyUsingActionBuilder(1);
//            selenium.isElementPresentFast("FieldServiceVacation");
        	selenium.waitingTime(5000);
        	
        	Calendar calendar1 = Calendar.getInstance();
			Date date = calendar1.getTime();
			SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
			String todaysDate = sdf1.format(date);
			
			calendar1.setTime(date);
			calendar1.add(Calendar.DATE, -1);			
			Date dateBefore1Day = calendar1.getTime();
			SimpleDateFormat sdf2 = new SimpleDateFormat("M/d/yyyy");
			String yesterdaysDate = sdf2.format(dateBefore1Day);
			
//			String recordDate = selenium.getText("SR_AbsanceEndTime");
			System.out.println("todays date" + todaysDate);
//			System.out.println("record date" + recordDate);
			System.out.println("yesterday/today date" + yesterdaysDate);
			
			String Xpath1 = selenium.getDynamicXpath_data("AllTagContainsText",todaysDate,"endContains");
			String Xpath2 = selenium.getDynamicXpath_data("AllTagContainsText",yesterdaysDate,"endContains");
			System.out.println("Xpath1 --> " + Xpath1 + "Xpath2 --> " + Xpath2);
			
//			if (recordDate.contains(todaysDate) || recordDate.contains(yesterdaysDate)) {
			if(selenium.isElementPresentXpathFast(Xpath1) || selenium.isElementPresentXpathFast(Xpath2)) {
					selenium.test.log(LogStatus.PASS, "Absence created successfully");
					System.out.println("Absence created successfully");
					selenium.takeScreenShot();
			}

			else {
				System.out.println("clicking last modified date");
				selenium.waitForElementToBeClickable("SR_AbsenceEndtimeColumn");
				selenium.jsClick("SR_AbsenceEndtimeColumn");
				selenium.waitingTime(8000);
	        	selenium.waitForElementToBeVisible("SR_AbsanceEndTime");
				String recordDate1 = selenium.getText("SR_AbsanceEndTime");
				System.out.println("record date" + recordDate1);
				if ((recordDate1.contains(todaysDate)|| recordDate1.contains(yesterdaysDate))) {
					System.out.println("after chcek");
					selenium.test.log(LogStatus.PASS, "Absence created successfully");
					selenium.takeScreenShot();
				}

				else {
					selenium.test.log(LogStatus.FAIL, "Service resource's Absence creation failed ");
					selenium.reportFailure("Service resource's Absence creation failed");
					System.out.println("Service resource's Absence creation failed");
				}
			}

			selenium.captureScreenShot();
			selenium.waitingTime(5000);


        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    
    @Then("Go the the date of the you created the resource absence for and confirm it shows on your calendar")
    public void go_the_the_date_of_the_you_created_the_resource_absence_for_and_confirm_it_shows_on_your_calendar() {
        try {
        	selenium.waitingTime(5000);
            selenium.isElementPresentFast("FieldserviceAbsencevisibleCalendar");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }

    @Then("Click on the Change Status button")
    public void click_on_the_change_status_button() {
        try {
        selenium.waitForElementToBeVisible("ServiceAppointmentsStatus");
        selenium.jsClick("ServiceAppointmentsStatus");
        selenium.waitingTime(3000);
        selenium.click("ServiceAppointmentDashoardDropDown");
        selenium.waitingTime(3000);
        selenium.click("ServiceAppointmentEditOption");
        selenium.waitingTime(3000);

    } catch (Exception e) {
        selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
        selenium.reportFailure("Error while selecting New Button" + e.getMessage());
    }
    }
    @Then("on the next page Select a Status")
    public void on_the_next_page_select_a_status() {
        try {
            AppointmentNumber =  selenium.getText("AppointmentNumberGetText");
            selenium.jsClick("ServiceAppointmentStatusDropDown");
            selenium.jsClick("StatusCancelled");
            selenium.waitingTime(3000);
            selenium.jsClick("ServiceApppointmentCancellationReason");
            selenium.jsClick("ServiceAppointmentCancellationReason");
            selenium.waitingTime(3000);
            selenium.jsClick("ServiceAppointmantcancellationStatusSave");
            selenium.waitingTime(3000);

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting New Button");
            selenium.reportFailure("Error while selecting New Button" + e.getMessage());
        }
    }
    @Then("verify a message box pops up confirming you status update and Click Finish")
    public void verify_a_message_box_pops_up_confirming_you_status_update_and_click_finish() {
        try {
            selenium.typeData("ServiceAppointmentSearch", AppointmentNumber);
            selenium.pressEnterKeyUsingActionBuilder(1);
            selenium.waitingTime(3000);
            selenium.jsClick("ServiceAppointmentsFirstSearch");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("verify the Service Appointment Status updated to the status you selected")
    public void verify_the_service_appointment_status_updated_to_the_status_you_selected() {
        try {
            selenium.jsClick("ServiceAppointmentsFirstSearch");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("go to the Chatter tab and confirm you see an activity related the status update")
    public void go_to_the_chatter_tab_and_confirm_you_see_an_activity_related_the_status_update() {
        try {
            selenium.jsClick("ServiceAppointmentChatter");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("click on the Feed page tab")
    public void click_on_the_feed_page_tab() {
        try {
            selenium.jsClick("ServiceAppointmentChatter");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Click on Email Attendees")
    public void click_on_email_attendees() {
        try {
            selenium.jsClick("ServiceAppointmentFeed");
            selenium.jsClick("ServiceAppointmentEmail");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Click on the template icon")
    public void click_on_the_template_icon() {
        try {
            selenium.jsClick("ServiceAppointmentCompose");
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Click on insert template An Insert Email Template window opens up On the Templates")
    public void click_on_insert_template_an_insert_email_template_window_opens_up_on_the_templates() {
        try {
            selenium.jsClick("ServiceappoinntmentInsertTemplateImage");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    @Then("Search for SFS Training Attendee Email and click on it")
    public void search_for_sfs_training_attendee_email_and_click_on_it() {
        try {
            selenium.jsClick("InsertTemplate");

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }

    @Then("Make any other updates to the email and confirm it all looks good Click Send")
    public void make_any_other_updates_to_the_email_and_confirm_it_all_looks_good_click_send() {
        try {
            selenium.jsClick("MailSendButton");


        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    
    @Then("Confirm the Status of the work order line item updated to Canceled")
    public void confirm_the_status_of_the_WOLI_updated_to_canceled() {
        try {
        	selenium.waitForElementToBeClickable("ParentRecordLink");
			selenium.jsClick("ParentRecordLink");
        	selenium.waitingTime(5000);
        	selenium.refresh();
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("WOStatusInWOLIandWO");
        	WorkOrderStatus = selenium.getText("WOStatusInWOLIandWO");
            System.out.println("WorkOrderLineItemStatus is --> " + WorkOrderStatus);
            if (WorkOrderStatus.equalsIgnoreCase("Canceled")) {
                selenium.test.log(LogStatus.PASS, "WorkOrderLineItemStatus Is Updated With Cancelled Status");
                System.out.println("PASS");
            }
            else
            {
                selenium.test.log(LogStatus.FAIL, "WorkOrderLineItem Is NOT Updated With Cancelled Status");
                selenium.reportFailure("WorkOrderLineItem Is NOT Updated With Cancelled Status");
                System.out.println("FAIL");
            }
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    
    @Then("Confirm the Status of the work order updated to Canceled")
    public void confirm_the_status_of_the_workorder_updated_to_canceled() {
        try {
			selenium.waitForElementToBeClickable("WorkOrderLink");
			selenium.jsClick("WorkOrderLink");
        	selenium.waitingTime(5000);
        	selenium.refresh();
        	selenium.waitingTime(5000);
        	selenium.waitForElementToBeVisible("WOStatusInWOLIandWO");
            WorkOrderStatus = selenium.getText("WOStatusInWOLIandWO");
            System.out.println("WorkOrderStatus is --> " + WorkOrderStatus);
            if (WorkOrderStatus.equalsIgnoreCase("Canceled")) {
                selenium.test.log(LogStatus.PASS, "WorkOrder Is Updated With Cancelled Status");
                System.out.println("PASS");
            }
            else
            {
                selenium.test.log(LogStatus.FAIL, "WorkOrder Is NOT Updated With Cancelled Status");
                selenium.reportFailure("WorkOrder Is NOT Updated With Cancelled Status");
                System.out.println("FAIL");
            }
        }catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while selecting the Xpath Element");
            selenium.reportFailure("Error while selecting the Xpath Element" + e.getMessage());
        }
    }
    
    @And("pickup SA and change the status and validate the fields")
    public void pickup_SA_and_change_the_status_and_validate_the_fields() {
        try {
        	selenium.waitingTime(5000);
			if(selenium.ServiceAppointmentURL != null)
			{
			selenium.navigateToURL(selenium.ServiceAppointmentURL);		//This run time SA will be in NONE status, so we are updating it to In Progress state.
        	selenium.waitingTime(8000);
//        	selenium.waitForElementToBeClickable("Edit_StatusBtn");
//        	selenium.click("Edit_StatusBtn");
//        	selenium.waitingTime(4000);
//        	selenium.waitForElementToBeClickable("StatusDrpDwnNoneStatus");
//        	selenium.click("StatusDrpDwnNoneStatus");
//        	selenium.waitForElementToBeClickable("StatusInProgress");
//        	selenium.click("StatusInProgress");
//        	selenium.click("RecordSaveButton");
//        	selenium.waitingTime(6000);
			}
			else
			{
				System.out.println("ServiceAppointmentURL is null");
				selenium.navigateToURL(ServiceAppointmentURL_VerifyStatus);		//This hard coded SA should be in In Progress status (if not this script will fail)
	        	selenium.waitingTime(8000);
			}        	
        	
        	selenium.waitForElementToBeVisible("SA_StatusText");
        	selenium.takeScreenShot();
        	String SA_Status = selenium.getText("SA_StatusText");
        	if(SA_Status.equalsIgnoreCase("In Progress"))
        	{
        		System.out.println("Service appointment's current status is In-Progress");
            	selenium.waitForElementToBeClickable("ChangeStatusActionBtn");
            	selenium.click("ChangeStatusActionBtn");
            	selenium.waitForElementToBeClickable("SA_ChangeStatusPicklist");
            	selenium.click("SA_ChangeStatusPicklist");
            	selenium.waitForElementToBeClickable("SA_PicklistValue_Completed");
            	selenium.click("SA_PicklistValue_Completed");
            	selenium.click("SA_ChangeStatusNextBtn");
            	selenium.waitingTime(2000);
            	if(selenium.isElementPresentFast("SA_ChangeStatusRequiredField1") && selenium.isElementPresentFast("SA_ChangeStatusRequiredField2")) {
                    selenium.test.log(LogStatus.PASS, "For Completed status user should enter a Start & End Date/Time");
                    System.out.println("PASS");
                    selenium.takeScreenShot();
                }
                else
                {
                    selenium.test.log(LogStatus.FAIL, "Validation Failed");
                    selenium.reportFailure("Validation Failed");
                    System.out.println("FAIL");
                }
            	
            	selenium.click("SA_ChangeStatusPreviousBtn");
            	selenium.waitingTime(2000);
               	selenium.waitForElementToBeClickable("SA_ChangeStatusPicklist");
            	selenium.click("SA_ChangeStatusPicklist");
            	selenium.waitForElementToBeClickable("SA_PicklistValue_CannotComplete");
            	selenium.click("SA_PicklistValue_CannotComplete");
            	selenium.click("SA_ChangeStatusNextBtn");
            	selenium.waitingTime(4000);
            	if(selenium.isElementPresentFast("SA_ChangeStatusRequiredField1") && selenium.isElementPresentFast("SA_ChangeStatusRequiredField2")) {
                    selenium.test.log(LogStatus.PASS, "For Cannot Completed status user should enter a Start & End Date/Time");
                    System.out.println("PASS");
                    selenium.takeScreenShot();
                }
                else
                {
                    selenium.test.log(LogStatus.FAIL, "Validation Failed");
                    selenium.reportFailure("Validation Failed");
                    System.out.println("FAIL");
                }

                selenium.typeData("SA_ChangeStatusStartDateField",selenium.getCurrentDate(0));
                selenium.typeData("SA_ChangeStatusEndDateField",selenium.getCurrentDate(1));
                selenium.waitingTime(1000);
            	selenium.click("SA_ChangeStatusNextBtn");
            	selenium.waitingTime(2000);
            	if(selenium.isElementPresentFast("SA_CannotCompleteReasonField")) {
                    selenium.test.log(LogStatus.PASS, "For Cannot Complete status user should enter Reason for Cannot Complete");
                    System.out.println("PASS");
                    selenium.takeScreenShot();
                }
                else
                {
                    selenium.test.log(LogStatus.FAIL, "Validation Failed");
                    selenium.reportFailure("Validation Failed");
                    System.out.println("FAIL");
                }
//            	We are not changing the SA status to complete/cannot complete as we cannot revert back the status for next test execution
            	selenium.click("CloseWindow");
            	 selenium.waitingTime(5000);
        	}
            else
            {
                selenium.test.log(LogStatus.FAIL, "The picked service appointment is not in required status i.e. In-Progress");
                selenium.reportFailure("The picked service appointment is not in required status i.e. In-Progress");
                System.out.println("FAIL");
            }            

        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while Selecting Non Availability and Click Next");
            selenium.reportFailure("Error while Selecting Non Availability and Click Next" + e.getMessage());
        }
    }
    
    @And("update the SA status to InProgress")
    public void update_the_SA_status_to_InProgress() {
        try {
			selenium.navigateToURL(selenium.ServiceAppointmentURL);		//This run time SA will be in NONE status, so we are updating it to In Progress state.
        	selenium.waitingTime(8000);
        	selenium.refresh();
        	selenium.waitingTime(8000);
        	selenium.waitForElementToBeClickable("Edit_StatusBtn");
        	selenium.takeScreenShot();
        	selenium.click("Edit_StatusBtn");
        	selenium.waitingTime(4000);
        	selenium.waitForElementToBeClickable("StatusDrpDwnNoneStatus");
        	selenium.click("StatusDrpDwnNoneStatus");
        	selenium.waitForElementToBeClickable("StatusInProgress");
        	selenium.click("StatusInProgress");
        	selenium.click("RecordSaveButton");
        	selenium.waitingTime(10000);
        	selenium.test.log(LogStatus.INFO, "Updated SA status to In Progress");
        } catch (Exception e) {
            selenium.test.log(LogStatus.FAIL, "Error while updating SA status");
            selenium.reportFailure("Error while updating SA status" + e.getMessage());
        }
    }
}
