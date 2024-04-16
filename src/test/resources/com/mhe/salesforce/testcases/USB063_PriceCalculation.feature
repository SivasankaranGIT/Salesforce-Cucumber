#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: PriceCalculation

Background: 
	Given I am logged into salesforce for "PriceCalculation" 	
	
@OpportunitiesNonDependent
@PriceCalculation @GCRM-9227
Scenario Outline: PriceCalculation

	Given Runmode for "PriceCalculation" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And Price Calculation	
	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|