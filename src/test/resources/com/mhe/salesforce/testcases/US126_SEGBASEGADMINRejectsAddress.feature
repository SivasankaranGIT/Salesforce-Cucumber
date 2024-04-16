#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Creates New Account

Background: 
	Given I am logged into salesforce for "SEGBASEGADMINRejectsAddress" 
	
@Accounts
@SmokeTest	
@SEGBASEGADMINRejectsAddress	@GCRM-8996
Scenario Outline: MHES Sales Rep User Creates New Account

	Given Runmode for "SEGBASEGADMINRejectsAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then global search for accounts
	And create new address for the account
	When Navigate to addresses screen
	And capture the address url
	Then I logout of any user
#	And Login as different US user
	And I do login as "<SEG_Business_Admin>"
	When Navigate to addresses screen
	Then User rejects any address	
Examples:
  |SEG_Sales_Rep|SEG_Business_Admin|
  |Open_Baker|SEGBA_SEGAdmin|