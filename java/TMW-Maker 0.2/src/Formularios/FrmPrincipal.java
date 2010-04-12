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


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import java.io.File;
import org.w3c.dom.*;


/**
 *
 * @author indigovox
 */

class XMLFile {


    private String mFirstName;
    private String mLastName;
    private int mYearsOld;
    private String mAddress;
    private String mCity;
    private String mState;
    private String mPhoneNumber;
    private String mEmail;

    public void setFirstName(String value) {
        this.mFirstName = value;
    }
    public void setLastName(String value) {
        this.mLastName = value;
    }
    public void setYearsOld(int value) {
        this.mYearsOld = value;
    }
    public void setAddress(String value) {
        this.mAddress = value;
    }
    public void setCity(String value) {
        this.mCity = value;
    }
    public void setState(String value) {
        this.mState = value;
    }
    public void setPhoneNumber(String value) {
        this.mPhoneNumber = value;
    }
    public void setEmail(String value) {
        this.mEmail = value;
    }
    public String getFirstName() {
        return this.mFirstName;
    }
    public String getLastName() {
        return this.mLastName;
    }
    public int getYearsOld() {
        return this.mYearsOld;
    }
    public String getAddress() {
        return this.mAddress;
    }
    public String getCity() {
        return this.mCity;
    }
    public String getState() {
        return this.mState;
    }
    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }
    public String getEmail() {
        return this.mEmail;
    }

    //
    public boolean saveTo(String filename) {
        try {
            //DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            //DocumentBuilder builder = fac.newDocumentBuilder();
            //Document doc = builder.newDocument();

            /**
             * <vcard>
             *    <name first="Stately" last="Máximos"/>
             *    <age value="99"/>
             *    <address city="Acolá" state="PE">Rua dos Bobo nº0</address>
             *    <contact email="dono@provedor.com.br" phone="06660666"/>
             * </vcard>
             */
            Document Documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Documento.setXmlVersion("1.0");
            Element vcard = Documento.createElement("vcard");
            Documento.appendChild(vcard);
            Element Elemento = Documento.createElement("name");
            vcard.appendChild(Elemento);
            Elemento.setAttribute("first", this.mFirstName);
            Elemento.setAttribute("last", this.mLastName);
            Elemento = Documento.createElement("age");
            vcard.appendChild(Elemento);
            Elemento.setAttribute("value", String.valueOf(this.mYearsOld));
            Elemento = Documento.createElement("address");
            vcard.appendChild(Elemento);
            Elemento.setAttribute("city", this.mCity);
            Elemento.setAttribute("state", this.mState);
            Elemento.appendChild(Documento.createTextNode(this.mAddress));
            Elemento = Documento.createElement("contact");
            vcard.appendChild(Elemento);
            Elemento.setAttribute("phone", this.mPhoneNumber);
            Elemento.setAttribute("email", this.mEmail);

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
    }
}


public class FrmPrincipal extends javax.swing.JFrame {

    static String ComponenteSelecionado = "";
    static String AppVersao = "0.2";

    static String ConexaoRepositorio = "http://themanaworld-br.googlecode.com/svn";
    static String ConexaoLocalhost = System.getProperty("user.home");
    static String ConexaoUsuario = "";
    static String ConexaoSenha = "";

    static String    ExecucaoComando = "mana";
    static String    ExecucaoParametroTMWData = System.getProperty("user.home")+"/tmwdata";
    static String    ExecucaoParametroServidor = "localhost";
    static String    ExecucaoParametroConta = ""; //Inicia sem valor
    static String    ExecucaoParametroSenha = ""; //Inicia sem valor
    static String    ExecucaoParametroPersonagem = ""; //Inicia sem valor
    static boolean   ExecucaoParametroSemopengl = true; //Inicia Sem OpenGL

    static String DocumentacaoAlteracoes = "http://code.google.com/p/tmw-maker/source/list";
    static String DocumentacaoComponentes = "http://code.google.com/p/tmw-maker/wiki/";
    static String DocumentacaoComentarios = "http://code.google.com/p/tmw-maker/issues/entry";
    static String DocumentacaoTraducoes = "";

        
    public FrmPrincipal() {
        initComponents();
     }
    public void setAviso(final String Aviso){
        //tProgressBar.setIndeterminate(true);
        Thread tThread = new Thread(
            new Runnable() {
                public void run() {
                    // operacao demorada
                    //tProgressBar.setIndeterminate(false);
                    LblEstatus.setText(Aviso.toString());
                }
            }
        );
        tThread.start();
    }
    public void Esperar(int Milisegundos){
        long TempoInicio,TempoAtual;

        TempoInicio=System.currentTimeMillis();
        do{
            TempoAtual=System.currentTimeMillis();
        }
        while (TempoAtual-TempoInicio<Milisegundos);
    }
    public static void AbrirConfiguracoes() {
         //new CadastroUsuariosGUJ();
    }
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
            Mensagem_Erro(
                "\n\n O TMW-Maker não conseguiu abrir o seu navegador padrão ao tentar acessar: \n\n " + URL + "\n\n",
                "Erro de acesso ao Navegado"
            );

