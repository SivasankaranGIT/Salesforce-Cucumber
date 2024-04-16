Feature:  Verify that MHHE Sales Rep can view the products of the package via  product catalog

Background: 
	Given I am logged into salesforce for "ViewPackagesProductCatalog" 
	
	
@ViewPackagesProductCatalog
Scenario Outline: Verify that MHHE Sales Rep can view the products of the package via  product catalog

	Given Runmode for "ViewPackagesProductCatalog" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	#When I click on the "productCatalogTab"
	When Navigate to Product Catalog page
	And Check package records
	#Then I logout of any user

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|
	
	