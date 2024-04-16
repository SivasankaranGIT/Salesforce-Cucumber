#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify E2Cs for Aleks and CXG related email addresses are updated with Case Origin as 'Email'

  Background:
    Given I am logged into salesforce for "VerifyCasesForALEKSAndCXG"

  @E2C @E2C_VerifyCasesForALEKSAndCXG @GCRM-17203
  Scenario: Verify E2Cs for Aleks and CXG related email addresses are updated with Case Origin as 'Email'
  Given Runmode for "VerifyCasesForALEKSAndCXG" is Y
  Then send external email using backend and verify case created or not
  |cxg.cpcc@9-302zzeq6mcln44i1a6bp3x3tyedo1aij5lj2ff8nqjyktusbdr.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|CXG Case|Email2Case Daily|
  Then Verify the CXG case origin field
  Then send external email using backend and verify case created or not
  |mhe-ticket@1d0s7gxv3itkb1hs35nam5a6cggvn64l21jkia9uq05pwqfmm.o8-23cxfmaq.usa268s.case.sandbox.salesforce.com|ALEKS Case|Email2Case Daily|
  Then Verify the ALEKS case origin field