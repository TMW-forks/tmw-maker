
package Formularios;

import Classes.ConfigClass;
import java.io.FileReader;
import java.io.FileWriter;

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
                "ID", "Login", "GM*", "IP", "Ultimo Acesso", "Acessos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
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
        //int ID=0,Poder=0;
        String ID="", Nome="",Poder="", Corpo=
            "///////////////////////////////////////////////////////\n"+
            "// Contas de GMs auto-editadas pelo TMW-Maker "+FrmPrincipal.Config.getVersao()+"\n"+
            "// Sumário: <ContaID> <PoderGM>\n"+
            "//          Por padrão a ID:2000000 inicia com GM:99.\n"+
            "///////////////////////////////////////////////////////\n"+
            "\n";
        try {
            for(int c=0;c<TblContas.getRowCount();c++){
                Nome=TblContas.getModel().getValueAt(c,1).toString();
                ID=TblContas.getModel().getValueAt(c,0).toString();
                Poder=TblContas.getModel().getValueAt(c,2).toString();
                if(Integer.parseInt(Poder)<0) Poder="0";
                if(Integer.parseInt(Poder)>99) Poder="99";
                Corpo+=Integer.parseInt(ID)+" "+Integer.parseInt(Poder)+" //"+Nome+"\n";
                //this.setTitle(this.getTitle()+" \""+Nome+"=GM"+Poder+"\"");
            }
            FileWriter out = new FileWriter(EnderecoDeContasGMs);
            out.write(Corpo);
            out.close();
            dispose();
        } catch (java.io.IOException exc) {
            ConfigClass.Mensagem_Erro(
                "<html>Não foi possivel gravar os poderes de GM!<br/>"+
                "<font face=\"monospace\">"+EnderecoDeContasGMs+"</font> (<font color=\"#FF0000\">Falhou</font>)"
                ,"ERRO"
            );
        } catch (Exception exc) {
            ConfigClass.Mensagem_Erro(
                "<html>Não foi possivel gravar os poderes de GM por motivo de valor inválido!<br/><br/>"+
                "<font color=\"#FF0000\">LOCAL DO ERRO:</font><br/>"+
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID: <font face=\"monospace\">"+ID+"</font><br/>"+
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GM: \"<font face=\"monospace\" color=\"#FF0000\">"+Poder+"</font>\"<br/>"+
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login: <font face=\"monospace\">"+Nome+"</font>"
                ,"ERRO"
            );
        }
    }//GEN-LAST:event_BtnAplicarActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        boolean SeArq1=false, SeArq2=false;
        String ConteudoDeContasUsuarios="",ConteudoDeContasGMs="";
        int Inicio=0,Fim=0;
        String ContasUsuarios[] = null,ContasGMs[] = null;

        try {
            FileReader CapsulaDeUsuarios = new FileReader(EnderecoDeContasUsuarios);
            int Caracater = CapsulaDeUsuarios.read();
            while (Caracater!=-1) {
                ConteudoDeContasUsuarios = ConteudoDeContasUsuarios + (char) Caracater;
                Caracater = CapsulaDeUsuarios.read();
            }
            CapsulaDeUsuarios.close();
            Inicio=ConteudoDeContasUsuarios.indexOf("\n2000000");
            ConteudoDeContasUsuarios = ConteudoDeContasUsuarios.substring(Inicio+1, ConteudoDeContasUsuarios.length());
            //ConfigClass.Mensagem_Erro(ConteudoDeContasUsuarios, "Nota de Programador");
            ContasUsuarios = ConteudoDeContasUsuarios.split("\n");
            SeArq1=true;
        } catch (java.io.IOException exc) {
            SeArq1=false;
        }

        try {
            FileReader CapsulaDeGMs = new FileReader(EnderecoDeContasGMs);
            int Caracater = CapsulaDeGMs.read();
            while (Caracater!=-1) {
                ConteudoDeContasGMs = ConteudoDeContasGMs + (char) Caracater;
                Caracater = CapsulaDeGMs.read();
            }
            CapsulaDeGMs.close();
            Inicio=ConteudoDeContasGMs.indexOf("\n2000000");
            ConteudoDeContasGMs = ConteudoDeContasGMs.substring(Inicio+1, ConteudoDeContasGMs.length());
            //ConfigClass.Mensagem_Erro(ConteudoDeContasUsuarios, "Nota de Programador");
            //ContasGMs = ConteudoDeContasGMs.split("\n");
            SeArq2=true;
        } catch (java.io.IOException exc) {
            SeArq2=false;
        }

        if(SeArq1==true && SeArq2==true){
            //ConfigClass.Mensagem_Erro("Contagem(Contas)="+Contas.length, "Nota de Programador");
            String Cabecalho[] = new String [] { "ID", "Login", "GM*", "IP", "Ultimo Acesso", "Acessos"};
            Object CorpoDeContasUsuarios[][] = new Object [ContasUsuarios.length-1][Cabecalho.length];
            //Object CorpoDeContasGMs[] = new Object [ContasUsuarios.length-1];
            String NovaLinha="",PartesDaLinha[];

            /*for(int c=0;c<ContasGMs.length-1;c++){
                PartesDaLinha=ContasGMs[c].split(" ");
                CorpoDeContasGMs[PartesDaLinha[0]] = new String();
                CorpoDeContasGMs[PartesDaLinha[0]] = PartesDaLinha[1];
            }/**/

            String LvlGM;
            for(int c=0;c<ContasUsuarios.length-1;c++){
                LvlGM="0";
                PartesDaLinha=ContasUsuarios[c].split("\t");
                Inicio=ConteudoDeContasGMs.indexOf(PartesDaLinha[0]);
                if(Inicio>=0){
                    Inicio+=PartesDaLinha[0].length()+1;
                    //Fim=ConteudoDeContasGMs.indexOf("\n", Inicio);
                    Fim=Inicio+2;
                    //if(Fim<=Inicio)Fim=ConteudoDeContasGMs.length();
                    if(Fim>Inicio) LvlGM=ConteudoDeContasGMs.substring(Inicio, Fim).trim();
                }

                CorpoDeContasUsuarios[c] = new String [] {
                    PartesDaLinha[0],
                    PartesDaLinha[1]+" ("+PartesDaLinha[4]+")",
                    LvlGM,
                    PartesDaLinha[10],
                    PartesDaLinha[3],
                    PartesDaLinha[5]
                };
            }

            TblContas.setModel(new javax.swing.table.DefaultTableModel(CorpoDeContasUsuarios,Cabecalho) {
                boolean[] canEdit = new boolean [] {false, false, true, false, false, false};
                public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
            });
            TblContas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(75);
            TblContas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(75);

            //TblContas.getTableHeader().getColumnModel().getColumn(1).setMinWidth(150);
            //TblContas.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(150);

            TblContas.getTableHeader().getColumnModel().getColumn(2).setMinWidth(40);
            TblContas.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(40);

            TblContas.getTableHeader().getColumnModel().getColumn(3).setMinWidth(70);
            TblContas.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(70);

            TblContas.getTableHeader().getColumnModel().getColumn(4).setMinWidth(170);
            TblContas.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(170);

            TblContas.getTableHeader().getColumnModel().getColumn(5).setMinWidth(70);
            TblContas.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(70);
        }else{
            ConfigClass.Mensagem_Erro(
                "<html>Não foi possivel abrir os arquivos de contas!<br/>"+
                "<font face=\"monospace\">"+EnderecoDeContasUsuarios+"</font> "+(SeArq1==false?"(<font color=\"#FF0000\">Falhou</font>)":"(<font color=\"#0000FF\">OK</font>)")+"<br/>"+
                "<font face=\"monospace\">"+EnderecoDeContasGMs+"</font> "+(SeArq2==false?"(<font color=\"#FF0000\">Falhou</font>)":"(<font color=\"#0000FF\">OK</font>)")
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
