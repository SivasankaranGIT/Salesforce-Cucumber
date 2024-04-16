#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHESSalesRepIAableToCreateContactsFromWithinAnAccount

Background: 
	Given I am logged into salesforce for "MHESRepCreateContacts" 
	
	
@Accounts
@TS01_TC07_VerifyThatMHESSalesRepIAableToCreateContactsFromWithinAnAccount @GCRM-9024
Scenario Outline: VerifyThatMHESSalesRepIAableToCreateContactsFromWithinAnAccount

	Given Runmode for "MHESRepCreateContacts" is Y
	Then I do login as "<SEG_Sales_Rep>"
#	Then I login as Sales Rep
	When I click Contacts to create new contact
	And I enter and save all the Contact details Validation

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|