#STAND_ALONE_SCRIPT - This script can be executed separately.
#It is duplicate test script. Already covered in VerifyCaseVisibilityInVariousLocations
Feature: As MHHE Sales Support, verify Case visibility in various locations throughout Salesforce.

Background: 
Given I am logged into salesforce for "MHHEViewCasefromDiffLoc"	
	
@CasesSKIP @MHHEViewCasefromDiffLoc	@GCRM-9230
Scenario Outline: MHHEViewCasefromDiffLoc

	Given Runmode for "MHHEViewCasefromDiffLoc" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	And  I change the app launcher to <app_Name>
	Then global search for contact
	And navigate to Cases section
	Then verify case details
	When I navigate to Opportunity page
	And navigate to Cases section from opportunity
	Then verify case details

	Examples:
		|app_Name|MHHE_Business_Administrator|
		|"MHHE"|Emily_Cearlock|