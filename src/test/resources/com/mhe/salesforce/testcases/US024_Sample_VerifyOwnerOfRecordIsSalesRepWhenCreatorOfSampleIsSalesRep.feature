#DEPENDENT SCRIPT - This script is dependent on CreateNewOppForSamplesTest script for getting the Opportunity URL (selenium.NewOppURLForSamplesTest)
Feature: Verify that if the creator of the sample request is a sales rep, the rep will be the owner of the record. 

Background: 
	Given I am logged into salesforce for "VerifyOwnerOfSampleRecord" 
	
	
@Samples
@TC20_US_Sample_VerifyOwnerOfRecordIsSalesRepWhenCreatorOfSampleIsSalesRep	@GCRM-9076
Scenario Outline: VerifyOwnerOfRecordIsSalesRepWhenCreatorOfSampleIsSalesRep

	Given Runmode for "VerifyOwnerOfSampleRecord" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
#	When I click Sales Rep Oppurtunities tab
	And click on new sample
	Then verify desired owner on new sample page

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|