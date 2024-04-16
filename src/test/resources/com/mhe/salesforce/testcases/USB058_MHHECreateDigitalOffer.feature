#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As an MHHE Sales Rep, create a digital offer request.

  Background:
    Given I am logged into salesforce for "MHHEDigitalOffer"

	@OpportunitiesNonDependent
  @MHHEDigitalOffer @GCRM-9225
  Scenario Outline: As an MHHE Sales Rep, create a digital offer request.

    Given Runmode for "MHHEDigitalOffer" is Y
#   Then I login as Sales Rep
    Then I do login as "<MHHE_Business_Administrator>"
    And I change the app launcher to MHHE
    When I navigate to opportunity tab
    Then global search for opportunities
    And click MHHE Digital Offers
    Then create new digital offer
    And delete offer

      Examples:
      |MHHE_Business_Administrator|
      |Jaime_Klar|