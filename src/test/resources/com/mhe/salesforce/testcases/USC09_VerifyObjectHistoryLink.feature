#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Object History related list is removed from all the page layouts of Account, Contacts, Opportunities & Samples.

Background:
Given I am logged into salesforce for "validateObjectHistoryLinkRemovedOrNot"

@Samples
@VerifyObjectHistoryLink
@GCRM-2733
Scenario Outline: Verify Object History related list is removed from all the page layouts of Account, Contacts, Opportunities & Samples.
	Given Runmode for "validateObjectHistoryLinkRemovedOrNot" is Y
#	Then I login as Sales Rep
	Then I do login as "<Sales_Rep_Lightning>"
	And verify object history link

	Examples:
	|Sales_Rep_Lightning|
	|Nick_Achelles|
	