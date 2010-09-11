package Classes.BancoDeDados;

public class Dados_Lojas {
    private String nomeLoja="";
    private int imagemILoja=0;
    private String mapa="";
    private int coordX=0;
    private int coordY=0;
    private static Dados_LojaProduto Produtos[];

    public void setNomeLoja(String novoNomeLoja){nomeLoja=novoNomeLoja;}
    public void setImagemLoja(int novaImagemILoja){imagemILoja=novaImagemILoja;}
    public void setMapa(String novoMapaNome){mapa=novoMapaNome;}
    public void setCoordX(int novaCoordX){coordX=novaCoordX;}
    public void setCoordY(int novaCoordY){coordY=novaCoordY;}
    public void setProdutoPorID(int antigoProdutoID, int novoProdutoID, int novoProdutoPrecoDeVenda){
        for(int b=0;b<Produtos.length;b++){
            if(Produtos[b].getID()==antigoProdutoID){
               Produtos[b].setID(novoProdutoID);
               Produtos[b].setPrecoDeVenda(novoProdutoPrecoDeVenda);
               return;//Termina o método!
            }
        }
    }
    public void setProdutoPorOrdem(int ordem, int novoProdutoID, int novoProdutoPrecoDeVenda){
        Produtos[ordem].setID(novoProdutoID);
        Produtos[ordem].setPrecoDeVenda(novoProdutoPrecoDeVenda);
    }

    public String getNomeLoja(){return nomeLoja;}
    public int    getImagemLoja(){return imagemILoja;}
    public String getMapa(){return mapa;}
    public int    getCoordX(){return coordX;}
    public int    getCoordY(){return coordY;}
    public Dados_LojaProduto getProdutoPorID(int antigoProdutoID){
        for(int b=0;b<Produtos.length;b++){
            if(Produtos[b].getID()==antigoProdutoID){
               return Produtos[b];//Termina o método!
            }
        }
        return null;
    }
    public Dados_LojaProduto getProdutoPorOrdem(int ordem){
        return Produtos[ordem];
    }

    public void addProduto(int produtoID, int produtoPreco){
        if(Produtos != null){
            Dados_LojaProduto NovaLista[] = new Dados_LojaProduto[Produtos.length+1];
            for(int b=0;b<Produtos.length;b++){
                if(Produtos[b].getID()!=produtoID){
                    NovaLista[b] = new Dados_LojaProduto(Produtos[b].getID(),Produtos[b].getPrecoDeVenda());
                }else{
                    return; //Cancela adição de o produto já foi adicionado anteriormente;
                }
            }
            NovaLista[Produtos.length] = new Dados_LojaProduto(produtoID, produtoPreco);
            Produtos = NovaLista;
        }else{
            Dados_LojaProduto NovaLista[] = new Dados_LojaProduto[1];
            NovaLista[0] = new Dados_LojaProduto(produtoID, produtoPreco);
            Produtos = NovaLista;
        }
    }
    public void delProdutoPorOrdem(int ordem){
        if(Produtos != null){
            Dados_LojaProduto NovaLista[] = new Dados_LojaProduto[Produtos.length-1];
            int contProduto=0;
            for(int b=0;b<Produtos.length;b++){
                if(b!=ordem){
                    contProduto++;
                    NovaLista[contProduto-1] = new Dados_LojaProduto(Produtos[b].getID(),Produtos[b].getPrecoDeVenda());
                }
            }
            Produtos = NovaLista;
        }
    }
    public void delProdutoPorID(int id){
        if(Produtos != null){
            Dados_LojaProduto NovaLista[] = new Dados_LojaProduto[Produtos.length-1];
            int contProduto=0;
            for(int b=0;b<Produtos.length;b++){
                if(Produtos[b].getID()!=id){
                    contProduto++;
                    NovaLista[contProduto-1] = new Dados_LojaProduto(Produtos[b].getID(),Produtos[b].getPrecoDeVenda());
                }
            }
            Produtos = NovaLista;
        }
    }
}
