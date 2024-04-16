#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate Job function field on the Contact record created through Campaign.
Background:
Given I am logged into salesforce for "validateJobFunctionFieldinContact"
@Samples
@VerifyJobFunctionFieldinContact
@GCRM-2421
Scenario Outline: Validate Job function field on the Contact record created through Campaign.
	Given Runmode for "validateJobFunctionFieldinContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then global search for campaign
	Then click on SEG Site URL 
	Then I enter the details 
	And I close the SEG site
	Then verify contact record on campaign members section for existing user
	And verify navigation on clicking first name and contact
	And verify the job function field value

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|