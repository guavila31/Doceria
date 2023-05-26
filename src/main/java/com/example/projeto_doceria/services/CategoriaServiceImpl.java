package com.example.projeto_doceria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.projeto_doceria.dtos.CategoriaDTO;
import com.example.projeto_doceria.dtos.DadosCategoriaDTO;
import com.example.projeto_doceria.exceptions.RegraNegocioException;
import com.example.projeto_doceria.models.Categoria;
import com.example.projeto_doceria.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        return categoriaRepository.save(categoria);
    }

    @Override
    public DadosCategoriaDTO obterCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).map((Categoria d) -> {
            return DadosCategoriaDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .build();
        }).orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
    }

    @Override
    public void remover(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, CategoriaDTO categoriaDto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        categoria.setNome(categoriaDto.getNome());
        categoriaRepository.save(categoria);
    }

    @Override
    public List<DadosCategoriaDTO> sobterTodos() {
        return categoriaRepository.findAll().stream().map((Categoria d) -> {
            return DadosCategoriaDTO.builder()
                    .id(d.getId())
                    .nome(d.getNome())
                    .build();
        }).collect(Collectors.toList());
    }

    
}
