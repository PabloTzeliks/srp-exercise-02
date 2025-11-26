package pablo.tzeliks.service;

import pablo.tzeliks.model.Pedido;

/**
 * Responsável pela comunicação externa e envio de notificações sobre o estado do pedido.
 * <p>
 * Esta classe encapsula a lógica de interação com sistemas de mensagens (como e-mail, SMS,
 * Webhooks ou Push Notifications). Sua única responsabilidade é garantir que o cliente
 * ou sistemas terceiros sejam avisados sobre eventos relevantes do pedido.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class NotificadorDePedido {

    /**
     * Envia uma notificação de confirmação para o cliente, caso o pagamento esteja confirmado.
     * <p>
     * Este método verifica se o pedido está pago (`isPago()`) antes de proceder com o envio.
     * Atualmente, a implementação simula o envio de um e-mail para o endereço cadastrado no pedido.
     * </p>
     * <p>
     * <strong>Regra de Mudança:</strong> Esta classe deve ser alterada apenas se o canal de comunicação
     * mudar (ex: trocar de E-mail para SMS) ou se a biblioteca de envio de e-mails for substituída.
     * </p>
     *
     * @param pedido O objeto {@link Pedido} contendo os dados do destinatário e status de pagamento.
     */
    public void enviarConfirmacao(Pedido pedido) {
        // Esta classe muda SOMENTE se o serviço de notificação (e-mail, SMS) mudar.
        if (pedido.isPago()) {
            System.out.println("-> Notificação: Email de confirmação enviado para: " + pedido.getEmailCliente());
        }
    }
}