#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the MHHE/Marketing User can link one or more Products In Use to an opportunity

Background: 
	Given I am logged into salesforce for "LinkProductInUse" 
	
@OpportunitiesNonDependent
@LinkProductInUse
@GCRM-8988
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that the MHHE/Marketing User can link one or more Products In Use to an opportunity 

	Given Runmode for "LinkProductInUse" is Y
	Then I do login as "<MHHE_Sales_Representative>"
#	Then I login as Sales Rep
	And I change the app launcher to MHHE
	When I click sales Ref user details to navigate Marketing
	When I navigate to product in use screen and add product 
	And Verify product in use list within the opportunity

	Examples:
    |MHHE_Sales_Representative|
    |Danielle_Snyder|