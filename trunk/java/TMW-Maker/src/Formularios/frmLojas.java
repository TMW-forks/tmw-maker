
package Formularios;

import Classes.BancoDeDados.Dados_NPC;
import Classes.ImagemTratavel;
import Classes.Modificadoras.MyComboBoxEditor;
import Classes.Modificadoras.jTable_CmbIDItens;
import Classes.Modificadoras.jTtableImagemDeColuna;
import Classes.SpriteDados;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class frmLojas extends javax.swing.JDialog {
    public frmLojas(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void ListarAparencias(){
        Dados_NPC NPC = null;
        Vector Lista = new Vector();
        Lista.add("Não (Script Intangível)");
        for(int n=0;n<FrmPrincipal.NPCs.getContNPCs();n++){
            NPC = FrmPrincipal.NPCs.getNPCporOrdem(n);
            if(NPC!=null){
                if(NPC.getSprite()!=null){
                    if(NPC.getID()>0) Lista.add(NPC.getID()+": "+(NPC.getNome().equals("")?"\""+NPC.getComentario().trim()+"\"":NPC.getNome()));
                }
            }
        }
        CmbNovoBlocoScriptImagem.setModel(new javax.swing.DefaultComboBoxModel(Lista));
    }
    public Vector addItem(int IDTem){
        return addItem(IDTem, FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeVenda());
    }
    public Vector addItem(int IDTem, int PrecoDeVenda){
        Vector Linha = new Vector();
        Linha.addElement(new ImageIcon(FrmPrincipal.Itens.getItemPorID(IDTem).getIconeImagem()));
        Linha.addElement(IDTem);
        Linha.addElement(FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo());//Se é um
        Linha.addElement(PrecoDeVenda);
        return Linha;
    }
    public void setCorpo(Vector Dados){
        Vector columnNames = new Vector();
        columnNames.addElement("IMG");
        columnNames.addElement("ID");
        columnNames.addElement("Item");
        columnNames.addElement("Venda(GP)");

        tblShop.setRowHeight(32);
        tblShop.setModel(new DefaultTableModel(Dados,columnNames) {
            boolean[] canEdit = new boolean[]{false, true, false, true};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });

        tblShop.getTableHeader().getColumnModel().getColumn(0).setCellRenderer(new jTtableImagemDeColuna());
        //tblShop.setRowHeight(0, 32);
        tblShop.getTableHeader().getColumnModel().getColumn(0).setMinWidth(32);
        tblShop.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(32);
        
        //TableCellRenderer Tipo2 = CmbIDItens;
        tblShop.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(new jTable_CmbIDItens(FrmPrincipal.Itens.getIDs()));
        tblShop.getTableHeader().getColumnModel().getColumn(1).setCellEditor(new MyComboBoxEditor(FrmPrincipal.Itens.getIDs()));
        tblShop.getTableHeader().getColumnModel().getColumn(1).setMinWidth(64);
        tblShop.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(64);

        tblShop.getTableHeader().getColumnModel().getColumn(3).setMinWidth(64);
        tblShop.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(256);
    }
    public void Teste_D02(){
        Vector Carrinho = new Vector();
        Carrinho.addElement(addItem(3017));
        Carrinho.addElement(addItem(3093));
        setCorpo(Carrinho);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        LblImagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CmbNovoBlocoScriptImagem = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        jButton1.setToolTipText("Voltar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jToolBar1.add(jComboBox1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        jButton3.setToolTipText("Voltar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator1);

        LblImagem.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        LblImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LblImagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tblShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "3017", "Colar Horcrux de Fada", "8000"},
                {null, "3093", "Máscara Necromante", "10000"}
            },
            new String [] {
                "IMG", "ID", "Nome", "Preço de Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblShop);

        CmbNovoBlocoScriptImagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "048", "049", "100", "101", "102", "103", " " }));
        CmbNovoBlocoScriptImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbNovoBlocoScriptImagemActionPerformed(evt);
            }
        });

        jTextField2.setText("Etiqueta do NPC");

        jLabel1.setText("Mapa:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("001");

        jLabel2.setText("Coord. X:");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("001");

        jLabel3.setText("Coord. Y:");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CmbNovoBlocoScriptImagem, 0, 126, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbNovoBlocoScriptImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbNovoBlocoScriptImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbNovoBlocoScriptImagemActionPerformed
        if(CmbNovoBlocoScriptImagem.getSelectedIndex()>=1){
            String Selecionado=CmbNovoBlocoScriptImagem.getItemAt(CmbNovoBlocoScriptImagem.getSelectedIndex()).toString();
            String Partes[] = Selecionado.split(":");
            if(Partes.length>=2){
                Dados_NPC NPC = FrmPrincipal.NPCs.getNPCporID(Integer.parseInt(Partes[0]));
                ImagemTratavel Imagem = new ImagemTratavel(NPC.getImagem());
                Imagem.setZoom(2.0);
                LblImagem.setIcon(new javax.swing.ImageIcon(Imagem.getImage()));
                LblImagem.setToolTipText("<html><font size=\"+1\">"+
                        "<b>Nome(ID:"+NPC.getID()+"):</b> " + NPC.getNome()+"<br/>"+
                        "<b>Imagem:</b> " + NPC.getXML()+"?img="+NPC.getVariante()+" ("+NPC.getImagem().getWidth()+"x"+NPC.getImagem().getHeight()+"px)"+"<br/>"+
                        "<b>Comentário:</b> " + NPC.getComentario()+"<br/>"
                        );
            }else{
                LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png")));
                LblImagem.setToolTipText(null);
            }
        }else{
            LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png")));
            LblImagem.setToolTipText(null);
        }
}//GEN-LAST:event_CmbNovoBlocoScriptImagemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListarAparencias();
        Teste_D02();
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLojas dialog = new frmLojas(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox CmbNovoBlocoScriptImagem;
    private javax.swing.JLabel LblImagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblShop;
    // End of variables declaration//GEN-END:variables

}
