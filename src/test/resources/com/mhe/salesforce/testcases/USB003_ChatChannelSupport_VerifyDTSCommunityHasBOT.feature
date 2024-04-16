#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the DTS Community Site has the entry  point(Bot) available on the page.

Background: 
	Given I am logged into salesforce for "VerifyDTSCommunityHasBOT"

@Cases
@VerifyDTSCommunityHasBOT @GCRM-8944
Scenario Outline: VerifyDTSCommunityHasBOT
	Given Runmode for "VerifyDTSCommunityHasBOT" is Y
	When I navigate to setup page
	Then I Quick search for all sites
	Then open DTS support page
	And verify BOT on homepage

	Examples:
	|app_Name|
	|"CXG Lightning Console"|