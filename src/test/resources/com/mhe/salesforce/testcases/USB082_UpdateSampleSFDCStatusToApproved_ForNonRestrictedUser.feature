#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the logged in User is NOT restricted from changing the SFDC Status to "Approved" on the Sample

Background:
Given I am logged into salesforce for "validateSampleStatusForAllowedUser"	

@Samples @VerifySampleStatusUpdateForNonRestrictedUser @GCRM-4359
Scenario Outline: Verify that the logged in User is NOT restricted from changing the SFDC Status to "Approved" on the Sample
	Given Runmode for "validateSampleStatusForAllowedUser" is Y
	Then I do login as "<Sales_Rep_Lightning>"
	Then global search for accounts
	Then navigate to the desired contact
	Then create INTL sample for the contact
	And validate the contact status

Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|