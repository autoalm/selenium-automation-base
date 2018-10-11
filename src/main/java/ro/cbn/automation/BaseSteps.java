package ro.cbn.automation;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSteps<T> {

    @Autowired
    private WebDriver webDriver;

    protected <Q> Q getCurrentScreen(Class<Q> clz) {
        return (Q) World.getCurrentScreen();
    }

    protected T getCurrentScreen() {
        return (T) World.getCurrentScreen();
    }

    protected void progressTo(Object newScreen) {
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);
        }
        World.setCurrentScreen(newScreen);
    }
}
