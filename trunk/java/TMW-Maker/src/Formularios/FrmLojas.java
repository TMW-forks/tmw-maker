
package Formularios;

import Classes.BancoDeDados.Banco_Lojas;
import Classes.BancoDeDados.Banco_NPCs.Dados_NPC;
import Classes.ImagemClass;
import Classes.DialogClass;
import Classes.Modificadoras.MyComboBoxEditor;
import Classes.StringClass;
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
          //Carrega a imagem antes de usar!
        for(int n=0;n<FrmPrincipal.bdNPCs.getContNPCs();n++){
            NPC = FrmPrincipal.bdNPCs.getNPCporOrdem(n);
            if(NPC!=null){
                
                
                    if(NPC.getID()>0) Lista.add(NPC.getID()+": "+(NPC.getNome().equals("")?"\""+NPC.getComentario().trim()+"\"":NPC.getNome()));
                    //if(NPC.getID()>0) Lista.add(NPC.getID());
                
            }
        }
        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(Lista));
    }
    public Vector addItemVector(int IDTem){
        return addItemVector(IDTem, FrmPrincipal.bdProds.getItemPorID(IDTem).getPrecoDeVenda());
    }
    public Vector addItemVector(int IDTem, int PrecoDeVenda){
        Vector Linha = new Vector();
        //Linha.addElement(new ImageIcon(FrmPrincipal.bdProds.getItemPorID(IDTem).getIconeImagem()));
        //Linha.addElement(IDTem);
        //Linha.addElement(FrmPrincipal.bdProds.getItemPorID(IDTem).getNomeTitulo());//Se é um
        Linha.addElement("<html>"+
            "<table><tr><td><img align=\"middle\" src=\"file://"+
                FrmPrincipal.bdProds.getItemPorID(IDTem).getIconeEndereco()+
            "\"></td><td>"+
                "<b>"+IDTem+":</b> "+FrmPrincipal.bdProds.getItemPorID(IDTem).getNomeTitulo()+"<br/>"+
                "<small>"+
                "V:"+FrmPrincipal.bdProds.getItemPorID(IDTem).getPrecoDeVenda()+"GP "+
                "C:"+FrmPrincipal.bdProds.getItemPorID(IDTem).getPrecoDeCompra()+"GP "+
                "("+FrmPrincipal.bdProds.getItemPorID(IDTem).getPoderEfeito()+")"+
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
        //tblShop.getTableHeader().getColumnModel().getColumn(1).setCellRenderer(new jTable_CmbIDItens(FrmPrincipal.bdProds.getTitutos()));
        tblShop.getTableHeader().getColumnModel().getColumn(0).setCellEditor(new MyComboBoxEditor(FrmPrincipal.bdProds.getTitutos()));

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
        cmbMapas.setEnabled(false);
        spnCoordX.setEnabled(false);
        spnCoordY.setEnabled(false);

        txtNomeDaLoja.setOpaque(false);
        CmbAparencias.setOpaque(false);
        cmbMapas.setOpaque(false);
        spnCoordX.setOpaque(false);
        spnCoordY.setOpaque(false);

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
            for(int M=0;M<cmbMapas.getItemCount();M++){
                if(Galeria.getLojaPorOrdem(G).getMapa().equals(cmbMapas.getItemAt(M).toString())){
                    cmbMapas.setSelectedIndex(M);
                    M=cmbMapas.getItemCount();
                }
            }/**/
            //spnCoordX.setValue(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordX()));

            spnCoordX.setModel(
                new javax.swing.SpinnerNumberModel(
                    Integer.valueOf(Galeria.getLojaPorOrdem(G).getCoordX()),
                    Integer.valueOf(0),
                    Integer.valueOf(FrmPrincipal.bdWarps.getMapaPorOrdem(cmbMapas.getSelectedIndex()).getLargura()),
                    Integer.valueOf(1)
                )
            );
            spnCoordY.setModel(
                new javax.swing.SpinnerNumberModel(
                    Integer.valueOf(Galeria.getLojaPorOrdem(G).getCoordY()),
                    Integer.valueOf(0),
                    Integer.valueOf(FrmPrincipal.bdWarps.getMapaPorOrdem(cmbMapas.getSelectedIndex()).getAltura()),
                    Integer.valueOf(1)
                )
            );
            //spnCoordX.setValue(Galeria.getLojaPorOrdem(G).getCoordX());
            //txtCoordY.setText(Integer.toString(Galeria.getLojaPorOrdem(G).getCoordY()));

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CmbAparencias = new javax.swing.JComboBox();
        cmbMapas = new javax.swing.JComboBox();
        spnCoordX = new javax.swing.JSpinner();
        spnCoordY = new javax.swing.JSpinner();
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mapa:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Coord. X:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Coord. Y:");

        CmbAparencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "048", "049", "100", "101", "102", "103", " " }));
        CmbAparencias.setEnabled(false);
        CmbAparencias.setOpaque(false);
        CmbAparencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbAparenciasActionPerformed(evt);
            }
        });

        cmbMapas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMapas.setEnabled(false);
        cmbMapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMapasActionPerformed(evt);
            }
        });
        cmbMapas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbMapasFocusLost(evt);
            }
        });

        spnCoordX.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnCoordX.setEnabled(false);
        spnCoordX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spnCoordXFocusLost(evt);
            }
        });

        spnCoordY.setModel(new javax.swing.SpinnerNumberModel());
        spnCoordY.setEnabled(false);
        spnCoordY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spnCoordYFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeDaLoja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(CmbAparencias, 0, 136, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMapas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbMapas, spnCoordX, spnCoordY});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeDaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CmbAparencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cmbMapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(spnCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(spnCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbMapas, spnCoordX, spnCoordY});

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
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
        System.out.println("aqui0");
        if(CmbAparencias.getSelectedIndex()>=1){
            String Selecionado=CmbAparencias.getItemAt(CmbAparencias.getSelectedIndex()).toString();
            String Partes[] = Selecionado.split(":");
            FrmPrincipal.bdNPCs.carregarImg(Integer.parseInt(Partes[0]));  //Carrega a imagem antes de usar!
            System.out.println("aqui1");
            if(Partes.length>=2){
                 System.out.println("aqui2");
                Dados_NPC NPC = FrmPrincipal.bdNPCs.getNPCporID(Integer.parseInt(Partes[0]));
                ImagemClass Imagem = new ImagemClass(NPC.getImagem());
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


        cmbMapas.setModel(new javax.swing.DefaultComboBoxModel(FrmPrincipal.bdWarps.getMapasVector()));
        //cmbLojas.setEnabled(Galeria.getContLojas()>=1);
        //if(FrmPrincipal.bdWarps.getContMapas()>=1) cmbMapas.setSelectedIndex(L<cmbLojas.getItemCount()?L:cmbLojas.getItemCount()-1);
        //cmbMapas.set

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
        //DialogClass Dialogo = new DialogClass();
        if(Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getContProdutos()>1){
            int X=tblShop.getSelectedColumn(), Y=tblShop.getSelectedRow();
            if(X>=0 && Y>=0){
                int ID = Galeria.getLojaPorOrdem(cmbLojas.getSelectedIndex()).getProdutoPorOrdem(Y).getID();
                ImagemClass Item = new ImagemClass(FrmPrincipal.bdProds.getItemPorID(ID).getIconeImagem());
                Item.setZoom(3.0);
                int R=DialogClass.showOpcoes(
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
        Galeria.getLojaPorOrdem(L).setMapa(cmbMapas.getItemAt(cmbMapas.getSelectedIndex()).toString());
        Galeria.getLojaPorOrdem(L).setCoordX(Integer.parseInt(spnCoordX.getValue().toString()));
        Galeria.getLojaPorOrdem(L).setCoordY(Integer.parseInt(spnCoordY.getValue().toString()));

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
        cmbMapas.setEnabled(true);
        spnCoordX.setEnabled(true);
        spnCoordY.setEnabled(true);

        txtNomeDaLoja.setOpaque(true);
        CmbAparencias.setOpaque(true);
        cmbMapas.setOpaque(true);
        spnCoordX.setOpaque(true);
        spnCoordY.setOpaque(true);

        txtNomeDaLoja.setText("Loja "+Galeria.getContLojas());
        setComboAparencia(0);
        cmbMapas.setSelectedIndex(0);
        spnCoordX.setValue(Integer.valueOf(FrmPrincipal.bdWarps.getMapaPorOrdem(0).getLargura()/2));
        spnCoordX.setValue(Integer.valueOf(FrmPrincipal.bdWarps.getMapaPorOrdem(0).getAltura()/2));
        


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
        cmbMapas.setEnabled(true);
        spnCoordX.setEnabled(true);
        spnCoordY.setEnabled(true);

        txtNomeDaLoja.setOpaque(true);
        CmbAparencias.setOpaque(true);
        cmbMapas.setOpaque(true);
        spnCoordX.setOpaque(true);
        spnCoordY.setOpaque(true);
    }//GEN-LAST:event_btnLojaEditarActionPerformed
    private void cmbMapasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbMapasFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            //String Selecionado=cmbMapas.getItemAt(L).toString();
            if(!cmbMapas.getItemAt(L).equals("")){
                Galeria.getLojaPorOrdem(L).setMapa(cmbMapas.getItemAt(L).toString());
                //int ValX = Galeria.getLojaPorOrdem(L).getCoordX();
                int ValX = Integer.parseInt(spnCoordX.getValue().toString());
                int MaxX = FrmPrincipal.bdWarps.getMapaPorOrdem(cmbMapas.getSelectedIndex()).getLargura();
                if(ValX>MaxX) ValX=MaxX;
                spnCoordX.setModel(
                    new javax.swing.SpinnerNumberModel(
                        Integer.valueOf(ValX),
                        Integer.valueOf(0),
                        Integer.valueOf(MaxX),
                        Integer.valueOf(1)
                    )
                );
                int ValY = Integer.parseInt(spnCoordY.getValue().toString());
                int MaxY = FrmPrincipal.bdWarps.getMapaPorOrdem(cmbMapas.getSelectedIndex()).getAltura();
                if(ValY>MaxY) ValY=MaxY;
                spnCoordY.setModel(
                    new javax.swing.SpinnerNumberModel(
                        Integer.valueOf(ValY),
                        Integer.valueOf(0),
                        Integer.valueOf(MaxY),
                        Integer.valueOf(1)
                    )
                );

                FrmPrincipal.setAvisoEmEstatus("<html>Novo mapa do NPC de Loja: <font color=\"#0000FF\">\""+cmbMapas.getItemAt(L)+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar um mapa a loja!");
            }
        }
    }//GEN-LAST:event_cmbMapasFocusLost
    private void spnCoordXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnCoordXFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            //int V=Integer.parseInt(spnCoordX.getValue().toString());
            if(Integer.parseInt(spnCoordX.getValue().toString())>=0){
                Galeria.getLojaPorOrdem(L).setCoordX(Integer.parseInt(spnCoordX.getValue().toString()));
                FrmPrincipal.setAvisoEmEstatus("<html>A nova coordenada do NPC de Loja: <font color=\"#0000FF\">\""+spnCoordX.getValue()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar uma Coordenada X a loja!");
            }
        }
    }//GEN-LAST:event_spnCoordXFocusLost
    private void spnCoordYFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spnCoordYFocusLost
        int L = cmbLojas.getSelectedIndex();
        if(L>=0){
            //int V=Integer.parseInt(spnCoordX.getValue().toString());
            if(Integer.parseInt(spnCoordY.getValue().toString())>=0){
                Galeria.getLojaPorOrdem(L).setCoordY(Integer.parseInt(spnCoordY.getValue().toString()));
                FrmPrincipal.setAvisoEmEstatus("<html>A nova coordenada do NPC de Loja: <font color=\"#0000FF\">\""+spnCoordY.getValue()+"\"</FONT>");
                btnLojaSalvar.setEnabled(true);
                btnLojaAbrir.setEnabled(true);
            }else{
                FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">AVISO:</FONT> É obrigatório dar uma Coordenada Y a loja!");
            }
        }
    }//GEN-LAST:event_spnCoordYFocusLost
    private void cmbMapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMapasActionPerformed
        //limitarMapa();
    }//GEN-LAST:event_cmbMapasActionPerformed

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
    private javax.swing.JComboBox cmbMapas;
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
    private javax.swing.JSpinner spnCoordX;
    private javax.swing.JSpinner spnCoordY;
    private javax.swing.JTable tblShop;
    private javax.swing.JTextField txtNomeDaLoja;
    // End of variables declaration//GEN-END:variables

}
