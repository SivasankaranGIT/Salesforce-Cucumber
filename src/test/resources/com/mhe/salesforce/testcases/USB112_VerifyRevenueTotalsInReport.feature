#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify reports show proper revenue totals 

  Background:
    Given I am logged into salesforce for "VerifyRevenueTotalsInReport"

	@OpportunitiesNonDependent
  @VerifyRevenueTotalsInReport
  @GCRM-9146
  Scenario Outline: Verify reports show proper revenue totals
    Given Runmode for "VerifyRevenueTotalsInReport" is Y
#    Then I login as Sales Rep in classic
      Then I do login as classic "<SEG_Business_Admin>"
    And switch to classic user interface
    And navigate to desired account in SF Classic
    And navigate to Account Call Report and run the report
    And verify revenue total in report

      Examples:
      |SEG_Business_Admin|
      |Ivan_Gomez|