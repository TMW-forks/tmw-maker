
package Classes;

public class StringClass {
    public String StringClass(String Testo) {
        testoEmTratamento = Testo;
        return testoEmTratamento;
    }
    public String StringClass() {
        return testoEmTratamento;
    }
    String testoEmTratamento="";

    public void setTesto(String Testo) {
        testoEmTratamento=Testo;
    }
    public String getTesto() {
        return testoEmTratamento;
    }
    public int getContLinhas() {
        String Partes[] = testoEmTratamento.split("\n");
        return Partes.length;
    }
    public String getLinha(int Linha) {
        String Partes[] = testoEmTratamento.split("\n");
        return Partes[Linha];
    }

    public void substituir(String De, String Por){
        String Entrada=testoEmTratamento;
        substituir(Entrada, De, Por);
    }
    public String substituir(String Entrada, String De, String Por){
       int Loc1=-1;
        Loc1=Entrada.indexOf(De);
        if(Loc1>=0){
            String Parte1="", Parte2="";
            Parte1=Entrada.substring(0, Loc1);
            Parte2=Entrada.substring(Loc1+De.length(), Entrada.length()-1);
            Entrada = Parte1+Por+Parte2;
        }
        return Entrada;
    }
    public String extrairEntre(String Parte1, String Parte2){
        return extrairEntre(testoEmTratamento, Parte1, Parte2);
    }
    public String extrairEntre(String Parte1, String Parte2, int Apartir){
        return extrairEntre(testoEmTratamento, Parte1, Parte2, Apartir);
    }
    public String extrairEntre(String Entrada, String Parte1, String Parte2){
        return extrairEntre(Entrada, Parte1, Parte2, 0);
    }
    public String extrairEntre(String Entrada, String Parte1, String Parte2, int Apartir){
        int Loc1=-1, Loc2=-1;
        Loc1=Entrada.indexOf(Parte1,Apartir);
        if(Loc1>=0){
            Loc2=Entrada.indexOf(Parte2,Loc1+Parte1.length());
            if(Loc2>=0 && Loc2>=Loc1){
                return Entrada.substring(Loc1+Parte1.length(), Loc2);
            }else{
                return "";
            }
        }else{
            return "";
        }

    }
}
