#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create an LMS Integration record for an account

Background: 
	Given I am logged into salesforce for "createLMSIntegration" 
	
@Accounts
@createLMSIntegration @GCRM-9018
Scenario Outline: Create an LMS Integration record for an account
	Given Runmode for "createLMSIntegration" is Y 
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	Then global search for accounts
	And I fill mandatory LMS Integration details
	Then I validate LMS created under account

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|