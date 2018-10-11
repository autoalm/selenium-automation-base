package ro.cbn.automation.util;

import org.apache.log4j.Logger;
import ro.cbn.automation.exceptions.TestFrameworkException;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.stripAccents;


public class AutomationHelper {
    private static final Logger LOG = Logger.getLogger(AutomationHelper.class);


    public static Class<?> getPageClass(String pageName) {
        String pageNameKey = stripAccents(pageName).toLowerCase();
        if (PAGE_CLASSES.containsKey(pageNameKey)) {
            return PAGE_CLASSES.get(pageNameKey);
        } else {
            throw new TestFrameworkException("Page name " + pageName + " has no corresponding class defined in AutomationHelper (page name key not found = '" + pageNameKey + "') !");
        }
    }

    private static final Map<String, Class<?>> PAGE_CLASSES = new LinkedHashMap<String, Class<?>>() {{
        put("mainpage", ro.cbn.automation.pages.MainPage.class);
        put("commonpage",ro.cbn.automation.pages.CommonPage.class);
    }};
}