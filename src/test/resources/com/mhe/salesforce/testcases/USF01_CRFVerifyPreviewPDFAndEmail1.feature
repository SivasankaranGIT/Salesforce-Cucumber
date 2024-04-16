#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through CRF option in Lightning mode
Background:
Given I am logged into salesforce for "CRFVerifyPreviewPDFAndEmail"

@Consultant
@CRFVerifyPreviewPDFAndEmail
@GCRM-2827 @GCRM-2907
Scenario Outline: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through CRF option in Lightning mode

	Given Runmode for "CRFVerifyPreviewPDFAndEmail" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then global search for consultant
	Then I navigate to CRF page
	And verify CRF Preview PDF functionality
	And verify Send Request as PDF functionality

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|