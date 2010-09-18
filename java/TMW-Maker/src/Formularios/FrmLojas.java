
package Formularios;

import Classes.BancoDeDados.Banco_Lojas;
import Classes.BancoDeDados.Dados_NPC;
import Classes.ImagemTratavel;
import Classes.Mensagem;
import Classes.Modificadoras.MyComboBoxEditor;
import Classes.StringClass;
import java.lang.reflect.Array;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
                    //if(NPC.getID()>0) Lista.add(NPC.getID());
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
        Vector NomesDeColuna = new Vector();
        //NomesDeColuna.addElement("IMG");
        NomesDeColuna.addElement("<html><big>ID: Item");
        NomesDeColuna.addElement("<html><b>Venda</b><br>(GP)");

        tblShop.setRowHeight(38);
        tblShop.setModel(new DefaultTableModel(Dados,NomesDeColuna) {
            boolean[] canEdit = new boolean[]{true, true};
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                int X=tblShop.getSelectedColumn(), Y=tblShop.getSelectedRow();
                if(column==0){
                    StringClass Item = new StringClass(aValue.toString());
                    int ID= Integer.parseInt(Item.extrairEntre("<td><b>", ":</b>"));
                    Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setID(ID);
                    FrmPrincipal.setAvisoEmEstatus("ID:"+ID);
                }else if(column==1){
                    int Preco= Integer.parseInt(aValue.toString().trim());
                    Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setPrecoDeVenda(Preco);
                    FrmPrincipal.setAvisoEmEstatus("Preço:"+
                        Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).getPrecoDeVenda()
                    );
                }
                abrirLojaAtual();
                tblShop.setColumnSelectionInterval(X, X);
                tblShop.setRowSelectionInterval(Y, Y);
            }/**/
        });
        //tblShop.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(new jTable_CmbIDItens(FrmPrincipal.Itens.getTitutos()));
        tblShop.getTableHeader().getColumnModel().getColumn(0).setCellEditor(new MyComboBoxEditor(FrmPrincipal.Itens.getTitutos()));

        tblShop.getTableHeader().getColumnModel().getColumn(1).setMinWidth(64);
        tblShop.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(256);
    }
    public void setComboAparencia(int Aparencia){
        for(int A=0;A<CmbAparencias.getItemCount();A++){
            String Partes[] = CmbAparencias.getItemAt(A).toString().split(":");
            if(Partes.length>=2 && Integer.parseInt(Partes[0])==Aparencia){
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
            //Vector Produto = new Vector();
            //Produto.addElement(addItemVector(Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getID()));
            //Produto.addElement(Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getPrecoDeVenda());
            //Carrinho.add(Produto);
            Carrinho.add(
                addItemVector(
                    Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getID(),
                    Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getPrecoDeVenda()
                )
            );
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
        jButton7 = new javax.swing.JButton();
        btnUpdateLoja = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        btnLojaAnterior = new javax.swing.JButton();
        btnLojaProximo = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        btnProdutoNovo = new javax.swing.JButton();
        btnProdutoExcluir = new javax.swing.JButton();
        LblImagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtEtiqueta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMapa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCoordX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCoordY = new javax.swing.JTextField();
        CmbAparencias = new javax.swing.JComboBox();
        cmbLojas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Lojas (Modo Somento Leitura)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        jButton7.setToolTipText("Salvar Loja");
        jButton7.setEnabled(false);
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
        jToolBar1.add(jSeparator2);

        jLabel5.setText("Loja:");
        jToolBar1.add(jLabel5);

        btnLojaAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_voltar.gif"))); // NOI18N
        btnLojaAnterior.setToolTipText("Voltar");
        btnLojaAnterior.setFocusable(false);
        btnLojaAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLojaAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaAnterior);

        btnLojaProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_avancar.gif"))); // NOI18N
        btnLojaProximo.setToolTipText("Voltar");
        btnLojaProximo.setFocusable(false);
        btnLojaProximo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLojaProximo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaProximoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaProximo);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_casa.png"))); // NOI18N
        jButton6.setToolTipText("Nova Loja");
        jButton6.setEnabled(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/fechar.png"))); // NOI18N
        jButton8.setToolTipText("Excluir Loja");
        jButton8.setEnabled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator1);

        jLabel4.setText("Produto:");
        jToolBar1.add(jLabel4);

        btnProdutoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_presente.gif"))); // NOI18N
        btnProdutoNovo.setToolTipText("Adicionar Produto");
        btnProdutoNovo.setFocusable(false);
        btnProdutoNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProdutoNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProdutoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProdutoNovo);

        btnProdutoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lixeira.png"))); // NOI18N
        btnProdutoExcluir.setToolTipText("Excluir Produto");
        btnProdutoExcluir.setFocusable(false);
        btnProdutoExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProdutoExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProdutoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProdutoExcluir);

        LblImagem.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmwmaker-96x96px.png"))); // NOI18N
        LblImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LblImagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tblShop.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        txtEtiqueta.setText("Etiqueta do NPC");
        txtEtiqueta.setEnabled(false);
        txtEtiqueta.setOpaque(false);

        jLabel1.setText("Mapa:");

        txtMapa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMapa.setText("001");
        txtMapa.setEnabled(false);
        txtMapa.setOpaque(false);

        jLabel2.setText("Coord. X:");

        txtCoordX.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordX.setText("001");
        txtCoordX.setEnabled(false);
        txtCoordX.setOpaque(false);

        jLabel3.setText("Coord. Y:");

        txtCoordY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordY.setText("001");
        txtCoordY.setEnabled(false);
        txtCoordY.setOpaque(false);

        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "048", "049", "100", "101", "102", "103", " " }));
        CmbAparencias.setEnabled(false);
        CmbAparencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbAparenciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtMapa, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(txtEtiqueta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoordY, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtCoordX, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                    .addComponent(CmbAparencias, 0, 126, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbAparencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
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

        cmbLojas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLojasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbLojas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblImagem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cmbLojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        //setTitle("L:"+Galeria.getContLojas()+" L(1):"+Galeria.getLojaPorOrdem(0).getContProdutos());
    }//GEN-LAST:event_formWindowOpened
    private void btnUpdateLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLojaActionPerformed
        abrirLojas();
    }//GEN-LAST:event_btnUpdateLojaActionPerformed
    private void cmbLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLojasActionPerformed
        abrirLojaAtual();
    }//GEN-LAST:event_cmbLojasActionPerformed
    private void btnLojaProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaProximoActionPerformed
        if(cmbLojas.getSelectedIndex()<cmbLojas.getItemCount()-1) cmbLojas.setSelectedIndex(cmbLojas.getSelectedIndex()+1);
    }//GEN-LAST:event_btnLojaProximoActionPerformed
    private void btnLojaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaAnteriorActionPerformed
        if(cmbLojas.getSelectedIndex()>0) cmbLojas.setSelectedIndex(cmbLojas.getSelectedIndex()-1);
    }//GEN-LAST:event_btnLojaAnteriorActionPerformed
    private void btnProdutoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoNovoActionPerformed
        Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).addProduto(727, 0);
        abrirLojaAtual();
    }//GEN-LAST:event_btnProdutoNovoActionPerformed
    private void btnProdutoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoExcluirActionPerformed
        //Mensagem Dialogo = new Mensagem();
        if(Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getContProdutos()>1){
            int X=tblShop.getSelectedColumn(), Y=tblShop.getSelectedRow();
            if(X>=0 && Y>=0){
                int ID = Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(Y).getID();
                ImagemTratavel Item = new ImagemTratavel(FrmPrincipal.Itens.getItemPorID(ID).getIconeImagem());
                Item.setZoom(3.0);
                int R=Mensagem.showOpcoes(
                    "Deseja realmente excluir este produto do estoque de Loja?",
                    "EXCLUIR ITEM DO ESTOQUE",
                    Item.getIcone(),
                    new Object[]{"SIM","NÃO"},
                    1
                );
                if(R==0){
                    Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).delProdutoPorOrdem(Y);
                    abrirLojaAtual();
                    if(tblShop.getRowCount()>=1){
                        tblShop.setColumnSelectionInterval(X, X);
                        if(Y>tblShop.getRowCount()-1){
                            tblShop.setRowSelectionInterval(Y-1, Y-1);
                        }else{
                            tblShop.setRowSelectionInterval(Y, Y);
                        }
                    }
                }
            }
        }else{
            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório haver pelo menos 1 produto na loja!");
        }

    }//GEN-LAST:event_btnProdutoExcluirActionPerformed

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
    private javax.swing.JButton btnLojaAnterior;
    private javax.swing.JButton btnLojaProximo;
    private javax.swing.JButton btnProdutoExcluir;
    private javax.swing.JButton btnProdutoNovo;
    private javax.swing.JButton btnUpdateLoja;
    private javax.swing.JComboBox cmbLojas;
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
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblShop;
    private javax.swing.JTextField txtCoordX;
    private javax.swing.JTextField txtCoordY;
    private javax.swing.JTextField txtEtiqueta;
    private javax.swing.JTextField txtMapa;
    // End of variables declaration//GEN-END:variables

}
