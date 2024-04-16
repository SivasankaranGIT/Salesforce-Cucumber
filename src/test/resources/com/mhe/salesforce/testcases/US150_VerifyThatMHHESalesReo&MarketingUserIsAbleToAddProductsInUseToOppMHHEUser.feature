#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOppMHHE

Background: 
	Given I am logged into salesforce for "MHHERepAddProdInUseToOppMHHE"	
	
@OpportunitiesNonDependent
@VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOppMHHE @GCRM-8968
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToAddProductInUseToAnOppMHHE

	Given Runmode for "MHHERepAddProdInUseToOppMHHE" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  	When I click sales Ref user details to navigate Sales
	And MHHE Use Add or Edit Opportunity Account tagged product with ISBN

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|