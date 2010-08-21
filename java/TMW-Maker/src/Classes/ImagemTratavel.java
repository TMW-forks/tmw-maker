
package Classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImagemTratavel {
    public ImagemTratavel(String Endereco) {
        setEndereço(Endereco);
    }
    public ImagemTratavel(BufferedImage NovaImagem) {
        setImage(NovaImagem);
    }
    public ImagemTratavel(URL Resource) {
        setEndereço(Resource.getFile());
    }

    BufferedImage Imagem;
    String ImagemEndereco="";

    public void setImage(BufferedImage NovaImagem) {
        ImagemEndereco="";
        Imagem = NovaImagem;
    }
    public BufferedImage getImage() {
        return Imagem;
    }
    public String getTipo(){
        String ParteDoEndereco[]=ImagemEndereco.split("\\.");
        return ParteDoEndereco[ParteDoEndereco.length-1].toLowerCase();
    }
    public String getEndereço() {
        return ImagemEndereco;
    }
    public void setEndereço(String Endereco) {
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
        BufferedImage novaImagem = new BufferedImage(Fundo.getWidth(), Fundo.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = novaImagem.getGraphics();
        g.drawImage(Fundo, 0, 0, null);
        g.drawImage(NovaCamada, X, Y, null);
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


}
