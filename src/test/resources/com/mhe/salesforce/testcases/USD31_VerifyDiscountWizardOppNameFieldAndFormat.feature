#The following test cases has been covered in this feature file @GCRM-17918 @GCRM-17893 @GCRM-17976 @GCRM-17974 @GCRM-17973
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
Feature: Verify the Opportunity Product Discount Name field and The name should have a format like OPD-00000001 . 

  Background:
    Given I am logged into salesforce for "VerifyDiscountWizardOppNameFieldAndFormat"
    
  #@DiscountWizard @VerifyDiscountWizardOppNameFieldAndFormat @GCRM-17711
  #Scenario Outline: Verify the Opportunity Product Discount Name field and The name should have a format like OPD-00000001 .
  #
    #Given Runmode for "VerifyDiscountWizardOppNameFieldAndFormat" is Y
    #Then I do login as "<MHHE_Admin>"
    #And I change the app launcher to "MHHE"
    #And navigate to already existing record
    #|https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0068b00001NzdhaAAB/view|
    #Then verify discount wizard name field and name format
  #Examples:
    #|MHHE_Admin|
    #|Jaime_Klar|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
  @DiscountWizard @VerifyNonAvailabilityDiscountWizardScreen @GCRM-17695 @GCRM-17916 @GCRM-17904
  Scenario Outline: To Verify message is displayed when the opportunity stage is Qualified or Prospect.
  
    Given Runmode for "VerifyNonAvailabilityDiscountWizardScreen" is Y
    Then I do login as "<MHHE_Sales Representative>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FU5jEAAT/view|
    Then validate the Discount Wizard Screen non availability for the Opportunity Stage "<Stage1>"
    Then I logout of any user
    Then I do login as "<MHHE_Business_Admin>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FU5jEAAT/view|
    Then validate the Discount Wizard Screen non availability for the Opportunity Stage "<Stage2>"
    Then I logout of any user
    Then I do login as "<MHHE_Sales_Manager>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001Gr5L6AAJ/view|
    Then validate the Discount Wizard Screen non availability for the Opportunity Stage "<Stage1>"
  Examples:
    |MHHE_Sales Representative|MHHE_Business_Admin|MHHE_Sales_Manager|Stage1|Stage2|
    |Danielle_Snyder|Jaime_Klar|Randy_Allen|Qualified|Prospect|

