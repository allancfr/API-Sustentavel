package br.com.futuro.api_sustentavel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "acao") // Boa prática para definir o nome da tabela
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    // Este é o campo que permite o filtro
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria") // Mapeia para a coluna 'categoria' no banco
    private CategoriaAcao categoria;

    // --- Construtores, Getters e Setters ---

    // Construtor vazio é necessário para o JPA
    public Acao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAcao getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAcao categoria) {
        this.categoria = categoria;
    }
}