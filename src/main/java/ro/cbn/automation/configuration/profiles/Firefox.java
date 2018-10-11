package ro.cbn.automation.configuration.profiles;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PreDestroy;

@Profile("firefox")
@Configuration
public class Firefox {
    private static Logger LOG = Logger.getLogger(Chrome.class);

    static {
        System.setProperty("webdriver.gecko.driver", "C:/Automation/geckodriver.exe");
    }

    private WebDriver webDriver;

    @Bean
    public WebDriver getWebDriver() {
        LOG.info("Getting a local firefox driver!");
        try {
            webDriver = new FirefoxDriver(new FirefoxOptions());
        } catch (Exception e) {
            throw new RuntimeException("Firefox driver failed to start -> " + e.getMessage());
        }
        return webDriver;
    }

    @Bean
    public WebDriverWait getWebDriverWait(){
        return new WebDriverWait(getWebDriver(),5);
    }

    @PreDestroy
    public void destroy() {
        if (webDriver != null) {
            webDriver.quit();
            LOG.info("Webdriver was closed");
        } else {
            LOG.warn("Webdriver is null, was closed before predestroy!");
        }
    }
}
