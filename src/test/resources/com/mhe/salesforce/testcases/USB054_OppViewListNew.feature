#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: OppViewListNew

Background: 
	Given I am logged into salesforce for "OppViewListNew" 	
	
@OpportunitiesNonDependent
@OppViewListNew @GCRM-9224
Scenario Outline: OppViewListNew

	Given Runmode for "OppViewListNew" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And List View Create Opp	
	And List View Opp Delete
	Then I logout of any user

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|