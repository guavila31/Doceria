package com.example.projeto_doceria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_doceria.dtos.CategoriaDTO;
import com.example.projeto_doceria.dtos.DadosCategoriaDTO;
import com.example.projeto_doceria.models.Categoria;
import com.example.projeto_doceria.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody CategoriaDTO dto) {
        return categoriaService.salvar(dto);
    }

    @GetMapping("{id}")
    public DadosCategoriaDTO getDocePorId(@PathVariable Long id) {
        return categoriaService.obterCategoriaPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@PathVariable Long id) {
        categoriaService.remover(id);
    }

    @PutMapping("{id}")
    public void editCurso(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        categoriaService.editar(id, dto);
    }

    @GetMapping
    public List<DadosCategoriaDTO> getCursos() {
        return categoriaService.sobterTodos();
    }
}
