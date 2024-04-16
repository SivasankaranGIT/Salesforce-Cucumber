#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHES user is able to create a new Sample

Background: 
	Given I am logged into salesforce for "MHESUserCreatesNewSample" 	

@OpportunitiesNonDependent	
@MHESUserCreatesNewSample
@GCRM-8963 @GCRM-16026
@RegressionTest @RegressionTestOpportunities
Scenario Outline: MHES user is able to create a new Sample

	Given Runmode for "MHESUserCreatesNewSample" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And I switch to SalesChatter home page
	When I click sales Ref user details to navigate Marketing
	Then I create new sample from Opportunity

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|