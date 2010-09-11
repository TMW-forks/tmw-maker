package Classes.BancoDeDados;

public class Dados_LojaProduto {
    private int produtoID=0;
    private int produtoPrecoDeVenda=0;

    Dados_LojaProduto(int NovoID, int NovoPrecoDeVenda) {
        produtoID=NovoID;
        produtoPrecoDeVenda=NovoPrecoDeVenda;
    }
    
    public void setID(int NovoID){produtoID=NovoID;}
    public void setPrecoDeVenda(int NovoPrecoDeVenda){produtoPrecoDeVenda=NovoPrecoDeVenda;}

    public int getID(){return produtoID;}
    public int getPrecoDeVenda(){return produtoPrecoDeVenda;}
}
