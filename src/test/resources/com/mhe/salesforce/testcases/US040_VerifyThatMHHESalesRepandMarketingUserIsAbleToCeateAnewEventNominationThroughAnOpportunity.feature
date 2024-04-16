Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHECreateEvenNomination" 
	
	
@US_TS01_TC12_VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunity
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCeateAnewEventNominationThroughAnOpportunity

	Given Runmode for "MHHECreateEvenNomination" is Y
#	Then I login as Sales Rep
	Then I do login as "<System Administrator>"
  	When I click sales Ref user details to navigate Sales
	And Navigate to existing Opportunity URL
	And Opportunities New Event Nomination

	Examples:
	|System Administrator|
	|Sivasankaran_Periyasamy|
