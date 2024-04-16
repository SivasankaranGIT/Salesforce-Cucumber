#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep view the Marketo Sales Insight list on the Contact Record.

Background: 
	Given I am logged into salesforce for "MarketoSalesInsightContact" 
	
	
@Contacts
@MarketoSalesInsightContact	@GCRM-9239
Scenario Outline: Verify that MHHE Sales Rep view the Marketo Sales Insight list on the Contact Record.

	Given Runmode for "MarketoSalesInsightContact" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	Then global search for contact
	And view Marketo Sales Insight list
	
	Examples: 
	|MHHE_Sales_Representative|
	|Danielle_Snyder|