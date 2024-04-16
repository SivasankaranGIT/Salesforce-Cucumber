#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the ALEKS Community Site does not have the entry point(Bot) available on the page.

  Background: 
    Given I am logged into salesforce for "ALEKSCommunityHasNoBOT"

  @Cases @ALEKSCommunityHasNoBOT @GCRM-8942
  Scenario Outline: ALEKSCommunityHasNoBOT
    Given Runmode for "ALEKSCommunityHasNoBOT" is Y
#    Then I login as Sales Rep
    Then I do login as "<ALEKS Administrator>"
    And  I change the app launcher to <app_Name>
    When I navigate to setup page
    Then I Quick search for all sites
    Then open ALEKS support page
    And verify BOT not present on homepage
	  Then I logout of any user
    Examples:
      |app_Name|ALEKS Administrator|
      |"ALEKS Lightning Console"|Isaac_Rubio|