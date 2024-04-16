#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHEBusinessAdminIsAbleToCreateAnewDepartme

Background: 
	Given I am logged into salesforce for "MHHEBussAdminCreateDept"	
	
@Department
@TS04_TC07_VerifyThatMHHEBusinessAdminIsAbleToCreateAnewDepartme @GCRM-9287
Scenario Outline: ValidationRuleALL_Reason_for_Inactive_contacts

	Given Runmode for "MHHEBussAdminCreateDept" is Y
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	When I click Admin user Contacts to create new department
	And I enter and save all the department details

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|

