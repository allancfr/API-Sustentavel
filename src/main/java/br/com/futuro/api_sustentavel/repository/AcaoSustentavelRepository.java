package br.com.futuro.api_sustentavel.repository;

import br.com.futuro.api_sustentavel.model.AcaoSustentavel;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {

    // ESTA LINHA É A MAIS IMPORTANTE E PROVAVELMENTE A CAUSA DO ERRO
    // Verifique se ela existe no seu código.
    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);

}