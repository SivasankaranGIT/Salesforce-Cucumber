#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Ship to Org ID Is Updated In Header Record As Per New Web Product Line

Background: 
	Given I am logged into salesforce for "VerifyShipToOrg" 
	
	
@Cases @VerifyShipToOrg @GCRM-3395
Scenario Outline: VerifyShipToOrg

	Given Runmode for "VerifyShipToOrg" is Y
#  Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to setup page
	 Then I Quick search for the Case
	 When I Click on email to case
	 Then I verify ship to org

	Examples:
		|app_Name|System_Administrator|
		|"ALEKS Lightning Console"|Sivasankaran_Periyasamy|
  
	