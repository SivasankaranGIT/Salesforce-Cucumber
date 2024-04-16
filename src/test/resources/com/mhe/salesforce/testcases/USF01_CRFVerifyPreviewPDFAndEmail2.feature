#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through Consultant Assignment option in Lightning mode

Background: 
Given I am logged into salesforce for "CRFVerifyPreviewPDFAndEmail2"

@ConsultantNA @CRFVerifyPreviewPDFAndEmail2 @GCRM-2926
Scenario Outline: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through Consultant Assignment option in Lightning mode

	Given Runmode for "CRFVerifyPreviewPDFAndEmail2" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then global search for consultant
	Then I navigate to consultant assignments page
	And verify CRF Preview PDF functionality
	And verify Send Request as PDF functionality

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|