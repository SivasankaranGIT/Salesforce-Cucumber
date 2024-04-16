#DEPENDENT_SCRIPT - This script is dependent on MHESRepCreateContacts script for getting contact url.
Feature: Verify MHHE profile user is able to create a Contact address

Background: 
	Given I am logged into salesforce for "CreateAndVerifyAddress" 
	
	
@Accounts
@CreateAndVerifyAddress	@GCRM-8997
Scenario Outline: Verify MHHE profile user is able to create a Contact address

	Given Runmode for "CreateAndVerifyAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
#	Then global search for accounts
	And create new address for the account to accept changes
	When Navigate to addresses screen
	And copy the address url
	Then I logout of any user
#	And Login as different US user
	And I do login as "<SEG_Business_Admin>"
	Then Verify and accept changes
	Then I logout of any user
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And Open and verify the same address
	Examples:
	|SEG_Sales_Rep|SEG_Business_Admin|
	|Open_Baker|SEGBA_SEGAdmin|