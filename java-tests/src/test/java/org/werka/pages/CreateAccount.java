package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.werka.tests.TestData;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class CreateAccount {
    WebDriver driver;
    WebElement userNameInput, userEmailInput, userPasswordInput, userPasswordConfirmationInput, createButton;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        userNameInput = driver.findElement(By.id("ap_customer_name"));
        userEmailInput = driver.findElement(By.id("ap_email"));
        userPasswordInput = driver.findElement(By.id("ap_password"));
        userPasswordConfirmationInput = driver.findElement(By.id("ap_password_check"));
        createButton = driver.findElement(By.id("continue"));
    }

    public void createAccount(TestData params) {
        setUserName(params.name);
        setEmail(params.email);
        setPassword(params.password);
        setPasswordConfirmation(params.confirmationPassword);
        submitAccountCreation();
    }

    public void setUserName(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void setEmail(String email) {
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        userPasswordInput.clear();
        userPasswordInput.sendKeys(password);
    }

    public void setPasswordConfirmation(String password) {
        userPasswordConfirmationInput.clear();
        userPasswordConfirmationInput.sendKeys(password);
    }

    public void submitAccountCreation() {
        createButton.click();
    }
}
