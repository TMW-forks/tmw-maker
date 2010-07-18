package Classes.Modificadoras;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class jTtableImagemDeColuna extends JLabel implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        /****************************************************************************
         * Essa parte prepara a coluna para colorir por foco em uma de suas celulas.
         *****************************************************************************/
        setOpaque(true);
        if (hasFocus) {
            super.setBackground(Color.cyan);
        } else if (isSelected) {
            super.setBackground(Color.lightGray);
        } else {
            super.setBackground(Color.white);
        }
        super.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        /****************************************************************************
         * Essa parte prepara a coluna para receber o Icone em uma de suas celulas.
         *****************************************************************************/
        if (value instanceof ImageIcon) {
            if (value != null) {
                ImageIcon d = (ImageIcon) value;
                setIcon(d);
                setText("");
                setToolTipText(value.toString());
            } else {
                setText(value.toString());
                setToolTipText("");
                setIcon(null);
            }
        }else{
            //super.setValue(value);
            setText(value.toString());
            setIcon(null);
        }
        return this;
    }
}
