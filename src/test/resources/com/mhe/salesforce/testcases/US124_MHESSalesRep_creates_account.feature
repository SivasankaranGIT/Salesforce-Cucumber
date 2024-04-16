#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES Sales Rep User Creates New Account

Background: 
	Given I am logged into salesforce for "MHESSalesRepCreatesAccount" 
	
@Accounts
@SmokeTest	
@MHESSalesRepCreatesAccount	@GCRM-9026
Scenario Outline: MHES Sales Rep User Creates New Account

	Given Runmode for "MHESSalesRepCreatesAccount" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When Navigate to Accounts page
	And create new Account by filling mandatory fields
	Then Verify the Details of the account record created
	And Verify approver name
	Then I logout of any user
#	And Login as different US user
	Then I do login as "<SEG_Business_Admin>"
	Then I approve the account created
	Then Verify the details of the account record created
	Then I logout of any user
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then Verify the details of the account record created

	Examples:
	|SEG_Sales_Rep|SEG_Business_Admin|
	|Open_Baker|SEGBA_SEGAdmin|