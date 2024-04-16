#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Create and Close DTS case

Background: 
	Given I am logged into salesforce for "VerifycreateAndCloseDTSCase" 	
	
@Cases @TC04_US_Cases_VerifycreateAndCloseDTSCase @GCRM-15617
Scenario Outline: VerifycreateAndCloseDTSCase

	Given Runmode for "VerifycreateAndCloseDTSCase" is Y
	Then I do login as "<CSOM_General_User_Mheducation_Live_Agent_Single>"
	And  I change the app launcher to <app_Name>
	Then global search for contact
	Then click on New case by selecting one contact
	Then select record type as DTS Support
	And fill all mandatory details to create DTS case
	Then click on close case button for DTS
	And fill mandatory fields to close DTS Case
	Then verify the status of closed DTS record
	And change case owner and verify record type
	Examples:
		|app_Name|CSOM_General_User_Mheducation_Live_Agent_Single|
		|"DTS Lightning Console"|Garry_Qualter|