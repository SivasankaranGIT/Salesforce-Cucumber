Feature: FSL Delivery Of Service

Background:
  Given I am logged into salesforce for "ServiceReportOnDesktop"

  @FSL @FSLSchedulingServiceAppointments @FSLServiceReportOnDesktop @GCRM-20940 @GCRM-19194 @GCRM-19205
  Scenario Outline: Service Report on Desktop
    Given Runmode for "ServiceReportOnDesktop" is Y
    Then I do login as "<SCHEDULE_ADMIN>"
#		And I change the app launcher to "Sales"
		Then I navigate to salesapplication
    When I navigate to "Service Appointments" tab
    And Locate a Service Appointment that is completed
    Then On the Service Appointment record click on the Create Service Report button
    Then A Service Report Preview window opens confirm all looks good If any changes are needed click cancel
    #Then You should see a message that a PDF was saved successfully
    Then the Service Appointment record, locate the Service Reports related list and click on View All
    Then Click on the Service Report Name link to preview
    Examples:
      | SCHEDULE_ADMIN  |
      | Stefanie_Vogel |

  @FSL @FSLSchedulingServiceAppointments @FSLNavigatingServiceAppointmentOnDesktop @GCRM-20940 @GCRM-19203 @GCRM-19192
  Scenario Outline: Navigating Service appointment on Desktop
    Given Runmode for "NavigatingServiceAppointmentOnDesktop" is Y
    Then I do login as "<SCHEDULE_ADMIN>"
		And I change the app launcher to "Sales"
    When I navigate to "Service Appointments" tab
    Then Select the My Service Appointments list view
    Then on the next page Click on a Service Appointment and confirm you see Action button
    Then Work Plan Work Steps Related lists Attendees Customer Survey Responses-Service Appointment History Files
    Then Explore the record and validate you can see all the needed information to delivery training work requested
    Examples:
      | SCHEDULE_ADMIN  |
      | Stefanie_Vogel |

  @FSL @FSLSchedulingServiceAppointments @FSLCreateaResourceAbsenceontheDesktop @GCRM-20940 @GCRM-19207 @GCRM-19196
  Scenario Outline: Create a Resource Absence on the Desktop
    Given Runmode for "CreateaResourceAbsenceontheDesktop" is Y
    Then I do login as "<SCHEDULE_ADMIN>"
		And I change the app launcher to "Sales"
    When I navigate to "Service Resources" tab
    Then Click on your Name link
    Then Locate the Absences related list on the right hand side
    Then Click on the drop down arrow and click on NEW
    Then Enter the required Start Time End Time Type and  Click Save
    Then Upon saving you are taken to the Resource Absence record Confirm the Times look correct
    When I navigate to "Calendar" tab
    Then Go the the date of the you created the resource absence for and confirm it shows on your calendar
    Examples:
      | SCHEDULE_ADMIN  |
      | Stefanie_Vogel |

#DEPENDENT_SCRIPT :This script dependent on 'FSLA3KScheduler_AutoScheduleServiceResourceToSA' for getting 'ServiceAppointmentURL'
  @FSL @FSLSchedulingServiceAppointments @FSLUpdateServiceAppointmentStatusOnDesktop @GCRM-20940 @GCRM-19204 @GCRM-19193
  Scenario Outline: Update Service Appointment Status on Desktop
    Given Runmode for "UpdateServiceAppointmentStatusOnDesktop" is Y
    Then I do login as "<SALES_REP>"
    And update the SA status to InProgress
    Then I logout of any user
    Then I do login as "<SCHEDULE_ADMIN>"
		And I change the app launcher to "Salesforce Chatter"
    When I navigate to "Service Appointments" tab
    And pickup SA and change the status and validate the fields
    #Then Click on the Change Status button
    #Then on the next page Select a Status
    #Then verify a message box pops up confirming you status update and Click Finish
    #Then verify the Service Appointment Status updated to the status you selected
    #And Locate the Service Appointment record to be cancelled
    #Then Update the Status field to Cancelled AND Enter a Cancellation OR Cannot Complete Reason and Click Save
    #Then Confirm the Status of the service appointment updated to Canceled
    #Then go to the Chatter tab and confirm you see an activity related the status update
    #Then click on the Feed page tab
    #Then Click on Email Attendees
    #Then Click on the template icon
    #Then Click on insert template An Insert Email Template window opens up On the Templates
    #Then Search for SFS Training Attendee Email and click on it
    #Then Make any other updates to the email and confirm it all looks good Click Send
    Examples:
      | SCHEDULE_ADMIN  | SALES_REP  |
      | Stefanie_Vogel | Stefanie_Vogel  |