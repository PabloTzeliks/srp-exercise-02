package pablo.tzeliks.repository;

import pablo.tzeliks.model.Pedido;

/**
 * Responsável pela persistência de objetos {@link Pedido} no banco de dados.
 * <p>
 * Esta classe encapsula todas as operações de acesso a dados (DAO/Repository pattern).
 * Sua única responsabilidade é comunicar-se com a camada de armazenamento, isolando
 * a lógica de negócios de detalhes técnicos de banco de dados (SQL, JPA, arquivos, etc).
 * </p>
 *
 * @author Pablo Ruan Tzeliks
 * @version 2.0.0
 * @since 26/11/2025
 */
public class RepositorioDePedido {

    /**
     * Persiste um pedido no banco de dados.
     * <p>
     * Este método simula a operação de inserção ou atualização de um registro
     * na base de dados. Se a tecnologia de persistência mudar, apenas esta classe
     * precisará ser alterada.
     * </p>
     *
     * @param pedido O objeto {@link Pedido} a ser salvo. Não deve ser nulo.
     */
    public void salvar(Pedido pedido) {
        // Esta classe muda SOMENTE se a tecnologia de persistência mudar (ex: de SQL para JPA).
        System.out.println("-> Persistência: Pedido " + pedido.getId() + " salvo no banco de dados.");
    }
}