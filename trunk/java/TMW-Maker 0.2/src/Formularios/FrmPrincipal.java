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

        PnlBarraDeEstatus = new javax.swing.JPanel();
        LblEstatus = new javax.swing.JLabel();
        PgbBarra = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuSistema = new javax.swing.JMenu();
        MnuSistemaEnviar = new javax.swing.JMenuItem();
        MnuSistemaReceber = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        MnuConfiguracoes = new javax.swing.JMenuItem();
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
        MnuEditarContas = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        MnuJogo = new javax.swing.JMenu();
        MnuJogoExecutar = new javax.swing.JMenuItem();
        MnuJogoEstruturar = new javax.swing.JMenuItem();
        MnuAjuda = new javax.swing.JMenu();
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

        PnlBarraDeEstatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PnlBarraDeEstatus.setAlignmentX(0.0F);
        PnlBarraDeEstatus.setAlignmentY(0.0F);

        LblEstatus.setBackground(java.awt.SystemColor.activeCaptionBorder);
        LblEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        LblEstatus.setText("Bem Vindo ao TMW-Maker!");
        LblEstatus.setBorder(null);

        PgbBarra.setString("");
        PgbBarra.setStringPainted(true);

        javax.swing.GroupLayout PnlBarraDeEstatusLayout = new javax.swing.GroupLayout(PnlBarraDeEstatus);
        PnlBarraDeEstatus.setLayout(PnlBarraDeEstatusLayout);
        PnlBarraDeEstatusLayout.setHorizontalGroup(
            PnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlBarraDeEstatusLayout.createSequentialGroup()
                .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlBarraDeEstatusLayout.setVerticalGroup(
            PnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
            .addComponent(PgbBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/tmw-maker.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

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

        MnuConfiguracoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        MnuConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_chaveinglesa.gif"))); // NOI18N
        MnuConfiguracoes.setMnemonic('G');
        MnuConfiguracoes.setText("Configurações");
        MnuConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuConfiguracoesActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuConfiguracoes);

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

        MnuEditarContas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_contato.gif"))); // NOI18N
        MnuEditarContas.setMnemonic('T');
        MnuEditarContas.setText("Contas");
        MnuEditarContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarContasActionPerformed(evt);
            }
        });
        MnuEditar.add(MnuEditarContas);

        jMenuItem6.setMnemonic('A');
        jMenuItem6.setText("Partículas");
        jMenuItem6.setEnabled(false);
        MnuEditar.add(jMenuItem6);

        jMenuBar1.add(MnuEditar);

        MnuJogo.setMnemonic('J');
        MnuJogo.setText("Jogo");

        MnuJogoExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        MnuJogoExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/tmw-br.png"))); // NOI18N
        MnuJogoExecutar.setMnemonic('E');
        MnuJogoExecutar.setText("Executar");
        MnuJogoExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoExecutarActionPerformed(evt);
            }
        });
        MnuJogo.add(MnuJogoExecutar);

        MnuJogoEstruturar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoEstruturar.setMnemonic('S');
        MnuJogoEstruturar.setText("Estruturar");
        MnuJogoEstruturar.setEnabled(false);
        MnuJogo.add(MnuJogoEstruturar);

        jMenuBar1.add(MnuJogo);

        MnuAjuda.setMnemonic('A');
        MnuAjuda.setText("Ajuda");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem9.setMnemonic('P');
        jMenuItem9.setText("Componentes");
        jMenuItem9.setEnabled(false);
        MnuAjuda.add(jMenuItem9);

        MnuAjudaComentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_comentario.gif"))); // NOI18N
        MnuAjudaComentarios.setMnemonic('C');
        MnuAjudaComentarios.setText("Comentários");
        MnuAjudaComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAjudaComentariosActionPerformed(evt);
            }
        });
        MnuAjuda.add(MnuAjudaComentarios);

        jMenuItem11.setText("Traduções");
        jMenuItem11.setEnabled(false);
        MnuAjuda.add(jMenuItem11);
        MnuAjuda.add(jSeparator4);

        MnuAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_contato.gif"))); // NOI18N
        MnuAjudaSobre.setText("Sobre...");
        MnuAjudaSobre.setName("MnuPrincipalSobre"); // NOI18N
        MnuAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAjudaSobreActionPerformed(evt);
            }
        });
        MnuAjuda.add(MnuAjudaSobre);
        MnuAjudaSobre.getAccessibleContext().setAccessibleName("MnuPrincipalSobre");

        jMenuBar1.add(MnuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlBarraDeEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlBarraDeEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void MnuAjudaComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaComentariosActionPerformed
       // TODO add your handling code here:
       AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComentarios());
    }//GEN-LAST:event_MnuAjudaComentariosActionPerformed
    private void MnuJogoExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoExecutarActionPerformed
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        
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
            //Executador.exec("open " + URL);
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {


            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    MnuSistema.setEnabled(false);
                    MnuEditar.setEnabled(false);
                    MnuJogo.setEnabled(false);
                    MnuAjuda.setEnabled(false);

                    PgbBarra.setEnabled(true);
                    PgbBarra.setValue(0);
                    PgbBarra.setMinimum(0);
                    PgbBarra.setMaximum(5);

                    /*javax.swing.JFrame FrmEstatus = new FrmEstatus();
                    Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
                    FrmEstatus.setBounds(
                        (Tela.width - FrmEstatus.getWidth()) / 2,
                        (Tela.height - FrmEstatus.getHeight()) / 2,
                    FrmEstatus.getWidth(),
                    FrmEstatus.getHeight());
                    //FrmEstatus.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
                     * FrmEstatus.setVisible(true);
                    /**/
                    

                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    Runtime Executador = Runtime.getRuntime();
                    String line="", Comando="";

                    if(FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost") || FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost")){
                        PgbBarra.setString("Reiniciando...");
                        LblEstatus.setText("Reiniciando localhost...");
                        //TxtEstatus.setText("Reiniciando localhost...");
                        try {
                            Comando=FrmPrincipal.Config.getConexaoLocalhost()+"/eathena-data/eathena.sh restart";
                            //TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
                            Process Retorno=Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                                //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
                            }
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nEathena reiniciado (Espere 5 segundos...)\n");
                            LblEstatus.setText("<html>Eathena reiniciado (<font color=\"#0000FF\"><b>Espere 5 segundos...</b></font>)");
                            long TempoInicio=0,TempoAtual=0,Milisegundos=5500,Segundos=0;
                            TempoInicio=System.currentTimeMillis();
                            do{
                                TempoAtual=System.currentTimeMillis();
                                Segundos=(TempoAtual-TempoInicio)/1000;
                                //LblEstatus.setText("Espere "+Segundos+"/5 segundos...");
                                PgbBarra.setValue((int)Segundos);
                                PgbBarra.setString("00:00:0"+(5-((int)Segundos)));
                            }
                            while (TempoAtual-TempoInicio<Milisegundos);
                        } catch (IOException e) {
                            e.printStackTrace();
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                            LblEstatus.setText("<html><font color=\"#FF0000\"><b>ERRO:</b></font> "+Comando);
                            ConfigClass.Mensagem_Erro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>"+
                                "01: <font face=\"monospace\" color=\"#FF0000\">"+Comando+"</font><br/>"+
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                        }
                    }
                    PgbBarra.setIndeterminate(true);
                    //TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+FrmPrincipal.Config.getExecucaoComando()+"\"...");
                    LblEstatus.setText("Abrindo aplicativo \""+FrmPrincipal.Config.getExecucaoComando()+"\"...");
                    Comando=FrmPrincipal.Config.getExecucaoComando()+" "+
                    (FrmPrincipal.Config.getExecucaoParametroTMWData().isEmpty()?"":("-ud "+FrmPrincipal.Config.getExecucaoParametroTMWData()+" "))+
                    (FrmPrincipal.Config.getExecucaoParametroServidor().isEmpty()?"":("--server "+FrmPrincipal.Config.getExecucaoParametroServidor()+" "))+
                    (FrmPrincipal.Config.getExecucaoParametroConta().isEmpty()?"":("--username "+FrmPrincipal.Config.getExecucaoParametroConta()+" "))+
                    (FrmPrincipal.Config.getExecucaoParametroSenha().isEmpty()?"":("--password "+FrmPrincipal.Config.getExecucaoParametroSenha()+" "))+
                    (FrmPrincipal.Config.getExecucaoParametroPersonagem().isEmpty()?"":("--character "+FrmPrincipal.Config.getExecucaoParametroPersonagem()+" "))+
                    (FrmPrincipal.Config.getExecucaoParametroSemopengl()==true?"--no-opengl":"");
                    try {
                        Process Retorno=Executador.exec(Comando);
                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
                            FrmPrincipal.LblEstatus.setText("<html>Aplicativo \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getExecucaoComando()+"</b></font>\": "+line);
                            PgbBarra.setString("Executando...");
                        }
                        //TxtEstatus.setText(TxtEstatus.getText()+"\nEncerrado!");
                        PgbBarra.setString("Encerrado!");
                        LblEstatus.setText("<html>Aplicativo \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getExecucaoComando()+"</b></font>\" executado e fechando com sucesso!");
                        PgbBarra.setIndeterminate(false);
                    } catch (IOException e) {
                        PgbBarra.setIndeterminate(false);
                        e.printStackTrace();
                        PgbBarra.setString("ERRO...");
                        //TxtEstatus.setText(TxtEstatus.getText()+"ERRO DE EXECUÇÃO: "+Comando);
                        LblEstatus.setText("<html><font color=\"#FF0000\"><b>ERRO DE EXECUÇÃO:</b></font> "+Comando);
                        ConfigClass.Mensagem_Erro("O TMW-Maker não conseguiu abrir o jogo THE MANA WORLD!","ERRO DE EXECUÇÃO");
                    }
                    PgbBarra.setValue(5);
                    MnuSistema.setEnabled(true);
                    MnuEditar.setEnabled(true);
                    MnuJogo.setEnabled(true);
                    MnuAjuda.setEnabled(true);
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            tThread.start();
        }
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
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            MnuSistemaReceber.setEnabled(false);
            MnuSistemaEnviar.setEnabled(false);
            MnuEditarContas.setEnabled(false);
        } else if (SistemaOperacional.indexOf("mac") >= 0) {

            MnuSistemaReceber.setEnabled(false);
            MnuSistemaEnviar.setEnabled(false);
            MnuEditarContas.setEnabled(false);
        } else {
            if(Config.SeComandoProcede("svn --help")){
                MnuSistemaReceber.setEnabled(true);
                //MnuSistemaEnviar.setEnabled(true);
            }else{
                MnuSistemaReceber.setEnabled(false);
                MnuSistemaEnviar.setEnabled(false);
            }
            if(
                ConfigClass.SeExiste(
                    Config.getConexaoLocalhost()+
                    System.getProperty("file.separator")+"eathena-data"+
                    System.getProperty("file.separator")+"save"+
                    System.getProperty("file.separator")+"account.txt"
                )
                &&
                ConfigClass.SeExiste(
                    Config.getConexaoLocalhost()+
                    System.getProperty("file.separator")+"eathena-data"+
                    System.getProperty("file.separator")+"conf"+
                    System.getProperty("file.separator")+"gm_account.txt"
                )
            ){
                MnuEditarContas.setEnabled(true);
            }else{
                MnuEditarContas.setEnabled(false);
            }
        }
        
    }//GEN-LAST:event_formWindowActivated
    private void MnuSistemaFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaFecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_MnuSistemaFecharActionPerformed
    private void MnuSistemaAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAlteracoesActionPerformed
        // TODO add your handling code here:
        AbrirNavegador(FrmPrincipal.Config.getDocumentacaoAlteracoes());
}//GEN-LAST:event_MnuSistemaAlteracoesActionPerformed
    private void MnuConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuConfiguracoesActionPerformed
        javax.swing.JDialog FrmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
        FrmConfiguracao.setLocation(
                ((this.getWidth() - FrmConfiguracao.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmConfiguracao.getHeight()) / 2) + this.getY());
        FrmConfiguracao.pack();
        FrmConfiguracao.setModal(true);
        FrmConfiguracao.setVisible(true);/**/
}//GEN-LAST:event_MnuConfiguracoesActionPerformed
    private void MnuSistemaReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaReceberActionPerformed
        javax.swing.JDialog FrmCheckout = new FrmCheckout(this, rootPaneCheckingEnabled);
        FrmCheckout.setLocation(
                ((this.getWidth() - FrmCheckout.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmCheckout.getHeight()) / 2) + this.getY());
        FrmCheckout.pack();
        FrmCheckout.setModal(true);
        FrmCheckout.setVisible(true);/**/
}//GEN-LAST:event_MnuSistemaReceberActionPerformed
    private void MnuEditarContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarContasActionPerformed
        javax.swing.JDialog FrmContas = new FrmContas(this, rootPaneCheckingEnabled);
        FrmContas.setLocation(
                ((this.getWidth() - FrmContas.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmContas.getHeight()) / 2) + this.getY());
        FrmContas.pack();
        FrmContas.setModal(true);
        FrmContas.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarContasActionPerformed

    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new FrmPrincipal().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel LblEstatus;
    private javax.swing.JMenu MnuAjuda;
    private javax.swing.JMenuItem MnuAjudaComentarios;
    private javax.swing.JMenuItem MnuAjudaSobre;
    private javax.swing.JMenuItem MnuConfiguracoes;
    private javax.swing.JMenu MnuEditar;
    private javax.swing.JMenu MnuEditarCampos;
    private javax.swing.JMenuItem MnuEditarCamposMapas;
    private javax.swing.JMenuItem MnuEditarCamposPortais;
    private javax.swing.JMenuItem MnuEditarCamposTilesets;
    private javax.swing.JMenuItem MnuEditarContas;
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
    private javax.swing.JMenu MnuJogo;
    private javax.swing.JMenuItem MnuJogoEstruturar;
    private javax.swing.JMenuItem MnuJogoExecutar;
    private javax.swing.JMenu MnuSistema;
    private javax.swing.JMenuItem MnuSistemaAlteracoes;
    private javax.swing.JMenuItem MnuSistemaEnviar;
    private javax.swing.JMenuItem MnuSistemaFechar;
    private javax.swing.JMenuItem MnuSistemaReceber;
    public static javax.swing.JProgressBar PgbBarra;
    private javax.swing.JPanel PnlBarraDeEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
