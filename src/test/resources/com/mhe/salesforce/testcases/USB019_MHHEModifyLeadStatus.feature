#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As NSS, I can modify lead status

  Background:
    Given I am logged into salesforce for "MHHEModifyLeadStatus"

	@Leads
  @MHHEModifyLeadStatus @GCRM-9302
  Scenario Outline: As NSS, I can modify lead status
    Given Runmode for "MHHEModifyLeadStatus" is Y
#   Then I login as Sales Rep
    Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to Leads tab
    And I select required search criteria for global search dropdown
    Then click on Lead based on Search
    And Modify Lead Status

  Examples:
    |MHHE_Business_Administrator|
    |Jaime_Klar|