#DEPENDENT SCRIPT - This script is dependent on CreateOppAndVerifyDaysToClose script for getting the Opportunity URL (selenium.NewOppURLForVerifyDaysToCloseTest). 
#This same URL is getting used in VerifyOppStageTypes, VerifyOppProductQuantity scripts as well.
Feature: Verify primary funding field is required when opportunity is set to won or lost & verify revenue fields are correctly populated based on stage

  Background:
    Given I am logged into salesforce for "VerifyOppPrimaryFundingField"

	@OpportunitiesDependent
  @VerifyOppPrimaryFundingField
  @GCRM-9515 @GCRM-9144 @GCRM-15912 @GCRM-15914 @GCRM-16030
  @RegressionTest @RegressionTestOpportunities
  Scenario Outline: Verify primary funding field is required when opportunity is set to won or lost & verify revenue fields are correctly populated based on stage
    Given Runmode for "VerifyOppPrimaryFundingField" is Y
#    Then I login as Sales Rep
      Then I do login as "<SEG_Business_Admin>"
    And verify total amount and revenue fields
    And validate opp purchase and decision date for stage Pilot or Quote
    And verify primary funding field

      Examples:
      |SEG_Business_Admin|
      |Ivan_Gomez|