package menu;

import operacoes.FilaPedidos;
import pedido.Pedido;
import produto.Produto;
import pedido.ItemPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Opcoes {
    private Scanner teclado;
    //private Pedido pedido;
    private FilaPedidos filaPedidos;
    private int opcao;
    private ArrayList<Produto> cardapio;

    public Opcoes() {
        teclado = new Scanner(System.in);
        filaPedidos = new FilaPedidos();
        cardapio = new ArrayList<Produto>();
        populaCardapio();

    }

    public void menu() {
        while(opcao != 5) {
            imprimirOpcoes();
            leOpcao();
        }
    }

    private void imprimirOpcoes() {
        System.out.println("\n=== McSinos vegan ===\n" +
                "[1] Ver cardápio\n" +
                "[2] Solicitar pedido\n" +
                "[3] Entregar pedido\n" +
                "[4] Ver fila de pedidos\n" +
                "[5] Sair\n");
    }

    private void leOpcao() {
        System.out.println("Digite a opção que deseja: ");
        opcao = teclado.nextInt();
        switch(opcao) {
            case 1:
                verCardapio();
                break;
            case 2:
                solicitarPedido();
                break;
            case 3:
                entregarPedido();
                break;
            case 4:
                verFilaPedidos();
                break;
            case 5:
                break;
            default:
                System.out.println("Essa opção é inválida!");
        }
    }

    public void verCardapio(){
        System.out.println("=== Cardápio McSinos Vegan ===");
        for(int i = 0; i < cardapio.size(); i++){
            System.out.println("[" + (i+1) + "] " + cardapio.get(i).getDescricao() + " || RS$" + cardapio.get(i).getPreco());
        }
    }
    public void solicitarPedido(){
        String sair;
        //int idPedido = 0;
        Pedido pedido = new Pedido();
        int quantidade = -1;
        int numeroProdutoCardapio = -1;

        verCardapio();
        System.out.println("\n=== Aqui você vai solicitar os produtos que deseja! ===");
        while(true) {
            System.out.println("Digite o número do produto: ");
            numeroProdutoCardapio = teclado.nextInt();
            while (numeroProdutoCardapio <= 0 || numeroProdutoCardapio > 10) {
                System.out.println("Número do produto inválido. Digite novamente: ");
                numeroProdutoCardapio = teclado.nextInt();
            }

            System.out.println("Digite a quantidade desejada do produto: ");
            quantidade = teclado.nextInt();
            while (quantidade <= 0) {
                System.out.println("Quantidade inválida. Digite novamente: ");
                quantidade = teclado.nextInt();
            }

            Produto produtoSelecionado = cardapio.get(numeroProdutoCardapio - 1);
            System.out.println(produtoSelecionado.getDescricao() + ", R$: " + produtoSelecionado.getPreco() + ", quantidade: " + quantidade);
            pedido.adicionarItem(new ItemPedido(produtoSelecionado.getDescricao(), produtoSelecionado.getPreco(), quantidade));
            pedido.toString();
            System.out.println("Deseja sair da solicitação? S/N");
            sair = teclado.next();
            if (sair.equalsIgnoreCase("S"))
                break;        }
        FilaPedidos.solicitarPedido(pedido);
    }
    public void entregarPedido(){
        FilaPedidos.entregarPedido();
    }
    public void verFilaPedidos(){
        FilaPedidos.mostrarFilaPedidos();
    }

    public void populaCardapio() {
        cardapio.add(0, new Produto("Hambúrguer de Grão de Bico", 15.00, Produto.TipoProduto.COMIDA));
        cardapio.add(1, new Produto("Hambúrguer de Lentilha", 14.90, Produto.TipoProduto.COMIDA));
        cardapio.add(2, new Produto("Hambúrguer de Cogumelos", 16.50, Produto.TipoProduto.COMIDA));
        cardapio.add(3, new Produto("Hambúrguer de Feijão Preto", 14.00, Produto.TipoProduto.COMIDA));
        cardapio.add(4, new Produto("Hambúrguer de Tofu", 17.00, Produto.TipoProduto.COMIDA));
        cardapio.add(5, new Produto("Suco de Frutas Vermelhas", 8.00, Produto.TipoProduto.BEBIDA));
        cardapio.add(6, new Produto("Suco de Abacaxi com Hortelã", 7.50, Produto.TipoProduto.BEBIDA));
        cardapio.add(7, new Produto("Smoothie de Banana", 9.00, Produto.TipoProduto.BEBIDA));
        cardapio.add(8, new Produto("Chá Gelado de Hibisco", 6.30, Produto.TipoProduto.BEBIDA));
        cardapio.add(9, new Produto("Água de Coco", 5.00, Produto.TipoProduto.BEBIDA));
    }
}

