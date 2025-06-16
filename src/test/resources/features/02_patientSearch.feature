@patientSearch

  Feature: PatientSearch

    Scenario: User can search for a patient
      Given I am Testing Case : "5"
      And I login into Application
      And I remove my login location preference
      And I click on the patient search icon
      And I search for a patient
      And I click on search
      And I verify the patient is present
