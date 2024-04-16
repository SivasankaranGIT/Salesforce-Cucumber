#DEPENDENT SCRIPT - This script is dependent on SampleRequest_SEGsite script for getting the Campaign URL (selenium.newCampaignUR)
Feature: Verify that the user is able to see the "Title__c" instead of "Full_Title__c" in the Title column for ordering Samples.

Background:
Given I am logged into salesforce for "validateSampleTitleinSEGSite"	

@Samples
@validateSampleTitleinSEGSite
@GCRM-4397
Scenario Outline: Verify that the user is able to see the "Title__c" instead of "Full_Title__c" in the Title column for ordering Samples.
	Given Runmode for "validateSampleTitleinSEGSite" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Business_Admin>"
	Then click on SEG Site URL
	And verify sample title

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|