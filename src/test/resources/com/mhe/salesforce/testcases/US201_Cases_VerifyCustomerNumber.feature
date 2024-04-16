#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Customer Number Is Updated In Header Record As Per New Web Product Line

Background: 
	Given I am logged into salesforce for "VerifyCaseNumber" 
	
	
@Cases @VerifyCaseNumber @GCRM-3392
Scenario Outline: VerifyCaseNumber

	Given Runmode for "VerifyCaseNumber" is Y
#  Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And  I change the app launcher to <app_Name>
	When Navigate to new record
	Then I search record by customer number
	And verify case number records

	Examples:
		|app_Name|MHHE_Sales_Representative|
		|"MHHE"|Jackie_Alvarado|
  
	