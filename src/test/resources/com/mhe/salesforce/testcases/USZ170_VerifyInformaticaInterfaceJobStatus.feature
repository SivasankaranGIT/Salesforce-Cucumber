#DEPENDENT SCRIPT - This script is dependent on RunInformaticaInterfaceJobs script for running the interface jobs.
Feature: Verify the Informatica interface jobs status

Background:
  Given Runmode for "VerifyInformaticaInterfaceJobStatus" is Y
  Then I navigate to My Services Home page
  Then I navigate to Data Integration module

@InformaticaInterface @VerifyInformaticaInterfaceJobStatus @GCRM-20423
Scenario Outline: Verify the Informatica interface jobs status
  And I navigate to My Jobs page and verify the "<Job>" status
  Examples:
	|Job|
	|II_Job1|
	|II_Job2|
	|II_Job3|
	|II_Job4|
	|II_Job5|