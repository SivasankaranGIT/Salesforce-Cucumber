#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHECreateOppFromContact

Background: 
	Given I am logged into salesforce for "MHHECreateOppFromContact" 	
	
@OpportunitiesNonDependent
@MHHECreateOppFromContact @GCRM-9242
Scenario Outline: MHHECreateOppFromContact

	Given Runmode for "MHHECreateOppFromContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And New opportunity from Contacts MHHE
	Then I logout of any user
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|