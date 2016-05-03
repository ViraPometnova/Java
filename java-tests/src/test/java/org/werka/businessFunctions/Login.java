package org.werka.businessFunctions;

import org.openqa.selenium.WebDriver;
import org.werka.pages.LoginPage;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserEmail(userEmail);
        loginPage.setUserPassword(userPassword);
        loginPage.signIn();
    }
}
