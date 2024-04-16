Feature: Salesforce Login 
	In order to test the informatica interface application 
	As a QA tester
	I want to login

@InformaticaInterface @InformaticaInterfaceLogin
Scenario Outline: Login Test 

	Given Runmode for "InformaticaInterfaceLogin" is Y 
	When I go to "<Url>"
	And I enter informatica login "<username>" and "<password>"
	And I click on "I_LoginInBtn"
	Examples:
	|Url|username|password|
	|II_loginURL|II_UserName|II_Password|