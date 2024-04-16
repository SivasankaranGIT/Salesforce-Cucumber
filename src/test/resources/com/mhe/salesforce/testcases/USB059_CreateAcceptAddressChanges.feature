#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create new contact address and validate the street ondemand via USPS data after creating the address.

Background: 
	Given I am logged into salesforce for "CreateAcceptAddressChanges" 
	
	
@Contacts
@CreateAcceptAddressChanges @GCRM-9226
Scenario Outline: Create new contact address and validate the street ondemand via USPS data after creating the address.

	Given Runmode for "CreateAcceptAddressChanges" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	And I change the app launcher to MHHE
	When Navigate to Contacts page
	Then global search for contact
	And create new address for any contact and verify
	Then Accept changes and verify status
	And delete new address for the contact

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|