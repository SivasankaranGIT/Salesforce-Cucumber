#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: As an MHHE Sales Rep create an LS project.

Background: 
	Given I am logged into salesforce for "CreateLSProject" 	
	
@Opportunities_SKIP
@CreateLSProject @GCRM-8973
Scenario Outline: As an MHHE Sales Rep create an LS project.

	Given Runmode for "CreateLSProject" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user details to navigate Sales
	Then global search for opportunities
	And create LS Project
	Then I logout of any user
#	And Login as different US user
	Then I do login as "<System_Administrator>"
	Then delete LS Project

	Examples:
	|MHHE_Sales_Representative|System_Administrator|
	|Danielle_Snyder|Sivasankaran_Periyasamy|

