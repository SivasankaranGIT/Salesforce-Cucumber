#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: ValidationRuleALL_Reason_for_Inactive_contacts

Background: 
	Given I am logged into salesforce for "ValidationRuleInactiveCont" 
	
	
@Contacts
@TC17_US_Contact_ValidationRuleALL_Reason_for_Inactive_contacts @GCRM-9008
Scenario Outline: ValidationRuleALL_Reason_for_Inactive_contacts

	Given Runmode for "ValidationRuleInactiveCont" is Y
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	When I click Admin user Contacts to create new contact
	And I enter and save all the Contact details Inactive

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|