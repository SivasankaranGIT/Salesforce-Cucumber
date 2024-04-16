#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:Verify that the Sample requests created from a contact will pre-populate the contact on the request

Background: 
Given I am logged into salesforce for "SamplesFromConactPrePopContact" 
	

@Samples	
@US_TC04_Sample_VerifyThatSampleRequestsCreatedfromContactWillPrepopulateContactOnRequest	@GCRM-9064
Scenario Outline: VerifyThatSampleRequestsCreatedfromContactWillPrepopulateContactOnRequest

	Given Runmode for "SamplesFromConactPrePopContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	Then click on sample contact button
	Then verify contact prepopulated on sample page	
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jenna_Taylor|