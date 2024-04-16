#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify 'Internal Description History' related list functionality on CXG case details page

  Background:
    Given I am logged into salesforce for "VerifyInternalDescriptionHistory"

  @Cases @VerifyInternalDescriptionHistory @GCRM-17742
  Scenario Outline: Verify 'Internal Description History' related list functionality on CXG case details page
    Given Runmode for "VerifyInternalDescriptionHistory" is Y
    Then I do login as "<CXG_Admin_User>"
    Then I change the app launcher to "<CXG_Lightning_Console>"
    Then I navigate to cases
    Then I create a new case for CXG Lightning Console
    Then Validate Internal Description History Page
    Examples:
      |CXG_Admin_User|CXG_Lightning_Console|
      |Eric_Nelson|CXG Lightning Console|