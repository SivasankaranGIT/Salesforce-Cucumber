#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the INTL user is able to send an email to the Product team if they try adding Digital Product or ineligible VitalSource Product & receive errors

Background:
Given I am logged into salesforce for "CreateSampleAndVerifyIneligibleVitalSourceAndDigitalProduct"	

@Samples @CreateSampleAndVerifyIneligibleVitalSourceAndDigitalProduct @GCRM-10345 @GCRM-10268 @GCRM-10798 @RegressionTest @RegressionTestSamples
Scenario Outline: Verify that the INTL user is able to send an email to the Product team if they try adding Digital Product or ineligible VitalSource Product & receive errors
	Given Runmode for "CreateSampleAndVerifyIneligibleVitalSourceAndDigitalProduct" is Y
	Then I do login as "<Sales_Rep_Lightning>"
	Then global search for accounts
	Then navigate to the desired contact
	Then create INTL sample and verify virtalsource product validation
#	And send email to product team
	Then create INTL sample and verify digital product validation
#	And send email to product team

Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|