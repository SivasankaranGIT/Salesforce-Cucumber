#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Samples created users other than sales reps will have a Pending Approval status

Background: 
Given I am logged into salesforce for "SampleStatusOtherThanSalesRep"	
	
@Samples
@US_TC22_Sample_VerifySamplesCreatedUsersOtherThanSalesRepWillHavePendingApprovalStatus	@GCRM-9077
Scenario Outline: VerifySamplesCreatedUsersOtherThanSalesRepWillHavePendingApprovalStatus

	Given Runmode for "SampleStatusOtherThanSalesRep" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Implementation_Team>"
	And I change the app launcher to MHHE
	Then click on sample contact button from menu
	Then search for product click on next for any ISBN
	Then click on create sample order for product
	Then verify SFDC Status on sample record

	Examples:
	|MHHE_Implementation_Team|
	|Jordan_Allen|