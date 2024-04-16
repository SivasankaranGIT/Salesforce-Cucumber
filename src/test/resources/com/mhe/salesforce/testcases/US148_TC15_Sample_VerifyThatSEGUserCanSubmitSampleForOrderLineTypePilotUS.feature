#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:Verify that the SEG sales and marketing users can submit sample requests for Order Line Type- Pilot- US for customers where sampling one or more products to one or more contacts.

Background: 
	Given I am logged into salesforce for "SEGUserSampleForOrderLinePilotUS" 
	

@Samples	
@TC15_US_Sample_VerifyThatSEGUserCanSubmitSampleForOrderLineTypePilotUS	@GCRM-9070
Scenario Outline: VerifyThatSEGUserCanSubmitSampleForOrderLineTypePilotUS

	Given Runmode for "SEGUserSampleForOrderLinePilotUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify account and orders details page
	Then select order line type as Pilot US
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then Review details on review page
	And verify sample is created for SEG User
	
	Examples: 
	|SEG_Sales_Rep|
	|Open_Baker|