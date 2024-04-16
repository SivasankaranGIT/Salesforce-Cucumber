#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts (CreateSampleThroughOpportunity).
Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHHERepcreateSampleOppMark" 	
	
@OpportunitiesDependent
@US_TSUS_01_TC11_VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunityMarketing @GCRM-9276
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunityMarketing

	Given Runmode for "MHHERepcreateSampleOppMark" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  When I click sales Ref user details to navigate Sales
	And Opportunities Samples Creation Marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|