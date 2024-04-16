#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHES/SEG Opportunity contact is getting deleted automatically when the same contact is marked as inactive

Background: 
	Given I am logged into salesforce for "ValidateInActiveMHESOppContact" 
	
@OpportunitiesDependent
@ValidateInActiveMHESOppContact
@GCRM-10633
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that MHES/SEG Opportunity contact is getting deleted automatically when the same contact is marked as inactive

	Given Runmode for "ValidateInActiveMHESOppContact" is Y
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
	And deactivate the opportunity contact
	Then I logout of any user
#	Then I login as MHHE_National_Sales_Manager
	Then I do login as "<SEG_Sales_Rep>"
	Then navigate to an exiting opportunity
	And verify that the opportunity contact record got deleted or not
	Then I logout of any user
#	Then I login as Admin User
	Then I do login as "<System_Administrator>"
	And I change the app launcher to MHHE
	And activate the contact back

	Examples:
	|System_Administrator|SEG_Sales_Rep|
	|Sivasankaran_Periyasamy|Open_Baker|
