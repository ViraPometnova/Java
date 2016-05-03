package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.werka.tests.TestData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class AddNewAddress {
    WebDriver driver;
    WebElement fullNameInput, addressLine1Input, addressLine2Input, cityInput, stateOrRegionInput, zipInput,
            phoneNumberInput, saveAndContinueButton;
    Select countryCodeDropdown;

    public AddNewAddress(WebDriver driver) {
        this.driver = driver;
        fullNameInput = driver.findElement(By.id("enterAddressFullName"));
        addressLine1Input = driver.findElement(By.id("enterAddressAddressLine1"));
        addressLine2Input = driver.findElement(By.id("enterAddressAddressLine2"));
        cityInput = driver.findElement(By.id("enterAddressCity"));
        stateOrRegionInput = driver.findElement(By.id("enterAddressStateOrRegion"));
        zipInput = driver.findElement(By.id("enterAddressPostalCode"));
        countryCodeDropdown = new Select(driver.findElement(By.id("enterAddressCountryCode")));
        phoneNumberInput = driver.findElement(By.id("enterAddressPhoneNumber"));
        saveAndContinueButton = driver.findElement(By.id("myab_newAddressButton"));
    }

    public void setFullName(String fullName) {
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
    }

    public void setAddressLine1(String address) {
        addressLine1Input.clear();
        addressLine1Input.sendKeys(address);
    }

    public void setAddressLine2(String address) {
        addressLine2Input.clear();
        addressLine2Input.sendKeys(address);
    }

    public void setCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setStateOrRegion(String state) {
        stateOrRegionInput.clear();
        stateOrRegionInput.sendKeys(state);
    }

    public void setPostalCode(String code) {
        zipInput.clear();
        zipInput.sendKeys(code);
    }

    public void setPhoneNumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void setCountryCode(String country) {
        countryCodeDropdown.selectByValue(country);
    }

    public void addNewAddress(TestData params) {
        setFullName(params.fullName);
        setAddressLine1(params.addressLine1);
        setAddressLine2(params.addressLine2);
        setCity(params.city);
        setStateOrRegion(params.state);
        setPostalCode(params.zip);
        setCountryCode(params.countryCode);
        setPhoneNumber(params.phone);
        saveAndContinue();
    }

    public void saveAndContinue() {
        saveAndContinueButton.click();
    }

    private WebElement successBarMessage() {
        return driver.findElement(By.id("myab-alert-bar-title"));
    }

    public String getSuccessBarMessage() {
        String message = successBarMessage().getText();
        return message.trim();
    }

    private WebElement addressLine1FromAddressList(int listNumber) {
        return driver.findElements(By.xpath("//li[@class = 'displayAddressLI displayAddressAddressLine1']//span")).get(listNumber);
    }

    private int getAddressListLineByFullName(String fullName) {
        WebElement listItem = driver.findElement(By.xpath("//li[@class = 'displayAddressLI displayAddressFullName']//span[contains(.,'" + fullName + "')]/ancestor::tr"));
        String itemId = listItem.getAttribute("id");
        Pattern pattern = Pattern.compile("address-index-(\\d+)");
        Matcher m = pattern.matcher(itemId);
        if (m.matches()) {
            return Integer.parseInt(m.group(1));
        }
        throw new RuntimeException("Can't match");
    }

    public String getAddressLine1FromAddressList(String fullName) {
        int index = getAddressListLineByFullName(fullName);
        return addressLine1FromAddressList(index).getText();
    }
}