#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
  @DiscountWizard @VerifyAvailabilityDiscountWizardScreen @GCRM-17687 @GCRM-17901 @GCRM-17932 @GCRM-17926 @GCRM-19736
  Scenario Outline: Validation of Discount Wizard Screen 1 Design with the Opportunity Stage Short Stack or  Adopted or At Risk and also verify Learning Solutions Setup option navigates to LS Project page.
  
    Given Runmode for "VerifyAvailabilityDiscountWizardScreen" is Y
    Then I do login as "<MHHE_Sales Representative>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FU5jEAAT/view|
    Then validate the Discount Wizard Screen availability for the Opportunity Stage "<Stage1>"
    And verify Learning Solutions Setup option navigates to LS Project creation page
    And verify PriceDuration Change option navigates to PriceDuration Product page
    Then I logout of any user
    Then I do login as "<MHHE_Business_Admin>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y00001FU5jEAAT/view|
    Then validate the Discount Wizard Screen availability for the Opportunity Stage "<Stage2>"
    And verify Learning Solutions Setup option navigates to LS Project creation page
    And verify PriceDuration Change option navigates to PriceDuration Product page
    Then I logout of any user
    Then I do login as "<MHHE_Sales_Manager>"
    And I change the app launcher to "MHHE"
    And navigate to already existing record
    |https://mh--uat.sandbox.lightning.force.com/lightning/r/Opportunity/0060y000016JdgbAAC/view|
    Then validate the Discount Wizard Screen availability for the Opportunity Stage "<Stage3>"
    And verify Learning Solutions Setup option navigates to LS Project creation page
    And verify PriceDuration Change option navigates to PriceDuration Product page
  Examples:
    |MHHE_Sales Representative|MHHE_Business_Admin|MHHE_Sales_Manager|Stage1|Stage2|Stage3|
    |Danielle_Snyder|Jaime_Klar|Randy_Allen|Short_Stack|Adopted|At_Risk|
   
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
  @DiscountWizard @VerifyRequestNewISBNButtonOnNonMHHEOpp @GCRM-17906
  Scenario Outline: To verify that Request New ISBN the button is not available for non-MHHE opportunities.
  
    Given Runmode for "VerifyRequestNewISBNButtonOnNonMHHEOpp" is Y
    Then I do login as "<SEG_Sales_Rep>"
    Then I navigate to opportunity tab
    Then I navigate to the first opp in the page
    And verify Request New ISBN button is not available
  Examples:
    |SEG_Sales_Rep|
    |Open_Baker|
    
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva
#select id, ISBN_13__c, Net_Price__c,Tier_1_Price__c    from Product2 where ISBN_Request_Product_Type__c = 'CONNECT' and Net_Price__c >0  and Tier_1_Price__c>0
#|CONNECT_TYPE	 |MHGO_TYPE			 |ALEKS_TYPE		 |SIMNET_TYPE		 |EBOOK_TYPE		 |LOOSELEAF_TYPE |HARDBOUND_TYPE |BUNDLE_TYPE    |
#|"9781264045969"|"9781260912753"|"9781264248636"|"9781264734139"|"9780077725020"|"9781264113088"|"9780070109100"|"9781260917666"|
  @DiscountWizard @VerifyProductsAreDisplayedUnderRespectiveSection @GCRM-17991 @GCRM-19738 @GCRM-19739 @GCRM-20544 @GCRM-19747 @GCRM-19752 @GCRM-19853 @GCRM-20542 @GCRM-18040 @GCRM-18047 @GCRM-18048 @GCRM-18049 @GCRM-18129 @GCRM-18140 @GCRM-18203 @GCRM-18144 @GCRM-18130 @GCRM-20535 @GCRM-20545 @GCRM-19744 @GCRM-18296
  Scenario Outline: To verify product can be added to Price Duration product list under respective product sections.
  
    Given Runmode for "VerifyProductsAreDisplayedUnderRespectiveSection" is Y
    Then I do login as "<MHHE_Sales Rep>"
    And I change the app launcher to "MHHE"
    Then I navigate to opportunity tab
    Then create new MHHE opportunity
    |BUTLER COMM CLG ANDOVER|Engineering Economy|200|125|Takeaway|
    And update the opportunity stage to "<Stage>"
    And add all type products to opportunity
    |9781264045969|9781264686285|9781264248636|9781264734139|9780077725020|9781264113088|9780070109100|9781260917666|
    And verify the newly added products are showing under correct section of PriceDuration Products page
    |9781264045969|9781264686285|9781264248636|9781264734139|9780077725020|9781264113088|9780070109100|9781260917666|
    And verify Offer Level Setup field against all product types in Screen2
    And verify Details in Screen3 of Discount Wizard
    And verify ISBN doesnt get auto approved even if the requested price is greater than suggested price but there is a duration change
    And verify for EBOOK product OPD there will be no record on the staging object
  Examples:
    |MHHE_Sales Rep|Stage|
    |Danielle_Snyder|Short_Stack|
    
