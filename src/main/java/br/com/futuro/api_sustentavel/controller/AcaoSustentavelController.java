package br.com.futuro.api_sustentavel.controller;

import br.com.futuro.api_sustentavel.dto.AcaoSustentavelRequest;
import br.com.futuro.api_sustentavel.dto.AcaoSustentavelResponse;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import br.com.futuro.api_sustentavel.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller para gerenciar as operações CRUD de Ações Sustentáveis.
 * Define a URL base "/acoes" para todos os endpoints.
 */
@RestController
@RequestMapping("/acoes")
public class AcaoSustentavelController {

    @Autowired
    private AcaoSustentavelService acaoSustentavelService;

    /**
     * Endpoint para cadastrar uma nova ação sustentável.
     * URL: POST /acoes
     * @param request DTO com os dados da nova ação.
     * @return Resposta com a nova ação criada e status 201 CREATED.
     */
    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> cadastrar(@Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse response = acaoSustentavelService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Endpoint para listar todas as ações sustentáveis.
     * URL: GET /acoes
     * @return Lista com todas as ações e status 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<AcaoSustentavelResponse>> listarTodas() {
        List<AcaoSustentavelResponse> response = acaoSustentavelService.listarTodas();
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint para buscar uma ação sustentável pelo seu ID.
     * URL: GET /acoes/{id}
     * @param id O ID da ação a ser buscada.
     * @return A ação encontrada com status 200 OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> buscarPorId(@PathVariable Long id) {
        AcaoSustentavelResponse response = acaoSustentavelService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint para filtrar ações por categoria.
     * URL: GET /acoes/categoria?tipo=NOME_DA_CATEGORIA
     * @param categoria O tipo de categoria para filtrar.
     * @return Lista de ações filtradas com status 200 OK.
     */
    @GetMapping("/categoria")
    public ResponseEntity<List<AcaoSustentavelResponse>> buscarPorCategoria(@RequestParam("tipo") CategoriaAcao categoria) {
        List<AcaoSustentavelResponse> response = acaoSustentavelService.listarPorCategoria(categoria);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint para atualizar uma ação sustentável existente.
     * URL: PUT /acoes/{id}
     * @param id O ID da ação a ser atualizada.
     * @param request DTO com os novos dados da ação.
     * @return A ação atualizada com status 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse response = acaoSustentavelService.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint para remover uma ação sustentável.
     * URL: DELETE /acoes/{id}
     * @param id O ID da ação a ser removida.
     * @return Resposta sem conteúdo e com status 204 NO CONTENT.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        acaoSustentavelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}