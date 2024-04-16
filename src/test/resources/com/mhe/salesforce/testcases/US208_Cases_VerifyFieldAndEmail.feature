#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the LMS field of Case Object and email address

  Background: 
    Given I am logged into salesforce for "VerifyFieldAndEmail"

  @Cases @GCRM-6006 @GCRM-5648 @GCRM-6076 @VerifyFieldAndEmail
  
  Scenario Outline: Verify the LMS field of Case Object and email address
  
  Given Runmode for "VerifyFieldAndEmail" is Y
#  Then I login as Sales Rep
    Then I do login as "<System_Administrator>"
#  Then I change the app launcher to CSOM Lightning Console
    And  I change the app launcher to <app_Name>
  When I navigate to cases tab
  And open case and verify the LMS field value from picklist
  Then verify Email address is present

    Examples:
      |app_Name|System_Administrator|
      |"CSOM Lightning Console"|Sivasankaran_Periyasamy|
    