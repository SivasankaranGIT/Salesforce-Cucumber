#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Course Build/Connect Configuration button in MHHE Opportunity Record with MHHE Sales Rep user

Background: 
	Given I am logged into salesforce for "VerifyCourseBuildConnectConfigurationFields" 
	
@OpportunitiesNonDependent
@VerifyCourseBuildConnectConfigurationFields
@GCRM-15830 @GCRM-15833
Scenario Outline: Verify Course Build/Connect Configuration button in MHHE Opportunity Record with MHHE Sales Rep user

	Given Runmode for "VerifyCourseBuildConnectConfigurationFields" is Y
#	Then I login as <MHHE_Sales_Rep_AND_MHHE_BusinessAdmin_User>
	Then I do login as "<MHHE_Sales_Rep_AND_MHHE_BusinessAdmin_User>"
	And verify CourseBuildConfigurationRequest fields in <MHHEOppURL>
	Examples:
	|MHHE_Sales_Rep_AND_MHHE_BusinessAdmin_User|MHHEOppURL|
	|Danielle_Snyder|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FTnEfAAL/view"|
	|Jaime_Klar|"https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FTnEfAAL/view"|