#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the targeted product field is updated in the related Opportunity orders when the opportunity year is greater than current year

Background: 
	Given I am logged into salesforce for "VerifyTPFieldForFutureYearOpp" 

@OpportunitiesDependent
@VerifyTPFieldForFutureYearOpp
@GCRM-10449
@RegressionTest @RegressionTestOpportunities
Scenario Outline: Verify the targeted product field is updated in the related Opportunity orders when the opportunity year is greater than current year

	Given Runmode for "VerifyTPFieldForFutureYearOpp" is Y
#	Then I login as <MHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	When I click sales Ref user details to navigate Sales
	Then MHHE Business Admin create new MHHE type opportunity
#	Then navigate to an exiting opportunity
#	Then delete opp order line
#	Then delete opp line item
#	Then update opp year to future year
	Then I logout of any user
	Then create order line and add opportunity order to it
#	Then I login as <MHHEBusinessAdminUserURL>
	Then I do login as "<MHHE_Business_Administrator>"
	Then add targeted products to MHHE opportunity
	And Verify Order Targeted Products field in opportunity

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|
