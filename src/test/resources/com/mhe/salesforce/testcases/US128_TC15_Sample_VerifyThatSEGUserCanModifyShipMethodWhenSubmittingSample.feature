#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Verify that the SEG sales user can modify the ship method when submitting the request.

Background: 
	Given I am logged into salesforce for "SEGUserModifyShipMethod" 
	
	
@Samples
@US_TC15_Sample_VerifyThatSEGUserCanModifyShipMethodWhenSubmittingSample	@GCRM-9071
Scenario Outline: VerifyThatSEGUserCanModifyShipMethodWhenSubmittingSample

	Given Runmode for "SEGUserModifyShipMethod" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on sample contact button from opportunity
	Then verify account and orders details page
	Then edit shipping method on account and orders details page
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then Review details on review page
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|