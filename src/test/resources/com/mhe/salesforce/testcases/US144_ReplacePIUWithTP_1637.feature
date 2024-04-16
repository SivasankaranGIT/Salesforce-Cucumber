#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the MHHE/Marketing User have an option to Replace PIU with TP

Background: 
Given I am logged into salesforce for "ReplacePIUWithTP"	
	
@OpportunitiesNonDependent @ReplacePIUWithTP	@GCRM-8987 @GCRM-25188
Scenario Outline: Verify that the MHHE/Marketing User have an option to Replace PIU with TP
	Given Runmode for "ReplacePIUWithTP" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	When I click on the "opportunitiesTab"
	And Note target products
	Then Replace PIU with TP button and verify products in use
	And delete the product
	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|