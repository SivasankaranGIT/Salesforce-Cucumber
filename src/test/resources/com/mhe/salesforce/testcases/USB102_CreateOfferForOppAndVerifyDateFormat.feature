#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user receives the validation error on the date fields whenever the fields are populated in an undesired format

  Background:
    Given I am logged into salesforce for "CreateOfferForOppAndVerifyDateFormat"

	@OpportunitiesNonDependent
  @CreateOfferForOppAndVerifyDateFormat
  @GCRM-9119 @GCRM-9397 @GCRM-25435
  Scenario Outline: Verify that the user receives the validation error on the date fields whenever the fields are populated in an undesired format

    Given Runmode for "CreateOfferForOppAndVerifyDateFormat" is Y
#   Then I login as Sales Rep
    Then I do login as "<MHHE_Business_Administrator>"
    And I change the app launcher to MHHE
    Then global search for opportunities
    And check new quote option is removed or not
    And delete existing MHHE digital offer
    And create new offer and validate date field
    And delete the newly created MHHE digital offer

    Examples:
    |MHHE_Business_Administrator|
    |Jaime_Klar|