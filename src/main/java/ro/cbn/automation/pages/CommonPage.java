package ro.cbn.automation.pages;

import org.openqa.selenium.By;
import ro.cbn.automation.selenium.WebDriverOperations;

import java.lang.reflect.Method;

import static ro.cbn.automation.util.AutomationHelper.getPageClass;

public abstract class CommonPage {

    private By cautariSimpleButtonLocator = By.xpath("//img[contains(@src,'cautari_simple')]");
    public By getCautariSimpleButtonLocator() {
        return cautariSimpleButtonLocator;
    }

    private By cautaButtonLocator = By.xpath("//input[@id='newSearch']");
    public By getCautaButtonLocator() {
        return cautaButtonLocator;
    }

    private By numeTextLocator = By.xpath("//input[@id='lastname']");
    public By getNumeTextLocator() {
        return numeTextLocator;
    }

    private By prenumeTextLocator = By.xpath("//input[@id='firstname']");
    public By getPrenumeTextLocator() {
        return prenumeTextLocator;
    }

    private By sexListLocator = By.xpath("//select[@id='sex']");
    public By getSexListLocator() {
        return sexListLocator;
    }

    private By cnpTextLocator = By.xpath("//input[@id='PNC']");
    public By getCNPTextLocator() {
        return cnpTextLocator;
    }

    private By motivulInterogariiTextLocator = By.xpath("//input[@id='searchReason']");
    public By getMotivulInterogariiTextLocator() {
        return motivulInterogariiTextLocator;
    }

    private By tableLocator = By.xpath("//table[4]/tbody");
    public By getTableLocator() {
        return tableLocator;
    }



    private WebDriverOperations webDriverOperations;
    public void setWebdriverOperation(WebDriverOperations webDriverOperations) {
        this.webDriverOperations = webDriverOperations;
    }

    public Boolean pageTitleContains(String pageTitle) {
        String titleFromPage = webDriverOperations.getTitle();
        return titleFromPage.contains(pageTitle);
    }

    public By getFieldLocatorByPage(String expectedPage, String fieldName) {
        By locator;
        try {
            Method methodGetToCall = getPageClass(expectedPage).getMethod("get" + fieldName.replaceAll(" ", "") + "TextLocator");
            locator = (By) methodGetToCall.invoke(getPageClass(expectedPage).getDeclaredConstructor().newInstance());
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("Could not instantiate! " + getPageClass(expectedPage).getSimpleName() + " or method: " + e.getMessage() + " does not exist");
        }
        return locator;
    }

    public By getListLocatorByPage(String expectedPage, String expectedList) {
        By locator;
        try {
            Method methodGetToCall = getPageClass(expectedPage).getMethod("get" + expectedList.replaceAll(" ", "") + "ListLocator");
            locator = (By) methodGetToCall.invoke(getPageClass(expectedPage).getDeclaredConstructor().newInstance());
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("Could not instantiate! " + getPageClass(expectedPage).getSimpleName() + " or method: " + e.getMessage() + " does not exist");
        }
        return locator;
    }

    public By navigateToTab(String tabToNavigate) {
        By locator;
        try {
            Method methodGetToCall = getPageClass("Main Page").getMethod("get" + tabToNavigate.replaceAll(" ", "") + "ButtonLocator");
            locator = (By) methodGetToCall.invoke(getPageClass("Main Page").getDeclaredConstructor().newInstance());
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("Could not instantiate! " + getPageClass("Main Page").getSimpleName() + " or method: " + e.getMessage() + " does not exist");
        }
        return locator;
    }
}
