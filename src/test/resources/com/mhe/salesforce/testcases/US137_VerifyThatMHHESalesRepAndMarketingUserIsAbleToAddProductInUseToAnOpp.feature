#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOpp

Background: 
	Given I am logged into salesforce for "MHHERepAddProdInUseToOpp"	
	
@OpportunitiesNonDependent
@VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOpp @GCRM-8968
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOpp

	Given Runmode for "MHHERepAddProdInUseToOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  	When I click sales Ref user details to navigate Sales
	And Marketing Use Add or Edit Opportunity Account tagged product with ISBN

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|