
package Formularios;

import Classes.BancoDeDados.Banco_Lojas;
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

public class FrmLojas extends javax.swing.JDialog {
    public FrmLojas(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private static String Barra = System.getProperty("file.separator");
    Banco_Lojas Galeria = new Banco_Lojas(FrmScript.EnderecoDoScript);

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
        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(Lista));
    }
    public Vector addItemVector(int IDTem){
        return addItemVector(IDTem, FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeVenda());
    }
    public Vector addItemVector(int IDTem, int PrecoDeVenda){
        Vector Linha = new Vector();
        //Linha.addElement(new ImageIcon(FrmPrincipal.Itens.getItemPorID(IDTem).getIconeImagem()));
        //Linha.addElement(IDTem);
        //Linha.addElement(FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo());//Se é um
        Linha.addElement("<html>"+
            "<table><tr><td><img align=\"middle\" src=\"file://"+
                FrmPrincipal.Itens.getItemPorID(IDTem).getIconeEndereco()+
            "\"></td><td>"+
                "<b>"+IDTem+":</b> "+FrmPrincipal.Itens.getItemPorID(IDTem).getNomeTitulo()+"<br/>"+
                "<small>"+
                "V:"+FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeVenda()+"GP "+
                "C:"+FrmPrincipal.Itens.getItemPorID(IDTem).getPrecoDeCompra()+"GP "+
                "("+FrmPrincipal.Itens.getItemPorID(IDTem).getPoderEfeito()+")"+
                "</small>"+
            "</td></tr></table>"
        );//Se é um
        Linha.addElement(PrecoDeVenda);
        return Linha;
    }
    public void setCorpo(Vector Dados){
        Vector columnNames = new Vector();
        //columnNames.addElement("IMG");
        columnNames.addElement("<html><big>ID: Item");
        columnNames.addElement("<html><b>Venda</b><br>(GP)");

        tblShop.setRowHeight(38);
        tblShop.setModel(new DefaultTableModel(Dados,columnNames) {
            boolean[] canEdit = new boolean[]{true, true};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });
        //tblShop.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(new jTable_CmbIDItens(FrmPrincipal.Itens.getTitutos()));
        tblShop.getTableHeader().getColumnModel().getColumn(0).setCellEditor(new MyComboBoxEditor(FrmPrincipal.Itens.getTitutos()));

        tblShop.getTableHeader().getColumnModel().getColumn(1).setMinWidth(64);
        tblShop.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(256);
    }
    public void setComboAparencia(int Aparencia){
        for(int A=0;A<CmbAparencias.getItemCount();A++){
            String Partes[] = CmbAparencias.getItemAt(A).toString().split(":");
            if(Partes.length>=2 &&  Integer.parseInt(Partes[0])==Aparencia){
                CmbAparencias.setSelectedIndex(A);
                return;
            }
        }
    }
    public void abrirLojas(){
        Vector Lojas = new Vector();
        Vector Carrinho = new Vector();
        for(int l=0;l<Galeria.getContLojas();l++){
            Lojas.addElement(Galeria.getLojaPorOrdem(l).getNomeLoja());
        }
        cmbLojas.setModel(new javax.swing.DefaultComboBoxModel(Lojas));
        abrirLojaAtual();
    }
    public void abrirLojaAtual(){
        int G = cmbLojas.getSelectedIndex();
        int Prods = Galeria.getLojaPorOrdem(G).getContProdutos();
        Vector Carrinho = new Vector();
        for(int P=0;P<Prods;P++){
            Carrinho.addElement(addItemVector(Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getID()));
        }
        txtEtiqueta.setText(Galeria.getLojaPorOrdem(G).getNomeLoja());
        txtMapa.setText(Galeria.getLojaPorOrdem(G).getMapa());
        txtCoordX.setText(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordX()));
        txtCoordY.setText(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordY()));
        setCorpo(Carrinho);
        setComboAparencia(Galeria.getLojaPorOrdem(G).getImagemLoja());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnUpdateLoja = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cmbLojas = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        LblImagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CmbAparencias = new javax.swing.JComboBox();
        txtEtiqueta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMapa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCoordX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCoordY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel5.setText("Loja:");
        jToolBar1.add(jLabel5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_casa.png"))); // NOI18N
        jButton6.setToolTipText("Nova Loja");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        jButton7.setToolTipText("Salvar Loja");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        btnUpdateLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_update.gif"))); // NOI18N
        btnUpdateLoja.setToolTipText("Atualizar Loja");
        btnUpdateLoja.setFocusable(false);
        btnUpdateLoja.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUpdateLoja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdateLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLojaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUpdateLoja);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/fechar.png"))); // NOI18N
        jButton8.setToolTipText("Excluir Loja");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        jButton1.setToolTipText("Voltar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        cmbLojas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLojasActionPerformed(evt);
            }
        });
        jToolBar1.add(cmbLojas);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        jButton3.setToolTipText("Voltar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator1);

        jLabel4.setText("Produto:");
        jToolBar1.add(jLabel4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_presente.gif"))); // NOI18N
        jButton2.setToolTipText("Adicionar Produto");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        jButton4.setToolTipText("Excluir Produto");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        LblImagem.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        LblImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LblImagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tblShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"3017: Colar Horcrux de Fada", "8000"},
                {"3093: Máscara Necromante", "10000"}
            },
            new String [] {
                "ID: Nome", "Preço de Venda"
            }
        ));
        jScrollPane3.setViewportView(tblShop);

        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "048", "049", "100", "101", "102", "103", " " }));
        CmbAparencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbAparenciasActionPerformed(evt);
            }
        });

        txtEtiqueta.setText("Etiqueta do NPC");

        jLabel1.setText("Mapa:");

        txtMapa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMapa.setText("001");

        jLabel2.setText("Coord. X:");

        txtCoordX.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordX.setText("001");

        jLabel3.setText("Coord. Y:");

        txtCoordY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordY.setText("001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CmbAparencias, 0, 126, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtMapa, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(txtEtiqueta, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoordY, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtCoordX, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbAparencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblImagem)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbAparenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbAparenciasActionPerformed
        if(CmbAparencias.getSelectedIndex()>=1){
            String Selecionado=CmbAparencias.getItemAt(CmbAparencias.getSelectedIndex()).toString();
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
}//GEN-LAST:event_CmbAparenciasActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListarAparencias();
        //SetExemploDeTabela();
        abrirLojas();
        setTitle("L:"+Galeria.getContLojas()+" L(1):"+Galeria.getLojaPorOrdem(0).getContProdutos());
    }//GEN-LAST:event_formWindowOpened
    private void btnUpdateLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLojaActionPerformed
        abrirLojaAtual();
    }//GEN-LAST:event_btnUpdateLojaActionPerformed
    private void cmbLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLojasActionPerformed
        abrirLojaAtual();
    }//GEN-LAST:event_cmbLojasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLojas dialog = new FrmLojas(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox CmbAparencias;
    private javax.swing.JLabel LblImagem;
    private javax.swing.JButton btnUpdateLoja;
    private javax.swing.JComboBox cmbLojas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblShop;
    private javax.swing.JTextField txtCoordX;
    private javax.swing.JTextField txtCoordY;
    private javax.swing.JTextField txtEtiqueta;
    private javax.swing.JTextField txtMapa;
    // End of variables declaration//GEN-END:variables

}
