
package Formularios;

import Classes.BancoDeDados.Banco_NPCs;
import Classes.ConfigClass;
import Classes.BancoDeDados.Banco_Itens;
import Classes.XmlDeEquip.XMLdeEquip;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
    }
    static String ComponenteSelecionado = "";
    public static ConfigClass Config = new ConfigClass();
    static String Barra = System.getProperty("file.separator");
    static Banco_Itens Itens; // será instaciado em WindowOpened(java.awt.event.WindowEvent evt) por precisar de uma barra de contagem
    static Banco_NPCs NPCs; // será instaciado em WindowOpened(java.awt.event.WindowEvent evt) por precisar de uma barra de contagem
    //public static String SpritePNG=""; // É esado em FrmEquipXML***
    static XMLdeEquip xmlEditada; // É usado em FrmEquipXML***

    public static void setAvisoEmEstatus(String Aviso) {
        System.out.println(Aviso.toString());
        LblEstatus.setText(Aviso.toString());
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


                FrmPrincipal.PgbBarra.setIndeterminate(true);
                FrmPrincipal.PgbBarra.setString("Baixando...");
                FrmPrincipal.setAvisoEmEstatus("Baixando atualização...");
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                String Destino=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmw-maker";
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
                    Link=Config.getConexaoLocalhost()+Barra+ "tmw-maker"+Barra+ "TMW-Maker.jar";
                    Simbolo=System.getProperty("user.home")+Barra+"Desktop";
                    if(Config.SeExiste(Simbolo)) Config.Apagar(Simbolo+Barra+"TMW-Maker.jar");
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
                        ConfigClass.Mensagem_Erro(
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
                FrmPrincipal.Config.setAtualizacaoAgora();
                FrmPrincipal.Config.ConfiguracoesGravar();
                FrmPrincipal.PgbBarra.setString("Concluido!");


                FrmPrincipal.PgbBarra.setIndeterminate(false);

                MnuSistema.setEnabled(true);
                MnuEditar.setEnabled(true);
                MnuJogo.setEnabled(true);
                MnuAjuda.setEnabled(true);

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
        FrmSplash.setVisible(true);/**/
    }
    public void MontarLocalhost() {
        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o windows!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
        } else if (System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0) {
            int R = JOptionPane.YES_OPTION;
            if(Config.getSeDependenciaDeGCC()){
                if (Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server") ||
                        Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server") ||
                        Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server")) {
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


                            Runtime Executador = Runtime.getRuntime();
                            String line = "", Comando = "";
                            String OS = System.getProperty("os.name").toLowerCase();
                            String Arch = System.getProperty("os.arch").toLowerCase();
                            boolean BinariosEspecificos = false;
                            int Baixados = 0;

                            PgbBarra.setIndeterminate(true);
                            PgbBarra.setString("Apagando...");
                            setAvisoEmEstatus("Apagando binários...");
                            if (Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "bins")) {
                                Config.Apagar(Config.getConexaoLocalhost() +Barra+ "bins");
                            }
                            Config.Apagar(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server");
                            Config.Apagar(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server");
                            Config.Apagar(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server");

                            PgbBarra.setString("Preparando...");
                            setAvisoEmEstatus("Preparando para baixar binários novos...");
                            if (OS.indexOf("linux") >= 0 && Arch.indexOf("i386") >= 0) {
                                Comando = "svn checkout " +
                                        "http://tmw-maker.googlecode.com/svn/bins/" + OS + "/" + Arch + " " +
                                        FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins";
                                BinariosEspecificos = true;
                                System.out.println(Comando);
                                //ConfigClass.Mensagem_Erro(Comando,"Nota de Programador");
                            } else {
                                Comando = "svn checkout " +
                                        "http://tmw-maker.googlecode.com/svn/bins/compiler " +
                                        FrmPrincipal.Config.getConexaoLocalhost() +Barra+ "bins";
                                BinariosEspecificos = false;
                                System.out.println(Comando);
                                //ConfigClass.Mensagem_Erro(Comando,"Nota de Programador");
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
                                ConfigClass.Mensagem_Erro(
                                    "<html><b>O TMW-Maker não conseguiu baixar os binários:</b><br/><br/>" +
                                    "01: <font face=\"monospace\" color=\"#FF0000\">" + Comando + "</font><br/>" +
                                    "</html>",
                                    "ERRO DE EXECUÇÃO"
                                );
                            }
                            if (BinariosEspecificos == true) {
                                PgbBarra.setString("Deslocando...");
                                if (!Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server")) {
                                    Config.MoverArquivo(
                                            Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "char-server",
                                            Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "char-server");
                                    setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">char-server</font>...");
                                }
                                if (!Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server")) {
                                    Config.MoverArquivo(
                                            Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "login-server",
                                            Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "login-server");
                                    setAvisoEmEstatus("<html>Deslocando <font color=\"#0000FF\">login-server</font>...");
                                }
                                if (!Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server")) {
                                    Config.MoverArquivo(
                                            Config.getConexaoLocalhost() +Barra+ "bins" +Barra+ "map-server",
                                            Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "map-server");
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
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "conf",
                                Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "save"
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
                                if (Config.SeExiste(Pasta[r] +Barra+ De[r])) {
                                    if (Config.SeExiste(Pasta[r] +Barra+ Para[r])) {
                                        Config.Apagar(Pasta[r] +Barra+ Para[r]);
                                        setAvisoEmEstatus("<html><font color=\"#FF0000\"><b>Apagando:</b></font> \"" + Para[r] + "\"!");
                                    }
                                    setAvisoEmEstatus("<html><b>Renomeando:</b> \"" + De[r] + "\" -> \"" + Para[r] + "\"...");
                                    Config.MoverArquivo(Pasta[r] +Barra+ De[r], Pasta[r] +Barra+ Para[r]);
                                }
                            }

                            if(!Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log")) {
                                setAvisoEmEstatus("<html><b>Criando Pasta:</b> \"" + Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log\"...");
                                Config.CriarPasta(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "log");
                            }

                            /*
                            Criar pasta de ~/localhost/eathena-data/log
                            gcc -o eathena-monitor eathena-monitor.c
                            /**/
                            if(!Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor")) {
                                PgbBarra.setString("Copilando...");
                                setAvisoEmEstatus("Copilando binário \"eathena-monitor\"...");
                                Comando="gcc -o "+
                                    Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor "+
                                    Config.getConexaoLocalhost() +Barra+ "eathena-data" +Barra+ "eathena-monitor.c";
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
                                    ConfigClass.Mensagem_Erro(
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
                            if(Config.SeExiste(System.getProperty("user.home")+Barra+"tmwserver")) {
                                Config.Apagar(System.getProperty("user.home")+Barra+"tmwserver");
                            }
                            PgbBarra.setString("Coligando...");
                            setAvisoEmEstatus("Criando link \""+System.getProperty("user.home")+Barra+"tmwserver\"...");
                            Comando="ln -s "+
                                Config.getConexaoLocalhost()+Barra+ "eathena-data"+" "+
                                System.getProperty("user.home")+Barra+"tmwserver";
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
                                ConfigClass.Mensagem_Erro(
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
                ConfigClass.Mensagem_Erro("<html>"+
                    "Esta função possui a <font face=\"monospace\" color=\"#FF0000\">dependencia</font> do comando GCC!",
                    "ERRO DE EXECUÇÃO"
                );
            }
        }
    }
    public void ExecutarJogo(){
        if (Config.getOS().indexOf("win") >= 0) {
            /*String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = URL;
            Executador.exec(cmd);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o windows!", "Descupe!");
            //C:\cygwin\cygwin.exe
            //C:\Arquivos de programas\Mana\mana.exe
        } else if (Config.getOS().indexOf("mac") >= 0) {
            //Executador.exec("open " + URL);
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!", "Descupe!");
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
                            ConfigClass.Mensagem_Erro("<html><b>O TMW-Maker não conseguiu reiniciar o eathena:</b><br/><br/>" +
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
                    //ConfigClass.Mensagem_Erro("<html>Comando:<br/>"+Comando,"TESTE DE PROGRAMADOR");
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
                            ConfigClass.Mensagem_Erro("<html>"+
                                "O TMW-Maker <b>não encotrou o aplicativo</b> \"<font face=\"monospace\" color=\"#FF0000\"><b>MANA</b></font>\".<br/>" +
                                "Substituindo por aplicativo \"<font face=\"monospace\" color=\"#0000FF\"><b>TMW</b></font>\"..." +
                                "</html>",
                                "ERRO DE EXECUÇÃO"
                            );
                            ExecutarJogo();
                        }else if(Config.getExecucaoComando().equals("tmw") && !Config.getSeDependenciaDeTMW() && Config.getSeDependenciaDeManaplus()){
                            Config.setExecucaoComando("manaplus");
                            Config.ConfiguracoesGravar();
                            ConfigClass.Mensagem_Erro("<html>"+
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
                            ConfigClass.Mensagem_Erro(
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
                            ConfigClass.Mensagem_Erro("<html><b>O TMW-Maker não conseguiu desligar o eathena:</b><br/><br/>" +
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
                            return;
                        }
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
    }
    public void VerificarMenus() {
        if (Config.getOS().indexOf("win") >= 0 || Config.getOS().indexOf("mac") >= 0) {
            MnuLocalhost.setEnabled(false);
            MnuLocalhost.setEnabled(false);
            MnuEditarContas.setEnabled(false);
            MnuEditarItens.setEnabled(false);
            //MnuEditarPersonagemScript.setEnabled(false);
        } else {
            if (Config.getSeDependenciaDeSVN()) {
                MnuLocalhost.setEnabled(true);
                //MnuSistemaEnviar.setEnabled(true);
            } else {
                MnuLocalhost.setEnabled(false);
                MnuLocalhost.setEnabled(false);
            }
            //MnuJogoMontar.setEnabled(Config.SeExiste(Config.getConexaoLocalhost() +Barra+ "eathena-data"));
            MnuEditarContas.setEnabled(Config.getSeDependenciaDeMontagem());
            MnuEditarItens.setEnabled(Config.getSeDependenciaDeMontagem());
            //MnuEditarPersonagemScript.setEnabled(Config.getSeDependenciaDeMontagem());
        }
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
        jSeparator5 = new javax.swing.JSeparator();
        MnuLocalhost = new javax.swing.JMenuItem();
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

        PnlBarraDeEstatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PnlBarraDeEstatus.setAlignmentX(0.0F);
        PnlBarraDeEstatus.setAlignmentY(0.0F);

        LblEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_tmw.png"))); // NOI18N
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
                .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlBarraDeEstatusLayout.setVerticalGroup(
            PnlBarraDeEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
            .addComponent(PgbBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Fundos/tela_1028x1024.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

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
        MnuSistemaConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_chaveinglesa.gif"))); // NOI18N
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

        MnuEditarItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_espada.gif"))); // NOI18N
        MnuEditarItens.setMnemonic('I');
        MnuEditarItens.setText("Itens");

        MnuEditarItensSprites.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarItensSprites.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_xml.gif"))); // NOI18N
        MnuEditarItensSprites.setMnemonic('S');
        MnuEditarItensSprites.setText("Sprites e XML");
        MnuEditarItensSprites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarItensSpritesActionPerformed(evt);
            }
        });
        MnuEditarItens.add(MnuEditarItensSprites);

        MnuEditarItensDados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarItensDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script_bloco.gif"))); // NOI18N
        MnuEditarItensDados.setMnemonic('D');
        MnuEditarItensDados.setText("Dados");
        MnuEditarItensDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEditarItensDadosActionPerformed(evt);
            }
        });
        MnuEditarItens.add(MnuEditarItensDados);

        MnuEditar.add(MnuEditarItens);

        MnuEditarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_terreno.gif"))); // NOI18N
        MnuEditarCampos.setMnemonic('C');
        MnuEditarCampos.setText("Campos");
        MnuEditarCampos.setEnabled(false);

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
        MnuEditarPersonagem.setText("Personagem (NPC)");

        MnuEditarPersonagemAparencia.setMnemonic('A');
        MnuEditarPersonagemAparencia.setText("Aparencia");
        MnuEditarPersonagemAparencia.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemAparencia);

        MnuEditarPersonagemLoja.setMnemonic('L');
        MnuEditarPersonagemLoja.setText("Loja");
        MnuEditarPersonagemLoja.setEnabled(false);
        MnuEditarPersonagem.add(MnuEditarPersonagemLoja);

        MnuEditarPersonagemScript.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        MnuEditarPersonagemScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_script.png"))); // NOI18N
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

        MnuEditarMagias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_arvore.gif"))); // NOI18N
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

        MnuJogoExecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        MnuJogoExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_tmw.png"))); // NOI18N
        MnuJogoExecutar.setMnemonic('E');
        MnuJogoExecutar.setText("Executar");
        MnuJogoExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuJogoExecutarActionPerformed(evt);
            }
        });
        MnuJogo.add(MnuJogoExecutar);
        MnuJogo.add(jSeparator5);

        MnuLocalhost.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        MnuLocalhost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_localhost-tmw.png"))); // NOI18N
        MnuLocalhost.setMnemonic('L');
        MnuLocalhost.setText("Localhost");
        MnuLocalhost.setEnabled(false);
        MnuLocalhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuLocalhostActionPerformed(evt);
            }
        });
        MnuJogo.add(MnuLocalhost);

        jMenuBar1.add(MnuJogo);

        MnuAjuda.setMnemonic('A');
        MnuAjuda.setText("Ajuda");

        MnuAjudaComponentes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MnuAjudaComponentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/ajuda.gif"))); // NOI18N
        MnuAjudaComponentes.setMnemonic('P');
        MnuAjudaComponentes.setText("Componentes");
        MnuAjuda.add(MnuAjudaComponentes);

        MnuAjudaIndicarDefeito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        MnuAjudaIndicarDefeito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/fechar.png"))); // NOI18N
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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE)
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
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        VerificarMenus();
        if(FrmPrincipal.Config.getOS().indexOf("linux") >= 0) {
            if(FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
                if(FrmPrincipal.Config.getSeDependenciaDeSVN()){
                    if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                        if(ConfigClass.getAgora()>=FrmPrincipal.Config.getAtualizacao()+FrmPrincipal.Config.getAtualizacaoIntervalo()){
                            Atualizar();
                        }
                        if(!(FrmPrincipal.Itens instanceof Classes.BancoDeDados.Banco_Itens)){
                            MostrarDeSplash();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_formWindowActivated
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
    private void MnuLocalhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuLocalhostActionPerformed
        javax.swing.JDialog FrmCheckout = new FrmLocalhost(this, rootPaneCheckingEnabled);
        FrmCheckout.setLocation(
                ((this.getWidth() - FrmCheckout.getWidth()) / 2) + this.getX(),
                ((this.getHeight() - FrmCheckout.getHeight()) / 2) + this.getY());
        FrmCheckout.pack();
        FrmCheckout.setModal(true);
        FrmCheckout.setVisible(true);/**/
}//GEN-LAST:event_MnuLocalhostActionPerformed
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
    }//GEN-LAST:event_formWindowOpened
    private void MnuSistemaAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuSistemaAtualizarActionPerformed
        if (FrmPrincipal.Config.getOS().indexOf("win") >= 0) {
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o WINDOWS!","Descupe!");
        } else if (FrmPrincipal.Config.getOS().indexOf("mac") >= 0) {
            /*Executador.exec("open " + URL);/**/
            ConfigClass.Mensagem_Erro("Este comando ainda não foi implementado para o MAC!","Descupe!");
        } else {
            if(FrmPrincipal.Config.getSeDependenciaDeConfiguracao()){
                if(FrmPrincipal.Config.getSeDependenciaDeSVN()){
                    if(FrmPrincipal.Config.getSeDependenciaDeLocalhost()){
                        Atualizar();
                    }else{
                        ConfigClass.Mensagem_Erro("Para atualizar é necessário atender a dependência de Localhost!","ERRO");
                    }
                }else{
                    ConfigClass.Mensagem_Erro("Para atualizar é necessário atender a dependência de SNV!","ERRO");
                }
            }else{
                ConfigClass.Mensagem_Erro("Para atualizar é necessário atender a dependência de Configuração!","ERRO");
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
    private javax.swing.JMenuItem MnuAjudaComponentes;
    private javax.swing.JMenuItem MnuAjudaIndicarDefeito;
    private javax.swing.JMenuItem MnuAjudaSobre;
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
    public static javax.swing.JMenuItem MnuJogoExecutar;
    private javax.swing.JMenuItem MnuLocalhost;
    private javax.swing.JMenu MnuSistema;
    private javax.swing.JMenuItem MnuSistemaAlteracoes;
    private javax.swing.JMenuItem MnuSistemaAreaDeTeste;
    private javax.swing.JMenuItem MnuSistemaAtualizar;
    private javax.swing.JMenuItem MnuSistemaConfiguracoes;
    private javax.swing.JMenuItem MnuSistemaDependencias;
    private javax.swing.JMenuItem MnuSistemaFechar;
    public static javax.swing.JProgressBar PgbBarra;
    private javax.swing.JPanel PnlBarraDeEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
