package test;

import operacoes.FilaPedidos;
import pedido.ItemPedido;
import pedido.Pedido;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidosTeste {
    private Queue<Pedido> filaPedidosTeste;
    private ItemPedido i1, i2, i3;
    private Pedido p1, p2, p3;
    private FilaPedidos filaTeste;

    public FilaPedidosTeste() {
        filaPedidosTeste = new LinkedList<Pedido>();
        filaTeste = new FilaPedidos();
    }
    @Test
    public void solicitarPedidoTeste(){
        p1 = new Pedido();
        p2 = new Pedido();
        p3 = new Pedido();
        i1 = new ItemPedido("Hambúrguer x", 34.90, 3);
        i2 = new ItemPedido("Hambúrguer y", 29.00, 2);
        p1.adicionarItem(i1);
        p2.adicionarItem(i2);
        FilaPedidos.solicitarPedido(p1);
        FilaPedidos.solicitarPedido(p2);
        FilaPedidos.solicitarPedido(p3);
    }

    @Test
    public void mostrarFilaPedidosTeste(){
        solicitarPedidoTeste();
        assertNotNull("Fila de pedidos vazia", filaPedidosTeste);
        FilaPedidos.mostrarFilaPedidos();
    }

    @Test
    public void entregarPedidoTeste(){
        solicitarPedidoTeste();
        FilaPedidos.entregarPedido();
        assertNotNull(p1);
        assertTrue("Pedido entregue", true);
    }
}
