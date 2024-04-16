#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that user should be able to recreate the sample using resample button

Background:
Given I am logged into salesforce for "validateSampleRecreate"

@Samples
@validateSampleRecreate
@GCRM-7180
Scenario Outline: Validate that user should be able to recreate the sample using resample button
	Given Runmode for "validateSampleRecreate" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	And verify recreate sample functionality

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|
