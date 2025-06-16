package stepdefs;

import general.MainCall;
import io.cucumber.java.en.And;

public class patientSearchSteps {
    @And("I click on the patient search icon")
    public void IClickOnThePatientSearchIcon() {
        MainCall.patientSearchFeature.clickOnSearchIcon();
    }

    @And("I search for a patient")
    public void iSearchForAPatient() {
        MainCall.patientSearchFeature.searchPatientName("joe");
    }

    @And("I click on search")
    public void iClickOnSearch() {
        MainCall.patientSearchFeature.clickOnSearchButton();
    }

    @And("I verify the patient is present")
    public void iVerifyThePatientIsPresent() {
        MainCall.patientSearchFeature.verifyPatientName();
    }
}
