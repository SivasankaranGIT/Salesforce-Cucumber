#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search documents via Course in product catalog

Background: 
	Given I am logged into salesforce for "SearchDocsViaCourseUS" 
	
@ProductCatalog
@SmokeTest	
@MHHEBusinessAdminSearchDocumentsViaCourse @GCRM-9000
Scenario Outline: MHHE Business admin search documents via Course in product catalog

	Given Runmode for "SearchDocsViaCourseUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search document via Course
	Then Verify documents present under all four categories
	
	Examples: 
	|MHHE_Business_Administrator|
	|Jaime_Klar|