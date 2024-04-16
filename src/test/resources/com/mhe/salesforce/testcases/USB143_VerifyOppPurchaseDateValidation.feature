#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the validation to match Opportunity Year is not fired when the Opportunity Purchase date is<01/01/2017

Background: 
	Given I am logged into salesforce for "VerifyOppPurchaseDateValidation" 

@OpportunitiesNonDependent @VerifyOppPurchaseDateValidation @GCRM-16941
Scenario: Verify the validation to match Opportunity Year is not fired when the Opportunity Purchase date is<01/01/2017
	Given Runmode for "VerifyOppPurchaseDateValidation" is Y
	Then I logout of any user
	And verify the match opportunity year validation when purchase date is less than 2017
	|https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0061A000012x7RNQAY/view|