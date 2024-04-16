#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the SEG sales user can create Sample request from the Samples tab directly

Background: 
	Given I am logged into salesforce for "SEGCreateSampleFromSampTab" 
	
@Samples @SmokeTest	@GCRM-9072 @GCRM-24927
@US_TC16_Sample_VerifyThatSEGSalesUserCanCreateSampleFromSamplesTabDirectly
Scenario Outline: VerifyThatSEGSalesUserCanCreateSampleFromSamplesTabDirectly

	Given Runmode for "SEGCreateSampleFromSampTab" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	When I navigate to sample tab
	And click on New to create sample
	Then fill mandatory fileds on account and orders details page for SEG user
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then review details on review page for SEG User
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|