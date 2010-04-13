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
        Mapa=NomeDoMapa.toLowerCase().toString();
    }
    public void setX(int CoordenadaX){
        X=CoordenadaX;
    }
    public void setY(int CoordenadaY){
        Y=CoordenadaY;
    }
    public void setScript(String ScriptDoNPC){
        Script=ScriptDoNPC.toLowerCase().toString();
    }
    public void setNome(String NpmeDoNPC){
        Nome=NpmeDoNPC.toLowerCase().toString();
    }
    public void setImagem(int BlocoDaImagem){
        Imagem=BlocoDaImagem;
    }

    public String getMapa(){
        return Mapa.toLowerCase().toString();
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public String getScript(){
        return Script.toLowerCase().toString();
    }
    public String getNome(){
        return Nome.toLowerCase().toString();
    }
    public int getImagem(){
        return Imagem;
    }
    public static void main(String args[]) {

    }
}
