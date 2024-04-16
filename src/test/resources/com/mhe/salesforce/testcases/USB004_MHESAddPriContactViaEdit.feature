#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: AddPriContactViaEdit

Background: 
	Given I am logged into salesforce for "AddPriContactViaEdit" 	
	
@OpportunitiesNonDependent
@AddPriContactViaEdit @GCRM-9246
Scenario Outline: AddPriContactViaEdit

	Given Runmode for "AddPriContactViaEdit" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
  When Opp Pri Contact Via Edit
	Then I logout of any user

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|