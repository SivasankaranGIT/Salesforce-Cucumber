#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify SEG Sales Rep user is able to create a new opportunity or not

Background: 
	Given I am logged into salesforce for "SEGSalesRepUserCreateOpportunity"	
	
@OpportunitiesDependent
@SEGSalesRepUserCreateOpportunity
@GCRM-8404 @GCRM-9191 @GCRM-7494 @GCRM-16026
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify SEG Sales Rep user is able to create a new opportunity or not

	Given Runmode for "SEGSalesRepUserCreateOpportunity" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	And add subtypes in opportunity
	And verify the SDR section in opportunity
Examples:
	|SEG_Sales_Rep|
	|Open_Baker|