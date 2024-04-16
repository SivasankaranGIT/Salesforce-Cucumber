#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Verify that the SEG sales user can create Sample request from the Accounts record

Background: 
	Given I am logged into salesforce for "CreateSampleRequestFromAccountRecord" 
	
	
@Samples
@US_TC17_Sample_VerifySEGSalesUserCanCreateSampleRequestFromAccountRecord	@GCRM-9073
Scenario Outline: VerifySEGSalesUserCanCreateSampleRequestFromAccountRecord

	Given Runmode for "CreateSampleRequestFromAccountRecord" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then click on new sample
	Then verify account and fill mandatory fileds on account and orders details page
	Then add products for SEG user by clicking search product
	Then fill details on additional info page for SEG User
	Then review details on review page for SEG User
	And verify sample is created for SEG User

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|