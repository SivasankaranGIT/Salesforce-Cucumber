#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Marketing user can create a new contact

Background: 
	Given I am logged into salesforce for "MarkuserCreateNewContact" 
	
@Contacts
@MarkuserCreateNewContact @GCRM-9282
Scenario Outline: Verify that Marketing user can create a new contact

	Given Runmode for "MarkuserCreateNewContact" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When I navigate to contacts tab
	And create sales rep user contact by filling mandatory fields

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|

