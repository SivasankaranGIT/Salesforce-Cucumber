#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Evergreen and Release Date columns are available in Product and PIU related list of Opportunity record for National Sales Rep

  Background:
    Given I am logged into salesforce for "VerifyOppProductFieldsClassic"

	@OpportunitiesNonDependent
  @VerifyOppProductFieldsClassic
  @GCRM-12844
  Scenario Outline: Verify the Evergreen and Release Date columns are available in Product and PIU related list of Opportunity record for National Sales Rep
    Given Runmode for "VerifyOppProductFieldsClassic" is Y
#    Then I login as Sales Rep in classic <National_Sales_Rep>
      Then I do login as classic "<MHHE_National_Sales_Representative>"
    When I navigate to opportunity tab in classic
    And verify the fields Evergreen and Release Date in Product and ProductInUse page in SF classic mode
    Then I logout of any classic user
    Examples:
    |MHHE_National_Sales_Representative|
    |open_Albertsen|