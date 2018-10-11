package ro.cbn.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import ro.cbn.automation.BaseSteps;
import ro.cbn.automation.pages.CommonPage;
import ro.cbn.automation.selenium.WebDriverOperations;

import java.lang.reflect.Method;

import static ro.cbn.automation.util.AutomationHelper.getPageClass;

public class CommonSteps extends BaseSteps<CommonPage> {

    @Autowired
    private WebDriverOperations webDriverOperations;

    @Then("^I check if page is \"([^\"]*)\" and title is \"([^\"]*)\"$")
    public void iCheckIfPageIsAndTitleIs(String expectedPage, String pageTitle) {
        try {
            this.progressTo(getPageClass(expectedPage).getDeclaredConstructor().newInstance());
            this.getCurrentScreen().setWebdriverOperation(webDriverOperations);
            Assert.assertEquals("pagina nu e buna", expectedPage, this.getCurrentScreen().getPageTitle());
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @And("^I click on \"([^\"]*)\" from page \"([^\"]*)\"$")
    public void iClickOnFromPage(String elementToClick, String pageName) {
        try {
            this.progressTo(getPageClass(pageName).getDeclaredConstructor().newInstance());
            this.getCurrentScreen().setWebdriverOperation(webDriverOperations);
            Method methodCall = this.getCurrentScreen().getClass().getMethod("get" + elementToClick + "ButtonLocator");
            By buttonLocator = (By) methodCall.invoke(this.getCurrentScreen().getClass().getDeclaredConstructor().newInstance());
            webDriverOperations.clickOnElement(buttonLocator);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
