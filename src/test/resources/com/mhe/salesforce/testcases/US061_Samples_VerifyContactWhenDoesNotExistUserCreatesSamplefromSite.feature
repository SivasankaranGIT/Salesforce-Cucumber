#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that when a user whose email address does not exist in SFDC creates a sample from site page then a new contact gets created and the newly created samples are listed on the contact.

Background: 
	Given I am logged into salesforce for "DoesNotExistUserCreateContact"

@Samples
@Samples_VerifyContactWhenDoesNotExistUserCreatesSamplefromSite @GCRM-9061
Scenario Outline: DoesNotExistUserCreateContact
	Given Runmode for "DoesNotExistUserCreateContact" is Y 
	Then I logout of any user
#	Then I do login as "<Super_Admin>"
	Then I navigate to Sales Home page
	Then global search for campaign
	Then click on SEG Site URL
	Then I enter the details for user doesnot exist
	And I close the SEG site
	Then verify contact record on campaign members section
	And verify navigation on clicking first name and contact

	Examples:
	|Super_Admin|
	|Lovenish_Saluja|