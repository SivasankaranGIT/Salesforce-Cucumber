#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that If a product is restricted or out of print, the product cannot be added to the sample request

Background: 
Given I am logged into salesforce for "RestrictedProdCannotAddToSample" 
	
	
@Samples
@US_TC10_Sample_VerifyRestrictedProductCannotBeAddedToSampleRequest	@GCRM-9067
Scenario Outline: VerifyRestrictedProductCannotBeAddedToSampleRequest

	Given Runmode for "RestrictedProdCannotAddToSample" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for products
	And fetch ISBN value
	When I navigate to contacts tab
	Then global search for contact
	Then click on sample contact button
	Then search for restricted product

	Examples:
	|MHHE_Sales_Representative|
	|Jenna_Taylor|