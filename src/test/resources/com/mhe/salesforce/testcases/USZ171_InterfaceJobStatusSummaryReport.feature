#DEPENDENT SCRIPT - This script is dependent on RunInformaticaInterfaceJobs & RunInformaticaInterfaceJobs scripts for running & getting the status of interface jobs.
Feature: Display the interface job status in table format 

@InformaticaInterface @InterfaceJobStatusSummaryReport @GCRM-20423
Scenario: Display the interface job status in table format 
  Given Runmode for "InterfaceJobStatusSummaryReport" is Y
	And create table and insert the job status