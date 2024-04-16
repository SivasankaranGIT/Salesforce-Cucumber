#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Opportunity Criteria Custom Link show opps based on Market Revenue group filter

Background: 
	Given I am logged into salesforce for "OppCustomLinkMarketRevenueGroupFilter" 
	
@OpportunitiesNonDependent
@OppCustomLinkMarketRevenueGroupFilter
@GCRM-7953 @GCRM-7965
Scenario Outline: Verify Opportunity Criteria Custom Link show opps based on Market Revenue group filter

	Given Runmode for "OppCustomLinkMarketRevenueGroupFilter" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then navigate to MHES Lightning Console
	Then navigate to Opp Search page through custom link
	And verify market revenue group filter <MarketRevenueGroup>
	And verify probability group filter
	Examples:
	|MarketRevenueGroup|SEG_Business_Admin|
	|"ELEMENTARY: ASG - LITERACY"|Ivan_Gomez|