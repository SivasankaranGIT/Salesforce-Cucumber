#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Views Contact from within an Account 

Background: 
	Given I am logged into salesforce for "ViewContactFromAccounts"
	
	
@Accounts
@ViewContactFromAccounts @GCRM-9025
Scenario Outline: MHES Sales Rep User Views Contact from within an Account

	Given Runmode for "ViewContactFromAccounts" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When Navigate to Accounts page
	Then I navigate to contacts from account
	And verify contact list within the account

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|