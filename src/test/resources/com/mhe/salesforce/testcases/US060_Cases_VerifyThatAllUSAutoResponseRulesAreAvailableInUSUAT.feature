#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that all US auto response rules are available in US-UAT

Background: 
	Given I am logged into salesforce for "AutoResponseRules"

@Cases
@Cases_VerifyThatAllUSAutoResponseRulesAreAvailableInUSUAT @GCRM-9259
Scenario Outline: Verify that all US auto response rules are available in US-UAT
	Given Runmode for "AutoResponseRules" is Y
	And  I change the app launcher to <app_Name>
	 When I navigate to setup page
	 Then I Quick search for the Case Auto Response Rules
	 When I Click on email to case auto response rules link
	 Then I verify auto response rules are available for US UAT

	Examples:
		|app_Name|
		|"CXG Lightning Console"|