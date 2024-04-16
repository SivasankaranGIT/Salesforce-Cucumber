#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify Opportunity validation on consultant form 

Background: 
    Given I am logged into salesforce for "verifyopportunityconsultant"     
  
@ConsultantNA @verifyopportunityconsultant @GCRM-5015
Scenario Outline: verify Opportunity validation on consultant form

    Given Runmode for "verifyopportunityconsultant" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Ops_Adm_Scheduler>"
    And Navigate to new consultant page
    Then enter all mandatory fields except email
    Then Verify Invalid email/opportunityLinked error message
    Then enter valid email and Opportunity save

    Examples:
    |SEG_Sales_Ops_Adm_Scheduler|
    |Amy_Stumpf|