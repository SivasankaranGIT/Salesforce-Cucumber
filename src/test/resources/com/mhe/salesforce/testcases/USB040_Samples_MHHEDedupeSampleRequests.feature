#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: De-dupe sample requests.

Background: 
	Given I am logged into salesforce for "MHHEDedupeSample"	
	
@Samples @MHHEDedupeSample	@GCRM-9211
Scenario Outline: MHHEDedupeSample

	Given Runmode for "MHHEDedupeSample" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	When I navigate to contacts tab
	Then global search for contact
	Then click on sample contact button
	Then search for product click on next for any ISBN
	And click on create sample order for copy
	Then copy sample name
	Then click on sample contact button
	Then search for product click on next for any ISBN
	And verify duplicate sample message
	Then I logout of any user
#	Then Login as different US user
	Then I do login as "<System_Administrator>"
	And select copied sample from search
	Then delete sample	
	
	Examples: 
	|MHHE_Sales_Representative|System_Administrator|
	|Jenna_Taylor|Sivasankaran_Periyasamy|