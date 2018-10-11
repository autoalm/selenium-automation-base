package ro.cbn.automation.pages;

import org.openqa.selenium.By;
import ro.cbn.automation.selenium.WebDriverOperations;

public abstract class CommonPage {

    private By cautaButtonLocator = By.xpath("//input[@id='newSearch']");
    public By getCautaButtonLocator() {
        return cautaButtonLocator;
    }

    private WebDriverOperations webDriverOperations;
    public void setWebdriverOperation(WebDriverOperations webDriverOperations) {
        this.webDriverOperations = webDriverOperations;
    }

    public void clickOnElement(By elementToClick) {
        webDriverOperations.clickOnElement(elementToClick);
    }

    public String getPageTitle(){
        return webDriverOperations.getTitle();
    }


}
