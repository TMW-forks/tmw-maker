/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConfiguracao.java
 *
 * Created on Apr 9, 2010, 1:51:19 PM
 */

package Formularios;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import java.io.*;
import javax.swing.JOptionPane;
import org.w3c.dom.*;
/**
 *
 * @author indigovox
 */
public class FrmConfiguracao extends javax.swing.JDialog {

    /** Creates new form FrmConfiguracao */
    public FrmConfiguracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void setMarcarComponente(String Componente) {
       FrmPrincipal.ComponenteSelecionado = Componente.toString();
       if(FrmPrincipal.ComponenteSelecionado != "") {
         BtnConfiguracaoAjuda.setEnabled(true);
       } else {
         BtnConfiguracaoAjuda.setEnabled(false);
       }
    }

    public boolean SalvarConfiguracao(String filename) {
        try {
            //DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            //DocumentBuilder builder = fac.newDocumentBuilder();
            //Document doc = builder.newDocument();

            FrmPrincipal.ConexaoRepositorio = TxtConfiguracaoConexaoRepositorio.getText();
            FrmPrincipal.ConexaoLocalhost = TxtConfiguracaoConexaoLocalhost.getText();
            FrmPrincipal.ConexaoUsuario = TxtConfiguracaoConexaoIdentificacaoUsuario.getText();
            FrmPrincipal.ConexaoSenha = TxtConfiguracaoConexaoIdentificacaoSenha.getText();

            FrmPrincipal.ExecucaoComando = TxtConfiguracaoExecucaoComando.getText();
            FrmPrincipal.ExecucaoParametroTMWData = TxtConfiguracaoExecucaoParamentroTMWData.getText();
            FrmPrincipal.ExecucaoParametroServidor = TxtConfiguracaoExecucaoParamentroServidor.getText();
            FrmPrincipal.ExecucaoParametroConta = TxtConfiguracaoExecucaoParamentroConta.getText();
            FrmPrincipal.ExecucaoParametroSenha = TxtConfiguracaoExecucaoParamentroSenha.getText();
            FrmPrincipal.ExecucaoParametroPersonagem = TxtConfiguracaoExecucaoParamentroPersonagem.getText();
            FrmPrincipal.ExecucaoParametroSemopengl = TxtConfiguracaoExecucaoParamentroServidor.getText()=="true"?true:false;

            FrmPrincipal.DocumentacaoAlteracoes = TxtConfiguracaoDocumentacaoAlteracoes.getText();
            FrmPrincipal.DocumentacaoComentarios = TxtConfiguracaoDocumentacaoComentarios.getText();
            FrmPrincipal.DocumentacaoComponentes = TxtConfiguracaoDocumentacaoComponentes.getText();
            FrmPrincipal.DocumentacaoTraducoes = TxtConfiguracaoDocumentacaoTraducoes.getText();
            /**
             * <Propriedade>
             *    <TMWMaker Versao="0.2"/>
             *    <Conexao>
             *      <Repositorio Valor="http://themanaworld-br.googlecode.com/svn"/>
             *      <Localhost Valor="~/TMW/"/>
             *      <Usuario Valor="rui.gravata"/>
             *      <Senha Valor="********"/>
             *    </Conexao>
             *    <Execucao>
             *      <Comando Valor="tmw"/>
             *      <TMWData Valor="-ud /home/indigovox/tmwdata"/>
             *      <Servidor Valor="-S locahost"/>
             *      <Usuario Valor="-U [Login]"/>
             *      <Senha Valor="-P [Senha]"/>
             *      <Personagem Valor="-c [char]"/>
             *    </Execucao>
             * </Propriedade>
             */

            Document Documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Documento.setXmlVersion("1.0");

            Element Configuracao = Documento.createElement("Configuracao");
            Documento.appendChild(Configuracao);
            Element Propriedade;

            Propriedade = Documento.createElement("Conexao");
            Propriedade.setAttribute("Versao", FrmPrincipal.AppVersao);
            Propriedade.setAttribute("Repositorio", FrmPrincipal.ConexaoRepositorio);
            Propriedade.setAttribute("Localhost", FrmPrincipal.ConexaoLocalhost);
            Propriedade.setAttribute("Usuario", FrmPrincipal.ConexaoUsuario);
            Propriedade.setAttribute("Senha", FrmPrincipal.ConexaoSenha);
            Configuracao.appendChild(Propriedade);

            Propriedade = Documento.createElement("Execucao");
            Propriedade.setAttribute("Comando", FrmPrincipal.ExecucaoComando);
            Propriedade.setAttribute("TMWData", FrmPrincipal.ExecucaoParametroTMWData);
            Propriedade.setAttribute("Servidor", FrmPrincipal.ExecucaoParametroServidor);
            Propriedade.setAttribute("Conta", FrmPrincipal.ExecucaoParametroConta);
            Propriedade.setAttribute("Senha", FrmPrincipal.ExecucaoParametroSenha);
            Propriedade.setAttribute("Personagem", FrmPrincipal.ExecucaoParametroPersonagem);
            Propriedade.setAttribute("SemOpenGL", FrmPrincipal.ExecucaoParametroSemopengl?"true":"false");
            Configuracao.appendChild(Propriedade);

            Propriedade = Documento.createElement("Documentacao");
            Propriedade.setAttribute("Alteracoes", FrmPrincipal.DocumentacaoAlteracoes);
            Propriedade.setAttribute("Comentarios", FrmPrincipal.DocumentacaoComentarios);
            Propriedade.setAttribute("Componentes", FrmPrincipal.DocumentacaoComponentes);
            Propriedade.setAttribute("Traducoes", FrmPrincipal.DocumentacaoTraducoes);
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
            //JOptionPane.showMessageDialog(rootPane, "Não foi possivel salvar!");
            /*JOptionPane.showMessageDialog(
                null,
                "Não foi possivel salvar!",
                "Erro de Gravação",
                JOptionPane.ERROR_MESSAGE
            );/**/
            return false;
        }
        return true;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
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
        TxtConfiguracaoExecucaoParamentroSenha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtConfiguracaoExecucaoParamentroPersonagem = new javax.swing.JTextField();
        ChkConfiguracaoExecucaoParamentroSemopengl = new javax.swing.JCheckBox();
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
        setTitle("Configurações");
        setModal(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Repositório:");

        TxtConfiguracaoConexaoRepositorio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoRepositorioFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoRepositorio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoConexaoRepositorioPropertyChange(evt);
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
        TxtConfiguracaoConexaoLocalhost.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoConexaoLocalhostPropertyChange(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação"));
        jPanel3.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuário:");

        TxtConfiguracaoConexaoIdentificacaoUsuario.setEnabled(false);
        TxtConfiguracaoConexaoIdentificacaoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoUsuarioFocusGained(evt);
            }
        });
        TxtConfiguracaoConexaoIdentificacaoUsuario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoUsuarioPropertyChange(evt);
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
        TxtConfiguracaoConexaoIdentificacaoSenha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoConexaoIdentificacaoSenhaPropertyChange(evt);
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
        jLabel15.setText("<html><b>OBS.:</b> Inicie com \"https://\" para ativar campos \"Usuário\" e \"Senha\"");

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

