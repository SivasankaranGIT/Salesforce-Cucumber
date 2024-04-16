#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE user can view package and BOMs from the Product record, as well as in the Product Catalog.

Background: 
	Given I am logged into salesforce for "MHHEProductAndCatalog" 
	
@Products
@MHHEProductAndCatalog @GCRM-9221
Scenario Outline: MHHEProductAndCatalog

	Given Runmode for "MHHEProductAndCatalog" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I navigate to products tab
	Then Verify packages section
	Then global search for products
	And View package definitions BOMs
	When I navigate to product catalog tab
	And verify package records

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|