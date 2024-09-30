
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void mergeSort(List<Pedido> pedidos, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2; 

            mergeSort(pedidos, inicio, meio);
            mergeSort(pedidos, meio + 1, fim);
            merge(pedidos, inicio, meio, fim);
        }
    }

    private static void merge(List<Pedido> pedidos, int inicio, int meio, int fim) {
        int tamEsq = meio - inicio + 1;  
        int tamDir = fim - meio;       

        List<Pedido> esquerda = new ArrayList<>(tamEsq);
        List<Pedido> direita = new ArrayList<>(tamDir);

        for (int i = 0; i < tamEsq; i++) {
            esquerda.add(pedidos.get(inicio + i));
        }

        for (int j = 0; j < tamDir; j++) {
            direita.add(pedidos.get(meio + 1 + j));
        }

        int idxEsq = 0, idxDir = 0;
        int k = inicio; 
     
        while (idxEsq < tamEsq && idxDir < tamDir) {
            if (esquerda.get(idxEsq).getDataHora().isBefore(direita.get(idxDir).getDataHora())) {
                pedidos.set(k++, esquerda.get(idxEsq++));
            } else {
                pedidos.set(k++, direita.get(idxDir++));
            }
        }

        while (idxEsq < tamEsq) {
            pedidos.set(k++, esquerda.get(idxEsq++));
        }

        while (idxDir < tamDir) {
            pedidos.set(k++, direita.get(idxDir++));
        }
    }

    static void exibir(List<Pedido> pedidos) {
        for (Pedido ped : pedidos) {
            System.out.println(ped.toString());
        }
    }
}
