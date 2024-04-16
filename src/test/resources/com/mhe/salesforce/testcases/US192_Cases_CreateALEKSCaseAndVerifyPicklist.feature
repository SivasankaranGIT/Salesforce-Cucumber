#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Addition of Sub Reasons picklist values for the respective Reason value

Background: 
	Given I am logged into salesforce for "CreateALEKSCaseAndVerifyPicklist"
	
@Cases @CreateALEKSCaseAndVerifyPicklist @GCRM-2297 @GCRM-2298 @GCRM-2306 @GCRM-24677
Scenario Outline: Addition of Sub Reasons picklist values for the respective Reason value

	Given Runmode for "CreateALEKSCaseAndVerifyPicklist" is Y
#	Then I login as Sales Rep
	Then I do login as "<ALEKS_Administrator>"
	And  I change the app launcher to <app_Name>
	And I navigate to cases page 
	And fill all mandatory details to create new ALEKS case
	Then I will edit the required fields to verify Picklist
	And verify the PnM and Version field removal
	Then I logout of any user
	Then I do login as "<ALEKS_CSR>"
	And verify the PnM and Version field removal
	Examples:
		|app_Name|ALEKS_Administrator|ALEKS_CSR|
		|"ALEKS Lightning Console"|Isaac_Rubio|James_Galvez|