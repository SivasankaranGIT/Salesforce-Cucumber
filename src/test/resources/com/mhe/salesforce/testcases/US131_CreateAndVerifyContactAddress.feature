#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify MHHE profile user is able to create a Contact address

Background: 
	Given I am logged into salesforce for "CreateAndVerifyContactAddress" 
	
	
@Contacts
@CreateAndVerifyContactAddress	@GCRM-9017
Scenario Outline: Verify MHHE profile user is able to create a Contact address

	Given Runmode for "CreateAndVerifyContactAddress" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	And create new address for the contact
	Then I logout of any user
#	And Login as different US user
	And I do login as "<MHHE_Business_Administrator>"
	Then Verify and accept changes

	Examples:
	|MHHE_Sales_Representative|MHHE_Business_Administrator|
	|Haley_Loebig|Jaime_Klar|