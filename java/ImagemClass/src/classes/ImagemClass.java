/**
 * @author lunovox
 */

package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImagemClass {
    public ImagemClass(String EnderecoOuResource) {
        try{
            setImage((new ImageIcon(getClass().getResource(EnderecoOuResource))).getImage());
        }catch(NullPointerException E){
            setEndereco(EnderecoOuResource);
        }
    }
    public ImagemClass(BufferedImage NovaImagem) {
        setImage(NovaImagem);
    }
    public ImagemClass(Image NovaImagem) {
        setImage(NovaImagem);
    }
    public ImagemClass(URL Endereco) {
        ImageIcon Icone = new ImageIcon(Endereco);
        setImage(Icone.getImage());
    }
    public ImagemClass(ImageIcon Icone) {
        setImage(Icone.getImage());
    }

    BufferedImage Imagem;
    String ImagemEndereco="";

    public void setImage(BufferedImage NovaImagem) {
        ImagemEndereco="";
        Imagem = NovaImagem;
    }
    public void setImage(ImageIcon NovaImagem){
        setImage(NovaImagem.getImage());
    }
    public void setImage(Image NovaImagem) {
        BufferedImage Buff = new BufferedImage(NovaImagem.getWidth(null), NovaImagem.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = Buff.createGraphics();
        g.drawImage(NovaImagem, 0, 0, null);
        ImagemEndereco="";
        Imagem = Buff;
    }
    public BufferedImage getImage() {
        return Imagem;
    }
    public ImageIcon getIcone() {
        return new ImageIcon(Imagem);
    }
    public String getTipo(){
        String ParteDoEndereco[]=ImagemEndereco.split("\\.");
        return ParteDoEndereco[ParteDoEndereco.length-1].toLowerCase();
    }
    public String getEndereco() {
        return ImagemEndereco;
    }
    public void setEndereco(String Endereco) {
        try {
            File Arquivo = new File(Endereco);
            if(Arquivo.exists()){
                ImagemEndereco=Endereco;
                Imagem = ImageIO.read(Arquivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getLargura() {
        return Imagem.getWidth();
    }
    public void setLargura(int Largura) {
        setEsticar(Largura, Imagem.getHeight());
    }
    public int getAltura() {
        return Imagem.getHeight();
    }
    public void setAltura(int Altura) {
        setEsticar(Imagem.getWidth(), Altura);
    }
    public void setZoom(double Decimal) {
        Imagem=getZoom(Imagem,Decimal);
    }
    public BufferedImage getZoom(double Decimal) {
        return getZoom(Imagem, Decimal);
    }
    public BufferedImage getZoom(BufferedImage SuaImagem, double Decimal) {
        return getEsticar(SuaImagem, (int)(SuaImagem.getWidth()*Decimal), (int)(SuaImagem.getHeight()*Decimal));
    }
    public void setInverterHorizontal() {
        Imagem=getInverterHorizontal(Imagem);
    }
    public BufferedImage getInverterHorizontal(BufferedImage SuaImagem) {
        int Ponteiro=0,W=SuaImagem.getWidth(), H=SuaImagem.getHeight();
        int Matriz[] = new int[W * H];
        for (int L=0; L<W; L++) {
            for (int T=0; T<H; T++) {
                Ponteiro=(T*W)+(W-(L+1));
                Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
            }
        }
        SuaImagem.setRGB(0, 0, W, H, Matriz, 0, W);
        return SuaImagem;
    }
    public void setInverterVertical() {
        Imagem=getInverterVertical(Imagem);
    }
    public BufferedImage getInverterVertical(BufferedImage SuaImagem) {
        int Ponteiro=0,W=SuaImagem.getWidth(), H=SuaImagem.getHeight();
        int Matriz[] = new int[W * H];
        for (int T=0; T<H; T++) {
            for (int L=0; L<W; L++) {
                Ponteiro=W*(H-(T+1))+L;
                Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
            }
        }
        SuaImagem.setRGB(0, 0, W, H, Matriz, 0, W);
        return SuaImagem;
    }
    public void setEsticar(int Largura, int Altura) {
        Imagem=getEsticar(Imagem, Largura, Altura);
    }
    public BufferedImage getEsticar(BufferedImage SuaImagem, int Largura, int Altura) {
        if(Largura>=1 && Altura>=1){
            try{//Esse try Catch é necessário pq imagens indexadas não são esticáveis.
                BufferedImage ImagemDestino = new BufferedImage(Largura,Altura,SuaImagem.getType());
                Graphics2D g = ImagemDestino.createGraphics();
                g.drawImage(SuaImagem,AffineTransform.getScaleInstance((double)Largura/SuaImagem.getWidth(),(double)Altura/SuaImagem.getHeight()) , null);
                return ImagemDestino;
            }catch(IllegalArgumentException MeuErro){
                return SuaImagem;
            }
        }else{
            return SuaImagem;
        }
    }
    public void setMesclagem(BufferedImage NovaCamada){
        Imagem=getMesclagem(Imagem, NovaCamada,0,0);
    }
    public void setMesclagem(BufferedImage NovaCamada, int X, int Y){
        Imagem=getMesclagem(Imagem, NovaCamada,X,Y);
    }
    public BufferedImage getMesclagem(BufferedImage Fundo, BufferedImage NovaCamada){
        return getMesclagem(Fundo, NovaCamada, 0, 0);
    }
    public BufferedImage getMesclagem(BufferedImage Fundo, BufferedImage NovaCamada, int X, int Y) {
        int Xfundo, Yfundo, Xtopo, Ytopo, NewW, NewH;
        if(X<0){
            Xfundo=X*(-1);
            Xtopo=0;
            if(Xfundo+Fundo.getWidth()>Xfundo+NovaCamada.getWidth()){
                NewW=Xfundo+Fundo.getWidth();
            }else{
                NewW=Xfundo+NovaCamada.getWidth();
            }
        }else{
            Xfundo=0;
            Xtopo=X;
            if(Xtopo+Fundo.getWidth()>Xtopo+NovaCamada.getWidth()){
                NewW=Xtopo+Fundo.getWidth();
            }else{
                NewW=Xtopo+NovaCamada.getWidth();
            }
        }
        if(Y<0){
            Yfundo=Y*(-1);
            Ytopo=0;
            if(Yfundo+Fundo.getHeight()>Yfundo+NovaCamada.getHeight()){
                NewH=Yfundo+Fundo.getHeight();
            }else{
                NewH=Yfundo+NovaCamada.getHeight();
            }
        }else{
            Yfundo=0;
            Ytopo=Y;
            if(Ytopo+Fundo.getHeight()>Ytopo+NovaCamada.getHeight()){
                NewH=Ytopo+Fundo.getHeight();
            }else{
                NewH=Ytopo+NovaCamada.getHeight();
            }
        }
        BufferedImage novaImagem = new BufferedImage(NewW, NewH, Fundo.getType());
        //BufferedImage.TYPE_INT_RGB
        Graphics g = novaImagem.getGraphics();
        g.drawImage(Fundo, Xfundo, Yfundo, null);
        g.drawImage(NovaCamada, Xtopo, Ytopo, null);
        return novaImagem;
    }
    public void setCorte(int X, int Y, int Largura, int Altura) {
        Imagem=getCorte(Imagem, X, Y, Largura, Altura);
    }
    public BufferedImage getCorte(BufferedImage Camada, int X, int Y, int Largura, int Altura) {
        return Camada.getSubimage(X,Y,Largura,Altura);
    }
    public void setGirar90Antihorario() {
        Imagem=getGirar90Antihorario(Imagem);
    }
    public BufferedImage getGirar90Antihorario(BufferedImage SuaImagem) {
        int Ponteiro=0, W=SuaImagem.getWidth(), H=SuaImagem.getHeight();
        int Matriz[] = new int[W * H];
        for (int L=0; L<W; L++) {
            for (int T=0; T<H; T++) {
                Ponteiro=(H*(W-(L+1)))+T;
                Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
            }
        }
        BufferedImage ImagemDestino = new BufferedImage(H,W,SuaImagem.getType());
        ImagemDestino.setRGB(0, 0, ImagemDestino.getWidth(), ImagemDestino.getHeight(), Matriz, 0, ImagemDestino.getWidth());
        return ImagemDestino;
    }
    public void setGirar90Horario() {
        Imagem=getGirar90Horario(Imagem);
    }
    public BufferedImage getGirar90Horario(BufferedImage SuaImagem) {
        int Ponteiro=0, W=SuaImagem.getWidth(), H=SuaImagem.getHeight();
        int Matriz[] = new int[W * H];
        for (int L=0; L<W; L++) {
            for (int T=0; T<H; T++) {
                Ponteiro=(H*L)+(H-(T+1));
                Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
            }
        }
        BufferedImage ImagemDestino = new BufferedImage(SuaImagem.getHeight(),SuaImagem.getWidth(),SuaImagem.getType());
        ImagemDestino.setRGB(0, 0, ImagemDestino.getWidth(), ImagemDestino.getHeight(), Matriz, 0, ImagemDestino.getWidth());
        return ImagemDestino;
    }
    public void setRecolor(Color CorDestino) {
        Imagem=getRecolor(
            Imagem,
            new Color(0,0,0),
            new Color(255,255,255),
            CorDestino
        );
    }
    public void setRecolor(Color CorOrigemMin, Color CorOrigemMax, Color CorDestino) {
        Imagem=getRecolor(Imagem, CorOrigemMin, CorOrigemMax, CorDestino);
    }
    public BufferedImage getRecolor(BufferedImage SuaImagem, Color CorOrigemMin, Color CorOrigemMax, Color CorDestino) {
        //
        int Ponteiro=0, W=SuaImagem.getWidth(), H=SuaImagem.getHeight();
        int Matriz[] = new int[W * H];
        for (int T=0; T<H; T++) {
            for (int L=0; L<W; L++) {
                //Ponteiro=(H*L)+(H-(T+1));
                Ponteiro=(W*T)+L;
                Color Cor = new Color(SuaImagem.getRGB(L, T));
                if(Cor.getRed()>0 && Cor.getGreen()>0 && Cor.getBlue()>0){
                    if(
                        (Cor.getRed()> CorOrigemMin.getRed() && Cor.getRed()< CorOrigemMax.getRed()) ||
                        (Cor.getGreen()> CorOrigemMin.getGreen() && Cor.getGreen()< CorOrigemMax.getGreen()) ||
                        (Cor.getBlue()> CorOrigemMin.getBlue() && Cor.getBlue()< CorOrigemMax.getBlue())
                    ){
                        int red=Cor.getRed();
                        int green=Cor.getGreen();
                        int blue=Cor.getBlue();

                        if(Cor.getRed()>= CorOrigemMin.getRed() && Cor.getRed()<= CorOrigemMax.getRed()){
                            red=(CorDestino.getRed()+Cor.getRed())/2;
                        }
                        if(Cor.getGreen()>= CorOrigemMin.getGreen() && Cor.getGreen()<= CorOrigemMax.getGreen()){
                            green=(CorDestino.getGreen()+Cor.getGreen())/2;
                        }
                        if(Cor.getBlue()>= CorOrigemMin.getBlue() && Cor.getBlue()<= CorOrigemMax.getBlue()){
                            blue=(CorDestino.getBlue()+Cor.getBlue()) /2;
                        }
                        /*Matriz[Ponteiro]=
                            (red*(256^2))+
                            (green*(256^1))+
                            (blue*(256^0));/**/
                        Matriz[Ponteiro]=(new Color(red,green,blue)).getRGB();
                        //Matriz[Ponteiro]=(Cor.getRGB()+CorDestino.getRGB())/2;
                        //Matriz[Ponteiro]=Cor.getRGB();
                    }else{
                        Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
                        //Matriz[Ponteiro]=Cor.getRGB();
                        //SuaImagem.setRGB(L, T, Cor.getRGB());
                    }
                }else{
                    Matriz[Ponteiro]=SuaImagem.getRGB(L, T);
                    //Matriz[Ponteiro]=Cor.getRGB();
                }
            }
        }
        BufferedImage ImagemDestino = new BufferedImage(SuaImagem.getHeight(),SuaImagem.getWidth(),SuaImagem.getType());
        ImagemDestino.setRGB(0, 0, ImagemDestino.getWidth(), ImagemDestino.getHeight(), Matriz, 0, ImagemDestino.getWidth());
        return ImagemDestino;
    }
    public void Esportar(String Endereco){
        Esportar(Imagem, Endereco);
    }
    public void Esportar(BufferedImage SuaImagem, String Endereco){
        String ParteDoEndereco[]=Endereco.split("\\.");
        try {
            ImageIO.write(
                SuaImagem,
                (getTipo().equals("")?ParteDoEndereco[ParteDoEndereco.length-1]:getTipo()),
                new File(Endereco)
            );
        } catch (IOException ex) {
            //Logger.getLogger(SpriteDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
