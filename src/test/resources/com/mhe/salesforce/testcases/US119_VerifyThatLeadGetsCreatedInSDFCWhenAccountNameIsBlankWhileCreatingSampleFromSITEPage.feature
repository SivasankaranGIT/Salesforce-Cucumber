Feature: Verify that lead gets created in SFDC when account name is blank while creating sample from the SITE Page

Background: 
	Given I am logged into salesforce for "LeadCreatedWhenAcctNameBlank"

@TS01_TC04_VerifyThatLeadGetsCreatedInSDFCWhenAccountNameIsBlankWhileCreatingSampleFromSITEPage 
Scenario Outline: TS01_TC04_VerifyThatLeadGetsCreatedInSDFCWhenAccountNameIsBlankWhileCreatingSampleFromSITEPage
	Given Runmode for "LeadCreatedWhenAcctNameBlank" is Y 
	Then I do login as "<MHHE_Marketing>"
	When I navigate to Campaigns tab
	And click on the Campaign name
	Then click on Lead URL 
	Then I enter manadatory details 
	And I close the SEG site
	Then verify lead record on campaign members section

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|