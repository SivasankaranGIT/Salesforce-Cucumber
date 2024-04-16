#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHES Sales Rep user is able to Create a consultant request from within an account

Background: 
	Given I am logged into salesforce for "MHESCreatesConsultantRequest" 
	
	
@AccountsNA @MHESCreatesConsultantRequest @GCRM-9022
Scenario Outline: Verify that MHES Sales Rep user is able to Create a consultant request from within an account

	Given Runmode for "MHESCreatesConsultantRequest" is Y
#	Then I login as Sales Rep
  Then I do login as "<SEG_Sales_Rep>"
  When I click on the "accountsTab"
  And create Consultant Request Form for account
  Then check status of CRF
  
  Examples: 
  |SEG_Sales_Rep|
  |Open_Baker|