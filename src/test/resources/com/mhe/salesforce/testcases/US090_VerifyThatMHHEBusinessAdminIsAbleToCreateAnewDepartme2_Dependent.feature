#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHEBusinessAdminIsAbleToCreateAnewDepartme2_Dependent

Background: 
	Given I am logged into salesforce for "MHHEBussAdminCreateDept2" 
	
	
@Department
@TS04_TC07_VerifyThatMHHEBusinessAdminIsAbleToCreateAnewDepartme2_Dependent @GCRM-9287
Scenario Outline: VerifyThatMHHEBusinessAdminIsAbleToCreateAnewDepartme2_Dependent

	Given Runmode for "MHHEBussAdminCreateDept2" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click Admin user Contacts to create new contact
	And I enter and save all the Contact details DepartmentValidation

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|