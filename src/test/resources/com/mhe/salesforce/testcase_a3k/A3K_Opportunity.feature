Feature: A3K Opportunity

  Background:
    Given I am logged into salesforce for "A3KOpportunity"

  @A3KNA @A3KOpportunity @A3KOppDefaultFields @GCRM-17672
  Scenario Outline: A3K DAG Opp - Verify default fields
    Given Runmode for "A3KOppDefaultFields" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create from Account a new Opportunity of Record Type "<Record_Type>"
    And I fill in all the required DAG Opportunity fields
    Then I verify the Opportunity Stage is "<Opportunity_Initial_Stage>"
    And I verify the Opportunity Name is in the expected DAG format
    Examples:
      | Record_Type   | SEG_Sales_Rep | Opportunity_Initial_Stage   |
      | DAG_New_Field | Jed_Holdeman  | DAG_New_Field_Initial_Stage |
      | DAG_Renewal   | Jed_Holdeman  | DAG_Renewal_Initial_Stage   |

  @A3KNA @A3KOpportunity @A3KOppRosteringNewFieldFails @GCRM-17772
  Scenario Outline: A3K DAG Opp - Rostering fields trigger VR for New/Field
    Given Runmode for "A3KOppRosteringNewFieldFails" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create from Account a new Opportunity of Record Type "<Record_Type>"
    And I fill in all the required DAG Opportunity fields
    And I add the product "<Opp_Product>" to the Opportunity
    Then I get an error when trying to update the Opportunity stage to "Presentation"
    Examples:
      | Record_Type   | Opp_Product | SEG_Sales_Rep |
      | DAG_New_Field | DAG_Product | Jed_Holdeman  |

  @A3KNA @A3KOpportunity @A3KOppRosteringNewFieldPass @GCRM-17772 @GCRM-17936
  Scenario Outline: A3K DAG Opp - Rostering fields required for New/Field
    Given Runmode for "A3KOppRosteringNewFieldPass" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create from Account a new Opportunity of Record Type "<Record_Type>"
    And I fill all required Opportunity fields
    And I save the Opportunity
    And I add the product "<Opp_Product>" to the Opportunity
    And I fill the Opportunity Rostering Fields
    And I go to Opportunity Contact Roles
    And I add a Contact with role "<Contact_Role_1>"
    And I save the Contact Roles
    Then I update the Opportunity stage to "Presentation" successfully
    Examples:
      | Record_Type   | Opp_Product | SEG_Sales_Rep |
      | DAG_New_Field | DAG_Product | Jed_Holdeman  |

  @A3KNA @A3KOpportunity @A3KOppRosteringRenewal @GCRM-17772
  Scenario Outline: A3K DAG Opp - Rostering fields not required for Renewal
    Given Runmode for "A3KOppRosteringRenewal" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create a new Opportunity of Record Type "<Record_Type>"
    And I fill all required Opportunity fields
    And I save the Opportunity
    And I add the product "<Opp_Product>" to the Opportunity
    Then I update the Opportunity stage to "Presentation" successfully
    Examples:
      | Record_Type | Opp_Product | SEG_Sales_Rep |
      | DAG_Renewal | DAG_Product | Jed_Holdeman  |

  @A3KNA @A3KOpportunity @A3KOppContactRolesMissing @GCRM-17671 @GCRM-17672
  Scenario Outline: A3K DAG Opp - Contact Roles Missing
    Given Runmode for "A3KOppContactRolesMissing" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create a new Opportunity of Record Type "<Record_Type>"
    And I fill all required Opportunity fields
    And I save the Opportunity
    And I fill the Opportunity Rostering Fields
    And I add the product "<Opp_Product>" to the Opportunity
    And I go to Opportunity Contact Roles
    And I add a Contact with role "<Contact_Role_1>"
    And I save the Contact Roles
    Then I get an error when trying to update the Opportunity stage to "Won"
    Examples:
      | Record_Type   | Opp_Product | A3K_Customer_Support | Blended_Service_and_Sales | CSOM_Business_Administrators | SEG_Business_Admin | SEG_Sales_Rep |
      | DAG_New_Field | DAG_Product | Steve_Loori          | Stefanie_Vogel               | Jennifer_Ryan                | Ivan_Gomez    | Jed_Holdeman  |
      | DAG_Renewal   | DAG_Product | Steve_Loori          | Stefanie_Vogel               | Jennifer_Ryan                | Ivan_Gomez    | Jed_Holdeman  |


  @A3KNA @A3KOpportunity @A3KOppContactRolesAdded @GCRM-17671 @GCRM-17672
  Scenario Outline: A3K DAG Opp - Contact Roles added
    Given Runmode for "A3KOppContactRolesAdded" is Y
    Then I do login as "<SEG_Sales_Rep>"
    When I navigate to A3K Account
    And I create a new Opportunity of Record Type "<Record_Type>"
    And I fill all required Opportunity fields
    And I save the Opportunity
    And I fill the Opportunity Rostering Fields
    And I add the product "<Opp_Product>" to the Opportunity
    And I go to Opportunity Contact Roles
    And I add a Contact with role "<Contact_Role_1>"
    And I add a Contact with role "<Contact_Role_2>"
    And I add a Contact with role "<Contact_Role_3>"
    And I add a Contact with role "<Contact_Role_4>"
    And I save the Contact Roles
    Then I update the Opportunity stage to "Won" successfully
    Examples:
      | Record_Type   | Opp_Product | Contact_Role_1         | Contact_Role_2     | Contact_Role_3             | Contact_Role_4   | SEG_Sales_Rep |
      | DAG_New_Field | DAG_Product | Tech/Rostering Contact | Activation Contact | Key Decision Maker / Buyer | Training Contact | Jed_Holdeman  |
      | DAG_Renewal   | DAG_Product | Tech/Rostering Contact | Activation Contact | Key Decision Maker / Buyer | Training Contact | Jed_Holdeman  |
