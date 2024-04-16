#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify MHHE Links

  Background:
    Given I am logged into salesforce for "VerifyMHHELinks"

  @OpportunitiesNonDependent @VerifyMHHELinks @GCRM-16488
  Scenario Outline: Verify MHHE Links
    Given Runmode for "VerifyMHHELinks" is Y
    Then I do login as "<MHHE_Business_Admin>"
    And I change the app launcher to "MHHE"
    And verify the MHHE Links

    Examples:
      |MHHE_Business_Admin|
      |Jaime_Klar|