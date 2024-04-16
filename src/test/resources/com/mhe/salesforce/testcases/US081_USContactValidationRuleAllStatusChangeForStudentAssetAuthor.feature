#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: USContactValidationRuleAllStatusChangeForStudentAssetAuthor

Background: 
	Given I am logged into salesforce for "USContactValidationRule" 
	
	
@Contacts @TC16_USContactValidationRuleAllStatusChangeForStudentAssetAuthor @GCRM-9090
Scenario Outline: USContactValidationRuleAllStatusChangeForStudentAssetAuthor

	Given Runmode for "USContactValidationRule" is Y
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	When I click Admin user Contacts to create new contact
	And I enter and save all the Contact details 
	Then Validate error message

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|

