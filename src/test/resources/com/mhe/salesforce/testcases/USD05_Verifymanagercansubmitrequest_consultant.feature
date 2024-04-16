#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify requestor and manager can be same  on consultant form when manager submit the request 

Background: 
    Given I am logged into salesforce for "verifymanagersubmitformconsultant"     
  
@ConsultantNA @verifymanagersubmitformconsultant @GCRM-5014
Scenario Outline: verify requestor and manager can be same  on consultant form when manager submit the request

    Given Runmode for "verifymanagersubmitformconsultant" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Ops_Adm_Manager>"
    And Navigate to new consultant page
    Then enter all mandatory fields except email
    Then edit the form and update the manager

    Examples:
    |SEG_Sales_Ops_Adm_Manager|
    |Amy_Stumpf|