package pablo.tzeliks.service;

import pablo.tzeliks.model.Pedido;
import pablo.tzeliks.repository.RepositorioDePedido;

/**
 * Orquestrador responsável por coordenar o fluxo de processamento de um pedido.
 * <p>
 * Esta classe implementa o padrão de projeto Facade/Service Layer, atuando como um ponto central
 * que delega tarefas para classes especializadas (Single Responsibility Principle).
 * Sua única responsabilidade é garantir a execução sequencial correta das etapas de validação,
 * cálculo, persistência e notificação.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class ServicoDeProcessamentoDePedido {

    private final ValidadorDeEstoque validador;
    private final CalculadoraDeTaxas calculadora;
    private final RepositorioDePedido repositorio;
    private final NotificadorDePedido notificador;

    /**
     * Construtor para injeção de dependências.
     * <p>
     * Utiliza o princípio de Inversão de Dependência (DIP) para receber as implementações
     * necessárias, facilitando testes unitários e desacoplamento.
     * </p>
     *
     * @param validador   Serviço responsável pela verificação de disponibilidade de itens.
     * @param calculadora Serviço responsável pelos cálculos financeiros (frete, impostos).
     * @param repositorio Repositório para persistência dos dados do pedido.
     * @param notificador Serviço de comunicação para envio de mensagens ao cliente.
     */
    public ServicoDeProcessamentoDePedido(
            ValidadorDeEstoque validador,
            CalculadoraDeTaxas calculadora,
            RepositorioDePedido repositorio,
            NotificadorDePedido notificador) {

        this.validador = validador;
        this.calculadora = calculadora;
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    /**
     * Executa o fluxo completo de processamento de um pedido.
     * <p>
     * O fluxo consiste nas seguintes etapas sequenciais:
     * <ol>
     * <li><strong>Validação:</strong> Verifica se há estoque disponível.</li>
     * <li><strong>Cálculo:</strong> Aplica taxas, fretes e atualiza o valor final.</li>
     * <li><strong>Pagamento:</strong> Simula a confirmação do pagamento.</li>
     * <li><strong>Persistência:</strong> Salva o estado atualizado do pedido no banco.</li>
     * <li><strong>Notificação:</strong> Envia confirmação para o cliente.</li>
     * </ol>
     * </p>
     *
     * @param pedido O objeto {@link Pedido} a ser processado.
     * @return O objeto {@link Pedido} atualizado com valores finais e status de pagamento.
     * @throws Exception Se ocorrer erro em qualquer etapa do processo (ex: falta de estoque).
     */
    public Pedido processar(Pedido pedido) throws Exception {
        // 1. Validação: Garante que o pedido é válido antes de prosseguir
        validador.validar(pedido);

        // 2. Cálculo: Determina o custo financeiro total
        double valorFinal = calculadora.calcularValorFinal(pedido);
        pedido.setValorFinal(valorFinal);

        // Simulação de pagamento (Em um cenário real, chamaria um Gateway de Pagamento)
        pedido.setPago(true);

        // 3. Persistência: Grava o resultado final para segurança dos dados
        repositorio.salvar(pedido);

        // 4. Notificação: Informa o usuário sobre o sucesso da operação
        notificador.enviarConfirmacao(pedido);

        return pedido;
    }
}