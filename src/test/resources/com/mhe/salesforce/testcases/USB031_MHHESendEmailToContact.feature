#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: SendEmailToContact

Background: 
	Given I am logged into salesforce for "SendEmailToContact" 
	
	
@Contacts
@SendEmailToContact @GCRM-8980
Scenario Outline: SendEmailToContact

	Given Runmode for "SendEmailToContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	And send Email to Contacts MHHE
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|