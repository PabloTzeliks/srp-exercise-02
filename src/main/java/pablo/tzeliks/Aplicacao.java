package pablo.tzeliks;

import pablo.tzeliks.model.Pedido;
import pablo.tzeliks.repository.RepositorioDePedido;
import pablo.tzeliks.service.CalculadoraDeTaxas;
import pablo.tzeliks.service.NotificadorDePedido;
import pablo.tzeliks.service.ServicoDeProcessamentoDePedido;
import pablo.tzeliks.service.ValidadorDeEstoque;

/**
 * Classe principal de execução da aplicação de processamento de pedidos.
 * <p>
 * Esta classe é responsável por inicializar as dependências, configurar o serviço
 * de processamento e executar o fluxo principal com um pedido de exemplo.
 * </p>
 * <p>
 * <strong>Créditos:</strong> A lógica original e a estrutura das classes foram desenvolvidas pelo
 * Professor <strong>Lucas Santos</strong> (<a href="https://github.com/engineer-lucas">GitHub: engineer-lucas</a>).
 * <br>
 * Refatoração, ajustes finos e documentação completa via Javadoc foram realizados por <strong>Pablo Ruan Tzeliks</strong>.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class Aplicacao {

    /**
     * Ponto de entrada da aplicação Java.
     * <p>
     * Realiza a injeção de dependência manual dos serviços e executa o processamento
     * de um pedido simulado para demonstrar o fluxo de validação, cálculo, persistência e notificação.
     * </p>
     *
     * @param args Argumentos de linha de comando (não utilizados nesta versão).
     */
    public static void main(String[] args) {
        // Instanciação das classes especializadas (Dependências)
        ValidadorDeEstoque validador = new ValidadorDeEstoque();
        CalculadoraDeTaxas calculadora = new CalculadoraDeTaxas();
        RepositorioDePedido repositorio = new RepositorioDePedido();
        NotificadorDePedido notificador = new NotificadorDePedido();

        // Instanciação do serviço de coordenação com Injeção de Dependência
        ServicoDeProcessamentoDePedido servico = new ServicoDeProcessamentoDePedido(
                validador, calculadora, repositorio, notificador
        );

        // Criação de um Pedido de exemplo para teste
        Pedido pedido1 = new Pedido("PED-789", 450.00, 2, "lucas.ecom@techstore.com");

        System.out.println("--- INICIANDO PROCESSAMENTO DO PEDIDO ---");

        try {
            // Executa o fluxo principal
            Pedido pedidoProcessado = servico.processar(pedido1);

            // Exibe o resultado final no console
            System.out.println("\n--- RESULTADO FINAL ---");
            System.out.println("Status do Pedido " + pedidoProcessado.getId() + ": PAGO");
            System.out.println("Valor Bruto: R$" + pedidoProcessado.getValorBruto());
            System.out.println("Valor Final (com taxas): R$" + pedidoProcessado.getValorFinal());

        } catch (Exception e) {
            // Tratamento de erros de negócio (ex: estoque insuficiente)
            System.out.println("Falha no processamento: " + e.getMessage());
        }
    }
}