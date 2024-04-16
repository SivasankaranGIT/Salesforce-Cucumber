#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close ALEKS case

Background: 
	Given I am logged into salesforce for "CreateAndCloseALEKSCase" 
	
	
@Cases
@CreateAndCloseALEKSCase @GCRM-8946 @GCRM-19799 @GCRM-20063
Scenario Outline: CreateAndCloseALEKSCase

	Given Runmode for "CreateAndCloseALEKSCase" is Y
#	Then I login as Sales Rep
	Then I do login as "<ALEKS Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to contacts tab
	And create new ALEKS contact
	Then click on New Case for ALEKS
	And fill all mandatory details to create ALEKS case
	And verify CXGUpdates and FindINTLContacts button
	And edit the case origin
	Then click on close case button for ALEKS
	And fill mandatory fields to close ALEKS Case
	Then verify the status of closed ALEKS record
	Then delete record
	Examples:
		|app_Name|ALEKS Administrator|
		|"ALEKS Lightning Console"|Isaac_Rubio|


