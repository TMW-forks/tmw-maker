
package Formularios;

import Classes.ConfigClass;
import java.io.FileReader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FrmContas extends javax.swing.JDialog {
    public FrmContas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String EnderecoDeContasUsuarios = FrmPrincipal.Config.getConexaoLocalhost()+
        System.getProperty("file.separator")+"eathena-data"+
        System.getProperty("file.separator")+"save"+
        System.getProperty("file.separator")+"account.txt";
    static String EnderecoDeContasGMs = FrmPrincipal.Config.getConexaoLocalhost()+
        System.getProperty("file.separator")+"eathena-data"+
        System.getProperty("file.separator")+"conf"+
        System.getProperty("file.separator")+"gm_account.txt";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblContas = new javax.swing.JTable();
        BtnFechar = new javax.swing.JButton();
        BtnAplicar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas do Localhost");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TblContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "IP", "Acesso", "GM*"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblContas.setOpaque(false);
        jScrollPane1.setViewportView(TblContas);

        BtnFechar.setMnemonic('F');
        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_contato.gif"))); // NOI18N
        BtnAplicar.setMnemonic('A');
        BtnAplicar.setText("Aplicar");
        BtnAplicar.setEnabled(false);
        BtnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAplicarActionPerformed(evt);
            }
        });

        jLabel1.setText("* Coluna Editável (F2)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(BtnAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAplicar, BtnFechar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(BtnAplicar)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnAplicar, BtnFechar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed
    private void BtnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAplicarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAplicarActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        String Conteudo="";
        try {
            FileReader CapsulaDeUsuarios = new FileReader(EnderecoDeContasUsuarios);
            int Caracater = CapsulaDeUsuarios.read();
            while (Caracater!=-1) {
                Conteudo = Conteudo + (char) Caracater;
                Caracater = CapsulaDeUsuarios.read();
            }
            CapsulaDeUsuarios.close();

            int Inicio =Conteudo.indexOf("2000000");
            Conteudo = Conteudo.substring(Inicio, Conteudo.length());
            //ConfigClass.Mensagem_Erro(Conteudo, "Nota de Programador");

            String Contas[] = Conteudo.split("\n");
            //ConfigClass.Mensagem_Erro("Contagem(Contas)="+Contas.length, "Nota de Programador");
            String Cabecalho[] = new String [] { "ID", "Login", "IP", "Acesso", "GM*"};
            Object Corpo[][] = new Object [Contas.length-1][Cabecalho.length];
            String NovaLinha="",PartesDaLinha[];
            for(int c=0;c<Contas.length-1;c++){
                PartesDaLinha=Contas[c].split("\t");
                Corpo[c] = new String [] {
                    PartesDaLinha[0],
                    PartesDaLinha[1]+" ("+PartesDaLinha[4]+")",
                    PartesDaLinha[10],
                    PartesDaLinha[3],
                    "???"
                };
            }

            TblContas.setModel(new javax.swing.table.DefaultTableModel(Corpo,Cabecalho) {
                boolean[] canEdit = new boolean [] {false, false, false, false, true};
                public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
            });
            TblContas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(75);
            TblContas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(75);

            //TblContas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(150);
            //TblContas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(150);

            TblContas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(70);
            TblContas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(70);

            TblContas.getTableHeader().getColumnModel().getColumn(3).setMinWidth(170);
            TblContas.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(170);

            TblContas.getTableHeader().getColumnModel().getColumn(4).setMinWidth(40);
            TblContas.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(40);

        } catch (java.io.IOException exc) {
            ConfigClass.Mensagem_Erro(
                "<html>Não foi possivel abrir o arquivo!"+
                "<font face=\"monospace\" color=\"#FF00000\">"+EnderecoDeContasUsuarios
                ,"AVISO"
            );
        }
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmContas dialog = new FrmContas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAplicar;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JTable TblContas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
