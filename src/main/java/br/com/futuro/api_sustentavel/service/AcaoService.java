package br.com.futuro.api_sustentavel.service;

import br.com.futuro.api_sustentavel.model.Acao;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import br.com.futuro.api_sustentavel.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaoService {

    @Autowired
    private AcaoRepository acaoRepository;

    /**
     * Contém a lógica de negócio para buscar ações por categoria.
     * Neste caso, apenas repassa a chamada para o repositório.
     * @param categoria A categoria para filtrar as ações.
     * @return A lista de ações filtrada.
     */
    public List<Acao> encontrarPorCategoria(CategoriaAcao categoria) {
        return acaoRepository.findByCategoria(categoria);
    }
}