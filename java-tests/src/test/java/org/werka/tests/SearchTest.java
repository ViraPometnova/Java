package org.werka.tests;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.werka.pages.MainMenu;
import org.werka.pages.SearchResults;

import static org.junit.Assert.assertTrue;

/**
 * Created by Vira Pometnova on
 * 30.04.2016.
 */
public class SearchTest {
    WebDriver driver = new FirefoxDriver();
    String searchText = "gopro";

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
    public void checkSearchResults() throws Exception {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.inputSearchText(searchText);
        mainMenu.performSearching();

        SearchResults searchResults = new SearchResults(driver);
        assertTrue("Takoe", searchResults.isSearchTextPresentInSearchResults(searchText));
    }

    @Test
    public void checkSearchResultsViaApi() throws Exception {
        URIBuilder builder = new URIBuilder("http://www.amazon.com")
                .addParameter("url", "search-alias=aps")
                .addParameter("field-keywords", searchText);

        String s = Request.Get(builder.build()).execute().returnContent().asString();
        System.out.println(s);
    }
}
