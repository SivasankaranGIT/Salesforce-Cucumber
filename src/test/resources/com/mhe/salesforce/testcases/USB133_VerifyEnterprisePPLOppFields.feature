#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user is able to see only specific values in the field "Types" & "Stages" on the Opportunity having the record type = Enterprise PPL Opportunity.

Background: 
	Given I am logged into salesforce for "VerifyEnterprisePPLOppFields" 

@OpportunitiesNonDependent
@VerifyEnterprisePPLOppFields
@GCRM-11552 @GCRM-15861 @GCRM-15863 @GCRM-15866 @GCRM-15870 @CRM-15872 @GCRM-15855 @GCRM-15858 @GCRM-15877 @GCRM-15875 @GCRM-15873
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that the user is able to see only specific values in the field "Types" & "Stages" on the Opportunity having the record type = Enterprise PPL Opportunity.

	Given Runmode for "VerifyEnterprisePPLOppFields" is Y
	Then I do login as "<MHHE_Business_Administrator>"
	When I click sales Ref user details to navigate Sales
	Then create Enterprise PPL type opportunity and verify types and stage fields
	And verify Annual Revenue and Annual Enrollment fields
	And edit Enterprise PPL type opportunity and verify types and stage fields
	And verify stage picklist when closing opportunity
	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|  