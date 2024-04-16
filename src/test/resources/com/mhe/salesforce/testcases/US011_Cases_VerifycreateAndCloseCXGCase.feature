#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close CXG case

Background: 
	Given I am logged into salesforce for "VerifycreateAndCloseCXGCase" 
	
@Cases
@SmokeTest
@TC03_US_Cases_VerifycreateAndCloseCXGCase @GCRM-9280 @GCRM-19981 @GCRM-19122 @GCRM-17742 @GCRM-17026
Scenario Outline: VerifycreateAndCloseCXGCase

	Given Runmode for "VerifycreateAndCloseCXGCase" is Y
#	Then I login as CXG User
	Then I do login as "<CXG_Administrator>"
	And  I change the app launcher to <app_Name>
	When I search for CXG User contacts
	Then global search for contact
	Then click on New case by selecting one contact
	And fill all mandatory details to create CXG case
	Then click on close case button for CXG
	And fill mandatory fields to close CXG Case
	Then verify the status of closed CXG record
	And verify CMGAgentLocationofCaseOriginator Field Placement
	Examples:
	|app_Name|CXG_Administrator|
	|"CXG Lightning Console"|Eric_Nelson|