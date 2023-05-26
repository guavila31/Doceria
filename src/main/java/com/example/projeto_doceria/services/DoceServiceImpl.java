package com.example.projeto_doceria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.projeto_doceria.dtos.CategoriaDTO;
import com.example.projeto_doceria.dtos.DadosDocesDTO;
import com.example.projeto_doceria.dtos.DocesDTO;
import com.example.projeto_doceria.exceptions.RegraNegocioException;
import com.example.projeto_doceria.models.Categoria;
import com.example.projeto_doceria.models.Doce;
import com.example.projeto_doceria.repositories.CategoriaRepository;
import com.example.projeto_doceria.repositories.DoceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoceServiceImpl implements DoceService {

    private final DoceRepository doceRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public Long salvar(DocesDTO docesDTO) {
        Categoria categoria = categoriaRepository.findById(docesDTO.getCategoriaDoceId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        Doce doce = new Doce();
        doce.setNome(docesDTO.getNome());
        doce.setCurtidas(docesDTO.getCurtidas());
        doce.setIngredientes(docesDTO.getIngredientes());
        doce.setCategoria(categoria);

        Doce novoDoce = doceRepository.save(doce);
        return novoDoce.getId();
    }

    @Override
    public DadosDocesDTO obterDocesPorId(Long id) {
        return doceRepository.findById(id).map((Doce d) -> {
            return DadosDocesDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .curtidas(d.getCurtidas())
                    .ingredientes(d.getIngredientes())
                    .categoria(CategoriaDTO.builder()
                            .id(d.getCategoria().getId())
                            .nome(d.getCategoria().getNome())
                            .build())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Doce não encontrado"));

    }

    @Override
    @Transactional
    public void remover(Long id) {
        doceRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void editar(Long id, DocesDTO doceDto) {
        Doce doce = doceRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Doce não encontrado"));

        Categoria categoria = categoriaRepository.findById(
                doceDto.getCategoriaDoceId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        doce.setNome(doceDto.getNome());
        doce.setCurtidas(doceDto.getCurtidas());
        doce.setIngredientes(doceDto.getIngredientes());
        doce.setCategoria(categoria);
        doceRepository.save(doce);
    }

    @Override
    @Transactional
    public void adicionarCurtida(Long id, DocesDTO doceDto) {
        Doce doce = doceRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Doce não encontrado"));

        Categoria categoria = categoriaRepository.findById(
                doceDto.getCategoriaDoceId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        doce.setNome(doceDto.getNome());
        doce.setCurtidas(doceDto.getCurtidas());
        doce.setIngredientes(doceDto.getIngredientes());
        doce.setCategoria(categoria);
        doceRepository.save(doce);
    }

    @Override
    @Transactional
    public List<DadosDocesDTO> sobterTodos() {
        return doceRepository.findAll().stream().map((Doce d) -> {
            return DadosDocesDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .curtidas(d.getCurtidas())
                    .ingredientes(d.getIngredientes())
                    .categoria(CategoriaDTO.builder()
                            .id(d.getCategoria().getId())
                            .nome(d.getCategoria().getNome())
                            .build())
                    .build();
        }).collect(Collectors.toList());

    }

}
