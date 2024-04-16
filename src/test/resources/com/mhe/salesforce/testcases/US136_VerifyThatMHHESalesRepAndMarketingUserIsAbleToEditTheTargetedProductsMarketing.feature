#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditTheTargetedProductsMarketing

Background: 
	Given I am logged into salesforce for "EditTheTargetedProductsMarketing"	
	
@OpportunitiesNonDependent
@EditTheTargetedProductsMarketing @GCRM-9273
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToEditTheTargetedProductsMarketing

	Given Runmode for "EditTheTargetedProductsMarketing" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  	When I click sales Ref user details to navigate Sales
	And Marketing Use Edit Opportunity Account Trageted Product

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|