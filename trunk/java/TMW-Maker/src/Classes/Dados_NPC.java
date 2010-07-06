
package Classes;

import java.awt.image.BufferedImage;

public class Dados_NPC {
    private int ID=0;
    private String XML="npc.xml";
    private String Particula="";
    private int Variante=0;
    private String Nome="";
    private String Comentario="";
    private SpriteDados Sprite = null;

    public void setID(int NovoID){ID=NovoID;}
    public void setXML(String NovoXML){XML=NovoXML;}
    public void setParticulaXML(String NovaParticula){Particula=NovaParticula;}
    public void setVariante(int NovaVariante){Variante=NovaVariante;}
    public void setNome(String NovoNome){Nome=NovoNome;}
    public void setComentario(String NovoComentario){Comentario=NovoComentario;}
    public void setSprite(SpriteDados NovoSprite){Sprite=NovoSprite;}

    public int getID(){return ID;}
    public String getXML(){return XML;}
    public String getParticulaXML(){return Particula;}
    public int getVariante(){return Variante;}
    public String getNome(){return Nome;}
    public String getComentario(){return Comentario;}
    public SpriteDados getSprite(){return Sprite;}
    public BufferedImage getImagem(){return Sprite.getBloco(Variante);}
}
