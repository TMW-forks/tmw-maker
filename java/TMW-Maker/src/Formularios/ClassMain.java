package Formularios;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
  * @author indigovox
 */

public class ClassMain extends SingleFrameApplication {
    @Override protected void startup() {
        //show(new TesteDeFrame(this));
        show(new FrmPrincipal());
    }
    @Override protected void configureWindow(java.awt.Window root) {
    }
    public static ClassMain getApplication() {
        return Application.getInstance(ClassMain.class);
    }
    public static void main(String[] args) {
        launch(ClassMain.class, args);
    }
}
