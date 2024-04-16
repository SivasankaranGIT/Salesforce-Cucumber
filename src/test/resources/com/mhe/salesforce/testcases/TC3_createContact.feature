Feature: Contact Creation 

Background: 
	Given I am logged into salesforce for "VerifyInlineEditingInReports" 

#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent @VerifyInlineEditingInReports @GCRM-26387
Scenario Outline: Verify Inline editing on report for cases is changing the case owner to Unassigned
Given Runmode for "VerifyInlineEditingInReports" is Y
Then I do login as "<CXG_Administrator>"
Then I navigate to "<Reports>" tab
Then I create a new report
Then I verify the created report

Examples:
|CXG_Administrator|Reports|
|Eric_Nelson	  |Reports|

