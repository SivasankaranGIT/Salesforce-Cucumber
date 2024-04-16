#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user can modify ship method, ship priority, and quantity when submitting a Sample request.

Background: 
	Given I am logged into salesforce for "ModifySampleQuantity" 
	
	
@Samples
@US_TC02_Sample_VerifyUserCanModifyQuantityWhenSubmittingSampleRequest	@GCRM-9288
Scenario Outline: VerifyUserCanModifyQuantityWhenSubmittingSampleRequest

	Given Runmode for "ModifySampleQuantity" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	Then click on sample contact button from opportunity
	Then verify products and contacts dispalyed
	Then edit Quantity to create sample
	Then navigate to samples section from opportunity
	And verify sample is created for quantity provided

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|