#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that user can track samples using the Tracking URL field located on the Sample record.

  Background: 
    Given I am logged into salesforce for "MHHETrackSample"

  @Samples @MHHETrackSample @GCRM-9243
  Scenario Outline: MHHETrackSample
    Given Runmode for "MHHETrackSample" is Y
#    Then I login as Sales Rep
    Then I do login as "<MHHE_Sales_Representative>"
    When I navigate to sample tab
    And choose shipped list view
    Then select sample from results
    Then click tracking URL
    And verify tracking details
    
    Examples: 
    |MHHE_Sales_Representative|
    |Danielle_Snyder|
