#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: OpportunityDiscountRequest

Background: 
	Given I am logged into salesforce for "OpportunityDiscountRequest" 	
	
@Opportunities_SKIP
@OpportunityDiscountRequest
@GCRM-8979
@RegressionTest @RegressionTestOpportunities
Scenario Outline: OpportunityDiscountRequest

	Given Runmode for "OpportunityDiscountRequest" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then I navigate to opportunity tab
	Then I create new opportunity
	And Navigate to products section
	Then Add product to opportunity
	Then request discount for opportunity product
	Then verify approval history

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|