#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE User submit Vitalsource sample requests from SFDC

Background: 
	Given I am logged into salesforce for "MHHEVitalSource" 
	
	
@Samples
@MHHEVitalSource	@GCRM-2391
Scenario Outline: MHHEVitalSource

	Given Runmode for "MHHEVitalSource" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	And I change the app launcher to MHHE
	Then global search for contact
	Then click on sample contact button from menu
	Then search for product click on next for any ISBN
	Then select SFDC Status as approved
	And click on create sample order for copy
	Then copy sample name and verify sample status
	Then I logout of any user
#	Then Login as different US user
	Then I do login as "<System_Administrator>"
	And search copied sample
	Then delete sample

	Examples:
	|MHHE_Business_Administrator|System_Administrator|
	|Jaime_Klar|Sivasankaran_Periyasamy|