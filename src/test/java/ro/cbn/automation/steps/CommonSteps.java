package ro.cbn.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @Then("^I check if page is \"([^\"]*)\" and title is \"([^\"]*)\"$")
    public void iCheckIfPageIsAndTitleIs(String expectedPage, String pageTitle) {
        try {
            this.progressTo(getPageClass(expectedPage).getDeclaredConstructor().newInstance());
            this.getCurrentScreen().setWebdriverOperation(webDriverOperations);
            Assert.assertTrue("pagina nu e buna", this.getCurrentScreen().pageTitleContains(pageTitle));
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    @And("^I navigate to \"([^\"]*)\" tab$")
    public void iNavigateToTab(String tabToNavigate) {
       By tabLocator =  this.getCurrentScreen().navigateToTab(tabToNavigate);
       webDriverOperations.clickOnElement(tabLocator);
    }

    @And("^I type \"([^\"]*)\" in \"([^\"]*)\" on page \"([^\"]*)\"$")
    public void iTypeInFieldOnPage(String textToType, String fieldName, String expectedPage) {
        By locator = this.getCurrentScreen().getFieldLocatorByPage(expectedPage,fieldName);
        webDriverOperations.findElementAndSendKeys(locator, textToType);
    }

    @When("^I select \"([^\"]*)\" from \"([^\"]*)\" list on page \"([^\"]*)\"$")
    public void iSelectFromListOnPage(String optionToSet, String list, String expectedPage) {
        By locator = this.getCurrentScreen().getListLocatorByPage(expectedPage,list);
        webDriverOperations.selectOptionFromList(locator, optionToSet);
    }
}
