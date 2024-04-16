#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Edit permanent Shipping Address

Background: 
	Given I am logged into salesforce for "EditPermanentShipingAddress" 
	
@Accounts
@editShippingaddress	@GCRM-9015
Scenario Outline: Editing country field in the contact address

	Given Runmode for "EditPermanentShipingAddress" is Y 
#	Then I login as Admin User
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for accounts
	And I edit the existing contact
  Then Verify the changes
	
	Examples: 
	|MHHE_Sales_Representative|
	|Haley_Loebig|