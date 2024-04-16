#DEPENDANT_SCRIPT - This script is dependent on 'CXGUserCreatesNewContact' script for getting 'selenium.contacts'
Feature: CXG User Edit a Contact

Background: 
	Given I am logged into salesforce for "CXGUserEditContact" 
	
	
@Contacts
@CXGUserEditContact	@GCRM-9258
Scenario Outline: CXG User Edit a Contact

	Given Runmode for "CXGUserEditContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<CXG_Administrator>"
	And I edit department details 
	
	Examples: 
	|CXG_Administrator|
	|Eric_Nelson|