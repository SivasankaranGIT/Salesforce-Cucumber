#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: To verify that when the user wants to create New Sample from Opportunity, & if the product is having a Swap Product in place, the user gets an alert for the same.

Background:
Given I am logged into salesforce for "validateSwapProduct"	

@Samples
@VerifySwapProductsOnSampleCreationForOpp
@GCRM-481
Scenario Outline: Verify that the swap product alert popup while MHHE Sales Rep is creating a new sample through an opportunity.
	Given Runmode for "validateSwapProduct" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	Then global search for opportunities
	Then click on sample contact button from opportunity

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|