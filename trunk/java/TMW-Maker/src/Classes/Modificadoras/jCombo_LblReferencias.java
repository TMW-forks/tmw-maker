/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes.Modificadoras;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author indigovox
 */
public class jCombo_LblReferencias extends JLabel implements ListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (value instanceof String) {
            if (value != null) {
                super.setText(value.toString());

            }
        }
        return this;
    }

}
