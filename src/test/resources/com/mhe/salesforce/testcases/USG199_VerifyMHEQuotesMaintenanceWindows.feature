#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created_By: Siva

Feature: Verify MHE Quotes Maintenance Windows

Background: Given I am logged into salesforce for "VerifyMHEQuotesMaintenanceWindows"
	
@Quote @VerifyMHEQuotesMaintenanceWindows @GCRM-15925
Scenario Outline: Verify MHE Quotes Maintenance Windows

	Given Runmode for "VerifyMHEQuotesMaintenanceWindows" is Y
	Then I do login as "<System_Admin>"
	Then I navigate to Sales Home page
	Then navigate to MHE Quotes Admin tab
	Then update under maintenance field
	Then verify site under maintenance message
	Then navigate to MHE Quotes Admin tab
	Then update under maintenance field
Examples:
	|System_Admin|
	|Sivasankaran_Periyasamy|