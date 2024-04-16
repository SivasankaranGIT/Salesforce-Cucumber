Feature: Verify the Cases Scenarios.

Background:
Given I am logged into salesforce for "VerifyCasesScenarios"

@Cases
@VerifyCasesScenarios @GCRM-18650
Scenario Outline: Verify the newly activated and deactivated values in the Product Group field for FAQ_Solution and How to record types
 	Given Runmode for "VerifyCasesScenarios" is Y
#	Then I login as <Jennifer Ryan>
	Then I do login as "<CSOM_Business_Administrators>"
	And I change the app launcher to "CSOM Lightning Console"
	When I navigate to "Knowledge" tab and click on New button
	Then I click <Record Type> radio button and click Next
	And fill all mandatory details to create new Knowledge article for <Category> 

    
Examples:
	|Category|Record Type|CSOM_Business_Administrators|
	|"CategoryName1"|"FAQ_Solution"|Jennifer_Ryan|
	|"CategoryName1"|"HowToRadioBtn"|Jennifer_Ryan|