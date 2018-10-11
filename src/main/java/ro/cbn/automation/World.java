package ro.cbn.automation;

public class World {

    private static Object currentScreen;

    public static Object getCurrentScreen() {
        return currentScreen;
    }

    public static <T> void setCurrentScreen(Object object) {
        currentScreen = object;
    }
}
