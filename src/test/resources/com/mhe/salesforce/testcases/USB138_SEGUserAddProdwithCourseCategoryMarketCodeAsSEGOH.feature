#STAND_ALONE_SCRIPT - This script can be executed separately.
#select id from MHE_Course__c where Category_Market_Code__c = 'SEGOH' 
Feature: Verify SEG users are able to add a product with course Category Market code as 'SEGOH' to an opportunity successfully

Background: 
	Given I am logged into salesforce for "SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH" 

@OpportunitiesNonDependent
@SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH
@GCRM-12422
Scenario Outline: Verify SEG users are able to add a product with course Category Market code as 'SEGOH' to an opportunity successfully

	Given Runmode for "SEGUserAddProdwithCourseCategoryMarketCodeAsSEGOH" is Y
	Then I logout of any user
	When Select any existing Course record with Category <MarketCode>
	Then Open any record from Product course related list
	Then Open the related product record and note the ISBN
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to an exiting opportunity
	Then Go to Products related list and click on Modify Products button
	Then Provide the ISBN in the key ISBN text box and click on Add button
	And Verify the product is successfully added to the opportunity
	Examples:
	|MarketCode|SEG_Sales_Rep|
	|SEGOH|Open_Baker|