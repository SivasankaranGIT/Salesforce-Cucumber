#STAND_ALONE_SCRIPT - This script can be executed separately. But it is a pre requisite for few other scripts.
Feature: Verify the targeted product field is not updated in the related Opportunity orders when the opportunity year is less than current year

Background: 
	Given I am logged into salesforce for "VerifyTPFieldForPastYearOpp" 

@OpportunitiesDependent
@VerifyTPFieldForPastYearOpp
@GCRM-10399 @GCRM-15724
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the targeted product field is not updated in the related Opportunity orders when the opportunity year is less than current year

	Given Runmode for "VerifyTPFieldForPastYearOpp" is Y
	Then I do login as "<MHHE_Business_Administrator>"
#	Then navigate to an exiting opportunity
	When I click sales Ref user details to navigate Sales
	Then MHHE Business Admin create new MHHE type opportunity
#	Then delete opp order line
#	Then delete opp line item
#	Then update opp year to past year
	Then I logout of any user
	Then create order line and add opportunity order to it
	Then I do login as "<MHHE_Business_Administrator>"
	Then add targeted products to MHHE opportunity
	And Verify Order Targeted Products field in opportunity

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|