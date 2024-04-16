#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMhheSalesRepIsAbleToViewTheTerritorieslinkedToAnAccount

Background: 
	Given I am logged into salesforce for "ViewTheTerritoriesUS" 
	
	
@Accounts
@TS02_TC03_VerifyThatMhheSalesRepIsAbleToViewTheTerritorieslinkedToAnAccount @GCRM-9296
Scenario Outline: VerifyThatMhheSalesRepIsAbleToViewTheTerritorieslinkedToAnAccount

	Given Runmode for "ViewTheTerritoriesUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	Then global search for accounts
	And Account Name click proceed view Territories
	
	Examples: 
	|System_Administrator|
	|Sivasankaran_Periyasamy|