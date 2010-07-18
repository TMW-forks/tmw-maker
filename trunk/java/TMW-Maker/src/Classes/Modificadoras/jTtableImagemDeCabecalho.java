
package Classes.Modificadoras;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class jTtableImagemDeCabecalho implements TableCellRenderer{
    private JLabel rot = null;

    public Component getTableCellRendererComponent(
        JTable Tabela,
        Object Valor,
        boolean SeSelecionada,
        boolean SeFocalizada,
        int Linha,
        int Coluna
    ) {
        rot = new JLabel(Valor.toString());
        TableCellRenderer tcr = Tabela.getTableHeader().getDefaultRenderer();

        Component Componente = tcr.getTableCellRendererComponent(Tabela, Valor, SeSelecionada, SeFocalizada, Linha, Coluna);

        rot.setFont(Componente.getFont());
        rot.setForeground(Color.RED);
        rot.setBorder(((JComponent) Componente).getBorder());
        rot.setText((String) Valor);
        rot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_char.png"))); // NOI18N

        return rot;
    }

    public void setTableCellRendererComponent(
        JTable Tabela,
        Object Valor,
        boolean SeSelecionada,
        boolean SeFocalizada,
        int Linha,
        int Coluna
    ){
        rot = new JLabel(Valor.toString());
        TableCellRenderer tcr = Tabela.getTableHeader().getDefaultRenderer();

        Component Componente = tcr.getTableCellRendererComponent(Tabela, Valor, SeSelecionada, SeFocalizada, Linha, Coluna);

        rot.setFont(Componente.getFont());
        rot.setForeground(Color.RED);
        rot.setBorder(((JComponent) Componente).getBorder());
        rot.setText((String) Valor);
        rot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_char.png"))); // NOI18N

    }
}

