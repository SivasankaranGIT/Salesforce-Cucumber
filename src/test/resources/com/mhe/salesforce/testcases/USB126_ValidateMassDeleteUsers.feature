#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate that mass delete all users from MHHE Opportunity Cloning Users list view

Background: 
	Given I am logged into salesforce for "ValidateMassDeleteUsers" 

@OpportunitiesNonDependent
@ValidateMassDeleteUsers
@GCRM-10601 @GCRM-15922
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Validate that mass delete all users from MHHE Opportunity Cloning Users list view

Given Runmode for "ValidateMassDeleteUsers" is Y
Then I logout of any user
Then I navigate to MHHE Opportunity Cloning Users page
Then Create New MHHE Opportunity Cloning <User1>
Then I navigate to MHHE Opportunity Cloning Users page
Then Create New MHHE Opportunity Cloning <User2>
Then I navigate to MHHE Opportunity Cloning Users page
And mass delete all users from MHHE Opp Cloning Users list view

Examples:
|User1|User2|
|"Jackie Heron"|"Ken Chu"|


#STAND_ALONE_SCRIPT - This script can be executed separately.
# Created By: Ramkaran Singh
@OpportunitiesNonDependent
@VerifyOppCloningEdit @GCRM-15924
Scenario Outline: Edit MHHE Opportunity Cloning Users record
Given Runmode for "VerifyOppCloningEdit" is Y
Then I do login as "<MHHE_Business_Admin>"
Then I change the app launcher to "<MHHE>"
Then I navigate to MHHE Opportunity Cloning Users page
Then Create New MHHE Opportunity Cloning <User>
Then I edit the created MHHE Opportunity cloning

Examples:
|MHHE|MHHE_Business_Admin|User|
|MHHE|Jaime_Klar|"Jackie Heron"|









