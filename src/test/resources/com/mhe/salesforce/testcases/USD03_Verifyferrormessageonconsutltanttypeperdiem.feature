#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify error message when consultant type not equals per diem 

Background: 
    Given I am logged into salesforce for "verifyconsultanttype"    
  
@Consultant
@verifyconsultanttype    @GCRM-2951
Scenario Outline: verify error message when consultant type not equals per diem

    Given Runmode for "verifyconsultanttype" is Y
    Then I do login as "<SEG_Sales_Ops_Adm_Scheduler>"
    And I navigate to consultant assignment page
    And I validate consultant type error message

    Examples:
    |SEG_Sales_Ops_Adm_Scheduler|
    |Amy_Stumpf|