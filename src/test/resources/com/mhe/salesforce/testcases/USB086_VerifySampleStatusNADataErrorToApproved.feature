#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that Sample status should be changed to Approved from NA data error if ship usage ID is Updated

Background:
Given I am logged into salesforce for "validateSampleStatusBasedOnShipUsageID"

@Samples
@verifySampleStatusApprovedAndNADataError
@GCRM-5390 @GCRM-5391 @GCRM-5392 @GCRM-6319
Scenario Outline: Validate that Sample status should be changed to Approved from NA data error if ship usage ID is Updated
	Given Runmode for "validateSampleStatusBasedOnShipUsageID" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	Then remove the ship usage id in address
	Then I logout of any user
#	And Login as different US user
	Then I do login as "<MHE_Business_Operations>"
	#Here we use INTL User to created INTL Sample and not US user.
	Then validate the SFDC status when ship usage ID is null for <ISBN>
	And validate the sample contact status
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	Then add the ship usage id back in address
	And validate the SFDC status after adding ship usage ID to address	
	Examples:
	|ISBN|System_Administrator|MHE_Business_Operations|
	|"9781265364472"|Sivasankaran_Periyasamy|Nisha_Bansal|