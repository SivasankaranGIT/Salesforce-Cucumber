#DEPENDENT SCRIPT - This script is dependent on MHHESalesRepUserCreateNewOpp script for getting the Opportunity URL (selenium.MHHENewOppURL).
#This same URL is getting used in MHHESalesRepUserEditOpp script as well.
Feature: Verify two new fields are present in DFC Request and values are auto updated from related Opportunity field values

Background: 
	Given I am logged into salesforce for "VerifyDFCRequestFieldsInOpp" 

@OpportunitiesDependent @VerifyDFCRequestFieldsInOpp @GCRM-15434 @GCRM-17192 @GCRM-16400
Scenario Outline: Verify two new fields are present in DFC Request and values are auto updated from related Opportunity field values
	Given Runmode for "VerifyDFCRequestFieldsInOpp" is Y
#	Then I login as <MHHE_Sales_Rep>
	Then I do login as "<MHHE_Sales_Representative>"
	Then create new DFC Request in Opp
	|IST|Course Build|Matt Birch|10AM TO 6PM|Jackie Alvarado|Test|Sales|7/8/2024|
	And verify the DFC Request fields
	|Customer Success Consultant|Customer Success Specialist|
	Then confirm the DFC Request field values are getting populated from opp record
	Then verify the DFC fields are editable
Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|