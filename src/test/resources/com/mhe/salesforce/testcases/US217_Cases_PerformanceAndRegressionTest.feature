#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Performance and Regression test scenarios

  Background:
    Given I am logged into salesforce for "PerformanceAndRegressionTest"

  @Cases @PerformanceAndRegressionTest @GCRM-18209
  Scenario Outline: Performance and Regression test scenarios
    Given Runmode for "PerformanceAndRegressionTest" is Y
    Then I do login as "<CSOM_Business_Admin>"
    Then I change the app launcher to "<CSOM_Lightning_Console>"
    Then I go to app launcher and select Internal Description Header
    Then verify the different buttons and fields
    Then verify the cancel button functionality
    Then verify the changes in record type
    Then I navigate to cases
    Then I create a new case for CSOM record type
    Then I logout of any user
    Then I do login as "<CSOM_General_User>"
    Then validate the case from another user

    Examples:
      |CSOM_Business_Admin|CSOM_Lightning_Console|CSOM_General_User|
      |Jennifer_Ryan|CSOM Lightning Console|Cristen_Anglin|