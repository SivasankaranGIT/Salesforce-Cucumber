#DEPENDENT SCRIPT - This script is dependent on CreateOppAndVerifyDaysToClose script for getting the Opportunity URL (selenium.NewOppURLForVerifyDaysToCloseTest). 
Feature: Verify the opportunity stage type gets calculated correctly

Background: 
	Given I am logged into salesforce for "VerifyOppStageTypes" 
	
@OpportunitiesDependent
@VerifyOppStageTypes
@GCRM-9145
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the opportunity stage type gets calculated correctly

	Given Runmode for "VerifyOppStageTypes" is Y
	Then I do login as "<SEG_Business_Admin>"
	And validate opportunity stage types

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|