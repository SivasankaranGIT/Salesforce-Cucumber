#DEPENDENT SCRIPT - This script is dependent on SEGSalesRepUserCreateOpportunity script for getting the Opportunity URL (selenium.SEGSalesRepUserNewOppURL). 
#This same URL is getting used in SEGSalesRepUserEditOpp script as well.
Feature: VerifyThatMHESUserIsAbleToSplitTheProducts

Background: 
	Given I am logged into salesforce for "MHESUserSplitProducts" 
	
@OpportunitiesDependent
@SmokeTest
@US_TS01_TC28_VerifyThatMHESUserIsAbleToSplitTheProducts @GCRM-8965 @GCRM-9516 @GCRM-15916 @GCRM-15918 @GCRM-15941 @GCRM-15940 @GCRM-16026
@RegressionTest @RegressionTestOpportunities
Scenario Outline: VerifyThatMHESUserIsAbleToSplitTheProducts

	Given Runmode for "MHESUserSplitProducts" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then Add product using ISBN for split
	And Opportunities Split Lines Validation for Lost Stage
	And Opportunities Split Lines Validation for Cancelled Stage
Examples:
	|SEG_Sales_Rep|SEG_Business_Admin|MHES_Lightning_Console|
	|Open_Baker|Ivan_Gomez|MHES Lightning Console|