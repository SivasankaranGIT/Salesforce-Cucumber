#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Adding to Opportunity w/out Product Flags

  Background:
    Given I am logged into salesforce for "AddingOpportunityProductFlags"

	@OpportunitiesNonDependent
  @AddingOpportunityProductFlags @GCRM-9223
  Scenario Outline: Adding to Opportunity w/out Product Flags

    Given Runmode for "AddingOpportunityProductFlags" is Y
#    Then I login as Sales Rep
      Then I do login as "<SEG_Sales_Rep>"
    Then navigate to MHES Lightning Console
    Then global search for opportunities
    And I click modify product
    Then Add ISBN to the product
    And I Validate that isbn is added to the opportunity

    Examples:
    |SEG_Sales_Rep|
    |Open_Baker|