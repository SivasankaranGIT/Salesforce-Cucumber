#DEPENDENT SCRIPT - This script is dependent on multiple test scripts to get the URLs of the records (which has been created at run time) which needs to be deleted
Feature: Delete the opp record which was created during run time for Quote object related testing

Background: 
	Given I am logged into salesforce for "DeleteOpportunity_Quote" 

@Quote
@DeleteOpportunity_Quote @GCRM-2736
Scenario Outline: Delete the opp record which was created during run time for Quote object related testing

	Given Runmode for "DeleteOpportunity_Quote" is Y
#  Then I login as Sales Rep
  Then I do login as "<System_Administrator>"
  Then I navigate to Sales Home page
  And delete opportunity

  Examples:
  |System_Administrator|
  |Sivasankaran_Periyasamy|