        jTabbedPane1.addTab("Conexão", jPanel1);

        jLabel5.setText("Comando de ativação:");

        TxtConfiguracaoExecucaoComando.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoComandoFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoComando.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoComandoPropertyChange(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros"));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("tmwdata:");

        TxtConfiguracaoExecucaoParamentroTMWData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroTMWDataFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroTMWData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoParamentroTMWDataPropertyChange(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Servidor:");

        TxtConfiguracaoExecucaoParamentroServidor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroServidorFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroServidor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoParamentroServidorPropertyChange(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Conta:");

        TxtConfiguracaoExecucaoParamentroConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroContaFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroConta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoParamentroContaPropertyChange(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Senha:");

        TxtConfiguracaoExecucaoParamentroSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroSenhaFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroSenha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoParamentroSenhaPropertyChange(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Personagem:");

        TxtConfiguracaoExecucaoParamentroPersonagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoExecucaoParamentroPersonagemFocusGained(evt);
            }
        });
        TxtConfiguracaoExecucaoParamentroPersonagem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoExecucaoParamentroPersonagemPropertyChange(evt);
            }
        });

        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(true);
        ChkConfiguracaoExecucaoParamentroSemopengl.setText("Sem OpenGL (Recomendado)");
        ChkConfiguracaoExecucaoParamentroSemopengl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ChkConfiguracaoExecucaoParamentroSemopenglFocusGained(evt);
            }
        });
        ChkConfiguracaoExecucaoParamentroSemopengl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ChkConfiguracaoExecucaoParamentroSemopenglPropertyChange(evt);
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
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtConfiguracaoExecucaoParamentroPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(TxtConfiguracaoExecucaoParamentroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
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

        jTabbedPane1.addTab("Execução", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Locais onde o TMW-Maker procurará sobre:"));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Alterações:");

        TxtConfiguracaoDocumentacaoAlteracoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoAlteracoesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoAlteracoes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoDocumentacaoAlteracoesPropertyChange(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Componentes:");

        TxtConfiguracaoDocumentacaoComponentes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoComponentesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoComponentes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoDocumentacaoComponentesPropertyChange(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Comentários:");

        TxtConfiguracaoDocumentacaoComentarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoComentariosFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoComentarios.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoDocumentacaoComentariosPropertyChange(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Traduções:");

        TxtConfiguracaoDocumentacaoTraducoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtConfiguracaoDocumentacaoTraducoesFocusGained(evt);
            }
        });
        TxtConfiguracaoDocumentacaoTraducoes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TxtConfiguracaoDocumentacaoTraducoesPropertyChange(evt);
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

        jTabbedPane1.addTab("Documentação", jPanel4);

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
        BtnConfiguracaoAjuda.setText("Ajuda");
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
                        .addComponent(BtnConfiguracaoAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
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
       // TODO add your handling code here:
       this.dispose();
       //System.exit(0);
    }//GEN-LAST:event_BtnConfiguracaoCancelarActionPerformed

    private void TxtConfiguracaoConexaoRepositorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoRepositorioKeyReleased
       // TODO add your handling code here:
       FunMudaTesto();
    }//GEN-LAST:event_TxtConfiguracaoConexaoRepositorioKeyReleased
    private void TxtConfiguracaoConexaoRepositorioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoRepositorioPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoConexaoRepositorio.setText(FrmPrincipal.ConexaoRepositorio);
        FunMudaTesto();
        setMarcarComponente("");
    }//GEN-LAST:event_TxtConfiguracaoConexaoRepositorioPropertyChange

    private void BtnConfiguracaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoOkActionPerformed
       // TODO add your handling code here:
        SalvarConfiguracao("config.xml");
        this.dispose();
    }//GEN-LAST:event_BtnConfiguracaoOkActionPerformed

    private void BtnConfiguracaoAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracaoAjudaActionPerformed
        FrmPrincipal.AbrirNavegador("http://code.google.com/p/tmw-maker/wiki/" + FrmPrincipal.ComponenteSelecionado.trim());
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
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoComando");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoComandoFocusGained
    private void TxtConfiguracaoExecucaoParamentroTMWDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroTMWDataFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroTMWData");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroTMWDataFocusGained
    private void TxtConfiguracaoExecucaoParamentroServidorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroServidorFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroServidor");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroServidorFocusGained
    private void TxtConfiguracaoExecucaoParamentroContaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroContaFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroConta");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroContaFocusGained
    private void TxtConfiguracaoExecucaoParamentroSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroSenhaFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroSenha");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroSenhaFocusGained
    private void TxtConfiguracaoExecucaoParamentroPersonagemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroPersonagemFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoExecucaoParamentroPersonagem");
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroPersonagemFocusGained
    private void ChkConfiguracaoExecucaoParamentroSemopenglFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglFocusGained
       // TODO add your handling code here:
       setMarcarComponente("ChkConfiguracaoExecucaoParamentroSemopengl");
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglFocusGained
    private void TxtConfiguracaoDocumentacaoAlteracoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoAlteracoesFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoDocumentacaoAlteracoes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoAlteracoesFocusGained
    private void TxtConfiguracaoDocumentacaoComponentesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComponentesFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoDocumentacaoComponentes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComponentesFocusGained
    private void TxtConfiguracaoDocumentacaoComentariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComentariosFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoDocumentacaoComentarios");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComentariosFocusGained
    private void TxtConfiguracaoDocumentacaoTraducoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoTraducoesFocusGained
       // TODO add your handling code here:
       setMarcarComponente("TxtConfiguracaoDocumentacaoTraducoes");
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoTraducoesFocusGained
    private void TxtConfiguracaoConexaoLocalhostPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoLocalhostPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoConexaoLocalhost.setText(FrmPrincipal.ConexaoLocalhost);
    }//GEN-LAST:event_TxtConfiguracaoConexaoLocalhostPropertyChange
    private void TxtConfiguracaoConexaoIdentificacaoUsuarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoConexaoIdentificacaoUsuario.setText(FrmPrincipal.ConexaoUsuario);
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoUsuarioPropertyChange
    private void TxtConfiguracaoConexaoIdentificacaoSenhaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoConexaoIdentificacaoSenhaPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoConexaoIdentificacaoSenha.setText(FrmPrincipal.ConexaoSenha);
    }//GEN-LAST:event_TxtConfiguracaoConexaoIdentificacaoSenhaPropertyChange
    private void TxtConfiguracaoExecucaoComandoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoComandoPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoComando.setText(FrmPrincipal.ExecucaoComando);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoComandoPropertyChange
    private void TxtConfiguracaoExecucaoParamentroTMWDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroTMWDataPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoParamentroTMWData.setText(FrmPrincipal.ExecucaoParametroTMWData);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroTMWDataPropertyChange
    private void TxtConfiguracaoExecucaoParamentroServidorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroServidorPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoParamentroServidor.setText(FrmPrincipal.ExecucaoParametroServidor);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroServidorPropertyChange

    private void TxtConfiguracaoExecucaoParamentroContaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroContaPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoParamentroConta.setText(FrmPrincipal.ExecucaoParametroConta);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroContaPropertyChange

    private void TxtConfiguracaoExecucaoParamentroSenhaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroSenhaPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoParamentroSenha.setText(FrmPrincipal.ExecucaoParametroSenha);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroSenhaPropertyChange

    private void TxtConfiguracaoExecucaoParamentroPersonagemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoExecucaoParamentroPersonagemPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoExecucaoParamentroPersonagem.setText(FrmPrincipal.ExecucaoParametroPersonagem);
    }//GEN-LAST:event_TxtConfiguracaoExecucaoParamentroPersonagemPropertyChange

    private void ChkConfiguracaoExecucaoParamentroSemopenglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ChkConfiguracaoExecucaoParamentroSemopenglPropertyChange
        // TODO add your handling code here:
        ChkConfiguracaoExecucaoParamentroSemopengl.setSelected(FrmPrincipal.ExecucaoParametroSemopengl);
    }//GEN-LAST:event_ChkConfiguracaoExecucaoParamentroSemopenglPropertyChange

    private void TxtConfiguracaoDocumentacaoAlteracoesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoAlteracoesPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoDocumentacaoAlteracoes.setText(FrmPrincipal.DocumentacaoAlteracoes);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoAlteracoesPropertyChange

    private void TxtConfiguracaoDocumentacaoComponentesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComponentesPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoDocumentacaoComponentes.setText(FrmPrincipal.DocumentacaoComponentes);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComponentesPropertyChange

    private void TxtConfiguracaoDocumentacaoComentariosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoComentariosPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoDocumentacaoComentarios.setText(FrmPrincipal.DocumentacaoComentarios);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoComentariosPropertyChange

    private void TxtConfiguracaoDocumentacaoTraducoesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TxtConfiguracaoDocumentacaoTraducoesPropertyChange
        // TODO add your handling code here:
        TxtConfiguracaoDocumentacaoTraducoes.setText(FrmPrincipal.DocumentacaoTraducoes);
    }//GEN-LAST:event_TxtConfiguracaoDocumentacaoTraducoesPropertyChange

    private void FunMudaTesto() {
       // TODO add your handling code here:
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


    /**
    * @param args the command line arguments
    */
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
    private javax.swing.JTextField TxtConfiguracaoExecucaoParamentroSenha;
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
