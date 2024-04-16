#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHERepCreateSampleOpp"	
	
@OpportunitiesNonDependent
@US_TSUS_01_TC11_VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunity @GCRM-9276
@RegressionTest @RegressionTestOpportunities
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateSampleThroughAnOpportunity

	Given Runmode for "MHHERepCreateSampleOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When I click sales Ref user details to navigate Sales
	And Opportunities Samples creation

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|
