#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifythatMhheSalesRepIsAbleToCreateANewContactFromWithinAnAccount

Background: 
	Given I am logged into salesforce for "MHHERepCreateContact" 
	
	
@Contacts
@TS02_TC06_VerifythatMhheSalesRepIsAbleToCreateANewContactFromWithinAnAccount	@GCRM-9019
Scenario Outline: VerifythatMhheSalesRepIsAbleToCreateANewContactFromWithinAnAccount

	Given Runmode for "MHHERepCreateContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When Navigate to Contacts page
  And Creates Mendatory Fields Department

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|