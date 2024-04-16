#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Case is created correctly for the respective Customer service team with the appropriate values defaulted

Background: 
	Given I am logged into salesforce for "CaseCreatedWithdefaultValues"

@Cases
@TC07_US_Community_VerifyCaseIsCreatedForRespectiveCustomerWithAppropriateValuesDefaulted @GCRM-9052
Scenario Outline: VerifyCaseIsCreatedForRespectiveCustomerWithAppropriateValuesDefaulted

	Given Runmode for "CaseCreatedWithdefaultValues" is Y 
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to chat transcript tab
	Then click on case details for the chat
	And verify default Case details

	Examples:
	|app_Name|System_Administrator|
	|"CSOM Lightning Console"|Sivasankaran_Periyasamy|