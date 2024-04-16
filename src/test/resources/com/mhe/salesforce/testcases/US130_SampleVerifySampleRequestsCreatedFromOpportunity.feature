#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the Sample requests created from an opportunity list view, will pre-populate the combinations of contacts and products related to the opportunity(s)

Background: 
Given I am logged into salesforce for "SampleFromOpportunityListView"	
	
@OpportunitiesNonDependent
@CreateSampleFromOppList @GCRM-9066	
Scenario Outline: VerifySampleRequestsCreatedFromOpportunityListViewWillPrepoulateCombinationOfContactsAndProducts

	Given Runmode for "SampleFromOpportunityListView" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I navigate to opportunity tab
	And choose list view for opportunity
	Then select opportunities and click on new sample
	Then verify samples section for product and contacts combination

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|