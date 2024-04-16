#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Sampling a Product A that has Swap Product B

Background: 
Given I am logged into salesforce for "SamplingProdHasSwapProd" 

@Samples @SmokeTest @TC25_US_Sample_VerifySamplingProductThatHasSwapProduct	@GCRM-9080
Scenario Outline: VerifySamplingProductThatHasSwapProduct

	Given Runmode for "SamplingProdHasSwapProd" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	And I change the app launcher to MHHE
	Then global search for products
	And Verify swap product field
	Then click on sample contact button from menu
	Then search for product
	And verify swap products message
	Then click on create sample order
	Then verify swap product on new sample

Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|