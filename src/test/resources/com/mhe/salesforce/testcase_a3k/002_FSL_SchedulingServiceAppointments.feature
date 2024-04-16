Feature: FSL Scheduling Service Appointments

Background:
  Given I am logged into salesforce for "CancellingAServiceAppointment"

@FSL @FSLSchedulingServiceAppointments @FSLCancellingServiceAppointments @GCRM-20940 @GCRM-19232
Scenario Outline: Cancelling a Service Appointment
  Given Runmode for "CancellingAServiceAppointment" is Y
  Then I do login as "<SCHEDULE_ADMIN>"
	#And I change the app launcher to "MHHE"
  When I navigate to "Service Appointments" tab
  And Locate the Service Appointment record to be cancelled
  Then Update the Status field to Cancelled AND Enter a Cancellation OR Cannot Complete Reason and Click Save
  Then Confirm the Status of the service appointment updated to Canceled
  Then Confirm the Status of the work order line item updated to Canceled
  Then Confirm the Status of the work order updated to Canceled
  Examples:
    | SCHEDULE_ADMIN  |
    | Stefanie_Vogel  |
    

@FSL @FSLSchedulingServiceAppointments @FSLA3KScheduler_AutoScheduleServiceResourceToSA @GCRM-21948 @GCRM-19279
Scenario Outline: Auto Schedule a Service Appointment
  Given Runmode for "FSLA3KScheduler_AutoScheduleServiceResourceToSA" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Accounts" tab
  When User click on create work order button
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields A3KScheduler
  Then On the next page validate Service Appointment is Created
  Then On the next page validate PD Days is Created
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  And validate service resource got auto assigned
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Stefanie_Vogel  | PostSales |

#DEPENDENT_SCRIPT :This script dependent on 'FSLA3KScheduler_AutoScheduleServiceResourceToSA' for getting 'ServiceAppointmentURL' 
@FSL @FSLSchedulingServiceAppointments @FSLA3KScheduler_AssignSRToSAUsingCandidateBtn @GCRM-21948 @GCRM-19236
Scenario Outline: Use the Candidate action button on the Service Appointment Record (No Assigned Service Resource)
  Given Runmode for "FSLA3KScheduler_AssignSRToSAUsingCandidateBtn" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
	And assign service resources through Candidate action button
	And validate service resource got assigned
  Examples:
    | SALES_REP  |
    | Stefanie_Vogel  |