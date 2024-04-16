#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Modifies Account Details

Background: 
	Given I am logged into salesforce for "MHESSalesRepModifiesAccountPhoneNumber" 
	
@Accounts
@SmokeTest	
@MHESSalesRepModifiesAccountPhoneNumber @GCRM-9095
Scenario Outline: MHES Sales Rep User Modifies Account Details

	Given Runmode for "MHESSalesRepModifiesAccountPhoneNumber" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then global search for accounts
	Then I edit the account phone number

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|