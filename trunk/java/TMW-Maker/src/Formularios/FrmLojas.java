
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
    Banco_Lojas Galeria = null;

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
                }else if(column==1){
                    int Preco= Integer.parseInt(aValue.toString().trim());
                    Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(row).setPrecoDeVenda(Preco);
                }
                abrirLojaAtual();
                tblShop.setColumnSelectionInterval(X, X);
                tblShop.setRowSelectionInterval(Y, Y);
                //btnLojaAnterior.setEnabled(false);
                //btnLojaProximo.setEnabled(cmbLojas.getItemCount()>1);
                //btnLojaCriar.setEnabled(true);
                //btnLojaEditar.setEnabled(true);
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);/**/
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
        int L = (cmbLojas.getSelectedIndex()>=0?cmbLojas.getSelectedIndex():Galeria.getContLojas()-1);

        Galeria = new Banco_Lojas(FrmScript.EnderecoDoScript);
        
        btnLojaCriar.setEnabled(true);
        btnLojaEditar.setEnabled(Galeria.getContLojas()>=1);
        btnLojaProximo.setEnabled(Galeria.getContLojas()>=1 && L<cmbLojas.getItemCount()-1);
        btnLojaAnterior.setEnabled(Galeria.getContLojas()>=1 && L>0);
        cmbLojas.setEnabled(Galeria.getContLojas()>=1);
        btnProdutoNovo.setEnabled(Galeria.getContLojas()>=1);
        btnProdutoExcluir.setEnabled(Galeria.getContLojas()>=1 &&Galeria.getLojaPorOrdem(L).getContProdutos()>=2);

        btnLojaAbrir.setEnabled(true);
        btnLojaSalvar.setEnabled(true);
        txtNomeDaLoja.setEnabled(false);
        CmbAparencias.setEnabled(false);
        txtMapa.setEnabled(false);
        txtCoordX.setEnabled(false);
        txtCoordY.setEnabled(false);

        txtNomeDaLoja.setOpaque(false);
        CmbAparencias.setOpaque(false);
        txtMapa.setOpaque(false);
        txtCoordX.setOpaque(false);
        txtCoordY.setOpaque(false);

        tblShop.setEnabled(
            Galeria.getContLojas()>=1 &&
            Galeria.getLojaPorOrdem(L).getContProdutos()>=1
        );

        /*Vector Lojas = new Vector();
        //Vector Carrinho = new Vector();
        for(int l=0;l<Galeria.getContLojas();l++){
            Lojas.addElement(Galeria.getLojaPorOrdem(l).getNomeLoja());
        }/**/

        cmbLojas.setModel(new javax.swing.DefaultComboBoxModel(Galeria.getLojasVector()));
        cmbLojas.setEnabled(Galeria.getContLojas()>=1);
        if(Galeria.getContLojas()>=1) cmbLojas.setSelectedIndex(L<cmbLojas.getItemCount()?L:cmbLojas.getItemCount()-1);
        //abrirLojaAtual();
        FrmPrincipal.setAvisoEmEstatus("Lojas abertas com sucesso!");
   }
    public void abrirLojaAtual(){
        abrirLoja(cmbLojas.getSelectedIndex());
    }
    public void abrirLoja(int G){
        if(Galeria.getContLojas()>=1){
            int Prods = Galeria.getLojaPorOrdem(G).getContProdutos();
            Vector Carrinho = new Vector();
            for(int P=0;P<Prods;P++){
                Carrinho.add(
                    addItemVector(
                        Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getID(),
                        Galeria.getLojaPorOrdem(G).getProdutoPorOrdem(P).getPrecoDeVenda()
                    )
                );
            }
            txtNomeDaLoja.setText(Galeria.getLojaPorOrdem(G).getNomeLoja());
            txtMapa.setText(Galeria.getLojaPorOrdem(G).getMapa());
            txtCoordX.setText(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordX()));
            txtCoordY.setText(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordY()));
            setCorpo(Carrinho);
            setComboAparencia(Galeria.getLojaPorOrdem(G).getImagemLoja());
            btnLojaAnterior.setEnabled(G>0);
            btnLojaProximo.setEnabled(G<cmbLojas.getItemCount()-1);
        }else{
            btnLojaCriar.setEnabled(true);
            btnLojaEditar.setEnabled(false);
            btnLojaProximo.setEnabled(false);
            btnLojaAnterior.setEnabled(false);
            cmbLojas.setEnabled(false);
            btnProdutoNovo.setEnabled(false);
            btnProdutoExcluir.setEnabled(false);
            /*btnLojaAbrir.setEnabled(false);
            btnLojaSalvar.setEnabled(false);

            txtNomeDaLoja.setEnabled(false);
            CmbAparencias.setEnabled(false);
            txtMapa.setEnabled(false);
            txtCoordX.setEnabled(false);
            txtCoordY.setEnabled(false);

            txtNomeDaLoja.setOpaque(false);
            CmbAparencias.setOpaque(false);
            txtMapa.setOpaque(false);
            txtCoordX.setOpaque(false);
            txtCoordY.setOpaque(false);/**/
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnLojaAnterior = new javax.swing.JButton();
        btnLojaProximo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        btnLojaCriar = new javax.swing.JButton();
        btnLojaEditar = new javax.swing.JButton();
        btnLojaSalvar = new javax.swing.JButton();
        btnLojaAbrir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        btnProdutoNovo = new javax.swing.JButton();
        btnProdutoExcluir = new javax.swing.JButton();
        LblImagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblShop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNomeDaLoja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMapa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCoordX = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCoordY = new javax.swing.JTextField();
        CmbAparencias = new javax.swing.JComboBox();
        cmbLojas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Personagens Lojistas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

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
        jToolBar1.add(jSeparator2);

        jLabel5.setText("Lojista:");
        jToolBar1.add(jLabel5);

        btnLojaCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_carrinho.gif"))); // NOI18N
        btnLojaCriar.setToolTipText("Criar Loja");
        btnLojaCriar.setFocusable(false);
        btnLojaCriar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLojaCriar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaCriarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaCriar);

        btnLojaEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_lapis.png"))); // NOI18N
        btnLojaEditar.setToolTipText("Editar Loja");
        btnLojaEditar.setFocusable(false);
        btnLojaEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLojaEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaEditar);

        btnLojaSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_disquete.gif"))); // NOI18N
        btnLojaSalvar.setToolTipText("Salvar Loja");
        btnLojaSalvar.setEnabled(false);
        btnLojaSalvar.setFocusable(false);
        btnLojaSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLojaSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaSalvar);

        btnLojaAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pasta.gif"))); // NOI18N
        btnLojaAbrir.setToolTipText("Abrir Lojas");
        btnLojaAbrir.setEnabled(false);
        btnLojaAbrir.setFocusable(false);
        btnLojaAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLojaAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLojaAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLojaAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLojaAbrir);
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

            },
            new String [] {
                "ID: Nome", "Preço de Venda"
            }
        ));
        jScrollPane3.setViewportView(tblShop);

        txtNomeDaLoja.setText("Etiqueta do NPC");
        txtNomeDaLoja.setEnabled(false);
        txtNomeDaLoja.setOpaque(false);
        txtNomeDaLoja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeDaLojaFocusLost(evt);
            }
        });

        jLabel1.setText("Mapa:");

        txtMapa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMapa.setText("001");
        txtMapa.setEnabled(false);
        txtMapa.setOpaque(false);
        txtMapa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMapaFocusLost(evt);
            }
        });

        jLabel2.setText("Coord. X:");

        txtCoordX.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordX.setText("001");
        txtCoordX.setEnabled(false);
        txtCoordX.setOpaque(false);
        txtCoordX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCoordXFocusLost(evt);
            }
        });

        jLabel3.setText("Coord. Y:");

        txtCoordY.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCoordY.setText("001");
        txtCoordY.setEnabled(false);
        txtCoordY.setOpaque(false);
        txtCoordY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCoordYFocusLost(evt);
            }
        });

        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "048", "049", "100", "101", "102", "103", " " }));
        CmbAparencias.setEnabled(false);
        CmbAparencias.setOpaque(false);
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
                    .addComponent(txtNomeDaLoja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
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
                .addComponent(txtNomeDaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbLojas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblImagem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
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
                LblImagem.setToolTipText(
                    "<html><font size=\"+1\">"+
                    "<b>Nome(ID:"+NPC.getID()+"):</b> " + NPC.getNome()+"<br/>"+
                    "<b>Imagem:</b> " + NPC.getXML()+"?img="+NPC.getVariante()+" ("+NPC.getImagem().getWidth()+"x"+NPC.getImagem().getHeight()+"px)"+"<br/>"+
                    "<b>Comentário:</b> " + NPC.getComentario()+"<br/>"
                );
                int L = (cmbLojas.getSelectedIndex()>=0?cmbLojas.getSelectedIndex():Galeria.getContLojas()-1);
                if(L>=0){
                    String Partes2[] = Selecionado.split(":");
                    if(Partes2.length>=2){
                        int A = Integer.parseInt(Partes2[0]);
                        Galeria.getLojaPorOrdem(L).setImagemLoja(A);
                    }else{
                        Galeria.getLojaPorOrdem(L).setImagemLoja(0);
                    }
                }
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
        abrirLojas();
    }//GEN-LAST:event_formWindowOpened
    private void btnLojaAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaAbrirActionPerformed
        abrirLojas();
    }//GEN-LAST:event_btnLojaAbrirActionPerformed
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
        Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).addProduto(727, -1);
        abrirLojaAtual();
        btnLojaSalvar.setEnabled(true);
        btnLojaAbrir.setEnabled(true);
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
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }
        }else{
            FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório haver pelo menos 1 produto na loja!");
        }

    }//GEN-LAST:event_btnProdutoExcluirActionPerformed
    private void btnLojaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaSalvarActionPerformed

        int L = (cmbLojas.getSelectedIndex()>=0?cmbLojas.getSelectedIndex():Galeria.getContLojas()-1);
        String Aparencia=CmbAparencias.getItemAt(CmbAparencias.getSelectedIndex()).toString();
        Galeria.getLojaPorOrdem(L).setNomeLoja(txtNomeDaLoja.getText());
        String Partes2[] = Aparencia.split(":");
        if(Partes2.length>=2){
            int A = Integer.parseInt(Partes2[0]);
            Galeria.getLojaPorOrdem(L).setImagemLoja(A);
        }else{
            Galeria.getLojaPorOrdem(L).setImagemLoja(0);
        }
        Galeria.getLojaPorOrdem(L).setMapa(txtMapa.getText());
        Galeria.getLojaPorOrdem(L).setCoordX(Integer.parseInt(txtCoordX.getText()));
        Galeria.getLojaPorOrdem(L).setCoordY(Integer.parseInt(txtCoordY.getText()));

        Galeria.arqSalvar(FrmScript.EnderecoDoScript);
        

        /*btnLojaCriar.setEnabled(true);
        btnLojaEditar.setEnabled(Galeria.getContLojas()>=1);
        btnLojaProximo.setEnabled(Galeria.getContLojas()>=1 && L<cmbLojas.getItemCount()-1);
        btnLojaAnterior.setEnabled(Galeria.getContLojas()>=1 && L>0);

        
        btnProdutoNovo.setEnabled(Galeria.getContLojas()>=1);
        btnProdutoExcluir.setEnabled(Galeria.getContLojas()>=1 && Galeria.getLojaPorOrdem(L).getContProdutos()>=2);

        btnLojaAbrir.setEnabled(true);
        btnLojaSalvar.setEnabled(true);
        txtNomeDaLoja.setEnabled(false);
        CmbAparencias.setEnabled(false);
        txtMapa.setEnabled(false);
        txtCoordX.setEnabled(false);
        txtCoordY.setEnabled(false);

        txtNomeDaLoja.setOpaque(false);
        CmbAparencias.setOpaque(false);
        txtMapa.setOpaque(false);
        txtCoordX.setOpaque(false);
        txtCoordY.setOpaque(false);
        
        tblShop.setEnabled(
            Galeria.getContLojas()>=1 &&
            Galeria.getLojaPorOrdem(L).getContProdutos()>=1
        );/**/

        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#0000FF\">AVISO:</FONT> Lojas salvas com sucesso!");

        abrirLojas();

        /*cmbLojas.setEnabled(Galeria.getContLojas()>=1);
        if(Galeria.getContLojas()>=1){
            abrirLojas();
            //cmbLojas.setSelectedIndex(L);
        }/**/
    }//GEN-LAST:event_btnLojaSalvarActionPerformed
    private void btnLojaCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaCriarActionPerformed
        Galeria.addLoja(
            "Loja "+(Galeria.getContLojas()+1), 
            0, 
            (Galeria.getContLojas()>=1?Galeria.getLojaPorOrdem(Galeria.getContLojas()-1).getMapa():"001"),
            100, 100
        );
        Galeria.getLojaPorOrdem(Galeria.getContLojas()-1).addProduto(727, -1);

        btnLojaCriar.setEnabled(false);
        btnLojaEditar.setEnabled(false);
        btnLojaProximo.setEnabled(false);
        btnLojaAnterior.setEnabled(false);
        cmbLojas.setEnabled(false);
        if(Galeria.getContLojas()>=1){
            cmbLojas.setModel(new javax.swing.DefaultComboBoxModel(Galeria.getLojasVector()));
            cmbLojas.setSelectedIndex(cmbLojas.getItemCount()-1);
        }

        btnProdutoNovo.setEnabled(false);
        btnProdutoExcluir.setEnabled(false);

        btnLojaAbrir.setEnabled(true);
        btnLojaSalvar.setEnabled(true);
        txtNomeDaLoja.setEnabled(true);
        CmbAparencias.setEnabled(true);
        txtMapa.setEnabled(true);
        txtCoordX.setEnabled(true);
        txtCoordY.setEnabled(true);

        txtNomeDaLoja.setOpaque(true);
        CmbAparencias.setOpaque(true);
        txtMapa.setOpaque(true);
        txtCoordX.setOpaque(true);
        txtCoordY.setOpaque(true);

        txtNomeDaLoja.setText("Loja "+Galeria.getContLojas());
        setComboAparencia(0);
        txtMapa.setText("001");
        txtCoordX.setText("100");
        txtCoordY.setText("100");


    }//GEN-LAST:event_btnLojaCriarActionPerformed
    private void txtNomeDaLojaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeDaLojaFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            if(!txtNomeDaLoja.getText().equals("")){
                Galeria.getLojaPorOrdem(L).setNomeLoja(txtNomeDaLoja.getText());
                FrmPrincipal.setAvisoEmEstatus("<html>Novo nome do NPC de Loja: <font color=\"#0000FF\">\""+txtNomeDaLoja.getText()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar um nome a loja!");
            }
        }
    }//GEN-LAST:event_txtNomeDaLojaFocusLost
    private void txtMapaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMapaFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            if(!txtMapa.getText().equals("")){
                Galeria.getLojaPorOrdem(L).setMapa(txtMapa.getText());
                FrmPrincipal.setAvisoEmEstatus("<html>Novo mapa do NPC de Loja: <font color=\"#0000FF\">\""+txtMapa.getText()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar um mapa a loja!");
            }
        }
    }//GEN-LAST:event_txtMapaFocusLost
    private void txtCoordXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCoordXFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            if(!txtCoordX.getText().equals("")){
                Galeria.getLojaPorOrdem(L).setCoordX(Integer.parseInt(txtCoordX.getText()));
                FrmPrincipal.setAvisoEmEstatus("<html>Novo mapa do NPC de Loja: <font color=\"#0000FF\">\""+txtCoordX.getText()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar uma Coordenada X a loja!");
            }
        }
    }//GEN-LAST:event_txtCoordXFocusLost
    private void txtCoordYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCoordYFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            if(!txtCoordY.getText().equals("")){
                Galeria.getLojaPorOrdem(L).setCoordY(Integer.parseInt(txtCoordY.getText()));
                FrmPrincipal.setAvisoEmEstatus("<html>Novo mapa do NPC de Loja: <font color=\"#0000FF\">\""+txtCoordY.getText()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar uma Coordenada Y a loja!");
            }
        }
    }//GEN-LAST:event_txtCoordYFocusLost
    private void btnLojaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLojaEditarActionPerformed
        btnLojaCriar.setEnabled(false);
        btnLojaEditar.setEnabled(false);
        btnLojaProximo.setEnabled(false);
        btnLojaAnterior.setEnabled(false);
        cmbLojas.setEnabled(false);
        btnProdutoNovo.setEnabled(false);
        btnProdutoExcluir.setEnabled(false);

        btnLojaAbrir.setEnabled(true);
        btnLojaSalvar.setEnabled(true);
        txtNomeDaLoja.setEnabled(true);
        CmbAparencias.setEnabled(true);
        txtMapa.setEnabled(true);
        txtCoordX.setEnabled(true);
        txtCoordY.setEnabled(true);

        txtNomeDaLoja.setOpaque(true);
        CmbAparencias.setOpaque(true);
        txtMapa.setOpaque(true);
        txtCoordX.setOpaque(true);
        txtCoordY.setOpaque(true);
    }//GEN-LAST:event_btnLojaEditarActionPerformed

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
    private javax.swing.JButton btnLojaAbrir;
    private javax.swing.JButton btnLojaAnterior;
    private javax.swing.JButton btnLojaCriar;
    private javax.swing.JButton btnLojaEditar;
    private javax.swing.JButton btnLojaProximo;
    private javax.swing.JButton btnLojaSalvar;
    private javax.swing.JButton btnProdutoExcluir;
    private javax.swing.JButton btnProdutoNovo;
    private javax.swing.JComboBox cmbLojas;
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
    private javax.swing.JTextField txtMapa;
    private javax.swing.JTextField txtNomeDaLoja;
    // End of variables declaration//GEN-END:variables

}
