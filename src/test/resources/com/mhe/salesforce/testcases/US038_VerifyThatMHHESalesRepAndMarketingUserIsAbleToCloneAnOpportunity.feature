Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHECloneOpp" 
	
@SmokeTest	
@US_TS01_TC10_VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunity
@GCRM-8977
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunity

	Given Runmode for "MHHECloneOpp" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When User to search and do Opportunity related validation
	Then global search for opportunities
	And I Clone from opportunity page
	And verify the Product and Contact details in newly cloned opportunities
	
	Examples: 
	|MHHE_Sales_Representative|
	|Haley_Loebig|