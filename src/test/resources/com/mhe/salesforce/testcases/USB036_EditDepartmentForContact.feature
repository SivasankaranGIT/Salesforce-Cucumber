#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: edit Contact
  
  Background:
  Given I am logged into salesforce for "EditDepartmentOnContact"

	@Contacts
  @EditDepartmentOnContact @GCRM-9293
  Scenario Outline: User Contact Edit
 	Given Runmode for "EditDepartmentOnContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Contacts page
	Then global search for contact
	Then select department name

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|

