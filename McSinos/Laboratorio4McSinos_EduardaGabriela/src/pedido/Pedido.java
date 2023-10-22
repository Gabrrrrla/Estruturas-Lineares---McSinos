package pedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private ArrayList<ItemPedido> itemPedidos;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Pedido() {
        this.itemPedidos = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setItens(ArrayList<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public List<ItemPedido> getItens() {
        return itemPedidos;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itemPedidos.add(itemPedido);
    }

    @Override
    public String toString() {
        String produtosGeral = "#" + numeroPedido + "\n";
        produtosGeral += enlistaProdutos();
        return produtosGeral;
    }
    public String enlistaProdutos() {
        String produtosGeral = "";
        for(ItemPedido itemPedido : itemPedidos)
            produtosGeral += itemPedido.toString() + "\n";
        return produtosGeral;
    }

}
