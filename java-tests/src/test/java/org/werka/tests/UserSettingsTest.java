package org.werka.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.werka.businessFunctions.Login;
import org.werka.pages.AccountSettings;
import org.werka.pages.AddNewAddress;
import org.werka.pages.MainMenu;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class UserSettingsTest {
    WebDriver driver = new FirefoxDriver();
    String userEmail = "vera.pometneva@gmail.com";
    String userPassword = "amazon01";
    String successMessage = "Your address has been successfully added";
    Login login = new Login(driver);
    TestData addressSettings = new TestData();

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
    public void addNewAddress() throws Exception {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.signIn();

        login.logIn(userEmail, userPassword);

        mainMenu = new MainMenu(driver);
        mainMenu.signIn();

        AccountSettings accountSettings = new AccountSettings(driver);
        accountSettings.openAddNewAddress();

        AddNewAddress newAddress = new AddNewAddress(driver);
        newAddress.addNewAddress(addressSettings);


        assertEquals("Success message should be equal to" + successMessage, successMessage,
                newAddress.getSuccessBarMessage());
        assertEquals("Proper address line 1 should be saved for user" + addressSettings.fullName,
                addressSettings.addressLine1, newAddress.getAddressLine1FromAddressList(addressSettings.fullName));

    }
}
