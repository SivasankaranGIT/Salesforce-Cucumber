#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the fields in CRF report in Salesforce Classic mode

Background: 
Given I am logged into salesforce for "validateCRFReportFieldsinSFClassic"

@Consultant
@validateCRFReportFieldsinSFClassic
@GCRM-3788
Scenario Outline: Verify the fields in CRF report in Salesforce Classic mode

	Given Runmode for "validateCRFReportFieldsinSFClassic" is Y
#	Then I login as Sales Rep in classic
	Then I do login as classic "<SEG_Sales_Ops_Adm_Manager>"
	And switch to classic user interface
	Then I navigate to reports tab
	And verify the request general and webinar in person fields
	Then create new report and verify the webinar in person field

	Examples:
	|SEG_Sales_Ops_Adm_Manager|
	|Kathleen_Nicholson|