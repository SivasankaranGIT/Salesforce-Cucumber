#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As NSS, I can convert leads from Marketo to contacts.

  Background:
    Given I am logged into salesforce for "ConvertLeadToContact"

	@Leads
  @ConvertLeadToContact @GCRM-9027
  Scenario Outline: As NSS, I can convert leads from Marketo to contacts.
    Given Runmode for "ConvertLeadToContact" is Y
#    Then I login as Sales Rep
      Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to Leads tab
    And Create a New Lead
    Then Validate that Lead is created successfully
    And Convert the Lead to Contact

      Examples:
      |MHHE_Business_Administrator|
      |Jaime_Klar|