#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL)
Feature: Verify that SEG Sales Rep Lightning user is able to edit an opportunity

Background: 
	Given I am logged into salesforce for "SEGSalesRepUserEditOpp"	
	
@OpportunitiesDependent
@SEGSalesRepUserEditOpp
@GCRM-10192 @GCRM-10237 @GCRM-16485 @GCRM-16445
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that SEG Sales Rep Lightning user is able to edit an opportunity

	Given Runmode for "SEGSalesRepUserEditOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to an exiting opportunity
	And SEGSalesRep user edit opportunity
	And verify Winning Publisher picklist

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|