
package Classes;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class StringClass {
    public StringClass(String Testo) {
        testoEmTratamento = Testo;
    }
    public StringClass() {
        testoEmTratamento = "";
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

    public void setKeyCode(String codigoDeCaracteres){
        if(codigoDeCaracteres.equals("UTF-8")){//Transforma ISO-8859-1 ? UTF-8
            testoEmTratamento=ISO88591toUTF8(testoEmTratamento);
        }else if(codigoDeCaracteres.equals("ISO-8859-1")){//Transforma UTF-8 ? ISO-8859-1
            testoEmTratamento=UTF8toISO88591(testoEmTratamento);
        }
    }
    public static String UTF8toISO88591(String UTF8){ // Só funciona se for executado fora do netbeans!
        try{
            return URLDecoder.decode(UTF8, "ISO-8859-1");
        } catch(UnsupportedEncodingException E){
            return UTF8;
        }
    }
    public static String ISO88591toUTF8(String ISO88591){ // Só funciona se for executado fora do netbeans!
        try{
            return new String(ISO88591.getBytes("UTF-8"), "ISO-8859-1");
        } catch(UnsupportedEncodingException E){
            return ISO88591;
        }
    }

    public void setSubstituicao(String De, String Por){
        testoEmTratamento=getSubstituicao(testoEmTratamento, De, Por);
    }
    public String getSubstituicao(String De, String Por){
        return getSubstituicao(testoEmTratamento, De, Por);
    }
    public String getSubstituicao(String Entrada, String De, String Por){
       int Loc1=-1;
        Loc1=Entrada.indexOf(De);
        if(Loc1>=0){
            String Parte1="", Parte2="";
            Parte1=Entrada.substring(0, Loc1);
            Parte2=Entrada.substring(Loc1+De.length(), Entrada.length());
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
