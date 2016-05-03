package org.werka.tests;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Vira Pometnova on
 * 01.05.2016.
 */
public class TestData {
    String userName = "Vera" + RandomStringUtils.randomAlphanumeric(6);
    String userEmail = userName + "@gmail.com";
    public String fullName = userName;
    public String addressLine1 = "Zabolotogo";
    public String addressLine2 = "253";
    public String city = "Kiev";
    public String state = "State";
    public String zip = "03187";
    public String countryCode = "UA";
    public String phone = "380445234999";
    public String name = userName;
    public String email = userEmail;
    public String password = "amazon01";
    public String confirmationPassword = password;


    public String getUserName() {
        return userName;
    }
}
