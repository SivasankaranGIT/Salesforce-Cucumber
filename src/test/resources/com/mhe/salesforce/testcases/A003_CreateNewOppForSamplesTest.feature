#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Create new opportunity to test Samples object related feature scenarios

Background: 
	Given I am logged into salesforce for "CreateNewOppForSamplesTest" 
	
	
@Samples
@CreateNewOppForSamplesTest @GCRM-8403 @GCRM-9191 @GCRM-15853 @GCRM-15856 @GCRM-15845 @GCRM-16026
Scenario Outline: Create new opportunity to test Samples object related feature scenarios

	Given Runmode for "CreateNewOppForSamplesTest" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	And add subtypes in opportunity
	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|