#STAND_ALONE_SCRIPT - This script can be executed separately.
#NOTE : This TC cannot be run as now we have no way to create an ADDRESS with NO COUNTRY (Country is a mandatory field now while creating address) 
Feature: Validate that address populating when attempting to create a sample record and also verify the invalid country validation

Background:
Given I am logged into salesforce for "CreateSampleAndVerifyAddressField"	

@SamplesNA
@CreateSampleAndVerifyAddressField
@GCRM-10572 @GCRM-10571
@RegressionTestNA @RegressionTestSamplesNA
Scenario Outline: Validate that address populating when attempting to create a sample record and also verify the invalid country validation
	Given Runmode for "CreateSampleAndVerifyAddressField" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHE_Business_Operations>"
	Then create INTL sample and validate address
	And verify invalid country validation

	Examples:
	|MHE_Business_Operations|
	|Nisha_Bansal|