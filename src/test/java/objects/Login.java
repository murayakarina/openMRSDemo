package objects;

import com.mysql.cj.exceptions.AssertionFailedException;
import general.MainCall;
import org.openqa.selenium.By;


public class Login {

    public Login() {}

    public static By login_btn = By.xpath("//button[@type='submit']");
    public static By login_UserName = By.xpath("//input[@id='username']");
    public static By continueButton = By.xpath("//button[@type='button']");
    public static By login_password = By.xpath("//input[@id='password']");
    public static By loginVerification = By.xpath("//div[@data-extension-slot-name='homepage-dashboard-slot']");
    public static By errorMsg = By.xpath("//div[text()='Invalid username or password']");
    public static By myAccount = By.xpath("//button[@name='User']");
    public static By logoutButton = By.xpath("//a[@aria-label='Logout']/button");
    public static By loginPage = By.xpath("//div[@class='cds--tile -esm-login__login__loginCard___iiPcZ']");
    public static By location = By.xpath("//span[@class='cds--radio-button__label-text']/span[text()='Mobile Clinic']");
    public static By checkBox = By.xpath("//span[@class='cds--checkbox-label-text']");
    public static By confirmButton = By.xpath("//button[@type='submit']");
    public static By locationSelected = By.xpath("//span[text()='Mobile Clinic'] ");
    public static By changeLocationButton = By.xpath("//button[@aria-label='Change location']");


    //ensures that the webdriver is initialized before tests start
    public static void arriveToLogin()
    {
        try {
            MainCall.webDriverFactory.getInstance();
        } catch (Exception exception) {
            throw new AssertionFailedException(exception.getMessage());
        }
    }

    //
    public static void verifyUserIsLoggedOut () {
        MainCall.seleniumFunctions.isExist(loginPage);
    }
    public static void clickOnMyAccount() {
        MainCall.seleniumFunctions.ClickingOn(myAccount);
    }
    public static void clickOnLogoutBtn () {
        MainCall.seleniumFunctions.ClickingOn(logoutButton);
    }

    public  static void clickOnContinue() {
        MainCall.seleniumFunctions.ClickingOn(continueButton);
    }
    public static void enterUserName(String userName)
    {
        MainCall.seleniumFunctions.IhaveGivenInput(login_UserName, userName);

    }
    public static void enterPassword(String password) {
        MainCall.seleniumFunctions.IhaveGivenInput(login_password, password);
    }
    public static void clickLogin() {
        MainCall.seleniumFunctions.PressButton(login_btn);
    }
    public static void verifyLogin() {
        MainCall.seleniumFunctions.isExist(loginVerification);
    }

    public  static void enterInvalidUsername(String invalidUsername) {
        MainCall.seleniumFunctions.IhaveGivenInput(login_UserName, invalidUsername);
    }
    public static void verifyErrorMessage() {
        MainCall.seleniumFunctions.isExist(errorMsg);
    }
    public static void chooseLocation () {
        MainCall.seleniumFunctions.ClickingOn(location);
    }
    public static void clickOnRememberMyLocation () {
        MainCall.seleniumFunctions.ClickingOn(checkBox);
    }
    public static void clickOnConfirm () {
        MainCall.seleniumFunctions.ClickingOn(confirmButton);
    }
    public static void verifyUserIsOnTheDashboard () {
        MainCall.seleniumFunctions.isExist(locationSelected);
    }
    public static void clickOnMobileClinic () {
        MainCall.seleniumFunctions.ClickingOn(changeLocationButton);
    }
}