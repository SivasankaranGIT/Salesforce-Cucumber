#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify MMHE Marketing user is able to create a new opportunity or not

Background: 
	Given I am logged into salesforce for "MarketingUserCreateOpportunity"
	
@OpportunitiesDependent
@MarketingUserCreateOpportunity @GCRM-8404 @GCRM-9271
Scenario: Verify MMHE Marketing user is able to create a new opportunity or not

	Given Runmode for "MarketingUserCreateOpportunity" is Y
	Then I login as Sales Rep
	Then I navigate to opportunity tab
	Then I create new opportunity