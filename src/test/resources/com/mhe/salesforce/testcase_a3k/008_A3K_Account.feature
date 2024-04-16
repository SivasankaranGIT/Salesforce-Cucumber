#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Ramkaran Singh
Feature: Verify Operating Hours are updated automatically with the related Time Zone.

Background:
Given I am logged into salesforce for "VerifyOperatingHours"

@A3K @A3KCases @GCRM-22443 @GCRM-22278 @GCRM-22277 @GCRM-22147
@VerifyOperatingHours
Scenario Outline: Verify OperatingHours are updated automatically with the related Time Zone.
Given Runmode for "VerifyOperatingHours" is Y
Then I do login as "<SEG_Business_Admin>"
Then I navigate to salesapplication
And I navigate to "<Accounts>" tab
Then I create a new account for MHES lightning console
Then I verify the time zone operating hours
Then I verify the Exclude Monthly Exclude Weekly touch points
Then I verify the sharepoint account name and record id
Then I click work order button
Then Select "<SALES_OPTION>" work order record type and click next
Then I verify the type dropdown picklist
Then I logout of any user
Then I do login as "<A3K_Customer_Support>"
Then I open an existing record
|https://mh--uat.sandbox.lightning.force.com/lightning/r/Order_Line__c/a0r8b00000sgkeDAAQ/view|
Examples:
|SEG_Business_Admin|Accounts|SALES_OPTION|Sales|A3K_Customer_Support|
|Ivan_Gomez   |Accounts|PreSales    |Sales|Steve_Loori      |

#Created By:Ramkaran Singh
@A3K @A3KCases @GCRM-23646
@VerifyWorkOrderTabInAccountAndOpp
Scenario Outline: To verify work order tab is present on the Account  & Opportunity record also verify New button is present on the work order related list .
Given Runmode for "VerifyWorkOrderTabInAccountAndOpp" is Y
Then I do login as "<SEG_Business_Admin>"
Then I change the app launcher to "<MHES_Lightning_Console>"
And I navigate to "<Accounts>" tab
Then I create a new account for MHES lightning console
Then I verify the work order tab and new button
Then I navigate to opportunity tab
Then create opportunity with same account name as of contact
Then I verify the work order tab and new button on opportunity

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|Accounts|
|Ivan_Gomez   |MHES Lightning Console|Accounts|


#Created By:Ramkaran Singh
@A3K @A3KCases @GCRM-23174
@VerifyCRFFunctionalityIsLocked
Scenario Outline: Confirm CRF functionality is locked down
Given Runmode for "VerifyCRFFunctionalityIsLocked" is Y
Then I do login as "<SEG_Business_Admin>"
Then I change the app launcher to "<MHES_Lightning_Console>"
And I navigate to "<Consultant_Requests>" tab
Then I verify the consultant request record
Then I navigate to "<Consultants>" tab
Then I verify the consultant record
Then I navigate to "<Accounts>" tab
Then Verify the New crf button
Then I navigate to "<Opportunities>" tab
Then Verify the New crf button in opp

Examples:
|SEG_Business_Admin|MHES_Lightning_Console|Consultant_Requests|Consultants|Accounts|Opportunities|
|Ivan_Gomez   |MHES Lightning Console|Consultant Requests|Consultants |Accounts|Opportunities|


#Created By:Ramkaran Singh
@FSL @FSLCreatingWorkOrders @FSLSalesRepCreateWO_PostSalesWithTypeMcGraw  @GCRM-24454 @GCRM-24509
Scenario Outline: Confirm user can submit work order after updated user manager /Create / Submit Post-Sales Work Order / Add PDs (Happy Path)
Given Runmode for "FSLSalesRepCreateWO_PostSalesWithTypeMcGraw" is Y
Then I do login as "<SALES_REP>"
And I change the app launcher to "Field Service Console"
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


#Created By:Ramkaran Singh
@A3K @A3KCases @GCRM-21074
@VerifyCreateDailyNewOrderReport
Scenario Outline: Verify user is able to Create Daily New Orders Report
Given Runmode for "VerifyCreateDailyNewOrderReport" is Y
And I logout of any user
Then I change the app launcher to "<MHES_Lightning_Console>"
Then Verifying user is able to create daily new orders report
Examples:
|MHES_Lightning_Console|
|MHES Lightning Console|


#Created By:Ramkaran Singh
@A3K @A3KCases @GCRM-18860 @GCRM-18861
@UpdateServiceTerritoryRecovery
Scenario Outline: Update a Service Territory Recovery/Deactivate a Service Territory
Given Runmode for "UpdateServiceTerritoryRecovery" is Y
Then I do login as "<Scheduler>"
Then I change the app launcher to "<Field_Service_Console>"
Then I navigate to "<Service_Territories>" tab
Then I verify the fields on service territory screen

Examples:
|Scheduler|Service_Territories|Field_Service_Console|
|Ivan_Gomez|Service Territories|Field Service Console|


@FSL @FSLSchedulingServiceAppointments @SA_IsHoveredInResourceView @GCRM-23973
Scenario Outline: Auto Schedule a Service Appointment
Given Runmode for "SA_IsHoveredInResourceView" is Y
Then I do login as "<SALES_REP>"
And I change the app launcher to "Field Service Console"
When I navigate to "Accounts" tab
#And I create a new account for FSL
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
