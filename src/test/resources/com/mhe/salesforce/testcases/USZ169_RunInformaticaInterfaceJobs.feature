#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Execute the Informatica interface jobs through Selenium automation script

@InformaticaInterface @RunInformaticaInterfaceJobs @GCRM-20423
Scenario: Execute the Informatica interface jobs through Selenium automation script
  Given Runmode for "RunInformaticaInterfaceJobs" is Y
  Then I navigate to My Services Home page
  Then I navigate to Data Integration module

@InformaticaInterface @RunInformaticaInterfaceJobs @GCRM-20423
Scenario Outline: Execute the Informatica interface jobs through Selenium automation script
  Then I navigate to Explore page
  When I search for a particular "<Job>" and start it
  Examples:
	|Job|
	|II_Job1|
	|II_Job2|
	|II_Job3|
	|II_Job4|
	|II_Job5|