package ro.cbn.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import ro.cbn.automation.pages.MainPage;


public class MainPageSteps {

    @Autowired
    private MainPage mainPage;

    @Then("^I check if page title is \"([^\"]*)\"$")
    public void iCheckIfPageTitleIs(String pageTitle) {
        Assert.assertTrue(mainPage.pageTitleContains(pageTitle));
    }


}
