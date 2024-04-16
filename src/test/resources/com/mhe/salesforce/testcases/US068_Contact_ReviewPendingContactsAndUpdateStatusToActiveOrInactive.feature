#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: ReviewPendingContactsAndUpdateStatusToActiveOrInactive

Background: 
	Given I am logged into salesforce for "UpdatePendingContactsStatus" 
	
	
@Contacts
@TC05_US_Contact_ReviewPendingContactsAndUpdateStatusToActiveOrInactive @GCRM-9014 @GCRM-9013
Scenario Outline: ReviewPendingContactsAndUpdateStatusToActiveOrInactive

	Given Runmode for "UpdatePendingContactsStatus" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	And Account Name click proceed and contacts Edit contact from pending to Active Inactive

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|