#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that user is able to create a sample request through SEG site.

Background: 
	Given I am logged into salesforce for "SampleRequest_SEGsite"	

@Samples
@VerifythatuserisabletocreateasamplerequestthroughSEGsite	@GCRM-9268
@RegressionTest @RegressionTestSamples
Scenario Outline:  VerifythatuserisabletocreateasamplerequestthroughSEGsite

	Given Runmode for "SampleRequest_SEGsite" is Y
#	And I login as Admin User
	And I do login as "<SEG_Business_Admin>"
	Then I navigate to Campaigns tab
	And I create new SEG campaign
	Then click on campaign product list and enter product
	Then Go to segSiteUrl and submit

	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|