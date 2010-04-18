
package Formularios;

import java.awt.Color;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import java.io.*;
import org.w3c.dom.*;
import java.awt.Toolkit;

public class FrmConfiguracao extends javax.swing.JDialog {
    
    public FrmConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

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
        String Repositorio = TxtConfiguracaoConexaoRepositorio.getText();
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
        FrmPrincipal.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComponentes().trim() + FrmPrincipal.ComponenteSelecionado.trim());
        Toolkit.getDefaultToolkit().beep();
    }
    public static void showAjuda(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_F1){showAjuda();}
    }
    public boolean SalvarConfiguracao(String filename) {
        try {
            //DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            //DocumentBuilder builder = fac.newDocumentBuilder();
            //Document doc = builder.newDocument();

            FrmPrincipal.Config.setConexaoRepositorio(TxtConfiguracaoConexaoRepositorio.getText());
            FrmPrincipal.Config.setConexaoLocalhost(TxtConfiguracaoConexaoLocalhost.getText());
            FrmPrincipal.Config.setConexaoUsuario (TxtConfiguracaoConexaoIdentificacaoUsuario.getText());
            FrmPrincipal.Config.setConexaoSenha (TxtConfiguracaoConexaoIdentificacaoSenha.getText());

            FrmPrincipal.Config.setExecucaoComando(TxtConfiguracaoExecucaoComando.getText());
            FrmPrincipal.Config.setExecucaoParametroTMWData(TxtConfiguracaoExecucaoParamentroTMWData.getText());
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
            Propriedade.setAttribute("TMWData", FrmPrincipal.Config.getExecucaoParametroTMWData());
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
            xformer.transform(source, result);/**/

            /*FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            record = new String();
            while ((record = br.readLine()) != null) {
                recCount++;
                System.out.println(recCount + ": " + record);
            }/**/


        } catch (Exception e) {
            //JOptionPane.showMessageDialog(rootPane, "N�o foi possivel salvar!");
            /*JOptionPane.showMessageDialog(
                null,
                "N�o foi possivel salvar!",
                "Erro de Grava��o",
                JOptionPane.ERROR_MESSAGE
            );/**/
            return false;
        }
        return true;

    }
    public void ImportarConfiguracao() {
        TxtConfiguracaoConexaoRepositorio.setText(FrmPrincipal.Config.getConexaoRepositorio().toString());
        TxtConfiguracaoConexaoLocalhost.setText(FrmPrincipal.Config.getConexaoLocalhost());
        TxtConfiguracaoConexaoIdentificacaoUsuario.setText(FrmPrincipal.Config.getConexaoUsuario());
        TxtConfiguracaoConexaoIdentificacaoSenha.setText(FrmPrincipal.Config.getConexaoSenha());

        TxtConfiguracaoExecucaoComando.setText(FrmPrincipal.Config.getExecucaoComando());
        TxtConfiguracaoExecucaoParamentroTMWData.setText(FrmPrincipal.Config.getExecucaoParametroTMWData());
        TxtConfiguracaoExecucaoParamentroServidor.setText(FrmPrincipal.Config.getExecucaoParametroServidor());
        TxtConfiguracaoExecucaoParamentroConta.setText(FrmPrincipal.Config.getExecucaoParametroConta());
        TxtConfiguracaoExecucaoParamentroSenha.setText(FrmPrincipal.Config.getExecucaoParametroSenha());
        TxtConfiguracaoExecucaoParamentroPersonagem.setText(FrmPrincipal.Config.getExecucaoParametroPersonagem());
        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(FrmPrincipal.Config.getExecucaoParametroSemopengl());

        TxtConfiguracaoDocumentacaoAlteracoes.setText(FrmPrincipal.Config.getDocumentacaoAlteracoes());
        TxtConfiguracaoDocumentacaoComponentes.setText(FrmPrincipal.Config.getDocumentacaoComponentes());
        TxtConfiguracaoDocumentacaoComentarios.setText(FrmPrincipal.Config.getDocumentacaoComentarios());
        TxtConfiguracaoDocumentacaoTraducoes.setText(FrmPrincipal.Config.getDocumentacaoTraducoes());
        FunMudaTesto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoRepositorio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoLocalhost = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoIdentificacaoUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtConfiguracaoConexaoIdentificacaoSenha = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoComando = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroTMWData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroServidor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroConta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroPersonagem = new javax.swing.JTextField();
        ChkConfiguracaoExecucaoParamentroSemopengl = new javax.swing.JCheckBox();
        TxtConfiguracaoExecucaoParamentroSenha = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoAlteracoes = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoComponentes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoComentarios = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtConfiguracaoDocumentacaoTraducoes = new javax.swing.JTextField();
        BtnConfiguracaoCancelar = new javax.swing.JButton();
        BtnConfiguracaoOk = new javax.swing.JButton();
        BtnConfiguracaoAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configura��es");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Reposit�rio:");

        TxtConfiguracaoConexaoRepositorio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoRepositorioFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoRepositorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoConexaoRepositorioKeyReleased(evt);
            }
        });

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Identifica��o"));
        jPanel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usu�rio:");

        TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(false);
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
                    .addComponent(TxtConfiguracaoConexaoIdentificacaoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtConfiguracaoConexaoIdentificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtConfiguracaoConexaoIdentificacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("<html><b>OBS.:</b> Inicie com \"https://\" para ativar campos \"Usu�rio\" e \"Senha\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtConfiguracaoConexaoRepositorio, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(TxtConfiguracaoConexaoLocalhost, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtConfiguracaoConexaoRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoConexaoLocalhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conex�o", jPanel1);

        jLabel5.setText("Comando de ativa��o:");

        TxtConfiguracaoExecucaoComando.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoComandoFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoComando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoComandoKeyReleased(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Par�metros"));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("tmwdata:");

        TxtConfiguracaoExecucaoParamentroTMWData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroTMWDataFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroTMWData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtConfiguracaoExecucaoParamentroTMWDataKeyReleased(evt);
            }
        });

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
        ChkConfiguracaoExecucaoParamentroSemopengl.setText("Sem OpenGL (Recomendado)");
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
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkConfiguracaoExecucaoParamentroSemopengl)
                    .addComponent(TxtConfiguracaoExecucaoParamentroServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroTMWData, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtConfiguracaoExecucaoParamentroTMWData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChkConfiguracaoExecucaoParamentroSemopengl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(TxtConfiguracaoExecucaoComando, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtConfiguracaoExecucaoComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Execu��o", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Locais onde o TMW-Maker procurar� sobre:"));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Altera��es:");

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
        jLabel13.setText("Coment�rios:");

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
        jLabel14.setText("Tradu��es:");

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtConfiguracaoDocumentacaoAlteracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoDocumentacaoComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoDocumentacaoComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addComponent(TxtConfiguracaoDocumentacaoTraducoes, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtConfiguracaoDocumentacaoAlteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TxtConfiguracaoDocumentacaoComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TxtConfiguracaoDocumentacaoComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtConfiguracaoDocumentacaoTraducoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Documenta��o", jPanel4);

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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnConfiguracaoAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                        .addComponent(BtnConfiguracaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnConfiguracaoCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConfiguracaoOk)
                    .addComponent(BtnConfiguracaoCancelar)
                    .addComponent(BtnConfiguracaoAjuda))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfiguracaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoCancelarActionPerformed
       this.dispose();
       //System.exit(0);
    }//GEN-LAST:event_BtnConfiguracaoCancelarActionPerformed
    private void TxtConfiguracaoConexaoRepositorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoRepositorioKeyReleased
       FunMudaTesto();
       showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoConexaoRepositorioKeyReleased
    private void BtnConfiguracaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoOkActionPerformed
        try {
            //SalvarConfiguracao("config.xml");
            FrmPrincipal.Config.setConexaoRepositorio(TxtConfiguracaoConexaoRepositorio.getText());
            FrmPrincipal.Config.setConexaoLocalhost(TxtConfiguracaoConexaoLocalhost.getText());
            FrmPrincipal.Config.setConexaoUsuario(TxtConfiguracaoConexaoIdentificacaoUsuario.getText());
            FrmPrincipal.Config.setConexaoSenha(TxtConfiguracaoConexaoIdentificacaoSenha.getText());
            FrmPrincipal.Config.setExecucaoComando(TxtConfiguracaoExecucaoComando.getText());
            FrmPrincipal.Config.setExecucaoParametroTMWData(TxtConfiguracaoExecucaoParamentroTMWData.getText());
            FrmPrincipal.Config.setExecucaoParametroServidor(TxtConfiguracaoExecucaoParamentroServidor.getText());
            FrmPrincipal.Config.setExecucaoParametroConta(TxtConfiguracaoExecucaoParamentroConta.getText());
            FrmPrincipal.Config.setExecucaoParametroSenha(TxtConfiguracaoExecucaoParamentroSenha.getText());
            FrmPrincipal.Config.setExecucaoParametroPersonagem(TxtConfiguracaoExecucaoParamentroPersonagem.getText());
            FrmPrincipal.Config.setExecucaoParametroSemopengl(ChkConfiguracaoExecucaoParamentroSemopengl.isSelected());
            FrmPrincipal.Config.setDocumentacaoAlteracoes(TxtConfiguracaoDocumentacaoAlteracoes.getText());
            FrmPrincipal.Config.setDocumentacaoComponentes(TxtConfiguracaoDocumentacaoComponentes.getText());
            FrmPrincipal.Config.setDocumentacaoComentarios(TxtConfiguracaoDocumentacaoComentarios.getText());
            FrmPrincipal.Config.setDocumentacaoTraducoes(TxtConfiguracaoDocumentacaoTraducoes.getText());
            
            FrmPrincipal.Config.ConfiguracoesGravar();
            this.dispose();
        } catch (IOException ex) {
            //Logger.getLogger(FrmConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
            FrmPrincipal.Config.Mensagem_Erro("N�o foi poss�vel salvar as configura��es!", "ERRO");
        }
    }//GEN-LAST:event_BtnConfiguracaoOkActionPerformed
    private void BtnConfiguracaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoAjudaActionPerformed
        showAjuda();
    }//GEN-LAST:event_BtnConfiguracaoAjudaActionPerformed
    private void TxtConfiguracaoConexaoRepositorioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoRepositorioFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoRepositorio");
    }//GEN-LAST:event_TxtConfiguracaoConexaoRepositorioFocusGained
    private void TxtConfiguracaoConexaoLocalhostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoLocalhostFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoLocalhost");
    }//GEN-LAST:event_TxtConfiguracaoConexaoLocalhostFocusGained
    private void TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoIdentificacaoUsuario");
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained
    private void TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained
       setMarcarComponente("TxtConfiguracaoConexaoIdentificacaoSenha");
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoSenhaFocusGained
    private void TxtConfiguracaoExecucaoComandoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoComandoFocusGained
       setMarcarComponente("TxtConfiguracaoExecucaoComando");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoComandoFocusGained
    private void TxtConfiguracaoExecucaoParamentroTMWDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroTMWDataFocusGained
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroTMWData");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroTMWDataFocusGained
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
    private void TxtConfiguracaoExecucaoComandoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoComandoKeyReleased
        if(!TxtConfiguracaoExecucaoComando.getText().isEmpty()){
            boolean SeProcede=FrmPrincipal.Config.SeComandoProcede(TxtConfiguracaoExecucaoComando.getText()+" --help");
            if(SeProcede){
                TxtConfiguracaoExecucaoComando.setForeground(java.awt.SystemColor.textText);
                FrmPrincipal.LblEstatus.setText("Comando \""+TxtConfiguracaoExecucaoComando.getText()+"\" Ok!");
            }else{
                TxtConfiguracaoExecucaoComando.setForeground(Color.red);
                FrmPrincipal.LblEstatus.setText("Comando \""+TxtConfiguracaoExecucaoComando.getText()+"\" n�o procede!");
            }
        }else{
            FrmPrincipal.LblEstatus.setText("Digite o comando que abrir� o jogo The Mana World!");
        }
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoComandoKeyReleased
    private void TxtConfiguracaoExecucaoParamentroTMWDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroTMWDataKeyReleased
        showAjuda(evt);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroTMWDataKeyReleased
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImportarConfiguracao();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        FrmPrincipal.LblEstatus.setText("Janela de configura��es fechada!");
    }//GEN-LAST:event_formWindowDeactivated

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
    private javax.swing.JButton BtnConfiguracaoAjuda;
    private javax.swing.JButton BtnConfiguracaoCancelar;
    private javax.swing.JButton BtnConfiguracaoOk;
    private javax.swing.JCheckBox ChkConfiguracaoExecucaoParamentroSemopengl;
    private javax.swing.JPasswordField TxtConfiguracaoConexaoIdentificacaoSenha;
    private javax.swing.JTextField TxtConfiguracaoConexaoIdentificacaoUsuario;
    private javax.swing.JTextField TxtConfiguracaoConexaoLocalhost;
    private javax.swing.JTextField TxtConfiguracaoConexaoRepositorio;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoAlteracoes;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoComentarios;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoComponentes;
    private javax.swing.JTextField TxtConfiguracaoDocumentacaoTraducoes;
    private javax.swing.JTextField TxtConfiguracaoExecucaoComando;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroConta;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroPersonagem;
    private javax.swing.JPasswordField TxtConfiguracaoExecucaoParamentroSenha;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroServidor;
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroTMWData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
