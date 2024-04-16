#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: buildConnectConfigurationRequest

Background: 
	Given I am logged into salesforce for "buildConnectConfigurationRequest" 
	
@OpportunitiesNonDependent
@buildConnectConfigurationRequest
@GCRM-9216 @GCRM-8241 @GCRM-16890
Scenario Outline: buildConnectConfigurationRequest

	Given Runmode for "buildConnectConfigurationRequest" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	And Build ConnectConfiguration Reques

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|