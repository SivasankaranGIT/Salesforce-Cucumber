#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View Product Courses For an Oppurtunity

Background: 
	Given I am logged into salesforce for "MHHERepAbleToViewCourses"	
	
@OpportunitiesNonDependent
@TS05_TC01_verifyThatMHHESalesRepIsAbleToViewCoursesAssignedToProductsForAnOpportunity	@GCRM-9286
Scenario Outline: TS05_TC01_verifyThatMHHESalesRepIsAbleToViewCoursesAssignedToProductsForAnOpportunity

	Given Runmode for "MHHERepAbleToViewCourses" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then Navigate to Products section
	And  click on Add or Edit button
	And  global search for product with ISBN
	Then click on product name 
	Then click on product course to verify products tied to course are displayed

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|