#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that a MHHE Buisness Admin can sort sequence on course in Product Catalog.

Background: 
	Given I am logged into salesforce for "SortSequenceOnCourse" 
	
	
@ProductCatalog
@SortSequenceOnCourse	@GCRM-9005
Scenario Outline: Verify that a MHHE Buisness Admin can sort sequence on course in Product Catalog.

	Given Runmode for "SortSequenceOnCourse" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	Then I change the app launcher to MHHE
	Then Select course and change sort sequence as <MHECourseURL>
	When I click on the "productCatalogTab"
	And Check sequence in product catalog
	Then Select course and change sort sequence as <MHECourseURL>
	When I click on the "productCatalogTab"
	And Check sequence in product catalog
	Examples:
	|MHECourseURL|	MHHE_Business_Administrator|
	|"https://mh--uat.sandbox.lightning.force.com/lightning/r/MHE_Course__c/a0U80000002MbrAEAS/view"|Jaime_Klar|