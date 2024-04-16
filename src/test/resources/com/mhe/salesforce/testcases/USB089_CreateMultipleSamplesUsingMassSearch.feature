#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the user is successfully able to create multiple samples using "Mass Search"

Background:
Given I am logged into salesforce for "validateMultipleSampleCreation"

@Samples @validateMultipleSampleCreationUsingMassSearch @GCRM-7668
Scenario Outline: Verify that the user is successfully able to create multiple samples using "Mass Search"
	Given Runmode for "validateMultipleSampleCreation" is Y
	Then I do login as "<SEG_Sales_Operations>"
	And switch to classic user interface
	Then navigate to mass search screen
	And create multiple samples

Examples:
	|SEG_Sales_Operations|
	|Angela_King|