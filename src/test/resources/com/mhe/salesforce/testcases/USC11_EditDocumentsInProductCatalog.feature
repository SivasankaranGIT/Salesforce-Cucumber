#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Documents can be editted in Product Catalog.

Background:
Given I am logged into salesforce for "VerifyEditDocumentInProductCatalog"

@ProductCatalog
@VerifyEditDocumentInProductCatalog
@GCRM-9256 @GCRM-10454
Scenario Outline: Verify that Documents can be editted in Product Catalog.
 	Given Runmode for "VerifyEditDocumentInProductCatalog" is Y
#	Then I login as <UserURL>
	Then I do login as "<MHHE_Marketing>"
	When I click on the "productCatalogTab"
	Then I search product via <ProductISBN>
  And I click product title
	Then I click on Course tab in Documents section
	And Verify that the new page has Edit button present
Examples:
|ProductISBN|MHHE_Marketing|
|"9781264088225"|Kara_Allara|