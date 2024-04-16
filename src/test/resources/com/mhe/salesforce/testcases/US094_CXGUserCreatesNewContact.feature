#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: CXG User Creates New Contact

Background: 
	Given I am logged into salesforce for "CXGUserCreatesNewContact"	
	
@Contacts @CXGUserCreatesNewContact	@GCRM-9258
Scenario Outline: CXG User Creates New Contact
	Given Runmode for "CXGUserCreatesNewContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<CXG_Administrator>"
	When Navigate to CXG Contacts page
	And create new CXG contact by filling mandatory fields

	Examples:
	|CXG_Administrator|
	|Eric_Nelson|