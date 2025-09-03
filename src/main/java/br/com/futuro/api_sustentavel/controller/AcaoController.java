package br.com.futuro.api_sustentavel.controller;

import br.com.futuro.api_sustentavel.model.Acao;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import br.com.futuro.api_sustentavel.service.AcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoController {

    @Autowired
    private AcaoService acaoService;

    /**
     * Endpoint para filtrar ações sustentáveis por categoria.
     * Exemplo de uso: GET /acoes/categoria?tipo=RECICLAGEM
     * @param categoria O tipo da categoria vindo do parâmetro 'tipo' na URL.
     * @return Uma resposta HTTP com a lista de ações encontradas e status 200 (OK).
     */
    @GetMapping("/categoria")
    public ResponseEntity<List<Acao>> buscarPorCategoria(@RequestParam("tipo") CategoriaAcao categoria) {
        List<Acao> acoesEncontradas = acaoService.encontrarPorCategoria(categoria);
        return ResponseEntity.ok(acoesEncontradas);
    }
}