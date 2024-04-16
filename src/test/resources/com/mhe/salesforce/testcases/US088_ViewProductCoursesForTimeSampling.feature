#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View Product Courses Time Sampling

Background: 
	Given I am logged into salesforce for "ViewProductCoursesForTimeSampling"	

@Samples
@viewProductCourseSampling	@GCRM-9285
@RegressionTest @RegressionTestSamples
Scenario Outline: View Product Courses Time Sampling

	Given Runmode for "ViewProductCoursesForTimeSampling" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to Contacts page
	Then global search for contact
	And click Sample contact button and search for MHE Course
	Then fetch ISBN number and search for product
	And click on Product course related list

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|