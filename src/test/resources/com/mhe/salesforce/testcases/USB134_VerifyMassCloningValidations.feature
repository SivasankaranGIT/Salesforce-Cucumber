#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: User should not be able to create duplicate Opportunities through mass Opportunity cloning process

Background: 
	Given I am logged into salesforce for "VerifyMassCloningValidations" 

@OpportunitiesNonDependent
@VerifyMassCloningValidations
@GCRM-7416 @GCRM-7417 @GCRM-15882 @GCRM-15888
@RegressionTest @RegressionTestOpportunities
Scenario Outline: User should not be able to create duplicate Opportunities through mass Opportunity cloning process
	Given Runmode for "VerifyMassCloningValidations" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	When I click sales Ref user details to navigate Sales
	Then I mass clone opportunity from opp list view
	And verify cloning already inprogress validation
	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|
	
@RegressionTest @RegressionTestOpportunities @OpportunitiesNonDependent @CreateAndUpdateMHHEOppCloneGrid @GCRM-15890 @GCRM-15895 @GCRM-15897 @GCRM-15899 @GCRM-15892
Scenario Outline: Create and update MHHE Opportunity Clone Grid Record
	Given Runmode for "CreateAndUpdateMHHEOppCloneGrid" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	Then I navigate to "<MHHE Opportunity Clone Grid>" tab
	When I create new MHHE Opportunity Clone Grid record
	Then I verify duplicate MHHE Opportunity Clone Grid record through Clone button
	Then I navigate to "<MHHE Opportunity Clone Grid>" tab
	Then I verify duplicate MHHE Opportunity Clone Grid record
	Then I edit the existing MHHE Opportunity Clone Grid record
	And I delete the MHHE Opportunity Clone Grid record
	Examples:
	|MHHE_Business_Administrator|MHHE Opportunity Clone Grid|
	|Jaime_Klar|MHHE Opportunity Clone Grid|