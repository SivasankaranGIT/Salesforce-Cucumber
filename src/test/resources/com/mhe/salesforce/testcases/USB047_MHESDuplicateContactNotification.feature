#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHES Sales Rep get notified while creating a duplicate contact

Background: 
	Given I am logged into salesforce for "MHESDuplicateContact" 
	
	
@Contacts
@MHESDuplicateContact	@GCRM-9217
Scenario Outline: MHESDuplicateContact

	Given Runmode for "MHESDuplicateContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When I navigate to contacts tab
	And create duplicate contact
	Then verify duplicate notification

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|