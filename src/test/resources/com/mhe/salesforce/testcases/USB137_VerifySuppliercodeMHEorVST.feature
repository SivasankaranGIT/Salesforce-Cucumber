#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Validate Asia eCommerce - dialog box with MHE or VST digital supplier

Background: 
	Given I am logged into salesforce for "VerifySuppliercodeMHEorVST" 

@OpportunitiesNonDependent_SKIP
@VerifySuppliercodeMHEorVST
@GCRM-12548 @GCRM-12549 @GCRM-7157
Scenario Outline: Validate Asia eCommerce - dialog box with MHE or VST digital supplier

	Given Runmode for "VerifySuppliercodeMHEorVST" is Y
#	Then I login as <SEG_Sales_Manager_Inside>
	Then I do login as "<MHE_Business_Operations>"
	Then navigate to an exiting opportunity
	And verify digital supplier code validation message with <validsuppliercode> code and <invalidsuppliercode> code
	Examples:
  |validsuppliercode|invalidsuppliercode|MHE_Business_Operations|
  |MHE|MHHE|Nisha_Bansal|