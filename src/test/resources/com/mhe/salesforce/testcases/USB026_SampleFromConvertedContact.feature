#DEPENDENT SCRIPT - This script is dependent on MHHESalesSupportUserCreatesNewContact script for getting the Contact URL (selenium.newContacts)
Feature: With the same customer verify sample request can be sent with appropriate rep approval.

Background: 
	Given I am logged into salesforce for "ConvertedContactSample"	
	
@Samples @ConvertedContactSample	@GCRM-9237
Scenario Outline: With the same customer verify sample request can be sent with appropriate rep approval.

	Given Runmode for "ConvertedContactSample" is Y
	Then I do login as "<MHHE_Sales_Support>"
	Then add products to sample
	Then create Sample Contact for converted contact
	Then I logout of any user
	And Login as different US user
	Then delete record as Sys admin

Examples:
	|MHHE_Sales_Support|
	|Jennifer_Bahl|