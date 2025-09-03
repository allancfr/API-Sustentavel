package br.com.futuro.api_sustentavel.repository;

import br.com.futuro.api_sustentavel.model.Acao;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {

    /**
     * Busca no banco de dados todas as Ações que pertencem a uma Categoria específica.
     * O Spring Data JPA implementa este método automaticamente.
     * @param categoria O Enum da categoria a ser buscada.
     * @return Uma lista de Ações encontradas.
     */
    List<Acao> findByCategoria(CategoriaAcao categoria);

}