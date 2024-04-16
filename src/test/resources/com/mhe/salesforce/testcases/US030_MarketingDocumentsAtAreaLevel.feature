#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View the Marketing documents at an area level and drill down to find products

Background: 
	Given I am logged into salesforce for "MarketingDocumentsAtAreaLevel" 
	
@ProductCatalog
@SmokeTest
@MarketingDocumentsAtAreaLevel @GCRM-9087
Scenario Outline:  View the Marketing documents at an area level and drill down to find products

	Given Runmode for "MarketingDocumentsAtAreaLevel" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Product Catalog page 
	When I search product via Area
	Then Verify Product course related list is dispalyed
	Then Verify tabs are present under Documents section
	Then Check categories under Product Summary

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|