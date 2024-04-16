#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify requestor and manager should not be same  on consultant form 

Background: 
    Given I am logged into salesforce for "verifyrequestorandmanagerconsultant"    
  
@ConsultantNA @verifyrequestorandmanagerconsultant @GCRM-5013
Scenario Outline: verify requestor and manager should not be same  on consultant form

    Given Runmode for "verifyrequestorandmanagerconsultant" is Y
#    Then I login as Sales Rep
    Then I do login as "<SEG_Sales_Rep>"
    And Navigate to new consultant page
    Then enter all mandatory fields except email
    Then Verify Invalid email/opportunityLinked error message

    Examples:
    |SEG_Sales_Rep|
    |Anthony_Greeson|