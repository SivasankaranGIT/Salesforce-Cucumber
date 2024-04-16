#DEPENDENT SCRIPT - This script is dependent on MarketingUserCreateOpportunity script for getting the Opportunity URL (selenium.MarketingUserNewOppURL)
Feature: VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityName

Background: 
	Given I am logged into salesforce for "MHHEUpdateOppNames"
	
@OpportunitiesDependent
@US_TS01_TC03_VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityName @GCRM-8983
Scenario Outline: VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityName

	Given Runmode for "MHHEUpdateOppNames" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
  When I click sales Ref user details to navigate Marketing
	And Edit Opportunities details for salesMarketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|