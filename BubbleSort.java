import java.util.List;

public class BubbleSort {

    public void sort(List<Pedido> pedidos) {
        int comprimento = pedidos.size();
        for (int i = 0; i < comprimento; i++) {
            for (int j = 0; j < (comprimento - i - 1); j++) {
                if (pedidos.get(j).getDataHora().isAfter(pedidos.get(j + 1).getDataHora())) {
                    Pedido temp = pedidos.get(j);
                    pedidos.set(j, pedidos.get(j + 1));
                    pedidos.set(j + 1, temp);
                }
            }
        }
        System.out.println("Ordenado com BubbleSort :");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }
}
