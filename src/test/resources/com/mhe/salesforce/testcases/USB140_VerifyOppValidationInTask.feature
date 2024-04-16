#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: verify that opportunity should not be blank on task which marked completed with 'Qualified' reason and Task_Source__c is 'Marketo'

Background: 
	Given I am logged into salesforce for "VerifyOppValidationInTask" 

@OpportunitiesNonDependent
@VerifyOppValidationInTask
@GCRM-13147
Scenario Outline: verify that opportunity should not be blank on task which marked completed with 'Qualified' reason and Task_Source__c is 'Marketo'

	Given Runmode for "VerifyOppValidationInTask" is Y
#	Then I login as <MHES Admin>
	Then I do login as "<SEG_Business_Admin>"
	And Verify the opportunity validation message
	Examples:
	|SEG_Business_Admin|
	|Ivan_Gomez|