#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify Days to close field is calculated correctly

Background: 
	Given I am logged into salesforce for "CreateOppAndVerifyDaysToClose" 
	
@OpportunitiesDependent
@CreateOppAndVerifyDaysToClose
@GCRM-9462
@RegressionTest @RegressionTestOpportunities
Scenario Outline: verify Days to close field is calculated correctly

	Given Runmode for "CreateOppAndVerifyDaysToClose" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	And add subtypes in opportunity
	And validate days to close

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|