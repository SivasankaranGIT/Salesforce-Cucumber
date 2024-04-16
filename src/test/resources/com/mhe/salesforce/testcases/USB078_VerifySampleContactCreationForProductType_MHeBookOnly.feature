#STAND_ALONE_SCRIPT - This script can be executed separately.
#In USB078,79&80 - On 30/8/22 we manually created a new address for US Customer to meet this specification as other addresses were having Oracle details filled in it.
Feature: While creating new sample contact validate when Product type is MHeBook and Address record has Oracle Info as Null then SFDC Status is 'Approved for MHeBook Submit' on the Sample record.

Background:
Given I am logged into salesforce for "validateSampleRecordStatusMHeBook"

@Samples
@VerifySampleStatusForProductTypeMHeBookOnly
@GCRM-2390
Scenario Outline: While creating new sample contact validate when Product type is MHeBook and Address record has Oracle Info as Null then SFDC Status is 'Approved for MHeBook Submit' on the Sample record.
	Given Runmode for "validateSampleRecordStatusMHeBook" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for contact
	Then add new sample contact and validate the SFDC status <ExpectedAddress>
	Examples:
	|ExpectedAddress|MHHE_Sales_Representative|
	|"1000 W COURT ST"|Jackie_Alvarado|