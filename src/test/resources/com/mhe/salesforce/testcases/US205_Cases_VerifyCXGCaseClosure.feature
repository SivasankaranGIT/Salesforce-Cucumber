#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify Case closure for the Incidents ADA Accessibility, Software Installation, Product Improvement

  Background: 
    Given I am logged into salesforce for "VerifyCXGCaseClosure"

  @Cases @GCRM-5292 @VerifyCXGCaseClosure
  
  Scenario Outline: VerifyCXGCaseClosure  
    Given Runmode for "VerifyCXGCaseClosure" is Y
    Then I do login as "<CXG_Administrator>"
    And  I change the app launcher to <app_Name>
    When I search for CXG User contacts
    Then global search for contact
    Then click on New case by selecting one contact
    And fill all mandatory details to create CXG case
    Then click on close case button for CXG
    And fill mandatory fields to close CXG Case
    Then verify the status of closed CXG record

  Examples:
    |app_Name|CXG_Administrator|
    |"CXG Lightning Console"|Eric_Nelson|
