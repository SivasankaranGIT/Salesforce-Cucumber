#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Approve a sample request. Deny a sample request.

Background: 
Given I am logged into salesforce for "MHHEApproveDenySample" 
	
	
@Samples
@MHHEApproveDenySample	@GCRM-9235
Scenario Outline: MHHEApproveDenySample

	Given Runmode for "MHHEApproveDenySample" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to Sales Home page
	And I select sample from recently view sample list
	And approve sample
	Then deny sample
	Then verify edited sample details

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|