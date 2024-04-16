#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Sales Rep User Edit a Contact

Background: 
	Given I am logged into salesforce for "MHHESalesRepUserEditContact" 
	
@Contacts
@SmokeTest	
@MHHESalesRepUserEditContact	@GCRM-9258
Scenario Outline: MHHE Sales Rep User Edit a Contact

	Given Runmode for "MHHESalesRepUserEditContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	And I edit sales rep user department details 
	And I click on "save" 
	Then Validate error message for sales rep department field edit
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|