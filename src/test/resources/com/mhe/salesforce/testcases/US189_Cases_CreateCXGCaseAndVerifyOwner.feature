#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close CXG case

Background: 
	Given I am logged into salesforce for "CreateCXGCaseAndVerifyOwner" 
	
@Cases
@GCRM-3231 @GCRM-19799 @GCRM-20063
@TC189_US_Cases_CreateCXGCaseAndVerifyOwner
Scenario Outline: VerifycreateAndCloseCXGCase

	Given Runmode for "CreateCXGCaseAndVerifyOwner" is Y
#	Then I login as CXG User
	Then I do login as "<CXG_Administrator>"
	And  I change the app launcher to <app_Name>
	When I search for CXG User contacts
	Then global search for contact
	Then click on New case by selecting one contact 
	And fill all mandatory details to create CXG case
	And verify CXGUpdates and FindINTLContacts button
	And edit the case origin
	Then click on close case button for CXG
	And fill mandatory fields to change owner of CXG Case
	Then verify the status of changed CXG record
	Examples:
		|app_Name|CXG_Administrator|
		|"CXG Lightning Console"|Eric_Nelson|