#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Sampling a Product A that does not have Swap Product

Background: 
Given I am logged into salesforce for "SamplingProdDoesNotHaveSwap"	
	
@Samples @US_TC24_Sample_VerifySamplingProductThatDoesNotHaveSwapProduct	@GCRM-9079
Scenario Outline: VerifySamplingProductThatDoesNotHaveSwapProduct

	Given Runmode for "SamplingProdDoesNotHaveSwap" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	Then global search for products
	And Verify swap product field not present
	Then click on sample contact button from menu
	Then search for product click on next
	Then click on create sample order for product
	Then verify new sample record

Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|