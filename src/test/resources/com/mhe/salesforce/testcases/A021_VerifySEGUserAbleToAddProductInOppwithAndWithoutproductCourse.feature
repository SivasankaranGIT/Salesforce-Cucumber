#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the SEG users are able to add Products to an opportunity with and without Product Course

  Background:
    Given I am logged into salesforce for " VerifySEGUserAbleToAddProductInOppwithAndWithoutproductCourse"

  @OpportunitiesNonDependent @VerifySEGUserAbleToAddProductInOpp @GCRM-17172 @GCRM-17167
  Scenario Outline: Verify the SEG users are able to add Products to an opportunity with and without Product Course

    Given Runmode for "VerifySEGUserAbleToAddProductInOppwithAndWithoutproductCourse" is Y
    Then I do login as "<SEG_SALES_REP>"
    And  I change the app launcher to <MHES_Lightning_Console>
    Then I navigate to opportunity tab
    Then I create a new opportunity for SEG Sales
    Then Go to Products related list and click on Modify Product button
    Then Provide the ISBN in the key ISBN text box and click on Add button
    And Verify that the product is successfully added to the opportunity

    Examples:
      |SEG_SALES_REP|MHES_Lightning_Console|
      |Open_Baker|MHES Lightning Console|