package ro.cbn.automation.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import ro.cbn.automation.selenium.WebDriverOperations;


public class LoginPage {

    private By utilizatorTextLocator = By.xpath("//input[@id='login-user']");
    private By parolaTextLocator = By.xpath("//input[@id='login-password']");
    private By autentificaButtonLocator = By.xpath("//input[@id='submit-button']");

    private WebDriverOperations webDriverOperations;

    public LoginPage(WebDriverOperations webDriverOperations){
        this.webDriverOperations = webDriverOperations;
    }
    public void navigateToMainPage(String url) {
        webDriverOperations.navigateTo(url);
    }

    public void login(String user, String password) {
        webDriverOperations.findElementAndSendKeys(utilizatorTextLocator, user);
        webDriverOperations.findElementAndSendKeys(parolaTextLocator, password);
        webDriverOperations.clickOnElement(autentificaButtonLocator);
    }


}
