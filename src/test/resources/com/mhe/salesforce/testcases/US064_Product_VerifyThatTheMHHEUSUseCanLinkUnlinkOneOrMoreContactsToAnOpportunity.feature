#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Product_VerifyThatTheMHHEUSUseCanLinkUnlinkOneOrMoreContactsToAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHELinkUnlinkContacts" 	
	
@OpportunitiesNonDependent
@TC01_US_Product_VerifyThatTheMHHEUSUseCanLinkUnlinkOneOrMoreContactsToAnOpportunity @GCRM-9278
Scenario Outline: Product_VerifyThatTheMHHEUSUseCanLinkUnlinkOneOrMoreContactsToAnOpportunity

	Given Runmode for "MHHELinkUnlinkContacts" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When User to search and do Opportunity related validation
	And I Add Edit contact from opportunity page

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|