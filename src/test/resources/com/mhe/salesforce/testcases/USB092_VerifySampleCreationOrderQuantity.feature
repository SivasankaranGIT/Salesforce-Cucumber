#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the INTL user can only create sample with Order Quantity between 1 & 99. Also, Verify that the user cannot see any Trial values in the field "SFDC Status" while creating a New Sample using the INTL Add Sample button on Contact and while re-sampling as well.

Background:
Given I am logged into salesforce for "Sample_OrderQuantityValidation"	

@Samples
@VerifySampleCreationOrderQuantity
@GCRM-9162 @GCRM-9482 @GCRM-9484
@RegressionTest @RegressionTestSamples
Scenario Outline: Verify that the INTL user can only create sample with Order Quantity between 1 & 99. Also, Verify that the user cannot see any Trial values in the field "SFDC Status" while creating a New Sample using the INTL Add Sample button on Contact and while re-sampling as well.
	Given Runmode for "Sample_OrderQuantityValidation" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then global search for accounts
	Then navigate to the desired contact
	Then create INTL sample for contact
	And verify the SFDC Status list for trial values
	And verify the order quantity validation
	And verify the SFDC Status list for trial values while resampling

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|