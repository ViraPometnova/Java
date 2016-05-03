package org.werka.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.werka.businessFunctions.Login;
import org.werka.pages.LoginPage;
import org.werka.pages.MainMenu;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class LoginTest {
    WebDriver driver = new FirefoxDriver();
    String userEmail = "vera.pometneva@gmail.com";
    String userName = "verapometneva";
    Login login = new Login(driver);

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @Test
    public void happyLogin() throws Exception {
        String userPassword = "amazon01";
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.signIn();

        Login login = new Login(driver);
        login.logIn(userEmail, userPassword);

        mainMenu = new MainMenu(driver);
        assertEquals("", userName, mainMenu.getHelloUserName());
        assertEquals("", userName, mainMenu.getHiUserName());
    }

    @Test
    public void loginWithWrongPassword() throws Exception {
        String userPassword = "amazon02";
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.signIn();

        login.logIn(userEmail, userPassword);

        LoginPage loginPage = new LoginPage(driver);
        assertEquals("", "Your email or password was incorrect. Please try again.", loginPage.getErrorMessage());
    }
}


