package Classes.BancoDeDados;

public class Dados_Lojas {
    private String nomeLoja="";
    private int imagemILoja=0;
    private String mapa="";
    private int coordX=0;
    private int coordY=0;
    private static Dados_LojaProduto estoque[];
    public Dados_Lojas(String novoNomeLoja, int novaImagemILoja, String novoMapa, int novaCoordX, int novaCoordY, Dados_LojaProduto NovosProdutos[]) {
        nomeLoja=novoNomeLoja;
        imagemILoja=novaImagemILoja;
        mapa=novoMapa;
        coordX=novaCoordX;
        coordY=novaCoordY;
        estoque=NovosProdutos;
    }
    public Dados_Lojas(String novoNomeLoja, int novaImagemILoja, String novoMapa, int novaCoordX, int novaCoordY) {
        nomeLoja=novoNomeLoja;
        imagemILoja=novaImagemILoja;
        mapa=novoMapa;
        coordX=novaCoordX;
        coordY=novaCoordY;
    }

    public void setNomeLoja(String novoNomeLoja){nomeLoja=novoNomeLoja;}
    public void setImagemLoja(int novaImagemILoja){imagemILoja=novaImagemILoja;}
    public void setMapa(String novoMapaNome){mapa=novoMapaNome;}
    public void setCoordX(int novaCoordX){coordX=novaCoordX;}
    public void setCoordY(int novaCoordY){coordY=novaCoordY;}
    public void setProdutoPorID(int antigoProdutoID, int novoProdutoID, int novoProdutoPrecoDeVenda){
        for(int b=0;b<estoque.length;b++){
            if(estoque[b].getID()==antigoProdutoID){
               estoque[b].setID(novoProdutoID);
               estoque[b].setPrecoDeVenda(novoProdutoPrecoDeVenda);
               return;//Termina o método!
            }
        }
    }
    public void setProdutoPorOrdem(int ordem, int novoProdutoID, int novoProdutoPrecoDeVenda){
        estoque[ordem].setID(novoProdutoID);
        estoque[ordem].setPrecoDeVenda(novoProdutoPrecoDeVenda);
    }

    public String getNomeLoja(){return nomeLoja;}
    public int    getImagemLoja(){return imagemILoja;}
    public String getMapa(){return mapa;}
    public int    getCoordX(){return coordX;}
    public int    getCoordY(){return coordY;}
    public int    getContProdutos(){
         if(estoque != null){
             return estoque.length;
         }else{
             return 0;
         }
    }
    public Dados_LojaProduto[] getProdutos(){return estoque;}
    public Dados_LojaProduto getProdutoPorID(int antigoProdutoID){
        for(int b=0;b<estoque.length;b++){
            if(estoque[b].getID()==antigoProdutoID){
               return estoque[b];//Termina o método!
            }
        }
        return null;
    }
    public Dados_LojaProduto getProdutoPorOrdem(int ordem){
        return estoque[ordem];
    }

    public void addProduto(int produtoID, int produtoPreco){
        if(estoque != null){
            Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length+1];
            for(int b=0;b<estoque.length;b++){
                if(estoque[b].getID()!=produtoID){
                    novoEstoque[b] = new Dados_LojaProduto(estoque[b].getID(),estoque[b].getPrecoDeVenda());
                }else{
                    return; //Cancela adição de o produto já foi adicionado anteriormente;
                }
            }
            novoEstoque[estoque.length] = new Dados_LojaProduto(produtoID, produtoPreco);
            estoque = novoEstoque;
        }else{
            Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[1];
            novoEstoque[0] = new Dados_LojaProduto(produtoID, produtoPreco);
            estoque = novoEstoque;
        }
    }
    public void delProdutoPorOrdem(int ordem){
        if(estoque != null){
            Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length-1];
            int contProduto=0;
            for(int b=0;b<estoque.length;b++){
                if(b!=ordem){
                    contProduto++;
                    novoEstoque[contProduto-1] = new Dados_LojaProduto(estoque[b].getID(),estoque[b].getPrecoDeVenda());
                }
            }
            estoque = novoEstoque;
        }
    }
    public void delProdutoPorID(int id){
        if(estoque != null){
            Dados_LojaProduto novoEstoque[] = new Dados_LojaProduto[estoque.length-1];
            int contProduto=0;
            for(int b=0;b<estoque.length;b++){
                if(estoque[b].getID()!=id){
                    contProduto++;
                    novoEstoque[contProduto-1] = new Dados_LojaProduto(estoque[b].getID(),estoque[b].getPrecoDeVenda());
                }
            }
            estoque = novoEstoque;
        }
    }
    public void delEstoque(){estoque = null;}
}
