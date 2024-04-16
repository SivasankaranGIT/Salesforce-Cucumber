#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify new Account MHE Course records are created.

Background: 
	Given I am logged into salesforce for "MHHECreateAccountCourse" 
	
@OpportunitiesNonDependent
@MHHECreateAccountCourse @GCRM-8975
Scenario Outline: Verify new Account MHE Course records are created.
	Given Runmode for "MHHECreateAccountCourse" is Y 
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	When I navigate to opportunity tab
	Then I click on new
	And create opportunity
	Then verify Account course created
	And delete opportunity
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jenna_Taylor|