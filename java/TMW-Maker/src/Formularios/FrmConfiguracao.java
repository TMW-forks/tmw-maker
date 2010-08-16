
package Formularios;

import Classes.ConfigClass;
import java.awt.Color;
import java.awt.Toolkit;

public class FrmConfiguracao extends javax.swing.JDialog {
    
    public FrmConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    static String Barra = System.getProperty("file.separator");


    private void setMarcarComponente(String Componente) {
        FrmPrincipal.ComponenteSelecionado = Componente.toString();
        if(FrmPrincipal.ComponenteSelecionado.isEmpty()) {
            BtnConfiguracaoAjuda.setEnabled(false);
        } else {
            BtnConfiguracaoAjuda.setEnabled(true);
            FrmPrincipal.LblEstatus.setText("Clique em F1 para obter ajuda sobre ["+Componente.toString()+"]...");
        }
    }
    private void FunMudaTesto() {
        String Repositorio;
        /*try {
            String Editado=CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString();
            String Selecionado=CmbConfiguracaoConexaoRepositorio.getItemAt(CmbConfiguracaoConexaoRepositorio.getSelectedIndex()).toString();
            if(!Editado.equals(Selecionado)){Repositorio = Selecionado;}else{Repositorio = Editado;}
        } catch (Exception e) {
            Repositorio = CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString();
        }/**/
        Repositorio = CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString();

        String Partes[] = null;
        Partes = Repositorio.split(":");
        if(Partes.length>1 && Partes[0].toLowerCase().equals("https")){
            TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(true);
            TxtConfiguracaoConexaoIdentificacaoSenha.setEnabled(true);
            TxtConfiguracaoConexaoIdentificacaoUsuario.setBackground(java.awt.SystemColor.text);
            TxtConfiguracaoConexaoIdentificacaoSenha.setBackground(java.awt.SystemColor.text);
        }else{
            TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(false);
            TxtConfiguracaoConexaoIdentificacaoSenha.setEnabled(false);
            TxtConfiguracaoConexaoIdentificacaoUsuario.setBackground(java.awt.SystemColor.window);
            TxtConfiguracaoConexaoIdentificacaoSenha.setBackground(java.awt.SystemColor.window);
        }
    }
    public static void showAjuda(){
        ConfigClass.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes()+Barra+FrmPrincipal.ComponenteSelecionado);
        Toolkit.getDefaultToolkit().beep();
    }
    public static void showAjuda(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_F1){showAjuda();}
    }
    /*public boolean SalvarConfiguracao(String filename) {
        try {
            //FrmPrincipal.Config.setConexaoRepositorio(TxtConfiguracaoConexaoRepositorio.getText());
            FrmPrincipal.Config.setConexaoRepositorio(CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString());
            FrmPrincipal.Config.setConexaoLocalhost(TxtConfiguracaoConexaoLocalhost.getText());
            FrmPrincipal.Config.setConexaoUsuario (TxtConfiguracaoConexaoIdentificacaoUsuario.getText());
            FrmPrincipal.Config.setConexaoSenha (TxtConfiguracaoConexaoIdentificacaoSenha.getText());

            //FrmPrincipal.Config.setExecucaoComando(TxtConfiguracaoExecucaoSoftwareCliente.getText());
            FrmPrincipal.Config.setExecucaoComando(CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString());
            //FrmPrincipal.Config.setExecucaoParametroTMWData(TxtConfiguracaoExecucaoParamentroTMWData.getText());
            FrmPrincipal.Config.setExecucaoParametroServidor(TxtConfiguracaoExecucaoParamentroServidor.getText());
            FrmPrincipal.Config.setExecucaoParametroConta(TxtConfiguracaoExecucaoParamentroConta.getText());
            FrmPrincipal.Config.setExecucaoParametroSenha(TxtConfiguracaoExecucaoParamentroSenha.getText());
            FrmPrincipal.Config.setExecucaoParametroPersonagem(TxtConfiguracaoExecucaoParamentroPersonagem.getText());
            FrmPrincipal.Config.setExecucaoParametroSemopengl(ChkConfiguracaoExecucaoParamentroSemopengl.isSelected());

            FrmPrincipal.Config.setDocumentacaoAlteracoes(TxtConfiguracaoDocumentacaoAlteracoes.getText());
            FrmPrincipal.Config.setDocumentacaoComentarios(TxtConfiguracaoDocumentacaoComentarios.getText());
            FrmPrincipal.Config.setDocumentacaoComponentes(TxtConfiguracaoDocumentacaoComponentes.getText());
            FrmPrincipal.Config.setDocumentacaoTraducoes(TxtConfiguracaoDocumentacaoTraducoes.getText());

            Document Documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Documento.setXmlVersion("1.0");

            Element Configuracao = Documento.createElement("Configuracao");
            Documento.appendChild(Configuracao);
            Element Propriedade;

            Propriedade = Documento.createElement("Conexao");
            Propriedade.setAttribute("Versao", FrmPrincipal.Config.getVersao());
            Propriedade.setAttribute("Repositorio", FrmPrincipal.Config.getConexaoRepositorio());
            Propriedade.setAttribute("Localhost", FrmPrincipal.Config.getConexaoLocalhost());
            Propriedade.setAttribute("Usuario", FrmPrincipal.Config.getConexaoUsuario());
            Propriedade.setAttribute("Senha", FrmPrincipal.Config.getConexaoSenha());
            Configuracao.appendChild(Propriedade);

            Propriedade = Documento.createElement("Execucao");
            Propriedade.setAttribute("Comando", FrmPrincipal.Config.getExecucaoComando());
            //Propriedade.setAttribute("TMWData", FrmPrincipal.Config.getExecucaoParametroTMWData());
            Propriedade.setAttribute("Servidor", FrmPrincipal.Config.getExecucaoParametroServidor());
            Propriedade.setAttribute("Conta", FrmPrincipal.Config.getExecucaoParametroConta());
            Propriedade.setAttribute("Senha", FrmPrincipal.Config.getExecucaoParametroSenha());
            Propriedade.setAttribute("Personagem", FrmPrincipal.Config.getExecucaoParametroPersonagem());
            Propriedade.setAttribute("SemOpenGL", FrmPrincipal.Config.getExecucaoParametroSemopengl()?"true":"false");
            Configuracao.appendChild(Propriedade);

            Propriedade = Documento.createElement("Documentacao");
            Propriedade.setAttribute("Alteracoes", FrmPrincipal.Config.getDocumentacaoAlteracoes());
            Propriedade.setAttribute("Comentarios", FrmPrincipal.Config.getDocumentacaoComentarios());
            Propriedade.setAttribute("Componentes", FrmPrincipal.Config.getDocumentacaoComponentes());
            Propriedade.setAttribute("Traducoes", FrmPrincipal.Config.getDocumentacaoTraducoes());
            Configuracao.appendChild(Propriedade);


            Source source = new DOMSource(Documento);

            File file = new File(filename);
            Result result = new StreamResult(file);
            TransformerFactory facxformer = TransformerFactory.newInstance();
            Transformer xformer = facxformer.newTransformer();
            xformer.transform(source, result);

        } catch (Exception e) {
            return false;
        }
        return true;

    }/**/
    public void ImportarConfiguracao() {
        CmbConfiguracaoConexaoRepositorio.setSelectedItem((Object)FrmPrincipal.Config.getConexaoRepositorio().toString());
        FrmPrincipal.Config.setConexaoRepositorio(CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString());
        TxtConfiguracaoConexaoLocalhost.setText(FrmPrincipal.Config.getConexaoLocalhost());
        TxtConfiguracaoConexaoIdentificacaoUsuario.setText(FrmPrincipal.Config.getConexaoUsuario());
        TxtConfiguracaoConexaoIdentificacaoSenha.setText(FrmPrincipal.Config.getConexaoSenha());
        CmbConfiguracaoExecucaoSoftwareCliente.setSelectedItem((Object)FrmPrincipal.Config.getExecucaoComando());
        if(!FrmPrincipal.Config.SeComandoProcede(FrmPrincipal.Config.getExecucaoComando()+" --help")){
            CmbConfiguracaoExecucaoSoftwareCliente.setForeground(Color.red);
            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">AVISO:</font> Aplicativo \"<font color=\"#FF0000\">"+FrmPrincipal.Config.getExecucaoComando()+"</font>\" não existe ou não está funcionando!");
            AbaConfiguracoes.setSelectedIndex(1);
            CmbConfiguracaoExecucaoSoftwareCliente.gotFocus(null, CmbConfiguracaoExecucaoSoftwareCliente);
        }
        //TxtConfiguracaoExecucaoParamentroTMWData.setText(FrmPrincipal.Config.getExecucaoParametroTMWData());
        TxtConfiguracaoExecucaoParamentroServidor.setText(FrmPrincipal.Config.getExecucaoParametroServidor());
        TxtConfiguracaoExecucaoParamentroConta.setText(FrmPrincipal.Config.getExecucaoParametroConta());
        TxtConfiguracaoExecucaoParamentroSenha.setText(FrmPrincipal.Config.getExecucaoParametroSenha());
        TxtConfiguracaoExecucaoParamentroPersonagem.setText(FrmPrincipal.Config.getExecucaoParametroPersonagem());
        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(FrmPrincipal.Config.getExecucaoParametroSemopengl());
        TxtConfiguracaoDocumentacaoAlteracoes.setText(FrmPrincipal.Config.getDocumentacaoAlteracoes());
        TxtConfiguracaoDocumentacaoComponentes.setText(FrmPrincipal.Config.getDocumentacaoComponentes());
        TxtConfiguracaoDocumentacaoComentarios.setText(FrmPrincipal.Config.getDocumentacaoComentarios());
        TxtConfiguracaoDocumentacaoTraducoes.setText(FrmPrincipal.Config.getDocumentacaoTraducoes());

        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()== -1) CmbConfiguracaoComportamentoEngine.setSelectedIndex(0);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()==  0) CmbConfiguracaoComportamentoEngine.setSelectedIndex(1);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()==  1) CmbConfiguracaoComportamentoEngine.setSelectedIndex(2);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()==  7) CmbConfiguracaoComportamentoEngine.setSelectedIndex(3);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()== 15) CmbConfiguracaoComportamentoEngine.setSelectedIndex(4);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()== 30) CmbConfiguracaoComportamentoEngine.setSelectedIndex(5);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()== 60) CmbConfiguracaoComportamentoEngine.setSelectedIndex(6);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()== 90) CmbConfiguracaoComportamentoEngine.setSelectedIndex(7);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()==182) CmbConfiguracaoComportamentoEngine.setSelectedIndex(8);
        if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()==365) CmbConfiguracaoComportamentoEngine.setSelectedIndex(9);

        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()== -1) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(0);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()==  0) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(1);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()==  1) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(2);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()==  7) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(3);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()== 15) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(4);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()== 30) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(5);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()== 60) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(6);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()== 90) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(7);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()==182) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(8);
        if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()==365) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(9);

        FunMudaTesto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AbaConfiguracoes = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoLocalhost = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoIdentificacaoUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoIdentificacaoSenha = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        CmbConfiguracaoConexaoRepositorio = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroServidor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroConta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroPersonagem = new javax.swing.JTextField();
        ChkConfiguracaoExecucaoParamentroSemopengl = new javax.swing.JCheckBox();
        TxtConfiguracaoExecucaoParamentroSenha = new javax.swing.JPasswordField();
        CmbConfiguracaoExecucaoSoftwareCliente = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoAlteracoes = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoComponentes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoComentarios = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoTraducoes = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CmbConfiguracaoComportamentoEngine = new javax.swing.JComboBox();
        CmbConfiguracaoComportamentoLocalhost = new javax.swing.JComboBox();
        ChkPedirCompartilhamentoAofechar = new javax.swing.JCheckBox();
        BtnConfiguracaoCancelar = new javax.swing.JButton();
        BtnConfiguracaoOk = new javax.swing.JButton();
        BtnConfiguracaoAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Repositório:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Localhost:");

        TxtConfiguracaoConexaoLocalhost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoLocalhostFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoLocalhost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoConexaoLocalhostKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));
        jPanel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuário:");

        TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(false);
        TxtConfiguracaoConexaoIdentificacaoUsuario.setMinimumSize(new java.awt.Dimension(25, 25));
        TxtConfiguracaoConexaoIdentificacaoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoIdentificacaoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoUsuarioKeyReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha:");

        TxtConfiguracaoConexaoIdentificacaoSenha.setEnabled(false);
        TxtConfiguracaoConexaoIdentificacaoSenha.setMinimumSize(new java.awt.Dimension(25, 25));
        TxtConfiguracaoConexaoIdentificacaoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoIdentificacaoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoSenhaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TxtConfiguracaoConexaoIdentificacaoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TxtConfiguracaoConexaoIdentificacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtConfiguracaoConexaoIdentificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtConfiguracaoConexaoIdentificacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("<html><b>OBS.:</b> Inicie com <font color=\"#0000FF\"><b>https://</b></font> para ativar a identificação.");

        CmbConfiguracaoConexaoRepositorio.setEditable(true);
        CmbConfiguracaoConexaoRepositorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "http://themanaworld-br.googlecode.com/svn/trunk" }));
        CmbConfiguracaoConexaoRepositorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbConfiguracaoConexaoRepositorioActionPerformed(evt);
            }
        });
        CmbConfiguracaoConexaoRepositorio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CmbConfiguracaoConexaoRepositorioFocusGained(evt);
            }
        });
        CmbConfiguracaoConexaoRepositorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CmbConfiguracaoConexaoRepositorioKeyReleased(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(CmbConfiguracaoConexaoRepositorio, 0, 353, Short.MAX_VALUE)
                            .addComponent(TxtConfiguracaoConexaoLocalhost, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CmbConfiguracaoConexaoRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoConexaoLocalhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbConfiguracaoConexaoRepositorio, TxtConfiguracaoConexaoLocalhost, jLabel1, jLabel2});

        AbaConfiguracoes.addTab("Conexão", jPanel1);

        jLabel5.setText("Software Cliente:");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros"));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Servidor:");

        TxtConfiguracaoExecucaoParamentroServidor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroServidorFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroServidor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoParamentroServidorKeyReleased(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Conta:");

        TxtConfiguracaoExecucaoParamentroConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroContaFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoParamentroContaKeyReleased(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Senha:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Personagem:");

        TxtConfiguracaoExecucaoParamentroPersonagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroPersonagemFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoParamentroPersonagemKeyReleased(evt);
            }
        });

        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(true);
        ChkConfiguracaoExecucaoParamentroSemopengl.setText("<html>Sem OpenGL (<font color=\"#FF0000\">Recomendado</font>)");
        ChkConfiguracaoExecucaoParamentroSemopengl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed(evt);
            }
        });
        ChkConfiguracaoExecucaoParamentroSemopengl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ChkConfiguracaoExecucaoParamentroSemopenglFocusGained(evt);
            }
        });
        ChkConfiguracaoExecucaoParamentroSemopengl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ChkConfiguracaoExecucaoParamentroSemopenglKeyReleased(evt);
            }
        });

        TxtConfiguracaoExecucaoParamentroSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroSenhaFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoParamentroSenhaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkConfiguracaoExecucaoParamentroSemopengl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChkConfiguracaoExecucaoParamentroSemopengl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TxtConfiguracaoExecucaoParamentroConta, TxtConfiguracaoExecucaoParamentroPersonagem, TxtConfiguracaoExecucaoParamentroSenha, TxtConfiguracaoExecucaoParamentroServidor, jLabel10, jLabel7, jLabel8, jLabel9});

        CmbConfiguracaoExecucaoSoftwareCliente.setEditable(true);
        CmbConfiguracaoExecucaoSoftwareCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "tmw", "manaplus" }));
        CmbConfiguracaoExecucaoSoftwareCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbConfiguracaoExecucaoSoftwareClienteActionPerformed(evt);
            }
        });
        CmbConfiguracaoExecucaoSoftwareCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CmbConfiguracaoExecucaoSoftwareClienteFocusGained(evt);
            }
        });
        CmbConfiguracaoExecucaoSoftwareCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CmbConfiguracaoExecucaoSoftwareClienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CmbConfiguracaoExecucaoSoftwareCliente, 0, 312, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbConfiguracaoExecucaoSoftwareCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbConfiguracaoExecucaoSoftwareCliente, jLabel5});

        AbaConfiguracoes.addTab("Execução", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Locais onde o TMW-Maker procurará sobre:"));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Alterações:");

        TxtConfiguracaoDocumentacaoAlteracoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoAlteracoesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoAlteracoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoDocumentacaoAlteracoesKeyReleased(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Componentes:");

        TxtConfiguracaoDocumentacaoComponentes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoComponentesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoComponentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoDocumentacaoComponentesKeyReleased(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Comentários:");

        TxtConfiguracaoDocumentacaoComentarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoComentariosFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoComentarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoDocumentacaoComentariosKeyReleased(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Traduções:");

        TxtConfiguracaoDocumentacaoTraducoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoTraducoesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoTraducoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoDocumentacaoTraducoesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(TxtConfiguracaoDocumentacaoAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(TxtConfiguracaoDocumentacaoComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(12, 12, 12)
                .addComponent(TxtConfiguracaoDocumentacaoComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addComponent(TxtConfiguracaoDocumentacaoTraducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoDocumentacaoAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoDocumentacaoComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoDocumentacaoComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoDocumentacaoTraducoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        AbaConfiguracoes.addTab("Documentação", jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Perdir permissão para atualização:"));

        jLabel6.setText("Engine:");

        jLabel16.setText("Localhost:");

        CmbConfiguracaoComportamentoEngine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca Perguntar", "Sempre ao Iniciar", "Diariamente", "Semanalmente", "Quinzenalmente", "Mensalmente", "Bimestralmente", "Trimestralmente", "Semestralmente", "Anualmente" }));
        CmbConfiguracaoComportamentoEngine.setSelectedIndex(2);

        CmbConfiguracaoComportamentoLocalhost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca Perguntar", "Sempre ao Iniciar", "Diariamente", "Semanalmente", "Quinzenalmente", "Mensalmente", "Bimestralmente", "Trimestralmente", "Semestralmente", "Anualmente" }));
        CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CmbConfiguracaoComportamentoLocalhost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbConfiguracaoComportamentoEngine, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbConfiguracaoComportamentoEngine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbConfiguracaoComportamentoLocalhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ChkPedirCompartilhamentoAofechar.setSelected(true);
        ChkPedirCompartilhamentoAofechar.setText("Pedir Compartilhamento de Localhost sempre ao felchar");
        ChkPedirCompartilhamentoAofechar.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChkPedirCompartilhamentoAofechar))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChkPedirCompartilhamentoAofechar)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        AbaConfiguracoes.addTab("Comportamento", jPanel6);

        BtnConfiguracaoCancelar.setMnemonic('C');
        BtnConfiguracaoCancelar.setText("Cancelar");
        BtnConfiguracaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfiguracaoCancelarActionPerformed(evt);
            }
        });

        BtnConfiguracaoOk.setMnemonic('O');
        BtnConfiguracaoOk.setText("Ok");
        BtnConfiguracaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfiguracaoOkActionPerformed(evt);
            }
        });

        BtnConfiguracaoAjuda.setMnemonic('A');
        BtnConfiguracaoAjuda.setText("Ajuda (F1)");
        BtnConfiguracaoAjuda.setEnabled(false);
        BtnConfiguracaoAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfiguracaoAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AbaConfiguracoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnConfiguracaoAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(BtnConfiguracaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnConfiguracaoCancelar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnConfiguracaoCancelar, BtnConfiguracaoOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AbaConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConfiguracaoOk)
                    .addComponent(BtnConfiguracaoCancelar)
                    .addComponent(BtnConfiguracaoAjuda))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnConfiguracaoCancelar, BtnConfiguracaoOk});

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfiguracaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoCancelarActionPerformed
       this.dispose();
       //System.exit(0);
    }//GEN-LAST:event_BtnConfiguracaoCancelarActionPerformed
    private void BtnConfiguracaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoOkActionPerformed
        boolean RecarregaBD=!TxtConfiguracaoConexaoLocalhost.getText().equals(FrmPrincipal.Config.getConexaoLocalhost());

        FrmPrincipal.Config.setConexaoRepositorio(CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString());
        //FrmPrincipal.Config.setConexaoRepositorio(TxtConfiguracaoConexaoRepositorio.getText());
        FrmPrincipal.Config.setConexaoLocalhost(TxtConfiguracaoConexaoLocalhost.getText());
        FrmPrincipal.Config.setConexaoUsuario(TxtConfiguracaoConexaoIdentificacaoUsuario.getText());
        FrmPrincipal.Config.setConexaoSenha(TxtConfiguracaoConexaoIdentificacaoSenha.getText());
        //FrmPrincipal.Config.setExecucaoComando(TxtConfiguracaoExecucaoSoftwareCliente.getText());
        FrmPrincipal.Config.setExecucaoComando(CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString());
        //FrmPrincipal.Config.setExecucaoParametroTMWData(TxtConfiguracaoExecucaoParamentroTMWData.getText());
        FrmPrincipal.Config.setExecucaoParametroServidor(TxtConfiguracaoExecucaoParamentroServidor.getText());
        FrmPrincipal.Config.setExecucaoParametroConta(TxtConfiguracaoExecucaoParamentroConta.getText());
        FrmPrincipal.Config.setExecucaoParametroSenha(TxtConfiguracaoExecucaoParamentroSenha.getText());
        FrmPrincipal.Config.setExecucaoParametroPersonagem(TxtConfiguracaoExecucaoParamentroPersonagem.getText());
        FrmPrincipal.Config.setExecucaoParametroSemopengl(ChkConfiguracaoExecucaoParamentroSemopengl.isSelected());
        FrmPrincipal.Config.setDocumentacaoAlteracoes(TxtConfiguracaoDocumentacaoAlteracoes.getText());
        FrmPrincipal.Config.setDocumentacaoComponentes(TxtConfiguracaoDocumentacaoComponentes.getText());
        FrmPrincipal.Config.setDocumentacaoComentarios(TxtConfiguracaoDocumentacaoComentarios.getText());
        FrmPrincipal.Config.setDocumentacaoTraducoes(TxtConfiguracaoDocumentacaoTraducoes.getText());

        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==0) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(-1);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==1) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(0);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==2) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(1);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==3) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(7);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==4) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(15);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==5) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(30);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==6) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(60);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==7) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(90);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==8) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(182);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==9) FrmPrincipal.Config.setAtualizacaoEngineIntervalo(365);


        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==0) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(-1);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==1) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(0);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==2) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(1);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==3) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(7);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==4) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(15);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==5) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(30);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==6) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(60);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==7) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(90);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==8) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(182);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==9) FrmPrincipal.Config.setAtualizacaoLocalhostIntervalo(365);

        FrmPrincipal.Config.ConfiguracoesGravar();

        this.dispose();
        
        if(RecarregaBD && FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
            javax.swing.JDialog FrmSplash = new FrmSplash(this, rootPaneCheckingEnabled);
            FrmSplash.setLocation(
                    ((this.getWidth() - FrmSplash.getWidth()) / 2) + this.getX(),
                    ((this.getHeight() - FrmSplash.getHeight()) / 2) + this.getY());
            FrmSplash.pack();
            FrmSplash.setModal(true);
            FrmSplash.setVisible(true);/**/
        }
    }//GEN-LAST:event_BtnConfiguracaoOkActionPerformed
    private void BtnConfiguracaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoAjudaActionPerformed
        showAjuda();
    }//GEN-LAST:event_BtnConfiguracaoAjudaActionPerformed
    private void TxtConfiguracaoConexaoLocalhostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoLocalhostFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoLocalhost");
    }//GEN-LAST:event_TxtConfiguracaoConexaoLocalhostFocusGained
    private void TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoIdentificacaoUsuario");
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained
    private void TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoIdentificacaoSenha");
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained
    private void TxtConfiguracaoExecucaoParamentroServidorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroServidorFocusGained
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroServidor");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroServidorFocusGained
    private void TxtConfiguracaoExecucaoParamentroContaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroContaFocusGained
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroConta");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroContaFocusGained
    private void TxtConfiguracaoExecucaoParamentroPersonagemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroPersonagemFocusGained
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroPersonagem");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroPersonagemFocusGained
    private void ChkConfiguracaoExecucaoParamentroSemopenglFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglFocusGained
       setMarcarComponente("ChkConfiguracaoExecucaoParamentroSemopengl");
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglFocusGained
    private void TxtConfiguracaoDocumentacaoAlteracoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoAlteracoesFocusGained
       setMarcarComponente("TxtConfiguracaoDocumentacaoAlteracoes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoAlteracoesFocusGained
    private void TxtConfiguracaoDocumentacaoComponentesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComponentesFocusGained
       setMarcarComponente("TxtConfiguracaoDocumentacaoComponentes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComponentesFocusGained
    private void TxtConfiguracaoDocumentacaoComentariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComentariosFocusGained
       setMarcarComponente("TxtConfiguracaoDocumentacaoComentarios");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComentariosFocusGained
    private void TxtConfiguracaoDocumentacaoTraducoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoTraducoesFocusGained
       setMarcarComponente("TxtConfiguracaoDocumentacaoTraducoes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoTraducoesFocusGained
    private void TxtConfiguracaoExecucaoParamentroSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroSenhaFocusGained
        setMarcarComponente("TxtConfiguracaoExecucaoParamentroSenha");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroSenhaFocusGained
    private void TxtConfiguracaoConexaoLocalhostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoLocalhostKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoConexaoLocalhostKeyReleased
    private void TxtConfiguracaoConexaoIdentificacaoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioKeyReleased
    private void TxtConfiguracaoConexaoIdentificacaoSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoSenhaKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoSenhaKeyReleased
    private void TxtConfiguracaoExecucaoParamentroServidorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroServidorKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroServidorKeyReleased
    private void TxtConfiguracaoExecucaoParamentroContaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroContaKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroContaKeyReleased
    private void TxtConfiguracaoExecucaoParamentroSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroSenhaKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroSenhaKeyReleased
    private void TxtConfiguracaoExecucaoParamentroPersonagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroPersonagemKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroPersonagemKeyReleased
    private void ChkConfiguracaoExecucaoParamentroSemopenglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglKeyReleased
    private void TxtConfiguracaoDocumentacaoAlteracoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoAlteracoesKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoAlteracoesKeyReleased
    private void TxtConfiguracaoDocumentacaoComponentesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComponentesKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComponentesKeyReleased
    private void TxtConfiguracaoDocumentacaoComentariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComentariosKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComentariosKeyReleased
    private void TxtConfiguracaoDocumentacaoTraducoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoTraducoesKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoTraducoesKeyReleased
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImportarConfiguracao();
    }//GEN-LAST:event_formWindowOpened
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        FrmPrincipal.LblEstatus.setText("Janela de configurações fechada!");
    }//GEN-LAST:event_formWindowClosed
    private void ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed
    private void CmbConfiguracaoConexaoRepositorioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CmbConfiguracaoConexaoRepositorioFocusGained
        setMarcarComponente("CmbConfiguracaoConexaoRepositorio");
    }//GEN-LAST:event_CmbConfiguracaoConexaoRepositorioFocusGained
    private void CmbConfiguracaoConexaoRepositorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbConfiguracaoConexaoRepositorioKeyReleased
        FunMudaTesto();
        showAjuda(evt);
    }//GEN-LAST:event_CmbConfiguracaoConexaoRepositorioKeyReleased
    private void CmbConfiguracaoConexaoRepositorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbConfiguracaoConexaoRepositorioActionPerformed
        FunMudaTesto();
    }//GEN-LAST:event_CmbConfiguracaoConexaoRepositorioActionPerformed
    private void CmbConfiguracaoExecucaoSoftwareClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CmbConfiguracaoExecucaoSoftwareClienteKeyReleased
        Alterado_SoftwareCliente();
        showAjuda(evt);
    }//GEN-LAST:event_CmbConfiguracaoExecucaoSoftwareClienteKeyReleased
    private void CmbConfiguracaoExecucaoSoftwareClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CmbConfiguracaoExecucaoSoftwareClienteFocusGained
        setMarcarComponente("CmbConfiguracaoExecucaoSoftwareCliente");
    }//GEN-LAST:event_CmbConfiguracaoExecucaoSoftwareClienteFocusGained
    private void CmbConfiguracaoExecucaoSoftwareClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbConfiguracaoExecucaoSoftwareClienteActionPerformed
        Alterado_SoftwareCliente();
    }//GEN-LAST:event_CmbConfiguracaoExecucaoSoftwareClienteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConfiguracao dialog = new FrmConfiguracao(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane AbaConfiguracoes;
    private javax.swing.JButton BtnConfiguracaoAjuda;
    private javax.swing.JButton BtnConfiguracaoCancelar;
    private javax.swing.JButton BtnConfiguracaoOk;
    private javax.swing.JCheckBox ChkConfiguracaoExecucaoParamentroSemopengl;
    private javax.swing.JCheckBox ChkPedirCompartilhamentoAofechar;
    private javax.swing.JComboBox CmbConfiguracaoComportamentoEngine;
    private javax.swing.JComboBox CmbConfiguracaoComportamentoLocalhost;
    private javax.swing.JComboBox CmbConfiguracaoConexaoRepositorio;
    private javax.swing.JComboBox CmbConfiguracaoExecucaoSoftwareCliente;
    private javax.swing.JPasswordField TxtConfiguracaoConexaoIdentificacaoSenha;
    private javax.swing.JTextField TxtConfiguracaoConexaoIdentificacaoUsuario;
    private javax.swing.JTextField TxtConfiguracaoConexaoLocalhost;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoAlteracoes;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoComentarios;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoComponentes;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoTraducoes;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroConta;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroPersonagem;
    private javax.swing.JPasswordField TxtConfiguracaoExecucaoParamentroSenha;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables

    private void Alterado_SoftwareCliente() {
        if(!CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString().isEmpty()){
            boolean SeProcede=FrmPrincipal.Config.SeComandoProcede(CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+" --help");
            if(SeProcede){
                CmbConfiguracaoExecucaoSoftwareCliente.setForeground(java.awt.SystemColor.textText);
                FrmPrincipal.LblEstatus.setText("Comando \""+CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+"\" Ok!");

            }else{
                CmbConfiguracaoExecucaoSoftwareCliente.setForeground(Color.red);
                FrmPrincipal.LblEstatus.setText("Comando \""+CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+"\" não procede!");
            }
        }else{
            FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">AVISO:<font> Digite o comando que abrirá o jogo The Mana World!");
        }
    }

}
