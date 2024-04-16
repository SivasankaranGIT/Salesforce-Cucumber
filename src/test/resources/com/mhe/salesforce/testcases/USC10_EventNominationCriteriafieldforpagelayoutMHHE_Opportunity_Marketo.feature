#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Event Nomination Criteria field is displayed for different types of page layout.

Background:
Given I am logged into salesforce for "VerifyEventNominationCriteriaField"

@OpportunitiesNonDependent @VerifyEventNominationCriteriaField @GCRM-10129 @GCRM-10321
Scenario Outline: Verify Event Nomination Criteria field is displayed for different types of page layout.
 	Given Runmode for "VerifyEventNominationCriteriaField" is Y
	Then I do login as "<MHHE_Sales_Manager>"
	Then I navigate to opportunity tab
	When I navigate to the first opp in the page
	And Navigate to Lead Nomination section
	And Verify the Event Nomination Criteria Field and its value
	Then I logout of any user
	Then I do login as "<MHHE_Business_Administrator>"
	Then I navigate to opportunity tab
	When I navigate to the first opp in the page
	And Navigate to Lead Nomination section
	And Verify the Event Nomination Criteria Field and its value
	Then I logout of any user
	Then I do login as "<MHHE_Enterprise>"
	Then I navigate to opportunity tab
	When I navigate to the first opp in the page
	And Navigate to Lead Nomination section
	And Verify the Event Nomination Criteria Field and its value
	Then I logout of any user
	Then I do login as "<MHHE_National_Sales_Manager>"
	Then I navigate to opportunity tab
	When I navigate to the first opp in the page
	And Navigate to Lead Nomination section
	And Verify the Event Nomination Criteria Field and its value

	Examples:
	|MHHE_Sales_Manager|MHHE_Business_Administrator|MHHE_Enterprise|MHHE_National_Sales_Manager|
	|Tina_Altman       |Jaime_Klar                 |Kelly_Cornelius|Cassie_Cannon              |