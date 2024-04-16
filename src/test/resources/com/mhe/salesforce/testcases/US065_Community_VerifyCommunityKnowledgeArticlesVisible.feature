#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the Knowledge articles are visible and limited to the respective service group

Background: 
	Given I am logged into salesforce for "CommuKnowledgeArtVisible"

@Cases
@TC02_US_Community_VerifyCommunityKnowledgeArticlesVisible @GCRM-9050
Scenario Outline: Verify that the Knowledge articles are visible and limited to the respective service group
	Given Runmode for "CommuKnowledgeArtVisible" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to setup page
	 Then I Quick search for all sites
	 Then verify ALEKS articles on support page
	 Then verify CSOM articles on support page
	 Then verify CXG articles on support page
	 Then verify DTS articles on support page
	 Then I logout of any user

	Examples:
		|app_Name|System_Administrator|
		|"CXG Lightning Console"|Sivasankaran_Periyasamy|


	 
	