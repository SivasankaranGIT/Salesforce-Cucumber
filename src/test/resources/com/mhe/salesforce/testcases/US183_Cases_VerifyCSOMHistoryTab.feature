#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the CSOM case History Tab

  Background: 
    Given I am logged into salesforce for "VerifyCSOMCaseHistoryTab"

  @Cases @GCRM-4672 @TC183_US_Cases_VerifyCSOMCaseHistoryTab @GCRM-4672
  Scenario Outline: VerifyCSOMCaseHistoryTab
    Given Runmode for "VerifyCSOMCaseHistoryTab" is Y
#    Then I login as Sales Rep
    Then I do login as "<CSOM_General_User>"
    And  I change the app launcher to <app_Name>
    #Then I navigate to CSOM Lightning Console Home page
    Then click on New case by selecting one contact
    Then select record type as CSOM Support
    And fill all mandatory details to create CSOM case
    Then create the history CSOM case
    And verify in resolution tab internal desciption should not be there
    Then verify the internal description history page

    Examples:
      |app_Name|CSOM_General_User|
      |"CSOM Lightning Console"|Lisa_Phelps|