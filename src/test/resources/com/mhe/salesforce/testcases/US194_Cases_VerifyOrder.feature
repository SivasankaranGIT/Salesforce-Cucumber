#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Order Mail Is Updated In Header Record As Per New Web Product Line

Background: 
	Given I am logged into salesforce for "VerifyOrder"
	
@Cases @VerifyOrder @GCRM-3396
Scenario Outline: VerifyOrder

	Given Runmode for "VerifyOrder" is Y
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to cases tab
	And open the case
	Then change the order of case

Examples:
	|app_Name|System_Administrator|
	|"ALEKS Lightning Console"|Sivasankaran_Periyasamy|