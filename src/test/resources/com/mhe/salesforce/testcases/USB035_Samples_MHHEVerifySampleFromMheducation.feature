#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify a sample request from mheducation.com.

Background: 
Given I am logged into salesforce for "MHHESampFromMheEdu" 
	
	
@Samples
@MHHESampFromMheEdu	@GCRM-9207
Scenario Outline: MHHESampFromMheEdu

	Given Runmode for "MHHESampFromMheEdu" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	When I navigate to sample tab
	And choose shop list view
	Then select sample from results
	Then verify sample source

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|

