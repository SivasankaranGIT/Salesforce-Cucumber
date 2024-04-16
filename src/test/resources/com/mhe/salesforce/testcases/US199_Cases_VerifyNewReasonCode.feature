#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the New Reason Code Sales Rep Referral is added when the call type is Misdirected Inquires for MHSE Sales Operations record type

Background: 
	Given I am logged into salesforce for "VerifyNewReasonCode" 
	
	
@Cases @VerifyNewReasonCode @GCRM-3491 @GCRM-3483
Scenario Outline: VerifyNewReasonCode

	Given Runmode for "VerifyNewReasonCode" is Y
#  	Then I login as Sales Rep
	Then I do login as "<ALEKS_Administrator>"
	And  I change the app launcher to <app_Name>
	And I navigate to cases page 
	And fill all mandatory details to create new case with reason code

	Examples:
	|app_Name|ALEKS_Administrator|
	|"ALEKS Lightning Console"|Isaac_Rubio|