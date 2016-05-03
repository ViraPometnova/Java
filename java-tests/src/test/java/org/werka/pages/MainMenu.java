package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vira Pometnova on
 * 30.04.2016.
 */
public class MainMenu {
    WebDriver driver;
    WebElement searchBox;
    WebElement searchButton;
    WebElement signInLink;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchButton = driver.findElement(By.cssSelector("input[value = 'Go']"));
        signInLink = driver.findElement(By.id("nav-link-yourAccount"));
    }

    public void inputSearchText(String text) {
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void performSearching() {
        searchButton.click();
    }

    public void signIn() {
        signInLink.click();
    }

    public String getHelloUserName() {
        String greeting = helloUserLink().getText();
        return greeting.substring(7); //starts after "Hello, "
    }

    public String getHiUserName() {
        String greeting = hiUserLink().getText();
        return greeting.substring(4); //starts after "Hi, "
    }

    private WebElement helloUserLink() {
        return driver.findElement(By.xpath("//span[contains(., 'Hello,')]"));
    }

    private WebElement hiUserLink() {
        return driver.findElement(By.xpath("//a[contains(., 'Hi,')]"));
    }
}
