package Classes;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mensagem {

    public static void showErro(String Aviso, String Titulo) {
        System.out.println(Aviso);
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
    }
    public static void showAlerta(String Aviso, String Titulo, String EnderecoOuResource) {
        ImagemTratavel Imagem = new ImagemTratavel(EnderecoOuResource);
        showAlerta(Aviso, Titulo, Imagem);
    }
    public static void showAlerta(String Aviso, String Titulo, ImagemTratavel Imagem) {
        showAlerta(Aviso, Titulo, Imagem.getIcone());
    }
    public static void showAlerta(String Aviso, String Titulo, ImageIcon Icone) {
        System.out.println(Aviso);
        Toolkit.getDefaultToolkit().beep();
        //JOptionPane.showMessageDialog(null,Aviso,Titulo,JOptionPane.WARNING_MESSAGE);
        Object[] options = {"Ok!"};
        JOptionPane.showOptionDialog(
            null,
            Aviso,
            Titulo,
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            Icone,
            options,
            options[0]
        );
    }
    public static int  showOpcoes(String Aviso, String Titulo, String EnderecoOuResource, Object Opcoes[], int FocarOpcao){
        ImagemTratavel Imagem = new ImagemTratavel(EnderecoOuResource);
        return showOpcoes(
            Aviso,
            Titulo,
            Imagem,
            Opcoes,
            FocarOpcao
        );
    }
    public static int  showOpcoes(String Aviso, String Titulo, ImagemTratavel Imagem, Object Opcoes[], int FocarOpcao){
        return showOpcoes(
            Aviso,
            Titulo,
            Imagem.getIcone(),
            Opcoes,
            FocarOpcao
        );
    }
    public static int  showOpcoes(String Aviso, String Titulo, ImageIcon Icone, Object Opcoes[], int FocarOpcao) {
        System.out.println(Aviso);
        Toolkit.getDefaultToolkit().beep();
        //Object[] Opcoes = {"Ok!","Cancel"};
        return JOptionPane.showOptionDialog(
            null,
            Aviso,
            Titulo,
            Opcoes.length, //JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            Icone,
            Opcoes,
            Opcoes[FocarOpcao]
        );
    }
}
