package ro.cbn.automation.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.cbn.automation.selenium.WebDriverOperations;

public class MainPage {

    private By titlePage = By.xpath("//title/text()");

    @Autowired
    private WebDriverOperations webDriverOperations;

    public Boolean pageTitleContains(String pageTitle) {
        String titleFromPage = webDriverOperations.getTitle();
        return titleFromPage.contains(pageTitle);
    }
}
