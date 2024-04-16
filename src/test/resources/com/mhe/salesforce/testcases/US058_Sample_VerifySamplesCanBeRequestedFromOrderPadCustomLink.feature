#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Samples can be requested from Order Pad custom link

Background: 
	Given I am logged into salesforce for "CreateSampleFromOrderPad" 
	
@Samples
@SmokeTest	
@US_TC23_Sample_VerifySamplesCanBeRequestedFromOrderPadCustomLink	@GCRM-9078
Scenario Outline: VerifySamplesCanBeRequestedFromOrderPadCustomLink

	Given Runmode for "CreateSampleFromOrderPad" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to MHES Lightning Console
	And click on order pad custom link
	Then fill mandatory fileds on account and orders details page
	Then add products by clicking search product
	Then fill details on additional info page
	Then review details on review page
	And verify sample is created from Order Pad

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|