#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Verify that the SEG sales users Sample requests created from a contact will pre-populate the contact on the request.

Background: 
	Given I am logged into salesforce for "SEGUserSampleWillPrepopulateContact" 
	
	
@Samples
@TC18_US_Sample_VerifySEGUserCreatedSampleWillPrepopulateContactOnRequest	@GCRM-9074
Scenario Outline: VerifySEGUserCreatedSampleWillPrepopulateContactOnRequest

	Given Runmode for "SEGUserSampleWillPrepopulateContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify contact and fill mandatory fileds on account and orders details page
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then review details on review page for SEG User
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|