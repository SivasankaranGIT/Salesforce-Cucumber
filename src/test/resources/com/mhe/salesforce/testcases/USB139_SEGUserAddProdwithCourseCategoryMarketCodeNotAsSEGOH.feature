#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify SEG users are able to add a product with course Category Market code as NOT 'SEGOH' to an opportunity successfully

Background: 
	Given I am logged into salesforce for "SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH" 

@OpportunitiesNonDependent
@SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH
@GCRM-12423
Scenario Outline: Verify SEG users are able to add a product with course Category Market code as NOT 'SEGOH' to an opportunity successfully

	Given Runmode for "SEGUserAddProdwithCourseCategoryMarketCodeNotAsSEGOH" is Y
#	Then I logout of any user
#	When Select any existing Course record with Category <MarketCode>
#	Then Open any record from Product course related list
#	Then Open the related product record and note the ISBN
#	Then I login as <SEGUser>
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to an exiting opportunity
	Then Go to Products related list and click on Modify Products button
	Then Provide the ISBN in the key ISBN text box and click on Add button
	And Verify the product is successfully added to the opportunity
	Examples:
	|MarketCode|SEG_Sales_Rep|
	|PBGBM|Open_Baker|