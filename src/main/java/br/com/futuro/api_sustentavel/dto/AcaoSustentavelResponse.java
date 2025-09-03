package br.com.futuro.api_sustentavel.dto;

import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AcaoSustentavelResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private CategoriaAcao categoria;
    private LocalDate dataRealizacao;
    private String responsavel;

}