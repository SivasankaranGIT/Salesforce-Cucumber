#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHESalesRep User Creates New Contact

Background: 
	Given I am logged into salesforce for "MHHESalesRepUserCreatesNewContact" 

@Contacts	
@SmokeTest
@MHHESalesRepUserCreatesNewContact	@GCRM-9258
Scenario Outline: MHHESalesRep User Creates New Contact

	Given Runmode for "MHHESalesRepUserCreatesNewContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click on the "contactsTab"
	And create sales rep user contact by filling mandatory fields

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|
