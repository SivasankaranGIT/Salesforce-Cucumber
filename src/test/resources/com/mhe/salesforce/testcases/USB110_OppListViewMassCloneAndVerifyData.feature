#DEPENDENT SCRIPT - This script is dependent on CloneOppAndVerifyData script for getting the Opportunity URL (selenium.MHHENewOppURLForSingleClone). 
Feature: Verify cloning multiple opportunities using the “Mass Clone“ button on Opportunity List View & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the Opportunity contact on cloned opportunity.

Background: 
	Given I am logged into salesforce for "OppListViewMassCloneAndVerifyData" 

@OpportunitiesDependent
@OppListViewMassCloneAndVerifyData
@GCRM-9328 @GCRM-8339 @GCRM-8588 @GCRM-15937 @GCRM-15929 @GCRM-15927 @GCRM-15915 @GCRM-15917 @GCRM-15920 @GCRM-16020
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify cloning multiple opportunities using the “Mass Clone“ button on Opportunity List View & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the Opportunity contact on cloned opportunity.

	Given Runmode for "OppListViewMassCloneAndVerifyData" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then navigate to an exiting opportunity
	Then navigate to opportunity contact
	Then edit Handoff Required field
	Then edit Lead and Lead Submitted On field
	Then I navigate to opportunity tab
	Then I mass clone opportunity in opp list view
	And verify the Handoff Required and Lead field in both opportunity contact
	And verify source opp link in new opp and new opp link in source opp
	And verify the Product and Contact details in newly cloned opportunities

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|