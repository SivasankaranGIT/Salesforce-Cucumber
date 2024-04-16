#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: SearchAndLinkTargetedProductsMHHE

Background: 
	Given I am logged into salesforce for "SearchAndLinkTargetedProductsMHHE" 	
	
@OpportunitiesNonDependent
@SearchAndLinkTargetedProductsMHHE
@GCRM-8970 @GCRM-16017 @GCRM-16011
@RegressionTest @RegressionTestOpportunities
Scenario Outline: SearchAndLinkTargetedProducts

	Given Runmode for "SearchAndLinkTargetedProductsMHHE" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user details to navigate Sales
	When I navigate to the first opp in the page
	And MHHE Search and Link Targeted Productswith ISBN
	Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|