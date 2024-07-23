package com.jose.julio.apiveiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ConsultaVeiculoDTO {
    private String chave; // Pode ser 'marca' ou 'decada'
    private String descricao;
    private Long quantidade;
}
