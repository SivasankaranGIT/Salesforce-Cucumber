#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHESalesSupport User Creates New Contact

Background: 
	Given I am logged into salesforce for "MHHESalesSupportUserCreatesNewContact" 

@Samples @MHHESalesSupportUserCreatesNewContact @GCRM-8403 @GCRM-9246
Scenario Outline: MHHESalesSupport User Creates New Contact

	Given Runmode for "MHHESalesSupportUserCreatesNewContact" is Y
	Then I do login as "<MHHE_Sales_Support>"
	When I click on the "contactsTab"
	And create sales support user contact by filling mandatory fields
Examples:
	|MHHE_Sales_Support|
	|Jennifer_Bahl|