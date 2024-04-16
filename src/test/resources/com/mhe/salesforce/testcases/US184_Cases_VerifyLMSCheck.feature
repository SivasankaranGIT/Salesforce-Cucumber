#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the LMS Field Check

  Background: 
    Given I am logged into salesforce for "VerifyLMSCheck"

  @Cases @GCRM-3908 @TC184_US_Cases_VerifyLMSCheck @GCRM-3908
  Scenario Outline: VerifyCSOMCaseHistoryTab
    Given Runmode for "VerifyLMSCheck" is Y
#    Then I login as Sales Rep
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name>
    Then global search for contact
    Then click on New case by selecting one contact
    And verify the LMS field check

    Examples:
      |app_Name|CXG_Administrator|
      |"CXG Lightning Console"|Eric_Nelson|

