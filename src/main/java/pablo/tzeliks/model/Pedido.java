package pablo.tzeliks.model;

/**
 * Representa uma entidade de dados para um Pedido no sistema de vendas.
 * <p>
 * Esta classe é responsável por encapsular as informações fundamentais de uma transação,
 * servindo como objeto de transferência de dados (DTO) ou entidade de domínio.
 * Mantém o estado do pedido, incluindo valores monetários, identificação do cliente
 * e status de pagamento.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class Pedido {

    /**
     * Identificador único do pedido.
     */
    private String id;

    /**
     * Valor total bruto dos itens do pedido, sem aplicação de descontos ou taxas.
     */
    private double valorBruto;

    /**
     * Valor final do pedido após processamento de regras de negócio (descontos, taxas, etc).
     * Inicialmente, é igual ao valor bruto.
     */
    private double valorFinal;

    /**
     * Quantidade total de itens contidos neste pedido.
     */
    private int quantidadeItens;

    /**
     * Indica o status do pagamento do pedido.
     * {@code true} se o pedido já foi pago, {@code false} caso contrário.
     */
    private boolean isPago;

    /**
     * Endereço de e-mail do cliente associado ao pedido.
     */
    private String emailCliente;

    /**
     * Constrói uma nova instância de {@code Pedido} com os dados iniciais obrigatórios.
     * <p>
     * Ao instanciar, o status de pagamento é definido como {@code false} (não pago)
     * e o valor final é inicializado com o mesmo valor do valor bruto.
     * </p>
     *
     * @param id              O identificador único do pedido.
     * @param valorBruto      O valor monetário bruto total do pedido.
     * @param quantidadeItens A quantidade de itens inclusos no pedido.
     * @param emailCliente    O e-mail do cliente responsável pelo pedido.
     */
    public Pedido(String id, double valorBruto, int quantidadeItens, String emailCliente) {
        this.id = id;
        this.valorBruto = valorBruto;
        this.quantidadeItens = quantidadeItens;
        this.isPago = false;
        this.emailCliente = emailCliente;
        this.valorFinal = valorBruto;
    }

    // --- Getters e Setters ---

    /**
     * Define o identificador do pedido.
     *
     * @param id O novo identificador a ser atribuído.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Define o valor bruto do pedido.
     *
     * @param valorBruto O valor bruto a ser atribuído.
     */
    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    /**
     * Define a quantidade de itens do pedido.
     *
     * @param quantidadeItens A quantidade de itens a ser atribuída.
     */
    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    /**
     * Define o e-mail do cliente.
     *
     * @param emailCliente O e-mail a ser associado ao pedido.
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     * Obtém o identificador único do pedido.
     *
     * @return Uma String representando o ID do pedido.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtém o valor bruto do pedido.
     *
     * @return O valor bruto (double).
     */
    public double getValorBruto() {
        return valorBruto;
    }

    /**
     * Obtém a quantidade de itens no pedido.
     *
     * @return Um inteiro representando a quantidade de itens.
     */
    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    /**
     * Verifica se o pedido está pago.
     *
     * @return {@code true} se o pagamento foi confirmado, {@code false} caso contrário.
     */
    public boolean isPago() {
        return isPago;
    }

    /**
     * Obtém o e-mail do cliente.
     *
     * @return Uma String contendo o e-mail.
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * Obtém o valor final do pedido (considerando processamentos posteriores à criação).
     *
     * @return O valor final a ser cobrado.
     */
    public double getValorFinal() {
        return valorFinal;
    }

    /**
     * Define o valor final do pedido.
     * <p>
     * Utilize este método para atualizar o valor após cálculos de frete, impostos ou descontos.
     * </p>
     *
     * @param valorFinal O novo valor final calculado.
     */
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    /**
     * Altera o status de pagamento do pedido.
     *
     * @param pago {@code true} para marcar como pago, {@code false} para pendente.
     */
    public void setPago(boolean pago) {
        this.isPago = pago;
    }

    /**
     * Retorna uma representação em String do objeto Pedido.
     * <p>
     * Inclui todos os campos principais formatados para log ou depuração.
     * </p>
     *
     * @return Uma String contendo os dados do estado atual do objeto.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " Valor Bruto: " + valorBruto +
                " Valor Final: " + valorFinal +
                " Quantidade Itens: " + quantidadeItens +
                " Foi Pago: " + isPago +
                " Email Cliente: " + emailCliente;
    }
}