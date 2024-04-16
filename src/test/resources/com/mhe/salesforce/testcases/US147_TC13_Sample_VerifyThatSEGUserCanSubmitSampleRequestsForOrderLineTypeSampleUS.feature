#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature:Verify that the SEG sales users can submit sample requests for Order Line Type- Sample US for customers where sampling one or more products to one or more contacts.

Background: 
	Given I am logged into salesforce for "SEGUserSampleForOrderLineSampleUS" 
	
	
@Samples
@TC13_US_Sample_VerifyThatSEGUserCanSubmitSampleRequestsForOrderLineTypeSampleUS	@GCRM-9068
Scenario Outline: VerifyThatSEGUserCanSubmitSampleRequestsForOrderLineTypeSampleUS

	Given Runmode for "SEGUserSampleForOrderLineSampleUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify account and orders details page and click next
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then Review details on review page
	And verify sample is created for SEG User
	
	Examples: 
	|SEG_Sales_Rep|
	|Open_Baker|