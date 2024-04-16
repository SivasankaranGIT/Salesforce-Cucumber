#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user is able to check the Vitalsource availability and Verify that the user is able to see the error message if the Vitalsource product cannot be Sampled

Background:
Given I am logged into salesforce for "VerifyVitalSourceAvailability"	

@Samples
@VerifyVitalSourceAvailability
@GCRM-9501 @GCRM-9844
@RegressionTest @RegressionTestSamples
Scenario Outline: Verify that the user is able to check the Vitalsource availability and Verify that the user is able to see the error message if the Vitalsource product cannot be Sampled
	Given Runmode for "VerifyVitalSourceAvailability" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHE_Business_Operations>"
	Then I navigate to INTL Sample Check Home page
	And check product vital source availability
	And check Vitalsource product cannot be Sampled validation
	Examples:
	  |MHE_Business_Operations|
	  |Nisha_Bansal|