package com.example.projeto_doceria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_doceria.models.Doce;

public interface DoceRepository extends JpaRepository<Doce, Long> {
    List<Doce> findByNomeLike(String nome);
}
