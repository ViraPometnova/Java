package org.werka.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.werka.pages.CreateAccount;
import org.werka.pages.LoginPage;
import org.werka.pages.MainMenu;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class UserCreationTest {
    WebDriver driver = new FirefoxDriver();
    TestData userData = new TestData();
    String userName = userData.getUserName();
    private TestData accountSettings;

    @Before
    public void setUp() throws Exception {
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        accountSettings = new TestData();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @Test
    public void createUser() throws Exception {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.signIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccount();

        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.createAccount(accountSettings);

        mainMenu = new MainMenu(driver);
        assertEquals("", userName, mainMenu.getHelloUserName());
    }
}
