#STAND_ALONE_SCRIPT - This script can be executed separately.
#NOTE : This TC cannot be run as now we have no way to create an ADDRESS with NO COUNTRY (Country is a mandatory field now while creating address) 
Feature: Verify that the user receives an Error when the Address of the Sample does not have a country.

Background:
Given I am logged into salesforce for "Sample_CountryValidation"	

@SamplesNA
@VerifySampleCreationWithoutCountryInAddress
@GCRM-9159
Scenario Outline: Verify that the user receives an Error when the Address of the Sample does not have a country.
	Given Runmode for "Sample_CountryValidation" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	Then global search for accounts
	Then navigate to the desired contact
	Then create INTL sample for contact
	And verify the address with no country validation

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|