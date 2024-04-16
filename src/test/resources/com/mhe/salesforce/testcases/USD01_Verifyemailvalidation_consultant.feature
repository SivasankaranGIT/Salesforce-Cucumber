#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify email validation on consultant form 

Background: 
    Given I am logged into salesforce for "verifyemailconsultant"     
  
@ConsultantNA @verifyemailconsultant @GCRM-5016
Scenario Outline: verify email validation on consultant form

    Given Runmode for "verifyemailconsultant" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Ops_Adm_Scheduler>"
    And Navigate to new consultant page
    Then enter all mandatory fields except email
    Then Verify Invalid email/opportunityLinked error message
    Then enter valid email and Opportunity save

    Examples:
    |SEG_Sales_Ops_Adm_Scheduler|
    |Amy_Stumpf|