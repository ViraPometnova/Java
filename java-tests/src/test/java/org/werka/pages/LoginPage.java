package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class LoginPage {
    WebDriver driver;
    WebElement emailInput, passwordInput, signInButton, createAccountButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        emailInput = driver.findElement(By.id("ap_email"));
        passwordInput = driver.findElement(By.id("ap_password"));
        signInButton = driver.findElement(By.id("signInSubmit"));
        createAccountButton = driver.findElement(By.id("createAccountSubmit"));
    }

    public void createAccount() {
        createAccountButton.click();
    }

    public void setUserEmail(String userEmail) {
        emailInput.clear();
        emailInput.sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword) {
        passwordInput.clear();
        passwordInput.sendKeys(userPassword);
    }

    public void signIn() {
        signInButton.click();
    }

    public String getErrorMessage() {
        String message = errorMessage().getText();
        return message.trim();
    }

    private WebElement errorMessage() {
        return driver.findElement(By.xpath(".//h4[text()='There was a problem']/following::span[1]"));
    }
}
