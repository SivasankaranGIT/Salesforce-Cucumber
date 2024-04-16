#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Case Priority To Be Set High For Platform/Functional OR Setup & Config update cases

Background: 
	Given I am logged into salesforce for "CreateCaseAndVerifyPriority" 
	
	
@Cases @CreateCaseAndVerifyPriority @GCRM-2334 @GCRM-2645 @GCRM-2929 @GCRM-2930
Scenario Outline: CreateCaseAndVerifyPriority

	Given Runmode for "CreateCaseAndVerifyPriority" is Y
#	Then I login as Sales Rep
	Then I do login as "<ALEKS_Administrator>"
	And  I change the app launcher to <app_Name>
	And I navigate to cases page
	And fill all mandatory details to create new ALEKS case
	Then I will edit the required fields to verify priority

	Examples:
		|app_Name|ALEKS_Administrator|
		|"ALEKS Lightning Console"|Isaac_Rubio|