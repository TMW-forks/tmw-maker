/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocomplete;

/**
 *
 * @author vanderson
 */
public class Comandos {
    private String comando;
    private String funcao;
    private String exemplo;
    public void setcomando(String comando){
        this.comando = comando;
    }
    public void setfuncao(String funcao){
        this.funcao = funcao;
    }
    public void setexemplo(String exemplo){
        this.exemplo = exemplo;
    }
    public String getcomando(){
        return comando;
    }
    public String getfuncao(){
        return funcao;
    }
    public String getexemplo(){
        return exemplo;
    }

}
