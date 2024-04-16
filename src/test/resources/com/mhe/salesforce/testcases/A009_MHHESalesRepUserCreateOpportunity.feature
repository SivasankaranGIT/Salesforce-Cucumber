#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: MHHE Sales Rep User create new opportunity

Background: 
	Given I am logged into salesforce for "MHHESalesRepUserCreateNewOpp"	
	
@OpportunitiesDependent
@MHHESalesRepUserCreateNewOpp
@GCRM-10133 @GCRM-24219 @GCRM-16011
@RegressionTest @RegressionTestOpportunities
Scenario Outline: MHHE Sales Rep User create new opportunity

	Given Runmode for "MHHESalesRepUserCreateNewOpp" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	Then I navigate to opportunity tab
	Then I create new opportunity
	Then I logout of any user
	And I change the app launcher to MHHE
	And verify the access for SEP Asset Send objects on the opportunity for system and super admins
	And verify the access for SEP Asset Session objects on the opportunity for system and super admins
	Then I do login as "<MHHE_Business_Administrator>"
	And verify access for SEP Asset Send and SEP Asset Session objects on the opportunity for MHHE Business Admin
Examples:
	|MHHE_Sales_Representative|MHHE_Business_Administrator|
	|Jackie_Alvarado|Jaime_Klar|