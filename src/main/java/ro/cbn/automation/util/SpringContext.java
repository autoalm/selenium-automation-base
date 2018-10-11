package ro.cbn.automation.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan("ro.cbn.automation")
@PropertySource("classpath:test.properties")
@ContextConfiguration(classes = SpringContext.class)
public abstract class SpringContext {

}
