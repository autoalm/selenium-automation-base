package ro.cbn.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebDriverOperations {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriverWait webDriverWait;

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void findElementAndSendKeys(By elementLocator, CharSequence charSequence) {
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator))
                .sendKeys(charSequence);
    }

    public void clickOnElement(By elementLocator) {
        webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator))
                .click();
    }

    public String getTextFromElement(By titlePage) {
        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(titlePage))
                .getText();
    }

    public void selectOptionFromList(By dropDownElementLocator, String optionToSet) {
        Select dropdown = new Select(webDriver.findElement(dropDownElementLocator));
        dropdown.selectByVisibleText(optionToSet);
    }
}
