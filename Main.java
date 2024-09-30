
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcaoSelecionada = 0;
        int somaTotal = 0;
        int quantidadePedido;
        String nomeCliente;
        Double precoProduto;

        BubbleSort bubbleSort = new BubbleSort();
        List<Pedido> pedidos = new ArrayList<>();

        System.out.println("Olá, bem-vindo ao sistema");

        while (opcaoSelecionada != 9) {
            System.out.println("Digite a opção:");
            System.out.println("1 - Inserir Pedido manualmente");
            System.out.println("2 - Gerar Pedidos automaticamente");
            System.out.println("3 - Ordenar e visualizar com Bubble Sort");
            System.out.println("4 - Ordenar e visualizar com Merge Sort");
            System.out.println("5 - Visualizar Pedidos não ordenados");
            System.out.println("6 - Total de pedidos");
            System.out.println("7 - Soma total do valor dos pedidos");
            System.out.println("8 - Apagar pedidos");
            System.out.println("9 - Finalizar Programa");

            System.out.print("Opção selecionada: ");
            opcaoSelecionada = sc.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    System.out.print("Informe quantos pedidos você pretende fazer?");
                    quantidadePedido = sc.nextInt();
                    for (int i = 0; i < quantidadePedido; i++) {
                        LocalDateTime dataHora = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
                        System.out.print("Nome do Cliente:");
                        nomeCliente = sc.next();
                        System.out.print("Preço do Produto:");
                        precoProduto = sc.nextDouble();
                        Pedido pedido = new Pedido(dataHora, i, precoProduto, nomeCliente);
                        pedidos.add(pedido);
                    }
                    System.out.println("+ " + quantidadePedido + " pedidos foram adicionados!");
                    break;
                case 2:
                    System.out.print("Informe quantos pedidos você pretende fazer?");
                    quantidadePedido = sc.nextInt();
                    for (int i = 0; i < quantidadePedido; i++) {
                        Pedido pedidosAutomatico = new Pedido();
                        pedidosAutomatico.gerarPedidoAutomatico(quantidadePedido);
                        pedidos.add(pedidosAutomatico);
                    }
                    System.out.println("+ " + quantidadePedido + " pedidos foram adicionados!");
                    break;
                case 3:
                    long inicioB = System.currentTimeMillis();
                    LocalDateTime inicioAlgoritmoB = LocalDateTime.now();
                    bubbleSort.sort(pedidos);
                    long finalB = System.currentTimeMillis();
                    LocalDateTime finalAlgoritmoB = LocalDateTime.now();
                    System.out.println("Algoritmo BubbleSort");
                    System.out.println("Algoritmo inicializado em: " + formataData(inicioAlgoritmoB));
                    System.err.println("Tempo inicial em milissegundos: " + inicioB);
                    System.out.println("Algoritmo finalizado em: " + formataData(finalAlgoritmoB));
                    System.err.println("Tempo final em milissegundos: " + finalB);
                    System.out.println("Tempo de execução : " + (finalB-inicioB) +" ms");
                    break;
                case 4:
                    long inicioM = System.currentTimeMillis();
                    LocalDateTime inicioAlgoritmoM = LocalDateTime.now();
                    MergeSort.mergeSort(pedidos, 0, pedidos.size() - 1);
                    long finalM = System.currentTimeMillis();
                    LocalDateTime finalAlgoritmoM = LocalDateTime.now();
                    MergeSort.exibir(pedidos);
                    System.err.println("Algoritmo MergeSort");
                    System.out.println("Algoritmo inicializado em: " + formataData(inicioAlgoritmoM));
                    System.err.println("Tempo inicial em milissegundos: " + inicioM);
                    System.out.println("Algoritmo finalizado em: " + formataData(finalAlgoritmoM));
                    System.err.println("Tempo final em milissegundos: " + finalM);
                    System.out.println("Tempo de execução : " + (finalM-inicioM) +" ms");
                    break;
                case 5:
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido.toString());
                    }
                    if (pedidos.isEmpty()) {
                        System.out.println("Não há pedidos");
                    }
                    break;
                case 6:
                    System.out.println("Total de pedidos: " + pedidos.size());
                    break;
                case 7:
                    for (int i = 0; i < pedidos.size(); i++) {
                        somaTotal += pedidos.get(i).getValorPedido();
                    }
                    System.out.println("Soma total do valor dos pedidos: " + somaTotal);
                    break;
                case 8:
                    System.out.println("Deseja apagar todos os pedidos?");
                    if (sc.next().equalsIgnoreCase("sim")) {
                        pedidos.clear();
                        System.out.println("Todos os pedidos foram apagados!");
                    } else {
                        System.out.println("Quantos pedidos você deseja apagar?");
                        int quantidadeApagar = sc.nextInt();
                        for (int i = 0; i < quantidadeApagar; i++) {
                            pedidos.remove(i);
                        }
                        System.out.println("Total de pedidos: " + pedidos.size());;
                    }
                    break;
                case 9:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    break;
            }

        }

    }
    public static String formataData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
