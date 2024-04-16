#DEPENDANT_SCRIPT - This script is dependent on 'MarketingUserCreateCampaign' script for getting 'selenium.campaign'.
Feature: Marketing User Edit a Campaign

Background: 
	Given I am logged into salesforce for "MarketingUserEditCampaign" 
	
@Campaign
@SmokeTest	
@MarketingUserEditCampaign	@GCRM-9283
Scenario: Marketing User Edit a Campaign

	Given Runmode for "MarketingUserEditCampaign" is Y
	And I edit campaign details 
	Then I validate the Marketing user create campaign success message