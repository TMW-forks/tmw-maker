package Classes.Modificadoras;

import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

public class MyComboBoxEditor extends DefaultCellEditor {
    public MyComboBoxEditor(Vector Lista) {
        super(new JComboBox(Lista));
    }
}
