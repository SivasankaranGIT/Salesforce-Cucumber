#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Product Name field of Opportunity order object accepts up to 255 characters

Background: 
	Given I am logged into salesforce for "VerifyProductNameLimitInOrderline" 

@OpportunitiesNonDependent
@VerifyProductNameLimitInOrderline
@GCRM-11844
@RegressionTest @RegressionTestOpportunities
Scenario: Verify the Product Name field of Opportunity order object accepts up to 255 characters

	Given Runmode for "VerifyProductNameLimitInOrderline" is Y
	Then I logout of any user
	Then create order line with ordered item
	And verify product name limit in order line
	Then create opportunity orders
	And verify product name limit in opp order line
