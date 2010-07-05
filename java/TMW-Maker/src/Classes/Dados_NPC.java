
package Classes;

public class Dados_NPC {
    private int ID=0;
    private String XML="npc.xml";
    private int Variante=0;
    private String Nome="";
    private String Comentario="";

    public void setID(int NovoID){ID=NovoID;}
    public void setXML(String NovoXML){XML=NovoXML;}
    public void setVariante(int NovaVariante){Variante=NovaVariante;}
    public void setNome(String NovoNome){Nome=NovoNome;}
    public void setComentario(String NovoComentario){Comentario=NovoComentario;}

    public int getID(){return ID;}
    public String getXML(){return XML;}
    public int getVariante(){return Variante;}
    public String getNome(){return Nome;}
    public String getComentario(){return Comentario;}

}
