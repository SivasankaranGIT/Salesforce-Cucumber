#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through CRF option in Classic mode
Background:
Given I am logged into salesforce for "CRFVerifyPreviewPDFAndEmail3"

@Consultant @CRFVerifyPreviewPDFAndEmail3 @GCRM-2828 @GCRM-2909
Scenario Outline: Verify SEG Business Admin user is able to Preview the PDF of the Staffing Request form through CRF option in Classic mode

	Given Runmode for "CRFVerifyPreviewPDFAndEmail3" is Y
#	Then I login as Sales Rep in classic
	Then I do login as classic "<A3K_Sales_Support>"
	And switch to classic user interface
	Then I navigate to CRF page in classic mode
	And verify CRF Preview PDF functionality
	And verify Send Request as PDF functionality
	
	Examples: 
	|A3K_Sales_Support|
	|Licia_Austin|