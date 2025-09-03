package br.com.futuro.api_sustentavel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "acoes_sustentaveis")
@Getter
@Setter
@NoArgsConstructor // 1. Lombok: Cria um construtor vazio (sem argumentos), exigido pelo JPA.
@AllArgsConstructor // 2. Lombok: Cria um construtor com todos os campos, útil para testes.
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;

    private LocalDate dataRealizacao;

    private String responsavel;

}