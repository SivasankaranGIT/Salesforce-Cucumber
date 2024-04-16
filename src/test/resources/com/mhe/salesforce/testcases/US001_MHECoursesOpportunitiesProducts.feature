#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the MHHE user in SFDC is able to view MHE Courses, link courses to opportunities, and search for products by course

Background: 
	Given I am logged into salesforce for "MHECoursesOpportunitiesProducts" 
	
@MHECourse
@MHECoursesOpportunitiesProducts @GCRM-9288
Scenario Outline: Verify that the MHHE user in SFDC is able to view MHE Courses, link courses to opportunities, and search for products by course
	Given Runmode for "MHECoursesOpportunitiesProducts" is Y 
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for MHECourse
	Then Verify MHE course related list
	Then global search for opportunities
	Then Link a MHE Course to the opportunity
	When Navigate to Product Catalog page
	When Search product via Course
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|