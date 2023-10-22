package operacoes;

import pedido.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos {
    private static Queue<Pedido> filaPedidos;

    public FilaPedidos() {
        this.filaPedidos = new LinkedList<Pedido>();
    }

    public static void mostrarFilaPedidos(){
        if(!filaPedidos.isEmpty()){
        System.out.println("=== Fila de pedidos === ");
        for (Pedido pedido : filaPedidos)
            System.out.println(pedido.toString() + "\n");
        }
        else
            System.out.println("A fila está vazia.");
    }

    public static void solicitarPedido(Pedido pedido){
        pedido.setNumeroPedido(filaPedidos.size()+1);
        filaPedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getNumeroPedido() + " adicionado à fila.");
    }

    public static void entregarPedido(){
        try{
        Pedido pedido = filaPedidos.poll();
        if(pedido != null){
            System.out.println("Pedido #" + pedido.getNumeroPedido() + " entregue: ");
            System.out.println(pedido.enlistaProdutos());
        }
        else
            System.out.println("Não há pedidos na fila.");
        } catch (Exception ex){
            System.out.println("Não há pedidos a serem entregues.");
        }
    }
}
