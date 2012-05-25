package Classes.BancoDeDados;

import classes.FileClass;
import Classes.BancoDeDados.Banco_Lojas.Dados_Lojas.Dados_LojaProduto;
import Classes.ConfigClass;
import Classes.StringClass;
import java.util.Vector;

public class Banco_Lojas {
    private Dados_Lojas galeria[]=null; //Não deve ser instaciado agora!!!!
    public Banco_Lojas(String Arquivo){
        arqAbrir(Arquivo);
    }
    public Banco_Lojas(){
        galeria = null;
    }

    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length+1];
            for(int b=0;b<galeria.length;b++){
                novaGaleria[b] = new Dados_Lojas(
                    galeria[b].getNomeLoja(),
                    galeria[b].getImagemLoja(),
                    galeria[b].getMapa(),
                    galeria[b].getCoordX(),
                    galeria[b].getCoordY(),
                    galeria[b].getProdutos()
                );
            }
            novaGaleria[galeria.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }else{
            Dados_Lojas novaGaleria[] = new Dados_Lojas[1];
            novaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }
    }
    public void addLoja(String nomeLoja, int imagemILoja, String mapa, int coordX, int coordY, Dados_LojaProduto NovosProdutos[]){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length+1];
            for(int b=0;b<galeria.length;b++){
                novaGaleria[b] = new Dados_Lojas(
                    galeria[b].getNomeLoja(),
                    galeria[b].getImagemLoja(),
                    galeria[b].getMapa(),
                    galeria[b].getCoordX(),
                    galeria[b].getCoordY(),
                    galeria[b].getProdutos()
                );
            }
            novaGaleria[galeria.length] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }else{
            Dados_Lojas novaGaleria[] = new Dados_Lojas[1];
            novaGaleria[0] = new Dados_Lojas(nomeLoja, imagemILoja, mapa, coordX, coordY);
            galeria = novaGaleria;
        }
    }
    public void delLojaPorNome(String nomeLoja){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length-1];
            int contLojas=0;
            for(int b=0;b<galeria.length;b++){
                if(galeria[b].getNomeLoja().equals(nomeLoja)){
                    contLojas++;
                    novaGaleria[contLojas-1] = new Dados_Lojas(
                        galeria[b].getNomeLoja(),
                        galeria[b].getImagemLoja(),
                        galeria[b].getMapa(),
                        galeria[b].getCoordX(),
                        galeria[b].getCoordY(),
                        galeria[b].getProdutos()
                    );
                }
            }
            galeria = novaGaleria;
        }
    }
    public void delLojaPorOrdem(int ordem){
        if(galeria != null){
            Dados_Lojas novaGaleria[] = new Dados_Lojas[galeria.length-1];
            int contLojas=0;
            for(int b=0;b<galeria.length;b++){
                if(b!=ordem){
                    contLojas++;
                    novaGaleria[contLojas-1] = new Dados_Lojas(
                        galeria[b].getNomeLoja(),
                        galeria[b].getImagemLoja(),
                        galeria[b].getMapa(),
                        galeria[b].getCoordX(),
                        galeria[b].getCoordY(),
                        galeria[b].getProdutos()
                    );
                }
            }
            galeria = novaGaleria;
        }
    }
    public void delGaleria(){galeria=null;}
    public Dados_Lojas[] getLojas(){return galeria;}
    public Vector getLojasVector(){
        Vector Lojas = new Vector();
        //Vector Carrinho = new Vector();
        for(int l=0;l<getContLojas();l++){
            Lojas.addElement(getLojaPorOrdem(l).getNomeLoja());
        }
        return Lojas;
    }
    public Dados_Lojas getLojaPorOrdem(int ordem){
        if(galeria != null){
            return galeria[ordem];
        }else{
            return null;
        }
    }
    public Dados_Lojas getLojaPorNome(String nomeLoja){
        if(galeria != null){
            for(int ordem=0;ordem<galeria.length;ordem++){
                if(galeria[ordem].getNomeLoja().equals(nomeLoja)){
                    return galeria[ordem];
                }
            }
        }
        return null;
    }
    public int getContLojas(){
         if(galeria != null){
             return galeria.length;
         }else{
             return 0;
         }
    }
    public void setLojas(Dados_Lojas NovasLojas[]){galeria=NovasLojas;}
    public String getScript(){
        //005.gat,92,67,0	shop	Jorge	120,1199:3,529:5,1200:1000,530:3000
        String Script=
        "///////////////////////////////////////////////////////////////////\n"+
        "//  IDE: TMW-Maker - Ferramenta Editora de Lojas\n"+
        "//  MODIFICADO: "+ConfigClass.AGORAtoFORMATO("dd/MM/yyyy h:mm a")+"\n"+
        "///////////////////////////////////////////////////////////////////\n"+
        "\n";
        for(int L=0;L<getContLojas();L++){
            Script +=
            getLojaPorOrdem(L).getMapa()+".gat,"+
            getLojaPorOrdem(L).getCoordX()+","+
            getLojaPorOrdem(L).getCoordY()+",0\tshop\t"+
            getLojaPorOrdem(L).getNomeLoja()+"\t"+
            getLojaPorOrdem(L).getImagemLoja();
            for(int P=0;P<getLojaPorOrdem(L).getContProdutos();P++){
                Script +=","+
                getLojaPorOrdem(L).getProdutoPorOrdem(P).getID()+":"+
                getLojaPorOrdem(L).getProdutoPorOrdem(P).getPrecoDeVenda();
            }
            Script +="\n";
        }
        return Script;

    }
    public void arqAbrir(String Arquivo){
        StringClass Conteudo = new StringClass(FileClass.arquivoAbrir(Arquivo));
        //Vector shops = new Vector();
        for(int ln=0;ln<Conteudo.getContLinhas();ln++){
            String Partes[] = Conteudo.getLinha(ln).trim().split(",");
            if(
                Partes.length>=5 &&
                Conteudo.getLinha(ln).trim().indexOf("//")!=0 &&
                Conteudo.getLinha(ln).trim().indexOf("\tshop\t")>=0
            ){
                String Partes2[] = Partes[0].trim().split("\\.");
                String Partes3[] = Partes[3].trim().split("\t");
                if(Partes2.length==2 && Partes3.length==4){
                    addLoja(
                        Partes3[2].toString(),
                        Integer.parseInt(Partes3[3].toString()),
                        Partes2[0].toString(),
                        Integer.parseInt(Partes[1].toString()),
                        Integer.parseInt(Partes[2].toString())
                    );
                    for(int P=4;P<Partes.length;P++){
                        String Partes4[] = Partes[P].trim().split(":");
                         if(Partes4.length==2){
                            getLojaPorOrdem(getContLojas()-1).addProduto(
                                Integer.parseInt(Partes4[0]),
                                Integer.parseInt(Partes4[1])
                            );
                            /*System.out.println(
                                "L:"+getContLojas()+" "+
                                "Ps:"+getLojaPorOrdem(getContLojas()-1).getContProdutos()
                            );/**/
                         }
                    }
                }
            }
        }
    }
    public void arqSalvar(String Arquivo){
        FileClass.arquivoSalvar(Arquivo,getScript());
    }

    //package Classes.BancoDeDados;

    //import java.util.Vector;

    public class Dados_Lojas {
        private String nomeLoja = "";
        private int imagemILoja = 0;
        private String mapa = "";
        private int coordX = 0;
        private int coordY = 0;
        private Dados_LojaProduto estoque[] = null;

        public Dados_Lojas(String novoNomeLoja, int novaImagemILoja, String novoMapa, int novaCoordX, int novaCoordY, Dados_LojaProduto NovosProdutos[]) {
            nomeLoja = novoNomeLoja;
            imagemILoja = novaImagemILoja;
            mapa = novoMapa;
            coordX = novaCoordX;
            coordY = novaCoordY;
            estoque = NovosProdutos;
        }

        public Dados_Lojas(String novoNomeLoja, int novaImagemILoja, String novoMapa, int novaCoordX, int novaCoordY) {
            nomeLoja = novoNomeLoja;
            imagemILoja = novaImagemILoja;
            mapa = novoMapa;
            coordX = novaCoordX;
            coordY = novaCoordY;
        }

        public Dados_Lojas() {
            //Loja Vazia
        }

        public void setNomeLoja(String novoNomeLoja) {
            nomeLoja = novoNomeLoja;
        }

        public void setImagemLoja(int novaImagemILoja) {
            imagemILoja = novaImagemILoja;
        }

        public void setMapa(String novoMapaNome) {
            mapa = novoMapaNome;
        }

        public void setCoordX(int novaCoordX) {
            coordX = novaCoordX;
        }

        public void setCoordY(int novaCoordY) {
            coordY = novaCoordY;
        }

        public void setProdutoPorID(int antigoProdutoID, int novoProdutoID, int novoProdutoPrecoDeVenda) {
            for (int b = 0; b < estoque.length; b++) {
                if (estoque[b].getID() == antigoProdutoID) {
                    estoque[b].setID(novoProdutoID);
                    estoque[b].setPrecoDeVenda(novoProdutoPrecoDeVenda);
                    return;//Termina o método!
                }
            }
        }

        public void setProdutoPorOrdem(int ordem, int novoProdutoID, int novoProdutoPrecoDeVenda) {
            estoque[ordem].setID(novoProdutoID);
            estoque[ordem].setPrecoDeVenda(novoProdutoPrecoDeVenda);
        }

        public String getNomeLoja() {
            return nomeLoja;
        }

        public int getImagemLoja() {
            return imagemILoja;
        }

        public String getMapa() {
            return mapa;
        }

        public int getCoordX() {
            return coordX;
        }

        public int getCoordY() {
            return coordY;
        }

        public int getContProdutos() {
            if (estoque != null) {
                return estoque.length;
            } else {
                return 0;
            }
        }

        public Dados_LojaProduto[] getProdutos() {
            return estoque;
        }

        public Vector getProdutosVector() {
            Vector Carrinho = new Vector();
            for (int p = 0; p < getContProdutos(); p++) {
                Vector Produto = new Vector();
                Produto.addElement(getProdutoPorOrdem(p).getID());
                Produto.addElement(getProdutoPorOrdem(p).getPrecoDeVenda());
                Carrinho.add(Produto);
            }
            return Carrinho;
        }

        public Dados_LojaProduto getProdutoPorID(int antigoProdutoID) {
            for (int b = 0; b < estoque.length; b++) {
                if (estoque[b].getID() == antigoProdutoID) {
                    return estoque[b];//Termina o método!
                }
            }
            return null;
        }

        public Dados_LojaProduto getProdutoPorOrdem(int ordem) {
            return estoque[ordem];
        }

        public void addProduto(int produtoID, int produtoPreco) {
            if (estoque != null) {
                Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length + 1];
                for (int b = 0; b < estoque.length; b++) {
                    if (estoque[b].getID() != produtoID) {
                        novoEstoque[b] = new Dados_LojaProduto(estoque[b].getID(), estoque[b].getPrecoDeVenda());
                    } else {
                        return; //Cancela adição de o produto já foi adicionado anteriormente;
                    }
                }
                novoEstoque[estoque.length] = new Dados_LojaProduto(produtoID, produtoPreco);
                estoque = novoEstoque;
            } else {
                Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[1];
                novoEstoque[0] = new Dados_LojaProduto(produtoID, produtoPreco);
                estoque = novoEstoque;
            }
        }

        public void delProdutoPorOrdem(int ordem) {
            if (estoque != null) {
                Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length - 1];
                int contProduto = 0;
                for (int b = 0; b < estoque.length; b++) {
                    if (b != ordem) {
                        contProduto++;
                        novoEstoque[contProduto - 1] = new Dados_LojaProduto(estoque[b].getID(), estoque[b].getPrecoDeVenda());
                    }
                }
                estoque = novoEstoque;
            }
        }

        public void delProdutoPorID(int id) {
            if (estoque != null) {
                Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length - 1];
                int contProduto = 0;
                for (int b = 0; b < estoque.length; b++) {
                    if (estoque[b].getID() != id) {
                        contProduto++;
                        novoEstoque[contProduto - 1] = new Dados_LojaProduto(estoque[b].getID(), estoque[b].getPrecoDeVenda());
                    }
                }
                estoque = novoEstoque;
            }
        }

        public void delEstoque() {
            estoque = null;
        }

        //package Classes.BancoDeDados;

        public class Dados_LojaProduto {
            private int produtoID = 0;
            private int produtoPrecoDeVenda = 0;

            Dados_LojaProduto(int NovoID, int NovoPrecoDeVenda) {
                produtoID = NovoID;
                produtoPrecoDeVenda = NovoPrecoDeVenda;
            }
            public void setID(int NovoID) {
                produtoID = NovoID;
            }
            public void setPrecoDeVenda(int NovoPrecoDeVenda) {
                produtoPrecoDeVenda = NovoPrecoDeVenda;
            }
            public int getID() {
                return produtoID;
            }
            public int getPrecoDeVenda() {
                return produtoPrecoDeVenda;
            }
        }
    }
}
