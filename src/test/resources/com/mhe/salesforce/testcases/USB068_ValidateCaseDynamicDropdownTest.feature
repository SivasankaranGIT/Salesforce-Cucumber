Feature: Validate Case Dynamic Dropdown fields.

Background: 
	Given I am logged into salesforce for "ValidateCaseDynamicDropdown"
	
	
@ValidateCaseDynamicDropdown
Scenario Outline: Validate Case Dynamic Dropdown fields.

	Given Runmode for "ValidateCaseDynamicDropdown" is Y
#	Then I login as Sales Rep in classic
	Then I do login as classic "<System_Administrator>"
	And switch to classic user interface
#	Then I login as Sales Rep
#	When I navigate to case tab
#	Then I click on new case option
	And Validate dynamic dropdown fields

	Examples:
	|System_Administrator|
	|Ashish_Gupta|