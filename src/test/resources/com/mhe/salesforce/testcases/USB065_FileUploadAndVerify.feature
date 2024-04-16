Feature: As a Marketing user, I can upload and link marketing documents to 1 or more areas (mark external/internal, expire date, remove linkages, and delete documents)

  Background:
    Given I am logged into salesforce for "FileUploadAndVerify"

  @FileUploadAndVerify @GCRM-9454
  Scenario Outline: As a Marketing user, I can upload and link marketing documents to 1 or more areas (mark external/internal, expire date, remove linkages, and delete documents)
    Given Runmode for "FileUploadAndVerify" is Y
#    Then I login as Sales Rep
    Then I do login as "<MHHE_Business_Administrator>"
    When I navigate to File Object
    Then I Upload a file
    And verify the US Taxonomy
    Then I View File detatls and Document Link
    And I Delete uploaded file
    
    Examples: 
    |MHHE_Business_Administrator|
    |Jaime_Klar|