#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the CSOM Community Site has the entry  point(Bot) available on the page.

Background: 
	Given I am logged into salesforce for "VerifyCSOMCommunityHasBOT"

@Cases
@VerifyCSOMCommunityHasBOT @GCRM-8945
Scenario Outline: VerifyCSOMCommunityHasBOT
	Given Runmode for "VerifyCSOMCommunityHasBOT" is Y
#	Then I login as Sales Rep
	Then I do login as "<CSOM_General_User>"
	And  I change the app launcher to <app_Name>
	When I navigate to setup page
	Then I Quick search for all sites
	Then open CSOM support page
	And verify BOT on homepage
	Then I logout of any user

	Examples:
		|app_Name|CSOM_General_User|
		|"CSOM Lightning Console"|Lisa_Phelps |


	 
	