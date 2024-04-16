#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify new MHE Functional field picklist value

  Background: 
    Given I am logged into salesforce for "CreateCSOMCaseAndVerifyFunctionalField"

  @Cases @GCRM-5059 @CreateCSOMCaseAndVerifyFunctionalField
  Scenario Outline: CreateCSOMCaseAndVerifyFunctionalField
    Given Runmode for "CreateCSOMCaseAndVerifyFunctionalField" is Y
#    Then I login as Sales Rep
    Then I do login as "<CSOM_General_User>"
    And  I change the app launcher to <app_Name>
    Then click on New case by selecting one contact
    Then select record type as CSOM Support
    And verify the MHE functional field values

    Examples:
      |app_Name|CSOM_General_User|
      |"CSOM Lightning Console"|Lisa_Phelps|