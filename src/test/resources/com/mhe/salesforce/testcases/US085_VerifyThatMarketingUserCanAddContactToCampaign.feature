#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Marketing user can add a contact to a campaign

Background: 
	Given I am logged into salesforce for "MarkuserAddContactToCamp" 
	
@Contacts
@SmokeTest	
@TS07_TC03_VerifyThatMarketingUserCanAddContactToCampaign @GCRM-9282
Scenario Outline: VerifyThatMarketingUserCanAddContactToCampaign

	Given Runmode for "MarkuserAddContactToCamp" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
	Then I navigate to Campaign history section to click on Add to campaign button
	Then I select campaign
	And verify fields on campaign page
	Then click on Campaign name
	And verify contact details in campaign history section
	Then delete campaign member
	
	Examples: 
	|MHHE_Marketing|
	|Kara_Allara|