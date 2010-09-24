package Formularios;




import Classes.FileClass;
import Classes.BancoDeDados.Banco_NPCs;
import Classes.ConfigClass;
import Classes.BancoDeDados.Banco_Itens;
import Classes.BancoDeDados.Banco_Mapas;
import Classes.ImagemClass;
import Classes.DialogClass;
import Classes.StringClass;
import Classes.BancoDeDados.XMLdeEquip;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
    }
    static String ComponenteSelecionado = "";
    public static ConfigClass Config = new ConfigClass();
    static String barra = System.getProperty("file.separator");
    static Banco_Itens Itens; // será instaciado em WindowOpened(java.awt.event.WindowEvent evt) por precisar de uma barra de contagem
    static Banco_NPCs NPCs; // será instaciado em WindowOpened(java.awt.event.WindowEvent evt) por precisar de uma barra de contagem
    static Banco_Mapas Mundo; // será instaciado em WindowOpened(java.awt.event.WindowEvent evt) por precisar de uma barra de contagem
    //public static String SpritePNG=""; // É esado em FrmEquipXML***
    static XMLdeEquip xmlEditada; // É usado em FrmEquipXML***

    public static void setAvisoEmEstatus(String Aviso) {
        setAvisoEmEstatus(Aviso.toString(), null);
    }
    public static void setAvisoEmEstatus(String Aviso, Icon Icone) {
        System.out.println(Aviso.toString());
        LblEstatus.setText(Aviso.toString());
        LblEstatus.setIcon(Icone);
    }

    public void Atualizar(){
        Thread tThread = new Thread(new Runnable() {
            public void run() {
                boolean SeConclui=false;
                Runtime Executador = Runtime.getRuntime();
                String line="", Partes[];
                String Comando ="",Link="",Simbolo="";
                int Arquivos=0;

                FrmPrincipal.PgbBarra.setEnabled(true);
                MnuSistema.setEnabled(false);
                MnuEditar.setEnabled(false);
                MnuJogo.setEnabled(false);
                MnuAjuda.setEnabled(false);
                VerificarBarraDeFerramentas();

                FrmPrincipal.PgbBarra.setIndeterminate(true);
                FrmPrincipal.PgbBarra.setString("Baixando...");
                FrmPrincipal.setAvisoEmEstatus("Baixando atualização...");
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                String Destino=FrmPrincipal.Config.getConexaoLocalhost()+barra+"tmw-maker";
                Comando ="svn checkout http://tmw-maker.googlecode.com/svn/tags/TMW-Maker "+Destino;

                try {
                    Process Retorno=Executador.exec(Comando);
                    BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                    while ((line = in.readLine()) != null) {
                        Arquivos++;
                        System.out.println(Arquivos+"º "+line);
                        FrmPrincipal.setAvisoEmEstatus("<html>"+Arquivos+"º: "+line);
                        FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                    }
                } catch (IOException e) {
                    FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">Falha ao receber a atualização!");
                    FrmPrincipal.PgbBarra.setString("ERRO!");
                    return;
                }/**/

                if(Arquivos>=2){
                    //ln -t /home/indigovox/Desktop -s /home/indigovox/localhost/tmw-maker/TMW-Maker_0.2.jar
                    Link=Config.getConexaoLocalhost()+barra+ "tmw-maker"+barra+ "TMW-Maker.jar";
                    Simbolo=System.getProperty("user.home")+barra+"Desktop";
                    if(FileClass.seExiste(Simbolo)) FileClass.apagar(Simbolo+barra+"TMW-Maker.jar");
                    PgbBarra.setString("Coligando...");
                    setAvisoEmEstatus("Criando link \""+Link+"\"...");
                    Comando="ln -t "+Simbolo+" -s "+Link;
                    System.out.println(Comando);
                    try {
                        Process Retorno = Executador.exec(Comando);
                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                        DialogClass.showErro(
                            "<html><b>O TMW-Maker não conseguiu criar link:</b><br/><br/>" +
                            "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                            "</html>",
                            "ERRO DE EXECUÇÃO"
                        );
                        return;
                    }
                    FrmPrincipal.setAvisoEmEstatus("<html>Atualização do recebida com sucesso! (<font color=\"#0000FF\"><b>Favor reiniciar pelo link em Área de Trabalho</b></font>)");
                    VisualizarNovidades();
                }else{
                    FrmPrincipal.setAvisoEmEstatus("<html>Este \"<font color=\"#0000FF\"><b>TMW-Maker</b></font>\" já é a versão mais atualizada!");
                }
                FrmPrincipal.Config.setAtualizacaoEngineUltimaAgora();
                FrmPrincipal.Config.ConfiguracoesGravar();
                FrmPrincipal.PgbBarra.setString("Concluido!");


                FrmPrincipal.PgbBarra.setIndeterminate(false);

                MnuSistema.setEnabled(true);
                MnuEditar.setEnabled(true);
                MnuJogo.setEnabled(true);
                MnuAjuda.setEnabled(true);
                VerificarBarraDeFerramentas();

                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        tThread.start();
    }
    public void VisualizarNovidades(){
        javax.swing.JDialog FrmNovidade = new FrmNovidade(this, rootPaneCheckingEnabled);
        FrmNovidade.setLocation(
                ((this.getWidth() - FrmNovidade.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmNovidade.getHeight()) / 2) + this.getY());
        FrmNovidade.pack();
        FrmNovidade.setModal(true);
        FrmNovidade.setVisible(true);/**/
    }
    public void MostrarDePendencias() {
        javax.swing.JDialog FrmDependencias = new FrmDependencias(this, rootPaneCheckingEnabled);
        FrmDependencias.setLocation(
                ((this.getWidth() - FrmDependencias.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmDependencias.getHeight()) / 2) + this.getY());
        FrmDependencias.pack();
        FrmDependencias.setModal(true);
        FrmDependencias.setVisible(true);/**/
    }
    public void MostrarDeSplash() {
        javax.swing.JDialog FrmSplash = new FrmSplash(this, rootPaneCheckingEnabled);
        FrmSplash.setLocation(
                ((this.getWidth() - FrmSplash.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmSplash.getHeight()) / 2) + this.getY());
        FrmSplash.pack();
        FrmSplash.setModal(true);
        try{
            FrmSplash.setVisible(true);/**/
        }catch(Exception E){
            
        }
    }
    public void LocalhostMontar() {
        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
            DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
            DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
            int R = JOptionPane.YES_OPTION;
            if(Config.getSeDependenciaDeGCC()){
                if (FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "char-server") ||
                        FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "login-server") ||
                        FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "map-server")) {
                    Object[] options = {"Remontar", "Cancelar"};
                    R = JOptionPane.showOptionDialog(
                            null, "<html>" +
                            "O seu localhost já está montado. Ao remontar você<br/>" +
                            "<font color=\"#FF0000\">pederá todas as contas</font> de jogadores deste localhost.<br/>" +
                            "Deseja realmente forçar uma remontagem?",
                            "REMONTAGEM DE LOCALHOST",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[1]);
                }
                if (R == JOptionPane.YES_OPTION) {
                    Thread tThread = new Thread(new Runnable() {
                        public void run() {
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            MnuSistema.setEnabled(false);
                            MnuEditar.setEnabled(false);
                            MnuJogo.setEnabled(false);
                            MnuAjuda.setEnabled(false);
                            PgbBarra.setEnabled(true);
                            PgbBarra.setValue(0);
                            VerificarBarraDeFerramentas();


                            Runtime Executador = Runtime.getRuntime();
                            String line = "", Comando = "";
                            String OS = System.getProperty("os.name").toLowerCase();
                            String Arch = System.getProperty("os.arch").toLowerCase();
                            boolean BinariosEspecificos = false;
                            int Baixados = 0;

                            PgbBarra.setIndeterminate(true);
                            PgbBarra.setString("Apagando...");
                            setAvisoEmEstatus("Apagando binários...");
                            if (FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "bins")) {
                                FileClass.apagar(Config.getConexaoLocalhost() +barra+ "bins");
                            }
                            FileClass.apagar(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "char-server");
                            FileClass.apagar(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "login-server");
                            FileClass.apagar(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "map-server");

                            PgbBarra.setString("Preparando...");
                            setAvisoEmEstatus("Preparando para baixar binários novos...");
                            if (OS.indexOf("linux") >= 0 && Arch.indexOf("i386") >= 0) {
                                Comando = "svn checkout " +
                                        "http://tmw-maker.googlecode.com/svn/bins/" + OS + "/" + Arch + " " +
                                        FrmPrincipal.Config.getConexaoLocalhost() +barra+ "bins";
                                BinariosEspecificos = true;
                                System.out.println(Comando);
                                //DialogClass.showAlerta(Comando,"Nota de Programador");
                            } else {
                                Comando = "svn checkout " +
                                        "http://tmw-maker.googlecode.com/svn/bins/compiler " +
                                        FrmPrincipal.Config.getConexaoLocalhost() +barra+ "bins";
                                BinariosEspecificos = false;
                                System.out.println(Comando);
                                //DialogClass.showAlerta(Comando,"Nota de Programador");
                            }
                            try {
                                Process Retorno = Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    System.out.println(line);
                                    Baixados++;
                                    setAvisoEmEstatus("<html>" + line + " (<font color=\"#FF0000\">Espere concluir...</font>)");
                                    PgbBarra.setString("Baixando nº" + Baixados + "...");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                DialogClass.showErro(
                                    "<html><b>O TMW-Maker não conseguiu baixar os binários:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                            }
                            if (BinariosEspecificos == true) {
                                PgbBarra.setString("Deslocando...");
                                if (!FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "char-server")) {
                                    FileClass.arquivoMover(
                                            Config.getConexaoLocalhost() +barra+ "bins" +barra+ "char-server",
                                            Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "char-server");
                                    setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                }
                                if (!FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "login-server")) {
                                    FileClass.arquivoMover(
                                            Config.getConexaoLocalhost() +barra+ "bins" +barra+ "login-server",
                                            Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "login-server");
                                    setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                }
                                if (!FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "map-server")) {
                                    FileClass.arquivoMover(
                                            Config.getConexaoLocalhost() +barra+ "bins" +barra+ "map-server",
                                            Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "map-server");
                                    setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">map-server</font>...");
                                }
                            } else {
                                //Desconpactar para usar
                            }

                            /*
                            mv -uv conf/atcommand_local.conf.example conf/atcommand_local.conf
                            mv -uv conf/battle_local.conf.example conf/battle_local.conf
                            mv -uv conf/char_local.conf.example conf/char_local.conf
                            mv -uv conf/eathena-monitor.conf.example conf/eathena-monitor.conf
                            mv -uv conf/gm_account.txt.example conf/gm_account.txt
                            mv -uv conf/help.txt.example conf/help.txt
                            mv -uv conf/ladmin_local.conf.example conf/ladmin_local.conf
                            mv -uv conf/login_local.conf.example conf/login_local.conf
                            mv -uv conf/map_local.conf.example conf/map_local.conf
                            mv -uv conf/motd.txt.example conf/motd.txt
                            mv -uv save/account.txt.example save/account.txt
                            /**/

                            setAvisoEmEstatus("Renomeando banco de dados...");
                            PgbBarra.setString("Renomeando...");
                            String Pasta[] = new String[]{
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "conf",
                                Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "save"
                            };
                            String De[] = new String[]{
                                "atcommand_local.conf.example",
                                "battle_local.conf.example",
                                "char_local.conf.example",
                                "eathena-monitor.conf.example",
                                "gm_account.txt.example",
                                "help.txt.example",
                                "ladmin_local.conf.example",
                                "login_local.conf.example",
                                "map_local.conf.example",
                                "motd.txt.example",
                                "account.txt.example"
                            };
                            String Para[] = new String[]{
                                "atcommand_local.conf",
                                "battle_local.conf",
                                "char_local.conf",
                                "eathena-monitor.conf",
                                "gm_account.txt",
                                "help.txt",
                                "ladmin_local.conf",
                                "login_local.conf",
                                "map_local.conf",
                                "motd.txt",
                                "account.txt"
                            };

                            for (int r = 0; r < De.length; r++) {
                                if (FileClass.seExiste(Pasta[r] +barra+ De[r])) {
                                    if (FileClass.seExiste(Pasta[r] +barra+ Para[r])) {
                                        FileClass.apagar(Pasta[r] +barra+ Para[r]);
                                        setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + Para[r] + "\"!");
                                    }
                                    setAvisoEmEstatus("<html><b>Renomeando:</b> \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                    FileClass.arquivoMover(Pasta[r] +barra+ De[r], Pasta[r] +barra+ Para[r]);
                                }
                            }

                            if(!FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "log")) {
                                setAvisoEmEstatus("<html><b>Criando Pasta:</b> \"" + Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "log\"...");
                                FileClass.pastaCriar(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "log");
                            }

                            /*
                            Criar pasta de ~/localhost/eathena-data/log
                            gcc -o eathena-monitor eathena-monitor.c
                            /**/
                            if(!FileClass.seExiste(Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "eathena-monitor")) {
                                PgbBarra.setString("Copilando...");
                                setAvisoEmEstatus("Copilando binário \"eathena-monitor\"...");
                                Comando="gcc -o "+
                                    Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "eathena-monitor "+
                                    Config.getConexaoLocalhost() +barra+ "eathena-data" +barra+ "eathena-monitor.c";
                                System.out.println(Comando);
                                try {
                                    Process Retorno = Executador.exec(Comando);
                                    BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                    while ((line = in.readLine()) != null) {
                                        System.out.println(line);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                    setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                    DialogClass.showErro(
                                        "<html><b>O TMW-Maker não conseguiu copilar o binário de monitor:</b><br/><br/>" +
                                        "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                        "</html>",
                                        "ERRO DE EXECUÇÃO"
                                    );
                                }
                            }

                            /*
                            rm $HOME/tmwserver // Apaga Link
                            ln -s $PWD $HOME/tmwserver //Recria Link
                            /**/
                            if(FileClass.seExiste(System.getProperty("user.home")+barra+"tmwserver")) {
                                FileClass.apagar(System.getProperty("user.home")+barra+"tmwserver");
                            }
                            PgbBarra.setString("Coligando...");
                            setAvisoEmEstatus("Criando link \""+System.getProperty("user.home")+barra+"tmwserver\"...");
                            Comando="ln -s "+
                                Config.getConexaoLocalhost()+barra+ "eathena-data"+" "+
                                System.getProperty("user.home")+barra+"tmwserver";
                            System.out.println(Comando);
                            try {
                                Process Retorno = Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                                setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                                DialogClass.showErro(
                                    "<html><b>O TMW-Maker não conseguiu criar link:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                            }

                            setAvisoEmEstatus("<html><font color=\"#0000FF\">Locahost montado com sucesso!");
                            PgbBarra.setString("Concluido!");

                            PgbBarra.setIndeterminate(false);
                            MnuSistema.setEnabled(true);
                            MnuEditar.setEnabled(true);
                            MnuJogo.setEnabled(true);
                            MnuAjuda.setEnabled(true);
                            VerificarBarraDeFerramentas();
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        }
                    });
                    tThread.start();
                } else {
                    setAvisoEmEstatus("Remontagem cancelada!");
                    PgbBarra.setString("");
                }
            }else{
                setAvisoEmEstatus("<html><font color=\"#0000FF\">CANCELADO:</font> Existe uma dependencia de GCC para você resolver!");
                DialogClass.showErro("<html>"+
                    "Esta função possui a <font face=\"monospace\" color=\"#FF0000\">dependencia</font> do comando GCC!",
                    "ERRO DE EXECUÇÃO"
                );
            }
        }
    }
    public void LocalhostReceber() {
        //int R = JOptionPane.NO_OPTION;
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            DialogClass.showErro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            DialogClass.showErro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    boolean SeConclui=false;
                    Runtime Executador = Runtime.getRuntime();
                    String line="", Partes[];
                    String Comando ="";
                    int Arquivos=0;
                    int R = JOptionPane.YES_OPTION;

                    FrmPrincipal.PgbBarra.setEnabled(true);
                    MnuSistema.setEnabled(false);
                    MnuEditar.setEnabled(false);
                    MnuJogo.setEnabled(false);
                    MnuAjuda.setEnabled(false);
                    VerificarBarraDeFerramentas();

                    FrmPrincipal.PgbBarra.setIndeterminate(true);
                    FrmPrincipal.PgbBarra.setString("Preparando...");
                    //TxtEstatus.setText("Preparando para baixar...");
                    FrmPrincipal.setAvisoEmEstatus("Preparando para baixar...");
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    // operacao demorada

                    Comando ="svn checkout "+FrmPrincipal.Config.getConexaoRepositorio()+" "+FrmPrincipal.Config.getConexaoLocalhost();

                    Partes = FrmPrincipal.Config.getConexaoRepositorio().split(":");
                    if(Partes.length>1 && Partes[0].toLowerCase().equals("https") && !FrmPrincipal.Config.getConexaoUsuario().equals("") && !FrmPrincipal.Config.getConexaoSenha().equals("")){
                        Comando+=" --username "+FrmPrincipal.Config.getConexaoUsuario()+" --password "+FrmPrincipal.Config.getConexaoSenha();
                    }

                    try {
                        Process Retorno=Executador.exec(Comando);
                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            line=line.replaceAll(FrmPrincipal.Config.getConexaoLocalhost()+barra, "");
                            System.out.println(line);
                            FrmPrincipal.setAvisoEmEstatus("<html>BAIXANDO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                            Arquivos++;
                            FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                        }
                        FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" recebido com sucesso!");
                        FrmPrincipal.PgbBarra.setString("Concluido!");
                        FrmPrincipal.Config.setAtualizacaoLocalhostUltimaAgora();
                        FrmPrincipal.Config.ConfiguracoesGravar();

                    } catch (IOException e) {
                        //DialogClass.showAlerta("<html><font color=\"#FF0000\">Falha ao receber o repositório \""+FrmPrincipal.Config.getConexaoUsuario()+"\"!", "ERRO");
                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">Falha ao receber o repositório \"<b>"+FrmPrincipal.Config.getConexaoUsuario()+"</b>\"!");
                        FrmPrincipal.PgbBarra.setString("ERRO!");
                    }/**/
                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                    MnuSistema.setEnabled(true);
                    MnuEditar.setEnabled(true);
                    MnuJogo.setEnabled(true);
                    MnuAjuda.setEnabled(true);
                    VerificarBarraDeFerramentas();
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                    MostrarDeSplash();
                }
            });
            tThread.start();
        }
    }
    public void LocalhostCompartilhar() {
        String SistemaOperacional = System.getProperty("os.name").toLowerCase();
        if (SistemaOperacional.indexOf("win") >= 0) {
            DialogClass.showErro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (SistemaOperacional.indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            DialogClass.showErro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    boolean SeConclui=false;
                    Runtime Executador = Runtime.getRuntime();
                    String line="", Partes[];
                    String Comando ="";
                    //String[] Comando = new String[2];
                    int Arquivos=0;
                    int R = JOptionPane.YES_OPTION;
                    FrmPrincipal.PgbBarra.setEnabled(true);
                    MnuSistema.setEnabled(false);
                    MnuEditar.setEnabled(false);
                    MnuJogo.setEnabled(false);
                    MnuAjuda.setEnabled(false);
                    VerificarBarraDeFerramentas();

                    Partes = FrmPrincipal.Config.getConexaoRepositorio().split(":");
                    if(Partes.length>1 && Partes[0].toLowerCase().equals("https") && !FrmPrincipal.Config.getConexaoUsuario().equals("") && !FrmPrincipal.Config.getConexaoSenha().equals("")){
                        Object[] options = {"Sim, Compartilhar!", "Não, Cancelar!"};
                        R = DialogClass.showOpcoes("<html>" +
                            "Se enviar algum <font color=\"#FF0000\">Script com Defeito</font> de seu Localhost para o Repositório, você <br/>" +
                            "poderá danificar o repositório, prejudicando trabalho de outros colaboradores.<br/>" +
                            "Tem certeza que seu localhost está funcionando corretamente?",
                            "COMPARTILHAMENTO DE LOCALHOST",
                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmw-96x96px.png")),
                            options, 1
                        );
                        if (R == JOptionPane.YES_OPTION) {
                            FrmPrincipal.PgbBarra.setIndeterminate(true);
                            FrmPrincipal.PgbBarra.setString("Preparando...");
                            FrmPrincipal.setAvisoEmEstatus("Preparando para compartilhar...");
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            // operacao demorada


                            try {
                                Comando=
                                    "svn commit "+FrmPrincipal.Config.getConexaoLocalhost()+" --message " +
                                    "Autosincronizar_TMW-Maker_"+FrmPrincipal.Config.getVersao()+"_" +
                                    "("+FrmPrincipal.Config.getOS()+"-"+FrmPrincipal.Config.getArquiteturaOS()+")...";/**/

                                Process Retorno=Executador.exec(Comando);
                                BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                                while ((line = in.readLine()) != null) {
                                    line=line.replaceAll(FrmPrincipal.Config.getConexaoLocalhost()+barra, "");
                                    System.out.println(line);
                                    FrmPrincipal.setAvisoEmEstatus("<html>ENVIADO: "+line+" (<font color=\"#FF0000\"><b>Espere concluir...</b></font>)");
                                    Arquivos++;
                                    FrmPrincipal.PgbBarra.setString("nº"+Arquivos);
                                }
                                if(Arquivos>=2){
                                    FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" compartilhado com sucesso!");
                                    FrmPrincipal.PgbBarra.setString("Concluido!");
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html>Repositório \"<font color=\"#0000FF\"><b>"+FrmPrincipal.Config.getConexaoLocalhost()+"</b></font>\" já está compartilhado!");
                                    FrmPrincipal.PgbBarra.setString("Concluido!");
                                }
                            } catch (IOException e) {
                                FrmPrincipal.setAvisoEmEstatus("Falha ao compartilhar o localhost \""+FrmPrincipal.Config.getConexaoLocalhost()+"\"!");
                                DialogClass.showErro("<html>" +
                                    "Falha ao compartilhar o localhost:<br/> " +
                                    "<font color=\"#FF0000\"> <b>"+Comando+"</b>!"
                                    , "ERRO"
                                );
                                FrmPrincipal.PgbBarra.setString("ERRO!");
                            }
                        }else{
                            FrmPrincipal.setAvisoEmEstatus("Compartilhamento concelado pelo usuário...!");
                            FrmPrincipal.PgbBarra.setString("Cancelado!");
                        }
                    }else{
                        FrmPrincipal.setAvisoEmEstatus("<html><font color=\"#FF0000\">PARADA CRÍTICA:</font> Você não identificação \"HTTPS\" em suas configurações!!");
                        FrmPrincipal.PgbBarra.setString("PARADA CRÍTICA");
                        DialogClass.showAlerta("<html>" +
                            "Você não tem permissão para compartilhar arquivos pelo TMW-Maker.<br/><br/>"+
                            "Para compatilhar configure a Conexão do Repositório como \"<font color=\"#0000FF\">HTTP<b><u>S</u></b></font>\" e <br/>" +
                            "preencha o \"<font color=\"#0000FF\">Usuário</font>\" e a \"<font color=\"#0000FF\">Senha</font>\" do repositório corretamente!"
                            , "COMPARTILHAMENTO NEGADO",
                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmw-96x96px.png"))
                        );
                    }
                    FrmPrincipal.PgbBarra.setIndeterminate(false);
                    MnuSistema.setEnabled(true);
                    MnuEditar.setEnabled(true);
                    MnuJogo.setEnabled(true);
                    MnuAjuda.setEnabled(true);
                    VerificarBarraDeFerramentas();
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            tThread.start();
        }
    }
    public void LocalhostCopilar(){
        Thread tThread = new Thread(new Runnable() {
            public void run() {
                //DialogClass.showAlerta("Esse comando ainda não foi implementado!", "Copilador", null);
                String baseScripts=FrmPrincipal.Config.getConexaoLocalhost()+barra+"eathena-data"+barra+"npc";
                String baseMapas=FrmPrincipal.Config.getConexaoLocalhost()+barra+"tmwdata"+barra+"maps";

                FrmPrincipal.PgbBarra.setIndeterminate(false);
                FrmPrincipal.PgbBarra.setEnabled(true);
                FrmPrincipal.PgbBarra.setMinimum(0);
                MnuSistema.setEnabled(false);
                MnuEditar.setEnabled(false);
                MnuJogo.setEnabled(false);
                MnuAjuda.setEnabled(false);
                VerificarBarraDeFerramentas();

                FrmPrincipal.setAvisoEmEstatus(
                    "Preparando para copilar...",
                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
                );
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                    String pasta[] = FileClass.listarPasta(baseScripts);
                    String arquivo[] = null;
                    String importador="", warps="", mobs="", mapaNome="", mapaTMX="";
                    StringClass importacao = new StringClass();
                    StringClass mapaConteudo = new StringClass();
                    StringClass warpConteudo = new StringClass();
                    StringClass mobConteudo = new StringClass();
                    FrmPrincipal.PgbBarra.setMaximum(pasta.length);
                    for(int p=0; p<pasta.length; p++){
                        FrmPrincipal.PgbBarra.setValue(p);
                        FrmPrincipal.PgbBarra.setString((((p+1)*100)/pasta.length)+"%");
                        if(
                            !pasta[p].equals(".svn") &&
                            !pasta[p].equals("functions")
                        ){
                            importador=baseScripts+barra+pasta[p]+barra+"_import.txt";
                            warps=baseScripts+barra+pasta[p]+barra+"_warps.txt";
                            mobs=baseScripts+barra+pasta[p]+barra+"_mobs.txt";
                            if(FileClass.seExiste(importador)){
                                if(FileClass.seExiste(warps)){
                                    if(FileClass.seExiste(mobs)){
                                        importacao.setTesto("\n"+FileClass.arquivoAbrir(importador));// esse \n tem que ser add pq a linha q tem "map:" pode está comentada!
                                        mapaNome=importacao.extrairEntre("\nmap: ", ".gat").trim();
                                        if(!mapaNome.equals("")){
                                            mapaTMX=baseMapas+barra+mapaNome+".tmx";
                                            if(FileClass.seExiste(mapaTMX)){
//////////////////////////////////////////////////////// PARA COLPILAR ////////////////////////////////////////////////////////////
                                                FrmPrincipal.setAvisoEmEstatus("<html>"+
                                                    "Copilando: <font color=\"#0000FF\">"+mapaNome+".tmx</font>",
                                                    MnuJogoCopilar.getIcon()
                                                );
                                                mapaConteudo.setTesto(FileClass.arquivoAbrir(mapaTMX));
                                                warpConteudo.setTesto(FileClass.arquivoAbrir(warps));
                                                mobConteudo.setTesto(FileClass.arquivoAbrir(mobs));


























//////////////////////////////////////////////////////// PARA COLPILAR ////////////////////////////////////////////////////////////

                                            }else{
                                                FrmPrincipal.setAvisoEmEstatus("<html>"+
                                                    "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar o mapa\"<font color=\"#FF0000\">"+mapaNome+".tmx</font>\"!",
                                                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                                                );
                                                DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+mapaNome+".tmx</font>\"!", "Copilador");
                                                MnuSistema.setEnabled(true);
                                                MnuEditar.setEnabled(true);
                                                MnuJogo.setEnabled(true);
                                                MnuAjuda.setEnabled(true);
                                                FrmPrincipal.PgbBarra.setString("ERRO!");
                                                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                                VerificarBarraDeFerramentas();
                                                return;
                                            }
                                        }//else{DialogClass.showErro("Arquivo\""+importador+"\" bloqueado!", "Copilador");}
                                    }else{
                                        FrmPrincipal.setAvisoEmEstatus("<html>"+
                                            "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar os spawns:<br/>"+
                                            "\"<font color=\"#FF0000\">"+mobs+".tmx</font>\"",
                                            new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                                        );
                                        DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+warps+".tmx</font>\"!", "Copilador");
                                        MnuSistema.setEnabled(true);
                                        MnuEditar.setEnabled(true);
                                        MnuJogo.setEnabled(true);
                                        MnuAjuda.setEnabled(true);
                                        FrmPrincipal.PgbBarra.setString("ERRO!");
                                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                        VerificarBarraDeFerramentas();
                                        return;
                                    }
                                }else{
                                    FrmPrincipal.setAvisoEmEstatus("<html>"+
                                        "<font color=\"#FF0000\">ERRO:</font> Não foi possivel encontrar os portais:<br/>"+
                                        "\"<font color=\"#FF0000\">"+warps+".tmx</font>\"!",
                                        new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))
                                    );
                                    DialogClass.showErro("<html>Não foi possivel encontrar o mapa \"<font color=\"#FF0000\">"+warps+".tmx</font>\"!", "Copilador");
                                    MnuSistema.setEnabled(true);
                                    MnuEditar.setEnabled(true);
                                    MnuJogo.setEnabled(true);
                                    MnuAjuda.setEnabled(true);
                                    FrmPrincipal.PgbBarra.setString("ERRO!");
                                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                                    VerificarBarraDeFerramentas();
                                    return;
                                }
                            }//else{DialogClass.showErro("Não foi possivel encontrar o arquivo\""+importador+"\"!", "Copilador");}
                        }
                    }
                }
                MnuSistema.setEnabled(true);
                MnuEditar.setEnabled(true);
                MnuJogo.setEnabled(true);
                MnuAjuda.setEnabled(true);
                FrmPrincipal.PgbBarra.setString("Concluido!");
                FrmPrincipal.setAvisoEmEstatus("<html>"+
                    "Copilação semi-concluida! (<font color=\"#FF0000\">Função Deprecada</font>)",
                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))
                );
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                VerificarBarraDeFerramentas();

            }
        });
        tThread.start();
    }

    public void ExecutarJogo(){
        if (Config.getOS().indexOf("win") >= 0) {
            /*String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = URL;
            Executador.exec(cmd);/**/
            DialogClass.showErro("Este comando ainda não foi implementado para o windows!", "Descupe!");
            //C:\cygwin\cygwin.exe
            //C:\Arquivos de programas\Mana\mana.exe
        } else if (Config.getOS().indexOf("mac") >= 0) {
            //Executador.exec("open " + URL);
            DialogClass.showErro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
        } else {
            Thread tThread = new Thread(new Runnable() {
                public void run() {
                    MnuSistema.setEnabled(false);
                    MnuEditar.setEnabled(false);
                    MnuJogo.setEnabled(false);
                    MnuAjuda.setEnabled(false);
                    VerificarBarraDeFerramentas();

                    PgbBarra.setEnabled(true);
                    PgbBarra.setValue(0);
                    PgbBarra.setMinimum(0);
                    PgbBarra.setMaximum(5);

                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    Runtime Executador = Runtime.getRuntime();
                    String line = "", Comando = "";

                    if (FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost") || FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost")) {
                        PgbBarra.setString("Reiniciando...");
                        setAvisoEmEstatus("Reiniciando localhost...");
                        //TxtEstatus.setText("Reiniciando localhost...");
                        try {
                            Comando = FrmPrincipal.Config.getConexaoLocalhost() + "/eathena-data/eathena.sh restart";
                            //TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
                            Process Retorno = Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                                //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
                            }
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nEathena reiniciado (Espere 5 segundos...)\n");
                            setAvisoEmEstatus("<html>Eathena reiniciado (<font color=\"#0000FF\"><b>Espere 5 segundos...</b></font>)");
                            long TempoInicio = 0, TempoAtual = 0, Milisegundos = 5500, Segundos = 0;
                            TempoInicio = System.currentTimeMillis();
                            do {
                                TempoAtual = System.currentTimeMillis();
                                Segundos = (TempoAtual - TempoInicio) / 1000;
                                //setAvisoEmEstatus("Espere "+Segundos+"/5 segundos...");
                                PgbBarra.setValue((int) Segundos);
                                PgbBarra.setString("00:00:0" + (5 - ((int) Segundos)));
                            } while (TempoAtual - TempoInicio < Milisegundos);
                        } catch (IOException e) {
                            e.printStackTrace();
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);
                            setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                            DialogClass.showErro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>" +
                                "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            PgbBarra.setValue(5);
                            MnuSistema.setEnabled(true);
                            MnuEditar.setEnabled(true);
                            MnuJogo.setEnabled(true);
                            MnuAjuda.setEnabled(true);
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            VerificarBarraDeFerramentas();
                            return;
                        }
                    }
                    PgbBarra.setIndeterminate(true);
                    //TxtEstatus.setText(TxtEstatus.getText()+"\nAbrindo aplicativo \""+FrmPrincipal.Config.getExecucaoComando()+"\"...");
                    setAvisoEmEstatus("Abrindo aplicativo \"" + FrmPrincipal.Config.getExecucaoComando() + "\"...");
                    Comando = FrmPrincipal.Config.getExecucaoComando() + " " +
                            "--update-host --default "+ //<-- O Manaplus só roda corretamente com essa linha...
                            ((!FrmPrincipal.Config.getTMWData().isEmpty() && (FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost") || FrmPrincipal.Config.getExecucaoParametroServidor().equals("127.0.0.1")))?("--skip-update --data " + FrmPrincipal.Config.getTMWData() + " "):"") +
                            (FrmPrincipal.Config.getExecucaoParametroServidor().isEmpty() ? "" : ("--server " + FrmPrincipal.Config.getExecucaoParametroServidor() + " ")) +
                            (FrmPrincipal.Config.getExecucaoParametroConta().isEmpty() ? "" : ("--username " + FrmPrincipal.Config.getExecucaoParametroConta() + " ")) +
                            (FrmPrincipal.Config.getExecucaoParametroSenha().isEmpty() ? "" : ("--password " + FrmPrincipal.Config.getExecucaoParametroSenha() + " ")) +
                            (FrmPrincipal.Config.getExecucaoParametroPersonagem().isEmpty() ? "" : ("--character " + FrmPrincipal.Config.getExecucaoParametroPersonagem() + " ")) +
                            (FrmPrincipal.Config.getExecucaoParametroSemopengl() == true ? "--no-opengl" : "");
                    //DialogClass.showAlerta("<html>Comando:<br/>"+Comando,"TESTE DE PROGRAMADOR");
                    try {
                        Process Retorno = Executador.exec(Comando);
                        BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                            //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
                            setAvisoEmEstatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + FrmPrincipal.Config.getExecucaoComando() + "</b></font>\": " + line);
                            PgbBarra.setString("Executando...");
                        }
                        PgbBarra.setString("Fechado!");
                        setAvisoEmEstatus("<html>Aplicativo \"<font color=\"#0000FF\"><b>" + FrmPrincipal.Config.getExecucaoComando() + "</b></font>\" fechando!");
                        PgbBarra.setIndeterminate(false);
                    } catch (IOException e) {
                        PgbBarra.setIndeterminate(false);
                        e.printStackTrace();
                        if(Config.getExecucaoComando().equals("manaplus") && !Config.getSeDependenciaDeManaplus() && Config.getSeDependenciaDeTMW()){
                            Config.setExecucaoComando("tmw");
                            Config.ConfiguracoesGravar();
                            DialogClass.showErro("<html>"+
                                "O TMW-Maker <b>não encotrou o aplicativo</b> \"<font face=\"monospace\" color=\"#FF0000\"><b>MANA</b></font>\".<br/>" +
                                "Substituindo por aplicativo \"<font face=\"monospace\" color=\"#0000FF\"><b>TMW</b></font>\"..." +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            ExecutarJogo();
                        }else if(Config.getExecucaoComando().equals("tmw") && !Config.getSeDependenciaDeTMW() && Config.getSeDependenciaDeManaplus()){
                            Config.setExecucaoComando("manaplus");
                            Config.ConfiguracoesGravar();
                            DialogClass.showErro("<html>"+
                                "O TMW-Maker <b>não encotrou o aplicativo</b> \"<font face=\"monospace\" color=\"#FF0000\"><b>TMW</b></font>\".<br/>" +
                                "Substituindo por aplicativo \"<font face=\"monospace\" color=\"#0000FF\"><b>MANA</b></font>\"..." +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            ExecutarJogo();
                        }else{
                            PgbBarra.setString("ERRO...");
                            //TxtEstatus.setText(TxtEstatus.getText()+"ERRO DE EXECUÇÃO: "+Comando);
                            setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO DE EXECUÇÃO:</b></font> " + Comando);
                            DialogClass.showErro(
                                "<html>O TMW-Maker <font color=\"#FF0000\">não conseguiu abrir</font> nenhum <br/>" +
                                "aplicativo cliente(jogo) de THE MANA WORLD!<br/>"+
                                "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font>"
                                , "ERRO DE EXECUÇÃO"
                            );
                        }
                        PgbBarra.setValue(5);
                        MnuSistema.setEnabled(true);
                        MnuEditar.setEnabled(true);
                        MnuJogo.setEnabled(true);
                        MnuAjuda.setEnabled(true);
                        VerificarBarraDeFerramentas();
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        return;
                    }

                    if (FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost") || FrmPrincipal.Config.getExecucaoParametroServidor().equals("localhost")) {
                        PgbBarra.setString("Desligando...");
                        setAvisoEmEstatus("Desligando localhost...");
                        //TxtEstatus.setText("Reiniciando localhost...");
                        try {
                            Comando = FrmPrincipal.Config.getConexaoLocalhost() + "/eathena-data/eathena.sh stop";
                            //TxtEstatus.setText(TxtEstatus.getText()+"\n"+Comando);
                            Process Retorno = Executador.exec(Comando);
                            BufferedReader in = new BufferedReader(new InputStreamReader(Retorno.getInputStream()));
                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                                //TxtEstatus.setText(TxtEstatus.getText()+"\n     "+line);
                            }
                            setAvisoEmEstatus("<html><font color=\"#0000FF\"><b>" + FrmPrincipal.Config.getExecucaoComando() + "</b></font> e <font color=\"#0000FF\"><b>eathena</b></font> executados e encerrados com sucesso!");
                            PgbBarra.setString("Encerrado!");
                        } catch (IOException e) {
                            e.printStackTrace();
                            //TxtEstatus.setText(TxtEstatus.getText()+"\nERRO: "+Comando);

                            setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>ERRO:</b></font> " + Comando);
                            DialogClass.showErro("<html><b>O TMW-Maker não conseguiu desligar o eathena:</b><br/><br/>" +
                                "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            PgbBarra.setValue(5);
                            MnuSistema.setEnabled(true);
                            MnuEditar.setEnabled(true);
                            MnuJogo.setEnabled(true);
                            MnuAjuda.setEnabled(true);
                            VerificarBarraDeFerramentas();
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            return;
                        }
                    }

                    PgbBarra.setValue(5);
                    MnuSistema.setEnabled(true);
                    MnuEditar.setEnabled(true);
                    MnuJogo.setEnabled(true);
                    MnuAjuda.setEnabled(true);
                    VerificarBarraDeFerramentas();
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            tThread.start();
        }
    }
    public void VerificarMenus() {
        if (Config.getOS().indexOf("win") >= 0 || Config.getOS().indexOf("mac") >= 0) {
            MnuJogoLocalhost.setEnabled(false);
            MnuJogoLocalhost.setEnabled(false);
            MnuEditarContas.setEnabled(false);
            MnuEditarItens.setEnabled(false);
            //MnuEditarPersonagemScript.setEnabled(false);
        } else {
            MnuJogoLocalhost.setEnabled(Config.getSeDependenciaDeSVN());
            MnuJogoLocalhostAtualizar.setEnabled(Config.getSeDependenciaDeSVN() && Config.getSeDependenciaDeMontagem());
            MnuJogoLocalhostCompartilhar.setEnabled(Config.getSeDependenciaDeSVN() && Config.getSeDependenciaDeMontagem());
            MnuEditarContas.setEnabled(Config.getSeDependenciaDeMontagem());
            MnuEditarPersonagem.setEnabled(Config.getSeDependenciaDeMontagem());
            MnuEditarItens.setEnabled(Config.getSeDependenciaDeMontagem());
            MnuJogoExecutar.setEnabled(Config.getSeDependenciaDeMontagem());
            MnuJogoCopilar.setEnabled(Config.getSeDependenciaDeMontagem());
        }
    }
    public void VerificarBarraDeFerramentas() {
        BtnSistemaAlteracoes.setEnabled(MnuSistema.isEnabled() && MnuSistemaAtualizar.isEnabled());
        BtnSistemaConfiguracoes.setEnabled(MnuSistema.isEnabled() && MnuSistemaConfiguracoes.isEnabled());
        BtnSistemaDependencias.setEnabled(MnuSistema.isEnabled() && MnuSistemaDependencias.isEnabled());
        BtnEditorItensSprites.setEnabled(MnuEditar.isEnabled() && MnuEditarItens.isEnabled() && MnuEditarItensSprites.isEnabled());
        BtnEditarItensDados.setEnabled(MnuEditar.isEnabled() && MnuEditarItens.isEnabled() && MnuEditarItensDados.isEnabled());
        BtnEditarPersonagemScript.setEnabled(MnuEditar.isEnabled() && MnuEditarPersonagem.isEnabled() && MnuEditarPersonagemScript.isEnabled());
        BtnEditarContas.setEnabled(MnuEditar.isEnabled() && MnuEditarContas.isEnabled());
        BtnJogoExecular.setEnabled(MnuJogo.isEnabled() && MnuJogoExecutar.isEnabled());
        BtnJogoCopilar.setEnabled(MnuJogo.isEnabled() && MnuJogoCopilar.isEnabled());
        BtnJogoLocalhostSupervisonar.setEnabled(MnuJogo.isEnabled() && MnuJogoLocalhost.isEnabled() && MnuJogoLocalhostSupervisionado.isEnabled());
        BtnJogoLocalhostAtualizar.setEnabled(MnuJogo.isEnabled() && MnuJogoLocalhost.isEnabled() && MnuJogoLocalhostAtualizar.isEnabled());
        BtnJogoLocalhostCompartilhar.setEnabled(MnuJogo.isEnabled() && MnuJogoLocalhost.isEnabled() && MnuJogoLocalhostCompartilhar.isEnabled());
        BtnAjudaComponentes.setEnabled(MnuAjuda.isEnabled() && MnuAjudaComponentes.isEnabled());
        BtnAjudaIndicarDefeito.setEnabled(MnuAjuda.isEnabled() && MnuAjudaIndicarDefeito.isEnabled());
        BtnAjudaSobre.setEnabled(MnuAjuda.isEnabled() && MnuAjudaSobre.isEnabled());
    }
    private void EsticarFundo() {
        ImagemClass Fundo = new ImagemClass("/Imagem/Fundos/tela_1492x1024.png");
        //Fundo.setEsticar(LblFundo.getWidth(),LblFundo.getHeight());
        Fundo.setZoom(
            ((double)LblFundo.getWidth())/((double)Fundo.getLargura())
        );
        LblFundo.setIcon(Fundo.getIcone());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlBarraDeEstatus = new javax.swing.JPanel();
        LblEstatus = new javax.swing.JLabel();
        PgbBarra = new javax.swing.JProgressBar();
        LblFundo = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        BtnSistemaAlteracoes = new javax.swing.JButton();
        BtnSistemaConfiguracoes = new javax.swing.JButton();
        BtnSistemaDependencias = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        BtnEditorItensSprites = new javax.swing.JButton();
        BtnEditarItensDados = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        BtnEditarPersonagemScript = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        BtnEditarContas = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        BtnJogoExecular = new javax.swing.JButton();
        BtnJogoCopilar = new javax.swing.JButton();
        BtnJogoLocalhostSupervisonar = new javax.swing.JButton();
        BtnJogoLocalhostAtualizar = new javax.swing.JButton();
        BtnJogoLocalhostCompartilhar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        BtnAjudaComponentes = new javax.swing.JButton();
        BtnAjudaIndicarDefeito = new javax.swing.JButton();
        BtnAjudaSobre = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuSistema = new javax.swing.JMenu();
        MnuSistemaAlteracoes = new javax.swing.JMenuItem();
        MnuSistemaAtualizar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        MnuSistemaConfiguracoes = new javax.swing.JMenuItem();
        MnuSistemaDependencias = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        MnuSistemaAreaDeTeste = new javax.swing.JMenuItem();
        MnuSistemaFechar = new javax.swing.JMenuItem();
        MnuEditar = new javax.swing.JMenu();
        MnuEditarItens = new javax.swing.JMenu();
        MnuEditarItensSprites = new javax.swing.JMenuItem();
        MnuEditarItensDados = new javax.swing.JMenuItem();
        MnuEditarCampos = new javax.swing.JMenu();
        MnuEditarCamposTilesets = new javax.swing.JMenuItem();
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
        MnuJogoLocalhost = new javax.swing.JMenu();
        MnuJogoLocalhostSupervisionado = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MnuJogoLocalhostAtualizar = new javax.swing.JMenuItem();
        MnuJogoLocalhostCompartilhar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        MnuJogoCopilar = new javax.swing.JMenuItem();
        MnuJogoExecutar = new javax.swing.JMenuItem();
        MnuAjuda = new javax.swing.JMenu();
        MnuAjudaComponentes = new javax.swing.JMenuItem();
        MnuAjudaIndicarDefeito = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        MnuAjudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TMW-MAKER 0.2");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        PnlBarraDeEstatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlBarraDeEstatus.setAlignmentX(0.0F);
        PnlBarraDeEstatus.setAlignmentY(0.0F);

        LblEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        LblEstatus.setText("Bem Vindo ao TMW-Maker!");
        LblEstatus.setBorder(null);

        PgbBarra.setBackground(new java.awt.Color(0, 79, 24));
        PgbBarra.setForeground(new java.awt.Color(0, 152, 27));
        PgbBarra.setString("");
        PgbBarra.setStringPainted(true);

        javax.swing.GroupLayout PnlBarraDeEstatusLayout = new javax.swing.GroupLayout(PnlBarraDeEstatus);
        PnlBarraDeEstatus.setLayout(PnlBarraDeEstatusLayout);
        PnlBarraDeEstatusLayout.setHorizontalGroup(
            PnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlBarraDeEstatusLayout.createSequentialGroup()
                .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlBarraDeEstatusLayout.setVerticalGroup(
            PnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
            .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        LblFundo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/tela_1492x1024.png"))); // NOI18N
        LblFundo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        BtnSistemaAlteracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_file_rss.gif"))); // NOI18N
        BtnSistemaAlteracoes.setToolTipText("Alterações (F12)");
        BtnSistemaAlteracoes.setFocusable(false);
        BtnSistemaAlteracoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSistemaAlteracoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSistemaAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSistemaAlteracoesActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnSistemaAlteracoes);

        BtnSistemaConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_chaveinglesa.png"))); // NOI18N
        BtnSistemaConfiguracoes.setToolTipText("Configurações (Ctrl+G)");
        BtnSistemaConfiguracoes.setFocusable(false);
        BtnSistemaConfiguracoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSistemaConfiguracoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSistemaConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSistemaConfiguracoesActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnSistemaConfiguracoes);

        BtnSistemaDependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_dependencias.gif"))); // NOI18N
        BtnSistemaDependencias.setToolTipText("Dependências (Ctrl+D)");
        BtnSistemaDependencias.setFocusable(false);
        BtnSistemaDependencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSistemaDependencias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSistemaDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSistemaDependenciasActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnSistemaDependencias);
        jToolBar1.add(jSeparator7);

        BtnEditorItensSprites.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_espada.gif"))); // NOI18N
        BtnEditorItensSprites.setToolTipText("Novo Equipamento (Ctrl+Shift+I)");
        BtnEditorItensSprites.setFocusable(false);
        BtnEditorItensSprites.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditorItensSprites.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditorItensSprites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditorItensSpritesActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnEditorItensSprites);

        BtnEditarItensDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_presente.gif"))); // NOI18N
        BtnEditarItensDados.setToolTipText("Editor de Ítens (Ctrl+I)");
        BtnEditarItensDados.setFocusable(false);
        BtnEditarItensDados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditarItensDados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditarItensDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarItensDadosActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnEditarItensDados);
        jToolBar1.add(jSeparator8);

        BtnEditarPersonagemScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_arvore.png"))); // NOI18N
        BtnEditarPersonagemScript.setToolTipText("Arvore de Scripts de NPC (Ctrl+N)");
        BtnEditarPersonagemScript.setFocusable(false);
        BtnEditarPersonagemScript.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditarPersonagemScript.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditarPersonagemScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarPersonagemScriptActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnEditarPersonagemScript);
        jToolBar1.add(jSeparator9);

        BtnEditarContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_contato.gif"))); // NOI18N
        BtnEditarContas.setToolTipText("Poderes de Contas (Ctrl+Shift+T)");
        BtnEditarContas.setFocusable(false);
        BtnEditarContas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditarContas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditarContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarContasActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnEditarContas);
        jToolBar1.add(jSeparator11);

        BtnJogoExecular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_play.png"))); // NOI18N
        BtnJogoExecular.setToolTipText("Executar Localhost (F9)");
        BtnJogoExecular.setFocusable(false);
        BtnJogoExecular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnJogoExecular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnJogoExecular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJogoExecularActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnJogoExecular);

        BtnJogoCopilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_atomico.gif"))); // NOI18N
        BtnJogoCopilar.setToolTipText("Copilar (Ctrl+F9)");
        BtnJogoCopilar.setFocusable(false);
        BtnJogoCopilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnJogoCopilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnJogoCopilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJogoCopilarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnJogoCopilar);

        BtnJogoLocalhostSupervisonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_load.gif"))); // NOI18N
        BtnJogoLocalhostSupervisonar.setToolTipText("Supervisionar Localhost... (Ctrl+L)");
        BtnJogoLocalhostSupervisonar.setFocusable(false);
        BtnJogoLocalhostSupervisonar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnJogoLocalhostSupervisonar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnJogoLocalhostSupervisonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJogoLocalhostSupervisonarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnJogoLocalhostSupervisonar);

        BtnJogoLocalhostAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_download.gif"))); // NOI18N
        BtnJogoLocalhostAtualizar.setToolTipText("Atualizar Localhost (Ctrl+PageDown)");
        BtnJogoLocalhostAtualizar.setFocusable(false);
        BtnJogoLocalhostAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnJogoLocalhostAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnJogoLocalhostAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJogoLocalhostAtualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnJogoLocalhostAtualizar);

        BtnJogoLocalhostCompartilhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_upload.gif"))); // NOI18N
        BtnJogoLocalhostCompartilhar.setToolTipText("Compartilhar Localhost (Ctrl+PageUp)");
        BtnJogoLocalhostCompartilhar.setFocusable(false);
        BtnJogoLocalhostCompartilhar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnJogoLocalhostCompartilhar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnJogoLocalhostCompartilhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJogoLocalhostCompartilharActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnJogoLocalhostCompartilhar);
        jToolBar1.add(jSeparator10);

        BtnAjudaComponentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        BtnAjudaComponentes.setToolTipText("Ajuda Sobre Componente (F1)");
        BtnAjudaComponentes.setEnabled(false);
        BtnAjudaComponentes.setFocusable(false);
        BtnAjudaComponentes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAjudaComponentes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAjudaComponentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjudaComponentesActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAjudaComponentes);

        BtnAjudaIndicarDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))); // NOI18N
        BtnAjudaIndicarDefeito.setToolTipText("Indicar Defeito (F5)");
        BtnAjudaIndicarDefeito.setFocusable(false);
        BtnAjudaIndicarDefeito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAjudaIndicarDefeito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAjudaIndicarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjudaIndicarDefeitoActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAjudaIndicarDefeito);

        BtnAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        BtnAjudaSobre.setToolTipText("Sobre o Engine...");
        BtnAjudaSobre.setFocusable(false);
        BtnAjudaSobre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAjudaSobre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjudaSobreActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnAjudaSobre);

        MnuSistema.setMnemonic('S');
        MnuSistema.setText("Sistema");

        MnuSistemaAlteracoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        MnuSistemaAlteracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_file_rss.gif"))); // NOI18N
        MnuSistemaAlteracoes.setMnemonic('T');
        MnuSistemaAlteracoes.setText("Alterações");
        MnuSistemaAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaAlteracoesActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaAlteracoes);

        MnuSistemaAtualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_update.gif"))); // NOI18N
        MnuSistemaAtualizar.setMnemonic('A');
        MnuSistemaAtualizar.setText("Atualizar");
        MnuSistemaAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaAtualizarActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaAtualizar);
        MnuSistema.add(jSeparator1);

        MnuSistemaConfiguracoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_chaveinglesa.png"))); // NOI18N
        MnuSistemaConfiguracoes.setMnemonic('G');
        MnuSistemaConfiguracoes.setText("Configurações");
        MnuSistemaConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaConfiguracoesActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaConfiguracoes);

        MnuSistemaDependencias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaDependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_dependencias.gif"))); // NOI18N
        MnuSistemaDependencias.setMnemonic('D');
        MnuSistemaDependencias.setText("Dependencias");
        MnuSistemaDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaDependenciasActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaDependencias);
        MnuSistema.add(jSeparator2);

        MnuSistemaAreaDeTeste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MnuSistemaAreaDeTeste.setMnemonic('T');
        MnuSistemaAreaDeTeste.setText("Área de Testes");
        MnuSistemaAreaDeTeste.setEnabled(false);
        MnuSistemaAreaDeTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuSistemaAreaDeTesteActionPerformed(evt);
            }
        });
        MnuSistema.add(MnuSistemaAreaDeTeste);

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

        MnuEditarItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_armadura.png"))); // NOI18N
        MnuEditarItens.setMnemonic('I');
        MnuEditarItens.setText("Itens");

        MnuEditarItensSprites.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarItensSprites.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_espada.gif"))); // NOI18N
        MnuEditarItensSprites.setMnemonic('S');
        MnuEditarItensSprites.setText("Novo Equipamento");
        MnuEditarItensSprites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarItensSpritesActionPerformed(evt);
            }
        });
        MnuEditarItens.add(MnuEditarItensSprites);

        MnuEditarItensDados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarItensDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_presente.gif"))); // NOI18N
        MnuEditarItensDados.setMnemonic('D');
        MnuEditarItensDados.setText("Editor de Ítens");
        MnuEditarItensDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarItensDadosActionPerformed(evt);
            }
        });
        MnuEditarItens.add(MnuEditarItensDados);

        MnuEditar.add(MnuEditarItens);

        MnuEditarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_casa.png"))); // NOI18N
        MnuEditarCampos.setMnemonic('C');
        MnuEditarCampos.setText("Campos");

        MnuEditarCamposTilesets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_terreno.gif"))); // NOI18N
        MnuEditarCamposTilesets.setMnemonic('T');
        MnuEditarCamposTilesets.setText("Tilesets");
        MnuEditarCamposTilesets.setEnabled(false);
        MnuEditarCampos.add(MnuEditarCamposTilesets);

        MnuEditarCamposMapas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarCamposMapas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_globo.gif"))); // NOI18N
        MnuEditarCamposMapas.setMnemonic('M');
        MnuEditarCamposMapas.setText("Mapas");
        MnuEditarCamposMapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarCamposMapasActionPerformed(evt);
            }
        });
        MnuEditarCampos.add(MnuEditarCamposMapas);

        MnuEditar.add(MnuEditarCampos);

        MnuEditarPersonagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pessoa.gif"))); // NOI18N
        MnuEditarPersonagem.setMnemonic('P');
        MnuEditarPersonagem.setText("Personagem (NPC)");

        MnuEditarPersonagemAparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_pessoa.gif"))); // NOI18N
        MnuEditarPersonagemAparencia.setMnemonic('A');
        MnuEditarPersonagemAparencia.setText("Aparencia");
        MnuEditarPersonagemAparencia.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemAparencia);

        MnuEditarPersonagemLoja.setMnemonic('L');
        MnuEditarPersonagemLoja.setText("Loja");
        MnuEditarPersonagemLoja.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemLoja);

        MnuEditarPersonagemScript.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarPersonagemScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_arvore.png"))); // NOI18N
        MnuEditarPersonagemScript.setMnemonic('S');
        MnuEditarPersonagemScript.setText("Árvore de Script de NPC");
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
        MnuEditarInimigos.setEnabled(false);

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

        MnuEditarMagias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_magica.png"))); // NOI18N
        MnuEditarMagias.setMnemonic('M');
        MnuEditarMagias.setText("Magias");
        MnuEditarMagias.setEnabled(false);

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

        MnuJogoLocalhost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_tmw.png"))); // NOI18N
        MnuJogoLocalhost.setMnemonic('L');
        MnuJogoLocalhost.setText("Localhost");

        MnuJogoLocalhostSupervisionado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoLocalhostSupervisionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_load.gif"))); // NOI18N
        MnuJogoLocalhostSupervisionado.setMnemonic('S');
        MnuJogoLocalhostSupervisionado.setText("Supervisionado...");
        MnuJogoLocalhostSupervisionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoLocalhostSupervisionadoActionPerformed(evt);
            }
        });
        MnuJogoLocalhost.add(MnuJogoLocalhostSupervisionado);
        MnuJogoLocalhost.add(jSeparator6);

        MnuJogoLocalhostAtualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_DOWN, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoLocalhostAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_download.gif"))); // NOI18N
        MnuJogoLocalhostAtualizar.setMnemonic('A');
        MnuJogoLocalhostAtualizar.setText("Atualizar");
        MnuJogoLocalhostAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoLocalhostAtualizarActionPerformed(evt);
            }
        });
        MnuJogoLocalhost.add(MnuJogoLocalhostAtualizar);

        MnuJogoLocalhostCompartilhar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAGE_UP, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoLocalhostCompartilhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_upload.gif"))); // NOI18N
        MnuJogoLocalhostCompartilhar.setMnemonic('C');
        MnuJogoLocalhostCompartilhar.setText("Compartilhar");
        MnuJogoLocalhostCompartilhar.setEnabled(false);
        MnuJogoLocalhostCompartilhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoLocalhostCompartilharActionPerformed(evt);
            }
        });
        MnuJogoLocalhost.add(MnuJogoLocalhostCompartilhar);

        MnuJogo.add(MnuJogoLocalhost);
        MnuJogo.add(jSeparator5);

        MnuJogoCopilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, java.awt.event.InputEvent.CTRL_MASK));
        MnuJogoCopilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_atomico.gif"))); // NOI18N
        MnuJogoCopilar.setMnemonic('C');
        MnuJogoCopilar.setText("Copilar");
        MnuJogoCopilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoCopilarActionPerformed(evt);
            }
        });
        MnuJogo.add(MnuJogoCopilar);

        MnuJogoExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        MnuJogoExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_play.png"))); // NOI18N
        MnuJogoExecutar.setMnemonic('E');
        MnuJogoExecutar.setText("Executar");
        MnuJogoExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoExecutarActionPerformed(evt);
            }
        });
        MnuJogo.add(MnuJogoExecutar);

        jMenuBar1.add(MnuJogo);

        MnuAjuda.setMnemonic('A');
        MnuAjuda.setText("Ajuda");

        MnuAjudaComponentes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MnuAjudaComponentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        MnuAjudaComponentes.setMnemonic('P');
        MnuAjudaComponentes.setText("Componentes");
        MnuAjudaComponentes.setEnabled(false);
        MnuAjuda.add(MnuAjudaComponentes);

        MnuAjudaIndicarDefeito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        MnuAjudaIndicarDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_alerta.png"))); // NOI18N
        MnuAjudaIndicarDefeito.setMnemonic('D');
        MnuAjudaIndicarDefeito.setText("Indicar Defeito");
        MnuAjudaIndicarDefeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAjudaIndicarDefeitoActionPerformed(evt);
            }
        });
        MnuAjuda.add(MnuAjudaIndicarDefeito);

        jMenuItem11.setText("Traduções");
        jMenuItem11.setEnabled(false);
        MnuAjuda.add(jMenuItem11);
        MnuAjuda.add(jSeparator4);

        MnuAjudaSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        MnuAjudaSobre.setText("Sobre o Engine");
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
            .addComponent(LblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 594, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LblFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PnlBarraDeEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnuAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaSobreActionPerformed
        // TODO add your handling code here:
        javax.swing.JDialog FrmSplash = new FrmSobre(this, rootPaneCheckingEnabled);
        FrmSplash.setLocation(
                ((this.getWidth() - FrmSplash.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmSplash.getHeight()) / 2) + this.getY());
        FrmSplash.pack();
        FrmSplash.setModal(true);
        FrmSplash.setVisible(true);/**/
    }//GEN-LAST:event_MnuAjudaSobreActionPerformed
    private void MnuAjudaIndicarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAjudaIndicarDefeitoActionPerformed
        // TODO add your handling code here:
        Config.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoComentarios());
    }//GEN-LAST:event_MnuAjudaIndicarDefeitoActionPerformed
    private void MnuJogoExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoExecutarActionPerformed
        ExecutarJogo();
    }//GEN-LAST:event_MnuJogoExecutarActionPerformed
    private void MnuEditarPersonagemScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarPersonagemScriptActionPerformed
        javax.swing.JDialog FrmScript = new FrmScript(this, rootPaneCheckingEnabled);
        FrmScript.setLocation(
            ((this.getWidth() - FrmScript.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmScript.getHeight()) / 2) + this.getY());
        FrmScript.pack();
        FrmScript.setModal(true);
        FrmScript.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarPersonagemScriptActionPerformed
    private void MnuSistemaFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaFecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_MnuSistemaFecharActionPerformed
    private void MnuSistemaAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAlteracoesActionPerformed
        // TODO add your handling code here:
        Config.AbrirNavegador(FrmPrincipal.Config.getDocumentacaoAlteracoes());
}//GEN-LAST:event_MnuSistemaAlteracoesActionPerformed
    private void MnuSistemaConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaConfiguracoesActionPerformed
        javax.swing.JDialog FrmConfiguracao = new FrmConfiguracao(this, rootPaneCheckingEnabled);
        FrmConfiguracao.setLocation(
            ((this.getWidth() - FrmConfiguracao.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmConfiguracao.getHeight()) / 2) + this.getY());
        FrmConfiguracao.pack();
        FrmConfiguracao.setModal(true);
        FrmConfiguracao.setVisible(true);/**/
}//GEN-LAST:event_MnuSistemaConfiguracoesActionPerformed
    private void MnuJogoLocalhostSupervisionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoLocalhostSupervisionadoActionPerformed
        javax.swing.JDialog FrmCheckout = new FrmLocalhost(this, rootPaneCheckingEnabled);
        FrmCheckout.setLocation(
                ((this.getWidth() - FrmCheckout.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmCheckout.getHeight()) / 2) + this.getY());
        FrmCheckout.pack();
        FrmCheckout.setModal(true);
        FrmCheckout.setVisible(true);/**/
}//GEN-LAST:event_MnuJogoLocalhostSupervisionadoActionPerformed
    private void MnuEditarContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarContasActionPerformed
        javax.swing.JDialog FrmContas = new FrmContas(this, rootPaneCheckingEnabled);
        FrmContas.setLocation(
                ((this.getWidth() - FrmContas.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmContas.getHeight()) / 2) + this.getY());
        FrmContas.pack();
        FrmContas.setModal(true);
        FrmContas.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarContasActionPerformed
    private void MnuSistemaDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaDependenciasActionPerformed
        MostrarDePendencias();
    }//GEN-LAST:event_MnuSistemaDependenciasActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Dimension Tela = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
                (Tela.width - this.getWidth()) / 2,
                (Tela.height - this.getHeight()) / 2,
                this.getWidth(),
                this.getHeight());
        this.setExtendedState(MAXIMIZED_BOTH); //Maximiza a tela
        Config.ConfiguracoesAbrir();
        if(Config.getDependenciaEmFalta() >= 1) MostrarDePendencias();
        if(FrmPrincipal.Config.getOS().indexOf("linux") >= 0) {
            if(FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
                if(FrmPrincipal.Config.getSeDependenciaDeSVN()){
                    if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                        if(!(FrmPrincipal.Itens instanceof Classes.BancoDeDados.Banco_Itens)){
                            if(FrmPrincipal.Config.getAtualizacaoLocalhostIntervalo()>=0 && ConfigClass.getAgora()>=FrmPrincipal.Config.getAtualizacaoLocalhostFutura()){
                                int R = JOptionPane.YES_OPTION;
                                Object[] options = {"Procurar", "Depois"};
                                R = JOptionPane.showOptionDialog(
                                    null, "<html>" +
                                    "O TMW-Maker é uma ferramenta de desenvolvimento colaborativa.<br/>" +
                                    "Por esta razão, seu Localhost pode estar desatualizado.<br/>" +
                                    "Deseja procurar atualização criada por outros DEVs via internet?",
                                    "ATUALIZAÇÃO DO LOCALHOST",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmw-96x96px.png")),
                                    options,
                                    options[0]
                                );
                                if (R == JOptionPane.YES_OPTION) {
                                    LocalhostReceber();
                                }else{
                                    MostrarDeSplash();
                                }
                            }else{
                                MostrarDeSplash();
                            }
                            if(FrmPrincipal.Config.getAtualizacaoEngineIntervalo()>=0 && ConfigClass.getAgora()>=FrmPrincipal.Config.getAtualizacaoEngineFutura()){
                                int R = JOptionPane.YES_OPTION;
                                Object[] options = {"Atualizar", "Depois"};
                                R = JOptionPane.showOptionDialog(
                                    null, "<html>" +
                                    "Seu TMW-Maker pode estar desatualizado.<br/>" +
                                    "Deseja procurar uma versão atualizada?",
                                    "ATUALIZAÇÃO DO TMW-MAKER v"+FrmPrincipal.Config.getVersao()+"",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/icon-tmw-96x96px.png")),
                                    options,
                                    options[0]
                                );
                                if (R == JOptionPane.YES_OPTION) {
                                    Atualizar();
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_formWindowOpened
    private void MnuSistemaAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAtualizarActionPerformed
        if (FrmPrincipal.Config.getOS().indexOf("win") >= 0) {
            DialogClass.showErro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (FrmPrincipal.Config.getOS().indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            DialogClass.showErro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            if(FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
                if(FrmPrincipal.Config.getSeDependenciaDeSVN()){
                    if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                        Atualizar();
                    }else{
                        DialogClass.showErro("Para atualizar é necessário atender a dependência de Localhost!","ERRO");
                    }
                }else{
                    DialogClass.showErro("Para atualizar é necessário atender a dependência de SNV!","ERRO");
                }
            }else{
                DialogClass.showErro("Para atualizar é necessário atender a dependência de Configuração!","ERRO");
            }
        }

    }//GEN-LAST:event_MnuSistemaAtualizarActionPerformed
    private void MnuEditarItensDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarItensDadosActionPerformed
        javax.swing.JDialog FrmItens = new FrmItens(this, rootPaneCheckingEnabled);
        FrmItens.setLocation(
            ((this.getWidth() - FrmItens.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmItens.getHeight()) / 2) + this.getY());
        FrmItens.pack();
        FrmItens.setModal(true);
        FrmItens.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarItensDadosActionPerformed
    private void MnuSistemaAreaDeTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAreaDeTesteActionPerformed
        javax.swing.JDialog FrmTestesDeCodigo = new FrmTestesDeCodigo(this, rootPaneCheckingEnabled);
        FrmTestesDeCodigo.setLocation(
                ((this.getWidth() - FrmTestesDeCodigo.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmTestesDeCodigo.getHeight()) / 2) + this.getY());
        FrmTestesDeCodigo.pack();
        FrmTestesDeCodigo.setModal(true);
        FrmTestesDeCodigo.setVisible(true);/**/
    }//GEN-LAST:event_MnuSistemaAreaDeTesteActionPerformed
    private void MnuEditarItensSpritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarItensSpritesActionPerformed
        javax.swing.JDialog FrmNovoEquipamento = new FrmEquipXmlNovo(this, rootPaneCheckingEnabled);
        FrmNovoEquipamento.setLocation(
            ((this.getWidth() - FrmNovoEquipamento.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmNovoEquipamento.getHeight()) / 2) + this.getY());
        FrmNovoEquipamento.pack();
        FrmNovoEquipamento.setModal(true);
        FrmNovoEquipamento.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarItensSpritesActionPerformed
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        VerificarMenus();
        VerificarBarraDeFerramentas();
        EsticarFundo();
    }//GEN-LAST:event_formWindowActivated
    private void MnuJogoLocalhostAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoLocalhostAtualizarActionPerformed
        LocalhostReceber();
    }//GEN-LAST:event_MnuJogoLocalhostAtualizarActionPerformed
    private void MnuJogoLocalhostCompartilharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoLocalhostCompartilharActionPerformed
        LocalhostCompartilhar();
    }//GEN-LAST:event_MnuJogoLocalhostCompartilharActionPerformed
    private void BtnSistemaAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSistemaAlteracoesActionPerformed
        if(MnuSistema.isEnabled() && MnuSistemaAlteracoes.isEnabled()) MnuSistemaAlteracoesActionPerformed(evt);
    }//GEN-LAST:event_BtnSistemaAlteracoesActionPerformed
    private void BtnSistemaConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSistemaConfiguracoesActionPerformed
        if(MnuSistema.isEnabled() && MnuSistemaConfiguracoes.isEnabled()) MnuSistemaConfiguracoesActionPerformed(evt);
    }//GEN-LAST:event_BtnSistemaConfiguracoesActionPerformed
    private void BtnSistemaDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSistemaDependenciasActionPerformed
        if(MnuSistema.isEnabled() && MnuSistemaDependencias.isEnabled()) MnuSistemaDependenciasActionPerformed(evt);
    }//GEN-LAST:event_BtnSistemaDependenciasActionPerformed
    private void BtnEditorItensSpritesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditorItensSpritesActionPerformed
        if(MnuEditar.isEnabled() && MnuEditarItens.isEnabled() && MnuEditarItensSprites.isEnabled()) MnuEditarItensSpritesActionPerformed(evt);
    }//GEN-LAST:event_BtnEditorItensSpritesActionPerformed
    private void BtnEditarItensDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarItensDadosActionPerformed
        if(MnuEditar.isEnabled() && MnuEditarItens.isEnabled() && MnuEditarItensDados.isEnabled()) MnuEditarItensDadosActionPerformed(evt);
    }//GEN-LAST:event_BtnEditarItensDadosActionPerformed
    private void BtnEditarPersonagemScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarPersonagemScriptActionPerformed
        if(MnuEditar.isEnabled() && MnuEditarPersonagem.isEnabled() && MnuEditarPersonagemScript.isEnabled()) MnuEditarPersonagemScriptActionPerformed(evt);
    }//GEN-LAST:event_BtnEditarPersonagemScriptActionPerformed
    private void BtnEditarContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarContasActionPerformed
        if(MnuEditar.isEnabled() && MnuEditarContas.isEnabled()) MnuEditarContasActionPerformed(evt);
    }//GEN-LAST:event_BtnEditarContasActionPerformed
    private void BtnJogoExecularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJogoExecularActionPerformed
        if(MnuJogo.isEnabled() && MnuJogoExecutar.isEnabled()) MnuJogoExecutarActionPerformed(evt);
    }//GEN-LAST:event_BtnJogoExecularActionPerformed
    private void BtnJogoLocalhostSupervisonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJogoLocalhostSupervisonarActionPerformed
        if(MnuJogo.isEnabled() && MnuJogoLocalhostSupervisionado.isEnabled()) MnuJogoLocalhostSupervisionadoActionPerformed(evt);
    }//GEN-LAST:event_BtnJogoLocalhostSupervisonarActionPerformed
    private void BtnJogoLocalhostAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJogoLocalhostAtualizarActionPerformed
        if(MnuJogo.isEnabled() && MnuJogoLocalhostAtualizar.isEnabled()) MnuJogoLocalhostAtualizarActionPerformed(evt);
    }//GEN-LAST:event_BtnJogoLocalhostAtualizarActionPerformed
    private void BtnJogoLocalhostCompartilharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJogoLocalhostCompartilharActionPerformed
        if(MnuJogo.isEnabled() && MnuJogoLocalhostCompartilhar.isEnabled()) MnuJogoLocalhostCompartilharActionPerformed(evt);
    }//GEN-LAST:event_BtnJogoLocalhostCompartilharActionPerformed
    private void BtnAjudaComponentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjudaComponentesActionPerformed
        DialogClass.showErro("Este atalho ainda não foi implementado!", "Descupe!");
    }//GEN-LAST:event_BtnAjudaComponentesActionPerformed
    private void BtnAjudaIndicarDefeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjudaIndicarDefeitoActionPerformed
        if(MnuAjuda.isEnabled() && MnuAjudaIndicarDefeito.isEnabled()) MnuAjudaIndicarDefeitoActionPerformed(evt);
    }//GEN-LAST:event_BtnAjudaIndicarDefeitoActionPerformed
    private void BtnAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjudaSobreActionPerformed
        if(MnuAjuda.isEnabled() && MnuAjudaSobre.isEnabled()) MnuAjudaSobreActionPerformed(evt);
    }//GEN-LAST:event_BtnAjudaSobreActionPerformed
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        EsticarFundo();
    }//GEN-LAST:event_formComponentResized
    private void MnuJogoCopilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuJogoCopilarActionPerformed
        LocalhostCopilar();
    }//GEN-LAST:event_MnuJogoCopilarActionPerformed
    private void BtnJogoCopilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJogoCopilarActionPerformed
        if(MnuJogo.isEnabled() && MnuJogoCopilar.isEnabled()) MnuJogoCopilarActionPerformed(evt);
    }//GEN-LAST:event_BtnJogoCopilarActionPerformed

    private void MnuEditarCamposMapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEditarCamposMapasActionPerformed
        javax.swing.JDialog FrmListarMapas = new FrmListarMapas(this, rootPaneCheckingEnabled);
        FrmListarMapas.setLocation(
            ((this.getWidth() - FrmListarMapas.getWidth()) / 2) + this.getX(),
            ((this.getHeight() - FrmListarMapas.getHeight()) / 2) + this.getY());
        FrmListarMapas.pack();
        FrmListarMapas.setModal(true);
        FrmListarMapas.setVisible(true);/**/
    }//GEN-LAST:event_MnuEditarCamposMapasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjudaComponentes;
    private javax.swing.JButton BtnAjudaIndicarDefeito;
    private javax.swing.JButton BtnAjudaSobre;
    private javax.swing.JButton BtnEditarContas;
    private javax.swing.JButton BtnEditarItensDados;
    private javax.swing.JButton BtnEditarPersonagemScript;
    private javax.swing.JButton BtnEditorItensSprites;
    private javax.swing.JButton BtnJogoCopilar;
    private javax.swing.JButton BtnJogoExecular;
    private javax.swing.JButton BtnJogoLocalhostAtualizar;
    private javax.swing.JButton BtnJogoLocalhostCompartilhar;
    private javax.swing.JButton BtnJogoLocalhostSupervisonar;
    private javax.swing.JButton BtnSistemaAlteracoes;
    private javax.swing.JButton BtnSistemaConfiguracoes;
    private javax.swing.JButton BtnSistemaDependencias;
    public static javax.swing.JLabel LblEstatus;
    private javax.swing.JLabel LblFundo;
    private javax.swing.JMenu MnuAjuda;
    private javax.swing.JMenuItem MnuAjudaComponentes;
    private javax.swing.JMenuItem MnuAjudaIndicarDefeito;
    private javax.swing.JMenuItem MnuAjudaSobre;
    private javax.swing.JMenu MnuEditar;
    private javax.swing.JMenu MnuEditarCampos;
    private javax.swing.JMenuItem MnuEditarCamposMapas;
    private javax.swing.JMenuItem MnuEditarCamposTilesets;
    private javax.swing.JMenuItem MnuEditarContas;
    private javax.swing.JMenu MnuEditarInimigos;
    private javax.swing.JMenuItem MnuEditarInimigosAnimacao;
    private javax.swing.JMenuItem MnuEditarInimigosArenas;
    private javax.swing.JMenuItem MnuEditarInimigosDados;
    public static javax.swing.JMenu MnuEditarItens;
    private javax.swing.JMenuItem MnuEditarItensDados;
    private javax.swing.JMenuItem MnuEditarItensSprites;
    private javax.swing.JMenu MnuEditarMagias;
    private javax.swing.JMenuItem MnuEditarMagiasCompetencias;
    private javax.swing.JMenuItem MnuEditarMagiasConjurações;
    public static javax.swing.JMenu MnuEditarPersonagem;
    private javax.swing.JMenuItem MnuEditarPersonagemAparencia;
    private javax.swing.JMenuItem MnuEditarPersonagemLoja;
    private javax.swing.JMenuItem MnuEditarPersonagemScript;
    private javax.swing.JMenu MnuJogo;
    private javax.swing.JMenuItem MnuJogoCopilar;
    public static javax.swing.JMenuItem MnuJogoExecutar;
    private javax.swing.JMenu MnuJogoLocalhost;
    private javax.swing.JMenuItem MnuJogoLocalhostAtualizar;
    private javax.swing.JMenuItem MnuJogoLocalhostCompartilhar;
    private javax.swing.JMenuItem MnuJogoLocalhostSupervisionado;
    private javax.swing.JMenu MnuSistema;
    private javax.swing.JMenuItem MnuSistemaAlteracoes;
    private javax.swing.JMenuItem MnuSistemaAreaDeTeste;
    private javax.swing.JMenuItem MnuSistemaAtualizar;
    private static javax.swing.JMenuItem MnuSistemaConfiguracoes;
    private javax.swing.JMenuItem MnuSistemaDependencias;
    private javax.swing.JMenuItem MnuSistemaFechar;
    public static javax.swing.JProgressBar PgbBarra;
    private javax.swing.JPanel PnlBarraDeEstatus;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}

