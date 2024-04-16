#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As NSS, I can view leads from Marketo

  Background:
    Given I am logged into salesforce for "ViewLeadFromMeaketo"

	@Leads
  @ViewLeadFromMeaketo @GCRM-9254
  Scenario Outline: As NSS, I can view leads from Marketo
    Given Runmode for "ViewLeadFromMeaketo" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to Leads tab
    And I select required search criteria for global search dropdown
    Then click on Lead based on Search
    And Validate Created By field in System information Section

      Examples:
      |MHHE_Business_Administrator|
      |Jaime_Klar|