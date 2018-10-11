package ro.cbn.automation.steps;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import ro.cbn.automation.BaseSteps;
import ro.cbn.automation.pages.LoginPage;
import ro.cbn.automation.selenium.WebDriverOperations;
import ro.cbn.automation.util.SpringContext;

@ActiveProfiles("chrome")
@ContextConfiguration(classes = {SpringContext.class})
public class LoginPageSteps extends BaseSteps<LoginPage> {

    @Value("${test.url}")
    private String url;

    @Value("${test.username}")
    private String username;

    @Value("${test.password}")
    private String password;

    @Autowired
    private WebDriverOperations webDriverOperations;

    @Given("^I login on dispatcher with admin credentials$")
    public void iLoginOnDispatcherWithAdminCredentials() {
        this.progressTo(new LoginPage(webDriverOperations));
        this.getCurrentScreen().navigateToMainPage(url);
        this.getCurrentScreen().login(username, password);
    }
}
