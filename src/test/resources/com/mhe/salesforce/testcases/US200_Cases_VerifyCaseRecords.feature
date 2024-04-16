#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify when 5 line records are created, the values in the latest line record is populated in Line Header

Background: 
	Given I am logged into salesforce for "VerifyCaseRecord" 
	
	
@Cases @VerifyCaseRecord @GCRM-3399
Scenario Outline: VerifyCaseRecord

	Given Runmode for "VerifyCaseRecord" is Y
#  	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And  I change the app launcher to <app_Name>
	When Navigate to new record
	Then I search record by customer number
	And Check case records

	Examples:
		|app_Name|MHHE_Sales_Representative|
		|"MHHE"|Jackie_Alvarado|
