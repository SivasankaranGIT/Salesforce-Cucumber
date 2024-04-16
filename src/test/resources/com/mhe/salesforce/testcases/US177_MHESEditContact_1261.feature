#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES User Edit a Contact

Background: 
	Given I am logged into salesforce for "MHESUserEditContact" 
	

@Contacts
@MHESUserEditContact	@GCRM-9293
Scenario Outline: MHE User Edit a Contact

	Given Runmode for "MHESUserEditContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	When Navigate to Contacts page
	And I edit MHE user contact details 
	And I click on "save" 
	Then verify error field message
	
	Examples: 
	|System_Administrator|
	|Sivasankaran_Periyasamy|