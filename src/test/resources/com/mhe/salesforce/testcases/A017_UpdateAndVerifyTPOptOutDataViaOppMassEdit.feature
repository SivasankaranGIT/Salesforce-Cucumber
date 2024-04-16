Feature: Verify TP Opt out field is added to the Mass Edit Page

Background: 
	Given I am logged into salesforce for "UpdateAndVerifyTPOptOutDataViaOppMassEdit" 

@OpportunitiesDependent_NA
@UpdateAndVerifyTPOptOutDataViaOppMassEdit
@GCRM-8204
Scenario Outline: Verify TP Opt out field is added to the Mass Edit Page

	Given Runmode for "UpdateAndVerifyTPOptOutDataViaOppMassEdit" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
	Then I navigate to opportunity tab
	Then verify and update TPOptOut field via Opp MassEdit
	Then I navigate to opportunity tab
	When I navigate to the first opp in the page
	And verify the TPOptOut field

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|
