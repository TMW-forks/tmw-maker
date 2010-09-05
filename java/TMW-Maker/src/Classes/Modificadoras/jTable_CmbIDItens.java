package Classes.Modificadoras;

import java.awt.Component;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class jTable_CmbIDItens extends JComboBox implements TableCellRenderer {

    public jTable_CmbIDItens(Vector Lista) {
        super(Lista);
    }
    Vector Itens = new Vector();

    public void addlista(String Item) {
        Itens.addElement(Item);
        super.setModel(new javax.swing.DefaultComboBoxModel(Itens));
    }

    public void setLista(Vector Lista) {
        Itens = Lista;
        super.setModel(new javax.swing.DefaultComboBoxModel(Itens));
    }

    public void setLimpesa() {
        Itens = new Vector();
        super.setModel(new javax.swing.DefaultComboBoxModel(Itens));
    }

    public Vector getlista(Vector Lista) {
        return Itens;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        } // Select the current value setSelectedItem(value); return this; 

        if (value instanceof Integer) {
            if (value != null) {
                for (int I = 0; I < super.getItemCount(); I++) {
                    if (super.getItemAt(I).equals(value)) {
                        super.setSelectedIndex(I);
                    }
                }
            } else {
                setSelectedIndex(0);
            }
        } else {
            setSelectedIndex(0);
        }
        return this;
    }
}