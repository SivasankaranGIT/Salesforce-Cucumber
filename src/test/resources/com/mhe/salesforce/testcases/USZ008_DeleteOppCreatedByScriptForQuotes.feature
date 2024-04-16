Feature: Delete opp records created by automation scripts

Background: 
	Given I am logged into salesforce for "DeleteOpportunitiesCreatedByScriptForQuoteTest" 

@Quote @DeleteOpportunitiesCreatedByScriptForQuoteTest
Scenario Outline: Verify the system admin user can delete the automation script created opportunities

	Given Runmode for "DeleteOpportunitiesCreatedByScriptForQuoteTest" is Y
	Then I logout of any user
	And I change the app launcher to MHHE
  And delete the <opportunities> which are created by scripts
  #Keep adding more opp names in the Examples section which you want to delete at the end of the script run
  Examples:
  |opportunities|
  |"2024-OK-Edwards Elementary Schoo-DAG: ELA/MATH-Open"|
  |"2024-OK-Edwards Elementary Schoo-ELEMENTARY: ASG - MATH-Open"|