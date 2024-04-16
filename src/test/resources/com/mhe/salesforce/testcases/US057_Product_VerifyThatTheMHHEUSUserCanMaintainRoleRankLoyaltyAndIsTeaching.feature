#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatTheMHHEUSUserCanMaintainRoleRankLoyaltyAndIsTeaching

Background: 
	Given I am logged into salesforce for "RoleRankLoyaltyAndIsTeaching" 	
	
@OpportunitiesNonDependent
@US1_TC01_US_Product_VerifyThatTheMHHEUSUserCanMaintainRoleRankLoyaltyAndIsTeaching @GCRM-9277
Scenario Outline: VerifyThatTheMHHEUSUserCanMaintainRoleRankLoyaltyAndIsTeaching

	Given Runmode for "RoleRankLoyaltyAndIsTeaching" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
  When I click sales Ref user details to navigate Sales
  Then global search for opportunities
	And Edit Opportunity Contact for Role Rank Loyalt and Is Teaching

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|