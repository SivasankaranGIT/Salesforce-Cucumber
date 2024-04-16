#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the given fields are available in Close Case Layout and the Case is Closed Only when the given field values are available

Background: 
	Given I am logged into salesforce for "VerifyCloseCase" 
	
	
@Cases @VerifyCloseCase @GCRM-4276 @GCRM-4275
Scenario Outline: VerifyCloseCase

	Given Runmode for "VerifyCloseCase" is Y
#  	Then I login as Sales Rep
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
#	Then I navigate to CSOM Lightning Console Home page
	Then click on New case by selecting available contact 
	Then select record type as CSOM Support
	And fill all mandatory details to create CSOM case
	Then click on close case button
	And fill mandatory fields to close CSOM Case
	Then verify the status of closed record

	Examples:
		|app_Name|CSOM_General_User|
		|"CSOM Lightning Console"|Lisa_Phelps|
  
	