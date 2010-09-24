package Classes.BancoDeDados;

import Formularios.FrmPrincipal;

public class Banco_Mapas {
    public Banco_Mapas(){
        
    }
    private static String Barra = System.getProperty("file.separator");
    private static String Tiled=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmw-maker"+Barra+"tiled.jar";
    private static String PastaDeMapas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"maps";
    private static String PastaDeMiniaturas=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"tmwdata"+Barra+"graphics"+Barra+"minimaps";
    private static String PastaDeColisoes=FrmPrincipal.Config.getConexaoLocalhost()+Barra+"eathena-data"+Barra+"data";
    private Dados_Mapas Mundo[]=null; //Não deve ser instaciado agora!!!!

    public void addMapa(String Nome, String Miniatura, String Arquivo, String Cilisao, int Largura, int Altura){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length+1];
            for(int b=0;b<Mundo.length;b++){
                novoMundo[b] = new Dados_Mapas(
                    Mundo[b].getNome(),
                    Mundo[b].getMiniatura(),
                    Mundo[b].getArquivo(),
                    Mundo[b].getColisão(),
                    Mundo[b].getLargura(),
                    Mundo[b].getAltura()
                );
            }
            novoMundo[Mundo.length] = new Dados_Mapas(Nome, Miniatura, Arquivo, Cilisao, Largura, Altura);
            Mundo = novoMundo;
        }else{
            Dados_Mapas novoMundo[] = new Dados_Mapas[1];
            novoMundo[0] = new Dados_Mapas(Nome, Miniatura, Arquivo, Cilisao, Largura, Altura);
            Mundo = novoMundo;
        }
    }
    public void delMapaPorArquivo(String Arquivo){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length-1];
            int contLojas=0;
            for(int b=0;b<Mundo.length;b++){
                if(Mundo[b].getArquivo().equals(Arquivo)){
                    contLojas++;
                    novoMundo[contLojas-1]=getMapaPorOrdem(b);
                }
            }
            Mundo = novoMundo;
        }
    }
    public void delMapaPorOrdem(int ordem){
        if(Mundo != null){
            Dados_Mapas novoMundo[] = new Dados_Mapas[Mundo.length-1];
            int contLojas=0;
            for(int b=0;b<Mundo.length;b++){
                if(b!=ordem){
                    contLojas++;
                    novoMundo[contLojas-1]=getMapaPorOrdem(b);
                }
            }
            Mundo = novoMundo;
        }
    }
    public int getContMapas(){
         if(Mundo != null){
             return Mundo.length;
         }else{
             return 0;
         }
    }
    public Dados_Mapas[] getMapas(){
        if(getContMapas()>=1){
            return Mundo;
        }else{
            return null;
        }
    }
    public Dados_Mapas getMapaPorOrdem(int ordem){
        if(Mundo != null){
            return Mundo[ordem];
        }else{
            return null;
        }
    }
    public Dados_Mapas getMapaPorNome(String nomeMapa){
        if(Mundo != null){
            for(int ordem=0;ordem<Mundo.length;ordem++){
                if(Mundo[ordem].getNome().equals(nomeMapa)){
                    return Mundo[ordem];
                }
            }
        }
        return null;
    }
    public Dados_Mapas getMapaPorArquivo(String arquivoTMX){
        if(Mundo != null){
            for(int ordem=0;ordem<Mundo.length;ordem++){
                if(Mundo[ordem].getArquivo().equals(arquivoTMX)){
                    return Mundo[ordem];
                }
            }
        }
        return null;
    }

    public class Dados_Mapas {
        public Dados_Mapas(String novaNome, String novaMiniatura, String novoArquivo, String novaColisao, int novaLargura, int novaAltura){
            Nome=novaNome;
            Arquivo=novoArquivo;
            Miniatura=novaMiniatura;
            Colisao=novaColisao;
            Largura=novaLargura;
            Altura=novaAltura;
        }
        private String Nome = "";
        private String Miniatura = "";
        private String Arquivo = "";
        private String Colisao = "";
        private int Largura = 0;
        private int Altura = 0;

        public String getNome(){return Nome;}
        public String getArquivo(){return Arquivo;}
        public String getMiniatura(){return Miniatura;}
        public String getColisão(){return Colisao;}
        public int getLargura(){return Largura;}
        public int getAltura(){return Altura;}

        public void setNome(String novoNome){Nome=novoNome;}
        public void setMiniatura(String novaMiniatura){Miniatura=novaMiniatura;}
        public void setArquivo(String novoArquivo){Arquivo=novoArquivo;}
        public void setColisao(String novaColisao){Colisao=novaColisao;}
        public void setLargura(int novaLargura){Largura=novaLargura;}
        public void setAltura(int novaAltura){Altura=novaAltura;}
    }
}
