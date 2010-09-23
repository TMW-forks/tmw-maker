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
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class FileClass {
    public static void apagar(String PastaOuArquivo){
        File Objeto = new File(PastaOuArquivo);
        Objeto.delete();
    }
    public static void arquivoCopiar(String De, String Para) {
        File CapsulaOrigem=new File(De);
        arquivoCopiar(CapsulaOrigem, Para);
    }
    public static void arquivoCopiar(File CapsulaOrigem, String Para) {
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
    public static void arquivoMover(String De, String Para) {
        File Origem = new File(De);
        File Destino = new File(Para);
        Origem.renameTo(Destino);
    }
    public static void pastaCriar(String EnderecoDaNovaPasta){
        File dir = new File(EnderecoDaNovaPasta);
        dir.mkdirs();
    }
    public static String[] listarPasta(String Endereco){
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
    public static String[] listarArquivos(String Endereco){
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
    public static boolean arquivoSeSimpleNome(File PastaPai, String NomDeArquivo) {
        /**
         * Função Copiada de Site "http://forums.sun.com/thread.jspa?threadID=629458"
         * Eu não entendo essa Função, mas tentei implementa-la para ver se serve.
         */

        if (PastaPai == null || NomDeArquivo == null) return false;
        File Arquivo = new File(PastaPai, NomDeArquivo);
        if(!Arquivo.exists()){ //se o arquivo já existe, pode ser o nome do arquivo está correto
            try {
                boolean SeNomeValido = Arquivo.createNewFile();
                //apagar o arquivo porque é criado para a verificação de validação
                if(SeNomeValido) Arquivo.delete();
                //Se o pai do novo arquivo e o pai dado é diferente, então o nome do arquivo está errado
                if(!Arquivo.getParent().equals(PastaPai.getPath())) return false;
                return SeNomeValido;
            } catch (IOException ioe) {
                return false;
            }
        }
        //Se o pai do novo arquivo e o pai dado é diferente, então o nome do arquivo está errado
        return Arquivo.getParent().equals(PastaPai.getPath());
    }

    public static boolean seExiste(String PastaOuArquivo){
        File Capsula;
        Capsula = new File(PastaOuArquivo);
        if (Capsula.exists()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean arquivoSalvar(String Endereco, String Conteudo){
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
    public static String arquivoAbrir_deprecado(String Endereco){
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
    public static String arquivoAbrir(String Endereco){
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
    public static String urlAbrir(String Endereco){
         try {
            URL arquivo = new URL(Endereco);
            BufferedReader in = new BufferedReader(new InputStreamReader(arquivo.openStream()));
            String str, Conteudo="";
            int contador=0;
            while ((str = in.readLine()) != null) {
                contador += 1;
                Conteudo+=(Conteudo.equals("")?str:"\n"+str);
            }
            in.close();
            return Conteudo;
        } catch (IOException e) {
            return null;
        }
    }

}
