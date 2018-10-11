package ro.cbn.automation.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ro.cbn.automation")
@PropertySource("classpath:test.properties")
public class MainConfiguration {
}
