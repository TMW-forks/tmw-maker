/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPrincipal.java
 *
 * Created on Apr 8, 2010, 2:20:48 PM
 */
package Formularios;


import Classes.ConfigClass;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {
    public FrmPrincipal() {
        initComponents();
     }

    static String ComponenteSelecionado = "";
    public static ConfigClass Config = new ConfigClass();

    public static boolean AbrirNavegador(String URL) {
        //minimizes the app

        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        try {
            if (SistemaOperacional.indexOf("win") >= 0) {
                String[] cmd = new String[4];
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = "start";
                cmd[3] = URL;
                Executador.exec(cmd);
            } else if (SistemaOperacional.indexOf("mac") >= 0) {
                Executador.exec("open " + URL);
            } else {
                //prioritized 'guess' of users' preference
                String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx"};
                StringBuffer cmd = new StringBuffer();
                for (int i = 0; i < browsers.length; i++) {
                   cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \"" +
                           URL + "\" ");
                }
                Executador.exec(new String[]{"sh", "-c", cmd.toString()});
                //rt.exec("firefox http://www.google.com");
                //System.out.println(cmd.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ConfigClass.Mensagem_Erro(
                "\n\n O TMW-Maker não conseguiu abrir o seu navegador padrão ao tentar acessar: \n\n " + URL + "\n\n",
                "Erro de acesso ao Navegado"
            );

            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LblEstatus = new javax.swing.JLabel();
        PgbBarra = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuSistema = new javax.swing.JMenu();
        MnuSistemaEnviar = new javax.swing.JMenuItem();
        MnuSistemaReceber = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();
        MnuSistemaAlteracoes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        MnuSistemaFechar = new javax.swing.JMenuItem();
        MnuEditar = new javax.swing.JMenu();
        MnuEditarItens = new javax.swing.JMenu();
        MnuEditarItensSprites = new javax.swing.JMenuItem();
        MnuEditarItensDados = new javax.swing.JMenuItem();
        MnuEditarCampos = new javax.swing.JMenu();
        MnuEditarCamposTilesets = new javax.swing.JMenuItem();
        MnuEditarCamposPortais = new javax.swing.JMenuItem();
        MnuEditarCamposMapas = new javax.swing.JMenuItem();
        MnuEditarPersonagem = new javax.swing.JMenu();
        MnuEditarPersonagemAparencia = new javax.swing.JMenuItem();
        MnuEditarPersonagemLoja = new javax.swing.JMenuItem();
        MnuEditarPersonagemScript = new javax.swing.JMenuItem();
        MnuEditarInimigos = new javax.swing.JMenu();
        MnuEditarInimigosAnimacao = new javax.swing.JMenuItem();
        MnuEditarInimigosDados = new javax.swing.JMenuItem();
        MnuEditarInimigosArenas = new javax.swing.JMenuItem();
        MnuEditarMagias = new javax.swing.JMenu();
        MnuEditarMagiasCompetencias = new javax.swing.JMenuItem();
        MnuEditarMagiasConjurações = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        MnuEditarPoderGM = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MnuJogoExecutar = new javax.swing.JMenuItem();
        MnuJogoEstruturar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        MnuAjudaComentarios = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        MnuAjudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TMW-MAKER 0.2");
        setForeground(java.awt.Color.white);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/ceu_1570x1024.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        LblEstatus.setBackground(java.awt.SystemColor.activeCaptionBorder);
        LblEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        LblEstatus.setText("Bem Vindo ao TMW-Maker!");
        LblEstatus.setBorder(null);

        PgbBarra.setString("");
        PgbBarra.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
            .addComponent(PgbBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MnuSistema.setMnemonic('S');
        MnuSistema.setText("Sistema");

        MnuSistemaEnviar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_upload.gif"))); // NOI18N
        MnuSistemaEnviar.setMnemonic('E');
        MnuSistemaEnviar.setText("Enviar");
        MnuSistemaEnviar.setEnabled(false);
        MnuSistema.add(MnuSistemaEnviar);

        MnuSistemaReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_download.gif"))); // NOI18N
        MnuSistemaReceber.setMnemonic('R');
        MnuSistemaReceber.setText("Receber");
        MnuSistemaReceber.setEnabled(false);
        MnuSistemaReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaReceberActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaReceber);
        MnuSistema.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_chaveinglesa.gif"))); // NOI18N
        jMenuItem3.setMnemonic('G');
        jMenuItem3.setText("Configurações");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MnuSistema.add(jMenuItem3);

        MnuSistemaAlteracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_file_rss.gif"))); // NOI18N
        MnuSistemaAlteracoes.setText("Alterações");
        MnuSistemaAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaAlteracoesActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaAlteracoes);
        MnuSistema.add(jSeparator2);

        MnuSistemaFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaFechar.setMnemonic('F');
        MnuSistemaFechar.setText("Fechar");
        MnuSistemaFechar.setName("BtnPrincipalFechar"); // NOI18N
        MnuSistemaFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaFecharActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaFechar);
        MnuSistemaFechar.getAccessibleContext().setAccessibleName("BtnPrincipalFechar");

        jMenuBar1.add(MnuSistema);

        MnuEditar.setMnemonic('E');
        MnuEditar.setText("Editar");

        MnuEditarItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_presente.gif"))); // NOI18N
        MnuEditarItens.setMnemonic('I');
        MnuEditarItens.setText("Itens");

        MnuEditarItensSprites.setMnemonic('S');
        MnuEditarItensSprites.setText("Sprites");
        MnuEditarItensSprites.setEnabled(false);
        MnuEditarItens.add(MnuEditarItensSprites);

        MnuEditarItensDados.setMnemonic('D');
        MnuEditarItensDados.setText("Dados");
        MnuEditarItensDados.setEnabled(false);
        MnuEditarItens.add(MnuEditarItensDados);

        MnuEditar.add(MnuEditarItens);

        MnuEditarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_terreno.gif"))); // NOI18N
        MnuEditarCampos.setMnemonic('C');
        MnuEditarCampos.setText("Campos");

        MnuEditarCamposTilesets.setMnemonic('T');
        MnuEditarCamposTilesets.setText("Tilesets");
        MnuEditarCamposTilesets.setEnabled(false);
        MnuEditarCampos.add(MnuEditarCamposTilesets);

        MnuEditarCamposPortais.setMnemonic('P');
        MnuEditarCamposPortais.setText("Portais");
        MnuEditarCamposPortais.setEnabled(false);
        MnuEditarCampos.add(MnuEditarCamposPortais);

        MnuEditarCamposMapas.setMnemonic('M');
        MnuEditarCamposMapas.setText("Mini-mapas");
        MnuEditarCamposMapas.setEnabled(false);
        MnuEditarCampos.add(MnuEditarCamposMapas);

        MnuEditar.add(MnuEditarCampos);

        MnuEditarPersonagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pessoa.gif"))); // NOI18N
        MnuEditarPersonagem.setMnemonic('P');
        MnuEditarPersonagem.setText("Personagem");

        MnuEditarPersonagemAparencia.setMnemonic('A');
        MnuEditarPersonagemAparencia.setText("Aparencia");
        MnuEditarPersonagemAparencia.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemAparencia);

        MnuEditarPersonagemLoja.setMnemonic('L');
        MnuEditarPersonagemLoja.setText("Loja");
        MnuEditarPersonagemLoja.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemLoja);

        MnuEditarPersonagemScript.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarPersonagemScript.setMnemonic('S');
        MnuEditarPersonagemScript.setText("Script");
        MnuEditarPersonagemScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarPersonagemScriptActionPerformed(evt);
            }
        });
        MnuEditarPersonagem.add(MnuEditarPersonagemScript);

        MnuEditar.add(MnuEditarPersonagem);

        MnuEditarInimigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_robotuatec.gif"))); // NOI18N
        MnuEditarInimigos.setMnemonic('N');
        MnuEditarInimigos.setText("Inimigos");

        MnuEditarInimigosAnimacao.setMnemonic('A');
        MnuEditarInimigosAnimacao.setText("Animação");
        MnuEditarInimigosAnimacao.setEnabled(false);
        MnuEditarInimigos.add(MnuEditarInimigosAnimacao);

        MnuEditarInimigosDados.setMnemonic('D');
        MnuEditarInimigosDados.setText("Dados");
        MnuEditarInimigosDados.setEnabled(false);
        MnuEditarInimigos.add(MnuEditarInimigosDados);

        MnuEditarInimigosArenas.setMnemonic('R');
        MnuEditarInimigosArenas.setText("Arenas");
        MnuEditarInimigosArenas.setEnabled(false);
        MnuEditarInimigos.add(MnuEditarInimigosArenas);

        MnuEditar.add(MnuEditarInimigos);

        MnuEditarMagias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_arvore.gif"))); // NOI18N
        MnuEditarMagias.setMnemonic('M');
        MnuEditarMagias.setText("Magias");

        MnuEditarMagiasCompetencias.setMnemonic('M');
        MnuEditarMagiasCompetencias.setText("Competencias");
        MnuEditarMagiasCompetencias.setEnabled(false);
        MnuEditarMagias.add(MnuEditarMagiasCompetencias);

        MnuEditarMagiasConjurações.setMnemonic('C');
        MnuEditarMagiasConjurações.setText("Conjurações");
        MnuEditarMagiasConjurações.setEnabled(false);
        MnuEditarMagias.add(MnuEditarMagiasConjurações);

        MnuEditar.add(MnuEditarMagias);
        MnuEditar.add(jSeparator3);

        MnuEditarPoderGM.setText("Poder GM");
        MnuEditarPoderGM.setEnabled(false);
        MnuEditar.add(MnuEditarPoderGM);

        jMenuItem6.setMnemonic('A');
        jMenuItem6.setText("Partículas");
        jMenuItem6.setEnabled(false);
        MnuEditar.add(jMenuItem6);

        jMenuBar1.add(MnuEditar);

        jMenu4.setMnemonic('J');
        jMenu4.setText("Jogo");

        MnuJogoExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        MnuJogoExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        MnuJogoExecutar.setMnemonic('E');
        MnuJogoExecutar.setText("Executar");
        MnuJogoExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoExecutarActionPerformed(evt);
            }
        });
        jMenu4.add(MnuJogoExecutar);

        MnuJogoEstruturar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoEstruturar.setMnemonic('S');
        MnuJogoEstruturar.setText("Estruturar");
        MnuJogoEstruturar.setEnabled(false);
        jMenu4.add(MnuJogoEstruturar);

        jMenuBar1.add(jMenu4);

        jMenu5.setMnemonic('A');
        jMenu5.setText("Ajuda");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem9.setMnemonic('P');
        jMenuItem9.setText("Componentes");
        jMenuItem9.setEnabled(false);
        jMenu5.add(jMenuItem9);

        MnuAjudaComentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_comentario.gif"))); // NOI18N
        MnuAjudaComentarios.setMnemonic('C');
        MnuAjudaComentarios.setText("Comentários");
        MnuAjudaComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAjudaComentariosActionPerformed(evt);
            }
        });
        jMenu5.add(MnuAjudaComentarios);

        jMenuItem11.setText("Traduções");
        jMenuItem11.setEnabled(false);
        jMenu5.add(jMenuItem11);
        jMenu5.add(jSeparator4);

        MnuAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_contato.gif"))); // NOI18N
        MnuAjudaSobre.setText("Sobre...");
        MnuAjudaSobre.setName("MnuPrincipalSobre"); // NOI18N
        MnuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAjudaSobreActionPerformed(evt);
            }
        });
        jMenu5.add(MnuAjudaSobre);
        MnuAjudaSobre.getAccessibleContext().setAccessibleName("MnuPrincipalSobre");

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnuSistemaFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaFecharActionPerformed
       // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_MnuSistemaFecharActionPerformed
    private void MnuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaSobreActionPerformed
       // TODO add your handling code here:
       javax.swing.JDialog FrmSplash = new FrmSplash(this, rootPaneCheckingEnabled);
       FrmSplash.setLocation(
               ((this.getWidth() - FrmSplash.getWidth()) / 2) + this.getX(),
               ((this.getHeight() - FrmSplash.getHeight()) / 2) + this.getY());
       FrmSplash.pack();
       FrmSplash.setModal(true);
       FrmSplash.setVisible(true);/**/
    }//GEN-LAST:event_MnuAjudaSobreActionPerformed
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       // TODO add your handling code here:
       Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
       this.setBounds(
               (Tela.width - this.getWidth()) / 2,
               (Tela.height - this.getHeight()) / 2,
               this.getWidth(),
               this.getHeight());
       this.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
        try {
            Config.ConfiguracoesAbrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       javax.swing.JDialog FrmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
       FrmConfiguracao.setLocation(
               ((this.getWidth() - FrmConfiguracao.getWidth()) / 2) + this.getX(),
               ((this.getHeight() - FrmConfiguracao.getHeight()) / 2) + this.getY());
       FrmConfiguracao.pack();
       FrmConfiguracao.setModal(true);
       FrmConfiguracao.setVisible(true);/**/
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void MnuSistemaAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAlteracoesActionPerformed
       // TODO add your handling code here:
       AbrirNavegador(FrmPrincipal.Config.getDocumentacaoAlteracoes());
    }//GEN-LAST:event_MnuSistemaAlteracoesActionPerformed
    private void MnuAjudaComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaComentariosActionPerformed
       // TODO add your handling code here:
       AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComentarios());
    }//GEN-LAST:event_MnuAjudaComentariosActionPerformed
    private void MnuJogoExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoExecutarActionPerformed
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        String Comando = null;
        
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        if (SistemaOperacional.indexOf("win") >= 0) {
            /*String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = URL;
            Executador.exec(cmd);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o windows!","Descupe!");
            //C:\cygwin\cygwin.exe
            //C:\Arquivos de programas\Mana\mana.exe
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            try {
                LblEstatus.setText("Abrindo aplicativo \""+FrmPrincipal.Config.getExecucaoComando()+"\"...");
                Comando=FrmPrincipal.Config.getExecucaoComando()+" "+
                (FrmPrincipal.Config.getExecucaoParametroTMWData().isEmpty()?"":("-ud "+FrmPrincipal.Config.getExecucaoParametroTMWData()+" "))+
                (FrmPrincipal.Config.getExecucaoParametroServidor().isEmpty()?"":("--server "+FrmPrincipal.Config.getExecucaoParametroServidor()+" "))+
                (FrmPrincipal.Config.getExecucaoParametroConta().isEmpty()?"":("--username "+FrmPrincipal.Config.getExecucaoParametroConta()+" "))+
                (FrmPrincipal.Config.getExecucaoParametroSenha().isEmpty()?"":("--password "+FrmPrincipal.Config.getExecucaoParametroSenha()+" "))+
                (FrmPrincipal.Config.getExecucaoParametroPersonagem().isEmpty()?"":("--character "+FrmPrincipal.Config.getExecucaoParametroPersonagem()+" "))+
                (FrmPrincipal.Config.getExecucaoParametroSemopengl()==true?"--no-opengl":"");

                if(FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost") || FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost")){
                    LblEstatus.setText("Reiniciando localhost...");
                    Executador.exec(FrmPrincipal.Config.getConexaoLocalhost()+"/eathena-data/eathena.sh restart");
                    LblEstatus.setText("Espere 5 segundos...");
                    FrmPrincipal.Config.Esperar(5500);
                }
                Executador.exec(Comando);
                LblEstatus.setText("Abrindo \""+FrmPrincipal.Config.getExecucaoComando()+"\"!");
            } catch (IOException e) {
                e.printStackTrace();
                LblEstatus.setText("ERRO: "+Comando);
                ConfigClass.Mensagem_Erro("<html><b>O TMW-Maker não conseguiu abrir o aplicativo cliente padrão para The Mana World:</b><br/><br/>"+
                    "01: <font face=\"monospace\" color=\"#FF0000\">"+FrmPrincipal.Config.getConexaoLocalhost()+"/eathena-data/eathena.sh restart</font><br/>"+
                    "02: <font face=\"monospace\" color=\"#FF0000\">"+Comando+"/eathena-data/eathena.sh restart</font><br/>"+
                    "</html>",
                    "Erro de "+FrmPrincipal.Config.getExecucaoComando()
                );
            }
        }
        
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_MnuJogoExecutarActionPerformed
    private void MnuEditarPersonagemScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarPersonagemScriptActionPerformed
        javax.swing.JDialog FrmNpcScript = new FrmScript(this, rootPaneCheckingEnabled);
        FrmNpcScript.setLocation(
            ((this.getWidth() - FrmNpcScript.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmNpcScript.getHeight()) / 2) + this.getY());
        FrmNpcScript.pack();
        FrmNpcScript.setModal(true);
        FrmNpcScript.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarPersonagemScriptActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(Config.SeComandoProcede("svn --help")){
            MnuSistemaReceber.setEnabled(true);
            //MnuSistemaEnviar.setEnabled(true);
        }else{
            MnuSistemaReceber.setEnabled(false);
            MnuSistemaEnviar.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowActivated

    private void MnuSistemaReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaReceberActionPerformed
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            PgbBarra.setIndeterminate(true);
            PgbBarra.setString("Preparando...");
            FrmPrincipal.LblEstatus.setText("Preparando para baixar...");
            PgbBarra.setEnabled(true);
            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    // operacao demorada
                    boolean SeConclui=false;
                    Runtime Executador = Runtime.getRuntime();
                    String line="", Partes[];
                    String Comando ="";
                    int Arquivos=0;

                    Comando ="svn checkout "+Config.getConexaoRepositorio()+" "+Config.getConexaoLocalhost();
                    Partes = Config.getConexaoRepositorio().split(":");
                    if(Partes.length>1 && Partes[0].toLowerCase().equals("https")){
                        Comando+=" --username "+Config.getConexaoUsuario()+" --password "+Config.getConexaoSenha();
                    }

                    try {
                        Process Retorno=Executador.exec(Comando);
                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            FrmPrincipal.LblEstatus.setText("<html>BAIXANDO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                            Arquivos++;
                            PgbBarra.setString("nº"+Arquivos);
                            //Partes=line.split("/");
                            //PgbBarra.setString(Partes[Partes.length-1]);
                        }
                        //ConfigClass.Mensagem_Erro("Repositório \""+Config.getConexaoLocalhost()+"\" recebido com sucesso!", "AVISO");
                        FrmPrincipal.LblEstatus.setText("<html>Repositório \"<font color=\"#0000FF\"><b>"+Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                        PgbBarra.setString("Concluido!");
                    } catch (IOException e) {
                        //ConfigClass.Mensagem_Erro("<html><font color=\"#FF0000\">Falha ao receber o repositório \""+Config.getConexaoUsuario()+"\"!", "ERRO");
                        FrmPrincipal.LblEstatus.setText("<html><font color=\"#FF0000\">Falha ao receber o repositório \"<b>"+Config.getConexaoUsuario()+"</b>\"!");
                        PgbBarra.setString("ERRO!");
                    }/**/
                    PgbBarra.setIndeterminate(false);
                    
                }
            });
            tThread.start();



            /*if(SeConclui){
                ConfigClass.Mensagem_Erro("Repositório \""+Config.getConexaoUsuario()+"\" recebido com sucesso!", "AVISO");
            }else{
                ConfigClass.Mensagem_Erro("Falha ao receber o repositório \""+Config.getConexaoUsuario()+"\"!", "ERRO");
            }/**/
            /*try {
                Process Retorno=Executador.exec(Comando);
                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                ConfigClass.Mensagem_Erro("Repositório \""+Config.getConexaoUsuario()+"\" recebido com sucesso!", "AVISO");
            } catch (IOException e) {
                ConfigClass.Mensagem_Erro("Falha ao receber o repositório \""+Config.getConexaoUsuario()+"\"!", "ERRO");
            }/**/
        }
    }//GEN-LAST:event_MnuSistemaReceberActionPerformed


    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new FrmPrincipal().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LblEstatus;
    private javax.swing.JMenuItem MnuAjudaComentarios;
    private javax.swing.JMenuItem MnuAjudaSobre;
    private javax.swing.JMenu MnuEditar;
    private javax.swing.JMenu MnuEditarCampos;
    private javax.swing.JMenuItem MnuEditarCamposMapas;
    private javax.swing.JMenuItem MnuEditarCamposPortais;
    private javax.swing.JMenuItem MnuEditarCamposTilesets;
    private javax.swing.JMenu MnuEditarInimigos;
    private javax.swing.JMenuItem MnuEditarInimigosAnimacao;
    private javax.swing.JMenuItem MnuEditarInimigosArenas;
    private javax.swing.JMenuItem MnuEditarInimigosDados;
    private javax.swing.JMenu MnuEditarItens;
    private javax.swing.JMenuItem MnuEditarItensDados;
    private javax.swing.JMenuItem MnuEditarItensSprites;
    private javax.swing.JMenu MnuEditarMagias;
    private javax.swing.JMenuItem MnuEditarMagiasCompetencias;
    private javax.swing.JMenuItem MnuEditarMagiasConjurações;
    private javax.swing.JMenu MnuEditarPersonagem;
    private javax.swing.JMenuItem MnuEditarPersonagemAparencia;
    private javax.swing.JMenuItem MnuEditarPersonagemLoja;
    private javax.swing.JMenuItem MnuEditarPersonagemScript;
    private javax.swing.JMenuItem MnuEditarPoderGM;
    private javax.swing.JMenuItem MnuJogoEstruturar;
    private javax.swing.JMenuItem MnuJogoExecutar;
    private javax.swing.JMenu MnuSistema;
    private javax.swing.JMenuItem MnuSistemaAlteracoes;
    private javax.swing.JMenuItem MnuSistemaEnviar;
    private javax.swing.JMenuItem MnuSistemaFechar;
    private javax.swing.JMenuItem MnuSistemaReceber;
    private javax.swing.JProgressBar PgbBarra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
