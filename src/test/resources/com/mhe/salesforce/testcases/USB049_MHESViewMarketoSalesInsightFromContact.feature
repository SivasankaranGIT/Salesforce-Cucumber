#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE View Market Sales Insight for a Contact 

Background: 
	Given I am logged into salesforce for "MHESMarketoSalesInsight" 

@Contacts
@MHESMarketoSalesInsight	@GCRM-9219
Scenario Outline: MHESMarketoSalesInsight

	Given Runmode for "MHESMarketoSalesInsight" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then global search for contact
	And view MHES Marketo Sales Insight list

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|