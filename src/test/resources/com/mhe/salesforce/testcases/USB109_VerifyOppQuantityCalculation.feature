#DEPENDENT SCRIPT - This script is dependent on CreateOppAndVerifyDaysToClose script for getting the Opportunity URL (selenium.NewOppURLForVerifyDaysToCloseTest). 
#This same URL is getting used in VerifyOppStageTypes script as well.
Feature: Verify opp qty fields are calculated correctly

Background: 
	Given I am logged into salesforce for "VerifyOppProductQuantity" 
	
@OpportunitiesDependent
@VerifyOppProductQuantity
@GCRM-9463
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify opp qty fields are calculated correctly

	Given Runmode for "VerifyOppProductQuantity" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then navigate to opp and add product
	And validate opportunity product quantity

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|