package com.example.projeto_doceria.services;

import java.util.List;

import com.example.projeto_doceria.dtos.DadosDocesDTO;
import com.example.projeto_doceria.dtos.DocesDTO;
import com.example.projeto_doceria.models.Doce;

public interface DoceService {

    Long salvar(DocesDTO docesDTO);

    DadosDocesDTO obterDocesPorId(Long id);

    void remover(Long id);

    void editar(Long id, DocesDTO cursoDto);

    void adicionarCurtida(Long id, DocesDTO cursoDto);

    List<DadosDocesDTO> sobterTodos();

}
