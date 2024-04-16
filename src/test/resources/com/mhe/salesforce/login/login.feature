Feature: Salesforce Login 
	In order to test the salesforce application 
	As a QA tester
	I want to login

@SmokeTest
@login 
Scenario Outline: Login Test 

	Given Runmode for "LoginTest" is Y 
	When I go to "<Url>"
	And I enter login "<username>" and "<password>"
	And I click on "loginSalesrep"
	Then login should be successful 
	Then I navigate to salesapplication
	Examples:
	|Url|username|password|
	|loginUrl|UserName|Password|