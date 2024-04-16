#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the opportunity close and purchase date validations. i.e. Close Date should be prioir to Purchase Date & Purchase Date should be inside the opportunity financial year.

Background: 
	Given I am logged into salesforce for "CreateOppAndVerifyCloseAndPurchaseDate" 
	
@OpportunitiesDependent
@CreateOppAndVerifyCloseAndPurchaseDate
@GCRM-9542 @GCRM-9539
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the opportunity close and purchase date validations. i.e. Close Date should be prioir to Purchase Date & Purchase Date should be inside the opportunity financial year.

	Given Runmode for "CreateOppAndVerifyCloseAndPurchaseDate" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	And add subtypes in opportunity
	And validate close and purchase dates

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|