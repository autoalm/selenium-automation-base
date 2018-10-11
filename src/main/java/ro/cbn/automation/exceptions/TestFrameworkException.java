package ro.cbn.automation.exceptions;

/**
 * Created by ab51xj on 1/30/2017.
 */
public class TestFrameworkException extends RuntimeException {
    public TestFrameworkException(String message) {
        super("There is something wrong with the test framework: " + message);
    }
}
