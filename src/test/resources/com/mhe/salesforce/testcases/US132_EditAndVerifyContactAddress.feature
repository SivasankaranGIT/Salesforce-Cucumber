#DEPENDANT_SCRIPT - This script is dependent on 'CreateAndVerifyContactAddress' script for getting 'selenium.url'
Feature: Verify MHHE profile user is able to edit a Contact address

Background: 
	Given I am logged into salesforce for "EditAndVerifyContactAddress" 
	
	
@Contacts
 @EditAndVerifyContactAddress	@GCRM-9016
Scenario Outline: Verify MHHE profile user is able to edit a Contact address

	Given Runmode for "EditAndVerifyContactAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And edit new address for the contact
	Then I logout of any user
#	And Login as different US user
	And I do login as "<MHHE_Business_Administrator>"
	Then Verify and accept changes

	Examples:
	|MHHE_Sales_Representative|MHHE_Business_Administrator|
	|Haley_Loebig|Jaime_Klar|