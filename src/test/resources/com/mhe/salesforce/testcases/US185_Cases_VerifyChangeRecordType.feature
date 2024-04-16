#DEPENDANT_SCRIPT - This script is dependent on 'VerifyCSOMCaseHistoryTab' script for getting 'selenium.CSOMCaseURL'
Feature: Verify change record type button

  Background: 
    Given I am logged into salesforce for "VerifyChangeRecordType"

  @Cases @GCRM-3653 @TC185_US_Cases_VerifyLMSCheck @GCRM-3653
  Scenario Outline: VerifyChangeRecordType
    Given Runmode for "VerifyChangeRecordType" is Y
#    Then I login as <CSOM_General_User>
    Then I do login as "<CSOM_General_User>"
    And  I change the app launcher to <app_Name>
    Then verify the change record type button check
    Examples:
    |CSOM_General_User|app_Name|
    |Lisa_Phelps|"CSOM Lightning Console"|