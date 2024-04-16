#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Marketing user create a campaign.

Background: 
	Given I am logged into salesforce for "MarketingUserCreateCampaign" 
	
@Campaign
@SmokeTest	
@MarketingUserCreateCampaign	@GCRM-9284
Scenario Outline: MHHE Sales Rep User Edit a Contact

	Given Runmode for "MarketingUserCreateCampaign" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When Navigate to Campaigns page
	And create campaign by filling mandatory fields
	Then I validate the Marketing user create campaign success message

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|