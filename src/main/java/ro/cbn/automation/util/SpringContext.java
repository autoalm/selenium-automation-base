package ro.cbn.automation.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import ro.cbn.automation.configuration.MainConfiguration;

@Configuration
@ComponentScan("ro.cbn.automation")
@PropertySource("classpath:test.properties")
@ActiveProfiles("chrome")
@ContextConfiguration(classes = SpringContext.class)
public abstract class SpringContext {

}
