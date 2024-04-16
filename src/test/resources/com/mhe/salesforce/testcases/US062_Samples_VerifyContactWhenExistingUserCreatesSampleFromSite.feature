#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that sample gets listed on Contact when an existing user (user with email address and account) creates a sample from the SITE

Background: 
	Given I am logged into salesforce for "ExistingUserCreatesSample"

@Samples
@Samples_VerifyContactWhenExistingUserCreatesSampleFromSite @GCRM-9060
Scenario Outline: Samples_VerifyContactWhenExistingUserCreatesSampleFromSite

	Given Runmode for "ExistingUserCreatesSample" is Y 
#	Then I do login as "<Super_Admin>"
	Then global search for campaign
	Then click on SEG Site URL 
	Then I enter the details 
	And I close the SEG site
	Then verify contact record on campaign members section for existing user
	And verify navigation on clicking first name and contact

	Examples:
	|Super_Admin|
	|Lovenish_Saluja|