#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the new sample requests can be created from the Sample tab directly

Background: 
	Given I am logged into salesforce for "SampleFromSampleTab"	
	
@Samples
@US_TC03_Sample_VerifyNewSampleRequestsCanBeCreatedFromSampleTabDirectly	@GCRM-9279
Scenario Outline: VerifyNewSampleRequestsCanBeCreatedFromSampleTabDirectly

	Given Runmode for "SampleFromSampleTab" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I navigate to sample tab
	And click on New to create sample
	Then click on search contacts
	And add contact to sample
	Then click on search products
	And add product to sample
	Then click on next and create sample
	And verify sample is created

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|