            return false;
        }
        return true;
    }
    public static void Mensagem_Erro(String Aviso, String Titulo) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
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
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/floresta_1024x768.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        LblEstatus.setBackground(java.awt.SystemColor.activeCaptionBorder);
        LblEstatus.setText("Bem Vindo ao TMW-Maker!");
        LblEstatus.setBorder(null);

        PgbBarra.setMinimum(100);
        PgbBarra.setString("...");
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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('E');
        jMenuItem1.setText("Enviar");
        jMenuItem1.setEnabled(false);
        MnuSistema.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('R');
        jMenuItem2.setText("Receber");
        jMenuItem2.setEnabled(false);
        MnuSistema.add(jMenuItem2);
        MnuSistema.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setMnemonic('G');
        jMenuItem3.setText("Configurações");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MnuSistema.add(jMenuItem3);

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

        MnuEditarPersonagemScript.setMnemonic('S');
        MnuEditarPersonagemScript.setText("Script");
        MnuEditarPersonagemScript.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemScript);

        MnuEditar.add(MnuEditarPersonagem);

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
    }//GEN-LAST:event_formComponentShown
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       // TODO add your handling code here:
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
       AbrirNavegador(DocumentacaoAlteracoes);
    }//GEN-LAST:event_MnuSistemaAlteracoesActionPerformed
    private void MnuAjudaComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaComentariosActionPerformed
       // TODO add your handling code here:
       AbrirNavegador(DocumentacaoComentarios);
    }//GEN-LAST:event_MnuAjudaComentariosActionPerformed
    private void MnuJogoExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoExecutarActionPerformed
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        Runtime Executador = Runtime.getRuntime();
        String Comando = null;
        
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            if (SistemaOperacional.indexOf("win") >= 0) {
                /*String[] cmd = new String[4];
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = "start";
                cmd[3] = URL;
                Executador.exec(cmd);/**/
                Mensagem_Erro("Este comando ainda não foi implementado para o windows!","Descupe!");
            } else if (SistemaOperacional.indexOf("mac") >= 0) {
                /*Executador.exec("open " + URL);/**/
                Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
            } else {
                LblEstatus.setText("Abrindo aplicativo \""+ExecucaoComando+"\"...");
                Comando=ExecucaoComando+" "+
                (ExecucaoParametroTMWData.isEmpty()?"":("-ud "+ExecucaoParametroTMWData+" "))+
                (ExecucaoParametroServidor.isEmpty()?"":("--server "+ExecucaoParametroServidor+" "))+
                (ExecucaoParametroConta.isEmpty()?"":("--username "+ExecucaoParametroConta+" "))+
                (ExecucaoParametroSenha.isEmpty()?"":("--password "+ExecucaoParametroSenha+" "))+
                (ExecucaoParametroPersonagem.isEmpty()?"":("--character "+ExecucaoParametroPersonagem+" "))+
                (ExecucaoParametroSemopengl==true?"--no-opengl":"");

                LblEstatus.setText("Reiniciando localhost...");
                setAviso("Reiniciando localhost...");
                LblEstatus.updateUI();
                Executador.exec(ConexaoLocalhost+"/eathena-data/eathena.sh restart");
                LblEstatus.setText("Espere 5 segundos...");
                LblEstatus.updateUI();
                Esperar(5500);
                Executador.exec(Comando);
                LblEstatus.setText("Concluido!");
                LblEstatus.updateUI();
            }
        } catch (IOException e) {
            e.printStackTrace();
            LblEstatus.setText("ERRO: "+Comando);
            Mensagem_Erro("<html><b>O TMW-Maker não conseguiu abrir o aplicativo cliente padrão para The Mana World:</b><br/><br/>"+
                "01: <font face=\"monospace\" color=\"#FF0000\">"+ConexaoLocalhost+"/eathena-data/eathena.sh restart</font><br/>"+
                "02: <font face=\"monospace\" color=\"#FF0000\">"+Comando+"/eathena-data/eathena.sh restart</font><br/>"+
                "</html>",
                "Erro de "+ExecucaoComando
            );
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_MnuJogoExecutarActionPerformed


    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new FrmPrincipal().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblEstatus;
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
    private javax.swing.JMenuItem MnuSistemaFechar;
    private javax.swing.JProgressBar PgbBarra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
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
