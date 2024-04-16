#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep can view the products of the package

Background: 
	Given I am logged into salesforce for "MHHEUserViewProductsFromPackage" 
	
	
@Products
@MHHEUserViewProductsFromPackage @GCRM-8986
Scenario Outline: Verify that MHHE Sales Rep can view the products of the package

	Given Runmode for "MHHEUserViewProductsFromPackage" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to products screen
	Then Verify products under packages

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|