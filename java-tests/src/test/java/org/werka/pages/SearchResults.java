package org.werka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Vira Pometnova on
 * 30.04.2016.
 */
public class SearchResults {
    WebDriver driver;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    private List<String> collectSearchResults() {
        return IntStream.range(0, 18).boxed().map(index -> {
            WebElement resultItem = driver.findElement(By.xpath("//li[@id='result_" + index + "']//h2"));
            return resultItem.getText();
        }).collect(Collectors.toList());
    }

    private long countSearchTextInclusion(List<String> list, String searchText) {
        return list.stream().filter(s -> s.toLowerCase().contains(searchText.toLowerCase())).count();
    }

    public boolean isSearchTextPresentInSearchResults(String searchText) {
        List<String> list = collectSearchResults();
        long results = countSearchTextInclusion(list, searchText);
        System.out.println(results);
        return results > 0;
    }
}
