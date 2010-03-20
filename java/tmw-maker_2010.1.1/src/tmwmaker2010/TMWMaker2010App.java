/*
 * TMWMaker2010App.java
 */

package tmwmaker2010;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class TMWMaker2010App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new TMWMaker2010View(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TMWMaker2010App
     */
    public static TMWMaker2010App getApplication() {
        return Application.getInstance(TMWMaker2010App.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(TMWMaker2010App.class, args);
    }
}
