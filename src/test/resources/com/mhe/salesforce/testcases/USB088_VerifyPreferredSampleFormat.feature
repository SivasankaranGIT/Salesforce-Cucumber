#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the data in the field "Preferred Sample format" is flown from Contact record to Opportunity Contact record

Background:
Given I am logged into salesforce for "validatePreferredSampleFormat"

@Samples @validatePreferredSampleFormat @GCRM-5435
Scenario Outline: Verify the data in the field "Preferred Sample format" is flown from Contact record to Opportunity Contact record
	Given Runmode for "validatePreferredSampleFormat" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	Then global search for opportunities
	Then navigate to opportunity contact
	And add new opp contact if not exist <Contact First Name>
	And edit the Preferred Sample Format field in contact
	And verify the Preferred Sample Format field in opportunity contact
Examples:
	|Contact First Name|MHHE_Business_Administrator|
	|"JAIME"|Jaime_Klar|