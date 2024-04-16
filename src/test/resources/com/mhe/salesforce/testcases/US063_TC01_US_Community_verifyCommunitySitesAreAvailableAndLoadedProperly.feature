#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the community sites are available and properly reflect the products or services for each customer service group.

Background: 
	Given I am logged into salesforce for "CommunitySitesLoad"

@Cases @TC01_US_Community_verifyCommunitySitesAreAvailableAndLoadedProperly @GCRM-9049
Scenario Outline: Verify that the community sites are available and properly reflect the products or services for each customer service group.
	Given Runmode for "CommunitySitesLoad" is Y
	Then I do login as "<System Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to setup page
	Then I Quick search for all sites
	Then get the ALEKS Support URL and verify page load
	Then get the CSOM URL and verify page load
	Then get the CXG URL and verify page load
	Then get the DTS URL and verify page load

Examples:
	|app_Name|System Administrator|
	|"CXG Lightning Console"|Sivasankaran_Periyasamy|
	
@Cases @VerifyINTLImplementationCustomerSuccessSiteFieldTypes @GCRM-27787
Scenario Outline: verify the form fields and their behavior are as per the requirement
	Given Runmode for "VerifyINTLImplementationCustomerSuccessSiteFieldTypes" is Y
	Then I do login as "<System Administrator>"
	And  I change the app launcher to <app_Name>
	When I navigate to setup page
	Then I Quick search for sites
	Then get the INTL Implementation Customer Success site URL and navigate
	And verify the form fields and their behavior 

Examples:
	|app_Name|System Administrator|
	|"MHHE"|Sivasankaran_Periyasamy|