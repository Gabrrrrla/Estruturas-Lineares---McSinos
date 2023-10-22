package produto;

public class Produto {
    private String descricao;
    private double preco;
    private TipoProduto tipo;

    public Produto(String descricao, double preco, TipoProduto tipo) {
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public enum TipoProduto{
        COMIDA,
        BEBIDA
    }
}
