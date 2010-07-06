
package Classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpriteDados {
    public SpriteDados(String Endereco, int Linhas, int Colunas) {
        try {
            File Arquivo = new File(Endereco);
            if(Arquivo.exists()){
                SpriteEndereco=Endereco;
                SpriteLinhas=Linhas;
                SpriteColunas=Colunas;
                Sprite = ImageIO.read(Arquivo);
                BlocoLargura=Sprite.getWidth()/Colunas;
                BlocoAltura=Sprite.getHeight()/Linhas;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // S� executa de for instaciado como objeto
    public SpriteDados(String Endereco) {
        try {
            File Arquivo = new File(Endereco);
            if(Arquivo.exists()){
                SpriteEndereco=Endereco;
                SpriteLinhas=1;
                SpriteColunas=1;
                Sprite = ImageIO.read(Arquivo);
                BlocoLargura=Sprite.getWidth();
                BlocoAltura=Sprite.getHeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // S� executa de for instaciado como objeto
    public SpriteDados(BufferedImage Imagem, int Linhas, int Colunas) {
        SpriteEndereco="";
        SpriteLinhas=Linhas;
        SpriteColunas=Colunas;
        Sprite = Imagem;
        BlocoLargura=Sprite.getWidth()/Colunas;
        BlocoAltura=Sprite.getHeight()/Linhas;
    } // S� executa de for instaciado como objeto
    public SpriteDados(BufferedImage Imagem) {
        SpriteEndereco="";
        SpriteLinhas=1;
        SpriteColunas=1;
        Sprite = Imagem;
        BlocoLargura=Sprite.getWidth();
        BlocoAltura=Sprite.getHeight();
    } // S� executa de for instaciado como objeto
    
    BufferedImage Sprite;
    String SpriteEndereco="";
    int SpriteLinhas=0;
    int SpriteColunas=0;
    int BlocoLargura=0;
    int BlocoAltura=0;

    public BufferedImage getSprite(){
        return Sprite;
    }
    public String getSpriteEndereco(){
        return SpriteEndereco;
    }
    public String getSpriteTipo(){
        String ParteDoEndereco[]=SpriteEndereco.split("\\.");
        return ParteDoEndereco[ParteDoEndereco.length-1].toLowerCase();
    }
    public int getSpriteLinhas(){
        return SpriteLinhas;
    }
    public int getSpriteColunas(){
        return SpriteColunas;
    }
    public void setSpriteLinhas(int Linhas){
        SpriteLinhas=Linhas;
        BlocoAltura=Sprite.getHeight()/SpriteLinhas;
    }
    public void setSpriteColunas(int Colunas){
        SpriteColunas=Colunas;
        BlocoLargura=Sprite.getWidth()/SpriteColunas;
    }
    public int getSpriteLargura(){
        return Sprite.getWidth();
    }
    public int getSpriteAltura(){
        return Sprite.getHeight();
    }
    public BufferedImage getBloco(int Numero){
        if(Numero<0) Numero=0;
        if(Numero>(SpriteLinhas*SpriteColunas)-1) Numero=(SpriteLinhas*SpriteColunas)-1;
        int Linha=0;
        int Coluna=0;
        if(Numero>=SpriteColunas){
            Linha=Numero/SpriteColunas;
            Coluna=Numero%SpriteColunas;
        }else{
            Linha=0;
            Coluna=Numero;
        }
        return getBloco(Linha,Coluna);
    }
    public BufferedImage getBloco(int Linha, int Coluna){
        if(Linha<0 ) Linha=0;
        if(Linha>SpriteLinhas) Linha=SpriteLinhas-1;
        if(Coluna<0 ) Coluna=0;
        if(Coluna>SpriteColunas) Coluna=SpriteColunas-1;
        return Sprite.getSubimage(
            BlocoLargura*Coluna,
            BlocoAltura*Linha,
            BlocoLargura,
            BlocoAltura
        );
    }
    public int getBlocoLargura(){
        return BlocoLargura;
    }
    public int getBlocoAltura(){
        return BlocoAltura;
    }
    public void EsportarBloco(int Bloco, String Endereco){
        String ParteDoEndereco[]=Endereco.split("\\.");
        try {
            ImageIO.write(
                getBloco(Bloco),
                getSpriteTipo(),//N�o pode ser um tipo diferente do SpriteOriginal
                new File(Endereco)
            );
        } catch (IOException ex) {
            Logger.getLogger(SpriteDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
