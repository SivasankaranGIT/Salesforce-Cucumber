#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user is able to check the Print availability.

Background:
Given I am logged into salesforce for "VerifyPrintAvailability"	

@Samples
@VerifyPrintAvailability
@GCRM-9561
@RegressionTest @RegressionTestSamples
Scenario Outline: Verify that the user is able to check the Print availability.
	Given Runmode for "VerifyPrintAvailability" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHE_Business_Operations>"
	Then I navigate to INTL Sample Check Home page
	And check product print availability
	
	Examples:
  |MHE_Business_Operations|
  |Nisha_Bansal|