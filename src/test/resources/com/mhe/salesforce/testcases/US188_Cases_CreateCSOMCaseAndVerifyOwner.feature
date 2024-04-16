#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close CSOM case

Background: 
	Given I am logged into salesforce for "CreateCSOMCaseAndVerifyOwner" 
	
@Cases @GCRM-3236 @TC188_US_Cases_CreateCSOMCaseAndVerifyOwner
Scenario Outline: CreateCSOMCaseAndVerifyOwner

	Given Runmode for "CreateCSOMCaseAndVerifyOwner" is Y
#	Then I login as Sales Rep
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
#	Then I navigate to CSOM Lightning Console Home page
	Then click on New case by selecting one contact 
	Then select record type as CSOM Support
	And fill all mandatory details to create CSOM case
	Then click on close case button
	And fill mandatory fields to change the owner of CSOM Case
	Then verify the status of changed record

	Examples:
		|app_Name|CSOM_General_User|
		|"CSOM Lightning Console"|Lisa_Phelps|