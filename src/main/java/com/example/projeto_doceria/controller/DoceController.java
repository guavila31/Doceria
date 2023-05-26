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

import com.example.projeto_doceria.dtos.DadosDocesDTO;
import com.example.projeto_doceria.dtos.DocesDTO;
import com.example.projeto_doceria.models.Doce;
import com.example.projeto_doceria.services.DoceService;

@RestController
@RequestMapping("/api/doce")
public class DoceController {
    private DoceService doceService;

    public DoceController(DoceService doceService) {
        this.doceService = doceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long salvar(@RequestBody DocesDTO doceDTO) {
        return doceService.salvar(doceDTO);
    }

    @GetMapping("{id}")
    public DadosDocesDTO getDocePorId(@PathVariable Long id) {
        return doceService.obterDocesPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@PathVariable Long id) {
        doceService.remover(id);
    }

    @PutMapping("{id}")
    public void editCurso(@PathVariable Long id, @RequestBody DocesDTO dto) {
        doceService.editar(id, dto);
    }

    @GetMapping
    public List<DadosDocesDTO> getCursos() {
        return doceService.sobterTodos();
    }
}
