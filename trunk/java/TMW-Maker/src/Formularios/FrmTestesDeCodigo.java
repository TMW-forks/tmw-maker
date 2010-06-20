/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmTestesDeCodigo.java
 *
 * Created on 19/06/2010, 23:49:26
 */

package Formularios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FrmTestesDeCodigo extends javax.swing.JDialog {

    /** Creates new form FrmTestesDeCodigo */
    public FrmTestesDeCodigo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

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
            BufferedImage image = ImageIO.read(new File("/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.png"));

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
            jLabel1.setIcon(new ImageIcon(image.getSubimage(0, 0, 64, 64)));
            //ImageIO.write(image, "png", new File("/home/indigovox/Desktop/teste.png"));

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

    public void Teste_B01(){
                //Como abrir um arquivo de testo rapido do computador?
        String Endereco = "/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.xml";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(Endereco)));
            jTextArea1.setText(br.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmTestesDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Teste_B02(){
        //Como abrir um arquivo de testo rapido do computador?
        String Endereco = "/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.xml";
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
        String Endereco = "/home/indigovox/localhost/tmwdata/graphics/sprites/player_male_base.xml";
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
            String Endereco = "http://themanaworld-br.googlecode.com/svn/updates/news.txt";
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setText("Testo de URL (Resolvido):");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Testo de Rápida leitura: (Falha)");

        jLabel1.setText("Imagem Cortada (Semi-resolvido)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       Teste_A04();
       //Teste_B03();
       Teste_C02();
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

}
