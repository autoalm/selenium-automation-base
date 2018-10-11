package ro.cbn.automation.configuration.profiles;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PreDestroy;


@Profile("chrome")
@Configuration
public class Chrome {
    private static Logger LOG = Logger.getLogger(Chrome.class);

    static {
        System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver.exe");
    }

    private WebDriver webDriver;

    @Bean
    public WebDriver getWebDriver() {
        LOG.info("Getting a local chrome driver!");
        try {
            webDriver = new ChromeDriver(new ChromeOptions());
        } catch (Exception e) {
            throw new RuntimeException("Chrome driver failed to start -> " + e.getMessage());
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
