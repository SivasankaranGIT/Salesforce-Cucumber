#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify that Status Date Blanks out on SEG Opportunities when Probability Group is Updated as: Stated Need/Pilot/Qualified/Presentation/Quote

Background: 
	Given I am logged into salesforce for "VerifyStatusDateinSEGOpp" 
	
@OpportunitiesDependent
@SmokeTest
@VerifyStatusDateinSEGOpp @GCRM-15705
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify that Status Date Blanks out on SEG Opportunities when Probability Group is Updated as: Stated Need/Pilot/Qualified/Presentation/Quote

	Given Runmode for "VerifyStatusDateinSEGOpp" is Y
	Then I do login as "<SEG_Sales_Rep>"
	Then I navigate to opportunity tab
	Then SEG Sales Rep user creates new opportunity
	Then I logout of any user
	Then I do login as "<SEG_Business_Admin>"
	Then I change the app launcher to "<MHES_Lightning_Console>"
	And verify Status Date field value
	Then I logout of any user
Examples:
	|SEG_Sales_Rep|SEG_Business_Admin|MHES_Lightning_Console|
	|Open_Baker|Ivan_Gomez|MHES Lightning Console|