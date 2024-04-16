#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Customer service agents Contact creation, edit, linking to a case & account

Background: 
	Given I am logged into salesforce for "CreateEditLinkContactToCaseAndAccount" 
	
	
@Contacts @CreateEditLinkContactToCaseAndAccount @GCRM-9007
Scenario Outline: Customer service agents Contact creation, edit, linking to a case & account.

	Given Runmode for "CreateEditLinkContactToCaseAndAccount" is Y
#	Then I login as Sales Rep
	Then I do login as "<CXG_Administrator>"
	When I navigate to contacts tab
	And create new contact for Customer service agent
	Then I edit contact that is newly created
	Then I create a new case for the contact

	Examples:
	|CXG_Administrator|
	|Eric_Nelson|

