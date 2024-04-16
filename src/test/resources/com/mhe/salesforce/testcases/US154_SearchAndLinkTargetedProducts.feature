#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: SearchAndLinkTargetedProducts

Background: 
	Given I am logged into salesforce for "SearchAndLinkTargetedProducts"	
	
@OpportunitiesNonDependent
@SearchAndLinkTargetedProducts @GCRM-9274
Scenario Outline: SearchAndLinkTargetedProducts

	Given Runmode for "SearchAndLinkTargetedProducts" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  	When I click sales Ref user details to navigate Sales
	And Search and Link Targeted Productswith ISBN Marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|