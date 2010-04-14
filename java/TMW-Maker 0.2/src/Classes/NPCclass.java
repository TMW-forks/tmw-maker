package Classes;

public class NPCclass {
    private String Nome="";
    private String Mapa="";
    private int X= 0;
    private int Y= 0;
    private int Imagem = 0;
    private String Script="";
    public NPCclass(){

    }

    public void setMapa(String NomeDoMapa){
        Mapa=NomeDoMapa.toString();
    }
    public void setX(int CoordenadaX){
        X=CoordenadaX;
    }
    public void setY(int CoordenadaY){
        Y=CoordenadaY;
    }
    public void setScript(String ScriptDoNPC){
        Script=ScriptDoNPC.toString();
    }
    public void setNome(String NpmeDoNPC){
        Nome=NpmeDoNPC.toString();
    }
    public void setImagem(int BlocoDaImagem){
        Imagem=BlocoDaImagem;
    }

    public String getMapa(){
        return Mapa.toString();
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public String getScript(){
        return Script.toString();
    }
    public String getNome(){
        return Nome.toString();
    }
    public int getImagem(){
        return Imagem;
    }
    public static void main(String args[]) {

    }
}
