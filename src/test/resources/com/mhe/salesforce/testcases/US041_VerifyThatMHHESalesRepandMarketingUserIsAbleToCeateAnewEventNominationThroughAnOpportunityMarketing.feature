Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHHECreateEventNominationMark" 
	
	
@US_TS01_TC12_VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunityMarketing
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunityMarketing

	Given Runmode for "MHHECreateEventNominationMark" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
  When I click sales Ref user details to navigate Sales
	And Navigate to existing Opportunity URL
	And Opportunities New Event Nomination Marketing

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|