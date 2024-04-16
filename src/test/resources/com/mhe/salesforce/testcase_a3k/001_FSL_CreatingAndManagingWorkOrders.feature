Feature: FSL Create and Manage Work Orders

Background:
  Given I am logged into salesforce for "FSLSalesRepCreateWO_PreSales"

@FSL @FSLCreatingWorkOrders @FSLSalesRepCreateWO_PreSales @GCRM-20945 @GCRM-19498 @GCRM-22221
Scenario Outline: Create Pre-Sales Work Orders (Happy Path)
  Given Runmode for "FSLSalesRepCreateWO_PreSales" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Opportunities" tab
  Then I create a new opportunity for FSL
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields SalesRep
  Then On the next page Validate a Success Message Work Order #xxxxxxx has been successfully created. It has not been submitted yet
  Then Validate when click on Open New Work Order button it navigate you to the newly created work order record
  #When I navigate to "Work Orders" tab
  And open the new work order
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Open_Baker  | PreSales |

@FSL @FSLCreatingWorkOrders @FSLSalesRepCreateWO_PostSales @GCRM-20945 @GCRM-19261 @GCRM-19512 @21502
Scenario Outline: Create / Submit Post-Sales Work Order / Add PDs (Happy Path)
  Given Runmode for "FSLSalesRepCreateWO_PostSales" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Accounts" tab
#  Then I create a new account for FSL
  When User click on create work order button
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields SalesRep
  Then On the next page Validate a Success Message Work Order #xxxxxxx has been successfully created. It has not been submitted yet
  Then Validate when click on Open New Work Order button it navigate you to the newly created work order record
  And Submit WO and validate PD Usage and Presentation type missing message
  And add PD Usage Summary and Presentation type details
  And Submit WO and validate the WO status and owner
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Christy_Freese  | PostSales | 
    
#DEPENDENT SCRIPT - This script is dependent on FSLSalesRepCreateWO_PostSales script for getting the WO URL (selenium.PostSalesWorkOrderURL)
@FSL @FSLCreatingWorkOrders @FSLMHSchedulerAddWorkOrderLineItem @GCRM-20945 @GCRM-19231
Scenario Outline: Adding WOLI’s to a Work Order
  Given Runmode for "FSLMHSchedulerAddWorkOrderLineItem" is Y
  Then I do login as "<SCHEDULER>"
  And I change the app launcher to "Field Service Console"
  And add Work order line item for work order
  Then create service appointment for workorderlineitem of new workorder
  Then On the next page validate PD Days is Created
  Then On the next page validate non-billable appointments
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  Then Validate the Records are created
  And open PD Usage related list in Service Appointment
  And click on PD Service and validate PD Usage Summary
  Examples:
    | SCHEDULER  |
    | Amy_Stumpf  |    

#DEPENDENT SCRIPT - This script is dependent on FSLSalesRepCreateWO_PostSales script for getting the WO URL (selenium.PostSalesWorkOrderURL)
@FSL @FSLCreatingWorkOrders @FSLMHSchedulerProcessWO_PostSales @GCRM-20945 @GCRM-19228
Scenario Outline: Process a Submitted Pre-sales Work Order by Sales Team.
  Given Runmode for "FSLMHSchedulerProcessWO_PostSales" is Y
  Then I do login as "<SCHEDULER>"
  And I change the app launcher to "Field Service Console"
  Then create service appointment for workorderlineitem of new workorder
  Then On the next page validate PD Days is Created
  Then On the next page validate non-billable appointments
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  Then Validate the Records are created
  And open PD Usage related list in Service Appointment
  #And click on PD Service and validate PD Usage Summary
  Examples:
    | SCHEDULER  |
    | Amy_Stumpf  |
    
@FSL @FSLCreatingWorkOrders @FSLMHSchedulerCreateWO_PreSales @GCRM-20945 @GCRM-19513
Scenario Outline: Create Pre-Sales Work Orders (Happy Path)
  Given Runmode for "FSLMHSchedulerCreateWO_PreSales" is Y
  Then I do login as "<SCHEDULER>"
  And I change the app launcher to "Field Service Console"
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields Scheduler
  Then On the next page validate Service Appointment is Created
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  Then Validate the Records are created
  And add all different presentation types to the workorder
  Examples:
    | SCHEDULER  | SALES_OPTION |
    | Amy_Stumpf  | PreSales |
    
