#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify users have read access to cases based on record type and cases based queue

  Background: 
    Given I am logged into salesforce for "VerifyReadAccess"

  @Cases @GCRM-4726 @GCRM-4725 @GCRM-4663 @VerifyReadAccess  
  Scenario Outline: Verify users have read access to cases based on record type and cases based queue
    Given Runmode for "VerifyReadAccess" is Y
#    Then I login as Sales Rep
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name1>
    And verify the read access to case based on record type
    Then I logout of any user
#    And I login as ALEKS user
    Then I do login as "<ALEKS_Administrator>"
    And  I change the app launcher to <app_Name2>
    Then verify the read access to case based queue type
    Examples:
      |app_Name1|app_Name2|CXG_Administrator|ALEKS_Administrator|
      |"CXG Lightning Console"|"ALEKS Lightning Console"|Eric_Nelson|Isaac_Rubio|