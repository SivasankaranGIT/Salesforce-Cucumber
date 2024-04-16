#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:  Verify SFDC User can view supplement products linked to a product within Product Catalogs

Background: 
	Given I am logged into salesforce for "ViewSupplementProductCatalog" 
	
@Products @SmokeTest @ViewSupplementProductCatalog @GCRM-9279
Scenario Outline: Verify SFDC User can view supplement products linked to a product within Product Catalogs

	Given Runmode for "ViewSupplementProductCatalog" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Product Catalog page
	Then I search product by expanding business unit
	And Check supplement records	
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|