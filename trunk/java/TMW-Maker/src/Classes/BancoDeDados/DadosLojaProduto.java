package Classes.BancoDeDados;

public class DadosLojaProduto {
    private int produtoID=0;
    private int produtoPrecoDeVenda=0;
    
    public void setID(int NovoID){produtoID=NovoID;}
    public void setPrecoDeVenda(int NovoPreco){produtoPrecoDeVenda=NovoPreco;}

    public int getID(){return produtoID;}
    public int getPrecoDeVenda(){return produtoPrecoDeVenda;}
}
