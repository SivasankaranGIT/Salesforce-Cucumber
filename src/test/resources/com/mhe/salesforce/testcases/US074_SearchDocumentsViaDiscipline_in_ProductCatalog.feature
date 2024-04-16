#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search documents via Discipline in product catalog

Background: 
	Given I am logged into salesforce for "SearchDocsViaDisciplineUS" 
	
@ProductCatalog
@SmokeTest	
@MHHEBusinessAdminSearchDocumentsViaDiscipline @GCRM-9001
Scenario Outline: MHHE Business admin search documents via Discipline in product catalog

	Given Runmode for "SearchDocsViaDisciplineUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via Discipline
	Then Verify documents present under all categories
	Then I logout of any user
	
	Examples: 
	|MHHE_Business_Administrator|
	|Jaime_Klar|