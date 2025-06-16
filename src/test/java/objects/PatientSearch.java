package objects;

import general.MainCall;
import org.openqa.selenium.By;

public class PatientSearch {
    public PatientSearch() {}

    public static By searchPatientIcon = By.xpath("//div[@data-extension-id='patient-search-icon']");
    public static By searchPatientTextfield = By.xpath("//input[@data-testid='patientSearchBar']");
    public static By searchButton = By.xpath("//button[@type='submit']");
    public static By patientName = By.xpath("//span[text()='joe doe Colombo']");

    public static void clickOnSearchIcon() {
        MainCall.seleniumFunctions.ClickingOn(searchPatientIcon);
    }

    public static void searchPatientName (String patientName) {
        MainCall.seleniumFunctions.IhaveGivenInput(searchPatientTextfield, patientName);
    }

    public static void clickOnSearchButton () {
        MainCall.seleniumFunctions.ClickingOn(searchButton);
    }

    public static void verifyPatientName() {
        MainCall.seleniumFunctions.isExist(patientName);
    }
}
