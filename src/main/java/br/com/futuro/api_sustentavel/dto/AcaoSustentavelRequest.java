package br.com.futuro.api_sustentavel.dto;

import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AcaoSustentavelRequest {

    // Note que não temos o 'id' aqui, pois ele é gerado pelo banco na criação.

    @NotBlank(message = "O título não pode ser vazio ou nulo.")
    @Size(min = 3, max = 150, message = "O título deve conter entre 3 e 150 caracteres.")
    private String titulo;

    @NotBlank(message = "A descrição não pode ser vazia ou nula.")
    @Size(min = 10, max = 1000, message = "A descrição deve conter entre 10 e 1000 caracteres.")
    private String descricao;

    @NotNull(message = "A categoria não pode ser nula.")
    private CategoriaAcao categoria;

    @NotNull(message = "A data de realização não pode ser nula.")
    @PastOrPresent(message = "A data de realização não pode ser uma data futura.")
    private LocalDate dataRealizacao;

    @NotBlank(message = "O responsável não pode ser vazio ou nulo.")
    private String responsavel;

}