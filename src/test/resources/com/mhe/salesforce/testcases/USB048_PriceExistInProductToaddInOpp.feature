#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts (VerifyOppProductFields).
Feature: PriceExistInProductToaddInOpp

Background: 
	Given I am logged into salesforce for "PriceExistInProductToaddInOpp" 	
	
@OpportunitiesDependent
@PriceExistInProductToaddInOpp @GCRM-9218
Scenario Outline: PriceExistInProductToaddInOpp

	Given Runmode for "PriceExistInProductToaddInOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	When I click sales Ref user details to navigate Sales
	Then Create new MHHE type opportunity
	Then add product to MHHE opportunity
	And Removal of Opp Account
	And Opp AccountProduct Add after removal with Price
	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|