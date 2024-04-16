#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify cloning a single opportunity using the “Clone“ button on Opportunity record & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the cloned opportunity.

Background: 
	Given I am logged into salesforce for "CloneOppAndVerifyData" 
	
@OpportunitiesDependent
@CloneOppAndVerifyData
@GCRM-8977 @GCRM-9358 @GCRM-8338 @GCRM-8587 @GCRM-15832 @GCRM-16666 @GCRM-16019
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify cloning a single opportunity using the “Clone“ button on Opportunity record & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the cloned opportunity.

	Given Runmode for "CloneOppAndVerifyData" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	And I switch to MHHE home page
	Then I navigate to opportunity tab
	Then I create new opportunity
	And add opportunity contact
  	And add opportunity product
	Then navigate to opportunity contact
	Then edit Handoff Required field
	Then edit Lead and Lead Submitted On field
	And I Clone from opportunity page
	And verify the Handoff Required and Lead field in both opportunity contact
	And verify source opp link in new opp and new opp link in source opp
	And verify the Product and Contact details in newly cloned opportunities
	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|