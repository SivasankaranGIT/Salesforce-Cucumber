#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Verify that the SEG sales User, Sample requests created from an opportunity, will pre-populate the account and products related to the opportunity.

Background: 
	Given I am logged into salesforce for "SEGSamplePrePopAccountProd" 
	

@Samples	
@TC19_US_Sample_VerifyThatForSEGUserSamplescreatedFromOpportunityWillPrepopulateAccountsAndProducts	@GCRM-9075
Scenario Outline: VerifyThatForSEGUserSamplescreatedFromOpportunityWillPrepopulateAccountsAndProducts

	Given Runmode for "SEGSamplePrePopAccountProd" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify account and orders details page and click next
	Then add products for SEG user by clicking search product
	Then verify details on additional info page for SEG User
	Then Review details on review page
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|