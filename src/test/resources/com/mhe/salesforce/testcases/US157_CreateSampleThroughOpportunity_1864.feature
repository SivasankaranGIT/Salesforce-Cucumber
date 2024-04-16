#DEPENDENT SCRIPT - This script is dependent on MHHERepcreateSampleOppMark script to cover the commented out steps
Feature: Verify that MHHE Sales Rep and Marketing user is able to create sample through an opportunity

Background: 
	Given I am logged into salesforce for "CreateSampleThroughOpportunity" 	
	
@OpportunitiesDependent
@CreateSampleThroughOpportunity @GCRM-8976
Scenario Outline: Verify that MHHE Sales Rep and Marketing user is able to create sample through an opportunity

	Given Runmode for "CreateSampleThroughOpportunity" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user details to navigate Marketing
	Then I create new sample from Opportunity for MHHE user
	#THE BELOW SCENAIOS ARE ALREADY BEEN COVERED IN MHHERepcreateSampleOppMark TEST SCRIPT
#	Then I logout of any user
#	And Login as different US user
#	When I click sales Ref user details to navigate Marketing
#	Then global search for opportunities
#	Then I create new sample from Opportunity for Marketing user

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|