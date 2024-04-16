#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that for MHES Business Unit the SEG Sales Rep user is able to rename the Name of the Opportunity

Background: 
	Given I am logged into salesforce for "SEGSalesRepUserRenameOpp"	
	
@OpportunitiesDependent
@SEGSalesRepUserRenameOpp
@GCRM-10148 @GCRM-24914 @GCRM-16024
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that for MHES Business Unit the SEG Sales Rep user is able to rename the Name of the Opportunity

	Given Runmode for "SEGSalesRepUserRenameOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then global search for opportunities
	And validate the SEG opportunity name
	And add subtypes in opportunity
	Then rename the SEG opportunity
	And validate the updated SEG opportunity name

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|