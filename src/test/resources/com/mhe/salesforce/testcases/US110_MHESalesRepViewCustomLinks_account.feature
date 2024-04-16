#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify MHES Sales Rep is able to view custom links

Background: 
	Given I am logged into salesforce for "MHESSalesRepViewCustomLinks" 
	
	
@Accounts
@MHESSalesRepViewCustomLinks @GCRM-8947
Scenario Outline: Verify MHES Sales Rep is able to view custom links

	Given Runmode for "MHESSalesRepViewCustomLinks" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When Navigate to Accounts page
	Then Verify Custom Links for MHES Sales Rep

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|