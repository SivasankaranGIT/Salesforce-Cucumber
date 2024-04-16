Feature: Delete opp records created by automation scripts

Background: Given I am logged into salesforce for "DeleteOpportunitiesCreatedByScript" 

@OpportunitiesDependent @DeleteOpportunitiesCreatedByScript
Scenario: Verify the system admin user can delete the automation script created opportunities
	Given Runmode for "DeleteOpportunitiesCreatedByScript" is Y
	Then I logout of any user
	And I change the app launcher to MHHE

#This is continuation of above scenario, just splitting it to avoid the repeat execution of logout and change app luncher steps
@OpportunitiesDependent @DeleteOpportunitiesCreatedByScript
Scenario Outline: Verify the system admin user can delete the automation script created opportunities
	Given Runmode for "DeleteOpportunitiesCreatedByScript" is Y
  And delete the <opportunities> which are created by scripts
  Examples:
  |opportunities|
  |"SAN ANTONIO COLLEGE General Middle School Methods"|
  |"OK-Yukon Public Schools-ELEMENTARY: ASG - LITERACY-Open"|
  |"OK-Lawton Public Schools-ELEMENTARY: ASG - LITERACY-Open"|
  |"UNIVERSITY OF MANITOBA Hazardous Waste 2023 New Omitted"|
  |"HAWAII COMMUNITY COLLEGE Hazardous Waste 2024 Fall Rollover Adopted"|
  |"North-West University-ELEMENTARY: CORE - OTHER-Open"|
  |"MA-John Duggan Middle Schoo-ELEMENTARY: ASG - MATH-Open"|
  |"2024-OK-Yukon Public Schools-HIGH SCHOOL: CORE - MATH-Closed/Won-rmele"|
  |"KY-New Highland Elem School-DAG New/Field-Open"|
  |"Employment & Training Australia Inc Science & Technology 2024 New Omitted"|
  |"2025-OK-Lawton Public Schools-DAG: ELA/MATH-Open-jbaker"|
  |"2025-OK-Yukon Public Schools-HIGH SCHOOL: CORE - MATH-Open-jbaker"|
  |"2025-OK-Yukon Public Schools-HIGH SCHOOL: CORE - MATH-Closed/Lost-jbaker"|
  |"The University of Canberra College Race 2024 New Omitted"|
  |"2025-OK-Lawton Public Schools-HIGH SCHOOL: CORE - MATH-Open-jbaker"|
  |"UNIV OF WISC WHITEWATER Advanced Engineering Mathematics 2024 Fall Not Applicable"|
  |"NH-Moultonborough Academy-HIGH SCHOOL: CORE - SOCIAL STUDIES-Open"|
    #Keep adding more opp names in the Examples section which you want to delete at the end of the script run