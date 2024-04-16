#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close CSOM case

Background: 
	Given I am logged into salesforce for "VerifycreateAndCloseCSOMCase" 
	
@Cases @SmokeTest @TC02_US_Cases_VerifycreateAndCloseCSOMCase @GCRM-9279 @GCRM-19122
Scenario Outline: VerifycreateAndCloseCSOMCase
	Given Runmode for "VerifycreateAndCloseCSOMCase" is Y
#	Then I login as Sales Rep
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
	Then click on New case by selecting one contact 
	Then select record type as CSOM Support
	And fill all mandatory details to create CSOM case
	Then click on close case button
	And fill mandatory fields to close CSOM Case
	Then verify the status of closed record
	Then I logout of any user
	Then I do login as "<CSOM_Business_Administrators>"
	And verify CMGAgentLocationofCaseOriginator Field Placement
	Examples:
		|app_Name|CSOM_Business_Administrators|CSOM_General_User|
		|"CSOM Lightning Console"|Jennifer_Ryan|Lisa_Phelps|