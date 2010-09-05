
package Classes.Modificadoras;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class jTtableImagemDeCabecalho implements TableCellRenderer{
    private JLabel Etiqueta = null;

    public Component getTableCellRendererComponent(
        JTable Tabela,
        Object Valor,
        boolean SeSelecionada,
        boolean SeFocalizada,
        int Linha,
        int Coluna
    ) {
        Etiqueta = new JLabel(Valor.toString());
        TableCellRenderer tcr = Tabela.getTableHeader().getDefaultRenderer();

        Component Componente = tcr.getTableCellRendererComponent(Tabela, Valor, SeSelecionada, SeFocalizada, Linha, Coluna);

        Etiqueta.setFont(Componente.getFont());
        Etiqueta.setForeground(Color.RED);
        Etiqueta.setBorder(((JComponent) Componente).getBorder());
        Etiqueta.setText((String) Valor);
        Etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_char.png"))); // NOI18N

        return Etiqueta;
    }

    public void setTableCellRendererComponent(
        JTable Tabela,
        Object Valor,
        boolean SeSelecionada,
        boolean SeFocalizada,
        int Linha,
        int Coluna
    ){
        Etiqueta = new JLabel(Valor.toString());
        TableCellRenderer tcr = Tabela.getTableHeader().getDefaultRenderer();

        Component Componente = tcr.getTableCellRendererComponent(Tabela, Valor, SeSelecionada, SeFocalizada, Linha, Coluna);

        Etiqueta.setFont(Componente.getFont());
        Etiqueta.setForeground(Color.RED);
        Etiqueta.setBorder(((JComponent) Componente).getBorder());
        Etiqueta.setText((String) Valor);
        Etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_char.png"))); // NOI18N

    }
}

