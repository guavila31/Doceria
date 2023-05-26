package com.example.projeto_doceria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projeto_doceria.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("select c from Categoria c left join fetch c.doces d where c.id = :id")
    Categoria findCategoriaCursoFetchCursos(@Param("id") Long id);
}
