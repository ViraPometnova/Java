package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class AccountSettings {
    WebDriver driver;
    WebElement addNewAddressLink;

    public AccountSettings(WebDriver driver) {
        this.driver = driver;
        addNewAddressLink = driver.findElement(By.xpath("//a[text() = 'Add New Address']"));
    }

    public void openAddNewAddress() {
        addNewAddressLink.click();
    }
}
