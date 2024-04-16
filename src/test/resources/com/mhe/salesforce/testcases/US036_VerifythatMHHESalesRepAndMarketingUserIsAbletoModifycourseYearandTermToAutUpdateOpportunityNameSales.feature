#DEPENDENT SCRIPT - This script is dependent on MarketingUserCreateOpportunity script for getting the Opportunity URL (selenium.MarketingUserNewOppURL). This same URL is getting used in MHHEUpdateOppNames script as well.
Feature: VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityNameSales

Background: 
	Given I am logged into salesforce for "MHHEUpdateOpp" 	
	
@OpportunitiesDependent
@US_TS01_TC03_VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityNameSales
@GCRM-8983 @GCRM-8561
Scenario Outline: VerifythatMHHESalesRepAndMarketingUserIsAbletoModifycourseYearandTermToAutUpdateOpportunityNameSales

	Given Runmode for "MHHEUpdateOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  When I click sales Ref user details to navigate Sales
	And Edit Opportunities details
	And MHHE Markerting user Edit McGrawHill GO field
	#Then I logout of any user	#Reason for commenting it out GCRM-18537
  #And Login as different US user
  #Then navigate to an exiting opportunity
	#And verify MHHE Sales Rep user can not Edit McGrawHill GO field

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|