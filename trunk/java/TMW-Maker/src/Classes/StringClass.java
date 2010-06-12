
package Classes;

public class StringClass {
    String TestoEmTratamento="";

    public String StringClass(String Testo) {
        TestoEmTratamento = Testo;
        return TestoEmTratamento;
    }
    public String StringClass() {
        return TestoEmTratamento;
    }
    public void setTesto(String Testo) {
        TestoEmTratamento=Testo;
    }
    public String getTesto() {
        return TestoEmTratamento;
    }

    public void Substituir(String De, String Por){
        String Entrada=TestoEmTratamento;
        Substituir(Entrada, De, Por);
    }
    public String Substituir(String Entrada, String De, String Por){
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
    public String ExtrairEntre(String Parte1, String Parte2){
        String Entrada=TestoEmTratamento;
        return ExtrairEntre(Entrada, Parte1, Parte2);
    }
    public String ExtrairEntre(String Entrada, String Parte1, String Parte2){
        int Loc1=-1, Loc2=-1;
        Loc1=Entrada.indexOf(Parte1);
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
