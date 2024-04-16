#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: confirm field history tracking history is turned on for Product Team Comments

Background: 
	Given I am logged into salesforce for "VerifyProdTeamCommentsInOppHistory" 

@GCRM-9818
@OpportunitiesNonDependent
@VerifyProdTeamCommentsInOppFieldHistory
@RegressionTest @RegressionTestOpportunities
Scenario: confirm field history tracking history is turned on for Product Team Comments

	Given Runmode for "VerifyProdTeamCommentsInOppHistory" is Y
	Then I logout of any user
	And I switch to Sales home page
	When I click sales Ref user details to navigate Sales
	When I navigate to the first opp in the page
	Then edit product team comments field
	And verify opp field history section