#DEPENDENT_SCRIPT - This script is dependent on VerifyProductsAreDisplayedUnderRespectiveSection script to get opp url.
#Created By : Siva
  @DiscountWizard @VerifyAddingofMultipleProductsOfSameType @GCRM-18068 @GCRM-18070 @GCRM-18072 @GCRM-18073 @GCRM-18074 @GCRM-18076 @GCRM-18080
  Scenario Outline: Add multiple product under a same Product Type 
  
    Given Runmode for "VerifyAddingofMultipleProductsOfSameType" is Y
    Then I do login as "<MHHE_Sales Rep>"
    And I change the app launcher to "MHHE"
    Then I navigate to opportunity tab
    Then create new MHHE opportunity
    |BUTLER COMM CLG ANDOVER|Engineering Economy|200|125|Takeaway|
    And update the opportunity stage to "<Stage>"
    And add same type products to opportunity
    |9781264045969|9781260930658|9781260088298|9781266336560|9781264113088|9781260937008|9780077725020|9781264009749|9781264248636|9781260939507|9781264686285|9781264904518|9781260912753|
    And verify error message when user selects products from both grids
  Examples:
    |MHHE_Sales Rep|Stage|
    |Danielle_Snyder|Short_Stack|
  
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva  
  @DiscountWizard @VerifyDuplicateISBNRequest @GCRM-17970 @GCRM-17975 @GCRM-19848 @GCRM-17711
  Scenario Outline: Verify that duplicate requests are accepted and processed correctly when Enter duplicate requests for the same product.
  
    Given Runmode for "VerifyDuplicateISBNRequest" is Y
    Then I do login as "<MHHE_Admin>"
    And I change the app launcher to "MHHE"
    Then I navigate to opportunity tab
    Then create new MHHE opportunity
    |OLYMPIC COLLEGE|Middle School Social Studies Methods|200|125|Service|
    And update the opportunity stage to "<Stage>"
    #I am using simnet product in the next step just for code reusability purpose but we can choose any type of product/ISBN in this test case
    And add <SIMNET_TYPE> product to opportunity
    Then create an ISBN request
    And verify the new ISBN request details in Opp Product Discount related list
    And Verify no new ISBN request can be raised when a OPD is in process of approval
    Then I logout of any user
    Then I do login as "<ISBN_Approver>"
    And I change the app launcher to "MHHE"
    And approver approves the ISBN Request
    Then I logout of any user
    Then I do login as "<MHHE_Admin>"
    Then create duplicate ISBN request and validate the warning message
    And verify the duplicate ISBN request details in Opp Product Discount related list
    Then verify discount wizard name field and name format
  Examples:
    |MHHE_Admin|Stage|ISBN_Approver|SIMNET_TYPE|
    |Jaime_Klar|Short_Stack|Michael_Swert|"9781264734139"|
    
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva 
#NOTE : "Code Type" field name has been updated to "Delivery Mode" & "Discount Type" field has been renamed as "National Discount"
  @DiscountWizard @VerifyCodeTypeFieldBehaviourForDiffProductTypes @GCRM-17928 @GCRM-17929 @GCRM-17972 @GCRM-17931 @GCRM-17930 @GCRM-19671 @GCRM-19737 @GCRM-19746 @GCRM-19748 @GCRM-18071 @GCRM-18214 @GCRM-18218 @GCRM-18089 @GCRM-18148 @GCRM-18133 @GCRM-18211 @GCRM-23822
  Scenario Outline: Verify the Code Type field  is only editable for the product of product type “ALEKS” and “SIMNET”.
  
    Given Runmode for "VerifyCodeTypeFieldBehaviourForDiffProductTypes" is Y
    Then I do login as "<MHHE_Admin>"
    And I change the app launcher to "MHHE"
    Then I navigate to opportunity tab
    Then create new MHHE opportunity
    |OLYMPIC COLLEGE|Middle School Social Studies Methods|200|125|Service|
    And update the opportunity stage to "<Stage>"
		And add all type products to opportunity
    |9781264045969|9781264686285|9781264248636|9781264734139|9780077725020|9781264113088|9780070109100|9781260917666|
		Then create ISBN request and verify code type field behaviour
		|9781264045969|9781264686285|9781264248636|9781264734139|9780077725020|9781264113088|9780070109100|9781260917666|
  Examples:
    |MHHE_Admin|Stage|
    |Jaime_Klar|Short_Stack|
    
#STAND_ALONE_SCRIPT - This script can be executed separately.
#Created By : Siva 
  @DiscountWizard @VerifyISBNRequestAutoApproval @GCRM-19845 @GCRM-19751
  Scenario Outline: Verify Tier1 -Autoapproval by sales Rep when requested price is greater than suggested price A,B,C and opty type is NULL and discount type is not Deal desk
  
    Given Runmode for "VerifyISBNRequestAutoApproval" is Y
    Then I do login as "<MHHE_Admin>"
    And I change the app launcher to "MHHE"
    Then I navigate to opportunity tab
    Then create new MHHE opportunity
    |OLYMPIC COLLEGE|Middle School Social Studies Methods|200|125|Service|
    And update the opportunity stage to "<Stage>"
    And add <EBOOK_TYPE> product to opportunity
		And verify ISBN get auto approved if the requested price is greater than suggested price and opty type is NULL and discount type is not Deal desk
  Examples:
    |MHHE_Admin|Stage|EBOOK_TYPE|
    |Jaime_Klar|Short_Stack|"9780077725020"|
    
#DEPENDENT_SCRIPT - This script is dependent on VerifyISBNRequestAutoApproval script to get opp url.
#Created By : Siva 
#Note : The ‘Direct to Student’ in Delivery Mode field has been renamed as ‘Private Offer’ in GCRM-24079
  @DiscountWizard @ISBNRequestWithSingleEBookwithDiffDiscountTypes @GCRM-20537 @GCRM-20539 @GCRM-20540 @GCRM-20541 @GCRM-24319 @GCRM-24320
  Scenario Outline: Verify ISBN request creation with single EBOOK with Different discount type
  
    Given Runmode for "ISBNRequestWithSingleEBookwithDiffDiscountTypes" is Y
    Then I do login as "<MHHE_Admin>"
    And I change the app launcher to "MHHE"    
    And verify ISBN request creation with single EBOOK with <Product_Type> discount type
  Examples:
    |MHHE_Admin|Product_Type|
    |Jaime_Klar|"Deal_Desk"|
    |Jaime_Klar|"Deal_Desk-IA"|
    |Jaime_Klar|"IA"|
    |Jaime_Klar|"National_Discount"|