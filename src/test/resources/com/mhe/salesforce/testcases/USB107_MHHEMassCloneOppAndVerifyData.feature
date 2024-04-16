Feature: Verify cloning multiple opportunities using the “MHHE Mass Opportunity Cloning“ tab & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the cloned opportunity.

Background: 
	Given I am logged into salesforce for "MHHEMassCloneOppAndVerifyData" 

@MHHEMassCloneOppAndVerifyData
@GCRM-9331 @GCRM-15829 @GCRM-15938 @GCRM-16022
Scenario Outline: Verify cloning multiple opportunities using the “MHHE Mass Opportunity Cloning“ tab & checking whether the same details present in Opportunity Contact field “Handoff Required” is flown to the cloned opportunity.

	Given Runmode for "MHHEMassCloneOppAndVerifyData" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	Then global search for opportunities
	Then navigate to opportunity contact
	Then edit Handoff Required field
	Then I navigate to MHHE Mass Opportunity Cloning page
	And I mass clone opportunity
#	And verify the Handoff Required field in both opportunity contact

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|