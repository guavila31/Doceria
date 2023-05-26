package com.example.projeto_doceria.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocesDTO {

    private Long id;
    private String nome;
    private String ingredientes;
    private Integer curtidas;
    private Long categoriaDoceId;
}
