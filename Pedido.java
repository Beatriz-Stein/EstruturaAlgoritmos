import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Pedido {
    
    private LocalDateTime data;
    private int idPedido;
    private double valorPedido;
    private String nomeCliente;

    private static String[] primeirosNomes = {
        "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", 
        "Fernanda", "Gabriel", "Helena", "Igor", "Juliana",
        "Lucas", "Mariana", "Nicolas", "Olivia", "Paulo"
    };
    
    private static String[] sobrenomes = {
        "Silva", "Santos", "Oliveira", "Souza", "Pereira",
        "Almeida", "Costa", "Ribeiro", "Martins", "Araujo"
    };

    public Pedido(){

    };

    public Pedido(LocalDateTime data, int idPedido, double valorPedido, String nome) {
        this.data = data;
        this.idPedido = idPedido;
        this.valorPedido = valorPedido;
        this.nomeCliente = nome;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public LocalDateTime getDataHora() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getIdPedido() {
        return idPedido;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String gerarNome() {
        Random random = new Random();
        String primeiroNome = primeirosNomes[random.nextInt(primeirosNomes.length)];
        String sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
        return primeiroNome + " " + sobrenome;
    };
    
    public void gerarValorPedido(int nQuantPedidos) { 
        Random numAleatorio = new Random();
        for (int i = 0; i < nQuantPedidos; i++) {
            valorPedido = Math.round(numAleatorio.nextDouble() * 1000.0 * 100.0) / 100.0;
        }
    }
    public void gerarPedidoAutomatico(int quantidadePedido) {
        this.idPedido = new Random().nextInt(1000000);
        this.nomeCliente = gerarNome(); 
        this.data = gerarDataHoraAleatoria();
        gerarValorPedido(1);
    }

    public String formataData(LocalDateTime data) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       return data.atZone(ZoneId.of("America/Sao_Paulo")).format(formatter);
    }

    public String exibeData(){
        return formataData(data);
    }

    public String mostraData(LocalDateTime data){
        return formataData(data);
    }

    @Override
    public String toString() {
        return "Pedido ID: " + this.idPedido + 
               ", Nome do Cliente: " + this.nomeCliente + 
               ", Data: " + this.data + 
               ", Valor do Pedido: R$ " + String.format("%.2f", this.valorPedido);
    }

    public static LocalDateTime gerarDataHoraAleatoria() {
        Random random = new Random();

        LocalDateTime dataInicio = LocalDateTime.of(2024, 9, 1, 0, 0);
        LocalDateTime dataFim = LocalDateTime.of(2024, 9, 1, 23, 59);

        long segundosEntre = java.time.Duration.between(dataInicio, dataFim).getSeconds();

        long segundosAleatorios = random.nextInt((int) segundosEntre + 1);

        return dataInicio.plusSeconds(segundosAleatorios);
    } 

}
