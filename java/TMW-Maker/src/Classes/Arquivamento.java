package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class Arquivamento {
    public static void Apagar(String PastaOuArquivo){
        File Objeto = new File(PastaOuArquivo);
        Objeto.delete();
    }
    public static void CopiarArquivo(String De, String Para) {
        File CapsulaOrigem=new File(De);
        CopiarArquivo(CapsulaOrigem, Para);
    }
    public static void CopiarArquivo(File CapsulaOrigem, String Para) {
        File CapsulaDestino=new File(Para);
        CapsulaDestino.setExecutable(CapsulaOrigem.canExecute(),true);
        CapsulaDestino.setReadable(CapsulaOrigem.canRead());
        CapsulaDestino.setWritable(CapsulaOrigem.canWrite());
        try {
            FileChannel Origem = new FileInputStream(CapsulaOrigem).getChannel();
            FileChannel Destino = new FileOutputStream(CapsulaDestino).getChannel();
            Origem.transferTo(0, Origem.size(),Destino);
            if (Origem != null && Origem.isOpen()) {
                Origem.close();
            }
            if (Destino != null && Destino.isOpen()) {
                Destino.close();
            }
        } catch(IOException Exc){
            //
        }/**/
    }
    public static void MoverArquivo(String De, String Para) {
        File Origem = new File(De);
        File Destino = new File(Para);
        Origem.renameTo(Destino);
    }
    public static void CriarPasta(String EnderecoDaNovaPasta){
        File dir = new File(EnderecoDaNovaPasta);
        dir.mkdirs();
    }
    public static String[] ListarPastas(String Endereco){
        ///home/indigovox/localhost/eathena-data/npc
        File Capsula = new File(Endereco);
        File[] Conteudo = Capsula.listFiles();
        int ContPastas=0;
        for(int c=0; c<Conteudo.length; c++){
            if(Conteudo[c].isDirectory()){
                ContPastas++;
            }
        }
        String Pasta[] = new String[ContPastas];
        ContPastas=0;
        for(int p=0; p<Conteudo.length; p++){
            if(Conteudo[p].isDirectory()){
                Pasta[ContPastas]=Conteudo[p].getName();
                //TxtScript.setText(TxtScript.getText()+Conteudo[c].getName()+"\n");
                ContPastas++;
            }
        }
        Arrays.sort(Pasta);
        return Pasta;
    }
    public static String[] ListarArquivos(String Endereco){
        ///home/indigovox/localhost/eathena-data/npc
        File Capsula = new File(Endereco);
        File[] Conteudo = Capsula.listFiles();
        int ContArquivos=0;
        for(int c=0; c<Conteudo.length; c++){
            if(Conteudo[c].isFile()){
                ContArquivos++;
            }
        }
        String Arquivos[] = new String[ContArquivos];
        ContArquivos=0;
        for(int a=0; a<Conteudo.length; a++){
            if(Conteudo[a].isFile()){
                Arquivos[ContArquivos]=Conteudo[a].getName();
                ContArquivos++;
            }
        }
        Arrays.sort(Arquivos);
        return Arquivos;
    }
    public static boolean SeSimpleNomeDeArquivo(File PastaPai, String NomDeArquivo) {
        /**
         * Fun��o Copiada de Site "http://forums.sun.com/thread.jspa?threadID=629458"
         * Eu n�o entendo essa Fun��o, mas tentei implementa-la para ver se serve.
         */

        if (PastaPai == null || NomDeArquivo == null) return false;
        File Arquivo = new File(PastaPai, NomDeArquivo);
        if(!Arquivo.exists()){ //se o arquivo j� existe, pode ser o nome do arquivo est� correto
            try {
                boolean SeNomeValido = Arquivo.createNewFile();
                //Apagar o arquivo porque � criado para a verifica��o de valida��o
                if(SeNomeValido) Arquivo.delete();
                //Se o pai do novo arquivo e o pai dado � diferente, ent�o o nome do arquivo est� errado
                if(!Arquivo.getParent().equals(PastaPai.getPath())) return false;
                return SeNomeValido;
            } catch (IOException ioe) {
                return false;
            }
        }
        //Se o pai do novo arquivo e o pai dado � diferente, ent�o o nome do arquivo est� errado
        return Arquivo.getParent().equals(PastaPai.getPath());
    }

    public static boolean SeExiste(String PastaOuArquivo){
        File Capsula;
        Capsula = new File(PastaOuArquivo);
        if (Capsula.exists()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean ArquivoSalvar(String Endereco, String Conteudo){
        try {
            BufferedWriter Capsula = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Endereco),"UTF-8"));
            String Cabecalho="";
            Capsula.write(Conteudo);
            Capsula.flush();
            Capsula.close();
            return true;
        } catch (java.io.IOException exc) {
            return false;
        }
    }
    public static String ArquivoAbrir_deprecado(String Endereco){
        try {
            String Conteudo="", Linha="";
            BufferedReader Capsula = new BufferedReader(new InputStreamReader(new FileInputStream(Endereco),"UTF-8"));
            while ((Linha = Capsula.readLine()) != null) {
                if(!Conteudo.equals("")){
                    Conteudo=Conteudo+"\n"+Linha;
                }else{
                    Conteudo=Linha;
                }
            }
            Capsula.close();
            return Conteudo;
        } catch (java.io.IOException exc) {
            return null;
        }
    }
    public static String ArquivoAbrir(String Endereco){
        String Conteudo="";
        int Tamanho = 1024*1024*32;
        ByteBuffer buf = ByteBuffer.allocate(Tamanho); //create buffer with capacity of 48 bytes
        try {
            RandomAccessFile aFile = new RandomAccessFile(Endereco, "rw");
            FileChannel inChannel = aFile.getChannel();
            int bytesRead = inChannel.read(buf);
            char Letra=0;
            byte[] bytearray = null;
            while (bytesRead != -1) {
                buf.flip();
                bytearray = new byte[buf.remaining()];
                while (buf.hasRemaining()) {
                    buf.get(bytearray);
                }
                Conteudo += new String(bytearray);
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            return Conteudo;
        } catch (IOException e) {
            return Conteudo;
        }
    }

}
