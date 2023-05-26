package com.example.projeto_doceria.services;

import java.util.List;

import com.example.projeto_doceria.dtos.CategoriaDTO;
import com.example.projeto_doceria.dtos.DadosCategoriaDTO;
import com.example.projeto_doceria.models.Categoria;

public interface CategoriaService {
    Categoria salvar(CategoriaDTO dto);

    DadosCategoriaDTO obterCategoriaPorId(Long id);

    void remover(Long id);

    void editar(Long id, CategoriaDTO cursoDto);

    List<DadosCategoriaDTO> sobterTodos();
}
