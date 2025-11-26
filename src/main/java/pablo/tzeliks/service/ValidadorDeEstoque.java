package pablo.tzeliks.service;

import pablo.tzeliks.model.Pedido;

/**
 * Responsável pela validação de regras de negócio preliminares, especificamente disponibilidade de estoque.
 * <p>
 * Esta classe garante que um pedido atenda aos requisitos operacionais antes de qualquer
 * cálculo financeiro ou persistência. Sua única responsabilidade é proteger o sistema
 * de processar pedidos inválidos ou que excedam a capacidade operacional.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class ValidadorDeEstoque {

    /**
     * Valida se o pedido pode ser atendido com base nas regras de estoque atuais.
     * <p>
     * Verifica a quantidade de itens solicitada no pedido. Se a quantidade exceder
     * o limite operacional permitido (atualmente 100 itens), uma exceção é lançada
     * para interromper o fluxo de processamento imediatamente.
     * </p>
     * <p>
     * <strong>Regra de Mudança:</strong> Esta classe deve ser alterada apenas se as
     * regras de validação de quantidade, verificação de saldo de estoque ou limites
     * por pedido mudarem.
     * </p>
     *
     * @param pedido O objeto {@link Pedido} contendo a quantidade de itens a ser verificada.
     * @throws Exception Se a quantidade de itens exceder o limite de estoque disponível ou permitido.
     */
    public void validar(Pedido pedido) throws Exception {
        // Esta classe muda SOMENTE se a regra de validação de estoque ou quantidade mudar.
        if (pedido.getQuantidadeItens() > 100) {
            throw new Exception("Estoque insuficiente para a quantidade solicitada.");
        }
        System.out.println("-> Validação de estoque OK.");
    }
}