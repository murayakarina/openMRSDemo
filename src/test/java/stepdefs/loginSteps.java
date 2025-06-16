package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import general.MainCall;


import static config.ConfigProperties.*;

public class loginSteps {
    @And("User arrives to Login Page")
    public void userArrivesToLoginPage() {
        MainCall.loginPage.arriveToLogin();
    }

    @Given("^I login into Application$")
    public void login() {
        MainCall.loginPage.arriveToLogin();
        MainCall.loginPage.enterUserName(username);
        MainCall.loginPage.clickOnContinue();
        MainCall.loginPage.enterPassword(password);
        MainCall.loginPage.clickLogin();
        MainCall.loginPage.chooseLocation();
        MainCall.loginPage.clickOnRememberMyLocation();
        MainCall.loginPage.clickOnConfirm();

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        MainCall.loginPage.clickLogin();
    }
    @Given("^I am Testing Case : \"([^\"]*)\"$")
    public void iAmTestingCase(String id) throws Throwable {
        MainCall.caseID = id;
    }

    @And("I enter a valid username")
    public void iHaveEnterValidUsernameEmail() {
        MainCall.loginPage.enterUserName(username);
    }


    @And("I enter a valid password")
    public void iEnterAValidPassword() {
        MainCall.loginPage.enterPassword(password);
    }


    @Then("I verify login")
    public void iVerifyLogin() throws InterruptedException {
        MainCall.loginPage.verifyLogin();
        Thread.sleep(2000);
    }

    @And("I enter an invalid password")
    public void iHaveEnterInvalidPassword() {
        MainCall.loginPage.enterPassword("test");

    }

    @And("user clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        MainCall.loginPage.clickOnLogoutBtn();
    }

    @Then("user is logged out")
    public void userIsLoggedOut() {
        MainCall.loginPage.verifyUserIsLoggedOut();
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        MainCall.loginPage.clickOnContinue();
    }

    @And("I enter an invalid username")
    public void iEnterAnInvalidUsername() {
        MainCall.loginPage.enterInvalidUsername("mike");
    }

    @Then("I get an error message")
    public void iGetAnErrorMessage() {
        MainCall.loginPage.verifyErrorMessage();
    }

    @And("I click on my account icon")
    public void iClickOnMyAccountIcon() {
        MainCall.loginPage.clickOnMyAccount();
    }

    @And("I click on Logout")
    public void iClickOnLogout() {
        MainCall.loginPage.clickOnLogoutBtn();
    }

    @And("I choose a location")
    public void iChooseALocation() {
        MainCall.loginPage.chooseLocation();
        MainCall.loginPage.clickOnRememberMyLocation();
        MainCall.loginPage.clickOnConfirm();
    }

    @And("I am navigated to the dashboard page")
    public void iAmNavigatedToTheDashboardPage() {
        MainCall.loginPage.verifyUserIsOnTheDashboard();
    }

    @And("I remove my login location preference")
    public void iRemoveMyLoginLocationPreference() {
        MainCall.loginPage.clickOnMobileClinic();
        MainCall.loginPage.clickOnRememberMyLocation();
        MainCall.loginPage.clickOnConfirm();
    }
}