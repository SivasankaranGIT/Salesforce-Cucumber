#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature:Verify that the SEG sales users can submit sample requests for Order Line Type- FWO- US for customers where sampling one or more products to one or more contacts.

Background: 
	Given I am logged into salesforce for "SEGUserSampleForOrderLineTypeFWOUS" 
	

@Samples	
@TC14_US_Sample_VerifyThatSEGUserCanSubmitSampleForOrderLineTypeFWOUS	@GCRM-9069
Scenario Outline: VerifyThatSEGUserCanSubmitSampleForOrderLineTypeFWOUS

	Given Runmode for "SEGUserSampleForOrderLineTypeFWOUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify account and orders details page
	Then select order line type as FWO US
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then Review details on review page
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|