@FSL @FSLCreatingWorkOrders @FSLMHSchedulerCreateWO_Others @GCRM-20945
Scenario Outline: Create Others Work Orders
  Given Runmode for "FSLMHSchedulerCreateWO_Others" is Y
  Then I do login as "<SCHEDULER>"
  And I change the app launcher to "Field Service Console"
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields Scheduler
  Then On the next page validate Service Appointment is not Created
  Then On the next page Validate a Success Message Work Order #xxxxxxx has been successfully created. It has not been submitted yet
  Then Validate when click on Open New Work Order button it navigate you to the newly created work order record
  #When I navigate to "Work Orders" tab
  And open the new work order
  #And add all different presentation types to the workorder
  Examples:
    |SCHEDULER|SALES_OPTION|
    |Amy_Stumpf|Others| 
    
@FSLNA @FSLCreatingWorkOrders @FSLMHSchedulerCloningWO_PreSales @GCRM-20945 @GCRM-19226
Scenario Outline: Clone a PreSales Work Orders (Happy Path)
  Given Runmode for "FSLMHSchedulerCloningWO_PreSales" is Y
  Then I do login as "<SCHEDULER>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Work Orders" tab
  When User click on Clone work order button
  Then Validate Clone Work Order Message
  Then Navigate to Cloned Work Order
  Examples:
    | SCHEDULER  | SALES_OPTION |
    | Amy_Stumpf  | PreSales |
    
@FSL @FSLCreatingWorkOrders @FSLA3KSchedulerCreateWO_Other @GCRM-20945 @GCRM-19270 @GCRM-21502
Scenario Outline: Create an Non-Billable “Other” Work Order ( From Account Record)
  Given Runmode for "FSLA3KSchedulerCreateWO_Other" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
#	 When I navigate to "Accounts" tab
#  Then I create a new account for FSL
  When User click on create work order button
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then Select "<SALES_OPTION>" work order record type and click next
  And create other Work Order by filling mandatory fields Scheduler
  Then On the next page Validate a Success Message Work Order #xxxxxxx has been successfully created. It has not been submitted yet
  Then Validate when click on Open New Work Order button it navigate you to the newly created work order record
#  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then create service appointment for workorderlineitem of new workorder
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Stefanie_Vogel  | Others |
    
@FSL @FSLCreatingWorkOrders @FSLA3KSchedulerCreateWO_PostSale @GCRM-20945 @GCRM-19266 @GCRM-21315 @21455
Scenario Outline: Create Post-Sales Work Orders (Billable) -Happy Path
  Given Runmode for "FSLA3KSchedulerCreateWO_PostSale" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Accounts" tab
#  Then I create a new account for FSL
  When User click on create work order button
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields A3KScheduler
  Then On the next page validate Service Appointment is Created
  Then On the next page validate PD Days is Created
  Then On the next page validate non-billable appointments
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  Then Validate the Records are created
  And open PD Usage related list in Service Appointment
  And click on PD Service and validate PD Usage Summary
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Jessica_Devlin  | PostSales |
    
@FSL @FSLCreatingWorkOrders @FSLA3KSchedulerManageWO_PostSale @GCRM-20945 @GCRM-19275
Scenario Outline: Creating & Converting Holds
  Given Runmode for "FSLA3KSchedulerManageWO_PostSale" is Y
  Then I do login as "<SALES_REP>"
  And I change the app launcher to "Field Service Console"
  When I navigate to "Accounts" tab
#  Then I create a new account for FSL
  When User click on create work order button
  |https://mh--uat.sandbox.lightning.force.com/lightning/r/Account/0018000000bwrieAAA/view|
  Then Select "<SALES_OPTION>" work order record type and click next
  And create Work Order by filling mandatory fields A3KScheduler
  Then On the next page validate Service Appointment is Created
  Then On the next page validate PD Days is Created
  Then Validate when click on Open New Service Appointment button it navigate you to the newly created service appointment
  When I navigate to "Service Appointments" tab
  And open the new service appointment
  #And validate service resource got auto assigned
  Then Validate the Records are created
  Then Validate Manage Hold functionality when SA has no PD Days
  Then Validate Manage Hold functionality when SA has PD Days
  #And open PD Usage related list in Service Appointment
  #And click on PD Service and validate PD Usage Summary
  Examples:
    | SALES_REP  | SALES_OPTION |
    | Jessica_Devlin  | PostSales |
