package br.com.futuro.api_sustentavel.service;

import br.com.futuro.api_sustentavel.dto.AcaoSustentavelRequest;
import br.com.futuro.api_sustentavel.dto.AcaoSustentavelResponse;
import br.com.futuro.api_sustentavel.exception.RecursoNaoEncontradoException;
import br.com.futuro.api_sustentavel.model.AcaoSustentavel;
import br.com.futuro.api_sustentavel.model.CategoriaAcao;
import br.com.futuro.api_sustentavel.repository.AcaoSustentavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoSustentavelService {

    @Autowired
    private AcaoSustentavelRepository acaoSustentavelRepository;

    public AcaoSustentavelResponse cadastrar(AcaoSustentavelRequest request) {
        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setCategoria(request.getCategoria());
        acao.setDataRealizacao(request.getDataRealizacao());
        acao.setResponsavel(request.getResponsavel());

        AcaoSustentavel acaoSalva = acaoSustentavelRepository.save(acao);
        return mapToResponse(acaoSalva);
    }

    public List<AcaoSustentavelResponse> listarTodas() {
        return acaoSustentavelRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse buscarPorId(Long id) {
        AcaoSustentavel acao = acaoSustentavelRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));
        return mapToResponse(acao);
    }

    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest request) {
        AcaoSustentavel acao = acaoSustentavelRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada."));

        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setCategoria(request.getCategoria());
        acao.setDataRealizacao(request.getDataRealizacao());
        acao.setResponsavel(request.getResponsavel());

        AcaoSustentavel acaoAtualizada = acaoSustentavelRepository.save(acao);
        return mapToResponse(acaoAtualizada);
    }

    public void deletar(Long id) {
        if (!acaoSustentavelRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ação com ID " + id + " não encontrada.");
        }
        acaoSustentavelRepository.deleteById(id);
    }

    // NOVO MÉTODO ADICIONADO AQUI
    public List<AcaoSustentavelResponse> listarPorCategoria(CategoriaAcao categoria) {
        List<AcaoSustentavel> acoes = acaoSustentavelRepository.findByCategoria(categoria);
        return acoes.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AcaoSustentavelResponse mapToResponse(AcaoSustentavel acao) {
        AcaoSustentavelResponse response = new AcaoSustentavelResponse();
        response.setId(acao.getId());
        response.setTitulo(acao.getTitulo());
        response.setDescricao(acao.getDescricao());
        response.setCategoria(acao.getCategoria());
        response.setDataRealizacao(acao.getDataRealizacao());
        response.setResponsavel(acao.getResponsavel());
        return response;
    }
}