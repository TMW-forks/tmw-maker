
package formularios;

//import Classes.ConfigClass;

public class FrmConfiguracao extends javax.swing.JDialog {
    
    public FrmConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
		  /*//CmbConfiguracaoConexaoRepositorio.set
		  TxtConfiguracaoConexaoLocalhost.setText(FrmTMWMaker2.conf.getConexaoLocalhost());
		  TxtConfiguracaoConexaoIdentificacaoUsuario.setText(FrmTMWMaker2.conf.getConexaoUsuario());
		  TxtConfiguracaoConexaoIdentificacaoSenha.setText(FrmTMWMaker2.conf.getConexaoSenha());/**/
    }

    static String Barra = System.getProperty("file.separator");


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
    
    
    public void ImportarConfiguracao() {
        CmbConfiguracaoConexaoRepositorio.setSelectedItem((Object)FrmTMWMaker2.conf.getConexaoRepositorio().toString());
        FrmTMWMaker2.conf.setConexaoRepositorio(CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString());
        TxtConfiguracaoConexaoLocalhost.setText(FrmTMWMaker2.conf.getConexaoLocalhost());
        TxtConfiguracaoConexaoIdentificacaoUsuario.setText(FrmTMWMaker2.conf.getConexaoUsuario());
        TxtConfiguracaoConexaoIdentificacaoSenha.setText(FrmTMWMaker2.conf.getConexaoSenha());
        CmbConfiguracaoExecucaoSoftwareCliente.setSelectedItem((Object)FrmTMWMaker2.conf.getExecucaoComando());
        /*if(!FrmTMWMaker2.conf.SeComandoProcede(FrmTMWMaker2.conf.getExecucaoComando()+" --help")){
            CmbConfiguracaoExecucaoSoftwareCliente.setForeground(Color.red);
            FrmTMWMaker2.LblEstatus.setText("<html><font color=\"#FF0000\">AVISO:</font> Aplicativo \"<font color=\"#FF0000\">"+FrmTMWMaker2.conf.getExecucaoComando()+"</font>\" n�o existe ou n�o est� funcionando!");
            AbaConfiguracoes.setSelectedIndex(1);
            CmbConfiguracaoExecucaoSoftwareCliente.gotFocus(null, CmbConfiguracaoExecucaoSoftwareCliente);
        }/**/
        TxtConfiguracaoExecucaoParamentroServidor.setText(FrmTMWMaker2.conf.getExecucaoParametroServidor());
        TxtConfiguracaoExecucaoParamentroConta.setText(FrmTMWMaker2.conf.getExecucaoParametroConta());
        TxtConfiguracaoExecucaoParamentroSenha.setText(FrmTMWMaker2.conf.getExecucaoParametroSenha());
        TxtConfiguracaoExecucaoParamentroPersonagem.setText(FrmTMWMaker2.conf.getExecucaoParametroPersonagem());
        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(FrmTMWMaker2.conf.getExecucaoParametroSemOpenGL());

        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()== -1) CmbConfiguracaoComportamentoEngine.setSelectedIndex(0);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()==  0) CmbConfiguracaoComportamentoEngine.setSelectedIndex(1);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()==  1) CmbConfiguracaoComportamentoEngine.setSelectedIndex(2);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()==  7) CmbConfiguracaoComportamentoEngine.setSelectedIndex(3);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()== 15) CmbConfiguracaoComportamentoEngine.setSelectedIndex(4);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()== 30) CmbConfiguracaoComportamentoEngine.setSelectedIndex(5);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()== 60) CmbConfiguracaoComportamentoEngine.setSelectedIndex(6);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()== 90) CmbConfiguracaoComportamentoEngine.setSelectedIndex(7);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()==182) CmbConfiguracaoComportamentoEngine.setSelectedIndex(8);
        if(FrmTMWMaker2.conf.getAtualizacaoEngineIntervalo()==365) CmbConfiguracaoComportamentoEngine.setSelectedIndex(9);

        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()== -1) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(0);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()==  0) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(1);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()==  1) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(2);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()==  7) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(3);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()== 15) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(4);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()== 30) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(5);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()== 60) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(6);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()== 90) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(7);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()==182) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(8);
        if(FrmTMWMaker2.conf.getAtualizacaoLocalhostIntervalo()==365) CmbConfiguracaoComportamentoLocalhost.setSelectedIndex(9);

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
      jPanel6 = new javax.swing.JPanel();
      jPanel7 = new javax.swing.JPanel();
      jLabel6 = new javax.swing.JLabel();
      jLabel16 = new javax.swing.JLabel();
      CmbConfiguracaoComportamentoEngine = new javax.swing.JComboBox();
      CmbConfiguracaoComportamentoLocalhost = new javax.swing.JComboBox();
      ChkPedirCompartilhamentoAofechar = new javax.swing.JCheckBox();
      BtnConfiguracaoCancelar = new javax.swing.JButton();
      BtnConfiguracaoOk = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Configurações");
      setModal(true);
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
         }
      });

      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel1.setText("Repositório:");

      jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel2.setText("Localhost:");

      jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));
      jPanel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));

      jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel3.setText("Usuário:");

      TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(false);
      TxtConfiguracaoConexaoIdentificacaoUsuario.setMinimumSize(new java.awt.Dimension(25, 25));

      jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel4.setText("Senha:");

      TxtConfiguracaoConexaoIdentificacaoSenha.setEnabled(false);
      TxtConfiguracaoConexaoIdentificacaoSenha.setMinimumSize(new java.awt.Dimension(25, 25));

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel3)
               .addComponent(TxtConfiguracaoConexaoIdentificacaoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
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
                     .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                     .addComponent(CmbConfiguracaoConexaoRepositorio, 0, 446, Short.MAX_VALUE)
                     .addComponent(TxtConfiguracaoConexaoLocalhost, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)))
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

      jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel8.setText("Conta:");

      jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel9.setText("Senha:");

      jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel10.setText("Personagem:");

      ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(true);
      ChkConfiguracaoExecucaoParamentroSemopengl.setText("<html>Sem OpenGL (<font color=\"#FF0000\">Recomendado</font>)");
      ChkConfiguracaoExecucaoParamentroSemopengl.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed(evt);
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
               .addComponent(TxtConfiguracaoExecucaoParamentroServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
                  .addComponent(CmbConfiguracaoExecucaoSoftwareCliente, 0, 398, Short.MAX_VALUE)))
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
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CmbConfiguracaoExecucaoSoftwareCliente, jLabel5});

      AbaConfiguracoes.addTab("Execução", jPanel2);

      jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Perdir permissão para atualização:"));

      jLabel6.setText("Engine:");
      jLabel6.setEnabled(false);

      jLabel16.setText("Localhost:");

      CmbConfiguracaoComportamentoEngine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca Perguntar", "Sempre ao Iniciar", "Diariamente", "Semanalmente", "Quinzenalmente", "Mensalmente", "Bimestralmente", "Trimestralmente", "Semestralmente", "Anualmente" }));
      CmbConfiguracaoComportamentoEngine.setSelectedIndex(2);
      CmbConfiguracaoComportamentoEngine.setEnabled(false);

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
            .addContainerGap(266, Short.MAX_VALUE))
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
            .addContainerGap(75, Short.MAX_VALUE))
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

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(AbaConfiguracoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
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
               .addComponent(BtnConfiguracaoCancelar))
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
        boolean RecarregaBD=!TxtConfiguracaoConexaoLocalhost.getText().equals(FrmTMWMaker2.conf.getConexaoLocalhost());

        FrmTMWMaker2.conf.setConexaoRepositorio(CmbConfiguracaoConexaoRepositorio.getEditor().getItem().toString());
        //FrmTMWMaker2.conf.setConexaoRepositorio(TxtConfiguracaoConexaoRepositorio.getText());
        FrmTMWMaker2.conf.setConexaoLocalhost(TxtConfiguracaoConexaoLocalhost.getText());
        FrmTMWMaker2.conf.setConexaoUsuario(TxtConfiguracaoConexaoIdentificacaoUsuario.getText());
        FrmTMWMaker2.conf.setConexaoSenha(TxtConfiguracaoConexaoIdentificacaoSenha.getText());
        //FrmTMWMaker2.conf.setExecucaoComando(TxtConfiguracaoExecucaoSoftwareCliente.getText());
        FrmTMWMaker2.conf.setExecucaoComando(CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString());
        //FrmTMWMaker2.conf.setExecucaoParametroTMWData(TxtConfiguracaoExecucaoParamentroTMWData.getText());
        FrmTMWMaker2.conf.setExecucaoParametroServidor(TxtConfiguracaoExecucaoParamentroServidor.getText());
        FrmTMWMaker2.conf.setExecucaoParametroConta(TxtConfiguracaoExecucaoParamentroConta.getText());
        FrmTMWMaker2.conf.setExecucaoParametroSenha(TxtConfiguracaoExecucaoParamentroSenha.getText());
        FrmTMWMaker2.conf.setExecucaoParametroPersonagem(TxtConfiguracaoExecucaoParamentroPersonagem.getText());
        FrmTMWMaker2.conf.setExecucaoParametroSemOpenGL(ChkConfiguracaoExecucaoParamentroSemopengl.isSelected());

        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==0) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(-1);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==1) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(0);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==2) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(1);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==3) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(7);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==4) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(15);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==5) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(30);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==6) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(60);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==7) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(90);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==8) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(182);
        if(CmbConfiguracaoComportamentoEngine.getSelectedIndex()==9) FrmTMWMaker2.conf.setAtualizacaoEngineIntervalo(365);


        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==0) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(-1);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==1) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(0);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==2) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(1);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==3) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(7);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==4) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(15);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==5) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(30);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==6) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(60);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==7) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(90);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==8) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(182);
        if(CmbConfiguracaoComportamentoLocalhost.getSelectedIndex()==9) FrmTMWMaker2.conf.setAtualizacaoLocalhostIntervalo(365);

        FrmTMWMaker2.conf.doSalvar();

        this.dispose();
        
        /*if(RecarregaBD && FrmTMWMaker2.conf.getSeDependenciaDeLocalhost()){
            javax.swing.JDialog FrmSplash = new FrmSplash(this, rootPaneCheckingEnabled);
            FrmSplash.setLocation(
                    ((this.getWidth() - FrmSplash.getWidth()) / 2) + this.getX(),
                    ((this.getHeight() - FrmSplash.getHeight()) / 2) + this.getY());
            FrmSplash.pack();
            FrmSplash.setModal(true);
            FrmSplash.setVisible(true);
        }/**/
    }//GEN-LAST:event_BtnConfiguracaoOkActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImportarConfiguracao();
    }//GEN-LAST:event_formWindowOpened
    private void ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglActionPerformed
    private void CmbConfiguracaoConexaoRepositorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbConfiguracaoConexaoRepositorioActionPerformed
        FunMudaTesto();
    }//GEN-LAST:event_CmbConfiguracaoConexaoRepositorioActionPerformed

    /*public static void main(String args[]) {
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
    }/**/

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTabbedPane AbaConfiguracoes;
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
   private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroConta;
   private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroPersonagem;
   private javax.swing.JPasswordField TxtConfiguracaoExecucaoParamentroSenha;
   private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroServidor;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
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
   private javax.swing.JPanel jPanel5;
   private javax.swing.JPanel jPanel6;
   private javax.swing.JPanel jPanel7;
   // End of variables declaration//GEN-END:variables

    /*private void Alterado_SoftwareCliente() {
        if(!CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString().isEmpty()){
            boolean SeProcede=FrmTMWMaker2.conf.SeComandoProcede(CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+" --help");
            if(SeProcede){
                CmbConfiguracaoExecucaoSoftwareCliente.setForeground(java.awt.SystemColor.textText);
                FrmTMWMaker2.LblEstatus.setText("Comando \""+CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+"\" Ok!");

            }else{
                CmbConfiguracaoExecucaoSoftwareCliente.setForeground(Color.red);
                FrmTMWMaker2.LblEstatus.setText("Comando \""+CmbConfiguracaoExecucaoSoftwareCliente.getEditor().getItem().toString()+"\" n�o procede!");
            }
        }else{
            FrmTMWMaker2.LblEstatus.setText("<html><font color=\"#FF0000\">AVISO:<font> Digite o comando que abrir� o jogo The Mana World!");
        }
    }/**/

}
