package ro.cbn.automation.configuration.profiles;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PreDestroy;

@Profile("ie")
@Configuration
public class InternetExplorer {

    private static Logger LOG = Logger.getLogger(Chrome.class);

    static {
        System.setProperty("webdriver.ie.driver", "C:/Automation/IEDriverServer.exe");
    }

    private WebDriver webDriver;

    @Bean
    public WebDriver getWebDriver() {
        LOG.info("Getting a local IE driver!");
        try {
            webDriver = new InternetExplorerDriver(new InternetExplorerOptions());
        } catch (Exception e) {
            throw new RuntimeException("IE driver failed to start -> " + e.getMessage());
        }
        return webDriver;
    }

    @Bean
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getWebDriver(), 10);
    }

    @PreDestroy
    public void destroy() {
        if (webDriver != null) {
            webDriver.close();
            LOG.info("Webdriver was closed");
        } else {
            LOG.warn("Webdriver is null, was closed before predestroy!");
        }
    }
}
