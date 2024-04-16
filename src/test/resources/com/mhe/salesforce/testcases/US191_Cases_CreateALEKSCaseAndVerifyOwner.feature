#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create ALEKS case and Owner

Background: 
	Given I am logged into salesforce for "CreateALEKSCaseAndVerifyOwner"	
	
@Cases @CreateALEKSCaseAndVerifyOwner	@GCRM-3231
Scenario Outline: CreateALEKSCaseAndVerifyOwner

	Given Runmode for "CreateALEKSCaseAndVerifyOwner" is Y
	Then I do login as "<ALEKS_Administrator>"
	And  I change the app launcher to <app_Name>
	And I switch to ALEKS home page
	When I navigate to contacts tab
	And create new ALEKS contact
	Then click on New Case for ALEKS
	And fill all mandatory details to create ALEKS case
	Then click on edit case button for ALEKS
	And fill mandatory fields to edit ALEKS Case
	Then verify the status of edited ALEKS record

Examples:
	|app_Name|ALEKS_Administrator|
	|"ALEKS Lightning Console"|Isaac_Rubio|