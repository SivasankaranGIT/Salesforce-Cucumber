#DEPENDANT_SCRIPT - This script is dependent on 'MHHECreateNewLead' script for getting 'selenium.LeadURl'
Feature: Verify that Marketing user can add a contact to a campaign

Background: 
	Given I am logged into salesforce for "MarkUserAddLeadToCamp" 
	
@Leads
@SmokeTest	
@TS07_TC04_VerifyThatMarketingUserCanAddLeadToCampaign @GCRM-9281
Scenario Outline: VerifyThatMarketingUserCanAddLeadToCampaign

	Given Runmode for "MarkUserAddLeadToCamp" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<System_Administrator>"
	Then I navigate to Campaignhistory section to click on Add to campaign button
	Then I select Campaign
	And verify fields on Campaign page
	Then click on created Campaign Name
	And verify contact details in Campaign History section
	Then delete campaign member

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|
