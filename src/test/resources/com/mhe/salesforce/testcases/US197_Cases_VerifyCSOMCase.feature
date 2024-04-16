#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: CSOM International Order Mgmt queue: manually assigned cases should have a Status = New

Background: 
	Given I am logged into salesforce for "VerifyCSOMCase" 
	
	
@Cases @VerifyCSOMCase @GCRM-3279
Scenario Outline: VerifyCSOMCase

	Given Runmode for "VerifyCSOMCase" is Y
#  	Then I login as Sales Rep
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
#	Then I navigate to CSOM Lightning Console Home page
	Then click on New case by selecting available contact 
	Then select record type as CSOM Support
	And fill all mandatory details to create CSOM case
	Then click on close case button
	And fill mandatory fields to change the owner of CSOM Case

	Examples:
		|app_Name|CSOM_General_User|
		|"CSOM Lightning Console"|Lisa_Phelps|
  
	