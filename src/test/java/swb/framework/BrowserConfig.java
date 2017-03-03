package swb.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@Configuration
@Import(WebDriverConfig.class)
@TestExecutionListeners(listeners = {ScreenshotTaker.class, DependencyInjectionTestExecutionListener.class})
public class BrowserConfig {

    @Bean(destroyMethod = "quit")
    @Scope("prototype")
    public Browser browser(WebDriver driver) {
        return new Browser(driver);
    }
    
   // @TestExecutionListeners(listeners = {ScreenshotTaker.class, DependencyInjectionTestExecutionListener.class})
    public static class ConfigShim {
    }
}
