package pablo.tzeliks.service;

import pablo.tzeliks.model.Pedido;

/**
 * Responsável pela lógica de domínio financeiro e cálculos de taxas.
 * <p>
 * Esta classe isola as regras de negócio complexas relacionadas a custos, como
 * cálculo de frete, impostos e descontos. Sua responsabilidade é puramente
 * matemática e financeira, não devendo manipular persistência ou notificação.
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class CalculadoraDeTaxas {

    /**
     * Calcula o valor final de um pedido aplicando regras de frete e impostos.
     * <p>
     * O cálculo considera o valor bruto do pedido, soma o frete aplicável
     * e adiciona uma taxa fixa de impostos (atualmente 15%).
     * </p>
     * <p>
     * <strong>Regra de Mudança:</strong> Esta classe/método deve ser alterada apenas
     * se as regras fiscais, alíquotas de imposto ou tabelas de frete mudarem.
     * </p>
     *
     * @param pedido O pedido contendo o valor bruto base para o cálculo.
     * @return O valor monetário final (double) a ser cobrado do cliente.
     */
    public double calcularValorFinal(Pedido pedido) {
        double valor = pedido.getValorBruto();
        double frete = calcularFrete(valor);
        double impostos = valor * 0.15; // 15% de imposto fixo

        double valorFinal = valor + frete + impostos;

        System.out.println("-> Frete (R$" + frete + ") e Impostos (R$" + impostos + ") calculados.");

        return valorFinal;
    }

    /**
     * Calcula o valor do frete com base no valor total dos itens.
     * <p>
     * Regra atual:
     * <ul>
     * <li>Pedidos abaixo de R$ 500,00: Frete de R$ 50,00.</li>
     * <li>Pedidos de R$ 500,00 ou mais: Frete Grátis.</li>
     * </ul>
     * </p>
     *
     * @param valor O valor base para cálculo do frete.
     * @return O valor do frete a ser cobrado.
     */
    private double calcularFrete(double valor) {
        if (valor < 500.00) {
            return 50.00;
        }
        return 0.0;
    }

}