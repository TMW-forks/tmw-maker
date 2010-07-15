
package Formularios;

import Classes.ImagemTratavel;
import Classes.jTtableImagemDeColuna;
import Classes.jTtableImagemDeCabecalho;
import Classes.SpriteDados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class FrmTestesDeCodigo extends javax.swing.JDialog {
    public FrmTestesDeCodigo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //TESTE-A RESOLVIDO
    public void Teste_A01(){
        java.awt.Image MinhaImagem = new ImageIcon("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png").getImage();
        /*java.awt.image.FilteredImageSource fis = new java.awt.image.FilteredImageSource(
            image.getSource(),
            new java.awt.image.CropImageFilter((int)(x), (int)(y), (int)w, (int)h)
        );
        image = null;
        image = java.awt.Toolkit.getDefaultToolkit().createImage(fis);/**/
        //BufferedImage aaa = new BufferedImage(MinhaImagem);
        /*BufferedImage aaa;
        aaa.

        BufferedImage clipping = new BufferedImage(width, height, originalImage.getType());
        Graphics2D area = (Graphics2D) clipping.getGraphics().create();
        area.drawImage(
            originalImage, 0, 0, clipping.getHeight(),
            clipping.getWidth(), x, y, x + clipping.getHeight(),
            y + clipping.getWidth(),
            null
        );
        area.dispose();/**/
    }
    public void Teste_A02(){
        try {
            BufferedImage image = ImageIO.read(new File("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png"));

            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage mascara = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics gr = mascara.createGraphics();
            gr.setColor(Color.BLACK);
            gr.fillRect(0, 0, width, height);
            gr.setColor(Color.WHITE);
            gr.fillOval(30, 30, 100, 100);  //aqui vai o desenho do poligono que você quer

            int pontos_img[] = new int[width * height];
            image.getRGB(0, 0, width, height, pontos_img, 0, width);

            int pontos_mask[] = new int[width * height];
            mascara.getRGB(0, 0, width, height, pontos_mask, 0, width);

            for (int i = 0; i < pontos_img.length; i++) {
                pontos_img[i] = pontos_img[i] & pontos_mask[i];

            }

            image.setRGB(0, 0, width, height, pontos_img, 0, width);

            ImageIO.write(image, "png", new File("/home/indigovox/Desktop/teste.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Teste_A03(){
        try {
            BufferedImage image = ImageIO.read(new File("/home/indigovox/Imagens/Papeis de Parede/Paisagens/Grama Verde.jpg"));

            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage mascara = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics gr = mascara.createGraphics();
            gr.setColor(Color.BLACK);
            gr.fillRect(0, 0, width, height);
            gr.setColor(Color.WHITE);
            //gr.fillOval(0, 0, 64, 64);  //aqui vai o desenho do poligono que você quer
            gr.fillRect(0, 0, 64, 64);  //aqui vai o desenho do poligono que você quer

            int pontos_img[] = new int[width * height];
            image.getRGB(0, 0, width, height, pontos_img, 0, width);

            int pontos_mask[] = new int[width * height];
            mascara.getRGB(0, 0, width, height, pontos_mask, 0, width);

            for (int i = 0; i < pontos_img.length; i++) {
                pontos_img[i] = pontos_img[i] & pontos_mask[i];

            }

            image.setRGB(0, 0, width, height, pontos_img, 0, width);
            //jLabel1.setIcon(new ImageIcon(image.getSubimage(0, 0, 64, 64)));
            jLabel1.setIcon(new ImageIcon(image));
            //ImageIO.write(image, "png", new File("/home/indigovox/Desktop/Teste_A03.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Teste_A04(){
        try {
            BufferedImage image = ImageIO.read(new File("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png"));
            jLabel1.setIcon(new ImageIcon(image.getSubimage(0, 0, 64, 64)));
            ImageIO.write(image.getSubimage(0, 0, 64, 64), "png", new File("/home/indigovox/Desktop/corte.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Teste_A05(){
        try {
            SpriteDados Sprite = new SpriteDados("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png",8,9);
            int Bloco=8;
            jLabel1.setIcon(new ImageIcon(Sprite.getBloco(Bloco)));
            Sprite.EsportarBloco(Bloco,"/home/indigovox/Desktop/corte.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Teste_A06(){
        try {
            SpriteDados Sprite = new SpriteDados("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png",8,9);
            int Bloco=8;
            ImagemTratavel BlocoImagem = new ImagemTratavel(Sprite.getBloco(Bloco));
            BlocoImagem.setCorte(0, 28, 64, 20);
            //BlocoImagem.setInverterHorizontal();
            //BlocoImagem.setInverterVertical();
            BlocoImagem.setEsticar(90,90);
            //BlocoImagem.setAltura(32);
            //BlocoImagem.setLargura(128);
            //BlocoImagem.setGirar90Antihorario();

            //BlocoImagem.setGirar90Horario();
            
            jLabel1.setIcon(new ImageIcon(BlocoImagem.getImage()));
            //Sprite.EsportarBloco(Bloco,"/home/indigovox/Desktop/corte.jpg");
            BlocoImagem.Esportar("/home/indigovox/Desktop/corte.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //Corta Sprite (OK!)

    //TESTE-B FALHOU
    public void Teste_B01(){
                //Como abrir um arquivo de testo rapido do computador?
        String Endereco = "/home/indigovox/localhost/tmwdata/items.xml";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(Endereco)));
            jTextArea1.setText(br.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Teste_B02(){
        //Como abrir um arquivo de testo rapido do computador?
        String Endereco = "/home/indigovox/localhost/tmwdata/items.xml";
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(Endereco);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        jTextArea1.setText(reader.toString());
    }
    public void Teste_B03(){
        String Endereco = "/home/indigovox/localhost/tmwdata/items.xml";
        File f = new File(Endereco);

        // Cria um arquivo mapeado no memória (somente leitura)
        FileChannel fcl = null;
        try {
            fcl = new RandomAccessFile(f, "r").getChannel();
            ByteBuffer bl = fcl.map(FileChannel.MapMode.READ_ONLY, 0, (int) fcl.size());
            FileChannel fcg = new RandomAccessFile(f, "rw").getChannel();
            ByteBuffer bg = fcg.map(FileChannel.MapMode.READ_WRITE, 0, (int)fcg.size());
            // Cria um arquivo mapeado no memória (leitura e gravação)

            jTextArea1.setText(bg.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void Teste_B04(){
        String Endereco = "/home/indigovox/localhost/tmwdata/items.xml";
        File Capsula;
        try {
            Capsula=new File(Endereco);
            Capsula.setExecutable(true);
            Capsula.setReadable(true);
            Capsula.setWritable(true);
            FileChannel Canal = new FileOutputStream(Capsula).getChannel();
            jTextArea1.setText(Canal.toString());
            /*FileChannel Origem = new FileInputStream(Capsula).getChannel();
            FileChannel Destino = new FileOutputStream(Capsula).getChannel();
            Origem.transferTo(0, Origem.size(),Destino);
            if (Origem != null && Origem.isOpen()) {
                Origem.close();
            }
            if (Destino != null && Destino.isOpen()) {
                Destino.close();
            }/**/
        } catch(IOException Exc){
            //
        }/**/
    }
    public void Teste_B05(){
        File Arquivo = new File("/home/indigovox/localhost/tmwdata/items.xml");
        String Conteudo="",Linha="";
        if (Arquivo.exists()) {
            try {
                BufferedReader Capsula = new BufferedReader(new FileReader(Arquivo));
                while ((Linha = Capsula.readLine()) != null) {
                    Conteudo+="\n"+Linha;
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }
        jTextArea1.setText(Conteudo);
    } // Chegou Proximo
    public void Teste_B06(){
        try {
            File Arquivo = new File("/home/indigovox/localhost/tmwdata/items.xml");
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();
            org.w3c.dom.Document scenarioDoc = DB.parse(Arquivo);
            jTextArea1.setText("'"+scenarioDoc.getTextContent()+"'");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
    }
    public void Teste_B07(){
        String src="/home/indigovox/Desktop/aaaaaa2.xml";
        boolean validate=true;
        File xmlFile = new File(src);
        String err = "";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(validate);
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.newDocument();
            doc = db.parse(xmlFile);
            err=doc.getTextContent().toString();
        } catch (ParserConfigurationException pce) {
            err = pce.toString();
        } catch (SAXParseException spe) {
            StringBuffer sb = new StringBuffer(spe.toString());
            sb.append("\n  Line number: " + spe.getLineNumber());
            sb.append("\n Column number: " + spe.getColumnNumber());
            sb.append("\n Public ID: " + spe.getPublicId());
            sb.append("\n System ID: " + spe.getSystemId() + "\n");
            err = sb.toString();
        } catch (SAXException se) {
            err = se.toString();
            if (se.getException() != null) {
                err += " caused by: " + se.getException().toString();
            }
        } catch (IOException ie) {
            err = ie.toString();
        } catch (NullPointerException spe) {
            StringBuffer sb = new StringBuffer(spe.toString());
            sb.append("\n Class: " + spe.getClass() + "\n");
            sb.append("\n Cause: " + spe.getCause() + "\n");
            sb.append("\n Message: " + spe.getMessage() + "\n");
            sb.append("\n LocalizedMessage(): " + spe.getLocalizedMessage() + "\n");
            err = sb.toString();
        }
        //return err;
        jTextArea1.setText(err.toString());

    }
    public void Teste_B08(){
        try {
            FileReader in = new FileReader("/home/indigovox/localhost/tmwdata/items.xml");
            String S = "";
            int i = in.read();
            while (i != -1) {
                S = S + (char) i;
                i = in.read();
            }
            jTextArea1.setText(S);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Mais demorado que o normal

    //TESTE-C RESOLVIDO
    public void Teste_C01(){
        //Como abrir um arquivo de testo que está na internet?

        /*String nom_arquivo  = null,
        nom_arquivo2 = null;
        nom_arquivo  = request.getParameter("nom_arquivo");
        nom_arquivo2 = request.getParameter("nom_arquivo2");

        String filename = nom_arquivo;
        String filepath = request.getRealPath("/")+"exportacoes/";

        FileInputStream inStream;
        try {
            inStream = new FileInputStream(filepath + filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
        OutputStream os=response.getOutputStream();

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment; filename=""+ nom_arquivo2 + """);
        response.setContentLength(inStream.available());/**/
    }
    public void Teste_C02(){
        /***********************************************************
         * Como abrir um arquivo de testo que está na internet? (Resolvido)
         **********************************************************/
         try {
            // Create a URL for the desired page
            String Endereco = "https://tmw-maker.googlecode.com/svn/trunk/java/TMW-Maker/src/Testos/news.html";
            URL arquivo = new URL(Endereco);

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(arquivo.openStream()));
            String str, Conteudo="";
            int contador=0;
            while ((str = in.readLine()) != null) {
                contador += 1;
                Conteudo+=(Conteudo.equals("")?str:"\n"+str);
            }
            in.close();
            jTextArea2.setText(Conteudo);
        } catch (IOException e) {
        }
    } //Carrega testo de internet (OK!)

    //TESTE-D RESOLVIDO
    public void Teste_D01(){
        Vector columnNames = new Vector();
        Vector data = new Vector();
        columnNames.addElement("Coluna 1");
        columnNames.addElement("Coluna 2");
        columnNames.addElement("Coluna 3");
        columnNames.addElement("Labe1");
        columnNames.addElement("Labe2");
        JLabel view = new JLabel("<html><u>View</u></html>");
        JLabel modify = new JLabel("<html><u>Modify</u></html>");

        int j = 1;

        String Dados[][] = new String [][] {{"A1", "B1", "C1"},{"A2", "B2", "C2"},{"A3", "B3", "C3"}};

        for (int i = 0; i < Dados.length; i++) {
            Vector temp = new Vector();
            temp.add(Dados[i][0]);
            temp.add(Dados[i][1]);
            temp.add(Dados[i][2]);
            temp.add(view);
            temp.add(modify);
            data.add(temp);
            j++;
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data,columnNames) {
            boolean[] canEdit = new boolean [] {false, false, false, true, true, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}

        });/**/

        jTable1.setPreferredScrollableViewportSize(new Dimension(350, 50));


        // define um TableCellRenderer para o primeiro título
        jTable1.getColumn("Coluna 2").setHeaderRenderer(new jTtableImagemDeCabecalho());
    }
    public void Teste_D02(){
        //////////////////////////////////////
        // Carregar Imagem em unica Celula  //
        //////////////////////////////////////
        
        Vector columnNames = new Vector();
        columnNames.addElement("Frame 1");
        columnNames.addElement("Frame 2");
        columnNames.addElement("Frame 3");

        SpriteDados Sprite = new SpriteDados("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png",8,9);
        ImageIcon Icone = new ImageIcon(Sprite.getBloco(8));
        ImageIcon Icone2 = new ImageIcon(Sprite.getBloco(0));
        ImageIcon Icone3 = new ImageIcon(Sprite.getBloco(999));
        Vector Dados = new Vector();
        Vector Linha[] = new Vector[3];

        Linha[0] = new Vector();
        Linha[0].addElement(Icone);
        Linha[0].addElement("<html><b>B1</b><br/><font size=\"-2\">(Oo)");//Se é um
        Linha[0].addElement("C1");
        Linha[1] = new Vector();
        Linha[1].addElement(Icone2);
        Linha[1].addElement("<html><font color=#008800 size=7><b>B2</b>");
        Linha[1].addElement(Icone3);
        Linha[2] = new Vector();
        Linha[2].addElement("A3");
        Linha[2].addElement("<html><img src=\"file:///home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png\">");
        Linha[2].addElement("<html><img src=\"http://hp.br.inter.net/ldferraz/perfil/fanlisting/haibane_touji.gif\">");

        Dados.addElement(Linha[0]);
        Dados.addElement(Linha[1]);
        Dados.addElement(Linha[2]);

        jTable1.setModel(new DefaultTableModel(Dados,columnNames) {
            boolean[] canEdit = new boolean [] {true, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        });

        
        jTable1.setRowHeight(0, Icone.getIconHeight());
        jTable1.setRowHeight(1, Icone.getIconHeight());
        jTable1.setRowHeight(2, Icone.getIconHeight());

        TableColumn Coluna1=jTable1.getTableHeader().getColumnModel().getColumn(0);
        Coluna1.setCellRenderer(new jTtableImagemDeColuna());
        Coluna1.setMinWidth(Icone.getIconHeight());
        //Coluna1.setMaxWidth(Icone.getIconHeight());

        TableColumn Coluna2=jTable1.getTableHeader().getColumnModel().getColumn(1);
        Coluna2.setHeaderRenderer(new jTtableImagemDeCabecalho());// Define imagem para Cabeçalho
        Coluna2.setCellRenderer(new jTtableImagemDeColuna());// Define imagem para cada Celula desta Coluna
        Coluna2.setMinWidth(Icone.getIconHeight());
        //Coluna2.setMaxWidth(Icone.getIconHeight());
        
        TableColumn Coluna3=jTable1.getTableHeader().getColumnModel().getColumn(2);
        Coluna3.setCellRenderer(new jTtableImagemDeColuna());
        Coluna3.setMinWidth(Icone.getIconHeight());
        //Coluna3.setMaxWidth(Icone.getIconHeight());
    } // Colocar Imagem em jTable editada por Vetores (OK!)

    //TESTE-E FALHOU
    public void Teste_E01(){
        /*String Testo = jEditorPane1.getText();
        Testo=Testo.replaceAll("script", "<font color=\"#0000FF\">script</font>");      
        jEditorPane1.setText(Testo);/**/
    }
    public void Teste_E02(){
        /*//int Cursor = jEditorPane1.getCaretPosition();
        int Cursor = jEditorPane1.getSelectionStart();
        String Testo="script", Tag1="<font color=\"#0000FF\"><b>", Tag2="</b></font>";
        String Parte1="", Parte2="";
        String Procurado1 = Testo;
        String Procurado2 = Tag1+Testo;
        int ProcuradoTamanho1 = Procurado1.length();
        int ProcuradoTamanho2 = Procurado2.length();
        String Corpo=jEditorPane1.getText();
        if(Cursor>=ProcuradoTamanho1 && Cursor>=ProcuradoTamanho2 && Cursor-ProcuradoTamanho1<=Corpo.length() && Cursor-ProcuradoTamanho2<=Corpo.length()){
            String Achado1=Corpo.substring(Cursor-ProcuradoTamanho1, Cursor);
            String Achado2=Corpo.substring(Cursor-ProcuradoTamanho2, Cursor);
            if(Achado1.equals(Procurado1) && !Achado2.equals(Procurado2)){
                jEditorPane1.setSelectionStart(Cursor);
                jEditorPane1.setSelectionEnd(Cursor+ProcuradoTamanho1);
                jEditorPane1.setSelectionColor(Color.red);
                /*try {
                    Parte1 = jEditorPane1.getText(0, Cursor + 1);
                    Parte2=jEditorPane1.getText(Cursor+Testo.length(), jEditorPane1.getText().length());
                    jEditorPane1.setText(Parte1+Tag1+Testo+Tag2+Parte2);
                } catch (BadLocationException ex) {
                    Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }/**/
    }
    public void Teste_E03(){
        if(TxpCodificador.getText().equals("")){
            TxpCodificador.setText(
                "_inicio:\n"+
                "\tmes \"[Bardo do Deserto]\";\n"+
                "\tmes \"\\\"Teste de script colorido!\\\"\";\n"+
                "close;\n"
            );
        }

        String Testo =TxpCodificador.getText();
        Testo=Testo.replaceAll("script", "<font color=\"#0000FF\"><b>script</b></font>");
        //Testo=Testo.replaceAll("\n", "<br>");
        //Testo=Testo.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        
        try{
            //TxpCodificador.setContentType("text/html");
            //TxpCodificador.setText(Testo);
        }catch(IllegalStateException Err){
            
        }
        //TxaCodigo.setText(Testo);
        //jEditorPane1.setContentType("text/plain");

    }
    public void AddCodigo(){
        String Testo =
            "_inicio:\n"+
            "\tmes \"[Bardo do Deserto]\";\n"+
            "\tmes \"\\\"Teste de script colorido!\\\"\";\n"+
            "close;\n";
        Testo=Testo.replaceAll("\n", "<br>");
        Testo=Testo.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        TxpCodificador.setText(Testo);
    }
    public void Autoformatar(){
        int Cursor = TxpCodificador.getCaretPosition();
        String Testo =TxpCodificador.getText();
        Testo=Testo.replaceAll("script", "<font color=\"#0000FF\"><b>script</b></font>");
        TxpCodificador.setText(Testo);
        TxpCodificador.setCaretPosition(Cursor);
    }
    public void Autoformatar2(){
        String[] initString =
            { "script" };

        String[] initStyles =
                { "bold" };

        //JTextPane textPane = new JTextPane();
        //StyledDocument doc = textPane.getStyledDocument();
        StyledDocument doc = TxpCodificador.getStyledDocument();
        //addStylesToDocument(doc);

        //Load the text pane with styled text.
        try {
            for (int i=0; i < initString.length; i++) {
                doc.insertString(doc.getLength(), initString[i], doc.getStyle(initStyles[i]));
            }
        } catch (BadLocationException ble) {
            System.err.println("Couldn't insert initial text into text pane.");
        }
    }
    public String Desformatar(String Testo){
        Testo=Testo.replaceAll("<html>\n", "");
        Testo=Testo.replaceAll("  <head>\n    \n  </head>\n", "");
        Testo=Testo.replaceAll("  <body>\n", "");
        Testo=Testo.replaceAll("  </body>\n", "");
        Testo=Testo.replaceAll("</html>\n", "");
        Testo=Testo.replaceAll("<font color=\"#0000FF\">", "");
        Testo=Testo.replaceAll("</font>", "");
        Testo=Testo.replaceAll("<b>", "");
        Testo=Testo.replaceAll("</b>", "");
        Testo=Testo.replaceAll("&quot;", "\"");
        Testo=Testo.replaceAll("&#160;", " ");
        Testo=Testo.replaceAll("<br>", "\n");
        Testo=Testo.replaceAll("&nbsp;", " ");
        return Testo;
    }
    public String Desformatar2(String Testo){
        JEditorPane ep1 = new JEditorPane("text/plain", Testo);
        //return ep1.getEditorKitForContentType("text/html").;
        //ep1.getEditorKitForContentType("text/plain").deinstall(ep1);
        //ep1.setSelectionStart(0);
        //ep1.setSelectionEnd();
        //ep1.registerEditorKitForContentType("text/html", ep1);
        return ep1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxpCodificador = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxaCodigo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Área em Desenvolvimento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setText("Testo de URL (Resolvido):");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Testo de Rápida leitura: (Falha)");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/Botoes/sbl_char.png"))); // NOI18N
        jLabel1.setText("Imagem Cortada (Semi-resolvido)");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grupo 01", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A1", "B1", "C1"},
                {"A2", "B2", "C2"},
                {"A3", "B3", "C3"}
            },
            new String [] {
                "Coluna 1", "Coluna 2", "Coluna 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public void setImgemColuna(int Coluna, ImageIcon Imagem) {
                //return canEdit [columnIndex];
                SpriteDados MeuSprite = new SpriteDados("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png",8,9);
                ImageIcon Icone = new ImageIcon(MeuSprite.getBloco(0));
                jTable1.getTableHeader().getColumnModel().getColumn(Coluna).setCellRenderer(new Classes.jTtableImagemDeColuna());
                jTable1.setRowHeight(0, Icone.getIconHeight());
                jTable1.getTableHeader().getColumnModel().getColumn(Coluna).setMinWidth(Icone.getIconHeight());
                jTable1.getTableHeader().getColumnModel().getColumn(Coluna).setMaxWidth(Icone.getIconHeight());
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grupo 02", jPanel2);

        TxpCodificador.setContentType("text/html");
        TxpCodificador.setFont(new java.awt.Font("Monospaced", 0, 13));
        TxpCodificador.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxpCodificadorCaretUpdate(evt);
            }
        });
        TxpCodificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxpCodificadorKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(TxpCodificador);

        TxaCodigo.setColumns(20);
        TxaCodigo.setRows(5);
        jScrollPane4.setViewportView(TxaCodigo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Editor de Codigos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       //Teste_A06(); //Corta Sprite
       //Teste_B08(); //Carrega testo de computador rapidamente
       //Teste_C02(); //Carrega testo de internet
       //Teste_D02(); //Colocar Imagem em jTable editada por Vetores
       //Teste_E03(); //Colorir corretamente um jTextPane

       AddCodigo(); Autoformatar();
       TxaCodigo.setText(Desformatar(TxpCodificador.getText()));
       //TxaCodigo.setText(TxpCodificador.getText().intern());

    }//GEN-LAST:event_formWindowOpened

    private void TxpCodificadorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxpCodificadorCaretUpdate
        
    }//GEN-LAST:event_TxpCodificadorCaretUpdate

    private void TxpCodificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxpCodificadorKeyReleased
        Autoformatar();
    }//GEN-LAST:event_TxpCodificadorKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmTestesDeCodigo dialog = new FrmTestesDeCodigo(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea TxaCodigo;
    private javax.swing.JTextPane TxpCodificador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

}
