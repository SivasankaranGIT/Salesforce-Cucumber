#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: edit Contact
  
  Background:
  Given I am logged into salesforce for "EditContact"

	@Contacts
  @editContact @GCRM-9097
  Scenario Outline: User Contact Edit
 	Given Runmode for "EditContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	Then global search for contact
	And I edit details 
	And I click on "save"
  	Then Verify error message

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|