#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:  View supplement products linked to an individual product from the Product Detail page

Background: 
	Given I am logged into salesforce for "ViewSupplementProducts" 
	
	
@Products
@ViewSupplementProducts @GCRM-9271
Scenario Outline: View supplement products linked to an individual product from the Product Detail page

	Given Runmode for "ViewSupplementProducts" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click on the "products_Tab"
	Then global search for product
	Then Verify supplement page have read only access

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|