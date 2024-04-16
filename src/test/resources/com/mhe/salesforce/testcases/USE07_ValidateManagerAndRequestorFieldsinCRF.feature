#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user is restricted from updating/populating the "Manager" field same as "Requestor" field

Background:
Given I am logged into salesforce for "validateManagerAndRequestorFieldsinCRF"

@ConsultantNA @validateManagerAndRequestorFieldsinCRF @GCRM-4731
Scenario Outline: Verify that the user is restricted from updating/populating the "Manager" field same as "Requestor" field

	Given Runmode for "validateManagerAndRequestorFieldsinCRF" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	When I navigate to consultant requests tab
	And create new consultant request
	And verify manager and requestor field validation
	And edit existing CRF and verify manager and requestor field validation

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|